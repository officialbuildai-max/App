package androidx.compose.ui.node;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    private int f5493a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f5494b = new int[16];

    /* renamed from: c, reason: collision with root package name */
    private androidx.compose.runtime.collection.b[] f5495c = new androidx.compose.runtime.collection.b[16];

    public final boolean a() {
        int i11 = this.f5493a;
        return i11 > 0 && this.f5494b[i11 - 1] >= 0;
    }

    public final Object b() {
        int i11 = this.f5493a;
        if (i11 <= 0) {
            throw new IllegalStateException("Cannot call pop() on an empty stack. Guard with a call to isNotEmpty()");
        }
        int i12 = i11 - 1;
        int i13 = this.f5494b[i12];
        androidx.compose.runtime.collection.b bVar = this.f5495c[i12];
        Intrinsics.e(bVar);
        if (i13 > 0) {
            this.f5494b[i12] = r3[i12] - 1;
        } else if (i13 == 0) {
            this.f5495c[i12] = null;
            this.f5493a--;
        }
        return bVar.m()[i13];
    }

    public final void c(androidx.compose.runtime.collection.b bVar) {
        if (bVar.p()) {
            return;
        }
        int i11 = this.f5493a;
        int[] iArr = this.f5494b;
        if (i11 >= iArr.length) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f5494b = copyOf;
            androidx.compose.runtime.collection.b[] bVarArr = this.f5495c;
            Object[] copyOf2 = Arrays.copyOf(bVarArr, bVarArr.length * 2);
            Intrinsics.g(copyOf2, "copyOf(this, newSize)");
            this.f5495c = (androidx.compose.runtime.collection.b[]) copyOf2;
        }
        this.f5494b[i11] = bVar.n() - 1;
        this.f5495c[i11] = bVar;
        this.f5493a++;
    }
}
