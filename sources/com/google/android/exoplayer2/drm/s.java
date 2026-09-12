package com.google.android.exoplayer2.drm;

import android.os.Handler;
import com.google.android.exoplayer2.drm.s;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.util.p0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public interface s {

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f25066a;

        /* renamed from: b, reason: collision with root package name */
        public final o.b f25067b;

        /* renamed from: c, reason: collision with root package name */
        private final CopyOnWriteArrayList f25068c;

        /* renamed from: com.google.android.exoplayer2.drm.s$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        private static final class C0367a {

            /* renamed from: a, reason: collision with root package name */
            public Handler f25069a;

            /* renamed from: b, reason: collision with root package name */
            public s f25070b;

            public C0367a(Handler handler, s sVar) {
                this.f25069a = handler;
                this.f25070b = sVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        private a(CopyOnWriteArrayList copyOnWriteArrayList, int i11, o.b bVar) {
            this.f25068c = copyOnWriteArrayList;
            this.f25066a = i11;
            this.f25067b = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(s sVar) {
            sVar.B(this.f25066a, this.f25067b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(s sVar) {
            sVar.r(this.f25066a, this.f25067b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(s sVar) {
            sVar.F(this.f25066a, this.f25067b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(s sVar, int i11) {
            sVar.s(this.f25066a, this.f25067b);
            sVar.D(this.f25066a, this.f25067b, i11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(s sVar, Exception exc) {
            sVar.y(this.f25066a, this.f25067b, exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(s sVar) {
            sVar.E(this.f25066a, this.f25067b);
        }

        public void g(Handler handler, s sVar) {
            com.google.android.exoplayer2.util.a.e(handler);
            com.google.android.exoplayer2.util.a.e(sVar);
            this.f25068c.add(new C0367a(handler, sVar));
        }

        public void h() {
            Iterator it = this.f25068c.iterator();
            while (it.hasNext()) {
                C0367a c0367a = (C0367a) it.next();
                final s sVar = c0367a.f25070b;
                p0.K0(c0367a.f25069a, new Runnable() { // from class: com.google.android.exoplayer2.drm.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.a.this.n(sVar);
                    }
                });
            }
        }

        public void i() {
            Iterator it = this.f25068c.iterator();
            while (it.hasNext()) {
                C0367a c0367a = (C0367a) it.next();
                final s sVar = c0367a.f25070b;
                p0.K0(c0367a.f25069a, new Runnable() { // from class: com.google.android.exoplayer2.drm.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.a.this.o(sVar);
                    }
                });
            }
        }

        public void j() {
            Iterator it = this.f25068c.iterator();
            while (it.hasNext()) {
                C0367a c0367a = (C0367a) it.next();
                final s sVar = c0367a.f25070b;
                p0.K0(c0367a.f25069a, new Runnable() { // from class: com.google.android.exoplayer2.drm.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.a.this.p(sVar);
                    }
                });
            }
        }

        public void k(final int i11) {
            Iterator it = this.f25068c.iterator();
            while (it.hasNext()) {
                C0367a c0367a = (C0367a) it.next();
                final s sVar = c0367a.f25070b;
                p0.K0(c0367a.f25069a, new Runnable() { // from class: com.google.android.exoplayer2.drm.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.a.this.q(sVar, i11);
                    }
                });
            }
        }

        public void l(final Exception exc) {
            Iterator it = this.f25068c.iterator();
            while (it.hasNext()) {
                C0367a c0367a = (C0367a) it.next();
                final s sVar = c0367a.f25070b;
                p0.K0(c0367a.f25069a, new Runnable() { // from class: com.google.android.exoplayer2.drm.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.a.this.r(sVar, exc);
                    }
                });
            }
        }

        public void m() {
            Iterator it = this.f25068c.iterator();
            while (it.hasNext()) {
                C0367a c0367a = (C0367a) it.next();
                final s sVar = c0367a.f25070b;
                p0.K0(c0367a.f25069a, new Runnable() { // from class: com.google.android.exoplayer2.drm.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.a.this.s(sVar);
                    }
                });
            }
        }

        public void t(s sVar) {
            Iterator it = this.f25068c.iterator();
            while (it.hasNext()) {
                C0367a c0367a = (C0367a) it.next();
                if (c0367a.f25070b == sVar) {
                    this.f25068c.remove(c0367a);
                }
            }
        }

        public a u(int i11, o.b bVar) {
            return new a(this.f25068c, i11, bVar);
        }
    }

    void B(int i11, o.b bVar);

    void D(int i11, o.b bVar, int i12);

    void E(int i11, o.b bVar);

    void F(int i11, o.b bVar);

    void r(int i11, o.b bVar);

    void s(int i11, o.b bVar);

    void y(int i11, o.b bVar, Exception exc);
}
