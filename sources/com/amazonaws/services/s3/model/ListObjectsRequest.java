package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: classes2.dex */
public class ListObjectsRequest extends AmazonWebServiceRequest {

    /* renamed from: a, reason: collision with root package name */
    private String f18794a;

    /* renamed from: b, reason: collision with root package name */
    private String f18795b;

    /* renamed from: c, reason: collision with root package name */
    private String f18796c;

    /* renamed from: d, reason: collision with root package name */
    private String f18797d;

    /* renamed from: e, reason: collision with root package name */
    private Integer f18798e;

    /* renamed from: f, reason: collision with root package name */
    private String f18799f;

    public ListObjectsRequest() {
    }

    public ListObjectsRequest(String str, String str2, String str3, String str4, Integer num) {
        setBucketName(str);
        e(str2);
        setMarker(str3);
        b(str4);
        d(num);
    }

    public void b(String str) {
        this.f18797d = str;
    }

    public void c(String str) {
        this.f18799f = str;
    }

    public void d(Integer num) {
        this.f18798e = num;
    }

    public void e(String str) {
        this.f18795b = str;
    }

    public ListObjectsRequest f(String str) {
        c(str);
        return this;
    }

    public void setBucketName(String str) {
        this.f18794a = str;
    }

    public void setMarker(String str) {
        this.f18796c = str;
    }
}
