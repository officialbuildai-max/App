package p0;

import androidx.collection.y0;
import kotlin.Unit;
import o0.o;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f72344a;

    /* renamed from: b, reason: collision with root package name */
    private static final float[] f72345b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile y0 f72346c;

    /* renamed from: d, reason: collision with root package name */
    private static final Object[] f72347d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f72348e;

    static {
        b bVar = new b();
        f72344a = bVar;
        f72345b = new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f};
        f72346c = new y0(0, 1, null);
        Object[] objArr = new Object[0];
        f72347d = objArr;
        synchronized (objArr) {
            bVar.h(f72346c, 1.15f, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{9.2f, 11.5f, 13.8f, 16.4f, 19.8f, 21.8f, 25.2f, 30.0f, 100.0f}));
            bVar.h(f72346c, 1.3f, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{10.4f, 13.0f, 15.6f, 18.8f, 21.6f, 23.6f, 26.4f, 30.0f, 100.0f}));
            bVar.h(f72346c, 1.5f, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{12.0f, 15.0f, 18.0f, 22.0f, 24.0f, 26.0f, 28.0f, 30.0f, 100.0f}));
            bVar.h(f72346c, 1.8f, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{14.4f, 18.0f, 21.6f, 24.4f, 27.6f, 30.8f, 32.8f, 34.8f, 100.0f}));
            bVar.h(f72346c, 2.0f, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{16.0f, 20.0f, 24.0f, 26.0f, 30.0f, 34.0f, 36.0f, 38.0f, 100.0f}));
            Unit unit = Unit.f67184a;
        }
        if (!(bVar.e(f72346c.k(0)) - 0.01f > 1.03f)) {
            o.b("You should only apply non-linear scaling to font scales > 1");
        }
        f72348e = 8;
    }

    private b() {
    }

    private final a a(a aVar, a aVar2, float f11) {
        float[] fArr = f72345b;
        float[] fArr2 = new float[fArr.length];
        int length = fArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            float f12 = f72345b[i11];
            fArr2[i11] = d.f72353a.b(aVar.b(f12), aVar2.b(f12), f11);
        }
        return new c(f72345b, fArr2);
    }

    private final a c(float f11) {
        return (a) f72346c.f(d(f11));
    }

    private final int d(float f11) {
        return (int) (f11 * 100.0f);
    }

    private final float e(int i11) {
        return i11 / 100.0f;
    }

    private final void g(float f11, a aVar) {
        synchronized (f72347d) {
            y0 clone = f72346c.clone();
            f72344a.h(clone, f11, aVar);
            f72346c = clone;
            Unit unit = Unit.f67184a;
        }
    }

    private final void h(y0 y0Var, float f11, a aVar) {
        y0Var.l(d(f11), aVar);
    }

    public final a b(float f11) {
        a aVar;
        if (!f(f11)) {
            return null;
        }
        a c11 = f72344a.c(f11);
        if (c11 != null) {
            return c11;
        }
        int i11 = f72346c.i(d(f11));
        if (i11 >= 0) {
            return (a) f72346c.q(i11);
        }
        int i12 = -(i11 + 1);
        int i13 = i12 - 1;
        float f12 = 1.0f;
        if (i12 >= f72346c.p()) {
            c cVar = new c(new float[]{1.0f}, new float[]{f11});
            g(f11, cVar);
            return cVar;
        }
        if (i13 < 0) {
            float[] fArr = f72345b;
            aVar = new c(fArr, fArr);
        } else {
            f12 = e(f72346c.k(i13));
            aVar = (a) f72346c.q(i13);
        }
        a a11 = a(aVar, (a) f72346c.q(i12), d.f72353a.a(0.0f, 1.0f, f12, e(f72346c.k(i12)), f11));
        g(f11, a11);
        return a11;
    }

    public final boolean f(float f11) {
        return f11 >= 1.03f;
    }
}
