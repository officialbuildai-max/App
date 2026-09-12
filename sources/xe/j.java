package xe;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.zxing.client.android.R$id;
import com.journeyapps.barcodescanner.camera.CameraInstance;

/* loaded from: classes5.dex */
public class j {

    /* renamed from: k, reason: collision with root package name */
    private static final String f78331k = "j";

    /* renamed from: a, reason: collision with root package name */
    private CameraInstance f78332a;

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f78333b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f78334c;

    /* renamed from: d, reason: collision with root package name */
    private g f78335d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f78336e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f78337f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f78338g = false;

    /* renamed from: h, reason: collision with root package name */
    private final Object f78339h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private final Handler.Callback f78340i = new a();

    /* renamed from: j, reason: collision with root package name */
    private final com.journeyapps.barcodescanner.camera.p f78341j = new b();

    /* loaded from: classes5.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == R$id.zxing_decode) {
                j.this.g((r) message.obj);
                return true;
            }
            if (i11 != R$id.zxing_preview_failed) {
                return true;
            }
            j.this.h();
            return true;
        }
    }

    /* loaded from: classes5.dex */
    class b implements com.journeyapps.barcodescanner.camera.p {
        b() {
        }

        @Override // com.journeyapps.barcodescanner.camera.p
        public void a(Exception exc) {
            synchronized (j.this.f78339h) {
                try {
                    if (j.this.f78338g) {
                        j.this.f78334c.obtainMessage(R$id.zxing_preview_failed).sendToTarget();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.journeyapps.barcodescanner.camera.p
        public void b(r rVar) {
            synchronized (j.this.f78339h) {
                try {
                    if (j.this.f78338g) {
                        j.this.f78334c.obtainMessage(R$id.zxing_decode, rVar).sendToTarget();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public j(CameraInstance cameraInstance, g gVar, Handler handler) {
        s.a();
        this.f78332a = cameraInstance;
        this.f78335d = gVar;
        this.f78336e = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(r rVar) {
        long currentTimeMillis = System.currentTimeMillis();
        rVar.d(this.f78337f);
        com.google.zxing.e f11 = f(rVar);
        com.google.zxing.j c11 = f11 != null ? this.f78335d.c(f11) : null;
        if (c11 != null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Found barcode in ");
            sb2.append(currentTimeMillis2 - currentTimeMillis);
            sb2.append(" ms");
            if (this.f78336e != null) {
                Message obtain = Message.obtain(this.f78336e, R$id.zxing_decode_succeeded, new c(c11, rVar));
                obtain.setData(new Bundle());
                obtain.sendToTarget();
            }
        } else {
            Handler handler = this.f78336e;
            if (handler != null) {
                Message.obtain(handler, R$id.zxing_decode_failed).sendToTarget();
            }
        }
        if (this.f78336e != null) {
            Message.obtain(this.f78336e, R$id.zxing_possible_result_points, c.f(this.f78335d.d(), rVar)).sendToTarget();
        }
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f78332a.y(this.f78341j);
    }

    protected com.google.zxing.e f(r rVar) {
        if (this.f78337f == null) {
            return null;
        }
        return rVar.a();
    }

    public void i(Rect rect) {
        this.f78337f = rect;
    }

    public void j(g gVar) {
        this.f78335d = gVar;
    }

    public void k() {
        s.a();
        HandlerThread handlerThread = new HandlerThread(f78331k);
        this.f78333b = handlerThread;
        handlerThread.start();
        this.f78334c = new Handler(this.f78333b.getLooper(), this.f78340i);
        this.f78338g = true;
        h();
    }

    public void l() {
        s.a();
        synchronized (this.f78339h) {
            this.f78338g = false;
            this.f78334c.removeCallbacksAndMessages(null);
            this.f78333b.quit();
        }
    }
}
