package com.transsion.shorttv_pugc.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.shorttv_pugc.ShorttvModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.n0;
import rt.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "Lcom/transsion/shorttv_pugc/ShorttvModel$PlayStreamItem;", "<anonymous>", "(Lkotlinx/coroutines/n0;)Lcom/transsion/shorttv_pugc/ShorttvModel$PlayStreamItem;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel$requestFirstVideo$1$2$1$streamDeferred$1", f = "ShortTvViewModel.kt", l = {168}, m = "invokeSuspend")
/* loaded from: classes6.dex */
final class ShortTvViewModel$requestFirstVideo$1$2$1$streamDeferred$1 extends SuspendLambda implements Function2<n0, Continuation<? super ShorttvModel.PlayStreamItem>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $ugcVideoIdMutable;
    int label;
    final /* synthetic */ ShortTvViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvViewModel$requestFirstVideo$1$2$1$streamDeferred$1(ShortTvViewModel shortTvViewModel, Ref.ObjectRef<String> objectRef, Continuation<? super ShortTvViewModel$requestFirstVideo$1$2$1$streamDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = shortTvViewModel;
        this.$ugcVideoIdMutable = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvViewModel$requestFirstVideo$1$2$1$streamDeferred$1(this.this$0, this.$ugcVideoIdMutable, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super ShorttvModel.PlayStreamItem> continuation) {
        return ((ShortTvViewModel$requestFirstVideo$1$2$1$streamDeferred$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        rt.a aVar;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            aVar = this.this$0.f54520a;
            String str = this.$ugcVideoIdMutable.element;
            this.label = 1;
            obj = a.C0937a.f(aVar, str, null, this, 2, null);
            if (obj == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return ((BaseDto) obj).getData();
    }
}
