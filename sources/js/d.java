package js;

import com.transsion.shorttv.bean.ShortTVItem;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final String f66381a;

    /* renamed from: b, reason: collision with root package name */
    private final int f66382b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f66383c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f66384d;

    /* renamed from: e, reason: collision with root package name */
    private ShortTVItem f66385e;

    public d(String subjectId, int i11, boolean z10, boolean z11, ShortTVItem shortTVItem) {
        Intrinsics.h(subjectId, "subjectId");
        this.f66381a = subjectId;
        this.f66382b = i11;
        this.f66383c = z10;
        this.f66384d = z11;
        this.f66385e = shortTVItem;
    }

    public /* synthetic */ d(String str, int i11, boolean z10, boolean z11, ShortTVItem shortTVItem, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i11, (i12 & 4) != 0 ? false : z10, (i12 & 8) != 0 ? false : z11, (i12 & 16) != 0 ? null : shortTVItem);
    }

    public final ShortTVItem a() {
        return this.f66385e;
    }

    public final int b() {
        return this.f66382b;
    }

    public final boolean c() {
        return this.f66384d;
    }

    public final boolean d() {
        return this.f66383c;
    }

    public final void e(boolean z10) {
        this.f66384d = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.c(this.f66381a, dVar.f66381a) && this.f66382b == dVar.f66382b && this.f66383c == dVar.f66383c && this.f66384d == dVar.f66384d && Intrinsics.c(this.f66385e, dVar.f66385e);
    }

    public final void f(ShortTVItem shortTVItem) {
        this.f66385e = shortTVItem;
    }

    public final void g(boolean z10) {
        this.f66383c = z10;
    }

    public int hashCode() {
        int hashCode = ((((((this.f66381a.hashCode() * 31) + this.f66382b) * 31) + androidx.compose.foundation.e.a(this.f66383c)) * 31) + androidx.compose.foundation.e.a(this.f66384d)) * 31;
        ShortTVItem shortTVItem = this.f66385e;
        return hashCode + (shortTVItem == null ? 0 : shortTVItem.hashCode());
    }

    public String toString() {
        return "ShortTvDownloadEpisodeSelectItem(subjectId=" + this.f66381a + ", position=" + this.f66382b + ", isSelect=" + this.f66383c + ", isDownload=" + this.f66384d + ", episodeItem=" + this.f66385e + ")";
    }
}
