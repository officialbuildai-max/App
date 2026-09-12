package v9;

import android.net.Uri;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.i0;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class f implements Loader.d {

    /* renamed from: a, reason: collision with root package name */
    public final long f77255a = t9.h.a();

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.n f77256b;

    /* renamed from: c, reason: collision with root package name */
    public final int f77257c;

    /* renamed from: d, reason: collision with root package name */
    public final o1 f77258d;

    /* renamed from: e, reason: collision with root package name */
    public final int f77259e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f77260f;

    /* renamed from: g, reason: collision with root package name */
    public final long f77261g;

    /* renamed from: h, reason: collision with root package name */
    public final long f77262h;

    /* renamed from: i, reason: collision with root package name */
    protected final i0 f77263i;

    public f(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, int i11, o1 o1Var, int i12, Object obj, long j11, long j12) {
        this.f77263i = new i0(kVar);
        this.f77256b = (com.google.android.exoplayer2.upstream.n) com.google.android.exoplayer2.util.a.e(nVar);
        this.f77257c = i11;
        this.f77258d = o1Var;
        this.f77259e = i12;
        this.f77260f = obj;
        this.f77261g = j11;
        this.f77262h = j12;
    }

    public final long a() {
        return this.f77263i.f();
    }

    public final long b() {
        return this.f77262h - this.f77261g;
    }

    public final Map c() {
        return this.f77263i.i();
    }

    public final Uri d() {
        return this.f77263i.h();
    }
}
