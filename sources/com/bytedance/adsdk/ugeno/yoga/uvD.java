package com.bytedance.adsdk.ugeno.yoga;

/* loaded from: classes2.dex */
public enum uvD {
    NO_WRAP(0, "nowrap"),
    WRAP(1, "wrap"),
    WRAP_REVERSE(2, "wrap_reverse");

    private final int EjP;
    private final String HiB;

    uvD(int i11, String str) {
        this.EjP = i11;
        this.HiB = str;
    }

    public static uvD Sj(int i11) {
        if (i11 == 0) {
            return NO_WRAP;
        }
        if (i11 == 1) {
            return WRAP;
        }
        if (i11 == 2) {
            return WRAP_REVERSE;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i11)));
    }

    public static uvD Sj(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1039592053:
                if (str.equals("nowrap")) {
                    c11 = 0;
                    break;
                }
                break;
            case 3657802:
                if (str.equals("wrap")) {
                    c11 = 1;
                    break;
                }
                break;
            case 491642861:
                if (str.equals("wrap_reverse")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return NO_WRAP;
            case 1:
                return WRAP;
            case 2:
                return WRAP_REVERSE;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(str));
        }
    }

    public int Sj() {
        return this.EjP;
    }
}
