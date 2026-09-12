package a2;

import java.util.Objects;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f161a;

    /* renamed from: b, reason: collision with root package name */
    public final String f162b;

    /* renamed from: c, reason: collision with root package name */
    public final String f163c;

    /* renamed from: d, reason: collision with root package name */
    public final String f164d;

    /* renamed from: e, reason: collision with root package name */
    public final String f165e;

    public h(String str, String str2, String str3, String str4, String str5) {
        this.f161a = str;
        this.f162b = str2;
        this.f163c = str3;
        this.f164d = str4;
        this.f165e = str5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Objects.equals(this.f161a, hVar.f161a) && Objects.equals(this.f162b, hVar.f162b) && Objects.equals(this.f163c, hVar.f163c) && Objects.equals(this.f164d, hVar.f164d) && Objects.equals(this.f165e, hVar.f165e);
    }

    public int hashCode() {
        String str = this.f161a;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f162b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f163c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f164d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f165e;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }
}
