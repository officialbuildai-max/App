package com.amazonaws.services.s3.model;

/* loaded from: classes2.dex */
public class SSECustomerKey {

    /* renamed from: a, reason: collision with root package name */
    private final String f18907a = null;

    /* renamed from: b, reason: collision with root package name */
    private String f18908b;

    /* renamed from: c, reason: collision with root package name */
    private String f18909c;

    private SSECustomerKey() {
    }

    public static SSECustomerKey a(String str) {
        if (str != null) {
            return new SSECustomerKey().f(str);
        }
        throw new IllegalArgumentException();
    }

    public String b() {
        return this.f18909c;
    }

    public String c() {
        return this.f18907a;
    }

    public String d() {
        return this.f18908b;
    }

    public void e(String str) {
        this.f18909c = str;
    }

    public SSECustomerKey f(String str) {
        e(str);
        return this;
    }
}
