package com.example;

public class LambdaTest {

    public static void main(String[] args) {
        String[] strList01 = {"tomorrow", "toto", "to", "timbukto", "the", "hello", "heat"};

        AnalyzerTool stringTool = new AnalyzerTool();
        String searchStr = "to";

        System.out.println("Searching for: " + searchStr);

        System.out.println("==Contains==");
        stringTool.showResult(strList01, searchStr, (tar, ser) -> tar.contains(ser));

        System.out.println("==Starts With==");
        stringTool.showResult(strList01, searchStr, (tar, ser) -> tar.startsWith(ser));

        System.out.println("==Equals==");
        stringTool.showResult(strList01, searchStr, (tar, ser) -> tar.equals(ser));

        System.out.println("==Ends With==");
        stringTool.showResult(strList01, searchStr, (tar, ser) -> tar.endsWith(ser));

        System.out.println("==Less than 5==");
        stringTool.showResult(strList01, searchStr, (tar, ser) -> tar.contains(ser) && tar.length() < 5);

        System.out.println("==Greater than 5==");
        stringTool.showResult(strList01, searchStr, (tar, ser) -> tar.contains(ser) && tar.length() > 5);
    }
    
}
