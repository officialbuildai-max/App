package com.google.android.exoplayer2.video;

import android.os.Bundle;
import com.google.android.exoplayer2.k;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class c implements com.google.android.exoplayer2.k {

    /* renamed from: f, reason: collision with root package name */
    public static final k.a f27879f = new k.a() { // from class: com.google.android.exoplayer2.video.b
        @Override // com.google.android.exoplayer2.k.a
        public final com.google.android.exoplayer2.k a(Bundle bundle) {
            c e11;
            e11 = c.e(bundle);
            return e11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final int f27880a;

    /* renamed from: b, reason: collision with root package name */
    public final int f27881b;

    /* renamed from: c, reason: collision with root package name */
    public final int f27882c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f27883d;

    /* renamed from: e, reason: collision with root package name */
    private int f27884e;

    public c(int i11, int i12, int i13, byte[] bArr) {
        this.f27880a = i11;
        this.f27881b = i12;
        this.f27882c = i13;
        this.f27883d = bArr;
    }

    public static int b(int i11) {
        if (i11 == 1) {
            return 1;
        }
        if (i11 != 9) {
            return (i11 == 4 || i11 == 5 || i11 == 6 || i11 == 7) ? 2 : -1;
        }
        return 6;
    }

    public static int c(int i11) {
        if (i11 == 1) {
            return 3;
        }
        if (i11 == 16) {
            return 6;
        }
        if (i11 != 18) {
            return (i11 == 6 || i11 == 7) ? 3 : -1;
        }
        return 7;
    }

    private static String d(int i11) {
        return Integer.toString(i11, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c e(Bundle bundle) {
        return new c(bundle.getInt(d(0), -1), bundle.getInt(d(1), -1), bundle.getInt(d(2), -1), bundle.getByteArray(d(3)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f27880a == cVar.f27880a && this.f27881b == cVar.f27881b && this.f27882c == cVar.f27882c && Arrays.equals(this.f27883d, cVar.f27883d);
    }

    public int hashCode() {
        if (this.f27884e == 0) {
            this.f27884e = ((((((527 + this.f27880a) * 31) + this.f27881b) * 31) + this.f27882c) * 31) + Arrays.hashCode(this.f27883d);
        }
        return this.f27884e;
    }

    @Override // com.google.android.exoplayer2.k
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(d(0), this.f27880a);
        bundle.putInt(d(1), this.f27881b);
        bundle.putInt(d(2), this.f27882c);
        bundle.putByteArray(d(3), this.f27883d);
        return bundle;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ColorInfo(");
        sb2.append(this.f27880a);
        sb2.append(", ");
        sb2.append(this.f27881b);
        sb2.append(", ");
        sb2.append(this.f27882c);
        sb2.append(", ");
        sb2.append(this.f27883d != null);
        sb2.append(")");
        return sb2.toString();
    }
}
