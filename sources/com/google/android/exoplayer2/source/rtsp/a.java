package com.google.android.exoplayer2.source.rtsp;

import com.cloud.tmc.kernel.utils.UrlUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.ImmutableMap;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f26357a;

    /* renamed from: b, reason: collision with root package name */
    public final int f26358b;

    /* renamed from: c, reason: collision with root package name */
    public final String f26359c;

    /* renamed from: d, reason: collision with root package name */
    public final int f26360d;

    /* renamed from: e, reason: collision with root package name */
    public final int f26361e;

    /* renamed from: f, reason: collision with root package name */
    public final String f26362f;

    /* renamed from: g, reason: collision with root package name */
    public final String f26363g;

    /* renamed from: h, reason: collision with root package name */
    public final String f26364h;

    /* renamed from: i, reason: collision with root package name */
    public final ImmutableMap f26365i;

    /* renamed from: j, reason: collision with root package name */
    public final c f26366j;

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f26367a;

        /* renamed from: b, reason: collision with root package name */
        private final int f26368b;

        /* renamed from: c, reason: collision with root package name */
        private final String f26369c;

        /* renamed from: d, reason: collision with root package name */
        private final int f26370d;

        /* renamed from: e, reason: collision with root package name */
        private final HashMap f26371e = new HashMap();

        /* renamed from: f, reason: collision with root package name */
        private int f26372f = -1;

        /* renamed from: g, reason: collision with root package name */
        private String f26373g;

        /* renamed from: h, reason: collision with root package name */
        private String f26374h;

        /* renamed from: i, reason: collision with root package name */
        private String f26375i;

        public b(String str, int i11, String str2, int i12) {
            this.f26367a = str;
            this.f26368b = i11;
            this.f26369c = str2;
            this.f26370d = i12;
        }

        public b i(String str, String str2) {
            this.f26371e.put(str, str2);
            return this;
        }

        public a j() {
            try {
                com.google.android.exoplayer2.util.a.g(this.f26371e.containsKey("rtpmap"));
                return new a(this, ImmutableMap.copyOf((Map) this.f26371e), c.a((String) p0.j((String) this.f26371e.get("rtpmap"))));
            } catch (ParserException e11) {
                throw new IllegalStateException(e11);
            }
        }

        public b k(int i11) {
            this.f26372f = i11;
            return this;
        }

        public b l(String str) {
            this.f26374h = str;
            return this;
        }

        public b m(String str) {
            this.f26375i = str;
            return this;
        }

        public b n(String str) {
            this.f26373g = str;
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f26376a;

        /* renamed from: b, reason: collision with root package name */
        public final String f26377b;

        /* renamed from: c, reason: collision with root package name */
        public final int f26378c;

        /* renamed from: d, reason: collision with root package name */
        public final int f26379d;

        private c(int i11, String str, int i12, int i13) {
            this.f26376a = i11;
            this.f26377b = str;
            this.f26378c = i12;
            this.f26379d = i13;
        }

        public static c a(String str) {
            String[] T0 = p0.T0(str, " ");
            com.google.android.exoplayer2.util.a.a(T0.length == 2);
            int g11 = y.g(T0[0]);
            String[] S0 = p0.S0(T0[1].trim(), "/");
            com.google.android.exoplayer2.util.a.a(S0.length >= 2);
            return new c(g11, S0[0], y.g(S0[1]), S0.length == 3 ? y.g(S0[2]) : -1);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return this.f26376a == cVar.f26376a && this.f26377b.equals(cVar.f26377b) && this.f26378c == cVar.f26378c && this.f26379d == cVar.f26379d;
        }

        public int hashCode() {
            return ((((((Sdk$SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE + this.f26376a) * 31) + this.f26377b.hashCode()) * 31) + this.f26378c) * 31) + this.f26379d;
        }
    }

    private a(b bVar, ImmutableMap immutableMap, c cVar) {
        this.f26357a = bVar.f26367a;
        this.f26358b = bVar.f26368b;
        this.f26359c = bVar.f26369c;
        this.f26360d = bVar.f26370d;
        this.f26362f = bVar.f26373g;
        this.f26363g = bVar.f26374h;
        this.f26361e = bVar.f26372f;
        this.f26364h = bVar.f26375i;
        this.f26365i = immutableMap;
        this.f26366j = cVar;
    }

    public ImmutableMap a() {
        String str = (String) this.f26365i.get("fmtp");
        if (str == null) {
            return ImmutableMap.of();
        }
        String[] T0 = p0.T0(str, " ");
        com.google.android.exoplayer2.util.a.b(T0.length == 2, str);
        String[] split = T0[1].split(";\\s?", 0);
        ImmutableMap.b bVar = new ImmutableMap.b();
        for (String str2 : split) {
            String[] T02 = p0.T0(str2, UrlUtils.EQUAL_MARK);
            bVar.h(T02[0], T02[1]);
        }
        return bVar.d();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f26357a.equals(aVar.f26357a) && this.f26358b == aVar.f26358b && this.f26359c.equals(aVar.f26359c) && this.f26360d == aVar.f26360d && this.f26361e == aVar.f26361e && this.f26365i.equals(aVar.f26365i) && this.f26366j.equals(aVar.f26366j) && p0.c(this.f26362f, aVar.f26362f) && p0.c(this.f26363g, aVar.f26363g) && p0.c(this.f26364h, aVar.f26364h);
    }

    public int hashCode() {
        int hashCode = (((((((((((((Sdk$SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE + this.f26357a.hashCode()) * 31) + this.f26358b) * 31) + this.f26359c.hashCode()) * 31) + this.f26360d) * 31) + this.f26361e) * 31) + this.f26365i.hashCode()) * 31) + this.f26366j.hashCode()) * 31;
        String str = this.f26362f;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f26363g;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f26364h;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }
}
