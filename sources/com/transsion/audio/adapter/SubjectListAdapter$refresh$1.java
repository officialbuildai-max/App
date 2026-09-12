package com.transsion.audio.adapter;

import android.view.View;
import android.widget.ImageView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.audio.R$drawable;
import com.transsion.audio.adapter.SubjectListAdapter;
import com.transsion.moviedetailapi.DownloadItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.audio.adapter.SubjectListAdapter$refresh$1", f = "SubjectListAdapter.kt", l = {75}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class SubjectListAdapter$refresh$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadItem $download;
    final /* synthetic */ BaseViewHolder $holder;
    int label;
    final /* synthetic */ SubjectListAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubjectListAdapter$refresh$1(DownloadItem downloadItem, BaseViewHolder baseViewHolder, SubjectListAdapter subjectListAdapter, Continuation<? super SubjectListAdapter$refresh$1> continuation) {
        super(2, continuation);
        this.$download = downloadItem;
        this.$holder = baseViewHolder;
        this.this$0 = subjectListAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(DownloadItem downloadItem, ImageView imageView, SubjectListAdapter subjectListAdapter, View view) {
        Integer status = downloadItem.getStatus();
        if (status != null && status.intValue() == 3) {
            imageView.setImageResource(R$drawable.play_progress_bg);
        } else {
            imageView.setImageResource(R$drawable.playing_progress_bg);
        }
        SubjectListAdapter.a optionClickListener = subjectListAdapter.getOptionClickListener();
        if (optionClickListener != null) {
            optionClickListener.a(downloadItem);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubjectListAdapter$refresh$1(this.$download, this.$holder, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SubjectListAdapter$refresh$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0023, code lost:
    
        r1 = r12.this$0.G1();
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cc  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.audio.adapter.SubjectListAdapter$refresh$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
