package com.journeyapps.barcodescanner.camera;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.google.zxing.client.android.R$id;
import xe.q;
import xe.s;

/* loaded from: classes4.dex */
public class CameraInstance {

    /* renamed from: n, reason: collision with root package name */
    private static final String f33989n = "CameraInstance";

    /* renamed from: a, reason: collision with root package name */
    private k f33990a;

    /* renamed from: b, reason: collision with root package name */
    private j f33991b;

    /* renamed from: c, reason: collision with root package name */
    private h f33992c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f33993d;

    /* renamed from: e, reason: collision with root package name */
    private m f33994e;

    /* renamed from: h, reason: collision with root package name */
    private Handler f33997h;

    /* renamed from: f, reason: collision with root package name */
    private boolean f33995f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f33996g = true;

    /* renamed from: i, reason: collision with root package name */
    private CameraSettings f33998i = new CameraSettings();

    /* renamed from: j, reason: collision with root package name */
    private Runnable f33999j = new Runnable() { // from class: com.journeyapps.barcodescanner.camera.CameraInstance.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                String unused = CameraInstance.f33989n;
                CameraInstance.this.f33992c.m();
            } catch (Exception e11) {
                CameraInstance.this.w(e11);
                Log.e(CameraInstance.f33989n, "Failed to open camera", e11);
            }
        }
    };

    /* renamed from: k, reason: collision with root package name */
    private Runnable f34000k = new Runnable() { // from class: com.journeyapps.barcodescanner.camera.CameraInstance.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                String unused = CameraInstance.f33989n;
                CameraInstance.this.f33992c.f();
                if (CameraInstance.this.f33993d != null) {
                    CameraInstance.this.f33993d.obtainMessage(R$id.zxing_prewiew_size_ready, CameraInstance.this.q()).sendToTarget();
                }
            } catch (Exception e11) {
                CameraInstance.this.w(e11);
                Log.e(CameraInstance.f33989n, "Failed to configure camera", e11);
            }
        }
    };

    /* renamed from: l, reason: collision with root package name */
    private Runnable f34001l = new Runnable() { // from class: com.journeyapps.barcodescanner.camera.CameraInstance.3
        @Override // java.lang.Runnable
        public void run() {
            try {
                String unused = CameraInstance.f33989n;
                CameraInstance.this.f33992c.t(CameraInstance.this.f33991b);
                CameraInstance.this.f33992c.v();
            } catch (Exception e11) {
                CameraInstance.this.w(e11);
                Log.e(CameraInstance.f33989n, "Failed to start preview", e11);
            }
        }
    };

    /* renamed from: m, reason: collision with root package name */
    private Runnable f34002m = new Runnable() { // from class: com.journeyapps.barcodescanner.camera.CameraInstance.4
        @Override // java.lang.Runnable
        public void run() {
            try {
                String unused = CameraInstance.f33989n;
                CameraInstance.this.f33992c.w();
                CameraInstance.this.f33992c.e();
            } catch (Exception e11) {
                Log.e(CameraInstance.f33989n, "Failed to close camera", e11);
            }
            CameraInstance.this.f33996g = true;
            CameraInstance.this.f33993d.sendEmptyMessage(R$id.zxing_camera_closed);
            CameraInstance.this.f33990a.b();
        }
    };

    public CameraInstance(Context context) {
        s.a();
        this.f33990a = k.d();
        h hVar = new h(context);
        this.f33992c = hVar;
        hVar.p(this.f33998i);
        this.f33997h = new Handler();
    }

    private void F() {
        if (!this.f33995f) {
            throw new IllegalStateException("CameraInstance is not open");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public q q() {
        return this.f33992c.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(i iVar) {
        this.f33992c.d(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(p pVar) {
        this.f33992c.n(pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(final p pVar) {
        if (this.f33995f) {
            this.f33990a.c(new Runnable() { // from class: com.journeyapps.barcodescanner.camera.g
                @Override // java.lang.Runnable
                public final void run() {
                    CameraInstance.this.t(pVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(boolean z10) {
        this.f33992c.u(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Exception exc) {
        Handler handler = this.f33993d;
        if (handler != null) {
            handler.obtainMessage(R$id.zxing_camera_error, exc).sendToTarget();
        }
    }

    public void A(m mVar) {
        this.f33994e = mVar;
        this.f33992c.r(mVar);
    }

    public void B(Handler handler) {
        this.f33993d = handler;
    }

    public void C(j jVar) {
        this.f33991b = jVar;
    }

    public void D(final boolean z10) {
        s.a();
        if (this.f33995f) {
            this.f33990a.c(new Runnable() { // from class: com.journeyapps.barcodescanner.camera.e
                @Override // java.lang.Runnable
                public final void run() {
                    CameraInstance.this.v(z10);
                }
            });
        }
    }

    public void E() {
        s.a();
        F();
        this.f33990a.c(this.f34001l);
    }

    public void m(final i iVar) {
        s.a();
        if (this.f33995f) {
            this.f33990a.c(new Runnable(iVar) { // from class: com.journeyapps.barcodescanner.camera.f
                @Override // java.lang.Runnable
                public final void run() {
                    CameraInstance.this.s(null);
                }
            });
        }
    }

    public void n() {
        s.a();
        if (this.f33995f) {
            this.f33990a.c(this.f34002m);
        } else {
            this.f33996g = true;
        }
        this.f33995f = false;
    }

    public void o() {
        s.a();
        F();
        this.f33990a.c(this.f34000k);
    }

    public m p() {
        return this.f33994e;
    }

    public boolean r() {
        return this.f33996g;
    }

    public void x() {
        s.a();
        this.f33995f = true;
        this.f33996g = false;
        this.f33990a.e(this.f33999j);
    }

    public void y(final p pVar) {
        this.f33997h.post(new Runnable() { // from class: com.journeyapps.barcodescanner.camera.d
            @Override // java.lang.Runnable
            public final void run() {
                CameraInstance.this.u(pVar);
            }
        });
    }

    public void z(CameraSettings cameraSettings) {
        if (this.f33995f) {
            return;
        }
        this.f33998i = cameraSettings;
        this.f33992c.p(cameraSettings);
    }
}
