package com.transsion.mpush.core.fcm;

import android.app.Application;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.mpush.core.net.PushNetworkApi;
import com.transsion.mpush.core.utils.PushPreference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import lg.a;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.mpush.core.fcm.FCMPushHelper$sendToServer$1$1", f = "FCMPushHelper.kt", l = {92}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class FCMPushHelper$sendToServer$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $json;
    final /* synthetic */ String $regHash;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FCMPushHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FCMPushHelper$sendToServer$1$1(FCMPushHelper fCMPushHelper, JSONObject jSONObject, String str, Continuation<? super FCMPushHelper$sendToServer$1$1> continuation) {
        super(2, continuation);
        this.this$0 = fCMPushHelper;
        this.$json = jSONObject;
        this.$regHash = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FCMPushHelper$sendToServer$1$1 fCMPushHelper$sendToServer$1$1 = new FCMPushHelper$sendToServer$1$1(this.this$0, this.$json, this.$regHash, continuation);
        fCMPushHelper$sendToServer$1$1.L$0 = obj;
        return fCMPushHelper$sendToServer$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((FCMPushHelper$sendToServer$1$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1185constructorimpl;
        String str;
        boolean z10;
        FCMPushHelper fCMPushHelper;
        PushNetworkApi r11;
        RequestBody s11;
        String str2;
        String str3;
        boolean z11;
        Application application;
        String str4;
        boolean z12;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                fCMPushHelper = this.this$0;
                JSONObject jSONObject = this.$json;
                String str5 = this.$regHash;
                Result.Companion companion = Result.INSTANCE;
                r11 = fCMPushHelper.r();
                String apiPathPrefix = ln.a.f69101a.i().getApiPathPrefix();
                String a11 = vg.a.f77447a.a();
                String jSONObject2 = jSONObject.toString();
                Intrinsics.g(jSONObject2, "toString(...)");
                s11 = fCMPushHelper.s(jSONObject2);
                this.L$0 = fCMPushHelper;
                this.L$1 = str5;
                this.label = 1;
                obj = r11.pushRegister(apiPathPrefix, a11, s11, this);
                if (obj == f11) {
                    return f11;
                }
                str2 = str5;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str2 = (String) this.L$1;
                fCMPushHelper = (FCMPushHelper) this.L$0;
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            if (Intrinsics.c(baseDto.getCode(), "0")) {
                application = fCMPushHelper.f47547h;
                if (application != null) {
                    PushPreference.f47662a.r(application, str2);
                }
                a.C0856a c0856a = lg.a.f68962a;
                str4 = fCMPushHelper.f47540a;
                z12 = fCMPushHelper.f47550k;
                a.C0856a.f(c0856a, str4, "onSuccess, retry:" + z12, false, 4, null);
            } else {
                a.C0856a c0856a2 = lg.a.f68962a;
                str3 = fCMPushHelper.f47540a;
                String code = baseDto.getCode();
                z11 = fCMPushHelper.f47550k;
                a.C0856a.f(c0856a2, str3, "onFailure code " + code + " retry:" + z11, false, 4, null);
                fCMPushHelper.C();
            }
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        FCMPushHelper fCMPushHelper2 = this.this$0;
        String str6 = this.$regHash;
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            a.C0856a c0856a3 = lg.a.f68962a;
            str = fCMPushHelper2.f47540a;
            String message = m1188exceptionOrNullimpl.getMessage();
            z10 = fCMPushHelper2.f47550k;
            a.C0856a.f(c0856a3, str, "send error: " + message + " retry:" + z10 + ",refresh:" + str6, false, 4, null);
            fCMPushHelper2.C();
        }
        return Unit.f67184a;
    }
}
