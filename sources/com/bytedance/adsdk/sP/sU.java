package com.bytedance.adsdk.sP;

import java.util.Map;

/* loaded from: classes2.dex */
public class sU {
    private final Map<String, String> Sj;
    private boolean sP;

    public String Sj(String str) {
        return str;
    }

    public String Sj(String str, String str2) {
        return Sj(str2);
    }

    public final String sP(String str, String str2) {
        if (this.sP && this.Sj.containsKey(str2)) {
            return this.Sj.get(str2);
        }
        String Sj = Sj(str, str2);
        if (this.sP) {
            this.Sj.put(str2, Sj);
        }
        return Sj;
    }
}
