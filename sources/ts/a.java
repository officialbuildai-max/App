package ts;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f76474a;

    /* renamed from: b, reason: collision with root package name */
    private final String f76475b;

    /* renamed from: c, reason: collision with root package name */
    private final String f76476c;

    /* renamed from: d, reason: collision with root package name */
    private final String f76477d;

    /* renamed from: e, reason: collision with root package name */
    private final String f76478e;

    /* renamed from: f, reason: collision with root package name */
    private final int f76479f;

    /* renamed from: g, reason: collision with root package name */
    private final int f76480g;

    /* renamed from: h, reason: collision with root package name */
    private final String f76481h;

    public a(String str, String subtitleResId, String str2, String str3, String str4, int i11, int i12, String str5) {
        Intrinsics.h(subtitleResId, "subtitleResId");
        this.f76474a = str;
        this.f76475b = subtitleResId;
        this.f76476c = str2;
        this.f76477d = str3;
        this.f76478e = str4;
        this.f76479f = i11;
        this.f76480g = i12;
        this.f76481h = str5;
    }

    public final int a() {
        return this.f76479f;
    }

    public final String b() {
        return this.f76481h;
    }

    public final int c() {
        return this.f76480g;
    }

    public final String d() {
        return this.f76478e;
    }

    public final String e() {
        return this.f76474a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.f76474a, aVar.f76474a) && Intrinsics.c(this.f76475b, aVar.f76475b) && Intrinsics.c(this.f76476c, aVar.f76476c) && Intrinsics.c(this.f76477d, aVar.f76477d) && Intrinsics.c(this.f76478e, aVar.f76478e) && this.f76479f == aVar.f76479f && this.f76480g == aVar.f76480g && Intrinsics.c(this.f76481h, aVar.f76481h);
    }

    public final String f() {
        return this.f76476c;
    }

    public final String g() {
        return this.f76475b;
    }

    public final String h() {
        return this.f76477d;
    }

    public int hashCode() {
        String str = this.f76474a;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.f76475b.hashCode()) * 31;
        String str2 = this.f76476c;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f76477d;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f76478e;
        int hashCode4 = (((((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.f76479f) * 31) + this.f76480g) * 31;
        String str5 = this.f76481h;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "ShortTvSubDownloadBean(subjectId=" + this.f76474a + ", subtitleResId=" + this.f76475b + ", subjectName=" + this.f76476c + ", titleName=" + this.f76477d + ", shorTvId=" + this.f76478e + ", ep=" + this.f76479f + ", se=" + this.f76480g + ", ops=" + this.f76481h + ")";
    }
}
