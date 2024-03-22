package ch14;

import java.util.*;

public class CarTest {
    static Set<String> carBrands = new TreeSet<>();
    static List<String> garage = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println("採購車輛...");
        Scanner scanner = new Scanner(System.in);
        String input;
        while (garage.size() < 8) {
            System.out.print("請輸入汽車品牌：");
            input = scanner.nextLine();
            if (carBrands.add(input)) {
                System.out.println("新增品牌：" + input);
            } else {
                System.out.println("現有品牌：" + input);
            }
            garage.add(input);
        }
        printData();
        System.out.println("銷售車輛......");
        while (true) {
            if (garage.isEmpty()) break;
            System.out.print("輸入欲購買品牌(輸入Quit結束)：");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("Quit")) break;
            int index = garage.indexOf(input);
            if (index == -1) {
                System.out.println("未銷售" + input);
            } else {
                System.out.println("請至" + index + "號車庫賞車");
                garage.remove(index);
                if (!garage.contains(input)) carBrands.remove(input);
                System.out.println(input + "已銷售");
            }
        }
        printData();
        scanner.close();
    }

    private static void printData() {
        System.out.println("銷售品牌：" + carBrands);
        System.out.println("現有車輛：" + garage);
    }
}
