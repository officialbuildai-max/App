package com.transsion.transfer.wifi.util;

import android.net.Uri;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f56089a = new e();

    private e() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map a(String urlString) {
        LinkedHashMap linkedHashMap;
        Intrinsics.h(urlString, "urlString");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        try {
            Result.Companion companion = Result.INSTANCE;
            Uri parse = Uri.parse(urlString);
            Intrinsics.g(parse, "parse(...)");
            linkedHashMap2.put("urlPath", parse.getPath());
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            Intrinsics.g(queryParameterNames, "getQueryParameterNames(...)");
            for (String str : queryParameterNames) {
                linkedHashMap2.put(str, parse.getQueryParameter(str));
            }
            linkedHashMap = Result.m1185constructorimpl(linkedHashMap2);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            linkedHashMap = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1188exceptionOrNullimpl(linkedHashMap) == null) {
            linkedHashMap2 = linkedHashMap;
        }
        return linkedHashMap2;
    }
}
