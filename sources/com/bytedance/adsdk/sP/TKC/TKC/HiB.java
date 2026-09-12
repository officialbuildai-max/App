package com.bytedance.adsdk.sP.TKC.TKC;

import com.bytedance.adsdk.sP.TKC.Sj.Ym;
import com.bytedance.adsdk.sP.TKC.Sj.aa;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class HiB {
    private final List<com.bytedance.adsdk.sP.TKC.sP.Dq> Dq;
    private final long EjP;
    private final float Fmk;
    private final Sj HiB;
    private final String Jcg;
    private final com.bytedance.adsdk.sP.TKC.Sj.sP RiZ;
    private final List<com.bytedance.adsdk.sP.TKC.sP.TKC> Sj;
    private final int TEQ;
    private final String TKC;
    private final Ym TzV;
    private final int Ym;
    private final float Zq;

    /* renamed from: aa, reason: collision with root package name */
    private final int f20861aa;
    private final com.bytedance.adsdk.sP.TKC.Sj.TEQ dNu;

    /* renamed from: dx, reason: collision with root package name */
    private final sP f20862dx;

    /* renamed from: ib, reason: collision with root package name */
    private final com.bytedance.adsdk.sP.TKC.sP.Sj f20863ib;
    private final com.bytedance.adsdk.sP.HiB.TEQ kF;
    private final com.bytedance.adsdk.sP.Jcg sP;
    private final List<com.bytedance.adsdk.sP.Jcg.Sj<Float>> sU;
    private final float sef;
    private final aa uA;
    private final float uvD;
    private final long vS;
    private final boolean zR;

    /* loaded from: classes2.dex */
    public enum Sj {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* loaded from: classes2.dex */
    public enum sP {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public HiB(List<com.bytedance.adsdk.sP.TKC.sP.TKC> list, com.bytedance.adsdk.sP.Jcg jcg, String str, long j11, Sj sj2, long j12, String str2, List<com.bytedance.adsdk.sP.TKC.sP.Dq> list2, aa aaVar, int i11, int i12, int i13, float f11, float f12, float f13, float f14, com.bytedance.adsdk.sP.TKC.Sj.TEQ teq, Ym ym2, List<com.bytedance.adsdk.sP.Jcg.Sj<Float>> list3, sP sPVar, com.bytedance.adsdk.sP.TKC.Sj.sP sPVar2, boolean z10, com.bytedance.adsdk.sP.TKC.sP.Sj sj3, com.bytedance.adsdk.sP.HiB.TEQ teq2) {
        this.Sj = list;
        this.sP = jcg;
        this.TKC = str;
        this.EjP = j11;
        this.HiB = sj2;
        this.vS = j12;
        this.Jcg = str2;
        this.Dq = list2;
        this.uA = aaVar;
        this.TEQ = i11;
        this.Ym = i12;
        this.f20861aa = i13;
        this.Fmk = f11;
        this.sef = f12;
        this.Zq = f13;
        this.uvD = f14;
        this.dNu = teq;
        this.TzV = ym2;
        this.sU = list3;
        this.f20862dx = sPVar;
        this.RiZ = sPVar2;
        this.zR = z10;
        this.f20863ib = sj3;
        this.kF = teq2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float Dq() {
        return this.Zq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.bytedance.adsdk.sP.Jcg.Sj<Float>> EjP() {
        return this.sU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long Fmk() {
        return this.vS;
    }

    public long HiB() {
        return this.EjP;
    }

    public String Jcg() {
        return this.Jcg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.adsdk.sP.TKC.Sj.TEQ RiZ() {
        return this.dNu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.adsdk.sP.Jcg Sj() {
        return this.sP;
    }

    public String Sj(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(vS());
        sb2.append("\n");
        HiB Sj2 = this.sP.Sj(Fmk());
        if (Sj2 != null) {
            sb2.append("\t\tParents: ");
            sb2.append(Sj2.vS());
            HiB Sj3 = this.sP.Sj(Sj2.Fmk());
            while (Sj3 != null) {
                sb2.append("->");
                sb2.append(Sj3.vS());
                Sj3 = this.sP.Sj(Sj3.Fmk());
            }
            sb2.append(str);
            sb2.append("\n");
        }
        if (!TEQ().isEmpty()) {
            sb2.append(str);
            sb2.append("\tMasks: ");
            sb2.append(TEQ().size());
            sb2.append("\n");
        }
        if (TzV() != 0 && dNu() != 0) {
            sb2.append(str);
            sb2.append("\tBackground: ");
            sb2.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(TzV()), Integer.valueOf(dNu()), Integer.valueOf(uvD())));
        }
        if (!this.Sj.isEmpty()) {
            sb2.append(str);
            sb2.append("\tShapes:\n");
            for (com.bytedance.adsdk.sP.TKC.sP.TKC tkc : this.Sj) {
                sb2.append(str);
                sb2.append("\t\t");
                sb2.append(tkc);
                sb2.append("\n");
            }
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.bytedance.adsdk.sP.TKC.sP.Dq> TEQ() {
        return this.Dq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float TKC() {
        return this.sef / this.sP.dNu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int TzV() {
        return this.TEQ;
    }

    public Sj Ym() {
        return this.HiB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa Zq() {
        return this.uA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public sP aa() {
        return this.f20862dx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dNu() {
        return this.Ym;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.adsdk.sP.TKC.Sj.sP dx() {
        return this.RiZ;
    }

    public com.bytedance.adsdk.sP.TKC.sP.Sj ib() {
        return this.f20863ib;
    }

    public com.bytedance.adsdk.sP.HiB.TEQ kF() {
        return this.kF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float sP() {
        return this.Fmk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ym sU() {
        return this.TzV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.bytedance.adsdk.sP.TKC.sP.TKC> sef() {
        return this.Sj;
    }

    public String toString() {
        return Sj("");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float uA() {
        return this.uvD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int uvD() {
        return this.f20861aa;
    }

    public String vS() {
        return this.TKC;
    }

    public boolean zR() {
        return this.zR;
    }
}
