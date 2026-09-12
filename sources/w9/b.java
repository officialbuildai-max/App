package w9;

import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.g3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Map f77722a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f77723b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f77724c;

    /* renamed from: d, reason: collision with root package name */
    private final Random f77725d;

    public b() {
        this(new Random());
    }

    b(Random random) {
        this.f77724c = new HashMap();
        this.f77725d = random;
        this.f77722a = new HashMap();
        this.f77723b = new HashMap();
    }

    private static void b(Object obj, long j11, Map map) {
        if (map.containsKey(obj)) {
            j11 = Math.max(j11, ((Long) p0.j((Long) map.get(obj))).longValue());
        }
        map.put(obj, Long.valueOf(j11));
    }

    private List c(List list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        h(elapsedRealtime, this.f77722a);
        h(elapsedRealtime, this.f77723b);
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            x9.b bVar = (x9.b) list.get(i11);
            if (!this.f77722a.containsKey(bVar.f78181b) && !this.f77723b.containsKey(Integer.valueOf(bVar.f78182c))) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(x9.b bVar, x9.b bVar2) {
        int compare = Integer.compare(bVar.f78182c, bVar2.f78182c);
        return compare != 0 ? compare : bVar.f78181b.compareTo(bVar2.f78181b);
    }

    public static int f(List list) {
        HashSet hashSet = new HashSet();
        for (int i11 = 0; i11 < list.size(); i11++) {
            hashSet.add(Integer.valueOf(((x9.b) list.get(i11)).f78182c));
        }
        return hashSet.size();
    }

    private static void h(long j11, Map map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            if (((Long) entry.getValue()).longValue() <= j11) {
                arrayList.add(entry.getKey());
            }
        }
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            map.remove(arrayList.get(i11));
        }
    }

    private x9.b k(List list) {
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            i11 += ((x9.b) list.get(i12)).f78183d;
        }
        int nextInt = this.f77725d.nextInt(i11);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            x9.b bVar = (x9.b) list.get(i14);
            i13 += bVar.f78183d;
            if (nextInt < i13) {
                return bVar;
            }
        }
        return (x9.b) g3.g(list);
    }

    public void e(x9.b bVar, long j11) {
        long elapsedRealtime = SystemClock.elapsedRealtime() + j11;
        b(bVar.f78181b, elapsedRealtime, this.f77722a);
        int i11 = bVar.f78182c;
        if (i11 != Integer.MIN_VALUE) {
            b(Integer.valueOf(i11), elapsedRealtime, this.f77723b);
        }
    }

    public int g(List list) {
        HashSet hashSet = new HashSet();
        List c11 = c(list);
        for (int i11 = 0; i11 < c11.size(); i11++) {
            hashSet.add(Integer.valueOf(((x9.b) c11.get(i11)).f78182c));
        }
        return hashSet.size();
    }

    public void i() {
        this.f77722a.clear();
        this.f77723b.clear();
        this.f77724c.clear();
    }

    public x9.b j(List list) {
        List c11 = c(list);
        if (c11.size() < 2) {
            return (x9.b) g3.f(c11, null);
        }
        Collections.sort(c11, new Comparator() { // from class: w9.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int d11;
                d11 = b.d((x9.b) obj, (x9.b) obj2);
                return d11;
            }
        });
        ArrayList arrayList = new ArrayList();
        int i11 = ((x9.b) c11.get(0)).f78182c;
        int i12 = 0;
        while (true) {
            if (i12 >= c11.size()) {
                break;
            }
            x9.b bVar = (x9.b) c11.get(i12);
            if (i11 == bVar.f78182c) {
                arrayList.add(new Pair(bVar.f78181b, Integer.valueOf(bVar.f78183d)));
                i12++;
            } else if (arrayList.size() == 1) {
                return (x9.b) c11.get(0);
            }
        }
        x9.b bVar2 = (x9.b) this.f77724c.get(arrayList);
        if (bVar2 != null) {
            return bVar2;
        }
        x9.b k11 = k(c11.subList(0, arrayList.size()));
        this.f77724c.put(arrayList, k11);
        return k11;
    }
}
