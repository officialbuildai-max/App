package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.b;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import v0.c;
import v0.d;
import v0.f;

/* loaded from: classes.dex */
public class m {
    private HashMap B;
    private HashMap C;
    private HashMap D;
    private k[] E;
    private int F;
    private int G;
    private View H;
    private int I;
    private float J;
    private Interpolator K;
    private boolean L;

    /* renamed from: b, reason: collision with root package name */
    View f7452b;

    /* renamed from: c, reason: collision with root package name */
    int f7453c;

    /* renamed from: e, reason: collision with root package name */
    String f7455e;

    /* renamed from: k, reason: collision with root package name */
    private androidx.constraintlayout.core.motion.utils.b[] f7461k;

    /* renamed from: l, reason: collision with root package name */
    private androidx.constraintlayout.core.motion.utils.b f7462l;

    /* renamed from: p, reason: collision with root package name */
    float f7466p;

    /* renamed from: q, reason: collision with root package name */
    float f7467q;

    /* renamed from: r, reason: collision with root package name */
    private int[] f7468r;

    /* renamed from: s, reason: collision with root package name */
    private double[] f7469s;

    /* renamed from: t, reason: collision with root package name */
    private double[] f7470t;

    /* renamed from: u, reason: collision with root package name */
    private String[] f7471u;

    /* renamed from: v, reason: collision with root package name */
    private int[] f7472v;

    /* renamed from: a, reason: collision with root package name */
    Rect f7451a = new Rect();

    /* renamed from: d, reason: collision with root package name */
    boolean f7454d = false;

    /* renamed from: f, reason: collision with root package name */
    private int f7456f = -1;

    /* renamed from: g, reason: collision with root package name */
    private o f7457g = new o();

    /* renamed from: h, reason: collision with root package name */
    private o f7458h = new o();

    /* renamed from: i, reason: collision with root package name */
    private l f7459i = new l();

    /* renamed from: j, reason: collision with root package name */
    private l f7460j = new l();

    /* renamed from: m, reason: collision with root package name */
    float f7463m = Float.NaN;

    /* renamed from: n, reason: collision with root package name */
    float f7464n = 0.0f;

    /* renamed from: o, reason: collision with root package name */
    float f7465o = 1.0f;

    /* renamed from: w, reason: collision with root package name */
    private int f7473w = 4;

    /* renamed from: x, reason: collision with root package name */
    private float[] f7474x = new float[4];

    /* renamed from: y, reason: collision with root package name */
    private ArrayList f7475y = new ArrayList();

