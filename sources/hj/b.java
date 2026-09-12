package hj;

import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f64600a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f64601b;

    /* renamed from: c, reason: collision with root package name */
    private final HashMap f64602c;

    /* renamed from: d, reason: collision with root package name */
    private String f64603d;

    /* renamed from: e, reason: collision with root package name */
    private String f64604e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f64605f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f64606g;

    /* renamed from: h, reason: collision with root package name */
    private long f64607h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f64608i;

    /* renamed from: j, reason: collision with root package name */
    private String f64609j;

    public b(String pageName, boolean z10) {
        Intrinsics.h(pageName, "pageName");
        this.f64600a = pageName;
        this.f64601b = z10;
        this.f64602c = new HashMap();
        this.f64604e = "";
        this.f64606g = true;
        this.f64607h = -1L;
    }

    public /* synthetic */ b(String str, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? true : z10);
    }

    public final String a() {
        return this.f64603d;
    }

    public final boolean b() {
        return this.f64601b;
    }

    public final boolean c() {
        return this.f64605f;
    }

    public final boolean d() {
        return this.f64606g;
    }

    public final String e() {
        return this.f64609j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.c(this.f64600a, bVar.f64600a) && this.f64601b == bVar.f64601b;
    }

    public final String f() {
        return this.f64600a;
    }

    public final HashMap g() {
        return this.f64602c;
    }

    public final long h() {
        return this.f64607h;
    }

    public int hashCode() {
        return (this.f64600a.hashCode() * 31) + androidx.compose.foundation.e.a(this.f64601b);
    }

    public final boolean i() {
        return this.f64608i;
    }

    public final void j(String str) {
        this.f64603d = str;
    }

    public final void k(boolean z10) {
        this.f64608i = z10;
    }

    public final void l(boolean z10) {
        this.f64605f = z10;
    }

    public final void m(boolean z10) {
        this.f64606g = z10;
    }

    public final void n(String str) {
        this.f64609j = str;
    }

    public final void o(long j11) {
        this.f64607h = j11;
    }

    public String toString() {
        return "LogViewConfig(pageName=" + this.f64600a + ", needAddToPageFrom=" + this.f64601b + ')';
    }
}
