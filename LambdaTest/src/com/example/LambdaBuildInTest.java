package com.example;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaBuildInTest {

    public static void main(String[] args) {
        List<Person> personList = Person.createList();

        // 使用 Lambda Expression 定義以Function 函式介面,傳回稱謂(姓名前加上Ms./Mr.)
        Function<Person, String> nameFormat = (p) ->
                (p.getGender() == Gender.MALE ? "Mr." : "Ms.") + p.getLastName();
        for (Person person : personList) {
            System.out.println(nameFormat.apply(person));
        }
        
        // 使用 Lambda Expression 定義Predicate 函式介面,篩選列印30歲以下的Person資訊
        Predicate<Person> underThirty = p -> p.getAge() <= 30;
        for (Person person : personList) {
            if (underThirty.test(person)) {
                System.out.println(person);
            }
        }
        
        // 使用 Lambda Expression 定義以Consumer 函式介面以FirstName(age)格式來列印Person資訊
        Consumer<Person> myPrint = p -> System.out.printf("%s(%d)%n", p.getFirstName(), p.getAge());
        for (Person person : personList) {
            myPrint.accept(person);
        }

    }
}
