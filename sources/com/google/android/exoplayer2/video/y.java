package com.google.android.exoplayer2.video;

import android.os.Bundle;
import com.google.android.exoplayer2.k;
import com.vungle.ads.internal.protos.Sdk$SDKError;

/* loaded from: classes3.dex */
public final class y implements com.google.android.exoplayer2.k {

    /* renamed from: e, reason: collision with root package name */
    public static final y f28061e = new y(0, 0);

    /* renamed from: f, reason: collision with root package name */
    public static final k.a f28062f = new k.a() { // from class: com.google.android.exoplayer2.video.x
        @Override // com.google.android.exoplayer2.k.a
        public final com.google.android.exoplayer2.k a(Bundle bundle) {
            y c11;
            c11 = y.c(bundle);
            return c11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final int f28063a;

    /* renamed from: b, reason: collision with root package name */
    public final int f28064b;

    /* renamed from: c, reason: collision with root package name */
    public final int f28065c;

    /* renamed from: d, reason: collision with root package name */
    public final float f28066d;

    public y(int i11, int i12) {
        this(i11, i12, 0, 1.0f);
    }

    public y(int i11, int i12, int i13, float f11) {
        this.f28063a = i11;
        this.f28064b = i12;
        this.f28065c = i13;
        this.f28066d = f11;
    }

    private static String b(int i11) {
        return Integer.toString(i11, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ y c(Bundle bundle) {
        return new y(bundle.getInt(b(0), 0), bundle.getInt(b(1), 0), bundle.getInt(b(2), 0), bundle.getFloat(b(3), 1.0f));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.f28063a == yVar.f28063a && this.f28064b == yVar.f28064b && this.f28065c == yVar.f28065c && this.f28066d == yVar.f28066d;
    }

    public int hashCode() {
        return ((((((Sdk$SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE + this.f28063a) * 31) + this.f28064b) * 31) + this.f28065c) * 31) + Float.floatToRawIntBits(this.f28066d);
    }

    @Override // com.google.android.exoplayer2.k
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(b(0), this.f28063a);
        bundle.putInt(b(1), this.f28064b);
        bundle.putInt(b(2), this.f28065c);
        bundle.putFloat(b(3), this.f28066d);
        return bundle;
    }
}
