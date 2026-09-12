package i3;

import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import androidx.media3.common.y;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import i3.s;
import java.io.EOFException;
import l2.r0;
import l2.s0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class v implements s0 {

    /* renamed from: a, reason: collision with root package name */
    private final s0 f65057a;

    /* renamed from: b, reason: collision with root package name */
    private final s.a f65058b;

    /* renamed from: h, reason: collision with root package name */
    private s f65064h;

    /* renamed from: i, reason: collision with root package name */
    private androidx.media3.common.r f65065i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f65066j;

    /* renamed from: c, reason: collision with root package name */
    private final d f65059c = new d();

    /* renamed from: e, reason: collision with root package name */
    private int f65061e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f65062f = 0;

    /* renamed from: g, reason: collision with root package name */
    private byte[] f65063g = a1.f10437f;

    /* renamed from: d, reason: collision with root package name */
    private final j0 f65060d = new j0();

    public v(s0 s0Var, s.a aVar) {
        this.f65057a = s0Var;
        this.f65058b = aVar;
    }

    private void i(int i11) {
        int length = this.f65063g.length;
        int i12 = this.f65062f;
        if (length - i12 >= i11) {
            return;
        }
        int i13 = i12 - this.f65061e;
        int max = Math.max(i13 * 2, i11 + i13);
        byte[] bArr = this.f65063g;
        byte[] bArr2 = max <= bArr.length ? bArr : new byte[max];
        System.arraycopy(bArr, this.f65061e, bArr2, 0, i13);
        this.f65061e = 0;
        this.f65062f = i13;
        this.f65063g = bArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void j(e eVar, long j11, int i11) {
        androidx.media3.common.util.a.i(this.f65065i);
        byte[] a11 = this.f65059c.a(eVar.f65019a, eVar.f65021c);
        this.f65060d.T(a11);
        this.f65057a.b(this.f65060d, a11.length);
        long j12 = eVar.f65020b;
        if (j12 == C.TIME_UNSET) {
            androidx.media3.common.util.a.g(this.f65065i.f10248t == Long.MAX_VALUE);
        } else {
            long j13 = this.f65065i.f10248t;
            j11 = j13 == Long.MAX_VALUE ? j11 + j12 : j12 + j13;
        }
        this.f65057a.d(j11, i11 | 1, a11.length, 0, null);
    }

    @Override // l2.s0
    public void a(j0 j0Var, int i11, int i12) {
        if (this.f65064h == null) {
            this.f65057a.a(j0Var, i11, i12);
            return;
        }
        i(i11);
        j0Var.l(this.f65063g, this.f65062f, i11);
        this.f65062f += i11;
    }

    @Override // l2.s0
    public /* synthetic */ void b(j0 j0Var, int i11) {
        r0.c(this, j0Var, i11);
    }

    @Override // l2.s0
    public void c(androidx.media3.common.r rVar) {
        androidx.media3.common.util.a.e(rVar.f10243o);
        androidx.media3.common.util.a.a(y.k(rVar.f10243o) == 3);
        if (!rVar.equals(this.f65065i)) {
            this.f65065i = rVar;
            this.f65064h = this.f65058b.a(rVar) ? this.f65058b.c(rVar) : null;
        }
        if (this.f65064h == null) {
            this.f65057a.c(rVar);
        } else {
            this.f65057a.c(rVar.b().u0("application/x-media3-cues").S(rVar.f10243o).y0(Long.MAX_VALUE).W(this.f65058b.b(rVar)).N());
        }
    }

    @Override // l2.s0
    public void d(final long j11, final int i11, int i12, int i13, s0.a aVar) {
        if (this.f65064h == null) {
            this.f65057a.d(j11, i11, i12, i13, aVar);
            return;
        }
        androidx.media3.common.util.a.b(aVar == null, "DRM on subtitles is not supported");
        int i14 = (this.f65062f - i13) - i12;
        try {
            this.f65064h.a(this.f65063g, i14, i12, s.b.b(), new androidx.media3.common.util.m() { // from class: i3.u
                @Override // androidx.media3.common.util.m
                public final void accept(Object obj) {
                    v.this.j(j11, i11, (e) obj);
                }
            });
        } catch (RuntimeException e11) {
            if (!this.f65066j) {
                throw e11;
            }
            androidx.media3.common.util.u.i("SubtitleTranscodingTO", "Parsing subtitles failed, ignoring sample.", e11);
        }
        int i15 = i14 + i12;
        this.f65061e = i15;
        if (i15 == this.f65062f) {
            this.f65061e = 0;
            this.f65062f = 0;
        }
    }

    @Override // l2.s0
    public /* synthetic */ int e(androidx.media3.common.j jVar, int i11, boolean z10) {
        return r0.b(this, jVar, i11, z10);
    }

    @Override // l2.s0
    public /* synthetic */ void f(long j11) {
        r0.a(this, j11);
    }

    @Override // l2.s0
    public int g(androidx.media3.common.j jVar, int i11, boolean z10, int i12) {
        if (this.f65064h == null) {
            return this.f65057a.g(jVar, i11, z10, i12);
        }
        i(i11);
        int read = jVar.read(this.f65063g, this.f65062f, i11);
        if (read != -1) {
            this.f65062f += read;
            return read;
        }
        if (z10) {
            return -1;
        }
        throw new EOFException();
    }

    public void l(boolean z10) {
        this.f65066j = z10;
    }
}
