package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.k;

/* loaded from: classes3.dex */
public final class i3 extends v2 {

    /* renamed from: d, reason: collision with root package name */
    public static final k.a f25193d = new k.a() { // from class: com.google.android.exoplayer2.h3
        @Override // com.google.android.exoplayer2.k.a
        public final k a(Bundle bundle) {
            i3 e11;
            e11 = i3.e(bundle);
            return e11;
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private final boolean f25194b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f25195c;

    public i3() {
        this.f25194b = false;
        this.f25195c = false;
    }

    public i3(boolean z10) {
        this.f25194b = true;
        this.f25195c = z10;
    }

    private static String c(int i11) {
        return Integer.toString(i11, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static i3 e(Bundle bundle) {
        com.google.android.exoplayer2.util.a.a(bundle.getInt(c(0), -1) == 3);
        return bundle.getBoolean(c(1), false) ? new i3(bundle.getBoolean(c(2), false)) : new i3();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i3)) {
            return false;
        }
        i3 i3Var = (i3) obj;
        return this.f25195c == i3Var.f25195c && this.f25194b == i3Var.f25194b;
    }

    public int hashCode() {
        return com.google.common.base.j.b(Boolean.valueOf(this.f25194b), Boolean.valueOf(this.f25195c));
    }

    @Override // com.google.android.exoplayer2.k
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(c(0), 3);
        bundle.putBoolean(c(1), this.f25194b);
        bundle.putBoolean(c(2), this.f25195c);
        return bundle;
    }
}
