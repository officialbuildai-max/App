package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ByteIterator;

/* loaded from: classes7.dex */
final class b extends ByteIterator {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f67426a;

    /* renamed from: b, reason: collision with root package name */
    private int f67427b;

    public b(byte[] array) {
        Intrinsics.h(array, "array");
        this.f67426a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f67427b < this.f67426a.length;
    }

    @Override // kotlin.collections.ByteIterator
    public byte nextByte() {
        try {
            byte[] bArr = this.f67426a;
            int i11 = this.f67427b;
            this.f67427b = i11 + 1;
            return bArr[i11];
        } catch (ArrayIndexOutOfBoundsException e11) {
            this.f67427b--;
            throw new NoSuchElementException(e11.getMessage());
        }
    }
}
