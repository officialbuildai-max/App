package z2;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class m extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f79325b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f79326c;

    public m(String str, byte[] bArr) {
        super("PRIV");
        this.f79325b = str;
        this.f79326c = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return Objects.equals(this.f79325b, mVar.f79325b) && Arrays.equals(this.f79326c, mVar.f79326c);
    }

    public int hashCode() {
        String str = this.f79325b;
        return ((527 + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.f79326c);
    }

    @Override // z2.i
    public String toString() {
        return this.f79315a + ": owner=" + this.f79325b;
    }
}
