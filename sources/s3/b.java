package s3;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import i3.s;
import java.util.List;
import java.util.Map;
import l2.m0;
import s3.l0;

/* loaded from: classes2.dex */
public final class b implements l2.r {

    /* renamed from: d, reason: collision with root package name */
    public static final l2.x f74991d = new l2.x() { // from class: s3.a
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
            g11 = b.g();
            return g11;
        }

        @Override // l2.x
        public /* synthetic */ l2.x d(boolean z10) {
            return l2.w.c(this, z10);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final c f74992a = new c(MimeTypes.AUDIO_AC3);

    /* renamed from: b, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f74993b = new androidx.media3.common.util.j0(2786);

    /* renamed from: c, reason: collision with root package name */
    private boolean f74994c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l2.r[] g() {
        return new l2.r[]{new b()};
    }

    @Override // l2.r
    public void b(l2.t tVar) {
        this.f74992a.d(tVar, new l0.d(0, 1));
        tVar.endTracks();
        tVar.f(new m0.b(C.TIME_UNSET));
    }

    @Override // l2.r
    public int c(l2.s sVar, l2.l0 l0Var) {
        int read = sVar.read(this.f74993b.e(), 0, 2786);
        if (read == -1) {
            return -1;
        }
        this.f74993b.W(0);
        this.f74993b.V(read);
        if (!this.f74994c) {
            this.f74992a.b(0L, 4);
            this.f74994c = true;
        }
        this.f74992a.a(this.f74993b);
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
            sVar.peekFully(j0Var.e(), 0, 6);
            j0Var.W(0);
            if (j0Var.P() != 2935) {
                sVar.resetPeekPosition();
                i13++;
                if (i13 - i11 >= 8192) {
                    return false;
                }
                sVar.advancePeekPosition(i13);
                i12 = 0;
            } else {
                i12++;
                if (i12 >= 4) {
                    return true;
                }
                int g11 = l2.b.g(j0Var.e());
                if (g11 == -1) {
                    return false;
                }
                sVar.advancePeekPosition(g11 - 6);
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
        this.f74994c = false;
        this.f74992a.seek();
    }
}
