package com.bytedance.adsdk.sP.Sj.sP;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class Sj<K, A> {
    private final TKC<K> HiB;
    protected com.bytedance.adsdk.sP.Jcg.sP<A> TKC;
    final List<InterfaceC0203Sj> Sj = new ArrayList(1);
    private boolean EjP = false;
    protected float sP = 0.0f;
    private A vS = null;
    private float Jcg = -1.0f;
    private float Dq = -1.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class EjP<T> implements TKC<T> {
        private final List<? extends com.bytedance.adsdk.sP.Jcg.Sj<T>> Sj;
        private com.bytedance.adsdk.sP.Jcg.Sj<T> TKC = null;
        private float EjP = -1.0f;
        private com.bytedance.adsdk.sP.Jcg.Sj<T> sP = TKC(0.0f);

        EjP(List<? extends com.bytedance.adsdk.sP.Jcg.Sj<T>> list) {
            this.Sj = list;
        }

        private com.bytedance.adsdk.sP.Jcg.Sj<T> TKC(float f11) {
            com.bytedance.adsdk.sP.Jcg.Sj<T> sj2 = this.Sj.get(r0.size() - 1);
            if (f11 >= sj2.TKC()) {
                return sj2;
            }
            for (int size = this.Sj.size() - 2; size > 0; size--) {
                com.bytedance.adsdk.sP.Jcg.Sj<T> sj3 = this.Sj.get(size);
                if (this.sP != sj3 && sj3.Sj(f11)) {
                    return sj3;
                }
            }
            return this.Sj.get(0);
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public float EjP() {
            return this.Sj.get(r0.size() - 1).EjP();
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public boolean Sj() {
            return false;
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public boolean Sj(float f11) {
            if (this.sP.Sj(f11)) {
                return !this.sP.HiB();
            }
            this.sP = TKC(f11);
            return true;
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public float TKC() {
            return this.Sj.get(0).TKC();
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public com.bytedance.adsdk.sP.Jcg.Sj<T> sP() {
            return this.sP;
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public boolean sP(float f11) {
            com.bytedance.adsdk.sP.Jcg.Sj<T> sj2 = this.TKC;
            com.bytedance.adsdk.sP.Jcg.Sj<T> sj3 = this.sP;
            if (sj2 == sj3 && this.EjP == f11) {
                return true;
            }
            this.TKC = sj3;
            this.EjP = f11;
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class HiB<T> implements TKC<T> {
        private final com.bytedance.adsdk.sP.Jcg.Sj<T> Sj;
        private float sP = -1.0f;

        HiB(List<? extends com.bytedance.adsdk.sP.Jcg.Sj<T>> list) {
            this.Sj = list.get(0);
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public float EjP() {
            return this.Sj.EjP();
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public boolean Sj() {
            return false;
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public boolean Sj(float f11) {
            return !this.Sj.HiB();
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public float TKC() {
            return this.Sj.TKC();
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public com.bytedance.adsdk.sP.Jcg.Sj<T> sP() {
            return this.Sj;
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public boolean sP(float f11) {
            if (this.sP == f11) {
                return true;
            }
            this.sP = f11;
            return false;
        }
    }

    /* renamed from: com.bytedance.adsdk.sP.Sj.sP.Sj$Sj, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0203Sj {
        void Sj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface TKC<T> {
        float EjP();

        boolean Sj();

        boolean Sj(float f11);

        float TKC();

        com.bytedance.adsdk.sP.Jcg.Sj<T> sP();

        boolean sP(float f11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class sP<T> implements TKC<T> {
        private sP() {
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public float EjP() {
            return 1.0f;
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public boolean Sj() {
            return true;
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public boolean Sj(float f11) {
            return false;
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public float TKC() {
            return 0.0f;
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public com.bytedance.adsdk.sP.Jcg.Sj<T> sP() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public boolean sP(float f11) {
            throw new IllegalStateException("not implemented");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sj(List<? extends com.bytedance.adsdk.sP.Jcg.Sj<K>> list) {
        this.HiB = Sj(list);
    }

    private static <T> TKC<T> Sj(List<? extends com.bytedance.adsdk.sP.Jcg.Sj<T>> list) {
        return list.isEmpty() ? new sP() : list.size() == 1 ? new HiB(list) : new EjP(list);
    }

    private float uA() {
        if (this.Jcg == -1.0f) {
            this.Jcg = this.HiB.TKC();
        }
        return this.Jcg;
    }

    public float Dq() {
        return this.sP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float EjP() {
        if (this.EjP) {
            return 0.0f;
        }
        com.bytedance.adsdk.sP.Jcg.Sj<K> TKC2 = TKC();
        if (TKC2.HiB()) {
            return 0.0f;
        }
        return (this.sP - TKC2.TKC()) / (TKC2.EjP() - TKC2.TKC());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float HiB() {
        com.bytedance.adsdk.sP.Jcg.Sj<K> TKC2 = TKC();
        if (TKC2 == null || TKC2.HiB()) {
            return 0.0f;
        }
        return TKC2.TKC.getInterpolation(EjP());
    }

    public A Jcg() {
        float EjP2 = EjP();
        if (this.TKC == null && this.HiB.sP(EjP2)) {
            return this.vS;
        }
        com.bytedance.adsdk.sP.Jcg.Sj<K> TKC2 = TKC();
        Interpolator interpolator = TKC2.EjP;
        A Sj = (interpolator == null || TKC2.HiB == null) ? Sj(TKC2, HiB()) : Sj(TKC2, EjP2, interpolator.getInterpolation(EjP2), TKC2.HiB.getInterpolation(EjP2));
        this.vS = Sj;
        return Sj;
    }

    abstract A Sj(com.bytedance.adsdk.sP.Jcg.Sj<K> sj2, float f11);

    protected A Sj(com.bytedance.adsdk.sP.Jcg.Sj<K> sj2, float f11, float f12, float f13) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void Sj() {
        this.EjP = true;
    }

    public void Sj(float f11) {
        if (this.HiB.Sj()) {
            return;
        }
        if (f11 < uA()) {
            f11 = uA();
        } else if (f11 > vS()) {
            f11 = vS();
        }
        if (f11 == this.sP) {
            return;
        }
        this.sP = f11;
        if (this.HiB.Sj(f11)) {
            sP();
        }
    }

    public void Sj(InterfaceC0203Sj interfaceC0203Sj) {
        this.Sj.add(interfaceC0203Sj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.bytedance.adsdk.sP.Jcg.Sj<K> TKC() {
        com.bytedance.adsdk.sP.HiB.Sj("BaseKeyframeAnimation#getCurrentKeyframe");
        com.bytedance.adsdk.sP.Jcg.Sj<K> sP2 = this.HiB.sP();
        com.bytedance.adsdk.sP.HiB.sP("BaseKeyframeAnimation#getCurrentKeyframe");
        return sP2;
    }

    public void sP() {
        for (int i11 = 0; i11 < this.Sj.size(); i11++) {
            this.Sj.get(i11).Sj();
        }
    }

    float vS() {
        if (this.Dq == -1.0f) {
            this.Dq = this.HiB.EjP();
        }
        return this.Dq;
    }
}
