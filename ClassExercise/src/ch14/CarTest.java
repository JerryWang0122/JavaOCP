package ch14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CarTest {
    static Set<String> carBrand = new HashSet<>();
    static ArrayList<String> carProduct = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (carBrand.size() < 3) {
            System.out.print("請輸入汽車品牌：");
            input = scanner.next();
            if (carBrand.add(input)) {
                System.out.println("新增品牌：" + input);
            } else {
                System.out.println("現有品牌：" + input);
            }
            carProduct.add(input);

        }
        System.out.println("銷售品牌：" + carBrand);
        System.out.println("現有車輛：" + carProduct);
        while (true) {
            if (carProduct.isEmpty()) break;
            System.out.print("輸入欲購買品牌：");
            input = scanner.next();
            if (input.equals("Quit")) break;
            int index = carProduct.indexOf(input);
            if (index == -1) {
                System.out.println("未銷售" + input);
            } else {
                System.out.println("請至" + index + "號車庫賞車");
                carProduct.remove(index);
                if (!carProduct.contains(input)) carBrand.remove(input);
                System.out.println(input + "已銷售");
            }
        }
        System.out.println("銷售品牌：" + carBrand);
        System.out.println("現有車輛：" + carProduct);

        scanner.close();
    }
}
