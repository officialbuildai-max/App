package androidx.media3.exoplayer.video.spherical;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.media3.common.r;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.o0;
import androidx.media3.common.util.u;
import androidx.media3.exoplayer.video.t;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class g implements t, k2.a {

    /* renamed from: i, reason: collision with root package name */
    private int f13374i;

    /* renamed from: j, reason: collision with root package name */
    private SurfaceTexture f13375j;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f13378m;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f13366a = new AtomicBoolean();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f13367b = new AtomicBoolean(true);

    /* renamed from: c, reason: collision with root package name */
    private final e f13368c = new e();

    /* renamed from: d, reason: collision with root package name */
    private final a f13369d = new a();

    /* renamed from: e, reason: collision with root package name */
    private final o0 f13370e = new o0();

    /* renamed from: f, reason: collision with root package name */
    private final o0 f13371f = new o0();

    /* renamed from: g, reason: collision with root package name */
    private final float[] f13372g = new float[16];

    /* renamed from: h, reason: collision with root package name */
    private final float[] f13373h = new float[16];

    /* renamed from: k, reason: collision with root package name */
    private volatile int f13376k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f13377l = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(SurfaceTexture surfaceTexture) {
        this.f13366a.set(true);
    }

    private void i(byte[] bArr, int i11, long j11) {
        byte[] bArr2 = this.f13378m;
        int i12 = this.f13377l;
        this.f13378m = bArr;
        if (i11 == -1) {
            i11 = this.f13376k;
        }
        this.f13377l = i11;
        if (i12 == i11 && Arrays.equals(bArr2, this.f13378m)) {
            return;
        }
        byte[] bArr3 = this.f13378m;
        c a11 = bArr3 != null ? d.a(bArr3, this.f13377l) : null;
        if (a11 == null || !e.c(a11)) {
            a11 = c.b(this.f13377l);
        }
        this.f13371f.a(j11, a11);
    }

    @Override // k2.a
    public void a(long j11, float[] fArr) {
        this.f13369d.e(j11, fArr);
    }

    @Override // k2.a
    public void b() {
        this.f13370e.c();
        this.f13369d.d();
        this.f13367b.set(true);
    }

    public void d(float[] fArr, boolean z10) {
        GLES20.glClear(16384);
        try {
            GlUtil.b();
        } catch (GlUtil.GlException e11) {
            u.d("SceneRenderer", "Failed to draw a frame", e11);
        }
        if (this.f13366a.compareAndSet(true, false)) {
            ((SurfaceTexture) androidx.media3.common.util.a.e(this.f13375j)).updateTexImage();
            try {
                GlUtil.b();
            } catch (GlUtil.GlException e12) {
                u.d("SceneRenderer", "Failed to draw a frame", e12);
            }
            if (this.f13367b.compareAndSet(true, false)) {
                GlUtil.k(this.f13372g);
            }
            long timestamp = this.f13375j.getTimestamp();
            Long l11 = (Long) this.f13370e.g(timestamp);
            if (l11 != null) {
                this.f13369d.c(this.f13372g, l11.longValue());
            }
            c cVar = (c) this.f13371f.j(timestamp);
            if (cVar != null) {
                this.f13368c.d(cVar);
            }
        }
        Matrix.multiplyMM(this.f13373h, 0, fArr, 0, this.f13372g, 0);
        this.f13368c.a(this.f13374i, this.f13373h, z10);
    }

    public SurfaceTexture e() {
        try {
            GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
            GlUtil.b();
            this.f13368c.b();
            GlUtil.b();
            this.f13374i = GlUtil.f();
        } catch (GlUtil.GlException e11) {
            u.d("SceneRenderer", "Failed to initialize the renderer", e11);
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f13374i);
        this.f13375j = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: androidx.media3.exoplayer.video.spherical.f
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                g.this.g(surfaceTexture2);
            }
        });
        return this.f13375j;
    }

    @Override // androidx.media3.exoplayer.video.t
    public void f(long j11, long j12, r rVar, MediaFormat mediaFormat) {
        this.f13370e.a(j12, Long.valueOf(j11));
        i(rVar.A, rVar.B, j12);
    }

    public void h(int i11) {
        this.f13376k = i11;
    }
}
