package p9;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.d0;
import g9.m;
import g9.o;

/* loaded from: classes4.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    public int f72483a;

    /* renamed from: b, reason: collision with root package name */
    public int f72484b;

    /* renamed from: c, reason: collision with root package name */
    public long f72485c;

    /* renamed from: d, reason: collision with root package name */
    public long f72486d;

    /* renamed from: e, reason: collision with root package name */
    public long f72487e;

    /* renamed from: f, reason: collision with root package name */
    public long f72488f;

    /* renamed from: g, reason: collision with root package name */
    public int f72489g;

    /* renamed from: h, reason: collision with root package name */
    public int f72490h;

    /* renamed from: i, reason: collision with root package name */
    public int f72491i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f72492j = new int[255];

    /* renamed from: k, reason: collision with root package name */
    private final d0 f72493k = new d0(255);

    public boolean a(m mVar, boolean z10) {
        b();
        this.f72493k.L(27);
        if (!o.b(mVar, this.f72493k.d(), 0, 27, z10) || this.f72493k.F() != 1332176723) {
            return false;
        }
        int D = this.f72493k.D();
        this.f72483a = D;
        if (D != 0) {
            if (z10) {
                return false;
            }
            throw ParserException.createForUnsupportedContainerFeature("unsupported bit stream revision");
        }
        this.f72484b = this.f72493k.D();
        this.f72485c = this.f72493k.r();
        this.f72486d = this.f72493k.t();
        this.f72487e = this.f72493k.t();
        this.f72488f = this.f72493k.t();
        int D2 = this.f72493k.D();
        this.f72489g = D2;
        this.f72490h = D2 + 27;
        this.f72493k.L(D2);
        if (!o.b(mVar, this.f72493k.d(), 0, this.f72489g, z10)) {
            return false;
        }
        for (int i11 = 0; i11 < this.f72489g; i11++) {
            this.f72492j[i11] = this.f72493k.D();
            this.f72491i += this.f72492j[i11];
        }
        return true;
    }

    public void b() {
        this.f72483a = 0;
        this.f72484b = 0;
        this.f72485c = 0L;
        this.f72486d = 0L;
        this.f72487e = 0L;
        this.f72488f = 0L;
        this.f72489g = 0;
        this.f72490h = 0;
        this.f72491i = 0;
    }

    public boolean c(m mVar) {
        return d(mVar, -1L);
    }

    public boolean d(m mVar, long j11) {
        com.google.android.exoplayer2.util.a.a(mVar.getPosition() == mVar.getPeekPosition());
        this.f72493k.L(4);
        while (true) {
            if ((j11 == -1 || mVar.getPosition() + 4 < j11) && o.b(mVar, this.f72493k.d(), 0, 4, true)) {
                this.f72493k.P(0);
                if (this.f72493k.F() == 1332176723) {
                    mVar.resetPeekPosition();
                    return true;
                }
                mVar.skipFully(1);
            }
        }
        do {
            if (j11 != -1 && mVar.getPosition() >= j11) {
                break;
            }
        } while (mVar.skip(1) != -1);
        return false;
    }
}
