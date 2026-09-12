package h2;

import android.net.Uri;
import androidx.media3.common.r;
import androidx.media3.exoplayer.upstream.Loader;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class e implements Loader.d {

    /* renamed from: a, reason: collision with root package name */
    public final long f64419a = g2.i.a();

    /* renamed from: b, reason: collision with root package name */
    public final w1.h f64420b;

    /* renamed from: c, reason: collision with root package name */
    public final int f64421c;

    /* renamed from: d, reason: collision with root package name */
    public final r f64422d;

    /* renamed from: e, reason: collision with root package name */
    public final int f64423e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f64424f;

    /* renamed from: g, reason: collision with root package name */
    public final long f64425g;

    /* renamed from: h, reason: collision with root package name */
    public final long f64426h;

    /* renamed from: i, reason: collision with root package name */
    protected final w1.l f64427i;

    public e(androidx.media3.datasource.a aVar, w1.h hVar, int i11, r rVar, int i12, Object obj, long j11, long j12) {
        this.f64427i = new w1.l(aVar);
        this.f64420b = (w1.h) androidx.media3.common.util.a.e(hVar);
        this.f64421c = i11;
        this.f64422d = rVar;
        this.f64423e = i12;
        this.f64424f = obj;
        this.f64425g = j11;
        this.f64426h = j12;
    }

    public final long a() {
        return this.f64427i.d();
    }

    public final long b() {
        return this.f64426h - this.f64425g;
    }

    public final Map c() {
        return this.f64427i.f();
    }

    public final Uri d() {
        return this.f64427i.e();
    }
}
