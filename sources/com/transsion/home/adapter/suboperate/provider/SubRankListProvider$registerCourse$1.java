package com.transsion.home.adapter.suboperate.provider;

import com.transsion.edcation.CourseManager;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.x0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.adapter.suboperate.provider.SubRankListProvider$registerCourse$1", f = "SubRankListProvider.kt", l = {147}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class SubRankListProvider$registerCourse$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SubRankListProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.transsion.home.adapter.suboperate.provider.SubRankListProvider$registerCourse$1$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 implements kotlinx.coroutines.flow.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SubRankListProvider f44606a;

        AnonymousClass1(SubRankListProvider subRankListProvider) {
            this.f44606a = subRankListProvider;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0091  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x007e -> B:10:0x008b). Please report as a decompilation issue!!! */
        @Override // kotlinx.coroutines.flow.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(com.transsion.edcation.bean.CourseBean r13, kotlin.coroutines.Continuation r14) {
            /*
                r12 = this;
                boolean r0 = r14 instanceof com.transsion.home.adapter.suboperate.provider.SubRankListProvider$registerCourse$1$1$emit$1
                if (r0 == 0) goto L13
                r0 = r14
                com.transsion.home.adapter.suboperate.provider.SubRankListProvider$registerCourse$1$1$emit$1 r0 = (com.transsion.home.adapter.suboperate.provider.SubRankListProvider$registerCourse$1$1$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.transsion.home.adapter.suboperate.provider.SubRankListProvider$registerCourse$1$1$emit$1 r0 = new com.transsion.home.adapter.suboperate.provider.SubRankListProvider$registerCourse$1$1$emit$1
                r0.<init>(r12, r14)
            L18:
                java.lang.Object r14 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L45
                if (r2 != r3) goto L3d
                int r13 = r0.I$1
                int r2 = r0.I$0
                java.lang.Object r4 = r0.L$3
                java.util.Iterator r4 = (java.util.Iterator) r4
                java.lang.Object r5 = r0.L$2
                java.util.Iterator r5 = (java.util.Iterator) r5
                java.lang.Object r6 = r0.L$1
                com.transsion.home.adapter.suboperate.provider.SubRankListProvider r6 = (com.transsion.home.adapter.suboperate.provider.SubRankListProvider) r6
                java.lang.Object r7 = r0.L$0
                com.transsion.edcation.bean.CourseBean r7 = (com.transsion.edcation.bean.CourseBean) r7
                kotlin.ResultKt.b(r14)
                goto L8b
            L3d:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r14)
                throw r13
            L45:
                kotlin.ResultKt.b(r14)
                com.transsion.home.adapter.suboperate.provider.SubRankListProvider r14 = r12.f44606a
                com.transsion.home.bean.OperateItem r14 = com.transsion.home.adapter.suboperate.provider.SubRankListProvider.B(r14)
                if (r14 == 0) goto Ld6
                com.transsion.home.bean.RankingListData r14 = r14.getRankingListData()
                if (r14 == 0) goto Ld6
                java.util.List r14 = r14.getItems()
                if (r14 == 0) goto Ld6
                java.lang.Iterable r14 = (java.lang.Iterable) r14
                com.transsion.home.adapter.suboperate.provider.SubRankListProvider r2 = r12.f44606a
                java.util.Iterator r14 = r14.iterator()
                r4 = 0
            L65:
                boolean r5 = r14.hasNext()
                if (r5 == 0) goto Ld6
                java.lang.Object r5 = r14.next()
                int r6 = r4 + 1
                if (r4 >= 0) goto L76
                kotlin.collections.CollectionsKt.u()
            L76:
                com.transsion.home.bean.RankingListItem r5 = (com.transsion.home.bean.RankingListItem) r5
                java.util.List r5 = r5.getSubjects()
                if (r5 == 0) goto Ld4
                java.lang.Iterable r5 = (java.lang.Iterable) r5
                java.util.Iterator r5 = r5.iterator()
                r7 = r13
                r13 = r4
                r4 = r5
                r5 = r14
                r11 = r6
                r6 = r2
                r2 = r11
            L8b:
                boolean r14 = r4.hasNext()
                if (r14 == 0) goto Lcf
                java.lang.Object r14 = r4.next()
                com.transsion.moviedetailapi.bean.Subject r14 = (com.transsion.moviedetailapi.bean.Subject) r14
                java.lang.String r8 = r7.getSubjectId()
                java.lang.String r9 = r14.getSubjectId()
                boolean r8 = kotlin.jvm.internal.Intrinsics.c(r8, r9)
                if (r8 == 0) goto L8b
                int r8 = r7.getSeenStatus()
                java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.d(r8)
                r14.setSeenStatus(r8)
                kotlinx.coroutines.a2 r8 = kotlinx.coroutines.y0.c()
                com.transsion.home.adapter.suboperate.provider.SubRankListProvider$registerCourse$1$1$1$1$1 r9 = new com.transsion.home.adapter.suboperate.provider.SubRankListProvider$registerCourse$1$1$1$1$1
                r10 = 0
                r9.<init>(r6, r13, r14, r10)
                r0.L$0 = r7
                r0.L$1 = r6
                r0.L$2 = r5
                r0.L$3 = r4
                r0.I$0 = r2
                r0.I$1 = r13
                r0.label = r3
                java.lang.Object r14 = kotlinx.coroutines.i.g(r8, r9, r0)
                if (r14 != r1) goto L8b
                return r1
            Lcf:
                r4 = r2
                r14 = r5
                r2 = r6
                r13 = r7
                goto L65
            Ld4:
                r4 = r6
                goto L65
            Ld6:
                kotlin.Unit r13 = kotlin.Unit.f67184a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.adapter.suboperate.provider.SubRankListProvider$registerCourse$1.AnonymousClass1.emit(com.transsion.edcation.bean.CourseBean, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubRankListProvider$registerCourse$1(SubRankListProvider subRankListProvider, Continuation<? super SubRankListProvider$registerCourse$1> continuation) {
        super(2, continuation);
        this.this$0 = subRankListProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubRankListProvider$registerCourse$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SubRankListProvider$registerCourse$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            x0 k11 = CourseManager.f44139a.k();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0);
            this.label = 1;
            if (k11.a(anonymousClass1, this) == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
