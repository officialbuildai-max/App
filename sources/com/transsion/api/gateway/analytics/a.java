package com.transsion.api.gateway.analytics;

/* loaded from: classes.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public boolean f42536c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f42537d;

    /* renamed from: e, reason: collision with root package name */
    public long f42538e;

    /* renamed from: f, reason: collision with root package name */
    public String f42539f;

    /* renamed from: g, reason: collision with root package name */
    public String f42540g;

    /* renamed from: h, reason: collision with root package name */
    public String f42541h;

    /* renamed from: i, reason: collision with root package name */
    public String f42542i;

    /* renamed from: j, reason: collision with root package name */
    public int f42543j;

    /* renamed from: k, reason: collision with root package name */
    public int f42544k;

    /* renamed from: b, reason: collision with root package name */
    public long f42535b = System.currentTimeMillis();

    /* renamed from: a, reason: collision with root package name */
    public String f42534a = String.valueOf(System.currentTimeMillis());

    public String toString() {
        return "RequestAnalyticsData{requestId='" + this.f42534a + "', requestSubId='" + ((String) null) + "', requestStartTime=" + this.f42535b + ", subRequestStartTime=0, isIpConnect=" + this.f42536c + ", isGateway=" + this.f42537d + ", requestSize=" + this.f42538e + ", responseSize=0, ip='" + ((String) null) + "', host='" + this.f42539f + "', netQuality=0, path='" + this.f42540g + "', originUrl='" + this.f42541h + "', originHost='" + this.f42542i + "', domain='" + ((String) null) + "', result='" + ((String) null) + "', retryTime=" + this.f42543j + ", responseCode=" + this.f42544k + '}';
    }
}
