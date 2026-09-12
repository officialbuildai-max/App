package g3;

import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import g3.i;
import java.util.Arrays;
import l2.a0;
import l2.b0;
import l2.m0;
import l2.s;
import l2.y;
import l2.z;

/* loaded from: classes2.dex */
final class b extends i {

    /* renamed from: n, reason: collision with root package name */
    private b0 f63405n;

    /* renamed from: o, reason: collision with root package name */
    private a f63406o;

    /* loaded from: classes2.dex */
    private static final class a implements g {

        /* renamed from: a, reason: collision with root package name */
        private b0 f63407a;

        /* renamed from: b, reason: collision with root package name */
        private b0.a f63408b;

        /* renamed from: c, reason: collision with root package name */
        private long f63409c = -1;

        /* renamed from: d, reason: collision with root package name */
        private long f63410d = -1;

        public a(b0 b0Var, b0.a aVar) {
            this.f63407a = b0Var;
            this.f63408b = aVar;
        }

        @Override // g3.g
        public long a(s sVar) {
            long j11 = this.f63410d;
            if (j11 < 0) {
                return -1L;
            }
            long j12 = -(j11 + 2);
            this.f63410d = -1L;
            return j12;
        }

        public void b(long j11) {
            this.f63409c = j11;
        }

        @Override // g3.g
        public m0 createSeekMap() {
            androidx.media3.common.util.a.g(this.f63409c != -1);
            return new a0(this.f63407a, this.f63409c);
        }

        @Override // g3.g
        public void startSeek(long j11) {
            long[] jArr = this.f63408b.f68636a;
            this.f63410d = jArr[a1.h(jArr, j11, true, true)];
        }
    }

    private int n(j0 j0Var) {
        int i11 = (j0Var.e()[2] & 255) >> 4;
        if (i11 == 6 || i11 == 7) {
            j0Var.X(4);
            j0Var.Q();
        }
        int j11 = y.j(j0Var, i11);
        j0Var.W(0);
        return j11;
    }

    private static boolean o(byte[] bArr) {
        return bArr[0] == -1;
    }

    public static boolean p(j0 j0Var) {
        return j0Var.a() >= 5 && j0Var.H() == 127 && j0Var.J() == 1179402563;
    }

    @Override // g3.i
    protected long f(j0 j0Var) {
        if (o(j0Var.e())) {
            return n(j0Var);
        }
        return -1L;
    }

    @Override // g3.i
    protected boolean h(j0 j0Var, long j11, i.b bVar) {
        byte[] e11 = j0Var.e();
        b0 b0Var = this.f63405n;
        if (b0Var == null) {
            b0 b0Var2 = new b0(e11, 17);
            this.f63405n = b0Var2;
            bVar.f63447a = b0Var2.g(Arrays.copyOfRange(e11, 9, j0Var.g()), null).b().U("audio/ogg").N();
            return true;
        }
        if ((e11[0] & Byte.MAX_VALUE) == 3) {
            b0.a f11 = z.f(j0Var);
            b0 b11 = b0Var.b(f11);
            this.f63405n = b11;
            this.f63406o = new a(b11, f11);
            return true;
        }
        if (!o(e11)) {
            return true;
        }
        a aVar = this.f63406o;
        if (aVar != null) {
            aVar.b(j11);
            bVar.f63448b = this.f63406o;
        }
        androidx.media3.common.util.a.e(bVar.f63447a);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g3.i
    public void l(boolean z10) {
        super.l(z10);
        if (z10) {
            this.f63405n = null;
            this.f63406o = null;
        }
    }
}
