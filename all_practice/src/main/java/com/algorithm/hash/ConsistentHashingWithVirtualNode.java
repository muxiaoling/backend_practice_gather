package com.algorithm.hash;

import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * 带虚拟节点的一致性hash算法
 */
public class ConsistentHashingWithVirtualNode {
    //服务器列表
    private static String[] servers = {
            "192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111", "192.168.0.3:111", "192.168.0.4:111"
    };
    //真实节点列表
    private static List<String> realNode = new LinkedList<>();
    //虚拟节点  key:hash值  value:虚拟节点的名称
    private static SortedMap<Integer, String> virtualNodes = new TreeMap<>();

    //虚拟节点的数目
    private static final int VIRTUAL_NODES = 5;
    
    static {
        //把原始服务器添加到真实列表中
        for (int i = 0; i < servers.length; i++) {
            realNode.add(servers[i]);
        }
        //添加虚拟节点
        for (String str : realNode) {
            for (int i = 0; i < VIRTUAL_NODES; i++) {
                String virtualNodeName = str + "&&VN" + String.valueOf(i);
                int hash = getHash(virtualNodeName);
                System.out.println("虚拟节点[" + virtualNodeName + "]被添加 " + "hash值为" + hash);
                virtualNodes.put(hash, virtualNodeName);
            }
            System.out.println();
        }
    }

    //使用FNV1_32_HASH算法计算服务器的Hash值
    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int)2166136261L;

        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }

    //得到hash环中的下一个节点
    private static String getServer(String key) {
        int hash = getHash(key);
        //得到大于该hash值的所有Map
        SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);

        String virtualNode = null;
        if (subMap.isEmpty()) {
            //如果没有比该key的hash值大的，则从第一个node开始
            int virtualKey = virtualNodes.firstKey();
            virtualNode = virtualNodes.get(virtualKey);
        } else {
            //顺时针最近的那个节点
            int virtualKey = subMap.firstKey();
            virtualNode = subMap.get(virtualKey);
        }
        //截取主机名，端口号部分即可
        if (StringUtils.isNotBlank(virtualNode)) {
            return virtualNode.substring(0, virtualNode.indexOf("&&"));
        }
        return null;
    }

    public static void main(String[] args) {
        String[] keys = {"北京访问1", "上海访问2", "广州访问3", "深圳访问4"};
        for (int i = 0; i < keys.length; i++) {
            System.out.println("[" + keys[i] + "]的hash值为" +
                    getHash(keys[i]) + "  被路由到[" + getServer(keys[i]) + "]");
        }
    }
}
