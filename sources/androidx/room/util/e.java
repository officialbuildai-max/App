package androidx.room.util;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
final class e implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    private final int f14873a;

    /* renamed from: b, reason: collision with root package name */
    private final int f14874b;

    /* renamed from: c, reason: collision with root package name */
    private final String f14875c;

    /* renamed from: d, reason: collision with root package name */
    private final String f14876d;

    public e(int i11, int i12, String from, String to2) {
        Intrinsics.h(from, "from");
        Intrinsics.h(to2, "to");
        this.f14873a = i11;
        this.f14874b = i12;
        this.f14875c = from;
        this.f14876d = to2;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(e other) {
        Intrinsics.h(other, "other");
        int i11 = this.f14873a - other.f14873a;
        return i11 == 0 ? this.f14874b - other.f14874b : i11;
    }

    public final String b() {
        return this.f14875c;
    }

    public final int d() {
        return this.f14873a;
    }

    public final String e() {
        return this.f14876d;
    }
}
