package com.transsion.home.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.MovieViewModel$getFilterItems$1", f = "MovieViewModel.kt", l = {46}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class MovieViewModel$getFilterItems$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $tabId;
    final /* synthetic */ String $version;
    int label;
    final /* synthetic */ MovieViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieViewModel$getFilterItems$1(MovieViewModel movieViewModel, Integer num, String str, Continuation<? super MovieViewModel$getFilterItems$1> continuation) {
        super(2, continuation);
        this.this$0 = movieViewModel;
        this.$tabId = num;
        this.$version = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MovieViewModel$getFilterItems$1(this.this$0, this.$tabId, this.$version, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((MovieViewModel$getFilterItems$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ol.c cVar;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                cVar = this.this$0.f45869e;
                String a11 = vg.a.f77447a.a();
                Integer num = this.$tabId;
                int intValue = num != null ? num.intValue() : 0;
                String str = this.$version;
                this.label = 1;
                obj = cVar.b(a11, intValue, str, this);
                if (obj == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            this.this$0.j().n((BaseDto) obj);
        } catch (Exception e11) {
            e11.printStackTrace();
            this.this$0.j().n(new BaseDto());
        }
        return Unit.f67184a;
    }
}
