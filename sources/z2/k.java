package z2;

import java.util.Objects;

/* loaded from: classes2.dex */
public final class k extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f79317b;

    /* renamed from: c, reason: collision with root package name */
    public final String f79318c;

    /* renamed from: d, reason: collision with root package name */
    public final String f79319d;

    public k(String str, String str2, String str3) {
        super("----");
        this.f79317b = str;
        this.f79318c = str2;
        this.f79319d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return Objects.equals(this.f79318c, kVar.f79318c) && Objects.equals(this.f79317b, kVar.f79317b) && Objects.equals(this.f79319d, kVar.f79319d);
    }

    public int hashCode() {
        String str = this.f79317b;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f79318c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f79319d;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // z2.i
    public String toString() {
        return this.f79315a + ": domain=" + this.f79317b + ", description=" + this.f79318c;
    }
}
