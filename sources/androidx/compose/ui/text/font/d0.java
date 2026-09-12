package androidx.compose.ui.text.font;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    private final h f6188a;

    /* renamed from: b, reason: collision with root package name */
    private final p f6189b;

    /* renamed from: c, reason: collision with root package name */
    private final int f6190c;

    /* renamed from: d, reason: collision with root package name */
    private final int f6191d;

    /* renamed from: e, reason: collision with root package name */
    private final Object f6192e;

    private d0(h hVar, p pVar, int i11, int i12, Object obj) {
        this.f6188a = hVar;
        this.f6189b = pVar;
        this.f6190c = i11;
        this.f6191d = i12;
        this.f6192e = obj;
    }

    public /* synthetic */ d0(h hVar, p pVar, int i11, int i12, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(hVar, pVar, i11, i12, obj);
    }

    public static /* synthetic */ d0 b(d0 d0Var, h hVar, p pVar, int i11, int i12, Object obj, int i13, Object obj2) {
        if ((i13 & 1) != 0) {
            hVar = d0Var.f6188a;
        }
        if ((i13 & 2) != 0) {
            pVar = d0Var.f6189b;
        }
        p pVar2 = pVar;
        if ((i13 & 4) != 0) {
            i11 = d0Var.f6190c;
        }
        int i14 = i11;
        if ((i13 & 8) != 0) {
            i12 = d0Var.f6191d;
        }
        int i15 = i12;
        if ((i13 & 16) != 0) {
            obj = d0Var.f6192e;
        }
        return d0Var.a(hVar, pVar2, i14, i15, obj);
    }

    public final d0 a(h hVar, p pVar, int i11, int i12, Object obj) {
        return new d0(hVar, pVar, i11, i12, obj, null);
    }

    public final h c() {
        return this.f6188a;
    }

    public final int d() {
        return this.f6190c;
    }

    public final p e() {
        return this.f6189b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return Intrinsics.c(this.f6188a, d0Var.f6188a) && Intrinsics.c(this.f6189b, d0Var.f6189b) && n.f(this.f6190c, d0Var.f6190c) && o.h(this.f6191d, d0Var.f6191d) && Intrinsics.c(this.f6192e, d0Var.f6192e);
    }

    public int hashCode() {
        h hVar = this.f6188a;
        int hashCode = (((((((hVar == null ? 0 : hVar.hashCode()) * 31) + this.f6189b.hashCode()) * 31) + n.g(this.f6190c)) * 31) + o.i(this.f6191d)) * 31;
        Object obj = this.f6192e;
        return hashCode + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        return "TypefaceRequest(fontFamily=" + this.f6188a + ", fontWeight=" + this.f6189b + ", fontStyle=" + ((Object) n.h(this.f6190c)) + ", fontSynthesis=" + ((Object) o.j(this.f6191d)) + ", resourceLoaderCacheKey=" + this.f6192e + ')';
    }
}
