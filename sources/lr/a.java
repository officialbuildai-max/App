package lr;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f69143a = new a();

    private a() {
    }

    private final String a(String str, String str2) {
        qs.b h11;
        String a11;
        rs.a c11 = c.f69154a.c();
        return (c11 == null || (h11 = c11.h()) == null || (a11 = h11.a(str, str2)) == null) ? str2 : a11;
    }

    static /* synthetic */ String b(a aVar, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        return aVar.a(str, str2);
    }

    public final boolean c() {
        return !Intrinsics.c(b(this, "short_tv_optimize_enable", null, 2, null), "false");
    }
}
