package com.transsion.subtitle.viewmodel;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.SubtitleLanguageMapBean;
import com.transsion.subtitle.bean.SubtitleSearchListBean;
import com.transsion.subtitle.fragment.i;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
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
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1", f = "SubtitleDownloadViewModel.kt", l = {151}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class SubtitleDownloadViewModel$searchSubtitleList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $downloadBean;
    final /* synthetic */ i $keyword;
    final /* synthetic */ List<SubtitleLanguageMapBean> $languageList;
    final /* synthetic */ String $languages;
    final /* synthetic */ String $nextPage;
    final /* synthetic */ int $perPage;
    int label;
    final /* synthetic */ SubtitleDownloadViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/subtitle/bean/SubtitleSearchListBean;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1$1", f = "SubtitleDownloadViewModel.kt", l = {140, 140}, m = "invokeSuspend")
    /* renamed from: com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<c, Continuation<? super Unit>, Object> {
        final /* synthetic */ DownloadBean $downloadBean;
        final /* synthetic */ i $keyword;
        final /* synthetic */ List<SubtitleLanguageMapBean> $languageList;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SubtitleDownloadViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SubtitleDownloadViewModel subtitleDownloadViewModel, DownloadBean downloadBean, i iVar, List<SubtitleLanguageMapBean> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = subtitleDownloadViewModel;
            this.$downloadBean = downloadBean;
            this.$keyword = iVar;
            this.$languageList = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$downloadBean, this.$keyword, this.$languageList, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(c cVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(cVar, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            c cVar;
            Object f11 = IntrinsicsKt.f();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                cVar = (c) this.L$0;
                SubtitleDownloadViewModel subtitleDownloadViewModel = this.this$0;
                DownloadBean downloadBean = this.$downloadBean;
                i iVar = this.$keyword;
                List<SubtitleLanguageMapBean> list = this.$languageList;
                this.L$0 = cVar;
                this.label = 1;
                obj = subtitleDownloadViewModel.s(downloadBean, iVar, list, this);
                if (obj == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Unit.f67184a;
                }
                cVar = (c) this.L$0;
                ResultKt.b(obj);
            }
            this.L$0 = null;
            this.label = 2;
            if (cVar.emit(obj, this) == f11) {
                return f11;
            }
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/subtitle/bean/SubtitleSearchListBean;", "", "it", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1$3", f = "SubtitleDownloadViewModel.kt", l = {150}, m = "invokeSuspend")
    /* renamed from: com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1$3, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function3<c, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(c cVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
            anonymousClass3.L$0 = cVar;
            return anonymousClass3.invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object f11 = IntrinsicsKt.f();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                c cVar = (c) this.L$0;
                this.label = 1;
                if (cVar.emit(null, this) == f11) {
                    return f11;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SubtitleDownloadViewModel f55118a;

        a(SubtitleDownloadViewModel subtitleDownloadViewModel) {
            this.f55118a = subtitleDownloadViewModel;
        }

        @Override // kotlinx.coroutines.flow.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(SubtitleSearchListBean subtitleSearchListBean, Continuation continuation) {
            this.f55118a.o().n(subtitleSearchListBean);
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubtitleDownloadViewModel$searchSubtitleList$1(SubtitleDownloadViewModel subtitleDownloadViewModel, DownloadBean downloadBean, i iVar, List<SubtitleLanguageMapBean> list, String str, String str2, int i11, Continuation<? super SubtitleDownloadViewModel$searchSubtitleList$1> continuation) {
        super(2, continuation);
        this.this$0 = subtitleDownloadViewModel;
        this.$downloadBean = downloadBean;
        this.$keyword = iVar;
        this.$languageList = list;
        this.$languages = str;
        this.$nextPage = str2;
        this.$perPage = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubtitleDownloadViewModel$searchSubtitleList$1(this.this$0, this.$downloadBean, this.$keyword, this.$languageList, this.$languages, this.$nextPage, this.$perPage, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SubtitleDownloadViewModel$searchSubtitleList$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            final kotlinx.coroutines.flow.b s11 = d.s(new AnonymousClass1(this.this$0, this.$downloadBean, this.$keyword, this.$languageList, null));
            final SubtitleDownloadViewModel subtitleDownloadViewModel = this.this$0;
            final i iVar = this.$keyword;
            final String str = this.$languages;
            final DownloadBean downloadBean = this.$downloadBean;
            final String str2 = this.$nextPage;
            final int i12 = this.$perPage;
            kotlinx.coroutines.flow.b f12 = d.f(new kotlinx.coroutines.flow.b() { // from class: com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1$invokeSuspend$$inlined$map$1

                /* renamed from: com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                /* loaded from: classes6.dex */
                public static final class AnonymousClass2 implements c {

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ c f55109a;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ SubtitleDownloadViewModel f55110b;

                    /* renamed from: c, reason: collision with root package name */
                    final /* synthetic */ i f55111c;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f55112d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ DownloadBean f55113e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ String f55114f;

                    /* renamed from: g, reason: collision with root package name */
                    final /* synthetic */ int f55115g;

                    @Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
                    @DebugMetadata(c = "com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1$invokeSuspend$$inlined$map$1$2", f = "SubtitleDownloadViewModel.kt", l = {Sdk$SDKMetric.SDKMetricType.AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE, 50}, m = "emit")
                    /* renamed from: com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    /* loaded from: classes6.dex */
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

                    public AnonymousClass2(c cVar, SubtitleDownloadViewModel subtitleDownloadViewModel, i iVar, String str, DownloadBean downloadBean, String str2, int i11) {
                        this.f55109a = cVar;
                        this.f55110b = subtitleDownloadViewModel;
                        this.f55111c = iVar;
                        this.f55112d = str;
                        this.f55113e = downloadBean;
                        this.f55114f = str2;
                        this.f55115g = i11;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:27:0x0054, code lost:
                    
                        if (r1.isEmpty() != false) goto L24;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:20:0x007f A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
                    @Override // kotlinx.coroutines.flow.c
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object emit(java.lang.Object r13, kotlin.coroutines.Continuation r14) {
                        /*
                            r12 = this;
                            boolean r0 = r14 instanceof com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r14
                            com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1$invokeSuspend$$inlined$map$1$2$1
                            r0.<init>(r14)
                        L18:
                            java.lang.Object r14 = r0.result
                            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                            int r1 = r0.label
                            r9 = 0
                            r10 = 2
                            r2 = 1
                            if (r1 == 0) goto L3d
                            if (r1 == r2) goto L35
                            if (r1 != r10) goto L2d
                            kotlin.ResultKt.b(r14)
                            goto L80
                        L2d:
                            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                            r13.<init>(r14)
                            throw r13
                        L35:
                            java.lang.Object r13 = r0.L$0
                            kotlinx.coroutines.flow.c r13 = (kotlinx.coroutines.flow.c) r13
                            kotlin.ResultKt.b(r14)
                            goto L72
                        L3d:
                            kotlin.ResultKt.b(r14)
                            kotlinx.coroutines.flow.c r14 = r12.f55109a
                            com.transsion.subtitle.bean.SubtitleSearchListBean r13 = (com.transsion.subtitle.bean.SubtitleSearchListBean) r13
                            if (r13 == 0) goto L4b
                            java.util.List r1 = r13.getItems()
                            goto L4c
                        L4b:
                            r1 = r9
                        L4c:
                            java.util.Collection r1 = (java.util.Collection) r1
                            if (r1 == 0) goto L56
                            boolean r1 = r1.isEmpty()
                            if (r1 == 0) goto L75
                        L56:
                            com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel r1 = r12.f55110b
                            com.transsion.subtitle.fragment.i r13 = r12.f55111c
                            java.lang.String r3 = r12.f55112d
                            com.transsion.baselib.db.download.DownloadBean r4 = r12.f55113e
                            java.lang.String r5 = r12.f55114f
                            int r6 = r12.f55115g
                            r0.L$0 = r14
                            r0.label = r2
                            r2 = r13
                            r7 = r0
                            java.lang.Object r13 = com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel.e(r1, r2, r3, r4, r5, r6, r7)
                            if (r13 != r8) goto L6f
                            return r8
                        L6f:
                            r11 = r14
                            r14 = r13
                            r13 = r11
                        L72:
                            r11 = r14
                            r14 = r13
                            r13 = r11
                        L75:
                            r0.L$0 = r9
                            r0.label = r10
                            java.lang.Object r13 = r14.emit(r13, r0)
                            if (r13 != r8) goto L80
                            return r8
                        L80:
                            kotlin.Unit r13 = kotlin.Unit.f67184a
                            return r13
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$searchSubtitleList$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.b
                public Object a(c cVar, Continuation continuation) {
                    Object a11 = kotlinx.coroutines.flow.b.this.a(new AnonymousClass2(cVar, subtitleDownloadViewModel, iVar, str, downloadBean, str2, i12), continuation);
                    return a11 == IntrinsicsKt.f() ? a11 : Unit.f67184a;
                }
            }, new AnonymousClass3(null));
            a aVar = new a(this.this$0);
            this.label = 1;
            if (f12.a(aVar, this) == f11) {
                return f11;
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
