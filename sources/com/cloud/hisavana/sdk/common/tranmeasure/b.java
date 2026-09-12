package com.cloud.hisavana.sdk.common.tranmeasure;

import android.os.Handler;
import android.os.Looper;
import com.cloud.hisavana.sdk.common.tranmeasure.f;
import com.cloud.hisavana.sdk.e4;

/* loaded from: classes3.dex */
public class b extends Monitor {

    /* renamed from: a, reason: collision with root package name */
    private volatile Handler f22175a = null;

    /* renamed from: b, reason: collision with root package name */
    private boolean f22176b = false;

    /* renamed from: c, reason: collision with root package name */
    private final f f22177c;

    /* renamed from: d, reason: collision with root package name */
    private final f.a f22178d;

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f22179e;

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f22180f;

    /* loaded from: classes3.dex */
    class a implements f.a {
        a() {
        }

        @Override // com.cloud.hisavana.sdk.common.tranmeasure.f.a
        public void a(boolean z10) {
            if (z10) {
                b.this.a();
            } else {
                b.this.c();
            }
        }
    }

    /* renamed from: com.cloud.hisavana.sdk.common.tranmeasure.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class RunnableC0311b implements Runnable {
        RunnableC0311b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f22176b) {
                e.c().i();
            }
        }
    }

    /* loaded from: classes3.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!b.this.f22176b || b.this.f22175a == null) {
                return;
            }
            b.this.f22175a.post(b.this.f22179e);
            b.this.f22175a.postDelayed(b.this.f22180f, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        a aVar = new a();
        this.f22178d = aVar;
        this.f22179e = new RunnableC0311b();
        this.f22180f = new c();
        f fVar = new f();
        this.f22177c = fVar;
        fVar.c(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            if (Looper.myLooper() == null) {
                return;
            }
            this.f22176b = true;
            if (this.f22175a == null) {
                this.f22175a = new Handler(Looper.myLooper());
            }
            if (this.f22175a != null) {
                this.f22175a.post(this.f22179e);
                this.f22175a.postDelayed(this.f22180f, 200L);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f22176b = false;
        if (this.f22175a != null) {
            this.f22175a.removeCallbacks(this.f22180f);
            this.f22175a = null;
        }
    }

    @Override // com.cloud.hisavana.sdk.common.tranmeasure.Monitor
    public void end() {
        try {
            e4.b().d("ssp_measure", "stop monitor");
            this.f22176b = false;
            f fVar = this.f22177c;
            if (fVar != null) {
                fVar.b();
            }
            c();
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.hisavana.sdk.common.tranmeasure.Monitor
    public void start() {
        if (this.f22176b && this.f22175a != null && this.f22175a.hasMessages(0)) {
            e4.b().d("ssp_measure", "monitor is running");
            return;
        }
        e4.b().d("ssp_measure", "start monitor");
        a();
        this.f22177c.c(this.f22178d);
        this.f22177c.h();
    }
}
