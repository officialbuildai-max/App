package androidx.media3.exoplayer;

import android.os.Looper;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes2.dex */
public final class t3 {

    /* renamed from: a, reason: collision with root package name */
    private final b f12994a;

    /* renamed from: b, reason: collision with root package name */
    private final a f12995b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.media3.common.util.i f12996c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.media3.common.e0 f12997d;

    /* renamed from: e, reason: collision with root package name */
    private int f12998e;

    /* renamed from: f, reason: collision with root package name */
    private Object f12999f;

    /* renamed from: g, reason: collision with root package name */
    private Looper f13000g;

    /* renamed from: h, reason: collision with root package name */
    private int f13001h;

    /* renamed from: i, reason: collision with root package name */
    private long f13002i = C.TIME_UNSET;

    /* renamed from: j, reason: collision with root package name */
    private boolean f13003j = true;

    /* renamed from: k, reason: collision with root package name */
    private boolean f13004k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f13005l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f13006m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f13007n;

    /* loaded from: classes2.dex */
    public interface a {
        void e(t3 t3Var);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void handleMessage(int i11, Object obj);
    }

    public t3(a aVar, b bVar, androidx.media3.common.e0 e0Var, int i11, androidx.media3.common.util.i iVar, Looper looper) {
        this.f12995b = aVar;
        this.f12994a = bVar;
        this.f12997d = e0Var;
        this.f13000g = looper;
        this.f12996c = iVar;
        this.f13001h = i11;
    }

    public boolean a() {
        return this.f13003j;
    }

    public Looper b() {
        return this.f13000g;
    }

    public int c() {
        return this.f13001h;
    }

    public Object d() {
        return this.f12999f;
    }

    public long e() {
        return this.f13002i;
    }

    public b f() {
        return this.f12994a;
    }

    public androidx.media3.common.e0 g() {
        return this.f12997d;
    }

    public int h() {
        return this.f12998e;
    }

    public synchronized boolean i() {
        return this.f13007n;
    }

    public synchronized void j(boolean z10) {
        this.f13005l = z10 | this.f13005l;
        this.f13006m = true;
        notifyAll();
    }

    public t3 k() {
        androidx.media3.common.util.a.g(!this.f13004k);
        if (this.f13002i == C.TIME_UNSET) {
            androidx.media3.common.util.a.a(this.f13003j);
        }
        this.f13004k = true;
        this.f12995b.e(this);
        return this;
    }

    public t3 l(Object obj) {
        androidx.media3.common.util.a.g(!this.f13004k);
        this.f12999f = obj;
        return this;
    }

    public t3 m(int i11) {
        androidx.media3.common.util.a.g(!this.f13004k);
        this.f12998e = i11;
        return this;
    }
}
