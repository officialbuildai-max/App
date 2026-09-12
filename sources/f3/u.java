package f3;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import l2.s0;

/* loaded from: classes2.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f62426a;

    /* renamed from: b, reason: collision with root package name */
    public final String f62427b;

    /* renamed from: c, reason: collision with root package name */
    public final s0.a f62428c;

    /* renamed from: d, reason: collision with root package name */
    public final int f62429d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f62430e;

    public u(boolean z10, String str, int i11, byte[] bArr, int i12, int i13, byte[] bArr2) {
        androidx.media3.common.util.a.a((bArr2 == null) ^ (i11 == 0));
        this.f62426a = z10;
        this.f62427b = str;
        this.f62429d = i11;
        this.f62430e = bArr2;
        this.f62428c = new s0.a(a(str), bArr, i12, i13);
    }

    private static int a(String str) {
        if (str == null) {
            return 1;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals(C.CENC_TYPE_cbc1)) {
                    c11 = 0;
                    break;
                }
                break;
            case 3046671:
                if (str.equals(C.CENC_TYPE_cbcs)) {
                    c11 = 1;
                    break;
                }
                break;
            case 3049879:
                if (str.equals(C.CENC_TYPE_cenc)) {
                    c11 = 2;
                    break;
                }
                break;
            case 3049895:
                if (str.equals(C.CENC_TYPE_cens)) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
                return 2;
            default:
                androidx.media3.common.util.u.h("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
            case 2:
            case 3:
                return 1;
        }
    }
}
