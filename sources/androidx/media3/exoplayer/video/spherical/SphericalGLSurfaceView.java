package androidx.media3.exoplayer.video.spherical;

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
import androidx.media3.common.util.GlUtil;
import androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView;
import androidx.media3.exoplayer.video.spherical.b;
import androidx.media3.exoplayer.video.spherical.h;
import androidx.media3.exoplayer.video.t;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes2.dex */
public final class SphericalGLSurfaceView extends GLSurfaceView {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f13303m = 0;

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList f13304a;

    /* renamed from: b, reason: collision with root package name */
    private final SensorManager f13305b;

    /* renamed from: c, reason: collision with root package name */
    private final Sensor f13306c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.media3.exoplayer.video.spherical.b f13307d;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f13308e;

    /* renamed from: f, reason: collision with root package name */
    private final h f13309f;

    /* renamed from: g, reason: collision with root package name */
    private final g f13310g;

    /* renamed from: h, reason: collision with root package name */
    private SurfaceTexture f13311h;

    /* renamed from: i, reason: collision with root package name */
    private Surface f13312i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f13313j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f13314k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f13315l;

    /* loaded from: classes2.dex */
    final class a implements GLSurfaceView.Renderer, h.a, b.a {

        /* renamed from: a, reason: collision with root package name */
        private final g f13316a;

        /* renamed from: d, reason: collision with root package name */
        private final float[] f13319d;

        /* renamed from: e, reason: collision with root package name */
        private final float[] f13320e;

        /* renamed from: f, reason: collision with root package name */
        private final float[] f13321f;

        /* renamed from: g, reason: collision with root package name */
        private float f13322g;

        /* renamed from: h, reason: collision with root package name */
        private float f13323h;

        /* renamed from: b, reason: collision with root package name */
        private final float[] f13317b = new float[16];

        /* renamed from: c, reason: collision with root package name */
        private final float[] f13318c = new float[16];

        /* renamed from: i, reason: collision with root package name */
        private final float[] f13324i = new float[16];

        /* renamed from: j, reason: collision with root package name */
        private final float[] f13325j = new float[16];

        public a(g gVar) {
            float[] fArr = new float[16];
            this.f13319d = fArr;
            float[] fArr2 = new float[16];
            this.f13320e = fArr2;
            float[] fArr3 = new float[16];
            this.f13321f = fArr3;
            this.f13316a = gVar;
            GlUtil.k(fArr);
            GlUtil.k(fArr2);
            GlUtil.k(fArr3);
            this.f13323h = 3.1415927f;
        }

        private float c(float f11) {
            if (f11 > 1.0f) {
                return (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / f11)) * 2.0d);
            }
            return 90.0f;
        }

        private void d() {
            Matrix.setRotateM(this.f13320e, 0, -this.f13322g, (float) Math.cos(this.f13323h), (float) Math.sin(this.f13323h), 0.0f);
        }

        @Override // androidx.media3.exoplayer.video.spherical.b.a
        public synchronized void a(float[] fArr, float f11) {
            float[] fArr2 = this.f13319d;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.f13323h = -f11;
            d();
        }

        @Override // androidx.media3.exoplayer.video.spherical.h.a
        public synchronized void b(PointF pointF) {
            this.f13322g = pointF.y;
            d();
            Matrix.setRotateM(this.f13321f, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.f13325j, 0, this.f13319d, 0, this.f13321f, 0);
                Matrix.multiplyMM(this.f13324i, 0, this.f13320e, 0, this.f13325j, 0);
            }
            Matrix.multiplyMM(this.f13318c, 0, this.f13317b, 0, this.f13324i, 0);
            this.f13316a.d(this.f13318c, false);
        }

        @Override // androidx.media3.exoplayer.video.spherical.h.a
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return SphericalGLSurfaceView.this.performClick();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i11, int i12) {
            GLES20.glViewport(0, 0, i11, i12);
            float f11 = i11 / i12;
            Matrix.perspectiveM(this.f13317b, 0, c(f11), f11, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            SphericalGLSurfaceView.this.f(this.f13316a.e());
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void p(Surface surface);

        void q(Surface surface);
    }

    public SphericalGLSurfaceView(Context context) {
        this(context, null);
    }

    public SphericalGLSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13304a = new CopyOnWriteArrayList();
        this.f13308e = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) androidx.media3.common.util.a.e(context.getSystemService("sensor"));
        this.f13305b = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(15);
        this.f13306c = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        g gVar = new g();
        this.f13310g = gVar;
        a aVar = new a(gVar);
        h hVar = new h(context, aVar, 25.0f);
        this.f13309f = hVar;
        this.f13307d = new androidx.media3.exoplayer.video.spherical.b(((WindowManager) androidx.media3.common.util.a.e((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), hVar, aVar);
        this.f13313j = true;
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setOnTouchListener(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        Surface surface = this.f13312i;
        if (surface != null) {
            Iterator it = this.f13304a.iterator();
            while (it.hasNext()) {
                ((b) it.next()).p(surface);
            }
        }
        g(this.f13311h, surface);
        this.f13311h = null;
        this.f13312i = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.f13311h;
        Surface surface = this.f13312i;
        Surface surface2 = new Surface(surfaceTexture);
        this.f13311h = surfaceTexture;
        this.f13312i = surface2;
        Iterator it = this.f13304a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).q(surface2);
        }
        g(surfaceTexture2, surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final SurfaceTexture surfaceTexture) {
        this.f13308e.post(new Runnable() { // from class: k2.d
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
        boolean z10 = this.f13313j && this.f13314k;
        Sensor sensor = this.f13306c;
        if (sensor == null || z10 == this.f13315l) {
            return;
        }
        if (z10) {
            this.f13305b.registerListener(this.f13307d, sensor, 0);
        } else {
            this.f13305b.unregisterListener(this.f13307d);
        }
        this.f13315l = z10;
    }

    public void addVideoSurfaceListener(b bVar) {
        this.f13304a.add(bVar);
    }

    public k2.a getCameraMotionListener() {
        return this.f13310g;
    }

    public t getVideoFrameMetadataListener() {
        return this.f13310g;
    }

    @Nullable
    public Surface getVideoSurface() {
        return this.f13312i;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f13308e.post(new Runnable() { // from class: k2.c
            @Override // java.lang.Runnable
            public final void run() {
                SphericalGLSurfaceView.this.d();
            }
        });
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.f13314k = false;
        h();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.f13314k = true;
        h();
    }

    public void removeVideoSurfaceListener(b bVar) {
        this.f13304a.remove(bVar);
    }

    public void setDefaultStereoMode(int i11) {
        this.f13310g.h(i11);
    }

    public void setUseSensorRotation(boolean z10) {
        this.f13313j = z10;
        h();
    }
}
