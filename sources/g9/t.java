package g9;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.common.collect.ImmutableList;
import g9.v;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class t {

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public v f63579a;

        public a(v vVar) {
            this.f63579a = vVar;
        }
    }

    public static boolean a(m mVar) {
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(4);
        mVar.peekFully(d0Var.d(), 0, 4);
        return d0Var.F() == 1716281667;
    }

    public static int b(m mVar) {
        mVar.resetPeekPosition();
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(2);
        mVar.peekFully(d0Var.d(), 0, 2);
        int J = d0Var.J();
        if ((J >> 2) == 16382) {
            mVar.resetPeekPosition();
            return J;
        }
        mVar.resetPeekPosition();
        throw ParserException.createForMalformedContainer("First frame does not start with sync code.", null);
    }

    public static Metadata c(m mVar, boolean z10) {
        Metadata a11 = new y().a(mVar, z10 ? null : com.google.android.exoplayer2.metadata.id3.b.f25490b);
        if (a11 == null || a11.length() == 0) {
            return null;
        }
        return a11;
    }

    public static Metadata d(m mVar, boolean z10) {
        mVar.resetPeekPosition();
        long peekPosition = mVar.getPeekPosition();
        Metadata c11 = c(mVar, z10);
        mVar.skipFully((int) (mVar.getPeekPosition() - peekPosition));
        return c11;
    }

    public static boolean e(m mVar, a aVar) {
        mVar.resetPeekPosition();
        com.google.android.exoplayer2.util.c0 c0Var = new com.google.android.exoplayer2.util.c0(new byte[4]);
        mVar.peekFully(c0Var.f27614a, 0, 4);
        boolean g11 = c0Var.g();
        int h11 = c0Var.h(7);
        int h12 = c0Var.h(24) + 4;
        if (h11 == 0) {
            aVar.f63579a = h(mVar);
        } else {
            v vVar = aVar.f63579a;
            if (vVar == null) {
                throw new IllegalArgumentException();
            }
            if (h11 == 3) {
                aVar.f63579a = vVar.b(g(mVar, h12));
            } else if (h11 == 4) {
                aVar.f63579a = vVar.c(j(mVar, h12));
            } else if (h11 == 6) {
                com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(h12);
                mVar.readFully(d0Var.d(), 0, h12);
                d0Var.Q(4);
                aVar.f63579a = vVar.a(ImmutableList.of(PictureFrame.fromPictureBlock(d0Var)));
            } else {
                mVar.skipFully(h12);
            }
        }
        return g11;
    }

    public static v.a f(com.google.android.exoplayer2.util.d0 d0Var) {
        d0Var.Q(1);
        int G = d0Var.G();
        long e11 = d0Var.e() + G;
        int i11 = G / 18;
        long[] jArr = new long[i11];
        long[] jArr2 = new long[i11];
        int i12 = 0;
        while (true) {
            if (i12 >= i11) {
                break;
            }
            long w11 = d0Var.w();
            if (w11 == -1) {
                jArr = Arrays.copyOf(jArr, i12);
                jArr2 = Arrays.copyOf(jArr2, i12);
                break;
            }
            jArr[i12] = w11;
            jArr2[i12] = d0Var.w();
            d0Var.Q(2);
            i12++;
        }
        d0Var.Q((int) (e11 - d0Var.e()));
        return new v.a(jArr, jArr2);
    }

    private static v.a g(m mVar, int i11) {
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(i11);
        mVar.readFully(d0Var.d(), 0, i11);
        return f(d0Var);
    }

    private static v h(m mVar) {
        byte[] bArr = new byte[38];
        mVar.readFully(bArr, 0, 38);
        return new v(bArr, 4);
    }

    public static void i(m mVar) {
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(4);
        mVar.readFully(d0Var.d(), 0, 4);
        if (d0Var.F() != 1716281667) {
            throw ParserException.createForMalformedContainer("Failed to read FLAC stream marker.", null);
        }
    }

    private static List j(m mVar, int i11) {
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(i11);
        mVar.readFully(d0Var.d(), 0, i11);
        d0Var.Q(4);
        return Arrays.asList(h0.j(d0Var, false, false).f63541b);
    }
}
