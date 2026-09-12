package com.bytedance.adsdk.ugeno.Sj;

/* loaded from: classes2.dex */
public enum EjP {
    TRANSLATE("translate", "translation", "point"),
    TRANSLATE_X("translateX", "translationX", "float"),
    TRANSLATE_Y("translateY", "translationY", "float"),
    ROTATE_X("rotateX", "rotationX", "float"),
    ROTATE_Y("rotateY", "rotationY", "float"),
    ROTATE_Z("rotateZ", "rotation", "float"),
    SCALE("scale", "scale", "point"),
    SCALE_X("scaleX", "scaleX", "float"),
    SCALE_Y("scaleY", "scaleY", "float"),
    ALPHA("opacity", "alpha", "float"),
    BACKGROUND_COLOR("backgroundColor", "backgroundColor", "int"),
    BORDER_RADIUS("borderRadius", "borderRadius", "float"),
    RIPPLE("ripple", "ripple", "float"),
    SHINE("shine", "shine", "float");

    private final String Zq;
    private final String dNu;
    private final String uvD;

    EjP(String str, String str2, String str3) {
        this.Zq = str;
        this.uvD = str2;
        this.dNu = str3;
    }

    public static EjP Sj(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1721943862:
                if (str.equals("translateX")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1721943861:
                if (str.equals("translateY")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    c11 = 2;
                    break;
                }
                break;
            case -930826704:
                if (str.equals("ripple")) {
                    c11 = 3;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c11 = 4;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c11 = 5;
                    break;
                }
                break;
            case 109250890:
                if (str.equals("scale")) {
                    c11 = 6;
                    break;
                }
                break;
            case 1052832078:
                if (str.equals("translate")) {
                    c11 = 7;
                    break;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    c11 = '\b';
                    break;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    c11 = '\t';
                    break;
                }
                break;
            case 1384173149:
                if (str.equals("rotateX")) {
                    c11 = '\n';
                    break;
                }
                break;
            case 1384173150:
                if (str.equals("rotateY")) {
                    c11 = 11;
                    break;
                }
                break;
            case 1384173151:
                if (str.equals("rotateZ")) {
                    c11 = '\f';
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return TRANSLATE_X;
            case 1:
                return TRANSLATE_Y;
            case 2:
                return ALPHA;
            case 3:
                return RIPPLE;
            case 4:
                return SCALE_X;
            case 5:
                return SCALE_Y;
            case 6:
                return SCALE;
            case 7:
                return TRANSLATE;
            case '\b':
                return BACKGROUND_COLOR;
            case '\t':
                return BORDER_RADIUS;
            case '\n':
                return ROTATE_X;
            case 11:
                return ROTATE_Y;
            case '\f':
                return ROTATE_Z;
            default:
                return TRANSLATE_X;
        }
    }

    public String Sj() {
        return this.Zq;
    }

    public String TKC() {
        return this.dNu;
    }

    public String sP() {
        return this.uvD;
    }
}
