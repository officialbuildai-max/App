package l2;

/* loaded from: classes2.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final int f68775a;

    /* renamed from: b, reason: collision with root package name */
    public final int f68776b;

    /* renamed from: c, reason: collision with root package name */
    public final String f68777c;

    private o(int i11, int i12, String str) {
        this.f68775a = i11;
        this.f68776b = i12;
        this.f68777c = str;
    }

    public static o a(androidx.media3.common.util.j0 j0Var) {
        String str;
        j0Var.X(2);
        int H = j0Var.H();
        int i11 = H >> 1;
        int H2 = ((j0Var.H() >> 3) & 31) | ((H & 1) << 5);
        if (i11 == 4 || i11 == 5 || i11 == 7 || i11 == 8) {
            str = "dvhe";
        } else if (i11 == 9) {
            str = "dvav";
        } else {
            if (i11 != 10) {
                return null;
            }
            str = "dav1";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(i11 < 10 ? ".0" : ".");
        sb2.append(i11);
        sb2.append(H2 < 10 ? ".0" : ".");
        sb2.append(H2);
        return new o(i11, H2, sb2.toString());
    }
}
