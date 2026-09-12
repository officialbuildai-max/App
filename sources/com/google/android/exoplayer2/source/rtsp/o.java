package com.google.android.exoplayer2.source.rtsp;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.g3;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class o {

    /* renamed from: b, reason: collision with root package name */
    public static final o f26499b = new b().e();

    /* renamed from: a, reason: collision with root package name */
    private final ImmutableListMultimap f26500a;

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final ImmutableListMultimap.a f26501a;

        public b() {
            this.f26501a = new ImmutableListMultimap.a();
        }

        public b(String str, String str2, int i11) {
            this();
            b("User-Agent", str);
            b("CSeq", String.valueOf(i11));
            if (str2 != null) {
                b("Session", str2);
            }
        }

        public b b(String str, String str2) {
            this.f26501a.f(o.c(str.trim()), str2.trim());
            return this;
        }

        public b c(List list) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                String[] T0 = p0.T0((String) list.get(i11), ":\\s?");
                if (T0.length == 2) {
                    b(T0[0], T0[1]);
                }
            }
            return this;
        }

        public b d(Map map) {
            for (Map.Entry entry : map.entrySet()) {
                b((String) entry.getKey(), (String) entry.getValue());
            }
            return this;
        }

        public o e() {
            return new o(this);
        }
    }

    private o(b bVar) {
        this.f26500a = bVar.f26501a.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(String str) {
        return com.google.common.base.a.a(str, "Accept") ? "Accept" : com.google.common.base.a.a(str, "Allow") ? "Allow" : com.google.common.base.a.a(str, HttpHeaders.AUTHORIZATION) ? HttpHeaders.AUTHORIZATION : com.google.common.base.a.a(str, "Bandwidth") ? "Bandwidth" : com.google.common.base.a.a(str, "Blocksize") ? "Blocksize" : com.google.common.base.a.a(str, HttpHeaders.CACHE_CONTROL) ? HttpHeaders.CACHE_CONTROL : com.google.common.base.a.a(str, "Connection") ? "Connection" : com.google.common.base.a.a(str, "Content-Base") ? "Content-Base" : com.google.common.base.a.a(str, HttpHeaders.CONTENT_ENCODING) ? HttpHeaders.CONTENT_ENCODING : com.google.common.base.a.a(str, "Content-Language") ? "Content-Language" : com.google.common.base.a.a(str, HttpHeaders.CONTENT_LENGTH) ? HttpHeaders.CONTENT_LENGTH : com.google.common.base.a.a(str, "Content-Location") ? "Content-Location" : com.google.common.base.a.a(str, HttpHeaders.CONTENT_TYPE) ? HttpHeaders.CONTENT_TYPE : com.google.common.base.a.a(str, "CSeq") ? "CSeq" : com.google.common.base.a.a(str, HttpHeaders.DATE) ? HttpHeaders.DATE : com.google.common.base.a.a(str, HttpHeaders.EXPIRES) ? HttpHeaders.EXPIRES : com.google.common.base.a.a(str, HttpHeaders.LOCATION) ? HttpHeaders.LOCATION : com.google.common.base.a.a(str, "Proxy-Authenticate") ? "Proxy-Authenticate" : com.google.common.base.a.a(str, "Proxy-Require") ? "Proxy-Require" : com.google.common.base.a.a(str, "Public") ? "Public" : com.google.common.base.a.a(str, "Range") ? "Range" : com.google.common.base.a.a(str, "RTP-Info") ? "RTP-Info" : com.google.common.base.a.a(str, "RTCP-Interval") ? "RTCP-Interval" : com.google.common.base.a.a(str, "Scale") ? "Scale" : com.google.common.base.a.a(str, "Session") ? "Session" : com.google.common.base.a.a(str, "Speed") ? "Speed" : com.google.common.base.a.a(str, "Supported") ? "Supported" : com.google.common.base.a.a(str, "Timestamp") ? "Timestamp" : com.google.common.base.a.a(str, "Transport") ? "Transport" : com.google.common.base.a.a(str, "User-Agent") ? "User-Agent" : com.google.common.base.a.a(str, "Via") ? "Via" : com.google.common.base.a.a(str, "WWW-Authenticate") ? "WWW-Authenticate" : str;
    }

    public ImmutableListMultimap b() {
        return this.f26500a;
    }

    public String d(String str) {
        ImmutableList e11 = e(str);
        if (e11.isEmpty()) {
            return null;
        }
        return (String) g3.g(e11);
    }

    public ImmutableList e(String str) {
        return this.f26500a.get((ImmutableListMultimap) c(str));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o) {
            return this.f26500a.equals(((o) obj).f26500a);
        }
        return false;
    }

    public int hashCode() {
        return this.f26500a.hashCode();
    }
}
