package l9;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.d0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g9.a0;
import g9.b0;
import g9.l;
import g9.m;
import g9.n;
import o9.k;

/* loaded from: classes4.dex */
public final class a implements l {

    /* renamed from: b, reason: collision with root package name */
    private n f68878b;

    /* renamed from: c, reason: collision with root package name */
    private int f68879c;

    /* renamed from: d, reason: collision with root package name */
    private int f68880d;

    /* renamed from: e, reason: collision with root package name */
    private int f68881e;

    /* renamed from: g, reason: collision with root package name */
    private MotionPhotoMetadata f68883g;

    /* renamed from: h, reason: collision with root package name */
    private m f68884h;

    /* renamed from: i, reason: collision with root package name */
    private c f68885i;

    /* renamed from: j, reason: collision with root package name */
    private k f68886j;

    /* renamed from: a, reason: collision with root package name */
    private final d0 f68877a = new d0(6);

    /* renamed from: f, reason: collision with root package name */
    private long f68882f = -1;

    private void a(m mVar) {
        this.f68877a.L(2);
        mVar.peekFully(this.f68877a.d(), 0, 2);
        mVar.advancePeekPosition(this.f68877a.J() - 2);
    }

    private void e() {
        g(new Metadata.Entry[0]);
        ((n) com.google.android.exoplayer2.util.a.e(this.f68878b)).endTracks();
        this.f68878b.d(new b0.b(C.TIME_UNSET));
        this.f68879c = 6;
    }

    private static MotionPhotoMetadata f(String str, long j11) {
        b a11;
        if (j11 == -1 || (a11 = e.a(str)) == null) {
            return null;
        }
        return a11.a(j11);
    }

    private void g(Metadata.Entry... entryArr) {
        ((n) com.google.android.exoplayer2.util.a.e(this.f68878b)).track(1024, 4).e(new o1.b().K("image/jpeg").X(new Metadata(entryArr)).E());
    }

    private int h(m mVar) {
        this.f68877a.L(2);
        mVar.peekFully(this.f68877a.d(), 0, 2);
        return this.f68877a.J();
    }

    private void i(m mVar) {
        this.f68877a.L(2);
        mVar.readFully(this.f68877a.d(), 0, 2);
        int J = this.f68877a.J();
        this.f68880d = J;
        if (J == 65498) {
            if (this.f68882f != -1) {
                this.f68879c = 4;
                return;
            } else {
                e();
                return;
            }
        }
        if ((J < 65488 || J > 65497) && J != 65281) {
            this.f68879c = 1;
        }
    }

    private void j(m mVar) {
        String x10;
        if (this.f68880d == 65505) {
            d0 d0Var = new d0(this.f68881e);
            mVar.readFully(d0Var.d(), 0, this.f68881e);
            if (this.f68883g == null && "http://ns.adobe.com/xap/1.0/".equals(d0Var.x()) && (x10 = d0Var.x()) != null) {
                MotionPhotoMetadata f11 = f(x10, mVar.getLength());
                this.f68883g = f11;
                if (f11 != null) {
                    this.f68882f = f11.videoStartPosition;
                }
            }
        } else {
            mVar.skipFully(this.f68881e);
        }
        this.f68879c = 0;
    }

    private void k(m mVar) {
        this.f68877a.L(2);
        mVar.readFully(this.f68877a.d(), 0, 2);
        this.f68881e = this.f68877a.J() - 2;
        this.f68879c = 2;
    }

    private void l(m mVar) {
        if (!mVar.peekFully(this.f68877a.d(), 0, 1, true)) {
            e();
            return;
        }
        mVar.resetPeekPosition();
        if (this.f68886j == null) {
            this.f68886j = new k();
        }
        c cVar = new c(mVar, this.f68882f);
        this.f68885i = cVar;
        if (!this.f68886j.d(cVar)) {
            e();
        } else {
            this.f68886j.b(new d(this.f68882f, (n) com.google.android.exoplayer2.util.a.e(this.f68878b)));
            m();
        }
    }

    private void m() {
        g((Metadata.Entry) com.google.android.exoplayer2.util.a.e(this.f68883g));
        this.f68879c = 5;
    }

    @Override // g9.l
    public void b(n nVar) {
        this.f68878b = nVar;
    }

    @Override // g9.l
    public int c(m mVar, a0 a0Var) {
        int i11 = this.f68879c;
        if (i11 == 0) {
            i(mVar);
            return 0;
        }
        if (i11 == 1) {
            k(mVar);
            return 0;
        }
        if (i11 == 2) {
            j(mVar);
            return 0;
        }
        if (i11 == 4) {
            long position = mVar.getPosition();
            long j11 = this.f68882f;
            if (position != j11) {
                a0Var.f63492a = j11;
                return 1;
            }
            l(mVar);
            return 0;
        }
        if (i11 != 5) {
            if (i11 == 6) {
                return -1;
            }
            throw new IllegalStateException();
        }
        if (this.f68885i == null || mVar != this.f68884h) {
            this.f68884h = mVar;
            this.f68885i = new c(mVar, this.f68882f);
        }
        int c11 = ((k) com.google.android.exoplayer2.util.a.e(this.f68886j)).c(this.f68885i, a0Var);
        if (c11 == 1) {
            a0Var.f63492a += this.f68882f;
        }
        return c11;
    }

    @Override // g9.l
    public boolean d(m mVar) {
        if (h(mVar) != 65496) {
            return false;
        }
        int h11 = h(mVar);
        this.f68880d = h11;
        if (h11 == 65504) {
            a(mVar);
            this.f68880d = h(mVar);
        }
        if (this.f68880d != 65505) {
            return false;
        }
        mVar.advancePeekPosition(2);
        this.f68877a.L(6);
        mVar.peekFully(this.f68877a.d(), 0, 6);
        return this.f68877a.F() == 1165519206 && this.f68877a.J() == 0;
    }

    @Override // g9.l
    public void release() {
        k kVar = this.f68886j;
        if (kVar != null) {
            kVar.release();
        }
    }

    @Override // g9.l
    public void seek(long j11, long j12) {
        if (j11 == 0) {
            this.f68879c = 0;
            this.f68886j = null;
        } else if (this.f68879c == 5) {
            ((k) com.google.android.exoplayer2.util.a.e(this.f68886j)).seek(j11, j12);
        }
    }
}
