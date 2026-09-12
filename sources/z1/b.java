package z1;

import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.common.util.a1;
import com.google.common.collect.g3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Map f79279a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f79280b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f79281c;

    /* renamed from: d, reason: collision with root package name */
    private final Random f79282d;

    public b() {
        this(new Random());
    }

    b(Random random) {
        this.f79281c = new HashMap();
        this.f79282d = random;
        this.f79279a = new HashMap();
        this.f79280b = new HashMap();
    }

    private static void b(Object obj, long j11, Map map) {
        if (map.containsKey(obj)) {
            j11 = Math.max(j11, ((Long) a1.i((Long) map.get(obj))).longValue());
        }
        map.put(obj, Long.valueOf(j11));
    }

    private List c(List list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        h(elapsedRealtime, this.f79279a);
        h(elapsedRealtime, this.f79280b);
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            a2.b bVar = (a2.b) list.get(i11);
            if (!this.f79279a.containsKey(bVar.f117b) && !this.f79280b.containsKey(Integer.valueOf(bVar.f118c))) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(a2.b bVar, a2.b bVar2) {
        int compare = Integer.compare(bVar.f118c, bVar2.f118c);
        return compare != 0 ? compare : bVar.f117b.compareTo(bVar2.f117b);
    }

    public static int f(List list) {
        HashSet hashSet = new HashSet();
        for (int i11 = 0; i11 < list.size(); i11++) {
            hashSet.add(Integer.valueOf(((a2.b) list.get(i11)).f118c));
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

    private a2.b k(List list) {
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            i11 += ((a2.b) list.get(i12)).f119d;
        }
        int nextInt = this.f79282d.nextInt(i11);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            a2.b bVar = (a2.b) list.get(i14);
            i13 += bVar.f119d;
            if (nextInt < i13) {
                return bVar;
            }
        }
        return (a2.b) g3.g(list);
    }

    public void e(a2.b bVar, long j11) {
        long elapsedRealtime = SystemClock.elapsedRealtime() + j11;
        b(bVar.f117b, elapsedRealtime, this.f79279a);
        int i11 = bVar.f118c;
        if (i11 != Integer.MIN_VALUE) {
            b(Integer.valueOf(i11), elapsedRealtime, this.f79280b);
        }
    }

    public int g(List list) {
        HashSet hashSet = new HashSet();
        List c11 = c(list);
        for (int i11 = 0; i11 < c11.size(); i11++) {
            hashSet.add(Integer.valueOf(((a2.b) c11.get(i11)).f118c));
        }
        return hashSet.size();
    }

    public void i() {
        this.f79279a.clear();
        this.f79280b.clear();
        this.f79281c.clear();
    }

    public a2.b j(List list) {
        List c11 = c(list);
        if (c11.size() < 2) {
            return (a2.b) g3.f(c11, null);
        }
        Collections.sort(c11, new Comparator() { // from class: z1.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int d11;
                d11 = b.d((a2.b) obj, (a2.b) obj2);
                return d11;
            }
        });
        ArrayList arrayList = new ArrayList();
        int i11 = ((a2.b) c11.get(0)).f118c;
        int i12 = 0;
        while (true) {
            if (i12 >= c11.size()) {
                break;
            }
            a2.b bVar = (a2.b) c11.get(i12);
            if (i11 == bVar.f118c) {
                arrayList.add(new Pair(bVar.f117b, Integer.valueOf(bVar.f119d)));
                i12++;
            } else if (arrayList.size() == 1) {
                return (a2.b) c11.get(0);
            }
        }
        a2.b bVar2 = (a2.b) this.f79281c.get(arrayList);
        if (bVar2 != null) {
            return bVar2;
        }
        a2.b k11 = k(c11.subList(0, arrayList.size()));
        this.f79281c.put(arrayList, k11);
        return k11;
    }
}
