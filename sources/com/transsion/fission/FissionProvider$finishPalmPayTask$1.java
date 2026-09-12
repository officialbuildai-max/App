package com.transsion.fission;

import com.therouter.TheRouter;
import com.transsion.bean.HomePopupEntity;
import com.transsion.commercializationapi.ICommonDialogApi;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.fission.FissionProvider$finishPalmPayTask$1", f = "FissionProvider.kt", l = {Sdk$SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class FissionProvider$finishPalmPayTask$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $subjectType;
    int label;
    final /* synthetic */ FissionProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FissionProvider$finishPalmPayTask$1(int i11, FissionProvider fissionProvider, Continuation<? super FissionProvider$finishPalmPayTask$1> continuation) {
        super(2, continuation);
        this.$subjectType = i11;
        this.this$0 = fissionProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(HomePopupEntity homePopupEntity) {
        ICommonDialogApi iCommonDialogApi = (ICommonDialogApi) TheRouter.d(ICommonDialogApi.class, new Object[0]);
        if (iCommonDialogApi != null) {
            iCommonDialogApi.b(homePopupEntity, new Function1() { // from class: com.transsion.fission.o
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit h11;
                    h11 = FissionProvider$finishPalmPayTask$1.h(((Boolean) obj).booleanValue());
                    return h11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(boolean z10) {
        return Unit.f67184a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FissionProvider$finishPalmPayTask$1(this.$subjectType, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((FissionProvider$finishPalmPayTask$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0081 A[Catch: all -> 0x0015, TRY_LEAVE, TryCatch #0 {all -> 0x0015, blocks: (B:5:0x000f, B:7:0x005f, B:9:0x0065, B:10:0x006b, B:12:0x0073, B:14:0x0079, B:16:0x0081, B:19:0x008b, B:21:0x0095, B:22:0x00a8, B:24:0x00b0, B:26:0x00b9, B:28:0x00db, B:30:0x009f, B:32:0x00e3, B:44:0x0027, B:46:0x0050), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b0 A[Catch: all -> 0x0015, TryCatch #0 {all -> 0x0015, blocks: (B:5:0x000f, B:7:0x005f, B:9:0x0065, B:10:0x006b, B:12:0x0073, B:14:0x0079, B:16:0x0081, B:19:0x008b, B:21:0x0095, B:22:0x00a8, B:24:0x00b0, B:26:0x00b9, B:28:0x00db, B:30:0x009f, B:32:0x00e3, B:44:0x0027, B:46:0x0050), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b9 A[Catch: all -> 0x0015, TryCatch #0 {all -> 0x0015, blocks: (B:5:0x000f, B:7:0x005f, B:9:0x0065, B:10:0x006b, B:12:0x0073, B:14:0x0079, B:16:0x0081, B:19:0x008b, B:21:0x0095, B:22:0x00a8, B:24:0x00b0, B:26:0x00b9, B:28:0x00db, B:30:0x009f, B:32:0x00e3, B:44:0x0027, B:46:0x0050), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0065 A[Catch: all -> 0x0015, TryCatch #0 {all -> 0x0015, blocks: (B:5:0x000f, B:7:0x005f, B:9:0x0065, B:10:0x006b, B:12:0x0073, B:14:0x0079, B:16:0x0081, B:19:0x008b, B:21:0x0095, B:22:0x00a8, B:24:0x00b0, B:26:0x00b9, B:28:0x00db, B:30:0x009f, B:32:0x00e3, B:44:0x0027, B:46:0x0050), top: B:2:0x000b }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.fission.FissionProvider$finishPalmPayTask$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
