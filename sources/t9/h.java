package t9;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: h, reason: collision with root package name */
    private static final AtomicLong f76222h = new AtomicLong();

    /* renamed from: a, reason: collision with root package name */
    public final long f76223a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.n f76224b;

    /* renamed from: c, reason: collision with root package name */
    public final Uri f76225c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f76226d;

    /* renamed from: e, reason: collision with root package name */
    public final long f76227e;

    /* renamed from: f, reason: collision with root package name */
    public final long f76228f;

    /* renamed from: g, reason: collision with root package name */
    public final long f76229g;

    public h(long j11, com.google.android.exoplayer2.upstream.n nVar, long j12) {
        this(j11, nVar, nVar.f27491a, Collections.emptyMap(), j12, 0L, 0L);
    }

    public h(long j11, com.google.android.exoplayer2.upstream.n nVar, Uri uri, Map map, long j12, long j13, long j14) {
        this.f76223a = j11;
        this.f76224b = nVar;
        this.f76225c = uri;
        this.f76226d = map;
        this.f76227e = j12;
        this.f76228f = j13;
        this.f76229g = j14;
    }

    public static long a() {
        return f76222h.getAndIncrement();
    }
}
