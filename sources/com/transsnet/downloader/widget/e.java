package com.transsnet.downloader.widget;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final String f60320a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f60321b;

    public e(String name, boolean z10) {
        Intrinsics.h(name, "name");
        this.f60320a = name;
        this.f60321b = z10;
    }

    public final String a() {
        return this.f60320a;
    }

    public final boolean b() {
        return this.f60321b;
    }

    public final void c(boolean z10) {
        this.f60321b = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Intrinsics.c(this.f60320a, eVar.f60320a) && this.f60321b == eVar.f60321b;
    }

    public int hashCode() {
        return (this.f60320a.hashCode() * 31) + androidx.compose.foundation.e.a(this.f60321b);
    }

    public String toString() {
        return "DownloadGridTabBean(name=" + this.f60320a + ", isSelected=" + this.f60321b + ")";
    }
}
