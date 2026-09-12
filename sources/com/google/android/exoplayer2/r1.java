package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.k;

/* loaded from: classes3.dex */
public final class r1 extends v2 {

    /* renamed from: d, reason: collision with root package name */
    public static final k.a f25673d = new k.a() { // from class: com.google.android.exoplayer2.q1
        @Override // com.google.android.exoplayer2.k.a
        public final k a(Bundle bundle) {
            r1 e11;
            e11 = r1.e(bundle);
            return e11;
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private final boolean f25674b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f25675c;

    public r1() {
        this.f25674b = false;
        this.f25675c = false;
    }

    public r1(boolean z10) {
        this.f25674b = true;
        this.f25675c = z10;
    }

    private static String c(int i11) {
        return Integer.toString(i11, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static r1 e(Bundle bundle) {
        com.google.android.exoplayer2.util.a.a(bundle.getInt(c(0), -1) == 0);
        return bundle.getBoolean(c(1), false) ? new r1(bundle.getBoolean(c(2), false)) : new r1();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof r1)) {
            return false;
        }
        r1 r1Var = (r1) obj;
        return this.f25675c == r1Var.f25675c && this.f25674b == r1Var.f25674b;
    }

    public int hashCode() {
        return com.google.common.base.j.b(Boolean.valueOf(this.f25674b), Boolean.valueOf(this.f25675c));
    }

    @Override // com.google.android.exoplayer2.k
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(c(0), 0);
        bundle.putBoolean(c(1), this.f25674b);
        bundle.putBoolean(c(2), this.f25675c);
        return bundle;
    }
}
