package com.mbridge.msdk.thrid.okio;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class q extends f {

    /* renamed from: f, reason: collision with root package name */
    final transient byte[][] f38527f;

    /* renamed from: g, reason: collision with root package name */
    final transient int[] f38528g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(c cVar, int i11) {
        super(null);
        u.a(cVar.f38486b, 0L, i11);
        o oVar = cVar.f38485a;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i11) {
            int i15 = oVar.f38520c;
            int i16 = oVar.f38519b;
            if (i15 == i16) {
                throw new AssertionError("s.limit == s.pos");
            }
            i13 += i15 - i16;
            i14++;
            oVar = oVar.f38523f;
        }
        this.f38527f = new byte[i14];
        this.f38528g = new int[i14 * 2];
        o oVar2 = cVar.f38485a;
        int i17 = 0;
        while (i12 < i11) {
            byte[][] bArr = this.f38527f;
            bArr[i17] = oVar2.f38518a;
            int i18 = oVar2.f38520c;
            int i19 = oVar2.f38519b;
            i12 += i18 - i19;
            if (i12 > i11) {
                i12 = i11;
            }
            int[] iArr = this.f38528g;
            iArr[i17] = i12;
            iArr[bArr.length + i17] = i19;
            oVar2.f38521d = true;
            i17++;
            oVar2 = oVar2.f38523f;
        }
    }

    private int b(int i11) {
        int binarySearch = Arrays.binarySearch(this.f38528g, 0, this.f38527f.length, i11 + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    private f i() {
        return new f(g());
    }

    @Override // com.mbridge.msdk.thrid.okio.f
    public byte a(int i11) {
        u.a(this.f38528g[this.f38527f.length - 1], i11, 1L);
        int b11 = b(i11);
        int i12 = b11 == 0 ? 0 : this.f38528g[b11 - 1];
        int[] iArr = this.f38528g;
        byte[][] bArr = this.f38527f;
        return bArr[b11][(i11 - i12) + iArr[bArr.length + b11]];
    }

    @Override // com.mbridge.msdk.thrid.okio.f
    public f a(int i11, int i12) {
        return i().a(i11, i12);
    }

    @Override // com.mbridge.msdk.thrid.okio.f
    public String a() {
        return i().a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.mbridge.msdk.thrid.okio.f
    public void a(c cVar) {
        int length = this.f38527f.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int[] iArr = this.f38528g;
            int i13 = iArr[length + i11];
            int i14 = iArr[i11];
            o oVar = new o(this.f38527f[i11], i13, (i13 + i14) - i12, true, false);
            o oVar2 = cVar.f38485a;
            if (oVar2 == null) {
                oVar.f38524g = oVar;
                oVar.f38523f = oVar;
                cVar.f38485a = oVar;
            } else {
                oVar2.f38524g.a(oVar);
            }
            i11++;
            i12 = i14;
        }
        cVar.f38486b += i12;
    }

    @Override // com.mbridge.msdk.thrid.okio.f
    public boolean a(int i11, f fVar, int i12, int i13) {
        if (i11 < 0 || i11 > e() - i13) {
            return false;
        }
        int b11 = b(i11);
        while (i13 > 0) {
            int i14 = b11 == 0 ? 0 : this.f38528g[b11 - 1];
            int min = Math.min(i13, ((this.f38528g[b11] - i14) + i14) - i11);
            int[] iArr = this.f38528g;
            byte[][] bArr = this.f38527f;
            if (!fVar.a(i12, bArr[b11], (i11 - i14) + iArr[bArr.length + b11], min)) {
                return false;
            }
            i11 += min;
            i12 += min;
            i13 -= min;
            b11++;
        }
        return true;
    }

    @Override // com.mbridge.msdk.thrid.okio.f
    public boolean a(int i11, byte[] bArr, int i12, int i13) {
        if (i11 < 0 || i11 > e() - i13 || i12 < 0 || i12 > bArr.length - i13) {
            return false;
        }
        int b11 = b(i11);
        while (i13 > 0) {
            int i14 = b11 == 0 ? 0 : this.f38528g[b11 - 1];
            int min = Math.min(i13, ((this.f38528g[b11] - i14) + i14) - i11);
            int[] iArr = this.f38528g;
            byte[][] bArr2 = this.f38527f;
            if (!u.a(bArr2[b11], (i11 - i14) + iArr[bArr2.length + b11], bArr, i12, min)) {
                return false;
            }
            i11 += min;
            i12 += min;
            i13 -= min;
            b11++;
        }
        return true;
    }

    @Override // com.mbridge.msdk.thrid.okio.f
    public String b() {
        return i().b();
    }

    @Override // com.mbridge.msdk.thrid.okio.f
    public f c() {
        return i().c();
    }

    @Override // com.mbridge.msdk.thrid.okio.f
    public f d() {
        return i().d();
    }

    @Override // com.mbridge.msdk.thrid.okio.f
    public int e() {
        return this.f38528g[this.f38527f.length - 1];
    }

    @Override // com.mbridge.msdk.thrid.okio.f
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.e() == e() && a(0, fVar, 0, e())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.mbridge.msdk.thrid.okio.f
    public f f() {
        return i().f();
    }

    @Override // com.mbridge.msdk.thrid.okio.f
    public byte[] g() {
        int[] iArr = this.f38528g;
        byte[][] bArr = this.f38527f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int[] iArr2 = this.f38528g;
            int i13 = iArr2[length + i11];
            int i14 = iArr2[i11];
            System.arraycopy(this.f38527f[i11], i13, bArr2, i12, i14 - i12);
            i11++;
            i12 = i14;
        }
        return bArr2;
    }

    @Override // com.mbridge.msdk.thrid.okio.f
    public String h() {
        return i().h();
    }

    @Override // com.mbridge.msdk.thrid.okio.f
    public int hashCode() {
        int i11 = this.f38491b;
        if (i11 != 0) {
            return i11;
        }
        int length = this.f38527f.length;
        int i12 = 0;
        int i13 = 1;
        int i14 = 0;
        while (i12 < length) {
            byte[] bArr = this.f38527f[i12];
            int[] iArr = this.f38528g;
            int i15 = iArr[length + i12];
            int i16 = iArr[i12];
            int i17 = (i16 - i14) + i15;
            while (i15 < i17) {
                i13 = (i13 * 31) + bArr[i15];
                i15++;
            }
            i12++;
            i14 = i16;
        }
        this.f38491b = i13;
        return i13;
    }

    @Override // com.mbridge.msdk.thrid.okio.f
    public String toString() {
        return i().toString();
    }
}
