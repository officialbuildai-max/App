package com.transsion.moviedetail.fragment;

import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
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
@DebugMetadata(c = "com.transsion.moviedetail.fragment.SubjectListFragment$insertLast$1", f = "SubjectListFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class SubjectListFragment$insertLast$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<PostSubjectItem> $dataList;
    int label;
    final /* synthetic */ SubjectListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.moviedetail.fragment.SubjectListFragment$insertLast$1$2", f = "SubjectListFragment.kt", l = {1174}, m = "invokeSuspend")
    /* renamed from: com.transsion.moviedetail.fragment.SubjectListFragment$insertLast$1$2, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SubjectListFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SubjectListFragment subjectListFragment, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = subjectListFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            BiddingNativeManager biddingNativeManager;
            Object f11 = IntrinsicsKt.f();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                biddingNativeManager = this.this$0.nativeManager;
                if (biddingNativeManager != null) {
                    this.label = 1;
                    if (AbsAdBidding.w0(biddingNativeManager, 0, false, this, 3, null) == f11) {
                        return f11;
                    }
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

    /* loaded from: classes6.dex */
    public static final class a extends di.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SubjectListFragment f47145d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f47146e;

        a(SubjectListFragment subjectListFragment, List list) {
            this.f47145d = subjectListFragment;
            this.f47146e = list;
        }

        @Override // di.a
        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
        }

        @Override // di.a
        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            BiddingNativeManager biddingNativeManager;
            BiddingListManager biddingListManager;
            BiddingListManager biddingListManager2;
            Function2 r11;
            super.j(biddingIntermediateMaterialBean);
            biddingNativeManager = this.f47145d.nativeManager;
            if (biddingNativeManager != null) {
                SubjectListFragment subjectListFragment = this.f47145d;
                List list = this.f47146e;
                biddingListManager = subjectListFragment.middleListManager;
                if (biddingListManager != null && (r11 = biddingListManager.r()) != null) {
                }
                biddingListManager2 = subjectListFragment.middleListManager;
                if (biddingListManager2 != null) {
                    biddingListManager2.D(null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubjectListFragment$insertLast$1(SubjectListFragment subjectListFragment, List<PostSubjectItem> list, Continuation<? super SubjectListFragment$insertLast$1> continuation) {
        super(2, continuation);
        this.this$0 = subjectListFragment;
        this.$dataList = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubjectListFragment$insertLast$1(this.this$0, this.$dataList, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SubjectListFragment$insertLast$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BiddingNativeManager biddingNativeManager;
        BiddingNativeManager biddingNativeManager2;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.this$0.nativeManager = new BiddingNativeManager();
        biddingNativeManager = this.this$0.nativeManager;
        if (biddingNativeManager != null) {
            biddingNativeManager.O0("SubjectDetailRecommendScene");
        }
        biddingNativeManager2 = this.this$0.nativeManager;
        if (biddingNativeManager2 != null) {
            biddingNativeManager2.N0(new a(this.this$0, this.$dataList));
        }
        kotlinx.coroutines.k.d(androidx.view.v.a(this.this$0), null, null, new AnonymousClass2(this.this$0, null), 3, null);
        return Unit.f67184a;
    }
}
