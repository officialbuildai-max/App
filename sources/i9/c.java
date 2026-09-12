package i9;

import com.google.android.exoplayer2.util.d0;

/* loaded from: classes4.dex */
final class c implements a {

    /* renamed from: a, reason: collision with root package name */
    public final int f65176a;

    /* renamed from: b, reason: collision with root package name */
    public final int f65177b;

    /* renamed from: c, reason: collision with root package name */
    public final int f65178c;

    /* renamed from: d, reason: collision with root package name */
    public final int f65179d;

    private c(int i11, int i12, int i13, int i14) {
        this.f65176a = i11;
        this.f65177b = i12;
        this.f65178c = i13;
        this.f65179d = i14;
    }

    public static c b(d0 d0Var) {
        int q11 = d0Var.q();
        d0Var.Q(8);
        int q12 = d0Var.q();
        int q13 = d0Var.q();
        d0Var.Q(4);
        int q14 = d0Var.q();
        d0Var.Q(12);
        return new c(q11, q12, q13, q14);
    }

    public boolean a() {
        return (this.f65177b & 16) == 16;
    }

    @Override // i9.a
    public int getType() {
        return 1751742049;
    }
}
