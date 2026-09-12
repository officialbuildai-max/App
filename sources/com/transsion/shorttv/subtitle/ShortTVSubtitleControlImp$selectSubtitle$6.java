package com.transsion.shorttv.subtitle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp$selectSubtitle$6", f = "ShortTVSubtitleControlImp.kt", l = {446}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class ShortTVSubtitleControlImp$selectSubtitle$6 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ ts.b $bean;
    int label;
    final /* synthetic */ ShortTVSubtitleControlImp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTVSubtitleControlImp$selectSubtitle$6(ts.b bVar, ShortTVSubtitleControlImp shortTVSubtitleControlImp, Continuation<? super ShortTVSubtitleControlImp$selectSubtitle$6> continuation) {
        super(2, continuation);
        this.$bean = bVar;
        this.this$0 = shortTVSubtitleControlImp;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTVSubtitleControlImp$selectSubtitle$6(this.$bean, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ShortTVSubtitleControlImp$selectSubtitle$6) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        r3 = (r1 = r4.this$0).f53115d;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.ResultKt.b(r5)
            goto L49
        Lf:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L17:
            kotlin.ResultKt.b(r5)
            ts.b r5 = r4.$bean
            if (r5 == 0) goto L49
            com.transsion.subtitle_download.db.SubtitleDownloadTable r5 = r5.a()
            if (r5 == 0) goto L49
            java.lang.String r5 = r5.getId()
            if (r5 == 0) goto L49
            com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp r1 = r4.this$0
            com.transsion.shorttv.viewmodel.ShortTvViewModel r3 = com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp.t(r1)
            if (r3 == 0) goto L49
            qs.h r3 = r3.A0()
            if (r3 == 0) goto L49
            js.e r1 = com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp.q(r1)
            java.lang.String r1 = r1.e()
            r4.label = r2
            java.lang.Object r5 = r3.b(r1, r5, r4)
            if (r5 != r0) goto L49
            return r0
        L49:
            kotlin.Unit r5 = kotlin.Unit.f67184a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp$selectSubtitle$6.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
