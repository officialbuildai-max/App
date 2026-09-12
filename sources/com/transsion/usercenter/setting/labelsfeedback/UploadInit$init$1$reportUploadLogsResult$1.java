package com.transsion.usercenter.setting.labelsfeedback;

import bh.b;
import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.upload.bean.LoggerBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import lg.a;
import okhttp3.RequestBody;
import yw.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.usercenter.setting.labelsfeedback.UploadInit$init$1$reportUploadLogsResult$1", f = "UploadInit.kt", l = {73}, m = "invokeSuspend")
/* loaded from: classes7.dex */
final class UploadInit$init$1$reportUploadLogsResult$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<LoggerBean, Unit> $callback;
    final /* synthetic */ JsonObject $json;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UploadInit$init$1$reportUploadLogsResult$1(JsonObject jsonObject, Function1<? super LoggerBean, Unit> function1, Continuation<? super UploadInit$init$1$reportUploadLogsResult$1> continuation) {
        super(2, continuation);
        this.$json = jsonObject;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UploadInit$init$1$reportUploadLogsResult$1(this.$json, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UploadInit$init$1$reportUploadLogsResult$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        yw.a f11;
        Function1<LoggerBean, Unit> function1;
        Object f12 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            b.a aVar = bh.b.f16553a;
            String jsonElement = this.$json.toString();
            Intrinsics.g(jsonElement, "toString(...)");
            RequestBody a11 = aVar.a(jsonElement);
            if (a11 != null) {
                Function1<LoggerBean, Unit> function12 = this.$callback;
                f11 = UploadInit.f57541a.f();
                this.L$0 = function12;
                this.label = 1;
                Object b11 = a.C0999a.b(f11, null, a11, this, 1, null);
                if (b11 == f12) {
                    return f12;
                }
                function1 = function12;
                obj = b11;
            }
            return Unit.f67184a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        function1 = (Function1) this.L$0;
        ResultKt.b(obj);
        BaseDto baseDto = (BaseDto) obj;
        a.C0856a.f(lg.a.f68962a, "UploadLoggerManager", "reportUploadLogsResult code=" + baseDto.getCode(), false, 4, null);
        function1.invoke(baseDto.getData());
        return Unit.f67184a;
    }
}
