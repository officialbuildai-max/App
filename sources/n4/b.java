package n4;

import java.util.List;

/* loaded from: classes2.dex */
public class b extends g {
    public b(List list) {
        super(list);
    }

    public int q() {
        return r(b(), d());
    }

    public int r(w4.a aVar, float f11) {
        Float f12;
        Integer num;
        if (aVar.f77687b == null || aVar.f77688c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        w4.c cVar = this.f70303e;
        return (cVar == null || (f12 = aVar.f77693h) == null || (num = (Integer) cVar.b(aVar.f77692g, f12.floatValue(), (Integer) aVar.f77687b, (Integer) aVar.f77688c, f11, e(), f())) == null) ? v4.d.c(v4.k.b(f11, 0.0f, 1.0f), ((Integer) aVar.f77687b).intValue(), ((Integer) aVar.f77688c).intValue()) : num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // n4.a
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public Integer i(w4.a aVar, float f11) {
        return Integer.valueOf(r(aVar, f11));
    }
}
