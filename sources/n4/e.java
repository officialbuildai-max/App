package n4;

import java.util.List;

/* loaded from: classes2.dex */
public class e extends g {

    /* renamed from: i, reason: collision with root package name */
    private final r4.d f70327i;

    public e(List list) {
        super(list);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            r4.d dVar = (r4.d) ((w4.a) list.get(i12)).f77687b;
            if (dVar != null) {
                i11 = Math.max(i11, dVar.f());
            }
        }
        this.f70327i = new r4.d(new float[i11], new int[i11]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // n4.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public r4.d i(w4.a aVar, float f11) {
        this.f70327i.g((r4.d) aVar.f77687b, (r4.d) aVar.f77688c, f11);
        return this.f70327i;
    }
}
