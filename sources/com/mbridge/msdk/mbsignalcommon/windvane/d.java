package com.mbridge.msdk.mbsignalcommon.windvane;

/* loaded from: classes5.dex */
public enum d {
    JS("js", "application/x-javascript"),
    CSS("css", "text/css"),
    JPG("jpg", "image/jpeg"),
    JPEG("jpep", "image/jpeg"),
    PNG("png", "image/png"),
    WEBP("webp", "image/webp"),
    GIF("gif", "image/gif"),
    HTM("htm", "text/html"),
    HTML("html", "text/html");


    /* renamed from: a, reason: collision with root package name */
    private String f36611a;

    /* renamed from: b, reason: collision with root package name */
    private String f36612b;

    d(String str, String str2) {
        this.f36611a = str;
        this.f36612b = str2;
    }

    public String b() {
        return this.f36612b;
    }

    public String c() {
        return this.f36611a;
    }
}
