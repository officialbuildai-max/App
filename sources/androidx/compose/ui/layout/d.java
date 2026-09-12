package androidx.compose.ui.layout;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public interface d {

    /* loaded from: classes.dex */
    public interface a {
        boolean a();
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5243a = new a(null);

        /* renamed from: b, reason: collision with root package name */
        private static final int f5244b = g(1);

        /* renamed from: c, reason: collision with root package name */
        private static final int f5245c = g(2);

        /* renamed from: d, reason: collision with root package name */
        private static final int f5246d = g(3);

        /* renamed from: e, reason: collision with root package name */
        private static final int f5247e = g(4);

        /* renamed from: f, reason: collision with root package name */
        private static final int f5248f = g(5);

        /* renamed from: g, reason: collision with root package name */
        private static final int f5249g = g(6);

        /* loaded from: classes.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return b.f5248f;
            }

            public final int b() {
                return b.f5245c;
            }

            public final int c() {
                return b.f5244b;
            }

            public final int d() {
                return b.f5249g;
            }

            public final int e() {
                return b.f5246d;
            }

            public final int f() {
                return b.f5247e;
            }
        }

        public static int g(int i11) {
            return i11;
        }

        public static final boolean h(int i11, int i12) {
            return i11 == i12;
        }
    }

    Object a(int i11, Function1 function1);
}
