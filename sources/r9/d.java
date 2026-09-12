package r9;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import g9.m;

/* loaded from: classes4.dex */
abstract class d {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f74346a;

        /* renamed from: b, reason: collision with root package name */
        public final long f74347b;

        private a(int i11, long j11) {
            this.f74346a = i11;
            this.f74347b = j11;
        }

        public static a a(m mVar, d0 d0Var) {
            mVar.peekFully(d0Var.d(), 0, 8);
            d0Var.P(0);
            return new a(d0Var.n(), d0Var.t());
        }
    }

    public static boolean a(m mVar) {
        d0 d0Var = new d0(8);
        int i11 = a.a(mVar, d0Var).f74346a;
        if (i11 != 1380533830 && i11 != 1380333108) {
            return false;
        }
        mVar.peekFully(d0Var.d(), 0, 4);
        d0Var.P(0);
        int n11 = d0Var.n();
        if (n11 == 1463899717) {
            return true;
        }
        s.c("WavHeaderReader", "Unsupported form type: " + n11);
        return false;
    }

    public static c b(m mVar) {
        byte[] bArr;
        d0 d0Var = new d0(16);
        a d11 = d(1718449184, mVar, d0Var);
        com.google.android.exoplayer2.util.a.g(d11.f74347b >= 16);
        mVar.peekFully(d0Var.d(), 0, 16);
        d0Var.P(0);
        int v11 = d0Var.v();
        int v12 = d0Var.v();
        int u11 = d0Var.u();
        int u12 = d0Var.u();
        int v13 = d0Var.v();
        int v14 = d0Var.v();
        int i11 = ((int) d11.f74347b) - 16;
        if (i11 > 0) {
            byte[] bArr2 = new byte[i11];
            mVar.peekFully(bArr2, 0, i11);
            bArr = bArr2;
        } else {
            bArr = p0.f27685f;
        }
        mVar.skipFully((int) (mVar.getPeekPosition() - mVar.getPosition()));
        return new c(v11, v12, u11, u12, v13, v14, bArr);
    }

    public static long c(m mVar) {
        d0 d0Var = new d0(8);
        a a11 = a.a(mVar, d0Var);
        if (a11.f74346a != 1685272116) {
            mVar.resetPeekPosition();
            return -1L;
        }
        mVar.advancePeekPosition(8);
        d0Var.P(0);
        mVar.peekFully(d0Var.d(), 0, 8);
        long r11 = d0Var.r();
        mVar.skipFully(((int) a11.f74347b) + 8);
        return r11;
    }

    private static a d(int i11, m mVar, d0 d0Var) {
        a a11 = a.a(mVar, d0Var);
        while (a11.f74346a != i11) {
            s.i("WavHeaderReader", "Ignoring unknown WAV chunk: " + a11.f74346a);
            long j11 = a11.f74347b + 8;
            if (j11 > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Chunk is too large (~2GB+) to skip; id: " + a11.f74346a);
            }
            mVar.skipFully((int) j11);
            a11 = a.a(mVar, d0Var);
        }
        return a11;
    }

    public static Pair e(m mVar) {
        mVar.resetPeekPosition();
        a d11 = d(1684108385, mVar, new d0(8));
        mVar.skipFully(8);
        return Pair.create(Long.valueOf(mVar.getPosition()), Long.valueOf(d11.f74347b));
    }
}
