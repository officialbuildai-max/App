package androidx.media3.exoplayer.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import androidx.media3.common.util.a1;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes2.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private final i f13401a = new i();

    /* renamed from: b, reason: collision with root package name */
    private final b f13402b;

    /* renamed from: c, reason: collision with root package name */
    private final c f13403c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f13404d;

    /* renamed from: e, reason: collision with root package name */
    private Surface f13405e;

    /* renamed from: f, reason: collision with root package name */
    private float f13406f;

    /* renamed from: g, reason: collision with root package name */
    private float f13407g;

    /* renamed from: h, reason: collision with root package name */
    private float f13408h;

    /* renamed from: i, reason: collision with root package name */
    private float f13409i;

    /* renamed from: j, reason: collision with root package name */
    private int f13410j;

    /* renamed from: k, reason: collision with root package name */
    private long f13411k;

    /* renamed from: l, reason: collision with root package name */
    private long f13412l;

    /* renamed from: m, reason: collision with root package name */
    private long f13413m;

    /* renamed from: n, reason: collision with root package name */
    private long f13414n;

    /* renamed from: o, reason: collision with root package name */
    private long f13415o;

    /* renamed from: p, reason: collision with root package name */
    private long f13416p;

    /* renamed from: q, reason: collision with root package name */
    private long f13417q;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {
        public static void a(Surface surface, float f11) {
            try {
                surface.setFrameRate(f11, f11 == 0.0f ? 0 : 1);
            } catch (IllegalStateException e11) {
                androidx.media3.common.util.u.d("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class b implements DisplayManager.DisplayListener {

        /* renamed from: a, reason: collision with root package name */
        private final DisplayManager f13418a;

        public b(DisplayManager displayManager) {
            this.f13418a = displayManager;
        }

        private Display a() {
            return this.f13418a.getDisplay(0);
        }

        public void b() {
            this.f13418a.registerDisplayListener(this, a1.A());
            w.this.p(a());
        }

        public void c() {
            this.f13418a.unregisterDisplayListener(this);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i11) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i11) {
            if (i11 == 0) {
                w.this.p(a());
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i11) {
        }
    }

    /* loaded from: classes2.dex */
    private static final class c implements Choreographer.FrameCallback, Handler.Callback {

        /* renamed from: f, reason: collision with root package name */
        private static final c f13420f = new c();

        /* renamed from: a, reason: collision with root package name */
        public volatile long f13421a = C.TIME_UNSET;

        /* renamed from: b, reason: collision with root package name */
        private final Handler f13422b;

        /* renamed from: c, reason: collision with root package name */
        private final HandlerThread f13423c;

        /* renamed from: d, reason: collision with root package name */
        private Choreographer f13424d;

        /* renamed from: e, reason: collision with root package name */
        private int f13425e;

        private c() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.f13423c = handlerThread;
            handlerThread.start();
            Handler z10 = a1.z(handlerThread.getLooper(), this);
            this.f13422b = z10;
            z10.sendEmptyMessage(1);
        }

        private void b() {
            Choreographer choreographer = this.f13424d;
            if (choreographer != null) {
                int i11 = this.f13425e + 1;
                this.f13425e = i11;
                if (i11 == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
        }

        private void c() {
            try {
                this.f13424d = Choreographer.getInstance();
            } catch (RuntimeException e11) {
                androidx.media3.common.util.u.i("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e11);
            }
        }

        public static c d() {
            return f13420f;
        }

        private void f() {
            Choreographer choreographer = this.f13424d;
            if (choreographer != null) {
                int i11 = this.f13425e - 1;
                this.f13425e = i11;
                if (i11 == 0) {
                    choreographer.removeFrameCallback(this);
                    this.f13421a = C.TIME_UNSET;
                }
            }
        }

        public void a() {
            this.f13422b.sendEmptyMessage(2);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j11) {
            this.f13421a = j11;
            ((Choreographer) androidx.media3.common.util.a.e(this.f13424d)).postFrameCallbackDelayed(this, 500L);
        }

        public void e() {
            this.f13422b.sendEmptyMessage(3);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == 1) {
                c();
                return true;
            }
            if (i11 == 2) {
                b();
                return true;
            }
            if (i11 != 3) {
                return false;
            }
            f();
            return true;
        }
    }

    public w(Context context) {
        b f11 = f(context);
        this.f13402b = f11;
        this.f13403c = f11 != null ? c.d() : null;
        this.f13411k = C.TIME_UNSET;
        this.f13412l = C.TIME_UNSET;
        this.f13406f = -1.0f;
        this.f13409i = 1.0f;
        this.f13410j = 0;
    }

    private static boolean c(long j11, long j12) {
        return Math.abs(j11 - j12) <= 20000000;
    }

    private void d() {
        Surface surface;
        if (a1.f10432a < 30 || (surface = this.f13405e) == null || this.f13410j == Integer.MIN_VALUE || this.f13408h == 0.0f) {
            return;
        }
        this.f13408h = 0.0f;
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

    private b f(Context context) {
        DisplayManager displayManager;
        if (context == null || (displayManager = (DisplayManager) context.getSystemService("display")) == null) {
            return null;
        }
        return new b(displayManager);
    }

    private void n() {
        this.f13413m = 0L;
        this.f13416p = -1L;
        this.f13414n = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / display.getRefreshRate());
            this.f13411k = refreshRate;
            this.f13412l = (refreshRate * 80) / 100;
        } else {
            androidx.media3.common.util.u.h("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            this.f13411k = C.TIME_UNSET;
            this.f13412l = C.TIME_UNSET;
        }
    }

    private void q() {
        if (a1.f10432a < 30 || this.f13405e == null) {
            return;
        }
        float b11 = this.f13401a.e() ? this.f13401a.b() : this.f13406f;
        float f11 = this.f13407g;
        if (b11 == f11) {
            return;
        }
        if (b11 != -1.0f && f11 != -1.0f) {
            if (Math.abs(b11 - this.f13407g) < ((!this.f13401a.e() || this.f13401a.d() < 5000000000L) ? 1.0f : 0.02f)) {
                return;
            }
        } else if (b11 == -1.0f && this.f13401a.c() < 30) {
            return;
        }
        this.f13407g = b11;
        r(false);
    }

    private void r(boolean z10) {
        Surface surface;
        float f11;
        if (a1.f10432a < 30 || (surface = this.f13405e) == null || this.f13410j == Integer.MIN_VALUE) {
            return;
        }
        if (this.f13404d) {
            float f12 = this.f13407g;
            if (f12 != -1.0f) {
                f11 = f12 * this.f13409i;
                if (z10 && this.f13408h == f11) {
                    return;
                }
                this.f13408h = f11;
                a.a(surface, f11);
            }
        }
        f11 = 0.0f;
        if (z10) {
        }
        this.f13408h = f11;
        a.a(surface, f11);
    }

    public long b(long j11) {
        long j12;
        c cVar;
        if (this.f13416p != -1 && this.f13401a.e()) {
            long a11 = this.f13417q + (((float) (this.f13401a.a() * (this.f13413m - this.f13416p))) / this.f13409i);
            if (c(j11, a11)) {
                j12 = a11;
                this.f13414n = this.f13413m;
                this.f13415o = j12;
                cVar = this.f13403c;
                if (cVar != null || this.f13411k == C.TIME_UNSET) {
                    return j12;
                }
                long j13 = cVar.f13421a;
                return j13 == C.TIME_UNSET ? j12 : e(j12, j13, this.f13411k) - this.f13412l;
            }
            n();
        }
        j12 = j11;
        this.f13414n = this.f13413m;
        this.f13415o = j12;
        cVar = this.f13403c;
        if (cVar != null) {
        }
        return j12;
    }

    public void g(float f11) {
        this.f13406f = f11;
        this.f13401a.g();
        q();
    }

    public void h(long j11) {
        long j12 = this.f13414n;
        if (j12 != -1) {
            this.f13416p = j12;
            this.f13417q = this.f13415o;
        }
        this.f13413m++;
        this.f13401a.f(j11 * 1000);
        q();
    }

    public void i(float f11) {
        this.f13409i = f11;
        n();
        r(false);
    }

    public void j() {
        n();
    }

    public void k() {
        this.f13404d = true;
        n();
        if (this.f13402b != null) {
            ((c) androidx.media3.common.util.a.e(this.f13403c)).a();
            this.f13402b.b();
        }
        r(false);
    }

    public void l() {
        this.f13404d = false;
        b bVar = this.f13402b;
        if (bVar != null) {
            bVar.c();
            ((c) androidx.media3.common.util.a.e(this.f13403c)).e();
        }
        d();
    }

    public void m(Surface surface) {
        if (this.f13405e == surface) {
            return;
        }
        d();
        this.f13405e = surface;
        r(true);
    }

    public void o(int i11) {
        if (this.f13410j == i11) {
            return;
        }
        this.f13410j = i11;
        r(true);
    }
}
