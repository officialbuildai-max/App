package com.transsion.postdetail.ui.fragment;

import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.ui.fragment.RoomPostExploreFragment$saveExposedDataCache$1", f = "RoomPostExploreFragment.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class RoomPostExploreFragment$saveExposedDataCache$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<PostSubjectItem> $data;
    final /* synthetic */ int $maxCount;
    int label;
    final /* synthetic */ RoomPostExploreFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomPostExploreFragment$saveExposedDataCache$1(List<PostSubjectItem> list, RoomPostExploreFragment roomPostExploreFragment, int i11, Continuation<? super RoomPostExploreFragment$saveExposedDataCache$1> continuation) {
        super(2, continuation);
        this.$data = list;
        this.this$0 = roomPostExploreFragment;
        this.$maxCount = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RoomPostExploreFragment$saveExposedDataCache$1(this.$data, this.this$0, this.$maxCount, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((RoomPostExploreFragment$saveExposedDataCache$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean isNewCacheStrategy;
        List L0;
        int i11;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        List<PostSubjectItem> list = this.$data;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            PostSubjectItem postSubjectItem = (PostSubjectItem) obj2;
            if (!postSubjectItem.getBuiltIn() && !postSubjectItem.isRoomCache()) {
                arrayList.add(obj2);
            }
        }
        isNewCacheStrategy = this.this$0.isNewCacheStrategy();
        int i12 = 0;
        if (isNewCacheStrategy) {
            int size = arrayList.size() - (arrayList.size() <= 8 ? arrayList.size() : 8);
            L0 = size <= 0 ? CollectionsKt.l() : arrayList.subList(RangesKt.f(size - this.$maxCount, 0), size);
        } else {
            L0 = CollectionsKt.L0(arrayList, this.$maxCount);
        }
        a.C0856a c0856a = lg.a.f68962a;
        String tag = this.this$0.getTAG();
        int size2 = this.$data.size();
        int size3 = arrayList.size();
        int size4 = L0.size();
        List<PostSubjectItem> list2 = this.$data;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            i11 = 0;
        } else {
            Iterator<T> it = list2.iterator();
            i11 = 0;
            while (it.hasNext()) {
                if (((PostSubjectItem) it.next()).getBuiltIn() && (i11 = i11 + 1) < 0) {
                    CollectionsKt.t();
                }
            }
        }
        List<PostSubjectItem> list3 = this.$data;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator<T> it2 = list3.iterator();
            while (it2.hasNext()) {
                if (((PostSubjectItem) it2.next()).isRoomCache() && (i12 = i12 + 1) < 0) {
                    CollectionsKt.t();
                }
            }
        }
        a.C0856a.f(c0856a, tag, "saveExposedDataCache, 总条数:" + size2 + ", 过滤后:" + size3 + ", 实际保存:" + size4 + " (builtIn:" + i11 + ", isRoomCache:" + i12 + ")", false, 4, null);
        if (L0.isEmpty()) {
            com.transsion.baselib.report.launch.b.f43424a.b().M("post_explore_exposed_cache");
            return Unit.f67184a;
        }
        com.transsion.baselib.report.launch.b.f43424a.b().putString("post_explore_exposed_cache", com.blankj.utilcode.util.o.j(new PostSubjectBean(CollectionsKt.U0(L0), null, null, null)));
        return Unit.f67184a;
    }
}
