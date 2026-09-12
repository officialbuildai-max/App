package com.transsion.ad.hi;

import android.app.Application;
import android.content.Context;
import com.blankj.utilcode.util.Utils;
import com.cloud.hisavana.net.CommonOkHttpClient;
import com.hisavana.mediation.config.TAdManager;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import okhttp3.OkHttpClient;
import zg.c;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.hi.HiSavanaAdManager$initHiAdSdk$2", f = "HiSavanaAdManager.kt", l = {Sdk$SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class HiSavanaAdManager$initHiAdSdk$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $adTestDevice;
    final /* synthetic */ String $hisavanaAppId;
    final /* synthetic */ boolean $isDebug;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiSavanaAdManager$initHiAdSdk$2(String str, boolean z10, boolean z11, Continuation<? super HiSavanaAdManager$initHiAdSdk$2> continuation) {
        super(2, continuation);
        this.$hisavanaAppId = str;
        this.$isDebug = z10;
        this.$adTestDevice = z11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HiSavanaAdManager$initHiAdSdk$2(this.$hisavanaAppId, this.$isDebug, this.$adTestDevice, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((HiSavanaAdManager$initHiAdSdk$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1185constructorimpl;
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        String f11;
        Object j11;
        Context applicationContext;
        Object f12 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                String str = this.$hisavanaAppId;
                boolean z10 = this.$isDebug;
                boolean z11 = this.$adTestDevice;
                Result.Companion companion = Result.INSTANCE;
                OkHttpClient g11 = c.f79537e.a().g();
                CommonOkHttpClient.r(g11 != null ? g11.dispatcher() : null);
                Application a11 = Utils.a();
                if (a11 != null && (applicationContext = a11.getApplicationContext()) != null) {
                    TAdManager.init(applicationContext, new TAdManager.AdConfigBuilder().setAppId(str).setAppIconId(com.blankj.utilcode.util.c.a()).setDebug(z10).testDevice(z10 && z11).setMuteVideo(true).build());
                }
                HiSavanaAdManager hiSavanaAdManager = HiSavanaAdManager.f42171a;
                this.label = 1;
                j11 = hiSavanaAdManager.j(this);
                if (j11 == f12) {
                    return f12;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            m1188exceptionOrNullimpl.printStackTrace();
            atomicBoolean = HiSavanaAdManager.f42172b;
            atomicBoolean.set(false);
            atomicBoolean2 = HiSavanaAdManager.f42173c;
            atomicBoolean2.set(false);
            oi.a aVar = oi.a.f71145a;
            f11 = HiSavanaAdManager.f42171a.f();
            oi.a.c(aVar, f11 + " --> initHiAdSdk() --> 初始化异常，已重置状态 --> it = " + m1188exceptionOrNullimpl, 6, false, 4, null);
        }
        return Unit.f67184a;
    }
}
