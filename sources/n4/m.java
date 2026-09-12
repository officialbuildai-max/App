package n4;

import android.graphics.Path;
import java.util.List;
import m4.s;

/* loaded from: classes2.dex */
public class m extends a {

    /* renamed from: i, reason: collision with root package name */
    private final r4.i f70340i;

    /* renamed from: j, reason: collision with root package name */
    private final Path f70341j;

    /* renamed from: k, reason: collision with root package name */
    private Path f70342k;

    /* renamed from: l, reason: collision with root package name */
    private Path f70343l;

    /* renamed from: m, reason: collision with root package name */
    private List f70344m;

    public m(List list) {
        super(list);
        this.f70340i = new r4.i();
        this.f70341j = new Path();
    }

    @Override // n4.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public Path i(w4.a aVar, float f11) {
        r4.i iVar = (r4.i) aVar.f77687b;
        r4.i iVar2 = (r4.i) aVar.f77688c;
        this.f70340i.c(iVar, iVar2 == null ? iVar : iVar2, f11);
        r4.i iVar3 = this.f70340i;
        List list = this.f70344m;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                iVar3 = ((s) this.f70344m.get(size)).e(iVar3);
            }
        }
        v4.k.h(iVar3, this.f70341j);
        if (this.f70303e == null) {
            return this.f70341j;
        }
        if (this.f70342k == null) {
            this.f70342k = new Path();
            this.f70343l = new Path();
        }
        v4.k.h(iVar, this.f70342k);
        if (iVar2 != null) {
            v4.k.h(iVar2, this.f70343l);
        }
        w4.c cVar = this.f70303e;
        float f12 = aVar.f77692g;
        float floatValue = aVar.f77693h.floatValue();
        Path path = this.f70342k;
        return (Path) cVar.b(f12, floatValue, path, iVar2 == null ? path : this.f70343l, f11, e(), f());
    }

    public void r(List list) {
        this.f70344m = list;
    }
}
