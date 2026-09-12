package com.amazonaws.internal;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

/* loaded from: classes2.dex */
public class StaticCredentialsProvider implements AWSCredentialsProvider {

    /* renamed from: a, reason: collision with root package name */
    private final AWSCredentials f18495a;

    public StaticCredentialsProvider(AWSCredentials aWSCredentials) {
        this.f18495a = aWSCredentials;
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public AWSCredentials a() {
        return this.f18495a;
    }
}
