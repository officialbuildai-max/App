package com.transsion.base.report.athena.sampler;

import android.text.TextUtils;
import com.blankj.utilcode.util.o;
import com.google.gson.reflect.TypeToken;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes5.dex */
public final class EventConfig {

    /* renamed from: a, reason: collision with root package name */
    public static final EventConfig f43057a = new EventConfig();

    /* renamed from: b, reason: collision with root package name */
    private static final String f43058b = "[\n    {\n        \"eventExpr\":\"(event =='ad_trigger')\",\n        \"batchKey\":\"客户端采样因子A\",\n        \"samplingRate\":0\n    },\n    {\n       \"eventExpr\":\"(event =='ad_display')\",\n        \"batchKey\":\"客户端采样因子b\",\n        \"samplingRate\":10\n    },\n    {\n       \"eventExpr\":\"(event =='ad_click')\",\n        \"batchKey\":\"客户端采样因子b\",\n        \"samplingRate\":90\n    }\n]";

    /* renamed from: c, reason: collision with root package name */
    private static volatile List f43059c;

    /* renamed from: d, reason: collision with root package name */
    private static final Set f43060d;

    /* renamed from: e, reason: collision with root package name */
    private static final Set f43061e;

    static {
        Set newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        Intrinsics.g(newSetFromMap, "newSetFromMap(...)");
        f43060d = newSetFromMap;
        Set newSetFromMap2 = Collections.newSetFromMap(new ConcurrentHashMap());
        Intrinsics.g(newSetFromMap2, "newSetFromMap(...)");
        f43061e = newSetFromMap2;
    }

    private EventConfig() {
    }

    private final void f(String str) {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            f43059c = (List) o.f().fromJson(str, new TypeToken<List<? extends EventStrategyBean>>() { // from class: com.transsion.base.report.athena.sampler.EventConfig$initEventStrategy$1$listType$1
            }.getType());
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            a.C0856a.l(lg.a.f68962a, "sampler", "EventConfig --> initEventStrategy() --> error = " + m1188exceptionOrNullimpl, false, 4, null);
            f43059c = null;
        }
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException: Cannot read field "wordsInUse" because "set" is null
        	at java.base/java.util.BitSet.or(BitSet.java:943)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:759)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:838)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:711)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    private final boolean g(java.lang.String r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L20
            boolean r1 = kotlin.text.StringsKt.q0(r3)
            if (r1 == 0) goto La
            goto L20
        La:
            com.google.gson.JsonElement r3 = com.google.gson.JsonParser.parseString(r3)     // Catch: java.lang.Exception -> L20
            java.lang.String r1 = "parseString(...)"
            kotlin.jvm.internal.Intrinsics.g(r3, r1)     // Catch: java.lang.Exception -> L20
            boolean r1 = r3.isJsonObject()     // Catch: java.lang.Exception -> L20
            if (r1 != 0) goto L1f
            boolean r3 = r3.isJsonArray()     // Catch: java.lang.Exception -> L20
            if (r3 == 0) goto L20
        L1f:
            r0 = 1
        L20:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.base.report.athena.sampler.EventConfig.g(java.lang.String):boolean");
    }

    public final void a(String event) {
        Intrinsics.h(event, "event");
        f43061e.add(event);
    }

    public final void b(String event) {
        Intrinsics.h(event, "event");
        f43060d.add(event);
    }

    public final Set c() {
        return CollectionsKt.W0(f43061e);
    }

    public final Set d() {
        return CollectionsKt.W0(f43060d);
    }

    public final List e() {
        return f43059c;
    }

    public final void h(String event) {
        Intrinsics.h(event, "event");
        f43061e.remove(event);
    }

    public final void i(String event) {
        Intrinsics.h(event, "event");
        f43060d.remove(event);
    }

    public final void j(String str) {
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "sampler", "EventConfig --> saveEventStrategy() --> eventStrategy = " + str, false, 4, null);
        if (TextUtils.isEmpty(str)) {
            a.C0856a.l(c0856a, "sampler", "EventConfig --> saveEventStrategy() --> eventStrategy is empty!", false, 4, null);
        } else if (g(str)) {
            f(str);
        } else {
            a.C0856a.l(c0856a, "sampler", "EventConfig --> saveEventStrategy() --> eventStrategy is not json!", false, 4, null);
        }
    }
}
