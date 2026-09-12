package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.IntIterator;

/* loaded from: classes7.dex */
final class f extends IntIterator {

    /* renamed from: a, reason: collision with root package name */
    private final int[] f67434a;

    /* renamed from: b, reason: collision with root package name */
    private int f67435b;

    public f(int[] array) {
        Intrinsics.h(array, "array");
        this.f67434a = array;
    }

    @Override // kotlin.collections.IntIterator
    public int a() {
        try {
            int[] iArr = this.f67434a;
            int i11 = this.f67435b;
            this.f67435b = i11 + 1;
            return iArr[i11];
        } catch (ArrayIndexOutOfBoundsException e11) {
            this.f67435b--;
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f67435b < this.f67434a.length;
    }
}
