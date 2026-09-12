package l2;

import androidx.media3.common.ParserException;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import l2.b0;

/* loaded from: classes2.dex */
public abstract class z {

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public b0 f68837a;

        public a(b0 b0Var) {
            this.f68837a = b0Var;
        }
    }

    public static boolean a(s sVar) {
        androidx.media3.common.util.j0 j0Var = new androidx.media3.common.util.j0(4);
        sVar.peekFully(j0Var.e(), 0, 4);
        return j0Var.J() == 1716281667;
    }

    public static int b(s sVar) {
        sVar.resetPeekPosition();
        androidx.media3.common.util.j0 j0Var = new androidx.media3.common.util.j0(2);
        sVar.peekFully(j0Var.e(), 0, 2);
        int P = j0Var.P();
        if ((P >> 2) == 16382) {
            sVar.resetPeekPosition();
            return P;
        }
        sVar.resetPeekPosition();
        throw ParserException.createForMalformedContainer("First frame does not start with sync code.", null);
    }

    public static androidx.media3.common.x c(s sVar, boolean z10) {
        androidx.media3.common.x a11 = new g0().a(sVar, z10 ? null : z2.h.f79310b);
        if (a11 == null || a11.e() == 0) {
            return null;
        }
        return a11;
    }

    public static androidx.media3.common.x d(s sVar, boolean z10) {
        sVar.resetPeekPosition();
        long peekPosition = sVar.getPeekPosition();
        androidx.media3.common.x c11 = c(sVar, z10);
        sVar.skipFully((int) (sVar.getPeekPosition() - peekPosition));
        return c11;
    }

    public static boolean e(s sVar, a aVar) {
        sVar.resetPeekPosition();
        androidx.media3.common.util.i0 i0Var = new androidx.media3.common.util.i0(new byte[4]);
        sVar.peekFully(i0Var.f10470a, 0, 4);
        boolean g11 = i0Var.g();
        int h11 = i0Var.h(7);
        int h12 = i0Var.h(24) + 4;
        if (h11 == 0) {
            aVar.f68837a = h(sVar);
        } else {
            b0 b0Var = aVar.f68837a;
            if (b0Var == null) {
                throw new IllegalArgumentException();
            }
            if (h11 == 3) {
                aVar.f68837a = b0Var.b(g(sVar, h12));
            } else if (h11 == 4) {
                aVar.f68837a = b0Var.c(j(sVar, h12));
            } else if (h11 == 6) {
                androidx.media3.common.util.j0 j0Var = new androidx.media3.common.util.j0(h12);
                sVar.readFully(j0Var.e(), 0, h12);
                j0Var.X(4);
                aVar.f68837a = b0Var.a(ImmutableList.of(x2.a.b(j0Var)));
            } else {
                sVar.skipFully(h12);
            }
        }
        return g11;
    }

    public static b0.a f(androidx.media3.common.util.j0 j0Var) {
        j0Var.X(1);
        int K = j0Var.K();
        long f11 = j0Var.f() + K;
        int i11 = K / 18;
        long[] jArr = new long[i11];
        long[] jArr2 = new long[i11];
        int i12 = 0;
        while (true) {
            if (i12 >= i11) {
                break;
            }
            long A = j0Var.A();
            if (A == -1) {
                jArr = Arrays.copyOf(jArr, i12);
                jArr2 = Arrays.copyOf(jArr2, i12);
                break;
            }
            jArr[i12] = A;
            jArr2[i12] = j0Var.A();
            j0Var.X(2);
            i12++;
        }
        j0Var.X((int) (f11 - j0Var.f()));
        return new b0.a(jArr, jArr2);
    }

    private static b0.a g(s sVar, int i11) {
        androidx.media3.common.util.j0 j0Var = new androidx.media3.common.util.j0(i11);
        sVar.readFully(j0Var.e(), 0, i11);
        return f(j0Var);
    }

    private static b0 h(s sVar) {
        byte[] bArr = new byte[38];
        sVar.readFully(bArr, 0, 38);
        return new b0(bArr, 4);
    }

    public static void i(s sVar) {
        androidx.media3.common.util.j0 j0Var = new androidx.media3.common.util.j0(4);
        sVar.readFully(j0Var.e(), 0, 4);
        if (j0Var.J() != 1716281667) {
            throw ParserException.createForMalformedContainer("Failed to read FLAC stream marker.", null);
        }
    }

    private static List j(s sVar, int i11) {
        androidx.media3.common.util.j0 j0Var = new androidx.media3.common.util.j0(i11);
        sVar.readFully(j0Var.e(), 0, i11);
        j0Var.X(4);
        return Arrays.asList(v0.k(j0Var, false, false).f68819b);
    }
}
