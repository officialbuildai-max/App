package t3;

import android.util.Pair;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import androidx.media3.common.util.u;
import l2.s;

/* loaded from: classes2.dex */
abstract class d {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f76175a;

        /* renamed from: b, reason: collision with root package name */
        public final long f76176b;

        private a(int i11, long j11) {
            this.f76175a = i11;
            this.f76176b = j11;
        }

        public static a a(s sVar, j0 j0Var) {
            sVar.peekFully(j0Var.e(), 0, 8);
            j0Var.W(0);
            return new a(j0Var.q(), j0Var.x());
        }
    }

    public static boolean a(s sVar) {
        j0 j0Var = new j0(8);
        int i11 = a.a(sVar, j0Var).f76175a;
        if (i11 != 1380533830 && i11 != 1380333108) {
            return false;
        }
        sVar.peekFully(j0Var.e(), 0, 4);
        j0Var.W(0);
        int q11 = j0Var.q();
        if (q11 == 1463899717) {
            return true;
        }
        u.c("WavHeaderReader", "Unsupported form type: " + q11);
        return false;
    }

    public static c b(s sVar) {
        byte[] bArr;
        j0 j0Var = new j0(16);
        a d11 = d(1718449184, sVar, j0Var);
        androidx.media3.common.util.a.g(d11.f76176b >= 16);
        sVar.peekFully(j0Var.e(), 0, 16);
        j0Var.W(0);
        int z10 = j0Var.z();
        int z11 = j0Var.z();
        int y10 = j0Var.y();
        int y11 = j0Var.y();
        int z12 = j0Var.z();
        int z13 = j0Var.z();
        int i11 = ((int) d11.f76176b) - 16;
        if (i11 > 0) {
            byte[] bArr2 = new byte[i11];
            sVar.peekFully(bArr2, 0, i11);
            bArr = bArr2;
        } else {
            bArr = a1.f10437f;
        }
        sVar.skipFully((int) (sVar.getPeekPosition() - sVar.getPosition()));
        return new c(z10, z11, y10, y11, z12, z13, bArr);
    }

    public static long c(s sVar) {
        j0 j0Var = new j0(8);
        a a11 = a.a(sVar, j0Var);
        if (a11.f76175a != 1685272116) {
            sVar.resetPeekPosition();
            return -1L;
        }
        sVar.advancePeekPosition(8);
        j0Var.W(0);
        sVar.peekFully(j0Var.e(), 0, 8);
        long v11 = j0Var.v();
        sVar.skipFully(((int) a11.f76176b) + 8);
        return v11;
    }

    private static a d(int i11, s sVar, j0 j0Var) {
        a a11 = a.a(sVar, j0Var);
        while (a11.f76175a != i11) {
            u.h("WavHeaderReader", "Ignoring unknown WAV chunk: " + a11.f76175a);
            long j11 = a11.f76176b;
            long j12 = 8 + j11;
            if (j11 % 2 != 0) {
                j12 = 9 + j11;
            }
            if (j12 > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Chunk is too large (~2GB+) to skip; id: " + a11.f76175a);
            }
            sVar.skipFully((int) j12);
            a11 = a.a(sVar, j0Var);
        }
        return a11;
    }

    public static Pair e(s sVar) {
        sVar.resetPeekPosition();
        a d11 = d(1684108385, sVar, new j0(8));
        sVar.skipFully(8);
        return Pair.create(Long.valueOf(sVar.getPosition()), Long.valueOf(d11.f76176b));
    }
}
