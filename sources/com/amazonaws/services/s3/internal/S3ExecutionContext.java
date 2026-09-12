package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.auth.Signer;
import com.amazonaws.http.ExecutionContext;
import java.net.URI;
import java.util.List;

/* loaded from: classes2.dex */
public class S3ExecutionContext extends ExecutionContext {

    /* renamed from: f, reason: collision with root package name */
    private Signer f18744f;

    public S3ExecutionContext(List list, boolean z10, AmazonWebServiceClient amazonWebServiceClient) {
        super(list, z10, amazonWebServiceClient);
    }

    @Override // com.amazonaws.http.ExecutionContext
    public Signer e(URI uri) {
        return this.f18744f;
    }

    @Override // com.amazonaws.http.ExecutionContext
    public void g(Signer signer) {
        this.f18744f = signer;
    }
}
