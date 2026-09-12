package v0;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.core.app.NotificationCompat;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public abstract class d extends androidx.constraintlayout.core.motion.utils.i {

    /* loaded from: classes2.dex */
    static class a extends d {
        a() {
        }

        @Override // v0.d
        public void h(View view, float f11) {
            view.setAlpha(a(f11));
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends d {

        /* renamed from: f, reason: collision with root package name */
        String f77097f;

        /* renamed from: g, reason: collision with root package name */
        SparseArray f77098g;

        /* renamed from: h, reason: collision with root package name */
        float[] f77099h;

        public b(String str, SparseArray sparseArray) {
            this.f77097f = str.split(",")[1];
            this.f77098g = sparseArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.i
        public void c(int i11, float f11) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // androidx.constraintlayout.core.motion.utils.i
        public void e(int i11) {
            int size = this.f77098g.size();
            int h11 = ((ConstraintAttribute) this.f77098g.valueAt(0)).h();
            double[] dArr = new double[size];
            this.f77099h = new float[h11];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, h11);
            for (int i12 = 0; i12 < size; i12++) {
                int keyAt = this.f77098g.keyAt(i12);
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f77098g.valueAt(i12);
                dArr[i12] = keyAt * 0.01d;
                constraintAttribute.f(this.f77099h);
                int i13 = 0;
                while (true) {
                    if (i13 < this.f77099h.length) {
                        dArr2[i12][i13] = r6[i13];
                        i13++;
                    }
                }
            }
            this.f6872a = androidx.constraintlayout.core.motion.utils.b.a(i11, dArr, dArr2);
        }

        @Override // v0.d
        public void h(View view, float f11) {
            this.f6872a.e(f11, this.f77099h);
            v0.a.b((ConstraintAttribute) this.f77098g.valueAt(0), view, this.f77099h);
        }

        public void i(int i11, ConstraintAttribute constraintAttribute) {
            this.f77098g.append(i11, constraintAttribute);
        }
    }

    /* loaded from: classes2.dex */
    static class c extends d {
        c() {
        }

        @Override // v0.d
        public void h(View view, float f11) {
            view.setElevation(a(f11));
        }
    }

    /* renamed from: v0.d$d, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0969d extends d {
        @Override // v0.d
        public void h(View view, float f11) {
        }

        public void i(View view, float f11, double d11, double d12) {
            view.setRotation(a(f11) + ((float) Math.toDegrees(Math.atan2(d12, d11))));
        }
    }

    /* loaded from: classes2.dex */
    static class e extends d {
        e() {
        }

        @Override // v0.d
        public void h(View view, float f11) {
            view.setPivotX(a(f11));
        }
    }

    /* loaded from: classes2.dex */
    static class f extends d {
        f() {
        }

        @Override // v0.d
        public void h(View view, float f11) {
            view.setPivotY(a(f11));
        }
    }

    /* loaded from: classes2.dex */
    static class g extends d {

        /* renamed from: f, reason: collision with root package name */
        boolean f77100f = false;

        g() {
        }

        @Override // v0.d
        public void h(View view, float f11) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f11));
                return;
            }
            if (this.f77100f) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f77100f = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(f11)));
                } catch (IllegalAccessException e11) {
                    Log.e("ViewSpline", "unable to setProgress", e11);
                } catch (InvocationTargetException e12) {
                    Log.e("ViewSpline", "unable to setProgress", e12);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    static class h extends d {
        h() {
        }

        @Override // v0.d
        public void h(View view, float f11) {
            view.setRotation(a(f11));
        }
    }

    /* loaded from: classes2.dex */
    static class i extends d {
        i() {
        }

        @Override // v0.d
        public void h(View view, float f11) {
            view.setRotationX(a(f11));
        }
    }

    /* loaded from: classes2.dex */
    static class j extends d {
        j() {
        }

        @Override // v0.d
        public void h(View view, float f11) {
            view.setRotationY(a(f11));
        }
    }

    /* loaded from: classes2.dex */
    static class k extends d {
        k() {
        }

        @Override // v0.d
        public void h(View view, float f11) {
            view.setScaleX(a(f11));
        }
    }

    /* loaded from: classes2.dex */
    static class l extends d {
        l() {
        }

        @Override // v0.d
        public void h(View view, float f11) {
            view.setScaleY(a(f11));
        }
    }

    /* loaded from: classes2.dex */
    static class m extends d {
        m() {
        }

        @Override // v0.d
        public void h(View view, float f11) {
            view.setTranslationX(a(f11));
        }
    }

    /* loaded from: classes2.dex */
    static class n extends d {
        n() {
        }

        @Override // v0.d
        public void h(View view, float f11) {
            view.setTranslationY(a(f11));
        }
    }

    /* loaded from: classes2.dex */
    static class o extends d {
        o() {
        }

        @Override // v0.d
        public void h(View view, float f11) {
            view.setTranslationZ(a(f11));
        }
    }

    public static d f(String str, SparseArray sparseArray) {
        return new b(str, sparseArray);
    }

    public static d g(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c11 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c11 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                    c11 = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c11 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c11 = 7;
                    break;
                }
                break;
            case -797520672:
                if (str.equals("waveVariesBy")) {
                    c11 = '\b';
                    break;
                }
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    c11 = '\t';
                    break;
                }
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    c11 = '\n';
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c11 = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c11 = '\f';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c11 = '\r';
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c11 = 14;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c11 = 15;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return new i();
            case 1:
                return new j();
            case 2:
                return new m();
            case 3:
                return new n();
            case 4:
                return new o();
            case 5:
                return new g();
            case 6:
                return new k();
            case 7:
                return new l();
            case '\b':
                return new a();
            case '\t':
                return new e();
            case '\n':
                return new f();
            case 11:
                return new h();
            case '\f':
                return new c();
            case '\r':
                return new C0969d();
            case 14:
                return new a();
            case 15:
                return new a();
            default:
                return null;
        }
    }

    public abstract void h(View view, float f11);
}
