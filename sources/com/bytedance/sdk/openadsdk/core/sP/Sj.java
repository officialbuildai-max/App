package com.bytedance.sdk.openadsdk.core.sP;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.TzV;
import com.bytedance.sdk.openadsdk.core.Dq.Dq;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.utils.Mts;
import com.bytedance.sdk.openadsdk.utils.Zq;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class Sj extends sP {
    private boolean FPG;
    private WeakReference<InterfaceC0286Sj> Mts;
    private boolean Sj;
    private boolean TKC;
    private int Wjd;
    private boolean sP;

    /* renamed from: com.bytedance.sdk.openadsdk.core.sP.Sj$Sj, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0286Sj {
        long getVideoProgress();
    }

    public Sj(@NonNull Context context, @NonNull sU sUVar, @NonNull String str, int i11) {
        super(context, sUVar, str, i11);
        this.Sj = true;
        this.sP = false;
        this.TKC = false;
        this.FPG = false;
    }

    private boolean Dq() {
        return sU.HiB(((sP) this).vS) && ((sP) this).vS.LD() == 1;
    }

    private boolean EjP(View view) {
        if (view == null) {
            return false;
        }
        if ((view instanceof com.bytedance.sdk.openadsdk.core.aa.sP.vS) || view.getId() == Zq.f21213gq || view.getId() == Zq.f21215jb || view.getId() == Zq.Ei || view.getId() == Zq.HpB || view.getId() == Zq.xhi || view.getId() == 520093726 || view.getId() == Zq.f21219vb) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        int i11 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i11 >= viewGroup.getChildCount()) {
                return false;
            }
            if (EjP(viewGroup.getChildAt(i11))) {
                return true;
            }
            i11++;
        }
    }

    private boolean TEQ() {
        if (((sP) this).vS == null || uA()) {
            return false;
        }
        if (((sP) this).vS.HcZ() != 5 && ((sP) this).vS.HcZ() != 15) {
            return false;
        }
        if (this.Wjd == 0) {
            this.Wjd = ((sP) this).vS.DKa();
        }
        sP();
        Sj();
        TKC();
        if (this.Wjd == 5 && Dq() && Sj() && !sP() && !TKC()) {
            return false;
        }
        int i11 = this.Wjd;
        return i11 == 1 || i11 == 2 || i11 == 5;
    }

    private String sP(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1695837674:
                if (str.equals("banner_ad")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1263194568:
                if (str.equals("open_ad")) {
                    c11 = 1;
                    break;
                }
                break;
            case -712491894:
                if (str.equals("embeded_ad")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1844104722:
                if (str.equals("interaction")) {
                    c11 = 3;
                    break;
                }
                break;
            case 2091589896:
                if (str.equals("slide_banner_ad")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return "banner_call";
            case 1:
                return "open_ad";
            case 2:
                return "feed_call";
            case 3:
                return "interaction_call";
            case 4:
                return "banner_call";
            default:
                return "";
        }
    }

    private boolean uA() {
        return this instanceof Dq;
    }

    public void EjP(boolean z10) {
        this.FPG = z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:181:0x03b6, code lost:
    
        if (((java.lang.Boolean) r4.getTag(520093762)).booleanValue() != false) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x03a7, code lost:
    
        if ((r4 instanceof com.bytedance.sdk.openadsdk.core.aa.sP.vS) == false) goto L187;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0138  */
    /* JADX WARN: Type inference failed for: r2v11, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r2v34, types: [android.content.Context] */
    @Override // com.bytedance.sdk.openadsdk.core.sP.sP, com.bytedance.sdk.openadsdk.core.sP.TKC
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Sj(android.view.View r31, float r32, float r33, float r34, float r35, android.util.SparseArray<com.bytedance.sdk.openadsdk.core.sP.TKC.Sj> r36, boolean r37) {
        /*
            Method dump skipped, instructions count: 1038
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.sP.Sj.Sj(android.view.View, float, float, float, float, android.util.SparseArray, boolean):void");
    }

    public void Sj(InterfaceC0286Sj interfaceC0286Sj) {
        this.Mts = new WeakReference<>(interfaceC0286Sj);
    }

    public void Sj(boolean z10) {
        this.Sj = z10;
    }

    protected boolean Sj() {
        sU sUVar = ((sP) this).vS;
        if (sUVar == null) {
            return true;
        }
        int sP = dNu.EjP().sP(sUVar.If());
        int TKC = TzV.TKC(dNu.Sj());
        if (sP == 1) {
            return Mts.EjP(TKC);
        }
        if (sP == 2) {
            return Mts.HiB(TKC) || Mts.EjP(TKC) || Mts.vS(TKC);
        }
        if (sP != 3) {
            return sP != 5 || Mts.EjP(TKC) || Mts.vS(TKC);
        }
        return false;
    }

    public void TKC(boolean z10) {
        this.TKC = z10;
    }

    public boolean TKC() {
        return false;
    }

    public void sP(boolean z10) {
        this.sP = z10;
    }

    public boolean sP() {
        return false;
    }
}
