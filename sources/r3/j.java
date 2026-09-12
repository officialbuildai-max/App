package r3;

import androidx.media3.common.util.a1;
import i3.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes2.dex */
final class j implements k {

    /* renamed from: a, reason: collision with root package name */
    private final List f74210a;

    /* renamed from: b, reason: collision with root package name */
    private final long[] f74211b;

    /* renamed from: c, reason: collision with root package name */
    private final long[] f74212c;

    public j(List list) {
        this.f74210a = Collections.unmodifiableList(new ArrayList(list));
        this.f74211b = new long[list.size() * 2];
        for (int i11 = 0; i11 < list.size(); i11++) {
            d dVar = (d) list.get(i11);
            int i12 = i11 * 2;
            long[] jArr = this.f74211b;
            jArr[i12] = dVar.f74181b;
            jArr[i12 + 1] = dVar.f74182c;
        }
        long[] jArr2 = this.f74211b;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f74212c = copyOf;
        Arrays.sort(copyOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b(d dVar, d dVar2) {
        return Long.compare(dVar.f74181b, dVar2.f74181b);
    }

    @Override // i3.k
    public List getCues(long j11) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < this.f74210a.size(); i11++) {
            long[] jArr = this.f74211b;
            int i12 = i11 * 2;
            if (jArr[i12] <= j11 && j11 < jArr[i12 + 1]) {
                d dVar = (d) this.f74210a.get(i11);
                u1.a aVar = dVar.f74180a;
                if (aVar.f76685e == -3.4028235E38f) {
                    arrayList2.add(dVar);
                } else {
                    arrayList.add(aVar);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: r3.i
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int b11;
                b11 = j.b((d) obj, (d) obj2);
                return b11;
            }
        });
        for (int i13 = 0; i13 < arrayList2.size(); i13++) {
            arrayList.add(((d) arrayList2.get(i13)).f74180a.a().h((-1) - i13, 1).a());
        }
        return arrayList;
    }

    @Override // i3.k
    public long getEventTime(int i11) {
        androidx.media3.common.util.a.a(i11 >= 0);
        androidx.media3.common.util.a.a(i11 < this.f74212c.length);
        return this.f74212c[i11];
    }

    @Override // i3.k
    public int getEventTimeCount() {
        return this.f74212c.length;
    }

    @Override // i3.k
    public int getNextEventTimeIndex(long j11) {
        int d11 = a1.d(this.f74212c, j11, false, false);
        if (d11 < this.f74212c.length) {
            return d11;
        }
        return -1;
    }
}
