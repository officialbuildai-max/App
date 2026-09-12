package n2;

import androidx.media3.common.util.j0;

/* loaded from: classes2.dex */
final class c implements a {

    /* renamed from: a, reason: collision with root package name */
    public final int f70265a;

    /* renamed from: b, reason: collision with root package name */
    public final int f70266b;

    /* renamed from: c, reason: collision with root package name */
    public final int f70267c;

    /* renamed from: d, reason: collision with root package name */
    public final int f70268d;

    private c(int i11, int i12, int i13, int i14) {
        this.f70265a = i11;
        this.f70266b = i12;
        this.f70267c = i13;
        this.f70268d = i14;
    }

    public static c b(j0 j0Var) {
        int u11 = j0Var.u();
        j0Var.X(8);
        int u12 = j0Var.u();
        int u13 = j0Var.u();
        j0Var.X(4);
        int u14 = j0Var.u();
        j0Var.X(12);
        return new c(u11, u12, u13, u14);
    }

    public boolean a() {
        return (this.f70266b & 16) == 16;
    }

    @Override // n2.a
    public int getType() {
        return 1751742049;
    }
}
