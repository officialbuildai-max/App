package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class AWSCredentialsProviderChain implements AWSCredentialsProvider {

    /* renamed from: d, reason: collision with root package name */
    private static final Log f18412d = LogFactory.b(AWSCredentialsProviderChain.class);

    /* renamed from: a, reason: collision with root package name */
    private List f18413a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    private boolean f18414b = true;

    /* renamed from: c, reason: collision with root package name */
    private AWSCredentialsProvider f18415c;

    public AWSCredentialsProviderChain(AWSCredentialsProvider... aWSCredentialsProviderArr) {
        if (aWSCredentialsProviderArr == null || aWSCredentialsProviderArr.length == 0) {
            throw new IllegalArgumentException("No credential providers specified");
        }
        for (AWSCredentialsProvider aWSCredentialsProvider : aWSCredentialsProviderArr) {
            this.f18413a.add(aWSCredentialsProvider);
        }
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public AWSCredentials a() {
        AWSCredentialsProvider aWSCredentialsProvider;
        if (this.f18414b && (aWSCredentialsProvider = this.f18415c) != null) {
            return aWSCredentialsProvider.a();
        }
        for (AWSCredentialsProvider aWSCredentialsProvider2 : this.f18413a) {
            try {
                AWSCredentials a11 = aWSCredentialsProvider2.a();
                if (a11.b() != null && a11.c() != null) {
                    f18412d.a("Loading credentials from " + aWSCredentialsProvider2.toString());
                    this.f18415c = aWSCredentialsProvider2;
                    return a11;
                }
            } catch (Exception e11) {
                f18412d.a("Unable to load credentials from " + aWSCredentialsProvider2.toString() + ": " + e11.getMessage());
            }
        }
        throw new AmazonClientException("Unable to load AWS credentials from any provider in the chain");
    }
}
