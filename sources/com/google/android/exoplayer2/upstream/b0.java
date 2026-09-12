package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.util.p0;
import java.io.InputStream;
import java.util.Map;

/* loaded from: classes3.dex */
public final class b0 implements Loader.d {

    /* renamed from: a, reason: collision with root package name */
    public final long f27325a;

    /* renamed from: b, reason: collision with root package name */
    public final n f27326b;

    /* renamed from: c, reason: collision with root package name */
    public final int f27327c;

    /* renamed from: d, reason: collision with root package name */
    private final i0 f27328d;

    /* renamed from: e, reason: collision with root package name */
    private final a f27329e;

    /* renamed from: f, reason: collision with root package name */
    private volatile Object f27330f;

    /* loaded from: classes3.dex */
    public interface a {
        Object parse(Uri uri, InputStream inputStream);
    }

    public b0(k kVar, Uri uri, int i11, a aVar) {
        this(kVar, new n.b().i(uri).b(1).a(), i11, aVar);
    }

    public b0(k kVar, n nVar, int i11, a aVar) {
        this.f27328d = new i0(kVar);
        this.f27326b = nVar;
        this.f27327c = i11;
        this.f27329e = aVar;
        this.f27325a = t9.h.a();
    }

    public static Object e(k kVar, a aVar, n nVar, int i11) {
        b0 b0Var = new b0(kVar, nVar, i11, aVar);
        b0Var.load();
        return com.google.android.exoplayer2.util.a.e(b0Var.c());
    }

    public long a() {
        return this.f27328d.f();
    }

    public Map b() {
        return this.f27328d.i();
    }

    public final Object c() {
        return this.f27330f;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public final void cancelLoad() {
    }

    public Uri d() {
        return this.f27328d.h();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public final void load() {
        this.f27328d.j();
        l lVar = new l(this.f27328d, this.f27326b);
        try {
            lVar.h();
            this.f27330f = this.f27329e.parse((Uri) com.google.android.exoplayer2.util.a.e(this.f27328d.getUri()), lVar);
        } finally {
            p0.n(lVar);
        }
    }
}
