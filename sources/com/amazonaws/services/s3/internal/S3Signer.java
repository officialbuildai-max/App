package com.amazonaws.services.s3.internal;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.amazonaws.Request;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.auth.AbstractAWSSigner;
import com.amazonaws.auth.SigningAlgorithm;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.HttpUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class S3Signer extends AbstractAWSSigner {

    /* renamed from: f, reason: collision with root package name */
    private static final Log f18746f = LogFactory.b(S3Signer.class);

    /* renamed from: c, reason: collision with root package name */
    private final String f18747c;

    /* renamed from: d, reason: collision with root package name */
    private final String f18748d;

    /* renamed from: e, reason: collision with root package name */
    private final Set f18749e;

    public S3Signer() {
        this.f18747c = null;
        this.f18748d = null;
        this.f18749e = null;
    }

    public S3Signer(String str, String str2) {
        this(str, str2, null);
    }

    public S3Signer(String str, String str2, Collection collection) {
        if (str2 == null) {
            throw new IllegalArgumentException("Parameter resourcePath is empty");
        }
        this.f18747c = str;
        this.f18748d = str2;
        this.f18749e = collection == null ? null : Collections.unmodifiableSet(new HashSet(collection));
    }

    @Override // com.amazonaws.auth.Signer
    public void b(Request request, AWSCredentials aWSCredentials) {
        w(request, aWSCredentials, null);
    }

    protected void v(Request request, AWSSessionCredentials aWSSessionCredentials) {
        request.addHeader("x-amz-security-token", aWSSessionCredentials.a());
    }

    void w(Request request, AWSCredentials aWSCredentials, Date date) {
        if (this.f18748d == null) {
            throw new UnsupportedOperationException("Cannot sign a request using a dummy S3Signer instance with no resource path");
        }
        if (aWSCredentials == null || aWSCredentials.c() == null) {
            f18746f.a("Canonical string will not be signed, as no AWS Secret Key was provided");
            return;
        }
        AWSCredentials q11 = q(aWSCredentials);
        if (q11 instanceof AWSSessionCredentials) {
            v(request, (AWSSessionCredentials) q11);
        }
        String b11 = HttpUtils.b(request.r().getPath(), this.f18748d, true);
        Date l11 = l(m(request));
        if (date == null) {
            date = l11;
        }
        request.addHeader(HttpHeaders.DATE, ServiceUtils.a(date));
        String a11 = RestUtils.a(this.f18747c, b11, request, null, this.f18749e);
        f18746f.a("Calculated string to sign:\n\"" + a11 + "\"");
        request.addHeader(HttpHeaders.AUTHORIZATION, "AWS " + q11.b() + ":" + super.t(a11, q11.c(), SigningAlgorithm.HmacSHA1));
    }
}
