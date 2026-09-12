package s3;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import i3.s;
import java.util.List;
import java.util.Map;
import l2.m0;
import s3.l0;

/* loaded from: classes2.dex */
public final class e implements l2.r {

    /* renamed from: d, reason: collision with root package name */
    public static final l2.x f75029d = new l2.x() { // from class: s3.d
        @Override // l2.x
        public /* synthetic */ l2.x a(s.a aVar) {
            return l2.w.d(this, aVar);
        }

        @Override // l2.x
        public /* synthetic */ l2.x b(int i11) {
            return l2.w.b(this, i11);
        }

        @Override // l2.x
        public /* synthetic */ l2.r[] c(Uri uri, Map map) {
            return l2.w.a(this, uri, map);
        }

        @Override // l2.x
        public final l2.r[] createExtractors() {
            l2.r[] g11;
            g11 = e.g();
            return g11;
        }

        @Override // l2.x
        public /* synthetic */ l2.x d(boolean z10) {
            return l2.w.c(this, z10);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final f f75030a = new f("audio/ac4");

    /* renamed from: b, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f75031b = new androidx.media3.common.util.j0(16384);

    /* renamed from: c, reason: collision with root package name */
    private boolean f75032c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l2.r[] g() {
        return new l2.r[]{new e()};
    }

    @Override // l2.r
    public void b(l2.t tVar) {
        this.f75030a.d(tVar, new l0.d(0, 1));
        tVar.endTracks();
        tVar.f(new m0.b(C.TIME_UNSET));
    }

    @Override // l2.r
    public int c(l2.s sVar, l2.l0 l0Var) {
        int read = sVar.read(this.f75031b.e(), 0, 16384);
        if (read == -1) {
            return -1;
        }
        this.f75031b.W(0);
        this.f75031b.V(read);
        if (!this.f75032c) {
            this.f75030a.b(0L, 4);
            this.f75032c = true;
        }
        this.f75030a.a(this.f75031b);
        return 0;
    }

    @Override // l2.r
    public boolean d(l2.s sVar) {
        androidx.media3.common.util.j0 j0Var = new androidx.media3.common.util.j0(10);
        int i11 = 0;
        while (true) {
            sVar.peekFully(j0Var.e(), 0, 10);
            j0Var.W(0);
            if (j0Var.K() != 4801587) {
                break;
            }
            j0Var.X(3);
            int G = j0Var.G();
            i11 += G + 10;
            sVar.advancePeekPosition(G);
        }
        sVar.resetPeekPosition();
        sVar.advancePeekPosition(i11);
        int i12 = 0;
        int i13 = i11;
        while (true) {
            sVar.peekFully(j0Var.e(), 0, 7);
            j0Var.W(0);
            int P = j0Var.P();
            if (P == 44096 || P == 44097) {
                i12++;
                if (i12 >= 4) {
                    return true;
                }
                int g11 = l2.c.g(j0Var.e(), P);
                if (g11 == -1) {
                    return false;
                }
                sVar.advancePeekPosition(g11 - 7);
            } else {
                sVar.resetPeekPosition();
                i13++;
                if (i13 - i11 >= 8192) {
                    return false;
                }
                sVar.advancePeekPosition(i13);
                i12 = 0;
            }
        }
    }

    @Override // l2.r
    public /* synthetic */ l2.r e() {
        return l2.q.b(this);
    }

    @Override // l2.r
    public /* synthetic */ List f() {
        return l2.q.a(this);
    }

    @Override // l2.r
    public void release() {
    }

    @Override // l2.r
    public void seek(long j11, long j12) {
        this.f75032c = false;
        this.f75030a.seek();
    }
}
