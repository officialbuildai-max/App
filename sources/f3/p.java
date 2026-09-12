package f3;

import androidx.media3.common.util.j0;
import java.nio.ByteBuffer;
import java.util.UUID;

/* loaded from: classes2.dex */
public abstract class p {

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final UUID f62401a;

        /* renamed from: b, reason: collision with root package name */
        public final int f62402b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f62403c;

        /* renamed from: d, reason: collision with root package name */
        public final UUID[] f62404d;

        a(UUID uuid, int i11, byte[] bArr, UUID[] uuidArr) {
            this.f62401a = uuid;
            this.f62402b = i11;
            this.f62403c = bArr;
            this.f62404d = uuidArr;
        }
    }

    public static byte[] a(UUID uuid, byte[] bArr) {
        return b(uuid, null, bArr);
    }

    public static byte[] b(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(1886614376);
        allocate.putInt(uuidArr != null ? 16777216 : 0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            allocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                allocate.putLong(uuid2.getMostSignificantBits());
                allocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr == null || bArr.length == 0) {
            allocate.putInt(0);
        } else {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    public static boolean c(byte[] bArr) {
        return d(bArr) != null;
    }

    public static a d(byte[] bArr) {
        UUID[] uuidArr;
        j0 j0Var = new j0(bArr);
        if (j0Var.g() < 32) {
            return null;
        }
        j0Var.W(0);
        int a11 = j0Var.a();
        int q11 = j0Var.q();
        if (q11 != a11) {
            androidx.media3.common.util.u.h("PsshAtomUtil", "Advertised atom size (" + q11 + ") does not match buffer size: " + a11);
            return null;
        }
        int q12 = j0Var.q();
        if (q12 != 1886614376) {
            androidx.media3.common.util.u.h("PsshAtomUtil", "Atom type is not pssh: " + q12);
            return null;
        }
        int p11 = b.p(j0Var.q());
        if (p11 > 1) {
            androidx.media3.common.util.u.h("PsshAtomUtil", "Unsupported pssh version: " + p11);
            return null;
        }
        UUID uuid = new UUID(j0Var.A(), j0Var.A());
        if (p11 == 1) {
            int L = j0Var.L();
            uuidArr = new UUID[L];
            for (int i11 = 0; i11 < L; i11++) {
                uuidArr[i11] = new UUID(j0Var.A(), j0Var.A());
            }
        } else {
            uuidArr = null;
        }
        int L2 = j0Var.L();
        int a12 = j0Var.a();
        if (L2 == a12) {
            byte[] bArr2 = new byte[L2];
            j0Var.l(bArr2, 0, L2);
            return new a(uuid, p11, bArr2, uuidArr);
        }
        androidx.media3.common.util.u.h("PsshAtomUtil", "Atom data size (" + L2 + ") does not match the bytes left: " + a12);
        return null;
    }

    public static byte[] e(byte[] bArr, UUID uuid) {
        a d11 = d(bArr);
        if (d11 == null) {
            return null;
        }
        if (uuid.equals(d11.f62401a)) {
            return d11.f62403c;
        }
        androidx.media3.common.util.u.h("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + d11.f62401a + ".");
        return null;
    }

    public static UUID f(byte[] bArr) {
        a d11 = d(bArr);
        if (d11 == null) {
            return null;
        }
        return d11.f62401a;
    }

    public static int g(byte[] bArr) {
        a d11 = d(bArr);
        if (d11 == null) {
            return -1;
        }
        return d11.f62402b;
    }
}
