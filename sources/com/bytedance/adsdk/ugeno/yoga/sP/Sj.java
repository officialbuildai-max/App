package com.bytedance.adsdk.ugeno.yoga.sP;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.bytedance.adsdk.ugeno.Jcg.TKC;
import com.bytedance.adsdk.ugeno.Sj;
import com.bytedance.adsdk.ugeno.sP.Sj;
import com.bytedance.adsdk.ugeno.yoga.Dq;
import com.bytedance.adsdk.ugeno.yoga.HiB;
import com.bytedance.adsdk.ugeno.yoga.Jcg;
import com.bytedance.adsdk.ugeno.yoga.Zq;
import com.bytedance.adsdk.ugeno.yoga.aa;
import com.bytedance.adsdk.ugeno.yoga.sP;
import com.bytedance.adsdk.ugeno.yoga.uvD;
import com.bytedance.adsdk.ugeno.yoga.vS;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: classes2.dex */
public class Sj extends com.bytedance.adsdk.ugeno.sP.Sj<Dq> {
    private vS AVc;
    private uvD RrR;
    private Jcg SP;
    private aa Xqg;
    private sP dLt;
    private sP zwV;

    /* renamed from: com.bytedance.adsdk.ugeno.yoga.sP.Sj$Sj, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0217Sj extends Sj.C0212Sj {
        private boolean Ei;
        public int FPG;
        private boolean Fm;
        private boolean HpB;
        public int JcM;
        public float LD;
        public float LqL;
        public int Mts;
        public int WMZ;
        public float Wjd;
        public int Yf;
        public int fF;

        /* renamed from: jb, reason: collision with root package name */
        private boolean f20933jb;
        public float ley;
        public int wE;
        private boolean xD;
        private boolean xhi;

