package androidx.work.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
final class b0 implements a0 {

    /* renamed from: b, reason: collision with root package name */
    private final Map f15624b = new LinkedHashMap();

    @Override // androidx.work.impl.a0
    public boolean a(androidx.work.impl.model.x id2) {
        Intrinsics.h(id2, "id");
        return this.f15624b.containsKey(id2);
    }

    @Override // androidx.work.impl.a0
    public y b(androidx.work.impl.model.x id2) {
        Intrinsics.h(id2, "id");
        return (y) this.f15624b.remove(id2);
    }

    @Override // androidx.work.impl.a0
    public /* synthetic */ y c(androidx.work.impl.model.j0 j0Var) {
        return z.a(this, j0Var);
    }

    @Override // androidx.work.impl.a0
    public y d(androidx.work.impl.model.x id2) {
        Intrinsics.h(id2, "id");
        Map map = this.f15624b;
        Object obj = map.get(id2);
        if (obj == null) {
            obj = new y(id2);
            map.put(id2, obj);
        }
        return (y) obj;
    }

    @Override // androidx.work.impl.a0
    public List remove(String workSpecId) {
        Intrinsics.h(workSpecId, "workSpecId");
        Map map = this.f15624b;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (Intrinsics.c(((androidx.work.impl.model.x) entry.getKey()).b(), workSpecId)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            this.f15624b.remove((androidx.work.impl.model.x) it.next());
        }
        return CollectionsKt.R0(linkedHashMap.values());
    }
}
