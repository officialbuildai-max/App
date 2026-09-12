package androidx.compose.animation.core;

/* loaded from: classes.dex */
public abstract class b0 {

    /* renamed from: a, reason: collision with root package name */
    private static final z f2482a = new u(0.4f, 0.0f, 0.2f, 1.0f);

    /* renamed from: b, reason: collision with root package name */
    private static final z f2483b = new u(0.0f, 0.0f, 0.2f, 1.0f);

    /* renamed from: c, reason: collision with root package name */
    private static final z f2484c = new u(0.4f, 0.0f, 1.0f, 1.0f);

    /* renamed from: d, reason: collision with root package name */
    private static final z f2485d = new z() { // from class: androidx.compose.animation.core.a0
        @Override // androidx.compose.animation.core.z
        public final float a(float f11) {
            float b11;
            b11 = b0.b(f11);
            return b11;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final float b(float f11) {
        return f11;
    }

    public static final z c() {
        return f2482a;
    }

    public static final z d() {
        return f2485d;
    }
}
