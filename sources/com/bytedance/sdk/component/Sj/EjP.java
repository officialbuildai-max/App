package com.bytedance.sdk.component.Sj;

/* loaded from: classes2.dex */
public abstract class EjP<P, R> extends com.bytedance.sdk.component.Sj.sP<P, R> {
    private boolean Sj = true;
    private vS TKC;
    private Sj sP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface Sj {
        void Sj(Object obj);

        void Sj(Throwable th2);
    }

    /* loaded from: classes2.dex */
    public interface sP {
        EjP Sj();
    }

    private boolean vS() {
        if (this.Sj) {
            return true;
        }
        uA.Sj(new IllegalStateException("Jsb async call already finished: " + Sj() + ", hashcode: " + hashCode()));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EjP() {
        this.Sj = false;
        this.TKC = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void HiB() {
        EjP();
    }

    @Override // com.bytedance.sdk.component.Sj.sP
    public /* bridge */ /* synthetic */ String Sj() {
        return super.Sj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Sj(R r11) {
        if (vS()) {
            this.sP.Sj(r11);
            EjP();
        }
    }

    protected abstract void Sj(P p11, vS vSVar) throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Sj(P p11, vS vSVar, Sj sj2) throws Exception {
        this.TKC = vSVar;
        this.sP = sj2;
        Sj(p11, vSVar);
    }

    protected final void Sj(Throwable th2) {
        if (vS()) {
            this.sP.Sj(th2);
            EjP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void TKC() {
        Sj((Throwable) null);
    }
}
