package com.amazonaws.auth;

/* loaded from: classes2.dex */
public class BasicAWSCredentials implements AWSCredentials {

    /* renamed from: a, reason: collision with root package name */
    private final String f18432a;

    /* renamed from: b, reason: collision with root package name */
    private final String f18433b;

    public BasicAWSCredentials(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Access key cannot be null.");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("Secret key cannot be null.");
        }
        this.f18432a = str;
        this.f18433b = str2;
    }

    @Override // com.amazonaws.auth.AWSCredentials
    public String b() {
        return this.f18432a;
    }

    @Override // com.amazonaws.auth.AWSCredentials
    public String c() {
        return this.f18433b;
    }
}
