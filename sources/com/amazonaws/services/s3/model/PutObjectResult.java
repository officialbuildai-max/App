package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.S3VersionResult;
import com.amazonaws.services.s3.internal.SSEResultBase;
import java.util.Date;

/* loaded from: classes2.dex */
public class PutObjectResult extends SSEResultBase implements ObjectExpirationResult, S3RequesterChargedResult, S3VersionResult {

    /* renamed from: a, reason: collision with root package name */
    private String f18861a;

    /* renamed from: b, reason: collision with root package name */
    private String f18862b;

    /* renamed from: c, reason: collision with root package name */
    private Date f18863c;

    /* renamed from: d, reason: collision with root package name */
    private String f18864d;

    /* renamed from: e, reason: collision with root package name */
    private String f18865e;

    /* renamed from: f, reason: collision with root package name */
    private ObjectMetadata f18866f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f18867g;

    public void a(String str) {
        this.f18865e = str;
    }

    public void b(ObjectMetadata objectMetadata) {
        this.f18866f = objectMetadata;
    }

    public void setETag(String str) {
        this.f18862b = str;
    }

    @Override // com.amazonaws.services.s3.internal.ObjectExpirationResult
    public void setExpirationTime(Date date) {
        this.f18863c = date;
    }

    @Override // com.amazonaws.services.s3.internal.ObjectExpirationResult
    public void setExpirationTimeRuleId(String str) {
        this.f18864d = str;
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public void setRequesterCharged(boolean z10) {
        this.f18867g = z10;
    }

    @Override // com.amazonaws.services.s3.internal.S3VersionResult
    public void setVersionId(String str) {
        this.f18861a = str;
    }
}
