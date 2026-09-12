package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.rtsp.c;
import com.google.android.exoplayer2.source.rtsp.p;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.v1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import javax.net.SocketFactory;

/* loaded from: classes3.dex */
public final class RtspMediaSource extends com.google.android.exoplayer2.source.a {

    /* renamed from: h, reason: collision with root package name */
    private final v1 f26341h;

    /* renamed from: i, reason: collision with root package name */
    private final c.a f26342i;

    /* renamed from: j, reason: collision with root package name */
    private final String f26343j;

    /* renamed from: k, reason: collision with root package name */
    private final Uri f26344k;

    /* renamed from: l, reason: collision with root package name */
    private final SocketFactory f26345l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f26346m;

    /* renamed from: o, reason: collision with root package name */
    private boolean f26348o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f26349p;

    /* renamed from: n, reason: collision with root package name */
    private long f26347n = C.TIME_UNSET;

    /* renamed from: q, reason: collision with root package name */
    private boolean f26350q = true;

    /* loaded from: classes3.dex */
    public static final class Factory implements o.a {

        /* renamed from: a, reason: collision with root package name */
        private long f26351a = 8000;

        /* renamed from: b, reason: collision with root package name */
        private String f26352b = "ExoPlayerLib/2.17.1";

        /* renamed from: c, reason: collision with root package name */
        private SocketFactory f26353c = SocketFactory.getDefault();

        /* renamed from: d, reason: collision with root package name */
        private boolean f26354d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f26355e;

        @Override // com.google.android.exoplayer2.source.o.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public RtspMediaSource a(v1 v1Var) {
            com.google.android.exoplayer2.util.a.e(v1Var.f27763b);
            return new RtspMediaSource(v1Var, this.f26354d ? new j0(this.f26351a) : new l0(this.f26351a), this.f26352b, this.f26353c, this.f26355e);
        }

        @Override // com.google.android.exoplayer2.source.o.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Factory b(com.google.android.exoplayer2.drm.x xVar) {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.o.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Factory c(com.google.android.exoplayer2.upstream.z zVar) {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static final class RtspPlaybackException extends IOException {
        public RtspPlaybackException(String str) {
            super(str);
        }

        public RtspPlaybackException(String str, Throwable th2) {
            super(str, th2);
        }

        public RtspPlaybackException(Throwable th2) {
            super(th2);
        }
    }

    /* loaded from: classes3.dex */
    class a implements p.c {
        a() {
        }

        @Override // com.google.android.exoplayer2.source.rtsp.p.c
        public void a() {
            RtspMediaSource.this.f26348o = false;
            RtspMediaSource.this.J();
        }

        @Override // com.google.android.exoplayer2.source.rtsp.p.c
        public void b(d0 d0Var) {
            RtspMediaSource.this.f26347n = p0.B0(d0Var.a());
            RtspMediaSource.this.f26348o = !d0Var.c();
            RtspMediaSource.this.f26349p = d0Var.c();
            RtspMediaSource.this.f26350q = false;
            RtspMediaSource.this.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends com.google.android.exoplayer2.source.j {
        b(RtspMediaSource rtspMediaSource, k3 k3Var) {
            super(k3Var);
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.k3
        public k3.b k(int i11, k3.b bVar, boolean z10) {
            super.k(i11, bVar, z10);
            bVar.f25213f = true;
            return bVar;
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.k3
        public k3.d s(int i11, k3.d dVar, long j11) {
            super.s(i11, dVar, j11);
            dVar.f25234l = true;
            return dVar;
        }
    }

    static {
        m1.a("goog.exo.rtsp");
    }

    RtspMediaSource(v1 v1Var, c.a aVar, String str, SocketFactory socketFactory, boolean z10) {
        this.f26341h = v1Var;
        this.f26342i = aVar;
        this.f26343j = str;
        this.f26344k = ((v1.h) com.google.android.exoplayer2.util.a.e(v1Var.f27763b)).f27826a;
        this.f26345l = socketFactory;
        this.f26346m = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        k3 uVar = new t9.u(this.f26347n, this.f26348o, false, this.f26349p, null, this.f26341h);
        if (this.f26350q) {
            uVar = new b(this, uVar);
        }
        C(uVar);
    }

    @Override // com.google.android.exoplayer2.source.a
    protected void B(com.google.android.exoplayer2.upstream.k0 k0Var) {
        J();
    }

    @Override // com.google.android.exoplayer2.source.a
    protected void D() {
    }

    @Override // com.google.android.exoplayer2.source.o
    public v1 a() {
        return this.f26341h;
    }

    @Override // com.google.android.exoplayer2.source.o
    public com.google.android.exoplayer2.source.n d(o.b bVar, com.google.android.exoplayer2.upstream.b bVar2, long j11) {
        return new p(bVar2, this.f26342i, this.f26344k, new a(), this.f26343j, this.f26345l, this.f26346m);
    }

    @Override // com.google.android.exoplayer2.source.o
    public void k(com.google.android.exoplayer2.source.n nVar) {
        ((p) nVar).M();
    }

    @Override // com.google.android.exoplayer2.source.o
    public void maybeThrowSourceInfoRefreshError() {
    }
}
