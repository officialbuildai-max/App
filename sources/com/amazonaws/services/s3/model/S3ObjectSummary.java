package com.amazonaws.services.s3.model;

import java.util.Date;

/* loaded from: classes2.dex */
public class S3ObjectSummary {

    /* renamed from: a, reason: collision with root package name */
    protected String f18890a;

    /* renamed from: b, reason: collision with root package name */
    protected String f18891b;

    /* renamed from: c, reason: collision with root package name */
    protected String f18892c;

    /* renamed from: d, reason: collision with root package name */
    protected long f18893d;

    /* renamed from: e, reason: collision with root package name */
    protected Date f18894e;

    /* renamed from: f, reason: collision with root package name */
    protected String f18895f;

    /* renamed from: g, reason: collision with root package name */
    protected Owner f18896g;

    public String a() {
        return this.f18891b;
    }

    public void b(String str) {
        this.f18890a = str;
    }

    public void c(String str) {
        this.f18892c = str;
    }

    public void d(String str) {
        this.f18891b = str;
    }

    public void e(Date date) {
        this.f18894e = date;
    }

    public void f(Owner owner) {
        this.f18896g = owner;
    }

    public void g(long j11) {
        this.f18893d = j11;
    }

    public void h(String str) {
        this.f18895f = str;
    }

    public String toString() {
        return "S3ObjectSummary{bucketName='" + this.f18890a + "', key='" + this.f18891b + "', eTag='" + this.f18892c + "', size=" + this.f18893d + ", lastModified=" + this.f18894e + ", storageClass='" + this.f18895f + "', owner=" + this.f18896g + '}';
    }
}
