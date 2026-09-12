package uy;

/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final int f77078a;

    public e(int i11) {
        this.f77078a = i11;
    }

    public final int a() {
        return this.f77078a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && this.f77078a == ((e) obj).f77078a;
    }

    public int hashCode() {
        return this.f77078a;
    }

    public String toString() {
        return "PaymentEvent(status=" + this.f77078a + ")";
    }
}
