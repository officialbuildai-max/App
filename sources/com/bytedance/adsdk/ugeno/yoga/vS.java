package com.bytedance.adsdk.ugeno.yoga;

/* loaded from: classes2.dex */
public enum vS {
    COLUMN(0, "column"),
    COLUMN_REVERSE(1, "column_reverse"),
    ROW(2, "row"),
    ROW_REVERSE(3, "row_reverse");

    private final int HiB;
    private final String vS;

    vS(int i11, String str) {
        this.HiB = i11;
        this.vS = str;
    }

    public static vS Sj(int i11) {
        if (i11 == 0) {
            return COLUMN;
        }
        if (i11 == 1) {
            return COLUMN_REVERSE;
        }
        if (i11 == 2) {
            return ROW;
        }
        if (i11 == 3) {
            return ROW_REVERSE;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i11)));
    }

    public static vS Sj(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1781065991:
                if (str.equals("column_reverse")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1354837162:
                if (str.equals("column")) {
                    c11 = 1;
                    break;
                }
                break;
            case -207799939:
                if (str.equals("row_reverse")) {
                    c11 = 2;
                    break;
                }
                break;
            case 113114:
                if (str.equals("row")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return COLUMN_REVERSE;
            case 1:
                return COLUMN;
            case 2:
                return ROW_REVERSE;
            case 3:
                return ROW;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(str));
        }
    }

    public int Sj() {
        return this.HiB;
    }
}
