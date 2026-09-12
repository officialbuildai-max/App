package n4;

import android.graphics.Path;
import android.graphics.PointF;

/* loaded from: classes2.dex */
public class i extends w4.a {

    /* renamed from: q, reason: collision with root package name */
    private Path f70331q;

    /* renamed from: r, reason: collision with root package name */
    private final w4.a f70332r;

    public i(com.airbnb.lottie.h hVar, w4.a aVar) {
        super(hVar, (PointF) aVar.f77687b, (PointF) aVar.f77688c, aVar.f77689d, aVar.f77690e, aVar.f77691f, aVar.f77692g, aVar.f77693h);
        this.f70332r = aVar;
        j();
    }

    public void j() {
        Object obj;
        Object obj2;
        Object obj3 = this.f77688c;
        boolean z10 = (obj3 == null || (obj2 = this.f77687b) == null || !((PointF) obj2).equals(((PointF) obj3).x, ((PointF) obj3).y)) ? false : true;
        Object obj4 = this.f77687b;
        if (obj4 == null || (obj = this.f77688c) == null || z10) {
            return;
        }
        w4.a aVar = this.f70332r;
        this.f70331q = v4.l.d((PointF) obj4, (PointF) obj, aVar.f77700o, aVar.f77701p);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path k() {
        return this.f70331q;
    }
}
