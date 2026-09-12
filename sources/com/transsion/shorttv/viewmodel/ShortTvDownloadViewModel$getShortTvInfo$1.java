package com.transsion.shorttv.viewmodel;

import com.transsion.shorttv.bean.Subject;
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
@DebugMetadata(c = "com.transsion.shorttv.viewmodel.ShortTvDownloadViewModel$getShortTvInfo$1", f = "ShortTvDownloadViewModel.kt", l = {78, 86, 97}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class ShortTvDownloadViewModel$getShortTvInfo$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $forLoginRefresh;
    final /* synthetic */ String $subjectId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ShortTvDownloadViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.shorttv.viewmodel.ShortTvDownloadViewModel$getShortTvInfo$1$3", f = "ShortTvDownloadViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.shorttv.viewmodel.ShortTvDownloadViewModel$getShortTvInfo$1$3, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $forLoginRefresh;
        final /* synthetic */ Subject $subject;
        int label;
        final /* synthetic */ ShortTvDownloadViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ShortTvDownloadViewModel shortTvDownloadViewModel, Subject subject, boolean z10, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = shortTvDownloadViewModel;
            this.$subject = subject;
            this.$forLoginRefresh = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.this$0, this.$subject, this.$forLoginRefresh, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.this$0.p().q(this.$subject);
            if (this.$forLoginRefresh) {
                this.this$0.j().q(Unit.f67184a);
            }
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvDownloadViewModel$getShortTvInfo$1(String str, ShortTvDownloadViewModel shortTvDownloadViewModel, boolean z10, Continuation<? super ShortTvDownloadViewModel$getShortTvInfo$1> continuation) {
        super(2, continuation);
        this.$subjectId = str;
        this.this$0 = shortTvDownloadViewModel;
        this.$forLoginRefresh = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ShortTvDownloadViewModel$getShortTvInfo$1 shortTvDownloadViewModel$getShortTvInfo$1 = new ShortTvDownloadViewModel$getShortTvInfo$1(this.$subjectId, this.this$0, this.$forLoginRefresh, continuation);
        shortTvDownloadViewModel$getShortTvInfo$1.L$0 = obj;
        return shortTvDownloadViewModel$getShortTvInfo$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvDownloadViewModel$getShortTvInfo$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a4 A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:14:0x0023, B:15:0x00a0, B:17:0x00a4, B:19:0x00aa, B:21:0x00d2, B:22:0x00db, B:23:0x00df, B:40:0x008d, B:42:0x0095), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x012b A[RETURN] */
    /* JADX WARN: Type inference failed for: r13v8, types: [zr.b] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.transsion.shorttv.bean.Subject] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.transsion.shorttv.bean.Subject] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.viewmodel.ShortTvDownloadViewModel$getShortTvInfo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
