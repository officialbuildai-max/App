package com.amazonaws.services.s3.internal;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DeleteObjectsResponse implements S3RequesterChargedResult {

    /* renamed from: a, reason: collision with root package name */
    private List f18703a;

    /* renamed from: b, reason: collision with root package name */
    private List f18704b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f18705c;

    public DeleteObjectsResponse() {
        this(new ArrayList(), new ArrayList());
    }

    public DeleteObjectsResponse(List list, List list2) {
        this.f18703a = list;
        this.f18704b = list2;
    }

    public List a() {
        return this.f18703a;
    }

    public List b() {
        return this.f18704b;
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public void setRequesterCharged(boolean z10) {
        this.f18705c = z10;
    }
}
