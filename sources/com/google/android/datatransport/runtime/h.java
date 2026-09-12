package com.google.android.datatransport.runtime;

import java.util.Arrays;

/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private final r8.c f24463a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f24464b;

    public h(r8.c cVar, byte[] bArr) {
        if (cVar == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f24463a = cVar;
        this.f24464b = bArr;
    }

    public byte[] a() {
        return this.f24464b;
    }

    public r8.c b() {
        return this.f24463a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f24463a.equals(hVar.f24463a)) {
            return Arrays.equals(this.f24464b, hVar.f24464b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.f24463a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f24464b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f24463a + ", bytes=[...]}";
    }
}
