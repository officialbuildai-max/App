package androidx.window.layout;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes2.dex */
public interface r extends l {

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: b, reason: collision with root package name */
        public static final C0138a f15433b = new C0138a(null);

        /* renamed from: c, reason: collision with root package name */
        public static final a f15434c = new a("NONE");

        /* renamed from: d, reason: collision with root package name */
        public static final a f15435d = new a("FULL");

        /* renamed from: a, reason: collision with root package name */
        private final String f15436a;

        /* renamed from: androidx.window.layout.r$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0138a {
            private C0138a() {
            }

            public /* synthetic */ C0138a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private a(String str) {
            this.f15436a = str;
        }

        public String toString() {
            return this.f15436a;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: b, reason: collision with root package name */
        public static final a f15437b = new a(null);

        /* renamed from: c, reason: collision with root package name */
        public static final b f15438c = new b("VERTICAL");

        /* renamed from: d, reason: collision with root package name */
        public static final b f15439d = new b("HORIZONTAL");

        /* renamed from: a, reason: collision with root package name */
        private final String f15440a;

        /* loaded from: classes2.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private b(String str) {
            this.f15440a = str;
        }

        public String toString() {
            return this.f15440a;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: b, reason: collision with root package name */
        public static final a f15441b = new a(null);

        /* renamed from: c, reason: collision with root package name */
        public static final c f15442c = new c("FLAT");

        /* renamed from: d, reason: collision with root package name */
        public static final c f15443d = new c("HALF_OPENED");

        /* renamed from: a, reason: collision with root package name */
        private final String f15444a;

        /* loaded from: classes2.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private c(String str) {
            this.f15444a = str;
        }

        public String toString() {
            return this.f15444a;
        }
    }

    b getOrientation();

    boolean isSeparating();
}
