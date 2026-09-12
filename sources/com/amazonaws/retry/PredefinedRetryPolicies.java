package com.amazonaws.retry;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.retry.RetryPolicy;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Random;

/* loaded from: classes2.dex */
public class PredefinedRetryPolicies {

    /* renamed from: a, reason: collision with root package name */
    public static final RetryPolicy f18651a = new RetryPolicy(RetryPolicy.RetryCondition.f18664a, RetryPolicy.BackoffStrategy.f18663a, 0, false);

    /* renamed from: d, reason: collision with root package name */
    public static final RetryPolicy.RetryCondition f18654d = new SDKDefaultRetryCondition();

    /* renamed from: e, reason: collision with root package name */
    public static final RetryPolicy.BackoffStrategy f18655e = new SDKDefaultBackoffStrategy(100, 20000);

    /* renamed from: b, reason: collision with root package name */
    public static final RetryPolicy f18652b = a();

    /* renamed from: c, reason: collision with root package name */
    public static final RetryPolicy f18653c = b();

    /* loaded from: classes2.dex */
    private static final class SDKDefaultBackoffStrategy implements RetryPolicy.BackoffStrategy {

        /* renamed from: b, reason: collision with root package name */
        private final Random f18656b;

        /* renamed from: c, reason: collision with root package name */
        private final int f18657c;

        /* renamed from: d, reason: collision with root package name */
        private final int f18658d;

        private SDKDefaultBackoffStrategy(int i11, int i12) {
            this.f18656b = new Random();
            this.f18657c = i11;
            this.f18658d = i12;
        }

        @Override // com.amazonaws.retry.RetryPolicy.BackoffStrategy
        public final long a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i11) {
            if (i11 <= 0) {
                return 0L;
            }
            return this.f18656b.nextInt(Math.min(this.f18658d, (1 << i11) * this.f18657c));
        }
    }

    /* loaded from: classes2.dex */
    public static class SDKDefaultRetryCondition implements RetryPolicy.RetryCondition {
        @Override // com.amazonaws.retry.RetryPolicy.RetryCondition
        public boolean a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i11) {
            if ((amazonClientException.getCause() instanceof IOException) && !(amazonClientException.getCause() instanceof InterruptedIOException)) {
                return true;
            }
            if (!(amazonClientException instanceof AmazonServiceException)) {
                return false;
            }
            AmazonServiceException amazonServiceException = (AmazonServiceException) amazonClientException;
            int statusCode = amazonServiceException.getStatusCode();
            return statusCode == 500 || statusCode == 503 || statusCode == 502 || statusCode == 504 || RetryUtils.c(amazonServiceException) || RetryUtils.a(amazonServiceException);
        }
    }

    public static RetryPolicy a() {
        return new RetryPolicy(f18654d, f18655e, 3, true);
    }

    public static RetryPolicy b() {
        return new RetryPolicy(f18654d, f18655e, 10, true);
    }
}
