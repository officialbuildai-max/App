package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.v;

/* loaded from: classes5.dex */
public class u extends v.a.AbstractC0584a {

    /* renamed from: b, reason: collision with root package name */
    public String f40707b;

    public u(int i11, String str) {
        super(i11);
        this.f40707b = str;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(u uVar) {
        return this.f40707b.compareTo(uVar.f40707b);
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public boolean equals(Object obj) {
        return (obj instanceof u) && compareTo((u) obj) == 0;
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public int hashCode() {
        return this.f40707b.hashCode();
    }
}
