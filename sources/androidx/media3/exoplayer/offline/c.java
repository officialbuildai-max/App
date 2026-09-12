package androidx.media3.exoplayer.offline;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final DownloadRequest f12495a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12496b;

    /* renamed from: c, reason: collision with root package name */
    public final long f12497c;

    /* renamed from: d, reason: collision with root package name */
    public final long f12498d;

    /* renamed from: e, reason: collision with root package name */
    public final long f12499e;

    /* renamed from: f, reason: collision with root package name */
    public final int f12500f;

    /* renamed from: g, reason: collision with root package name */
    public final int f12501g;

    /* renamed from: h, reason: collision with root package name */
    final l f12502h;

    public c(DownloadRequest downloadRequest, int i11, long j11, long j12, long j13, int i12, int i13) {
        this(downloadRequest, i11, j11, j12, j13, i12, i13, new l());
    }

    public c(DownloadRequest downloadRequest, int i11, long j11, long j12, long j13, int i12, int i13, l lVar) {
        androidx.media3.common.util.a.e(lVar);
        boolean z10 = false;
        androidx.media3.common.util.a.a((i13 == 0) == (i11 != 4));
        if (i12 != 0) {
            if (i11 != 2 && i11 != 0) {
                z10 = true;
            }
            androidx.media3.common.util.a.a(z10);
        }
        this.f12495a = downloadRequest;
        this.f12496b = i11;
        this.f12497c = j11;
        this.f12498d = j12;
        this.f12499e = j13;
        this.f12500f = i12;
        this.f12501g = i13;
        this.f12502h = lVar;
    }

    public long a() {
        return this.f12502h.f12506a;
    }

    public float b() {
        return this.f12502h.f12507b;
    }

    public boolean c() {
        int i11 = this.f12496b;
        return i11 == 3 || i11 == 4;
    }
}
