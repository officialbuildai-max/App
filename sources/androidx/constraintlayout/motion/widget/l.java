package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.b;
import androidx.core.app.NotificationCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import v0.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Comparable {
    static String[] D = {RequestParameters.POSITION, "x", "y", "width", "height", "pathRotate"};

    /* renamed from: c, reason: collision with root package name */
    int f7427c;

    /* renamed from: p, reason: collision with root package name */
    private androidx.constraintlayout.core.motion.utils.c f7440p;

    /* renamed from: r, reason: collision with root package name */
    private float f7442r;

    /* renamed from: s, reason: collision with root package name */
    private float f7443s;

    /* renamed from: t, reason: collision with root package name */
    private float f7444t;

    /* renamed from: u, reason: collision with root package name */
    private float f7445u;

    /* renamed from: v, reason: collision with root package name */
    private float f7446v;

    /* renamed from: a, reason: collision with root package name */
    private float f7425a = 1.0f;

    /* renamed from: b, reason: collision with root package name */
    int f7426b = 0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f7428d = false;

    /* renamed from: e, reason: collision with root package name */
    private float f7429e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    private float f7430f = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    private float f7431g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    public float f7432h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    private float f7433i = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    private float f7434j = 1.0f;

    /* renamed from: k, reason: collision with root package name */
    private float f7435k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    private float f7436l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    private float f7437m = 0.0f;

    /* renamed from: n, reason: collision with root package name */
    private float f7438n = 0.0f;

    /* renamed from: o, reason: collision with root package name */
    private float f7439o = 0.0f;

    /* renamed from: q, reason: collision with root package name */
    private int f7441q = 0;

    /* renamed from: w, reason: collision with root package name */
    private float f7447w = Float.NaN;

    /* renamed from: x, reason: collision with root package name */
    private float f7448x = Float.NaN;

    /* renamed from: y, reason: collision with root package name */
    private int f7449y = -1;

    /* renamed from: z, reason: collision with root package name */
    LinkedHashMap f7450z = new LinkedHashMap();
    int A = 0;
    double[] B = new double[18];
    double[] C = new double[18];

    private boolean f(float f11, float f12) {
        return (Float.isNaN(f11) || Float.isNaN(f12)) ? Float.isNaN(f11) != Float.isNaN(f12) : Math.abs(f11 - f12) > 1.0E-6f;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0026. Please report as an issue. */
    public void a(HashMap hashMap, int i11) {
        for (String str : hashMap.keySet()) {
            v0.d dVar = (v0.d) hashMap.get(str);
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
                case -760884510:
                    if (str.equals("transformPivotX")) {
                        c11 = '\b';
                        break;
                    }
                    break;
                case -760884509:
                    if (str.equals("transformPivotY")) {
                        c11 = '\t';
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        c11 = '\n';
                        break;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        c11 = 11;
                        break;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        c11 = '\f';
                        break;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        c11 = '\r';
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    dVar.c(i11, Float.isNaN(this.f7431g) ? 0.0f : this.f7431g);
                    break;
                case 1:
                    dVar.c(i11, Float.isNaN(this.f7432h) ? 0.0f : this.f7432h);
                    break;
                case 2:
                    dVar.c(i11, Float.isNaN(this.f7437m) ? 0.0f : this.f7437m);
                    break;
                case 3:
                    dVar.c(i11, Float.isNaN(this.f7438n) ? 0.0f : this.f7438n);
                    break;
                case 4:
                    dVar.c(i11, Float.isNaN(this.f7439o) ? 0.0f : this.f7439o);
                    break;
                case 5:
                    dVar.c(i11, Float.isNaN(this.f7448x) ? 0.0f : this.f7448x);
                    break;
                case 6:
                    dVar.c(i11, Float.isNaN(this.f7433i) ? 1.0f : this.f7433i);
                    break;
                case 7:
                    dVar.c(i11, Float.isNaN(this.f7434j) ? 1.0f : this.f7434j);
                    break;
                case '\b':
                    dVar.c(i11, Float.isNaN(this.f7435k) ? 0.0f : this.f7435k);
                    break;
                case '\t':
                    dVar.c(i11, Float.isNaN(this.f7436l) ? 0.0f : this.f7436l);
                    break;
                case '\n':
                    dVar.c(i11, Float.isNaN(this.f7430f) ? 0.0f : this.f7430f);
                    break;
                case 11:
                    dVar.c(i11, Float.isNaN(this.f7429e) ? 0.0f : this.f7429e);
                    break;
                case '\f':
                    dVar.c(i11, Float.isNaN(this.f7447w) ? 0.0f : this.f7447w);
                    break;
                case '\r':
                    dVar.c(i11, Float.isNaN(this.f7425a) ? 1.0f : this.f7425a);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(",")[1];
                        if (this.f7450z.containsKey(str2)) {
                            ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f7450z.get(str2);
                            if (dVar instanceof d.b) {
                                ((d.b) dVar).i(i11, constraintAttribute);
                                break;
                            } else {
                                Log.e("MotionPaths", str + " ViewSpline not a CustomSet frame = " + i11 + ", value" + constraintAttribute.e() + dVar);
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        Log.e("MotionPaths", "UNKNOWN spline " + str);
                        break;
                    }
            }
        }
    }

    public void b(View view) {
        this.f7427c = view.getVisibility();
        this.f7425a = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.f7428d = false;
        this.f7429e = view.getElevation();
        this.f7430f = view.getRotation();
        this.f7431g = view.getRotationX();
        this.f7432h = view.getRotationY();
        this.f7433i = view.getScaleX();
        this.f7434j = view.getScaleY();
        this.f7435k = view.getPivotX();
        this.f7436l = view.getPivotY();
        this.f7437m = view.getTranslationX();
        this.f7438n = view.getTranslationY();
        this.f7439o = view.getTranslationZ();
    }

    public void d(b.a aVar) {
        b.d dVar = aVar.f7840c;
        int i11 = dVar.f7919c;
        this.f7426b = i11;
        int i12 = dVar.f7918b;
        this.f7427c = i12;
        this.f7425a = (i12 == 0 || i11 != 0) ? dVar.f7920d : 0.0f;
        b.e eVar = aVar.f7843f;
        this.f7428d = eVar.f7935m;
        this.f7429e = eVar.f7936n;
        this.f7430f = eVar.f7924b;
        this.f7431g = eVar.f7925c;
        this.f7432h = eVar.f7926d;
        this.f7433i = eVar.f7927e;
        this.f7434j = eVar.f7928f;
        this.f7435k = eVar.f7929g;
        this.f7436l = eVar.f7930h;
        this.f7437m = eVar.f7932j;
        this.f7438n = eVar.f7933k;
        this.f7439o = eVar.f7934l;
        this.f7440p = androidx.constraintlayout.core.motion.utils.c.c(aVar.f7841d.f7906d);
        b.c cVar = aVar.f7841d;
        this.f7447w = cVar.f7911i;
        this.f7441q = cVar.f7908f;
        this.f7449y = cVar.f7904b;
        this.f7448x = aVar.f7840c.f7921e;
        for (String str : aVar.f7844g.keySet()) {
            ConstraintAttribute constraintAttribute = (ConstraintAttribute) aVar.f7844g.get(str);
            if (constraintAttribute.g()) {
                this.f7450z.put(str, constraintAttribute);
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compareTo(l lVar) {
        return Float.compare(this.f7442r, lVar.f7442r);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(l lVar, HashSet hashSet) {
        if (f(this.f7425a, lVar.f7425a)) {
            hashSet.add("alpha");
        }
        if (f(this.f7429e, lVar.f7429e)) {
            hashSet.add("elevation");
        }
        int i11 = this.f7427c;
        int i12 = lVar.f7427c;
        if (i11 != i12 && this.f7426b == 0 && (i11 == 0 || i12 == 0)) {
            hashSet.add("alpha");
        }
        if (f(this.f7430f, lVar.f7430f)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f7447w) || !Float.isNaN(lVar.f7447w)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f7448x) || !Float.isNaN(lVar.f7448x)) {
            hashSet.add(NotificationCompat.CATEGORY_PROGRESS);
        }
        if (f(this.f7431g, lVar.f7431g)) {
            hashSet.add("rotationX");
        }
        if (f(this.f7432h, lVar.f7432h)) {
            hashSet.add("rotationY");
        }
        if (f(this.f7435k, lVar.f7435k)) {
            hashSet.add("transformPivotX");
        }
        if (f(this.f7436l, lVar.f7436l)) {
            hashSet.add("transformPivotY");
        }
        if (f(this.f7433i, lVar.f7433i)) {
            hashSet.add("scaleX");
        }
        if (f(this.f7434j, lVar.f7434j)) {
            hashSet.add("scaleY");
        }
        if (f(this.f7437m, lVar.f7437m)) {
            hashSet.add("translationX");
        }
        if (f(this.f7438n, lVar.f7438n)) {
            hashSet.add("translationY");
        }
        if (f(this.f7439o, lVar.f7439o)) {
            hashSet.add("translationZ");
        }
    }

    void h(float f11, float f12, float f13, float f14) {
        this.f7443s = f11;
        this.f7444t = f12;
        this.f7445u = f13;
        this.f7446v = f14;
    }

    public void i(Rect rect, View view, int i11, float f11) {
        h(rect.left, rect.top, rect.width(), rect.height());
        b(view);
        this.f7435k = Float.NaN;
        this.f7436l = Float.NaN;
        if (i11 == 1) {
            this.f7430f = f11 - 90.0f;
        } else {
            if (i11 != 2) {
                return;
            }
            this.f7430f = f11 + 90.0f;
        }
    }

    public void j(Rect rect, androidx.constraintlayout.widget.b bVar, int i11, int i12) {
        h(rect.left, rect.top, rect.width(), rect.height());
        d(bVar.D(i12));
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 4) {
                        return;
                    }
                }
            }
            float f11 = this.f7430f + 90.0f;
            this.f7430f = f11;
            if (f11 > 180.0f) {
                this.f7430f = f11 - 360.0f;
                return;
            }
            return;
        }
        this.f7430f -= 90.0f;
    }

    public void k(View view) {
        h(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        b(view);
    }
}
