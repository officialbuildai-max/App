package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    private int[] f3879a = new int[10];

    /* renamed from: b, reason: collision with root package name */
    private int f3880b;

    public final void a() {
        this.f3880b = 0;
    }

    public final int b() {
        return this.f3880b;
    }

    public final int c(int i11) {
        int i12 = this.f3880b;
        for (int i13 = 0; i13 < i12; i13++) {
            if (this.f3879a[i13] == i11) {
                return i13;
            }
        }
        return -1;
    }

    public final boolean d() {
        return this.f3880b == 0;
    }

    public final int e() {
        return this.f3879a[this.f3880b - 1];
    }

    public final int f(int i11) {
        return this.f3879a[i11];
    }

    public final int g() {
        return this.f3879a[this.f3880b - 2];
    }

    public final int h(int i11) {
        return this.f3880b > 0 ? e() : i11;
    }

    public final int i() {
        int[] iArr = this.f3879a;
        int i11 = this.f3880b - 1;
        this.f3880b = i11;
        return iArr[i11];
    }

    public final void j(int i11) {
        int i12 = this.f3880b;
        int[] iArr = this.f3879a;
        if (i12 >= iArr.length) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f3879a = copyOf;
        }
        int[] iArr2 = this.f3879a;
        int i13 = this.f3880b;
        this.f3880b = i13 + 1;
        iArr2[i13] = i11;
    }
}
