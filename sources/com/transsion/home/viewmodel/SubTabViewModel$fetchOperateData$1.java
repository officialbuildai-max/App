package com.transsion.home.viewmodel;

import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.SubOperateData;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.r0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.SubTabViewModel$fetchOperateData$1", f = "SubTabViewModel.kt", l = {72}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class SubTabViewModel$fetchOperateData$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $grade;
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ Ref.ObjectRef<SubOperateData> $operateData;
    final /* synthetic */ int $tabId;
    int label;
    final /* synthetic */ SubTabViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.home.viewmodel.SubTabViewModel$fetchOperateData$1$1", f = "SubTabViewModel.kt", l = {76}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: com.transsion.home.viewmodel.SubTabViewModel$fetchOperateData$1$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $grade;
        final /* synthetic */ boolean $isRefresh;
        final /* synthetic */ Ref.ObjectRef<SubOperateData> $operateData;
        final /* synthetic */ int $tabId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SubTabViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.ObjectRef<SubOperateData> objectRef, SubTabViewModel subTabViewModel, int i11, boolean z10, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$operateData = objectRef;
            this.this$0 = subTabViewModel;
            this.$tabId = i11;
            this.$isRefresh = z10;
            this.$grade = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$operateData, this.this$0, this.$tabId, this.$isRefresh, this.$grade, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            r0 b11;
            Ref.ObjectRef<SubOperateData> objectRef;
            T t11;
            List<OperateItem> items;
            List I0;
            Object f11 = IntrinsicsKt.f();
            int i11 = this.label;
            List<OperateItem> list = null;
            if (i11 == 0) {
                ResultKt.b(obj);
                b11 = kotlinx.coroutines.k.b((n0) this.L$0, null, null, new SubTabViewModel$fetchOperateData$1$1$operationTask$1(this.this$0, this.$tabId, this.$grade, null), 3, null);
                Ref.ObjectRef<SubOperateData> objectRef2 = this.$operateData;
                this.L$0 = objectRef2;
                this.label = 1;
                Object i12 = b11.i(this);
                if (i12 == f11) {
                    return f11;
                }
                objectRef = objectRef2;
                t11 = i12;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) this.L$0;
                ResultKt.b(obj);
                t11 = obj;
            }
            objectRef.element = t11;
            SubOperateData subOperateData = this.$operateData.element;
            SubOperateData subOperateData2 = subOperateData;
            if (subOperateData2 != null) {
                SubOperateData subOperateData3 = subOperateData;
                if (subOperateData3 != null && (items = subOperateData3.getItems()) != null && (I0 = CollectionsKt.I0(items, new Comparator() { // from class: com.transsion.home.viewmodel.SubTabViewModel$fetchOperateData$1$1$invokeSuspend$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t12, T t13) {
                        return ComparisonsKt.d(((OperateItem) t12).getPosition(), ((OperateItem) t13).getPosition());
                    }
                })) != null) {
                    list = CollectionsKt.U0(I0);
                }
                subOperateData2.setItems(list);
            }
            this.this$0.u(this.$operateData.element);
            this.this$0.v(this.$tabId, this.$operateData.element);
            if (this.$isRefresh) {
                this.this$0.q().n(this.$operateData.element);
                this.this$0.f45887f = 1;
            } else {
                this.this$0.p().n(this.$operateData.element);
            }
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubTabViewModel$fetchOperateData$1(boolean z10, SubTabViewModel subTabViewModel, Ref.ObjectRef<SubOperateData> objectRef, int i11, String str, Continuation<? super SubTabViewModel$fetchOperateData$1> continuation) {
        super(2, continuation);
        this.$isRefresh = z10;
        this.this$0 = subTabViewModel;
        this.$operateData = objectRef;
        this.$tabId = i11;
        this.$grade = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubTabViewModel$fetchOperateData$1(this.$isRefresh, this.this$0, this.$operateData, this.$tabId, this.$grade, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SubTabViewModel$fetchOperateData$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List<OperateItem> items;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$operateData, this.this$0, this.$tabId, this.$isRefresh, this.$grade, null);
                this.label = 1;
                if (l2.c(anonymousClass1, this) == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            lg.a.f68962a.i("SubTabFragment", "exceptionHandler " + e11.getMessage(), true);
            if (this.$isRefresh) {
                this.this$0.q().n(null);
            } else {
                SubOperateData subOperateData = this.$operateData.element;
                if (((subOperateData == null || (items = subOperateData.getItems()) == null) ? 0 : items.size()) > 0) {
                    this.this$0.p().n(this.$operateData.element);
                } else {
                    this.this$0.p().n(null);
                }
            }
        }
        return Unit.f67184a;
    }
}
