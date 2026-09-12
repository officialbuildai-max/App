package androidx.collection;

import com.cloud.tmc.kernel.utils.UrlUtils;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class p0 {

    /* renamed from: a, reason: collision with root package name */
    public long[] f2389a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f2390b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f2391c;

    /* renamed from: d, reason: collision with root package name */
    public int f2392d;

    /* renamed from: e, reason: collision with root package name */
    public int f2393e;

    private p0() {
        this.f2389a = v0.f2428a;
        this.f2390b = n.a.f70176c;
        this.f2391c = r.a();
    }

    public /* synthetic */ p0(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final int a(Object obj) {
        int i11 = 0;
        int hashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i12 = hashCode ^ (hashCode << 16);
        int i13 = i12 & 127;
        int i14 = this.f2392d;
        int i15 = i12 >>> 7;
        while (true) {
            int i16 = i15 & i14;
            long[] jArr = this.f2389a;
            int i17 = i16 >> 3;
            int i18 = (i16 & 7) << 3;
            long j11 = ((jArr[i17 + 1] << (64 - i18)) & ((-i18) >> 63)) | (jArr[i17] >>> i18);
            long j12 = (i13 * 72340172838076673L) ^ j11;
            for (long j13 = (~j12) & (j12 - 72340172838076673L) & (-9187201950435737472L); j13 != 0; j13 &= j13 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j13) >> 3) + i16) & i14;
                if (Intrinsics.c(this.f2390b[numberOfTrailingZeros], obj)) {
                    return numberOfTrailingZeros;
                }
            }
            if ((j11 & ((~j11) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i11 += 8;
            i15 = i16 + i11;
        }
    }

    public final int b(Object obj) {
        int a11 = a(obj);
        if (a11 >= 0) {
            return this.f2391c[a11];
        }
        throw new NoSuchElementException("There is no key " + obj + " in the map");
    }

    public final int c() {
        return this.f2392d;
    }

    public final int d(Object obj, int i11) {
        int a11 = a(obj);
        return a11 >= 0 ? this.f2391c[a11] : i11;
    }

    public final int e() {
        return this.f2393e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p0)) {
            return false;
        }
        p0 p0Var = (p0) obj;
        if (p0Var.e() != e()) {
            return false;
        }
        Object[] objArr = this.f2390b;
        int[] iArr = this.f2391c;
        long[] jArr = this.f2389a;
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
                            if (iArr[i14] != p0Var.b(objArr[i14])) {
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

    public final boolean f() {
        return this.f2393e == 0;
    }

    public final boolean g() {
        return this.f2393e != 0;
    }

    public int hashCode() {
        Object[] objArr = this.f2390b;
        int[] iArr = this.f2391c;
        long[] jArr = this.f2389a;
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
                            Object obj = objArr[i16];
                            i13 += iArr[i16] ^ (obj != null ? obj.hashCode() : 0);
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
        if (f()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('{');
        Object[] objArr = this.f2390b;
        int[] iArr = this.f2391c;
        long[] jArr = this.f2389a;
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
                            Object obj = objArr[i15];
                            int i16 = iArr[i15];
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb2.append(obj);
                            sb2.append(UrlUtils.EQUAL_MARK);
                            sb2.append(i16);
                            i12++;
                            if (i12 < this.f2393e) {
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
