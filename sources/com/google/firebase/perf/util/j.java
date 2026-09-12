package com.google.firebase.perf.util;

import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes4.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final URL f32434a;

    public j(URL url) {
        this.f32434a = url;
    }

    public URLConnection a() {
        return this.f32434a.openConnection();
    }

    public String toString() {
        return this.f32434a.toString();
    }
}
