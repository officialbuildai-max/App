package com.transsion.ugcvideodetail.viewmodel;

import androidx.view.b0;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import com.transsion.ugcvideodetail.api.bean.UGCContentList;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import com.transsion.ugcvideodetail.api.bean.UGCVideoList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import org.apache.tools.zip.UnixStat;
import rv.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getImmVideoRecommentList$1", f = "UGCImmVideoDetailViewModel.kt", l = {497}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class UGCImmVideoDetailViewModel$getImmVideoRecommentList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ String $ugcVideoId;
    int label;
    final /* synthetic */ UGCImmVideoDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/ugcvideodetail/api/bean/UGCContentList;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getImmVideoRecommentList$1$1", f = "UGCImmVideoDetailViewModel.kt", l = {UnixStat.DEFAULT_DIR_PERM, 494}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getImmVideoRecommentList$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.c, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isRefresh;
        final /* synthetic */ String $ugcVideoId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ UGCImmVideoDetailViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z10, UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$isRefresh = z10;
            this.this$0 = uGCImmVideoDetailViewModel;
            this.$ugcVideoId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$isRefresh, this.this$0, this.$ugcVideoId, continuation);
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
            rv.a F;
            String str;
            Object f11 = IntrinsicsKt.f();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                cVar = (kotlinx.coroutines.flow.c) this.L$0;
                if (this.$isRefresh) {
                    this.this$0.I = "";
                }
                F = this.this$0.F();
                String str2 = this.$ugcVideoId;
                String V0 = this.this$0.V0();
                str = this.this$0.I;
                String str3 = str == null ? "" : str;
                this.L$0 = cVar;
                this.label = 1;
                obj = a.C0938a.b(F, str2, V0, str3, 0, null, this, 24, null);
                if (obj == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Unit.f67184a;
                }
                cVar = (kotlinx.coroutines.flow.c) this.L$0;
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            Object data = baseDto.getData();
            if (!Intrinsics.c(baseDto.getCode(), "0")) {
                data = null;
            }
            this.L$0 = null;
            this.label = 2;
            if (cVar.emit(data, this) == f11) {
                return f11;
            }
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/c;", "Lcom/transsion/ugcvideodetail/api/bean/UGCContentList;", "", "it", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getImmVideoRecommentList$1$2", f = "UGCImmVideoDetailViewModel.kt", l = {496}, m = "invokeSuspend")
    /* renamed from: com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getImmVideoRecommentList$1$2, reason: invalid class name */
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
        final /* synthetic */ UGCImmVideoDetailViewModel f56548a;

        a(UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel) {
            this.f56548a = uGCImmVideoDetailViewModel;
        }

        @Override // kotlinx.coroutines.flow.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(UGCContentList uGCContentList, Continuation continuation) {
            UGCVideoList uGCVideoList;
            b0 b0Var;
            b0 b0Var2;
            List<UGCVideo> items;
            List<UGCContent> items2;
            Pager pager;
            String nextPage;
            List<UGCVideo> items3;
            UGCVideoBelongToCollection belongToCollection;
            String collectionId;
            Integer videoNum;
            UGCVideoList uGCVideoList2;
            if (uGCContentList != null) {
                UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel = this.f56548a;
                List<UGCContent> items4 = uGCContentList.getItems();
                if (items4 != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : items4) {
                        if (Intrinsics.c(((UGCContent) obj).getTopicType(), "UGC_VIDEO")) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        UGCVideo video = ((UGCContent) it.next()).getVideo();
                        if (video != null) {
                            String ops = video.getOps();
                            if (ops == null || ops.length() == 0) {
                                video.setOps(uGCImmVideoDetailViewModel.W0());
                            }
                        } else {
                            video = null;
                        }
                        if (video != null) {
                            arrayList2.add(video);
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        arrayList2 = null;
                    }
                    if (arrayList2 != null) {
                        uGCVideoList2 = new UGCVideoList(CollectionsKt.U0(arrayList2), uGCContentList.getPager());
                        uGCVideoList = uGCVideoList2;
                    }
                }
                uGCVideoList2 = null;
                uGCVideoList = uGCVideoList2;
            } else {
                uGCVideoList = null;
            }
            b0Var = this.f56548a.W;
            Map map = (Map) b0Var.f();
            if (map == null) {
                map = new LinkedHashMap();
            }
            if (uGCVideoList != null && (items3 = uGCVideoList.getItems()) != null) {
                for (UGCVideo uGCVideo : items3) {
                    if (uGCVideo.getBelongToCollection() != null && (belongToCollection = uGCVideo.getBelongToCollection()) != null && (collectionId = belongToCollection.getCollectionId()) != null) {
                        UGCVideoBelongToCollection belongToCollection2 = uGCVideo.getBelongToCollection();
                        map.put(collectionId, Boxing.d((belongToCollection2 == null || (videoNum = belongToCollection2.getVideoNum()) == null) ? 1 : videoNum.intValue()));
                    }
                }
            }
            b0Var2 = this.f56548a.W;
            b0Var2.q(map);
            if (uGCContentList != null && (pager = uGCContentList.getPager()) != null && (nextPage = pager.getNextPage()) != null) {
                this.f56548a.I = nextPage;
            }
            a.C0856a.f(lg.a.f68962a, "UGCImmVideoDetailViewModel", "getImmVideoRecommentList,success:" + ((uGCContentList == null || (items2 = uGCContentList.getItems()) == null) ? null : Boxing.d(items2.size())) + ", videoList size:" + ((uGCVideoList == null || (items = uGCVideoList.getItems()) == null) ? null : Boxing.d(items.size())) + " ", false, 4, null);
            UGCImmVideoDetailViewModel.G0(this.f56548a, false, uGCVideoList, 0, false, uGCContentList != null ? uGCContentList.getPager() : null, 12, null);
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCImmVideoDetailViewModel$getImmVideoRecommentList$1(boolean z10, UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel, String str, Continuation<? super UGCImmVideoDetailViewModel$getImmVideoRecommentList$1> continuation) {
        super(2, continuation);
        this.$isRefresh = z10;
        this.this$0 = uGCImmVideoDetailViewModel;
        this.$ugcVideoId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UGCImmVideoDetailViewModel$getImmVideoRecommentList$1(this.$isRefresh, this.this$0, this.$ugcVideoId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UGCImmVideoDetailViewModel$getImmVideoRecommentList$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.b f12 = kotlinx.coroutines.flow.d.f(kotlinx.coroutines.flow.d.u(kotlinx.coroutines.flow.d.s(new AnonymousClass1(this.$isRefresh, this.this$0, this.$ugcVideoId, null)), y0.b()), new AnonymousClass2(null));
            a aVar = new a(this.this$0);
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
