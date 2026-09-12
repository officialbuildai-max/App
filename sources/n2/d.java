package n2;

import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import androidx.media3.common.util.u;

/* loaded from: classes2.dex */
final class d implements a {

    /* renamed from: a, reason: collision with root package name */
    public final int f70269a;

    /* renamed from: b, reason: collision with root package name */
    public final int f70270b;

    /* renamed from: c, reason: collision with root package name */
    public final int f70271c;

    /* renamed from: d, reason: collision with root package name */
    public final int f70272d;

    /* renamed from: e, reason: collision with root package name */
    public final int f70273e;

    /* renamed from: f, reason: collision with root package name */
    public final int f70274f;

    /* renamed from: g, reason: collision with root package name */
    public final int f70275g;

    private d(int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        this.f70269a = i11;
        this.f70270b = i12;
        this.f70271c = i13;
        this.f70272d = i14;
        this.f70273e = i15;
        this.f70274f = i16;
        this.f70275g = i17;
    }

    public static d c(j0 j0Var) {
        int u11 = j0Var.u();
        j0Var.X(12);
        int u12 = j0Var.u();
        int u13 = j0Var.u();
        int u14 = j0Var.u();
        j0Var.X(4);
        int u15 = j0Var.u();
        int u16 = j0Var.u();
        j0Var.X(4);
        return new d(u11, u12, u13, u14, u15, u16, j0Var.u());
    }

    public long a() {
        return a1.e1(this.f70273e, this.f70271c * 1000000, this.f70272d);
    }

    public int b() {
        int i11 = this.f70269a;
        if (i11 == 1935960438) {
            return 2;
        }
        if (i11 == 1935963489) {
            return 1;
        }
        if (i11 == 1937012852) {
            return 3;
        }
        u.h("AviStreamHeaderChunk", "Found unsupported streamType fourCC: " + Integer.toHexString(this.f70269a));
        return -1;
    }

    @Override // n2.a
    public int getType() {
        return 1752331379;
    }
}
