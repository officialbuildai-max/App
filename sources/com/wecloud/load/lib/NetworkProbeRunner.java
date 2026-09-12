package com.wecloud.load.lib;

import androidx.annotation.Keep;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.y0;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

/* loaded from: classes7.dex */
public final class NetworkProbeRunner {

    /* renamed from: a, reason: collision with root package name */
    public static final NetworkProbeRunner f60935a = new NetworkProbeRunner();

    /* renamed from: b, reason: collision with root package name */
    private static final Gson f60936b = new Gson();

    /* renamed from: c, reason: collision with root package name */
    private static final OkHttpClient f60937c = new OkHttpClient.Builder().followRedirects(true).followSslRedirects(true).build();

    /* JADX INFO: Access modifiers changed from: private */
    @Keep
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0083\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0086\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u000bHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R$\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006-"}, d2 = {"Lcom/wecloud/load/lib/NetworkProbeRunner$Link;", "", "id", "", "url", "method", "headers", "", TtmlNode.TAG_BODY, "expectedStatusCode", "timeoutMilliseconds", "", "retryCount", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getUrl", "getMethod", "getHeaders", "()Ljava/util/Map;", "getBody", "getExpectedStatusCode", "getTimeoutMilliseconds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRetryCount", "getName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/wecloud/load/lib/NetworkProbeRunner$Link;", "equals", "", OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER, "hashCode", "toString", "network_probe_native_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes7.dex */
    public static final /* data */ class Link {

        @SerializedName(TtmlNode.TAG_BODY)
        private final String body;

        @SerializedName("expectedStatusCode")
        private final String expectedStatusCode;

        @SerializedName("headers")
        private final Map<String, String> headers;

        @SerializedName("id")
        private final String id;

        @SerializedName("method")
        private final String method;

        @SerializedName("name")
        private final String name;

        @SerializedName("retryCount")
        private final Integer retryCount;

        @SerializedName("timeoutMilliseconds")
        private final Integer timeoutMilliseconds;

        @SerializedName("url")
        private final String url;

        public Link() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        public Link(String str, String str2, String str3, Map<String, String> map, String str4, String str5, Integer num, Integer num2, String str6) {
            this.id = str;
            this.url = str2;
            this.method = str3;
            this.headers = map;
            this.body = str4;
            this.expectedStatusCode = str5;
            this.timeoutMilliseconds = num;
            this.retryCount = num2;
            this.name = str6;
        }

        public /* synthetic */ Link(String str, String str2, String str3, Map map, String str4, String str5, Integer num, Integer num2, String str6, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : map, (i11 & 16) != 0 ? null : str4, (i11 & 32) != 0 ? null : str5, (i11 & 64) != 0 ? null : num, (i11 & 128) != 0 ? null : num2, (i11 & 256) == 0 ? str6 : null);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component3, reason: from getter */
        public final String getMethod() {
            return this.method;
        }

        public final Map<String, String> component4() {
            return this.headers;
        }

        /* renamed from: component5, reason: from getter */
        public final String getBody() {
            return this.body;
        }

        /* renamed from: component6, reason: from getter */
        public final String getExpectedStatusCode() {
            return this.expectedStatusCode;
        }

        /* renamed from: component7, reason: from getter */
        public final Integer getTimeoutMilliseconds() {
            return this.timeoutMilliseconds;
        }

        /* renamed from: component8, reason: from getter */
        public final Integer getRetryCount() {
            return this.retryCount;
        }

        /* renamed from: component9, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final Link copy(String id2, String url, String method, Map<String, String> headers, String body, String expectedStatusCode, Integer timeoutMilliseconds, Integer retryCount, String name) {
            return new Link(id2, url, method, headers, body, expectedStatusCode, timeoutMilliseconds, retryCount, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Link)) {
                return false;
            }
            Link link = (Link) other;
            return Intrinsics.c(this.id, link.id) && Intrinsics.c(this.url, link.url) && Intrinsics.c(this.method, link.method) && Intrinsics.c(this.headers, link.headers) && Intrinsics.c(this.body, link.body) && Intrinsics.c(this.expectedStatusCode, link.expectedStatusCode) && Intrinsics.c(this.timeoutMilliseconds, link.timeoutMilliseconds) && Intrinsics.c(this.retryCount, link.retryCount) && Intrinsics.c(this.name, link.name);
        }

        public final String getBody() {
            return this.body;
        }

        public final String getExpectedStatusCode() {
            return this.expectedStatusCode;
        }

        public final Map<String, String> getHeaders() {
            return this.headers;
        }

        public final String getId() {
            return this.id;
        }

        public final String getMethod() {
            return this.method;
        }

        public final String getName() {
            return this.name;
        }

        public final Integer getRetryCount() {
            return this.retryCount;
        }

        public final Integer getTimeoutMilliseconds() {
            return this.timeoutMilliseconds;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            String str = this.id;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.url;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.method;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Map<String, String> map = this.headers;
            int hashCode4 = (hashCode3 + (map == null ? 0 : map.hashCode())) * 31;
            String str4 = this.body;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.expectedStatusCode;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Integer num = this.timeoutMilliseconds;
            int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.retryCount;
            int hashCode8 = (hashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str6 = this.name;
            return hashCode8 + (str6 != null ? str6.hashCode() : 0);
        }

        public String toString() {
            return "Link(id=" + this.id + ", url=" + this.url + ", method=" + this.method + ", headers=" + this.headers + ", body=" + this.body + ", expectedStatusCode=" + this.expectedStatusCode + ", timeoutMilliseconds=" + this.timeoutMilliseconds + ", retryCount=" + this.retryCount + ", name=" + this.name + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Keep
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0083\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J8\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/wecloud/load/lib/NetworkProbeRunner$Payload;", "", "version", "", "maxConcurrency", "proberLinks", "", "Lcom/wecloud/load/lib/NetworkProbeRunner$Link;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "getVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxConcurrency", "getProberLinks", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lcom/wecloud/load/lib/NetworkProbeRunner$Payload;", "equals", "", OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER, "hashCode", "toString", "", "network_probe_native_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes7.dex */
    public static final /* data */ class Payload {

        @SerializedName("maxConcurrency")
        private final Integer maxConcurrency;

        @SerializedName("proberLinks")
        private final List<Link> proberLinks;

        @SerializedName("version")
        private final Integer version;

        public Payload() {
            this(null, null, null, 7, null);
        }

        public Payload(Integer num, Integer num2, List<Link> list) {
            this.version = num;
            this.maxConcurrency = num2;
            this.proberLinks = list;
        }

        public /* synthetic */ Payload(Integer num, Integer num2, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? null : num2, (i11 & 4) != 0 ? null : list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Payload copy$default(Payload payload, Integer num, Integer num2, List list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                num = payload.version;
            }
            if ((i11 & 2) != 0) {
                num2 = payload.maxConcurrency;
            }
            if ((i11 & 4) != 0) {
                list = payload.proberLinks;
            }
            return payload.copy(num, num2, list);
        }

        /* renamed from: component1, reason: from getter */
        public final Integer getVersion() {
            return this.version;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getMaxConcurrency() {
            return this.maxConcurrency;
        }

        public final List<Link> component3() {
            return this.proberLinks;
        }

        public final Payload copy(Integer version, Integer maxConcurrency, List<Link> proberLinks) {
            return new Payload(version, maxConcurrency, proberLinks);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Payload)) {
                return false;
            }
            Payload payload = (Payload) other;
            return Intrinsics.c(this.version, payload.version) && Intrinsics.c(this.maxConcurrency, payload.maxConcurrency) && Intrinsics.c(this.proberLinks, payload.proberLinks);
        }

        public final Integer getMaxConcurrency() {
            return this.maxConcurrency;
        }

        public final List<Link> getProberLinks() {
            return this.proberLinks;
        }

        public final Integer getVersion() {
            return this.version;
        }

        public int hashCode() {
            Integer num = this.version;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.maxConcurrency;
            int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            List<Link> list = this.proberLinks;
            return hashCode2 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "Payload(version=" + this.version + ", maxConcurrency=" + this.maxConcurrency + ", proberLinks=" + this.proberLinks + ")";
        }
    }

