package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.SSEResultBase;

/* loaded from: classes2.dex */
public class InitiateMultipartUploadResult extends SSEResultBase {

    /* renamed from: a, reason: collision with root package name */
    private String f18791a;

    /* renamed from: b, reason: collision with root package name */
    private String f18792b;

    /* renamed from: c, reason: collision with root package name */
    private String f18793c;

    public String a() {
        return this.f18793c;
    }

    public void b(String str) {
        this.f18793c = str;
    }

    public void setBucketName(String str) {
        this.f18791a = str;
    }

    public void setKey(String str) {
        this.f18792b = str;
    }
}
