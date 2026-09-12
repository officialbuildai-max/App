package n4;

import android.graphics.PointF;
import java.util.Collections;
import n4.a;

/* loaded from: classes2.dex */
public class n extends a {

    /* renamed from: i, reason: collision with root package name */
    private final PointF f70345i;

    /* renamed from: j, reason: collision with root package name */
    private final PointF f70346j;

    /* renamed from: k, reason: collision with root package name */
    private final a f70347k;

    /* renamed from: l, reason: collision with root package name */
    private final a f70348l;

    /* renamed from: m, reason: collision with root package name */
    protected w4.c f70349m;

    /* renamed from: n, reason: collision with root package name */
    protected w4.c f70350n;

    public n(a aVar, a aVar2) {
        super(Collections.emptyList());
        this.f70345i = new PointF();
        this.f70346j = new PointF();
        this.f70347k = aVar;
        this.f70348l = aVar2;
        n(f());
    }

    @Override // n4.a
    public void n(float f11) {
        this.f70347k.n(f11);
        this.f70348l.n(f11);
        this.f70345i.set(((Float) this.f70347k.h()).floatValue(), ((Float) this.f70348l.h()).floatValue());
        for (int i11 = 0; i11 < this.f70299a.size(); i11++) {
            ((a.b) this.f70299a.get(i11)).a();
        }
    }

    @Override // n4.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public PointF h() {
        return i(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // n4.a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public PointF i(w4.a aVar, float f11) {
        Float f12;
        w4.a b11;
        w4.a b12;
        Float f13 = null;
        if (this.f70349m == null || (b12 = this.f70347k.b()) == null) {
            f12 = null;
        } else {
            float d11 = this.f70347k.d();
            Float f14 = b12.f77693h;
            w4.c cVar = this.f70349m;
            float f15 = b12.f77692g;
            f12 = (Float) cVar.b(f15, f14 == null ? f15 : f14.floatValue(), (Float) b12.f77687b, (Float) b12.f77688c, f11, f11, d11);
        }
        if (this.f70350n != null && (b11 = this.f70348l.b()) != null) {
            float d12 = this.f70348l.d();
            Float f16 = b11.f77693h;
            w4.c cVar2 = this.f70350n;
            float f17 = b11.f77692g;
            f13 = (Float) cVar2.b(f17, f16 == null ? f17 : f16.floatValue(), (Float) b11.f77687b, (Float) b11.f77688c, f11, f11, d12);
        }
        if (f12 == null) {
            this.f70346j.set(this.f70345i.x, 0.0f);
        } else {
            this.f70346j.set(f12.floatValue(), 0.0f);
        }
        if (f13 == null) {
            PointF pointF = this.f70346j;
            pointF.set(pointF.x, this.f70345i.y);
        } else {
            PointF pointF2 = this.f70346j;
            pointF2.set(pointF2.x, f13.floatValue());
        }
        return this.f70346j;
    }

    public void s(w4.c cVar) {
        w4.c cVar2 = this.f70349m;
        if (cVar2 != null) {
            cVar2.c(null);
        }
        this.f70349m = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    public void t(w4.c cVar) {
        w4.c cVar2 = this.f70350n;
        if (cVar2 != null) {
            cVar2.c(null);
        }
        this.f70350n = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }
}
