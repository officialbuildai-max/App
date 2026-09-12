package l9;

import g9.b0;
import g9.c0;
import g9.e0;
import g9.n;

/* loaded from: classes4.dex */
public final class d implements n {

    /* renamed from: a, reason: collision with root package name */
    private final long f68894a;

    /* renamed from: b, reason: collision with root package name */
    private final n f68895b;

    /* loaded from: classes4.dex */
    class a implements b0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b0 f68896a;

        a(b0 b0Var) {
            this.f68896a = b0Var;
        }

        @Override // g9.b0
        public long getDurationUs() {
            return this.f68896a.getDurationUs();
        }

        @Override // g9.b0
        public b0.a getSeekPoints(long j11) {
            b0.a seekPoints = this.f68896a.getSeekPoints(j11);
            c0 c0Var = seekPoints.f63493a;
            c0 c0Var2 = new c0(c0Var.f63498a, c0Var.f63499b + d.this.f68894a);
            c0 c0Var3 = seekPoints.f63494b;
            return new b0.a(c0Var2, new c0(c0Var3.f63498a, c0Var3.f63499b + d.this.f68894a));
        }

        @Override // g9.b0
        public boolean isSeekable() {
            return this.f68896a.isSeekable();
        }
    }

    public d(long j11, n nVar) {
        this.f68894a = j11;
        this.f68895b = nVar;
    }

    @Override // g9.n
    public void d(b0 b0Var) {
        this.f68895b.d(new a(b0Var));
    }

    @Override // g9.n
    public void endTracks() {
        this.f68895b.endTracks();
    }

    @Override // g9.n
    public e0 track(int i11, int i12) {
        return this.f68895b.track(i11, i12);
    }
}