        public C0217Sj(com.bytedance.adsdk.ugeno.sP.Sj sj2) {
            super(sj2);
            this.wE = 1;
            this.ley = 0.0f;
            this.LqL = 1.0f;
            this.Yf = sP.AUTO.Sj();
            this.LD = -1.0f;
            this.fF = Zq.RELATIVE.Sj();
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
                case -1783760955:
                    if (str.equals("flexBasis")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1383228885:
                    if (str.equals(IntegrationConstants.TAB_BAR_POSITION_DEFAULT)) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 115029:
                    if (str.equals(IntegrationConstants.TAB_BAR_POSITION_TOP)) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 3317767:
                    if (str.equals(TtmlNode.LEFT)) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 106006350:
                    if (str.equals("order")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 108285963:
                    if (str.equals("ratio")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 108511772:
                    if (str.equals(TtmlNode.RIGHT)) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 747804969:
                    if (str.equals(RequestParameters.POSITION)) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 1031115618:
                    if (str.equals("flexShrink")) {
                        c11 = '\b';
                        break;
                    }
                    break;
                case 1743739820:
                    if (str.equals("flexGrow")) {
                        c11 = '\t';
                        break;
                    }
                    break;
                case 1767100401:
                    if (str.equals("alignSelf")) {
                        c11 = '\n';
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    this.xD = true;
                    this.LD = TKC.Sj(str2, -1.0f);
                    return;
                case 1:
                    this.f20933jb = true;
                    this.WMZ = (int) com.bytedance.adsdk.ugeno.Jcg.Dq.Sj(context, TKC.Sj(str2, 0));
                    return;
                case 2:
                    this.Fm = true;
                    this.JcM = (int) com.bytedance.adsdk.ugeno.Jcg.Dq.Sj(context, TKC.Sj(str2, 0));
                    return;
                case 3:
                    this.Ei = true;
                    this.Mts = (int) com.bytedance.adsdk.ugeno.Jcg.Dq.Sj(context, TKC.Sj(str2, 0));
                    return;
                case 4:
                    this.wE = TKC.Sj(str2, 1);
                    return;
                case 5:
                    this.xhi = true;
                    this.Wjd = TKC.Sj(str2, 0.0f);
                    return;
                case 6:
                    this.HpB = true;
                    this.FPG = (int) com.bytedance.adsdk.ugeno.Jcg.Dq.Sj(context, TKC.Sj(str2, 0));
                    return;
                case 7:
                    this.fF = Zq.Sj(str2).Sj();
                    return;
                case '\b':
                    this.LqL = TKC.Sj(str2, 1.0f);
                    return;
                case '\t':
                    this.ley = TKC.Sj(str2, 0.0f);
                    return;
                case '\n':
                    this.Yf = sP.Sj(str2).Sj();
                    return;
                default:
                    return;
            }
        }

        public boolean TKC() {
            float f11 = this.Sj;
            if (f11 == -1.0f && this.sP == -1.0f) {
                return false;
            }
            return f11 == -2.0f || this.sP == -2.0f;
        }

        @Override // com.bytedance.adsdk.ugeno.sP.Sj.C0212Sj
        /* renamed from: sP, reason: merged with bridge method [inline-methods] */
        public Dq.Sj Sj() {
            Dq.Sj sj2 = new Dq.Sj((int) this.Sj, (int) this.sP);
            sj2.aa((int) (this.sU ? this.vS : this.HiB));
            sj2.sef((int) (this.f20908dx ? this.Jcg : this.HiB));
            sj2.Ym((int) (this.zR ? this.Dq : this.HiB));
            sj2.Fmk((int) (this.f20909ib ? this.uA : this.HiB));
            sj2.Sj(this.wE);
            sj2.HiB(this.Yf);
            sj2.sP(this.ley);
            sj2.TKC(this.LqL);
            sj2.uvD(this.TKC);
            sj2.dNu(this.EjP);
            if (this.xD) {
                sj2.EjP(this.LD);
            }
            sj2.vS(this.fF);
            if (this.Fm) {
                sj2.Jcg(this.JcM);
            }
            if (this.f20933jb) {
                sj2.uA(this.WMZ);
            }
            if (this.Ei) {
                sj2.Dq(this.Mts);
            }
            if (this.HpB) {
                sj2.TEQ(this.FPG);
            }
            if (this.xhi && TKC()) {
                float f11 = this.Wjd;
                if (f11 > 0.0f) {
                    sj2.Zq(f11);
                }
            }
            return sj2;
        }

        @Override // com.bytedance.adsdk.ugeno.sP.Sj.C0212Sj
        public String toString() {
            return "LayoutParams{mOrder=" + this.wE + ", mFlexGrow=" + this.ley + ", mFlexShrink=" + this.LqL + ", mAlignSelf=" + this.Yf + ", mFlexBasis=" + this.LD + ", mPosition=" + this.fF + ", mTop=" + this.JcM + ", mBottom=" + this.WMZ + ", mLeft=" + this.Mts + ", mRight=" + this.FPG + '}';
        }
    }

    public Sj(Context context) {
        super(context);
        this.AVc = vS.ROW;
        this.RrR = uvD.NO_WRAP;
        this.SP = Jcg.FLEX_START;
        sP sPVar = sP.STRETCH;
        this.dLt = sPVar;
        this.zwV = sPVar;
    }

    private void Sj(final ImageView imageView) {
        this.HiB.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.yoga.sP.Sj.2
            @Override // java.lang.Runnable
            public void run() {
                aa Sj;
                if (((com.bytedance.adsdk.ugeno.sP.TKC) Sj.this).HiB == null || (Sj = ((Dq) ((com.bytedance.adsdk.ugeno.sP.TKC) Sj.this).HiB).Sj(imageView)) == null) {
                    return;
                }
                Sj.EjP(((com.bytedance.adsdk.ugeno.sP.TKC) Sj.this).HiB.getWidth());
                Sj.vS(((com.bytedance.adsdk.ugeno.sP.TKC) Sj.this).HiB.getHeight());
                ((com.bytedance.adsdk.ugeno.sP.TKC) Sj.this).HiB.requestLayout();
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.sP.Sj
    /* renamed from: EjP, reason: merged with bridge method [inline-methods] */
    public C0217Sj TEQ() {
        return new C0217Sj(this);
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    protected void Fmk() {
        if (this.fF) {
            this.Xqg.sP(HiB.ALL, this.wE);
        }
        if (this.JcM) {
            this.Xqg.sP(HiB.LEFT, this.ley);
        }
        if (this.WMZ) {
            this.Xqg.sP(HiB.RIGHT, this.LqL);
        }
        if (this.Mts) {
            this.Xqg.sP(HiB.TOP, this.Yf);
        }
        if (this.FPG) {
            this.Xqg.sP(HiB.BOTTOM, this.LD);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    protected void Sj(Drawable drawable) {
        ImageView.ScaleType scaleType;
        ImageView imageView = new ImageView(this.sP);
        imageView.setImageDrawable(drawable);
        if (!this.HpB || (scaleType = this.Fm) == ImageView.ScaleType.FIT_XY) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView.setScaleType(scaleType);
        }
        Dq.Sj sj2 = new Dq.Sj(-1, -1);
        sj2.vS(Zq.ABSOLUTE.Sj());
        T t11 = this.HiB;
        if (t11 instanceof Dq) {
            ((Dq) t11).addView(imageView, 0, sj2);
            Sj(imageView);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.sP.Sj
    public void Sj(com.bytedance.adsdk.ugeno.sP.TKC tkc) {
        super.Sj(tkc);
    }

    @Override // com.bytedance.adsdk.ugeno.sP.Sj
    public void Sj(com.bytedance.adsdk.ugeno.sP.TKC tkc, ViewGroup.LayoutParams layoutParams) {
        if (tkc == null) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.sP.Sj) this).Sj.add(tkc);
        View Ym = tkc.Ym();
        if (Ym != null) {
            ((Dq) this.HiB).addView(Ym, layoutParams);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    public void Sj(String str, String str2) {
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
                this.dLt = sP.Sj(str2);
                return;
            case 1:
                this.AVc = vS.Sj(str2);
                return;
            case 2:
                this.zwV = sP.Sj(str2);
                return;
            case 3:
                this.RrR = uvD.Sj(str2);
                return;
            case 4:
                this.SP = Jcg.Sj(str2);
                return;
            default:
                return;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    /* renamed from: TKC, reason: merged with bridge method [inline-methods] */
    public Dq Sj() {
        Dq dq2 = new Dq(this.sP);
        dq2.Sj(this);
        this.Xqg = dq2.getYogaNode();
        return dq2;
    }

    @Override // com.bytedance.adsdk.ugeno.sP.Sj, com.bytedance.adsdk.ugeno.sP.TKC
    public void sP() {
        super.sP();
        this.Xqg.Sj(this.AVc);
        this.Xqg.Sj(this.RrR);
        this.Xqg.Sj(this.SP);
        this.Xqg.Sj(this.dLt);
        this.Xqg.TKC(this.zwV);
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    protected void wE() {
        ImageView.ScaleType scaleType;
        if (this.Ei) {
            com.bytedance.adsdk.ugeno.HiB.Sj().sP().Sj(this.uA, this.xD, new Sj.InterfaceC0208Sj() { // from class: com.bytedance.adsdk.ugeno.yoga.sP.Sj.1
                @Override // com.bytedance.adsdk.ugeno.Sj.InterfaceC0208Sj
                public void Sj(Bitmap bitmap) {
                    final Bitmap Sj;
                    if (bitmap == null || (Sj = com.bytedance.adsdk.ugeno.Jcg.Dq.Sj(((com.bytedance.adsdk.ugeno.sP.TKC) Sj.this).sP, bitmap, (int) ((com.bytedance.adsdk.ugeno.sP.TKC) Sj.this).f20915jb)) == null) {
                        return;
                    }
                    com.bytedance.adsdk.ugeno.Jcg.Dq.Sj(new Runnable() { // from class: com.bytedance.adsdk.ugeno.yoga.sP.Sj.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Sj.this.Sj(new BitmapDrawable(Sj));
                        }
                    });
                }
            });
            return;
        }
        ImageView imageView = new ImageView(this.sP);
        com.bytedance.adsdk.ugeno.HiB.Sj().sP().Sj(this.uA, this.xD, imageView, this.HiB.getWidth(), this.HiB.getHeight());
        if (!this.HpB || (scaleType = this.Fm) == ImageView.ScaleType.FIT_XY) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView.setScaleType(scaleType);
        }
        Dq.Sj sj2 = new Dq.Sj(-1, -1);
        sj2.vS(Zq.ABSOLUTE.Sj());
        T t11 = this.HiB;
        if (t11 instanceof Dq) {
            ((Dq) t11).addView(imageView, 0, sj2);
            Sj(imageView);
        }
    }
}
