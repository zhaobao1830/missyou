package com.zb.missyou.api.v1.t.factory;

import com.zb.missyou.api.v1.t.factory.zero.Diana;
import com.zb.missyou.api.v1.t.factory.zero.Irelia;

public class HeroFactory {

    public static Hero getHero(String name) {
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
        return hero;
    }
}
