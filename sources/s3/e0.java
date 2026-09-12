package s3;

import androidx.core.view.InputDeviceCompat;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.p0;
import s3.l0;

/* loaded from: classes2.dex */
public final class e0 implements l0 {

    /* renamed from: a, reason: collision with root package name */
    private final d0 f75033a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f75034b = new androidx.media3.common.util.j0(32);

    /* renamed from: c, reason: collision with root package name */
    private int f75035c;

    /* renamed from: d, reason: collision with root package name */
    private int f75036d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f75037e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f75038f;

    public e0(d0 d0Var) {
        this.f75033a = d0Var;
    }

    @Override // s3.l0
    public void a(androidx.media3.common.util.j0 j0Var, int i11) {
        boolean z10 = (i11 & 1) != 0;
        int f11 = z10 ? j0Var.f() + j0Var.H() : -1;
        if (this.f75038f) {
            if (!z10) {
                return;
            }
            this.f75038f = false;
            j0Var.W(f11);
            this.f75036d = 0;
        }
        while (j0Var.a() > 0) {
            int i12 = this.f75036d;
            if (i12 < 3) {
                if (i12 == 0) {
                    int H = j0Var.H();
                    j0Var.W(j0Var.f() - 1);
                    if (H == 255) {
                        this.f75038f = true;
                        return;
                    }
                }
                int min = Math.min(j0Var.a(), 3 - this.f75036d);
                j0Var.l(this.f75034b.e(), this.f75036d, min);
                int i13 = this.f75036d + min;
                this.f75036d = i13;
                if (i13 == 3) {
                    this.f75034b.W(0);
                    this.f75034b.V(3);
                    this.f75034b.X(1);
                    int H2 = this.f75034b.H();
                    int H3 = this.f75034b.H();
                    this.f75037e = (H2 & 128) != 0;
                    this.f75035c = (((H2 & 15) << 8) | H3) + 3;
                    int b11 = this.f75034b.b();
                    int i14 = this.f75035c;
                    if (b11 < i14) {
                        this.f75034b.c(Math.min(InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(i14, this.f75034b.b() * 2)));
                    }
                }
            } else {
                int min2 = Math.min(j0Var.a(), this.f75035c - this.f75036d);
                j0Var.l(this.f75034b.e(), this.f75036d, min2);
                int i15 = this.f75036d + min2;
                this.f75036d = i15;
                int i16 = this.f75035c;
                if (i15 != i16) {
                    continue;
                } else {
                    if (!this.f75037e) {
                        this.f75034b.V(i16);
                    } else {
                        if (a1.x(this.f75034b.e(), 0, this.f75035c, -1) != 0) {
                            this.f75038f = true;
                            return;
                        }
                        this.f75034b.V(this.f75035c - 4);
                    }
                    this.f75034b.W(0);
                    this.f75033a.a(this.f75034b);
                    this.f75036d = 0;
                }
            }
        }
    }

    @Override // s3.l0
    public void b(p0 p0Var, l2.t tVar, l0.d dVar) {
        this.f75033a.b(p0Var, tVar, dVar);
        this.f75038f = true;
    }

    @Override // s3.l0
    public void seek() {
        this.f75038f = true;
    }
}