    /* loaded from: classes7.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f60939a;

        static {
            int[] iArr = new int[Protocol.values().length];
            try {
                iArr[Protocol.HTTP_1_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Protocol.HTTP_1_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Protocol.HTTP_2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Protocol.QUIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Protocol.H2_PRIOR_KNOWLEDGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f60939a = iArr;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends EventListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicReference f60940a;

        b(AtomicReference atomicReference) {
            this.f60940a = atomicReference;
        }

        @Override // okhttp3.EventListener
        public void connectionAcquired(Call call, Connection connection) {
            InetAddress address;
            Intrinsics.h(call, "call");
            Intrinsics.h(connection, "connection");
            InetSocketAddress socketAddress = connection.getRoute().socketAddress();
            String str = null;
            if (!(socketAddress instanceof InetSocketAddress)) {
                socketAddress = null;
            }
            if (socketAddress != null && (address = socketAddress.getAddress()) != null) {
                str = address.getHostAddress();
            }
            if (str == null || StringsKt.q0(str)) {
                return;
            }
            this.f60940a.set(str);
        }
    }

    private NetworkProbeRunner() {
    }

    private final Pair d(Throwable th2) {
        if (th2 instanceof SocketTimeoutException) {
            String message = th2.getMessage();
            if (message == null) {
                message = "Operation timeout";
            }
            return TuplesKt.a(3, message);
        }
        if (th2 instanceof UnknownHostException) {
            String message2 = th2.getMessage();
            if (message2 == null) {
                message2 = "DNS lookup failed";
            }
            return TuplesKt.a(1, message2);
        }
        if (th2 instanceof ConnectException) {
            String message3 = th2.getMessage();
            if (message3 == null) {
                message3 = "Failed to connect to host";
            }
            return TuplesKt.a(2, message3);
        }
        if ((th2 instanceof SSLPeerUnverifiedException) || (th2 instanceof SSLHandshakeException)) {
            String message4 = th2.getMessage();
            if (message4 == null) {
                message4 = "SSL peer certificate verification failed";
            }
            return TuplesKt.a(5, message4);
        }
        if (th2 instanceof IOException) {
            String message5 = th2.getMessage();
            if (message5 == null) {
                message5 = "IO error";
            }
            return TuplesKt.a(99, message5);
        }
        String message6 = th2.getMessage();
        if (message6 == null) {
            message6 = "Unknown error";
        }
        return TuplesKt.a(99, message6);
    }

    public static /* synthetic */ Object f(NetworkProbeRunner networkProbeRunner, String str, i0 i0Var, Continuation continuation, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i0Var = y0.b();
        }
        return networkProbeRunner.e(str, i0Var, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g(Link link, Continuation continuation) {
        n nVar;
        Integer retryCount = link.getRetryCount();
        int i11 = 0;
        int f11 = RangesKt.f(retryCount != null ? retryCount.intValue() : 0, 0);
        if (f11 >= 0) {
            while (true) {
                nVar = h(link);
                if (!nVar.m()) {
                    if (i11 == f11) {
                        break;
                    }
                    i11++;
                } else {
                    return nVar;
                }
            }
        } else {
            nVar = null;
        }
        String url = link.getUrl();
        if (url == null) {
            url = "";
        }
        String str = url;
        if (nVar == null) {
            String method = link.getMethod();
            if (method == null) {
                method = "GET";
            }
            String upperCase = method.toUpperCase(Locale.ROOT);
            Intrinsics.g(upperCase, "toUpperCase(...)");
            nVar = new n(str, upperCase, false, -1, "", "Unknown error", 99, MapsKt.h(), "", System.currentTimeMillis(), 0L, TmcConstants.ROUTE_UNKNOWN);
        }
        return nVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x01b0, code lost:
    
        if (r6 == r3) goto L82;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x020d A[Catch: all -> 0x020a, TryCatch #1 {all -> 0x020a, blocks: (B:93:0x0204, B:95:0x024f, B:97:0x0255, B:103:0x020d, B:105:0x0216, B:106:0x022b, B:107:0x023f, B:108:0x0231), top: B:89:0x01f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0146 A[Catch: all -> 0x00ad, TryCatch #3 {all -> 0x00ad, blocks: (B:22:0x005c, B:23:0x0091, B:25:0x0097, B:27:0x00b4, B:29:0x00bc, B:31:0x00c4, B:33:0x00cc, B:37:0x00d8, B:38:0x00e2, B:40:0x00e8, B:44:0x00ff, B:46:0x0103, B:48:0x010d, B:50:0x0117, B:52:0x011d, B:55:0x0129, B:56:0x013d, B:57:0x014e, B:58:0x0173, B:60:0x0179, B:62:0x018b, B:64:0x0191, B:67:0x0198, B:69:0x01a0, B:74:0x01bb, B:86:0x01e5, B:91:0x01f2, B:134:0x0146), top: B:21:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x00fe A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e8 A[Catch: all -> 0x00ad, TryCatch #3 {all -> 0x00ad, blocks: (B:22:0x005c, B:23:0x0091, B:25:0x0097, B:27:0x00b4, B:29:0x00bc, B:31:0x00c4, B:33:0x00cc, B:37:0x00d8, B:38:0x00e2, B:40:0x00e8, B:44:0x00ff, B:46:0x0103, B:48:0x010d, B:50:0x0117, B:52:0x011d, B:55:0x0129, B:56:0x013d, B:57:0x014e, B:58:0x0173, B:60:0x0179, B:62:0x018b, B:64:0x0191, B:67:0x0198, B:69:0x01a0, B:74:0x01bb, B:86:0x01e5, B:91:0x01f2, B:134:0x0146), top: B:21:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0103 A[Catch: all -> 0x00ad, TryCatch #3 {all -> 0x00ad, blocks: (B:22:0x005c, B:23:0x0091, B:25:0x0097, B:27:0x00b4, B:29:0x00bc, B:31:0x00c4, B:33:0x00cc, B:37:0x00d8, B:38:0x00e2, B:40:0x00e8, B:44:0x00ff, B:46:0x0103, B:48:0x010d, B:50:0x0117, B:52:0x011d, B:55:0x0129, B:56:0x013d, B:57:0x014e, B:58:0x0173, B:60:0x0179, B:62:0x018b, B:64:0x0191, B:67:0x0198, B:69:0x01a0, B:74:0x01bb, B:86:0x01e5, B:91:0x01f2, B:134:0x0146), top: B:21:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010d A[Catch: all -> 0x00ad, TryCatch #3 {all -> 0x00ad, blocks: (B:22:0x005c, B:23:0x0091, B:25:0x0097, B:27:0x00b4, B:29:0x00bc, B:31:0x00c4, B:33:0x00cc, B:37:0x00d8, B:38:0x00e2, B:40:0x00e8, B:44:0x00ff, B:46:0x0103, B:48:0x010d, B:50:0x0117, B:52:0x011d, B:55:0x0129, B:56:0x013d, B:57:0x014e, B:58:0x0173, B:60:0x0179, B:62:0x018b, B:64:0x0191, B:67:0x0198, B:69:0x01a0, B:74:0x01bb, B:86:0x01e5, B:91:0x01f2, B:134:0x0146), top: B:21:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0179 A[Catch: all -> 0x00ad, LOOP:2: B:58:0x0173->B:60:0x0179, LOOP_END, TryCatch #3 {all -> 0x00ad, blocks: (B:22:0x005c, B:23:0x0091, B:25:0x0097, B:27:0x00b4, B:29:0x00bc, B:31:0x00c4, B:33:0x00cc, B:37:0x00d8, B:38:0x00e2, B:40:0x00e8, B:44:0x00ff, B:46:0x0103, B:48:0x010d, B:50:0x0117, B:52:0x011d, B:55:0x0129, B:56:0x013d, B:57:0x014e, B:58:0x0173, B:60:0x0179, B:62:0x018b, B:64:0x0191, B:67:0x0198, B:69:0x01a0, B:74:0x01bb, B:86:0x01e5, B:91:0x01f2, B:134:0x0146), top: B:21:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0191 A[Catch: all -> 0x00ad, TryCatch #3 {all -> 0x00ad, blocks: (B:22:0x005c, B:23:0x0091, B:25:0x0097, B:27:0x00b4, B:29:0x00bc, B:31:0x00c4, B:33:0x00cc, B:37:0x00d8, B:38:0x00e2, B:40:0x00e8, B:44:0x00ff, B:46:0x0103, B:48:0x010d, B:50:0x0117, B:52:0x011d, B:55:0x0129, B:56:0x013d, B:57:0x014e, B:58:0x0173, B:60:0x0179, B:62:0x018b, B:64:0x0191, B:67:0x0198, B:69:0x01a0, B:74:0x01bb, B:86:0x01e5, B:91:0x01f2, B:134:0x0146), top: B:21:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a0 A[Catch: all -> 0x00ad, TryCatch #3 {all -> 0x00ad, blocks: (B:22:0x005c, B:23:0x0091, B:25:0x0097, B:27:0x00b4, B:29:0x00bc, B:31:0x00c4, B:33:0x00cc, B:37:0x00d8, B:38:0x00e2, B:40:0x00e8, B:44:0x00ff, B:46:0x0103, B:48:0x010d, B:50:0x0117, B:52:0x011d, B:55:0x0129, B:56:0x013d, B:57:0x014e, B:58:0x0173, B:60:0x0179, B:62:0x018b, B:64:0x0191, B:67:0x0198, B:69:0x01a0, B:74:0x01bb, B:86:0x01e5, B:91:0x01f2, B:134:0x0146), top: B:21:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01f2 A[Catch: all -> 0x00ad, TRY_LEAVE, TryCatch #3 {all -> 0x00ad, blocks: (B:22:0x005c, B:23:0x0091, B:25:0x0097, B:27:0x00b4, B:29:0x00bc, B:31:0x00c4, B:33:0x00cc, B:37:0x00d8, B:38:0x00e2, B:40:0x00e8, B:44:0x00ff, B:46:0x0103, B:48:0x010d, B:50:0x0117, B:52:0x011d, B:55:0x0129, B:56:0x013d, B:57:0x014e, B:58:0x0173, B:60:0x0179, B:62:0x018b, B:64:0x0191, B:67:0x0198, B:69:0x01a0, B:74:0x01bb, B:86:0x01e5, B:91:0x01f2, B:134:0x0146), top: B:21:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0255 A[Catch: all -> 0x020a, TRY_LEAVE, TryCatch #1 {all -> 0x020a, blocks: (B:93:0x0204, B:95:0x024f, B:97:0x0255, B:103:0x020d, B:105:0x0216, B:106:0x022b, B:107:0x023f, B:108:0x0231), top: B:89:0x01f0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.wecloud.load.lib.n h(com.wecloud.load.lib.NetworkProbeRunner.Link r43) {
        /*
            Method dump skipped, instructions count: 707
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wecloud.load.lib.NetworkProbeRunner.h(com.wecloud.load.lib.NetworkProbeRunner$Link):com.wecloud.load.lib.n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventListener i(AtomicReference atomicReference, Call it) {
        Intrinsics.h(it, "it");
        return new b(atomicReference);
    }

    public final Object e(String str, i0 i0Var, Continuation continuation) {
        return kotlinx.coroutines.i.g(i0Var, new NetworkProbeRunner$run$2(str, null), continuation);
    }
}
