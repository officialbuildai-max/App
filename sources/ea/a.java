package ea;

import android.graphics.Bitmap;
import ba.b;
import ba.h;
import ba.i;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;

/* loaded from: classes4.dex */
public final class a extends h {

    /* renamed from: o, reason: collision with root package name */
    private final d0 f61952o;

    /* renamed from: p, reason: collision with root package name */
    private final d0 f61953p;

    /* renamed from: q, reason: collision with root package name */
    private final C0767a f61954q;

    /* renamed from: r, reason: collision with root package name */
    private Inflater f61955r;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ea.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0767a {

        /* renamed from: a, reason: collision with root package name */
        private final d0 f61956a = new d0();

        /* renamed from: b, reason: collision with root package name */
        private final int[] f61957b = new int[256];

        /* renamed from: c, reason: collision with root package name */
        private boolean f61958c;

        /* renamed from: d, reason: collision with root package name */
        private int f61959d;

        /* renamed from: e, reason: collision with root package name */
        private int f61960e;

        /* renamed from: f, reason: collision with root package name */
        private int f61961f;

        /* renamed from: g, reason: collision with root package name */
        private int f61962g;

        /* renamed from: h, reason: collision with root package name */
        private int f61963h;

        /* renamed from: i, reason: collision with root package name */
        private int f61964i;

        /* JADX INFO: Access modifiers changed from: private */
        public void e(d0 d0Var, int i11) {
            int G;
            if (i11 < 4) {
                return;
            }
            d0Var.Q(3);
            int i12 = i11 - 4;
            if ((d0Var.D() & 128) != 0) {
                if (i12 < 7 || (G = d0Var.G()) < 4) {
                    return;
                }
                this.f61963h = d0Var.J();
                this.f61964i = d0Var.J();
                this.f61956a.L(G - 4);
                i12 = i11 - 11;
            }
            int e11 = this.f61956a.e();
            int f11 = this.f61956a.f();
            if (e11 >= f11 || i12 <= 0) {
                return;
            }
            int min = Math.min(i12, f11 - e11);
            d0Var.j(this.f61956a.d(), e11, min);
            this.f61956a.P(e11 + min);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(d0 d0Var, int i11) {
            if (i11 < 19) {
                return;
            }
            this.f61959d = d0Var.J();
            this.f61960e = d0Var.J();
            d0Var.Q(11);
            this.f61961f = d0Var.J();
            this.f61962g = d0Var.J();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(d0 d0Var, int i11) {
            if (i11 % 5 != 2) {
                return;
            }
            d0Var.Q(2);
            Arrays.fill(this.f61957b, 0);
            int i12 = i11 / 5;
            for (int i13 = 0; i13 < i12; i13++) {
                int D = d0Var.D();
                int D2 = d0Var.D();
                int D3 = d0Var.D();
                int D4 = d0Var.D();
                double d11 = D2;
                double d12 = D3 - 128;
                double d13 = D4 - 128;
                this.f61957b[D] = (p0.q((int) ((d11 - (0.34414d * d13)) - (d12 * 0.71414d)), 0, 255) << 8) | (d0Var.D() << 24) | (p0.q((int) ((1.402d * d12) + d11), 0, 255) << 16) | p0.q((int) (d11 + (d13 * 1.772d)), 0, 255);
            }
            this.f61958c = true;
        }

        public ba.b d() {
            int i11;
            if (this.f61959d == 0 || this.f61960e == 0 || this.f61963h == 0 || this.f61964i == 0 || this.f61956a.f() == 0 || this.f61956a.e() != this.f61956a.f() || !this.f61958c) {
                return null;
            }
            this.f61956a.P(0);
            int i12 = this.f61963h * this.f61964i;
            int[] iArr = new int[i12];
            int i13 = 0;
            while (i13 < i12) {
                int D = this.f61956a.D();
                if (D != 0) {
                    i11 = i13 + 1;
                    iArr[i13] = this.f61957b[D];
                } else {
                    int D2 = this.f61956a.D();
                    if (D2 != 0) {
                        i11 = ((D2 & 64) == 0 ? D2 & 63 : ((D2 & 63) << 8) | this.f61956a.D()) + i13;
                        Arrays.fill(iArr, i13, i11, (D2 & 128) == 0 ? 0 : this.f61957b[this.f61956a.D()]);
                    }
                }
                i13 = i11;
            }
            return new b.C0151b().f(Bitmap.createBitmap(iArr, this.f61963h, this.f61964i, Bitmap.Config.ARGB_8888)).k(this.f61961f / this.f61959d).l(0).h(this.f61962g / this.f61960e, 0).i(0).n(this.f61963h / this.f61959d).g(this.f61964i / this.f61960e).a();
        }

        public void h() {
            this.f61959d = 0;
            this.f61960e = 0;
            this.f61961f = 0;
            this.f61962g = 0;
            this.f61963h = 0;
            this.f61964i = 0;
            this.f61956a.L(0);
            this.f61958c = false;
        }
    }

    public a() {
        super("PgsDecoder");
        this.f61952o = new d0();
        this.f61953p = new d0();
        this.f61954q = new C0767a();
    }

    private void x(d0 d0Var) {
        if (d0Var.a() <= 0 || d0Var.h() != 120) {
            return;
        }
        if (this.f61955r == null) {
            this.f61955r = new Inflater();
        }
        if (p0.r0(d0Var, this.f61953p, this.f61955r)) {
            d0Var.N(this.f61953p.d(), this.f61953p.f());
        }
    }

    private static ba.b y(d0 d0Var, C0767a c0767a) {
        int f11 = d0Var.f();
        int D = d0Var.D();
        int J = d0Var.J();
        int e11 = d0Var.e() + J;
        ba.b bVar = null;
        if (e11 > f11) {
            d0Var.P(f11);
            return null;
        }
        if (D != 128) {
            switch (D) {
                case 20:
                    c0767a.g(d0Var, J);
                    break;
                case 21:
                    c0767a.e(d0Var, J);
                    break;
                case 22:
                    c0767a.f(d0Var, J);
                    break;
            }
        } else {
            bVar = c0767a.d();
            c0767a.h();
        }
        d0Var.P(e11);
        return bVar;
    }

    @Override // ba.h
    protected i v(byte[] bArr, int i11, boolean z10) {
        this.f61952o.N(bArr, i11);
        x(this.f61952o);
        this.f61954q.h();
        ArrayList arrayList = new ArrayList();
        while (this.f61952o.a() >= 3) {
            ba.b y10 = y(this.f61952o, this.f61954q);
            if (y10 != null) {
                arrayList.add(y10);
            }
        }
        return new b(Collections.unmodifiableList(arrayList));
    }
}
