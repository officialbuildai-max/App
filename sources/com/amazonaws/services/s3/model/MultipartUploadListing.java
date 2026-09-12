package com.amazonaws.services.s3.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class MultipartUploadListing {

    /* renamed from: a, reason: collision with root package name */
    private String f18829a;

    /* renamed from: b, reason: collision with root package name */
    private String f18830b;

    /* renamed from: c, reason: collision with root package name */
    private String f18831c;

    /* renamed from: d, reason: collision with root package name */
    private String f18832d;

    /* renamed from: e, reason: collision with root package name */
    private String f18833e;

    /* renamed from: f, reason: collision with root package name */
    private int f18834f;

    /* renamed from: g, reason: collision with root package name */
    private String f18835g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f18836h;

    /* renamed from: i, reason: collision with root package name */
    private String f18837i;

    /* renamed from: j, reason: collision with root package name */
    private String f18838j;

    /* renamed from: k, reason: collision with root package name */
    private List f18839k;

    /* renamed from: l, reason: collision with root package name */
    private List f18840l = new ArrayList();

    public List a() {
        return this.f18840l;
    }

    public List b() {
        if (this.f18839k == null) {
            this.f18839k = new ArrayList();
        }
        return this.f18839k;
    }

    public void c(String str) {
        this.f18829a = str;
    }

    public void d(String str) {
        this.f18831c = str;
    }

    public void e(String str) {
        this.f18835g = str;
    }

    public void f(String str) {
        this.f18830b = str;
    }

    public void g(int i11) {
        this.f18834f = i11;
    }

    public void h(String str) {
        this.f18837i = str;
    }

    public void i(String str) {
        this.f18838j = str;
    }

    public void j(String str) {
        this.f18832d = str;
    }

    public void k(boolean z10) {
        this.f18836h = z10;
    }

    public void l(String str) {
        this.f18833e = str;
    }
}
