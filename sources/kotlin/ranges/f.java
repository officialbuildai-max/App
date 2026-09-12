package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes7.dex */
final class f implements Iterator, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    private final int f67497a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f67498b;

    /* renamed from: c, reason: collision with root package name */
    private final int f67499c;

    /* renamed from: d, reason: collision with root package name */
    private int f67500d;

    private f(int i11, int i12, int i13) {
        int compare;
        this.f67497a = i12;
        boolean z10 = false;
        compare = Integer.compare(i11 ^ Integer.MIN_VALUE, i12 ^ Integer.MIN_VALUE);
        if (i13 <= 0 ? compare >= 0 : compare <= 0) {
            z10 = true;
        }
        this.f67498b = z10;
        this.f67499c = UInt.b(i13);
        this.f67500d = this.f67498b ? i11 : i12;
    }

    public /* synthetic */ f(int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, i12, i13);
    }

    public int a() {
        int i11 = this.f67500d;
        if (i11 != this.f67497a) {
            this.f67500d = UInt.b(this.f67499c + i11);
        } else {
            if (!this.f67498b) {
                throw new NoSuchElementException();
            }
            this.f67498b = false;
        }
        return i11;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f67498b;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return UInt.a(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
