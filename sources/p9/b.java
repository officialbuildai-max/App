package p9;

import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import g9.b0;
import g9.m;
import g9.s;
import g9.t;
import g9.u;
import g9.v;
import java.util.Arrays;
import p9.i;

/* loaded from: classes4.dex */
final class b extends i {

    /* renamed from: n, reason: collision with root package name */
    private v f72468n;

    /* renamed from: o, reason: collision with root package name */
    private a f72469o;

    /* loaded from: classes4.dex */
    private static final class a implements g {

        /* renamed from: a, reason: collision with root package name */
        private v f72470a;

        /* renamed from: b, reason: collision with root package name */
        private v.a f72471b;

        /* renamed from: c, reason: collision with root package name */
        private long f72472c = -1;

        /* renamed from: d, reason: collision with root package name */
        private long f72473d = -1;

        public a(v vVar, v.a aVar) {
            this.f72470a = vVar;
            this.f72471b = aVar;
        }

        @Override // p9.g
        public long a(m mVar) {
            long j11 = this.f72473d;
            if (j11 < 0) {
                return -1L;
            }
            long j12 = -(j11 + 2);
            this.f72473d = -1L;
            return j12;
        }

        public void b(long j11) {
            this.f72472c = j11;
        }

        @Override // p9.g
        public b0 createSeekMap() {
            com.google.android.exoplayer2.util.a.g(this.f72472c != -1);
            return new u(this.f72470a, this.f72472c);
        }

        @Override // p9.g
        public void startSeek(long j11) {
            long[] jArr = this.f72471b.f63594a;
            this.f72473d = jArr[p0.i(jArr, j11, true, true)];
        }
    }

    private int n(d0 d0Var) {
        int i11 = (d0Var.d()[2] & 255) >> 4;
        if (i11 == 6 || i11 == 7) {
            d0Var.Q(4);
            d0Var.K();
        }
        int j11 = s.j(d0Var, i11);
        d0Var.P(0);
        return j11;
    }

    private static boolean o(byte[] bArr) {
        return bArr[0] == -1;
    }

    public static boolean p(d0 d0Var) {
        return d0Var.a() >= 5 && d0Var.D() == 127 && d0Var.F() == 1179402563;
    }

    @Override // p9.i
    protected long f(d0 d0Var) {
        if (o(d0Var.d())) {
            return n(d0Var);
        }
        return -1L;
    }

    @Override // p9.i
    protected boolean h(d0 d0Var, long j11, i.b bVar) {
        byte[] d11 = d0Var.d();
        v vVar = this.f72468n;
        if (vVar == null) {
            v vVar2 = new v(d11, 17);
            this.f72468n = vVar2;
            bVar.f72510a = vVar2.g(Arrays.copyOfRange(d11, 9, d0Var.f()), null);
            return true;
        }
        if ((d11[0] & Byte.MAX_VALUE) == 3) {
            v.a f11 = t.f(d0Var);
            v b11 = vVar.b(f11);
            this.f72468n = b11;
            this.f72469o = new a(b11, f11);
            return true;
        }
        if (!o(d11)) {
            return true;
        }
        a aVar = this.f72469o;
        if (aVar != null) {
            aVar.b(j11);
            bVar.f72511b = this.f72469o;
        }
        com.google.android.exoplayer2.util.a.e(bVar.f72510a);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p9.i
    public void l(boolean z10) {
        super.l(z10);
        if (z10) {
            this.f72468n = null;
            this.f72469o = null;
        }
    }
}
