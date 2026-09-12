package com.transsion.audio.fragment;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.audio.fragment.SubjectListFragment$onPlayError$1", f = "SubjectListFragment.kt", l = {TTAdConstant.IMAGE_URL_CODE}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes5.dex */
final class SubjectListFragment$onPlayError$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ SubjectListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubjectListFragment$onPlayError$1(SubjectListFragment subjectListFragment, Continuation<? super SubjectListFragment$onPlayError$1> continuation) {
        super(2, continuation);
        this.this$0 = subjectListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubjectListFragment$onPlayError$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SubjectListFragment$onPlayError$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005f, code lost:
    
        r8 = r7.v0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007c, code lost:
    
        r11 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0075 -> B:5:0x0078). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r10.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L28
            if (r1 != r3) goto L20
            int r1 = r10.I$1
            int r4 = r10.I$0
            java.lang.Object r5 = r10.L$2
            com.transsion.moviedetailapi.DownloadItem r5 = (com.transsion.moviedetailapi.DownloadItem) r5
            java.lang.Object r6 = r10.L$1
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r7 = r10.L$0
            com.transsion.audio.fragment.SubjectListFragment r7 = (com.transsion.audio.fragment.SubjectListFragment) r7
            kotlin.ResultKt.b(r11)
            goto L78
        L20:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L28:
            kotlin.ResultKt.b(r11)
            com.transsion.audio.fragment.SubjectListFragment r11 = r10.this$0
            com.transsion.audio.adapter.SubjectListAdapter r11 = com.transsion.audio.fragment.SubjectListFragment.k0(r11)
            if (r11 == 0) goto L97
            java.util.List r11 = r11.getData()
            if (r11 == 0) goto L97
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            com.transsion.audio.fragment.SubjectListFragment r1 = r10.this$0
            java.util.Iterator r11 = r11.iterator()
            r4 = 0
            r6 = r11
            r7 = r1
        L44:
            r1 = r4
            boolean r11 = r6.hasNext()
            if (r11 == 0) goto L95
            java.lang.Object r11 = r6.next()
            int r4 = r1 + 1
            if (r1 >= 0) goto L56
            kotlin.collections.CollectionsKt.u()
        L56:
            r5 = r11
            com.transsion.moviedetailapi.DownloadItem r5 = (com.transsion.moviedetailapi.DownloadItem) r5
            java.lang.String r11 = r5.getUrl()
            if (r11 == 0) goto L7b
            jj.a r8 = com.transsion.audio.fragment.SubjectListFragment.i0(r7)
            if (r8 == 0) goto L7b
            r10.L$0 = r7
            r10.L$1 = r6
            r10.L$2 = r5
            r10.I$0 = r4
            r10.I$1 = r1
            r10.label = r3
            java.lang.Object r11 = r8.c(r11, r10)
            if (r11 != r0) goto L78
            return r0
        L78:
            com.transsion.baselib.db.audio.AudioBean r11 = (com.transsion.baselib.db.audio.AudioBean) r11
            goto L7c
        L7b:
            r11 = r2
        L7c:
            if (r11 == 0) goto L44
            int r8 = r11.getStatus()
            r9 = 3
            if (r8 != r9) goto L44
            if (r11 == 0) goto L8b
            r8 = 7
            r11.setStatus(r8)
        L8b:
            com.transsion.audio.adapter.SubjectListAdapter r11 = com.transsion.audio.fragment.SubjectListFragment.k0(r7)
            if (r11 == 0) goto L44
            r11.notifyItemChanged(r1, r5)
            goto L44
        L95:
            kotlin.Unit r2 = kotlin.Unit.f67184a
        L97:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.audio.fragment.SubjectListFragment$onPlayError$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
