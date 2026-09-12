package com.bytedance.adsdk.ugeno.sP;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.Jcg.Dq;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class Sj<E extends ViewGroup> extends TKC {
    protected List<TKC<View>> Sj;

    /* renamed from: com.bytedance.adsdk.ugeno.sP.Sj$Sj, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0212Sj {
        protected float Dq;
        protected float Fmk;
        protected float HiB;
        protected float Jcg;
        protected boolean RiZ;
        protected float TEQ;
        protected boolean TzV;
        protected float Ym;
        protected boolean Zq;

        /* renamed from: aa, reason: collision with root package name */
        protected float f20907aa;
        protected boolean dNu;

        /* renamed from: dx, reason: collision with root package name */
        protected boolean f20908dx;

        /* renamed from: ib, reason: collision with root package name */
        protected boolean f20909ib;
        protected ViewGroup.LayoutParams kF;
        protected boolean sU;
        protected float sef;
        protected float uA;
        protected Sj uP;
        protected boolean uvD;
        protected float vS;
        protected boolean zR;
        protected float Sj = -2.0f;
        protected float sP = -2.0f;
        protected float TKC = 0.0f;
        protected float EjP = 0.0f;

        public C0212Sj(Sj sj2) {
            this.uP = sj2;
        }

        public ViewGroup.LayoutParams Sj() {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams((int) this.Sj, (int) this.sP);
            marginLayoutParams.leftMargin = (int) (this.sU ? this.vS : this.HiB);
            marginLayoutParams.rightMargin = (int) (this.f20908dx ? this.Jcg : this.HiB);
            marginLayoutParams.topMargin = (int) (this.zR ? this.Dq : this.HiB);
            marginLayoutParams.bottomMargin = (int) (this.f20909ib ? this.uA : this.HiB);
            return marginLayoutParams;
        }

        public void Sj(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            str.hashCode();
            char c11 = 65535;
            switch (str.hashCode()) {
                case -1501175880:
                    if (str.equals("paddingLeft")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1375815020:
                    if (str.equals("minWidth")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -1221029593:
                    if (str.equals("height")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -1081309778:
                    if (str.equals("margin")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case -1044792121:
                    if (str.equals("marginTop")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case -806339567:
                    if (str.equals("padding")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case -289173127:
                    if (str.equals("marginBottom")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case -133587431:
                    if (str.equals("minHeight")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 90130308:
                    if (str.equals("paddingTop")) {
                        c11 = '\b';
                        break;
                    }
                    break;
                case 113126854:
                    if (str.equals("width")) {
                        c11 = '\t';
                        break;
                    }
                    break;
                case 202355100:
                    if (str.equals("paddingBottom")) {
                        c11 = '\n';
                        break;
                    }
                    break;
                case 713848971:
                    if (str.equals("paddingRight")) {
                        c11 = 11;
                        break;
                    }
                    break;
                case 975087886:
                    if (str.equals("marginRight")) {
                        c11 = '\f';
                        break;
                    }
                    break;
                case 1970934485:
                    if (str.equals("marginLeft")) {
                        c11 = '\r';
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    this.Ym = Dq.Sj(context, str2);
                    this.uvD = true;
                    return;
                case 1:
                    this.TKC = Dq.Sj(context, str2);
                    return;
                case 2:
                    if (!TextUtils.equals(str2, "match_parent")) {
                        if (TextUtils.equals(str2, "wrap_content")) {
                            this.sP = -2.0f;
                            return;
                        } else {
                            this.sP = Dq.Sj(context, str2);
                            return;
                        }
                    }
                    Sj sj2 = this.uP;
                    if (sj2 == null || !sj2.LD() || this.uP.FPG() != -2 || this.uP.HpB()) {
                        this.sP = -1.0f;
                        return;
                    } else {
                        this.sP = -2.0f;
                        return;
                    }
                case 3:
                    this.HiB = Dq.Sj(context, str2);
                    return;
                case 4:
                    this.Dq = Dq.Sj(context, str2);
                    this.zR = true;
                    return;
                case 5:
                    this.TEQ = Dq.Sj(context, str2);
                    this.Zq = true;
                    return;
                case 6:
                    this.uA = Dq.Sj(context, str2);
                    this.f20909ib = true;
                    return;
                case 7:
                    this.EjP = Dq.Sj(context, str2);
                    return;
                case '\b':
                    this.f20907aa = Dq.Sj(context, str2);
                    this.TzV = true;
                    return;
                case '\t':
                    if (!TextUtils.equals(str2, "match_parent")) {
                        if (TextUtils.equals(str2, "wrap_content")) {
                            this.Sj = -2.0f;
                            return;
                        } else {
                            this.Sj = Dq.Sj(context, str2);
                            return;
                        }
                    }
                    Sj sj3 = this.uP;
                    if (sj3 == null || !sj3.LD() || this.uP.Mts() != -2 || this.uP.HpB()) {
                        this.Sj = -1.0f;
                        return;
                    } else {
                        this.Sj = -2.0f;
                        return;
                    }
                case '\n':
                    this.sef = Dq.Sj(context, str2);
                    this.RiZ = true;
                    return;
                case 11:
                    this.Fmk = Dq.Sj(context, str2);
                    this.dNu = true;
                    return;
                case '\f':
                    this.Jcg = Dq.Sj(context, str2);
                    this.f20908dx = true;
                    return;
                case '\r':
                    this.vS = Dq.Sj(context, str2);
                    this.sU = true;
                    return;
                default:
                    return;
            }
        }

        public String toString() {
            return "LayoutParams{mWidth=" + this.Sj + ", mHeight=" + this.sP + ", mMargin=" + this.HiB + ", mMarginLeft=" + this.vS + ", mMarginRight=" + this.Jcg + ", mMarginTop=" + this.Dq + ", mMarginBottom=" + this.uA + ", mParams=" + this.kF + '}';
        }
    }

    public Sj(Context context) {
        this(context, null);
    }

    public Sj(Context context, Sj sj2) {
        super(context, sj2);
        this.Sj = new ArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    public TKC Sj(String str) {
        TKC<View> TKC;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.Ym)) {
            return this;
        }
        for (TKC<View> tkc : this.Sj) {
            if (tkc != null && (TKC = tkc.TKC(str)) != null) {
                return TKC;
            }
        }
        return null;
    }

    public void Sj(TKC tkc) {
        if (tkc == null) {
            return;
        }
        this.Sj.add(tkc);
        View Ym = tkc.Ym();
        if (Ym != null) {
            ((ViewGroup) this.HiB).addView(Ym);
        }
    }

    public void Sj(TKC tkc, ViewGroup.LayoutParams layoutParams) {
        if (tkc == null) {
            return;
        }
        this.Sj.add(tkc);
        View Ym = tkc.Ym();
        if (Ym != null) {
            ((ViewGroup) this.HiB).addView(Ym, layoutParams);
        }
    }

    public C0212Sj TEQ() {
        return new C0212Sj(this);
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    public TKC sP(String str) {
        TKC<View> EjP;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.f20910aa)) {
            return this;
        }
        for (TKC<View> tkc : this.Sj) {
            if (tkc != null && (EjP = tkc.EjP(str)) != null) {
                return EjP;
            }
        }
        return null;
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    public void sP() {
        super.sP();
    }

    public List<TKC<View>> uA() {
        return this.Sj;
    }
}
