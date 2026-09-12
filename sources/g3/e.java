package g3;

import androidx.media3.common.util.j0;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.OggPageHeader;
import java.util.Arrays;
import l2.s;
import l2.u;

/* loaded from: classes2.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    private final f f63415a = new f();

    /* renamed from: b, reason: collision with root package name */
    private final j0 f63416b = new j0(new byte[OggPageHeader.MAX_PAGE_PAYLOAD], 0);

    /* renamed from: c, reason: collision with root package name */
    private int f63417c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f63418d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f63419e;

    private int a(int i11) {
        int i12;
        int i13 = 0;
        this.f63418d = 0;
        do {
            int i14 = this.f63418d;
            int i15 = i11 + i14;
            f fVar = this.f63415a;
            if (i15 >= fVar.f63426g) {
                break;
            }
            int[] iArr = fVar.f63429j;
            this.f63418d = i14 + 1;
            i12 = iArr[i14 + i11];
            i13 += i12;
        } while (i12 == 255);
        return i13;
    }

    public f b() {
        return this.f63415a;
    }

    public j0 c() {
        return this.f63416b;
    }

    public boolean d(s sVar) {
        int i11;
        androidx.media3.common.util.a.g(sVar != null);
        if (this.f63419e) {
            this.f63419e = false;
            this.f63416b.S(0);
        }
        while (!this.f63419e) {
            if (this.f63417c < 0) {
                if (!this.f63415a.c(sVar) || !this.f63415a.a(sVar, true)) {
                    return false;
                }
                f fVar = this.f63415a;
                int i12 = fVar.f63427h;
                if ((fVar.f63421b & 1) == 1 && this.f63416b.g() == 0) {
                    i12 += a(0);
                    i11 = this.f63418d;
                } else {
                    i11 = 0;
                }
                if (!u.e(sVar, i12)) {
                    return false;
                }
                this.f63417c = i11;
            }
            int a11 = a(this.f63417c);
            int i13 = this.f63417c + this.f63418d;
            if (a11 > 0) {
                j0 j0Var = this.f63416b;
                j0Var.c(j0Var.g() + a11);
                if (!u.d(sVar, this.f63416b.e(), this.f63416b.g(), a11)) {
                    return false;
                }
                j0 j0Var2 = this.f63416b;
                j0Var2.V(j0Var2.g() + a11);
                this.f63419e = this.f63415a.f63429j[i13 + (-1)] != 255;
            }
            if (i13 == this.f63415a.f63426g) {
                i13 = -1;
            }
            this.f63417c = i13;
        }
        return true;
    }

    public void e() {
        this.f63415a.b();
        this.f63416b.S(0);
        this.f63417c = -1;
        this.f63419e = false;
    }

    public void f() {
        if (this.f63416b.e().length == 65025) {
            return;
        }
        j0 j0Var = this.f63416b;
        j0Var.U(Arrays.copyOf(j0Var.e(), Math.max(OggPageHeader.MAX_PAGE_PAYLOAD, this.f63416b.g())), this.f63416b.g());
    }
}
