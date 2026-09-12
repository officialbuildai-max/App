package com.google.zxing.pdf417.decoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Map f33011a = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a() {
        ArrayList arrayList = new ArrayList();
        int i11 = -1;
        for (Map.Entry entry : this.f33011a.entrySet()) {
            if (((Integer) entry.getValue()).intValue() > i11) {
                i11 = ((Integer) entry.getValue()).intValue();
                arrayList.clear();
                arrayList.add((Integer) entry.getKey());
            } else if (((Integer) entry.getValue()).intValue() == i11) {
                arrayList.add((Integer) entry.getKey());
            }
        }
        return td.a.b(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i11) {
        Integer num = (Integer) this.f33011a.get(Integer.valueOf(i11));
        if (num == null) {
            num = 0;
        }
        this.f33011a.put(Integer.valueOf(i11), Integer.valueOf(num.intValue() + 1));
    }
}
