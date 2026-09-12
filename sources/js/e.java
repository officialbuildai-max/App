package js;

import com.transsion.shorttv.bean.ShortTVItem;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class e extends k {

    /* renamed from: a, reason: collision with root package name */
    private final String f66386a;

    /* renamed from: b, reason: collision with root package name */
    private final int f66387b;

    /* renamed from: c, reason: collision with root package name */
    private ShortTVItem f66388c;

    /* renamed from: d, reason: collision with root package name */
    private int f66389d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String subjectId, int i11, ShortTVItem shortTVItem, int i12) {
        super(null);
        Intrinsics.h(subjectId, "subjectId");
        this.f66386a = subjectId;
        this.f66387b = i11;
        this.f66388c = shortTVItem;
        this.f66389d = i12;
    }

    public /* synthetic */ e(String str, int i11, ShortTVItem shortTVItem, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i11, (i13 & 4) != 0 ? null : shortTVItem, (i13 & 8) != 0 ? 0 : i12);
    }

    public final String a() {
        return "shorttv_ad_" + this.f66386a + "_" + this.f66387b;
    }

    public final int b() {
        return this.f66389d;
    }

    public final int c() {
        return this.f66387b;
    }

    public final ShortTVItem d() {
        return this.f66388c;
    }

    public final String e() {
        return this.f66386a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.c(e.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.f(obj, "null cannot be cast to non-null type com.transsion.shorttv.bean.ShortTvEpisodeSelectItem");
        e eVar = (e) obj;
        return Intrinsics.c(this.f66386a, eVar.f66386a) && this.f66387b == eVar.f66387b;
    }

    public final String f() {
        return this.f66386a + "_" + this.f66387b + "short";
    }

    public final void g(int i11) {
        this.f66389d = i11;
    }

    public final void h(ShortTVItem shortTVItem) {
        this.f66388c = shortTVItem;
    }

    public int hashCode() {
        return (this.f66386a.hashCode() * 31) + this.f66387b;
    }

    public String toString() {
        return "ShortTvEpisodeSelectItem(subjectId=" + this.f66386a + ", ep=" + this.f66387b + ", item=" + this.f66388c + ", downloadStatus=" + this.f66389d + ")";
    }
}
