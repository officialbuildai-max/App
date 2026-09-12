package androidx.compose.ui.graphics;

import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;
import androidx.compose.ui.graphics.c5;
import androidx.compose.ui.graphics.d5;

/* loaded from: classes.dex */
public abstract class t0 {

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4719a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f4720b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f4721c;

        static {
            int[] iArr = new int[Paint.Style.values().length];
            try {
                iArr[Paint.Style.STROKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f4719a = iArr;
            int[] iArr2 = new int[Paint.Cap.values().length];
            try {
                iArr2[Paint.Cap.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[Paint.Cap.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[Paint.Cap.SQUARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            f4720b = iArr2;
            int[] iArr3 = new int[Paint.Join.values().length];
            try {
                iArr3[Paint.Join.MITER.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[Paint.Join.BEVEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[Paint.Join.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            f4721c = iArr3;
        }
    }

    public static final m4 a() {
        return new s0();
    }

    public static final m4 b(Paint paint) {
        return new s0(paint);
    }

    public static final float c(Paint paint) {
        return paint.getAlpha() / 255.0f;
    }

    public static final long d(Paint paint) {
        return w1.b(paint.getColor());
    }

    public static final int e(Paint paint) {
        return !paint.isFilterBitmap() ? x3.f4954a.b() : x3.f4954a.a();
    }

    public static final int f(Paint paint) {
        Paint.Cap strokeCap = paint.getStrokeCap();
        int i11 = strokeCap == null ? -1 : a.f4720b[strokeCap.ordinal()];
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? c5.f4393a.a() : c5.f4393a.c() : c5.f4393a.b() : c5.f4393a.a();
    }

    public static final int g(Paint paint) {
        Paint.Join strokeJoin = paint.getStrokeJoin();
        int i11 = strokeJoin == null ? -1 : a.f4721c[strokeJoin.ordinal()];
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? d5.f4505a.b() : d5.f4505a.c() : d5.f4505a.a() : d5.f4505a.b();
    }

    public static final float h(Paint paint) {
        return paint.getStrokeMiter();
    }

    public static final float i(Paint paint) {
        return paint.getStrokeWidth();
    }

    public static final Paint j() {
        return new Paint(7);
    }

    public static final void k(Paint paint, float f11) {
        paint.setAlpha((int) Math.rint(f11 * 255.0f));
    }

    public static final void l(Paint paint, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            h5.f4525a.a(paint, i11);
        } else {
            paint.setXfermode(new PorterDuffXfermode(f0.c(i11)));
        }
    }

    public static final void m(Paint paint, long j11) {
        paint.setColor(w1.j(j11));
    }

    public static final void n(Paint paint, v1 v1Var) {
        paint.setColorFilter(v1Var != null ? i0.b(v1Var) : null);
    }

    public static final void o(Paint paint, int i11) {
        paint.setFilterBitmap(!x3.d(i11, x3.f4954a.b()));
    }

    public static final void p(Paint paint, p4 p4Var) {
        android.support.v4.media.session.c.a(p4Var);
        paint.setPathEffect(null);
    }

    public static final void q(Paint paint, Shader shader) {
        paint.setShader(shader);
    }

    public static final void r(Paint paint, int i11) {
        c5.a aVar = c5.f4393a;
        paint.setStrokeCap(c5.e(i11, aVar.c()) ? Paint.Cap.SQUARE : c5.e(i11, aVar.b()) ? Paint.Cap.ROUND : c5.e(i11, aVar.a()) ? Paint.Cap.BUTT : Paint.Cap.BUTT);
    }

    public static final void s(Paint paint, int i11) {
        d5.a aVar = d5.f4505a;
        paint.setStrokeJoin(d5.e(i11, aVar.b()) ? Paint.Join.MITER : d5.e(i11, aVar.a()) ? Paint.Join.BEVEL : d5.e(i11, aVar.c()) ? Paint.Join.ROUND : Paint.Join.MITER);
    }

    public static final void t(Paint paint, float f11) {
        paint.setStrokeMiter(f11);
    }

    public static final void u(Paint paint, float f11) {
        paint.setStrokeWidth(f11);
    }

    public static final void v(Paint paint, int i11) {
        paint.setStyle(n4.d(i11, n4.f4683a.b()) ? Paint.Style.STROKE : Paint.Style.FILL);
    }
}
