package mf;

import com.tencent.tinker.android.dex.j;
import com.tencent.tinker.android.dex.v;
import java.util.Arrays;

/* loaded from: classes5.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    protected final nf.a f69662a;

    /* renamed from: b, reason: collision with root package name */
    protected final com.tencent.tinker.android.dex.j f69663b;

    /* renamed from: c, reason: collision with root package name */
    private final of.c f69664c;

    public j(nf.a aVar, com.tencent.tinker.android.dex.j jVar, of.c cVar) {
        this.f69662a = aVar;
        this.f69663b = jVar;
        this.f69664c = cVar;
    }

    private void b(j.h hVar, int i11, int[] iArr, int[] iArr2, int[] iArr3) {
        int i12;
        int i13 = 1;
        int length = iArr.length;
        int length2 = iArr2.length;
        int length3 = iArr3.length;
        int i14 = (i11 + length2) - length;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (true) {
            if (i19 >= i11 && i18 >= i14) {
                break;
            }
            if (i17 < length2 && iArr2[i17] == i18) {
                k(g(this.f69662a.a()));
                i17 += i13;
            } else if (i16 >= length3 || iArr3[i16] != i18) {
                if (Arrays.binarySearch(iArr, i19) >= 0) {
                    f(this.f69664c, i19, d(i19, g(hVar)));
                    i12 = 1;
                    i19++;
                    i15++;
                } else if (Arrays.binarySearch(iArr3, i19) >= 0) {
                    f(this.f69664c, i19, d(i19, g(hVar)));
                    i12 = 1;
                    i19++;
                } else if (i19 < i11) {
                    Comparable a11 = a(this.f69664c, g(hVar));
                    int i20 = i16;
                    j(this.f69664c, i19, d(i19, a11), i18, k(a11));
                    i19++;
                    i18++;
                    i13 = 1;
                    i15 = i15;
                    i16 = i20;
                    i17 = i17;
                } else {
                    i13 = 1;
                }
                i13 = i12;
            } else {
                k(g(this.f69662a.a()));
                i16 += i13;
            }
            i18 += i13;
        }
        if (i17 == length2 && i15 == length && i16 == length3) {
            h();
            return;
        }
        Integer valueOf = Integer.valueOf(i17);
        Integer valueOf2 = Integer.valueOf(length2);
        Integer valueOf3 = Integer.valueOf(i15);
        Integer valueOf4 = Integer.valueOf(length);
        Integer valueOf5 = Integer.valueOf(i16);
        Integer valueOf6 = Integer.valueOf(length3);
        Object[] objArr = new Object[6];
        objArr[0] = valueOf;
        objArr[i13] = valueOf2;
        objArr[2] = valueOf3;
        objArr[3] = valueOf4;
        objArr[4] = valueOf5;
        objArr[5] = valueOf6;
        throw new IllegalStateException(String.format("bad patch operation sequence. addCounter: %d, addCount: %d, delCounter: %d, delCount: %d, replaceCounter: %d, replaceCount:%d", objArr));
    }

    private int d(int i11, Comparable comparable) {
        return comparable instanceof v.a.AbstractC0584a ? ((v.a.AbstractC0584a) comparable).f40739a : i11;
    }

    private int[] i(int i11) {
        int[] iArr = new int[i11];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 += this.f69662a.a().D();
            iArr[i13] = i12;
        }
        return iArr;
    }

    protected Comparable a(of.a aVar, Comparable comparable) {
        return comparable;
    }

    public void c() {
        j.h hVar;
        int i11;
        int[] i12 = i(this.f69662a.a().H());
        int[] i13 = i(this.f69662a.a().H());
        int[] i14 = i(this.f69662a.a().H());
        v.a e11 = e(this.f69663b);
        if (e11.b()) {
            j.h m11 = this.f69663b.m(e11);
            i11 = e11.f40736c;
            hVar = m11;
        } else {
            hVar = null;
            i11 = 0;
        }
        b(hVar, i11, i12, i13, i14);
    }

    protected abstract v.a e(com.tencent.tinker.android.dex.j jVar);

    protected void f(of.c cVar, int i11, int i12) {
    }

    protected abstract Comparable g(ff.a aVar);

    protected void h() {
    }

    protected void j(of.c cVar, int i11, int i12, int i13, int i14) {
    }

    protected abstract int k(Comparable comparable);
}
