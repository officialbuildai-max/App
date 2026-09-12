package g9;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;

/* loaded from: classes4.dex */
public abstract class s {

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public long f63578a;
    }

    private static boolean a(com.google.android.exoplayer2.util.d0 d0Var, v vVar, int i11) {
        int j11 = j(d0Var, i11);
        return j11 != -1 && j11 <= vVar.f63583b;
    }

    private static boolean b(com.google.android.exoplayer2.util.d0 d0Var, int i11) {
        return d0Var.D() == p0.u(d0Var.d(), i11, d0Var.e() - 1, 0);
    }

    private static boolean c(com.google.android.exoplayer2.util.d0 d0Var, v vVar, boolean z10, a aVar) {
        try {
            long K = d0Var.K();
            if (!z10) {
                K *= vVar.f63583b;
            }
            aVar.f63578a = K;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean d(com.google.android.exoplayer2.util.d0 d0Var, v vVar, int i11, a aVar) {
        int e11 = d0Var.e();
        long F = d0Var.F();
        long j11 = F >>> 16;
        if (j11 != i11) {
            return false;
        }
        return g((int) ((F >> 4) & 15), vVar) && f((int) ((F >> 1) & 7), vVar) && !(((F & 1) > 1L ? 1 : ((F & 1) == 1L ? 0 : -1)) == 0) && c(d0Var, vVar, ((j11 & 1) > 1L ? 1 : ((j11 & 1) == 1L ? 0 : -1)) == 0, aVar) && a(d0Var, vVar, (int) ((F >> 12) & 15)) && e(d0Var, vVar, (int) ((F >> 8) & 15)) && b(d0Var, e11);
    }

    private static boolean e(com.google.android.exoplayer2.util.d0 d0Var, v vVar, int i11) {
        int i12 = vVar.f63586e;
        if (i11 == 0) {
            return true;
        }
        if (i11 <= 11) {
            return i11 == vVar.f63587f;
        }
        if (i11 == 12) {
            return d0Var.D() * 1000 == i12;
        }
        if (i11 > 14) {
            return false;
        }
        int J = d0Var.J();
        if (i11 == 14) {
            J *= 10;
        }
        return J == i12;
    }

    private static boolean f(int i11, v vVar) {
        return i11 == 0 || i11 == vVar.f63590i;
    }

    private static boolean g(int i11, v vVar) {
        return i11 <= 7 ? i11 == vVar.f63588g - 1 : i11 <= 10 && vVar.f63588g == 2;
    }

    public static boolean h(m mVar, v vVar, int i11, a aVar) {
        long peekPosition = mVar.getPeekPosition();
        byte[] bArr = new byte[2];
        mVar.peekFully(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i11) {
            mVar.resetPeekPosition();
            mVar.advancePeekPosition((int) (peekPosition - mVar.getPosition()));
            return false;
        }
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(16);
        System.arraycopy(bArr, 0, d0Var.d(), 0, 2);
        d0Var.O(o.c(mVar, d0Var.d(), 2, 14));
        mVar.resetPeekPosition();
        mVar.advancePeekPosition((int) (peekPosition - mVar.getPosition()));
        return d(d0Var, vVar, i11, aVar);
    }

    public static long i(m mVar, v vVar) {
        mVar.resetPeekPosition();
        mVar.advancePeekPosition(1);
        byte[] bArr = new byte[1];
        mVar.peekFully(bArr, 0, 1);
        boolean z10 = (bArr[0] & 1) == 1;
        mVar.advancePeekPosition(2);
        int i11 = z10 ? 7 : 6;
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(i11);
        d0Var.O(o.c(mVar, d0Var.d(), 0, i11));
        mVar.resetPeekPosition();
        a aVar = new a();
        if (c(d0Var, vVar, z10, aVar)) {
            return aVar.f63578a;
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public static int j(com.google.android.exoplayer2.util.d0 d0Var, int i11) {
        switch (i11) {
            case 1:
                return PsExtractor.AUDIO_STREAM;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i11 - 2);
            case 6:
                return d0Var.D() + 1;
            case 7:
                return d0Var.J() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i11 - 8);
            default:
                return -1;
        }
    }
}
