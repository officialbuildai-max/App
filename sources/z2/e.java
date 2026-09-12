package z2;

import java.util.Objects;

/* loaded from: classes2.dex */
public final class e extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f79303b;

    /* renamed from: c, reason: collision with root package name */
    public final String f79304c;

    /* renamed from: d, reason: collision with root package name */
    public final String f79305d;

    public e(String str, String str2, String str3) {
        super("COMM");
        this.f79303b = str;
        this.f79304c = str2;
        this.f79305d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return Objects.equals(this.f79304c, eVar.f79304c) && Objects.equals(this.f79303b, eVar.f79303b) && Objects.equals(this.f79305d, eVar.f79305d);
    }

    public int hashCode() {
        String str = this.f79303b;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f79304c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f79305d;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // z2.i
    public String toString() {
        return this.f79315a + ": language=" + this.f79303b + ", description=" + this.f79304c + ", text=" + this.f79305d;
    }
}
