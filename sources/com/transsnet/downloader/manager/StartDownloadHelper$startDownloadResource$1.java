package com.transsnet.downloader.manager;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.bean.StartlDownloadBean;
import java.util.ArrayList;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.manager.StartDownloadHelper$startDownloadResource$1", f = "StartDownloadHelper.kt", l = {98}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class StartDownloadHelper$startDownloadResource$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<DownloadBean> $beanList;
    int label;
    final /* synthetic */ StartDownloadHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsnet/downloader/bean/StartResponseBean;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsnet.downloader.manager.StartDownloadHelper$startDownloadResource$1$2", f = "StartDownloadHelper.kt", l = {78, 87, 91, 93}, m = "invokeSuspend")
    /* renamed from: com.transsnet.downloader.manager.StartDownloadHelper$startDownloadResource$1$2, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.c, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<StartlDownloadBean> $normalList;
        final /* synthetic */ ArrayList<UGCStartDownloadBean> $ugcList;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ StartDownloadHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ArrayList<UGCStartDownloadBean> arrayList, StartDownloadHelper startDownloadHelper, ArrayList<StartlDownloadBean> arrayList2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$ugcList = arrayList;
            this.this$0 = startDownloadHelper;
            this.$normalList = arrayList2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$ugcList, this.this$0, this.$normalList, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(cVar, continuation)).invokeSuspend(Unit.f67184a);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x00ee A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00b3  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00ef  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 253
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.StartDownloadHelper$startDownloadResource$1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsnet/downloader/bean/StartResponseBean;", "", "it", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsnet.downloader.manager.StartDownloadHelper$startDownloadResource$1$3", f = "StartDownloadHelper.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsnet.downloader.manager.StartDownloadHelper$startDownloadResource$1$3, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.c, Throwable, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ StartDownloadHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(StartDownloadHelper startDownloadHelper, Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
            this.this$0 = startDownloadHelper;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, continuation);
            anonymousClass3.L$0 = th2;
            return anonymousClass3.invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Throwable th2 = (Throwable) this.L$0;
            a.C0856a c0856a = lg.a.f68962a;
            str = this.this$0.f59597a;
            String message = th2.getMessage();
            if (message == null) {
                message = "";
            }
            a.C0856a.e(c0856a, str, message, th2, false, 8, null);
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.transsnet.downloader.manager.StartDownloadHelper$startDownloadResource$1$4, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass4 implements kotlinx.coroutines.flow.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f59599a;

        AnonymousClass4(List list) {
            this.f59599a = list;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // kotlinx.coroutines.flow.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(com.transsnet.downloader.bean.StartResponseBean r5, kotlin.coroutines.Continuation r6) {
            /*
                r4 = this;
                boolean r5 = r6 instanceof com.transsnet.downloader.manager.StartDownloadHelper$startDownloadResource$1$4$emit$1
                if (r5 == 0) goto L13
                r5 = r6
                com.transsnet.downloader.manager.StartDownloadHelper$startDownloadResource$1$4$emit$1 r5 = (com.transsnet.downloader.manager.StartDownloadHelper$startDownloadResource$1$4$emit$1) r5
                int r0 = r5.label
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r0 & r1
                if (r2 == 0) goto L13
                int r0 = r0 - r1
                r5.label = r0
                goto L18
            L13:
                com.transsnet.downloader.manager.StartDownloadHelper$startDownloadResource$1$4$emit$1 r5 = new com.transsnet.downloader.manager.StartDownloadHelper$startDownloadResource$1$4$emit$1
                r5.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r5.result
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r5.label
                r2 = 1
                if (r1 == 0) goto L31
                if (r1 != r2) goto L29
                kotlin.ResultKt.b(r6)
                goto L68
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                kotlin.ResultKt.b(r6)
                com.transsnet.downloader.manager.f$a r6 = com.transsnet.downloader.manager.f.f59601a
                com.transsnet.downloader.manager.f r6 = r6.a()
                r6.g()
                java.util.List r6 = r4.f59599a
                if (r6 == 0) goto L5d
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                java.util.Iterator r6 = r6.iterator()
            L47:
                boolean r1 = r6.hasNext()
                if (r1 == 0) goto L5d
                java.lang.Object r1 = r6.next()
                com.transsion.baselib.db.download.DownloadBean r1 = (com.transsion.baselib.db.download.DownloadBean) r1
                boolean r3 = r1.getIsStartRequested()
                if (r3 == 0) goto L47
                r1.setSubtitleStarted(r2)
                goto L47
            L5d:
                r5.label = r2
                r1 = 3000(0xbb8, double:1.482E-320)
                java.lang.Object r5 = kotlinx.coroutines.u0.a(r1, r5)
                if (r5 != r0) goto L68
                return r0
            L68:
                com.transsnet.downloader.manager.f$a r5 = com.transsnet.downloader.manager.f.f59601a
                com.transsnet.downloader.manager.f r5 = r5.a()
                r5.h()
                kotlin.Unit r5 = kotlin.Unit.f67184a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.StartDownloadHelper$startDownloadResource$1.AnonymousClass4.emit(com.transsnet.downloader.bean.StartResponseBean, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StartDownloadHelper$startDownloadResource$1(List<? extends DownloadBean> list, StartDownloadHelper startDownloadHelper, Continuation<? super StartDownloadHelper$startDownloadResource$1> continuation) {
        super(2, continuation);
        this.$beanList = list;
        this.this$0 = startDownloadHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StartDownloadHelper$startDownloadResource$1(this.$beanList, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((StartDownloadHelper$startDownloadResource$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0145, code lost:
    
        if (kotlin.text.StringsKt.c0(r3, "http", false, 2, null) == true) goto L44;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r27) {
        /*
            Method dump skipped, instructions count: 504
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.StartDownloadHelper$startDownloadResource$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
