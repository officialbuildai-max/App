package com.transsion.base.report.athena.sampler;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import lg.a;
import org.json.JSONObject;
import org.mvel2.d;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f43062a = new a();

    private a() {
    }

    private final boolean b(String str, Map map) {
        Object m1185constructorimpl;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Map w11 = MapsKt.w(map);
            Iterator f67553a = Regex.findAll$default(new Regex("\\b([a-zA-Z_][a-zA-Z0-9_]*)\\b"), str, 0, 2, null).getF67553a();
            while (f67553a.hasNext()) {
                String str2 = (String) ((MatchResult) f67553a.next()).a().get(1);
                if (!w11.containsKey(str2)) {
                    w11.put(str2, null);
                }
            }
            Object p11 = d.p(str, w11);
            Intrinsics.f(p11, "null cannot be cast to non-null type kotlin.Boolean");
            Boolean bool = (Boolean) p11;
            bool.booleanValue();
            m1185constructorimpl = Result.m1185constructorimpl(bool);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            lg.a.f68962a.i("sampler", "Eval --> safeEval() --> it = " + m1188exceptionOrNullimpl + " --> rule = " + str + " --> safeVars = " + map, true);
            m1185constructorimpl = Boolean.FALSE;
        }
        return ((Boolean) m1185constructorimpl).booleanValue();
    }

    public final Triple a(String event, Bundle bundle) {
        Object m1185constructorimpl;
        Triple triple;
        Intrinsics.h(event, "event");
        Intrinsics.h(bundle, "bundle");
        try {
            Result.Companion companion = Result.INSTANCE;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String string = bundle.getString("ext");
            if (string == null) {
                string = "{}";
            }
            JSONObject jSONObject = new JSONObject(string);
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.g(keys, "keys(...)");
            while (keys.hasNext()) {
                String next = keys.next();
                linkedHashMap.put(next, jSONObject.optString(next));
            }
            String string2 = bundle.getString("page_name");
            if (string2 == null) {
                string2 = "";
            }
            linkedHashMap.put("page_name", string2);
            linkedHashMap.put(NotificationCompat.CATEGORY_EVENT, event);
            List<EventStrategyBean> e11 = EventConfig.f43057a.e();
            if (e11 != null) {
                for (EventStrategyBean eventStrategyBean : e11) {
                    if (!TextUtils.isEmpty(eventStrategyBean.getEventExpr())) {
                        String eventExpr = eventStrategyBean.getEventExpr();
                        if (eventExpr == null) {
                            eventExpr = "";
                        }
                        if (b(eventExpr, linkedHashMap)) {
                            triple = new Triple(Boolean.TRUE, eventStrategyBean.getSamplingRate(), eventStrategyBean.getBatchKey());
                            break;
                        }
                        a.C0856a.f(lg.a.f68962a, "sampler", "Eval --> eval() --> 没有命中 继续下一个表达式判断 --> eventExpr = " + eventStrategyBean.getEventExpr() + " --> contextVars = " + linkedHashMap, false, 4, null);
                    }
                }
            }
            triple = new Triple(Boolean.FALSE, 100, "没有命中，返回默认值");
            m1185constructorimpl = Result.m1185constructorimpl(triple);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
            m1185constructorimpl = new Triple(Boolean.FALSE, 100, "没有命中，返回默认值");
        }
        return (Triple) m1185constructorimpl;
    }
}
