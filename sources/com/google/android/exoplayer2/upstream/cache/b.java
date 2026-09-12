package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.cache.Cache;

/* loaded from: classes3.dex */
public interface b extends Cache.a {
    boolean a();

    void c(Cache cache, String str, long j11, long j12);

    void onCacheInitialized();
}
