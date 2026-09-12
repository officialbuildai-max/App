package com.transsion.json;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    final LinkedList f46149a = new LinkedList();

    public q a(String str) {
        this.f46149a.add(str);
        return this;
    }

    public List b() {
        return this.f46149a;
    }

    public int c() {
        return this.f46149a.size();
    }

    public String d() {
        return (String) this.f46149a.removeLast();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        return this.f46149a.equals(((q) obj).f46149a);
    }

    public int hashCode() {
        return this.f46149a.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[ ");
        Iterator it = this.f46149a.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z10) {
                sb2.append(".");
            }
            sb2.append(str);
            z10 = true;
        }
        sb2.append(" ]");
        return sb2.toString();
    }
}
