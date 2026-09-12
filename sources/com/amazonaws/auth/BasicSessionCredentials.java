package com.amazonaws.auth;

/* loaded from: classes2.dex */
public class BasicSessionCredentials implements AWSSessionCredentials {

    /* renamed from: a, reason: collision with root package name */
    private final String f18434a;

    /* renamed from: b, reason: collision with root package name */
    private final String f18435b;

    /* renamed from: c, reason: collision with root package name */
    private final String f18436c;

    public BasicSessionCredentials(String str, String str2, String str3) {
        this.f18434a = str;
        this.f18435b = str2;
        this.f18436c = str3;
    }

    @Override // com.amazonaws.auth.AWSSessionCredentials
    public String a() {
        return this.f18436c;
    }

    @Override // com.amazonaws.auth.AWSCredentials
    public String b() {
        return this.f18434a;
    }

    @Override // com.amazonaws.auth.AWSCredentials
    public String c() {
        return this.f18435b;
    }
}
