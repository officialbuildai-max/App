package i9;

import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;

/* loaded from: classes4.dex */
final class d implements a {

    /* renamed from: a, reason: collision with root package name */
    public final int f65180a;

    /* renamed from: b, reason: collision with root package name */
    public final int f65181b;

    /* renamed from: c, reason: collision with root package name */
    public final int f65182c;

    /* renamed from: d, reason: collision with root package name */
    public final int f65183d;

    /* renamed from: e, reason: collision with root package name */
    public final int f65184e;

    /* renamed from: f, reason: collision with root package name */
    public final int f65185f;

    private d(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f65180a = i11;
        this.f65181b = i12;
        this.f65182c = i13;
        this.f65183d = i14;
        this.f65184e = i15;
        this.f65185f = i16;
    }

    public static d c(d0 d0Var) {
        int q11 = d0Var.q();
        d0Var.Q(12);
        int q12 = d0Var.q();
        int q13 = d0Var.q();
        int q14 = d0Var.q();
        d0Var.Q(4);
        int q15 = d0Var.q();
        int q16 = d0Var.q();
        d0Var.Q(8);
        return new d(q11, q12, q13, q14, q15, q16);
    }

    public long a() {
        return p0.N0(this.f65184e, this.f65182c * 1000000, this.f65183d);
    }

    public int b() {
        int i11 = this.f65180a;
        if (i11 == 1935960438) {
            return 2;
        }
        if (i11 == 1935963489) {
            return 1;
        }
        if (i11 == 1937012852) {
            return 3;
        }
        s.i("AviStreamHeaderChunk", "Found unsupported streamType fourCC: " + Integer.toHexString(this.f65180a));
        return -1;
    }

    @Override // i9.a
    public int getType() {
        return 1752331379;
    }
}
