package r4;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private final List f74243a;

    /* renamed from: b, reason: collision with root package name */
    private PointF f74244b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f74245c;

    public i() {
        this.f74243a = new ArrayList();
    }

    public i(PointF pointF, boolean z10, List list) {
        this.f74244b = pointF;
        this.f74245c = z10;
        this.f74243a = new ArrayList(list);
    }

    public List a() {
        return this.f74243a;
    }

    public PointF b() {
        return this.f74244b;
    }

    public void c(i iVar, i iVar2, float f11) {
        if (this.f74244b == null) {
            this.f74244b = new PointF();
        }
        this.f74245c = iVar.d() || iVar2.d();
        if (iVar.a().size() != iVar2.a().size()) {
            v4.f.c("Curves must have the same number of control points. Shape 1: " + iVar.a().size() + "\tShape 2: " + iVar2.a().size());
        }
        int min = Math.min(iVar.a().size(), iVar2.a().size());
        if (this.f74243a.size() < min) {
            for (int size = this.f74243a.size(); size < min; size++) {
                this.f74243a.add(new p4.a());
            }
        } else if (this.f74243a.size() > min) {
            for (int size2 = this.f74243a.size() - 1; size2 >= min; size2--) {
                List list = this.f74243a;
                list.remove(list.size() - 1);
            }
        }
        PointF b11 = iVar.b();
        PointF b12 = iVar2.b();
        f(v4.k.i(b11.x, b12.x, f11), v4.k.i(b11.y, b12.y, f11));
        for (int size3 = this.f74243a.size() - 1; size3 >= 0; size3--) {
            p4.a aVar = (p4.a) iVar.a().get(size3);
            p4.a aVar2 = (p4.a) iVar2.a().get(size3);
            PointF a11 = aVar.a();
            PointF b13 = aVar.b();
            PointF c11 = aVar.c();
            PointF a12 = aVar2.a();
            PointF b14 = aVar2.b();
            PointF c12 = aVar2.c();
            ((p4.a) this.f74243a.get(size3)).d(v4.k.i(a11.x, a12.x, f11), v4.k.i(a11.y, a12.y, f11));
            ((p4.a) this.f74243a.get(size3)).e(v4.k.i(b13.x, b14.x, f11), v4.k.i(b13.y, b14.y, f11));
            ((p4.a) this.f74243a.get(size3)).f(v4.k.i(c11.x, c12.x, f11), v4.k.i(c11.y, c12.y, f11));
        }
    }

    public boolean d() {
        return this.f74245c;
    }

    public void e(boolean z10) {
        this.f74245c = z10;
    }

    public void f(float f11, float f12) {
        if (this.f74244b == null) {
            this.f74244b = new PointF();
        }
        this.f74244b.set(f11, f12);
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f74243a.size() + "closed=" + this.f74245c + '}';
    }
}
