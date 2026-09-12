package androidx.work;

/* loaded from: classes2.dex */
public interface w {

    /* renamed from: a, reason: collision with root package name */
    public static final b.c f16140a;

    /* renamed from: b, reason: collision with root package name */
    public static final b.C0145b f16141b;

    /* loaded from: classes2.dex */
    public static abstract class b {

        /* loaded from: classes2.dex */
        public static final class a extends b {

            /* renamed from: a, reason: collision with root package name */
            private final Throwable f16142a;

            public a(Throwable th2) {
                this.f16142a = th2;
            }

            public String toString() {
                return "FAILURE (" + this.f16142a.getMessage() + ")";
            }
        }

        /* renamed from: androidx.work.w$b$b, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0145b extends b {
            private C0145b() {
            }

            public String toString() {
                return "IN_PROGRESS";
            }
        }

        /* loaded from: classes2.dex */
        public static final class c extends b {
            private c() {
            }

            public String toString() {
                return "SUCCESS";
            }
        }

        b() {
        }
    }

    static {
        f16140a = new b.c();
        f16141b = new b.C0145b();
    }

    com.google.common.util.concurrent.r a();
}
