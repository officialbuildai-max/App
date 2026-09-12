package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public interface p {

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f26295a;

        /* renamed from: b, reason: collision with root package name */
        public final o.b f26296b;

        /* renamed from: c, reason: collision with root package name */
        private final CopyOnWriteArrayList f26297c;

        /* renamed from: d, reason: collision with root package name */
        private final long f26298d;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.android.exoplayer2.source.p$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0375a {

            /* renamed from: a, reason: collision with root package name */
            public Handler f26299a;

            /* renamed from: b, reason: collision with root package name */
            public p f26300b;

            public C0375a(Handler handler, p pVar) {
                this.f26299a = handler;
                this.f26300b = pVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null, 0L);
        }

        private a(CopyOnWriteArrayList copyOnWriteArrayList, int i11, o.b bVar, long j11) {
            this.f26297c = copyOnWriteArrayList;
            this.f26295a = i11;
            this.f26296b = bVar;
            this.f26298d = j11;
        }

        private long h(long j11) {
            long e12 = p0.e1(j11);
            return e12 == C.TIME_UNSET ? C.TIME_UNSET : this.f26298d + e12;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(p pVar, t9.i iVar) {
            pVar.w(this.f26295a, this.f26296b, iVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(p pVar, t9.h hVar, t9.i iVar) {
            pVar.u(this.f26295a, this.f26296b, hVar, iVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(p pVar, t9.h hVar, t9.i iVar) {
            pVar.z(this.f26295a, this.f26296b, hVar, iVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(p pVar, t9.h hVar, t9.i iVar, IOException iOException, boolean z10) {
            pVar.x(this.f26295a, this.f26296b, hVar, iVar, iOException, z10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(p pVar, t9.h hVar, t9.i iVar) {
            pVar.p(this.f26295a, this.f26296b, hVar, iVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(p pVar, o.b bVar, t9.i iVar) {
            pVar.l(this.f26295a, bVar, iVar);
        }

        public void A(t9.h hVar, int i11, int i12, o1 o1Var, int i13, Object obj, long j11, long j12) {
            B(hVar, new t9.i(i11, i12, o1Var, i13, obj, h(j11), h(j12)));
        }

        public void B(final t9.h hVar, final t9.i iVar) {
            Iterator it = this.f26297c.iterator();
            while (it.hasNext()) {
                C0375a c0375a = (C0375a) it.next();
                final p pVar = c0375a.f26300b;
                p0.K0(c0375a.f26299a, new Runnable() { // from class: t9.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        p.a.this.o(pVar, hVar, iVar);
                    }
                });
            }
        }

        public void C(p pVar) {
            Iterator it = this.f26297c.iterator();
            while (it.hasNext()) {
                C0375a c0375a = (C0375a) it.next();
                if (c0375a.f26300b == pVar) {
                    this.f26297c.remove(c0375a);
                }
            }
        }

        public void D(int i11, long j11, long j12) {
            E(new t9.i(1, i11, null, 3, null, h(j11), h(j12)));
        }

        public void E(final t9.i iVar) {
            final o.b bVar = (o.b) com.google.android.exoplayer2.util.a.e(this.f26296b);
            Iterator it = this.f26297c.iterator();
            while (it.hasNext()) {
                C0375a c0375a = (C0375a) it.next();
                final p pVar = c0375a.f26300b;
                p0.K0(c0375a.f26299a, new Runnable() { // from class: t9.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        p.a.this.p(pVar, bVar, iVar);
                    }
                });
            }
        }

        public a F(int i11, o.b bVar, long j11) {
            return new a(this.f26297c, i11, bVar, j11);
        }

        public void g(Handler handler, p pVar) {
            com.google.android.exoplayer2.util.a.e(handler);
            com.google.android.exoplayer2.util.a.e(pVar);
            this.f26297c.add(new C0375a(handler, pVar));
        }

        public void i(int i11, o1 o1Var, int i12, Object obj, long j11) {
            j(new t9.i(1, i11, o1Var, i12, obj, h(j11), C.TIME_UNSET));
        }

        public void j(final t9.i iVar) {
            Iterator it = this.f26297c.iterator();
            while (it.hasNext()) {
                C0375a c0375a = (C0375a) it.next();
                final p pVar = c0375a.f26300b;
                p0.K0(c0375a.f26299a, new Runnable() { // from class: t9.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        p.a.this.k(pVar, iVar);
                    }
                });
            }
        }

        public void q(t9.h hVar, int i11) {
            r(hVar, i11, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET);
        }

        public void r(t9.h hVar, int i11, int i12, o1 o1Var, int i13, Object obj, long j11, long j12) {
            s(hVar, new t9.i(i11, i12, o1Var, i13, obj, h(j11), h(j12)));
        }

        public void s(final t9.h hVar, final t9.i iVar) {
            Iterator it = this.f26297c.iterator();
            while (it.hasNext()) {
                C0375a c0375a = (C0375a) it.next();
                final p pVar = c0375a.f26300b;
                p0.K0(c0375a.f26299a, new Runnable() { // from class: t9.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        p.a.this.l(pVar, hVar, iVar);
                    }
                });
            }
        }

        public void t(t9.h hVar, int i11) {
            u(hVar, i11, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET);
        }

        public void u(t9.h hVar, int i11, int i12, o1 o1Var, int i13, Object obj, long j11, long j12) {
            v(hVar, new t9.i(i11, i12, o1Var, i13, obj, h(j11), h(j12)));
        }

        public void v(final t9.h hVar, final t9.i iVar) {
            Iterator it = this.f26297c.iterator();
            while (it.hasNext()) {
                C0375a c0375a = (C0375a) it.next();
                final p pVar = c0375a.f26300b;
                p0.K0(c0375a.f26299a, new Runnable() { // from class: t9.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        p.a.this.m(pVar, hVar, iVar);
                    }
                });
            }
        }

        public void w(t9.h hVar, int i11, int i12, o1 o1Var, int i13, Object obj, long j11, long j12, IOException iOException, boolean z10) {
            y(hVar, new t9.i(i11, i12, o1Var, i13, obj, h(j11), h(j12)), iOException, z10);
        }

        public void x(t9.h hVar, int i11, IOException iOException, boolean z10) {
            w(hVar, i11, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET, iOException, z10);
        }

        public void y(final t9.h hVar, final t9.i iVar, final IOException iOException, final boolean z10) {
            Iterator it = this.f26297c.iterator();
            while (it.hasNext()) {
                C0375a c0375a = (C0375a) it.next();
                final p pVar = c0375a.f26300b;
                p0.K0(c0375a.f26299a, new Runnable() { // from class: t9.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        p.a.this.n(pVar, hVar, iVar, iOException, z10);
                    }
                });
            }
        }

        public void z(t9.h hVar, int i11) {
            A(hVar, i11, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET);
        }
    }

    void l(int i11, o.b bVar, t9.i iVar);

    void p(int i11, o.b bVar, t9.h hVar, t9.i iVar);

    void u(int i11, o.b bVar, t9.h hVar, t9.i iVar);

    void w(int i11, o.b bVar, t9.i iVar);

    void x(int i11, o.b bVar, t9.h hVar, t9.i iVar, IOException iOException, boolean z10);

    void z(int i11, o.b bVar, t9.h hVar, t9.i iVar);
}
