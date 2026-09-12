package l3;

import android.graphics.Bitmap;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import androidx.media3.common.util.m;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import i3.e;
import i3.k;
import i3.r;
import i3.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.Inflater;
import u1.a;

/* loaded from: classes2.dex */
public final class a implements s {

    /* renamed from: a, reason: collision with root package name */
    private final j0 f68838a = new j0();

    /* renamed from: b, reason: collision with root package name */
    private final j0 f68839b = new j0();

    /* renamed from: c, reason: collision with root package name */
    private final C0855a f68840c = new C0855a();

    /* renamed from: d, reason: collision with root package name */
    private Inflater f68841d;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l3.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0855a {

        /* renamed from: a, reason: collision with root package name */
        private final j0 f68842a = new j0();

        /* renamed from: b, reason: collision with root package name */
        private final int[] f68843b = new int[256];

        /* renamed from: c, reason: collision with root package name */
        private boolean f68844c;

        /* renamed from: d, reason: collision with root package name */
        private int f68845d;

        /* renamed from: e, reason: collision with root package name */
        private int f68846e;

        /* renamed from: f, reason: collision with root package name */
        private int f68847f;

        /* renamed from: g, reason: collision with root package name */
        private int f68848g;

        /* renamed from: h, reason: collision with root package name */
        private int f68849h;

        /* renamed from: i, reason: collision with root package name */
        private int f68850i;

        /* JADX INFO: Access modifiers changed from: private */
        public void e(j0 j0Var, int i11) {
            int K;
            if (i11 < 4) {
                return;
            }
            j0Var.X(3);
            int i12 = i11 - 4;
            if ((j0Var.H() & 128) != 0) {
                if (i12 < 7 || (K = j0Var.K()) < 4) {
                    return;
                }
                this.f68849h = j0Var.P();
                this.f68850i = j0Var.P();
                this.f68842a.S(K - 4);
                i12 = i11 - 11;
            }
            int f11 = this.f68842a.f();
            int g11 = this.f68842a.g();
            if (f11 >= g11 || i12 <= 0) {
                return;
            }
            int min = Math.min(i12, g11 - f11);
            j0Var.l(this.f68842a.e(), f11, min);
            this.f68842a.W(f11 + min);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(j0 j0Var, int i11) {
            if (i11 < 19) {
                return;
            }
            this.f68845d = j0Var.P();
            this.f68846e = j0Var.P();
            j0Var.X(11);
            this.f68847f = j0Var.P();
            this.f68848g = j0Var.P();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(j0 j0Var, int i11) {
            if (i11 % 5 != 2) {
                return;
            }
            j0Var.X(2);
            Arrays.fill(this.f68843b, 0);
            int i12 = i11 / 5;
            for (int i13 = 0; i13 < i12; i13++) {
                int H = j0Var.H();
                int H2 = j0Var.H();
                int H3 = j0Var.H();
                int H4 = j0Var.H();
                double d11 = H2;
                double d12 = H3 - 128;
                double d13 = H4 - 128;
                this.f68843b[H] = (a1.p((int) ((d11 - (0.34414d * d13)) - (d12 * 0.71414d)), 0, 255) << 8) | (j0Var.H() << 24) | (a1.p((int) ((1.402d * d12) + d11), 0, 255) << 16) | a1.p((int) (d11 + (d13 * 1.772d)), 0, 255);
            }
            this.f68844c = true;
        }

        public u1.a d() {
            int i11;
            if (this.f68845d == 0 || this.f68846e == 0 || this.f68849h == 0 || this.f68850i == 0 || this.f68842a.g() == 0 || this.f68842a.f() != this.f68842a.g() || !this.f68844c) {
                return null;
            }
            this.f68842a.W(0);
            int i12 = this.f68849h * this.f68850i;
            int[] iArr = new int[i12];
            int i13 = 0;
            while (i13 < i12) {
                int H = this.f68842a.H();
                if (H != 0) {
                    i11 = i13 + 1;
                    iArr[i13] = this.f68843b[H];
                } else {
                    int H2 = this.f68842a.H();
                    if (H2 != 0) {
                        i11 = ((H2 & 64) == 0 ? H2 & 63 : ((H2 & 63) << 8) | this.f68842a.H()) + i13;
                        Arrays.fill(iArr, i13, i11, (H2 & 128) == 0 ? this.f68843b[0] : this.f68843b[this.f68842a.H()]);
                    }
                }
                i13 = i11;
            }
            return new a.b().f(Bitmap.createBitmap(iArr, this.f68849h, this.f68850i, Bitmap.Config.ARGB_8888)).k(this.f68847f / this.f68845d).l(0).h(this.f68848g / this.f68846e, 0).i(0).n(this.f68849h / this.f68845d).g(this.f68850i / this.f68846e).a();
        }

        public void h() {
            this.f68845d = 0;
            this.f68846e = 0;
            this.f68847f = 0;
            this.f68848g = 0;
            this.f68849h = 0;
            this.f68850i = 0;
            this.f68842a.S(0);
            this.f68844c = false;
        }
    }

    private static u1.a d(j0 j0Var, C0855a c0855a) {
        int g11 = j0Var.g();
        int H = j0Var.H();
        int P = j0Var.P();
        int f11 = j0Var.f() + P;
        u1.a aVar = null;
        if (f11 > g11) {
            j0Var.W(g11);
            return null;
        }
        if (H != 128) {
            switch (H) {
                case 20:
                    c0855a.g(j0Var, P);
                    break;
                case 21:
                    c0855a.e(j0Var, P);
                    break;
                case 22:
                    c0855a.f(j0Var, P);
                    break;
            }
        } else {
            aVar = c0855a.d();
            c0855a.h();
        }
        j0Var.W(f11);
        return aVar;
    }

    @Override // i3.s
    public void a(byte[] bArr, int i11, int i12, s.b bVar, m mVar) {
        this.f68838a.U(bArr, i12 + i11);
        this.f68838a.W(i11);
        if (this.f68841d == null) {
            this.f68841d = new Inflater();
        }
        if (a1.P0(this.f68838a, this.f68839b, this.f68841d)) {
            this.f68838a.U(this.f68839b.e(), this.f68839b.g());
        }
        this.f68840c.h();
        ArrayList arrayList = new ArrayList();
        while (this.f68838a.a() >= 3) {
            u1.a d11 = d(this.f68838a, this.f68840c);
            if (d11 != null) {
                arrayList.add(d11);
            }
        }
        mVar.accept(new e(arrayList, C.TIME_UNSET, C.TIME_UNSET));
    }

    @Override // i3.s
    public /* synthetic */ k b(byte[] bArr, int i11, int i12) {
        return r.a(this, bArr, i11, i12);
    }

    @Override // i3.s
    public int c() {
        return 2;
    }

    @Override // i3.s
    public /* synthetic */ void reset() {
        r.b(this);
    }
}
