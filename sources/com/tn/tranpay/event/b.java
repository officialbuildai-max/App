package com.tn.tranpay.event;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f41603a;

    public b(int i11) {
        this.f41603a = i11;
    }

    public final int a() {
        return this.f41603a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && this.f41603a == ((b) obj).f41603a;
    }

    public int hashCode() {
        return this.f41603a;
    }

    public String toString() {
        return "PaymentEvent(status=" + this.f41603a + ")";
    }
}
