package com.tn.tranpay;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public static final a f41591c;

    /* renamed from: d, reason: collision with root package name */
    private static e f41592d;

    /* renamed from: a, reason: collision with root package name */
    private boolean f41593a;

    /* renamed from: b, reason: collision with root package name */
    private int f41594b;

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(e theme) {
            Intrinsics.h(theme, "theme");
            e.f41592d = theme;
        }

        public final e b() {
            return e.f41592d;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        f41591c = new a(defaultConstructorMarker);
        f41592d = new e(false, 0 == true ? 1 : 0, 3, defaultConstructorMarker);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    public e(boolean z10, int i11) {
        this.f41593a = z10;
        this.f41594b = i11;
    }

    public /* synthetic */ e(boolean z10, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? false : z10, (i12 & 2) != 0 ? -14696961 : i11);
    }

    public final boolean c() {
        return this.f41593a;
    }

    public final int d() {
        return this.f41594b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f41593a == eVar.f41593a && this.f41594b == eVar.f41594b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z10 = this.f41593a;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        return (r02 * 31) + this.f41594b;
    }

    public String toString() {
        return "TranPayTheme(showLoadingWhenLaunched=" + this.f41593a + ", tintColor=" + this.f41594b + ")";
    }
}
