package com.transsion.usercenter.me;

import bh.b;
import com.tencent.mmkv.MMKV;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.usercenter.profile.bean.ZeroBody;
import com.transsion.usercenter.profile.bean.ZeroConfig;
import com.transsion.usercenter.profile.bean.ZeroInfo;
import com.transsion.usercenter.profile.bean.ZeroResponse;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import lg.a;
import okhttp3.RequestBody;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.usercenter.me.MeViewmodel$fetchPurchase$1", f = "MeViewmodel.kt", l = {Sdk$SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class MeViewmodel$fetchPurchase$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MeViewmodel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MeViewmodel$fetchPurchase$1(MeViewmodel meViewmodel, Continuation<? super MeViewmodel$fetchPurchase$1> continuation) {
        super(2, continuation);
        this.this$0 = meViewmodel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MeViewmodel$fetchPurchase$1 meViewmodel$fetchPurchase$1 = new MeViewmodel$fetchPurchase$1(this.this$0, continuation);
        meViewmodel$fetchPurchase$1.L$0 = obj;
        return meViewmodel$fetchPurchase$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((MeViewmodel$fetchPurchase$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1185constructorimpl;
        ILoginApi F;
        ILoginApi F2;
        String str;
        ZeroConfig zeroConfig;
        com.transsion.usercenter.profile.d H;
        Object a11;
        MeViewmodel meViewmodel;
        String string;
        UserInfo i11;
        UserInfo i12;
        List list;
        List list2;
        List<ZeroInfo> l11;
        Object f11 = IntrinsicsKt.f();
        int i13 = this.label;
        try {
            if (i13 == 0) {
                ResultKt.b(obj);
                MeViewmodel meViewmodel2 = this.this$0;
                Result.Companion companion = Result.INSTANCE;
                String str2 = TimeZone.getDefault().getID().toString();
                F = meViewmodel2.F();
                String phone = (F == null || (i12 = F.i()) == null) ? null : i12.getPhone();
                F2 = meViewmodel2.F();
                String userId = (F2 == null || (i11 = F2.i()) == null) ? null : i11.getUserId();
                String i14 = ih.b.f65364a.i();
                MMKV c11 = bh.a.f16551a.c();
                if (c11 == null || (string = c11.getString("custom_local_iso", "")) == null) {
                    str = null;
                } else {
                    str = string.toUpperCase(Locale.ROOT);
                    Intrinsics.g(str, "toUpperCase(...)");
                }
                b.a aVar = bh.b.f16553a;
                String j11 = com.blankj.utilcode.util.o.j(new ZeroBody(str == null ? "" : str, phone, userId, i14, str2, 0, null, 96, null));
                Intrinsics.g(j11, "toJson(...)");
                RequestBody a12 = aVar.a(j11);
                if (a12 == null) {
                    return Unit.f67184a;
                }
                zeroConfig = meViewmodel2.f57021g;
                String urlPath = zeroConfig != null ? zeroConfig.getUrlPath() : null;
                if (urlPath == null || urlPath.length() == 0) {
                    urlPath = "campaign/v1/freebuy/campaign/recent";
                }
                H = meViewmodel2.H();
                this.L$0 = meViewmodel2;
                this.label = 1;
                a11 = H.a(a12, urlPath, this);
                if (a11 == f11) {
                    return f11;
                }
                meViewmodel = meViewmodel2;
            } else {
                if (i13 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                meViewmodel = (MeViewmodel) this.L$0;
                ResultKt.b(obj);
                a11 = obj;
            }
            BaseDto baseDto = (BaseDto) a11;
            a.C0856a.f(lg.a.f68962a, "MeViewmodel", "zero entrance:" + baseDto, false, 4, null);
            if (Intrinsics.c(baseDto.getCode(), "0")) {
                list = meViewmodel.f57020f;
                list.clear();
                list2 = meViewmodel.f57020f;
                ZeroResponse zeroResponse = (ZeroResponse) baseDto.getData();
                if (zeroResponse == null || (l11 = zeroResponse.getItems()) == null) {
                    l11 = CollectionsKt.l();
                }
                list2.addAll(l11);
                meViewmodel.T();
            }
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("error:");
            sb2.append(m1188exceptionOrNullimpl);
        }
        return Unit.f67184a;
    }
}
