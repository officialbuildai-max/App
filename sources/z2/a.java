package z2;

import androidx.media3.common.v;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class a extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f79287b;

    /* renamed from: c, reason: collision with root package name */
    public final String f79288c;

    /* renamed from: d, reason: collision with root package name */
    public final int f79289d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f79290e;

    public a(String str, String str2, int i11, byte[] bArr) {
        super("APIC");
        this.f79287b = str;
        this.f79288c = str2;
        this.f79289d = i11;
        this.f79290e = bArr;
    }

    @Override // z2.i, androidx.media3.common.x.a
    public void a(v.b bVar) {
        bVar.K(this.f79290e, this.f79289d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f79289d == aVar.f79289d && Objects.equals(this.f79287b, aVar.f79287b) && Objects.equals(this.f79288c, aVar.f79288c) && Arrays.equals(this.f79290e, aVar.f79290e);
    }

    public int hashCode() {
        int i11 = (527 + this.f79289d) * 31;
        String str = this.f79287b;
        int hashCode = (i11 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f79288c;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f79290e);
    }

    @Override // z2.i
    public String toString() {
        return this.f79315a + ": mimeType=" + this.f79287b + ", description=" + this.f79288c;
    }
}
