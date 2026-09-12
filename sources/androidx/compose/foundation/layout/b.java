package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.collections.ArraysKt;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f2911a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static final d f2912b = new i();

    /* renamed from: c, reason: collision with root package name */
    private static final d f2913c = new c();

    /* renamed from: d, reason: collision with root package name */
    private static final k f2914d = new j();

    /* renamed from: e, reason: collision with root package name */
    private static final k f2915e = new a();

    /* renamed from: f, reason: collision with root package name */
    private static final e f2916f = new C0034b();

    /* renamed from: g, reason: collision with root package name */
    private static final e f2917g = new h();

    /* renamed from: h, reason: collision with root package name */
    private static final e f2918h = new g();

    /* renamed from: i, reason: collision with root package name */
    private static final e f2919i = new f();

    /* loaded from: classes.dex */
    public static final class a implements k {
        a() {
        }

        @Override // androidx.compose.foundation.layout.b.k
        public /* synthetic */ float a() {
            return androidx.compose.foundation.layout.d.a(this);
        }

        @Override // androidx.compose.foundation.layout.b.k
        public void c(o0.e eVar, int i11, int[] iArr, int[] iArr2) {
            b.f2911a.g(i11, iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#Bottom";
        }
    }

    /* renamed from: androidx.compose.foundation.layout.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0034b implements e {

        /* renamed from: a, reason: collision with root package name */
        private final float f2920a = o0.i.g(0);

        C0034b() {
        }

        @Override // androidx.compose.foundation.layout.b.d, androidx.compose.foundation.layout.b.k
        public float a() {
            return this.f2920a;
        }

        @Override // androidx.compose.foundation.layout.b.d
        public void b(o0.e eVar, int i11, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                b.f2911a.e(i11, iArr, iArr2, false);
            } else {
                b.f2911a.e(i11, iArr, iArr2, true);
            }
        }

        @Override // androidx.compose.foundation.layout.b.k
        public void c(o0.e eVar, int i11, int[] iArr, int[] iArr2) {
            b.f2911a.e(i11, iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#Center";
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements d {
        c() {
        }

        @Override // androidx.compose.foundation.layout.b.d, androidx.compose.foundation.layout.b.k
        public /* synthetic */ float a() {
            return androidx.compose.foundation.layout.c.a(this);
        }

        @Override // androidx.compose.foundation.layout.b.d
        public void b(o0.e eVar, int i11, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                b.f2911a.g(i11, iArr, iArr2, false);
            } else {
                b.f2911a.f(iArr, iArr2, true);
            }
        }

        public String toString() {
            return "Arrangement#End";
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        float a();

        void b(o0.e eVar, int i11, int[] iArr, LayoutDirection layoutDirection, int[] iArr2);
    }

    /* loaded from: classes.dex */
    public interface e extends d, k {
    }

    /* loaded from: classes.dex */
    public static final class f implements e {

        /* renamed from: a, reason: collision with root package name */
        private final float f2921a = o0.i.g(0);

        f() {
        }

        @Override // androidx.compose.foundation.layout.b.d, androidx.compose.foundation.layout.b.k
        public float a() {
            return this.f2921a;
        }

        @Override // androidx.compose.foundation.layout.b.d
        public void b(o0.e eVar, int i11, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                b.f2911a.h(i11, iArr, iArr2, false);
            } else {
                b.f2911a.h(i11, iArr, iArr2, true);
            }
        }

        @Override // androidx.compose.foundation.layout.b.k
        public void c(o0.e eVar, int i11, int[] iArr, int[] iArr2) {
            b.f2911a.h(i11, iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#SpaceAround";
        }
    }

    /* loaded from: classes.dex */
    public static final class g implements e {

        /* renamed from: a, reason: collision with root package name */
        private final float f2922a = o0.i.g(0);

        g() {
        }

        @Override // androidx.compose.foundation.layout.b.d, androidx.compose.foundation.layout.b.k
        public float a() {
            return this.f2922a;
        }

        @Override // androidx.compose.foundation.layout.b.d
        public void b(o0.e eVar, int i11, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                b.f2911a.i(i11, iArr, iArr2, false);
            } else {
                b.f2911a.i(i11, iArr, iArr2, true);
            }
        }

        @Override // androidx.compose.foundation.layout.b.k
        public void c(o0.e eVar, int i11, int[] iArr, int[] iArr2) {
            b.f2911a.i(i11, iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#SpaceBetween";
        }
    }

    /* loaded from: classes.dex */
    public static final class h implements e {

        /* renamed from: a, reason: collision with root package name */
        private final float f2923a = o0.i.g(0);

        h() {
        }

        @Override // androidx.compose.foundation.layout.b.d, androidx.compose.foundation.layout.b.k
        public float a() {
            return this.f2923a;
        }

        @Override // androidx.compose.foundation.layout.b.d
        public void b(o0.e eVar, int i11, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                b.f2911a.j(i11, iArr, iArr2, false);
            } else {
                b.f2911a.j(i11, iArr, iArr2, true);
            }
        }

        @Override // androidx.compose.foundation.layout.b.k
        public void c(o0.e eVar, int i11, int[] iArr, int[] iArr2) {
            b.f2911a.j(i11, iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#SpaceEvenly";
        }
    }

    /* loaded from: classes.dex */
    public static final class i implements d {
        i() {
        }

        @Override // androidx.compose.foundation.layout.b.d, androidx.compose.foundation.layout.b.k
        public /* synthetic */ float a() {
            return androidx.compose.foundation.layout.c.a(this);
        }

        @Override // androidx.compose.foundation.layout.b.d
        public void b(o0.e eVar, int i11, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                b.f2911a.f(iArr, iArr2, false);
            } else {
                b.f2911a.g(i11, iArr, iArr2, true);
            }
        }

        public String toString() {
            return "Arrangement#Start";
        }
    }

    /* loaded from: classes.dex */
    public static final class j implements k {
        j() {
        }

        @Override // androidx.compose.foundation.layout.b.k
        public /* synthetic */ float a() {
            return androidx.compose.foundation.layout.d.a(this);
        }

        @Override // androidx.compose.foundation.layout.b.k
        public void c(o0.e eVar, int i11, int[] iArr, int[] iArr2) {
            b.f2911a.f(iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#Top";
        }
    }

    /* loaded from: classes.dex */
    public interface k {
        float a();

        void c(o0.e eVar, int i11, int[] iArr, int[] iArr2);
    }

    private b() {
    }

    public final k a() {
        return f2915e;
    }

    public final e b() {
        return f2916f;
    }

    public final d c() {
        return f2912b;
    }

    public final k d() {
        return f2914d;
    }

    public final void e(int i11, int[] iArr, int[] iArr2, boolean z10) {
        int i12 = 0;
        int i13 = 0;
        for (int i14 : iArr) {
            i13 += i14;
        }
        float f11 = (i11 - i13) / 2;
        if (!z10) {
            int length = iArr.length;
            int i15 = 0;
            while (i12 < length) {
                int i16 = iArr[i12];
                iArr2[i15] = Math.round(f11);
                f11 += i16;
                i12++;
                i15++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i17 = iArr[length2];
            iArr2[length2] = Math.round(f11);
            f11 += i17;
        }
    }

    public final void f(int[] iArr, int[] iArr2, boolean z10) {
        int i11 = 0;
        if (!z10) {
            int length = iArr.length;
            int i12 = 0;
            int i13 = 0;
            while (i11 < length) {
                int i14 = iArr[i11];
                iArr2[i12] = i13;
                i13 += i14;
                i11++;
                i12++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i15 = iArr[length2];
            iArr2[length2] = i11;
            i11 += i15;
        }
    }

    public final void g(int i11, int[] iArr, int[] iArr2, boolean z10) {
        int i12 = 0;
        int i13 = 0;
        for (int i14 : iArr) {
            i13 += i14;
        }
        int i15 = i11 - i13;
        if (!z10) {
            int length = iArr.length;
            int i16 = 0;
            while (i12 < length) {
                int i17 = iArr[i12];
                iArr2[i16] = i15;
                i15 += i17;
                i12++;
                i16++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i18 = iArr[length2];
            iArr2[length2] = i15;
            i15 += i18;
        }
    }

    public final void h(int i11, int[] iArr, int[] iArr2, boolean z10) {
        int i12 = 0;
        int i13 = 0;
        for (int i14 : iArr) {
            i13 += i14;
        }
        float length = !(iArr.length == 0) ? (i11 - i13) / iArr.length : 0.0f;
        float f11 = length / 2;
        if (z10) {
            for (int length2 = iArr.length - 1; -1 < length2; length2--) {
                int i15 = iArr[length2];
                iArr2[length2] = Math.round(f11);
                f11 += i15 + length;
            }
            return;
        }
        int length3 = iArr.length;
        int i16 = 0;
        while (i12 < length3) {
            int i17 = iArr[i12];
            iArr2[i16] = Math.round(f11);
            f11 += i17 + length;
            i12++;
            i16++;
        }
    }

    public final void i(int i11, int[] iArr, int[] iArr2, boolean z10) {
        if (iArr.length == 0) {
            return;
        }
        int i12 = 0;
        int i13 = 0;
        for (int i14 : iArr) {
            i13 += i14;
        }
        float max = (i11 - i13) / Math.max(ArraysKt.Z(iArr), 1);
        float f11 = (z10 && iArr.length == 1) ? max : 0.0f;
        if (z10) {
            for (int length = iArr.length - 1; -1 < length; length--) {
                int i15 = iArr[length];
                iArr2[length] = Math.round(f11);
                f11 += i15 + max;
            }
            return;
        }
        int length2 = iArr.length;
        int i16 = 0;
        while (i12 < length2) {
            int i17 = iArr[i12];
            iArr2[i16] = Math.round(f11);
            f11 += i17 + max;
            i12++;
            i16++;
        }
    }

    public final void j(int i11, int[] iArr, int[] iArr2, boolean z10) {
        int i12 = 0;
        int i13 = 0;
        for (int i14 : iArr) {
            i13 += i14;
        }
        float length = (i11 - i13) / (iArr.length + 1);
        if (z10) {
            float f11 = length;
            for (int length2 = iArr.length - 1; -1 < length2; length2--) {
                int i15 = iArr[length2];
                iArr2[length2] = Math.round(f11);
                f11 += i15 + length;
            }
            return;
        }
        int length3 = iArr.length;
        float f12 = length;
        int i16 = 0;
        while (i12 < length3) {
            int i17 = iArr[i12];
            iArr2[i16] = Math.round(f12);
            f12 += i17 + length;
            i12++;
            i16++;
        }
    }
}
