package o9;

import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;
import java.nio.ByteBuffer;
import java.util.UUID;

/* loaded from: classes4.dex */
public abstract class l {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final UUID f70987a;

        /* renamed from: b, reason: collision with root package name */
        private final int f70988b;

        /* renamed from: c, reason: collision with root package name */
        private final byte[] f70989c;

        public a(UUID uuid, int i11, byte[] bArr) {
            this.f70987a = uuid;
            this.f70988b = i11;
            this.f70989c = bArr;
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
        if (bArr != null && bArr.length != 0) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    public static boolean c(byte[] bArr) {
        return d(bArr) != null;
    }

    private static a d(byte[] bArr) {
        d0 d0Var = new d0(bArr);
        if (d0Var.f() < 32) {
            return null;
        }
        d0Var.P(0);
        if (d0Var.n() != d0Var.a() + 4 || d0Var.n() != 1886614376) {
            return null;
        }
        int c11 = o9.a.c(d0Var.n());
        if (c11 > 1) {
            s.i("PsshAtomUtil", "Unsupported pssh version: " + c11);
            return null;
        }
        UUID uuid = new UUID(d0Var.w(), d0Var.w());
        if (c11 == 1) {
            d0Var.Q(d0Var.H() * 16);
        }
        int H = d0Var.H();
        if (H != d0Var.a()) {
            return null;
        }
        byte[] bArr2 = new byte[H];
        d0Var.j(bArr2, 0, H);
        return new a(uuid, c11, bArr2);
    }

    public static byte[] e(byte[] bArr, UUID uuid) {
        a d11 = d(bArr);
        if (d11 == null) {
            return null;
        }
        if (uuid.equals(d11.f70987a)) {
            return d11.f70989c;
        }
        s.i("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + d11.f70987a + ".");
        return null;
    }

    public static UUID f(byte[] bArr) {
        a d11 = d(bArr);
        if (d11 == null) {
            return null;
        }
        return d11.f70987a;
    }

    public static int g(byte[] bArr) {
        a d11 = d(bArr);
        if (d11 == null) {
            return -1;
        }
        return d11.f70988b;
    }
}
