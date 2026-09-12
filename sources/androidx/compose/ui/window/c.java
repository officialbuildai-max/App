package androidx.compose.ui.window;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f6633a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f6634b;

    /* renamed from: c, reason: collision with root package name */
    private final SecureFlagPolicy f6635c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f6636d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f6637e;

    public c() {
        this(false, false, null, false, false, 31, null);
    }

    public c(boolean z10, boolean z11, SecureFlagPolicy secureFlagPolicy, boolean z12, boolean z13) {
        this.f6633a = z10;
        this.f6634b = z11;
        this.f6635c = secureFlagPolicy;
        this.f6636d = z12;
        this.f6637e = z13;
    }

    public /* synthetic */ c(boolean z10, boolean z11, SecureFlagPolicy secureFlagPolicy, boolean z12, boolean z13, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? true : z10, (i11 & 2) != 0 ? true : z11, (i11 & 4) != 0 ? SecureFlagPolicy.Inherit : secureFlagPolicy, (i11 & 8) != 0 ? true : z12, (i11 & 16) != 0 ? true : z13);
    }

    public c(boolean z10, boolean z11, boolean z12) {
        this(z10, z11, SecureFlagPolicy.Inherit, z12, true);
    }

    public /* synthetic */ c(boolean z10, boolean z11, boolean z12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? true : z10, (i11 & 2) != 0 ? true : z11, (i11 & 4) != 0 ? true : z12);
    }

    public final boolean a() {
        return this.f6637e;
    }

    public final boolean b() {
        return this.f6633a;
    }

    public final boolean c() {
        return this.f6634b;
    }

    public final SecureFlagPolicy d() {
        return this.f6635c;
    }

    public final boolean e() {
        return this.f6636d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f6633a == cVar.f6633a && this.f6634b == cVar.f6634b && this.f6635c == cVar.f6635c && this.f6636d == cVar.f6636d && this.f6637e == cVar.f6637e;
    }

    public int hashCode() {
        return (((((((androidx.compose.foundation.e.a(this.f6633a) * 31) + androidx.compose.foundation.e.a(this.f6634b)) * 31) + this.f6635c.hashCode()) * 31) + androidx.compose.foundation.e.a(this.f6636d)) * 31) + androidx.compose.foundation.e.a(this.f6637e);
    }
}
