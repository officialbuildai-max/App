package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.CharIterator;

/* loaded from: classes7.dex */
final class c extends CharIterator {

    /* renamed from: a, reason: collision with root package name */
    private final char[] f67428a;

    /* renamed from: b, reason: collision with root package name */
    private int f67429b;

    public c(char[] array) {
        Intrinsics.h(array, "array");
        this.f67428a = array;
    }

    @Override // kotlin.collections.CharIterator
    public char a() {
        try {
            char[] cArr = this.f67428a;
            int i11 = this.f67429b;
            this.f67429b = i11 + 1;
            return cArr[i11];
        } catch (ArrayIndexOutOfBoundsException e11) {
            this.f67429b--;
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f67429b < this.f67428a.length;
    }
}
