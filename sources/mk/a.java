package mk;

import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.bean.GameInfoType;
import com.transsion.commercialization.gameres.aha.c;
import kotlin.jvm.internal.Intrinsics;
import oh.b;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final GameInfoType f69736a;

    /* renamed from: b, reason: collision with root package name */
    private final RecommendInfo f69737b;

    /* renamed from: c, reason: collision with root package name */
    private final c f69738c;

    /* renamed from: d, reason: collision with root package name */
    private transient String f69739d;

    /* renamed from: e, reason: collision with root package name */
    private transient String f69740e;

    /* renamed from: mk.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public /* synthetic */ class C0868a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f69741a;

        static {
            int[] iArr = new int[GameInfoType.values().length];
            try {
                iArr[GameInfoType.AHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GameInfoType.PS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f69741a = iArr;
        }
    }

    public a(GameInfoType type, RecommendInfo recommendInfo, c cVar) {
        Intrinsics.h(type, "type");
        this.f69736a = type;
        this.f69737b = recommendInfo;
        this.f69738c = cVar;
    }

    public final c a() {
        return this.f69738c;
    }

    public final String b() {
        String categoryName;
        RecommendInfo recommendInfo = this.f69737b;
        if (recommendInfo != null && (categoryName = recommendInfo.getCategoryName()) != null) {
            return categoryName;
        }
        c cVar = this.f69738c;
        String b11 = cVar != null ? cVar.b() : null;
        return b11 == null ? "" : b11;
    }

    public final String c() {
        String iconUrl;
        RecommendInfo recommendInfo = this.f69737b;
        if (recommendInfo != null && (iconUrl = recommendInfo.getIconUrl()) != null) {
            return iconUrl;
        }
        c cVar = this.f69738c;
        String c11 = cVar != null ? cVar.c() : null;
        return c11 == null ? "" : c11;
    }

    public final String d() {
        String name;
        RecommendInfo recommendInfo = this.f69737b;
        if (recommendInfo != null && (name = recommendInfo.getName()) != null) {
            return name;
        }
        c cVar = this.f69738c;
        String f11 = cVar != null ? cVar.f() : null;
        return f11 == null ? "" : f11;
    }

    public final String e() {
        String d11;
        int i11 = C0868a.f69741a[this.f69736a.ordinal()];
        if (i11 == 1) {
            c cVar = this.f69738c;
            return (cVar == null || (d11 = cVar.d()) == null) ? "" : d11;
        }
        if (i11 != 2) {
            return "";
        }
        RecommendInfo recommendInfo = this.f69737b;
        if ((recommendInfo != null ? recommendInfo.getSize() : 0L) <= 0) {
            return "";
        }
        RecommendInfo recommendInfo2 = this.f69737b;
        return b.a(recommendInfo2 != null ? recommendInfo2.getSize() : 0L, 1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f69736a == aVar.f69736a && Intrinsics.c(this.f69737b, aVar.f69737b) && Intrinsics.c(this.f69738c, aVar.f69738c);
    }

    public final String f() {
        Double e11;
        String star;
        RecommendInfo recommendInfo = this.f69737b;
        if (recommendInfo != null && (star = recommendInfo.getStar()) != null) {
            return star;
        }
        c cVar = this.f69738c;
        return (cVar == null || (e11 = cVar.e()) == null) ? "" : e11.toString();
    }

    public final String g() {
        return this.f69740e;
    }

    public final String h() {
        return this.f69739d;
    }

    public int hashCode() {
        int hashCode = this.f69736a.hashCode() * 31;
        RecommendInfo recommendInfo = this.f69737b;
        int hashCode2 = (hashCode + (recommendInfo == null ? 0 : recommendInfo.hashCode())) * 31;
        c cVar = this.f69738c;
        return hashCode2 + (cVar != null ? cVar.hashCode() : 0);
    }

    public final RecommendInfo i() {
        return this.f69737b;
    }

    public final GameInfoType j() {
        return this.f69736a;
    }

    public final void k(String str) {
        this.f69740e = str;
    }

    public final void l(String str) {
        this.f69739d = str;
    }

    public String toString() {
        return "GameResInfo(type=" + this.f69736a + ", psInfo=" + this.f69737b + ", ahaInfo=" + this.f69738c + ")";
    }
}
