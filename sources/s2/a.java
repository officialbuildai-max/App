package s2;

import androidx.media3.common.util.j0;
import java.util.List;
import l2.l0;
import l2.o0;
import l2.q;
import l2.r;
import l2.s;
import l2.t;

/* loaded from: classes2.dex */
public final class a implements r {

    /* renamed from: a, reason: collision with root package name */
    private final j0 f74981a = new j0(4);

    /* renamed from: b, reason: collision with root package name */
    private final o0 f74982b = new o0(-1, -1, "image/heif");

    private boolean a(s sVar, int i11) {
        this.f74981a.S(4);
        sVar.peekFully(this.f74981a.e(), 0, 4);
        return this.f74981a.J() == ((long) i11);
    }

    @Override // l2.r
    public void b(t tVar) {
        this.f74982b.b(tVar);
    }

    @Override // l2.r
    public int c(s sVar, l0 l0Var) {
        return this.f74982b.c(sVar, l0Var);
    }

    @Override // l2.r
    public boolean d(s sVar) {
        sVar.advancePeekPosition(4);
        return a(sVar, 1718909296) && a(sVar, 1751476579);
    }

    @Override // l2.r
    public /* synthetic */ r e() {
        return q.b(this);
    }

    @Override // l2.r
    public /* synthetic */ List f() {
        return q.a(this);
    }

    @Override // l2.r
    public void release() {
    }

    @Override // l2.r
    public void seek(long j11, long j12) {
        this.f74982b.seek(j11, j12);
    }
}
