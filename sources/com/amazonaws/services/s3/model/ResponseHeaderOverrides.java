package com.amazonaws.services.s3.model;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: classes2.dex */
public class ResponseHeaderOverrides extends AmazonWebServiceRequest {

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f18878g = {RequestParameters.RESPONSE_HEADER_CACHE_CONTROL, RequestParameters.RESPONSE_HEADER_CONTENT_DISPOSITION, RequestParameters.RESPONSE_HEADER_CONTENT_ENCODING, RequestParameters.RESPONSE_HEADER_CONTENT_LANGUAGE, RequestParameters.RESPONSE_HEADER_CONTENT_TYPE, RequestParameters.RESPONSE_HEADER_EXPIRES};

    /* renamed from: a, reason: collision with root package name */
    private String f18879a;

    /* renamed from: b, reason: collision with root package name */
    private String f18880b;

    /* renamed from: c, reason: collision with root package name */
    private String f18881c;

    /* renamed from: d, reason: collision with root package name */
    private String f18882d;

    /* renamed from: e, reason: collision with root package name */
    private String f18883e;

    /* renamed from: f, reason: collision with root package name */
    private String f18884f;

    public String b() {
        return this.f18882d;
    }

    public String c() {
        return this.f18883e;
    }

    public String e() {
        return this.f18884f;
    }

    public String f() {
        return this.f18880b;
    }

    public String g() {
        return this.f18881c;
    }

    public String getContentType() {
        return this.f18879a;
    }
}
