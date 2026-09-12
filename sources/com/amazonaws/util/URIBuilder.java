package com.amazonaws.util;

import com.amazonaws.Protocol;
import java.net.URI;

/* loaded from: classes2.dex */
public class URIBuilder {

    /* renamed from: h, reason: collision with root package name */
    private static final String f19092h = Protocol.HTTPS.toString();

    /* renamed from: a, reason: collision with root package name */
    private String f19093a;

    /* renamed from: b, reason: collision with root package name */
    private String f19094b;

    /* renamed from: c, reason: collision with root package name */
    private String f19095c;

    /* renamed from: d, reason: collision with root package name */
    private int f19096d;

    /* renamed from: e, reason: collision with root package name */
    private String f19097e;

    /* renamed from: f, reason: collision with root package name */
    private String f19098f;

    /* renamed from: g, reason: collision with root package name */
    private String f19099g;

    private URIBuilder(URI uri) {
        this.f19093a = uri.getScheme();
        this.f19094b = uri.getUserInfo();
        this.f19095c = uri.getHost();
        this.f19096d = uri.getPort();
        this.f19097e = uri.getPath();
        this.f19098f = uri.getQuery();
        this.f19099g = uri.getFragment();
    }

    public static URIBuilder b(URI uri) {
        return new URIBuilder(uri);
    }

    public URI a() {
        return new URI(this.f19093a, this.f19094b, this.f19095c, this.f19096d, this.f19097e, this.f19098f, this.f19099g);
    }

    public URIBuilder c(String str) {
        this.f19095c = str;
        return this;
    }
}
