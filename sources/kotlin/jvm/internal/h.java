package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.LongIterator;

/* loaded from: classes7.dex */
final class h extends LongIterator {

    /* renamed from: a, reason: collision with root package name */
    private final long[] f67438a;

    /* renamed from: b, reason: collision with root package name */
    private int f67439b;

    public h(long[] array) {
        Intrinsics.h(array, "array");
        this.f67438a = array;
    }

    @Override // kotlin.collections.LongIterator
    public long a() {
        try {
            long[] jArr = this.f67438a;
            int i11 = this.f67439b;
            this.f67439b = i11 + 1;
            return jArr[i11];
        } catch (ArrayIndexOutOfBoundsException e11) {
            this.f67439b--;
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f67439b < this.f67438a.length;
    }
}
