package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.util.p0;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class o implements b {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f27512a;

    /* renamed from: b, reason: collision with root package name */
    private final int f27513b;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f27514c;

    /* renamed from: d, reason: collision with root package name */
    private int f27515d;

    /* renamed from: e, reason: collision with root package name */
    private int f27516e;

    /* renamed from: f, reason: collision with root package name */
    private int f27517f;

    /* renamed from: g, reason: collision with root package name */
    private a[] f27518g;

    public o(boolean z10, int i11) {
        this(z10, i11, 0);
    }

    public o(boolean z10, int i11, int i12) {
        com.google.android.exoplayer2.util.a.a(i11 > 0);
        com.google.android.exoplayer2.util.a.a(i12 >= 0);
        this.f27512a = z10;
        this.f27513b = i11;
        this.f27517f = i12;
        this.f27518g = new a[i12 + 100];
        if (i12 <= 0) {
            this.f27514c = null;
            return;
        }
        this.f27514c = new byte[i12 * i11];
        for (int i13 = 0; i13 < i12; i13++) {
            this.f27518g[i13] = new a(this.f27514c, i13 * i11);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized void a(b.a aVar) {
        while (aVar != null) {
            try {
                a[] aVarArr = this.f27518g;
                int i11 = this.f27517f;
                this.f27517f = i11 + 1;
                aVarArr[i11] = aVar.a();
                this.f27516e--;
                aVar = aVar.next();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        notifyAll();
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized a allocate() {
        a aVar;
        try {
            this.f27516e++;
            int i11 = this.f27517f;
            if (i11 > 0) {
                a[] aVarArr = this.f27518g;
                int i12 = i11 - 1;
                this.f27517f = i12;
                aVar = (a) com.google.android.exoplayer2.util.a.e(aVarArr[i12]);
                this.f27518g[this.f27517f] = null;
            } else {
                aVar = new a(new byte[this.f27513b], 0);
                int i13 = this.f27516e;
                a[] aVarArr2 = this.f27518g;
                if (i13 > aVarArr2.length) {
                    this.f27518g = (a[]) Arrays.copyOf(aVarArr2, aVarArr2.length * 2);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return aVar;
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized void b(a aVar) {
        a[] aVarArr = this.f27518g;
        int i11 = this.f27517f;
        this.f27517f = i11 + 1;
        aVarArr[i11] = aVar;
        this.f27516e--;
        notifyAll();
    }

    public synchronized int c() {
        return this.f27516e * this.f27513b;
    }

    public synchronized void d() {
        if (this.f27512a) {
            e(0);
        }
    }

    public synchronized void e(int i11) {
        boolean z10 = i11 < this.f27515d;
        this.f27515d = i11;
        if (z10) {
            trim();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public int getIndividualAllocationLength() {
        return this.f27513b;
    }

    @Override // com.google.android.exoplayer2.upstream.b
    public synchronized void trim() {
        try {
            int i11 = 0;
            int max = Math.max(0, p0.l(this.f27515d, this.f27513b) - this.f27516e);
            int i12 = this.f27517f;
            if (max >= i12) {
                return;
            }
            if (this.f27514c != null) {
                int i13 = i12 - 1;
                while (i11 <= i13) {
                    a aVar = (a) com.google.android.exoplayer2.util.a.e(this.f27518g[i11]);
                    if (aVar.f27323a == this.f27514c) {
                        i11++;
                    } else {
                        a aVar2 = (a) com.google.android.exoplayer2.util.a.e(this.f27518g[i13]);
                        if (aVar2.f27323a != this.f27514c) {
                            i13--;
                        } else {
                            a[] aVarArr = this.f27518g;
                            aVarArr[i11] = aVar2;
                            aVarArr[i13] = aVar;
                            i13--;
                            i11++;
                        }
                    }
                }
                max = Math.max(max, i11);
                if (max >= this.f27517f) {
                    return;
                }
            }
            Arrays.fill(this.f27518g, max, this.f27517f, (Object) null);
            this.f27517f = max;
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
