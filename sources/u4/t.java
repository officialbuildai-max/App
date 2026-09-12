package u4;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.y0;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
abstract class t {

    /* renamed from: b, reason: collision with root package name */
    private static y0 f76794b;

    /* renamed from: a, reason: collision with root package name */
    private static final Interpolator f76793a = new LinearInterpolator();

    /* renamed from: c, reason: collision with root package name */
    static JsonReader.a f76795c = JsonReader.a.a("t", "s", "e", "o", "i", "h", "to", "ti");

    /* renamed from: d, reason: collision with root package name */
    static JsonReader.a f76796d = JsonReader.a.a("x", "y");

    private static WeakReference a(int i11) {
        WeakReference weakReference;
        synchronized (t.class) {
            weakReference = (WeakReference) g().f(i11);
        }
        return weakReference;
    }

    private static Interpolator b(PointF pointF, PointF pointF2) {
        Interpolator create;
        pointF.x = v4.k.b(pointF.x, -1.0f, 1.0f);
        pointF.y = v4.k.b(pointF.y, -100.0f, 100.0f);
        pointF2.x = v4.k.b(pointF2.x, -1.0f, 1.0f);
        float b11 = v4.k.b(pointF2.y, -100.0f, 100.0f);
        pointF2.y = b11;
        int i11 = v4.l.i(pointF.x, pointF.y, pointF2.x, b11);
        WeakReference a11 = com.airbnb.lottie.d.e() ? null : a(i11);
        Interpolator interpolator = a11 != null ? (Interpolator) a11.get() : null;
        if (a11 == null || interpolator == null) {
            try {
                create = PathInterpolatorCompat.create(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e11) {
                create = "The Path cannot loop back on itself.".equals(e11.getMessage()) ? PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y) : new LinearInterpolator();
            }
            interpolator = create;
            if (!com.airbnb.lottie.d.e()) {
                try {
                    h(i11, new WeakReference(interpolator));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
        }
        return interpolator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static w4.a c(JsonReader jsonReader, com.airbnb.lottie.h hVar, float f11, n0 n0Var, boolean z10, boolean z11) {
        return (z10 && z11) ? e(hVar, jsonReader, f11, n0Var) : z10 ? d(hVar, jsonReader, f11, n0Var) : f(jsonReader, f11, n0Var);
    }

    private static w4.a d(com.airbnb.lottie.h hVar, JsonReader jsonReader, float f11, n0 n0Var) {
        Interpolator b11;
        Object obj;
        jsonReader.h();
        PointF pointF = null;
        Object obj2 = null;
        Object obj3 = null;
        PointF pointF2 = null;
        PointF pointF3 = null;
        float f12 = 0.0f;
        boolean z10 = false;
        PointF pointF4 = null;
        while (jsonReader.m()) {
            switch (jsonReader.v(f76795c)) {
                case 0:
                    f12 = (float) jsonReader.o();
                    break;
                case 1:
                    obj3 = n0Var.a(jsonReader, f11);
                    break;
                case 2:
                    obj2 = n0Var.a(jsonReader, f11);
                    break;
                case 3:
                    pointF = s.e(jsonReader, 1.0f);
                    break;
                case 4:
                    pointF4 = s.e(jsonReader, 1.0f);
                    break;
                case 5:
                    if (jsonReader.p() != 1) {
                        z10 = false;
                        break;
                    } else {
                        z10 = true;
                        break;
                    }
                case 6:
                    pointF2 = s.e(jsonReader, f11);
                    break;
                case 7:
                    pointF3 = s.e(jsonReader, f11);
                    break;
                default:
                    jsonReader.x();
                    break;
            }
        }
        jsonReader.l();
        if (z10) {
            b11 = f76793a;
            obj = obj3;
        } else {
            b11 = (pointF == null || pointF4 == null) ? f76793a : b(pointF, pointF4);
            obj = obj2;
        }
        w4.a aVar = new w4.a(hVar, obj3, obj, b11, f12, null);
        aVar.f77700o = pointF2;
        aVar.f77701p = pointF3;
        return aVar;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0023. Please report as an issue. */
    private static w4.a e(com.airbnb.lottie.h hVar, JsonReader jsonReader, float f11, n0 n0Var) {
        Interpolator interpolator;
        Interpolator b11;
        Interpolator b12;
        Object obj;
        PointF pointF;
        w4.a aVar;
        PointF pointF2;
        float f12;
        PointF pointF3;
        jsonReader.h();
        PointF pointF4 = null;
        boolean z10 = false;
        PointF pointF5 = null;
        PointF pointF6 = null;
        PointF pointF7 = null;
        Object obj2 = null;
        PointF pointF8 = null;
        PointF pointF9 = null;
        PointF pointF10 = null;
        float f13 = 0.0f;
        PointF pointF11 = null;
        Object obj3 = null;
        while (jsonReader.m()) {
            switch (jsonReader.v(f76795c)) {
                case 0:
                    pointF2 = pointF4;
                    f13 = (float) jsonReader.o();
                    pointF4 = pointF2;
                    break;
                case 1:
                    pointF2 = pointF4;
                    obj2 = n0Var.a(jsonReader, f11);
                    pointF4 = pointF2;
                    break;
                case 2:
                    pointF2 = pointF4;
                    obj3 = n0Var.a(jsonReader, f11);
                    pointF4 = pointF2;
                    break;
                case 3:
                    pointF2 = pointF4;
                    f12 = f13;
                    PointF pointF12 = pointF11;
                    if (jsonReader.t() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.h();
                        float f14 = 0.0f;
                        float f15 = 0.0f;
                        float f16 = 0.0f;
                        float f17 = 0.0f;
                        while (jsonReader.m()) {
                            int v11 = jsonReader.v(f76796d);
                            if (v11 == 0) {
                                JsonReader.Token t11 = jsonReader.t();
                                JsonReader.Token token = JsonReader.Token.NUMBER;
                                if (t11 == token) {
                                    f16 = (float) jsonReader.o();
                                    f14 = f16;
                                } else {
                                    jsonReader.d();
                                    f14 = (float) jsonReader.o();
                                    f16 = jsonReader.t() == token ? (float) jsonReader.o() : f14;
                                    jsonReader.k();
                                }
                            } else if (v11 != 1) {
                                jsonReader.x();
                            } else {
                                JsonReader.Token t12 = jsonReader.t();
                                JsonReader.Token token2 = JsonReader.Token.NUMBER;
                                if (t12 == token2) {
                                    f17 = (float) jsonReader.o();
                                    f15 = f17;
                                } else {
                                    jsonReader.d();
                                    f15 = (float) jsonReader.o();
                                    f17 = jsonReader.t() == token2 ? (float) jsonReader.o() : f15;
                                    jsonReader.k();
                                }
                            }
                        }
                        PointF pointF13 = new PointF(f14, f15);
                        PointF pointF14 = new PointF(f16, f17);
                        jsonReader.l();
                        pointF8 = pointF14;
                        pointF7 = pointF13;
                        pointF11 = pointF12;
                        f13 = f12;
                        pointF4 = pointF2;
                        break;
                    } else {
                        pointF5 = s.e(jsonReader, f11);
                        f13 = f12;
                        pointF11 = pointF12;
                        pointF4 = pointF2;
                    }
                case 4:
                    if (jsonReader.t() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.h();
                        float f18 = 0.0f;
                        float f19 = 0.0f;
                        float f20 = 0.0f;
                        float f21 = 0.0f;
                        while (jsonReader.m()) {
                            PointF pointF15 = pointF11;
                            int v12 = jsonReader.v(f76796d);
                            if (v12 != 0) {
                                pointF3 = pointF4;
                                if (v12 != 1) {
                                    jsonReader.x();
                                } else {
                                    JsonReader.Token t13 = jsonReader.t();
                                    JsonReader.Token token3 = JsonReader.Token.NUMBER;
                                    if (t13 == token3) {
                                        f21 = (float) jsonReader.o();
                                        f13 = f13;
                                        f19 = f21;
                                    } else {
                                        float f22 = f13;
                                        jsonReader.d();
                                        float o11 = (float) jsonReader.o();
                                        float o12 = jsonReader.t() == token3 ? (float) jsonReader.o() : o11;
                                        jsonReader.k();
                                        f13 = f22;
                                        pointF11 = pointF15;
                                        pointF4 = pointF3;
                                        f21 = o12;
                                        f19 = o11;
                                    }
                                }
                            } else {
                                pointF3 = pointF4;
                                float f23 = f13;
                                JsonReader.Token t14 = jsonReader.t();
                                JsonReader.Token token4 = JsonReader.Token.NUMBER;
                                if (t14 == token4) {
                                    f20 = (float) jsonReader.o();
                                    f13 = f23;
                                    f18 = f20;
                                } else {
                                    jsonReader.d();
                                    f18 = (float) jsonReader.o();
                                    f20 = jsonReader.t() == token4 ? (float) jsonReader.o() : f18;
                                    jsonReader.k();
                                    f13 = f23;
                                }
                            }
                            pointF11 = pointF15;
                            pointF4 = pointF3;
                        }
                        pointF2 = pointF4;
                        f12 = f13;
                        PointF pointF16 = new PointF(f18, f19);
                        PointF pointF17 = new PointF(f20, f21);
                        jsonReader.l();
                        pointF10 = pointF17;
                        pointF9 = pointF16;
                        f13 = f12;
                        pointF4 = pointF2;
                        break;
                    } else {
                        pointF2 = pointF4;
                        pointF6 = s.e(jsonReader, f11);
                        pointF4 = pointF2;
                    }
                case 5:
                    if (jsonReader.p() != 1) {
                        z10 = false;
                        break;
                    } else {
                        z10 = true;
                        break;
                    }
                case 6:
                    pointF11 = s.e(jsonReader, f11);
                    break;
                case 7:
                    pointF4 = s.e(jsonReader, f11);
                    break;
                default:
                    jsonReader.x();
                    break;
            }
        }
        PointF pointF18 = pointF4;
        float f24 = f13;
        PointF pointF19 = pointF11;
        jsonReader.l();
        if (z10) {
            interpolator = f76793a;
            obj = obj2;
        } else {
            if (pointF5 != null && pointF6 != null) {
                interpolator = b(pointF5, pointF6);
            } else {
                if (pointF7 != null && pointF8 != null && pointF9 != null && pointF10 != null) {
                    b11 = b(pointF7, pointF9);
                    b12 = b(pointF8, pointF10);
                    obj = obj3;
                    interpolator = null;
                    if (b11 != null || b12 == null) {
                        pointF = pointF19;
                        aVar = new w4.a(hVar, obj2, obj, interpolator, f24, null);
                    } else {
                        pointF = pointF19;
                        aVar = new w4.a(hVar, obj2, obj, b11, b12, f24, null);
                    }
                    aVar.f77700o = pointF;
                    aVar.f77701p = pointF18;
                    return aVar;
                }
                interpolator = f76793a;
            }
            obj = obj3;
        }
        b11 = null;
        b12 = null;
        if (b11 != null) {
        }
        pointF = pointF19;
        aVar = new w4.a(hVar, obj2, obj, interpolator, f24, null);
        aVar.f77700o = pointF;
        aVar.f77701p = pointF18;
        return aVar;
    }

    private static w4.a f(JsonReader jsonReader, float f11, n0 n0Var) {
        return new w4.a(n0Var.a(jsonReader, f11));
    }

    private static y0 g() {
        if (f76794b == null) {
            f76794b = new y0();
        }
        return f76794b;
    }

    private static void h(int i11, WeakReference weakReference) {
        synchronized (t.class) {
            f76794b.l(i11, weakReference);
        }
    }
}
