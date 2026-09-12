package w4;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.h;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final h f77686a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f77687b;

    /* renamed from: c, reason: collision with root package name */
    public Object f77688c;

    /* renamed from: d, reason: collision with root package name */
    public final Interpolator f77689d;

    /* renamed from: e, reason: collision with root package name */
    public final Interpolator f77690e;

    /* renamed from: f, reason: collision with root package name */
    public final Interpolator f77691f;

    /* renamed from: g, reason: collision with root package name */
    public final float f77692g;

    /* renamed from: h, reason: collision with root package name */
    public Float f77693h;

    /* renamed from: i, reason: collision with root package name */
    private float f77694i;

    /* renamed from: j, reason: collision with root package name */
    private float f77695j;

    /* renamed from: k, reason: collision with root package name */
    private int f77696k;

    /* renamed from: l, reason: collision with root package name */
    private int f77697l;

    /* renamed from: m, reason: collision with root package name */
    private float f77698m;

    /* renamed from: n, reason: collision with root package name */
    private float f77699n;

    /* renamed from: o, reason: collision with root package name */
    public PointF f77700o;

    /* renamed from: p, reason: collision with root package name */
    public PointF f77701p;

    public a(h hVar, Object obj, Object obj2, Interpolator interpolator, float f11, Float f12) {
        this.f77694i = -3987645.8f;
        this.f77695j = -3987645.8f;
        this.f77696k = 784923401;
        this.f77697l = 784923401;
        this.f77698m = Float.MIN_VALUE;
        this.f77699n = Float.MIN_VALUE;
        this.f77700o = null;
        this.f77701p = null;
        this.f77686a = hVar;
        this.f77687b = obj;
        this.f77688c = obj2;
        this.f77689d = interpolator;
        this.f77690e = null;
        this.f77691f = null;
        this.f77692g = f11;
        this.f77693h = f12;
    }

    public a(h hVar, Object obj, Object obj2, Interpolator interpolator, Interpolator interpolator2, float f11, Float f12) {
        this.f77694i = -3987645.8f;
        this.f77695j = -3987645.8f;
        this.f77696k = 784923401;
        this.f77697l = 784923401;
        this.f77698m = Float.MIN_VALUE;
        this.f77699n = Float.MIN_VALUE;
        this.f77700o = null;
        this.f77701p = null;
        this.f77686a = hVar;
        this.f77687b = obj;
        this.f77688c = obj2;
        this.f77689d = null;
        this.f77690e = interpolator;
        this.f77691f = interpolator2;
        this.f77692g = f11;
        this.f77693h = f12;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(h hVar, Object obj, Object obj2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f11, Float f12) {
        this.f77694i = -3987645.8f;
        this.f77695j = -3987645.8f;
        this.f77696k = 784923401;
        this.f77697l = 784923401;
        this.f77698m = Float.MIN_VALUE;
        this.f77699n = Float.MIN_VALUE;
        this.f77700o = null;
        this.f77701p = null;
        this.f77686a = hVar;
        this.f77687b = obj;
        this.f77688c = obj2;
        this.f77689d = interpolator;
        this.f77690e = interpolator2;
        this.f77691f = interpolator3;
        this.f77692g = f11;
        this.f77693h = f12;
    }

    public a(Object obj) {
        this.f77694i = -3987645.8f;
        this.f77695j = -3987645.8f;
        this.f77696k = 784923401;
        this.f77697l = 784923401;
        this.f77698m = Float.MIN_VALUE;
        this.f77699n = Float.MIN_VALUE;
        this.f77700o = null;
        this.f77701p = null;
        this.f77686a = null;
        this.f77687b = obj;
        this.f77688c = obj;
        this.f77689d = null;
        this.f77690e = null;
        this.f77691f = null;
        this.f77692g = Float.MIN_VALUE;
        this.f77693h = Float.valueOf(Float.MAX_VALUE);
    }

    private a(Object obj, Object obj2) {
        this.f77694i = -3987645.8f;
        this.f77695j = -3987645.8f;
        this.f77696k = 784923401;
        this.f77697l = 784923401;
        this.f77698m = Float.MIN_VALUE;
        this.f77699n = Float.MIN_VALUE;
        this.f77700o = null;
        this.f77701p = null;
        this.f77686a = null;
        this.f77687b = obj;
        this.f77688c = obj2;
        this.f77689d = null;
        this.f77690e = null;
        this.f77691f = null;
        this.f77692g = Float.MIN_VALUE;
        this.f77693h = Float.valueOf(Float.MAX_VALUE);
    }

    public boolean a(float f11) {
        return f11 >= f() && f11 < c();
    }

    public a b(Object obj, Object obj2) {
        return new a(obj, obj2);
    }

    public float c() {
        if (this.f77686a == null) {
            return 1.0f;
        }
        if (this.f77699n == Float.MIN_VALUE) {
            if (this.f77693h == null) {
                this.f77699n = 1.0f;
            } else {
                this.f77699n = f() + ((this.f77693h.floatValue() - this.f77692g) / this.f77686a.e());
            }
        }
        return this.f77699n;
    }

    public float d() {
        if (this.f77695j == -3987645.8f) {
            this.f77695j = ((Float) this.f77688c).floatValue();
        }
        return this.f77695j;
    }

    public int e() {
        if (this.f77697l == 784923401) {
            this.f77697l = ((Integer) this.f77688c).intValue();
        }
        return this.f77697l;
    }

    public float f() {
        h hVar = this.f77686a;
        if (hVar == null) {
            return 0.0f;
        }
        if (this.f77698m == Float.MIN_VALUE) {
            this.f77698m = (this.f77692g - hVar.p()) / this.f77686a.e();
        }
        return this.f77698m;
    }

    public float g() {
        if (this.f77694i == -3987645.8f) {
            this.f77694i = ((Float) this.f77687b).floatValue();
        }
        return this.f77694i;
    }

    public int h() {
        if (this.f77696k == 784923401) {
            this.f77696k = ((Integer) this.f77687b).intValue();
        }
        return this.f77696k;
    }

    public boolean i() {
        return this.f77689d == null && this.f77690e == null && this.f77691f == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f77687b + ", endValue=" + this.f77688c + ", startFrame=" + this.f77692g + ", endFrame=" + this.f77693h + ", interpolator=" + this.f77689d + '}';
    }
}
