package com.google.android.exoplayer2.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.exoplayer2.video.e f27925a = new com.google.android.exoplayer2.video.e();

    /* renamed from: b, reason: collision with root package name */
    private final b f27926b;

    /* renamed from: c, reason: collision with root package name */
    private final e f27927c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f27928d;

    /* renamed from: e, reason: collision with root package name */
    private Surface f27929e;

    /* renamed from: f, reason: collision with root package name */
    private float f27930f;

    /* renamed from: g, reason: collision with root package name */
    private float f27931g;

    /* renamed from: h, reason: collision with root package name */
    private float f27932h;

    /* renamed from: i, reason: collision with root package name */
    private float f27933i;

    /* renamed from: j, reason: collision with root package name */
    private int f27934j;

    /* renamed from: k, reason: collision with root package name */
    private long f27935k;

    /* renamed from: l, reason: collision with root package name */
    private long f27936l;

    /* renamed from: m, reason: collision with root package name */
    private long f27937m;

    /* renamed from: n, reason: collision with root package name */
    private long f27938n;

    /* renamed from: o, reason: collision with root package name */
    private long f27939o;

    /* renamed from: p, reason: collision with root package name */
    private long f27940p;

    /* renamed from: q, reason: collision with root package name */
    private long f27941q;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {
        public static void a(Surface surface, float f11) {
            try {
                surface.setFrameRate(f11, f11 == 0.0f ? 0 : 1);
            } catch (IllegalStateException e11) {
                com.google.android.exoplayer2.util.s.d("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface b {

        /* loaded from: classes3.dex */
        public interface a {
            void a(Display display);
        }

        void a(a aVar);

        void unregister();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class c implements b {

        /* renamed from: a, reason: collision with root package name */
        private final WindowManager f27942a;

        private c(WindowManager windowManager) {
            this.f27942a = windowManager;
        }

        public static b b(Context context) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                return new c(windowManager);
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.video.k.b
        public void a(b.a aVar) {
            aVar.a(this.f27942a.getDefaultDisplay());
        }

        @Override // com.google.android.exoplayer2.video.k.b
        public void unregister() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class d implements b, DisplayManager.DisplayListener {

        /* renamed from: a, reason: collision with root package name */
        private final DisplayManager f27943a;

        /* renamed from: b, reason: collision with root package name */
        private b.a f27944b;

        private d(DisplayManager displayManager) {
            this.f27943a = displayManager;
        }

        private Display b() {
            return this.f27943a.getDisplay(0);
        }

        public static b c(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            if (displayManager != null) {
                return new d(displayManager);
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.video.k.b
        public void a(b.a aVar) {
            this.f27944b = aVar;
            this.f27943a.registerDisplayListener(this, p0.w());
            aVar.a(b());
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i11) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i11) {
            b.a aVar = this.f27944b;
            if (aVar == null || i11 != 0) {
                return;
            }
            aVar.a(b());
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i11) {
        }

        @Override // com.google.android.exoplayer2.video.k.b
        public void unregister() {
            this.f27943a.unregisterDisplayListener(this);
            this.f27944b = null;
        }
    }

    /* loaded from: classes3.dex */
    private static final class e implements Choreographer.FrameCallback, Handler.Callback {

        /* renamed from: f, reason: collision with root package name */
        private static final e f27945f = new e();

        /* renamed from: a, reason: collision with root package name */
        public volatile long f27946a = C.TIME_UNSET;

        /* renamed from: b, reason: collision with root package name */
        private final Handler f27947b;

        /* renamed from: c, reason: collision with root package name */
        private final HandlerThread f27948c;

        /* renamed from: d, reason: collision with root package name */
        private Choreographer f27949d;

        /* renamed from: e, reason: collision with root package name */
        private int f27950e;

        private e() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.f27948c = handlerThread;
            handlerThread.start();
            Handler v11 = p0.v(handlerThread.getLooper(), this);
            this.f27947b = v11;
            v11.sendEmptyMessage(0);
        }

        private void b() {
            Choreographer choreographer = this.f27949d;
            if (choreographer != null) {
                int i11 = this.f27950e + 1;
                this.f27950e = i11;
                if (i11 == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
        }

        private void c() {
            try {
                this.f27949d = Choreographer.getInstance();
            } catch (RuntimeException e11) {
                com.google.android.exoplayer2.util.s.j("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e11);
            }
        }

        public static e d() {
            return f27945f;
        }

        private void f() {
            Choreographer choreographer = this.f27949d;
            if (choreographer != null) {
                int i11 = this.f27950e - 1;
                this.f27950e = i11;
                if (i11 == 0) {
                    choreographer.removeFrameCallback(this);
                    this.f27946a = C.TIME_UNSET;
                }
            }
        }

        public void a() {
            this.f27947b.sendEmptyMessage(1);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j11) {
            this.f27946a = j11;
            ((Choreographer) com.google.android.exoplayer2.util.a.e(this.f27949d)).postFrameCallbackDelayed(this, 500L);
        }

        public void e() {
            this.f27947b.sendEmptyMessage(2);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == 0) {
                c();
                return true;
            }
            if (i11 == 1) {
                b();
                return true;
            }
            if (i11 != 2) {
                return false;
            }
            f();
            return true;
        }
    }

    public k(Context context) {
        b f11 = f(context);
        this.f27926b = f11;
        this.f27927c = f11 != null ? e.d() : null;
        this.f27935k = C.TIME_UNSET;
        this.f27936l = C.TIME_UNSET;
        this.f27930f = -1.0f;
        this.f27933i = 1.0f;
        this.f27934j = 0;
    }

    private static boolean c(long j11, long j12) {
        return Math.abs(j11 - j12) <= 20000000;
    }

    private void d() {
        Surface surface;
        if (p0.f27680a < 30 || (surface = this.f27929e) == null || this.f27934j == Integer.MIN_VALUE || this.f27932h == 0.0f) {
            return;
        }
        this.f27932h = 0.0f;
        a.a(surface, 0.0f);
    }

    private static long e(long j11, long j12, long j13) {
        long j14;
        long j15 = j12 + (((j11 - j12) / j13) * j13);
        if (j11 <= j15) {
            j14 = j15 - j13;
        } else {
            j15 = j13 + j15;
            j14 = j15;
        }
        return j15 - j11 < j11 - j14 ? j15 : j14;
    }

    private static b f(Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        b c11 = p0.f27680a >= 17 ? d.c(applicationContext) : null;
        return c11 == null ? c.b(applicationContext) : c11;
    }

    private void n() {
        this.f27937m = 0L;
        this.f27940p = -1L;
        this.f27938n = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / display.getRefreshRate());
            this.f27935k = refreshRate;
            this.f27936l = (refreshRate * 80) / 100;
        } else {
            com.google.android.exoplayer2.util.s.i("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            this.f27935k = C.TIME_UNSET;
            this.f27936l = C.TIME_UNSET;
        }
    }

    private void q() {
        if (p0.f27680a < 30 || this.f27929e == null) {
            return;
        }
        float b11 = this.f27925a.e() ? this.f27925a.b() : this.f27930f;
        float f11 = this.f27931g;
        if (b11 == f11) {
            return;
        }
        if (b11 != -1.0f && f11 != -1.0f) {
            if (Math.abs(b11 - this.f27931g) < ((!this.f27925a.e() || this.f27925a.d() < 5000000000L) ? 1.0f : 0.02f)) {
                return;
            }
        } else if (b11 == -1.0f && this.f27925a.c() < 30) {
            return;
        }
        this.f27931g = b11;
        r(false);
    }

    private void r(boolean z10) {
        Surface surface;
        float f11;
        if (p0.f27680a < 30 || (surface = this.f27929e) == null || this.f27934j == Integer.MIN_VALUE) {
            return;
        }
        if (this.f27928d) {
            float f12 = this.f27931g;
            if (f12 != -1.0f) {
                f11 = f12 * this.f27933i;
                if (z10 && this.f27932h == f11) {
                    return;
                }
                this.f27932h = f11;
                a.a(surface, f11);
            }
        }
        f11 = 0.0f;
        if (z10) {
        }
        this.f27932h = f11;
        a.a(surface, f11);
    }

    public long b(long j11) {
        long j12;
        e eVar;
        if (this.f27940p != -1 && this.f27925a.e()) {
            long a11 = this.f27941q + (((float) (this.f27925a.a() * (this.f27937m - this.f27940p))) / this.f27933i);
            if (c(j11, a11)) {
                j12 = a11;
                this.f27938n = this.f27937m;
                this.f27939o = j12;
                eVar = this.f27927c;
                if (eVar != null || this.f27935k == C.TIME_UNSET) {
                    return j12;
                }
                long j13 = eVar.f27946a;
                return j13 == C.TIME_UNSET ? j12 : e(j12, j13, this.f27935k) - this.f27936l;
            }
            n();
        }
        j12 = j11;
        this.f27938n = this.f27937m;
        this.f27939o = j12;
        eVar = this.f27927c;
        if (eVar != null) {
        }
        return j12;
    }

    public void g(float f11) {
        this.f27930f = f11;
        this.f27925a.g();
        q();
    }

    public void h(long j11) {
        long j12 = this.f27938n;
        if (j12 != -1) {
            this.f27940p = j12;
            this.f27941q = this.f27939o;
        }
        this.f27937m++;
        this.f27925a.f(j11 * 1000);
        q();
    }

    public void i(float f11) {
        this.f27933i = f11;
        n();
        r(false);
    }

    public void j() {
        n();
    }

    public void k() {
        this.f27928d = true;
        n();
        if (this.f27926b != null) {
            ((e) com.google.android.exoplayer2.util.a.e(this.f27927c)).a();
            this.f27926b.a(new b.a() { // from class: com.google.android.exoplayer2.video.j
                @Override // com.google.android.exoplayer2.video.k.b.a
                public final void a(Display display) {
                    k.this.p(display);
                }
            });
        }
        r(false);
    }

    public void l() {
        this.f27928d = false;
        b bVar = this.f27926b;
        if (bVar != null) {
            bVar.unregister();
            ((e) com.google.android.exoplayer2.util.a.e(this.f27927c)).e();
        }
        d();
    }

    public void m(Surface surface) {
        if (surface instanceof PlaceholderSurface) {
            surface = null;
        }
        if (this.f27929e == surface) {
            return;
        }
        d();
        this.f27929e = surface;
        r(true);
    }

    public void o(int i11) {
        if (this.f27934j == i11) {
            return;
        }
        this.f27934j = i11;
        r(true);
    }
}
