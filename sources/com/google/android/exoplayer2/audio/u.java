package com.google.android.exoplayer2.audio;

/* loaded from: classes3.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final int f24828a;

    /* renamed from: b, reason: collision with root package name */
    public final float f24829b;

    public u(int i11, float f11) {
        this.f24828a = i11;
        this.f24829b = f11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || u.class != obj.getClass()) {
            return false;
        }
        u uVar = (u) obj;
        return this.f24828a == uVar.f24828a && Float.compare(uVar.f24829b, this.f24829b) == 0;
    }

    public int hashCode() {
        return ((527 + this.f24828a) * 31) + Float.floatToIntBits(this.f24829b);
    }
}
