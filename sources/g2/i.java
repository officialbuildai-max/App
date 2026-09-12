package g2;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public final class i {

    /* renamed from: h, reason: collision with root package name */
    private static final AtomicLong f63330h = new AtomicLong();

    /* renamed from: a, reason: collision with root package name */
    public final long f63331a;

    /* renamed from: b, reason: collision with root package name */
    public final w1.h f63332b;

    /* renamed from: c, reason: collision with root package name */
    public final Uri f63333c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f63334d;

    /* renamed from: e, reason: collision with root package name */
    public final long f63335e;

    /* renamed from: f, reason: collision with root package name */
    public final long f63336f;

    /* renamed from: g, reason: collision with root package name */
    public final long f63337g;

    public i(long j11, w1.h hVar, long j12) {
        this(j11, hVar, hVar.f77634a, Collections.emptyMap(), j12, 0L, 0L);
    }

    public i(long j11, w1.h hVar, Uri uri, Map map, long j12, long j13, long j14) {
        this.f63331a = j11;
        this.f63332b = hVar;
        this.f63333c = uri;
        this.f63334d = map;
        this.f63335e = j12;
        this.f63336f = j13;
        this.f63337g = j14;
    }

    public static long a() {
        return f63330h.getAndIncrement();
    }
}
