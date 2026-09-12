package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.x;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final List f27873a;

    /* renamed from: b, reason: collision with root package name */
    public final int f27874b;

    /* renamed from: c, reason: collision with root package name */
    public final int f27875c;

    /* renamed from: d, reason: collision with root package name */
    public final int f27876d;

    /* renamed from: e, reason: collision with root package name */
    public final float f27877e;

    /* renamed from: f, reason: collision with root package name */
    public final String f27878f;

    private a(List list, int i11, int i12, int i13, float f11, String str) {
        this.f27873a = list;
        this.f27874b = i11;
        this.f27875c = i12;
        this.f27876d = i13;
        this.f27877e = f11;
        this.f27878f = str;
    }

    private static byte[] a(d0 d0Var) {
        int J = d0Var.J();
        int e11 = d0Var.e();
        d0Var.Q(J);
        return com.google.android.exoplayer2.util.f.d(d0Var.d(), e11, J);
    }

    public static a b(d0 d0Var) {
        int i11;
        int i12;
        float f11;
        String str;
        try {
            d0Var.Q(4);
            int D = (d0Var.D() & 3) + 1;
            if (D == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int D2 = d0Var.D() & 31;
            for (int i13 = 0; i13 < D2; i13++) {
                arrayList.add(a(d0Var));
            }
            int D3 = d0Var.D();
            for (int i14 = 0; i14 < D3; i14++) {
                arrayList.add(a(d0Var));
            }
            if (D2 > 0) {
                x.c l11 = com.google.android.exoplayer2.util.x.l((byte[]) arrayList.get(0), D, ((byte[]) arrayList.get(0)).length);
                int i15 = l11.f27740f;
                int i16 = l11.f27741g;
                float f12 = l11.f27742h;
                str = com.google.android.exoplayer2.util.f.a(l11.f27735a, l11.f27736b, l11.f27737c);
                i11 = i15;
                i12 = i16;
                f11 = f12;
            } else {
                i11 = -1;
                i12 = -1;
                f11 = 1.0f;
                str = null;
            }
            return new a(arrayList, D, i11, i12, f11, str);
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw ParserException.createForMalformedContainer("Error parsing AVC config", e11);
        }
    }
}
