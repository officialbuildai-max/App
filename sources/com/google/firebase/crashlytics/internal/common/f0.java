package com.google.firebase.crashlytics.internal.common;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    private final String f31229a;

    /* renamed from: b, reason: collision with root package name */
    private final String f31230b;

    public f0(String str, String str2) {
        this.f31229a = str;
        this.f31230b = str2;
    }

    public final String a() {
        return this.f31230b;
    }

    public final String b() {
        return this.f31229a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return Intrinsics.c(this.f31229a, f0Var.f31229a) && Intrinsics.c(this.f31230b, f0Var.f31230b);
    }

    public int hashCode() {
        String str = this.f31229a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f31230b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "FirebaseInstallationId(fid=" + this.f31229a + ", authToken=" + this.f31230b + ')';
    }
}
