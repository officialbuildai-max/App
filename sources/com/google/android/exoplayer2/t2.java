package com.google.android.exoplayer2;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
final class t2 extends a {

    /* renamed from: f, reason: collision with root package name */
    private final int f26775f;

    /* renamed from: g, reason: collision with root package name */
    private final int f26776g;

    /* renamed from: h, reason: collision with root package name */
    private final int[] f26777h;

    /* renamed from: i, reason: collision with root package name */
    private final int[] f26778i;

    /* renamed from: j, reason: collision with root package name */
    private final k3[] f26779j;

    /* renamed from: k, reason: collision with root package name */
    private final Object[] f26780k;

    /* renamed from: l, reason: collision with root package name */
    private final HashMap f26781l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t2(Collection collection, t9.t tVar) {
        super(false, tVar);
        int i11 = 0;
        int size = collection.size();
        this.f26777h = new int[size];
        this.f26778i = new int[size];
        this.f26779j = new k3[size];
        this.f26780k = new Object[size];
        this.f26781l = new HashMap();
        Iterator it = collection.iterator();
        int i12 = 0;
        int i13 = 0;
        while (it.hasNext()) {
            f2 f2Var = (f2) it.next();
            this.f26779j[i13] = f2Var.b();
            this.f26778i[i13] = i11;
            this.f26777h[i13] = i12;
            i11 += this.f26779j[i13].t();
            i12 += this.f26779j[i13].m();
            this.f26780k[i13] = f2Var.a();
            this.f26781l.put(this.f26780k[i13], Integer.valueOf(i13));
            i13++;
        }
        this.f26775f = i11;
        this.f26776g = i12;
    }

    @Override // com.google.android.exoplayer2.a
    protected int A(int i11) {
        return com.google.android.exoplayer2.util.p0.h(this.f26778i, i11 + 1, false, false);
    }

    @Override // com.google.android.exoplayer2.a
    protected Object D(int i11) {
        return this.f26780k[i11];
    }

    @Override // com.google.android.exoplayer2.a
    protected int F(int i11) {
        return this.f26777h[i11];
    }

    @Override // com.google.android.exoplayer2.a
    protected int G(int i11) {
        return this.f26778i[i11];
    }

    @Override // com.google.android.exoplayer2.a
    protected k3 J(int i11) {
        return this.f26779j[i11];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List K() {
        return Arrays.asList(this.f26779j);
    }

    @Override // com.google.android.exoplayer2.k3
    public int m() {
        return this.f26776g;
    }

    @Override // com.google.android.exoplayer2.k3
    public int t() {
        return this.f26775f;
    }

    @Override // com.google.android.exoplayer2.a
    protected int y(Object obj) {
        Integer num = (Integer) this.f26781l.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.android.exoplayer2.a
    protected int z(int i11) {
        return com.google.android.exoplayer2.util.p0.h(this.f26777h, i11 + 1, false, false);
    }
}
