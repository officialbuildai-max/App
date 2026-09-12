package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ShortIterator;

/* loaded from: classes7.dex */
final class i extends ShortIterator {

    /* renamed from: a, reason: collision with root package name */
    private final short[] f67440a;

    /* renamed from: b, reason: collision with root package name */
    private int f67441b;

    public i(short[] array) {
        Intrinsics.h(array, "array");
        this.f67440a = array;
    }

    @Override // kotlin.collections.ShortIterator
    public short a() {
        try {
            short[] sArr = this.f67440a;
            int i11 = this.f67441b;
            this.f67441b = i11 + 1;
            return sArr[i11];
        } catch (ArrayIndexOutOfBoundsException e11) {
            this.f67441b--;
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f67441b < this.f67440a.length;
    }
}
