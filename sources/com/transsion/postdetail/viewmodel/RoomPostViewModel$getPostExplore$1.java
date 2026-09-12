package com.transsion.postdetail.viewmodel;

import androidx.view.b0;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.vungle.ads.internal.protos.Sdk$SDKError;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.viewmodel.RoomPostViewModel$getPostExplore$1", f = "RoomPostViewModel.kt", l = {Sdk$SDKError.Reason.AD_IS_PLAYING_VALUE}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class RoomPostViewModel$getPostExplore$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $insertPostId;
    final /* synthetic */ boolean $isFirstLoad;
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ String $page;
    final /* synthetic */ int $perPage;
    int label;
    final /* synthetic */ RoomPostViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/moviedetailapi/bean/PostSubjectBean;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.postdetail.viewmodel.RoomPostViewModel$getPostExplore$1$1", f = "RoomPostViewModel.kt", l = {196, 198, 200}, m = "invokeSuspend")
    /* renamed from: com.transsion.postdetail.viewmodel.RoomPostViewModel$getPostExplore$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.c, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $insertPostId;
        final /* synthetic */ String $page;
        final /* synthetic */ int $perPage;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RoomPostViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RoomPostViewModel roomPostViewModel, String str, int i11, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = roomPostViewModel;
            this.$page = str;
            this.$perPage = i11;
            this.$insertPostId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$page, this.$perPage, this.$insertPostId, continuation);
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
            xo.c S;
            Object f11 = IntrinsicsKt.f();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                cVar = (kotlinx.coroutines.flow.c) this.L$0;
                S = this.this$0.S();
                String a11 = vg.a.f77447a.a();
                String str = this.$page;
                int i12 = this.$perPage;
                String str2 = this.$insertPostId;
                this.L$0 = cVar;
                this.label = 1;
                obj = S.a(a11, str, i12, 0.0f, 0.0f, str2, this);
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
            if (Intrinsics.c(baseDto.getCode(), "0")) {
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
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/moviedetailapi/bean/PostSubjectBean;", "", "it", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.postdetail.viewmodel.RoomPostViewModel$getPostExplore$1$2", f = "RoomPostViewModel.kt", l = {Sdk$SDKError.Reason.AD_ALREADY_LOADED_VALUE}, m = "invokeSuspend")
    /* renamed from: com.transsion.postdetail.viewmodel.RoomPostViewModel$getPostExplore$1$2, reason: invalid class name */
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
        final /* synthetic */ boolean f50299a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f50300b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ RoomPostViewModel f50301c;

        a(boolean z10, Ref.BooleanRef booleanRef, RoomPostViewModel roomPostViewModel) {
            this.f50299a = z10;
            this.f50300b = booleanRef;
            this.f50301c = roomPostViewModel;
        }

        @Override // kotlinx.coroutines.flow.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(PostSubjectBean postSubjectBean, Continuation continuation) {
            b0 b0Var;
            List<PostSubjectItem> items;
            List<PostSubjectItem> items2;
            long j11;
            long j12;
            if (this.f50299a && this.f50300b.element) {
                j11 = this.f50301c.f50297o;
                if (j11 > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j12 = this.f50301c.f50297o;
                    boolean z10 = currentTimeMillis - j12 <= 2000;
                    this.f50301c.f50297o = 0L;
                    a.C0856a.f(lg.a.f68962a, "RoomPostVM", "getPostExplore success--needRefreshBuiltIn:" + z10, false, 4, null);
                    this.f50300b.element = z10;
                }
            }
            a.C0856a.f(lg.a.f68962a, "RoomPostVM", "getPostExplore success--isRefreshNew:" + this.f50300b.element + ", size：" + ((postSubjectBean == null || (items2 = postSubjectBean.getItems()) == null) ? null : Boxing.d(items2.size())), false, 4, null);
            if (postSubjectBean != null) {
                postSubjectBean.setRefresh(this.f50300b.element);
            }
            b0Var = this.f50301c.f50287e;
            b0Var.n(postSubjectBean);
            if (postSubjectBean != null && (items = postSubjectBean.getItems()) != null) {
                com.transsion.postdetail.util.g.f50219a.b(items);
            }
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomPostViewModel$getPostExplore$1(boolean z10, RoomPostViewModel roomPostViewModel, boolean z11, String str, int i11, String str2, Continuation<? super RoomPostViewModel$getPostExplore$1> continuation) {
        super(2, continuation);
        this.$isFirstLoad = z10;
        this.this$0 = roomPostViewModel;
        this.$isRefresh = z11;
        this.$page = str;
        this.$perPage = i11;
        this.$insertPostId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RoomPostViewModel$getPostExplore$1(this.$isFirstLoad, this.this$0, this.$isRefresh, this.$page, this.$perPage, this.$insertPostId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((RoomPostViewModel$getPostExplore$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z10;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            if (this.$isFirstLoad) {
                com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
                String string = bVar.b().getString("room_cache_data", "");
                z10 = false;
                if (this.this$0.X()) {
                    String string2 = bVar.b().getString("post_explore_net_cache_exp", "");
                    String string3 = bVar.b().getString("post_explore_exposed_cache", "");
                    a.C0856a c0856a = lg.a.f68962a;
                    boolean z11 = !(string == null || string.length() == 0);
                    boolean z12 = !(string2 == null || string2.length() == 0);
                    boolean z13 = string3 == null || string3.length() == 0;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("getPostExplore  手动缓存：");
                    sb2.append(z11);
                    sb2.append(",网络缓存：");
                    sb2.append(z12);
                    sb2.append(",已曝光缓存：");
                    sb2.append(!z13);
                    a.C0856a.f(c0856a, "RoomPostVM", sb2.toString(), false, 4, null);
                    if ((string == null || string.length() == 0) && ((string2 == null || string2.length() == 0) && (string3 == null || string3.length() == 0))) {
                        z10 = this.$isRefresh;
                    }
                } else {
                    String string4 = bVar.b().getString("post_explore_net_cache", "");
                    a.C0856a c0856a2 = lg.a.f68962a;
                    boolean z14 = !(string == null || string.length() == 0);
                    boolean z15 = string4 == null || string4.length() == 0;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("getPostExplore  手动缓存：");
                    sb3.append(z14);
                    sb3.append(",网络缓存：");
                    sb3.append(!z15);
                    a.C0856a.f(c0856a2, "RoomPostVM", sb3.toString(), false, 4, null);
                    if ((string == null || string.length() == 0) && (string4 == null || string4.length() == 0)) {
                        z10 = this.$isRefresh;
                    }
                }
            } else {
                z10 = this.$isRefresh;
            }
            booleanRef.element = z10;
            kotlinx.coroutines.flow.b f12 = kotlinx.coroutines.flow.d.f(kotlinx.coroutines.flow.d.u(kotlinx.coroutines.flow.d.s(new AnonymousClass1(this.this$0, this.$page, this.$perPage, this.$insertPostId, null)), y0.b()), new AnonymousClass2(null));
            a aVar = new a(this.$isFirstLoad, booleanRef, this.this$0);
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
