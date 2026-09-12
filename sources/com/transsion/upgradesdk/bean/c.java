package com.transsion.upgradesdk.bean;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public static final c f56711b;

    /* renamed from: c, reason: collision with root package name */
    public static final c f56712c;

    /* renamed from: d, reason: collision with root package name */
    public static final c f56713d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ c[] f56714e;

    /* renamed from: a, reason: collision with root package name */
    public final int f56715a;

    static {
        c cVar = new c("STATUS_DEFAULT", 0, 0);
        f56711b = cVar;
        c cVar2 = new c("DEFAULT", 1, 1);
        f56712c = cVar2;
        c cVar3 = new c("CUSTOM", 2, 2);
        f56713d = cVar3;
        c[] cVarArr = {cVar, cVar2, cVar3};
        f56714e = cVarArr;
        EnumEntriesKt.a(cVarArr);
    }

    public c(String str, int i11, int i12) {
        this.f56715a = i12;
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f56714e.clone();
    }
}
