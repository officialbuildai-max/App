package androidx.activity;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final a f944e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final float f945a;

    /* renamed from: b, reason: collision with root package name */
    private final float f946b;

    /* renamed from: c, reason: collision with root package name */
    private final float f947c;

    /* renamed from: d, reason: collision with root package name */
    private final int f948d;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(float f11, float f12, float f13, int i11) {
        this.f945a = f11;
        this.f946b = f12;
        this.f947c = f13;
        this.f948d = i11;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(android.window.BackEvent r5) {
        /*
            r4 = this;
            java.lang.String r0 = "backEvent"
            kotlin.jvm.internal.Intrinsics.h(r5, r0)
            androidx.activity.a r0 = androidx.activity.a.f943a
            float r1 = r0.c(r5)
            float r2 = r0.d(r5)
            float r3 = r0.a(r5)
            int r5 = r0.b(r5)
            r4.<init>(r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.b.<init>(android.window.BackEvent):void");
    }

    public final float a() {
        return this.f947c;
    }

    public final int b() {
        return this.f948d;
    }

    public final float c() {
        return this.f946b;
    }

    public String toString() {
        return "BackEventCompat{touchX=" + this.f945a + ", touchY=" + this.f946b + ", progress=" + this.f947c + ", swipeEdge=" + this.f948d + '}';
    }
}
