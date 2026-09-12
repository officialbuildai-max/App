package com.transsion.player.shorttv.preload;

import androidx.collection.s;
import androidx.media3.exoplayer.offline.DownloadRequest;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f48563a;

    /* renamed from: b, reason: collision with root package name */
    private final String f48564b;

    /* renamed from: c, reason: collision with root package name */
    private final DownloadRequest f48565c;

    /* renamed from: d, reason: collision with root package name */
    private long f48566d;

    /* renamed from: e, reason: collision with root package name */
    private long f48567e;

    /* renamed from: f, reason: collision with root package name */
    private long f48568f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f48569g;

    public a(String id2, String url, DownloadRequest request, long j11, long j12, long j13, boolean z10) {
        Intrinsics.h(id2, "id");
        Intrinsics.h(url, "url");
        Intrinsics.h(request, "request");
        this.f48563a = id2;
        this.f48564b = url;
        this.f48565c = request;
        this.f48566d = j11;
        this.f48567e = j12;
        this.f48568f = j13;
        this.f48569g = z10;
    }

    public final long a() {
        return this.f48566d;
    }

    public final long b() {
        return this.f48567e;
    }

    public final String c() {
        return this.f48563a;
    }

    public final long d() {
        return this.f48568f;
    }

    public final DownloadRequest e() {
        return this.f48565c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.f48563a, aVar.f48563a) && Intrinsics.c(this.f48564b, aVar.f48564b) && Intrinsics.c(this.f48565c, aVar.f48565c) && this.f48566d == aVar.f48566d && this.f48567e == aVar.f48567e && this.f48568f == aVar.f48568f && this.f48569g == aVar.f48569g;
    }

    public final boolean f() {
        return this.f48569g;
    }

    public final void g(long j11) {
        this.f48566d = j11;
    }

    public final void h(long j11) {
        this.f48567e = j11;
    }

    public int hashCode() {
        return (((((((((((this.f48563a.hashCode() * 31) + this.f48564b.hashCode()) * 31) + this.f48565c.hashCode()) * 31) + s.a(this.f48566d)) * 31) + s.a(this.f48567e)) * 31) + s.a(this.f48568f)) * 31) + androidx.compose.foundation.e.a(this.f48569g);
    }

    public final void i(long j11) {
        this.f48568f = j11;
    }

    public String toString() {
        return "VideoDownloadBean(id=" + this.f48563a + ", url=" + this.f48564b + ", request=" + this.f48565c + ", contentLength=" + this.f48566d + ", downloadLength=" + this.f48567e + ", maxLength=" + this.f48568f + ", isAdd=" + this.f48569g + ")";
    }
}
