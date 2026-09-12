package ii;

import androidx.collection.s;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final int f65369a;

    /* renamed from: b, reason: collision with root package name */
    private final long f65370b;

    public a(int i11, long j11) {
        this.f65369a = i11;
        this.f65370b = j11;
    }

    public final int a() {
        return this.f65369a;
    }

    public final long b() {
        return this.f65370b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f65369a == aVar.f65369a && this.f65370b == aVar.f65370b;
    }

    public int hashCode() {
        return (this.f65369a * 31) + s.a(this.f65370b);
    }

    public String toString() {
        return "AdSceneConfig(priority=" + this.f65369a + ", useInterval=" + this.f65370b + ")";
    }
}
