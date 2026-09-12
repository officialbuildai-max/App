package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.v;
import java.util.Arrays;

/* loaded from: classes5.dex */
public final class w extends v.a.AbstractC0584a {

    /* renamed from: c, reason: collision with root package name */
    public static final w f40740c = new w(0, j.f40666n);

    /* renamed from: b, reason: collision with root package name */
    public short[] f40741b;

    public w(int i11, short[] sArr) {
        super(i11);
        this.f40741b = sArr;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(w wVar) {
        return gf.c.f(this.f40741b, wVar.f40741b);
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public boolean equals(Object obj) {
        return (obj instanceof w) && compareTo((w) obj) == 0;
    }

    @Override // com.tencent.tinker.android.dex.v.a.AbstractC0584a
    public int hashCode() {
        return Arrays.hashCode(this.f40741b);
    }
}
