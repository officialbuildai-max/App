package m4;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.p0;

/* loaded from: classes2.dex */
public class t extends a {

    /* renamed from: r, reason: collision with root package name */
    private final com.airbnb.lottie.model.layer.a f69425r;

    /* renamed from: s, reason: collision with root package name */
    private final String f69426s;

    /* renamed from: t, reason: collision with root package name */
    private final boolean f69427t;

    /* renamed from: u, reason: collision with root package name */
    private final n4.a f69428u;

    /* renamed from: v, reason: collision with root package name */
    private n4.a f69429v;

    public t(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(lottieDrawable, aVar, shapeStroke.b().toPaintCap(), shapeStroke.e().toPaintJoin(), shapeStroke.g(), shapeStroke.i(), shapeStroke.j(), shapeStroke.f(), shapeStroke.d());
        this.f69425r = aVar;
        this.f69426s = shapeStroke.h();
        this.f69427t = shapeStroke.k();
        n4.a a11 = shapeStroke.c().a();
        this.f69428u = a11;
        a11.a(this);
        aVar.i(a11);
    }

    @Override // m4.a, p4.e
    public void b(Object obj, w4.c cVar) {
        super.b(obj, cVar);
        if (obj == p0.f17986b) {
            this.f69428u.o(cVar);
            return;
        }
        if (obj == p0.K) {
            n4.a aVar = this.f69429v;
            if (aVar != null) {
                this.f69425r.H(aVar);
            }
            if (cVar == null) {
                this.f69429v = null;
                return;
            }
            n4.q qVar = new n4.q(cVar);
            this.f69429v = qVar;
            qVar.a(this);
            this.f69425r.i(this.f69428u);
        }
    }

    @Override // m4.c
    public String getName() {
        return this.f69426s;
    }

    @Override // m4.a, m4.e
    public void h(Canvas canvas, Matrix matrix, int i11) {
        if (this.f69427t) {
            return;
        }
        this.f69293i.setColor(((n4.b) this.f69428u).q());
        n4.a aVar = this.f69429v;
        if (aVar != null) {
            this.f69293i.setColorFilter((ColorFilter) aVar.h());
        }
        super.h(canvas, matrix, i11);
    }
}
