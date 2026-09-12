package com.mbridge.msdk.click.entity;

import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f34365a;

    /* renamed from: b, reason: collision with root package name */
    public String f34366b;

    /* renamed from: c, reason: collision with root package name */
    public String f34367c;

    /* renamed from: d, reason: collision with root package name */
    public String f34368d;

    /* renamed from: e, reason: collision with root package name */
    public int f34369e;

    /* renamed from: f, reason: collision with root package name */
    public int f34370f;

    /* renamed from: g, reason: collision with root package name */
    public String f34371g;

    /* renamed from: h, reason: collision with root package name */
    public String f34372h;

    public String a() {
        return "statusCode=" + this.f34370f + ", location=" + this.f34365a + ", contentType=" + this.f34366b + ", contentLength=" + this.f34369e + ", contentEncoding=" + this.f34367c + ", referer=" + this.f34368d;
    }

    @NonNull
    public String toString() {
        return "ClickResponseHeader{location='" + this.f34365a + "', contentType='" + this.f34366b + "', contentEncoding='" + this.f34367c + "', referer='" + this.f34368d + "', contentLength=" + this.f34369e + ", statusCode=" + this.f34370f + ", url='" + this.f34371g + "', exception='" + this.f34372h + "'}";
    }
}
