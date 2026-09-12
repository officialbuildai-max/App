package com.transsion.http.d;

import java.util.UUID;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f45981a = new a("FORM", 0, "application/x-www-form-urlencoded");

    /* renamed from: b, reason: collision with root package name */
    public static final a f45982b = new a("JSON", 1, "application/json");

    /* renamed from: c, reason: collision with root package name */
    public static final a f45983c = new a("FILE", 2, "multipart/form-data;boundary=--" + UUID.randomUUID().toString());

    /* renamed from: d, reason: collision with root package name */
    private final String f45984d;

    private a(String str, int i11, String str2) {
        this.f45984d = str2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f45984d;
    }
}
