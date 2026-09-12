package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.SSEResultBase;

/* loaded from: classes2.dex */
public class UploadPartResult extends SSEResultBase implements S3RequesterChargedResult {

    /* renamed from: a, reason: collision with root package name */
    private int f18913a;

    /* renamed from: b, reason: collision with root package name */
    private String f18914b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f18915c;

    public String getETag() {
        return this.f18914b;
    }

    public int getPartNumber() {
        return this.f18913a;
    }

    public void setETag(String str) {
        this.f18914b = str;
    }

    public void setPartNumber(int i11) {
        this.f18913a = i11;
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public void setRequesterCharged(boolean z10) {
        this.f18915c = z10;
    }
}
