package com.transsion.ad.monopoly.intercept;

import android.os.SystemClock;
import com.transsion.ad.monopoly.intercept.AdResourceDownloadedHandler;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class AdResourceDownloadedHandler extends com.transsion.ad.monopoly.intercept.a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f42182b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap f42183c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    private static volatile long f42184d;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d(String str) {
            Object computeIfAbsent;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - AdResourceDownloadedHandler.f42184d > 5000) {
                AdResourceDownloadedHandler.f42183c.clear();
                AdResourceDownloadedHandler.f42184d = elapsedRealtime;
            }
            ConcurrentHashMap concurrentHashMap = AdResourceDownloadedHandler.f42183c;
            final Function1 function1 = new Function1() { // from class: com.transsion.ad.monopoly.intercept.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Boolean e11;
                    e11 = AdResourceDownloadedHandler.a.e((String) obj);
                    return e11;
                }
            };
            computeIfAbsent = concurrentHashMap.computeIfAbsent(str, new Function() { // from class: com.transsion.ad.monopoly.intercept.e
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Boolean f11;
                    f11 = AdResourceDownloadedHandler.a.f(Function1.this, obj);
                    return f11;
                }
            });
            Intrinsics.g(computeIfAbsent, "computeIfAbsent(...)");
            return ((Boolean) computeIfAbsent).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Boolean e(String it) {
            Intrinsics.h(it, "it");
            return Boolean.valueOf(ti.h.f76382a.h(it));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Boolean f(Function1 function1, Object obj) {
            return (Boolean) function1.invoke(obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    @Override // com.transsion.ad.monopoly.intercept.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(java.lang.String r19, com.transsion.ad.db.plan.MbAdDbPlans r20, java.util.Map r21, kotlin.coroutines.Continuation r22) {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.intercept.AdResourceDownloadedHandler.b(java.lang.String, com.transsion.ad.db.plan.MbAdDbPlans, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
