package ka;

import com.google.android.exoplayer2.util.p0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes4.dex */
final class k implements ba.i {

    /* renamed from: a, reason: collision with root package name */
    private final List f66858a;

    /* renamed from: b, reason: collision with root package name */
    private final long[] f66859b;

    /* renamed from: c, reason: collision with root package name */
    private final long[] f66860c;

    public k(List list) {
        this.f66858a = Collections.unmodifiableList(new ArrayList(list));
        this.f66859b = new long[list.size() * 2];
        for (int i11 = 0; i11 < list.size(); i11++) {
            e eVar = (e) list.get(i11);
            int i12 = i11 * 2;
            long[] jArr = this.f66859b;
            jArr[i12] = eVar.f66829b;
            jArr[i12 + 1] = eVar.f66830c;
        }
        long[] jArr2 = this.f66859b;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f66860c = copyOf;
        Arrays.sort(copyOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b(e eVar, e eVar2) {
        return Long.compare(eVar.f66829b, eVar2.f66829b);
    }

    @Override // ba.i
    public List getCues(long j11) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < this.f66858a.size(); i11++) {
            long[] jArr = this.f66859b;
            int i12 = i11 * 2;
            if (jArr[i12] <= j11 && j11 < jArr[i12 + 1]) {
                e eVar = (e) this.f66858a.get(i11);
                ba.b bVar = eVar.f66828a;
                if (bVar.f16337e == -3.4028235E38f) {
                    arrayList2.add(eVar);
                } else {
                    arrayList.add(bVar);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: ka.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int b11;
                b11 = k.b((e) obj, (e) obj2);
                return b11;
            }
        });
        for (int i13 = 0; i13 < arrayList2.size(); i13++) {
            arrayList.add(((e) arrayList2.get(i13)).f66828a.b().h((-1) - i13, 1).a());
        }
        return arrayList;
    }

    @Override // ba.i
    public long getEventTime(int i11) {
        com.google.android.exoplayer2.util.a.a(i11 >= 0);
        com.google.android.exoplayer2.util.a.a(i11 < this.f66860c.length);
        return this.f66860c[i11];
    }

    @Override // ba.i
    public int getEventTimeCount() {
        return this.f66860c.length;
    }

    @Override // ba.i
    public int getNextEventTimeIndex(long j11) {
        int e11 = p0.e(this.f66860c, j11, false, false);
        if (e11 < this.f66860c.length) {
            return e11;
        }
        return -1;
    }
}
