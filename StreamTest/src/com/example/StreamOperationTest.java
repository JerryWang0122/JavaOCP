package com.example;

import java.util.*;
import java.util.stream.Collectors;

public class StreamOperationTest {

    public static void main(String[] args) {        
        List<Person> personList = Person.createList();
        // 顯示台北成員的性別稱謂, 以map()方法將性別轉換為先生或小姐
        System.out.println("顯示台北成員的性別稱謂, 以map()方法將性別轉換為先生或小姐");
        personList.stream().filter(p -> p.getCity() == City.Taipei)
                .map(p -> p.getGender().getPrefix())
                .forEach(pf -> System.out.println(pf));
        
        // 問候所有台南的成員(你好, Sean 先生), 以peek()方法在性別稱謂前列印問候語
        System.out.println("\n問候所有台南的成員(你好, Sean 先生), 以peek()方法在性別稱謂前列印問候語");
        personList.stream().filter(p -> p.getCity() == City.Tainan)
                .peek(p -> System.out.printf("你好, %s", p.getName()))
                .map(p -> p.getGender().getPrefix())
                .forEach(pf -> System.out.println(pf));

        // 使用findFirst()方法取得第一個住台南的年齡小於35歲的女性,
        System.out.println("\n使用findFirst()方法取得第一個住台南的年齡小於35歲的女性");
        Optional<Person> result = personList.stream().filter(p -> p.getCity() == City.Tainan)
                                                    .filter(p -> p.getGender() == Gender.FEMALE)
                                                    .filter(p -> p.getAge() <= 35).findFirst();
        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("No person match!");
        }

        // 南部成員個數
        System.out.println("\n南部成員個數");
        long southCount = personList.stream()
                .filter(p -> p.getCity() == City.Kaohsiung || p.getCity() == City.Tainan)
                .count();
        System.out.println(southCount);

        //取得年紀最大的成員
        System.out.println("\n取得年紀最大的成員");
        Person person = personList.stream().max((p1, p2) -> p1.compareAgeTo(p2)).get();
        System.out.println(person);

        //取得年紀最小的成員
        System.out.println("\n取得年紀最小的成員");
        person = personList.stream().min((p1, p2) -> p1.compareAgeTo(p2)).get();
        System.out.println(person);

        //取得成員年紀總和
        System.out.println("\n取得成員年紀總和");
        int sum = personList.stream().mapToInt(p -> p.getAge()).sum();
        System.out.println("成員年紀總和: " + sum);
        //取得成員年紀平均    
        System.out.println("\n取得成員年紀平均  ");
        OptionalDouble average = personList.stream().mapToInt(p -> p.getAge()).average();
        System.out.println("成員年紀平均  : " + average.orElse(-1));
        //女性成員排序
        System.out.println("\n女性成員排序");
        personList.stream().filter(p -> p.getGender() == Gender.FEMALE)
                .sorted()
                .forEach(p -> System.out.println(p));
        
        //男性成員依城市排序
        System.out.println("\n男性成員依城市排序");
        personList.stream().filter(p -> p.getGender() == Gender.MALE)
                        .sorted((p1, p2) -> p1.compareCityTo(p2))
                        .forEach(p -> System.out.println(p));
        
        //所有成員依年紀反向排序
        System.out.println("\n所有成員依年紀反向排序");
        Comparator<Person> comp = Comparator.comparing((Person p) -> p.getAge()).reversed();
        personList.stream().sorted(comp).forEach(p -> System.out.println(p));

        //所有成員依城市->年紀兩階段排序
        System.out.println("\n所有成員依城市->年紀兩階段排序");
//        Comparator<Person> myComparator = Comparator.comparing(p -> p.getCity().ordinal());
//        myComparator = myComparator.thenComparing(p -> p.getAge());

        /* KNOWLEDGE: 泛型只能鎖定串流最後一層的型別，過程的型別無法鎖定，默認成 <T> => Object */
        Comparator<Person> myComparator = Comparator.comparing((Person p) -> p.getCity().ordinal())
                                                    .thenComparing(p -> p.getAge());
        personList.stream().sorted(myComparator).forEach(p -> System.out.println(p));
                
        //以收集器取得將女性成員排序後轉為新序列
        System.out.println("\n以收集器取得將女性成員排序後轉為新序列");
        List<Person> newList = personList.stream().filter(p -> p.getGender() == Gender.FEMALE).sorted().collect(Collectors.toList());
        System.out.println(newList);

        //以收集器取得所有台北成員的電話序列
        System.out.println("\n以收集器取得所有台北成員的電話序列");
        List<String> phoneList = personList.stream().filter(p -> p.getCity() == City.Taipei).map(p -> p.getPhone()).collect(Collectors.toList());
        System.out.println(phoneList);

        //收集器產生計算台南成員平均年紀
        System.out.println("\n收集器產生計算台南成員平均年紀");
        Double avg = personList.stream().filter(p -> p.getCity() == City.Tainan).collect(Collectors.averagingDouble(p -> p.getAge()));
        System.out.println(avg);

        //收集器取得所有台北成員email字串用,隔開 
        System.out.println("\n收集器取得所有台北成員email字串用,隔開");
        String emailStr = personList.stream().filter(p -> p.getCity() == City.Taipei)
                                            .map(p -> p.getEmail())
                                            .collect(Collectors.joining(", "));
        System.out.println(emailStr);

        //成員依城市分組
        System.out.println("\n成員依城市分組");
        Map<City, List<Person>> cityMap = personList.stream().collect(Collectors.groupingBy(p -> p.getCity()));
        cityMap.forEach((k, v) -> System.out.println(k + " : " + v));

        //成員依城市計數
        System.out.println("\n成員依城市計數");
        Map<City, Long> cityCount = personList.stream()
                                        .collect(Collectors.groupingBy(p -> p.getCity(), Collectors.counting()));
        cityCount.forEach((k, v) -> System.out.println(k + " : " + v));

        //成員依年齡分組(30分界)
        System.out.println("\n成員依年齡分組");
        Map<Boolean, List<Person>> ageMap = personList.stream()
                                                    .collect(Collectors.partitioningBy(p -> p.getAge() > 30));
        ageMap.forEach((k, v) -> System.out.println((k ? "大於" : "小於") + "30歲: " + v));

    }           
}
