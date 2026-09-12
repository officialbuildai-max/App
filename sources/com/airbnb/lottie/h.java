package com.airbnb.lottie;

import android.graphics.Rect;
import androidx.collection.y0;
import com.airbnb.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    private Map f17814c;

    /* renamed from: d, reason: collision with root package name */
    private Map f17815d;

    /* renamed from: e, reason: collision with root package name */
    private float f17816e;

    /* renamed from: f, reason: collision with root package name */
    private Map f17817f;

    /* renamed from: g, reason: collision with root package name */
    private List f17818g;

    /* renamed from: h, reason: collision with root package name */
    private y0 f17819h;

    /* renamed from: i, reason: collision with root package name */
    private androidx.collection.x f17820i;

    /* renamed from: j, reason: collision with root package name */
    private List f17821j;

    /* renamed from: k, reason: collision with root package name */
    private Rect f17822k;

    /* renamed from: l, reason: collision with root package name */
    private float f17823l;

    /* renamed from: m, reason: collision with root package name */
    private float f17824m;

    /* renamed from: n, reason: collision with root package name */
    private float f17825n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f17826o;

    /* renamed from: q, reason: collision with root package name */
    private int f17828q;

    /* renamed from: r, reason: collision with root package name */
    private int f17829r;

    /* renamed from: a, reason: collision with root package name */
    private final PerformanceTracker f17812a = new PerformanceTracker();

    /* renamed from: b, reason: collision with root package name */
    private final HashSet f17813b = new HashSet();

    /* renamed from: p, reason: collision with root package name */
    private int f17827p = 0;

    public void a(String str) {
        v4.f.c(str);
        this.f17813b.add(str);
    }

    public Rect b() {
        return this.f17822k;
    }

    public y0 c() {
        return this.f17819h;
    }

    public float d() {
        return (e() / this.f17825n) * 1000.0f;
    }

    public float e() {
        return this.f17824m - this.f17823l;
    }

    public float f() {
        return this.f17824m;
    }

    public Map g() {
        return this.f17817f;
    }

    public float h(float f11) {
        return v4.k.i(this.f17823l, this.f17824m, f11);
    }

    public float i() {
        return this.f17825n;
    }

    public Map j() {
        float e11 = v4.l.e();
        if (e11 != this.f17816e) {
            for (Map.Entry entry : this.f17815d.entrySet()) {
                this.f17815d.put((String) entry.getKey(), ((l0) entry.getValue()).a(this.f17816e / e11));
            }
        }
        this.f17816e = e11;
        return this.f17815d;
    }

    public List k() {
        return this.f17821j;
    }

    public p4.g l(String str) {
        int size = this.f17818g.size();
        for (int i11 = 0; i11 < size; i11++) {
            p4.g gVar = (p4.g) this.f17818g.get(i11);
            if (gVar.a(str)) {
                return gVar;
            }
        }
        return null;
    }

    public int m() {
        return this.f17827p;
    }

    public PerformanceTracker n() {
        return this.f17812a;
    }

    public List o(String str) {
        return (List) this.f17814c.get(str);
    }

    public float p() {
        return this.f17823l;
    }

    public boolean q() {
        return this.f17826o;
    }

    public void r(int i11) {
        this.f17827p += i11;
    }

    public void s(Rect rect, float f11, float f12, float f13, List list, androidx.collection.x xVar, Map map, Map map2, float f14, y0 y0Var, Map map3, List list2, int i11, int i12) {
        this.f17822k = rect;
        this.f17823l = f11;
        this.f17824m = f12;
        this.f17825n = f13;
        this.f17821j = list;
        this.f17820i = xVar;
        this.f17814c = map;
        this.f17815d = map2;
        this.f17816e = f14;
        this.f17819h = y0Var;
        this.f17817f = map3;
        this.f17818g = list2;
        this.f17828q = i11;
        this.f17829r = i12;
    }

    public Layer t(long j11) {
        return (Layer) this.f17820i.e(j11);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("LottieComposition:\n");
        Iterator it = this.f17821j.iterator();
        while (it.hasNext()) {
            sb2.append(((Layer) it.next()).z("\t"));
        }
        return sb2.toString();
    }

    public void u(boolean z10) {
        this.f17826o = z10;
    }

    public void v(boolean z10) {
        this.f17812a.b(z10);
    }
}
