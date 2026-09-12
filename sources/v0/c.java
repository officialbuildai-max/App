package v0;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.core.app.NotificationCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public abstract class c extends KeyCycleOscillator {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends c {
        a() {
        }

        @Override // v0.c
        public void j(View view, float f11) {
            view.setAlpha(a(f11));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b extends c {

        /* renamed from: h, reason: collision with root package name */
        float[] f77094h = new float[1];

        /* renamed from: i, reason: collision with root package name */
        protected ConstraintAttribute f77095i;

        b() {
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        protected void c(Object obj) {
            this.f77095i = (ConstraintAttribute) obj;
        }

        @Override // v0.c
        public void j(View view, float f11) {
            this.f77094h[0] = a(f11);
            v0.a.b(this.f77095i, view, this.f77094h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: v0.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0968c extends c {
        C0968c() {
        }

        @Override // v0.c
        public void j(View view, float f11) {
            view.setElevation(a(f11));
        }
    }

    /* loaded from: classes2.dex */
    public static class d extends c {
        @Override // v0.c
        public void j(View view, float f11) {
        }

        public void k(View view, float f11, double d11, double d12) {
            view.setRotation(a(f11) + ((float) Math.toDegrees(Math.atan2(d12, d11))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class e extends c {

        /* renamed from: h, reason: collision with root package name */
        boolean f77096h = false;

        e() {
        }

        @Override // v0.c
        public void j(View view, float f11) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f11));
                return;
            }
            if (this.f77096h) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f77096h = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(f11)));
                } catch (IllegalAccessException e11) {
                    Log.e("ViewOscillator", "unable to setProgress", e11);
                } catch (InvocationTargetException e12) {
                    Log.e("ViewOscillator", "unable to setProgress", e12);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class f extends c {
        f() {
        }

        @Override // v0.c
        public void j(View view, float f11) {
            view.setRotation(a(f11));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class g extends c {
        g() {
        }

        @Override // v0.c
        public void j(View view, float f11) {
            view.setRotationX(a(f11));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class h extends c {
        h() {
        }

        @Override // v0.c
        public void j(View view, float f11) {
            view.setRotationY(a(f11));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class i extends c {
        i() {
        }

        @Override // v0.c
        public void j(View view, float f11) {
            view.setScaleX(a(f11));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class j extends c {
        j() {
        }

        @Override // v0.c
        public void j(View view, float f11) {
            view.setScaleY(a(f11));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class k extends c {
        k() {
        }

        @Override // v0.c
        public void j(View view, float f11) {
            view.setTranslationX(a(f11));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class l extends c {
        l() {
        }

        @Override // v0.c
        public void j(View view, float f11) {
            view.setTranslationY(a(f11));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class m extends c {
        m() {
        }

        @Override // v0.c
        public void j(View view, float f11) {
            view.setTranslationZ(a(f11));
        }
    }

    public static c i(String str) {
        if (str.startsWith("CUSTOM")) {
            return new b();
        }
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
            case -40300674:
                if (str.equals("rotation")) {
                    c11 = '\t';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c11 = '\n';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c11 = 11;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c11 = '\f';
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c11 = '\r';
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return new g();
            case 1:
                return new h();
            case 2:
                return new k();
            case 3:
                return new l();
            case 4:
                return new m();
            case 5:
                return new e();
            case 6:
                return new i();
            case 7:
                return new j();
            case '\b':
                return new a();
            case '\t':
                return new f();
            case '\n':
                return new C0968c();
            case 11:
                return new d();
            case '\f':
                return new a();
            case '\r':
                return new a();
            default:
                return null;
        }
    }

    public abstract void j(View view, float f11);
}
