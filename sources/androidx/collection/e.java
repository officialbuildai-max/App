package androidx.collection;

import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private Object[] f2343a;

    /* renamed from: b, reason: collision with root package name */
    private int f2344b;

    /* renamed from: c, reason: collision with root package name */
    private int f2345c;

    /* renamed from: d, reason: collision with root package name */
    private int f2346d;

    @JvmOverloads
    public e() {
        this(0, 1, null);
    }

    public e(int i11) {
        if (!(i11 >= 1)) {
            n.d.a("capacity must be >= 1");
        }
        if (!(i11 <= 1073741824)) {
            n.d.a("capacity must be <= 2^30");
        }
        i11 = Integer.bitCount(i11) != 1 ? Integer.highestOneBit(i11 - 1) << 1 : i11;
        this.f2346d = i11 - 1;
        this.f2343a = new Object[i11];
    }

    public /* synthetic */ e(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 8 : i11);
    }

    private final void b() {
        Object[] objArr = this.f2343a;
        int length = objArr.length;
        int i11 = this.f2344b;
        int i12 = length - i11;
        int i13 = length << 1;
        if (i13 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        Object[] objArr2 = new Object[i13];
        ArraysKt.n(objArr, objArr2, 0, i11, length);
        ArraysKt.n(this.f2343a, objArr2, i12, 0, this.f2344b);
        this.f2343a = objArr2;
        this.f2344b = 0;
        this.f2345c = length;
        this.f2346d = i13 - 1;
    }

    public final void a(Object obj) {
        Object[] objArr = this.f2343a;
        int i11 = this.f2345c;
        objArr[i11] = obj;
        int i12 = this.f2346d & (i11 + 1);
        this.f2345c = i12;
        if (i12 == this.f2344b) {
            b();
        }
    }

    public final Object c(int i11) {
        if (i11 < 0 || i11 >= f()) {
            g gVar = g.f2353a;
            throw new ArrayIndexOutOfBoundsException();
        }
        Object obj = this.f2343a[this.f2346d & (this.f2344b + i11)];
        Intrinsics.e(obj);
        return obj;
    }

    public final boolean d() {
        return this.f2344b == this.f2345c;
    }

    public final Object e() {
        int i11 = this.f2344b;
        if (i11 == this.f2345c) {
            g gVar = g.f2353a;
            throw new ArrayIndexOutOfBoundsException();
        }
        Object[] objArr = this.f2343a;
        Object obj = objArr[i11];
        objArr[i11] = null;
        this.f2344b = (i11 + 1) & this.f2346d;
        return obj;
    }

    public final int f() {
        return (this.f2345c - this.f2344b) & this.f2346d;
    }
}
