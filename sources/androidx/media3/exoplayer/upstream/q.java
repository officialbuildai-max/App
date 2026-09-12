package androidx.media3.exoplayer.upstream;

import android.net.Uri;
import androidx.media3.common.util.a1;
import androidx.media3.exoplayer.upstream.Loader;
import java.io.InputStream;
import java.util.Map;
import w1.h;

/* loaded from: classes2.dex */
public final class q implements Loader.d {

    /* renamed from: a, reason: collision with root package name */
    public final long f13096a;

    /* renamed from: b, reason: collision with root package name */
    public final w1.h f13097b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13098c;

    /* renamed from: d, reason: collision with root package name */
    private final w1.l f13099d;

    /* renamed from: e, reason: collision with root package name */
    private final a f13100e;

    /* renamed from: f, reason: collision with root package name */
    private volatile Object f13101f;

    /* loaded from: classes.dex */
    public interface a {
        Object parse(Uri uri, InputStream inputStream);
    }

    public q(androidx.media3.datasource.a aVar, Uri uri, int i11, a aVar2) {
        this(aVar, new h.b().i(uri).b(1).a(), i11, aVar2);
    }

    public q(androidx.media3.datasource.a aVar, w1.h hVar, int i11, a aVar2) {
        this.f13099d = new w1.l(aVar);
        this.f13097b = hVar;
        this.f13098c = i11;
        this.f13100e = aVar2;
        this.f13096a = g2.i.a();
    }

    public static Object e(androidx.media3.datasource.a aVar, a aVar2, w1.h hVar, int i11) {
        q qVar = new q(aVar, hVar, i11, aVar2);
        qVar.load();
        return androidx.media3.common.util.a.e(qVar.c());
    }

    public long a() {
        return this.f13099d.d();
    }

    public Map b() {
        return this.f13099d.f();
    }

    public final Object c() {
        return this.f13101f;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public final void cancelLoad() {
    }

    public Uri d() {
        return this.f13099d.e();
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public final void load() {
        this.f13099d.g();
        w1.f fVar = new w1.f(this.f13099d, this.f13097b);
        try {
            fVar.h();
            this.f13101f = this.f13100e.parse((Uri) androidx.media3.common.util.a.e(this.f13099d.getUri()), fVar);
        } finally {
            a1.m(fVar);
        }
    }
}
