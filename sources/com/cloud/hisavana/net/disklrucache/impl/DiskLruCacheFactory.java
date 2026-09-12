package com.cloud.hisavana.net.disklrucache.impl;

import com.cloud.hisavana.net.disklrucache.impl.IDiskCache;

/* loaded from: classes3.dex */
public class DiskLruCacheFactory implements IDiskCache.Factory {

    /* renamed from: a, reason: collision with root package name */
    private final long f21488a;

    /* renamed from: b, reason: collision with root package name */
    private final int f21489b;

    public DiskLruCacheFactory(long j11, int i11) {
        this.f21488a = j11;
        this.f21489b = i11;
    }

    public IDiskCache a() {
        return new DiskCacheImpl(null, this.f21488a, this.f21489b);
    }
}
