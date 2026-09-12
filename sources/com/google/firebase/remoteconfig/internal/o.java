package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private final Set f32601a;

    /* renamed from: b, reason: collision with root package name */
    private final ConfigRealtimeHttpClient f32602b;

    /* renamed from: c, reason: collision with root package name */
    private final ConfigFetchHandler f32603c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.firebase.f f32604d;

    /* renamed from: e, reason: collision with root package name */
    private final jc.e f32605e;

    /* renamed from: f, reason: collision with root package name */
    private final e f32606f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f32607g;

    /* renamed from: h, reason: collision with root package name */
    private final String f32608h;

    /* renamed from: i, reason: collision with root package name */
    private final n f32609i;

    /* renamed from: j, reason: collision with root package name */
    private final ScheduledExecutorService f32610j;

    public o(com.google.firebase.f fVar, jc.e eVar, ConfigFetchHandler configFetchHandler, e eVar2, Context context, String str, n nVar, ScheduledExecutorService scheduledExecutorService) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.f32601a = linkedHashSet;
        this.f32602b = new ConfigRealtimeHttpClient(fVar, eVar, configFetchHandler, eVar2, context, str, linkedHashSet, nVar, scheduledExecutorService);
        this.f32604d = fVar;
        this.f32603c = configFetchHandler;
        this.f32605e = eVar;
        this.f32606f = eVar2;
        this.f32607g = context;
        this.f32608h = str;
        this.f32609i = nVar;
        this.f32610j = scheduledExecutorService;
    }

    private synchronized void a() {
        if (!this.f32601a.isEmpty()) {
            this.f32602b.C();
        }
    }

    public synchronized void b(boolean z10) {
        this.f32602b.z(z10);
        if (!z10) {
            a();
        }
    }
}
