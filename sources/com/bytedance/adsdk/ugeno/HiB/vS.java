package com.bytedance.adsdk.ugeno.HiB;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.HiB.HiB;
import com.bytedance.adsdk.ugeno.sP.Sj;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: classes2.dex */
public class vS extends com.bytedance.adsdk.ugeno.sP.Sj<HiB> {
    private int AVc;
    private int RrR;
    private int SP;
    private int dLt;
    private int zwV;

    /* loaded from: classes2.dex */
    public static class Sj extends Sj.C0212Sj {
        public int JcM;
        public float LD;
        public float LqL;
        public int Mts;
        public int WMZ;
        public int Yf;
        public int fF;
        public float ley;
        public int wE;

        public Sj(com.bytedance.adsdk.ugeno.sP.Sj sj2) {
            super(sj2);
            this.wE = 1;
            this.ley = 0.0f;
            this.LqL = 0.0f;
            this.Yf = -1;
            this.LD = -1.0f;
            this.fF = -1;
            this.JcM = -1;
            this.WMZ = 16777215;
            this.Mts = 16777215;
        }

        private float EjP(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return -1.0f;
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private int HiB(String str) {
            boolean z10;
            str.hashCode();
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        z10 = false;
                        break;
                    }
                    z10 = -1;
                    break;
                case -1720785339:
                    if (str.equals("baseline")) {
                        z10 = true;
                        break;
                    }
                    z10 = -1;
                    break;
                case -1364013995:
                    if (str.equals(TtmlNode.CENTER)) {
                        z10 = 2;
                        break;
                    }
                    z10 = -1;
                    break;
                case 1384876188:
                    if (str.equals("flex_start")) {
                        z10 = 3;
                        break;
                    }
                    z10 = -1;
                    break;
                case 1744442261:
                    if (str.equals("flex_end")) {
                        z10 = 4;
                        break;
                    }
                    z10 = -1;
                    break;
                default:
                    z10 = -1;
                    break;
            }
            switch (z10) {
                case false:
                    return 4;
                case true:
                    return 3;
                case true:
                    return 2;
                case true:
                    return 0;
                case true:
                    return 1;
                default:
                    return -1;
            }
        }

