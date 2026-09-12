package l2;

import androidx.media3.common.r;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.List;

/* loaded from: classes2.dex */
public final class o0 implements r {

    /* renamed from: a, reason: collision with root package name */
    private final int f68778a;

    /* renamed from: b, reason: collision with root package name */
    private final int f68779b;

    /* renamed from: c, reason: collision with root package name */
    private final String f68780c;

    /* renamed from: d, reason: collision with root package name */
    private int f68781d;

    /* renamed from: e, reason: collision with root package name */
    private int f68782e;

    /* renamed from: f, reason: collision with root package name */
    private t f68783f;

    /* renamed from: g, reason: collision with root package name */
    private s0 f68784g;

    public o0(int i11, int i12, String str) {
        this.f68778a = i11;
        this.f68779b = i12;
        this.f68780c = str;
    }

    private void a(String str) {
        s0 track = this.f68783f.track(1024, 4);
        this.f68784g = track;
        track.c(new r.b().U(str).u0(str).N());
        this.f68783f.endTracks();
        this.f68783f.f(new p0(C.TIME_UNSET));
        this.f68782e = 1;
    }

    private void g(s sVar) {
        int e11 = ((s0) androidx.media3.common.util.a.e(this.f68784g)).e(sVar, 1024, true);
        if (e11 != -1) {
            this.f68781d += e11;
            return;
        }
        this.f68782e = 2;
        this.f68784g.d(0L, 1, this.f68781d, 0, null);
        this.f68781d = 0;
    }

    @Override // l2.r
    public void b(t tVar) {
        this.f68783f = tVar;
        a(this.f68780c);
    }

    @Override // l2.r
    public int c(s sVar, l0 l0Var) {
        int i11 = this.f68782e;
        if (i11 == 1) {
            g(sVar);
            return 0;
        }
        if (i11 == 2) {
            return -1;
        }
        throw new IllegalStateException();
    }

    @Override // l2.r
    public boolean d(s sVar) {
        androidx.media3.common.util.a.g((this.f68778a == -1 || this.f68779b == -1) ? false : true);
        androidx.media3.common.util.j0 j0Var = new androidx.media3.common.util.j0(this.f68779b);
        sVar.peekFully(j0Var.e(), 0, this.f68779b);
        return j0Var.P() == this.f68778a;
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
        if (j11 == 0 || this.f68782e == 1) {
            this.f68782e = 1;
            this.f68781d = 0;
        }
    }
}
