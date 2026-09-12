package pg;

import com.tn.lib.net.cons.HeaderType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f72573a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f72574b;

    /* renamed from: c, reason: collision with root package name */
    private String f72575c = "";

    /* renamed from: d, reason: collision with root package name */
    private HeaderType f72576d = HeaderType.ONE_ROOM;

    /* renamed from: e, reason: collision with root package name */
    private long f72577e;

    public final HeaderType a() {
        return this.f72576d;
    }

    public final String b() {
        return this.f72575c;
    }

    public final boolean c() {
        return this.f72573a;
    }

    public final boolean d() {
        return this.f72574b;
    }

    public final void e(boolean z10) {
        this.f72573a = z10;
    }

    public final void f(boolean z10) {
        this.f72574b = z10;
    }

    public final void g(long j11) {
        this.f72577e = j11;
    }

    public final void h(String str) {
        Intrinsics.h(str, "<set-?>");
        this.f72575c = str;
    }
}
