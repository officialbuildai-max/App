package v0;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.n;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.core.app.NotificationCompat;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public abstract class f extends n {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends f {
        a() {
        }

        @Override // v0.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            view.setAlpha(f(f11, j11, view, dVar));
            return this.f6912h;
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends f {

        /* renamed from: l, reason: collision with root package name */
        String f77106l;

        /* renamed from: m, reason: collision with root package name */
        SparseArray f77107m;

        /* renamed from: n, reason: collision with root package name */
        SparseArray f77108n = new SparseArray();

        /* renamed from: o, reason: collision with root package name */
        float[] f77109o;

        /* renamed from: p, reason: collision with root package name */
        float[] f77110p;

        public b(String str, SparseArray sparseArray) {
            this.f77106l = str.split(",")[1];
            this.f77107m = sparseArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.n
        public void b(int i11, float f11, float f12, int i12, float f13) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // androidx.constraintlayout.core.motion.utils.n
        public void e(int i11) {
            int size = this.f77107m.size();
            int h11 = ((ConstraintAttribute) this.f77107m.valueAt(0)).h();
            double[] dArr = new double[size];
            int i12 = h11 + 2;
            this.f77109o = new float[i12];
            this.f77110p = new float[h11];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i12);
            for (int i13 = 0; i13 < size; i13++) {
                int keyAt = this.f77107m.keyAt(i13);
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f77107m.valueAt(i13);
                float[] fArr = (float[]) this.f77108n.valueAt(i13);
                dArr[i13] = keyAt * 0.01d;
                constraintAttribute.f(this.f77109o);
                int i14 = 0;
                while (true) {
                    if (i14 < this.f77109o.length) {
                        dArr2[i13][i14] = r8[i14];
                        i14++;
                    }
                }
                double[] dArr3 = dArr2[i13];
                dArr3[h11] = fArr[0];
                dArr3[h11 + 1] = fArr[1];
            }
            this.f6905a = androidx.constraintlayout.core.motion.utils.b.a(i11, dArr, dArr2);
        }

        @Override // v0.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            this.f6905a.e(f11, this.f77109o);
            float[] fArr = this.f77109o;
            float f12 = fArr[fArr.length - 2];
            float f13 = fArr[fArr.length - 1];
            long j12 = j11 - this.f6913i;
            if (Float.isNaN(this.f6914j)) {
                float a11 = dVar.a(view, this.f77106l, 0);
                this.f6914j = a11;
                if (Float.isNaN(a11)) {
                    this.f6914j = 0.0f;
                }
            }
            float f14 = (float) ((this.f6914j + ((j12 * 1.0E-9d) * f12)) % 1.0d);
            this.f6914j = f14;
            this.f6913i = j11;
            float a12 = a(f14);
            this.f6912h = false;
            int i11 = 0;
            while (true) {
                float[] fArr2 = this.f77110p;
                if (i11 >= fArr2.length) {
                    break;
                }
                boolean z10 = this.f6912h;
                float f15 = this.f77109o[i11];
                this.f6912h = z10 | (((double) f15) != 0.0d);
                fArr2[i11] = (f15 * a12) + f13;
                i11++;
            }
            v0.a.b((ConstraintAttribute) this.f77107m.valueAt(0), view, this.f77110p);
            if (f12 != 0.0f) {
                this.f6912h = true;
            }
            return this.f6912h;
        }

        public void j(int i11, ConstraintAttribute constraintAttribute, float f11, int i12, float f12) {
            this.f77107m.append(i11, constraintAttribute);
            this.f77108n.append(i11, new float[]{f11, f12});
            this.f6906b = Math.max(this.f6906b, i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class c extends f {
        c() {
        }

        @Override // v0.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            view.setElevation(f(f11, j11, view, dVar));
            return this.f6912h;
        }
    }

    /* loaded from: classes2.dex */
    public static class d extends f {
        @Override // v0.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            return this.f6912h;
        }

        public boolean j(View view, androidx.constraintlayout.core.motion.utils.d dVar, float f11, long j11, double d11, double d12) {
            view.setRotation(f(f11, j11, view, dVar) + ((float) Math.toDegrees(Math.atan2(d12, d11))));
            return this.f6912h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class e extends f {

        /* renamed from: l, reason: collision with root package name */
        boolean f77111l = false;

        e() {
        }

        @Override // v0.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(f(f11, j11, view, dVar));
            } else {
                if (this.f77111l) {
                    return false;
                }
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.f77111l = true;
                    method = null;
                }
                Method method2 = method;
                if (method2 != null) {
                    try {
                        method2.invoke(view, Float.valueOf(f(f11, j11, view, dVar)));
                    } catch (IllegalAccessException e11) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e11);
                    } catch (InvocationTargetException e12) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e12);
                    }
                }
            }
            return this.f6912h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: v0.f$f, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0970f extends f {
        C0970f() {
        }

        @Override // v0.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            view.setRotation(f(f11, j11, view, dVar));
            return this.f6912h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class g extends f {
        g() {
        }

        @Override // v0.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            view.setRotationX(f(f11, j11, view, dVar));
            return this.f6912h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class h extends f {
        h() {
        }

        @Override // v0.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            view.setRotationY(f(f11, j11, view, dVar));
            return this.f6912h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class i extends f {
        i() {
        }

        @Override // v0.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            view.setScaleX(f(f11, j11, view, dVar));
            return this.f6912h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class j extends f {
        j() {
        }

        @Override // v0.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            view.setScaleY(f(f11, j11, view, dVar));
            return this.f6912h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class k extends f {
        k() {
        }

        @Override // v0.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            view.setTranslationX(f(f11, j11, view, dVar));
            return this.f6912h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class l extends f {
        l() {
        }

        @Override // v0.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            view.setTranslationY(f(f11, j11, view, dVar));
            return this.f6912h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class m extends f {
        m() {
        }

        @Override // v0.f
        public boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
            view.setTranslationZ(f(f11, j11, view, dVar));
            return this.f6912h;
        }
    }

    public static f g(String str, SparseArray sparseArray) {
        return new b(str, sparseArray);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:39:0x009c. Please report as an issue. */
    public static f h(String str, long j11) {
        f gVar;
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
            case -40300674:
                if (str.equals("rotation")) {
                    c11 = '\b';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c11 = '\t';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c11 = '\n';
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c11 = 11;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                gVar = new g();
                gVar.c(j11);
                return gVar;
            case 1:
                gVar = new h();
                gVar.c(j11);
                return gVar;
            case 2:
                gVar = new k();
                gVar.c(j11);
                return gVar;
            case 3:
                gVar = new l();
                gVar.c(j11);
                return gVar;
            case 4:
                gVar = new m();
                gVar.c(j11);
                return gVar;
            case 5:
                gVar = new e();
                gVar.c(j11);
                return gVar;
            case 6:
                gVar = new i();
                gVar.c(j11);
                return gVar;
            case 7:
                gVar = new j();
                gVar.c(j11);
                return gVar;
            case '\b':
                gVar = new C0970f();
                gVar.c(j11);
                return gVar;
            case '\t':
                gVar = new c();
                gVar.c(j11);
                return gVar;
            case '\n':
                gVar = new d();
                gVar.c(j11);
                return gVar;
            case 11:
                gVar = new a();
                gVar.c(j11);
                return gVar;
            default:
                return null;
        }
    }

    public float f(float f11, long j11, View view, androidx.constraintlayout.core.motion.utils.d dVar) {
        this.f6905a.e(f11, this.f6911g);
        float[] fArr = this.f6911g;
        float f12 = fArr[1];
        if (f12 == 0.0f) {
            this.f6912h = false;
            return fArr[2];
        }
        if (Float.isNaN(this.f6914j)) {
            float a11 = dVar.a(view, this.f6910f, 0);
            this.f6914j = a11;
            if (Float.isNaN(a11)) {
                this.f6914j = 0.0f;
            }
        }
        float f13 = (float) ((this.f6914j + (((j11 - this.f6913i) * 1.0E-9d) * f12)) % 1.0d);
        this.f6914j = f13;
        dVar.b(view, this.f6910f, 0, f13);
        this.f6913i = j11;
        float f14 = this.f6911g[0];
        float a12 = (a(this.f6914j) * f14) + this.f6911g[2];
        this.f6912h = (f14 == 0.0f && f12 == 0.0f) ? false : true;
        return a12;
    }

    public abstract boolean i(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar);
}
