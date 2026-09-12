package androidx.media3.exoplayer.source;

import android.os.Handler;
import androidx.media3.common.util.a1;
import androidx.media3.exoplayer.source.r;
import androidx.media3.exoplayer.source.s;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public interface s {

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f12970a;

        /* renamed from: b, reason: collision with root package name */
        public final r.b f12971b;

        /* renamed from: c, reason: collision with root package name */
        private final CopyOnWriteArrayList f12972c;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: androidx.media3.exoplayer.source.s$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0109a {

            /* renamed from: a, reason: collision with root package name */
            public Handler f12973a;

            /* renamed from: b, reason: collision with root package name */
            public s f12974b;

            public C0109a(Handler handler, s sVar) {
                this.f12973a = handler;
                this.f12974b = sVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        private a(CopyOnWriteArrayList copyOnWriteArrayList, int i11, r.b bVar) {
            this.f12972c = copyOnWriteArrayList;
            this.f12970a = i11;
            this.f12971b = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(g2.j jVar, s sVar) {
            sVar.E(this.f12970a, this.f12971b, jVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(g2.i iVar, g2.j jVar, s sVar) {
            sVar.l(this.f12970a, this.f12971b, iVar, jVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(g2.i iVar, g2.j jVar, s sVar) {
            sVar.C(this.f12970a, this.f12971b, iVar, jVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(g2.i iVar, g2.j jVar, IOException iOException, boolean z10, s sVar) {
            sVar.y(this.f12970a, this.f12971b, iVar, jVar, iOException, z10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(g2.i iVar, g2.j jVar, int i11, s sVar) {
            sVar.F(this.f12970a, this.f12971b, iVar, jVar, i11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(r.b bVar, g2.j jVar, s sVar) {
            sVar.D(this.f12970a, bVar, jVar);
        }

        public void A(final g2.i iVar, final g2.j jVar, final IOException iOException, final boolean z10) {
            i(new androidx.media3.common.util.m() { // from class: g2.o
                @Override // androidx.media3.common.util.m
                public final void accept(Object obj) {
                    s.a.this.p(iVar, jVar, iOException, z10, (androidx.media3.exoplayer.source.s) obj);
                }
            });
        }

        public void B(g2.i iVar, int i11, int i12) {
            C(iVar, i11, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET, i12);
        }

        public void C(g2.i iVar, int i11, int i12, androidx.media3.common.r rVar, int i13, Object obj, long j11, long j12, int i14) {
            D(iVar, new g2.j(i11, i12, rVar, i13, obj, a1.y1(j11), a1.y1(j12)), i14);
        }

        public void D(final g2.i iVar, final g2.j jVar, final int i11) {
            i(new androidx.media3.common.util.m() { // from class: g2.m
                @Override // androidx.media3.common.util.m
                public final void accept(Object obj) {
                    s.a.this.q(iVar, jVar, i11, (androidx.media3.exoplayer.source.s) obj);
                }
            });
        }

        public void E(s sVar) {
            Iterator it = this.f12972c.iterator();
            while (it.hasNext()) {
                C0109a c0109a = (C0109a) it.next();
                if (c0109a.f12974b == sVar) {
                    this.f12972c.remove(c0109a);
                }
            }
        }

        public void F(int i11, long j11, long j12) {
            G(new g2.j(1, i11, null, 3, null, a1.y1(j11), a1.y1(j12)));
        }

        public void G(final g2.j jVar) {
            final r.b bVar = (r.b) androidx.media3.common.util.a.e(this.f12971b);
            i(new androidx.media3.common.util.m() { // from class: g2.s
                @Override // androidx.media3.common.util.m
                public final void accept(Object obj) {
                    s.a.this.r(bVar, jVar, (androidx.media3.exoplayer.source.s) obj);
                }
            });
        }

        public a H(int i11, r.b bVar) {
            return new a(this.f12972c, i11, bVar);
        }

        public void h(Handler handler, s sVar) {
            androidx.media3.common.util.a.e(handler);
            androidx.media3.common.util.a.e(sVar);
            this.f12972c.add(new C0109a(handler, sVar));
        }

        public void i(final androidx.media3.common.util.m mVar) {
            Iterator it = this.f12972c.iterator();
            while (it.hasNext()) {
                C0109a c0109a = (C0109a) it.next();
                final s sVar = c0109a.f12974b;
                a1.b1(c0109a.f12973a, new Runnable() { // from class: g2.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        androidx.media3.common.util.m.this.accept(sVar);
                    }
                });
            }
        }

        public void j(int i11, androidx.media3.common.r rVar, int i12, Object obj, long j11) {
            k(new g2.j(1, i11, rVar, i12, obj, a1.y1(j11), C.TIME_UNSET));
        }

        public void k(final g2.j jVar) {
            i(new androidx.media3.common.util.m() { // from class: g2.r
                @Override // androidx.media3.common.util.m
                public final void accept(Object obj) {
                    s.a.this.m(jVar, (androidx.media3.exoplayer.source.s) obj);
                }
            });
        }

        public void s(g2.i iVar, int i11) {
            t(iVar, i11, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET);
        }

        public void t(g2.i iVar, int i11, int i12, androidx.media3.common.r rVar, int i13, Object obj, long j11, long j12) {
            u(iVar, new g2.j(i11, i12, rVar, i13, obj, a1.y1(j11), a1.y1(j12)));
        }

        public void u(final g2.i iVar, final g2.j jVar) {
            i(new androidx.media3.common.util.m() { // from class: g2.p
                @Override // androidx.media3.common.util.m
                public final void accept(Object obj) {
                    s.a.this.n(iVar, jVar, (androidx.media3.exoplayer.source.s) obj);
                }
            });
        }

        public void v(g2.i iVar, int i11) {
            w(iVar, i11, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET);
        }

        public void w(g2.i iVar, int i11, int i12, androidx.media3.common.r rVar, int i13, Object obj, long j11, long j12) {
            x(iVar, new g2.j(i11, i12, rVar, i13, obj, a1.y1(j11), a1.y1(j12)));
        }

        public void x(final g2.i iVar, final g2.j jVar) {
            i(new androidx.media3.common.util.m() { // from class: g2.n
                @Override // androidx.media3.common.util.m
                public final void accept(Object obj) {
                    s.a.this.o(iVar, jVar, (androidx.media3.exoplayer.source.s) obj);
                }
            });
        }

        public void y(g2.i iVar, int i11, int i12, androidx.media3.common.r rVar, int i13, Object obj, long j11, long j12, IOException iOException, boolean z10) {
            A(iVar, new g2.j(i11, i12, rVar, i13, obj, a1.y1(j11), a1.y1(j12)), iOException, z10);
        }

        public void z(g2.i iVar, int i11, IOException iOException, boolean z10) {
            y(iVar, i11, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET, iOException, z10);
        }
    }

    void C(int i11, r.b bVar, g2.i iVar, g2.j jVar);

    void D(int i11, r.b bVar, g2.j jVar);

    void E(int i11, r.b bVar, g2.j jVar);

    void F(int i11, r.b bVar, g2.i iVar, g2.j jVar, int i12);

    void l(int i11, r.b bVar, g2.i iVar, g2.j jVar);

    void y(int i11, r.b bVar, g2.i iVar, g2.j jVar, IOException iOException, boolean z10);
}
