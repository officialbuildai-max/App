package com.transsion.ad.monopoly.intercept;

import android.text.TextUtils;
import com.transsion.ad.db.plan.MbAdDbPlans;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* loaded from: classes5.dex */
public abstract class BaseAdSceneCtxExprHandler extends com.transsion.ad.monopoly.intercept.a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f42185b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Regex f42186c = new Regex("\\b([a-zA-Z_][a-zA-Z0-9_]*)\\b");

    /* renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap f42187d = new ConcurrentHashMap();

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object i(com.transsion.ad.monopoly.intercept.BaseAdSceneCtxExprHandler r26, java.lang.String r27, com.transsion.ad.db.plan.MbAdDbPlans r28, java.util.Map r29, kotlin.coroutines.Continuation r30) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.intercept.BaseAdSceneCtxExprHandler.i(com.transsion.ad.monopoly.intercept.BaseAdSceneCtxExprHandler, java.lang.String, com.transsion.ad.db.plan.MbAdDbPlans, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean n(String str, Map map) {
        Object m1185constructorimpl;
        Object computeIfAbsent;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            ConcurrentHashMap concurrentHashMap = f42187d;
            final Function1 function1 = new Function1() { // from class: com.transsion.ad.monopoly.intercept.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Serializable o11;
                    o11 = BaseAdSceneCtxExprHandler.o((String) obj);
                    return o11;
                }
            };
            computeIfAbsent = concurrentHashMap.computeIfAbsent(str, new Function() { // from class: com.transsion.ad.monopoly.intercept.i
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Serializable p11;
                    p11 = BaseAdSceneCtxExprHandler.p(Function1.this, obj);
                    return p11;
                }
            });
            Intrinsics.g(computeIfAbsent, "computeIfAbsent(...)");
            Serializable serializable = (Serializable) computeIfAbsent;
            HashMap hashMap = new HashMap(map);
            Iterator f67553a = Regex.findAll$default(f42186c, str, 0, 2, null).getF67553a();
            while (f67553a.hasNext()) {
                String str2 = (String) ((MatchResult) f67553a.next()).a().get(1);
                if (!hashMap.containsKey(str2)) {
                    hashMap.put(str2, null);
                }
            }
            Object v11 = org.mvel2.d.v(serializable, hashMap);
            Intrinsics.f(v11, "null cannot be cast to non-null type kotlin.Boolean");
            Boolean bool = (Boolean) v11;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Serializable o(String it) {
        Intrinsics.h(it, "it");
        return org.mvel2.d.d(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Serializable p(Function1 function1, Object obj) {
        return (Serializable) function1.invoke(obj);
    }

    @Override // com.transsion.ad.monopoly.intercept.a
    public Object b(String str, MbAdDbPlans mbAdDbPlans, Map map, Continuation continuation) {
        return i(this, str, mbAdDbPlans, map, continuation);
    }

    public abstract String j(String str, MbAdDbPlans mbAdDbPlans, Map map);

    public abstract String k();

    public abstract String l();

    public abstract boolean m(boolean z10);
}
