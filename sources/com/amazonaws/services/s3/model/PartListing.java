package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class PartListing implements S3RequesterChargedResult {

    /* renamed from: a, reason: collision with root package name */
    private String f18844a;

    /* renamed from: b, reason: collision with root package name */
    private String f18845b;

    /* renamed from: c, reason: collision with root package name */
    private String f18846c;

    /* renamed from: d, reason: collision with root package name */
    private Integer f18847d;

    /* renamed from: e, reason: collision with root package name */
    private Integer f18848e;

    /* renamed from: f, reason: collision with root package name */
    private String f18849f;

    /* renamed from: g, reason: collision with root package name */
    private Owner f18850g;

    /* renamed from: h, reason: collision with root package name */
    private Owner f18851h;

    /* renamed from: i, reason: collision with root package name */
    private String f18852i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f18853j;

    /* renamed from: k, reason: collision with root package name */
    private Integer f18854k;

    /* renamed from: l, reason: collision with root package name */
    private List f18855l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f18856m;

    public List a() {
        if (this.f18855l == null) {
            this.f18855l = new ArrayList();
        }
        return this.f18855l;
    }

    public void b(String str) {
        this.f18844a = str;
    }

    public void c(String str) {
        this.f18849f = str;
    }

    public void d(Owner owner) {
        this.f18851h = owner;
    }

    public void e(String str) {
        this.f18845b = str;
    }

    public void f(int i11) {
        this.f18847d = Integer.valueOf(i11);
    }

    public void g(int i11) {
        this.f18854k = Integer.valueOf(i11);
    }

    public void h(Owner owner) {
        this.f18850g = owner;
    }

    public void i(int i11) {
        this.f18848e = Integer.valueOf(i11);
    }

    public void j(String str) {
        this.f18852i = str;
    }

    public void k(boolean z10) {
        this.f18853j = z10;
    }

    public void l(String str) {
        this.f18846c = str;
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public void setRequesterCharged(boolean z10) {
        this.f18856m = z10;
    }
}
