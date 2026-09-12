package kd;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final a f66902a;

    /* renamed from: b, reason: collision with root package name */
    private final List f66903b;

    public d(a aVar) {
        this.f66902a = aVar;
        ArrayList arrayList = new ArrayList();
        this.f66903b = arrayList;
        arrayList.add(new b(aVar, new int[]{1}));
    }

    private b a(int i11) {
        if (i11 >= this.f66903b.size()) {
            List list = this.f66903b;
            b bVar = (b) list.get(list.size() - 1);
            for (int size = this.f66903b.size(); size <= i11; size++) {
                a aVar = this.f66902a;
                bVar = bVar.i(new b(aVar, new int[]{1, aVar.c((size - 1) + aVar.d())}));
                this.f66903b.add(bVar);
            }
        }
        return (b) this.f66903b.get(i11);
    }

    public void b(int[] iArr, int i11) {
        if (i11 == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i11;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        b a11 = a(i11);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] e11 = new b(this.f66902a, iArr2).j(i11, 1).b(a11)[1].e();
        int length2 = i11 - e11.length;
        for (int i12 = 0; i12 < length2; i12++) {
            iArr[length + i12] = 0;
        }
        System.arraycopy(e11, 0, iArr, length + length2, e11.length);
    }
}
