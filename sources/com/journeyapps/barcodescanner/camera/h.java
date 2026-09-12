package com.journeyapps.barcodescanner.camera;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import xe.q;
import xe.r;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: n, reason: collision with root package name */
    private static final String f34033n = "h";

    /* renamed from: a, reason: collision with root package name */
    private Camera f34034a;

    /* renamed from: b, reason: collision with root package name */
    private Camera.CameraInfo f34035b;

    /* renamed from: c, reason: collision with root package name */
    private com.journeyapps.barcodescanner.camera.a f34036c;

    /* renamed from: d, reason: collision with root package name */
    private gd.b f34037d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f34038e;

    /* renamed from: f, reason: collision with root package name */
    private String f34039f;

    /* renamed from: h, reason: collision with root package name */
    private m f34041h;

    /* renamed from: i, reason: collision with root package name */
    private q f34042i;

    /* renamed from: j, reason: collision with root package name */
    private q f34043j;

    /* renamed from: l, reason: collision with root package name */
    private Context f34045l;

    /* renamed from: g, reason: collision with root package name */
    private CameraSettings f34040g = new CameraSettings();

    /* renamed from: k, reason: collision with root package name */
    private int f34044k = -1;

    /* renamed from: m, reason: collision with root package name */
    private final a f34046m = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public final class a implements Camera.PreviewCallback {

        /* renamed from: a, reason: collision with root package name */
        private p f34047a;

        /* renamed from: b, reason: collision with root package name */
        private q f34048b;

        public a() {
        }

        public void a(p pVar) {
            this.f34047a = pVar;
        }

        public void b(q qVar) {
            this.f34048b = qVar;
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            q qVar = this.f34048b;
            p pVar = this.f34047a;
            if (qVar == null || pVar == null) {
                String unused = h.f34033n;
                if (pVar != null) {
                    pVar.a(new Exception("No resolution available"));
                    return;
                }
                return;
            }
            try {
                if (bArr == null) {
                    throw new NullPointerException("No preview data received");
                }
                r rVar = new r(bArr, qVar.f78357a, qVar.f78358b, camera.getParameters().getPreviewFormat(), h.this.g());
                if (h.this.f34035b.facing == 1) {
                    rVar.e(true);
                }
                pVar.b(rVar);
            } catch (RuntimeException e11) {
                Log.e(h.f34033n, "Camera preview failed", e11);
                pVar.a(e11);
            }
        }
    }

    public h(Context context) {
        this.f34045l = context;
    }

    private int c() {
        int c11 = this.f34041h.c();
        int i11 = 0;
        if (c11 != 0) {
            if (c11 == 1) {
                i11 = 90;
            } else if (c11 == 2) {
                i11 = 180;
            } else if (c11 == 3) {
                i11 = 270;
            }
        }
        Camera.CameraInfo cameraInfo = this.f34035b;
        int i12 = cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i11) % 360)) % 360 : ((cameraInfo.orientation - i11) + 360) % 360;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Camera Display Orientation: ");
        sb2.append(i12);
        return i12;
    }

    private Camera.Parameters h() {
        Camera.Parameters parameters = this.f34034a.getParameters();
        String str = this.f34039f;
        if (str == null) {
            this.f34039f = parameters.flatten();
        } else {
            parameters.unflatten(str);
        }
        return parameters;
    }

    private static List j(Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        if (supportedPreviewSizes == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                new q(previewSize.width, previewSize.height);
                arrayList.add(new q(previewSize.width, previewSize.height));
            }
            return arrayList;
        }
        for (Camera.Size size : supportedPreviewSizes) {
            arrayList.add(new q(size.width, size.height));
        }
        return arrayList;
    }

    private void o(int i11) {
        this.f34034a.setDisplayOrientation(i11);
    }

    private void q(boolean z10) {
        Camera.Parameters h11 = h();
        if (h11 == null) {
            Log.w(f34033n, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        String str = f34033n;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Initial camera parameters: ");
        sb2.append(h11.flatten());
        if (z10) {
            Log.w(str, "In camera config safe mode -- most settings will not be honored");
        }
        c.g(h11, this.f34040g.a(), z10);
        if (!z10) {
            c.k(h11, false);
            if (this.f34040g.h()) {
                c.i(h11);
            }
            if (this.f34040g.e()) {
                c.c(h11);
            }
            if (this.f34040g.g()) {
                c.l(h11);
                c.h(h11);
                c.j(h11);
            }
        }
        List j11 = j(h11);
        if (j11.size() == 0) {
            this.f34042i = null;
        } else {
            q a11 = this.f34041h.a(j11, k());
            this.f34042i = a11;
            h11.setPreviewSize(a11.f78357a, a11.f78358b);
        }
        if (Build.DEVICE.equals("glass-1")) {
            c.e(h11);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Final camera parameters: ");
        sb3.append(h11.flatten());
        this.f34034a.setParameters(h11);
    }

    private void s() {
        try {
            int c11 = c();
            this.f34044k = c11;
            o(c11);
        } catch (Exception unused) {
            Log.w(f34033n, "Failed to set rotation.");
        }
        try {
            q(false);
        } catch (Exception unused2) {
            try {
                q(true);
            } catch (Exception unused3) {
                Log.w(f34033n, "Camera rejected even safe-mode parameters! No configuration");
            }
        }
        Camera.Size previewSize = this.f34034a.getParameters().getPreviewSize();
        if (previewSize == null) {
            this.f34043j = this.f34042i;
        } else {
            this.f34043j = new q(previewSize.width, previewSize.height);
        }
        this.f34046m.b(this.f34043j);
    }

    public void d(i iVar) {
        Camera camera = this.f34034a;
        if (camera != null) {
            try {
                camera.setParameters(iVar.a(camera.getParameters()));
            } catch (RuntimeException e11) {
                Log.e(f34033n, "Failed to change camera parameters", e11);
            }
        }
    }

    public void e() {
        Camera camera = this.f34034a;
        if (camera != null) {
            camera.release();
            this.f34034a = null;
        }
    }

    public void f() {
        if (this.f34034a == null) {
            throw new RuntimeException("Camera not open");
        }
        s();
    }

    public int g() {
        return this.f34044k;
    }

    public q i() {
        if (this.f34043j == null) {
            return null;
        }
        return k() ? this.f34043j.d() : this.f34043j;
    }

    public boolean k() {
        int i11 = this.f34044k;
        if (i11 != -1) {
            return i11 % 180 != 0;
        }
        throw new IllegalStateException("Rotation not calculated yet. Call configure() first.");
    }

    public boolean l() {
        String flashMode;
        Camera.Parameters parameters = this.f34034a.getParameters();
        if (parameters == null || (flashMode = parameters.getFlashMode()) == null) {
            return false;
        }
        return "on".equals(flashMode) || "torch".equals(flashMode);
    }

    public void m() {
        Camera b11 = hd.a.b(this.f34040g.b());
        this.f34034a = b11;
        if (b11 == null) {
            throw new RuntimeException("Failed to open camera");
        }
        int a11 = hd.a.a(this.f34040g.b());
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        this.f34035b = cameraInfo;
        Camera.getCameraInfo(a11, cameraInfo);
    }

    public void n(p pVar) {
        Camera camera = this.f34034a;
        if (camera == null || !this.f34038e) {
            return;
        }
        this.f34046m.a(pVar);
        camera.setOneShotPreviewCallback(this.f34046m);
    }

    public void p(CameraSettings cameraSettings) {
        this.f34040g = cameraSettings;
    }

    public void r(m mVar) {
        this.f34041h = mVar;
    }

    public void t(j jVar) {
        jVar.a(this.f34034a);
    }

    public void u(boolean z10) {
        if (this.f34034a != null) {
            try {
                if (z10 != l()) {
                    com.journeyapps.barcodescanner.camera.a aVar = this.f34036c;
                    if (aVar != null) {
                        aVar.j();
                    }
                    Camera.Parameters parameters = this.f34034a.getParameters();
                    c.k(parameters, z10);
                    if (this.f34040g.f()) {
                        c.d(parameters, z10);
                    }
                    this.f34034a.setParameters(parameters);
                    com.journeyapps.barcodescanner.camera.a aVar2 = this.f34036c;
                    if (aVar2 != null) {
                        aVar2.i();
                    }
                }
            } catch (RuntimeException e11) {
                Log.e(f34033n, "Failed to set torch", e11);
            }
        }
    }

    public void v() {
        Camera camera = this.f34034a;
        if (camera == null || this.f34038e) {
            return;
        }
        camera.startPreview();
        this.f34038e = true;
        this.f34036c = new com.journeyapps.barcodescanner.camera.a(this.f34034a, this.f34040g);
        gd.b bVar = new gd.b(this.f34045l, this, this.f34040g);
        this.f34037d = bVar;
        bVar.d();
    }

    public void w() {
        com.journeyapps.barcodescanner.camera.a aVar = this.f34036c;
        if (aVar != null) {
            aVar.j();
            this.f34036c = null;
        }
        gd.b bVar = this.f34037d;
        if (bVar != null) {
            bVar.e();
            this.f34037d = null;
        }
        Camera camera = this.f34034a;
        if (camera == null || !this.f34038e) {
            return;
        }
        camera.stopPreview();
        this.f34046m.a(null);
        this.f34038e = false;
    }
}
