package com.mbridge.msdk.video.signal.factory;

import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.d;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.g;
import com.mbridge.msdk.video.signal.i;
import com.mbridge.msdk.video.signal.impl.e;
import com.mbridge.msdk.video.signal.impl.h;
import com.mbridge.msdk.video.signal.j;

/* loaded from: classes5.dex */
public class a implements IJSFactory {

    /* renamed from: a, reason: collision with root package name */
    protected com.mbridge.msdk.video.signal.b f39850a;

    /* renamed from: b, reason: collision with root package name */
    protected d f39851b;

    /* renamed from: c, reason: collision with root package name */
    protected j f39852c;

    /* renamed from: d, reason: collision with root package name */
    protected g f39853d;

    /* renamed from: e, reason: collision with root package name */
    protected f f39854e;

    /* renamed from: f, reason: collision with root package name */
    protected i f39855f;

    /* renamed from: g, reason: collision with root package name */
    protected c f39856g;

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public com.mbridge.msdk.video.signal.b getActivityProxy() {
        if (this.f39850a == null) {
            this.f39850a = new com.mbridge.msdk.video.signal.impl.b();
        }
        return this.f39850a;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public i getIJSRewardVideoV1() {
        if (this.f39855f == null) {
            this.f39855f = new com.mbridge.msdk.video.signal.impl.g();
        }
        return this.f39855f;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public c getJSBTModule() {
        if (this.f39856g == null) {
            this.f39856g = new com.mbridge.msdk.video.signal.impl.c();
        }
        return this.f39856g;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public d getJSCommon() {
        if (this.f39851b == null) {
            this.f39851b = new com.mbridge.msdk.video.signal.impl.d();
        }
        return this.f39851b;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public f getJSContainerModule() {
        if (this.f39854e == null) {
            this.f39854e = new e();
        }
        return this.f39854e;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public g getJSNotifyProxy() {
        if (this.f39853d == null) {
            this.f39853d = new com.mbridge.msdk.video.signal.impl.f();
        }
        return this.f39853d;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public j getJSVideoModule() {
        if (this.f39852c == null) {
            this.f39852c = new h();
        }
        return this.f39852c;
    }
}
