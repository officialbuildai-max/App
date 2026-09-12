package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.k;

/* loaded from: classes3.dex */
public final class n2 implements k {

    /* renamed from: d, reason: collision with root package name */
    public static final n2 f25527d = new n2(1.0f);

    /* renamed from: e, reason: collision with root package name */
    public static final k.a f25528e = new k.a() { // from class: com.google.android.exoplayer2.m2
        @Override // com.google.android.exoplayer2.k.a
        public final k a(Bundle bundle) {
            n2 d11;
            d11 = n2.d(bundle);
            return d11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final float f25529a;

    /* renamed from: b, reason: collision with root package name */
    public final float f25530b;

    /* renamed from: c, reason: collision with root package name */
    private final int f25531c;

    public n2(float f11) {
        this(f11, 1.0f);
    }

    public n2(float f11, float f12) {
        com.google.android.exoplayer2.util.a.a(f11 > 0.0f);
        com.google.android.exoplayer2.util.a.a(f12 > 0.0f);
        this.f25529a = f11;
        this.f25530b = f12;
        this.f25531c = Math.round(f11 * 1000.0f);
    }

    private static String c(int i11) {
        return Integer.toString(i11, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ n2 d(Bundle bundle) {
        return new n2(bundle.getFloat(c(0), 1.0f), bundle.getFloat(c(1), 1.0f));
    }

    public long b(long j11) {
        return j11 * this.f25531c;
    }

    public n2 e(float f11) {
        return new n2(f11, this.f25530b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n2.class != obj.getClass()) {
            return false;
        }
        n2 n2Var = (n2) obj;
        return this.f25529a == n2Var.f25529a && this.f25530b == n2Var.f25530b;
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.f25529a)) * 31) + Float.floatToRawIntBits(this.f25530b);
    }

    @Override // com.google.android.exoplayer2.k
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putFloat(c(0), this.f25529a);
        bundle.putFloat(c(1), this.f25530b);
        return bundle;
    }

    public String toString() {
        return com.google.android.exoplayer2.util.p0.C("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.f25529a), Float.valueOf(this.f25530b));
    }
}
