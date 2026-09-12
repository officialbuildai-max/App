package m4;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.p0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import n4.a;

/* loaded from: classes2.dex */
public class p implements e, m, j, a.b, k {

    /* renamed from: a, reason: collision with root package name */
    private final Matrix f69404a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    private final Path f69405b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private final LottieDrawable f69406c;

    /* renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.model.layer.a f69407d;

    /* renamed from: e, reason: collision with root package name */
    private final String f69408e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f69409f;

    /* renamed from: g, reason: collision with root package name */
    private final n4.a f69410g;

    /* renamed from: h, reason: collision with root package name */
    private final n4.a f69411h;

    /* renamed from: i, reason: collision with root package name */
    private final n4.p f69412i;

    /* renamed from: j, reason: collision with root package name */
    private d f69413j;

    public p(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, r4.g gVar) {
        this.f69406c = lottieDrawable;
        this.f69407d = aVar;
        this.f69408e = gVar.c();
        this.f69409f = gVar.f();
        n4.d a11 = gVar.b().a();
        this.f69410g = a11;
        aVar.i(a11);
        a11.a(this);
        n4.d a12 = gVar.d().a();
        this.f69411h = a12;
        aVar.i(a12);
        a12.a(this);
        n4.p b11 = gVar.e().b();
        this.f69412i = b11;
        b11.a(aVar);
        b11.b(this);
    }

    @Override // n4.a.b
    public void a() {
        this.f69406c.invalidateSelf();
    }

    @Override // p4.e
    public void b(Object obj, w4.c cVar) {
        if (this.f69412i.c(obj, cVar)) {
            return;
        }
        if (obj == p0.f18005u) {
            this.f69410g.o(cVar);
        } else if (obj == p0.f18006v) {
            this.f69411h.o(cVar);
        }
    }

    @Override // m4.c
    public void c(List list, List list2) {
        this.f69413j.c(list, list2);
    }

    @Override // p4.e
    public void d(p4.d dVar, int i11, List list, p4.d dVar2) {
        v4.k.k(dVar, i11, list, dVar2, this);
        for (int i12 = 0; i12 < this.f69413j.j().size(); i12++) {
            c cVar = (c) this.f69413j.j().get(i12);
            if (cVar instanceof k) {
                v4.k.k(dVar, i11, list, dVar2, (k) cVar);
            }
        }
    }

    @Override // m4.e
    public void f(RectF rectF, Matrix matrix, boolean z10) {
        this.f69413j.f(rectF, matrix, z10);
    }

    @Override // m4.j
    public void g(ListIterator listIterator) {
        if (this.f69413j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add((c) listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f69413j = new d(this.f69406c, this.f69407d, "Repeater", this.f69409f, arrayList, null);
    }

    @Override // m4.c
    public String getName() {
        return this.f69408e;
    }

    @Override // m4.m
    public Path getPath() {
        Path path = this.f69413j.getPath();
        this.f69405b.reset();
        float floatValue = ((Float) this.f69410g.h()).floatValue();
        float floatValue2 = ((Float) this.f69411h.h()).floatValue();
        for (int i11 = ((int) floatValue) - 1; i11 >= 0; i11--) {
            this.f69404a.set(this.f69412i.g(i11 + floatValue2));
            this.f69405b.addPath(path, this.f69404a);
        }
        return this.f69405b;
    }

    @Override // m4.e
    public void h(Canvas canvas, Matrix matrix, int i11) {
        float floatValue = ((Float) this.f69410g.h()).floatValue();
        float floatValue2 = ((Float) this.f69411h.h()).floatValue();
        float floatValue3 = ((Float) this.f69412i.i().h()).floatValue() / 100.0f;
        float floatValue4 = ((Float) this.f69412i.e().h()).floatValue() / 100.0f;
        for (int i12 = ((int) floatValue) - 1; i12 >= 0; i12--) {
            this.f69404a.set(matrix);
            float f11 = i12;
            this.f69404a.preConcat(this.f69412i.g(f11 + floatValue2));
            this.f69413j.h(canvas, this.f69404a, (int) (i11 * v4.k.i(floatValue3, floatValue4, f11 / floatValue)));
        }
    }
}
