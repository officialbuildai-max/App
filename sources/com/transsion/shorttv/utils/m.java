package com.transsion.shorttv.utils;

/* loaded from: classes6.dex */
public abstract class m {
    public static final String a(int i11) {
        Object valueOf;
        Object valueOf2;
        int i12 = i11 / 1000;
        int i13 = i12 % 60;
        int i14 = (i12 / 60) % 60;
        int i15 = i12 / 3600;
        if (i15 <= 0) {
            String valueOf3 = i14 > 0 ? Integer.valueOf(i14) : "0";
            if (i13 < 10) {
                valueOf = "0" + i13;
            } else {
                valueOf = Integer.valueOf(i13);
            }
            return valueOf3 + ":" + valueOf;
        }
        if (i13 < 10) {
            valueOf2 = "0" + i13;
        } else {
            valueOf2 = Integer.valueOf(i13);
        }
        return i15 + ":" + i14 + ":" + valueOf2;
    }
}
