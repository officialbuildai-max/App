package com.amazonaws.services.s3.internal;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.S3ResponseMetadata;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.util.DateUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class AbstractS3ResponseHandler<T> implements HttpResponseHandler<AmazonWebServiceResponse<T>> {

    /* renamed from: a, reason: collision with root package name */
    private static final Log f18700a = LogFactory.b(S3MetadataResponseHandler.class);

    /* renamed from: b, reason: collision with root package name */
    private static final Set f18701b;

    static {
        HashSet hashSet = new HashSet();
        f18701b = hashSet;
        hashSet.add(HttpHeaders.DATE);
        hashSet.add("Server");
        hashSet.add("x-amz-request-id");
        hashSet.add("x-amz-id-2");
        hashSet.add("X-Amz-Cf-Id");
        hashSet.add("Connection");
    }

    @Override // com.amazonaws.http.HttpResponseHandler
    public boolean b() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AmazonWebServiceResponse c(HttpResponse httpResponse) {
        AmazonWebServiceResponse amazonWebServiceResponse = new AmazonWebServiceResponse();
        String str = (String) httpResponse.c().get("x-amz-request-id");
        String str2 = (String) httpResponse.c().get("x-amz-id-2");
        String str3 = (String) httpResponse.c().get("X-Amz-Cf-Id");
        HashMap hashMap = new HashMap();
        hashMap.put("AWS_REQUEST_ID", str);
        hashMap.put("HOST_ID", str2);
        hashMap.put("CLOUD_FRONT_ID", str3);
        amazonWebServiceResponse.c(new S3ResponseMetadata(hashMap));
        return amazonWebServiceResponse;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(HttpResponse httpResponse, ObjectMetadata objectMetadata) {
        for (Map.Entry entry : httpResponse.c().entrySet()) {
            String str = (String) entry.getKey();
            if (str.startsWith("x-amz-meta-")) {
                objectMetadata.addUserMetadata(str.substring(11), (String) entry.getValue());
            } else if (f18701b.contains(str)) {
                f18700a.a(String.format("%s is ignored.", str));
            } else if (str.equalsIgnoreCase("Last-Modified")) {
                try {
                    objectMetadata.setHeader(str, ServiceUtils.e((String) entry.getValue()));
                } catch (Exception e11) {
                    f18700a.i("Unable to parse last modified date: " + ((String) entry.getValue()), e11);
                }
            } else if (str.equalsIgnoreCase(HttpHeaders.CONTENT_LENGTH)) {
                try {
                    objectMetadata.setHeader(str, Long.valueOf(Long.parseLong((String) entry.getValue())));
                } catch (NumberFormatException e12) {
                    f18700a.i("Unable to parse content length: " + ((String) entry.getValue()), e12);
                }
            } else if (str.equalsIgnoreCase("ETag")) {
                objectMetadata.setHeader(str, ServiceUtils.f((String) entry.getValue()));
            } else if (str.equalsIgnoreCase(HttpHeaders.EXPIRES)) {
                try {
                    objectMetadata.setHttpExpiresDate(DateUtils.i((String) entry.getValue()));
                } catch (Exception e13) {
                    f18700a.i("Unable to parse http expiration date: " + ((String) entry.getValue()), e13);
                }
            } else if (str.equalsIgnoreCase("x-amz-expiration")) {
                new ObjectExpirationHeaderHandler().a(objectMetadata, httpResponse);
            } else if (str.equalsIgnoreCase("x-amz-restore")) {
                new ObjectRestoreHeaderHandler().a(objectMetadata, httpResponse);
            } else if (str.equalsIgnoreCase("x-amz-request-charged")) {
                new S3RequesterChargedHeaderHandler().a(objectMetadata, httpResponse);
            } else if (str.equalsIgnoreCase("x-amz-mp-parts-count")) {
                try {
                    objectMetadata.setHeader(str, Integer.valueOf(Integer.parseInt((String) entry.getValue())));
                } catch (NumberFormatException e14) {
                    throw new AmazonClientException("Unable to parse part count. Header x-amz-mp-parts-count has corrupted data" + e14.getMessage(), e14);
                }
            } else {
                objectMetadata.setHeader(str, entry.getValue());
            }
        }
    }
}
