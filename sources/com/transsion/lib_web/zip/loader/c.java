package com.transsion.lib_web.zip.loader;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public interface c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f46256a = a.f46257a;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f46257a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final HashMap f46258b = MapsKt.j(new Pair(OSSHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*"), new Pair("Access-Control-Allow-Credentials", "*"));

        /* renamed from: c, reason: collision with root package name */
        private static final String f46259c = "versionCode";

        private a() {
        }

        public final HashMap a() {
            return f46258b;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        public static Map a(c cVar, Map headers) {
            Intrinsics.h(headers, "headers");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(headers);
            linkedHashMap.putAll(c.f46256a.a());
            return linkedHashMap;
        }
    }

    WebResourceResponse a(WebResourceRequest webResourceRequest);
}
