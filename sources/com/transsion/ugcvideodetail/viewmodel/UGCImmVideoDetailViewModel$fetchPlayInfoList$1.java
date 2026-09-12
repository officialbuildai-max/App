package com.transsion.ugcvideodetail.viewmodel;

import androidx.view.b0;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.ugcvideodetail.api.bean.UGCImmVideo;
import com.transsion.ugcvideodetail.api.bean.UGCImmVideoContent;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoList;
import com.transsion.ugcvideodetail.api.bean.UGCVideoPlayInfo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoPlayInfoList;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$fetchPlayInfoList$1", f = "UGCImmVideoDetailViewModel.kt", l = {582}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class UGCImmVideoDetailViewModel$fetchPlayInfoList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isCollectionList;
    final /* synthetic */ boolean $isLoadDown;
    final /* synthetic */ Pager $pager;
    final /* synthetic */ int $startPosition;
    final /* synthetic */ UGCVideoList $videoData;
    int label;
    final /* synthetic */ UGCImmVideoDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideoPlayInfoList;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$fetchPlayInfoList$1$1", f = "UGCImmVideoDetailViewModel.kt", l = {541, 543, 548, 577}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$fetchPlayInfoList$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.c, Continuation<? super Unit>, Object> {
        final /* synthetic */ UGCVideoList $videoData;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ UGCImmVideoDetailViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel, UGCVideoList uGCVideoList, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = uGCImmVideoDetailViewModel;
            this.$videoData = uGCVideoList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$videoData, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(cVar, continuation)).invokeSuspend(Unit.f67184a);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x010d  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0136  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0141  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0164  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0144  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0139  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0193  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00e4  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x01f2  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x020a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0196  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0112  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00ee -> B:34:0x017a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0106 -> B:11:0x0109). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r27) {
            /*
                Method dump skipped, instructions count: 537
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$fetchPlayInfoList$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideoPlayInfoList;", "", "it", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$fetchPlayInfoList$1$2", f = "UGCImmVideoDetailViewModel.kt", l = {581}, m = "invokeSuspend")
    /* renamed from: com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$fetchPlayInfoList$1$2, reason: invalid class name */
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
        final /* synthetic */ UGCVideoList f56536a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f56537b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f56538c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ UGCImmVideoDetailViewModel f56539d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f56540e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Pager f56541f;

        a(UGCVideoList uGCVideoList, int i11, boolean z10, UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel, boolean z11, Pager pager) {
            this.f56536a = uGCVideoList;
            this.f56537b = i11;
            this.f56538c = z10;
            this.f56539d = uGCImmVideoDetailViewModel;
            this.f56540e = z11;
            this.f56541f = pager;
        }

        @Override // kotlinx.coroutines.flow.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(UGCVideoPlayInfoList uGCVideoPlayInfoList, Continuation continuation) {
            b0 b0Var;
            List<UGCVideoPlayInfo> list;
            List<UGCVideoPlayInfo> items = uGCVideoPlayInfoList != null ? uGCVideoPlayInfoList.getItems() : null;
            UGCVideoList uGCVideoList = this.f56536a;
            List<UGCVideo> items2 = uGCVideoList != null ? uGCVideoList.getItems() : null;
            ArrayList arrayList = new ArrayList();
            List<UGCVideo> list2 = items2;
            if (list2 != null && !list2.isEmpty() && (list = items) != null && !list.isEmpty()) {
                List<UGCVideoPlayInfo> list3 = items;
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.e(CollectionsKt.v(list3, 10)), 16));
                for (Object obj : list3) {
                    linkedHashMap.put(((UGCVideoPlayInfo) obj).getUgcVideoId(), obj);
                }
                int i11 = this.f56537b;
                a.C0856a.f(lg.a.f68962a, "UGCImmVideoDetailViewModel", "fetchPlayInfoList,isCollectionList:" + this.f56538c + ", startPos:" + i11 + ", endPos:" + (items2.size() + i11) + " ", false, 4, null);
                boolean z10 = this.f56538c;
                for (UGCVideo uGCVideo : items2) {
                    UGCVideoPlayInfo uGCVideoPlayInfo = (UGCVideoPlayInfo) linkedHashMap.get(uGCVideo.getUgcVideoId());
                    UGCImmVideo uGCImmVideo = new UGCImmVideo(uGCVideo, uGCVideoPlayInfo);
                    uGCImmVideo.setDownloadStatus(uGCVideoPlayInfo != null ? uGCVideoPlayInfo.getDownloadStatus() : 0);
                    uGCImmVideo.setCollectionList(z10);
                    arrayList.add(uGCImmVideo);
                }
            }
            b0Var = this.f56539d.Y;
            b0Var.q(arrayList.isEmpty() ? null : new UGCImmVideoContent(arrayList, this.f56540e, this.f56541f));
            if (this.f56538c && !arrayList.isEmpty()) {
                this.f56539d.E0(arrayList, this.f56540e);
            }
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCImmVideoDetailViewModel$fetchPlayInfoList$1(UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel, UGCVideoList uGCVideoList, int i11, boolean z10, boolean z11, Pager pager, Continuation<? super UGCImmVideoDetailViewModel$fetchPlayInfoList$1> continuation) {
        super(2, continuation);
        this.this$0 = uGCImmVideoDetailViewModel;
        this.$videoData = uGCVideoList;
        this.$startPosition = i11;
        this.$isCollectionList = z10;
        this.$isLoadDown = z11;
        this.$pager = pager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UGCImmVideoDetailViewModel$fetchPlayInfoList$1(this.this$0, this.$videoData, this.$startPosition, this.$isCollectionList, this.$isLoadDown, this.$pager, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UGCImmVideoDetailViewModel$fetchPlayInfoList$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.b f12 = kotlinx.coroutines.flow.d.f(kotlinx.coroutines.flow.d.u(kotlinx.coroutines.flow.d.s(new AnonymousClass1(this.this$0, this.$videoData, null)), y0.b()), new AnonymousClass2(null));
            a aVar = new a(this.$videoData, this.$startPosition, this.$isCollectionList, this.this$0, this.$isLoadDown, this.$pager);
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
