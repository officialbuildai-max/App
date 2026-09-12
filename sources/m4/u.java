package m4;

import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
import n4.a;

/* loaded from: classes2.dex */
public class u implements c, a.b {

    /* renamed from: a, reason: collision with root package name */
    private final String f69430a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f69431b;

    /* renamed from: c, reason: collision with root package name */
    private final List f69432c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final ShapeTrimPath.Type f69433d;

    /* renamed from: e, reason: collision with root package name */
    private final n4.a f69434e;

    /* renamed from: f, reason: collision with root package name */
    private final n4.a f69435f;

    /* renamed from: g, reason: collision with root package name */
    private final n4.a f69436g;

    public u(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.f69430a = shapeTrimPath.c();
        this.f69431b = shapeTrimPath.g();
        this.f69433d = shapeTrimPath.f();
        n4.d a11 = shapeTrimPath.e().a();
        this.f69434e = a11;
        n4.d a12 = shapeTrimPath.b().a();
        this.f69435f = a12;
        n4.d a13 = shapeTrimPath.d().a();
        this.f69436g = a13;
        aVar.i(a11);
        aVar.i(a12);
        aVar.i(a13);
        a11.a(this);
        a12.a(this);
        a13.a(this);
    }

    @Override // n4.a.b
    public void a() {
        for (int i11 = 0; i11 < this.f69432c.size(); i11++) {
            ((a.b) this.f69432c.get(i11)).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(a.b bVar) {
        this.f69432c.add(bVar);
    }

    @Override // m4.c
    public void c(List list, List list2) {
    }

    public n4.a d() {
        return this.f69435f;
    }

    public n4.a g() {
        return this.f69436g;
    }

    public n4.a i() {
        return this.f69434e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type j() {
        return this.f69433d;
    }

    public boolean k() {
        return this.f69431b;
    }
}
