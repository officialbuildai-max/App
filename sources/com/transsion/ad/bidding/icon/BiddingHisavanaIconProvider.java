package com.transsion.ad.bidding.icon;

import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hisavana.mediation.ad.TNativeAd;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import oi.b;

/* loaded from: classes5.dex */
public final class BiddingHisavanaIconProvider implements oi.b {

    /* renamed from: d, reason: collision with root package name */
    public static final a f41986d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy f41987e = LazyKt.b(new Function0() { // from class: com.transsion.ad.bidding.icon.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            HashMap f11;
            f11 = BiddingHisavanaIconProvider.f();
            return f11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private String f41988a;

    /* renamed from: b, reason: collision with root package name */
    private String f41989b;

    /* renamed from: c, reason: collision with root package name */
    private TNativeAd f41990c;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final HashMap a() {
            return (HashMap) BiddingHisavanaIconProvider.f41987e.getValue();
        }

        public final BiddingHisavanaIconProvider b(String str) {
            String h11;
            if (TextUtils.isEmpty(str) || (h11 = com.transsion.ad.scene.a.f42255a.h(str)) == null) {
                return null;
            }
            BiddingHisavanaIconProvider biddingHisavanaIconProvider = (BiddingHisavanaIconProvider) a().get(h11);
            if (biddingHisavanaIconProvider != null) {
                return biddingHisavanaIconProvider;
            }
            BiddingHisavanaIconProvider biddingHisavanaIconProvider2 = new BiddingHisavanaIconProvider();
            biddingHisavanaIconProvider2.i(h11);
            a().put(h11, biddingHisavanaIconProvider2);
            return biddingHisavanaIconProvider2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ce.b e() {
        if (this.f41990c == null) {
            this.f41990c = new TNativeAd(Utils.a(), this.f41988a);
            oi.a.f71145a.n("ad_ic", "============= " + getClassTag() + " --> loadIconAd() --> mPlacementId = " + this.f41988a + " --> create Icon TNativeAd() =================== ", 5, false);
        }
        return this.f41990c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashMap f() {
        return new HashMap();
    }

    private final boolean h(String str) {
        Object m1185constructorimpl;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.INSTANCE;
            JsonObject b11 = com.transsion.ad.scene.d.f42258a.b(str);
            m1185constructorimpl = Result.m1185constructorimpl(Boolean.valueOf((b11 == null || (jsonElement = b11.get("preload")) == null) ? false : jsonElement.getAsBoolean()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
            m1185constructorimpl = Boolean.FALSE;
        }
        return ((Boolean) m1185constructorimpl).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(java.lang.String r9, java.util.Map r10, kotlin.coroutines.Continuation r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.transsion.ad.bidding.icon.BiddingHisavanaIconProvider$preloadAd$1
            if (r0 == 0) goto L13
            r0 = r11
            com.transsion.ad.bidding.icon.BiddingHisavanaIconProvider$preloadAd$1 r0 = (com.transsion.ad.bidding.icon.BiddingHisavanaIconProvider$preloadAd$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.bidding.icon.BiddingHisavanaIconProvider$preloadAd$1 r0 = new com.transsion.ad.bidding.icon.BiddingHisavanaIconProvider$preloadAd$1
            r0.<init>(r8, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3b
            if (r2 != r4) goto L33
            java.lang.Object r9 = r0.L$1
            r10 = r9
            java.util.Map r10 = (java.util.Map) r10
            java.lang.Object r9 = r0.L$0
            java.lang.String r9 = (java.lang.String) r9
            kotlin.ResultKt.b(r11)
            goto L84
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3b:
            kotlin.ResultKt.b(r11)
            boolean r11 = r8.h(r9)
            if (r11 != 0) goto L6a
            java.lang.String r10 = r8.getClassTag()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r10)
            java.lang.String r10 = " --> sceneId = "
            r11.append(r10)
            r11.append(r9)
            java.lang.String r9 = " --> 预请求开关关闭"
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            java.lang.String r10 = "ad_ic"
            r11 = 3
            r8.onLog(r11, r9, r10, r3)
            kotlin.Unit r9 = kotlin.Unit.f67184a
            return r9
        L6a:
            com.transsion.ad.hi.HiSavanaAdManager r11 = com.transsion.ad.hi.HiSavanaAdManager.f42171a
            boolean r11 = r11.i()
            if (r11 != 0) goto L75
            kotlin.Unit r9 = kotlin.Unit.f67184a
            return r9
        L75:
            com.transsion.ad.scene.SceneInterceptManager r11 = com.transsion.ad.scene.SceneInterceptManager.f42254a
            r0.L$0 = r9
            r0.L$1 = r10
            r0.label = r4
            java.lang.Object r11 = r11.a(r9, r0)
            if (r11 != r1) goto L84
            return r1
        L84:
            kotlin.Pair r11 = (kotlin.Pair) r11
            java.lang.Object r11 = r11.getFirst()
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L95
            kotlin.Unit r9 = kotlin.Unit.f67184a
            return r9
        L95:
            com.transsion.ad.scene.c r11 = com.transsion.ad.scene.c.f42257a
            r0 = 2
            r1 = 0
            boolean r11 = com.transsion.ad.scene.c.b(r11, r9, r3, r0, r1)
            if (r11 == 0) goto La2
            kotlin.Unit r9 = kotlin.Unit.f67184a
            return r9
        La2:
            ce.b r11 = r8.e()
            if (r11 == 0) goto Lb1
            boolean r11 = r11.hasAd()
            if (r11 != r4) goto Lb1
            kotlin.Unit r9 = kotlin.Unit.f67184a
            return r9
        Lb1:
            kotlinx.coroutines.i0 r11 = kotlinx.coroutines.y0.b()
            kotlinx.coroutines.n0 r2 = kotlinx.coroutines.o0.a(r11)
            com.transsion.ad.bidding.icon.BiddingHisavanaIconProvider$preloadAd$2 r5 = new com.transsion.ad.bidding.icon.BiddingHisavanaIconProvider$preloadAd$2
            r5.<init>(r9, r8, r10, r1)
            r6 = 3
            r7 = 0
            r3 = 0
            r4 = 0
            kotlinx.coroutines.i.d(r2, r3, r4, r5, r6, r7)
            kotlin.Unit r9 = kotlin.Unit.f67184a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.bidding.icon.BiddingHisavanaIconProvider.g(java.lang.String, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // oi.b
    public String getClassTag() {
        return b.a.a(this);
    }

    @Override // oi.b
    public String getLogTag() {
        return "ad_ic";
    }

    @Override // oi.b
    /* renamed from: getSceneId */
    public String getMSceneId() {
        String str = this.f41989b;
        return str == null ? "" : str;
    }

    public final void i(String str) {
        this.f41988a = str;
    }

    @Override // oi.b
    public void onLog(int i11, String str, String str2, boolean z10) {
        b.a.b(this, i11, str, str2, z10);
    }
}
