package l2;

import androidx.media3.common.ParserException;
import androidx.media3.container.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final List f68651a;

    /* renamed from: b, reason: collision with root package name */
    public final int f68652b;

    /* renamed from: c, reason: collision with root package name */
    public final int f68653c;

    /* renamed from: d, reason: collision with root package name */
    public final int f68654d;

    /* renamed from: e, reason: collision with root package name */
    public final int f68655e;

    /* renamed from: f, reason: collision with root package name */
    public final int f68656f;

    /* renamed from: g, reason: collision with root package name */
    public final int f68657g;

    /* renamed from: h, reason: collision with root package name */
    public final int f68658h;

    /* renamed from: i, reason: collision with root package name */
    public final int f68659i;

    /* renamed from: j, reason: collision with root package name */
    public final int f68660j;

    /* renamed from: k, reason: collision with root package name */
    public final float f68661k;

    /* renamed from: l, reason: collision with root package name */
    public final String f68662l;

    private d(List list, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, float f11, String str) {
        this.f68651a = list;
        this.f68652b = i11;
        this.f68653c = i12;
        this.f68654d = i13;
        this.f68655e = i14;
        this.f68656f = i15;
        this.f68657g = i16;
        this.f68658h = i17;
        this.f68659i = i18;
        this.f68660j = i19;
        this.f68661k = f11;
        this.f68662l = str;
    }

    private static byte[] a(androidx.media3.common.util.j0 j0Var) {
        int P = j0Var.P();
        int f11 = j0Var.f();
        j0Var.X(P);
        return androidx.media3.common.util.j.g(j0Var.e(), f11, P);
    }

    public static d b(androidx.media3.common.util.j0 j0Var) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        float f11;
        String str;
        int i18;
        try {
            j0Var.X(4);
            int H = (j0Var.H() & 3) + 1;
            if (H == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int H2 = j0Var.H() & 31;
            for (int i19 = 0; i19 < H2; i19++) {
                arrayList.add(a(j0Var));
            }
            int H3 = j0Var.H();
            for (int i20 = 0; i20 < H3; i20++) {
                arrayList.add(a(j0Var));
            }
            if (H2 > 0) {
                g.m C = androidx.media3.container.g.C((byte[]) arrayList.get(0), androidx.media3.container.g.f10675a.length, ((byte[]) arrayList.get(0)).length);
                int i21 = C.f10740f;
                int i22 = C.f10741g;
                int i23 = C.f10743i + 8;
                int i24 = C.f10744j + 8;
                int i25 = C.f10751q;
                int i26 = C.f10752r;
                int i27 = C.f10753s;
                int i28 = C.f10754t;
                float f12 = C.f10742h;
                str = androidx.media3.common.util.j.d(C.f10735a, C.f10736b, C.f10737c);
                i17 = i27;
                i18 = i28;
                f11 = f12;
                i14 = i24;
                i15 = i25;
                i16 = i26;
                i11 = i21;
                i12 = i22;
                i13 = i23;
            } else {
                i11 = -1;
                i12 = -1;
                i13 = -1;
                i14 = -1;
                i15 = -1;
                i16 = -1;
                i17 = -1;
                f11 = 1.0f;
                str = null;
                i18 = 16;
            }
            return new d(arrayList, H, i11, i12, i13, i14, i15, i16, i17, i18, f11, str);
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw ParserException.createForMalformedContainer("Error parsing AVC config", e11);
        }
    }
}
