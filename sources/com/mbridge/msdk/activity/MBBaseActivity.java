package com.mbridge.msdk.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.c1;
import com.mbridge.msdk.foundation.tools.o0;

/* loaded from: classes4.dex */
public abstract class MBBaseActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private Display f34083a;

    /* renamed from: b, reason: collision with root package name */
    private OrientationEventListener f34084b;

    /* renamed from: c, reason: collision with root package name */
    private int f34085c = -1;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f34086d = false;

    /* renamed from: e, reason: collision with root package name */
    private Runnable f34087e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                MBBaseActivity.this.b();
            } catch (Exception e11) {
                o0.b("MBBaseActivity", e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends OrientationEventListener {
        b(Context context, int i11) {
            super(context, i11);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i11) {
            int rotation = MBBaseActivity.this.f34083a != null ? MBBaseActivity.this.f34083a.getRotation() : 0;
            if (rotation == 1 && MBBaseActivity.this.f34085c != 1) {
                MBBaseActivity.this.f34085c = 1;
                MBBaseActivity.this.getNotchParams();
                o0.b("MBBaseActivity", "Orientation Left");
                return;
            }
            if (rotation == 3 && MBBaseActivity.this.f34085c != 2) {
                MBBaseActivity.this.f34085c = 2;
                MBBaseActivity.this.getNotchParams();
                o0.b("MBBaseActivity", "Orientation Right");
            } else if (rotation == 0 && MBBaseActivity.this.f34085c != 3) {
                MBBaseActivity.this.f34085c = 3;
                MBBaseActivity.this.getNotchParams();
                o0.b("MBBaseActivity", "Orientation Top");
            } else {
                if (rotation != 2 || MBBaseActivity.this.f34085c == 4) {
                    return;
                }
                MBBaseActivity.this.f34085c = 4;
                MBBaseActivity.this.getNotchParams();
                o0.b("MBBaseActivity", "Orientation Bottom");
            }
        }
    }

    private int a() {
        Display display;
        if (this.f34083a == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                display = getDisplay();
                this.f34083a = display;
            } else {
                this.f34083a = ((WindowManager) getSystemService("window")).getDefaultDisplay();
            }
        }
        Display display2 = this.f34083a;
        if (display2 != null) {
            return display2.getRotation();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        r0 = r1.getDisplayCutout();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b() {
        /*
            r12 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            boolean r1 = r12.f34086d
            if (r1 == 0) goto L7
            return
        L7:
            android.view.Window r1 = r12.getWindow()
            android.view.View r1 = r1.getDecorView()
            android.view.WindowInsets r1 = r1.getRootWindowInsets()
            r2 = -1
            r3 = 0
            if (r1 == 0) goto L8b
            r4 = 28
            if (r0 < r4) goto L8b
            android.view.DisplayCutout r0 = androidx.core.view.z1.a(r1)
            if (r0 == 0) goto L8b
            int r1 = androidx.window.layout.i.a(r0)
            int r4 = androidx.window.layout.g.a(r0)
            int r5 = androidx.window.layout.j.a(r0)
            int r0 = androidx.window.layout.h.a(r0)
            android.view.Display r6 = r12.f34083a
            if (r6 == 0) goto L3a
            int r6 = r6.getRotation()
            goto L3e
        L3a:
            int r6 = r12.a()
        L3e:
            int r7 = r12.f34085c
            r8 = 2
            r9 = 1
            r10 = 3
            if (r7 != r2) goto L70
            if (r6 != 0) goto L49
            r7 = r10
            goto L56
        L49:
            if (r6 != r9) goto L4d
            r7 = r9
            goto L56
        L4d:
            if (r6 != r8) goto L51
            r7 = 4
            goto L56
        L51:
            if (r6 != r10) goto L55
            r7 = r8
            goto L56
        L55:
            r7 = r2
        L56:
            r12.f34085c = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            int r11 = r12.f34085c
            r7.append(r11)
            java.lang.String r11 = ""
            r7.append(r11)
            java.lang.String r7 = r7.toString()
            java.lang.String r11 = "MBBaseActivity"
            com.mbridge.msdk.foundation.tools.o0.b(r11, r7)
        L70:
            if (r6 == 0) goto L87
            if (r6 == r9) goto L84
            if (r6 == r8) goto L81
            if (r6 == r10) goto L7e
        L78:
            r11 = r0
            r8 = r1
            r7 = r2
        L7b:
            r9 = r4
            r10 = r5
            goto L90
        L7e:
            r2 = 270(0x10e, float:3.78E-43)
            goto L78
        L81:
            r2 = 180(0xb4, float:2.52E-43)
            goto L78
        L84:
            r2 = 90
            goto L78
        L87:
            r11 = r0
            r8 = r1
            r7 = r3
            goto L7b
        L8b:
            r7 = r2
            r8 = r3
            r9 = r8
            r10 = r9
            r11 = r10
        L90:
            r6 = r12
            r6.setTopControllerPadding(r7, r8, r9, r10, r11)
            android.view.OrientationEventListener r0 = r12.f34084b
            if (r0 != 0) goto L9b
            r12.d()
        L9b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.activity.MBBaseActivity.b():void");
    }

    private void c() {
        try {
            getWindow().addFlags(67108864);
            getWindow().getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        } catch (Throwable th2) {
            o0.b("MBBaseActivity", th2.getMessage());
        }
    }

    private void d() {
        b bVar = new b(this, 1);
        this.f34084b = bVar;
        if (bVar.canDetectOrientation()) {
            this.f34084b.enable();
        } else {
            this.f34084b.disable();
            this.f34084b = null;
        }
    }

    public void getNotchParams() {
        if (this.f34086d) {
            return;
        }
        this.f34087e = new a();
        getWindow().getDecorView().postDelayed(this.f34087e, 500L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f34086d = false;
        try {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            getWindow().addFlags(512);
            c();
            a();
            c1.a(getWindow());
        } catch (Exception e11) {
            o0.b("MBBaseActivity", e11.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        this.f34086d = true;
        super.onDestroy();
        try {
            OrientationEventListener orientationEventListener = this.f34084b;
            if (orientationEventListener != null) {
                orientationEventListener.disable();
                this.f34084b = null;
            }
            if (this.f34087e != null) {
                getWindow().getDecorView().removeCallbacks(this.f34087e);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("MBBaseActivity", e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (com.mbridge.msdk.foundation.feedback.b.f35343f) {
            return;
        }
        getNotchParams();
        c();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        c();
    }

    public abstract void setTopControllerPadding(int i11, int i12, int i13, int i14, int i15);
}
