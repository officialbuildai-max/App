package com.transsion.ugcvideodetail.viewmodel;

import androidx.view.b0;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.ugcvideodetail.api.bean.UGCImmVideo;
import com.transsion.ugcvideodetail.api.bean.UGCImmVideoContent;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import com.transsion.ugcvideodetail.api.bean.UGCVideoList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getImmVideoList$1", f = "UGCImmVideoDetailViewModel.kt", l = {424}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class UGCImmVideoDetailViewModel$getImmVideoList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $collectionId;
    final /* synthetic */ int $endPosition;
    final /* synthetic */ boolean $isLoadDown;
    final /* synthetic */ int $startPosition;
    final /* synthetic */ boolean $withoutPlayInfo;
    int label;
    final /* synthetic */ UGCImmVideoDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideoList;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getImmVideoList$1$1", f = "UGCImmVideoDetailViewModel.kt", l = {TTAdConstant.DOWNLOAD_APP_INFO_CODE, TTAdConstant.IMAGE_LIST_CODE, TTAdConstant.VIDEO_COVER_URL_CODE, 419}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getImmVideoList$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.c, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ int $endPosition;
        final /* synthetic */ int $startPosition;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ UGCImmVideoDetailViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel, String str, int i11, int i12, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = uGCImmVideoDetailViewModel;
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
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getImmVideoList$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideoList;", "", "it", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getImmVideoList$1$2", f = "UGCImmVideoDetailViewModel.kt", l = {423}, m = "invokeSuspend")
    /* renamed from: com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getImmVideoList$1$2, reason: invalid class name */
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
        final /* synthetic */ boolean f56542a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f56543b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ UGCImmVideoDetailViewModel f56544c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f56545d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f56546e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f56547f;

        a(boolean z10, int i11, UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel, String str, int i12, boolean z11) {
            this.f56542a = z10;
            this.f56543b = i11;
            this.f56544c = uGCImmVideoDetailViewModel;
            this.f56545d = str;
            this.f56546e = i12;
            this.f56547f = z11;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v4, types: [com.transsion.ugcvideodetail.api.bean.UGCImmVideoContent] */
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
            b0 b0Var3;
            UGCVideoBelongToCollection belongToCollection;
            UGCVideo ugcVideo;
            UGCVideoBelongToCollection belongToCollection2;
            if (uGCVideoList != null) {
                uGCVideoList.setLoadDown(this.f56542a);
            }
            int i17 = this.f56543b;
            if (uGCVideoList != null && (items2 = uGCVideoList.getItems()) != null) {
                UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel = this.f56544c;
                String str = this.f56545d;
                for (UGCVideo uGCVideo : items2) {
                    uGCVideo.setPlayListPosition(i17);
                    String ops = uGCVideo.getOps();
                    if (ops == null || ops.length() == 0) {
                        uGCVideo.setOps(uGCImmVideoDetailViewModel.W0());
                    }
                    b0Var3 = uGCImmVideoDetailViewModel.f56534b0;
                    UGCImmVideo uGCImmVideo = (UGCImmVideo) b0Var3.f();
                    if (uGCVideo.getBelongToCollection() == null) {
                        if (Intrinsics.c((uGCImmVideo == null || (ugcVideo = uGCImmVideo.getUgcVideo()) == null || (belongToCollection2 = ugcVideo.getBelongToCollection()) == null) ? null : belongToCollection2.getCollectionId(), str)) {
                            UGCVideo ugcVideo2 = uGCImmVideo.getUgcVideo();
                            UGCVideoBelongToCollection a11 = (ugcVideo2 == null || (belongToCollection = ugcVideo2.getBelongToCollection()) == null) ? null : ov.e.a(belongToCollection);
                            if (a11 != null) {
                                a11.setPosition(Boxing.d(i17));
                            }
                            uGCVideo.setBelongToCollection(a11);
                        }
                    }
                    i17++;
                }
            }
            if (uGCVideoList != null && (items = uGCVideoList.getItems()) != null && !items.isEmpty()) {
                this.f56544c.M = this.f56545d;
                i11 = this.f56544c.N;
                if (i11 != 0) {
                    i14 = this.f56544c.O;
                    if (i14 != 0) {
                        UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel2 = this.f56544c;
                        i15 = uGCImmVideoDetailViewModel2.N;
                        uGCImmVideoDetailViewModel2.N = Math.min(i15, this.f56543b);
                        UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel3 = this.f56544c;
                        i16 = uGCImmVideoDetailViewModel3.O;
                        uGCImmVideoDetailViewModel3.O = Math.max(i16, this.f56546e);
                        a.C0856a c0856a = lg.a.f68962a;
                        String str2 = this.f56545d;
                        i12 = this.f56544c.N;
                        i13 = this.f56544c.O;
                        a.C0856a.f(c0856a, "UGCImmVideoDetailViewModel", "Updated loaded playList range: collectionId=" + str2 + ", range[" + i12 + "-" + i13 + "]", false, 4, null);
                    }
                }
                this.f56544c.N = this.f56543b;
                this.f56544c.O = this.f56546e;
                a.C0856a c0856a2 = lg.a.f68962a;
                String str22 = this.f56545d;
                i12 = this.f56544c.N;
                i13 = this.f56544c.O;
                a.C0856a.f(c0856a2, "UGCImmVideoDetailViewModel", "Updated loaded playList range: collectionId=" + str22 + ", range[" + i12 + "-" + i13 + "]", false, 4, null);
            }
            if (uGCVideoList != null && (pager = uGCVideoList.getPager()) != null && (totalCount = pager.getTotalCount()) != null) {
                UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel4 = this.f56544c;
                String str3 = this.f56545d;
                int intValue = totalCount.intValue();
                b0Var2 = uGCImmVideoDetailViewModel4.W;
                b0Var2.q(MapsKt.m(TuplesKt.a(str3, Boxing.d(intValue))));
            }
            if (this.f56547f) {
                ArrayList arrayList = new ArrayList();
                List<UGCVideo> items3 = uGCVideoList != null ? uGCVideoList.getItems() : null;
                List<UGCVideo> list = items3;
                if (list != null && !list.isEmpty()) {
                    Iterator it = items3.iterator();
                    while (it.hasNext()) {
                        UGCImmVideo uGCImmVideo2 = new UGCImmVideo((UGCVideo) it.next(), null);
                        uGCImmVideo2.setCollectionList(true);
                        uGCImmVideo2.getIsCollectionList();
                        arrayList.add(uGCImmVideo2);
                    }
                }
                b0Var = this.f56544c.Y;
                b0Var.q(arrayList.isEmpty() ? null : new UGCImmVideoContent(arrayList, this.f56542a, uGCVideoList != null ? uGCVideoList.getPager() : null));
            } else {
                this.f56544c.F0(true, uGCVideoList, this.f56543b, this.f56542a, uGCVideoList != null ? uGCVideoList.getPager() : null);
            }
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCImmVideoDetailViewModel$getImmVideoList$1(UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel, String str, int i11, int i12, boolean z10, boolean z11, Continuation<? super UGCImmVideoDetailViewModel$getImmVideoList$1> continuation) {
        super(2, continuation);
        this.this$0 = uGCImmVideoDetailViewModel;
        this.$collectionId = str;
        this.$startPosition = i11;
        this.$endPosition = i12;
        this.$isLoadDown = z10;
        this.$withoutPlayInfo = z11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UGCImmVideoDetailViewModel$getImmVideoList$1(this.this$0, this.$collectionId, this.$startPosition, this.$endPosition, this.$isLoadDown, this.$withoutPlayInfo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UGCImmVideoDetailViewModel$getImmVideoList$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.b f12 = kotlinx.coroutines.flow.d.f(kotlinx.coroutines.flow.d.u(kotlinx.coroutines.flow.d.s(new AnonymousClass1(this.this$0, this.$collectionId, this.$startPosition, this.$endPosition, null)), y0.b()), new AnonymousClass2(null));
            a aVar = new a(this.$isLoadDown, this.$startPosition, this.this$0, this.$collectionId, this.$endPosition, this.$withoutPlayInfo);
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
