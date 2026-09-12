package androidx.media3.exoplayer.mediacodec;

import android.content.Context;
import androidx.media3.common.util.a1;
import androidx.media3.exoplayer.mediacodec.c;
import androidx.media3.exoplayer.mediacodec.r0;
import androidx.media3.exoplayer.mediacodec.t;

/* loaded from: classes2.dex */
public final class k implements t.b {

    /* renamed from: b, reason: collision with root package name */
    private final Context f12313b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.common.base.q f12314c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.common.base.q f12315d;

    /* renamed from: e, reason: collision with root package name */
    private int f12316e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f12317f;

    @Deprecated
    public k() {
        this.f12316e = 0;
        this.f12317f = false;
        this.f12313b = null;
        this.f12314c = null;
        this.f12315d = null;
    }

    public k(Context context) {
        this(context, null, null);
    }

    public k(Context context, com.google.common.base.q qVar, com.google.common.base.q qVar2) {
        this.f12313b = context;
        this.f12316e = 0;
        this.f12317f = false;
        this.f12314c = qVar;
        this.f12315d = qVar2;
    }

    private boolean c() {
        int i11 = a1.f10432a;
        if (i11 >= 31) {
            return true;
        }
        Context context = this.f12313b;
        return context != null && i11 >= 28 && context.getPackageManager().hasSystemFeature("com.amazon.hardware.tv_screen");
    }

    @Override // androidx.media3.exoplayer.mediacodec.t.b
    public t a(t.a aVar) {
        int i11;
        com.google.common.base.q qVar;
        if (a1.f10432a < 23 || !((i11 = this.f12316e) == 1 || (i11 == 0 && c()))) {
            return new r0.b().a(aVar);
        }
        int k11 = androidx.media3.common.y.k(aVar.f12332c.f10243o);
        androidx.media3.common.util.u.f("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type " + a1.t0(k11));
        com.google.common.base.q qVar2 = this.f12314c;
        c.b bVar = (qVar2 == null || (qVar = this.f12315d) == null) ? new c.b(k11) : new c.b(qVar2, qVar);
        bVar.e(this.f12317f);
        return bVar.a(aVar);
    }

    public k b() {
        this.f12316e = 1;
        return this;
    }
}
