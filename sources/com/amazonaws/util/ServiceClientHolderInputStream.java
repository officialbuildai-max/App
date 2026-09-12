package com.amazonaws.util;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.internal.SdkFilterInputStream;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class ServiceClientHolderInputStream extends SdkFilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private AmazonWebServiceClient f19085a;

    public ServiceClientHolderInputStream(InputStream inputStream, AmazonWebServiceClient amazonWebServiceClient) {
        super(inputStream);
        this.f19085a = amazonWebServiceClient;
    }
}
