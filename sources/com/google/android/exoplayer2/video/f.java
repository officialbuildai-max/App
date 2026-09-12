package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.x;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final List f27902a;

    /* renamed from: b, reason: collision with root package name */
    public final int f27903b;

    /* renamed from: c, reason: collision with root package name */
    public final int f27904c;

    /* renamed from: d, reason: collision with root package name */
    public final int f27905d;

    /* renamed from: e, reason: collision with root package name */
    public final float f27906e;

    /* renamed from: f, reason: collision with root package name */
    public final String f27907f;

    private f(List list, int i11, int i12, int i13, float f11, String str) {
        this.f27902a = list;
        this.f27903b = i11;
        this.f27904c = i12;
        this.f27905d = i13;
        this.f27906e = f11;
        this.f27907f = str;
    }

    public static f a(d0 d0Var) {
        int i11;
        int i12;
        try {
            d0Var.Q(21);
            int D = d0Var.D() & 3;
            int D2 = d0Var.D();
            int e11 = d0Var.e();
            int i13 = 0;
            int i14 = 0;
            for (int i15 = 0; i15 < D2; i15++) {
                d0Var.Q(1);
                int J = d0Var.J();
                for (int i16 = 0; i16 < J; i16++) {
                    int J2 = d0Var.J();
                    i14 += J2 + 4;
                    d0Var.Q(J2);
                }
            }
            d0Var.P(e11);
            byte[] bArr = new byte[i14];
            int i17 = -1;
            int i18 = -1;
            float f11 = 1.0f;
            String str = null;
            int i19 = 0;
            int i20 = 0;
            while (i19 < D2) {
                int D3 = d0Var.D() & 127;
                int J3 = d0Var.J();
                int i21 = i13;
                while (i21 < J3) {
                    int J4 = d0Var.J();
                    byte[] bArr2 = com.google.android.exoplayer2.util.x.f27718a;
                    int i22 = D2;
                    System.arraycopy(bArr2, i13, bArr, i20, bArr2.length);
                    int length = i20 + bArr2.length;
                    System.arraycopy(d0Var.d(), d0Var.e(), bArr, length, J4);
                    if (D3 == 33 && i21 == 0) {
                        x.a h11 = com.google.android.exoplayer2.util.x.h(bArr, length, length + J4);
                        int i23 = h11.f27729h;
                        i18 = h11.f27730i;
                        f11 = h11.f27731j;
                        i11 = D3;
                        i12 = J3;
                        i17 = i23;
                        str = com.google.android.exoplayer2.util.f.c(h11.f27722a, h11.f27723b, h11.f27724c, h11.f27725d, h11.f27726e, h11.f27727f);
                    } else {
                        i11 = D3;
                        i12 = J3;
                    }
                    i20 = length + J4;
                    d0Var.Q(J4);
                    i21++;
                    D2 = i22;
                    D3 = i11;
                    J3 = i12;
                    i13 = 0;
                }
                i19++;
                i13 = 0;
            }
            return new f(i14 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), D + 1, i17, i18, f11, str);
        } catch (ArrayIndexOutOfBoundsException e12) {
            throw ParserException.createForMalformedContainer("Error parsing HEVC config", e12);
        }
    }
}
