package p9;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.d0;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import g9.h0;
import java.util.ArrayList;
import java.util.Arrays;
import p9.i;

/* loaded from: classes4.dex */
final class j extends i {

    /* renamed from: n, reason: collision with root package name */
    private a f72512n;

    /* renamed from: o, reason: collision with root package name */
    private int f72513o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f72514p;

    /* renamed from: q, reason: collision with root package name */
    private h0.d f72515q;

    /* renamed from: r, reason: collision with root package name */
    private h0.b f72516r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final h0.d f72517a;

        /* renamed from: b, reason: collision with root package name */
        public final h0.b f72518b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f72519c;

        /* renamed from: d, reason: collision with root package name */
        public final h0.c[] f72520d;

        /* renamed from: e, reason: collision with root package name */
        public final int f72521e;

        public a(h0.d dVar, h0.b bVar, byte[] bArr, h0.c[] cVarArr, int i11) {
            this.f72517a = dVar;
            this.f72518b = bVar;
            this.f72519c = bArr;
            this.f72520d = cVarArr;
            this.f72521e = i11;
        }
    }

    static void n(d0 d0Var, long j11) {
        if (d0Var.b() < d0Var.f() + 4) {
            d0Var.M(Arrays.copyOf(d0Var.d(), d0Var.f() + 4));
        } else {
            d0Var.O(d0Var.f() + 4);
        }
        byte[] d11 = d0Var.d();
        d11[d0Var.f() - 4] = (byte) (j11 & 255);
        d11[d0Var.f() - 3] = (byte) ((j11 >>> 8) & 255);
        d11[d0Var.f() - 2] = (byte) ((j11 >>> 16) & 255);
        d11[d0Var.f() - 1] = (byte) ((j11 >>> 24) & 255);
    }

    private static int o(byte b11, a aVar) {
        return !aVar.f72520d[p(b11, aVar.f72521e, 1)].f63543a ? aVar.f72517a.f63553g : aVar.f72517a.f63554h;
    }

    static int p(byte b11, int i11, int i12) {
        return (b11 >> i12) & (255 >>> (8 - i11));
    }

    public static boolean r(d0 d0Var) {
        try {
            return h0.m(1, d0Var, true);
        } catch (ParserException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p9.i
    public void e(long j11) {
        super.e(j11);
        this.f72514p = j11 != 0;
        h0.d dVar = this.f72515q;
        this.f72513o = dVar != null ? dVar.f63553g : 0;
    }

    @Override // p9.i
    protected long f(d0 d0Var) {
        if ((d0Var.d()[0] & 1) == 1) {
            return -1L;
        }
        int o11 = o(d0Var.d()[0], (a) com.google.android.exoplayer2.util.a.i(this.f72512n));
        long j11 = this.f72514p ? (this.f72513o + o11) / 4 : 0;
        n(d0Var, j11);
        this.f72514p = true;
        this.f72513o = o11;
        return j11;
    }

    @Override // p9.i
    protected boolean h(d0 d0Var, long j11, i.b bVar) {
        if (this.f72512n != null) {
            com.google.android.exoplayer2.util.a.e(bVar.f72510a);
            return false;
        }
        a q11 = q(d0Var);
        this.f72512n = q11;
        if (q11 == null) {
            return true;
        }
        h0.d dVar = q11.f72517a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar.f63556j);
        arrayList.add(q11.f72519c);
        bVar.f72510a = new o1.b().e0(MimeTypes.AUDIO_VORBIS).G(dVar.f63551e).Z(dVar.f63550d).H(dVar.f63548b).f0(dVar.f63549c).T(arrayList).X(h0.c(ImmutableList.copyOf(q11.f72518b.f63541b))).E();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p9.i
    public void l(boolean z10) {
        super.l(z10);
        if (z10) {
            this.f72512n = null;
            this.f72515q = null;
            this.f72516r = null;
        }
        this.f72513o = 0;
        this.f72514p = false;
    }

    a q(d0 d0Var) {
        h0.d dVar = this.f72515q;
        if (dVar == null) {
            this.f72515q = h0.k(d0Var);
            return null;
        }
        h0.b bVar = this.f72516r;
        if (bVar == null) {
            this.f72516r = h0.i(d0Var);
            return null;
        }
        byte[] bArr = new byte[d0Var.f()];
        System.arraycopy(d0Var.d(), 0, bArr, 0, d0Var.f());
        return new a(dVar, bVar, bArr, h0.l(d0Var, dVar.f63548b), h0.a(r4.length - 1));
    }
}
