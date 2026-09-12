package com.google.android.exoplayer2.video.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.video.i;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.google.android.exoplayer2.video.spherical.b;
import com.google.android.exoplayer2.video.spherical.h;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes3.dex */
public final class SphericalGLSurfaceView extends GLSurfaceView {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f27969m = 0;

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList f27970a;

    /* renamed from: b, reason: collision with root package name */
    private final SensorManager f27971b;

    /* renamed from: c, reason: collision with root package name */
    private final Sensor f27972c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.android.exoplayer2.video.spherical.b f27973d;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f27974e;

    /* renamed from: f, reason: collision with root package name */
    private final h f27975f;

    /* renamed from: g, reason: collision with root package name */
    private final g f27976g;

    /* renamed from: h, reason: collision with root package name */
    private SurfaceTexture f27977h;

    /* renamed from: i, reason: collision with root package name */
    private Surface f27978i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f27979j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f27980k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f27981l;

    /* loaded from: classes3.dex */
    final class a implements GLSurfaceView.Renderer, h.a, b.a {

        /* renamed from: a, reason: collision with root package name */
        private final g f27982a;

        /* renamed from: d, reason: collision with root package name */
        private final float[] f27985d;

        /* renamed from: e, reason: collision with root package name */
        private final float[] f27986e;

        /* renamed from: f, reason: collision with root package name */
        private final float[] f27987f;

        /* renamed from: g, reason: collision with root package name */
        private float f27988g;

        /* renamed from: h, reason: collision with root package name */
        private float f27989h;

        /* renamed from: b, reason: collision with root package name */
        private final float[] f27983b = new float[16];

        /* renamed from: c, reason: collision with root package name */
        private final float[] f27984c = new float[16];

        /* renamed from: i, reason: collision with root package name */
        private final float[] f27990i = new float[16];

        /* renamed from: j, reason: collision with root package name */
        private final float[] f27991j = new float[16];

        public a(g gVar) {
            float[] fArr = new float[16];
            this.f27985d = fArr;
            float[] fArr2 = new float[16];
            this.f27986e = fArr2;
            float[] fArr3 = new float[16];
            this.f27987f = fArr3;
            this.f27982a = gVar;
            Matrix.setIdentityM(fArr, 0);
            Matrix.setIdentityM(fArr2, 0);
            Matrix.setIdentityM(fArr3, 0);
            this.f27989h = 3.1415927f;
        }

        private float c(float f11) {
            if (f11 > 1.0f) {
                return (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / f11)) * 2.0d);
            }
            return 90.0f;
        }

        private void d() {
            Matrix.setRotateM(this.f27986e, 0, -this.f27988g, (float) Math.cos(this.f27989h), (float) Math.sin(this.f27989h), 0.0f);
        }

        @Override // com.google.android.exoplayer2.video.spherical.b.a
        public synchronized void a(float[] fArr, float f11) {
            float[] fArr2 = this.f27985d;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.f27989h = -f11;
            d();
        }

        @Override // com.google.android.exoplayer2.video.spherical.h.a
        public synchronized void b(PointF pointF) {
            this.f27988g = pointF.y;
            d();
            Matrix.setRotateM(this.f27987f, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.f27991j, 0, this.f27985d, 0, this.f27987f, 0);
                Matrix.multiplyMM(this.f27990i, 0, this.f27986e, 0, this.f27991j, 0);
            }
            Matrix.multiplyMM(this.f27984c, 0, this.f27983b, 0, this.f27990i, 0);
            this.f27982a.d(this.f27984c, false);
        }

        @Override // com.google.android.exoplayer2.video.spherical.h.a
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return SphericalGLSurfaceView.this.performClick();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i11, int i12) {
            GLES20.glViewport(0, 0, i11, i12);
            float f11 = i11 / i12;
            Matrix.perspectiveM(this.f27983b, 0, c(f11), f11, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            SphericalGLSurfaceView.this.f(this.f27982a.e());
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void p(Surface surface);

        void q(Surface surface);
    }

    public SphericalGLSurfaceView(Context context) {
        this(context, null);
    }

    public SphericalGLSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27970a = new CopyOnWriteArrayList();
        this.f27974e = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) com.google.android.exoplayer2.util.a.e(context.getSystemService("sensor"));
        this.f27971b = sensorManager;
        Sensor defaultSensor = p0.f27680a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.f27972c = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        g gVar = new g();
        this.f27976g = gVar;
        a aVar = new a(gVar);
        h hVar = new h(context, aVar, 25.0f);
        this.f27975f = hVar;
        this.f27973d = new com.google.android.exoplayer2.video.spherical.b(((WindowManager) com.google.android.exoplayer2.util.a.e((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), hVar, aVar);
        this.f27979j = true;
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setOnTouchListener(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        Surface surface = this.f27978i;
        if (surface != null) {
            Iterator it = this.f27970a.iterator();
            while (it.hasNext()) {
                ((b) it.next()).p(surface);
            }
        }
        g(this.f27977h, surface);
        this.f27977h = null;
        this.f27978i = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.f27977h;
        Surface surface = this.f27978i;
        Surface surface2 = new Surface(surfaceTexture);
        this.f27977h = surfaceTexture;
        this.f27978i = surface2;
        Iterator it = this.f27970a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).q(surface2);
        }
        g(surfaceTexture2, surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final SurfaceTexture surfaceTexture) {
        this.f27974e.post(new Runnable() { // from class: ma.c
            @Override // java.lang.Runnable
            public final void run() {
                SphericalGLSurfaceView.this.e(surfaceTexture);
            }
        });
    }

    private static void g(SurfaceTexture surfaceTexture, Surface surface) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
    }

    private void h() {
        boolean z10 = this.f27979j && this.f27980k;
        Sensor sensor = this.f27972c;
        if (sensor == null || z10 == this.f27981l) {
            return;
        }
        if (z10) {
            this.f27971b.registerListener(this.f27973d, sensor, 0);
        } else {
            this.f27971b.unregisterListener(this.f27973d);
        }
        this.f27981l = z10;
    }

    public void addVideoSurfaceListener(b bVar) {
        this.f27970a.add(bVar);
    }

    public ma.a getCameraMotionListener() {
        return this.f27976g;
    }

    public i getVideoFrameMetadataListener() {
        return this.f27976g;
    }

    @Nullable
    public Surface getVideoSurface() {
        return this.f27978i;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f27974e.post(new Runnable() { // from class: ma.d
            @Override // java.lang.Runnable
            public final void run() {
                SphericalGLSurfaceView.this.d();
            }
        });
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.f27980k = false;
        h();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.f27980k = true;
        h();
    }

    public void removeVideoSurfaceListener(b bVar) {
        this.f27970a.remove(bVar);
    }

    public void setDefaultStereoMode(int i11) {
        this.f27976g.h(i11);
    }

    public void setUseSensorRotation(boolean z10) {
        this.f27979j = z10;
        h();
    }
}
