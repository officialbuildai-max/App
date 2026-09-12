package androidx.compose.ui.text;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private final o f6372a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6373b;

    /* renamed from: c, reason: collision with root package name */
    private final int f6374c;

    public n(o oVar, int i11, int i12) {
        this.f6372a = oVar;
        this.f6373b = i11;
        this.f6374c = i12;
    }

    public final int a() {
        return this.f6374c;
    }

    public final o b() {
        return this.f6372a;
    }

    public final int c() {
        return this.f6373b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return Intrinsics.c(this.f6372a, nVar.f6372a) && this.f6373b == nVar.f6373b && this.f6374c == nVar.f6374c;
    }

    public int hashCode() {
        return (((this.f6372a.hashCode() * 31) + this.f6373b) * 31) + this.f6374c;
    }

    public String toString() {
        return "ParagraphIntrinsicInfo(intrinsics=" + this.f6372a + ", startIndex=" + this.f6373b + ", endIndex=" + this.f6374c + ')';
    }
}
