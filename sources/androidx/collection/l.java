package androidx.collection;

import com.cloud.tmc.kernel.utils.UrlUtils;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public long[] f2368a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f2369b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f2370c;

    /* renamed from: d, reason: collision with root package name */
    public int f2371d;

    /* renamed from: e, reason: collision with root package name */
    public int f2372e;

    private l() {
        this.f2368a = v0.f2428a;
        this.f2369b = r.a();
        this.f2370c = r.a();
    }

    public /* synthetic */ l(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final boolean a(int i11) {
        return b(i11) >= 0;
    }

    public final int b(int i11) {
        int i12 = (-862048943) * i11;
        int i13 = i12 ^ (i12 << 16);
        int i14 = i13 & 127;
        int i15 = this.f2371d;
        int i16 = (i13 >>> 7) & i15;
        int i17 = 0;
        while (true) {
            long[] jArr = this.f2368a;
            int i18 = i16 >> 3;
            int i19 = (i16 & 7) << 3;
            long j11 = ((jArr[i18 + 1] << (64 - i19)) & ((-i19) >> 63)) | (jArr[i18] >>> i19);
            long j12 = (i14 * 72340172838076673L) ^ j11;
            for (long j13 = (~j12) & (j12 - 72340172838076673L) & (-9187201950435737472L); j13 != 0; j13 &= j13 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j13) >> 3) + i16) & i15;
                if (this.f2369b[numberOfTrailingZeros] == i11) {
                    return numberOfTrailingZeros;
                }
            }
            if ((j11 & ((~j11) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i17 += 8;
            i16 = (i16 + i17) & i15;
        }
    }

    public final int c(int i11) {
        int b11 = b(i11);
        if (b11 >= 0) {
            return this.f2370c[b11];
        }
        throw new NoSuchElementException("Cannot find value for key " + i11);
    }

    public final int d() {
        return this.f2371d;
    }

    public final int e(int i11, int i12) {
        int b11 = b(i11);
        return b11 >= 0 ? this.f2370c[b11] : i12;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (lVar.f() != f()) {
            return false;
        }
        int[] iArr = this.f2369b;
        int[] iArr2 = this.f2370c;
        long[] jArr = this.f2368a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i11 = 0;
            while (true) {
                long j11 = jArr[i11];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                    for (int i13 = 0; i13 < i12; i13++) {
                        if ((255 & j11) < 128) {
                            int i14 = (i11 << 3) + i13;
                            if (iArr2[i14] != lVar.c(iArr[i14])) {
                                return false;
                            }
                        }
                        j11 >>= 8;
                    }
                    if (i12 != 8) {
                        break;
                    }
                }
                if (i11 == length) {
                    break;
                }
                i11++;
            }
        }
        return true;
    }

    public final int f() {
        return this.f2372e;
    }

    public final boolean g() {
        return this.f2372e == 0;
    }

    public int hashCode() {
        int[] iArr = this.f2369b;
        int[] iArr2 = this.f2370c;
        long[] jArr = this.f2368a;
        int length = jArr.length - 2;
        int i11 = 0;
        if (length >= 0) {
            int i12 = 0;
            int i13 = 0;
            while (true) {
                long j11 = jArr[i12];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i14 = 8 - ((~(i12 - length)) >>> 31);
                    for (int i15 = 0; i15 < i14; i15++) {
                        if ((255 & j11) < 128) {
                            int i16 = (i12 << 3) + i15;
                            i13 += iArr2[i16] ^ iArr[i16];
                        }
                        j11 >>= 8;
                    }
                    if (i14 != 8) {
                        return i13;
                    }
                }
                if (i12 == length) {
                    i11 = i13;
                    break;
                }
                i12++;
            }
        }
        return i11;
    }

    public String toString() {
        if (g()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('{');
        int[] iArr = this.f2369b;
        int[] iArr2 = this.f2370c;
        long[] jArr = this.f2368a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i11 = 0;
            int i12 = 0;
            while (true) {
                long j11 = jArr[i11];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i13 = 8 - ((~(i11 - length)) >>> 31);
                    for (int i14 = 0; i14 < i13; i14++) {
                        if ((255 & j11) < 128) {
                            int i15 = (i11 << 3) + i14;
                            int i16 = iArr[i15];
                            int i17 = iArr2[i15];
                            sb2.append(i16);
                            sb2.append(UrlUtils.EQUAL_MARK);
                            sb2.append(i17);
                            i12++;
                            if (i12 < this.f2372e) {
                                sb2.append(',');
                                sb2.append(' ');
                            }
                        }
                        j11 >>= 8;
                    }
                    if (i13 != 8) {
                        break;
                    }
                }
                if (i11 == length) {
                    break;
                }
                i11++;
            }
        }
        sb2.append('}');
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "s.append('}').toString()");
        return sb3;
    }
}
