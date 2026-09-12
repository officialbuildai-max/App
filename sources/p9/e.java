package p9;

import com.google.android.exoplayer2.util.d0;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.OggPageHeader;
import g9.m;
import g9.o;
import java.util.Arrays;

/* loaded from: classes4.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    private final f f72478a = new f();

    /* renamed from: b, reason: collision with root package name */
    private final d0 f72479b = new d0(new byte[OggPageHeader.MAX_PAGE_PAYLOAD], 0);

    /* renamed from: c, reason: collision with root package name */
    private int f72480c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f72481d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f72482e;

    private int a(int i11) {
        int i12;
        int i13 = 0;
        this.f72481d = 0;
        do {
            int i14 = this.f72481d;
            int i15 = i11 + i14;
            f fVar = this.f72478a;
            if (i15 >= fVar.f72489g) {
                break;
            }
            int[] iArr = fVar.f72492j;
            this.f72481d = i14 + 1;
            i12 = iArr[i14 + i11];
            i13 += i12;
        } while (i12 == 255);
        return i13;
    }

    public f b() {
        return this.f72478a;
    }

    public d0 c() {
        return this.f72479b;
    }

    public boolean d(m mVar) {
        int i11;
        com.google.android.exoplayer2.util.a.g(mVar != null);
        if (this.f72482e) {
            this.f72482e = false;
            this.f72479b.L(0);
        }
        while (!this.f72482e) {
            if (this.f72480c < 0) {
                if (!this.f72478a.c(mVar) || !this.f72478a.a(mVar, true)) {
                    return false;
                }
                f fVar = this.f72478a;
                int i12 = fVar.f72490h;
                if ((fVar.f72484b & 1) == 1 && this.f72479b.f() == 0) {
                    i12 += a(0);
                    i11 = this.f72481d;
                } else {
                    i11 = 0;
                }
                if (!o.e(mVar, i12)) {
                    return false;
                }
                this.f72480c = i11;
            }
            int a11 = a(this.f72480c);
            int i13 = this.f72480c + this.f72481d;
            if (a11 > 0) {
                d0 d0Var = this.f72479b;
                d0Var.c(d0Var.f() + a11);
                if (!o.d(mVar, this.f72479b.d(), this.f72479b.f(), a11)) {
                    return false;
                }
                d0 d0Var2 = this.f72479b;
                d0Var2.O(d0Var2.f() + a11);
                this.f72482e = this.f72478a.f72492j[i13 + (-1)] != 255;
            }
            if (i13 == this.f72478a.f72489g) {
                i13 = -1;
            }
            this.f72480c = i13;
        }
        return true;
    }

    public void e() {
        this.f72478a.b();
        this.f72479b.L(0);
        this.f72480c = -1;
        this.f72482e = false;
    }

    public void f() {
        if (this.f72479b.d().length == 65025) {
            return;
        }
        d0 d0Var = this.f72479b;
        d0Var.N(Arrays.copyOf(d0Var.d(), Math.max(OggPageHeader.MAX_PAGE_PAYLOAD, this.f72479b.f())), this.f72479b.f());
    }
}
