package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import com.google.zxing.client.android.R$id;
import com.google.zxing.client.android.R$styleable;
import com.journeyapps.barcodescanner.CameraPreview;
import com.journeyapps.barcodescanner.camera.CameraInstance;
import com.journeyapps.barcodescanner.camera.CameraSettings;
import com.journeyapps.barcodescanner.camera.PreviewScalingStrategy;
import com.journeyapps.barcodescanner.camera.i;
import com.journeyapps.barcodescanner.camera.j;
import com.journeyapps.barcodescanner.camera.l;
import com.journeyapps.barcodescanner.camera.m;
import com.journeyapps.barcodescanner.camera.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xe.o;
import xe.p;
import xe.q;
import xe.s;

/* loaded from: classes4.dex */
public class CameraPreview extends ViewGroup {
    private static final String A = "CameraPreview";

    /* renamed from: a, reason: collision with root package name */
    private CameraInstance f33932a;

    /* renamed from: b, reason: collision with root package name */
    private WindowManager f33933b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f33934c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f33935d;

    /* renamed from: e, reason: collision with root package name */
    private SurfaceView f33936e;

    /* renamed from: f, reason: collision with root package name */
    private TextureView f33937f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f33938g;

    /* renamed from: h, reason: collision with root package name */
    private p f33939h;

    /* renamed from: i, reason: collision with root package name */
    private int f33940i;

    /* renamed from: j, reason: collision with root package name */
    private List f33941j;

    /* renamed from: k, reason: collision with root package name */
    private m f33942k;

    /* renamed from: l, reason: collision with root package name */
    private CameraSettings f33943l;

    /* renamed from: m, reason: collision with root package name */
    private q f33944m;

    /* renamed from: n, reason: collision with root package name */
    private q f33945n;

    /* renamed from: o, reason: collision with root package name */
    private Rect f33946o;

    /* renamed from: p, reason: collision with root package name */
    private q f33947p;

    /* renamed from: q, reason: collision with root package name */
    private Rect f33948q;

    /* renamed from: r, reason: collision with root package name */
    private Rect f33949r;

    /* renamed from: s, reason: collision with root package name */
    private q f33950s;

    /* renamed from: t, reason: collision with root package name */
    private double f33951t;

    /* renamed from: u, reason: collision with root package name */
    private PreviewScalingStrategy f33952u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f33953v;

    /* renamed from: w, reason: collision with root package name */
    private final SurfaceHolder.Callback f33954w;

    /* renamed from: x, reason: collision with root package name */
    private final Handler.Callback f33955x;

    /* renamed from: y, reason: collision with root package name */
    private o f33956y;

    /* renamed from: z, reason: collision with root package name */
    private final f f33957z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements TextureView.SurfaceTextureListener {
        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
            onSurfaceTextureSizeChanged(surfaceTexture, i11, i12);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
            CameraPreview.this.f33947p = new q(i11, i12);
            CameraPreview.this.w();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* loaded from: classes4.dex */
    class b implements SurfaceHolder.Callback {
        b() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
            if (surfaceHolder == null) {
                Log.e(CameraPreview.A, "*** WARNING *** surfaceChanged() gave us a null surface!");
                return;
            }
            CameraPreview.this.f33947p = new q(i12, i13);
            CameraPreview.this.w();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            CameraPreview.this.f33947p = null;
        }
    }

