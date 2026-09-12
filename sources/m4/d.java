package m4;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import java.util.ArrayList;
import java.util.List;
import n4.a;

/* loaded from: classes2.dex */
public class d implements e, m, a.b, p4.e {

    /* renamed from: a, reason: collision with root package name */
    private final Paint f69305a;

    /* renamed from: b, reason: collision with root package name */
    private final RectF f69306b;

    /* renamed from: c, reason: collision with root package name */
    private final Matrix f69307c;

    /* renamed from: d, reason: collision with root package name */
    private final Path f69308d;

    /* renamed from: e, reason: collision with root package name */
    private final RectF f69309e;

    /* renamed from: f, reason: collision with root package name */
    private final String f69310f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f69311g;

    /* renamed from: h, reason: collision with root package name */
    private final List f69312h;

    /* renamed from: i, reason: collision with root package name */
    private final LottieDrawable f69313i;

    /* renamed from: j, reason: collision with root package name */
    private List f69314j;

    /* renamed from: k, reason: collision with root package name */
    private n4.p f69315k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, String str, boolean z10, List list, q4.n nVar) {
        this.f69305a = new l4.a();
        this.f69306b = new RectF();
        this.f69307c = new Matrix();
        this.f69308d = new Path();
        this.f69309e = new RectF();
        this.f69310f = str;
        this.f69313i = lottieDrawable;
        this.f69311g = z10;
        this.f69312h = list;
        if (nVar != null) {
            n4.p b11 = nVar.b();
            this.f69315k = b11;
            b11.a(aVar);
            this.f69315k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = (c) list.get(size);
            if (cVar instanceof j) {
                arrayList.add((j) cVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((j) arrayList.get(size2)).g(list.listIterator(list.size()));
        }
    }

    public d(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, r4.k kVar, com.airbnb.lottie.h hVar) {
        this(lottieDrawable, aVar, kVar.c(), kVar.d(), g(lottieDrawable, hVar, aVar, kVar.b()), i(kVar.b()));
    }

    private static List g(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar, List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i11 = 0; i11 < list.size(); i11++) {
            c a11 = ((r4.c) list.get(i11)).a(lottieDrawable, hVar, aVar);
            if (a11 != null) {
                arrayList.add(a11);
            }
        }
        return arrayList;
    }

    static q4.n i(List list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            r4.c cVar = (r4.c) list.get(i11);
            if (cVar instanceof q4.n) {
                return (q4.n) cVar;
            }
        }
        return null;
    }

    private boolean m() {
        int i11 = 0;
        for (int i12 = 0; i12 < this.f69312h.size(); i12++) {
            if ((this.f69312h.get(i12) instanceof e) && (i11 = i11 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // n4.a.b
    public void a() {
        this.f69313i.invalidateSelf();
    }

    @Override // p4.e
    public void b(Object obj, w4.c cVar) {
        n4.p pVar = this.f69315k;
        if (pVar != null) {
            pVar.c(obj, cVar);
        }
    }

    @Override // m4.c
    public void c(List list, List list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f69312h.size());
        arrayList.addAll(list);
        for (int size = this.f69312h.size() - 1; size >= 0; size--) {
            c cVar = (c) this.f69312h.get(size);
            cVar.c(arrayList, this.f69312h.subList(0, size));
            arrayList.add(cVar);
        }
    }

    @Override // p4.e
    public void d(p4.d dVar, int i11, List list, p4.d dVar2) {
        if (dVar.g(getName(), i11) || "__container".equals(getName())) {
            if (!"__container".equals(getName())) {
                dVar2 = dVar2.a(getName());
                if (dVar.c(getName(), i11)) {
                    list.add(dVar2.i(this));
                }
            }
            if (dVar.h(getName(), i11)) {
                int e11 = i11 + dVar.e(getName(), i11);
                for (int i12 = 0; i12 < this.f69312h.size(); i12++) {
                    c cVar = (c) this.f69312h.get(i12);
                    if (cVar instanceof p4.e) {
                        ((p4.e) cVar).d(dVar, e11, list, dVar2);
                    }
                }
            }
        }
    }

    @Override // m4.e
    public void f(RectF rectF, Matrix matrix, boolean z10) {
        this.f69307c.set(matrix);
        n4.p pVar = this.f69315k;
        if (pVar != null) {
            this.f69307c.preConcat(pVar.f());
        }
        this.f69309e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f69312h.size() - 1; size >= 0; size--) {
            c cVar = (c) this.f69312h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).f(this.f69309e, this.f69307c, z10);
                rectF.union(this.f69309e);
            }
        }
    }

    @Override // m4.c
    public String getName() {
        return this.f69310f;
    }

    @Override // m4.m
    public Path getPath() {
        this.f69307c.reset();
        n4.p pVar = this.f69315k;
        if (pVar != null) {
            this.f69307c.set(pVar.f());
        }
        this.f69308d.reset();
        if (this.f69311g) {
            return this.f69308d;
        }
        for (int size = this.f69312h.size() - 1; size >= 0; size--) {
            c cVar = (c) this.f69312h.get(size);
            if (cVar instanceof m) {
                this.f69308d.addPath(((m) cVar).getPath(), this.f69307c);
            }
        }
        return this.f69308d;
    }

    @Override // m4.e
    public void h(Canvas canvas, Matrix matrix, int i11) {
        if (this.f69311g) {
            return;
        }
        this.f69307c.set(matrix);
        n4.p pVar = this.f69315k;
        if (pVar != null) {
            this.f69307c.preConcat(pVar.f());
            i11 = (int) (((((this.f69315k.h() == null ? 100 : ((Integer) this.f69315k.h().h()).intValue()) / 100.0f) * i11) / 255.0f) * 255.0f);
        }
        boolean z10 = this.f69313i.m0() && m() && i11 != 255;
        if (z10) {
            this.f69306b.set(0.0f, 0.0f, 0.0f, 0.0f);
            f(this.f69306b, this.f69307c, true);
            this.f69305a.setAlpha(i11);
            v4.l.n(canvas, this.f69306b, this.f69305a);
        }
        if (z10) {
            i11 = 255;
        }
        for (int size = this.f69312h.size() - 1; size >= 0; size--) {
            Object obj = this.f69312h.get(size);
            if (obj instanceof e) {
                ((e) obj).h(canvas, this.f69307c, i11);
            }
        }
        if (z10) {
            canvas.restore();
        }
    }

    public List j() {
        return this.f69312h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List k() {
        if (this.f69314j == null) {
            this.f69314j = new ArrayList();
            for (int i11 = 0; i11 < this.f69312h.size(); i11++) {
                c cVar = (c) this.f69312h.get(i11);
                if (cVar instanceof m) {
                    this.f69314j.add((m) cVar);
                }
            }
        }
        return this.f69314j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix l() {
        n4.p pVar = this.f69315k;
        if (pVar != null) {
            return pVar.f();
        }
        this.f69307c.reset();
        return this.f69307c;
    }
}
