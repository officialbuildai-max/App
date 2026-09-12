package com.transsion.shorttv.viewmodel;

import androidx.view.b0;
import com.transsion.shorttv.bean.ShortTVFavInfo;
import com.transsion.shorttv.bean.Subject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv.viewmodel.ShortTvViewModel$forceRefreshSubjectInfo$1", f = "ShortTvViewModel.kt", l = {875, 888, 895}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class ShortTvViewModel$forceRefreshSubjectInfo$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $subjectId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ShortTvViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.shorttv.viewmodel.ShortTvViewModel$forceRefreshSubjectInfo$1$3", f = "ShortTvViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.shorttv.viewmodel.ShortTvViewModel$forceRefreshSubjectInfo$1$3, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Subject $newSubject;
        int label;
        final /* synthetic */ ShortTvViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ShortTvViewModel shortTvViewModel, Subject subject, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = shortTvViewModel;
            this.$newSubject = subject;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.this$0, this.$newSubject, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            b0 b0Var;
            b0 b0Var2;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            b0Var = this.this$0.f53739g;
            b0Var.q(this.$newSubject);
            b0Var2 = this.this$0.D;
            ShortTVFavInfo shortTVFavInfo = this.$newSubject.getShortTVFavInfo();
            b0Var2.q(shortTVFavInfo != null ? Boxing.a(shortTVFavInfo.getHasFavorite()) : null);
            b0 l02 = this.this$0.l0();
            Unit unit = Unit.f67184a;
            l02.q(unit);
            return unit;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvViewModel$forceRefreshSubjectInfo$1(ShortTvViewModel shortTvViewModel, String str, Continuation<? super ShortTvViewModel$forceRefreshSubjectInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = shortTvViewModel;
        this.$subjectId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ShortTvViewModel$forceRefreshSubjectInfo$1 shortTvViewModel$forceRefreshSubjectInfo$1 = new ShortTvViewModel$forceRefreshSubjectInfo$1(this.this$0, this.$subjectId, continuation);
        shortTvViewModel$forceRefreshSubjectInfo$1.L$0 = obj;
        return shortTvViewModel$forceRefreshSubjectInfo$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvViewModel$forceRefreshSubjectInfo$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ca A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:14:0x0023, B:15:0x00c6, B:17:0x00ca, B:19:0x00d0, B:21:0x00d9, B:22:0x00e2, B:23:0x00e6, B:53:0x00b3, B:55:0x00bb), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x012b A[RETURN] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.transsion.shorttv.bean.Subject] */
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
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.viewmodel.ShortTvViewModel$forceRefreshSubjectInfo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
