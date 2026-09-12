package com.therouter.router;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private String f40836a;

    /* renamed from: b, reason: collision with root package name */
    private String f40837b;

    /* renamed from: c, reason: collision with root package name */
    private int f40838c;

    /* renamed from: d, reason: collision with root package name */
    private String f40839d;

    /* renamed from: e, reason: collision with root package name */
    private String f40840e;

    /* renamed from: f, reason: collision with root package name */
    private String f40841f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f40842g;

    /* renamed from: h, reason: collision with root package name */
    private String f40843h;

    public b(String type, String key, int i11, String args, String className, String fieldName, boolean z10, String description) {
        Intrinsics.h(type, "type");
        Intrinsics.h(key, "key");
        Intrinsics.h(args, "args");
        Intrinsics.h(className, "className");
        Intrinsics.h(fieldName, "fieldName");
        Intrinsics.h(description, "description");
        this.f40836a = type;
        this.f40837b = key;
        this.f40838c = i11;
        this.f40839d = args;
        this.f40840e = className;
        this.f40841f = fieldName;
        this.f40842g = z10;
        this.f40843h = description;
    }

    public final int a() {
        return this.f40838c;
    }

    public final String b() {
        return this.f40837b;
    }

    public final String c() {
        return this.f40836a;
    }
}
