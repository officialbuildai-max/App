package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.transform.Unmarshaller;
import java.util.Map;

/* loaded from: classes2.dex */
public class S3XmlResponseHandler<T> extends AbstractS3ResponseHandler<T> {

    /* renamed from: e, reason: collision with root package name */
    private static final Log f18750e = LogFactory.c("com.amazonaws.request");

    /* renamed from: c, reason: collision with root package name */
    private Unmarshaller f18751c;

    /* renamed from: d, reason: collision with root package name */
    private Map f18752d;

    public S3XmlResponseHandler(Unmarshaller unmarshaller) {
        this.f18751c = unmarshaller;
    }

    @Override // com.amazonaws.http.HttpResponseHandler
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public AmazonWebServiceResponse a(HttpResponse httpResponse) {
        AmazonWebServiceResponse c11 = c(httpResponse);
        this.f18752d = httpResponse.c();
        if (this.f18751c != null) {
            Log log = f18750e;
            log.k("Beginning to parse service response XML");
            Object a11 = this.f18751c.a(httpResponse.b());
            log.k("Done parsing service response XML");
            c11.d(a11);
        }
        return c11;
    }
}
