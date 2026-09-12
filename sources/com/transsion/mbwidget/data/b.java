package com.transsion.mbwidget.data;

import com.transsion.moviedetailapi.bean.Subject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f46320a;

    /* renamed from: b, reason: collision with root package name */
    private final Subject f46321b;

    public b(int i11, Subject subject) {
        Intrinsics.h(subject, "subject");
        this.f46320a = i11;
        this.f46321b = subject;
    }

    public final int a() {
        return this.f46320a;
    }

    public final Subject b() {
        return this.f46321b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f46320a == bVar.f46320a && Intrinsics.c(this.f46321b, bVar.f46321b);
    }

    public int hashCode() {
        return (this.f46320a * 31) + this.f46321b.hashCode();
    }

    public String toString() {
        return "ShowItem(position=" + this.f46320a + ", subject=" + this.f46321b + ")";
    }
}
