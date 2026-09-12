package com.transsion.ugcvideodetail.viewmodel;

import androidx.view.b0;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCVideoDetailViewModel$getVideoPlayList$1", f = "UGCVideoDetailViewModel.kt", l = {393}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class UGCVideoDetailViewModel$getVideoPlayList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $collectionId;
    final /* synthetic */ int $endPosition;
    final /* synthetic */ boolean $isLoadDown;
    final /* synthetic */ int $startPosition;
    int label;
    final /* synthetic */ UGCVideoDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideoList;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCVideoDetailViewModel$getVideoPlayList$1$1", f = "UGCVideoDetailViewModel.kt", l = {378, 380, 385, 388}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: com.transsion.ugcvideodetail.viewmodel.UGCVideoDetailViewModel$getVideoPlayList$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.c, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ int $endPosition;
        final /* synthetic */ int $startPosition;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ UGCVideoDetailViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(UGCVideoDetailViewModel uGCVideoDetailViewModel, String str, int i11, int i12, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = uGCVideoDetailViewModel;
            this.$collectionId = str;
            this.$startPosition = i11;
            this.$endPosition = i12;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$collectionId, this.$startPosition, this.$endPosition, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(cVar, continuation)).invokeSuspend(Unit.f67184a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:46:0x00ce, code lost:
        
            if (r2 == null) goto L44;
         */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0103 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                Method dump skipped, instructions count: 263
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.viewmodel.UGCVideoDetailViewModel$getVideoPlayList$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideoList;", "", "e", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCVideoDetailViewModel$getVideoPlayList$1$2", f = "UGCVideoDetailViewModel.kt", l = {392}, m = "invokeSuspend")
    /* renamed from: com.transsion.ugcvideodetail.viewmodel.UGCVideoDetailViewModel$getVideoPlayList$1$2, reason: invalid class name */
    /* loaded from: classes6.dex */
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
    /* loaded from: classes6.dex */
    public static final class a implements kotlinx.coroutines.flow.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f56591a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f56592b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ UGCVideoDetailViewModel f56593c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f56594d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f56595e;

        a(boolean z10, int i11, UGCVideoDetailViewModel uGCVideoDetailViewModel, String str, int i12) {
            this.f56591a = z10;
            this.f56592b = i11;
            this.f56593c = uGCVideoDetailViewModel;
            this.f56594d = str;
            this.f56595e = i12;
        }

        @Override // kotlinx.coroutines.flow.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(UGCVideoList uGCVideoList, Continuation continuation) {
            b0 b0Var;
            Pager pager;
            Integer totalCount;
            b0 b0Var2;
            List<UGCVideo> items;
            int i11;
            int i12;
            int i13;
            int i14;
            int i15;
            int i16;
            List<UGCVideo> items2;
            if (uGCVideoList != null) {
                uGCVideoList.setLoadDown(this.f56591a);
            }
            int i17 = this.f56592b;
            if (uGCVideoList != null && (items2 = uGCVideoList.getItems()) != null) {
                Iterator<T> it = items2.iterator();
                while (it.hasNext()) {
                    ((UGCVideo) it.next()).setPlayListPosition(i17);
                    i17++;
                }
            }
            if (uGCVideoList != null && (items = uGCVideoList.getItems()) != null && !items.isEmpty()) {
                this.f56593c.A = this.f56594d;
                i11 = this.f56593c.B;
                if (i11 != 0) {
                    i14 = this.f56593c.C;
                    if (i14 != 0) {
                        UGCVideoDetailViewModel uGCVideoDetailViewModel = this.f56593c;
                        i15 = uGCVideoDetailViewModel.B;
                        uGCVideoDetailViewModel.B = Math.min(i15, this.f56592b);
                        UGCVideoDetailViewModel uGCVideoDetailViewModel2 = this.f56593c;
                        i16 = uGCVideoDetailViewModel2.C;
                        uGCVideoDetailViewModel2.C = Math.max(i16, this.f56595e);
                        a.C0856a c0856a = lg.a.f68962a;
                        String str = this.f56594d;
                        i12 = this.f56593c.B;
                        i13 = this.f56593c.C;
                        a.C0856a.f(c0856a, "UGCVideoDetailViewModel", "Updated loaded playList range: collectionId=" + str + ", range[" + i12 + "-" + i13 + "]", false, 4, null);
                    }
                }
                this.f56593c.B = this.f56592b;
                this.f56593c.C = this.f56595e;
                a.C0856a c0856a2 = lg.a.f68962a;
                String str2 = this.f56594d;
                i12 = this.f56593c.B;
                i13 = this.f56593c.C;
                a.C0856a.f(c0856a2, "UGCVideoDetailViewModel", "Updated loaded playList range: collectionId=" + str2 + ", range[" + i12 + "-" + i13 + "]", false, 4, null);
            }
            if (uGCVideoList != null && (pager = uGCVideoList.getPager()) != null && (totalCount = pager.getTotalCount()) != null) {
                UGCVideoDetailViewModel uGCVideoDetailViewModel3 = this.f56593c;
                int intValue = totalCount.intValue();
                b0Var2 = uGCVideoDetailViewModel3.f56582u;
                b0Var2.q(Boxing.d(intValue));
            }
            b0Var = this.f56593c.f56580s;
            b0Var.q(uGCVideoList);
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCVideoDetailViewModel$getVideoPlayList$1(UGCVideoDetailViewModel uGCVideoDetailViewModel, String str, int i11, int i12, boolean z10, Continuation<? super UGCVideoDetailViewModel$getVideoPlayList$1> continuation) {
        super(2, continuation);
        this.this$0 = uGCVideoDetailViewModel;
        this.$collectionId = str;
        this.$startPosition = i11;
        this.$endPosition = i12;
        this.$isLoadDown = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UGCVideoDetailViewModel$getVideoPlayList$1(this.this$0, this.$collectionId, this.$startPosition, this.$endPosition, this.$isLoadDown, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UGCVideoDetailViewModel$getVideoPlayList$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.b f12 = kotlinx.coroutines.flow.d.f(kotlinx.coroutines.flow.d.u(kotlinx.coroutines.flow.d.s(new AnonymousClass1(this.this$0, this.$collectionId, this.$startPosition, this.$endPosition, null)), y0.b()), new AnonymousClass2(null));
            a aVar = new a(this.$isLoadDown, this.$startPosition, this.this$0, this.$collectionId, this.$endPosition);
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
