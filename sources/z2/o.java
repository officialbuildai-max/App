package z2;

import java.util.Objects;

/* loaded from: classes2.dex */
public final class o extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f79330b;

    /* renamed from: c, reason: collision with root package name */
    public final String f79331c;

    public o(String str, String str2, String str3) {
        super(str);
        this.f79330b = str2;
        this.f79331c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        return this.f79315a.equals(oVar.f79315a) && Objects.equals(this.f79330b, oVar.f79330b) && Objects.equals(this.f79331c, oVar.f79331c);
    }

    public int hashCode() {
        int hashCode = (527 + this.f79315a.hashCode()) * 31;
        String str = this.f79330b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f79331c;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // z2.i
    public String toString() {
        return this.f79315a + ": url=" + this.f79331c;
    }
}
