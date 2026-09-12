package com.google.android.datatransport.cct.internal;

import java.util.List;

/* loaded from: classes3.dex */
final class d extends m {

    /* renamed from: a, reason: collision with root package name */
    private final List f24329a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(List list) {
        if (list == null) {
            throw new NullPointerException("Null logRequests");
        }
        this.f24329a = list;
    }

    @Override // com.google.android.datatransport.cct.internal.m
    public List c() {
        return this.f24329a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            return this.f24329a.equals(((m) obj).c());
        }
        return false;
    }

    public int hashCode() {
        return this.f24329a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f24329a + "}";
    }
}
