package com.cloud.hisavana.net.disklrucache.impl;

import com.cloud.hisavana.net.disklrucache.impl.IDiskCache;

/* loaded from: classes3.dex */
public class DiskCacheProvider implements IDiskCache.Provider {

    /* renamed from: a, reason: collision with root package name */
    private volatile IDiskCache f21485a;

    /* renamed from: b, reason: collision with root package name */
    private volatile IDiskCache f21486b;

    /* renamed from: c, reason: collision with root package name */
    private volatile IDiskCache f21487c;

    private IDiskCache a(long j11) {
        if (this.f21487c == null) {
            synchronized (this) {
                try {
                    if (this.f21487c == null) {
                        this.f21487c = new DiskLruCacheFactory(j11, 4).a();
                    }
                } finally {
                }
            }
        }
        return this.f21487c;
    }

    private IDiskCache c(long j11) {
        if (this.f21485a == null) {
            synchronized (this) {
                try {
                    if (this.f21485a == null) {
                        this.f21485a = new DiskLruCacheFactory(j11, 1).a();
                    }
                } finally {
                }
            }
        }
        return this.f21485a;
    }

    private IDiskCache d(long j11) {
        if (this.f21486b == null) {
            synchronized (this) {
                try {
                    if (this.f21486b == null) {
                        this.f21486b = new DiskLruCacheFactory(j11, 3).a();
                    }
                } finally {
                }
            }
        }
        return this.f21486b;
    }

    public IDiskCache b(long j11, int i11) {
        return i11 != 3 ? i11 != 4 ? c(j11) : a(j11) : d(j11);
    }
}
