package com.transsion.videodetail;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1", f = "VideoDetailViewModel.kt", l = {Sdk$SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class VideoDetailViewModel$fetchSeason$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $subjectId;
    int label;
    final /* synthetic */ VideoDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/tn/lib/net/bean/BaseDto;", "Lcom/transsion/moviedetailapi/bean/ResourcesSeasonList;", "", "it", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1$2", f = "VideoDetailViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1$2, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.c, Throwable, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ VideoDetailViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(VideoDetailViewModel videoDetailViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.this$0 = videoDetailViewModel;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Throwable th2, Continuation<? super Unit> continuation) {
            return new AnonymousClass2(this.this$0, continuation).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            androidx.view.b0 b0Var;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            b0Var = this.this$0.f57764b;
            b0Var.q(null);
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/tn/lib/net/bean/BaseDto;", "Lcom/transsion/moviedetailapi/bean/ResourcesSeasonList;"}, k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    @DebugMetadata(c = "com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1$3", f = "VideoDetailViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1$3, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<BaseDto<ResourcesSeasonList>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $subjectId;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ VideoDetailViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(VideoDetailViewModel videoDetailViewModel, String str, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = videoDetailViewModel;
            this.$subjectId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, this.$subjectId, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(BaseDto<ResourcesSeasonList> baseDto, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(baseDto, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            androidx.view.b0 b0Var;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            BaseDto baseDto = (BaseDto) this.L$0;
            b0Var = this.this$0.f57764b;
            b0Var.q(baseDto.getData());
            VideoDetailViewModel videoDetailViewModel = this.this$0;
            String str = this.$subjectId;
            ResourcesSeasonList resourcesSeasonList = (ResourcesSeasonList) baseDto.getData();
            videoDetailViewModel.p(str, resourcesSeasonList != null ? resourcesSeasonList.getSeasons() : null);
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDetailViewModel$fetchSeason$1(String str, VideoDetailViewModel videoDetailViewModel, Continuation<? super VideoDetailViewModel$fetchSeason$1> continuation) {
        super(2, continuation);
        this.$subjectId = str;
        this.this$0 = videoDetailViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoDetailViewModel$fetchSeason$1(this.$subjectId, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((VideoDetailViewModel$fetchSeason$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlinx.coroutines.flow.b f11;
        Object f12 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            final kotlinx.coroutines.flow.b t11 = kotlinx.coroutines.flow.d.t(this.$subjectId);
            final VideoDetailViewModel videoDetailViewModel = this.this$0;
            final String str = this.$subjectId;
            f11 = FlowKt__ErrorsKt.f(new kotlinx.coroutines.flow.b() { // from class: com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1$invokeSuspend$$inlined$map$1

                /* renamed from: com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                /* loaded from: classes7.dex */
                public static final class AnonymousClass2 implements kotlinx.coroutines.flow.c {

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ kotlinx.coroutines.flow.c f57778a;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ VideoDetailViewModel f57779b;

                    /* renamed from: c, reason: collision with root package name */
                    final /* synthetic */ String f57780c;

                    @Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
                    @DebugMetadata(c = "com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1$invokeSuspend$$inlined$map$1$2", f = "VideoDetailViewModel.kt", l = {Sdk$SDKMetric.SDKMetricType.AD_REWARD_USER_VALUE, 50}, m = "emit")
                    /* renamed from: com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    /* loaded from: classes7.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(kotlinx.coroutines.flow.c cVar, VideoDetailViewModel videoDetailViewModel, String str) {
                        this.f57778a = cVar;
                        this.f57779b = videoDetailViewModel;
                        this.f57780c = str;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:19:0x0069 A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                    @Override // kotlinx.coroutines.flow.c
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object emit(java.lang.Object r11, kotlin.coroutines.Continuation r12) {
                        /*
                            r10 = this;
                            boolean r0 = r12 instanceof com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r12
                            com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1$invokeSuspend$$inlined$map$1$2$1
                            r0.<init>(r12)
                        L18:
                            java.lang.Object r12 = r0.result
                            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                            int r1 = r0.label
                            r8 = 2
                            r2 = 1
                            if (r1 == 0) goto L3c
                            if (r1 == r2) goto L34
                            if (r1 != r8) goto L2c
                            kotlin.ResultKt.b(r12)
                            goto L6a
                        L2c:
                            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                            r11.<init>(r12)
                            throw r11
                        L34:
                            java.lang.Object r11 = r0.L$0
                            kotlinx.coroutines.flow.c r11 = (kotlinx.coroutines.flow.c) r11
                            kotlin.ResultKt.b(r12)
                            goto L5e
                        L3c:
                            kotlin.ResultKt.b(r12)
                            kotlinx.coroutines.flow.c r12 = r10.f57778a
                            java.lang.String r11 = (java.lang.String) r11
                            com.transsion.videodetail.VideoDetailViewModel r11 = r10.f57779b
                            com.transsion.videodetail.b r1 = com.transsion.videodetail.VideoDetailViewModel.l(r11)
                            java.lang.String r11 = r10.f57780c
                            r0.L$0 = r12
                            r0.label = r2
                            r3 = 0
                            r5 = 2
                            r6 = 0
                            r2 = r11
                            r4 = r0
                            java.lang.Object r11 = com.transsion.videodetail.b.a.b(r1, r2, r3, r4, r5, r6)
                            if (r11 != r7) goto L5b
                            return r7
                        L5b:
                            r9 = r12
                            r12 = r11
                            r11 = r9
                        L5e:
                            r1 = 0
                            r0.L$0 = r1
                            r0.label = r8
                            java.lang.Object r11 = r11.emit(r12, r0)
                            if (r11 != r7) goto L6a
                            return r7
                        L6a:
                            kotlin.Unit r11 = kotlin.Unit.f67184a
                            return r11
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.transsion.videodetail.VideoDetailViewModel$fetchSeason$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.b
                public Object a(kotlinx.coroutines.flow.c cVar, Continuation continuation) {
                    Object a11 = kotlinx.coroutines.flow.b.this.a(new AnonymousClass2(cVar, videoDetailViewModel, str), continuation);
                    return a11 == IntrinsicsKt.f() ? a11 : Unit.f67184a;
                }
            }, 1L, null, 2, null);
            kotlinx.coroutines.flow.b f13 = kotlinx.coroutines.flow.d.f(f11, new AnonymousClass2(this.this$0, null));
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, this.$subjectId, null);
            this.label = 1;
            if (kotlinx.coroutines.flow.d.i(f13, anonymousClass3, this) == f12) {
                return f12;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f67184a;
    }
}
