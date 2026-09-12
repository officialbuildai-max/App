package z2;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class f extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f79306b;

    /* renamed from: c, reason: collision with root package name */
    public final String f79307c;

    /* renamed from: d, reason: collision with root package name */
    public final String f79308d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f79309e;

    public f(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f79306b = str;
        this.f79307c = str2;
        this.f79308d = str3;
        this.f79309e = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return Objects.equals(this.f79306b, fVar.f79306b) && Objects.equals(this.f79307c, fVar.f79307c) && Objects.equals(this.f79308d, fVar.f79308d) && Arrays.equals(this.f79309e, fVar.f79309e);
    }

    public int hashCode() {
        String str = this.f79306b;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f79307c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f79308d;
        return ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.f79309e);
    }

    @Override // z2.i
    public String toString() {
        return this.f79315a + ": mimeType=" + this.f79306b + ", filename=" + this.f79307c + ", description=" + this.f79308d;
    }
}
