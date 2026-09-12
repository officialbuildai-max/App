package com.google.android.exoplayer2;

import android.os.Looper;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public final class s2 {

    /* renamed from: a, reason: collision with root package name */
    private final b f25682a;

    /* renamed from: b, reason: collision with root package name */
    private final a f25683b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.e f25684c;

    /* renamed from: d, reason: collision with root package name */
    private final k3 f25685d;

    /* renamed from: e, reason: collision with root package name */
    private int f25686e;

    /* renamed from: f, reason: collision with root package name */
    private Object f25687f;

    /* renamed from: g, reason: collision with root package name */
    private Looper f25688g;

    /* renamed from: h, reason: collision with root package name */
    private int f25689h;

    /* renamed from: i, reason: collision with root package name */
    private long f25690i = C.TIME_UNSET;

    /* renamed from: j, reason: collision with root package name */
    private boolean f25691j = true;

    /* renamed from: k, reason: collision with root package name */
    private boolean f25692k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f25693l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f25694m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f25695n;

    /* loaded from: classes3.dex */
    public interface a {
        void b(s2 s2Var);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void handleMessage(int i11, Object obj);
    }

    public s2(a aVar, b bVar, k3 k3Var, int i11, com.google.android.exoplayer2.util.e eVar, Looper looper) {
        this.f25683b = aVar;
        this.f25682a = bVar;
        this.f25685d = k3Var;
        this.f25688g = looper;
        this.f25684c = eVar;
        this.f25689h = i11;
    }

    public synchronized boolean a(long j11) {
        boolean z10;
        try {
            com.google.android.exoplayer2.util.a.g(this.f25692k);
            com.google.android.exoplayer2.util.a.g(this.f25688g.getThread() != Thread.currentThread());
            long elapsedRealtime = this.f25684c.elapsedRealtime() + j11;
            while (true) {
                z10 = this.f25694m;
                if (z10 || j11 <= 0) {
                    break;
                }
                this.f25684c.a();
                wait(j11);
                j11 = elapsedRealtime - this.f25684c.elapsedRealtime();
            }
            if (!z10) {
                throw new TimeoutException("Message delivery timed out.");
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f25693l;
    }

    public boolean b() {
        return this.f25691j;
    }

    public Looper c() {
        return this.f25688g;
    }

    public int d() {
        return this.f25689h;
    }

    public Object e() {
        return this.f25687f;
    }

    public long f() {
        return this.f25690i;
    }

    public b g() {
        return this.f25682a;
    }

    public k3 h() {
        return this.f25685d;
    }

    public int i() {
        return this.f25686e;
    }

    public synchronized boolean j() {
        return this.f25695n;
    }

    public synchronized void k(boolean z10) {
        this.f25693l = z10 | this.f25693l;
        this.f25694m = true;
        notifyAll();
    }

    public s2 l() {
        com.google.android.exoplayer2.util.a.g(!this.f25692k);
        if (this.f25690i == C.TIME_UNSET) {
            com.google.android.exoplayer2.util.a.a(this.f25691j);
        }
        this.f25692k = true;
        this.f25683b.b(this);
        return this;
    }

    public s2 m(Object obj) {
        com.google.android.exoplayer2.util.a.g(!this.f25692k);
        this.f25687f = obj;
        return this;
    }

    public s2 n(int i11) {
        com.google.android.exoplayer2.util.a.g(!this.f25692k);
        this.f25686e = i11;
        return this;
    }
}
