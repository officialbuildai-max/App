package com.transsion.shorttv_pugc.ui.fragment.download;

import com.transsion.shorttv_pugc.bean.ShortTvInnerPlayBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv_pugc.ui.fragment.download.ShortTVDownloadReFragment$initHistory$1", f = "ShortTVDownloadReFragment.kt", l = {194, 196}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class ShortTVDownloadReFragment$initHistory$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ShortTVDownloadReFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTVDownloadReFragment$initHistory$1(ShortTVDownloadReFragment shortTVDownloadReFragment, Continuation<? super ShortTVDownloadReFragment$initHistory$1> continuation) {
        super(2, continuation);
        this.this$0 = shortTVDownloadReFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTVDownloadReFragment$initHistory$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ShortTVDownloadReFragment$initHistory$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        ShortTVDownloadReFragment shortTVDownloadReFragment;
        ShortTvInnerPlayBean shortTvInnerPlayBean;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            str = this.this$0.subjectId;
            if (str != null) {
                shortTVDownloadReFragment = this.this$0;
                st.f O = shortTVDownloadReFragment.g0().O();
                if (O != null) {
                    this.L$0 = shortTVDownloadReFragment;
                    this.label = 1;
                    obj = O.c(str, this);
                    if (obj == f11) {
                        return f11;
                    }
                    shortTvInnerPlayBean = (ShortTvInnerPlayBean) obj;
                } else {
                    shortTvInnerPlayBean = null;
                }
            }
            return Unit.f67184a;
        }
        if (i11 != 1) {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Unit.f67184a;
        }
        shortTVDownloadReFragment = (ShortTVDownloadReFragment) this.L$0;
        ResultKt.b(obj);
        shortTvInnerPlayBean = (ShortTvInnerPlayBean) obj;
        a2 c11 = y0.c();
        ShortTVDownloadReFragment$initHistory$1$1$1 shortTVDownloadReFragment$initHistory$1$1$1 = new ShortTVDownloadReFragment$initHistory$1$1$1(shortTVDownloadReFragment, shortTvInnerPlayBean, null);
        this.L$0 = null;
        this.label = 2;
        if (kotlinx.coroutines.i.g(c11, shortTVDownloadReFragment$initHistory$1$1$1, this) == f11) {
            return f11;
        }
        return Unit.f67184a;
    }
}
