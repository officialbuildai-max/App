package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.BooleanIterator;

/* loaded from: classes7.dex */
final class a extends BooleanIterator {

    /* renamed from: a, reason: collision with root package name */
    private final boolean[] f67424a;

    /* renamed from: b, reason: collision with root package name */
    private int f67425b;

    public a(boolean[] array) {
        Intrinsics.h(array, "array");
        this.f67424a = array;
    }

    @Override // kotlin.collections.BooleanIterator
    public boolean a() {
        try {
            boolean[] zArr = this.f67424a;
            int i11 = this.f67425b;
            this.f67425b = i11 + 1;
            return zArr[i11];
        } catch (ArrayIndexOutOfBoundsException e11) {
            this.f67425b--;
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f67425b < this.f67424a.length;
    }
}
