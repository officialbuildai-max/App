package com.transsion.audio.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.audio.fragment.SubjectListFragment$onCompletion$1", f = "SubjectListFragment.kt", l = {428}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes5.dex */
final class SubjectListFragment$onCompletion$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ ao.e $mediaSource;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ SubjectListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubjectListFragment$onCompletion$1(ao.e eVar, SubjectListFragment subjectListFragment, Continuation<? super SubjectListFragment$onCompletion$1> continuation) {
        super(2, continuation);
        this.$mediaSource = eVar;
        this.this$0 = subjectListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubjectListFragment$onCompletion$1(this.$mediaSource, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SubjectListFragment$onCompletion$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006e, code lost:
    
        r9 = r7.v0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008d, code lost:
    
        r11 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x008f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0086 -> B:5:0x0089). Please report as a decompilation issue!!! */
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
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L2c
            if (r1 != r2) goto L24
            int r1 = r10.I$1
            int r4 = r10.I$0
            java.lang.Object r5 = r10.L$3
            com.transsion.moviedetailapi.DownloadItem r5 = (com.transsion.moviedetailapi.DownloadItem) r5
            java.lang.Object r6 = r10.L$2
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r7 = r10.L$1
            com.transsion.audio.fragment.SubjectListFragment r7 = (com.transsion.audio.fragment.SubjectListFragment) r7
            java.lang.Object r8 = r10.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.ResultKt.b(r11)
            goto L89
        L24:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L2c:
            kotlin.ResultKt.b(r11)
            ao.e r11 = r10.$mediaSource
            if (r11 == 0) goto L38
            java.lang.String r11 = r11.k()
            goto L39
        L38:
            r11 = r3
        L39:
            com.transsion.audio.fragment.SubjectListFragment r1 = r10.this$0
            com.transsion.audio.adapter.SubjectListAdapter r1 = com.transsion.audio.fragment.SubjectListFragment.k0(r1)
            if (r1 == 0) goto Lb8
            java.util.List r1 = r1.getData()
            if (r1 == 0) goto Lb8
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            com.transsion.audio.fragment.SubjectListFragment r4 = r10.this$0
            java.util.Iterator r1 = r1.iterator()
            r5 = 0
            r8 = r11
            r6 = r1
            r7 = r4
            r1 = r5
        L54:
            boolean r11 = r6.hasNext()
            if (r11 == 0) goto Lb6
            java.lang.Object r11 = r6.next()
            int r4 = r1 + 1
            if (r1 >= 0) goto L65
            kotlin.collections.CollectionsKt.u()
        L65:
            r5 = r11
            com.transsion.moviedetailapi.DownloadItem r5 = (com.transsion.moviedetailapi.DownloadItem) r5
            java.lang.String r11 = r5.getUrl()
            if (r11 == 0) goto L8c
            jj.a r9 = com.transsion.audio.fragment.SubjectListFragment.i0(r7)
            if (r9 == 0) goto L8c
            r10.L$0 = r8
            r10.L$1 = r7
            r10.L$2 = r6
            r10.L$3 = r5
            r10.I$0 = r4
            r10.I$1 = r1
            r10.label = r2
            java.lang.Object r11 = r9.c(r11, r10)
            if (r11 != r0) goto L89
            return r0
        L89:
            com.transsion.baselib.db.audio.AudioBean r11 = (com.transsion.baselib.db.audio.AudioBean) r11
            goto L8d
        L8c:
            r11 = r3
        L8d:
            if (r11 == 0) goto L94
            java.lang.String r9 = r11.getAudioUrl()
            goto L95
        L94:
            r9 = r3
        L95:
            boolean r9 = android.text.TextUtils.equals(r8, r9)
            if (r9 == 0) goto Lb4
            r9 = 6
            if (r11 == 0) goto La1
            r11.setStatus(r9)
        La1:
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.d(r9)
            r5.setStatus(r11)
            com.transsion.audio.adapter.SubjectListAdapter r11 = com.transsion.audio.fragment.SubjectListFragment.k0(r7)
            if (r11 == 0) goto Lb1
            r11.notifyItemChanged(r1, r5)
        Lb1:
            com.transsion.audio.fragment.SubjectListFragment.s0(r7, r8)
        Lb4:
            r1 = r4
            goto L54
        Lb6:
            kotlin.Unit r3 = kotlin.Unit.f67184a
        Lb8:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.audio.fragment.SubjectListFragment$onCompletion$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
