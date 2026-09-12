package dg;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.tmc.network.log.LogLevel;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;

/* loaded from: classes5.dex */
public final class b implements Interceptor {

    /* renamed from: e, reason: collision with root package name */
    private static final a f61475e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0757b f61476a;

    /* renamed from: b, reason: collision with root package name */
    private volatile Set f61477b;

    /* renamed from: c, reason: collision with root package name */
    private volatile LogLevel f61478c;

    /* renamed from: d, reason: collision with root package name */
    private volatile LogLevel f61479d;

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(Buffer buffer) {
            Intrinsics.h(buffer, "<this>");
            try {
                Buffer buffer2 = new Buffer();
                buffer.copyTo(buffer2, 0L, RangesKt.j(buffer.size(), 64L));
                int i11 = 0;
                do {
                    i11++;
                    if (buffer2.exhausted()) {
                        break;
                    }
                    int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                    if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                        return false;
                    }
                } while (i11 < 16);
                return true;
            } catch (EOFException unused) {
                return false;
            }
        }

        public final boolean b(MediaType mediaType) {
            if (!Intrinsics.c(mediaType == null ? null : mediaType.type(), MimeTypes.BASE_TYPE_TEXT)) {
                if (!Intrinsics.c(mediaType == null ? null : mediaType.subtype(), "json")) {
                    if (!Intrinsics.c(mediaType != null ? mediaType.subtype() : null, "x-www-form-urlencoded")) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    /* renamed from: dg.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0757b {

        /* renamed from: a, reason: collision with root package name */
        public static final C0758b f61480a = C0758b.f61482a;

        /* renamed from: b, reason: collision with root package name */
        public static final InterfaceC0757b f61481b = new a();

        /* renamed from: dg.b$b$a */
        /* loaded from: classes5.dex */
        public static final class a implements InterfaceC0757b {
            a() {
            }

            @Override // dg.b.InterfaceC0757b
            public void log(String message) {
                Intrinsics.h(message, "message");
                Platform.INSTANCE.get().log(message, 4, null);
            }
        }

        /* renamed from: dg.b$b$b, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0758b {

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ C0758b f61482a = new C0758b();

            private C0758b() {
            }
        }

        void log(String str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public b(InterfaceC0757b logger) {
        Intrinsics.h(logger, "logger");
        this.f61476a = logger;
        this.f61477b = SetsKt.f();
        LogLevel logLevel = LogLevel.NONE;
        this.f61478c = logLevel;
        this.f61479d = logLevel;
    }

    public /* synthetic */ b(InterfaceC0757b interfaceC0757b, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? InterfaceC0757b.f61481b : interfaceC0757b);
    }

    private final boolean a(Headers headers) {
        String str = headers.get(HttpHeaders.CONTENT_ENCODING);
        return (str == null || StringsKt.H(str, "identity", true) || StringsKt.H(str, "gzip", true)) ? false : true;
    }

    private final void b(Headers headers, int i11) {
        String value = this.f61477b.contains(headers.name(i11)) ? "██" : headers.value(i11);
        this.f61476a.log(headers.name(i11) + ": " + value);
    }

    public final void c(LogLevel logLevel) {
        Intrinsics.h(logLevel, "<set-?>");
        this.f61478c = logLevel;
    }

    public final void d(LogLevel logLevel) {
        Intrinsics.h(logLevel, "<set-?>");
        this.f61479d = logLevel;
    }

    public final b e(LogLevel level) {
        Intrinsics.h(level, "level");
        c(level);
        return this;
    }

    public final b f(LogLevel level) {
        Intrinsics.h(level, "level");
        d(level);
        return this;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        boolean z10;
        String str;
        String str2;
        char c11;
        String sb2;
        String str3;
        Charset charset;
        Long l11;
        Intrinsics.h(chain, "chain");
        LogLevel logLevel = this.f61478c;
        LogLevel logLevel2 = this.f61479d;
        Request request = chain.request();
        LogLevel logLevel3 = LogLevel.NONE;
        if (logLevel == logLevel3 && logLevel2 == logLevel3) {
            return chain.proceed(request);
        }
        boolean z11 = logLevel == LogLevel.BODY;
        boolean z12 = z11 || logLevel == LogLevel.HEADERS;
        RequestBody body = request.body();
        boolean b11 = f61475e.b(body == null ? null : body.get$contentType());
        Connection connection = chain.connection();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("--> ");
        sb3.append(request.method());
        sb3.append(' ');
        sb3.append(request.url());
        sb3.append(connection != null ? Intrinsics.q(" ", connection.protocol()) : "");
        String sb4 = sb3.toString();
        if (!z12 && body != null) {
            sb4 = sb4 + " (" + body.contentLength() + "-byte body)";
        }
        this.f61476a.log(sb4);
        if (z12) {
            Headers headers = request.headers();
            if (body != null) {
                MediaType mediaType = body.get$contentType();
                if (mediaType != null && headers.get(HttpHeaders.CONTENT_TYPE) == null) {
                    z10 = z12;
                    this.f61476a.log(Intrinsics.q("Content-Type: ", mediaType));
                } else {
                    z10 = z12;
                }
                if (body.contentLength() != -1 && headers.get(HttpHeaders.CONTENT_LENGTH) == null) {
                    this.f61476a.log(Intrinsics.q("Content-Length: ", Long.valueOf(body.contentLength())));
                }
            } else {
                z10 = z12;
            }
            int size = headers.size();
            if (size > 0) {
                int i11 = 0;
                while (true) {
                    int i12 = i11 + 1;
                    b(headers, i11);
                    if (i12 >= size) {
                        break;
                    }
                    i11 = i12;
                }
            }
            if (!z11 || body == null) {
                this.f61476a.log(Intrinsics.q("--> END ", request.method()));
            } else if (a(request.headers())) {
                this.f61476a.log("--> END " + request.method() + " (encoded body omitted)");
            } else if (body.isDuplex()) {
                this.f61476a.log("--> END " + request.method() + " (duplex request body omitted)");
            } else if (b11) {
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                MediaType mediaType2 = body.get$contentType();
                Charset UTF_8 = mediaType2 == null ? null : mediaType2.charset(StandardCharsets.UTF_8);
                if (UTF_8 == null) {
                    UTF_8 = StandardCharsets.UTF_8;
                    Intrinsics.g(UTF_8, "UTF_8");
                }
                this.f61476a.log("");
                if (f61475e.a(buffer)) {
                    this.f61476a.log(buffer.readString(UTF_8));
                    this.f61476a.log("--> END " + request.method() + " (" + body.contentLength() + "-byte body)");
                } else {
                    this.f61476a.log("--> END " + request.method() + " (binary " + body.contentLength() + "-byte body omitted)");
                }
            } else {
                this.f61476a.log("--> END " + request.method() + " (non text request body omitted.)");
            }
        } else {
            z10 = z12;
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain.proceed(request);
            boolean z13 = logLevel2 == LogLevel.BODY;
            boolean z14 = z13 || logLevel2 == LogLevel.HEADERS;
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            Intrinsics.e(body2);
            long j11 = body2.get$contentLength();
            if (j11 != -1) {
                str = j11 + "-byte";
            } else {
                str = "unknown-length";
            }
            InterfaceC0757b interfaceC0757b = this.f61476a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("<-- ");
            sb5.append(proceed.code());
            if (proceed.message().length() == 0) {
                str2 = "-byte body omitted)";
                sb2 = "";
                c11 = ' ';
            } else {
                String message = proceed.message();
                StringBuilder sb6 = new StringBuilder();
                str2 = "-byte body omitted)";
                c11 = ' ';
                sb6.append(String.valueOf(' '));
                sb6.append(message);
                sb2 = sb6.toString();
            }
            sb5.append(sb2);
            sb5.append(c11);
            sb5.append(proceed.request().url());
            sb5.append(" (");
            sb5.append(millis);
            sb5.append("ms");
            if (z10) {
                str3 = "";
            } else {
                str3 = ", " + str + " body";
            }
            sb5.append(str3);
            sb5.append(')');
            interfaceC0757b.log(sb5.toString());
            boolean b12 = f61475e.b(body2.get$contentType());
            if (z14) {
                Headers headers2 = proceed.headers();
                int size2 = headers2.size();
                if (size2 > 0) {
                    int i13 = 0;
                    while (true) {
                        int i14 = i13 + 1;
                        b(headers2, i13);
                        if (i14 >= size2) {
                            break;
                        }
                        i13 = i14;
                    }
                }
                if (!z13 || !okhttp3.internal.http.HttpHeaders.promisesBody(proceed)) {
                    this.f61476a.log("<-- END HTTP");
                } else if (a(proceed.headers())) {
                    this.f61476a.log("<-- END HTTP (encoded body omitted)");
                } else if (b12) {
                    BufferedSource bufferedSource = body2.get$this_asResponseBody();
                    bufferedSource.request(Long.MAX_VALUE);
                    Buffer buffer2 = bufferedSource.getBuffer();
                    if (StringsKt.H("gzip", headers2.get(HttpHeaders.CONTENT_ENCODING), true)) {
                        l11 = Long.valueOf(buffer2.size());
                        GzipSource gzipSource = new GzipSource(buffer2.clone());
                        try {
                            buffer2 = new Buffer();
                            buffer2.writeAll(gzipSource);
                            charset = null;
                            CloseableKt.a(gzipSource, null);
                        } finally {
                        }
                    } else {
                        charset = null;
                        l11 = null;
                    }
                    MediaType mediaType3 = body2.get$contentType();
                    Charset UTF_82 = mediaType3 == null ? charset : mediaType3.charset(StandardCharsets.UTF_8);
                    if (UTF_82 == null) {
                        UTF_82 = StandardCharsets.UTF_8;
                        Intrinsics.g(UTF_82, "UTF_8");
                    }
                    if (!f61475e.a(buffer2)) {
                        this.f61476a.log("");
                        this.f61476a.log("<-- END HTTP (binary " + buffer2.size() + str2);
                        return proceed;
                    }
                    if (j11 != 0) {
                        this.f61476a.log("");
                        this.f61476a.log(buffer2.clone().readString(UTF_82));
                    }
                    if (l11 != null) {
                        this.f61476a.log("<-- END HTTP (" + buffer2.size() + "-byte, " + l11 + "-gzipped-byte body)");
                    } else {
                        this.f61476a.log("<-- END HTTP (" + buffer2.size() + "-byte body)");
                    }
                } else {
                    this.f61476a.log("<-- END HTTP (non text response body omitted.)");
                }
            }
            return proceed;
        } catch (Exception e11) {
            this.f61476a.log(Intrinsics.q("<-- HTTP FAILED: ", e11));
            throw e11;
        }
    }
}
