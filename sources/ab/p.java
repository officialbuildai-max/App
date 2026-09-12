package ab;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public float f644a;

    /* renamed from: b, reason: collision with root package name */
    public float f645b;

    /* renamed from: c, reason: collision with root package name */
    public float f646c;

    /* renamed from: d, reason: collision with root package name */
    public float f647d;

    /* renamed from: e, reason: collision with root package name */
    public float f648e;

    /* renamed from: f, reason: collision with root package name */
    public float f649f;

    /* renamed from: g, reason: collision with root package name */
    private final List f650g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final List f651h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private boolean f652i;

    /* loaded from: classes4.dex */
    class a extends g {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f653c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Matrix f654d;

        a(List list, Matrix matrix) {
            this.f653c = list;
            this.f654d = matrix;
        }

        @Override // ab.p.g
        public void a(Matrix matrix, za.a aVar, int i11, Canvas canvas) {
            Iterator it = this.f653c.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(this.f654d, aVar, i11, canvas);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class b extends g {

        /* renamed from: c, reason: collision with root package name */
        private final d f656c;

        public b(d dVar) {
            this.f656c = dVar;
        }

        @Override // ab.p.g
        public void a(Matrix matrix, za.a aVar, int i11, Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.f656c.k(), this.f656c.o(), this.f656c.l(), this.f656c.j()), i11, this.f656c.m(), this.f656c.n());
        }
    }

    /* loaded from: classes4.dex */
    static class c extends g {

        /* renamed from: c, reason: collision with root package name */
        private final e f657c;

        /* renamed from: d, reason: collision with root package name */
        private final float f658d;

        /* renamed from: e, reason: collision with root package name */
        private final float f659e;

        public c(e eVar, float f11, float f12) {
            this.f657c = eVar;
            this.f658d = f11;
            this.f659e = f12;
        }

        @Override // ab.p.g
        public void a(Matrix matrix, za.a aVar, int i11, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f657c.f668c - this.f659e, this.f657c.f667b - this.f658d), 0.0f);
            this.f671a.set(matrix);
            this.f671a.preTranslate(this.f658d, this.f659e);
            this.f671a.preRotate(c());
            aVar.b(canvas, this.f671a, rectF, i11);
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((this.f657c.f668c - this.f659e) / (this.f657c.f667b - this.f658d)));
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends f {

        /* renamed from: h, reason: collision with root package name */
        private static final RectF f660h = new RectF();

        /* renamed from: b, reason: collision with root package name */
        public float f661b;

        /* renamed from: c, reason: collision with root package name */
        public float f662c;

        /* renamed from: d, reason: collision with root package name */
        public float f663d;

        /* renamed from: e, reason: collision with root package name */
        public float f664e;

        /* renamed from: f, reason: collision with root package name */
        public float f665f;

        /* renamed from: g, reason: collision with root package name */
        public float f666g;

        public d(float f11, float f12, float f13, float f14) {
            q(f11);
            u(f12);
            r(f13);
            p(f14);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float j() {
            return this.f664e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float k() {
            return this.f661b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float l() {
            return this.f663d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float m() {
            return this.f665f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float n() {
            return this.f666g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float o() {
            return this.f662c;
        }

        private void p(float f11) {
            this.f664e = f11;
        }

        private void q(float f11) {
            this.f661b = f11;
        }

        private void r(float f11) {
            this.f663d = f11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f11) {
            this.f665f = f11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(float f11) {
            this.f666g = f11;
        }

        private void u(float f11) {
            this.f662c = f11;
        }

        @Override // ab.p.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f669a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f660h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends f {

        /* renamed from: b, reason: collision with root package name */
        private float f667b;

        /* renamed from: c, reason: collision with root package name */
        private float f668c;

        @Override // ab.p.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f669a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f667b, this.f668c);
            path.transform(matrix);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        protected final Matrix f669a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static abstract class g {

        /* renamed from: b, reason: collision with root package name */
        static final Matrix f670b = new Matrix();

        /* renamed from: a, reason: collision with root package name */
        final Matrix f671a = new Matrix();

        g() {
        }

        public abstract void a(Matrix matrix, za.a aVar, int i11, Canvas canvas);

        public final void b(za.a aVar, int i11, Canvas canvas) {
            a(f670b, aVar, i11, canvas);
        }
    }

    public p() {
        n(0.0f, 0.0f);
    }

    private void b(float f11) {
        if (g() == f11) {
            return;
        }
        float g11 = ((f11 - g()) + 360.0f) % 360.0f;
        if (g11 > 180.0f) {
            return;
        }
        d dVar = new d(i(), j(), i(), j());
        dVar.s(g());
        dVar.t(g11);
        this.f651h.add(new b(dVar));
        p(f11);
    }

    private void c(g gVar, float f11, float f12) {
        b(f11);
        this.f651h.add(gVar);
        p(f12);
    }

    private float g() {
        return this.f648e;
    }

    private float h() {
        return this.f649f;
    }

    private void p(float f11) {
        this.f648e = f11;
    }

    private void q(float f11) {
        this.f649f = f11;
    }

    private void r(float f11) {
        this.f646c = f11;
    }

    private void s(float f11) {
        this.f647d = f11;
    }

    private void t(float f11) {
        this.f644a = f11;
    }

    private void u(float f11) {
        this.f645b = f11;
    }

    public void a(float f11, float f12, float f13, float f14, float f15, float f16) {
        d dVar = new d(f11, f12, f13, f14);
        dVar.s(f15);
        dVar.t(f16);
        this.f650g.add(dVar);
        b bVar = new b(dVar);
        float f17 = f15 + f16;
        boolean z10 = f16 < 0.0f;
        if (z10) {
            f15 = (f15 + 180.0f) % 360.0f;
        }
        c(bVar, f15, z10 ? (180.0f + f17) % 360.0f : f17);
        double d11 = f17;
        r(((f11 + f13) * 0.5f) + (((f13 - f11) / 2.0f) * ((float) Math.cos(Math.toRadians(d11)))));
        s(((f12 + f14) * 0.5f) + (((f14 - f12) / 2.0f) * ((float) Math.sin(Math.toRadians(d11)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f650g.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((f) this.f650g.get(i11)).a(matrix, path);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f652i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g f(Matrix matrix) {
        b(h());
        return new a(new ArrayList(this.f651h), new Matrix(matrix));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        return this.f646c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.f647d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float k() {
        return this.f644a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float l() {
        return this.f645b;
    }

    public void m(float f11, float f12) {
        e eVar = new e();
        eVar.f667b = f11;
        eVar.f668c = f12;
        this.f650g.add(eVar);
        c cVar = new c(eVar, i(), j());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        r(f11);
        s(f12);
    }

    public void n(float f11, float f12) {
        o(f11, f12, 270.0f, 0.0f);
    }

    public void o(float f11, float f12, float f13, float f14) {
        t(f11);
        u(f12);
        r(f11);
        s(f12);
        p(f13);
        q((f13 + f14) % 360.0f);
        this.f650g.clear();
        this.f651h.clear();
        this.f652i = false;
    }
}
