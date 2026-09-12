package androidx.media3.common;

import android.util.SparseBooleanArray;
import androidx.media3.common.util.a1;

/* loaded from: classes2.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    private final SparseBooleanArray f10201a;

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final SparseBooleanArray f10202a = new SparseBooleanArray();

        /* renamed from: b, reason: collision with root package name */
        private boolean f10203b;

        public b a(int i11) {
            androidx.media3.common.util.a.g(!this.f10203b);
            this.f10202a.append(i11, true);
            return this;
        }

        public b b(p pVar) {
            for (int i11 = 0; i11 < pVar.d(); i11++) {
                a(pVar.c(i11));
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

        public p e() {
            androidx.media3.common.util.a.g(!this.f10203b);
            this.f10203b = true;
            return new p(this.f10202a);
        }
    }

    private p(SparseBooleanArray sparseBooleanArray) {
        this.f10201a = sparseBooleanArray;
    }

    public boolean a(int i11) {
        return this.f10201a.get(i11);
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
        androidx.media3.common.util.a.c(i11, 0, d());
        return this.f10201a.keyAt(i11);
    }

    public int d() {
        return this.f10201a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (a1.f10432a >= 24) {
            return this.f10201a.equals(pVar.f10201a);
        }
        if (d() != pVar.d()) {
            return false;
        }
        for (int i11 = 0; i11 < d(); i11++) {
            if (c(i11) != pVar.c(i11)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (a1.f10432a >= 24) {
            return this.f10201a.hashCode();
        }
        int d11 = d();
        for (int i11 = 0; i11 < d(); i11++) {
            d11 = (d11 * 31) + c(i11);
        }
        return d11;
    }
}