    /* renamed from: z, reason: collision with root package name */
    private float[] f7476z = new float[1];
    private ArrayList A = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Interpolator {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.constraintlayout.core.motion.utils.c f7477a;

        a(androidx.constraintlayout.core.motion.utils.c cVar) {
            this.f7477a = cVar;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f11) {
            return (float) this.f7477a.a(f11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(View view) {
        int i11 = d.f7324f;
        this.F = i11;
        this.G = i11;
        this.H = null;
        this.I = i11;
        this.J = Float.NaN;
        this.K = null;
        this.L = false;
        H(view);
    }

    private float g(float f11, float[] fArr) {
        float f12 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f13 = this.f7465o;
            if (f13 != 1.0d) {
                float f14 = this.f7464n;
                if (f11 < f14) {
                    f11 = 0.0f;
                }
                if (f11 > f14 && f11 < 1.0d) {
                    f11 = Math.min((f11 - f14) * f13, 1.0f);
                }
            }
        }
        androidx.constraintlayout.core.motion.utils.c cVar = this.f7457g.f7479a;
        Iterator it = this.f7475y.iterator();
        float f15 = Float.NaN;
        while (it.hasNext()) {
            o oVar = (o) it.next();
            androidx.constraintlayout.core.motion.utils.c cVar2 = oVar.f7479a;
            if (cVar2 != null) {
                float f16 = oVar.f7481c;
                if (f16 < f11) {
                    cVar = cVar2;
                    f12 = f16;
                } else if (Float.isNaN(f15)) {
                    f15 = oVar.f7481c;
                }
            }
        }
        if (cVar != null) {
            float f17 = (Float.isNaN(f15) ? 1.0f : f15) - f12;
            double d11 = (f11 - f12) / f17;
            f11 = (((float) cVar.a(d11)) * f17) + f12;
            if (fArr != null) {
                fArr[0] = (float) cVar.b(d11);
            }
        }
        return f11;
    }

    private static Interpolator p(Context context, int i11, String str, int i12) {
        if (i11 == -2) {
            return AnimationUtils.loadInterpolator(context, i12);
        }
        if (i11 == -1) {
            return new a(androidx.constraintlayout.core.motion.utils.c.c(str));
        }
        if (i11 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i11 == 1) {
            return new AccelerateInterpolator();
        }
        if (i11 == 2) {
            return new DecelerateInterpolator();
        }
        if (i11 == 4) {
            return new BounceInterpolator();
        }
        if (i11 != 5) {
            return null;
        }
        return new OvershootInterpolator();
    }

    private float s() {
        char c11;
        float f11;
        float[] fArr = new float[2];
        float f12 = 1.0f / 99;
        double d11 = 0.0d;
        double d12 = 0.0d;
        float f13 = 0.0f;
        int i11 = 0;
        while (i11 < 100) {
            float f14 = i11 * f12;
            double d13 = f14;
            androidx.constraintlayout.core.motion.utils.c cVar = this.f7457g.f7479a;
            Iterator it = this.f7475y.iterator();
            float f15 = Float.NaN;
            float f16 = 0.0f;
            while (it.hasNext()) {
                o oVar = (o) it.next();
                androidx.constraintlayout.core.motion.utils.c cVar2 = oVar.f7479a;
                if (cVar2 != null) {
                    float f17 = oVar.f7481c;
                    if (f17 < f14) {
                        cVar = cVar2;
                        f16 = f17;
                    } else if (Float.isNaN(f15)) {
                        f15 = oVar.f7481c;
                    }
                }
            }
            if (cVar != null) {
                if (Float.isNaN(f15)) {
                    f15 = 1.0f;
                }
                d13 = (((float) cVar.a((f14 - f16) / r17)) * (f15 - f16)) + f16;
            }
            this.f7461k[0].d(d13, this.f7469s);
            float f18 = f13;
            int i12 = i11;
            this.f7457g.g(d13, this.f7468r, this.f7469s, fArr, 0);
            if (i12 > 0) {
                c11 = 0;
                f11 = (float) (f18 + Math.hypot(d12 - fArr[1], d11 - fArr[0]));
            } else {
                c11 = 0;
                f11 = f18;
            }
            d11 = fArr[c11];
            i11 = i12 + 1;
            f13 = f11;
            d12 = fArr[1];
        }
        return f13;
    }

    private void w(o oVar) {
        if (Collections.binarySearch(this.f7475y, oVar) == 0) {
            Log.e("MotionController", " KeyPath position \"" + oVar.f7482d + "\" outside of range");
        }
        this.f7475y.add((-r0) - 1, oVar);
    }

    private void y(o oVar) {
        oVar.q((int) this.f7452b.getX(), (int) this.f7452b.getY(), this.f7452b.getWidth(), this.f7452b.getHeight());
    }

    void A(Rect rect, Rect rect2, int i11, int i12, int i13) {
        if (i11 == 1) {
            int i14 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i13 - ((i14 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
            return;
        }
        if (i11 == 2) {
            int i15 = rect.left + rect.right;
            rect2.left = i12 - (((rect.top + rect.bottom) + rect.width()) / 2);
            rect2.top = (i15 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
            return;
        }
        if (i11 == 3) {
            int i16 = rect.left + rect.right;
            rect2.left = ((rect.height() / 2) + rect.top) - (i16 / 2);
            rect2.top = i13 - ((i16 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
            return;
        }
        if (i11 != 4) {
            return;
        }
        int i17 = rect.left + rect.right;
        rect2.left = i12 - (((rect.bottom + rect.top) + rect.width()) / 2);
        rect2.top = (i17 - rect.height()) / 2;
        rect2.right = rect2.left + rect.width();
        rect2.bottom = rect2.top + rect.height();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(View view) {
        o oVar = this.f7457g;
        oVar.f7481c = 0.0f;
        oVar.f7482d = 0.0f;
        this.L = true;
        oVar.q(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.f7458h.q(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.f7459i.k(view);
        this.f7460j.k(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(Rect rect, androidx.constraintlayout.widget.b bVar, int i11, int i12) {
        int i13 = bVar.f7834d;
        if (i13 != 0) {
            A(rect, this.f7451a, i13, i11, i12);
            rect = this.f7451a;
        }
        o oVar = this.f7458h;
        oVar.f7481c = 1.0f;
        oVar.f7482d = 1.0f;
        y(oVar);
        this.f7458h.q(rect.left, rect.top, rect.width(), rect.height());
        this.f7458h.a(bVar.D(this.f7453c));
        this.f7460j.j(rect, bVar, i13, this.f7453c);
    }

    public void D(int i11) {
        this.F = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(View view) {
        o oVar = this.f7457g;
        oVar.f7481c = 0.0f;
        oVar.f7482d = 0.0f;
        oVar.q(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.f7459i.k(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(Rect rect, androidx.constraintlayout.widget.b bVar, int i11, int i12) {
        int i13 = bVar.f7834d;
        if (i13 != 0) {
            A(rect, this.f7451a, i13, i11, i12);
        }
        o oVar = this.f7457g;
        oVar.f7481c = 0.0f;
        oVar.f7482d = 0.0f;
        y(oVar);
        this.f7457g.q(rect.left, rect.top, rect.width(), rect.height());
        b.a D = bVar.D(this.f7453c);
        this.f7457g.a(D);
        this.f7463m = D.f7841d.f7909g;
        this.f7459i.j(rect, bVar, i13, this.f7453c);
        this.G = D.f7843f.f7931i;
        b.c cVar = D.f7841d;
        this.I = cVar.f7913k;
        this.J = cVar.f7912j;
        Context context = this.f7452b.getContext();
        b.c cVar2 = D.f7841d;
        this.K = p(context, cVar2.f7915m, cVar2.f7914l, cVar2.f7916n);
    }

    public void G(v0.e eVar, View view, int i11, int i12, int i13) {
        o oVar = this.f7457g;
        oVar.f7481c = 0.0f;
        oVar.f7482d = 0.0f;
        Rect rect = new Rect();
        if (i11 == 1) {
            int i14 = eVar.f77102b + eVar.f77104d;
            rect.left = ((eVar.f77103c + eVar.f77105e) - eVar.c()) / 2;
            rect.top = i12 - ((i14 + eVar.b()) / 2);
            rect.right = rect.left + eVar.c();
            rect.bottom = rect.top + eVar.b();
        } else if (i11 == 2) {
            int i15 = eVar.f77102b + eVar.f77104d;
            rect.left = i13 - (((eVar.f77103c + eVar.f77105e) + eVar.c()) / 2);
            rect.top = (i15 - eVar.b()) / 2;
            rect.right = rect.left + eVar.c();
            rect.bottom = rect.top + eVar.b();
        }
        this.f7457g.q(rect.left, rect.top, rect.width(), rect.height());
        this.f7459i.i(rect, view, i11, eVar.f77101a);
    }

    public void H(View view) {
        this.f7452b = view;
        this.f7453c = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            this.f7455e = ((ConstraintLayout.b) layoutParams).a();
        }
    }

    public void I(int i11, int i12, float f11, long j11) {
        ArrayList arrayList;
        String[] strArr;
        double[][] dArr;
        ConstraintAttribute constraintAttribute;
        v0.f h11;
        ConstraintAttribute constraintAttribute2;
        Integer num;
        v0.d g11;
        ConstraintAttribute constraintAttribute3;
        new HashSet();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashMap hashMap = new HashMap();
        int i13 = this.F;
        if (i13 != d.f7324f) {
            this.f7457g.f7489k = i13;
        }
        this.f7459i.g(this.f7460j, hashSet2);
        ArrayList arrayList2 = this.A;
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            arrayList = null;
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar instanceof h) {
                    h hVar = (h) dVar;
                    w(new o(i11, i12, hVar, this.f7457g, this.f7458h));
                    int i14 = hVar.f7384g;
                    if (i14 != d.f7324f) {
                        this.f7456f = i14;
                    }
                } else if (dVar instanceof f) {
                    dVar.d(hashSet3);
                } else if (dVar instanceof j) {
                    dVar.d(hashSet);
                } else if (dVar instanceof k) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((k) dVar);
                } else {
                    dVar.h(hashMap);
                    dVar.d(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.E = (k[]) arrayList.toArray(new k[0]);
        }
        char c11 = 1;
        if (!hashSet2.isEmpty()) {
            this.C = new HashMap();
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                if (str.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str2 = str.split(",")[1];
                    Iterator it3 = this.A.iterator();
                    while (it3.hasNext()) {
                        d dVar2 = (d) it3.next();
                        HashMap hashMap2 = dVar2.f7329e;
                        if (hashMap2 != null && (constraintAttribute3 = (ConstraintAttribute) hashMap2.get(str2)) != null) {
                            sparseArray.append(dVar2.f7325a, constraintAttribute3);
                        }
                    }
                    g11 = v0.d.f(str, sparseArray);
                } else {
                    g11 = v0.d.g(str);
                }
                if (g11 != null) {
                    g11.d(str);
                    this.C.put(str, g11);
                }
            }
            ArrayList arrayList3 = this.A;
            if (arrayList3 != null) {
                Iterator it4 = arrayList3.iterator();
                while (it4.hasNext()) {
                    d dVar3 = (d) it4.next();
                    if (dVar3 instanceof e) {
                        dVar3.a(this.C);
                    }
                }
            }
            this.f7459i.a(this.C, 0);
            this.f7460j.a(this.C, 100);
            for (String str3 : this.C.keySet()) {
                int intValue = (!hashMap.containsKey(str3) || (num = (Integer) hashMap.get(str3)) == null) ? 0 : num.intValue();
                androidx.constraintlayout.core.motion.utils.i iVar = (androidx.constraintlayout.core.motion.utils.i) this.C.get(str3);
                if (iVar != null) {
                    iVar.e(intValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.B == null) {
                this.B = new HashMap();
            }
            Iterator it5 = hashSet.iterator();
            while (it5.hasNext()) {
                String str4 = (String) it5.next();
                if (!this.B.containsKey(str4)) {
                    if (str4.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str5 = str4.split(",")[1];
                        Iterator it6 = this.A.iterator();
                        while (it6.hasNext()) {
                            d dVar4 = (d) it6.next();
                            HashMap hashMap3 = dVar4.f7329e;
                            if (hashMap3 != null && (constraintAttribute2 = (ConstraintAttribute) hashMap3.get(str5)) != null) {
                                sparseArray2.append(dVar4.f7325a, constraintAttribute2);
                            }
                        }
                        h11 = v0.f.g(str4, sparseArray2);
                    } else {
                        h11 = v0.f.h(str4, j11);
                    }
                    if (h11 != null) {
                        h11.d(str4);
                        this.B.put(str4, h11);
                    }
                }
            }
            ArrayList arrayList4 = this.A;
            if (arrayList4 != null) {
                Iterator it7 = arrayList4.iterator();
                while (it7.hasNext()) {
                    d dVar5 = (d) it7.next();
                    if (dVar5 instanceof j) {
                        ((j) dVar5).U(this.B);
                    }
                }
            }
            for (String str6 : this.B.keySet()) {
                ((v0.f) this.B.get(str6)).e(hashMap.containsKey(str6) ? ((Integer) hashMap.get(str6)).intValue() : 0);
            }
        }
        int size = this.f7475y.size();
        int i15 = size + 2;
        o[] oVarArr = new o[i15];
        oVarArr[0] = this.f7457g;
        oVarArr[size + 1] = this.f7458h;
        if (this.f7475y.size() > 0 && this.f7456f == -1) {
            this.f7456f = 0;
        }
        Iterator it8 = this.f7475y.iterator();
        int i16 = 1;
        while (it8.hasNext()) {
            oVarArr[i16] = (o) it8.next();
            i16++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str7 : this.f7458h.f7493o.keySet()) {
            if (this.f7457g.f7493o.containsKey(str7)) {
                if (!hashSet2.contains("CUSTOM," + str7)) {
                    hashSet4.add(str7);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.f7471u = strArr2;
        this.f7472v = new int[strArr2.length];
        int i17 = 0;
        while (true) {
            strArr = this.f7471u;
            if (i17 >= strArr.length) {
                break;
            }
            String str8 = strArr[i17];
            this.f7472v[i17] = 0;
            int i18 = 0;
            while (true) {
                if (i18 >= i15) {
                    break;
                }
                if (oVarArr[i18].f7493o.containsKey(str8) && (constraintAttribute = (ConstraintAttribute) oVarArr[i18].f7493o.get(str8)) != null) {
                    int[] iArr = this.f7472v;
                    iArr[i17] = iArr[i17] + constraintAttribute.h();
                    break;
                }
                i18++;
            }
            i17++;
        }
        boolean z10 = oVarArr[0].f7489k != d.f7324f;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i19 = 1; i19 < i15; i19++) {
            oVarArr[i19].e(oVarArr[i19 - 1], zArr, this.f7471u, z10);
        }
        int i20 = 0;
        for (int i21 = 1; i21 < length; i21++) {
            if (zArr[i21]) {
                i20++;
            }
        }
        this.f7468r = new int[i20];
        int i22 = 2;
        int max = Math.max(2, i20);
        this.f7469s = new double[max];
        this.f7470t = new double[max];
        int i23 = 0;
        for (int i24 = 1; i24 < length; i24++) {
            if (zArr[i24]) {
                this.f7468r[i23] = i24;
                i23++;
            }
        }
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i15, this.f7468r.length);
        double[] dArr3 = new double[i15];
        for (int i25 = 0; i25 < i15; i25++) {
            oVarArr[i25].f(dArr2[i25], this.f7468r);
            dArr3[i25] = oVarArr[i25].f7481c;
        }
        int i26 = 0;
        while (true) {
            int[] iArr2 = this.f7468r;
            if (i26 >= iArr2.length) {
                break;
            }
            if (iArr2[i26] < o.f7478t.length) {
                String str9 = o.f7478t[this.f7468r[i26]] + " [";
                for (int i27 = 0; i27 < i15; i27++) {
                    str9 = str9 + dArr2[i27][i26];
                }
            }
            i26++;
        }
        this.f7461k = new androidx.constraintlayout.core.motion.utils.b[this.f7471u.length + 1];
        int i28 = 0;
        while (true) {
            String[] strArr3 = this.f7471u;
            if (i28 >= strArr3.length) {
                break;
            }
            String str10 = strArr3[i28];
            int i29 = 0;
            int i30 = 0;
            double[] dArr4 = null;
            double[][] dArr5 = null;
            while (i29 < i15) {
                if (oVarArr[i29].l(str10)) {
                    if (dArr5 == null) {
                        dArr4 = new double[i15];
                        int[] iArr3 = new int[i22];
                        iArr3[c11] = oVarArr[i29].j(str10);
                        iArr3[0] = i15;
                        dArr5 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iArr3);
                    }
                    o oVar = oVarArr[i29];
                    dArr = dArr2;
                    dArr4[i30] = oVar.f7481c;
                    oVar.i(str10, dArr5[i30], 0);
                    i30++;
                } else {
                    dArr = dArr2;
                }
                i29++;
                dArr2 = dArr;
                i22 = 2;
                c11 = 1;
            }
            i28++;
            this.f7461k[i28] = androidx.constraintlayout.core.motion.utils.b.a(this.f7456f, Arrays.copyOf(dArr4, i30), (double[][]) Arrays.copyOf(dArr5, i30));
            dArr2 = dArr2;
            i22 = 2;
            c11 = 1;
        }
        this.f7461k[0] = androidx.constraintlayout.core.motion.utils.b.a(this.f7456f, dArr3, dArr2);
        if (oVarArr[0].f7489k != d.f7324f) {
            int[] iArr4 = new int[i15];
            double[] dArr6 = new double[i15];
            double[][] dArr7 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i15, 2);
            for (int i31 = 0; i31 < i15; i31++) {
                iArr4[i31] = oVarArr[i31].f7489k;
                dArr6[i31] = r9.f7481c;
                double[] dArr8 = dArr7[i31];
                dArr8[0] = r9.f7483e;
                dArr8[1] = r9.f7484f;
            }
            this.f7462l = androidx.constraintlayout.core.motion.utils.b.b(iArr4, dArr6, dArr7);
        }
        this.D = new HashMap();
        if (this.A != null) {
            Iterator it9 = hashSet3.iterator();
            float f12 = Float.NaN;
            while (it9.hasNext()) {
                String str11 = (String) it9.next();
                v0.c i32 = v0.c.i(str11);
                if (i32 != null) {
                    if (i32.h() && Float.isNaN(f12)) {
                        f12 = s();
                    }
                    i32.f(str11);
                    this.D.put(str11, i32);
                }
            }
            Iterator it10 = this.A.iterator();
            while (it10.hasNext()) {
                d dVar6 = (d) it10.next();
                if (dVar6 instanceof f) {
                    ((f) dVar6).Y(this.D);
                }
            }
            Iterator it11 = this.D.values().iterator();
            while (it11.hasNext()) {
                ((v0.c) it11.next()).g(f12);
            }
        }
    }

    public void J(m mVar) {
        this.f7457g.t(mVar, mVar.f7457g);
        this.f7458h.t(mVar, mVar.f7458h);
    }

    public void a(d dVar) {
        this.A.add(dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ArrayList arrayList) {
        this.A.addAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] h11 = this.f7461k[0].h();
        if (iArr != null) {
            Iterator it = this.f7475y.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                iArr[i11] = ((o) it.next()).f7494p;
                i11++;
            }
        }
        int i12 = 0;
        for (int i13 = 0; i13 < h11.length; i13++) {
            this.f7461k[0].d(h11[i13], this.f7469s);
            this.f7457g.g(h11[i13], this.f7468r, this.f7469s, fArr, i12);
            i12 += 2;
        }
        return i12 / 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float[] fArr, int i11) {
        int i12 = i11;
        float f11 = 1.0f;
        float f12 = 1.0f / (i12 - 1);
        HashMap hashMap = this.C;
        androidx.constraintlayout.core.motion.utils.i iVar = hashMap == null ? null : (androidx.constraintlayout.core.motion.utils.i) hashMap.get("translationX");
        HashMap hashMap2 = this.C;
        androidx.constraintlayout.core.motion.utils.i iVar2 = hashMap2 == null ? null : (androidx.constraintlayout.core.motion.utils.i) hashMap2.get("translationY");
        HashMap hashMap3 = this.D;
        v0.c cVar = hashMap3 == null ? null : (v0.c) hashMap3.get("translationX");
        HashMap hashMap4 = this.D;
        v0.c cVar2 = hashMap4 != null ? (v0.c) hashMap4.get("translationY") : null;
        int i13 = 0;
        while (i13 < i12) {
            float f13 = i13 * f12;
            float f14 = this.f7465o;
            float f15 = 0.0f;
            if (f14 != f11) {
                float f16 = this.f7464n;
                if (f13 < f16) {
                    f13 = 0.0f;
                }
                if (f13 > f16 && f13 < 1.0d) {
                    f13 = Math.min((f13 - f16) * f14, f11);
                }
            }
            double d11 = f13;
            androidx.constraintlayout.core.motion.utils.c cVar3 = this.f7457g.f7479a;
            Iterator it = this.f7475y.iterator();
            float f17 = Float.NaN;
            while (it.hasNext()) {
                o oVar = (o) it.next();
                androidx.constraintlayout.core.motion.utils.c cVar4 = oVar.f7479a;
                if (cVar4 != null) {
                    float f18 = oVar.f7481c;
                    if (f18 < f13) {
                        f15 = f18;
                        cVar3 = cVar4;
                    } else if (Float.isNaN(f17)) {
                        f17 = oVar.f7481c;
                    }
                }
            }
            if (cVar3 != null) {
                if (Float.isNaN(f17)) {
                    f17 = 1.0f;
                }
                d11 = (((float) cVar3.a((f13 - f15) / r16)) * (f17 - f15)) + f15;
            }
            this.f7461k[0].d(d11, this.f7469s);
            androidx.constraintlayout.core.motion.utils.b bVar = this.f7462l;
            if (bVar != null) {
                double[] dArr = this.f7469s;
                if (dArr.length > 0) {
                    bVar.d(d11, dArr);
                }
            }
            int i14 = i13 * 2;
            this.f7457g.g(d11, this.f7468r, this.f7469s, fArr, i14);
            if (cVar != null) {
                fArr[i14] = fArr[i14] + cVar.a(f13);
            } else if (iVar != null) {
                fArr[i14] = fArr[i14] + iVar.a(f13);
            }
            if (cVar2 != null) {
                int i15 = i14 + 1;
                fArr[i15] = fArr[i15] + cVar2.a(f13);
            } else if (iVar2 != null) {
                int i16 = i14 + 1;
                fArr[i16] = fArr[i16] + iVar2.a(f13);
            }
            i13++;
            i12 = i11;
            f11 = 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(float f11, float[] fArr, int i11) {
        this.f7461k[0].d(g(f11, null), this.f7469s);
        this.f7457g.k(this.f7468r, this.f7469s, fArr, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(boolean z10) {
        if (!"button".equals(androidx.constraintlayout.motion.widget.a.d(this.f7452b)) || this.E == null) {
            return;
        }
        int i11 = 0;
        while (true) {
            k[] kVarArr = this.E;
            if (i11 >= kVarArr.length) {
                return;
            }
            kVarArr[i11].y(z10 ? -100.0f : 100.0f, this.f7452b);
            i11++;
        }
    }

    public int h() {
        return this.f7457g.f7490l;
    }

    public void i(double d11, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f7461k[0].d(d11, dArr);
        this.f7461k[0].g(d11, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.f7457g.h(d11, this.f7468r, dArr, fArr, dArr2, fArr2);
    }

    public float j() {
        return this.f7466p;
    }

    public float k() {
        return this.f7467q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(float f11, float f12, float f13, float[] fArr) {
        double[] dArr;
        float g11 = g(f11, this.f7476z);
        androidx.constraintlayout.core.motion.utils.b[] bVarArr = this.f7461k;
        int i11 = 0;
        if (bVarArr == null) {
            o oVar = this.f7458h;
            float f14 = oVar.f7483e;
            o oVar2 = this.f7457g;
            float f15 = f14 - oVar2.f7483e;
            float f16 = oVar.f7484f - oVar2.f7484f;
            float f17 = (oVar.f7485g - oVar2.f7485g) + f15;
            float f18 = (oVar.f7486h - oVar2.f7486h) + f16;
            fArr[0] = (f15 * (1.0f - f12)) + (f17 * f12);
            fArr[1] = (f16 * (1.0f - f13)) + (f18 * f13);
            return;
        }
        double d11 = g11;
        bVarArr[0].g(d11, this.f7470t);
        this.f7461k[0].d(d11, this.f7469s);
        float f19 = this.f7476z[0];
        while (true) {
            dArr = this.f7470t;
            if (i11 >= dArr.length) {
                break;
            }
            dArr[i11] = dArr[i11] * f19;
            i11++;
        }
        androidx.constraintlayout.core.motion.utils.b bVar = this.f7462l;
        if (bVar == null) {
            this.f7457g.r(f12, f13, fArr, this.f7468r, dArr, this.f7469s);
            return;
        }
        double[] dArr2 = this.f7469s;
        if (dArr2.length > 0) {
            bVar.d(d11, dArr2);
            this.f7462l.g(d11, this.f7470t);
            this.f7457g.r(f12, f13, fArr, this.f7468r, this.f7470t, this.f7469s);
        }
    }

    public int m() {
        int i11 = this.f7457g.f7480b;
        Iterator it = this.f7475y.iterator();
        while (it.hasNext()) {
            i11 = Math.max(i11, ((o) it.next()).f7480b);
        }
        return Math.max(i11, this.f7458h.f7480b);
    }

    public float n() {
        return this.f7458h.f7483e;
    }

    public float o() {
        return this.f7458h.f7484f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o q(int i11) {
        return (o) this.f7475y.get(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(float f11, int i11, int i12, float f12, float f13, float[] fArr) {
        float g11 = g(f11, this.f7476z);
        HashMap hashMap = this.C;
        androidx.constraintlayout.core.motion.utils.i iVar = hashMap == null ? null : (androidx.constraintlayout.core.motion.utils.i) hashMap.get("translationX");
        HashMap hashMap2 = this.C;
        androidx.constraintlayout.core.motion.utils.i iVar2 = hashMap2 == null ? null : (androidx.constraintlayout.core.motion.utils.i) hashMap2.get("translationY");
        HashMap hashMap3 = this.C;
        androidx.constraintlayout.core.motion.utils.i iVar3 = hashMap3 == null ? null : (androidx.constraintlayout.core.motion.utils.i) hashMap3.get("rotation");
        HashMap hashMap4 = this.C;
        androidx.constraintlayout.core.motion.utils.i iVar4 = hashMap4 == null ? null : (androidx.constraintlayout.core.motion.utils.i) hashMap4.get("scaleX");
        HashMap hashMap5 = this.C;
        androidx.constraintlayout.core.motion.utils.i iVar5 = hashMap5 == null ? null : (androidx.constraintlayout.core.motion.utils.i) hashMap5.get("scaleY");
        HashMap hashMap6 = this.D;
        v0.c cVar = hashMap6 == null ? null : (v0.c) hashMap6.get("translationX");
        HashMap hashMap7 = this.D;
        v0.c cVar2 = hashMap7 == null ? null : (v0.c) hashMap7.get("translationY");
        HashMap hashMap8 = this.D;
        v0.c cVar3 = hashMap8 == null ? null : (v0.c) hashMap8.get("rotation");
        HashMap hashMap9 = this.D;
        v0.c cVar4 = hashMap9 == null ? null : (v0.c) hashMap9.get("scaleX");
        HashMap hashMap10 = this.D;
        v0.c cVar5 = hashMap10 != null ? (v0.c) hashMap10.get("scaleY") : null;
        androidx.constraintlayout.core.motion.utils.o oVar = new androidx.constraintlayout.core.motion.utils.o();
        oVar.b();
        oVar.d(iVar3, g11);
        oVar.h(iVar, iVar2, g11);
        oVar.f(iVar4, iVar5, g11);
        oVar.c(cVar3, g11);
        oVar.g(cVar, cVar2, g11);
        oVar.e(cVar4, cVar5, g11);
        androidx.constraintlayout.core.motion.utils.b bVar = this.f7462l;
        if (bVar != null) {
            double[] dArr = this.f7469s;
            if (dArr.length > 0) {
                double d11 = g11;
                bVar.d(d11, dArr);
                this.f7462l.g(d11, this.f7470t);
                this.f7457g.r(f12, f13, fArr, this.f7468r, this.f7470t, this.f7469s);
            }
            oVar.a(f12, f13, i11, i12, fArr);
            return;
        }
        int i13 = 0;
        if (this.f7461k == null) {
            o oVar2 = this.f7458h;
            float f14 = oVar2.f7483e;
            o oVar3 = this.f7457g;
            float f15 = f14 - oVar3.f7483e;
            v0.c cVar6 = cVar5;
            float f16 = oVar2.f7484f - oVar3.f7484f;
            v0.c cVar7 = cVar4;
            float f17 = (oVar2.f7485g - oVar3.f7485g) + f15;
            float f18 = (oVar2.f7486h - oVar3.f7486h) + f16;
            fArr[0] = (f15 * (1.0f - f12)) + (f17 * f12);
            fArr[1] = (f16 * (1.0f - f13)) + (f18 * f13);
            oVar.b();
            oVar.d(iVar3, g11);
            oVar.h(iVar, iVar2, g11);
            oVar.f(iVar4, iVar5, g11);
            oVar.c(cVar3, g11);
            oVar.g(cVar, cVar2, g11);
            oVar.e(cVar7, cVar6, g11);
            oVar.a(f12, f13, i11, i12, fArr);
            return;
        }
        double g12 = g(g11, this.f7476z);
        this.f7461k[0].g(g12, this.f7470t);
        this.f7461k[0].d(g12, this.f7469s);
        float f19 = this.f7476z[0];
        while (true) {
            double[] dArr2 = this.f7470t;
            if (i13 >= dArr2.length) {
                this.f7457g.r(f12, f13, fArr, this.f7468r, dArr2, this.f7469s);
                oVar.a(f12, f13, i11, i12, fArr);
                return;
            } else {
                dArr2[i13] = dArr2[i13] * f19;
                i13++;
            }
        }
    }

    public float t() {
        return this.f7457g.f7483e;
    }

    public String toString() {
        return " start: x: " + this.f7457g.f7483e + " y: " + this.f7457g.f7484f + " end: x: " + this.f7458h.f7483e + " y: " + this.f7458h.f7484f;
    }

    public float u() {
        return this.f7457g.f7484f;
    }

    public View v() {
        return this.f7452b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x(View view, float f11, long j11, androidx.constraintlayout.core.motion.utils.d dVar) {
        f.d dVar2;
        boolean z10;
        int i11;
        double d11;
        float g11 = g(f11, null);
        int i12 = this.I;
        if (i12 != d.f7324f) {
            float f12 = 1.0f / i12;
            float floor = ((float) Math.floor(g11 / f12)) * f12;
            float f13 = (g11 % f12) / f12;
            if (!Float.isNaN(this.J)) {
                f13 = (f13 + this.J) % 1.0f;
            }
            Interpolator interpolator = this.K;
            g11 = ((interpolator != null ? interpolator.getInterpolation(f13) : ((double) f13) > 0.5d ? 1.0f : 0.0f) * f12) + floor;
        }
        float f14 = g11;
        HashMap hashMap = this.C;
        if (hashMap != null) {
            Iterator it = hashMap.values().iterator();
            while (it.hasNext()) {
                ((v0.d) it.next()).h(view, f14);
            }
        }
        HashMap hashMap2 = this.B;
        if (hashMap2 != null) {
            f.d dVar3 = null;
            boolean z11 = false;
            for (v0.f fVar : hashMap2.values()) {
                if (fVar instanceof f.d) {
                    dVar3 = (f.d) fVar;
                } else {
                    z11 |= fVar.i(view, f14, j11, dVar);
                }
            }
            z10 = z11;
            dVar2 = dVar3;
        } else {
            dVar2 = null;
            z10 = false;
        }
        androidx.constraintlayout.core.motion.utils.b[] bVarArr = this.f7461k;
        if (bVarArr != null) {
            double d12 = f14;
            bVarArr[0].d(d12, this.f7469s);
            this.f7461k[0].g(d12, this.f7470t);
            androidx.constraintlayout.core.motion.utils.b bVar = this.f7462l;
            if (bVar != null) {
                double[] dArr = this.f7469s;
                if (dArr.length > 0) {
                    bVar.d(d12, dArr);
                    this.f7462l.g(d12, this.f7470t);
                }
            }
            if (this.L) {
                d11 = d12;
            } else {
                d11 = d12;
                this.f7457g.s(f14, view, this.f7468r, this.f7469s, this.f7470t, null, this.f7454d);
                this.f7454d = false;
            }
            if (this.G != d.f7324f) {
                if (this.H == null) {
                    this.H = ((View) view.getParent()).findViewById(this.G);
                }
                if (this.H != null) {
                    float top = (r1.getTop() + this.H.getBottom()) / 2.0f;
                    float left = (this.H.getLeft() + this.H.getRight()) / 2.0f;
                    if (view.getRight() - view.getLeft() > 0 && view.getBottom() - view.getTop() > 0) {
                        view.setPivotX(left - view.getLeft());
                        view.setPivotY(top - view.getTop());
                    }
                }
            }
            HashMap hashMap3 = this.C;
            if (hashMap3 != null) {
                for (androidx.constraintlayout.core.motion.utils.i iVar : hashMap3.values()) {
                    if (iVar instanceof d.C0969d) {
                        double[] dArr2 = this.f7470t;
                        if (dArr2.length > 1) {
                            ((d.C0969d) iVar).i(view, f14, dArr2[0], dArr2[1]);
                        }
                    }
                }
            }
            if (dVar2 != null) {
                double[] dArr3 = this.f7470t;
                i11 = 1;
                z10 |= dVar2.j(view, dVar, f14, j11, dArr3[0], dArr3[1]);
            } else {
                i11 = 1;
            }
            int i13 = i11;
            while (true) {
                androidx.constraintlayout.core.motion.utils.b[] bVarArr2 = this.f7461k;
                if (i13 >= bVarArr2.length) {
                    break;
                }
                bVarArr2[i13].e(d11, this.f7474x);
                v0.a.b((ConstraintAttribute) this.f7457g.f7493o.get(this.f7471u[i13 - 1]), view, this.f7474x);
                i13++;
            }
            l lVar = this.f7459i;
            if (lVar.f7426b == 0) {
                if (f14 <= 0.0f) {
                    view.setVisibility(lVar.f7427c);
                } else if (f14 >= 1.0f) {
                    view.setVisibility(this.f7460j.f7427c);
                } else if (this.f7460j.f7427c != lVar.f7427c) {
                    view.setVisibility(0);
                }
            }
            if (this.E != null) {
                int i14 = 0;
                while (true) {
                    k[] kVarArr = this.E;
                    if (i14 >= kVarArr.length) {
                        break;
                    }
                    kVarArr[i14].y(f14, view);
                    i14++;
                }
            }
        } else {
            i11 = 1;
            o oVar = this.f7457g;
            float f15 = oVar.f7483e;
            o oVar2 = this.f7458h;
            float f16 = f15 + ((oVar2.f7483e - f15) * f14);
            float f17 = oVar.f7484f;
            float f18 = f17 + ((oVar2.f7484f - f17) * f14);
            float f19 = oVar.f7485g;
            float f20 = oVar2.f7485g;
            float f21 = oVar.f7486h;
            float f22 = oVar2.f7486h;
            float f23 = f16 + 0.5f;
            int i15 = (int) f23;
            float f24 = f18 + 0.5f;
            int i16 = (int) f24;
            int i17 = (int) (f23 + ((f20 - f19) * f14) + f19);
            int i18 = (int) (f24 + ((f22 - f21) * f14) + f21);
            int i19 = i17 - i15;
            int i20 = i18 - i16;
            if (f20 != f19 || f22 != f21 || this.f7454d) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i19, 1073741824), View.MeasureSpec.makeMeasureSpec(i20, 1073741824));
                this.f7454d = false;
            }
            view.layout(i15, i16, i17, i18);
        }
        HashMap hashMap4 = this.D;
        if (hashMap4 != null) {
            for (v0.c cVar : hashMap4.values()) {
                if (cVar instanceof c.d) {
                    double[] dArr4 = this.f7470t;
                    ((c.d) cVar).k(view, f14, dArr4[0], dArr4[i11]);
                } else {
                    cVar.j(view, f14);
                }
            }
        }
        return z10;
    }

    public void z() {
        this.f7454d = true;
    }
}
