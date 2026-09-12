package com.amazonaws;

/* loaded from: classes2.dex */
public class AmazonWebServiceResponse<T> {

    /* renamed from: a, reason: collision with root package name */
    private Object f18362a;

    /* renamed from: b, reason: collision with root package name */
    private ResponseMetadata f18363b;

    public String a() {
        ResponseMetadata responseMetadata = this.f18363b;
        if (responseMetadata == null) {
            return null;
        }
        return responseMetadata.a();
    }

    public Object b() {
        return this.f18362a;
    }

    public void c(ResponseMetadata responseMetadata) {
        this.f18363b = responseMetadata;
    }

    public void d(Object obj) {
        this.f18362a = obj;
    }
}
