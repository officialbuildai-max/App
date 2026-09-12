package com.amazonaws.services.s3;

import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.amazonaws.AbortedException;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.Signer;
import com.amazonaws.auth.SignerFactory;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListenerCallbackExecutor;
import com.amazonaws.event.ProgressReportingInputStream;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpClient;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.http.UrlHttpClient;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.RegionUtils;
import com.amazonaws.retry.PredefinedRetryPolicies;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.services.s3.internal.AWSS3V4Signer;
import com.amazonaws.services.s3.internal.BucketNameUtils;
import com.amazonaws.services.s3.internal.CompleteMultipartUploadRetryCondition;
import com.amazonaws.services.s3.internal.DigestValidationInputStream;
import com.amazonaws.services.s3.internal.InputSubstream;
import com.amazonaws.services.s3.internal.MD5DigestCalculatingInputStream;
import com.amazonaws.services.s3.internal.ObjectExpirationHeaderHandler;
import com.amazonaws.services.s3.internal.RepeatableFileInputStream;
import com.amazonaws.services.s3.internal.ResponseHeaderHandlerChain;
import com.amazonaws.services.s3.internal.S3ErrorResponseHandler;
import com.amazonaws.services.s3.internal.S3ExecutionContext;
import com.amazonaws.services.s3.internal.S3HttpUtils;
import com.amazonaws.services.s3.internal.S3MetadataResponseHandler;
import com.amazonaws.services.s3.internal.S3ObjectResponseHandler;
import com.amazonaws.services.s3.internal.S3RequesterChargedHeaderHandler;
import com.amazonaws.services.s3.internal.S3Signer;
import com.amazonaws.services.s3.internal.S3VersionHeaderHandler;
import com.amazonaws.services.s3.internal.S3XmlResponseHandler;
import com.amazonaws.services.s3.internal.ServerSideEncryptionHeaderHandler;
import com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazonaws.services.s3.metrics.S3ServiceMetric;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.Grant;
import com.amazonaws.services.s3.model.Grantee;
import com.amazonaws.services.s3.model.HeadBucketRequest;
import com.amazonaws.services.s3.model.HeadBucketResult;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.ObjectTagging;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.ResponseHeaderOverrides;
import com.amazonaws.services.s3.model.S3AccelerateUnsupported;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.SSEAwsKeyManagementParams;
import com.amazonaws.services.s3.model.SSECustomerKey;
import com.amazonaws.services.s3.model.Tag;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import com.amazonaws.services.s3.model.transform.BucketConfigurationXmlFactory;
import com.amazonaws.services.s3.model.transform.HeadBucketResultHandler;
import com.amazonaws.services.s3.model.transform.RequestPaymentConfigurationXmlFactory;
import com.amazonaws.services.s3.model.transform.RequestXmlFactory;
import com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser;
import com.amazonaws.services.s3.util.Mimetypes;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AwsHostNameUtils;
import com.amazonaws.util.Base64;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.LengthCheckInputStream;
import com.amazonaws.util.Md5Utils;
import com.amazonaws.util.RuntimeHttpUtils;
import com.amazonaws.util.ServiceClientHolderInputStream;
import com.amazonaws.util.ValidationUtils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class AmazonS3Client extends AmazonWebServiceClient implements AmazonS3 {

    /* renamed from: s, reason: collision with root package name */
    private static Log f18665s = LogFactory.b(AmazonS3Client.class);

    /* renamed from: t, reason: collision with root package name */
    private static final BucketConfigurationXmlFactory f18666t;

    /* renamed from: u, reason: collision with root package name */
    private static final RequestPaymentConfigurationXmlFactory f18667u;

    /* renamed from: v, reason: collision with root package name */
    private static final Map f18668v;

    /* renamed from: l, reason: collision with root package name */
    private final S3ErrorResponseHandler f18669l;

    /* renamed from: m, reason: collision with root package name */
    private final S3XmlResponseHandler f18670m;

    /* renamed from: n, reason: collision with root package name */
    protected S3ClientOptions f18671n;

    /* renamed from: o, reason: collision with root package name */
    private final AWSCredentialsProvider f18672o;

    /* renamed from: p, reason: collision with root package name */
    volatile String f18673p;

    /* renamed from: q, reason: collision with root package name */
    private int f18674q;

    /* renamed from: r, reason: collision with root package name */
    private final CompleteMultipartUploadRetryCondition f18675r;

    static {
        AwsSdkMetrics.addAll(Arrays.asList(S3ServiceMetric.b()));
        SignerFactory.e("AWSS3V4SignerType", AWSS3V4Signer.class);
        f18666t = new BucketConfigurationXmlFactory();
        f18667u = new RequestPaymentConfigurationXmlFactory();
        f18668v = Collections.synchronizedMap(new LinkedHashMap<String, String>(300, 1.1f, true) { // from class: com.amazonaws.services.s3.AmazonS3Client.1
            private static final long serialVersionUID = 23453;

            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry<String, String> entry) {
                return size() > 300;
            }
        });
    }

    @Deprecated
    public AmazonS3Client() {
        this(new DefaultAWSCredentialsProviderChain());
    }

    public AmazonS3Client(AWSCredentials aWSCredentials, Region region) {
        this(aWSCredentials, region, new ClientConfiguration());
    }

    public AmazonS3Client(AWSCredentials aWSCredentials, Region region, ClientConfiguration clientConfiguration) {
        this(aWSCredentials, region, clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    public AmazonS3Client(AWSCredentials aWSCredentials, Region region, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        this(new StaticCredentialsProvider(aWSCredentials), region, clientConfiguration, httpClient);
    }

    public AmazonS3Client(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AmazonS3Client(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    public AmazonS3Client(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(clientConfiguration, httpClient);
        this.f18669l = new S3ErrorResponseHandler();
        this.f18670m = new S3XmlResponseHandler(null);
        this.f18671n = new S3ClientOptions();
        this.f18674q = 1024;
        this.f18675r = new CompleteMultipartUploadRetryCondition();
        this.f18672o = aWSCredentialsProvider;
        Q();
    }

    public AmazonS3Client(AWSCredentialsProvider aWSCredentialsProvider, Region region, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(clientConfiguration, httpClient);
        this.f18669l = new S3ErrorResponseHandler();
        this.f18670m = new S3XmlResponseHandler(null);
        this.f18671n = new S3ClientOptions();
        this.f18674q = 1024;
        this.f18675r = new CompleteMultipartUploadRetryCondition();
        this.f18672o = aWSCredentialsProvider;
        R(region, clientConfiguration);
    }

    private static void A(Request request, String str, String str2) {
        if (str2 != null) {
            request.addHeader(str, str2);
        }
    }

    private static void B(Request request, ResponseHeaderOverrides responseHeaderOverrides) {
        if (responseHeaderOverrides != null) {
            if (responseHeaderOverrides.b() != null) {
                request.g(RequestParameters.RESPONSE_HEADER_CACHE_CONTROL, responseHeaderOverrides.b());
            }
            if (responseHeaderOverrides.c() != null) {
                request.g(RequestParameters.RESPONSE_HEADER_CONTENT_DISPOSITION, responseHeaderOverrides.c());
            }
            if (responseHeaderOverrides.e() != null) {
                request.g(RequestParameters.RESPONSE_HEADER_CONTENT_ENCODING, responseHeaderOverrides.e());
            }
            if (responseHeaderOverrides.f() != null) {
                request.g(RequestParameters.RESPONSE_HEADER_CONTENT_LANGUAGE, responseHeaderOverrides.f());
            }
            if (responseHeaderOverrides.getContentType() != null) {
                request.g(RequestParameters.RESPONSE_HEADER_CONTENT_TYPE, responseHeaderOverrides.getContentType());
            }
            if (responseHeaderOverrides.g() != null) {
                request.g(RequestParameters.RESPONSE_HEADER_EXPIRES, responseHeaderOverrides.g());
            }
        }
    }

    private static void C(Request request, String str, List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        request.addHeader(str, ServiceUtils.c(list));
    }

    private long D(InputStream inputStream) {
        byte[] bArr = new byte[8192];
        inputStream.mark(-1);
        long j11 = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    inputStream.reset();
                    return j11;
                }
                j11 += read;
            } catch (IOException e11) {
                throw new AmazonClientException("Could not calculate content length.", e11);
            }
        }
    }

    private URI E(URI uri, String str) {
        try {
            return new URI(uri.getScheme() + "://" + str + "." + uri.getAuthority());
        } catch (URISyntaxException e11) {
            throw new IllegalArgumentException("Invalid bucket name: " + str, e11);
        }
    }

    private S3Signer I(Request request, String str, String str2) {
        String str3;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("/");
        if (str != null) {
            str3 = str + "/";
        } else {
            str3 = "";
        }
        sb2.append(str3);
        if (str2 == null) {
            str2 = "";
        }
        sb2.append(str2);
        return new S3Signer(request.m().toString(), sb2.toString());
    }

    private String K(String str) {
        Map map = f18668v;
        String str2 = (String) map.get(str);
        if (str2 == null) {
            if (f18665s.b()) {
                f18665s.a("Bucket region cache doesn't have an entry for " + str + ". Trying to get bucket region from Amazon S3.");
            }
            str2 = M(str);
            if (str2 != null) {
                map.put(str, str2);
            }
        }
        if (f18665s.b()) {
            f18665s.a("Region for " + str + " is " + str2);
        }
        return str2;
    }

    private void L(ProgressListenerCallbackExecutor progressListenerCallbackExecutor, int i11) {
        if (progressListenerCallbackExecutor == null) {
            return;
        }
        ProgressEvent progressEvent = new ProgressEvent(0L);
        progressEvent.c(i11);
        progressListenerCallbackExecutor.c(progressEvent);
    }

    private String M(String str) {
        String str2 = null;
        try {
            str2 = ((HeadBucketResult) S(H(str, null, new HeadBucketRequest(str), HttpMethodName.HEAD, new URI("https://s3-us-west-1.amazonaws.com")), new HeadBucketResultHandler(), str, null)).a();
        } catch (AmazonS3Exception e11) {
            if (e11.getAdditionalDetails() != null) {
                str2 = e11.getAdditionalDetails().get("x-amz-bucket-region");
            }
        } catch (URISyntaxException unused) {
            f18665s.j("Error while creating URI");
        }
        if (str2 == null && f18665s.b()) {
            f18665s.a("Not able to derive region of the " + str + " from the HEAD Bucket requests.");
        }
        return str2;
    }

    private String N(String str) {
        if (str == null || !str.startsWith("/")) {
            return str;
        }
        return "/" + str;
    }

    private String O(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("/");
        if (str2 == null) {
            str2 = "";
        }
        sb2.append(str2);
        return sb2.toString();
    }

    private String P() {
        String q11 = q();
        return q11 == null ? this.f18673p : q11;
    }

    private void Q() {
        v("s3.amazonaws.com");
        this.f18360i = "s3";
        HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
        this.f18356e.addAll(handlerChainFactory.c("/com/amazonaws/services/s3/request.handlers"));
        this.f18356e.addAll(handlerChainFactory.b("/com/amazonaws/services/s3/request.handler2s"));
    }

    private void R(Region region, ClientConfiguration clientConfiguration) {
        if (this.f18672o == null) {
            throw new IllegalArgumentException("Credentials cannot be null. Credentials is required to sign the request");
        }
        if (region == null) {
            throw new IllegalArgumentException("Region cannot be null. Region is required to sign the request");
        }
        this.f18354c = clientConfiguration;
        this.f18360i = "s3";
        v("s3.amazonaws.com");
        w(region);
        HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
        this.f18356e.addAll(handlerChainFactory.c("/com/amazonaws/services/s3/request.handlers"));
        this.f18356e.addAll(handlerChainFactory.b("/com/amazonaws/services/s3/request.handler2s"));
        f18665s.a("initialized with endpoint = " + this.f18352a);
    }

    private Object S(Request request, HttpResponseHandler httpResponseHandler, String str, String str2) {
        AmazonWebServiceRequest l11 = request.l();
        ExecutionContext F = F(l11);
        AWSRequestMetrics a11 = F.a();
        request.h(a11);
        a11.g(AWSRequestMetrics.Field.ClientExecuteTime);
        Response response = null;
        try {
            try {
                request.e(this.f18357f);
                if (!request.getHeaders().containsKey(HttpHeaders.CONTENT_TYPE)) {
                    request.addHeader(HttpHeaders.CONTENT_TYPE, OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
                }
                if (str != null) {
                    request.l();
                    if (W(request)) {
                        K(str);
                    }
                }
                AWSCredentials a12 = this.f18672o.a();
                if (l11.getRequestCredentials() != null) {
                    a12 = l11.getRequestCredentials();
                }
                F.g(J(request, str, str2));
                F.f(a12);
                response = this.f18355d.d(request, httpResponseHandler, this.f18669l, F);
                Object a13 = response.a();
                j(a11, request, response);
                return a13;
            } catch (AmazonS3Exception e11) {
                if (e11.getStatusCode() == 301 && e11.getAdditionalDetails() != null) {
                    String str3 = e11.getAdditionalDetails().get("x-amz-bucket-region");
                    f18668v.put(str, str3);
                    e11.setErrorMessage("The bucket is in this region: " + str3 + ". Please use this region to retry the request");
                }
                throw e11;
            }
        } catch (Throwable th2) {
            j(a11, request, response);
            throw th2;
        }
    }

    private boolean T() {
        ClientConfiguration clientConfiguration = this.f18354c;
        return (clientConfiguration == null || clientConfiguration.e() == null) ? false : true;
    }

    private boolean U(URI uri) {
        return uri.getHost().endsWith("s3.amazonaws.com");
    }

    static boolean V(String str) {
        if (str == null) {
            return false;
        }
        String[] split = str.split("\\.");
        if (split.length != 4) {
            return false;
        }
        for (String str2 : split) {
            try {
                int parseInt = Integer.parseInt(str2);
                int i11 = (parseInt >= 0 && parseInt <= 255) ? i11 + 1 : 0;
            } catch (NumberFormatException unused) {
            }
            return false;
        }
        return true;
    }

    private boolean W(Request request) {
        return U(request.r()) && P() == null;
    }

    protected static void X(Request request, ObjectMetadata objectMetadata) {
        Map<String, Object> rawMetadata = objectMetadata.getRawMetadata();
        if (rawMetadata.get("x-amz-server-side-encryption-aws-kms-key-id") != null && !ObjectMetadata.KMS_SERVER_SIDE_ENCRYPTION.equals(rawMetadata.get("x-amz-server-side-encryption"))) {
            throw new IllegalArgumentException("If you specify a KMS key id for server side encryption, you must also set the SSEAlgorithm to ObjectMetadata.KMS_SERVER_SIDE_ENCRYPTION");
        }
        for (Map.Entry<String, Object> entry : rawMetadata.entrySet()) {
            request.addHeader(entry.getKey(), entry.getValue().toString());
        }
        Date httpExpiresDate = objectMetadata.getHttpExpiresDate();
        if (httpExpiresDate != null) {
            request.addHeader(HttpHeaders.EXPIRES, DateUtils.d(httpExpiresDate));
        }
        Map<String, String> userMetadata = objectMetadata.getUserMetadata();
        if (userMetadata != null) {
            for (Map.Entry<String, String> entry2 : userMetadata.entrySet()) {
                String key = entry2.getKey();
                String value = entry2.getValue();
                if (key != null) {
                    key = key.trim();
                }
                if (value != null) {
                    value = value.trim();
                }
                if (!"x-amz-tagging".equals(key)) {
                    request.addHeader("x-amz-meta-" + key, value);
                }
            }
        }
    }

    protected static void Y(Request request, boolean z10) {
        if (z10) {
            request.addHeader("x-amz-request-payer", "requester");
        }
    }

    private static void Z(Request request, SSECustomerKey sSECustomerKey) {
        if (sSECustomerKey == null) {
            return;
        }
        A(request, "x-amz-server-side-encryption-customer-algorithm", sSECustomerKey.b());
        A(request, "x-amz-server-side-encryption-customer-key", sSECustomerKey.c());
        A(request, "x-amz-server-side-encryption-customer-key-MD5", sSECustomerKey.d());
        if (sSECustomerKey.c() == null || sSECustomerKey.d() != null) {
            return;
        }
        request.addHeader("x-amz-server-side-encryption-customer-key-MD5", Md5Utils.e(Base64.decode(sSECustomerKey.c())));
    }

    private static void a0(Request request, SSEAwsKeyManagementParams sSEAwsKeyManagementParams) {
        if (sSEAwsKeyManagementParams != null) {
            A(request, "x-amz-server-side-encryption", sSEAwsKeyManagementParams.getEncryption());
            A(request, "x-amz-server-side-encryption-aws-kms-key-id", sSEAwsKeyManagementParams.getAwsKmsKeyId());
        }
    }

    private void c0(AWSS3V4Signer aWSS3V4Signer, String str) {
        aWSS3V4Signer.a(o());
        aWSS3V4Signer.c(str);
    }

    private void e0(Request request) {
        request.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(0));
    }

    private boolean f0(AmazonWebServiceRequest amazonWebServiceRequest, AmazonS3Exception amazonS3Exception, int i11) {
        RetryPolicy d11 = this.f18354c.d();
        if (d11 == null || d11.c() == null || d11 == PredefinedRetryPolicies.f18651a) {
            return false;
        }
        return this.f18675r.a(amazonWebServiceRequest, amazonS3Exception, i11);
    }

    private boolean g0(URI uri, String str) {
        return (this.f18671n.e() || !BucketNameUtils.isDNSBucketName(str) || V(uri.getHost())) ? false : true;
    }

    private ByteArrayInputStream h0(InputStream inputStream) {
        int i11 = 262144;
        byte[] bArr = new byte[262144];
        int i12 = 0;
        while (i11 > 0) {
            try {
                int read = inputStream.read(bArr, i12, i11);
                if (read == -1) {
                    break;
                }
                i12 += read;
                i11 -= read;
            } catch (IOException e11) {
                throw new AmazonClientException("Failed to read from inputstream", e11);
            }
        }
        if (inputStream.read() != -1) {
            throw new AmazonClientException("Input stream exceeds 256k buffer.");
        }
        inputStream.close();
        return new ByteArrayInputStream(bArr, 0, i12);
    }

    private String i0(ObjectTagging objectTagging) {
        if (objectTagging == null || objectTagging.getTagSet() == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<Tag> it = objectTagging.getTagSet().iterator();
        while (it.hasNext()) {
            Tag next = it.next();
            sb2.append(S3HttpUtils.b(next.getKey(), false));
            sb2.append('=');
            sb2.append(S3HttpUtils.b(next.getValue(), false));
            if (it.hasNext()) {
                sb2.append(UrlUtils.AND_MARK);
            }
        }
        return sb2.toString();
    }

    private static void y(Request request, AccessControlList accessControlList) {
        Set<Grant> grants = accessControlList.getGrants();
        HashMap hashMap = new HashMap();
        for (Grant grant : grants) {
            if (!hashMap.containsKey(grant.b())) {
                hashMap.put(grant.b(), new LinkedList());
            }
            ((Collection) hashMap.get(grant.b())).add(grant.a());
        }
        for (Permission permission : Permission.values()) {
            if (hashMap.containsKey(permission)) {
                Collection<Grantee> collection = (Collection) hashMap.get(permission);
                StringBuilder sb2 = new StringBuilder();
                boolean z10 = false;
                for (Grantee grantee : collection) {
                    if (z10) {
                        sb2.append(", ");
                    } else {
                        z10 = true;
                    }
                    sb2.append(grantee.getTypeIdentifier());
                    sb2.append(UrlUtils.EQUAL_MARK);
                    sb2.append("\"");
                    sb2.append(grantee.getIdentifier());
                    sb2.append("\"");
                }
                request.addHeader(permission.getHeaderName(), sb2.toString());
            }
        }
    }

    private static void z(Request request, String str, Date date) {
        if (date != null) {
            request.addHeader(str, ServiceUtils.a(date));
        }
    }

    protected final ExecutionContext F(AmazonWebServiceRequest amazonWebServiceRequest) {
        return new S3ExecutionContext(this.f18356e, t(amazonWebServiceRequest) || AmazonWebServiceClient.r(), this);
    }

    protected Request G(String str, String str2, AmazonWebServiceRequest amazonWebServiceRequest, HttpMethodName httpMethodName) {
        return H(str, str2, amazonWebServiceRequest, httpMethodName, null);
    }

    protected Request H(String str, String str2, AmazonWebServiceRequest amazonWebServiceRequest, HttpMethodName httpMethodName, URI uri) {
        DefaultRequest defaultRequest = new DefaultRequest(amazonWebServiceRequest, "Amazon S3");
        if (this.f18671n.b() && !(defaultRequest.l() instanceof S3AccelerateUnsupported)) {
            uri = this.f18671n.d() ? RuntimeHttpUtils.a("s3-accelerate.dualstack.amazonaws.com", this.f18354c) : RuntimeHttpUtils.a("s3-accelerate.amazonaws.com", this.f18354c);
        }
        defaultRequest.o(httpMethodName);
        b0(defaultRequest, str, str2, uri);
        return defaultRequest;
    }

    protected Signer J(Request request, String str, String str2) {
        Signer p11 = p(this.f18671n.b() ? this.f18352a : request.r());
        if (!T()) {
            if ((p11 instanceof AWSS3V4Signer) && W(request)) {
                String str3 = this.f18673p == null ? (String) f18668v.get(str) : this.f18673p;
                if (str3 != null) {
                    b0(request, str, str2, RuntimeHttpUtils.a(RegionUtils.a(str3).g("s3"), this.f18354c));
                    AWSS3V4Signer aWSS3V4Signer = (AWSS3V4Signer) p11;
                    c0(aWSS3V4Signer, str3);
                    return aWSS3V4Signer;
                }
                if (request.l() instanceof GeneratePresignedUrlRequest) {
                    return I(request, str, str2);
                }
            }
            String q11 = q() == null ? this.f18673p == null ? (String) f18668v.get(str) : this.f18673p : q();
            if (q11 != null) {
                AWSS3V4Signer aWSS3V4Signer2 = new AWSS3V4Signer();
                c0(aWSS3V4Signer2, q11);
                return aWSS3V4Signer2;
            }
        }
        return p11 instanceof S3Signer ? I(request, str, str2) : p11;
    }

    @Override // com.amazonaws.services.s3.AmazonS3, com.amazonaws.services.s3.internal.S3DirectSpi
    public UploadPartResult a(UploadPartRequest uploadPartRequest) {
        InputStream inputSubstream;
        MD5DigestCalculatingInputStream mD5DigestCalculatingInputStream;
        ValidationUtils.a(uploadPartRequest, "The request parameter must be specified when uploading a part");
        String bucketName = uploadPartRequest.getBucketName();
        String key = uploadPartRequest.getKey();
        String uploadId = uploadPartRequest.getUploadId();
        int partNumber = uploadPartRequest.getPartNumber();
        long partSize = uploadPartRequest.getPartSize();
        ValidationUtils.a(bucketName, "The bucket name parameter must be specified when uploading a part");
        ValidationUtils.a(key, "The key parameter must be specified when uploading a part");
        ValidationUtils.a(uploadId, "The upload ID parameter must be specified when uploading a part");
        ValidationUtils.a(Integer.valueOf(partNumber), "The part number parameter must be specified when uploading a part");
        ValidationUtils.a(Long.valueOf(partSize), "The part size parameter must be specified when uploading a part");
        Request G = G(bucketName, key, uploadPartRequest, HttpMethodName.PUT);
        G.g(RequestParameters.UPLOAD_ID, uploadId);
        G.g(RequestParameters.PART_NUMBER, Integer.toString(partNumber));
        ObjectMetadata objectMetadata = uploadPartRequest.getObjectMetadata();
        if (objectMetadata != null) {
            X(G, objectMetadata);
        }
        A(G, HttpHeaders.CONTENT_MD5, uploadPartRequest.getMd5Digest());
        G.addHeader(HttpHeaders.CONTENT_LENGTH, Long.toString(partSize));
        Y(G, uploadPartRequest.isRequesterPays());
        Z(G, uploadPartRequest.getSSECustomerKey());
        if (uploadPartRequest.getInputStream() != null) {
            inputSubstream = uploadPartRequest.getInputStream();
        } else {
            if (uploadPartRequest.getFile() == null) {
                throw new IllegalArgumentException("A File or InputStream must be specified when uploading part");
            }
            try {
                inputSubstream = new InputSubstream(new RepeatableFileInputStream(uploadPartRequest.getFile()), uploadPartRequest.getFileOffset(), partSize, true);
            } catch (FileNotFoundException e11) {
                throw new IllegalArgumentException("The specified file doesn't exist", e11);
            }
        }
        if (uploadPartRequest.getMd5Digest() != null || ServiceUtils.g(uploadPartRequest, this.f18671n)) {
            mD5DigestCalculatingInputStream = null;
        } else {
            mD5DigestCalculatingInputStream = new MD5DigestCalculatingInputStream(inputSubstream);
            inputSubstream = mD5DigestCalculatingInputStream;
        }
        ProgressListenerCallbackExecutor d11 = ProgressListenerCallbackExecutor.d(uploadPartRequest.getGeneralProgressListener());
        if (d11 != null) {
            ProgressReportingInputStream progressReportingInputStream = new ProgressReportingInputStream(inputSubstream, d11);
            progressReportingInputStream.o(this.f18674q);
            L(d11, 1024);
            inputSubstream = progressReportingInputStream;
        }
        try {
            try {
                G.a(inputSubstream);
                ObjectMetadata objectMetadata2 = (ObjectMetadata) S(G, new S3MetadataResponseHandler(), bucketName, key);
                if (objectMetadata2 != null && mD5DigestCalculatingInputStream != null && !ServiceUtils.h(objectMetadata2, this.f18671n) && !Arrays.equals(mD5DigestCalculatingInputStream.m(), BinaryUtils.b(objectMetadata2.getETag()))) {
                    throw new AmazonClientException("Unable to verify integrity of data upload.  Client calculated content hash didn't match hash calculated by Amazon S3.  You may need to delete the data stored in Amazon S3.");
                }
                L(d11, 2048);
                UploadPartResult uploadPartResult = new UploadPartResult();
                uploadPartResult.setETag(objectMetadata2.getETag());
                uploadPartResult.setPartNumber(partNumber);
                uploadPartResult.setSSEAlgorithm(objectMetadata2.getSSEAlgorithm());
                uploadPartResult.setSSECustomerAlgorithm(objectMetadata2.getSSECustomerAlgorithm());
                uploadPartResult.setSSECustomerKeyMd5(objectMetadata2.getSSECustomerKeyMd5());
                uploadPartResult.setRequesterCharged(objectMetadata2.isRequesterCharged());
                if (inputSubstream != null) {
                    try {
                        inputSubstream.close();
                    } catch (Exception unused) {
                    }
                }
                return uploadPartResult;
            } catch (Throwable th2) {
                if (inputSubstream != null) {
                    try {
                        inputSubstream.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th2;
            }
        } catch (AmazonClientException e12) {
            L(d11, 4096);
            throw e12;
        }
    }

    @Override // com.amazonaws.services.s3.AmazonS3
    public CompleteMultipartUploadResult b(CompleteMultipartUploadRequest completeMultipartUploadRequest) {
        ValidationUtils.a(completeMultipartUploadRequest, "The request parameter must be specified when completing a multipart upload");
        String bucketName = completeMultipartUploadRequest.getBucketName();
        String key = completeMultipartUploadRequest.getKey();
        String uploadId = completeMultipartUploadRequest.getUploadId();
        ValidationUtils.a(bucketName, "The bucket name parameter must be specified when completing a multipart upload");
        ValidationUtils.a(key, "The key parameter must be specified when completing a multipart upload");
        ValidationUtils.a(uploadId, "The upload ID parameter must be specified when completing a multipart upload");
        ValidationUtils.a(completeMultipartUploadRequest.getPartETags(), "The part ETags parameter must be specified when completing a multipart upload");
        int i11 = 0;
        while (true) {
            Request G = G(bucketName, key, completeMultipartUploadRequest, HttpMethodName.POST);
            G.g(RequestParameters.UPLOAD_ID, uploadId);
            Y(G, completeMultipartUploadRequest.isRequesterPays());
            byte[] a11 = RequestXmlFactory.a(completeMultipartUploadRequest.getPartETags());
            G.addHeader(HttpHeaders.CONTENT_TYPE, "application/xml");
            G.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(a11.length));
            G.a(new ByteArrayInputStream(a11));
            XmlResponsesSaxParser.CompleteMultipartUploadHandler completeMultipartUploadHandler = (XmlResponsesSaxParser.CompleteMultipartUploadHandler) S(G, new ResponseHeaderHandlerChain(new Unmarshaller<XmlResponsesSaxParser.CompleteMultipartUploadHandler, InputStream>() { // from class: com.amazonaws.services.s3.model.transform.Unmarshallers$CompleteMultipartUploadResultUnmarshaller
                @Override // com.amazonaws.transform.Unmarshaller
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public XmlResponsesSaxParser.CompleteMultipartUploadHandler a(InputStream inputStream) {
                    return new XmlResponsesSaxParser().j(inputStream);
                }
            }, new ServerSideEncryptionHeaderHandler(), new ObjectExpirationHeaderHandler(), new S3VersionHeaderHandler(), new S3RequesterChargedHeaderHandler()), bucketName, key);
            if (completeMultipartUploadHandler.h() != null) {
                return completeMultipartUploadHandler.h();
            }
            int i12 = i11 + 1;
            if (!f0(completeMultipartUploadRequest, completeMultipartUploadHandler.g(), i11)) {
                throw completeMultipartUploadHandler.g();
            }
            i11 = i12;
        }
    }

    public void b0(Request request, String str, String str2, URI uri) {
        if (uri == null) {
            uri = this.f18352a;
        }
        if (g0(uri, str)) {
            f18665s.a("Using virtual style addressing. Endpoint = " + uri);
            request.s(E(uri, str));
            request.c(N(str2));
        } else {
            f18665s.a("Using path style addressing. Endpoint = " + uri);
            request.s(uri);
            if (str != null) {
                request.c(O(str, str2));
            }
        }
        f18665s.a("Key: " + str2 + "; Request: " + request);
    }

    @Override // com.amazonaws.services.s3.AmazonS3
    public InitiateMultipartUploadResult c(InitiateMultipartUploadRequest initiateMultipartUploadRequest) {
        ValidationUtils.a(initiateMultipartUploadRequest, "The request parameter must be specified when initiating a multipart upload");
        ValidationUtils.a(initiateMultipartUploadRequest.getBucketName(), "The bucket name parameter must be specified when initiating a multipart upload");
        ValidationUtils.a(initiateMultipartUploadRequest.getKey(), "The key parameter must be specified when initiating a multipart upload");
        Request G = G(initiateMultipartUploadRequest.getBucketName(), initiateMultipartUploadRequest.getKey(), initiateMultipartUploadRequest, HttpMethodName.POST);
        G.g(RequestParameters.SUBRESOURCE_UPLOADS, null);
        if (initiateMultipartUploadRequest.getStorageClass() != null) {
            G.addHeader("x-amz-storage-class", initiateMultipartUploadRequest.getStorageClass().toString());
        }
        if (initiateMultipartUploadRequest.getRedirectLocation() != null) {
            G.addHeader("x-amz-website-redirect-location", initiateMultipartUploadRequest.getRedirectLocation());
        }
        if (initiateMultipartUploadRequest.getAccessControlList() != null) {
            y(G, initiateMultipartUploadRequest.getAccessControlList());
        } else if (initiateMultipartUploadRequest.getCannedACL() != null) {
            G.addHeader("x-amz-acl", initiateMultipartUploadRequest.getCannedACL().toString());
        }
        ObjectMetadata objectMetadata = initiateMultipartUploadRequest.objectMetadata;
        if (objectMetadata != null) {
            X(G, objectMetadata);
        }
        A(G, "x-amz-tagging", i0(initiateMultipartUploadRequest.getTagging()));
        Y(G, initiateMultipartUploadRequest.isRequesterPays());
        Z(G, initiateMultipartUploadRequest.getSSECustomerKey());
        a0(G, initiateMultipartUploadRequest.getSSEAwsKeyManagementParams());
        e0(G);
        G.a(new ByteArrayInputStream(new byte[0]));
        return (InitiateMultipartUploadResult) S(G, new ResponseHeaderHandlerChain(new Unmarshaller<InitiateMultipartUploadResult, InputStream>() { // from class: com.amazonaws.services.s3.model.transform.Unmarshallers$InitiateMultipartUploadResultUnmarshaller
            @Override // com.amazonaws.transform.Unmarshaller
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public InitiateMultipartUploadResult a(InputStream inputStream) {
                return new XmlResponsesSaxParser().k(inputStream).f();
            }
        }, new ServerSideEncryptionHeaderHandler()), initiateMultipartUploadRequest.getBucketName(), initiateMultipartUploadRequest.getKey());
    }

    @Override // com.amazonaws.services.s3.AmazonS3
    public S3Object d(GetObjectRequest getObjectRequest) {
        ValidationUtils.a(getObjectRequest, "The GetObjectRequest parameter must be specified when requesting an object");
        ValidationUtils.a(getObjectRequest.getBucketName(), "The bucket name parameter must be specified when requesting an object");
        ValidationUtils.a(getObjectRequest.getKey(), "The key parameter must be specified when requesting an object");
        Request G = G(getObjectRequest.getBucketName(), getObjectRequest.getKey(), getObjectRequest, HttpMethodName.GET);
        if (getObjectRequest.getVersionId() != null) {
            G.g("versionId", getObjectRequest.getVersionId());
        }
        long[] range = getObjectRequest.getRange();
        if (range != null) {
            String str = "bytes=" + Long.toString(range[0]) + "-";
            if (range[1] >= 0) {
                str = str + Long.toString(range[1]);
            }
            G.addHeader("Range", str);
        }
        Y(G, getObjectRequest.isRequesterPays());
        B(G, getObjectRequest.getResponseHeaders());
        z(G, "If-Modified-Since", getObjectRequest.getModifiedSinceConstraint());
        z(G, "If-Unmodified-Since", getObjectRequest.getUnmodifiedSinceConstraint());
        C(G, "If-Match", getObjectRequest.getMatchingETagConstraints());
        C(G, "If-None-Match", getObjectRequest.getNonmatchingETagConstraints());
        Z(G, getObjectRequest.getSSECustomerKey());
        ProgressListenerCallbackExecutor d11 = ProgressListenerCallbackExecutor.d(getObjectRequest.getGeneralProgressListener());
        try {
            S3Object s3Object = (S3Object) S(G, new S3ObjectResponseHandler(), getObjectRequest.getBucketName(), getObjectRequest.getKey());
            s3Object.setBucketName(getObjectRequest.getBucketName());
            s3Object.setKey(getObjectRequest.getKey());
            FilterInputStream serviceClientHolderInputStream = new ServiceClientHolderInputStream(s3Object.getObjectContent(), this);
            if (d11 != null) {
                ProgressReportingInputStream progressReportingInputStream = new ProgressReportingInputStream(serviceClientHolderInputStream, d11);
                progressReportingInputStream.n(true);
                progressReportingInputStream.o(this.f18674q);
                L(d11, 2);
                serviceClientHolderInputStream = progressReportingInputStream;
            }
            if (ServiceUtils.g(getObjectRequest, this.f18671n) || ServiceUtils.h(s3Object.getObjectMetadata(), this.f18671n)) {
                serviceClientHolderInputStream = new LengthCheckInputStream(serviceClientHolderInputStream, s3Object.getObjectMetadata().getContentLength(), true);
            } else {
                String eTag = s3Object.getObjectMetadata().getETag();
                if (eTag != null && !ServiceUtils.b(eTag)) {
                    try {
                        serviceClientHolderInputStream = new DigestValidationInputStream(serviceClientHolderInputStream, MessageDigest.getInstance("MD5"), BinaryUtils.b(s3Object.getObjectMetadata().getETag()));
                    } catch (NoSuchAlgorithmException e11) {
                        f18665s.i("No MD5 digest algorithm available. Unable to calculate checksum and verify data integrity.", e11);
                    }
                }
            }
            s3Object.setObjectContent(new S3ObjectInputStream(serviceClientHolderInputStream));
            return s3Object;
        } catch (AmazonS3Exception e12) {
            if (e12.getStatusCode() == 412 || e12.getStatusCode() == 304) {
                L(d11, 16);
                return null;
            }
            L(d11, 8);
            throw e12;
        }
    }

    public void d0(S3ClientOptions s3ClientOptions) {
        this.f18671n = new S3ClientOptions(s3ClientOptions);
    }

    @Override // com.amazonaws.services.s3.AmazonS3
    public void e(AbortMultipartUploadRequest abortMultipartUploadRequest) {
        ValidationUtils.a(abortMultipartUploadRequest, "The request parameter must be specified when aborting a multipart upload");
        ValidationUtils.a(abortMultipartUploadRequest.getBucketName(), "The bucket name parameter must be specified when aborting a multipart upload");
        ValidationUtils.a(abortMultipartUploadRequest.getKey(), "The key parameter must be specified when aborting a multipart upload");
        ValidationUtils.a(abortMultipartUploadRequest.getUploadId(), "The upload ID parameter must be specified when aborting a multipart upload");
        String bucketName = abortMultipartUploadRequest.getBucketName();
        String key = abortMultipartUploadRequest.getKey();
        Request G = G(bucketName, key, abortMultipartUploadRequest, HttpMethodName.DELETE);
        G.g(RequestParameters.UPLOAD_ID, abortMultipartUploadRequest.getUploadId());
        Y(G, abortMultipartUploadRequest.isRequesterPays());
        S(G, this.f18670m, bucketName, key);
    }

    @Override // com.amazonaws.services.s3.AmazonS3
    public PutObjectResult f(PutObjectRequest putObjectRequest) {
        InputStream inputStream;
        MD5DigestCalculatingInputStream mD5DigestCalculatingInputStream;
        InputStream inputStream2;
        ValidationUtils.a(putObjectRequest, "The PutObjectRequest parameter must be specified when uploading an object");
        String bucketName = putObjectRequest.getBucketName();
        String key = putObjectRequest.getKey();
        ObjectMetadata metadata = putObjectRequest.getMetadata();
        InputStream inputStream3 = putObjectRequest.getInputStream();
        ProgressListenerCallbackExecutor d11 = ProgressListenerCallbackExecutor.d(putObjectRequest.getGeneralProgressListener());
        if (metadata == null) {
            metadata = new ObjectMetadata();
        }
        ValidationUtils.a(bucketName, "The bucket name parameter must be specified when uploading an object");
        ValidationUtils.a(key, "The key parameter must be specified when uploading an object");
        boolean g11 = ServiceUtils.g(putObjectRequest, this.f18671n);
        InputStream inputStream4 = inputStream3;
        if (putObjectRequest.getFile() != null) {
            File file = putObjectRequest.getFile();
            metadata.setContentLength(file.length());
            boolean z10 = metadata.getContentMD5() == null;
            if (metadata.getContentType() == null) {
                metadata.setContentType(Mimetypes.a().b(file));
            }
            if (z10 && !g11) {
                try {
                    metadata.setContentMD5(Md5Utils.d(file));
                } catch (Exception e11) {
                    throw new AmazonClientException("Unable to calculate MD5 hash: " + e11.getMessage(), e11);
                }
            }
            try {
                inputStream4 = new RepeatableFileInputStream(file);
            } catch (FileNotFoundException e12) {
                throw new AmazonClientException("Unable to find file to upload", e12);
            }
        }
        Request G = G(bucketName, key, putObjectRequest, HttpMethodName.PUT);
        if (putObjectRequest.getAccessControlList() != null) {
            y(G, putObjectRequest.getAccessControlList());
        } else if (putObjectRequest.getCannedAcl() != null) {
            G.addHeader("x-amz-acl", putObjectRequest.getCannedAcl().toString());
        }
        if (putObjectRequest.getStorageClass() != null) {
            G.addHeader("x-amz-storage-class", putObjectRequest.getStorageClass());
        }
        InputStream inputStream5 = inputStream4;
        if (putObjectRequest.getRedirectLocation() != null) {
            G.addHeader("x-amz-website-redirect-location", putObjectRequest.getRedirectLocation());
            inputStream5 = inputStream4;
            if (inputStream4 == null) {
                e0(G);
                inputStream5 = new ByteArrayInputStream(new byte[0]);
            }
        }
        A(G, "x-amz-tagging", i0(putObjectRequest.getTagging()));
        Y(G, putObjectRequest.isRequesterPays());
        Z(G, putObjectRequest.getSSECustomerKey());
        Long l11 = (Long) metadata.getRawMetadataValue(HttpHeaders.CONTENT_LENGTH);
        if (l11 != null) {
            long longValue = l11.longValue();
            inputStream = inputStream5;
            if (longValue >= 0) {
                LengthCheckInputStream lengthCheckInputStream = new LengthCheckInputStream(inputStream5, longValue, false);
                G.addHeader(HttpHeaders.CONTENT_LENGTH, l11.toString());
                inputStream = lengthCheckInputStream;
            }
        } else if (inputStream5.markSupported()) {
            G.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(D(inputStream5)));
            inputStream = inputStream5;
        } else {
            f18665s.j("No content length specified for stream data.  Stream contents will be buffered in memory and could result in out of memory errors.");
            ByteArrayInputStream h02 = h0(inputStream5);
            G.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(h02.available()));
            G.n(true);
            inputStream = h02;
        }
        if (d11 != null) {
            ProgressReportingInputStream progressReportingInputStream = new ProgressReportingInputStream(inputStream, d11);
            progressReportingInputStream.o(this.f18674q);
            L(d11, 2);
            inputStream = progressReportingInputStream;
        }
        if (metadata.getContentMD5() != null || g11) {
            mD5DigestCalculatingInputStream = null;
            inputStream2 = inputStream;
        } else {
            mD5DigestCalculatingInputStream = new MD5DigestCalculatingInputStream(inputStream);
            inputStream2 = mD5DigestCalculatingInputStream;
        }
        if (metadata.getContentType() == null) {
            metadata.setContentType(OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        }
        X(G, metadata);
        a0(G, putObjectRequest.getSSEAwsKeyManagementParams());
        G.a(inputStream2);
        try {
            try {
                ObjectMetadata objectMetadata = (ObjectMetadata) S(G, new S3MetadataResponseHandler(), bucketName, key);
                try {
                    inputStream2.close();
                } catch (AbortedException unused) {
                } catch (Exception e13) {
                    f18665s.g("Unable to cleanly close input stream: " + e13.getMessage(), e13);
                }
                String contentMD5 = metadata.getContentMD5();
                if (mD5DigestCalculatingInputStream != null) {
                    contentMD5 = BinaryUtils.c(mD5DigestCalculatingInputStream.m());
                }
                if (objectMetadata != null && contentMD5 != null && !g11 && !Arrays.equals(BinaryUtils.a(contentMD5), BinaryUtils.b(objectMetadata.getETag()))) {
                    L(d11, 8);
                    throw new AmazonClientException("Unable to verify integrity of data upload.  Client calculated content hash didn't match hash calculated by Amazon S3.  You may need to delete the data stored in Amazon S3.");
                }
                L(d11, 4);
                PutObjectResult putObjectResult = new PutObjectResult();
                putObjectResult.setVersionId(objectMetadata.getVersionId());
                putObjectResult.setSSEAlgorithm(objectMetadata.getSSEAlgorithm());
                putObjectResult.setSSECustomerAlgorithm(objectMetadata.getSSECustomerAlgorithm());
                putObjectResult.setSSECustomerKeyMd5(objectMetadata.getSSECustomerKeyMd5());
                putObjectResult.setExpirationTime(objectMetadata.getExpirationTime());
                putObjectResult.setExpirationTimeRuleId(objectMetadata.getExpirationTimeRuleId());
                putObjectResult.setETag(objectMetadata.getETag());
                putObjectResult.b(objectMetadata);
                putObjectResult.setRequesterCharged(objectMetadata.isRequesterCharged());
                putObjectResult.a(contentMD5);
                return putObjectResult;
            } catch (AmazonClientException e14) {
                L(d11, 8);
                throw e14;
            }
        } finally {
        }
    }

    @Override // com.amazonaws.AmazonWebServiceClient
    public void v(String str) {
        if (str.endsWith("s3-accelerate.amazonaws.com")) {
            throw new IllegalStateException("To enable accelerate mode, please use AmazonS3Client.setS3ClientOptions(S3ClientOptions.builder().setAccelerateModeEnabled(true).build());");
        }
        super.v(str);
        if (str.endsWith("s3.amazonaws.com")) {
            return;
        }
        this.f18673p = AwsHostNameUtils.a(this.f18352a.getHost(), "s3");
    }

    @Override // com.amazonaws.AmazonWebServiceClient
    public void w(Region region) {
        super.w(region);
        this.f18673p = region.d();
    }
}
