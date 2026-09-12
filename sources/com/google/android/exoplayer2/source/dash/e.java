package com.google.android.exoplayer2.source.dash;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.upstream.g;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g9.d0;
import g9.e0;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import v9.f;

/* loaded from: classes3.dex */
public final class e implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.b f25935a;

    /* renamed from: b, reason: collision with root package name */
    private final b f25936b;

    /* renamed from: f, reason: collision with root package name */
    private x9.c f25940f;

    /* renamed from: g, reason: collision with root package name */
    private long f25941g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f25942h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f25943i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f25944j;

    /* renamed from: e, reason: collision with root package name */
    private final TreeMap f25939e = new TreeMap();

    /* renamed from: d, reason: collision with root package name */
    private final Handler f25938d = p0.x(this);

    /* renamed from: c, reason: collision with root package name */
    private final com.google.android.exoplayer2.metadata.emsg.a f25937c = new com.google.android.exoplayer2.metadata.emsg.a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f25945a;

        /* renamed from: b, reason: collision with root package name */
        public final long f25946b;

        public a(long j11, long j12) {
            this.f25945a = j11;
            this.f25946b = j12;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(long j11);

        void b();
    }

    /* loaded from: classes3.dex */
    public final class c implements e0 {

        /* renamed from: a, reason: collision with root package name */
        private final a0 f25947a;

        /* renamed from: b, reason: collision with root package name */
        private final p1 f25948b = new p1();

        /* renamed from: c, reason: collision with root package name */
        private final com.google.android.exoplayer2.metadata.d f25949c = new com.google.android.exoplayer2.metadata.d();

        /* renamed from: d, reason: collision with root package name */
        private long f25950d = C.TIME_UNSET;

        c(com.google.android.exoplayer2.upstream.b bVar) {
            this.f25947a = a0.l(bVar);
        }

        private com.google.android.exoplayer2.metadata.d g() {
            this.f25949c.b();
            if (this.f25947a.S(this.f25948b, this.f25949c, 0, false) != -4) {
                return null;
            }
            this.f25949c.n();
            return this.f25949c;
        }

        private void k(long j11, long j12) {
            e.this.f25938d.sendMessage(e.this.f25938d.obtainMessage(1, new a(j11, j12)));
        }

        private void l() {
            while (this.f25947a.K(false)) {
                com.google.android.exoplayer2.metadata.d g11 = g();
                if (g11 != null) {
                    long j11 = g11.f24899e;
                    Metadata a11 = e.this.f25937c.a(g11);
                    if (a11 != null) {
                        EventMessage eventMessage = (EventMessage) a11.get(0);
                        if (e.h(eventMessage.schemeIdUri, eventMessage.value)) {
                            m(j11, eventMessage);
                        }
                    }
                }
            }
            this.f25947a.s();
        }

        private void m(long j11, EventMessage eventMessage) {
            long f11 = e.f(eventMessage);
            if (f11 == C.TIME_UNSET) {
                return;
            }
            k(j11, f11);
        }

        @Override // g9.e0
        public int a(g gVar, int i11, boolean z10, int i12) {
            return this.f25947a.b(gVar, i11, z10);
        }

        @Override // g9.e0
        public /* synthetic */ int b(g gVar, int i11, boolean z10) {
            return d0.a(this, gVar, i11, z10);
        }

        @Override // g9.e0
        public /* synthetic */ void c(com.google.android.exoplayer2.util.d0 d0Var, int i11) {
            d0.b(this, d0Var, i11);
        }

        @Override // g9.e0
        public void d(long j11, int i11, int i12, int i13, e0.a aVar) {
            this.f25947a.d(j11, i11, i12, i13, aVar);
            l();
        }

        @Override // g9.e0
        public void e(o1 o1Var) {
            this.f25947a.e(o1Var);
        }

        @Override // g9.e0
        public void f(com.google.android.exoplayer2.util.d0 d0Var, int i11, int i12) {
            this.f25947a.c(d0Var, i11);
        }

        public boolean h(long j11) {
            return e.this.j(j11);
        }

        public void i(f fVar) {
            long j11 = this.f25950d;
            if (j11 == C.TIME_UNSET || fVar.f77262h > j11) {
                this.f25950d = fVar.f77262h;
            }
            e.this.m(fVar);
        }

        public boolean j(f fVar) {
            long j11 = this.f25950d;
            return e.this.n(j11 != C.TIME_UNSET && j11 < fVar.f77261g);
        }

        public void n() {
            this.f25947a.T();
        }
    }

    public e(x9.c cVar, b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        this.f25940f = cVar;
        this.f25936b = bVar;
        this.f25935a = bVar2;
    }

    private Map.Entry e(long j11) {
        return this.f25939e.ceilingEntry(Long.valueOf(j11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long f(EventMessage eventMessage) {
        try {
            return p0.I0(p0.D(eventMessage.messageData));
        } catch (ParserException unused) {
            return C.TIME_UNSET;
        }
    }

    private void g(long j11, long j12) {
        Long l11 = (Long) this.f25939e.get(Long.valueOf(j12));
        if (l11 == null) {
            this.f25939e.put(Long.valueOf(j12), Long.valueOf(j11));
        } else if (l11.longValue() > j11) {
            this.f25939e.put(Long.valueOf(j12), Long.valueOf(j11));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean h(String str, String str2) {
        return "urn:mpeg:dash:event:2012".equals(str) && ("1".equals(str2) || "2".equals(str2) || "3".equals(str2));
    }

    private void i() {
        if (this.f25942h) {
            this.f25943i = true;
            this.f25942h = false;
            this.f25936b.b();
        }
    }

    private void l() {
        this.f25936b.a(this.f25941g);
    }

    private void p() {
        Iterator it = this.f25939e.entrySet().iterator();
        while (it.hasNext()) {
            if (((Long) ((Map.Entry) it.next()).getKey()).longValue() < this.f25940f.f78191h) {
                it.remove();
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.f25944j) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        a aVar = (a) message.obj;
        g(aVar.f25945a, aVar.f25946b);
        return true;
    }

    boolean j(long j11) {
        x9.c cVar = this.f25940f;
        boolean z10 = false;
        if (!cVar.f78187d) {
            return false;
        }
        if (this.f25943i) {
            return true;
        }
        Map.Entry e11 = e(cVar.f78191h);
        if (e11 != null && ((Long) e11.getValue()).longValue() < j11) {
            this.f25941g = ((Long) e11.getKey()).longValue();
            l();
            z10 = true;
        }
        if (z10) {
            i();
        }
        return z10;
    }

    public c k() {
        return new c(this.f25935a);
    }

    void m(f fVar) {
        this.f25942h = true;
    }

    boolean n(boolean z10) {
        if (!this.f25940f.f78187d) {
            return false;
        }
        if (this.f25943i) {
            return true;
        }
        if (!z10) {
            return false;
        }
        i();
        return true;
    }

    public void o() {
        this.f25944j = true;
        this.f25938d.removeCallbacksAndMessages(null);
    }

    public void q(x9.c cVar) {
        this.f25943i = false;
        this.f25941g = C.TIME_UNSET;
        this.f25940f = cVar;
        p();
    }
}
