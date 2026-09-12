package g3;

import androidx.media3.common.ParserException;
import androidx.media3.common.r;
import androidx.media3.common.util.j0;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import g3.i;
import java.util.ArrayList;
import java.util.Arrays;
import l2.v0;

/* loaded from: classes2.dex */
final class j extends i {

    /* renamed from: n, reason: collision with root package name */
    private a f63449n;

    /* renamed from: o, reason: collision with root package name */
    private int f63450o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f63451p;

    /* renamed from: q, reason: collision with root package name */
    private v0.c f63452q;

    /* renamed from: r, reason: collision with root package name */
    private v0.a f63453r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final v0.c f63454a;

        /* renamed from: b, reason: collision with root package name */
        public final v0.a f63455b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f63456c;

        /* renamed from: d, reason: collision with root package name */
        public final v0.b[] f63457d;

        /* renamed from: e, reason: collision with root package name */
        public final int f63458e;

        public a(v0.c cVar, v0.a aVar, byte[] bArr, v0.b[] bVarArr, int i11) {
            this.f63454a = cVar;
            this.f63455b = aVar;
            this.f63456c = bArr;
            this.f63457d = bVarArr;
            this.f63458e = i11;
        }
    }

    static void n(j0 j0Var, long j11) {
        if (j0Var.b() < j0Var.g() + 4) {
            j0Var.T(Arrays.copyOf(j0Var.e(), j0Var.g() + 4));
        } else {
            j0Var.V(j0Var.g() + 4);
        }
        byte[] e11 = j0Var.e();
        e11[j0Var.g() - 4] = (byte) (j11 & 255);
        e11[j0Var.g() - 3] = (byte) ((j11 >>> 8) & 255);
        e11[j0Var.g() - 2] = (byte) ((j11 >>> 16) & 255);
        e11[j0Var.g() - 1] = (byte) ((j11 >>> 24) & 255);
    }

    private static int o(byte b11, a aVar) {
        return !aVar.f63457d[p(b11, aVar.f63458e, 1)].f68821a ? aVar.f63454a.f68831g : aVar.f63454a.f68832h;
    }

    static int p(byte b11, int i11, int i12) {
        return (b11 >> i12) & (255 >>> (8 - i11));
    }

    public static boolean r(j0 j0Var) {
        try {
            return v0.o(1, j0Var, true);
        } catch (ParserException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g3.i
    public void e(long j11) {
        super.e(j11);
        this.f63451p = j11 != 0;
        v0.c cVar = this.f63452q;
        this.f63450o = cVar != null ? cVar.f68831g : 0;
    }

    @Override // g3.i
    protected long f(j0 j0Var) {
        if ((j0Var.e()[0] & 1) == 1) {
            return -1L;
        }
        int o11 = o(j0Var.e()[0], (a) androidx.media3.common.util.a.i(this.f63449n));
        long j11 = this.f63451p ? (this.f63450o + o11) / 4 : 0;
        n(j0Var, j11);
        this.f63451p = true;
        this.f63450o = o11;
        return j11;
    }

    @Override // g3.i
    protected boolean h(j0 j0Var, long j11, i.b bVar) {
        if (this.f63449n != null) {
            androidx.media3.common.util.a.e(bVar.f63447a);
            return false;
        }
        a q11 = q(j0Var);
        this.f63449n = q11;
        if (q11 == null) {
            return true;
        }
        v0.c cVar = q11.f63454a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar.f68834j);
        arrayList.add(q11.f63456c);
        bVar.f63447a = new r.b().U("audio/ogg").u0(MimeTypes.AUDIO_VORBIS).Q(cVar.f68829e).p0(cVar.f68828d).R(cVar.f68826b).v0(cVar.f68827c).g0(arrayList).n0(v0.d(ImmutableList.copyOf(q11.f63455b.f68819b))).N();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g3.i
    public void l(boolean z10) {
        super.l(z10);
        if (z10) {
            this.f63449n = null;
            this.f63452q = null;
            this.f63453r = null;
        }
        this.f63450o = 0;
        this.f63451p = false;
    }

    a q(j0 j0Var) {
        v0.c cVar = this.f63452q;
        if (cVar == null) {
            this.f63452q = v0.l(j0Var);
            return null;
        }
        v0.a aVar = this.f63453r;
        if (aVar == null) {
            this.f63453r = v0.j(j0Var);
            return null;
        }
        byte[] bArr = new byte[j0Var.g()];
        System.arraycopy(j0Var.e(), 0, bArr, 0, j0Var.g());
        return new a(cVar, aVar, bArr, v0.m(j0Var, cVar.f68826b), v0.b(r4.length - 1));
    }
}
