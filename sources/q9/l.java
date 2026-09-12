package q9;

import com.google.android.exoplayer2.o1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;
import q9.i0;

/* loaded from: classes4.dex */
public final class l implements m {

    /* renamed from: a, reason: collision with root package name */
    private final List f73461a;

    /* renamed from: b, reason: collision with root package name */
    private final g9.e0[] f73462b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f73463c;

    /* renamed from: d, reason: collision with root package name */
    private int f73464d;

    /* renamed from: e, reason: collision with root package name */
    private int f73465e;

    /* renamed from: f, reason: collision with root package name */
    private long f73466f = C.TIME_UNSET;

    public l(List list) {
        this.f73461a = list;
        this.f73462b = new g9.e0[list.size()];
    }

    private boolean d(com.google.android.exoplayer2.util.d0 d0Var, int i11) {
        if (d0Var.a() == 0) {
            return false;
        }
        if (d0Var.D() != i11) {
            this.f73463c = false;
        }
        this.f73464d--;
        return this.f73463c;
    }

    @Override // q9.m
    public void a(com.google.android.exoplayer2.util.d0 d0Var) {
        if (this.f73463c) {
            if (this.f73464d != 2 || d(d0Var, 32)) {
                if (this.f73464d != 1 || d(d0Var, 0)) {
                    int e11 = d0Var.e();
                    int a11 = d0Var.a();
                    for (g9.e0 e0Var : this.f73462b) {
                        d0Var.P(e11);
                        e0Var.c(d0Var, a11);
                    }
                    this.f73465e += a11;
                }
            }
        }
    }

    @Override // q9.m
    public void b(long j11, int i11) {
        if ((i11 & 4) == 0) {
            return;
        }
        this.f73463c = true;
        if (j11 != C.TIME_UNSET) {
            this.f73466f = j11;
        }
        this.f73465e = 0;
        this.f73464d = 2;
    }

    @Override // q9.m
    public void c(g9.n nVar, i0.d dVar) {
        for (int i11 = 0; i11 < this.f73462b.length; i11++) {
            i0.a aVar = (i0.a) this.f73461a.get(i11);
            dVar.a();
            g9.e0 track = nVar.track(dVar.c(), 3);
            track.e(new o1.b().S(dVar.b()).e0(MimeTypes.APPLICATION_DVBSUBS).T(Collections.singletonList(aVar.f73436c)).V(aVar.f73434a).E());
            this.f73462b[i11] = track;
        }
    }

    @Override // q9.m
    public void packetFinished() {
        if (this.f73463c) {
            if (this.f73466f != C.TIME_UNSET) {
                for (g9.e0 e0Var : this.f73462b) {
                    e0Var.d(this.f73466f, 1, this.f73465e, 0, null);
                }
            }
            this.f73463c = false;
        }
    }

    @Override // q9.m
    public void seek() {
        this.f73463c = false;
        this.f73466f = C.TIME_UNSET;
    }
}
