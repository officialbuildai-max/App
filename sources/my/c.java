package my;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final String f70156a;

    /* renamed from: b, reason: collision with root package name */
    private final int f70157b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f70158c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f70159d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f70160e;

    public c(String subjectId, int i11, boolean z10, boolean z11, boolean z12) {
        Intrinsics.h(subjectId, "subjectId");
        this.f70156a = subjectId;
        this.f70157b = i11;
        this.f70158c = z10;
        this.f70159d = z11;
        this.f70160e = z12;
    }

    public /* synthetic */ c(String str, int i11, boolean z10, boolean z11, boolean z12, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i11, (i12 & 4) != 0 ? false : z10, (i12 & 8) != 0 ? false : z11, (i12 & 16) != 0 ? false : z12);
    }

    public final int a() {
        return this.f70157b;
    }

    public final boolean b() {
        return this.f70160e;
    }

    public final boolean c() {
        return this.f70158c;
    }

    public final boolean d() {
        return this.f70159d;
    }

    public final void e(boolean z10) {
        this.f70160e = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.c(this.f70156a, cVar.f70156a) && this.f70157b == cVar.f70157b && this.f70158c == cVar.f70158c && this.f70159d == cVar.f70159d && this.f70160e == cVar.f70160e;
    }

    public final void f(boolean z10) {
        this.f70158c = z10;
    }

    public final void g(boolean z10) {
        this.f70159d = z10;
    }

    public int hashCode() {
        return (((((((this.f70156a.hashCode() * 31) + this.f70157b) * 31) + androidx.compose.foundation.e.a(this.f70158c)) * 31) + androidx.compose.foundation.e.a(this.f70159d)) * 31) + androidx.compose.foundation.e.a(this.f70160e);
    }

    public String toString() {
        return "DownloadShortTVEpisodeSelectItem(subjectId=" + this.f70156a + ", position=" + this.f70157b + ", isFree=" + this.f70158c + ", isSelect=" + this.f70159d + ", isDownload=" + this.f70160e + ")";
    }
}
