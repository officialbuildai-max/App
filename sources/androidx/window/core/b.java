package androidx.window.core;

import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f15371a;

    /* renamed from: b, reason: collision with root package name */
    private final int f15372b;

    /* renamed from: c, reason: collision with root package name */
    private final int f15373c;

    /* renamed from: d, reason: collision with root package name */
    private final int f15374d;

    public b(int i11, int i12, int i13, int i14) {
        this.f15371a = i11;
        this.f15372b = i12;
        this.f15373c = i13;
        this.f15374d = i14;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Rect rect) {
        this(rect.left, rect.top, rect.right, rect.bottom);
        Intrinsics.h(rect, "rect");
    }

    public final int a() {
        return this.f15374d - this.f15372b;
    }

    public final int b() {
        return this.f15371a;
    }

    public final int c() {
        return this.f15372b;
    }

    public final int d() {
        return this.f15373c - this.f15371a;
    }

    public final boolean e() {
        return a() == 0 && d() == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.c(b.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.window.core.Bounds");
        }
        b bVar = (b) obj;
        return this.f15371a == bVar.f15371a && this.f15372b == bVar.f15372b && this.f15373c == bVar.f15373c && this.f15374d == bVar.f15374d;
    }

    public final Rect f() {
        return new Rect(this.f15371a, this.f15372b, this.f15373c, this.f15374d);
    }

    public int hashCode() {
        return (((((this.f15371a * 31) + this.f15372b) * 31) + this.f15373c) * 31) + this.f15374d;
    }

    public String toString() {
        return ((Object) b.class.getSimpleName()) + " { [" + this.f15371a + ',' + this.f15372b + ',' + this.f15373c + ',' + this.f15374d + "] }";
    }
}
