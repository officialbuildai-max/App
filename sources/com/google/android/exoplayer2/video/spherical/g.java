package com.google.android.exoplayer2.video.spherical;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.k0;
import com.google.android.exoplayer2.video.i;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class g implements i, ma.a {

    /* renamed from: i, reason: collision with root package name */
    private int f28040i;

    /* renamed from: j, reason: collision with root package name */
    private SurfaceTexture f28041j;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f28044m;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f28032a = new AtomicBoolean();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f28033b = new AtomicBoolean(true);

    /* renamed from: c, reason: collision with root package name */
    private final e f28034c = new e();

    /* renamed from: d, reason: collision with root package name */
    private final a f28035d = new a();

    /* renamed from: e, reason: collision with root package name */
    private final k0 f28036e = new k0();

    /* renamed from: f, reason: collision with root package name */
    private final k0 f28037f = new k0();

    /* renamed from: g, reason: collision with root package name */
    private final float[] f28038g = new float[16];

    /* renamed from: h, reason: collision with root package name */
    private final float[] f28039h = new float[16];

    /* renamed from: k, reason: collision with root package name */
    private volatile int f28042k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f28043l = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(SurfaceTexture surfaceTexture) {
        this.f28032a.set(true);
    }

    private void i(byte[] bArr, int i11, long j11) {
        byte[] bArr2 = this.f28044m;
        int i12 = this.f28043l;
        this.f28044m = bArr;
        if (i11 == -1) {
            i11 = this.f28042k;
        }
        this.f28043l = i11;
        if (i12 == i11 && Arrays.equals(bArr2, this.f28044m)) {
            return;
        }
        byte[] bArr3 = this.f28044m;
        c a11 = bArr3 != null ? d.a(bArr3, this.f28043l) : null;
        if (a11 == null || !e.c(a11)) {
            a11 = c.b(this.f28043l);
        }
        this.f28037f.a(j11, a11);
    }

    @Override // ma.a
    public void a(long j11, float[] fArr) {
        this.f28035d.e(j11, fArr);
    }

    @Override // ma.a
    public void b() {
        this.f28036e.c();
        this.f28035d.d();
        this.f28033b.set(true);
    }

    public void d(float[] fArr, boolean z10) {
        GLES20.glClear(16384);
        GlUtil.c();
        if (this.f28032a.compareAndSet(true, false)) {
            ((SurfaceTexture) com.google.android.exoplayer2.util.a.e(this.f28041j)).updateTexImage();
            GlUtil.c();
            if (this.f28033b.compareAndSet(true, false)) {
                Matrix.setIdentityM(this.f28038g, 0);
            }
            long timestamp = this.f28041j.getTimestamp();
            Long l11 = (Long) this.f28036e.g(timestamp);
            if (l11 != null) {
                this.f28035d.c(this.f28038g, l11.longValue());
            }
            c cVar = (c) this.f28037f.j(timestamp);
            if (cVar != null) {
                this.f28034c.d(cVar);
            }
        }
        Matrix.multiplyMM(this.f28039h, 0, fArr, 0, this.f28038g, 0);
        this.f28034c.a(this.f28040i, this.f28039h, z10);
    }

    public SurfaceTexture e() {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        GlUtil.c();
        this.f28034c.b();
        GlUtil.c();
        this.f28040i = GlUtil.f();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f28040i);
        this.f28041j = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.google.android.exoplayer2.video.spherical.f
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                g.this.g(surfaceTexture2);
            }
        });
        return this.f28041j;
    }

    @Override // com.google.android.exoplayer2.video.i
    public void f(long j11, long j12, o1 o1Var, MediaFormat mediaFormat) {
        this.f28036e.a(j12, Long.valueOf(j11));
        i(o1Var.f25560v, o1Var.f25561w, j12);
    }

    public void h(int i11) {
        this.f28042k = i11;
    }
}
