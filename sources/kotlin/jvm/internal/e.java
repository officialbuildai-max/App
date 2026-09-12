package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.FloatIterator;

/* loaded from: classes7.dex */
final class e extends FloatIterator {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f67432a;

    /* renamed from: b, reason: collision with root package name */
    private int f67433b;

    public e(float[] array) {
        Intrinsics.h(array, "array");
        this.f67432a = array;
    }

    @Override // kotlin.collections.FloatIterator
    public float a() {
        try {
            float[] fArr = this.f67432a;
            int i11 = this.f67433b;
            this.f67433b = i11 + 1;
            return fArr[i11];
        } catch (ArrayIndexOutOfBoundsException e11) {
            this.f67433b--;
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f67433b < this.f67432a.length;
    }
}
