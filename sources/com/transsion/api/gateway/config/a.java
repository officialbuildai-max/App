package com.transsion.api.gateway.config;

import com.transsion.api.gateway.bean.RemoteConfig;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f42546a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f42547b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f42548c;

    /* renamed from: d, reason: collision with root package name */
    public final int f42549d;

    /* renamed from: e, reason: collision with root package name */
    public final long f42550e;

    /* renamed from: f, reason: collision with root package name */
    public final int f42551f;

    /* renamed from: g, reason: collision with root package name */
    public final long f42552g;

    /* renamed from: h, reason: collision with root package name */
    public final String f42553h;

    /* renamed from: i, reason: collision with root package name */
    public final List f42554i;

    /* renamed from: j, reason: collision with root package name */
    public final List f42555j;

    /* renamed from: k, reason: collision with root package name */
    public final List f42556k;

    /* renamed from: com.transsion.api.gateway.config.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0602a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f42557a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f42558b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f42559c;

        /* renamed from: d, reason: collision with root package name */
        public int f42560d;

        /* renamed from: e, reason: collision with root package name */
        public long f42561e;

        /* renamed from: f, reason: collision with root package name */
        public long f42562f;

        /* renamed from: g, reason: collision with root package name */
        public String f42563g;

        /* renamed from: h, reason: collision with root package name */
        public List f42564h;

        /* renamed from: i, reason: collision with root package name */
        public int f42565i;

        /* renamed from: j, reason: collision with root package name */
        public List f42566j;

        /* renamed from: k, reason: collision with root package name */
        public List f42567k;

        public C0602a() {
            this.f42557a = false;
            this.f42558b = false;
            this.f42559c = true;
            this.f42560d = 60000;
            this.f42561e = 3600000L;
            this.f42562f = 3600000L;
            this.f42565i = 0;
            this.f42566j = new ArrayList();
            this.f42567k = new ArrayList();
        }

        public C0602a(a aVar) {
            this.f42557a = aVar.f42546a;
            this.f42558b = aVar.f42547b;
            this.f42559c = aVar.f42548c;
            this.f42560d = aVar.f42549d;
            this.f42561e = aVar.f42550e;
            this.f42562f = aVar.f42552g;
            this.f42566j = aVar.f42555j;
            this.f42567k = aVar.f42556k;
            this.f42565i = aVar.f42551f;
            this.f42563g = aVar.f42553h;
            this.f42564h = aVar.f42554i;
        }

        public C0602a a(RemoteConfig remoteConfig) {
            this.f42557a = remoteConfig.activateGatewayDns;
            this.f42558b = remoteConfig.useGateway;
            this.f42559c = remoteConfig.activateTracking;
            this.f42560d = remoteConfig.requestTimeout;
            this.f42561e = remoteConfig.refreshInterval;
            this.f42562f = remoteConfig.metricsInterval;
            this.f42566j = remoteConfig.useGatewayHostList;
            this.f42567k = remoteConfig.gatewayStrategy;
            this.f42565i = remoteConfig.configVersion;
            this.f42563g = remoteConfig.gatewayHost;
            this.f42564h = remoteConfig.gatewayIp;
            return this;
        }
    }

    public a(C0602a c0602a) {
        this.f42546a = c0602a.f42557a;
        this.f42547b = c0602a.f42558b;
        this.f42548c = c0602a.f42559c;
        this.f42549d = c0602a.f42560d;
        this.f42550e = c0602a.f42561e;
        this.f42551f = c0602a.f42565i;
        this.f42552g = c0602a.f42562f;
        this.f42553h = c0602a.f42563g;
        this.f42554i = c0602a.f42564h;
        this.f42555j = c0602a.f42566j;
        this.f42556k = c0602a.f42567k;
    }

    public String toString() {
        return "GatewayConfig{activateGatewayDns=" + this.f42546a + ", useGateway=" + this.f42547b + ", activateTracking=" + this.f42548c + ", requestTimeout=" + this.f42549d + ", refreshInterval=" + this.f42550e + ", configVersion=" + this.f42551f + ", metricsInterval=" + this.f42552g + ", gatewayHost='" + this.f42553h + "', gatewayIp=" + this.f42554i + ", useGatewayHostList=" + this.f42555j + ", gatewayStrategy=" + this.f42556k + '}';
    }
}
