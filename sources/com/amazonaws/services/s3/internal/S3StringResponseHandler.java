package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.util.StringUtils;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class S3StringResponseHandler extends AbstractS3ResponseHandler<String> {
    @Override // com.amazonaws.http.HttpResponseHandler
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public AmazonWebServiceResponse a(HttpResponse httpResponse) {
        AmazonWebServiceResponse c11 = c(httpResponse);
        byte[] bArr = new byte[1024];
        StringBuilder sb2 = new StringBuilder();
        InputStream b11 = httpResponse.b();
        while (true) {
            int read = b11.read(bArr);
            if (read <= 0) {
                c11.d(sb2.toString());
                return c11;
            }
            sb2.append(new String(bArr, 0, read, StringUtils.f19086a));
        }
    }
}
