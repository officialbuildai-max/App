package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
class d {

    /* renamed from: e, reason: collision with root package name */
    private static d f29854e;

    /* renamed from: a, reason: collision with root package name */
    private final Object f29855a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final Handler f29856b = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: c, reason: collision with root package name */
    private c f29857c;

    /* renamed from: d, reason: collision with root package name */
    private c f29858d;

    /* loaded from: classes4.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            d.this.d((c) message.obj);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface b {
        void a(int i11);

        void show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        final WeakReference f29860a;

        /* renamed from: b, reason: collision with root package name */
        int f29861b;

        /* renamed from: c, reason: collision with root package name */
        boolean f29862c;

        c(int i11, b bVar) {
            this.f29860a = new WeakReference(bVar);
            this.f29861b = i11;
        }

        boolean a(b bVar) {
            return bVar != null && this.f29860a.get() == bVar;
        }
    }

    private d() {
    }

    private boolean a(c cVar, int i11) {
        b bVar = (b) cVar.f29860a.get();
        if (bVar == null) {
            return false;
        }
        this.f29856b.removeCallbacksAndMessages(cVar);
        bVar.a(i11);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d c() {
        if (f29854e == null) {
            f29854e = new d();
        }
        return f29854e;
    }

    private boolean f(b bVar) {
        c cVar = this.f29857c;
        return cVar != null && cVar.a(bVar);
    }

    private boolean g(b bVar) {
        c cVar = this.f29858d;
        return cVar != null && cVar.a(bVar);
    }

    private void l(c cVar) {
        int i11 = cVar.f29861b;
        if (i11 == -2) {
            return;
        }
        if (i11 <= 0) {
            i11 = i11 == -1 ? 1500 : 2750;
        }
        this.f29856b.removeCallbacksAndMessages(cVar);
        Handler handler = this.f29856b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i11);
    }

    private void n() {
        c cVar = this.f29858d;
        if (cVar != null) {
            this.f29857c = cVar;
            this.f29858d = null;
            b bVar = (b) cVar.f29860a.get();
            if (bVar != null) {
                bVar.show();
            } else {
                this.f29857c = null;
            }
        }
    }

    public void b(b bVar, int i11) {
        synchronized (this.f29855a) {
            try {
                if (f(bVar)) {
                    a(this.f29857c, i11);
                } else if (g(bVar)) {
                    a(this.f29858d, i11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    void d(c cVar) {
        synchronized (this.f29855a) {
            try {
                if (this.f29857c != cVar) {
                    if (this.f29858d == cVar) {
                    }
                }
                a(cVar, 2);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean e(b bVar) {
        boolean z10;
        synchronized (this.f29855a) {
            try {
                z10 = f(bVar) || g(bVar);
            } finally {
            }
        }
        return z10;
    }

    public void h(b bVar) {
        synchronized (this.f29855a) {
            try {
                if (f(bVar)) {
                    this.f29857c = null;
                    if (this.f29858d != null) {
                        n();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void i(b bVar) {
        synchronized (this.f29855a) {
            try {
                if (f(bVar)) {
                    l(this.f29857c);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void j(b bVar) {
        synchronized (this.f29855a) {
            try {
                if (f(bVar)) {
                    c cVar = this.f29857c;
                    if (!cVar.f29862c) {
                        cVar.f29862c = true;
                        this.f29856b.removeCallbacksAndMessages(cVar);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void k(b bVar) {
        synchronized (this.f29855a) {
            try {
                if (f(bVar)) {
                    c cVar = this.f29857c;
                    if (cVar.f29862c) {
                        cVar.f29862c = false;
                        l(cVar);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void m(int i11, b bVar) {
        synchronized (this.f29855a) {
            try {
                if (f(bVar)) {
                    c cVar = this.f29857c;
                    cVar.f29861b = i11;
                    this.f29856b.removeCallbacksAndMessages(cVar);
                    l(this.f29857c);
                    return;
                }
                if (g(bVar)) {
                    this.f29858d.f29861b = i11;
                } else {
                    this.f29858d = new c(i11, bVar);
                }
                c cVar2 = this.f29857c;
                if (cVar2 == null || !a(cVar2, 4)) {
                    this.f29857c = null;
                    n();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
