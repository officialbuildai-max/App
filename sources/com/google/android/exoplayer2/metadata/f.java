package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.h;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.y2;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class f extends h implements Handler.Callback {

    /* renamed from: n, reason: collision with root package name */
    private final c f25476n;

    /* renamed from: o, reason: collision with root package name */
    private final e f25477o;

    /* renamed from: p, reason: collision with root package name */
    private final Handler f25478p;

    /* renamed from: q, reason: collision with root package name */
    private final d f25479q;

    /* renamed from: r, reason: collision with root package name */
    private b f25480r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f25481s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f25482t;

    /* renamed from: u, reason: collision with root package name */
    private long f25483u;

    /* renamed from: v, reason: collision with root package name */
    private long f25484v;

    /* renamed from: w, reason: collision with root package name */
    private Metadata f25485w;

    public f(e eVar, Looper looper) {
        this(eVar, looper, c.f25471a);
    }

    public f(e eVar, Looper looper, c cVar) {
        super(5);
        this.f25477o = (e) com.google.android.exoplayer2.util.a.e(eVar);
        this.f25478p = looper == null ? null : p0.v(looper, this);
        this.f25476n = (c) com.google.android.exoplayer2.util.a.e(cVar);
        this.f25479q = new d();
        this.f25484v = C.TIME_UNSET;
    }

    private void A(Metadata metadata) {
        Handler handler = this.f25478p;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            B(metadata);
        }
    }

    private void B(Metadata metadata) {
        this.f25477o.onMetadata(metadata);
    }

    private boolean C(long j11) {
        boolean z10;
        Metadata metadata = this.f25485w;
        if (metadata == null || this.f25484v > j11) {
            z10 = false;
        } else {
            A(metadata);
            this.f25485w = null;
            this.f25484v = C.TIME_UNSET;
            z10 = true;
        }
        if (this.f25481s && this.f25485w == null) {
            this.f25482t = true;
        }
        return z10;
    }

    private void D() {
        if (this.f25481s || this.f25485w != null) {
            return;
        }
        this.f25479q.b();
        p1 k11 = k();
        int w11 = w(k11, this.f25479q, 0);
        if (w11 != -4) {
            if (w11 == -5) {
                this.f25483u = ((o1) com.google.android.exoplayer2.util.a.e(k11.f25652b)).f25554p;
                return;
            }
            return;
        }
        if (this.f25479q.h()) {
            this.f25481s = true;
            return;
        }
        d dVar = this.f25479q;
        dVar.f25472i = this.f25483u;
        dVar.n();
        Metadata a11 = ((b) p0.j(this.f25480r)).a(this.f25479q);
        if (a11 != null) {
            ArrayList arrayList = new ArrayList(a11.length());
            z(a11, arrayList);
            if (arrayList.isEmpty()) {
                return;
            }
            this.f25485w = new Metadata(arrayList);
            this.f25484v = this.f25479q.f24899e;
        }
    }

    private void z(Metadata metadata, List list) {
        for (int i11 = 0; i11 < metadata.length(); i11++) {
            o1 wrappedMetadataFormat = metadata.get(i11).getWrappedMetadataFormat();
            if (wrappedMetadataFormat == null || !this.f25476n.a(wrappedMetadataFormat)) {
                list.add(metadata.get(i11));
            } else {
                b b11 = this.f25476n.b(wrappedMetadataFormat);
                byte[] bArr = (byte[]) com.google.android.exoplayer2.util.a.e(metadata.get(i11).getWrappedMetadataBytes());
                this.f25479q.b();
                this.f25479q.m(bArr.length);
                ((ByteBuffer) p0.j(this.f25479q.f24897c)).put(bArr);
                this.f25479q.n();
                Metadata a11 = b11.a(this.f25479q);
                if (a11 != null) {
                    z(a11, list);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.z2
    public int a(o1 o1Var) {
        if (this.f25476n.a(o1Var)) {
            return y2.a(o1Var.E == 0 ? 4 : 2);
        }
        return y2.a(0);
    }

    @Override // com.google.android.exoplayer2.x2, com.google.android.exoplayer2.z2
    public String getName() {
        return "MetadataRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        B((Metadata) message.obj);
        return true;
    }

    @Override // com.google.android.exoplayer2.x2
    public boolean isEnded() {
        return this.f25482t;
    }

    @Override // com.google.android.exoplayer2.x2
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.h
    protected void p() {
        this.f25485w = null;
        this.f25484v = C.TIME_UNSET;
        this.f25480r = null;
    }

    @Override // com.google.android.exoplayer2.h
    protected void r(long j11, boolean z10) {
        this.f25485w = null;
        this.f25484v = C.TIME_UNSET;
        this.f25481s = false;
        this.f25482t = false;
    }

    @Override // com.google.android.exoplayer2.x2
    public void render(long j11, long j12) {
        boolean z10 = true;
        while (z10) {
            D();
            z10 = C(j11);
        }
    }

    @Override // com.google.android.exoplayer2.h
    protected void v(o1[] o1VarArr, long j11, long j12) {
        this.f25480r = this.f25476n.b(o1VarArr[0]);
    }
}
