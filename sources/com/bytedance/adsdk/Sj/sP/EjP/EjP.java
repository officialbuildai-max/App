package com.bytedance.adsdk.Sj.sP.EjP;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum EjP implements HiB {
    LEFT_PAREN("("),
    RIGHT_PAREN(")"),
    LEFT_BRACKET("["),
    RIGHT_BRACKET("]"),
    COMMA(",");

    private static final Map<String, EjP> vS;
    private final String Jcg;

    static {
        HashMap hashMap = new HashMap(128);
        vS = hashMap;
        for (EjP ejP : hashMap.values()) {
            vS.put(ejP.Sj(), ejP);
        }
    }

    EjP(String str) {
        this.Jcg = str;
    }

    public static boolean Sj(HiB hiB) {
        return hiB instanceof EjP;
    }

    public String Sj() {
        return this.Jcg;
    }
}
