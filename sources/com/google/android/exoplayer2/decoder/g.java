package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.o1;

/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f24943a;

    /* renamed from: b, reason: collision with root package name */
    public final o1 f24944b;

    /* renamed from: c, reason: collision with root package name */
    public final o1 f24945c;

    /* renamed from: d, reason: collision with root package name */
    public final int f24946d;

    /* renamed from: e, reason: collision with root package name */
    public final int f24947e;

    public g(String str, o1 o1Var, o1 o1Var2, int i11, int i12) {
        com.google.android.exoplayer2.util.a.a(i11 == 0 || i12 == 0);
        this.f24943a = com.google.android.exoplayer2.util.a.d(str);
        this.f24944b = (o1) com.google.android.exoplayer2.util.a.e(o1Var);
        this.f24945c = (o1) com.google.android.exoplayer2.util.a.e(o1Var2);
        this.f24946d = i11;
        this.f24947e = i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f24946d == gVar.f24946d && this.f24947e == gVar.f24947e && this.f24943a.equals(gVar.f24943a) && this.f24944b.equals(gVar.f24944b) && this.f24945c.equals(gVar.f24945c);
    }

    public int hashCode() {
        return ((((((((527 + this.f24946d) * 31) + this.f24947e) * 31) + this.f24943a.hashCode()) * 31) + this.f24944b.hashCode()) * 31) + this.f24945c.hashCode();
    }
}
