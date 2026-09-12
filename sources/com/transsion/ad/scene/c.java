package com.transsion.ad.scene;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import hi.e;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f42257a = new c();

    private c() {
    }

    public static /* synthetic */ boolean b(c cVar, String str, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        return cVar.a(str, z10);
    }

    public static /* synthetic */ boolean d(c cVar, String str, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        return cVar.c(str, z10);
    }

    public static /* synthetic */ boolean f(c cVar, String str, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        return cVar.e(str, z10);
    }

    public final boolean a(String str, boolean z10) {
        Object m1185constructorimpl;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.INSTANCE;
            JsonObject b11 = d.f42258a.b(str);
            m1185constructorimpl = Result.m1185constructorimpl(Boolean.valueOf((b11 == null || (jsonElement = b11.get("hiOff")) == null) ? z10 : jsonElement.getAsBoolean()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
            m1185constructorimpl = Boolean.valueOf(z10);
        }
        return ((Boolean) m1185constructorimpl).booleanValue();
    }

    public final boolean c(String sceneId, boolean z10) {
        Object m1185constructorimpl;
        JsonElement jsonElement;
        Intrinsics.h(sceneId, "sceneId");
        try {
            Result.Companion companion = Result.INSTANCE;
            JsonObject b11 = d.f42258a.b(sceneId);
            m1185constructorimpl = Result.m1185constructorimpl(Boolean.valueOf((b11 == null || (jsonElement = b11.get("nonOff")) == null) ? z10 : jsonElement.getAsBoolean()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
            m1185constructorimpl = Boolean.valueOf(z10);
        }
        return ((Boolean) m1185constructorimpl).booleanValue();
    }

    public final boolean e(String str, boolean z10) {
        Object m1185constructorimpl;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.INSTANCE;
            JsonObject b11 = d.f42258a.b(str);
            m1185constructorimpl = Result.m1185constructorimpl(Boolean.valueOf((b11 == null || (jsonElement = b11.get("sceneOff")) == null) ? z10 : jsonElement.getAsBoolean()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
            m1185constructorimpl = Boolean.valueOf(z10);
        }
        return ((Boolean) m1185constructorimpl).booleanValue();
    }

    public final boolean g(String str) {
        if (e.f64594a.a()) {
            return b.f42256a.o() || a.f42255a.w(str);
        }
        return false;
    }
}
