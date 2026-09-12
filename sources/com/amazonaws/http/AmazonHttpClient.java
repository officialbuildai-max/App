package com.amazonaws.http;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.RequestClientOptions;
import com.amazonaws.Response;
import com.amazonaws.handlers.CredentialsRequestHandler;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.internal.CRC32MismatchException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.TimingInfo;
import com.amazonaws.util.URIBuilder;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class AmazonHttpClient {

    /* renamed from: e, reason: collision with root package name */
    private static final Log f18460e = LogFactory.c("com.amazonaws.request");

    /* renamed from: f, reason: collision with root package name */
    static final Log f18461f = LogFactory.b(AmazonHttpClient.class);

    /* renamed from: a, reason: collision with root package name */
    final HttpClient f18462a;

    /* renamed from: b, reason: collision with root package name */
    final ClientConfiguration f18463b;

    /* renamed from: d, reason: collision with root package name */
    private final HttpRequestFactory f18465d = new HttpRequestFactory();

    /* renamed from: c, reason: collision with root package name */
    private final RequestMetricCollector f18464c = null;

    public AmazonHttpClient(ClientConfiguration clientConfiguration, HttpClient httpClient) {
        this.f18463b = clientConfiguration;
        this.f18462a = httpClient;
    }

    static String c(String str, String str2) {
        if (str.contains(str2)) {
            return str;
        }
        return str.trim() + " " + str2.trim();
    }

    private String g(String str) {
        return str.substring(str.indexOf("(") + 1, str.contains(" + 15") ? str.indexOf(" + 15") : str.indexOf(" - 15"));
    }

    private Throwable j(Throwable th2, AWSRequestMetrics aWSRequestMetrics) {
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.Exception;
        aWSRequestMetrics.d(field);
        aWSRequestMetrics.a(field, th2);
        return th2;
    }

    private boolean k(HttpResponse httpResponse) {
        int e11 = httpResponse.e();
        return e11 >= 200 && e11 < 300;
    }

    private static boolean l(HttpResponse httpResponse) {
        int e11 = httpResponse.e();
        String str = (String) httpResponse.c().get(HttpHeaders.LOCATION);
        return (e11 != 307 || str == null || str.isEmpty()) ? false : true;
    }

    private long n(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i11, RetryPolicy retryPolicy) {
        int i12 = i11 - 2;
        long a11 = retryPolicy.a().a(amazonWebServiceRequest, amazonClientException, i12);
        Log log = f18461f;
        if (log.b()) {
            log.a("Retriable error detected, will retry in " + a11 + "ms, attempt number: " + i12);
        }
        try {
            Thread.sleep(a11);
            return a11;
        } catch (InterruptedException e11) {
            Thread.currentThread().interrupt();
            throw new AmazonClientException(e11.getMessage(), e11);
        }
    }

    private boolean r(AmazonWebServiceRequest amazonWebServiceRequest, InputStream inputStream, AmazonClientException amazonClientException, int i11, RetryPolicy retryPolicy) {
        int i12 = i11 - 1;
        int b11 = this.f18463b.b();
        if (b11 < 0 || !retryPolicy.d()) {
            b11 = retryPolicy.b();
        }
        if (i12 >= b11) {
            return false;
        }
        if (inputStream == null || inputStream.markSupported()) {
            return retryPolicy.c().a(amazonWebServiceRequest, amazonClientException, i12);
        }
        Log log = f18461f;
        if (log.b()) {
            log.a("Content not repeatable");
        }
        return false;
    }

    void a(Request request, Response response, List list, AmazonClientException amazonClientException) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((RequestHandler2) it.next()).b(request, response, amazonClientException);
        }
    }

    void b(Request request, List list, Response response, TimingInfo timingInfo) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((RequestHandler2) it.next()).c(request, response);
        }
    }

    public Response d(Request request, HttpResponseHandler httpResponseHandler, HttpResponseHandler httpResponseHandler2, ExecutionContext executionContext) {
        Response response;
        if (request.j() != null) {
            try {
                URI r11 = request.r();
                request.s(URIBuilder.b(r11).c(request.j() + r11.getHost()).a());
            } catch (URISyntaxException e11) {
                Log log = f18461f;
                if (log.b()) {
                    log.g("Failed to prepend host prefix: " + e11.getMessage(), e11);
                }
            }
        }
        if (executionContext == null) {
            throw new AmazonClientException("Internal SDK Error: No execution context parameter specified.");
        }
        List o11 = o(request, executionContext);
        AWSRequestMetrics a11 = executionContext.a();
        try {
            response = e(request, httpResponseHandler, httpResponseHandler2, executionContext);
        } catch (AmazonClientException e12) {
            e = e12;
            response = null;
        }
        try {
            b(request, o11, response, a11.c().c());
            return response;
        } catch (AmazonClientException e13) {
            e = e13;
            a(request, response, o11, e);
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x03ec A[Catch: all -> 0x03ab, TRY_ENTER, TryCatch #6 {all -> 0x03ab, blocks: (B:61:0x03e2, B:64:0x03ec, B:65:0x0402, B:67:0x0444, B:81:0x0470, B:246:0x03a5, B:247:0x03aa), top: B:60:0x03e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0444 A[Catch: all -> 0x03ab, TRY_LEAVE, TryCatch #6 {all -> 0x03ab, blocks: (B:61:0x03e2, B:64:0x03ec, B:65:0x0402, B:67:0x0444, B:81:0x0470, B:246:0x03a5, B:247:0x03aa), top: B:60:0x03e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0470 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    com.amazonaws.Response e(com.amazonaws.Request r27, com.amazonaws.http.HttpResponseHandler r28, com.amazonaws.http.HttpResponseHandler r29, com.amazonaws.http.ExecutionContext r30) {
        /*
            Method dump skipped, instructions count: 1162
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.http.AmazonHttpClient.e(com.amazonaws.Request, com.amazonaws.http.HttpResponseHandler, com.amazonaws.http.HttpResponseHandler, com.amazonaws.http.ExecutionContext):com.amazonaws.Response");
    }

    public RequestMetricCollector f() {
        return this.f18464c;
    }

    protected void finalize() {
        s();
        super.finalize();
    }

    AmazonServiceException h(Request request, HttpResponseHandler httpResponseHandler, HttpResponse httpResponse) {
        AmazonServiceException amazonServiceException;
        int e11 = httpResponse.e();
        try {
            amazonServiceException = (AmazonServiceException) httpResponseHandler.a(httpResponse);
            f18460e.a("Received error response: " + amazonServiceException.toString());
        } catch (Exception e12) {
            if (e11 == 413) {
                amazonServiceException = new AmazonServiceException("Request entity too large");
                amazonServiceException.setServiceName(request.d());
                amazonServiceException.setStatusCode(TTAdConstant.VIDEO_INFO_CODE);
                amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Client);
                amazonServiceException.setErrorCode("Request entity too large");
            } else {
                if (e11 != 503 || !"Service Unavailable".equalsIgnoreCase(httpResponse.f())) {
                    if (e12 instanceof IOException) {
                        throw ((IOException) e12);
                    }
                    throw new AmazonClientException("Unable to unmarshall error response (" + e12.getMessage() + "). Response Code: " + e11 + ", Response Text: " + httpResponse.f() + ", Response Headers: " + httpResponse.c(), e12);
                }
                amazonServiceException = new AmazonServiceException("Service unavailable");
                amazonServiceException.setServiceName(request.d());
                amazonServiceException.setStatusCode(503);
                amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Service);
                amazonServiceException.setErrorCode("Service unavailable");
            }
        }
        amazonServiceException.setStatusCode(e11);
        amazonServiceException.setServiceName(request.d());
        amazonServiceException.fillInStackTrace();
        return amazonServiceException;
    }

    Object i(Request request, HttpResponseHandler httpResponseHandler, HttpResponse httpResponse, ExecutionContext executionContext) {
        try {
            AWSRequestMetrics a11 = executionContext.a();
            AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ResponseProcessingTime;
            a11.g(field);
            try {
                AmazonWebServiceResponse amazonWebServiceResponse = (AmazonWebServiceResponse) httpResponseHandler.a(httpResponse);
                a11.b(field);
                if (amazonWebServiceResponse == null) {
                    throw new RuntimeException("Unable to unmarshall response metadata. Response Code: " + httpResponse.e() + ", Response Text: " + httpResponse.f());
                }
                Log log = f18460e;
                if (log.b()) {
                    log.a("Received successful response: " + httpResponse.e() + ", AWS Request ID: " + amazonWebServiceResponse.a());
                }
                a11.a(AWSRequestMetrics.Field.AWSRequestID, amazonWebServiceResponse.a());
                return amazonWebServiceResponse.b();
            } catch (Throwable th2) {
                a11.b(AWSRequestMetrics.Field.ResponseProcessingTime);
                throw th2;
            }
        } catch (CRC32MismatchException e11) {
            throw e11;
        } catch (IOException e12) {
            throw e12;
        } catch (Exception e13) {
            throw new AmazonClientException("Unable to unmarshall response (" + e13.getMessage() + "). Response Code: " + httpResponse.e() + ", Response Text: " + httpResponse.f(), e13);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v13, types: [int] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    int m(HttpResponse httpResponse, AmazonServiceException amazonServiceException) {
        Date i11;
        Date date = new Date();
        String str = (String) httpResponse.c().get(HttpHeaders.DATE);
        try {
            if (str != 0) {
                try {
                    if (!str.isEmpty()) {
                        i11 = DateUtils.i(str);
                        str = (int) ((date.getTime() - i11.getTime()) / 1000);
                        return str;
                    }
                } catch (RuntimeException e11) {
                    e = e11;
                    str = 0;
                    f18461f.i("Unable to parse clock skew offset from response: " + str, e);
                    return 0;
                }
            }
            i11 = DateUtils.g(g(amazonServiceException.getMessage()));
            str = (int) ((date.getTime() - i11.getTime()) / 1000);
            return str;
        } catch (RuntimeException e12) {
            e = e12;
        }
    }

    List o(Request request, ExecutionContext executionContext) {
        List<RequestHandler2> d11 = executionContext.d();
        if (d11 == null) {
            return Collections.emptyList();
        }
        for (RequestHandler2 requestHandler2 : d11) {
            if (requestHandler2 instanceof CredentialsRequestHandler) {
                ((CredentialsRequestHandler) requestHandler2).e(executionContext.c());
            }
            requestHandler2.d(request);
        }
        return d11;
    }

    void p(Request request, Exception exc) {
        if (request.getContent() == null) {
            return;
        }
        if (!request.getContent().markSupported()) {
            throw new AmazonClientException("Encountered an exception and stream is not resettable", exc);
        }
        try {
            request.getContent().reset();
        } catch (IOException unused) {
            throw new AmazonClientException("Encountered an exception and couldn't reset the stream to retry", exc);
        }
    }

    void q(Request request) {
        RequestClientOptions requestClientOptions;
        String c11;
        String str = ClientConfiguration.f18364u;
        AmazonWebServiceRequest l11 = request.l();
        String c12 = (l11 == null || (requestClientOptions = l11.getRequestClientOptions()) == null || (c11 = requestClientOptions.c(RequestClientOptions.Marker.USER_AGENT)) == null) ? str : c(str, c11);
        if (!str.equals(this.f18463b.h())) {
            c12 = c(c12, this.f18463b.h());
        }
        if (this.f18463b.i() != null) {
            c12 = this.f18463b.i();
        }
        request.addHeader("User-Agent", c12);
    }

    public void s() {
        this.f18462a.shutdown();
    }
}
