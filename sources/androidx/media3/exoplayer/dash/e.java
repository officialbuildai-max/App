package androidx.media3.exoplayer.dash;

import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.s2;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g2.u;

/* loaded from: classes2.dex */
final class e implements u {

    /* renamed from: a, reason: collision with root package name */
    private final r f11543a;

    /* renamed from: c, reason: collision with root package name */
    private long[] f11545c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f11546d;

    /* renamed from: e, reason: collision with root package name */
    private a2.f f11547e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f11548f;

    /* renamed from: g, reason: collision with root package name */
    private int f11549g;

    /* renamed from: b, reason: collision with root package name */
    private final w2.c f11544b = new w2.c();

    /* renamed from: h, reason: collision with root package name */
    private long f11550h = C.TIME_UNSET;

    public e(a2.f fVar, r rVar, boolean z10) {
        this.f11543a = rVar;
        this.f11547e = fVar;
        this.f11545c = fVar.f152b;
        d(fVar, z10);
    }

    public String a() {
        return this.f11547e.a();
    }

    public void b(long j11) {
        int d11 = a1.d(this.f11545c, j11, true, false);
        this.f11549g = d11;
        if (!this.f11546d || d11 != this.f11545c.length) {
            j11 = C.TIME_UNSET;
        }
        this.f11550h = j11;
    }

    @Override // g2.u
    public int c(s2 s2Var, DecoderInputBuffer decoderInputBuffer, int i11) {
        int i12 = this.f11549g;
        boolean z10 = i12 == this.f11545c.length;
        if (z10 && !this.f11546d) {
            decoderInputBuffer.setFlags(4);
            return -4;
        }
        if ((i11 & 2) != 0 || !this.f11548f) {
            s2Var.f12652b = this.f11543a;
            this.f11548f = true;
            return -5;
        }
        if (z10) {
            return -3;
        }
        if ((i11 & 1) == 0) {
            this.f11549g = i12 + 1;
        }
        if ((i11 & 4) == 0) {
            byte[] a11 = this.f11544b.a(this.f11547e.f151a[i12]);
            decoderInputBuffer.b(a11.length);
            decoderInputBuffer.f11000c.put(a11);
        }
        decoderInputBuffer.f11002e = this.f11545c[i12];
        decoderInputBuffer.setFlags(1);
        return -4;
    }

    public void d(a2.f fVar, boolean z10) {
        int i11 = this.f11549g;
        long j11 = i11 == 0 ? -9223372036854775807L : this.f11545c[i11 - 1];
        this.f11546d = z10;
        this.f11547e = fVar;
        long[] jArr = fVar.f152b;
        this.f11545c = jArr;
        long j12 = this.f11550h;
        if (j12 != C.TIME_UNSET) {
            b(j12);
        } else if (j11 != C.TIME_UNSET) {
            this.f11549g = a1.d(jArr, j11, false, false);
        }
    }

    @Override // g2.u
    public boolean isReady() {
        return true;
    }

    @Override // g2.u
    public void maybeThrowError() {
    }

    @Override // g2.u
    public int skipData(long j11) {
        int max = Math.max(this.f11549g, a1.d(this.f11545c, j11, true, false));
        int i11 = max - this.f11549g;
        this.f11549g = max;
        return i11;
    }
}
