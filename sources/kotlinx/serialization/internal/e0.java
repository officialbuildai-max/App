package kotlinx.serialization.internal;

import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class e0 {

    /* renamed from: e, reason: collision with root package name */
    private static final a f68249e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final long[] f68250f = new long[0];

    /* renamed from: a, reason: collision with root package name */
    private final kotlinx.serialization.descriptors.f f68251a;

    /* renamed from: b, reason: collision with root package name */
    private final Function2 f68252b;

    /* renamed from: c, reason: collision with root package name */
    private long f68253c;

    /* renamed from: d, reason: collision with root package name */
    private final long[] f68254d;

    /* loaded from: classes7.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public e0(kotlinx.serialization.descriptors.f descriptor, Function2 readIfAbsent) {
        Intrinsics.h(descriptor, "descriptor");
        Intrinsics.h(readIfAbsent, "readIfAbsent");
        this.f68251a = descriptor;
        this.f68252b = readIfAbsent;
        int e11 = descriptor.e();
        if (e11 <= 64) {
            this.f68253c = e11 != 64 ? (-1) << e11 : 0L;
            this.f68254d = f68250f;
        } else {
            this.f68253c = 0L;
            this.f68254d = e(e11);
        }
    }

    private final void b(int i11) {
        int i12 = (i11 >>> 6) - 1;
        long[] jArr = this.f68254d;
        jArr[i12] = jArr[i12] | (1 << (i11 & 63));
    }

    private final int c() {
        int length = this.f68254d.length;
        int i11 = 0;
        while (i11 < length) {
            int i12 = i11 + 1;
            int i13 = i12 * 64;
            long j11 = this.f68254d[i11];
            while (j11 != -1) {
                int numberOfTrailingZeros = Long.numberOfTrailingZeros(~j11);
                j11 |= 1 << numberOfTrailingZeros;
                int i14 = numberOfTrailingZeros + i13;
                if (((Boolean) this.f68252b.invoke(this.f68251a, Integer.valueOf(i14))).booleanValue()) {
                    this.f68254d[i11] = j11;
                    return i14;
                }
            }
            this.f68254d[i11] = j11;
            i11 = i12;
        }
        return -1;
    }

    private final long[] e(int i11) {
        long[] jArr = new long[(i11 - 1) >>> 6];
        if ((i11 & 63) != 0) {
            jArr[ArraysKt.a0(jArr)] = (-1) << i11;
        }
        return jArr;
    }

    public final void a(int i11) {
        if (i11 < 64) {
            this.f68253c |= 1 << i11;
        } else {
            b(i11);
        }
    }

    public final int d() {
        int numberOfTrailingZeros;
        int e11 = this.f68251a.e();
        do {
            long j11 = this.f68253c;
            if (j11 == -1) {
                if (e11 > 64) {
                    return c();
                }
                return -1;
            }
            numberOfTrailingZeros = Long.numberOfTrailingZeros(~j11);
            this.f68253c |= 1 << numberOfTrailingZeros;
        } while (!((Boolean) this.f68252b.invoke(this.f68251a, Integer.valueOf(numberOfTrailingZeros))).booleanValue());
        return numberOfTrailingZeros;
    }
}
