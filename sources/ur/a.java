package ur;

import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f77012a = new a();

    private a() {
    }

    private final String a(String str) {
        return "shorttv_ad_" + str;
    }

    public static /* synthetic */ void c(a aVar, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = null;
        }
        aVar.b(str, str2, str3);
    }

    public static /* synthetic */ void e(a aVar, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = null;
        }
        aVar.d(str, str2, str3);
    }

    public static /* synthetic */ void g(a aVar, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = null;
        }
        aVar.f(str, str2, str3);
    }

    public final void b(String tag, String message, String str) {
        String str2;
        Intrinsics.h(tag, "tag");
        Intrinsics.h(message, "message");
        if (str != null) {
            if (str.length() <= 0) {
                str = null;
            }
            if (str != null) {
                String str3 = "sceneId=" + str + ", " + message;
                if (str3 != null) {
                    str2 = str3;
                    a.C0856a.f(lg.a.f68962a, a(tag), str2, false, 4, null);
                }
            }
        }
        str2 = message;
        a.C0856a.f(lg.a.f68962a, a(tag), str2, false, 4, null);
    }

    public final void d(String tag, String message, String str) {
        String str2;
        Intrinsics.h(tag, "tag");
        Intrinsics.h(message, "message");
        if (str != null) {
            if (str.length() <= 0) {
                str = null;
            }
            if (str != null) {
                String str3 = "sceneId=" + str + ", " + message;
                if (str3 != null) {
                    str2 = str3;
                    a.C0856a.l(lg.a.f68962a, a(tag), str2, false, 4, null);
                }
            }
        }
        str2 = message;
        a.C0856a.l(lg.a.f68962a, a(tag), str2, false, 4, null);
    }

    public final void f(String tag, String message, String str) {
        Intrinsics.h(tag, "tag");
        Intrinsics.h(message, "message");
        if (str != null) {
            if (str.length() <= 0) {
                str = null;
            }
            if (str != null) {
                String str2 = "sceneId=" + str + ", " + message;
                if (str2 != null) {
                    message = str2;
                }
            }
        }
        a.C0856a.r(lg.a.f68962a, a(tag), new String[]{message}, false, 4, null);
    }
}
