package com.google.android.exoplayer2.util;

import android.util.SparseBooleanArray;

/* loaded from: classes3.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private final SparseBooleanArray f27661a;

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final SparseBooleanArray f27662a = new SparseBooleanArray();

        /* renamed from: b, reason: collision with root package name */
        private boolean f27663b;

        public b a(int i11) {
            com.google.android.exoplayer2.util.a.g(!this.f27663b);
            this.f27662a.append(i11, true);
            return this;
        }

        public b b(m mVar) {
            for (int i11 = 0; i11 < mVar.d(); i11++) {
                a(mVar.c(i11));
            }
            return this;
        }

        public b c(int... iArr) {
            for (int i11 : iArr) {
                a(i11);
            }
            return this;
        }

        public b d(int i11, boolean z10) {
            return z10 ? a(i11) : this;
        }

        public m e() {
            com.google.android.exoplayer2.util.a.g(!this.f27663b);
            this.f27663b = true;
            return new m(this.f27662a);
        }
    }

    private m(SparseBooleanArray sparseBooleanArray) {
        this.f27661a = sparseBooleanArray;
    }

    public boolean a(int i11) {
        return this.f27661a.get(i11);
    }

    public boolean b(int... iArr) {
        for (int i11 : iArr) {
            if (a(i11)) {
                return true;
            }
        }
        return false;
    }

    public int c(int i11) {
        com.google.android.exoplayer2.util.a.c(i11, 0, d());
        return this.f27661a.keyAt(i11);
    }

    public int d() {
        return this.f27661a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (p0.f27680a >= 24) {
            return this.f27661a.equals(mVar.f27661a);
        }
        if (d() != mVar.d()) {
            return false;
        }
        for (int i11 = 0; i11 < d(); i11++) {
            if (c(i11) != mVar.c(i11)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (p0.f27680a >= 24) {
            return this.f27661a.hashCode();
        }
        int d11 = d();
        for (int i11 = 0; i11 < d(); i11++) {
            d11 = (d11 * 31) + c(i11);
        }
        return d11;
    }
}
