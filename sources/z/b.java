package z;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.h4;
import androidx.compose.ui.graphics.m1;
import y.n;

/* loaded from: classes2.dex */
public abstract class b {

    /* loaded from: classes2.dex */
    public static final class a implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f79231a;

        a(d dVar) {
            this.f79231a = dVar;
        }

        @Override // z.j
        public void a(float f11, float f12, float f13, float f14, int i11) {
            this.f79231a.e().a(f11, f12, f13, f14, i11);
        }

        @Override // z.j
        public void b(Path path, int i11) {
            this.f79231a.e().b(path, i11);
        }

        @Override // z.j
        public void c(float f11, float f12) {
            this.f79231a.e().c(f11, f12);
        }

        @Override // z.j
        public void d(float[] fArr) {
            this.f79231a.e().p(fArr);
        }

        @Override // z.j
        public void e(float f11, float f12, long j11) {
            m1 e11 = this.f79231a.e();
            e11.c(y.g.m(j11), y.g.n(j11));
            e11.e(f11, f12);
            e11.c(-y.g.m(j11), -y.g.n(j11));
        }

        @Override // z.j
        public void f(float f11, float f12, float f13, float f14) {
            m1 e11 = this.f79231a.e();
            d dVar = this.f79231a;
            long a11 = n.a(y.m.i(g()) - (f13 + f11), y.m.g(g()) - (f14 + f12));
            if (!(y.m.i(a11) >= 0.0f && y.m.g(a11) >= 0.0f)) {
                h4.a("Width and height must be greater than or equal to zero");
            }
            dVar.f(a11);
            e11.c(f11, f12);
        }

        public long g() {
            return this.f79231a.i();
        }
    }

    public static final /* synthetic */ j a(d dVar) {
        return b(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final j b(d dVar) {
        return new a(dVar);
    }
}
