package com.android.volley;

import com.android.volley.c;

/* loaded from: classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final Object f19333a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a f19334b;

    /* renamed from: c, reason: collision with root package name */
    public final VolleyError f19335c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f19336d;

    /* loaded from: classes2.dex */
    public interface a {
        void onErrorResponse(VolleyError volleyError);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onResponse(Object obj);
    }

    private i(VolleyError volleyError) {
        this.f19336d = false;
        this.f19333a = null;
        this.f19334b = null;
        this.f19335c = volleyError;
    }

    private i(Object obj, c.a aVar) {
        this.f19336d = false;
        this.f19333a = obj;
        this.f19334b = aVar;
        this.f19335c = null;
    }

    public static i a(VolleyError volleyError) {
        return new i(volleyError);
    }

    public static i c(Object obj, c.a aVar) {
        return new i(obj, aVar);
    }

    public boolean b() {
        return this.f19335c == null;
    }
}
