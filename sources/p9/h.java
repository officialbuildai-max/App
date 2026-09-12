package p9;

import com.google.android.exoplayer2.audio.c0;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.d0;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import g9.h0;
import java.util.Arrays;
import java.util.List;
import okio.Utf8;
import p9.i;

/* loaded from: classes4.dex */
final class h extends i {

    /* renamed from: o, reason: collision with root package name */
    private static final byte[] f72494o = {79, 112, 117, 115, 72, 101, 97, 100};

    /* renamed from: p, reason: collision with root package name */
    private static final byte[] f72495p = {79, 112, 117, 115, 84, 97, 103, 115};

    /* renamed from: n, reason: collision with root package name */
    private boolean f72496n;

    private long n(byte[] bArr) {
        int i11;
        byte b11 = bArr[0];
        int i12 = b11 & 255;
        int i13 = b11 & 3;
        if (i13 != 0) {
            i11 = 2;
            if (i13 != 1 && i13 != 2) {
                i11 = bArr[1] & Utf8.REPLACEMENT_BYTE;
            }
        } else {
            i11 = 1;
        }
        int i14 = i12 >> 3;
        return i11 * (i14 >= 16 ? DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS << r0 : i14 >= 12 ? 10000 << (i14 & 1) : (i14 & 3) == 3 ? 60000 : 10000 << r0);
    }

    private static boolean o(d0 d0Var, byte[] bArr) {
        if (d0Var.a() < bArr.length) {
            return false;
        }
        int e11 = d0Var.e();
        byte[] bArr2 = new byte[bArr.length];
        d0Var.j(bArr2, 0, bArr.length);
        d0Var.P(e11);
        return Arrays.equals(bArr2, bArr);
    }

    public static boolean p(d0 d0Var) {
        return o(d0Var, f72494o);
    }

    @Override // p9.i
    protected long f(d0 d0Var) {
        return c(n(d0Var.d()));
    }

    @Override // p9.i
    protected boolean h(d0 d0Var, long j11, i.b bVar) {
        if (o(d0Var, f72494o)) {
            byte[] copyOf = Arrays.copyOf(d0Var.d(), d0Var.f());
            int c11 = c0.c(copyOf);
            List a11 = c0.a(copyOf);
            if (bVar.f72510a != null) {
                return true;
            }
            bVar.f72510a = new o1.b().e0(MimeTypes.AUDIO_OPUS).H(c11).f0(48000).T(a11).E();
            return true;
        }
        byte[] bArr = f72495p;
        if (!o(d0Var, bArr)) {
            com.google.android.exoplayer2.util.a.i(bVar.f72510a);
            return false;
        }
        com.google.android.exoplayer2.util.a.i(bVar.f72510a);
        if (this.f72496n) {
            return true;
        }
        this.f72496n = true;
        d0Var.Q(bArr.length);
        Metadata c12 = h0.c(ImmutableList.copyOf(h0.j(d0Var, false, false).f63541b));
        if (c12 == null) {
            return true;
        }
        bVar.f72510a = bVar.f72510a.b().X(c12.copyWithAppendedEntriesFrom(bVar.f72510a.f25548j)).E();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p9.i
    public void l(boolean z10) {
        super.l(z10);
        if (z10) {
            this.f72496n = false;
        }
    }
}
