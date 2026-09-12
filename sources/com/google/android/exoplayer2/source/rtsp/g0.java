package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    public final ImmutableMap f26446a;

    /* renamed from: b, reason: collision with root package name */
    public final ImmutableList f26447b;

    /* renamed from: c, reason: collision with root package name */
    public final String f26448c;

    /* renamed from: d, reason: collision with root package name */
    public final String f26449d;

    /* renamed from: e, reason: collision with root package name */
    public final String f26450e;

    /* renamed from: f, reason: collision with root package name */
    public final int f26451f;

    /* renamed from: g, reason: collision with root package name */
    public final Uri f26452g;

    /* renamed from: h, reason: collision with root package name */
    public final String f26453h;

    /* renamed from: i, reason: collision with root package name */
    public final String f26454i;

    /* renamed from: j, reason: collision with root package name */
    public final String f26455j;

    /* renamed from: k, reason: collision with root package name */
    public final String f26456k;

    /* renamed from: l, reason: collision with root package name */
    public final String f26457l;

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final HashMap f26458a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        private final ImmutableList.a f26459b = new ImmutableList.a();

        /* renamed from: c, reason: collision with root package name */
        private int f26460c = -1;

        /* renamed from: d, reason: collision with root package name */
        private String f26461d;

        /* renamed from: e, reason: collision with root package name */
        private String f26462e;

        /* renamed from: f, reason: collision with root package name */
        private String f26463f;

        /* renamed from: g, reason: collision with root package name */
        private Uri f26464g;

        /* renamed from: h, reason: collision with root package name */
        private String f26465h;

        /* renamed from: i, reason: collision with root package name */
        private String f26466i;

        /* renamed from: j, reason: collision with root package name */
        private String f26467j;

        /* renamed from: k, reason: collision with root package name */
        private String f26468k;

        /* renamed from: l, reason: collision with root package name */
        private String f26469l;

        public b m(String str, String str2) {
            this.f26458a.put(str, str2);
            return this;
        }

        public b n(com.google.android.exoplayer2.source.rtsp.a aVar) {
            this.f26459b.a(aVar);
            return this;
        }

        public g0 o() {
            if (this.f26461d == null || this.f26462e == null || this.f26463f == null) {
                throw new IllegalStateException("One of more mandatory SDP fields are not set.");
            }
            return new g0(this);
        }

        public b p(int i11) {
            this.f26460c = i11;
            return this;
        }

        public b q(String str) {
            this.f26465h = str;
            return this;
        }

        public b r(String str) {
            this.f26468k = str;
            return this;
        }

        public b s(String str) {
            this.f26466i = str;
            return this;
        }

        public b t(String str) {
            this.f26462e = str;
            return this;
        }

        public b u(String str) {
            this.f26469l = str;
            return this;
        }

        public b v(String str) {
            this.f26467j = str;
            return this;
        }

        public b w(String str) {
            this.f26461d = str;
            return this;
        }

        public b x(String str) {
            this.f26463f = str;
            return this;
        }

        public b y(Uri uri) {
            this.f26464g = uri;
            return this;
        }
    }

    private g0(b bVar) {
        this.f26446a = ImmutableMap.copyOf((Map) bVar.f26458a);
        this.f26447b = bVar.f26459b.e();
        this.f26448c = (String) p0.j(bVar.f26461d);
        this.f26449d = (String) p0.j(bVar.f26462e);
        this.f26450e = (String) p0.j(bVar.f26463f);
        this.f26452g = bVar.f26464g;
        this.f26453h = bVar.f26465h;
        this.f26451f = bVar.f26460c;
        this.f26454i = bVar.f26466i;
        this.f26455j = bVar.f26468k;
        this.f26456k = bVar.f26469l;
        this.f26457l = bVar.f26467j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g0.class != obj.getClass()) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.f26451f == g0Var.f26451f && this.f26446a.equals(g0Var.f26446a) && this.f26447b.equals(g0Var.f26447b) && this.f26449d.equals(g0Var.f26449d) && this.f26448c.equals(g0Var.f26448c) && this.f26450e.equals(g0Var.f26450e) && p0.c(this.f26457l, g0Var.f26457l) && p0.c(this.f26452g, g0Var.f26452g) && p0.c(this.f26455j, g0Var.f26455j) && p0.c(this.f26456k, g0Var.f26456k) && p0.c(this.f26453h, g0Var.f26453h) && p0.c(this.f26454i, g0Var.f26454i);
    }

    public int hashCode() {
        int hashCode = (((((((((((Sdk$SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE + this.f26446a.hashCode()) * 31) + this.f26447b.hashCode()) * 31) + this.f26449d.hashCode()) * 31) + this.f26448c.hashCode()) * 31) + this.f26450e.hashCode()) * 31) + this.f26451f) * 31;
        String str = this.f26457l;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Uri uri = this.f26452g;
        int hashCode3 = (hashCode2 + (uri == null ? 0 : uri.hashCode())) * 31;
        String str2 = this.f26455j;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f26456k;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f26453h;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f26454i;
        return hashCode6 + (str5 != null ? str5.hashCode() : 0);
    }
}
