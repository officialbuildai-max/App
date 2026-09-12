package com.transsnet.downloader.adapter;

import android.text.TextUtils;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baselib.db.download.DownloadBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.adapter.DownloadExpandAdapter$upDateAudioName$1", f = "DownloadExpandAdapter.kt", l = {226, 237}, m = "invokeSuspend")
/* loaded from: classes7.dex */
public final class DownloadExpandAdapter$upDateAudioName$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ n6.a $item;
    int label;
    final /* synthetic */ DownloadExpandAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadExpandAdapter$upDateAudioName$1(n6.a aVar, DownloadExpandAdapter downloadExpandAdapter, Continuation<? super DownloadExpandAdapter$upDateAudioName$1> continuation) {
        super(2, continuation);
        this.$item = aVar;
        this.this$0 = downloadExpandAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadExpandAdapter$upDateAudioName$1(this.$item, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadExpandAdapter$upDateAudioName$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        jj.a N1;
        AudioBean audioBean;
        Object c11;
        jj.a N12;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            String url = ((DownloadBean) this.$item).getUrl();
            if (!TextUtils.isEmpty(url)) {
                N1 = this.this$0.N1();
                if (N1 != null) {
                    this.label = 1;
                    c11 = N1.c(url, this);
                    if (c11 == f11) {
                        return f11;
                    }
                    audioBean = (AudioBean) c11;
                } else {
                    audioBean = null;
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
        ResultKt.b(obj);
        c11 = obj;
        audioBean = (AudioBean) c11;
        if (audioBean == null) {
            audioBean = new AudioBean(((DownloadBean) this.$item).getUrl(), ((DownloadBean) this.$item).getCover(), Boxing.e(0L), ((DownloadBean) this.$item).getSize(), ((DownloadBean) this.$item).getPath(), ((DownloadBean) this.$item).getName(), null, null, null, null, null, null, null, null, null, null, 0, null, 0, 0, 1048512, null);
            audioBean.setPostId(((DownloadBean) this.$item).getPostId());
            audioBean.setResourceId(((DownloadBean) this.$item).getResourceId());
            audioBean.setSubjectId(((DownloadBean) this.$item).getSubjectId());
            audioBean.setGroupId(((DownloadBean) this.$item).getGroupId());
        }
        audioBean.setTitle(((DownloadBean) this.$item).getName());
        N12 = this.this$0.N1();
        if (N12 != null) {
            this.label = 2;
            if (N12.f(audioBean, this) == f11) {
                return f11;
            }
        }
        return Unit.f67184a;
    }
}
