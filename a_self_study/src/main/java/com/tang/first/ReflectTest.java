package com.tang.first;

import java.lang.reflect.Field;

/**
 * @author muxiaoling
 * @date 2022/11/11 10:13
 */
public class ReflectTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String st = "tangjinghao";
        Class<? extends String> clazz = st.getClass();
        Field field = clazz.getDeclaredField("value");
        field.setAccessible(true);
        char[] value = (char[]) field.get(st);

        value[0] = 'T';
        System.out.println(st);
    }
}
