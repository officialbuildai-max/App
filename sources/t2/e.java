package t2;

import l2.d0;
import l2.m0;
import l2.n0;
import l2.s0;
import l2.t;

/* loaded from: classes2.dex */
public final class e implements t {

    /* renamed from: a, reason: collision with root package name */
    private final long f76131a;

    /* renamed from: b, reason: collision with root package name */
    private final t f76132b;

    /* loaded from: classes2.dex */
    class a extends d0 {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ m0 f76133b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(m0 m0Var, m0 m0Var2) {
            super(m0Var);
            this.f76133b = m0Var2;
        }

        @Override // l2.d0, l2.m0
        public m0.a getSeekPoints(long j11) {
            m0.a seekPoints = this.f76133b.getSeekPoints(j11);
            n0 n0Var = seekPoints.f68767a;
            n0 n0Var2 = new n0(n0Var.f68773a, n0Var.f68774b + e.this.f76131a);
            n0 n0Var3 = seekPoints.f68768b;
            return new m0.a(n0Var2, new n0(n0Var3.f68773a, n0Var3.f68774b + e.this.f76131a));
        }
    }

    public e(long j11, t tVar) {
        this.f76131a = j11;
        this.f76132b = tVar;
    }

    @Override // l2.t
    public void endTracks() {
        this.f76132b.endTracks();
    }

    @Override // l2.t
    public void f(m0 m0Var) {
        this.f76132b.f(new a(m0Var, m0Var));
    }

    @Override // l2.t
    public s0 track(int i11, int i12) {
        return this.f76132b.track(i11, i12);
    }
}
