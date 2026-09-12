package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.k;

/* loaded from: classes3.dex */
public final class r implements k {

    /* renamed from: d, reason: collision with root package name */
    public static final r f25667d = new r(0, 0, 0);

    /* renamed from: e, reason: collision with root package name */
    public static final k.a f25668e = new k.a() { // from class: com.google.android.exoplayer2.q
        @Override // com.google.android.exoplayer2.k.a
        public final k a(Bundle bundle) {
            r c11;
            c11 = r.c(bundle);
            return c11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final int f25669a;

    /* renamed from: b, reason: collision with root package name */
    public final int f25670b;

    /* renamed from: c, reason: collision with root package name */
    public final int f25671c;

    public r(int i11, int i12, int i13) {
        this.f25669a = i11;
        this.f25670b = i12;
        this.f25671c = i13;
    }

    private static String b(int i11) {
        return Integer.toString(i11, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ r c(Bundle bundle) {
        return new r(bundle.getInt(b(0), 0), bundle.getInt(b(1), 0), bundle.getInt(b(2), 0));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f25669a == rVar.f25669a && this.f25670b == rVar.f25670b && this.f25671c == rVar.f25671c;
    }

    public int hashCode() {
        return ((((527 + this.f25669a) * 31) + this.f25670b) * 31) + this.f25671c;
    }

    @Override // com.google.android.exoplayer2.k
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(b(0), this.f25669a);
        bundle.putInt(b(1), this.f25670b);
        bundle.putInt(b(2), this.f25671c);
        return bundle;
    }
}
