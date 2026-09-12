package com.transsion.subtitle.fragment;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final String f54986a;

    /* renamed from: b, reason: collision with root package name */
    private final int f54987b;

    /* renamed from: c, reason: collision with root package name */
    private final int f54988c;

    public i(String name, int i11, int i12) {
        Intrinsics.h(name, "name");
        this.f54986a = name;
        this.f54987b = i11;
        this.f54988c = i12;
    }

    public final int a() {
        return this.f54988c;
    }

    public final String b() {
        return this.f54986a;
    }

    public final int c() {
        return this.f54987b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Intrinsics.c(this.f54986a, iVar.f54986a) && this.f54987b == iVar.f54987b && this.f54988c == iVar.f54988c;
    }

    public int hashCode() {
        return (((this.f54986a.hashCode() * 31) + this.f54987b) * 31) + this.f54988c;
    }

    public String toString() {
        return "SubtitleSearchKeyword(name=" + this.f54986a + ", season=" + this.f54987b + ", episode=" + this.f54988c + ")";
    }
}
