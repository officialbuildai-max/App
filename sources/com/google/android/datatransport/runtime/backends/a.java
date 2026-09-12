package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendResponse;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class a extends BackendResponse {

    /* renamed from: a, reason: collision with root package name */
    private final BackendResponse.Status f24425a;

    /* renamed from: b, reason: collision with root package name */
    private final long f24426b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BackendResponse.Status status, long j11) {
        if (status == null) {
            throw new NullPointerException("Null status");
        }
        this.f24425a = status;
        this.f24426b = j11;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public long b() {
        return this.f24426b;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public BackendResponse.Status c() {
        return this.f24425a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendResponse)) {
            return false;
        }
        BackendResponse backendResponse = (BackendResponse) obj;
        return this.f24425a.equals(backendResponse.c()) && this.f24426b == backendResponse.b();
    }

    public int hashCode() {
        int hashCode = (this.f24425a.hashCode() ^ 1000003) * 1000003;
        long j11 = this.f24426b;
        return hashCode ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f24425a + ", nextRequestWaitMillis=" + this.f24426b + "}";
    }
}
