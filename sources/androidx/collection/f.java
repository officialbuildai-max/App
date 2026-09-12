package androidx.collection;

import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private int[] f2348a;

    /* renamed from: b, reason: collision with root package name */
    private int f2349b;

    /* renamed from: c, reason: collision with root package name */
    private int f2350c;

    /* renamed from: d, reason: collision with root package name */
    private int f2351d;

    @JvmOverloads
    public f() {
        this(0, 1, null);
    }

    public f(int i11) {
        if (!(i11 >= 1)) {
            n.d.a("capacity must be >= 1");
        }
        if (!(i11 <= 1073741824)) {
            n.d.a("capacity must be <= 2^30");
        }
        i11 = Integer.bitCount(i11) != 1 ? Integer.highestOneBit(i11 - 1) << 1 : i11;
        this.f2351d = i11 - 1;
        this.f2348a = new int[i11];
    }

    public /* synthetic */ f(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 8 : i11);
    }

    private final void c() {
        int[] iArr = this.f2348a;
        int length = iArr.length;
        int i11 = this.f2349b;
        int i12 = length - i11;
        int i13 = length << 1;
        if (i13 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        int[] iArr2 = new int[i13];
        ArraysKt.l(iArr, iArr2, 0, i11, length);
        ArraysKt.l(this.f2348a, iArr2, i12, 0, this.f2349b);
        this.f2348a = iArr2;
        this.f2349b = 0;
        this.f2350c = length;
        this.f2351d = i13 - 1;
    }

    public final void a(int i11) {
        int[] iArr = this.f2348a;
        int i12 = this.f2350c;
        iArr[i12] = i11;
        int i13 = this.f2351d & (i12 + 1);
        this.f2350c = i13;
        if (i13 == this.f2349b) {
            c();
        }
    }

    public final void b() {
        this.f2350c = this.f2349b;
    }

    public final boolean d() {
        return this.f2349b == this.f2350c;
    }

    public final int e() {
        int i11 = this.f2349b;
        if (i11 == this.f2350c) {
            g gVar = g.f2353a;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i12 = this.f2348a[i11];
        this.f2349b = (i11 + 1) & this.f2351d;
        return i12;
    }
}
