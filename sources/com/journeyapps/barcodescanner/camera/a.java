package com.journeyapps.barcodescanner.camera;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.journeyapps.barcodescanner.camera.a;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: i, reason: collision with root package name */
    private static final String f34012i = "a";

    /* renamed from: j, reason: collision with root package name */
    private static final Collection f34013j;

    /* renamed from: a, reason: collision with root package name */
    private boolean f34014a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f34015b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f34016c;

    /* renamed from: d, reason: collision with root package name */
    private final Camera f34017d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f34018e;

    /* renamed from: f, reason: collision with root package name */
    private int f34019f = 1;

    /* renamed from: g, reason: collision with root package name */
    private final Handler.Callback f34020g;

    /* renamed from: h, reason: collision with root package name */
    private final Camera.AutoFocusCallback f34021h;

    /* renamed from: com.journeyapps.barcodescanner.camera.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0466a implements Handler.Callback {
        C0466a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != a.this.f34019f) {
                return false;
            }
            a.this.h();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements Camera.AutoFocusCallback {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            a.this.f34015b = false;
            a.this.f();
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z10, Camera camera) {
            a.this.f34018e.post(new Runnable() { // from class: com.journeyapps.barcodescanner.camera.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.this.b();
                }
            });
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        f34013j = arrayList;
        arrayList.add("auto");
        arrayList.add("macro");
    }

    public a(Camera camera, CameraSettings cameraSettings) {
        C0466a c0466a = new C0466a();
        this.f34020g = c0466a;
        this.f34021h = new b();
        this.f34018e = new Handler(c0466a);
        this.f34017d = camera;
        String focusMode = camera.getParameters().getFocusMode();
        boolean z10 = cameraSettings.c() && f34013j.contains(focusMode);
        this.f34016c = z10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Current focus mode '");
        sb2.append(focusMode);
        sb2.append("'; use auto focus? ");
        sb2.append(z10);
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        if (!this.f34014a && !this.f34018e.hasMessages(this.f34019f)) {
            Handler handler = this.f34018e;
            handler.sendMessageDelayed(handler.obtainMessage(this.f34019f), 2000L);
        }
    }

    private void g() {
        this.f34018e.removeMessages(this.f34019f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (!this.f34016c || this.f34014a || this.f34015b) {
            return;
        }
        try {
            this.f34017d.autoFocus(this.f34021h);
            this.f34015b = true;
        } catch (RuntimeException e11) {
            Log.w(f34012i, "Unexpected exception while focusing", e11);
            f();
        }
    }

    public void i() {
        this.f34014a = false;
        h();
    }

    public void j() {
        this.f34014a = true;
        this.f34015b = false;
        g();
        if (this.f34016c) {
            try {
                this.f34017d.cancelAutoFocus();
            } catch (RuntimeException e11) {
                Log.w(f34012i, "Unexpected exception while cancelling focusing", e11);
            }
        }
    }
}
