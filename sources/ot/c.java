package ot;

import androidx.compose.foundation.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final String f72223a;

    /* renamed from: b, reason: collision with root package name */
    private final int f72224b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f72225c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f72226d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f72227e;

    public c(String subjectId, int i11, boolean z10, boolean z11, boolean z12) {
        Intrinsics.h(subjectId, "subjectId");
        this.f72223a = subjectId;
        this.f72224b = i11;
        this.f72225c = z10;
        this.f72226d = z11;
        this.f72227e = z12;
    }

    public /* synthetic */ c(String str, int i11, boolean z10, boolean z11, boolean z12, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i11, (i12 & 4) != 0 ? false : z10, (i12 & 8) != 0 ? false : z11, (i12 & 16) != 0 ? false : z12);
    }

    public final int a() {
        return this.f72224b;
    }

    public final boolean b() {
        return this.f72227e;
    }

    public final boolean c() {
        return this.f72225c;
    }

    public final boolean d() {
        return this.f72226d;
    }

    public final void e(boolean z10) {
        this.f72225c = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.c(this.f72223a, cVar.f72223a) && this.f72224b == cVar.f72224b && this.f72225c == cVar.f72225c && this.f72226d == cVar.f72226d && this.f72227e == cVar.f72227e;
    }

    public final void f(boolean z10) {
        this.f72226d = z10;
    }

    public int hashCode() {
        return (((((((this.f72223a.hashCode() * 31) + this.f72224b) * 31) + e.a(this.f72225c)) * 31) + e.a(this.f72226d)) * 31) + e.a(this.f72227e);
    }

    public String toString() {
        return "ShortTvDownloadEpisodeSelectItem(subjectId=" + this.f72223a + ", position=" + this.f72224b + ", isFree=" + this.f72225c + ", isSelect=" + this.f72226d + ", isDownload=" + this.f72227e + ")";
    }
}
