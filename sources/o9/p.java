package o9;

import com.google.android.exoplayer2.util.s;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g9.e0;

/* loaded from: classes4.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f71010a;

    /* renamed from: b, reason: collision with root package name */
    public final String f71011b;

    /* renamed from: c, reason: collision with root package name */
    public final e0.a f71012c;

    /* renamed from: d, reason: collision with root package name */
    public final int f71013d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f71014e;

    public p(boolean z10, String str, int i11, byte[] bArr, int i12, int i13, byte[] bArr2) {
        com.google.android.exoplayer2.util.a.a((bArr2 == null) ^ (i11 == 0));
        this.f71010a = z10;
        this.f71011b = str;
        this.f71013d = i11;
        this.f71014e = bArr2;
        this.f71012c = new e0.a(a(str), bArr, i12, i13);
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
                s.i("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
            case 2:
            case 3:
                return 1;
        }
    }
}
