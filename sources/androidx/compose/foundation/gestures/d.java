package androidx.compose.foundation.gestures;

/* loaded from: classes.dex */
public interface d {

    /* renamed from: a, reason: collision with root package name */
    public static final a f2791a = a.f2792a;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f2792a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final androidx.compose.animation.core.g f2793b = androidx.compose.animation.core.h.d(0.0f, 0.0f, null, 7, null);

        /* renamed from: c, reason: collision with root package name */
        private static final d f2794c = new C0033a();

        /* renamed from: androidx.compose.foundation.gestures.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0033a implements d {
            C0033a() {
            }

            @Override // androidx.compose.foundation.gestures.d
            public /* synthetic */ float a(float f11, float f12, float f13) {
                return c.a(this, f11, f12, f13);
            }

            @Override // androidx.compose.foundation.gestures.d
            public /* synthetic */ androidx.compose.animation.core.g b() {
                return c.b(this);
            }
        }

        private a() {
        }

        public final float a(float f11, float f12, float f13) {
            float f14 = f12 + f11;
            if ((f11 >= 0.0f && f14 <= f13) || (f11 < 0.0f && f14 > f13)) {
                return 0.0f;
            }
            float f15 = f14 - f13;
            return Math.abs(f11) < Math.abs(f15) ? f11 : f15;
        }

        public final d b() {
            return f2794c;
        }

        public final androidx.compose.animation.core.g c() {
            return f2793b;
        }
    }

    float a(float f11, float f12, float f13);

    androidx.compose.animation.core.g b();
}
