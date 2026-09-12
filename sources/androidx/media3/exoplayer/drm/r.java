package androidx.media3.exoplayer.drm;

import android.os.Handler;
import androidx.media3.common.util.a1;
import androidx.media3.exoplayer.drm.r;
import androidx.media3.exoplayer.source.r;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public interface r {

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f11689a;

        /* renamed from: b, reason: collision with root package name */
        public final r.b f11690b;

        /* renamed from: c, reason: collision with root package name */
        private final CopyOnWriteArrayList f11691c;

        /* renamed from: androidx.media3.exoplayer.drm.r$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static final class C0104a {

            /* renamed from: a, reason: collision with root package name */
            public Handler f11692a;

            /* renamed from: b, reason: collision with root package name */
            public r f11693b;

            public C0104a(Handler handler, r rVar) {
                this.f11692a = handler;
                this.f11693b = rVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        private a(CopyOnWriteArrayList copyOnWriteArrayList, int i11, r.b bVar) {
            this.f11691c = copyOnWriteArrayList;
            this.f11689a = i11;
            this.f11690b = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(r rVar) {
            rVar.q(this.f11689a, this.f11690b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(r rVar) {
            rVar.w(this.f11689a, this.f11690b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(r rVar) {
            rVar.A(this.f11689a, this.f11690b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(r rVar, int i11) {
            rVar.r(this.f11689a, this.f11690b, i11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(r rVar, Exception exc) {
            rVar.x(this.f11689a, this.f11690b, exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(r rVar) {
            rVar.G(this.f11689a, this.f11690b);
        }

        public void g(Handler handler, r rVar) {
            androidx.media3.common.util.a.e(handler);
            androidx.media3.common.util.a.e(rVar);
            this.f11691c.add(new C0104a(handler, rVar));
        }

        public void h() {
            Iterator it = this.f11691c.iterator();
            while (it.hasNext()) {
                C0104a c0104a = (C0104a) it.next();
                final r rVar = c0104a.f11693b;
                a1.b1(c0104a.f11692a, new Runnable() { // from class: androidx.media3.exoplayer.drm.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        r.a.this.n(rVar);
                    }
                });
            }
        }

        public void i() {
            Iterator it = this.f11691c.iterator();
            while (it.hasNext()) {
                C0104a c0104a = (C0104a) it.next();
                final r rVar = c0104a.f11693b;
                a1.b1(c0104a.f11692a, new Runnable() { // from class: androidx.media3.exoplayer.drm.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        r.a.this.o(rVar);
                    }
                });
            }
        }

        public void j() {
            Iterator it = this.f11691c.iterator();
            while (it.hasNext()) {
                C0104a c0104a = (C0104a) it.next();
                final r rVar = c0104a.f11693b;
                a1.b1(c0104a.f11692a, new Runnable() { // from class: androidx.media3.exoplayer.drm.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        r.a.this.p(rVar);
                    }
                });
            }
        }

        public void k(final int i11) {
            Iterator it = this.f11691c.iterator();
            while (it.hasNext()) {
                C0104a c0104a = (C0104a) it.next();
                final r rVar = c0104a.f11693b;
                a1.b1(c0104a.f11692a, new Runnable() { // from class: androidx.media3.exoplayer.drm.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        r.a.this.q(rVar, i11);
                    }
                });
            }
        }

        public void l(final Exception exc) {
            Iterator it = this.f11691c.iterator();
            while (it.hasNext()) {
                C0104a c0104a = (C0104a) it.next();
                final r rVar = c0104a.f11693b;
                a1.b1(c0104a.f11692a, new Runnable() { // from class: androidx.media3.exoplayer.drm.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        r.a.this.r(rVar, exc);
                    }
                });
            }
        }

        public void m() {
            Iterator it = this.f11691c.iterator();
            while (it.hasNext()) {
                C0104a c0104a = (C0104a) it.next();
                final r rVar = c0104a.f11693b;
                a1.b1(c0104a.f11692a, new Runnable() { // from class: androidx.media3.exoplayer.drm.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        r.a.this.s(rVar);
                    }
                });
            }
        }

        public void t(r rVar) {
            Iterator it = this.f11691c.iterator();
            while (it.hasNext()) {
                C0104a c0104a = (C0104a) it.next();
                if (c0104a.f11693b == rVar) {
                    this.f11691c.remove(c0104a);
                }
            }
        }

        public a u(int i11, r.b bVar) {
            return new a(this.f11691c, i11, bVar);
        }
    }

    void A(int i11, r.b bVar);

    void G(int i11, r.b bVar);

    void q(int i11, r.b bVar);

    void r(int i11, r.b bVar, int i12);

    void w(int i11, r.b bVar);

    void x(int i11, r.b bVar, Exception exc);
}
