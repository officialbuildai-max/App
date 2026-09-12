package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.util.d0;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final int f27885a;

    /* renamed from: b, reason: collision with root package name */
    public final int f27886b;

    /* renamed from: c, reason: collision with root package name */
    public final String f27887c;

    private d(int i11, int i12, String str) {
        this.f27885a = i11;
        this.f27886b = i12;
        this.f27887c = str;
    }

    public static d a(d0 d0Var) {
        String str;
        d0Var.Q(2);
        int D = d0Var.D();
        int i11 = D >> 1;
        int D2 = ((d0Var.D() >> 3) & 31) | ((D & 1) << 5);
        if (i11 == 4 || i11 == 5 || i11 == 7) {
            str = "dvhe";
        } else if (i11 == 8) {
            str = "hev1";
        } else {
            if (i11 != 9) {
                return null;
            }
            str = "avc3";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(".0");
        sb2.append(i11);
        sb2.append(D2 >= 10 ? "." : ".0");
        sb2.append(D2);
        return new d(i11, D2, sb2.toString());
    }
}
