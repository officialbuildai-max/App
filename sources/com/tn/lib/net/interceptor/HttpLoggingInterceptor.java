package com.tn.lib.net.interceptor;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nh.m;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.HttpUrl;
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
import xg.d;

/* loaded from: classes.dex */
public final class HttpLoggingInterceptor implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    private final a f40889a;

    /* renamed from: b, reason: collision with root package name */
    private volatile Set f40890b;

    /* renamed from: c, reason: collision with root package name */
    private volatile Level f40891c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/tn/lib/net/interceptor/HttpLoggingInterceptor$Level;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "BASIC", "HEADERS", "BODY", "lib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes.dex */
    public static final class Level {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Level[] $VALUES;
        public static final Level NONE = new Level("NONE", 0);
        public static final Level BASIC = new Level("BASIC", 1);
        public static final Level HEADERS = new Level("HEADERS", 2);
        public static final Level BODY = new Level("BODY", 3);

        private static final /* synthetic */ Level[] $values() {
            return new Level[]{NONE, BASIC, HEADERS, BODY};
        }

        static {
            Level[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private Level(String str, int i11) {
        }

        public static EnumEntries<Level> getEntries() {
            return $ENTRIES;
        }

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        public static Level[] values() {
            return (Level[]) $VALUES.clone();
        }
    }

    /* loaded from: classes3.dex */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0586a f40892a = C0586a.f40894a;

        /* renamed from: b, reason: collision with root package name */
        public static final a f40893b = new C0586a.C0587a();

        /* renamed from: com.tn.lib.net.interceptor.HttpLoggingInterceptor$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0586a {

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ C0586a f40894a = new C0586a();

            /* renamed from: com.tn.lib.net.interceptor.HttpLoggingInterceptor$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            private static final class C0587a implements a {
                @Override // com.tn.lib.net.interceptor.HttpLoggingInterceptor.a
                public void log(String message) {
                    Intrinsics.h(message, "message");
                    Platform.log$default(Platform.INSTANCE.get(), message, 0, null, 6, null);
                }
            }

            private C0586a() {
            }
        }

        void log(String str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public HttpLoggingInterceptor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public HttpLoggingInterceptor(a logger) {
        Intrinsics.h(logger, "logger");
        this.f40889a = logger;
        this.f40890b = SetsKt.f();
        this.f40891c = Level.NONE;
    }

    public /* synthetic */ HttpLoggingInterceptor(a aVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? a.f40893b : aVar);
    }

    private final boolean a(Headers headers) {
        String str = headers.get(HttpHeaders.CONTENT_ENCODING);
        return (str == null || StringsKt.H(str, "identity", true) || StringsKt.H(str, "gzip", true)) ? false : true;
    }

    private final void c(Headers headers, int i11) {
        String value = this.f40890b.contains(headers.name(i11)) ? "██" : headers.value(i11);
        this.f40889a.log(headers.name(i11) + ": " + value);
    }

    public final void b(Level level) {
        Intrinsics.h(level, "<set-?>");
        this.f40891c = level;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        boolean z10;
        String str;
        String str2;
        long j11;
        String str3;
        String str4;
        String str5;
        Charset UTF_8;
        boolean b11;
        Charset UTF_82;
        boolean b12;
        Intrinsics.h(chain, "chain");
        Level level = this.f40891c;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        boolean z11 = level == Level.BODY;
        boolean z12 = z11 || level == Level.HEADERS;
        RequestBody body = request.body();
        Connection connection = chain.connection();
        String str6 = "--> " + request.method() + " " + request.url() + (connection != null ? " " + connection.protocol() : "");
        if (!z12 && body != null) {
            str6 = str6 + " (" + body.contentLength() + "-byte body)";
        }
        this.f40889a.log(str6);
        if (z12) {
            Headers headers = request.headers();
            if (body != null) {
                MediaType mediaType = body.get$contentType();
                if (mediaType == null || headers.get(HttpHeaders.CONTENT_TYPE) != null) {
                    str = " ";
                } else {
                    a aVar = this.f40889a;
                    StringBuilder sb2 = new StringBuilder();
                    str = " ";
                    sb2.append("Content-Type: ");
                    sb2.append(mediaType);
                    aVar.log(sb2.toString());
                }
                if (body.contentLength() == -1 || headers.get(HttpHeaders.CONTENT_LENGTH) != null) {
                    z10 = z12;
                } else {
                    a aVar2 = this.f40889a;
                    long contentLength = body.contentLength();
                    StringBuilder sb3 = new StringBuilder();
                    z10 = z12;
                    sb3.append("Content-Length: ");
                    sb3.append(contentLength);
                    aVar2.log(sb3.toString());
                }
            } else {
                z10 = z12;
                str = " ";
            }
            int size = headers.size();
            for (int i11 = 0; i11 < size; i11++) {
                c(headers, i11);
            }
            if (!z11 || body == null) {
                this.f40889a.log("--> END " + request.method());
            } else if (a(request.headers())) {
                this.f40889a.log("--> END " + request.method() + " (encoded body omitted)");
            } else if (body.isDuplex()) {
                this.f40889a.log("--> END " + request.method() + " (duplex request body omitted)");
            } else if (body.isOneShot()) {
                this.f40889a.log("--> END " + request.method() + " (one-shot body omitted)");
            } else {
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                MediaType mediaType2 = body.get$contentType();
                if (mediaType2 == null || (UTF_82 = mediaType2.charset(StandardCharsets.UTF_8)) == null) {
                    UTF_82 = StandardCharsets.UTF_8;
                    Intrinsics.g(UTF_82, "UTF_8");
                }
                this.f40889a.log("");
                b12 = d.b(buffer);
                if (b12) {
                    this.f40889a.log(buffer.readString(UTF_82));
                    this.f40889a.log("--> END " + request.method() + " (" + body.contentLength() + "-byte body)");
                } else {
                    this.f40889a.log("--> END " + request.method() + " (binary " + body.contentLength() + "-byte body omitted)");
                }
            }
        } else {
            z10 = z12;
            str = " ";
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            Intrinsics.e(body2);
            long contentLength2 = body2.getContentLength();
            String str7 = contentLength2 != -1 ? contentLength2 + "-byte" : "unknown-length";
            a aVar3 = this.f40889a;
            int code = proceed.code();
            if (proceed.message().length() == 0) {
                j11 = contentLength2;
                str2 = "-byte body)";
                str3 = "";
            } else {
                str2 = "-byte body)";
                j11 = contentLength2;
                str3 = ' ' + proceed.message();
            }
            HttpUrl url = proceed.request().url();
            if (z10) {
                str4 = "-byte body omitted)";
                str5 = "";
            } else {
                StringBuilder sb4 = new StringBuilder();
                str4 = "-byte body omitted)";
                sb4.append(", ");
                sb4.append(str7);
                sb4.append(" body");
                str5 = sb4.toString();
            }
            aVar3.log("<-- " + code + str3 + str + url + " (" + millis + "ms" + str5 + ")");
            if (z10) {
                Headers headers2 = proceed.headers();
                int size2 = headers2.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    c(headers2, i12);
                }
                if (!z11 || !okhttp3.internal.http.HttpHeaders.promisesBody(proceed)) {
                    this.f40889a.log("<-- END HTTP");
                } else if (a(proceed.headers())) {
                    this.f40889a.log("<-- END HTTP (encoded body omitted)");
                } else {
                    BufferedSource source = body2.getSource();
                    source.request(Long.MAX_VALUE);
                    Buffer buffer2 = source.getBuffer();
                    Long l11 = null;
                    if (StringsKt.H("gzip", headers2.get(HttpHeaders.CONTENT_ENCODING), true)) {
                        Long valueOf = Long.valueOf(buffer2.size());
                        GzipSource gzipSource = new GzipSource(buffer2.clone());
                        try {
                            buffer2 = new Buffer();
                            buffer2.writeAll(gzipSource);
                            CloseableKt.a(gzipSource, null);
                            l11 = valueOf;
                        } finally {
                        }
                    }
                    MediaType mediaType3 = body2.get$contentType();
                    if (mediaType3 == null || (UTF_8 = mediaType3.charset(StandardCharsets.UTF_8)) == null) {
                        UTF_8 = StandardCharsets.UTF_8;
                        Intrinsics.g(UTF_8, "UTF_8");
                    }
                    b11 = d.b(buffer2);
                    if (!b11) {
                        this.f40889a.log("");
                        this.f40889a.log("<-- END HTTP (binary " + buffer2.size() + str4);
                        return proceed;
                    }
                    if (j11 != 0) {
                        this.f40889a.log("");
                        this.f40889a.log(buffer2.clone().readString(UTF_8));
                    }
                    if (l11 != null) {
                        this.f40889a.log("<-- END HTTP (" + buffer2.size() + "-byte, " + l11 + "-gzipped-byte body)");
                    } else {
                        this.f40889a.log("<-- END HTTP (" + buffer2.size() + str2);
                    }
                }
            }
            return proceed;
        } catch (Exception e11) {
            lg.a.f68962a.i("HttpTag", "net_state:" + m.f70597a.b() + " url:" + request.url() + "<-- HTTP FAILED: " + e11, true);
            throw e11;
        }
    }
}
