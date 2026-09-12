package androidx.collection;

import com.cloud.tmc.kernel.utils.UrlUtils;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public long[] f2408a;

    /* renamed from: b, reason: collision with root package name */
    public long[] f2409b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f2410c;

    /* renamed from: d, reason: collision with root package name */
    public int f2411d;

    /* renamed from: e, reason: collision with root package name */
    public int f2412e;

    private t() {
        this.f2408a = v0.f2428a;
        this.f2409b = w.a();
        this.f2410c = r.a();
    }

    public /* synthetic */ t(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final int a(long j11) {
        int a11 = s.a(j11) * (-862048943);
        int i11 = a11 ^ (a11 << 16);
        int i12 = i11 & 127;
        int i13 = this.f2411d;
        int i14 = (i11 >>> 7) & i13;
        int i15 = 0;
        while (true) {
            long[] jArr = this.f2408a;
            int i16 = i14 >> 3;
            int i17 = (i14 & 7) << 3;
            long j12 = ((jArr[i16 + 1] << (64 - i17)) & ((-i17) >> 63)) | (jArr[i16] >>> i17);
            long j13 = (i12 * 72340172838076673L) ^ j12;
            for (long j14 = (~j13) & (j13 - 72340172838076673L) & (-9187201950435737472L); j14 != 0; j14 &= j14 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j14) >> 3) + i14) & i13;
                if (this.f2409b[numberOfTrailingZeros] == j11) {
                    return numberOfTrailingZeros;
                }
            }
            if ((j12 & ((~j12) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i15 += 8;
            i14 = (i14 + i15) & i13;
        }
    }

    public final int b(long j11) {
        int a11 = a(j11);
        if (a11 >= 0) {
            return this.f2410c[a11];
        }
        throw new NoSuchElementException("Cannot find value for key " + j11);
    }

    public final int c() {
        return this.f2411d;
    }

    public final int d() {
        return this.f2412e;
    }

    public final boolean e() {
        return this.f2412e == 0;
    }

    public boolean equals(Object obj) {
        int i11;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        if (tVar.d() != d()) {
            return false;
        }
        long[] jArr = this.f2409b;
        int[] iArr = this.f2410c;
        long[] jArr2 = this.f2408a;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i12 = 0;
            while (true) {
                long j11 = jArr2[i12];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i13 = 8;
                    int i14 = 8 - ((~(i12 - length)) >>> 31);
                    int i15 = 0;
                    while (i15 < i14) {
                        if ((255 & j11) < 128) {
                            int i16 = (i12 << 3) + i15;
                            i11 = i15;
                            if (iArr[i16] != tVar.b(jArr[i16])) {
                                return false;
                            }
                            i13 = 8;
                        } else {
                            i11 = i15;
                        }
                        j11 >>= i13;
                        i15 = i11 + 1;
                    }
                    if (i14 != i13) {
                        break;
                    }
                }
                if (i12 == length) {
                    break;
                }
                i12++;
            }
        }
        return true;
    }

    public int hashCode() {
        long[] jArr = this.f2409b;
        int[] iArr = this.f2410c;
        long[] jArr2 = this.f2408a;
        int length = jArr2.length - 2;
        int i11 = 0;
        if (length >= 0) {
            int i12 = 0;
            int i13 = 0;
            while (true) {
                long j11 = jArr2[i12];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i14 = 8 - ((~(i12 - length)) >>> 31);
                    for (int i15 = 0; i15 < i14; i15++) {
                        if ((255 & j11) < 128) {
                            int i16 = (i12 << 3) + i15;
                            i13 += iArr[i16] ^ s.a(jArr[i16]);
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
        int i11;
        int i12;
        if (e()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('{');
        long[] jArr = this.f2409b;
        int[] iArr = this.f2410c;
        long[] jArr2 = this.f2408a;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i13 = 0;
            int i14 = 0;
            while (true) {
                long j11 = jArr2[i13];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i15 = 8 - ((~(i13 - length)) >>> 31);
                    int i16 = 0;
                    while (i16 < i15) {
                        if ((255 & j11) < 128) {
                            int i17 = (i13 << 3) + i16;
                            i12 = i13;
                            long j12 = jArr[i17];
                            int i18 = iArr[i17];
                            sb2.append(j12);
                            sb2.append(UrlUtils.EQUAL_MARK);
                            sb2.append(i18);
                            i14++;
                            if (i14 < this.f2412e) {
                                sb2.append(',');
                                sb2.append(' ');
                            }
                        } else {
                            i12 = i13;
                        }
                        j11 >>= 8;
                        i16++;
                        i13 = i12;
                    }
                    int i19 = i13;
                    if (i15 != 8) {
                        break;
                    }
                    i11 = i19;
                } else {
                    i11 = i13;
                }
                if (i11 == length) {
                    break;
                }
                i13 = i11 + 1;
            }
        }
        sb2.append('}');
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "s.append('}').toString()");
        return sb3;
    }
}
