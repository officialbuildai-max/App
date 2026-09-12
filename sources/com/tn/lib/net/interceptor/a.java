package com.tn.lib.net.interceptor;

import com.tn.lib.net.interceptor.HttpLoggingInterceptor;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes3.dex */
public final class a implements HttpLoggingInterceptor.a {

    /* renamed from: c, reason: collision with root package name */
    private String f40895c = "HttpLogInterceptor";

    @Override // com.tn.lib.net.interceptor.HttpLoggingInterceptor.a
    public void log(String message) {
        Intrinsics.h(message, "message");
        a.C0856a.f(lg.a.f68962a, this.f40895c, message, false, 4, null);
    }
}
