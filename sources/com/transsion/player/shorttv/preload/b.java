package com.transsion.player.shorttv.preload;

import androidx.media3.common.t;
import androidx.media3.common.util.a1;
import androidx.media3.datasource.cache.a;
import androidx.media3.exoplayer.offline.DownloadRequest;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b extends androidx.media3.exoplayer.offline.b {

    /* renamed from: d, reason: collision with root package name */
    private final a.c f48570d;

    /* renamed from: e, reason: collision with root package name */
    private final Executor f48571e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a.c cacheDataSourceFactory, Executor executor) {
        super(cacheDataSourceFactory, executor);
        Intrinsics.h(cacheDataSourceFactory, "cacheDataSourceFactory");
        Intrinsics.h(executor, "executor");
        this.f48570d = cacheDataSourceFactory;
        this.f48571e = executor;
    }

    @Override // androidx.media3.exoplayer.offline.b, androidx.media3.exoplayer.offline.p
    public androidx.media3.exoplayer.offline.o a(DownloadRequest request) {
        Intrinsics.h(request, "request");
        int A0 = a1.A0(request.uri, request.mimeType);
        if (A0 == 0 || A0 == 1 || A0 == 2) {
            androidx.media3.exoplayer.offline.o a11 = super.a(request);
            Intrinsics.g(a11, "createDownloader(...)");
            return a11;
        }
        if (A0 == 4) {
            return new VideoProgressiveDownloader(new t.c().i(request.uri).b(request.customCacheKey).a(), this.f48570d, this.f48571e);
        }
        throw new IllegalArgumentException("Unsupported type: " + A0);
    }
}
