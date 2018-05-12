package com.krokky.leetcode_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambad {
    public static void main(String[] args) {
        String[] keywordString = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
                "const", "continue", "default", "do", "double", "else", "enum", "extends", "for", "final", "finally",
                "float", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
                "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
                "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while",
                "true", "false", "null"};
        List<String> keyword = new ArrayList<>(Arrays.asList(keywordString));// 将keywordString转化为list对象
//        keyword.add("asd");
        keyword.forEach((word) -> System.out.print(word + " "));
//         调用forEach使用lambad表达式输出keyword等价于
//         for (String word : keyword) {
//         System.out.print(word + " ");
//         }
        keyword.forEach(System.out::print);// 使用双冒号输出，其中::表示调用的方法
    }
}

