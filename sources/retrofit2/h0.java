package retrofit2;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.util.regex.Pattern;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;

/* loaded from: classes7.dex */
final class h0 {

    /* renamed from: l, reason: collision with root package name */
    private static final char[] f74518l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: m, reason: collision with root package name */
    private static final Pattern f74519m = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* renamed from: a, reason: collision with root package name */
    private final String f74520a;

    /* renamed from: b, reason: collision with root package name */
    private final HttpUrl f74521b;

    /* renamed from: c, reason: collision with root package name */
    private String f74522c;

    /* renamed from: d, reason: collision with root package name */
    private HttpUrl.Builder f74523d;

    /* renamed from: e, reason: collision with root package name */
    private final Request.Builder f74524e = new Request.Builder();

    /* renamed from: f, reason: collision with root package name */
    private final Headers.Builder f74525f;

    /* renamed from: g, reason: collision with root package name */
    private MediaType f74526g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f74527h;

    /* renamed from: i, reason: collision with root package name */
    private MultipartBody.Builder f74528i;

    /* renamed from: j, reason: collision with root package name */
    private FormBody.Builder f74529j;

    /* renamed from: k, reason: collision with root package name */
    private RequestBody f74530k;

    /* loaded from: classes7.dex */
    private static class a extends RequestBody {

        /* renamed from: a, reason: collision with root package name */
        private final RequestBody f74531a;

        /* renamed from: b, reason: collision with root package name */
        private final MediaType f74532b;

        a(RequestBody requestBody, MediaType mediaType) {
            this.f74531a = requestBody;
            this.f74532b = mediaType;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() {
            return this.f74531a.contentLength();
        }

        @Override // okhttp3.RequestBody
        /* renamed from: contentType */
        public MediaType getContentType() {
            return this.f74532b;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) {
            this.f74531a.writeTo(bufferedSink);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(String str, HttpUrl httpUrl, String str2, Headers headers, MediaType mediaType, boolean z10, boolean z11, boolean z12) {
        this.f74520a = str;
        this.f74521b = httpUrl;
        this.f74522c = str2;
        this.f74526g = mediaType;
        this.f74527h = z10;
        if (headers != null) {
            this.f74525f = headers.newBuilder();
        } else {
            this.f74525f = new Headers.Builder();
        }
        if (z11) {
            this.f74529j = new FormBody.Builder();
        } else if (z12) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            this.f74528i = builder;
            builder.setType(MultipartBody.FORM);
        }
    }

    private static String i(String str, boolean z10) {
        int length = str.length();
        int i11 = 0;
        while (i11 < length) {
            int codePointAt = str.codePointAt(i11);
            if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z10 && (codePointAt == 47 || codePointAt == 37))) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, 0, i11);
                j(buffer, str, i11, length, z10);
                return buffer.readUtf8();
            }
            i11 += Character.charCount(codePointAt);
        }
        return str;
    }

    private static void j(Buffer buffer, String str, int i11, int i12, boolean z10) {
        Buffer buffer2 = null;
        while (i11 < i12) {
            int codePointAt = str.codePointAt(i11);
            if (!z10 || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z10 && (codePointAt == 47 || codePointAt == 37))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.writeUtf8CodePoint(codePointAt);
                    while (!buffer2.exhausted()) {
                        byte readByte = buffer2.readByte();
                        buffer.writeByte(37);
                        char[] cArr = f74518l;
                        buffer.writeByte((int) cArr[((readByte & 255) >> 4) & 15]);
                        buffer.writeByte((int) cArr[readByte & 15]);
                    }
                } else {
                    buffer.writeUtf8CodePoint(codePointAt);
                }
            }
            i11 += Character.charCount(codePointAt);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, boolean z10) {
        if (z10) {
            this.f74529j.addEncoded(str, str2);
        } else {
            this.f74529j.add(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, String str2, boolean z10) {
        if (!HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(str)) {
            if (z10) {
                this.f74525f.addUnsafeNonAscii(str, str2);
                return;
            } else {
                this.f74525f.add(str, str2);
                return;
            }
        }
        try {
            this.f74526g = MediaType.get(str2);
        } catch (IllegalArgumentException e11) {
            throw new IllegalArgumentException("Malformed content type: " + str2, e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Headers headers) {
        this.f74525f.addAll(headers);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Headers headers, RequestBody requestBody) {
        this.f74528i.addPart(headers, requestBody);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MultipartBody.Part part) {
        this.f74528i.addPart(part);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, String str2, boolean z10) {
        if (this.f74522c == null) {
            throw new AssertionError();
        }
        String i11 = i(str2, z10);
        String replace = this.f74522c.replace("{" + str + "}", i11);
        if (!f74519m.matcher(replace).matches()) {
            this.f74522c = replace;
            return;
        }
        throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(String str, String str2, boolean z10) {
        String str3 = this.f74522c;
        if (str3 != null) {
            HttpUrl.Builder newBuilder = this.f74521b.newBuilder(str3);
            this.f74523d = newBuilder;
            if (newBuilder == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f74521b + ", Relative: " + this.f74522c);
            }
            this.f74522c = null;
        }
        if (z10) {
            this.f74523d.addEncodedQueryParameter(str, str2);
        } else {
            this.f74523d.addQueryParameter(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Class cls, Object obj) {
        this.f74524e.tag(cls, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Request.Builder k() {
        HttpUrl resolve;
        HttpUrl.Builder builder = this.f74523d;
        if (builder != null) {
            resolve = builder.build();
        } else {
            resolve = this.f74521b.resolve(this.f74522c);
            if (resolve == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f74521b + ", Relative: " + this.f74522c);
            }
        }
        RequestBody requestBody = this.f74530k;
        if (requestBody == null) {
            FormBody.Builder builder2 = this.f74529j;
            if (builder2 != null) {
                requestBody = builder2.build();
            } else {
                MultipartBody.Builder builder3 = this.f74528i;
                if (builder3 != null) {
                    requestBody = builder3.build();
                } else if (this.f74527h) {
                    requestBody = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.f74526g;
        if (mediaType != null) {
            if (requestBody != null) {
                requestBody = new a(requestBody, mediaType);
            } else {
                this.f74525f.add(HttpHeaders.CONTENT_TYPE, mediaType.getMediaType());
            }
        }
        return this.f74524e.url(resolve).headers(this.f74525f.build()).method(this.f74520a, requestBody);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(RequestBody requestBody) {
        this.f74530k = requestBody;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Object obj) {
        this.f74522c = obj.toString();
    }
}
