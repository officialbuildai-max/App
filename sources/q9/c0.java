package q9;

import androidx.core.view.InputDeviceCompat;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.p0;
import q9.i0;

/* loaded from: classes4.dex */
public final class c0 implements i0 {

    /* renamed from: a, reason: collision with root package name */
    private final b0 f73334a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.d0 f73335b = new com.google.android.exoplayer2.util.d0(32);

    /* renamed from: c, reason: collision with root package name */
    private int f73336c;

    /* renamed from: d, reason: collision with root package name */
    private int f73337d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f73338e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f73339f;

    public c0(b0 b0Var) {
        this.f73334a = b0Var;
    }

    @Override // q9.i0
    public void a(com.google.android.exoplayer2.util.d0 d0Var, int i11) {
        boolean z10 = (i11 & 1) != 0;
        int e11 = z10 ? d0Var.e() + d0Var.D() : -1;
        if (this.f73339f) {
            if (!z10) {
                return;
            }
            this.f73339f = false;
            d0Var.P(e11);
            this.f73337d = 0;
        }
        while (d0Var.a() > 0) {
            int i12 = this.f73337d;
            if (i12 < 3) {
                if (i12 == 0) {
                    int D = d0Var.D();
                    d0Var.P(d0Var.e() - 1);
                    if (D == 255) {
                        this.f73339f = true;
                        return;
                    }
                }
                int min = Math.min(d0Var.a(), 3 - this.f73337d);
                d0Var.j(this.f73335b.d(), this.f73337d, min);
                int i13 = this.f73337d + min;
                this.f73337d = i13;
                if (i13 == 3) {
                    this.f73335b.P(0);
                    this.f73335b.O(3);
                    this.f73335b.Q(1);
                    int D2 = this.f73335b.D();
                    int D3 = this.f73335b.D();
                    this.f73338e = (D2 & 128) != 0;
                    this.f73336c = (((D2 & 15) << 8) | D3) + 3;
                    int b11 = this.f73335b.b();
                    int i14 = this.f73336c;
                    if (b11 < i14) {
                        this.f73335b.c(Math.min(InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(i14, this.f73335b.b() * 2)));
                    }
                }
            } else {
                int min2 = Math.min(d0Var.a(), this.f73336c - this.f73337d);
                d0Var.j(this.f73335b.d(), this.f73337d, min2);
                int i15 = this.f73337d + min2;
                this.f73337d = i15;
                int i16 = this.f73336c;
                if (i15 != i16) {
                    continue;
                } else {
                    if (!this.f73338e) {
                        this.f73335b.O(i16);
                    } else {
                        if (p0.t(this.f73335b.d(), 0, this.f73336c, -1) != 0) {
                            this.f73339f = true;
                            return;
                        }
                        this.f73335b.O(this.f73336c - 4);
                    }
                    this.f73335b.P(0);
                    this.f73334a.a(this.f73335b);
                    this.f73337d = 0;
                }
            }
        }
    }

    @Override // q9.i0
    public void b(l0 l0Var, g9.n nVar, i0.d dVar) {
        this.f73334a.b(l0Var, nVar, dVar);
        this.f73339f = true;
    }

    @Override // q9.i0
    public void seek() {
        this.f73339f = true;
    }
}
