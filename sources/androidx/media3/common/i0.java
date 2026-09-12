package androidx.media3.common;

import androidx.media3.common.util.a1;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Booleans;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public final class i0 {

    /* renamed from: b, reason: collision with root package name */
    public static final i0 f10166b = new i0(ImmutableList.of());

    /* renamed from: c, reason: collision with root package name */
    private static final String f10167c = a1.C0(0);

    /* renamed from: a, reason: collision with root package name */
    private final ImmutableList f10168a;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: f, reason: collision with root package name */
        private static final String f10169f = a1.C0(0);

        /* renamed from: g, reason: collision with root package name */
        private static final String f10170g = a1.C0(1);

        /* renamed from: h, reason: collision with root package name */
        private static final String f10171h = a1.C0(3);

        /* renamed from: i, reason: collision with root package name */
        private static final String f10172i = a1.C0(4);

        /* renamed from: a, reason: collision with root package name */
        public final int f10173a;

        /* renamed from: b, reason: collision with root package name */
        private final f0 f10174b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f10175c;

        /* renamed from: d, reason: collision with root package name */
        private final int[] f10176d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean[] f10177e;

        public a(f0 f0Var, boolean z10, int[] iArr, boolean[] zArr) {
            int i11 = f0Var.f10053a;
            this.f10173a = i11;
            boolean z11 = false;
            androidx.media3.common.util.a.a(i11 == iArr.length && i11 == zArr.length);
            this.f10174b = f0Var;
            if (z10 && i11 > 1) {
                z11 = true;
            }
            this.f10175c = z11;
            this.f10176d = (int[]) iArr.clone();
            this.f10177e = (boolean[]) zArr.clone();
        }

        public f0 a() {
            return this.f10174b;
        }

        public r b(int i11) {
            return this.f10174b.a(i11);
        }

        public int c(int i11) {
            return this.f10176d[i11];
        }

        public int d() {
            return this.f10174b.f10055c;
        }

        public boolean e() {
            return this.f10175c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f10175c == aVar.f10175c && this.f10174b.equals(aVar.f10174b) && Arrays.equals(this.f10176d, aVar.f10176d) && Arrays.equals(this.f10177e, aVar.f10177e);
        }

        public boolean f() {
            return Booleans.a(this.f10177e, true);
        }

        public boolean g(boolean z10) {
            for (int i11 = 0; i11 < this.f10176d.length; i11++) {
                if (j(i11, z10)) {
                    return true;
                }
            }
            return false;
        }

        public boolean h(int i11) {
            return this.f10177e[i11];
        }

        public int hashCode() {
            return (((((this.f10174b.hashCode() * 31) + (this.f10175c ? 1 : 0)) * 31) + Arrays.hashCode(this.f10176d)) * 31) + Arrays.hashCode(this.f10177e);
        }

        public boolean i(int i11) {
            return j(i11, false);
        }

        public boolean j(int i11, boolean z10) {
            int i12 = this.f10176d[i11];
            return i12 == 4 || (z10 && i12 == 3);
        }
    }

    public i0(List list) {
        this.f10168a = ImmutableList.copyOf((Collection) list);
    }

    public ImmutableList a() {
        return this.f10168a;
    }

    public boolean b() {
        return this.f10168a.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean c(int i11) {
        for (int i12 = 0; i12 < this.f10168a.size(); i12++) {
            a aVar = (a) this.f10168a.get(i12);
            if (aVar.f() && aVar.d() == i11) {
                return true;
            }
        }
        return false;
    }

    public boolean d(int i11) {
        return e(i11, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean e(int i11, boolean z10) {
        for (int i12 = 0; i12 < this.f10168a.size(); i12++) {
            if (((a) this.f10168a.get(i12)).d() == i11 && ((a) this.f10168a.get(i12)).g(z10)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i0.class != obj.getClass()) {
            return false;
        }
        return this.f10168a.equals(((i0) obj).f10168a);
    }

    public int hashCode() {
        return this.f10168a.hashCode();
    }
}
