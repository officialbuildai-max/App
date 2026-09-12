package com.transsion.audio.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsnet.downloader.bean.DownloadListBean;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1", f = "HistoryListManager.kt", l = {145}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class HistoryListManager$getResourcePosition$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $postId;
    final /* synthetic */ int $resourceNum;
    final /* synthetic */ String $subjectId;
    int label;
    final /* synthetic */ HistoryListManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsnet/downloader/bean/DownloadListBean;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1$1", f = "HistoryListManager.kt", l = {Sdk$SDKError.Reason.TPAT_RETRY_FAILED_VALUE, 139, 141}, m = "invokeSuspend")
    /* renamed from: com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.c, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $postId;
        final /* synthetic */ int $resourceNum;
        final /* synthetic */ String $subjectId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ HistoryListManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HistoryListManager historyListManager, String str, String str2, int i11, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = historyListManager;
            this.$subjectId = str;
            this.$postId = str2;
            this.$resourceNum = i11;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$subjectId, this.$postId, this.$resourceNum, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(cVar, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.c cVar;
            cj.a u11;
            DownloadListBean downloadListBean;
            List<DownloadItem> items;
            Object f11 = IntrinsicsKt.f();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                cVar = (kotlinx.coroutines.flow.c) this.L$0;
                u11 = this.this$0.u();
                String a11 = vg.a.f77447a.a();
                String str = this.$subjectId;
                String str2 = this.$postId;
                int i12 = this.$resourceNum;
                this.L$0 = cVar;
                this.label = 1;
                obj = u11.a(a11, str, str2, i12, this);
                if (obj == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    if (i11 != 2 && i11 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Unit.f67184a;
                }
                cVar = (kotlinx.coroutines.flow.c) this.L$0;
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            if (Intrinsics.c(baseDto.getCode(), "0") && ((downloadListBean = (DownloadListBean) baseDto.getData()) == null || (items = downloadListBean.getItems()) == null || !items.isEmpty())) {
                Object data = baseDto.getData();
                this.L$0 = null;
                this.label = 3;
                if (cVar.emit(data, this) == f11) {
                    return f11;
                }
            } else {
                this.L$0 = null;
                this.label = 2;
                if (cVar.emit(null, this) == f11) {
                    return f11;
                }
            }
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsnet/downloader/bean/DownloadListBean;", "", "it", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1$2", f = "HistoryListManager.kt", l = {144}, m = "invokeSuspend")
    /* renamed from: com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1$2, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.c, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = cVar;
            return anonymousClass2.invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object f11 = IntrinsicsKt.f();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.c cVar = (kotlinx.coroutines.flow.c) this.L$0;
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
    /* renamed from: com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1$3, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass3 implements kotlinx.coroutines.flow.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HistoryListManager f43022a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f43023b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f43024c;

        AnonymousClass3(HistoryListManager historyListManager, String str, String str2) {
            this.f43022a = historyListManager;
            this.f43023b = str;
            this.f43024c = str2;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00ae  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        @Override // kotlinx.coroutines.flow.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(com.transsnet.downloader.bean.DownloadListBean r8, kotlin.coroutines.Continuation r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1$3$emit$1
                if (r0 == 0) goto L13
                r0 = r9
                com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1$3$emit$1 r0 = (com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1$3$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1$3$emit$1 r0 = new com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1$3$emit$1
                r0.<init>(r7, r9)
            L18:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.label
                r3 = 0
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L3e
                if (r2 == r5) goto L36
                if (r2 != r4) goto L2e
                kotlin.ResultKt.b(r9)
                goto Lc1
            L2e:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L36:
                java.lang.Object r8 = r0.L$0
                com.transsnet.downloader.bean.DownloadListBean r8 = (com.transsnet.downloader.bean.DownloadListBean) r8
                kotlin.ResultKt.b(r9)
                goto L78
            L3e:
                kotlin.ResultKt.b(r9)
                com.transsion.audio.viewmodel.HistoryListManager$a r9 = com.transsion.audio.viewmodel.HistoryListManager.f43015e
                boolean r2 = r9.a()
                if (r2 != 0) goto L56
                com.transsion.audio.viewmodel.HistoryListManager r2 = r7.f43022a
                androidx.lifecycle.b0 r2 = r2.v()
                r2.n(r8)
                r9.c(r5)
                goto L61
            L56:
                if (r8 == 0) goto L61
                com.transsion.audio.viewmodel.HistoryListManager r9 = r7.f43022a
                androidx.lifecycle.b0 r9 = r9.v()
                r9.n(r8)
            L61:
                com.transsion.audio.viewmodel.HistoryListManager r9 = r7.f43022a
                jj.a r9 = com.transsion.audio.viewmodel.HistoryListManager.f(r9)
                if (r9 == 0) goto L7b
                java.lang.String r2 = r7.f43023b
                java.lang.String r6 = r7.f43024c
                r0.L$0 = r8
                r0.label = r5
                java.lang.Object r9 = r9.g(r2, r6, r0)
                if (r9 != r1) goto L78
                return r1
            L78:
                com.transsion.baselib.db.audio.AudioBean r9 = (com.transsion.baselib.db.audio.AudioBean) r9
                goto L7c
            L7b:
                r9 = r3
            L7c:
                if (r8 == 0) goto Lac
                java.util.List r8 = r8.getItems()
                if (r8 == 0) goto Lac
                r2 = r8
                java.util.Collection r2 = (java.util.Collection) r2
                boolean r2 = r2.isEmpty()
                if (r2 != 0) goto Lac
                r2 = 0
                if (r9 == 0) goto L9d
                java.lang.Object r5 = r8.get(r2)
                com.transsion.moviedetailapi.DownloadItem r5 = (com.transsion.moviedetailapi.DownloadItem) r5
                int r5 = r5.getSe()
                r9.setSe(r5)
            L9d:
                if (r9 == 0) goto Lac
                java.lang.Object r8 = r8.get(r2)
                com.transsion.moviedetailapi.DownloadItem r8 = (com.transsion.moviedetailapi.DownloadItem) r8
                int r8 = r8.getEp()
                r9.setEp(r8)
            Lac:
                if (r9 == 0) goto Lc4
                com.transsion.audio.viewmodel.HistoryListManager r8 = r7.f43022a
                jj.a r8 = com.transsion.audio.viewmodel.HistoryListManager.f(r8)
                if (r8 == 0) goto Lc4
                r0.L$0 = r3
                r0.label = r4
                java.lang.Object r8 = r8.f(r9, r0)
                if (r8 != r1) goto Lc1
                return r1
            Lc1:
                kotlin.Unit r8 = kotlin.Unit.f67184a
                return r8
            Lc4:
                kotlin.Unit r8 = kotlin.Unit.f67184a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.audio.viewmodel.HistoryListManager$getResourcePosition$1.AnonymousClass3.emit(com.transsnet.downloader.bean.DownloadListBean, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryListManager$getResourcePosition$1(HistoryListManager historyListManager, String str, String str2, int i11, Continuation<? super HistoryListManager$getResourcePosition$1> continuation) {
        super(2, continuation);
        this.this$0 = historyListManager;
        this.$subjectId = str;
        this.$postId = str2;
        this.$resourceNum = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoryListManager$getResourcePosition$1(this.this$0, this.$subjectId, this.$postId, this.$resourceNum, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((HistoryListManager$getResourcePosition$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.b f12 = kotlinx.coroutines.flow.d.f(kotlinx.coroutines.flow.d.s(new AnonymousClass1(this.this$0, this.$subjectId, this.$postId, this.$resourceNum, null)), new AnonymousClass2(null));
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, this.$subjectId, this.$postId);
            this.label = 1;
            if (f12.a(anonymousClass3, this) == f11) {
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
