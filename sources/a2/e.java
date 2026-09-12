package a2;

import java.util.Objects;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f148a;

    /* renamed from: b, reason: collision with root package name */
    public final String f149b;

    /* renamed from: c, reason: collision with root package name */
    public final String f150c;

    public e(String str, String str2, String str3) {
        this.f148a = str;
        this.f149b = str2;
        this.f150c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return Objects.equals(this.f148a, eVar.f148a) && Objects.equals(this.f149b, eVar.f149b) && Objects.equals(this.f150c, eVar.f150c);
    }

    public int hashCode() {
        int hashCode = this.f148a.hashCode() * 31;
        String str = this.f149b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f150c;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }
}
