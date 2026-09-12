package androidx.media3.exoplayer.upstream;

import androidx.media3.common.util.a1;
import androidx.media3.exoplayer.upstream.b;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class h implements b {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f13048a;

    /* renamed from: b, reason: collision with root package name */
    private final int f13049b;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f13050c;

    /* renamed from: d, reason: collision with root package name */
    private int f13051d;

    /* renamed from: e, reason: collision with root package name */
    private int f13052e;

    /* renamed from: f, reason: collision with root package name */
    private int f13053f;

    /* renamed from: g, reason: collision with root package name */
    private a[] f13054g;

    public h(boolean z10, int i11) {
        this(z10, i11, 0);
    }

    public h(boolean z10, int i11, int i12) {
        androidx.media3.common.util.a.a(i11 > 0);
        androidx.media3.common.util.a.a(i12 >= 0);
        this.f13048a = z10;
        this.f13049b = i11;
        this.f13053f = i12;
        this.f13054g = new a[i12 + 100];
        if (i12 <= 0) {
            this.f13050c = null;
            return;
        }
        this.f13050c = new byte[i12 * i11];
        for (int i13 = 0; i13 < i12; i13++) {
            this.f13054g[i13] = new a(this.f13050c, i13 * i11);
        }
    }

    @Override // androidx.media3.exoplayer.upstream.b
    public synchronized void a(b.a aVar) {
        while (aVar != null) {
            try {
                a[] aVarArr = this.f13054g;
                int i11 = this.f13053f;
                this.f13053f = i11 + 1;
                aVarArr[i11] = aVar.a();
                this.f13052e--;
                aVar = aVar.next();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        notifyAll();
    }

    @Override // androidx.media3.exoplayer.upstream.b
    public synchronized a allocate() {
        a aVar;
        try {
            this.f13052e++;
            int i11 = this.f13053f;
            if (i11 > 0) {
                a[] aVarArr = this.f13054g;
                int i12 = i11 - 1;
                this.f13053f = i12;
                aVar = (a) androidx.media3.common.util.a.e(aVarArr[i12]);
                this.f13054g[this.f13053f] = null;
            } else {
                aVar = new a(new byte[this.f13049b], 0);
                int i13 = this.f13052e;
                a[] aVarArr2 = this.f13054g;
                if (i13 > aVarArr2.length) {
                    this.f13054g = (a[]) Arrays.copyOf(aVarArr2, aVarArr2.length * 2);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return aVar;
    }

    @Override // androidx.media3.exoplayer.upstream.b
    public synchronized void b(a aVar) {
        a[] aVarArr = this.f13054g;
        int i11 = this.f13053f;
        this.f13053f = i11 + 1;
        aVarArr[i11] = aVar;
        this.f13052e--;
        notifyAll();
    }

    public synchronized int c() {
        return this.f13052e * this.f13049b;
    }

    public synchronized void d() {
        if (this.f13048a) {
            e(0);
        }
    }

    public synchronized void e(int i11) {
        boolean z10 = i11 < this.f13051d;
        this.f13051d = i11;
        if (z10) {
            trim();
        }
    }

    @Override // androidx.media3.exoplayer.upstream.b
    public int getIndividualAllocationLength() {
        return this.f13049b;
    }

    @Override // androidx.media3.exoplayer.upstream.b
    public synchronized void trim() {
        try {
            int i11 = 0;
            int max = Math.max(0, a1.k(this.f13051d, this.f13049b) - this.f13052e);
            int i12 = this.f13053f;
            if (max >= i12) {
                return;
            }
            if (this.f13050c != null) {
                int i13 = i12 - 1;
                while (i11 <= i13) {
                    a aVar = (a) androidx.media3.common.util.a.e(this.f13054g[i11]);
                    if (aVar.f13038a == this.f13050c) {
                        i11++;
                    } else {
                        a aVar2 = (a) androidx.media3.common.util.a.e(this.f13054g[i13]);
                        if (aVar2.f13038a != this.f13050c) {
                            i13--;
                        } else {
                            a[] aVarArr = this.f13054g;
                            aVarArr[i11] = aVar2;
                            aVarArr[i13] = aVar;
                            i13--;
                            i11++;
                        }
                    }
                }
                max = Math.max(max, i11);
                if (max >= this.f13053f) {
                    return;
                }
            }
            Arrays.fill(this.f13054g, max, this.f13053f, (Object) null);
            this.f13053f = max;
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
