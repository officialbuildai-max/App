package g3;

import androidx.media3.common.r;
import androidx.media3.common.util.j0;
import androidx.media3.common.x;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import g3.i;
import java.util.Arrays;
import java.util.List;
import l2.k0;
import l2.v0;

/* loaded from: classes2.dex */
final class h extends i {

    /* renamed from: o, reason: collision with root package name */
    private static final byte[] f63431o = {79, 112, 117, 115, 72, 101, 97, 100};

    /* renamed from: p, reason: collision with root package name */
    private static final byte[] f63432p = {79, 112, 117, 115, 84, 97, 103, 115};

    /* renamed from: n, reason: collision with root package name */
    private boolean f63433n;

    private static boolean n(j0 j0Var, byte[] bArr) {
        if (j0Var.a() < bArr.length) {
            return false;
        }
        int f11 = j0Var.f();
        byte[] bArr2 = new byte[bArr.length];
        j0Var.l(bArr2, 0, bArr.length);
        j0Var.W(f11);
        return Arrays.equals(bArr2, bArr);
    }

    public static boolean o(j0 j0Var) {
        return n(j0Var, f63431o);
    }

    @Override // g3.i
    protected long f(j0 j0Var) {
        return c(k0.e(j0Var.e()));
    }

    @Override // g3.i
    protected boolean h(j0 j0Var, long j11, i.b bVar) {
        if (n(j0Var, f63431o)) {
            byte[] copyOf = Arrays.copyOf(j0Var.e(), j0Var.g());
            int c11 = k0.c(copyOf);
            List a11 = k0.a(copyOf);
            if (bVar.f63447a != null) {
                return true;
            }
            bVar.f63447a = new r.b().U("audio/ogg").u0(MimeTypes.AUDIO_OPUS).R(c11).v0(48000).g0(a11).N();
            return true;
        }
        byte[] bArr = f63432p;
        if (!n(j0Var, bArr)) {
            androidx.media3.common.util.a.i(bVar.f63447a);
            return false;
        }
        androidx.media3.common.util.a.i(bVar.f63447a);
        if (this.f63433n) {
            return true;
        }
        this.f63433n = true;
        j0Var.X(bArr.length);
        x d11 = v0.d(ImmutableList.copyOf(v0.k(j0Var, false, false).f68819b));
        if (d11 == null) {
            return true;
        }
        bVar.f63447a = bVar.f63447a.b().n0(d11.b(bVar.f63447a.f10240l)).N();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g3.i
    public void l(boolean z10) {
        super.l(z10);
        if (z10) {
            this.f63433n = false;
        }
    }
}
