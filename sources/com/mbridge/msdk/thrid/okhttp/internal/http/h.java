package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.mbridge.msdk.thrid.okhttp.z;

/* loaded from: classes5.dex */
public final class h extends z {

    /* renamed from: a, reason: collision with root package name */
    private final String f38058a;

    /* renamed from: b, reason: collision with root package name */
    private final long f38059b;

    /* renamed from: c, reason: collision with root package name */
    private final com.mbridge.msdk.thrid.okio.e f38060c;

    public h(String str, long j11, com.mbridge.msdk.thrid.okio.e eVar) {
        this.f38058a = str;
        this.f38059b = j11;
        this.f38060c = eVar;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.z
    public long h() {
        return this.f38059b;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.z
    public com.mbridge.msdk.thrid.okio.e k() {
        return this.f38060c;
    }
}
