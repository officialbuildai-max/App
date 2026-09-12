package androidx.coordinatorlayout.widget;

import androidx.collection.x0;
import androidx.core.util.f;
import androidx.core.util.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final f f8001a = new g(10);

    /* renamed from: b, reason: collision with root package name */
    private final x0 f8002b = new x0();

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList f8003c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final HashSet f8004d = new HashSet();

    private void e(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) this.f8002b.get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i11 = 0; i11 < size; i11++) {
                e(arrayList2.get(i11), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    private ArrayList f() {
        ArrayList arrayList = (ArrayList) this.f8001a.acquire();
        return arrayList == null ? new ArrayList() : arrayList;
    }

    private void k(ArrayList arrayList) {
        arrayList.clear();
        this.f8001a.release(arrayList);
    }

    public void a(Object obj, Object obj2) {
        if (!this.f8002b.containsKey(obj) || !this.f8002b.containsKey(obj2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = (ArrayList) this.f8002b.get(obj);
        if (arrayList == null) {
            arrayList = f();
            this.f8002b.put(obj, arrayList);
        }
        arrayList.add(obj2);
    }

    public void b(Object obj) {
        if (this.f8002b.containsKey(obj)) {
            return;
        }
        this.f8002b.put(obj, null);
    }

    public void c() {
        int size = this.f8002b.size();
        for (int i11 = 0; i11 < size; i11++) {
            ArrayList arrayList = (ArrayList) this.f8002b.valueAt(i11);
            if (arrayList != null) {
                k(arrayList);
            }
        }
        this.f8002b.clear();
    }

    public boolean d(Object obj) {
        return this.f8002b.containsKey(obj);
    }

    public List g(Object obj) {
        return (List) this.f8002b.get(obj);
    }

    public List h(Object obj) {
        int size = this.f8002b.size();
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < size; i11++) {
            ArrayList arrayList2 = (ArrayList) this.f8002b.valueAt(i11);
            if (arrayList2 != null && arrayList2.contains(obj)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f8002b.keyAt(i11));
            }
        }
        return arrayList;
    }

    public ArrayList i() {
        this.f8003c.clear();
        this.f8004d.clear();
        int size = this.f8002b.size();
        for (int i11 = 0; i11 < size; i11++) {
            e(this.f8002b.keyAt(i11), this.f8003c, this.f8004d);
        }
        return this.f8003c;
    }

    public boolean j(Object obj) {
        int size = this.f8002b.size();
        for (int i11 = 0; i11 < size; i11++) {
            ArrayList arrayList = (ArrayList) this.f8002b.valueAt(i11);
            if (arrayList != null && arrayList.contains(obj)) {
                return true;
            }
        }
        return false;
    }
}
