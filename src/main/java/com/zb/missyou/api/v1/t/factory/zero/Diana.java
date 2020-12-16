package com.zb.missyou.api.v1.t.factory.zero;

import com.zb.missyou.api.v1.t.factory.Hero;

public class Diana implements Hero {
    @Override
    public void q() {
        System.out.println("Diana q");
    }

    @Override
    public void w() {
        System.out.println("Diana w");
    }

    @Override
    public void e() {
        System.out.println("Diana e");
    }

    @Override
    public void r() {
        System.out.println("Diana r");
    }
}
