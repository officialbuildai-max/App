package com.amazonaws;

import com.amazonaws.http.HttpResponse;

/* loaded from: classes2.dex */
public final class Response<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Object f18399a;

    /* renamed from: b, reason: collision with root package name */
    private final HttpResponse f18400b;

    public Response(Object obj, HttpResponse httpResponse) {
        this.f18399a = obj;
        this.f18400b = httpResponse;
    }

    public Object a() {
        return this.f18399a;
    }
}
