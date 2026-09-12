package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: classes2.dex */
public class ListVersionsRequest extends AmazonWebServiceRequest {

    /* renamed from: a, reason: collision with root package name */
    private String f18812a;

    /* renamed from: b, reason: collision with root package name */
    private String f18813b;

    /* renamed from: c, reason: collision with root package name */
    private String f18814c;

    /* renamed from: d, reason: collision with root package name */
    private String f18815d;

    /* renamed from: e, reason: collision with root package name */
    private String f18816e;

    /* renamed from: f, reason: collision with root package name */
    private Integer f18817f;

    /* renamed from: g, reason: collision with root package name */
    private String f18818g;

    public ListVersionsRequest() {
    }

    public ListVersionsRequest(String str, String str2, String str3, String str4, String str5, Integer num) {
        setBucketName(str);
        e(str2);
        d(str3);
        f(str4);
        b(str5);
        setMaxResults(num);
    }

    public void b(String str) {
        this.f18816e = str;
    }

    public void c(String str) {
        this.f18818g = str;
    }

    public void d(String str) {
        this.f18814c = str;
    }

    public void e(String str) {
        this.f18813b = str;
    }

    public void f(String str) {
        this.f18815d = str;
    }

    public ListVersionsRequest g(String str) {
        c(str);
        return this;
    }

    public void setBucketName(String str) {
        this.f18812a = str;
    }

    public void setMaxResults(Integer num) {
        this.f18817f = num;
    }
}
