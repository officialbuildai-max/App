package e0;

import androidx.compose.ui.input.pointer.v;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private int f61588a;

    /* renamed from: b, reason: collision with root package name */
    private long[] f61589b = new long[2];

    public final boolean a(long j11) {
        if (d(j11)) {
            return false;
        }
        k(this.f61588a, j11);
        return true;
    }

    public final boolean b(long j11) {
        return a(j11);
    }

    public final void c() {
        this.f61588a = 0;
    }

    public final boolean d(long j11) {
        int i11 = this.f61588a;
        for (int i12 = 0; i12 < i11; i12++) {
            if (this.f61589b[i12] == j11) {
                return true;
            }
        }
        return false;
    }

    public final long e(int i11) {
        return v.b(this.f61589b[i11]);
    }

    public final int f() {
        return this.f61588a;
    }

    public final boolean g() {
        return this.f61588a == 0;
    }

    public final boolean h(long j11) {
        int i11 = this.f61588a;
        for (int i12 = 0; i12 < i11; i12++) {
            if (j11 == e(i12)) {
                j(i12);
                return true;
            }
        }
        return false;
    }

    public final boolean i(long j11) {
        return h(j11);
    }

    public final boolean j(int i11) {
        int i12 = this.f61588a;
        if (i11 >= i12) {
            return false;
        }
        int i13 = i12 - 1;
        while (i11 < i13) {
            long[] jArr = this.f61589b;
            int i14 = i11 + 1;
            jArr[i11] = jArr[i14];
            i11 = i14;
        }
        this.f61588a--;
        return true;
    }

    public final void k(int i11, long j11) {
        long[] jArr = this.f61589b;
        if (i11 >= jArr.length) {
            long[] copyOf = Arrays.copyOf(jArr, Math.max(i11 + 1, jArr.length * 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f61589b = copyOf;
        }
        this.f61589b[i11] = j11;
        if (i11 >= this.f61588a) {
            this.f61588a = i11 + 1;
        }
    }
}
