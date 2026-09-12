package n4;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* loaded from: classes2.dex */
public class j extends g {

    /* renamed from: i, reason: collision with root package name */
    private final PointF f70333i;

    /* renamed from: j, reason: collision with root package name */
    private final float[] f70334j;

    /* renamed from: k, reason: collision with root package name */
    private final float[] f70335k;

    /* renamed from: l, reason: collision with root package name */
    private final PathMeasure f70336l;

    /* renamed from: m, reason: collision with root package name */
    private i f70337m;

    public j(List list) {
        super(list);
        this.f70333i = new PointF();
        this.f70334j = new float[2];
        this.f70335k = new float[2];
        this.f70336l = new PathMeasure();
    }

    @Override // n4.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public PointF i(w4.a aVar, float f11) {
        PointF pointF;
        i iVar = (i) aVar;
        Path k11 = iVar.k();
        if (k11 == null) {
            return (PointF) aVar.f77687b;
        }
        w4.c cVar = this.f70303e;
        if (cVar != null && (pointF = (PointF) cVar.b(iVar.f77692g, iVar.f77693h.floatValue(), (PointF) iVar.f77687b, (PointF) iVar.f77688c, e(), f11, f())) != null) {
            return pointF;
        }
        if (this.f70337m != iVar) {
            this.f70336l.setPath(k11, false);
            this.f70337m = iVar;
        }
        float length = this.f70336l.getLength();
        float f12 = f11 * length;
        this.f70336l.getPosTan(f12, this.f70334j, this.f70335k);
        PointF pointF2 = this.f70333i;
        float[] fArr = this.f70334j;
        pointF2.set(fArr[0], fArr[1]);
        if (f12 < 0.0f) {
            PointF pointF3 = this.f70333i;
            float[] fArr2 = this.f70335k;
            pointF3.offset(fArr2[0] * f12, fArr2[1] * f12);
        } else if (f12 > length) {
            PointF pointF4 = this.f70333i;
            float[] fArr3 = this.f70335k;
            float f13 = f12 - length;
            pointF4.offset(fArr3[0] * f13, fArr3[1] * f13);
        }
        return this.f70333i;
    }
}