        private int Sj(String str) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return 1;
            }
        }

        private float TKC(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return 0.0f;
            }
        }

        private float sP(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return 0.0f;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.sP.Sj.C0212Sj
        public void Sj(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.Sj(context, str, str2);
            str.hashCode();
            char c11 = 65535;
            switch (str.hashCode()) {
                case -1962496832:
                    if (str.equals("flexBasisPercent")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 106006350:
                    if (str.equals("order")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 1031115618:
                    if (str.equals("flexShrink")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 1743739820:
                    if (str.equals("flexGrow")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 1767100401:
                    if (str.equals("alignSelf")) {
                        c11 = 4;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    this.LD = EjP(str2);
                    return;
                case 1:
                    this.wE = Sj(str2);
                    return;
                case 2:
                    this.LqL = TKC(str2);
                    return;
                case 3:
                    this.ley = sP(str2);
                    return;
                case 4:
                    this.Yf = HiB(str2);
                    return;
                default:
                    return;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.sP.Sj.C0212Sj
        /* renamed from: sP, reason: merged with bridge method [inline-methods] */
        public HiB.Sj Sj() {
            HiB.Sj sj2 = new HiB.Sj((int) this.Sj, (int) this.sP);
            ((ViewGroup.MarginLayoutParams) sj2).leftMargin = (int) this.vS;
            ((ViewGroup.MarginLayoutParams) sj2).rightMargin = (int) this.Jcg;
            ((ViewGroup.MarginLayoutParams) sj2).topMargin = (int) this.Dq;
            ((ViewGroup.MarginLayoutParams) sj2).bottomMargin = (int) this.uA;
            sj2.TKC(this.wE);
            sj2.EjP(this.Yf);
            sj2.Sj(this.ley);
            sj2.sP(this.LqL);
            sj2.TKC(this.LD);
            return sj2;
        }

        @Override // com.bytedance.adsdk.ugeno.sP.Sj.C0212Sj
        public String toString() {
            return "LayoutParams{mWidth=" + this.Sj + ", mHeight=" + this.sP + ", mMargin=" + this.HiB + ", mMarginLeft=" + this.vS + ", mMarginRight=" + this.Jcg + ", mMarginTop=" + this.Dq + ", mMarginBottom=" + this.uA + ", mParams=" + this.kF + ", mOrder=" + this.wE + ", mFlexGrow=" + this.ley + ", mFlexShrink=" + this.LqL + ", mAlignSelf=" + this.Yf + ", mFlexBasisPercent=" + this.LD + ", mMinWidth=" + this.fF + ", mMinHeight=" + this.JcM + ", mMaxWidth=" + this.WMZ + ", mMaxHeight=" + this.Mts + "} " + super.toString();
        }
    }

    public vS(Context context) {
        super(context);
    }

    private int Dq(String str) {
        str.hashCode();
        return !str.equals("wrap") ? 0 : 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int TEQ(String str) {
        char c11;
        switch (str.hashCode()) {
            case -1881872635:
                if (str.equals("stretch")) {
                    c11 = 4;
                    break;
                }
                c11 = 65535;
                break;
            case -1720785339:
                if (str.equals("baseline")) {
                    c11 = 3;
                    break;
                }
                c11 = 65535;
                break;
            case -1364013995:
                if (str.equals(TtmlNode.CENTER)) {
                    c11 = 2;
                    break;
                }
                c11 = 65535;
                break;
            case 1384876188:
                if (str.equals("flex_start")) {
                    c11 = 0;
                    break;
                }
                c11 = 65535;
                break;
            case 1744442261:
                if (str.equals("flex_end")) {
                    c11 = 1;
                    break;
                }
                c11 = 65535;
                break;
            default:
                c11 = 65535;
                break;
        }
        if (c11 == 0) {
            return 0;
        }
        if (c11 == 1) {
            return 1;
        }
        if (c11 != 2) {
            return c11 != 3 ? 4 : 3;
        }
        return 2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int Ym(String str) {
        char c11;
        switch (str.hashCode()) {
            case -1881872635:
                if (str.equals("stretch")) {
                    c11 = 5;
                    break;
                }
                c11 = 65535;
                break;
            case -1364013995:
                if (str.equals(TtmlNode.CENTER)) {
                    c11 = 2;
                    break;
                }
                c11 = 65535;
                break;
            case -932331738:
                if (str.equals("space_around")) {
                    c11 = 3;
                    break;
                }
                c11 = 65535;
                break;
            case 1384876188:
                if (str.equals("flex_start")) {
                    c11 = 0;
                    break;
                }
                c11 = 65535;
                break;
            case 1682480591:
                if (str.equals("space_between")) {
                    c11 = 4;
                    break;
                }
                c11 = 65535;
                break;
            case 1744442261:
                if (str.equals("flex_end")) {
                    c11 = 1;
                    break;
                }
                c11 = 65535;
                break;
            default:
                c11 = 65535;
                break;
        }
        if (c11 == 0) {
            return 0;
        }
        if (c11 == 1) {
            return 1;
        }
        if (c11 == 2) {
            return 2;
        }
        if (c11 != 3) {
            return c11 != 4 ? 5 : 3;
        }
        return 4;
    }

    private int uA(String str) {
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
            case 1682480591:
                if (str.equals("space_between")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1744442261:
                if (str.equals("flex_end")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 2;
            case 1:
                return 4;
            case 2:
                return 3;
            case 3:
                return 1;
            default:
                return 0;
        }
    }

    int Jcg(String str) {
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
        }
        switch (c11) {
            case 0:
                return 3;
            case 1:
                return 2;
            case 2:
                return 1;
            default:
                return 0;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    public void Sj(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.Sj(str, str2);
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1063257157:
                if (str.equals("alignItems")) {
                    c11 = 0;
                    break;
                }
                break;
            case -975171706:
                if (str.equals("flexDirection")) {
                    c11 = 1;
                    break;
                }
                break;
            case -752601676:
                if (str.equals("alignContent")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1744216035:
                if (str.equals("flexWrap")) {
                    c11 = 3;
                    break;
                }
                break;
            case 1860657097:
                if (str.equals("justifyContent")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                this.dLt = TEQ(str2);
                return;
            case 1:
                this.AVc = Jcg(str2);
                return;
            case 2:
                this.zwV = Ym(str2);
                return;
            case 3:
                this.RrR = Dq(str2);
                return;
            case 4:
                this.SP = uA(str2);
                return;
            default:
                return;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.sP.Sj
    public Sj.C0212Sj TEQ() {
        return new Sj(this);
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    /* renamed from: TKC, reason: merged with bridge method [inline-methods] */
    public HiB Sj() {
        HiB hiB = new HiB(this.sP);
        hiB.Sj(this);
        return hiB;
    }

    @Override // com.bytedance.adsdk.ugeno.sP.Sj, com.bytedance.adsdk.ugeno.sP.TKC
    public void sP() {
        super.sP();
        ((HiB) this.HiB).setFlexDirection(this.AVc);
        ((HiB) this.HiB).setFlexWrap(this.RrR);
        ((HiB) this.HiB).setJustifyContent(this.SP);
        ((HiB) this.HiB).setAlignItems(this.dLt);
        ((HiB) this.HiB).setAlignContent(this.zwV);
    }
}
