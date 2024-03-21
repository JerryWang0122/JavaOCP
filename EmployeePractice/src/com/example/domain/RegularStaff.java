package com.example.domain;

import java.util.Random;

public interface RegularStaff {
    String[] gifts = {"Car", "iPhone15", "Dyson Vacuum Cleaner", "Lottery", "Frying Pan",
            "Microwave Oven", "Vacation Tickets", "iPad", "Lottery", "Lottery"};
    public static String getLuckDraw() {
        int randomIdx = new Random().nextInt(gifts.length);
        return gifts[randomIdx];
    }

    public default double calcPerMultiplier() {
        return (int)(Math.random() * 5 + 1) * 0.5;
    }

    public double getBonus();
}
