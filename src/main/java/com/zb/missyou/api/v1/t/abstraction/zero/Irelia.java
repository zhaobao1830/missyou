package com.zb.missyou.api.v1.t.abstraction.zero;

import com.zb.missyou.api.v1.t.abstraction.Hero;

public class Irelia implements Hero {
    @Override
    public void q() {
        System.out.println("Irelia q");
    }

    @Override
    public void w() {
        System.out.println("Irelia w");
    }

    @Override
    public void e() {
        System.out.println("Irelia e");
    }

    @Override
    public void r() {
        System.out.println("Irelia r");
    }
}
