package g3;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.j0;
import l2.s;
import l2.u;

/* loaded from: classes2.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    public int f63420a;

    /* renamed from: b, reason: collision with root package name */
    public int f63421b;

    /* renamed from: c, reason: collision with root package name */
    public long f63422c;

    /* renamed from: d, reason: collision with root package name */
    public long f63423d;

    /* renamed from: e, reason: collision with root package name */
    public long f63424e;

    /* renamed from: f, reason: collision with root package name */
    public long f63425f;

    /* renamed from: g, reason: collision with root package name */
    public int f63426g;

    /* renamed from: h, reason: collision with root package name */
    public int f63427h;

    /* renamed from: i, reason: collision with root package name */
    public int f63428i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f63429j = new int[255];

    /* renamed from: k, reason: collision with root package name */
    private final j0 f63430k = new j0(255);

    public boolean a(s sVar, boolean z10) {
        b();
        this.f63430k.S(27);
        if (!u.b(sVar, this.f63430k.e(), 0, 27, z10) || this.f63430k.J() != 1332176723) {
            return false;
        }
        int H = this.f63430k.H();
        this.f63420a = H;
        if (H != 0) {
            if (z10) {
                return false;
            }
            throw ParserException.createForUnsupportedContainerFeature("unsupported bit stream revision");
        }
        this.f63421b = this.f63430k.H();
        this.f63422c = this.f63430k.v();
        this.f63423d = this.f63430k.x();
        this.f63424e = this.f63430k.x();
        this.f63425f = this.f63430k.x();
        int H2 = this.f63430k.H();
        this.f63426g = H2;
        this.f63427h = H2 + 27;
        this.f63430k.S(H2);
        if (!u.b(sVar, this.f63430k.e(), 0, this.f63426g, z10)) {
            return false;
        }
        for (int i11 = 0; i11 < this.f63426g; i11++) {
            this.f63429j[i11] = this.f63430k.H();
            this.f63428i += this.f63429j[i11];
        }
        return true;
    }

    public void b() {
        this.f63420a = 0;
        this.f63421b = 0;
        this.f63422c = 0L;
        this.f63423d = 0L;
        this.f63424e = 0L;
        this.f63425f = 0L;
        this.f63426g = 0;
        this.f63427h = 0;
        this.f63428i = 0;
    }

    public boolean c(s sVar) {
        return d(sVar, -1L);
    }

    public boolean d(s sVar, long j11) {
        androidx.media3.common.util.a.a(sVar.getPosition() == sVar.getPeekPosition());
        this.f63430k.S(4);
        while (true) {
            if ((j11 == -1 || sVar.getPosition() + 4 < j11) && u.b(sVar, this.f63430k.e(), 0, 4, true)) {
                this.f63430k.W(0);
                if (this.f63430k.J() == 1332176723) {
                    sVar.resetPeekPosition();
                    return true;
                }
                sVar.skipFully(1);
            }
        }
        do {
            if (j11 != -1 && sVar.getPosition() >= j11) {
                break;
            }
        } while (sVar.skip(1) != -1);
        return false;
    }
}
