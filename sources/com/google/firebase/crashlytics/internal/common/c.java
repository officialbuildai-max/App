package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.h0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class c extends h0.a {

    /* renamed from: a, reason: collision with root package name */
    private final String f31207a;

    /* renamed from: b, reason: collision with root package name */
    private final String f31208b;

    /* renamed from: c, reason: collision with root package name */
    private final String f31209c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("Null crashlyticsInstallId");
        }
        this.f31207a = str;
        this.f31208b = str2;
        this.f31209c = str3;
    }

    @Override // com.google.firebase.crashlytics.internal.common.h0.a
    public String c() {
        return this.f31207a;
    }

    @Override // com.google.firebase.crashlytics.internal.common.h0.a
    public String d() {
        return this.f31209c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.h0.a
    public String e() {
        return this.f31208b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h0.a)) {
            return false;
        }
        h0.a aVar = (h0.a) obj;
        if (this.f31207a.equals(aVar.c()) && ((str = this.f31208b) != null ? str.equals(aVar.e()) : aVar.e() == null)) {
            String str2 = this.f31209c;
            if (str2 == null) {
                if (aVar.d() == null) {
                    return true;
                }
            } else if (str2.equals(aVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.f31207a.hashCode() ^ 1000003) * 1000003;
        String str = this.f31208b;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f31209c;
        return hashCode2 ^ (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "InstallIds{crashlyticsInstallId=" + this.f31207a + ", firebaseInstallationId=" + this.f31208b + ", firebaseAuthenticationToken=" + this.f31209c + "}";
    }
}
