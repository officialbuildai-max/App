package androidx.compose.ui;

import androidx.compose.ui.b;
import androidx.compose.ui.unit.LayoutDirection;
import o0.q;
import o0.t;

/* loaded from: classes.dex */
public final class c implements androidx.compose.ui.b {

    /* renamed from: b, reason: collision with root package name */
    private final float f4179b;

    /* renamed from: c, reason: collision with root package name */
    private final float f4180c;

    /* loaded from: classes.dex */
    public static final class a implements b.InterfaceC0044b {

        /* renamed from: a, reason: collision with root package name */
        private final float f4181a;

        public a(float f11) {
            this.f4181a = f11;
        }

        @Override // androidx.compose.ui.b.InterfaceC0044b
        public int a(int i11, int i12, LayoutDirection layoutDirection) {
            return Math.round(((i12 - i11) / 2.0f) * (1 + (layoutDirection == LayoutDirection.Ltr ? this.f4181a : (-1) * this.f4181a)));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Float.compare(this.f4181a, ((a) obj).f4181a) == 0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f4181a);
        }

        public String toString() {
            return "Horizontal(bias=" + this.f4181a + ')';
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements b.c {

        /* renamed from: a, reason: collision with root package name */
        private final float f4182a;

        public b(float f11) {
            this.f4182a = f11;
        }

        @Override // androidx.compose.ui.b.c
        public int a(int i11, int i12) {
            return Math.round(((i12 - i11) / 2.0f) * (1 + this.f4182a));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Float.compare(this.f4182a, ((b) obj).f4182a) == 0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f4182a);
        }

        public String toString() {
            return "Vertical(bias=" + this.f4182a + ')';
        }
    }

    public c(float f11, float f12) {
        this.f4179b = f11;
        this.f4180c = f12;
    }

    @Override // androidx.compose.ui.b
    public long a(long j11, long j12, LayoutDirection layoutDirection) {
        float g11 = (t.g(j12) - t.g(j11)) / 2.0f;
        float f11 = (t.f(j12) - t.f(j11)) / 2.0f;
        float f12 = 1;
        return q.a(Math.round(g11 * ((layoutDirection == LayoutDirection.Ltr ? this.f4179b : (-1) * this.f4179b) + f12)), Math.round(f11 * (f12 + this.f4180c)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Float.compare(this.f4179b, cVar.f4179b) == 0 && Float.compare(this.f4180c, cVar.f4180c) == 0;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f4179b) * 31) + Float.floatToIntBits(this.f4180c);
    }

    public String toString() {
        return "BiasAlignment(horizontalBias=" + this.f4179b + ", verticalBias=" + this.f4180c + ')';
    }
}
