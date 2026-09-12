package com.transsion.shorttv.ui.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv.ui.fragment.ShortTvDetailListFragment$downloadListener$1$onDownloadSuccess$2$1", f = "ShortTvDetailListFragment.kt", l = {1134}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
final class ShortTvDetailListFragment$downloadListener$1$onDownloadSuccess$2$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ js.e $it;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ShortTvDetailListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvDetailListFragment$downloadListener$1$onDownloadSuccess$2$1(js.e eVar, ShortTvDetailListFragment shortTvDetailListFragment, Continuation<? super ShortTvDetailListFragment$downloadListener$1$onDownloadSuccess$2$1> continuation) {
        super(2, continuation);
        this.$it = eVar;
        this.this$0 = shortTvDetailListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvDetailListFragment$downloadListener$1$onDownloadSuccess$2$1(this.$it, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvDetailListFragment$downloadListener$1$onDownloadSuccess$2$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0071, code lost:
    
        r8 = r0.mOrPlayer;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r12.label
            r2 = 1
            if (r1 == 0) goto L26
            if (r1 != r2) goto L1e
            java.lang.Object r0 = r12.L$2
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r1 = r12.L$1
            js.e r1 = (js.e) r1
            java.lang.Object r2 = r12.L$0
            com.transsion.shorttv.ui.fragment.ShortTvDetailListFragment r2 = (com.transsion.shorttv.ui.fragment.ShortTvDetailListFragment) r2
            kotlin.ResultKt.b(r13)
            r11 = r2
            r2 = r0
            r0 = r11
            goto L6d
        L1e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L26:
            kotlin.ResultKt.b(r13)
            js.e r13 = r12.$it
            com.transsion.shorttv.bean.ShortTVItem r13 = r13.d()
            if (r13 == 0) goto La2
            com.transsion.shorttv.bean.Media r13 = r13.getVideo()
            if (r13 == 0) goto La2
            com.transsion.shorttv.bean.Video r13 = r13.getVideo()
            if (r13 == 0) goto La2
            java.lang.String r13 = r13.getUrl()
            if (r13 == 0) goto La2
            com.transsion.shorttv.ui.fragment.ShortTvDetailListFragment r1 = r12.this$0
            js.e r3 = r12.$it
            com.transsion.shorttv.viewmodel.ShortTvViewModel r4 = com.transsion.shorttv.ui.fragment.ShortTvDetailListFragment.y0(r1)
            qs.d r4 = r4.s0()
            if (r4 == 0) goto La2
            java.lang.String r5 = r3.e()
            int r6 = r3.c()
            r12.L$0 = r1
            r12.L$1 = r3
            r12.L$2 = r13
            r12.label = r2
            java.lang.Object r2 = r4.a(r5, r6, r13, r12)
            if (r2 != r0) goto L68
            return r0
        L68:
            r0 = r1
            r1 = r3
            r11 = r2
            r2 = r13
            r13 = r11
        L6d:
            java.lang.String r13 = (java.lang.String) r13
            if (r13 == 0) goto La2
            lo.f r8 = com.transsion.shorttv.ui.fragment.ShortTvDetailListFragment.x0(r0)
            if (r8 == 0) goto La2
            ao.e r9 = new ao.e
            com.transsion.shorttv.bean.ShortTVItem r0 = r1.d()
            if (r0 == 0) goto L85
            java.lang.String r0 = r0.getId()
        L83:
            r3 = r0
            goto L87
        L85:
            r0 = 0
            goto L83
        L87:
            int r4 = r1.c()
            r6 = 24
            r7 = 0
            r5 = 0
            r10 = 0
            r0 = r9
            r1 = r3
            r3 = r4
            r4 = r5
            r5 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r9.t(r13)
            boolean r13 = r8.b(r9)
            kotlin.coroutines.jvm.internal.Boxing.a(r13)
        La2:
            kotlin.Unit r13 = kotlin.Unit.f67184a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.ui.fragment.ShortTvDetailListFragment$downloadListener$1$onDownloadSuccess$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
