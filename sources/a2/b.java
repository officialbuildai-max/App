package a2;

import java.util.Objects;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f116a;

    /* renamed from: b, reason: collision with root package name */
    public final String f117b;

    /* renamed from: c, reason: collision with root package name */
    public final int f118c;

    /* renamed from: d, reason: collision with root package name */
    public final int f119d;

    public b(String str, String str2, int i11, int i12) {
        this.f116a = str;
        this.f117b = str2;
        this.f118c = i11;
        this.f119d = i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f118c == bVar.f118c && this.f119d == bVar.f119d && Objects.equals(this.f116a, bVar.f116a) && Objects.equals(this.f117b, bVar.f117b);
    }

    public int hashCode() {
        return Objects.hash(this.f116a, this.f117b, Integer.valueOf(this.f118c), Integer.valueOf(this.f119d));
    }
}
