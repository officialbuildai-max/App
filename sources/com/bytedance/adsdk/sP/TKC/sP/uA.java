package com.bytedance.adsdk.sP.TKC.sP;

/* loaded from: classes2.dex */
public class uA implements TKC {
    private final String Sj;
    private final boolean TKC;
    private final Sj sP;

    /* loaded from: classes2.dex */
    public enum Sj {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static Sj Sj(int i11) {
            return i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? i11 != 5 ? MERGE : EXCLUDE_INTERSECTIONS : INTERSECT : SUBTRACT : ADD : MERGE;
        }
    }

    public uA(String str, Sj sj2, boolean z10) {
        this.Sj = str;
        this.sP = sj2;
        this.TKC = z10;
    }

    @Override // com.bytedance.adsdk.sP.TKC.sP.TKC
    public com.bytedance.adsdk.sP.Sj.Sj.TKC Sj(com.bytedance.adsdk.sP.uA uAVar, com.bytedance.adsdk.sP.Jcg jcg, com.bytedance.adsdk.sP.TKC.TKC.Sj sj2) {
        return new com.bytedance.adsdk.sP.Sj.Sj.aa(this);
    }

    public String Sj() {
        return this.Sj;
    }

    public boolean TKC() {
        return this.TKC;
    }

    public Sj sP() {
        return this.sP;
    }

    public String toString() {
        return "MergePaths{mode=" + this.sP + '}';
    }
}
