package com.amazonaws.retry;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: classes2.dex */
public final class RetryPolicy {

    /* renamed from: a, reason: collision with root package name */
    private final RetryCondition f18659a;

    /* renamed from: b, reason: collision with root package name */
    private final BackoffStrategy f18660b;

    /* renamed from: c, reason: collision with root package name */
    private final int f18661c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f18662d;

    /* loaded from: classes2.dex */
    public interface BackoffStrategy {

        /* renamed from: a, reason: collision with root package name */
        public static final BackoffStrategy f18663a = new BackoffStrategy() { // from class: com.amazonaws.retry.RetryPolicy.BackoffStrategy.1
            @Override // com.amazonaws.retry.RetryPolicy.BackoffStrategy
            public long a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i11) {
                return 0L;
            }
        };

        long a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i11);
    }

    /* loaded from: classes2.dex */
    public interface RetryCondition {

        /* renamed from: a, reason: collision with root package name */
        public static final RetryCondition f18664a = new RetryCondition() { // from class: com.amazonaws.retry.RetryPolicy.RetryCondition.1
            @Override // com.amazonaws.retry.RetryPolicy.RetryCondition
            public boolean a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i11) {
                return false;
            }
        };

        boolean a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i11);
    }

    public RetryPolicy(RetryCondition retryCondition, BackoffStrategy backoffStrategy, int i11, boolean z10) {
        retryCondition = retryCondition == null ? PredefinedRetryPolicies.f18654d : retryCondition;
        backoffStrategy = backoffStrategy == null ? PredefinedRetryPolicies.f18655e : backoffStrategy;
        if (i11 < 0) {
            throw new IllegalArgumentException("Please provide a non-negative value for maxErrorRetry.");
        }
        this.f18659a = retryCondition;
        this.f18660b = backoffStrategy;
        this.f18661c = i11;
        this.f18662d = z10;
    }

    public BackoffStrategy a() {
        return this.f18660b;
    }

    public int b() {
        return this.f18661c;
    }

    public RetryCondition c() {
        return this.f18659a;
    }

    public boolean d() {
        return this.f18662d;
    }
}
