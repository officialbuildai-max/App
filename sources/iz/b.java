package iz;

import androidx.collection.s;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f65797a;

    /* renamed from: b, reason: collision with root package name */
    private final long f65798b;

    /* renamed from: c, reason: collision with root package name */
    private final long f65799c;

    /* renamed from: d, reason: collision with root package name */
    private final String f65800d;

    public b(int i11, long j11, long j12, String str) {
        this.f65797a = i11;
        this.f65798b = j11;
        this.f65799c = j12;
        this.f65800d = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f65797a == bVar.f65797a && this.f65798b == bVar.f65798b && this.f65799c == bVar.f65799c && Intrinsics.c(this.f65800d, bVar.f65800d);
    }

    public int hashCode() {
        int a11 = ((((this.f65797a * 31) + s.a(this.f65798b)) * 31) + s.a(this.f65799c)) * 31;
        String str = this.f65800d;
        return a11 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Chapter(index=" + this.f65797a + ", start=" + this.f65798b + ", end=" + this.f65799c + ", title=" + this.f65800d + ")";
    }
}
