package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.k;

/* loaded from: classes3.dex */
public final class e3 extends v2 {

    /* renamed from: d, reason: collision with root package name */
    public static final k.a f25092d = new k.a() { // from class: com.google.android.exoplayer2.d3
        @Override // com.google.android.exoplayer2.k.a
        public final k a(Bundle bundle) {
            e3 e11;
            e11 = e3.e(bundle);
            return e11;
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private final int f25093b;

    /* renamed from: c, reason: collision with root package name */
    private final float f25094c;

    public e3(int i11) {
        com.google.android.exoplayer2.util.a.b(i11 > 0, "maxStars must be a positive integer");
        this.f25093b = i11;
        this.f25094c = -1.0f;
    }

    public e3(int i11, float f11) {
        boolean z10 = false;
        com.google.android.exoplayer2.util.a.b(i11 > 0, "maxStars must be a positive integer");
        if (f11 >= 0.0f && f11 <= i11) {
            z10 = true;
        }
        com.google.android.exoplayer2.util.a.b(z10, "starRating is out of range [0, maxStars]");
        this.f25093b = i11;
        this.f25094c = f11;
    }

    private static String c(int i11) {
        return Integer.toString(i11, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static e3 e(Bundle bundle) {
        com.google.android.exoplayer2.util.a.a(bundle.getInt(c(0), -1) == 2);
        int i11 = bundle.getInt(c(1), 5);
        float f11 = bundle.getFloat(c(2), -1.0f);
        return f11 == -1.0f ? new e3(i11) : new e3(i11, f11);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e3)) {
            return false;
        }
        e3 e3Var = (e3) obj;
        return this.f25093b == e3Var.f25093b && this.f25094c == e3Var.f25094c;
    }

    public int hashCode() {
        return com.google.common.base.j.b(Integer.valueOf(this.f25093b), Float.valueOf(this.f25094c));
    }

    @Override // com.google.android.exoplayer2.k
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(c(0), 2);
        bundle.putInt(c(1), this.f25093b);
        bundle.putFloat(c(2), this.f25094c);
        return bundle;
    }
}
