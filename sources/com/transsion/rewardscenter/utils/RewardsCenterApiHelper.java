package com.transsion.rewardscenter.utils;

import com.cloud.tmc.integration.net.UrlKt;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.transsion.rewardscenterapi.ClaimReceiverRequest;
import com.transsion.rewardscenterapi.PhoneInfo;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class RewardsCenterApiHelper {

    /* renamed from: a */
    public static final RewardsCenterApiHelper f51346a = new RewardsCenterApiHelper();

    /* renamed from: b */
    private static final Lazy f51347b = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.utils.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            up.a h11;
            h11 = RewardsCenterApiHelper.h();
            return h11;
        }
    });

    /* renamed from: c */
    public static final int f51348c = 8;

    private RewardsCenterApiHelper() {
    }

    public static final up.a h() {
        return (up.a) zg.c.f79537e.a().h(up.a.class);
    }

    private final RequestBody i(Function1 function1) {
        RequestBody.Companion companion = RequestBody.INSTANCE;
        JSONObject jSONObject = new JSONObject();
        function1.invoke(jSONObject);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.g(jSONObject2, "toString(...)");
        return companion.create(jSONObject2, MediaType.INSTANCE.parse("application/json"));
    }

    public static final Unit k(JSONObject buildBody) {
        Intrinsics.h(buildBody, "$this$buildBody");
        buildBody.put(UrlKt.KEY_MINI_GAID, ih.b.f65364a.i());
        return Unit.f67184a;
    }

    public static final Unit m(String str, JSONObject buildBody) {
        Intrinsics.h(buildBody, "$this$buildBody");
        buildBody.put("drawResultId", str);
        return Unit.f67184a;
    }

    public static /* synthetic */ Object o(RewardsCenterApiHelper rewardsCenterApiHelper, Function2 function2, Function1 function1, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function2 = null;
        }
        return rewardsCenterApiHelper.n(function2, function1, continuation);
    }

    private final up.a p() {
        return (up.a) f51347b.getValue();
    }

    public static final Unit r(String str, JSONObject buildBody) {
        Intrinsics.h(buildBody, "$this$buildBody");
        buildBody.put("activityId", str);
        buildBody.put("num", 1);
        return Unit.f67184a;
    }

    public static final Unit t(String str, JSONObject buildBody) {
        Intrinsics.h(buildBody, "$this$buildBody");
        buildBody.put("skuId", str);
        buildBody.put("clientOrderId", UUID.randomUUID().toString());
        return Unit.f67184a;
    }

    public static final Unit v(String str, JSONObject buildBody) {
        Intrinsics.h(buildBody, "$this$buildBody");
        if (str == null) {
            str = "";
        }
        buildBody.put("taskId", str);
        buildBody.put(UrlKt.KEY_MINI_GAID, ih.b.f65364a.i());
        return Unit.f67184a;
    }

    public static final Unit x(ClaimReceiverRequest claimReceiverRequest, JSONObject buildBody) {
        Intrinsics.h(buildBody, "$this$buildBody");
        Object drawResultId = claimReceiverRequest.getDrawResultId();
        if (drawResultId == null) {
            drawResultId = "";
        }
        buildBody.put("drawResultId", drawResultId);
        Object receiverName = claimReceiverRequest.getReceiverName();
        if (receiverName == null) {
            receiverName = "";
        }
        buildBody.put("receiverName", receiverName);
        JSONArray jSONArray = new JSONArray();
        List<PhoneInfo> phone = claimReceiverRequest.getPhone();
        if (phone != null) {
            for (PhoneInfo phoneInfo : phone) {
                JSONObject jSONObject = new JSONObject();
                String countryNo = phoneInfo.getCountryNo();
                if (countryNo == null) {
                    countryNo = "";
                }
                jSONObject.put("countryNo", countryNo);
                String number = phoneInfo.getNumber();
                if (number == null) {
                    number = "";
                }
                jSONObject.put("number", number);
                String countryCode = phoneInfo.getCountryCode();
                if (countryCode == null) {
                    countryCode = "";
                }
                jSONObject.put("countryCode", countryCode);
                jSONArray.put(jSONObject);
            }
        }
        Unit unit = Unit.f67184a;
        buildBody.put("phone", jSONArray);
        Object address = claimReceiverRequest.getAddress();
        buildBody.put(PlaceTypes.ADDRESS, address != null ? address : "");
        String email = claimReceiverRequest.getEmail();
        if (email != null && !StringsKt.q0(email)) {
            buildBody.put("email", claimReceiverRequest.getEmail());
        }
        String postCode = claimReceiverRequest.getPostCode();
        if (postCode != null && !StringsKt.q0(postCode)) {
            buildBody.put("postCode", claimReceiverRequest.getPostCode());
        }
        return Unit.f67184a;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(2:3|(12:5|6|7|8|(1:(2:11|12)(2:29|30))(3:31|32|(1:34))|13|14|(2:16|(1:18)(1:(1:20)))|21|(1:24)|25|26))|37|6|7|8|(0)(0)|13|14|(0)|21|(1:24)|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0034, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0067, code lost:
    
        r0 = kotlin.Result.INSTANCE;
        r10 = kotlin.Result.m1185constructorimpl(kotlin.ResultKt.a(r10));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(kotlin.jvm.functions.Function2 r8, kotlin.jvm.functions.Function1 r9, kotlin.coroutines.Continuation r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.transsion.rewardscenter.utils.RewardsCenterApiHelper$checkDadaSetDefault$1
            if (r0 == 0) goto L14
            r0 = r10
            com.transsion.rewardscenter.utils.RewardsCenterApiHelper$checkDadaSetDefault$1 r0 = (com.transsion.rewardscenter.utils.RewardsCenterApiHelper$checkDadaSetDefault$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.transsion.rewardscenter.utils.RewardsCenterApiHelper$checkDadaSetDefault$1 r0 = new com.transsion.rewardscenter.utils.RewardsCenterApiHelper$checkDadaSetDefault$1
            r0.<init>(r7, r10)
            goto L12
        L1a:
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L3e
            if (r1 != r2) goto L36
            java.lang.Object r8 = r4.L$1
            r9 = r8
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            java.lang.Object r8 = r4.L$0
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L34
            goto L60
        L34:
            r10 = move-exception
            goto L67
        L36:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3e:
            kotlin.ResultKt.b(r10)
            com.transsion.rewardscenter.utils.i r10 = new com.transsion.rewardscenter.utils.i
            r10.<init>()
            okhttp3.RequestBody r3 = r7.i(r10)
            kotlin.Result$Companion r10 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L34
            up.a r1 = r7.p()     // Catch: java.lang.Throwable -> L34
            r4.L$0 = r8     // Catch: java.lang.Throwable -> L34
            r4.L$1 = r9     // Catch: java.lang.Throwable -> L34
            r4.label = r2     // Catch: java.lang.Throwable -> L34
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r10 = up.a.C0966a.a(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L34
            if (r10 != r0) goto L60
            return r0
        L60:
            com.tn.lib.net.bean.BaseDto r10 = (com.tn.lib.net.bean.BaseDto) r10     // Catch: java.lang.Throwable -> L34
            java.lang.Object r10 = kotlin.Result.m1185constructorimpl(r10)     // Catch: java.lang.Throwable -> L34
            goto L71
        L67:
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r10 = kotlin.ResultKt.a(r10)
            java.lang.Object r10 = kotlin.Result.m1185constructorimpl(r10)
        L71:
            boolean r0 = kotlin.Result.m1192isSuccessimpl(r10)
            if (r0 == 0) goto L95
            r0 = r10
            com.tn.lib.net.bean.BaseDto r0 = (com.tn.lib.net.bean.BaseDto) r0
            boolean r1 = com.transsion.rewardscenter.utils.n.a(r0)
            if (r1 == 0) goto L88
            java.lang.Object r0 = r0.getData()
            r9.invoke(r0)
            goto L95
        L88:
            if (r8 == 0) goto L95
            java.lang.String r9 = r0.getCode()
            java.lang.String r0 = r0.getMsg()
            r8.invoke(r9, r0)
        L95:
            java.lang.Throwable r9 = kotlin.Result.m1188exceptionOrNullimpl(r10)
            if (r9 == 0) goto La5
            if (r8 == 0) goto La5
            r10 = 0
            java.lang.String r9 = r9.getMessage()
            r8.invoke(r10, r9)
        La5:
            kotlin.Unit r8 = kotlin.Unit.f67184a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.rewardscenter.utils.RewardsCenterApiHelper.j(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(2:3|(12:5|6|7|8|(1:(2:11|12)(2:29|30))(3:31|32|(1:34))|13|14|(2:16|(1:18)(1:(1:20)))|21|(1:24)|25|26))|37|6|7|8|(0)(0)|13|14|(0)|21|(1:24)|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0035, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0068, code lost:
    
        r11 = kotlin.Result.INSTANCE;
        r8 = kotlin.Result.m1185constructorimpl(kotlin.ResultKt.a(r8));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(final java.lang.String r8, kotlin.jvm.functions.Function2 r9, kotlin.jvm.functions.Function1 r10, kotlin.coroutines.Continuation r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.transsion.rewardscenter.utils.RewardsCenterApiHelper$claimReward$1
            if (r0 == 0) goto L14
            r0 = r11
            com.transsion.rewardscenter.utils.RewardsCenterApiHelper$claimReward$1 r0 = (com.transsion.rewardscenter.utils.RewardsCenterApiHelper$claimReward$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.transsion.rewardscenter.utils.RewardsCenterApiHelper$claimReward$1 r0 = new com.transsion.rewardscenter.utils.RewardsCenterApiHelper$claimReward$1
            r0.<init>(r7, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L3f
            if (r1 != r2) goto L37
            java.lang.Object r8 = r4.L$1
            r10 = r8
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r8 = r4.L$0
            r9 = r8
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            kotlin.ResultKt.b(r11)     // Catch: java.lang.Throwable -> L35
            goto L61
        L35:
            r8 = move-exception
            goto L68
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3f:
            kotlin.ResultKt.b(r11)
            com.transsion.rewardscenter.utils.k r11 = new com.transsion.rewardscenter.utils.k
            r11.<init>()
            okhttp3.RequestBody r3 = r7.i(r11)
            kotlin.Result$Companion r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L35
            up.a r1 = r7.p()     // Catch: java.lang.Throwable -> L35
            r4.L$0 = r9     // Catch: java.lang.Throwable -> L35
            r4.L$1 = r10     // Catch: java.lang.Throwable -> L35
            r4.label = r2     // Catch: java.lang.Throwable -> L35
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r11 = up.a.C0966a.b(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L35
            if (r11 != r0) goto L61
            return r0
        L61:
            com.tn.lib.net.bean.BaseDto r11 = (com.tn.lib.net.bean.BaseDto) r11     // Catch: java.lang.Throwable -> L35
            java.lang.Object r8 = kotlin.Result.m1185constructorimpl(r11)     // Catch: java.lang.Throwable -> L35
            goto L72
        L68:
            kotlin.Result$Companion r11 = kotlin.Result.INSTANCE
            java.lang.Object r8 = kotlin.ResultKt.a(r8)
            java.lang.Object r8 = kotlin.Result.m1185constructorimpl(r8)
        L72:
            boolean r11 = kotlin.Result.m1192isSuccessimpl(r8)
            if (r11 == 0) goto L96
            r11 = r8
            com.tn.lib.net.bean.BaseDto r11 = (com.tn.lib.net.bean.BaseDto) r11
            boolean r0 = com.transsion.rewardscenter.utils.n.a(r11)
            if (r0 == 0) goto L89
            java.lang.Object r11 = r11.getData()
            r10.invoke(r11)
            goto L96
        L89:
            if (r9 == 0) goto L96
            java.lang.String r10 = r11.getCode()
            java.lang.String r11 = r11.getMsg()
            r9.invoke(r10, r11)
        L96:
            java.lang.Throwable r8 = kotlin.Result.m1188exceptionOrNullimpl(r8)
            if (r8 == 0) goto La6
            if (r9 == 0) goto La6
            r10 = 0
            java.lang.String r8 = r8.getMessage()
            r9.invoke(r10, r8)
        La6:
            kotlin.Unit r8 = kotlin.Unit.f67184a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.rewardscenter.utils.RewardsCenterApiHelper.l(java.lang.String, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(11:5|6|7|(1:(2:10|11)(2:28|29))(3:30|31|(1:33))|12|13|(2:15|(1:17)(1:(1:19)))|20|(1:23)|24|25))|36|6|7|(0)(0)|12|13|(0)|20|(1:23)|24|25) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0033, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005a, code lost:
    
        r0 = kotlin.Result.INSTANCE;
        r8 = kotlin.Result.m1185constructorimpl(kotlin.ResultKt.a(r8));
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(kotlin.jvm.functions.Function2 r6, kotlin.jvm.functions.Function1 r7, kotlin.coroutines.Continuation r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.transsion.rewardscenter.utils.RewardsCenterApiHelper$fetchAdTaskInfo$1
            if (r0 == 0) goto L13
            r0 = r8
            com.transsion.rewardscenter.utils.RewardsCenterApiHelper$fetchAdTaskInfo$1 r0 = (com.transsion.rewardscenter.utils.RewardsCenterApiHelper$fetchAdTaskInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.rewardscenter.utils.RewardsCenterApiHelper$fetchAdTaskInfo$1 r0 = new com.transsion.rewardscenter.utils.RewardsCenterApiHelper$fetchAdTaskInfo$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 != r4) goto L35
            java.lang.Object r6 = r0.L$1
            r7 = r6
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r6 = r0.L$0
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L33
            goto L53
        L33:
            r8 = move-exception
            goto L5a
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            kotlin.ResultKt.b(r8)
            kotlin.Result$Companion r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L33
            up.a r8 = r5.p()     // Catch: java.lang.Throwable -> L33
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L33
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L33
            r0.label = r4     // Catch: java.lang.Throwable -> L33
            java.lang.Object r8 = up.a.C0966a.c(r8, r3, r0, r4, r3)     // Catch: java.lang.Throwable -> L33
            if (r8 != r1) goto L53
            return r1
        L53:
            com.tn.lib.net.bean.BaseDto r8 = (com.tn.lib.net.bean.BaseDto) r8     // Catch: java.lang.Throwable -> L33
            java.lang.Object r8 = kotlin.Result.m1185constructorimpl(r8)     // Catch: java.lang.Throwable -> L33
            goto L64
        L5a:
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r8 = kotlin.ResultKt.a(r8)
            java.lang.Object r8 = kotlin.Result.m1185constructorimpl(r8)
        L64:
            boolean r0 = kotlin.Result.m1192isSuccessimpl(r8)
            if (r0 == 0) goto L88
            r0 = r8
            com.tn.lib.net.bean.BaseDto r0 = (com.tn.lib.net.bean.BaseDto) r0
            boolean r1 = com.transsion.rewardscenter.utils.n.a(r0)
            if (r1 == 0) goto L7b
            java.lang.Object r0 = r0.getData()
            r7.invoke(r0)
            goto L88
        L7b:
            if (r6 == 0) goto L88
            java.lang.String r7 = r0.getCode()
            java.lang.String r0 = r0.getMsg()
            r6.invoke(r7, r0)
        L88:
            java.lang.Throwable r7 = kotlin.Result.m1188exceptionOrNullimpl(r8)
            if (r7 == 0) goto L97
            if (r6 == 0) goto L97
            java.lang.String r7 = r7.getMessage()
            r6.invoke(r3, r7)
        L97:
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.rewardscenter.utils.RewardsCenterApiHelper.n(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(2:3|(12:5|6|7|8|(1:(2:11|12)(2:29|30))(3:31|32|(1:34))|13|14|(2:16|(1:18)(1:(1:20)))|21|(1:24)|25|26))|37|6|7|8|(0)(0)|13|14|(0)|21|(1:24)|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0035, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0068, code lost:
    
        r11 = kotlin.Result.INSTANCE;
        r8 = kotlin.Result.m1185constructorimpl(kotlin.ResultKt.a(r8));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(final java.lang.String r8, kotlin.jvm.functions.Function2 r9, kotlin.jvm.functions.Function1 r10, kotlin.coroutines.Continuation r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.transsion.rewardscenter.utils.RewardsCenterApiHelper$redeemLottery$1
            if (r0 == 0) goto L14
            r0 = r11
            com.transsion.rewardscenter.utils.RewardsCenterApiHelper$redeemLottery$1 r0 = (com.transsion.rewardscenter.utils.RewardsCenterApiHelper$redeemLottery$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.transsion.rewardscenter.utils.RewardsCenterApiHelper$redeemLottery$1 r0 = new com.transsion.rewardscenter.utils.RewardsCenterApiHelper$redeemLottery$1
            r0.<init>(r7, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L3f
            if (r1 != r2) goto L37
            java.lang.Object r8 = r4.L$1
            r10 = r8
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r8 = r4.L$0
            r9 = r8
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            kotlin.ResultKt.b(r11)     // Catch: java.lang.Throwable -> L35
            goto L61
        L35:
            r8 = move-exception
            goto L68
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3f:
            kotlin.ResultKt.b(r11)
            com.transsion.rewardscenter.utils.m r11 = new com.transsion.rewardscenter.utils.m
            r11.<init>()
            okhttp3.RequestBody r3 = r7.i(r11)
            kotlin.Result$Companion r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L35
            up.a r1 = r7.p()     // Catch: java.lang.Throwable -> L35
            r4.L$0 = r9     // Catch: java.lang.Throwable -> L35
            r4.L$1 = r10     // Catch: java.lang.Throwable -> L35
            r4.label = r2     // Catch: java.lang.Throwable -> L35
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r11 = up.a.C0966a.g(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L35
            if (r11 != r0) goto L61
            return r0
        L61:
            com.tn.lib.net.bean.BaseDto r11 = (com.tn.lib.net.bean.BaseDto) r11     // Catch: java.lang.Throwable -> L35
            java.lang.Object r8 = kotlin.Result.m1185constructorimpl(r11)     // Catch: java.lang.Throwable -> L35
            goto L72
        L68:
            kotlin.Result$Companion r11 = kotlin.Result.INSTANCE
            java.lang.Object r8 = kotlin.ResultKt.a(r8)
            java.lang.Object r8 = kotlin.Result.m1185constructorimpl(r8)
        L72:
            boolean r11 = kotlin.Result.m1192isSuccessimpl(r8)
            if (r11 == 0) goto L96
            r11 = r8
            com.tn.lib.net.bean.BaseDto r11 = (com.tn.lib.net.bean.BaseDto) r11
            boolean r0 = com.transsion.rewardscenter.utils.n.a(r11)
            if (r0 == 0) goto L89
            java.lang.Object r11 = r11.getData()
            r10.invoke(r11)
            goto L96
        L89:
            if (r9 == 0) goto L96
            java.lang.String r10 = r11.getCode()
            java.lang.String r11 = r11.getMsg()
            r9.invoke(r10, r11)
        L96:
            java.lang.Throwable r8 = kotlin.Result.m1188exceptionOrNullimpl(r8)
            if (r8 == 0) goto La6
            if (r9 == 0) goto La6
            r10 = 0
            java.lang.String r8 = r8.getMessage()
            r9.invoke(r10, r8)
        La6:
            kotlin.Unit r8 = kotlin.Unit.f67184a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.rewardscenter.utils.RewardsCenterApiHelper.q(java.lang.String, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(2:3|(12:5|6|7|8|(1:(2:11|12)(2:29|30))(3:31|32|(1:34))|13|14|(2:16|(1:18)(1:(1:20)))|21|(1:24)|25|26))|37|6|7|8|(0)(0)|13|14|(0)|21|(1:24)|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0035, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0068, code lost:
    
        r11 = kotlin.Result.INSTANCE;
        r8 = kotlin.Result.m1185constructorimpl(kotlin.ResultKt.a(r8));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(final java.lang.String r8, kotlin.jvm.functions.Function2 r9, kotlin.jvm.functions.Function1 r10, kotlin.coroutines.Continuation r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.transsion.rewardscenter.utils.RewardsCenterApiHelper$redeemProduct$1
            if (r0 == 0) goto L14
            r0 = r11
            com.transsion.rewardscenter.utils.RewardsCenterApiHelper$redeemProduct$1 r0 = (com.transsion.rewardscenter.utils.RewardsCenterApiHelper$redeemProduct$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.transsion.rewardscenter.utils.RewardsCenterApiHelper$redeemProduct$1 r0 = new com.transsion.rewardscenter.utils.RewardsCenterApiHelper$redeemProduct$1
            r0.<init>(r7, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L3f
            if (r1 != r2) goto L37
            java.lang.Object r8 = r4.L$1
            r10 = r8
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r8 = r4.L$0
            r9 = r8
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            kotlin.ResultKt.b(r11)     // Catch: java.lang.Throwable -> L35
            goto L61
        L35:
            r8 = move-exception
            goto L68
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3f:
            kotlin.ResultKt.b(r11)
            com.transsion.rewardscenter.utils.h r11 = new com.transsion.rewardscenter.utils.h
            r11.<init>()
            okhttp3.RequestBody r3 = r7.i(r11)
            kotlin.Result$Companion r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L35
            up.a r1 = r7.p()     // Catch: java.lang.Throwable -> L35
            r4.L$0 = r9     // Catch: java.lang.Throwable -> L35
            r4.L$1 = r10     // Catch: java.lang.Throwable -> L35
            r4.label = r2     // Catch: java.lang.Throwable -> L35
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r11 = up.a.C0966a.h(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L35
            if (r11 != r0) goto L61
            return r0
        L61:
            com.tn.lib.net.bean.BaseDto r11 = (com.tn.lib.net.bean.BaseDto) r11     // Catch: java.lang.Throwable -> L35
            java.lang.Object r8 = kotlin.Result.m1185constructorimpl(r11)     // Catch: java.lang.Throwable -> L35
            goto L72
        L68:
            kotlin.Result$Companion r11 = kotlin.Result.INSTANCE
            java.lang.Object r8 = kotlin.ResultKt.a(r8)
            java.lang.Object r8 = kotlin.Result.m1185constructorimpl(r8)
        L72:
            boolean r11 = kotlin.Result.m1192isSuccessimpl(r8)
            if (r11 == 0) goto L96
            r11 = r8
            com.tn.lib.net.bean.BaseDto r11 = (com.tn.lib.net.bean.BaseDto) r11
            boolean r0 = com.transsion.rewardscenter.utils.n.a(r11)
            if (r0 == 0) goto L89
            java.lang.Object r11 = r11.getData()
            r10.invoke(r11)
            goto L96
        L89:
            if (r9 == 0) goto L96
            java.lang.String r10 = r11.getCode()
            java.lang.String r11 = r11.getMsg()
            r9.invoke(r10, r11)
        L96:
            java.lang.Throwable r8 = kotlin.Result.m1188exceptionOrNullimpl(r8)
            if (r8 == 0) goto La6
            if (r9 == 0) goto La6
            r10 = 0
            java.lang.String r8 = r8.getMessage()
            r9.invoke(r10, r8)
        La6:
            kotlin.Unit r8 = kotlin.Unit.f67184a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.rewardscenter.utils.RewardsCenterApiHelper.s(java.lang.String, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(2:3|(12:5|6|7|8|(1:(2:11|12)(2:27|28))(3:29|30|(1:32))|13|14|(2:16|(1:18)(1:19))|20|(1:22)|23|24))|35|6|7|8|(0)(0)|13|14|(0)|20|(0)|23|24) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0035, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0068, code lost:
    
        r11 = kotlin.Result.INSTANCE;
        r8 = kotlin.Result.m1185constructorimpl(kotlin.ResultKt.a(r8));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(final java.lang.String r8, kotlin.jvm.functions.Function2 r9, kotlin.jvm.functions.Function1 r10, kotlin.coroutines.Continuation r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.transsion.rewardscenter.utils.RewardsCenterApiHelper$startClaim$1
            if (r0 == 0) goto L14
            r0 = r11
            com.transsion.rewardscenter.utils.RewardsCenterApiHelper$startClaim$1 r0 = (com.transsion.rewardscenter.utils.RewardsCenterApiHelper$startClaim$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.transsion.rewardscenter.utils.RewardsCenterApiHelper$startClaim$1 r0 = new com.transsion.rewardscenter.utils.RewardsCenterApiHelper$startClaim$1
            r0.<init>(r7, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L3f
            if (r1 != r2) goto L37
            java.lang.Object r8 = r4.L$1
            r10 = r8
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r8 = r4.L$0
            r9 = r8
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            kotlin.ResultKt.b(r11)     // Catch: java.lang.Throwable -> L35
            goto L61
        L35:
            r8 = move-exception
            goto L68
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3f:
            kotlin.ResultKt.b(r11)
            com.transsion.rewardscenter.utils.j r11 = new com.transsion.rewardscenter.utils.j
            r11.<init>()
            okhttp3.RequestBody r3 = r7.i(r11)
            kotlin.Result$Companion r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L35
            up.a r1 = r7.p()     // Catch: java.lang.Throwable -> L35
            r4.L$0 = r9     // Catch: java.lang.Throwable -> L35
            r4.L$1 = r10     // Catch: java.lang.Throwable -> L35
            r4.label = r2     // Catch: java.lang.Throwable -> L35
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r11 = up.a.C0966a.f(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L35
            if (r11 != r0) goto L61
            return r0
        L61:
            com.tn.lib.net.bean.BaseDto r11 = (com.tn.lib.net.bean.BaseDto) r11     // Catch: java.lang.Throwable -> L35
            java.lang.Object r8 = kotlin.Result.m1185constructorimpl(r11)     // Catch: java.lang.Throwable -> L35
            goto L72
        L68:
            kotlin.Result$Companion r11 = kotlin.Result.INSTANCE
            java.lang.Object r8 = kotlin.ResultKt.a(r8)
            java.lang.Object r8 = kotlin.Result.m1185constructorimpl(r8)
        L72:
            boolean r11 = kotlin.Result.m1192isSuccessimpl(r8)
            if (r11 == 0) goto L94
            r11 = r8
            com.tn.lib.net.bean.BaseDto r11 = (com.tn.lib.net.bean.BaseDto) r11
            boolean r0 = com.transsion.rewardscenter.utils.n.a(r11)
            if (r0 == 0) goto L89
            java.lang.Object r11 = r11.getData()
            r10.invoke(r11)
            goto L94
        L89:
            java.lang.String r10 = r11.getCode()
            java.lang.String r11 = r11.getMsg()
            r9.invoke(r10, r11)
        L94:
            java.lang.Throwable r8 = kotlin.Result.m1188exceptionOrNullimpl(r8)
            if (r8 == 0) goto La2
            r10 = 0
            java.lang.String r8 = r8.getMessage()
            r9.invoke(r10, r8)
        La2:
            kotlin.Unit r8 = kotlin.Unit.f67184a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.rewardscenter.utils.RewardsCenterApiHelper.u(java.lang.String, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(2:3|(12:5|6|7|8|(1:(2:11|12)(2:29|30))(3:31|32|(1:34))|13|14|(2:16|(1:18)(1:(1:20)))|21|(1:24)|25|26))|37|6|7|8|(0)(0)|13|14|(0)|21|(1:24)|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0035, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0068, code lost:
    
        r11 = kotlin.Result.INSTANCE;
        r8 = kotlin.Result.m1185constructorimpl(kotlin.ResultKt.a(r8));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(final com.transsion.rewardscenterapi.ClaimReceiverRequest r8, kotlin.jvm.functions.Function2 r9, kotlin.jvm.functions.Function1 r10, kotlin.coroutines.Continuation r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.transsion.rewardscenter.utils.RewardsCenterApiHelper$submitClaimReceiverInfo$1
            if (r0 == 0) goto L14
            r0 = r11
            com.transsion.rewardscenter.utils.RewardsCenterApiHelper$submitClaimReceiverInfo$1 r0 = (com.transsion.rewardscenter.utils.RewardsCenterApiHelper$submitClaimReceiverInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.transsion.rewardscenter.utils.RewardsCenterApiHelper$submitClaimReceiverInfo$1 r0 = new com.transsion.rewardscenter.utils.RewardsCenterApiHelper$submitClaimReceiverInfo$1
            r0.<init>(r7, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L3f
            if (r1 != r2) goto L37
            java.lang.Object r8 = r4.L$1
            r10 = r8
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r8 = r4.L$0
            r9 = r8
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            kotlin.ResultKt.b(r11)     // Catch: java.lang.Throwable -> L35
            goto L61
        L35:
            r8 = move-exception
            goto L68
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3f:
            kotlin.ResultKt.b(r11)
            com.transsion.rewardscenter.utils.l r11 = new com.transsion.rewardscenter.utils.l
            r11.<init>()
            okhttp3.RequestBody r3 = r7.i(r11)
            kotlin.Result$Companion r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L35
            up.a r1 = r7.p()     // Catch: java.lang.Throwable -> L35
            r4.L$0 = r9     // Catch: java.lang.Throwable -> L35
            r4.L$1 = r10     // Catch: java.lang.Throwable -> L35
            r4.label = r2     // Catch: java.lang.Throwable -> L35
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r11 = up.a.C0966a.i(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L35
            if (r11 != r0) goto L61
            return r0
        L61:
            com.tn.lib.net.bean.BaseDto r11 = (com.tn.lib.net.bean.BaseDto) r11     // Catch: java.lang.Throwable -> L35
            java.lang.Object r8 = kotlin.Result.m1185constructorimpl(r11)     // Catch: java.lang.Throwable -> L35
            goto L72
        L68:
            kotlin.Result$Companion r11 = kotlin.Result.INSTANCE
            java.lang.Object r8 = kotlin.ResultKt.a(r8)
            java.lang.Object r8 = kotlin.Result.m1185constructorimpl(r8)
        L72:
            boolean r11 = kotlin.Result.m1192isSuccessimpl(r8)
            if (r11 == 0) goto L96
            r11 = r8
            com.tn.lib.net.bean.BaseDto r11 = (com.tn.lib.net.bean.BaseDto) r11
            boolean r0 = com.transsion.rewardscenter.utils.n.a(r11)
            if (r0 == 0) goto L89
            java.lang.Object r11 = r11.getData()
            r10.invoke(r11)
            goto L96
        L89:
            if (r9 == 0) goto L96
            java.lang.String r10 = r11.getCode()
            java.lang.String r11 = r11.getMsg()
            r9.invoke(r10, r11)
        L96:
            java.lang.Throwable r8 = kotlin.Result.m1188exceptionOrNullimpl(r8)
            if (r8 == 0) goto La6
            if (r9 == 0) goto La6
            r10 = 0
            java.lang.String r8 = r8.getMessage()
            r9.invoke(r10, r8)
        La6:
            kotlin.Unit r8 = kotlin.Unit.f67184a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.rewardscenter.utils.RewardsCenterApiHelper.w(com.transsion.rewardscenterapi.ClaimReceiverRequest, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