    /* loaded from: classes4.dex */
    class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == R$id.zxing_prewiew_size_ready) {
                CameraPreview.this.r((q) message.obj);
                return true;
            }
            if (i11 != R$id.zxing_camera_error) {
                if (i11 != R$id.zxing_camera_closed) {
                    return false;
                }
                CameraPreview.this.f33957z.b();
                return false;
            }
            Exception exc = (Exception) message.obj;
            if (!CameraPreview.this.q()) {
                return false;
            }
            CameraPreview.this.pause();
            CameraPreview.this.f33957z.c(exc);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements o {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            CameraPreview.this.t();
        }

        @Override // xe.o
        public void a(int i11) {
            CameraPreview.this.f33934c.postDelayed(new Runnable() { // from class: com.journeyapps.barcodescanner.a
                @Override // java.lang.Runnable
                public final void run() {
                    CameraPreview.d.this.c();
                }
            }, 250L);
        }
    }

    /* loaded from: classes4.dex */
    class e implements f {
        e() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void a() {
            Iterator it = CameraPreview.this.f33941j.iterator();
            while (it.hasNext()) {
                ((f) it.next()).a();
            }
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void b() {
            Iterator it = CameraPreview.this.f33941j.iterator();
            while (it.hasNext()) {
                ((f) it.next()).b();
            }
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void c(Exception exc) {
            Iterator it = CameraPreview.this.f33941j.iterator();
            while (it.hasNext()) {
                ((f) it.next()).c(exc);
            }
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void d() {
            Iterator it = CameraPreview.this.f33941j.iterator();
            while (it.hasNext()) {
                ((f) it.next()).d();
            }
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void e() {
            Iterator it = CameraPreview.this.f33941j.iterator();
            while (it.hasNext()) {
                ((f) it.next()).e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a();

        void b();

        void c(Exception exc);

        void d();

        void e();
    }

    public CameraPreview(Context context) {
        super(context);
        this.f33935d = false;
        this.f33938g = false;
        this.f33940i = -1;
        this.f33941j = new ArrayList();
        this.f33943l = new CameraSettings();
        this.f33948q = null;
        this.f33949r = null;
        this.f33950s = null;
        this.f33951t = 0.1d;
        this.f33952u = null;
        this.f33953v = false;
        this.f33954w = new b();
        this.f33955x = new c();
        this.f33956y = new d();
        this.f33957z = new e();
        o(context, null, 0, 0);
    }

    public CameraPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33935d = false;
        this.f33938g = false;
        this.f33940i = -1;
        this.f33941j = new ArrayList();
        this.f33943l = new CameraSettings();
        this.f33948q = null;
        this.f33949r = null;
        this.f33950s = null;
        this.f33951t = 0.1d;
        this.f33952u = null;
        this.f33953v = false;
        this.f33954w = new b();
        this.f33955x = new c();
        this.f33956y = new d();
        this.f33957z = new e();
        o(context, attributeSet, 0, 0);
    }

    public CameraPreview(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f33935d = false;
        this.f33938g = false;
        this.f33940i = -1;
        this.f33941j = new ArrayList();
        this.f33943l = new CameraSettings();
        this.f33948q = null;
        this.f33949r = null;
        this.f33950s = null;
        this.f33951t = 0.1d;
        this.f33952u = null;
        this.f33953v = false;
        this.f33954w = new b();
        this.f33955x = new c();
        this.f33956y = new d();
        this.f33957z = new e();
        o(context, attributeSet, i11, 0);
    }

    private int getDisplayRotation() {
        return this.f33933b.getDefaultDisplay().getRotation();
    }

    private void i() {
        q qVar;
        m mVar;
        q qVar2 = this.f33944m;
        if (qVar2 == null || (qVar = this.f33945n) == null || (mVar = this.f33942k) == null) {
            this.f33949r = null;
            this.f33948q = null;
            this.f33946o = null;
            throw new IllegalStateException("containerSize or previewSize is not set yet");
        }
        int i11 = qVar.f78357a;
        int i12 = qVar.f78358b;
        int i13 = qVar2.f78357a;
        int i14 = qVar2.f78358b;
        Rect d11 = mVar.d(qVar);
        if (d11.width() <= 0 || d11.height() <= 0) {
            return;
        }
        this.f33946o = d11;
        this.f33948q = j(new Rect(0, 0, i13, i14), this.f33946o);
        Rect rect = new Rect(this.f33948q);
        Rect rect2 = this.f33946o;
        rect.offset(-rect2.left, -rect2.top);
        Rect rect3 = new Rect((rect.left * i11) / this.f33946o.width(), (rect.top * i12) / this.f33946o.height(), (rect.right * i11) / this.f33946o.width(), (rect.bottom * i12) / this.f33946o.height());
        this.f33949r = rect3;
        if (rect3.width() > 0 && this.f33949r.height() > 0) {
            this.f33957z.a();
            return;
        }
        this.f33949r = null;
        this.f33948q = null;
        Log.w(A, "Preview frame is too small");
    }

    private void l(q qVar) {
        this.f33944m = qVar;
        CameraInstance cameraInstance = this.f33932a;
        if (cameraInstance == null || cameraInstance.p() != null) {
            return;
        }
        m mVar = new m(getDisplayRotation(), qVar);
        this.f33942k = mVar;
        mVar.e(getPreviewScalingStrategy());
        this.f33932a.A(this.f33942k);
        this.f33932a.o();
        boolean z10 = this.f33953v;
        if (z10) {
            this.f33932a.D(z10);
        }
    }

    private void n() {
        if (this.f33932a != null) {
            Log.w(A, "initCamera called twice");
            return;
        }
        CameraInstance m11 = m();
        this.f33932a = m11;
        m11.B(this.f33934c);
        this.f33932a.x();
        this.f33940i = getDisplayRotation();
    }

    private void o(Context context, AttributeSet attributeSet, int i11, int i12) {
        if (getBackground() == null) {
            setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        p(attributeSet);
        this.f33933b = (WindowManager) context.getSystemService("window");
        this.f33934c = new Handler(this.f33955x);
        this.f33939h = new p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(q qVar) {
        this.f33945n = qVar;
        if (this.f33944m != null) {
            i();
            requestLayout();
            w();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (!q() || getDisplayRotation() == this.f33940i) {
            return;
        }
        pause();
        resume();
    }

    private void u() {
        if (this.f33935d) {
            TextureView textureView = new TextureView(getContext());
            this.f33937f = textureView;
            textureView.setSurfaceTextureListener(x());
            addView(this.f33937f);
            return;
        }
        SurfaceView surfaceView = new SurfaceView(getContext());
        this.f33936e = surfaceView;
        surfaceView.getHolder().addCallback(this.f33954w);
        addView(this.f33936e);
    }

    private void v(j jVar) {
        if (this.f33938g || this.f33932a == null) {
            return;
        }
        this.f33932a.C(jVar);
        this.f33932a.E();
        this.f33938g = true;
        s();
        this.f33957z.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        Rect rect;
        q qVar = this.f33947p;
        if (qVar == null || this.f33945n == null || (rect = this.f33946o) == null) {
            return;
        }
        if (this.f33936e != null && qVar.equals(new q(rect.width(), this.f33946o.height()))) {
            v(new j(this.f33936e.getHolder()));
            return;
        }
        TextureView textureView = this.f33937f;
        if (textureView == null || textureView.getSurfaceTexture() == null) {
            return;
        }
        if (this.f33945n != null) {
            this.f33937f.setTransform(k(new q(this.f33937f.getWidth(), this.f33937f.getHeight()), this.f33945n));
        }
        v(new j(this.f33937f.getSurfaceTexture()));
    }

    private TextureView.SurfaceTextureListener x() {
        return new a();
    }

    public void addStateListener(f fVar) {
        this.f33941j.add(fVar);
    }

    public void changeCameraParameters(i iVar) {
        CameraInstance cameraInstance = this.f33932a;
        if (cameraInstance != null) {
            cameraInstance.m(iVar);
        }
    }

    public CameraInstance getCameraInstance() {
        return this.f33932a;
    }

    public CameraSettings getCameraSettings() {
        return this.f33943l;
    }

    public Rect getFramingRect() {
        return this.f33948q;
    }

    public q getFramingRectSize() {
        return this.f33950s;
    }

    public double getMarginFraction() {
        return this.f33951t;
    }

    public Rect getPreviewFramingRect() {
        return this.f33949r;
    }

    public PreviewScalingStrategy getPreviewScalingStrategy() {
        PreviewScalingStrategy previewScalingStrategy = this.f33952u;
        return previewScalingStrategy != null ? previewScalingStrategy : this.f33937f != null ? new l() : new n();
    }

    public q getPreviewSize() {
        return this.f33945n;
    }

    public boolean isCameraClosed() {
        CameraInstance cameraInstance = this.f33932a;
        return cameraInstance == null || cameraInstance.r();
    }

    public boolean isPreviewActive() {
        return this.f33938g;
    }

    public boolean isUseTextureView() {
        return this.f33935d;
    }

    protected Rect j(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        if (this.f33950s != null) {
            rect3.inset(Math.max(0, (rect3.width() - this.f33950s.f78357a) / 2), Math.max(0, (rect3.height() - this.f33950s.f78358b) / 2));
            return rect3;
        }
        int min = (int) Math.min(rect3.width() * this.f33951t, rect3.height() * this.f33951t);
        rect3.inset(min, min);
        if (rect3.height() > rect3.width()) {
            rect3.inset(0, (rect3.height() - rect3.width()) / 2);
        }
        return rect3;
    }

    protected Matrix k(q qVar, q qVar2) {
        float f11;
        float f12 = qVar.f78357a / qVar.f78358b;
        float f13 = qVar2.f78357a / qVar2.f78358b;
        float f14 = 1.0f;
        if (f12 < f13) {
            float f15 = f13 / f12;
            f11 = 1.0f;
            f14 = f15;
        } else {
            f11 = f12 / f13;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f14, f11);
        int i11 = qVar.f78357a;
        int i12 = qVar.f78358b;
        matrix.postTranslate((i11 - (i11 * f14)) / 2.0f, (i12 - (i12 * f11)) / 2.0f);
        return matrix;
    }

    protected CameraInstance m() {
        CameraInstance cameraInstance = new CameraInstance(getContext());
        cameraInstance.z(this.f33943l);
        return cameraInstance;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        u();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        l(new q(i13 - i11, i14 - i12));
        SurfaceView surfaceView = this.f33936e;
        if (surfaceView == null) {
            TextureView textureView = this.f33937f;
            if (textureView != null) {
                textureView.layout(0, 0, getWidth(), getHeight());
                return;
            }
            return;
        }
        Rect rect = this.f33946o;
        if (rect == null) {
            surfaceView.layout(0, 0, getWidth(), getHeight());
        } else {
            surfaceView.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("super"));
        setTorch(bundle.getBoolean("torch"));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", onSaveInstanceState);
        bundle.putBoolean("torch", this.f33953v);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.zxing_camera_preview);
        int dimension = (int) obtainStyledAttributes.getDimension(R$styleable.zxing_camera_preview_zxing_framing_rect_width, -1.0f);
        int dimension2 = (int) obtainStyledAttributes.getDimension(R$styleable.zxing_camera_preview_zxing_framing_rect_height, -1.0f);
        if (dimension > 0 && dimension2 > 0) {
            this.f33950s = new q(dimension, dimension2);
        }
        this.f33935d = obtainStyledAttributes.getBoolean(R$styleable.zxing_camera_preview_zxing_use_texture_view, true);
        int integer = obtainStyledAttributes.getInteger(R$styleable.zxing_camera_preview_zxing_preview_scaling_strategy, -1);
        if (integer == 1) {
            this.f33952u = new l();
        } else if (integer == 2) {
            this.f33952u = new n();
        } else if (integer == 3) {
            this.f33952u = new com.journeyapps.barcodescanner.camera.o();
        }
        obtainStyledAttributes.recycle();
    }

    public void pause() {
        TextureView textureView;
        SurfaceView surfaceView;
        s.a();
        this.f33940i = -1;
        CameraInstance cameraInstance = this.f33932a;
        if (cameraInstance != null) {
            cameraInstance.n();
            this.f33932a = null;
            this.f33938g = false;
        } else {
            this.f33934c.sendEmptyMessage(R$id.zxing_camera_closed);
        }
        if (this.f33947p == null && (surfaceView = this.f33936e) != null) {
            surfaceView.getHolder().removeCallback(this.f33954w);
        }
        if (this.f33947p == null && (textureView = this.f33937f) != null) {
            textureView.setSurfaceTextureListener(null);
        }
        this.f33944m = null;
        this.f33945n = null;
        this.f33949r = null;
        this.f33939h.f();
        this.f33957z.d();
    }

    public void pauseAndWait() {
        CameraInstance cameraInstance = getCameraInstance();
        pause();
        long nanoTime = System.nanoTime();
        while (cameraInstance != null && !cameraInstance.r() && System.nanoTime() - nanoTime <= 2000000000) {
            try {
                Thread.sleep(1L);
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    protected boolean q() {
        return this.f33932a != null;
    }

    public void resume() {
        s.a();
        n();
        if (this.f33947p != null) {
            w();
        } else {
            SurfaceView surfaceView = this.f33936e;
            if (surfaceView != null) {
                surfaceView.getHolder().addCallback(this.f33954w);
            } else {
                TextureView textureView = this.f33937f;
                if (textureView != null) {
                    if (textureView.isAvailable()) {
                        x().onSurfaceTextureAvailable(this.f33937f.getSurfaceTexture(), this.f33937f.getWidth(), this.f33937f.getHeight());
                    } else {
                        this.f33937f.setSurfaceTextureListener(x());
                    }
                }
            }
        }
        requestLayout();
        this.f33939h.e(getContext(), this.f33956y);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s() {
    }

    public void setCameraSettings(CameraSettings cameraSettings) {
        this.f33943l = cameraSettings;
    }

    public void setFramingRectSize(q qVar) {
        this.f33950s = qVar;
    }

    public void setMarginFraction(double d11) {
        if (d11 >= 0.5d) {
            throw new IllegalArgumentException("The margin fraction must be less than 0.5");
        }
        this.f33951t = d11;
    }

    public void setPreviewScalingStrategy(PreviewScalingStrategy previewScalingStrategy) {
        this.f33952u = previewScalingStrategy;
    }

    public void setTorch(boolean z10) {
        this.f33953v = z10;
        CameraInstance cameraInstance = this.f33932a;
        if (cameraInstance != null) {
            cameraInstance.D(z10);
        }
    }

    public void setUseTextureView(boolean z10) {
        this.f33935d = z10;
    }
}
