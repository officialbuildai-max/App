package com.transsion.subtitle;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import com.transsnet.downloader.manager.DownloadEsHelper;
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
@DebugMetadata(c = "com.transsion.subtitle.VideoSubtitleControl$saveSelectedFlag$1", f = "VideoSubtitleControl.kt", l = {848, 853}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class VideoSubtitleControl$saveSelectedFlag$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ eu.a $bean;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VideoSubtitleControl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoSubtitleControl$saveSelectedFlag$1(VideoSubtitleControl videoSubtitleControl, eu.a aVar, Continuation<? super VideoSubtitleControl$saveSelectedFlag$1> continuation) {
        super(2, continuation);
        this.this$0 = videoSubtitleControl;
        this.$bean = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        VideoSubtitleControl$saveSelectedFlag$1 videoSubtitleControl$saveSelectedFlag$1 = new VideoSubtitleControl$saveSelectedFlag$1(this.this$0, this.$bean, continuation);
        videoSubtitleControl$saveSelectedFlag$1.L$0 = obj;
        return videoSubtitleControl$saveSelectedFlag$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((VideoSubtitleControl$saveSelectedFlag$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        SubtitleDownloadTable b11;
        String id2;
        VideoDetailPlayDao H;
        String str2;
        SubtitleDownloadTable b12;
        String id3;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            n0 n0Var = (n0) this.L$0;
            DownloadBean downloadBean = this.this$0.f54839p;
            String str3 = "";
            if (downloadBean == null || !downloadBean.getIsStreamVideoDetail()) {
                a.f54861a.a(n0Var.getClass().getSimpleName() + " --> saveSelectedFlag() --> saveSelectedFlag -- download");
                DownloadEsHelper a11 = DownloadEsHelper.f59542m.a();
                DownloadBean downloadBean2 = this.this$0.f54839p;
                if (downloadBean2 == null || (str = downloadBean2.getResourceId()) == null) {
                    str = "";
                }
                eu.a aVar = this.$bean;
                if (aVar != null && (b11 = aVar.b()) != null && (id2 = b11.getId()) != null) {
                    str3 = id2;
                }
                this.label = 2;
                if (a11.h0(str, str3, this) == f11) {
                    return f11;
                }
            } else {
                a.f54861a.a(n0Var.getClass().getSimpleName() + " --> saveSelectedFlag() --> saveSelectedFlag -- dash");
                H = this.this$0.H();
                DownloadBean downloadBean3 = this.this$0.f54839p;
                if (downloadBean3 == null || (str2 = downloadBean3.getSubjectId()) == null) {
                    str2 = "";
                }
                eu.a aVar2 = this.$bean;
                if (aVar2 != null && (b12 = aVar2.b()) != null && (id3 = b12.getId()) != null) {
                    str3 = id3;
                }
                this.label = 1;
                if (H.b(str2, str3, this) == f11) {
                    return f11;
                }
            }
        } else {
            if (i11 != 1 && i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f67184a;
    }
}
