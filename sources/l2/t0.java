package l2;

import l2.s0;

/* loaded from: classes2.dex */
public final class t0 {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f68807a = new byte[10];

    /* renamed from: b, reason: collision with root package name */
    private boolean f68808b;

    /* renamed from: c, reason: collision with root package name */
    private int f68809c;

    /* renamed from: d, reason: collision with root package name */
    private long f68810d;

    /* renamed from: e, reason: collision with root package name */
    private int f68811e;

    /* renamed from: f, reason: collision with root package name */
    private int f68812f;

    /* renamed from: g, reason: collision with root package name */
    private int f68813g;

    public void a(s0 s0Var, s0.a aVar) {
        if (this.f68809c > 0) {
            s0Var.d(this.f68810d, this.f68811e, this.f68812f, this.f68813g, aVar);
            this.f68809c = 0;
        }
    }

    public void b() {
        this.f68808b = false;
        this.f68809c = 0;
    }

    public void c(s0 s0Var, long j11, int i11, int i12, int i13, s0.a aVar) {
        androidx.media3.common.util.a.h(this.f68813g <= i12 + i13, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.f68808b) {
            int i14 = this.f68809c;
            int i15 = i14 + 1;
            this.f68809c = i15;
            if (i14 == 0) {
                this.f68810d = j11;
                this.f68811e = i11;
                this.f68812f = 0;
            }
            this.f68812f += i12;
            this.f68813g = i13;
            if (i15 >= 16) {
                a(s0Var, aVar);
            }
        }
    }

    public void d(s sVar) {
        if (this.f68808b) {
            return;
        }
        sVar.peekFully(this.f68807a, 0, 10);
        sVar.resetPeekPosition();
        if (b.j(this.f68807a) == 0) {
            return;
        }
        this.f68808b = true;
    }
}
