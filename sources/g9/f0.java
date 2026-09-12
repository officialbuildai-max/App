package g9;

import g9.e0;

/* loaded from: classes4.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f63524a = new byte[10];

    /* renamed from: b, reason: collision with root package name */
    private boolean f63525b;

    /* renamed from: c, reason: collision with root package name */
    private int f63526c;

    /* renamed from: d, reason: collision with root package name */
    private long f63527d;

    /* renamed from: e, reason: collision with root package name */
    private int f63528e;

    /* renamed from: f, reason: collision with root package name */
    private int f63529f;

    /* renamed from: g, reason: collision with root package name */
    private int f63530g;

    public void a(e0 e0Var, e0.a aVar) {
        if (this.f63526c > 0) {
            e0Var.d(this.f63527d, this.f63528e, this.f63529f, this.f63530g, aVar);
            this.f63526c = 0;
        }
    }

    public void b() {
        this.f63525b = false;
        this.f63526c = 0;
    }

    public void c(e0 e0Var, long j11, int i11, int i12, int i13, e0.a aVar) {
        com.google.android.exoplayer2.util.a.h(this.f63530g <= i12 + i13, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.f63525b) {
            int i14 = this.f63526c;
            int i15 = i14 + 1;
            this.f63526c = i15;
            if (i14 == 0) {
                this.f63527d = j11;
                this.f63528e = i11;
                this.f63529f = 0;
            }
            this.f63529f += i12;
            this.f63530g = i13;
            if (i15 >= 16) {
                a(e0Var, aVar);
            }
        }
    }

    public void d(m mVar) {
        if (this.f63525b) {
            return;
        }
        mVar.peekFully(this.f63524a, 0, 10);
        mVar.resetPeekPosition();
        if (com.google.android.exoplayer2.audio.b.i(this.f63524a) == 0) {
            return;
        }
        this.f63525b = true;
    }
}
