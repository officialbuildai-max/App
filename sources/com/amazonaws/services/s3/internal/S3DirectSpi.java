package com.amazonaws.services.s3.internal;

import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;

/* loaded from: classes2.dex */
public interface S3DirectSpi {
    UploadPartResult a(UploadPartRequest uploadPartRequest);
}
