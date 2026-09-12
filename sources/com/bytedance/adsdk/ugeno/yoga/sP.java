package com.bytedance.adsdk.ugeno.yoga;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: classes2.dex */
public enum sP {
    AUTO(0, "auto"),
    FLEX_START(1, "flex_start"),
    CENTER(2, TtmlNode.CENTER),
    FLEX_END(3, "flex_end"),
    STRETCH(4, "stretch"),
    BASELINE(5, "baseline"),
    SPACE_BETWEEN(6, "space_between"),
    SPACE_AROUND(7, "space_around");

    private final String TEQ;
    private final int uA;

    sP(int i11, String str) {
        this.uA = i11;
        this.TEQ = str;
    }

    public static sP Sj(int i11) {
        switch (i11) {
            case 0:
                return AUTO;
            case 1:
                return FLEX_START;
            case 2:
                return CENTER;
            case 3:
                return FLEX_END;
            case 4:
                return STRETCH;
            case 5:
                return BASELINE;
            case 6:
                return SPACE_BETWEEN;
            case 7:
                return SPACE_AROUND;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i11)));
        }
    }

    public static sP Sj(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1881872635:
                if (str.equals("stretch")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1720785339:
                if (str.equals("baseline")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1364013995:
                if (str.equals(TtmlNode.CENTER)) {
                    c11 = 2;
                    break;
                }
                break;
            case -932331738:
                if (str.equals("space_around")) {
                    c11 = 3;
                    break;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    c11 = 4;
                    break;
                }
                break;
            case 1384876188:
                if (str.equals("flex_start")) {
                    c11 = 5;
                    break;
                }
                break;
            case 1682480591:
                if (str.equals("space_between")) {
                    c11 = 6;
                    break;
                }
                break;
            case 1744442261:
                if (str.equals("flex_end")) {
                    c11 = 7;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return STRETCH;
            case 1:
                return BASELINE;
            case 2:
                return CENTER;
            case 3:
                return SPACE_AROUND;
            case 4:
                return AUTO;
            case 5:
                return FLEX_START;
            case 6:
                return SPACE_BETWEEN;
            case 7:
                return FLEX_END;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(str));
        }
    }

    public int Sj() {
        return this.uA;
    }
}
