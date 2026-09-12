package lg;

import android.util.Log;
import com.tn.lib.logger.xlog.LogType;
import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mg.c;
import og.b;
import og.d;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a */
    public static final C0856a f68962a = new C0856a(null);

    /* renamed from: b */
    private static mg.a f68963b;

    /* renamed from: lg.a$a */
    /* loaded from: classes3.dex */
    public static final class C0856a {

        /* renamed from: lg.a$a$a */
        /* loaded from: classes3.dex */
        public /* synthetic */ class C0857a {

            /* renamed from: a */
            public static final /* synthetic */ int[] f68964a;

            static {
                int[] iArr = new int[LogType.values().length];
                try {
                    iArr[LogType.TYPE_LOGCAT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LogType.TYPE_XLOG.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f68964a = iArr;
            }
        }

        private C0856a() {
        }

        public /* synthetic */ C0856a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String a(String str) {
            String str2 = "MB_" + str;
            if (str2.length() <= 23) {
                return str2;
            }
            String substring = str2.substring(0, 23);
            Intrinsics.g(substring, "substring(...)");
            return substring;
        }

        public static /* synthetic */ void e(C0856a c0856a, String str, String str2, Throwable th2, boolean z10, int i11, Object obj) {
            if ((i11 & 8) != 0) {
                z10 = false;
            }
            c0856a.b(str, str2, th2, z10);
        }

        public static /* synthetic */ void f(C0856a c0856a, String str, String str2, boolean z10, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                z10 = false;
            }
            c0856a.c(str, str2, z10);
        }

        public static /* synthetic */ void g(C0856a c0856a, String str, boolean z10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                z10 = false;
            }
            c0856a.d(str, z10);
        }

        public static /* synthetic */ void k(C0856a c0856a, String str, String str2, Throwable th2, boolean z10, int i11, Object obj) {
            if ((i11 & 8) != 0) {
                z10 = false;
            }
            c0856a.h(str, str2, th2, z10);
        }

        public static /* synthetic */ void l(C0856a c0856a, String str, String str2, boolean z10, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                z10 = false;
            }
            c0856a.i(str, str2, z10);
        }

        public static /* synthetic */ void m(C0856a c0856a, String str, boolean z10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                z10 = false;
            }
            c0856a.j(str, z10);
        }

        private final mg.a n() {
            int i11 = C0857a.f68964a[c.f69683a.d().ordinal()];
            if (i11 == 1) {
                return b.f71134b.a();
            }
            if (i11 == 2) {
                return d.f71137b.a();
            }
            throw new NoWhenBranchMatchedException();
        }

        public static /* synthetic */ void q(C0856a c0856a, String str, boolean z10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                z10 = false;
            }
            c0856a.o(str, z10);
        }

        public static /* synthetic */ void r(C0856a c0856a, String str, String[] strArr, boolean z10, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                z10 = false;
            }
            c0856a.p(str, strArr, z10);
        }

        private final boolean s(String str, boolean z10) {
            return !z10 || Log.isLoggable(a(str), 3);
        }

        private final boolean t(String str) {
            return Log.isLoggable(a(str), 3);
        }

        public static /* synthetic */ void v(C0856a c0856a, String str, String str2, boolean z10, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                z10 = false;
            }
            c0856a.u(str, str2, z10);
        }

        public static /* synthetic */ void y(C0856a c0856a, String str, String str2, Throwable th2, boolean z10, int i11, Object obj) {
            if ((i11 & 8) != 0) {
                z10 = false;
            }
            c0856a.w(str, str2, th2, z10);
        }

        public static /* synthetic */ void z(C0856a c0856a, String str, String str2, boolean z10, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                z10 = false;
            }
            c0856a.x(str, str2, z10);
        }

        public final void b(String tag, String msg, Throwable throwable, boolean z10) {
            Intrinsics.h(tag, "tag");
            Intrinsics.h(msg, "msg");
            Intrinsics.h(throwable, "throwable");
            if (t(tag)) {
                b.f71134b.a().f(a(tag), msg, throwable.getStackTrace().toString());
                return;
            }
            if (!z10) {
                b.f71134b.a().d(a(tag), msg, throwable.getStackTrace().toString());
                return;
            }
            if (a.f68963b == null) {
                a.f68963b = n();
            }
            mg.a aVar = a.f68963b;
            if (aVar != null) {
                aVar.e(a(tag), msg, throwable.getStackTrace().toString());
            }
        }

        public final void c(String tag, String msg, boolean z10) {
            Intrinsics.h(tag, "tag");
            Intrinsics.h(msg, "msg");
            if (t(tag)) {
                b.f71134b.a().f(a(tag), msg);
                return;
            }
            if (!z10) {
                b.f71134b.a().e(a(tag), msg);
                return;
            }
            if (a.f68963b == null) {
                a.f68963b = n();
            }
            mg.a aVar = a.f68963b;
            if (aVar != null) {
                aVar.e(a(tag), msg);
            }
        }

        public final void d(String msg, boolean z10) {
            Intrinsics.h(msg, "msg");
            if (!z10) {
                b.f71134b.a().c(msg);
                return;
            }
            if (a.f68963b == null) {
                a.f68963b = n();
            }
            mg.a aVar = a.f68963b;
            if (aVar != null) {
                aVar.c(msg);
            }
        }

        public final void h(String tag, String msg, Throwable throwable, boolean z10) {
            Intrinsics.h(tag, "tag");
            Intrinsics.h(msg, "msg");
            Intrinsics.h(throwable, "throwable");
            if (s(tag, z10)) {
                b.f71134b.a().g(a(tag), msg, throwable.getStackTrace().toString());
                return;
            }
            if (a.f68963b == null) {
                a.f68963b = n();
            }
            mg.a aVar = a.f68963b;
            if (aVar != null) {
                aVar.g(a(tag), msg, throwable.getStackTrace().toString());
            }
        }

        public final void i(String tag, String msg, boolean z10) {
            Intrinsics.h(tag, "tag");
            Intrinsics.h(msg, "msg");
            if (s(tag, z10)) {
                b.f71134b.a().g(a(tag), msg);
                return;
            }
            if (a.f68963b == null) {
                a.f68963b = n();
            }
            mg.a aVar = a.f68963b;
            if (aVar != null) {
                aVar.g(a(tag), msg);
            }
        }

        public final void j(String msg, boolean z10) {
            Intrinsics.h(msg, "msg");
            if (!z10) {
                b.f71134b.a().b(msg);
                return;
            }
            if (a.f68963b == null) {
                a.f68963b = n();
            }
            mg.a aVar = a.f68963b;
            if (aVar != null) {
                aVar.b(msg);
            }
        }

        public final void o(String msg, boolean z10) {
            Intrinsics.h(msg, "msg");
            if (!z10) {
                b.f71134b.a().a(msg);
                return;
            }
            if (a.f68963b == null) {
                a.f68963b = n();
            }
            mg.a aVar = a.f68963b;
            if (aVar != null) {
                aVar.a(msg);
            }
        }

        public final void p(String tag, String[] msg, boolean z10) {
            Intrinsics.h(tag, "tag");
            Intrinsics.h(msg, "msg");
            if (t(tag)) {
                b.f71134b.a().f(a(tag), (String[]) Arrays.copyOf(msg, msg.length));
                return;
            }
            if (!z10) {
                b.f71134b.a().d(a(tag), (String[]) Arrays.copyOf(msg, msg.length));
                return;
            }
            if (a.f68963b == null) {
                a.f68963b = n();
            }
            mg.a aVar = a.f68963b;
            if (aVar != null) {
                aVar.d(a(tag), (String[]) Arrays.copyOf(msg, msg.length));
            }
        }

        public final void u(String tag, String msg, boolean z10) {
            Intrinsics.h(tag, "tag");
            Intrinsics.h(msg, "msg");
            if (t(tag)) {
                b.f71134b.a().f(a(tag), msg);
                return;
            }
            if (!z10) {
                b.f71134b.a().h(a(tag), msg);
                return;
            }
            if (a.f68963b == null) {
                a.f68963b = n();
            }
            mg.a aVar = a.f68963b;
            if (aVar != null) {
                aVar.h(a(tag), msg);
            }
        }

        public final void w(String tag, String msg, Throwable throwable, boolean z10) {
            Intrinsics.h(tag, "tag");
            Intrinsics.h(msg, "msg");
            Intrinsics.h(throwable, "throwable");
            if (s(tag, z10)) {
                b.f71134b.a().f(a(tag), msg, throwable.getStackTrace().toString());
                return;
            }
            if (a.f68963b == null) {
                a.f68963b = n();
            }
            mg.a aVar = a.f68963b;
            if (aVar != null) {
                aVar.f(a(tag), msg, throwable.getStackTrace().toString());
            }
        }

        public final void x(String tag, String msg, boolean z10) {
            Intrinsics.h(tag, "tag");
            Intrinsics.h(msg, "msg");
            if (s(tag, z10)) {
                b.f71134b.a().f(a(tag), msg);
                return;
            }
            if (a.f68963b == null) {
                a.f68963b = n();
            }
            mg.a aVar = a.f68963b;
            if (aVar != null) {
                aVar.f(a(tag), msg);
            }
        }
    }

    public static final void c(String str, String str2, boolean z10) {
        f68962a.c(str, str2, z10);
    }
}
