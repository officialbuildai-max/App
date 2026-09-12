package m4;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.p0;
import java.util.ArrayList;
import java.util.List;
import n4.a;

/* loaded from: classes2.dex */
public class r implements m, a.b, k {

    /* renamed from: b, reason: collision with root package name */
    private final String f69419b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f69420c;

    /* renamed from: d, reason: collision with root package name */
    private final LottieDrawable f69421d;

    /* renamed from: e, reason: collision with root package name */
    private final n4.m f69422e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f69423f;

    /* renamed from: a, reason: collision with root package name */
    private final Path f69418a = new Path();

    /* renamed from: g, reason: collision with root package name */
    private final b f69424g = new b();

    public r(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, r4.l lVar) {
        this.f69419b = lVar.b();
        this.f69420c = lVar.d();
        this.f69421d = lottieDrawable;
        n4.m a11 = lVar.c().a();
        this.f69422e = a11;
        aVar.i(a11);
        a11.a(this);
    }

    private void g() {
        this.f69423f = false;
        this.f69421d.invalidateSelf();
    }

    @Override // n4.a.b
    public void a() {
        g();
    }

    @Override // p4.e
    public void b(Object obj, w4.c cVar) {
        if (obj == p0.P) {
            this.f69422e.o(cVar);
        }
    }

    @Override // m4.c
    public void c(List list, List list2) {
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < list.size(); i11++) {
            c cVar = (c) list.get(i11);
            if (cVar instanceof u) {
                u uVar = (u) cVar;
                if (uVar.j() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f69424g.a(uVar);
                    uVar.b(this);
                }
            }
            if (cVar instanceof s) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((s) cVar);
            }
        }
        this.f69422e.r(arrayList);
    }

    @Override // p4.e
    public void d(p4.d dVar, int i11, List list, p4.d dVar2) {
        v4.k.k(dVar, i11, list, dVar2, this);
    }

    @Override // m4.c
    public String getName() {
        return this.f69419b;
    }

    @Override // m4.m
    public Path getPath() {
        if (this.f69423f && !this.f69422e.k()) {
            return this.f69418a;
        }
        this.f69418a.reset();
        if (this.f69420c) {
            this.f69423f = true;
            return this.f69418a;
        }
        Path path = (Path) this.f69422e.h();
        if (path == null) {
            return this.f69418a;
        }
        this.f69418a.set(path);
        this.f69418a.setFillType(Path.FillType.EVEN_ODD);
        this.f69424g.b(this.f69418a);
        this.f69423f = true;
        return this.f69418a;
    }
}
