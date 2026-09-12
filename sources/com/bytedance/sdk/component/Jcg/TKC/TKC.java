package com.bytedance.sdk.component.Jcg.TKC;

/* loaded from: classes2.dex */
public class TKC {
    private Sj Sj;
    private sP sP;

    /* loaded from: classes2.dex */
    public enum Sj {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    /* renamed from: com.bytedance.sdk.component.Jcg.TKC.TKC$TKC, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0223TKC {
        private static final TKC Sj = new TKC();
    }

    /* loaded from: classes2.dex */
    public interface sP {
    }

    private TKC() {
        this.Sj = Sj.OFF;
        this.sP = new com.bytedance.sdk.component.Jcg.TKC.sP();
    }

    public static void Sj(Sj sj2) {
        synchronized (TKC.class) {
            C0223TKC.Sj.Sj = sj2;
        }
    }
}
