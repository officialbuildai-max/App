package com.bytedance.adsdk.ugeno.yoga;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: classes2.dex */
public enum Jcg {
    FLEX_START(0, "flex_start"),
    CENTER(1, TtmlNode.CENTER),
    FLEX_END(2, "flex_end"),
    SPACE_BETWEEN(3, "space_between"),
    SPACE_AROUND(4, "space_around"),
    SPACE_EVENLY(5, "space_evenly");

    private final String Dq;
    private final int Jcg;

    Jcg(int i11, String str) {
        this.Jcg = i11;
        this.Dq = str;
    }

    public static Jcg Sj(int i11) {
        if (i11 == 0) {
            return FLEX_START;
        }
        if (i11 == 1) {
            return CENTER;
        }
        if (i11 == 2) {
            return FLEX_END;
        }
        if (i11 == 3) {
            return SPACE_BETWEEN;
        }
        if (i11 == 4) {
            return SPACE_AROUND;
        }
        if (i11 == 5) {
            return SPACE_EVENLY;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i11)));
    }

    public static Jcg Sj(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(TtmlNode.CENTER)) {
                    c11 = 0;
                    break;
                }
                break;
            case -932331738:
                if (str.equals("space_around")) {
                    c11 = 1;
                    break;
                }
                break;
            case -814425728:
                if (str.equals("space_evenly")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1384876188:
                if (str.equals("flex_start")) {
                    c11 = 3;
                    break;
                }
                break;
            case 1682480591:
                if (str.equals("space_between")) {
                    c11 = 4;
                    break;
                }
                break;
            case 1744442261:
                if (str.equals("flex_end")) {
                    c11 = 5;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return CENTER;
            case 1:
                return SPACE_AROUND;
            case 2:
                return SPACE_EVENLY;
            case 3:
                return FLEX_START;
            case 4:
                return SPACE_BETWEEN;
            case 5:
                return FLEX_END;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(str));
        }
    }

    public int Sj() {
        return this.Jcg;
    }
}
