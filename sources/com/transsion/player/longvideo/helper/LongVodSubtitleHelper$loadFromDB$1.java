package com.transsion.player.longvideo.helper;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.subtitle.VideoSubtitleControl;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.player.longvideo.helper.LongVodSubtitleHelper$loadFromDB$1", f = "LongVodSubtitleHelper.kt", l = {186, PsExtractor.PRIVATE_STREAM_1, 193, 201}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class LongVodSubtitleHelper$loadFromDB$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $bean;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ LongVodSubtitleHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.player.longvideo.helper.LongVodSubtitleHelper$loadFromDB$1$3", f = "LongVodSubtitleHelper.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.player.longvideo.helper.LongVodSubtitleHelper$loadFromDB$1$3, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ DownloadBean $bean;
        final /* synthetic */ List<eu.a> $list;
        int label;
        final /* synthetic */ LongVodSubtitleHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(List<eu.a> list, LongVodSubtitleHelper longVodSubtitleHelper, DownloadBean downloadBean, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$list = list;
            this.this$0 = longVodSubtitleHelper;
            this.$bean = downloadBean;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$list, this.this$0, this.$bean, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List list;
            List list2;
            VideoSubtitleControl videoSubtitleControl;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            List<eu.a> list3 = this.$list;
            if (list3 != null && !list3.isEmpty()) {
                list = this.this$0.f47999g;
                list.clear();
                list2 = this.this$0.f47999g;
                list2.addAll(this.$list);
                videoSubtitleControl = this.this$0.f48000h;
                videoSubtitleControl.h0(this.$list);
            }
            if (nh.m.f70597a.e()) {
                this.this$0.F(this.$bean);
            }
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongVodSubtitleHelper$loadFromDB$1(DownloadBean downloadBean, LongVodSubtitleHelper longVodSubtitleHelper, Continuation<? super LongVodSubtitleHelper$loadFromDB$1> continuation) {
        super(2, continuation);
        this.$bean = downloadBean;
        this.this$0 = longVodSubtitleHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LongVodSubtitleHelper$loadFromDB$1(this.$bean, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((LongVodSubtitleHelper$loadFromDB$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0146 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.player.longvideo.helper.LongVodSubtitleHelper$loadFromDB$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
