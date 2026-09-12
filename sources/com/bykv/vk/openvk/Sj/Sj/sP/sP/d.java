package com.bykv.vk.openvk.Sj.Sj.sP.sP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: f, reason: collision with root package name */
    private static final Set f20329f = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    private static final Set f20330g = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f20331a;

    /* renamed from: b, reason: collision with root package name */
    private final int f20332b;

    /* renamed from: c, reason: collision with root package name */
    private int f20333c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f20334d;

    /* renamed from: e, reason: collision with root package name */
    private final int f20335e;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        final String f20336a;

        /* renamed from: b, reason: collision with root package name */
        int f20337b;

        a(String str) {
            this.f20336a = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            d.f20329f.add(this.f20336a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b() {
            d.f20330g.add(this.f20336a);
        }

        public String toString() {
            return this.f20336a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        ArrayList arrayList = new ArrayList(1);
        this.f20331a = arrayList;
        arrayList.add(new a(str));
        this.f20332b = 1;
        this.f20335e = 1;
    }

    d(List list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("urls can't be empty");
        }
        int size = list.size();
        this.f20332b = size;
        this.f20331a = new ArrayList(size);
        Iterator it = list.iterator();
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        while (it.hasNext()) {
            String str = (String) it.next();
            a aVar = new a(str);
            if (f20329f.contains(str)) {
                arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                arrayList2.add(aVar);
            } else if (f20330g.contains(str)) {
                arrayList = arrayList == null ? new ArrayList() : arrayList;
                arrayList.add(aVar);
            } else {
                this.f20331a.add(aVar);
            }
        }
        if (arrayList != null) {
            this.f20331a.addAll(arrayList);
        }
        if (arrayList2 != null) {
            this.f20331a.addAll(arrayList2);
        }
        Integer num = com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20324h;
        this.f20335e = (num == null || num.intValue() <= 0) ? this.f20332b >= 2 ? 1 : 2 : num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f20334d < this.f20335e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a d() {
        if (!b()) {
            throw new NoSuchElementException();
        }
        int i11 = this.f20333c + 1;
        if (i11 >= this.f20332b - 1) {
            this.f20333c = -1;
            this.f20334d++;
        } else {
            this.f20333c = i11;
        }
        a aVar = (a) this.f20331a.get(i11);
        aVar.f20337b = (this.f20334d * this.f20332b) + this.f20333c;
        return aVar;
    }
}
