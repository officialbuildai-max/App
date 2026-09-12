package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.sessions.api.SessionSubscriber;

/* loaded from: classes4.dex */
public class k implements SessionSubscriber {

    /* renamed from: a, reason: collision with root package name */
    private final d0 f31248a;

    /* renamed from: b, reason: collision with root package name */
    private final j f31249b;

    public k(d0 d0Var, vb.g gVar) {
        this.f31248a = d0Var;
        this.f31249b = new j(gVar);
    }

    @Override // com.google.firebase.sessions.api.SessionSubscriber
    public boolean a() {
        return this.f31248a.d();
    }

    @Override // com.google.firebase.sessions.api.SessionSubscriber
    public SessionSubscriber.Name b() {
        return SessionSubscriber.Name.CRASHLYTICS;
    }

    @Override // com.google.firebase.sessions.api.SessionSubscriber
    public void c(SessionSubscriber.a aVar) {
        ob.g.f().b("App Quality Sessions session changed: " + aVar);
        this.f31249b.h(aVar.a());
    }

    public String d(String str) {
        return this.f31249b.c(str);
    }

    public void e(String str) {
        this.f31249b.i(str);
    }
}
