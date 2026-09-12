package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.DoubleIterator;

/* loaded from: classes7.dex */
final class d extends DoubleIterator {

    /* renamed from: a, reason: collision with root package name */
    private final double[] f67430a;

    /* renamed from: b, reason: collision with root package name */
    private int f67431b;

    public d(double[] array) {
        Intrinsics.h(array, "array");
        this.f67430a = array;
    }

    @Override // kotlin.collections.DoubleIterator
    public double a() {
        try {
            double[] dArr = this.f67430a;
            int i11 = this.f67431b;
            this.f67431b = i11 + 1;
            return dArr[i11];
        } catch (ArrayIndexOutOfBoundsException e11) {
            this.f67431b--;
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f67431b < this.f67430a.length;
    }
}
