package com.google.firebase.sessions;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    private final String f32741a;

    /* renamed from: b, reason: collision with root package name */
    private final int f32742b;

    /* renamed from: c, reason: collision with root package name */
    private final int f32743c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f32744d;

    public p(String processName, int i11, int i12, boolean z10) {
        Intrinsics.h(processName, "processName");
        this.f32741a = processName;
        this.f32742b = i11;
        this.f32743c = i12;
        this.f32744d = z10;
    }

    public final int a() {
        return this.f32743c;
    }

    public final int b() {
        return this.f32742b;
    }

    public final String c() {
        return this.f32741a;
    }

    public final boolean d() {
        return this.f32744d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return Intrinsics.c(this.f32741a, pVar.f32741a) && this.f32742b == pVar.f32742b && this.f32743c == pVar.f32743c && this.f32744d == pVar.f32744d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.f32741a.hashCode() * 31) + this.f32742b) * 31) + this.f32743c) * 31;
        boolean z10 = this.f32744d;
        int i11 = z10;
        if (z10 != 0) {
            i11 = 1;
        }
        return hashCode + i11;
    }

    public String toString() {
        return "ProcessDetails(processName=" + this.f32741a + ", pid=" + this.f32742b + ", importance=" + this.f32743c + ", isDefaultProcess=" + this.f32744d + ')';
    }
}
