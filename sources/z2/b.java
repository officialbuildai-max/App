package z2;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class b extends i {

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f79291b;

    public b(String str, byte[] bArr) {
        super(str);
        this.f79291b = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f79315a.equals(bVar.f79315a) && Arrays.equals(this.f79291b, bVar.f79291b);
    }

    public int hashCode() {
        return ((527 + this.f79315a.hashCode()) * 31) + Arrays.hashCode(this.f79291b);
    }
}
