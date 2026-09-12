package x9;

import com.google.android.exoplayer2.util.p0;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f78224a;

    /* renamed from: b, reason: collision with root package name */
    public final String f78225b;

    /* renamed from: c, reason: collision with root package name */
    public final String f78226c;

    /* renamed from: d, reason: collision with root package name */
    public final String f78227d;

    /* renamed from: e, reason: collision with root package name */
    public final String f78228e;

    public h(String str, String str2, String str3, String str4, String str5) {
        this.f78224a = str;
        this.f78225b = str2;
        this.f78226c = str3;
        this.f78227d = str4;
        this.f78228e = str5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return p0.c(this.f78224a, hVar.f78224a) && p0.c(this.f78225b, hVar.f78225b) && p0.c(this.f78226c, hVar.f78226c) && p0.c(this.f78227d, hVar.f78227d) && p0.c(this.f78228e, hVar.f78228e);
    }

    public int hashCode() {
        String str = this.f78224a;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f78225b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f78226c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f78227d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f78228e;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }
}
