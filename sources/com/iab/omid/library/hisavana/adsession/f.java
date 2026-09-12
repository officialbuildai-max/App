package com.iab.omid.library.hisavana.adsession;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final String f33604a;

    /* renamed from: b, reason: collision with root package name */
    private final String f33605b;

    private f(String str, String str2) {
        this.f33604a = str;
        this.f33605b = str2;
    }

    public static f a(String str, String str2) {
        ie.g.f(str, "Name is null or empty");
        ie.g.f(str2, "Version is null or empty");
        return new f(str, str2);
    }

    public String b() {
        return this.f33604a;
    }

    public String c() {
        return this.f33605b;
    }
}
