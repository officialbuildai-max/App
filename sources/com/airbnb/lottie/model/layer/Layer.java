package com.airbnb.lottie.model.layer;

import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.LBlendMode;
import java.util.List;
import java.util.Locale;
import q4.j;
import q4.k;
import q4.n;

/* loaded from: classes.dex */
public class Layer {

    /* renamed from: a, reason: collision with root package name */
    private final List f17915a;

    /* renamed from: b, reason: collision with root package name */
    private final h f17916b;

    /* renamed from: c, reason: collision with root package name */
    private final String f17917c;

    /* renamed from: d, reason: collision with root package name */
    private final long f17918d;

    /* renamed from: e, reason: collision with root package name */
    private final LayerType f17919e;

    /* renamed from: f, reason: collision with root package name */
    private final long f17920f;

    /* renamed from: g, reason: collision with root package name */
    private final String f17921g;

    /* renamed from: h, reason: collision with root package name */
    private final List f17922h;

    /* renamed from: i, reason: collision with root package name */
    private final n f17923i;

    /* renamed from: j, reason: collision with root package name */
    private final int f17924j;

    /* renamed from: k, reason: collision with root package name */
    private final int f17925k;

    /* renamed from: l, reason: collision with root package name */
    private final int f17926l;

    /* renamed from: m, reason: collision with root package name */
    private final float f17927m;

    /* renamed from: n, reason: collision with root package name */
    private final float f17928n;

    /* renamed from: o, reason: collision with root package name */
    private final float f17929o;

    /* renamed from: p, reason: collision with root package name */
    private final float f17930p;

    /* renamed from: q, reason: collision with root package name */
    private final j f17931q;

    /* renamed from: r, reason: collision with root package name */
    private final k f17932r;

    /* renamed from: s, reason: collision with root package name */
    private final q4.b f17933s;

    /* renamed from: t, reason: collision with root package name */
    private final List f17934t;

    /* renamed from: u, reason: collision with root package name */
    private final MatteType f17935u;

    /* renamed from: v, reason: collision with root package name */
    private final boolean f17936v;

    /* renamed from: w, reason: collision with root package name */
    private final r4.a f17937w;

    /* renamed from: x, reason: collision with root package name */
    private final u4.j f17938x;

    /* renamed from: y, reason: collision with root package name */
    private final LBlendMode f17939y;

    /* loaded from: classes.dex */
    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* loaded from: classes.dex */
    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(List list, h hVar, String str, long j11, LayerType layerType, long j12, String str2, List list2, n nVar, int i11, int i12, int i13, float f11, float f12, float f13, float f14, j jVar, k kVar, List list3, MatteType matteType, q4.b bVar, boolean z10, r4.a aVar, u4.j jVar2, LBlendMode lBlendMode) {
        this.f17915a = list;
        this.f17916b = hVar;
        this.f17917c = str;
        this.f17918d = j11;
        this.f17919e = layerType;
        this.f17920f = j12;
        this.f17921g = str2;
        this.f17922h = list2;
        this.f17923i = nVar;
        this.f17924j = i11;
        this.f17925k = i12;
        this.f17926l = i13;
        this.f17927m = f11;
        this.f17928n = f12;
        this.f17929o = f13;
        this.f17930p = f14;
        this.f17931q = jVar;
        this.f17932r = kVar;
        this.f17934t = list3;
        this.f17935u = matteType;
        this.f17933s = bVar;
        this.f17936v = z10;
        this.f17937w = aVar;
        this.f17938x = jVar2;
        this.f17939y = lBlendMode;
    }

    public LBlendMode a() {
        return this.f17939y;
    }

    public r4.a b() {
        return this.f17937w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h c() {
        return this.f17916b;
    }

    public u4.j d() {
        return this.f17938x;
    }

    public long e() {
        return this.f17918d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List f() {
        return this.f17934t;
    }

    public LayerType g() {
        return this.f17919e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List h() {
        return this.f17922h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType i() {
        return this.f17935u;
    }

    public String j() {
        return this.f17917c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long k() {
        return this.f17920f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float l() {
        return this.f17930p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float m() {
        return this.f17929o;
    }

    public String n() {
        return this.f17921g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List o() {
        return this.f17915a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        return this.f17926l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        return this.f17925k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int r() {
        return this.f17924j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float s() {
        return this.f17928n / this.f17916b.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j t() {
        return this.f17931q;
    }

    public String toString() {
        return z("");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k u() {
        return this.f17932r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q4.b v() {
        return this.f17933s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float w() {
        return this.f17927m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n x() {
        return this.f17923i;
    }

    public boolean y() {
        return this.f17936v;
    }

    public String z(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(j());
        sb2.append("\n");
        Layer t11 = this.f17916b.t(k());
        if (t11 != null) {
            sb2.append("\t\tParents: ");
            sb2.append(t11.j());
            Layer t12 = this.f17916b.t(t11.k());
            while (t12 != null) {
                sb2.append("->");
                sb2.append(t12.j());
                t12 = this.f17916b.t(t12.k());
            }
            sb2.append(str);
            sb2.append("\n");
        }
        if (!h().isEmpty()) {
            sb2.append(str);
            sb2.append("\tMasks: ");
            sb2.append(h().size());
            sb2.append("\n");
        }
        if (r() != 0 && q() != 0) {
            sb2.append(str);
            sb2.append("\tBackground: ");
            sb2.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(r()), Integer.valueOf(q()), Integer.valueOf(p())));
        }
        if (!this.f17915a.isEmpty()) {
            sb2.append(str);
            sb2.append("\tShapes:\n");
            for (Object obj : this.f17915a) {
                sb2.append(str);
                sb2.append("\t\t");
                sb2.append(obj);
                sb2.append("\n");
            }
        }
        return sb2.toString();
    }
}
