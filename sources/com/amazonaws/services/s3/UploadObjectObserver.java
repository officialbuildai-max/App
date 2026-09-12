package com.amazonaws.services.s3;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.internal.PartCreationEvent;
import com.amazonaws.services.s3.internal.S3DirectSpi;
import com.amazonaws.services.s3.model.UploadObjectRequest;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class UploadObjectObserver {

    /* renamed from: a, reason: collision with root package name */
    private final List f18691a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private UploadObjectRequest f18692b;

    /* renamed from: c, reason: collision with root package name */
    private String f18693c;

    /* renamed from: d, reason: collision with root package name */
    private S3DirectSpi f18694d;

    /* renamed from: e, reason: collision with root package name */
    private ExecutorService f18695e;

    protected AmazonWebServiceRequest a(AmazonWebServiceRequest amazonWebServiceRequest, String str) {
        amazonWebServiceRequest.getRequestClientOptions().a(str);
        return amazonWebServiceRequest;
    }

    protected UploadPartRequest b(PartCreationEvent partCreationEvent, File file) {
        return new UploadPartRequest().withBucketName(this.f18692b.getBucketName()).withFile(file).withKey(this.f18692b.getKey()).withPartNumber(partCreationEvent.c()).withPartSize(file.length()).withLastPart(partCreationEvent.d()).withUploadId(this.f18693c).withObjectMetadata(this.f18692b.getUploadPartMetadata());
    }

    public void c(PartCreationEvent partCreationEvent) {
        final File b11 = partCreationEvent.b();
        final UploadPartRequest b12 = b(partCreationEvent, b11);
        final OnFileDelete a11 = partCreationEvent.a();
        a(b12, AmazonS3EncryptionClient.f18676w);
        this.f18691a.add(this.f18695e.submit(new Callable<UploadPartResult>() { // from class: com.amazonaws.services.s3.UploadObjectObserver.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public UploadPartResult call() {
                try {
                    UploadPartResult d11 = UploadObjectObserver.this.d(b12);
                    if (b11.delete()) {
                        OnFileDelete onFileDelete = a11;
                        if (onFileDelete != null) {
                            onFileDelete.b(null);
                        }
                    } else {
                        LogFactory.b(getClass()).a("Ignoring failure to delete file " + b11 + " which has already been uploaded");
                    }
                    return d11;
                } catch (Throwable th2) {
                    if (b11.delete()) {
                        OnFileDelete onFileDelete2 = a11;
                        if (onFileDelete2 != null) {
                            onFileDelete2.b(null);
                        }
                    } else {
                        LogFactory.b(getClass()).a("Ignoring failure to delete file " + b11 + " which has already been uploaded");
                    }
                    throw th2;
                }
            }
        }));
    }

    protected UploadPartResult d(UploadPartRequest uploadPartRequest) {
        return this.f18694d.a(uploadPartRequest);
    }
}
