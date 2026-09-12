package com.bytedance.adsdk.ugeno.yoga;

/* loaded from: classes2.dex */
public enum Zq {
    STATIC(0, "static"),
    RELATIVE(1, "relative"),
    ABSOLUTE(2, "absolute");

    private final int EjP;
    private final String HiB;

    Zq(int i11, String str) {
        this.EjP = i11;
        this.HiB = str;
    }

    public static Zq Sj(int i11) {
        if (i11 == 0) {
            return STATIC;
        }
        if (i11 == 1) {
            return RELATIVE;
        }
        if (i11 == 2) {
            return ABSOLUTE;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i11)));
    }

    public static Zq Sj(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -892481938:
                if (str.equals("static")) {
                    c11 = 0;
                    break;
                }
                break;
            case -554435892:
                if (str.equals("relative")) {
                    c11 = 1;
                    break;
                }
                break;
            case 1728122231:
                if (str.equals("absolute")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return STATIC;
            case 1:
                return RELATIVE;
            case 2:
                return ABSOLUTE;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(str));
        }
    }

    public int Sj() {
        return this.EjP;
    }
}
