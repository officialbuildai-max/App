package com.transsion.wrapperad;

import ak.k;
import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.ad.MBAd;
import com.transsion.ad.strategy.AdOverridePendingTransitionManager;
import com.transsion.baselib.report.l;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberSource;
import com.transsion.web.api.WebConstants;
import com.transsion.web.api.WebPageIdentity;
import com.transsion.wrapperad.h5.H5InterstitialAdProvider;
import com.transsion.wrapperad.h5.H5VideoAdProvider;
import com.transsion.wrapperadapi.H5AdStateEnum;
import com.transsion.wrapperadapi.IWrapperAdApi;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class WrapperAdProvider implements IWrapperAdApi {

    /* renamed from: a, reason: collision with root package name */
    public static final a f58263a = new a(null);

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements hi.a {
        b() {
        }

        @Override // hi.a
        public void a(String str, AdOverridePendingTransitionManager.AdOverridePendingTransitionEnum adOverridePendingTransitionEnum) {
            Pair a11 = AdOverridePendingTransitionManager.f42265a.a(adOverridePendingTransitionEnum);
            Activity o11 = l.f43413a.o();
            Navigator K = TheRouter.c(WebPageIdentity.WEB_VIEW).K("url", str).K(WebConstants.PAGE_FROM, "MB_AD");
            if (o11 == null || o11.isFinishing() || o11.isDestroyed()) {
                k.p(K);
                return;
            }
            if (a11 != null) {
                o11.overridePendingTransition(((Number) a11.getFirst()).intValue(), ((Number) a11.getSecond()).intValue());
            }
            Navigator.x(K, o11, null, 2, null);
        }

        @Override // hi.a
        public void b(String str) {
            Object m1185constructorimpl;
            if (str != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    if (Build.VERSION.SDK_INT < 36) {
                        com.transsion.lib_web.cache.a.f46196a.f(str);
                    }
                    m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
                }
                Result.m1184boximpl(m1185constructorimpl);
            }
        }

        @Override // hi.a
        public void c(String sceneId) {
            IMemberApi iMemberApi;
            Intrinsics.h(sceneId, "sceneId");
            Activity b11 = com.blankj.utilcode.util.a.b();
            if (b11 == null || (iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0])) == null) {
                return;
            }
            iMemberApi.a(b11, MemberSource.SOURCE_AD, null, false, sceneId);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ad A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // com.transsion.wrapperadapi.IWrapperAdApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(kotlin.coroutines.Continuation r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.transsion.wrapperad.WrapperAdProvider$initAd$1
            if (r0 == 0) goto L13
            r0 = r9
            com.transsion.wrapperad.WrapperAdProvider$initAd$1 r0 = (com.transsion.wrapperad.WrapperAdProvider$initAd$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.wrapperad.WrapperAdProvider$initAd$1 r0 = new com.transsion.wrapperad.WrapperAdProvider$initAd$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L41
            if (r2 == r6) goto L3d
            if (r2 == r5) goto L39
            if (r2 != r4) goto L31
            kotlin.ResultKt.b(r9)
            goto Lc0
        L31:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L39:
            kotlin.ResultKt.b(r9)
            goto Lae
        L3d:
            kotlin.ResultKt.b(r9)
            goto L56
        L41:
            kotlin.ResultKt.b(r9)
            kotlinx.coroutines.a2 r9 = kotlinx.coroutines.y0.c()
            com.transsion.wrapperad.WrapperAdProvider$initAd$2 r2 = new com.transsion.wrapperad.WrapperAdProvider$initAd$2
            r2.<init>(r3)
            r0.label = r6
            java.lang.Object r9 = kotlinx.coroutines.i.g(r9, r2, r0)
            if (r9 != r1) goto L56
            return r1
        L56:
            com.transsion.ad.MBAd r9 = com.transsion.ad.MBAd.f41805a
            com.transsion.ad.MBAd$b r2 = new com.transsion.ad.MBAd$b
            r2.<init>()
            java.lang.String r7 = "2301069UF9YjuO"
            com.transsion.ad.MBAd$b r2 = r2.g(r7)
            r7 = 0
            com.transsion.ad.MBAd$b r2 = r2.d(r7)
            com.transsion.ad.MBAd$b r2 = r2.i(r7)
            com.transsion.ad.strategy.AppManager$AppEnum r7 = com.transsion.ad.strategy.AppManager.AppEnum.APP_MOVIE_BOX
            com.transsion.ad.MBAd$b r2 = r2.e(r7)
            java.lang.String r7 = "HotStartScene"
            com.transsion.ad.MBAd$b r2 = r2.h(r7)
            java.lang.String r7 = "/wefeed-mobile-bff/ad/config"
            com.transsion.ad.MBAd$b r2 = r2.c(r7)
            com.tn.lib.net.dns.or.CacheIpPool r7 = com.tn.lib.net.dns.or.CacheIpPool.f40879a
            java.lang.String r7 = r7.l()
            com.transsion.ad.MBAd$b r2 = r2.b(r7)
            com.transsion.ad.MBAd$b r2 = r2.j(r6)
            com.transsion.ad.MBAd$b r2 = r2.k(r6)
            com.transsion.ad.MBAd$b r2 = r2.l(r6)
            com.transsion.ad.MBAd$b r2 = r2.m(r6)
            com.transsion.wrapperad.WrapperAdProvider$b r6 = new com.transsion.wrapperad.WrapperAdProvider$b
            r6.<init>()
            com.transsion.ad.MBAd$b r2 = r2.f(r6)
            com.transsion.ad.MBAd$a r2 = r2.a()
            r0.label = r5
            java.lang.Object r9 = r9.e(r2, r0)
            if (r9 != r1) goto Lae
            return r1
        Lae:
            kotlinx.coroutines.a2 r9 = kotlinx.coroutines.y0.c()
            com.transsion.wrapperad.WrapperAdProvider$initAd$4 r2 = new com.transsion.wrapperad.WrapperAdProvider$initAd$4
            r2.<init>(r3)
            r0.label = r4
            java.lang.Object r9 = kotlinx.coroutines.i.g(r9, r2, r0)
            if (r9 != r1) goto Lc0
            return r1
        Lc0:
            kotlin.Unit r9 = kotlin.Unit.f67184a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.wrapperad.WrapperAdProvider.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.transsion.wrapperadapi.IWrapperAdApi
    public void b(String str, jy.a callback) {
        Object m1185constructorimpl;
        JSONObject jSONObject;
        String optString;
        Intrinsics.h(callback, "callback");
        if (TextUtils.isEmpty(str)) {
            callback.onAdStateCallback(H5AdStateEnum.MB_H5_AD_STATE_ON_FAIL.getValue(), "adConfig is empty");
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            if (str == null) {
                str = "{}";
            }
            jSONObject = new JSONObject(str);
            optString = jSONObject.optString("sceneId");
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (TextUtils.isEmpty(optString)) {
            callback.onAdStateCallback(H5AdStateEnum.MB_H5_AD_STATE_ON_FAIL.getValue(), "sceneId is empty");
            return;
        }
        int optInt = jSONObject.optInt("adType");
        if (optInt == 3) {
            H5VideoAdProvider.f58292a.h(optString, callback);
        } else if (optInt == 4) {
            H5InterstitialAdProvider.f58288a.f(optString, callback);
        }
        m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl == null) {
            return;
        }
        callback.onAdStateCallback(H5AdStateEnum.MB_H5_AD_STATE_ON_FAIL.getValue(), m1188exceptionOrNullimpl.getMessage());
    }

    @Override // com.transsion.wrapperadapi.IWrapperAdApi
    public Object c(Continuation continuation) {
        Object f11 = MBAd.f41805a.f("/wefeed-mobile-bff/ad/config", continuation);
        return f11 == IntrinsicsKt.f() ? f11 : Unit.f67184a;
    }
}
