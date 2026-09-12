package com.transsion.postdetail.layer;

import android.os.Handler;
import android.os.HandlerThread;
import com.transsion.postdetail.layer.SystemTimeManager;

/* loaded from: classes6.dex */
public final class SystemTimeManager {

    /* renamed from: a, reason: collision with root package name */
    private Handler f48942a;

    /* renamed from: b, reason: collision with root package name */
    private a f48943b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f48944c;

    /* renamed from: d, reason: collision with root package name */
    private final HandlerThread f48945d;

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f48946e;

    /* loaded from: classes6.dex */
    public interface a {
        long a();
    }

    public SystemTimeManager(a aVar) {
        HandlerThread handlerThread = new HandlerThread("SystemTimeManager");
        this.f48945d = handlerThread;
        this.f48946e = new Runnable() { // from class: com.transsion.postdetail.layer.SystemTimeManager$mTrackingRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                SystemTimeManager.a aVar2;
                SystemTimeManager.a aVar3;
                Handler handler;
                aVar2 = SystemTimeManager.this.f48943b;
                if (aVar2 == null) {
                    SystemTimeManager.this.e();
                    return;
                }
                aVar3 = SystemTimeManager.this.f48943b;
                Long valueOf = aVar3 != null ? Long.valueOf(aVar3.a()) : null;
                if (valueOf != null) {
                    if (valueOf.longValue() <= 0) {
                        SystemTimeManager.this.e();
                        return;
                    }
                    handler = SystemTimeManager.this.f48942a;
                    if (handler != null) {
                        handler.postDelayed(this, valueOf.longValue());
                    }
                }
            }
        };
        handlerThread.start();
        this.f48942a = new Handler(handlerThread.getLooper());
        this.f48943b = aVar;
    }

    public final void c() {
        e();
        this.f48944c = false;
        Handler handler = this.f48942a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f48942a = null;
        this.f48943b = null;
        this.f48945d.quitSafely();
    }

    public final void d() {
        if (this.f48944c) {
            return;
        }
        this.f48944c = true;
        Handler handler = this.f48942a;
        if (handler != null) {
            handler.removeCallbacks(this.f48946e);
        }
        Handler handler2 = this.f48942a;
        if (handler2 != null) {
            handler2.post(this.f48946e);
        }
    }

    public final void e() {
        if (this.f48944c) {
            this.f48944c = false;
            Handler handler = this.f48942a;
            if (handler != null) {
                handler.removeCallbacks(this.f48946e);
            }
        }
    }
}
