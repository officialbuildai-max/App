package androidx.compose.ui.text;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    private final String f6253a;

    public g0(String str) {
        this.f6253a = str;
    }

    public final String a() {
        return this.f6253a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g0) && Intrinsics.c(this.f6253a, ((g0) obj).f6253a);
    }

    public int hashCode() {
        return this.f6253a.hashCode();
    }

    public String toString() {
        return "UrlAnnotation(url=" + this.f6253a + ')';
    }
}
