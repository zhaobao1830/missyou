package com.zb.missyou.api.v1.t;

import com.zb.missyou.api.v1.t.abstraction.Hero;
import com.zb.missyou.api.v1.t.abstraction.zero.Diana;
import com.zb.missyou.api.v1.t.abstraction.zero.Irelia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name = Main.getPlayerInput();
        Hero hero;
        switch (name) {
            case "Diana":
                hero = new Diana();
                break;
            case "Irelia":
                hero = new Irelia();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + name);
        }
        hero.r();
    }

    private static String getPlayerInput() {
        System.out.println("Enter a Hero name");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
