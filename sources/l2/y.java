package l2;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.a1;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;

/* loaded from: classes2.dex */
public abstract class y {

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public long f68836a;
    }

    private static boolean a(androidx.media3.common.util.j0 j0Var, b0 b0Var, int i11) {
        int j11 = j(j0Var, i11);
        return j11 != -1 && j11 <= b0Var.f68625b;
    }

    private static boolean b(androidx.media3.common.util.j0 j0Var, int i11) {
        return j0Var.H() == a1.y(j0Var.e(), i11, j0Var.f() - 1, 0);
    }

    private static boolean c(androidx.media3.common.util.j0 j0Var, b0 b0Var, boolean z10, a aVar) {
        try {
            long Q = j0Var.Q();
            if (!z10) {
                Q *= b0Var.f68625b;
            }
            aVar.f68836a = Q;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean d(androidx.media3.common.util.j0 j0Var, b0 b0Var, int i11, a aVar) {
        int f11 = j0Var.f();
        long J = j0Var.J();
        long j11 = J >>> 16;
        if (j11 != i11) {
            return false;
        }
        return g((int) ((J >> 4) & 15), b0Var) && f((int) ((J >> 1) & 7), b0Var) && !(((J & 1) > 1L ? 1 : ((J & 1) == 1L ? 0 : -1)) == 0) && c(j0Var, b0Var, ((j11 & 1) > 1L ? 1 : ((j11 & 1) == 1L ? 0 : -1)) == 0, aVar) && a(j0Var, b0Var, (int) ((J >> 12) & 15)) && e(j0Var, b0Var, (int) ((J >> 8) & 15)) && b(j0Var, f11);
    }

    private static boolean e(androidx.media3.common.util.j0 j0Var, b0 b0Var, int i11) {
        int i12 = b0Var.f68628e;
        if (i11 == 0) {
            return true;
        }
        if (i11 <= 11) {
            return i11 == b0Var.f68629f;
        }
        if (i11 == 12) {
            return j0Var.H() * 1000 == i12;
        }
        if (i11 > 14) {
            return false;
        }
        int P = j0Var.P();
        if (i11 == 14) {
            P *= 10;
        }
        return P == i12;
    }

    private static boolean f(int i11, b0 b0Var) {
        return i11 == 0 || i11 == b0Var.f68632i;
    }

    private static boolean g(int i11, b0 b0Var) {
        return i11 <= 7 ? i11 == b0Var.f68630g - 1 : i11 <= 10 && b0Var.f68630g == 2;
    }

    public static boolean h(s sVar, b0 b0Var, int i11, a aVar) {
        long peekPosition = sVar.getPeekPosition();
        byte[] bArr = new byte[2];
        sVar.peekFully(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i11) {
            sVar.resetPeekPosition();
            sVar.advancePeekPosition((int) (peekPosition - sVar.getPosition()));
            return false;
        }
        androidx.media3.common.util.j0 j0Var = new androidx.media3.common.util.j0(16);
        System.arraycopy(bArr, 0, j0Var.e(), 0, 2);
        j0Var.V(u.c(sVar, j0Var.e(), 2, 14));
        sVar.resetPeekPosition();
        sVar.advancePeekPosition((int) (peekPosition - sVar.getPosition()));
        return d(j0Var, b0Var, i11, aVar);
    }

    public static long i(s sVar, b0 b0Var) {
        sVar.resetPeekPosition();
        sVar.advancePeekPosition(1);
        byte[] bArr = new byte[1];
        sVar.peekFully(bArr, 0, 1);
        boolean z10 = (bArr[0] & 1) == 1;
        sVar.advancePeekPosition(2);
        int i11 = z10 ? 7 : 6;
        androidx.media3.common.util.j0 j0Var = new androidx.media3.common.util.j0(i11);
        j0Var.V(u.c(sVar, j0Var.e(), 0, i11));
        sVar.resetPeekPosition();
        a aVar = new a();
        if (c(j0Var, b0Var, z10, aVar)) {
            return aVar.f68836a;
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public static int j(androidx.media3.common.util.j0 j0Var, int i11) {
        switch (i11) {
            case 1:
                return PsExtractor.AUDIO_STREAM;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i11 - 2);
            case 6:
                return j0Var.H() + 1;
            case 7:
                return j0Var.P() + 1;
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
