package com.val.typeinfo.reflect;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Class<String> c = String.class;

        Method[] methods = c.getDeclaredMethods();
        Pattern pattern = Pattern.compile(".*static.*");
        Matcher matcher;

        for (Method methodItem: methods){
            matcher = pattern.matcher(methodItem.toString());
            if(matcher.find()){
                System.out.println(matcher.group().replaceAll("\\w+\\.", ""));
            }
        }
    }
}
