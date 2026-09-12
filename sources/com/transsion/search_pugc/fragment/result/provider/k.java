package com.transsion.search_pugc.fragment.result.provider;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.search.R$layout;
import com.transsion.search_pugc.bean.SearchResultItem;
import com.transsion.search_pugc.constant.ResultCollectItemWrapper;
import com.transsion.search_pugc.constant.SearchType;
import com.transsion.ugcvideodetail.api.bean.UGCCollection;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class k extends BaseItemProvider implements t {

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ t f52498e;

    /* renamed from: f, reason: collision with root package name */
    private final Lazy f52499f;

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f52500g;

    /* renamed from: h, reason: collision with root package name */
    private final float f52501h;

    public k(t reportable) {
        Intrinsics.h(reportable, "reportable");
        this.f52498e = reportable;
        this.f52499f = LazyKt.b(new Function0() { // from class: com.transsion.search_pugc.fragment.result.provider.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int N;
                N = k.N();
                return Integer.valueOf(N);
            }
        });
        this.f52500g = LazyKt.b(new Function0() { // from class: com.transsion.search_pugc.fragment.result.provider.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int M;
                M = k.M();
                return Integer.valueOf(M);
            }
        });
        this.f52501h = 0.95f;
    }

    private final void E(final View view, int i11, int i12) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i11, i12);
        ofInt.setDuration(200L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.transsion.search_pugc.fragment.result.provider.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                k.F(view, valueAnimator);
            }
        });
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(View view, ValueAnimator animation) {
        Intrinsics.h(animation, "animation");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.n nVar = (RecyclerView.n) layoutParams;
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.f(animatedValue, "null cannot be cast to non-null type kotlin.Number");
        ((ViewGroup.MarginLayoutParams) nVar).width = ((Number) animatedValue).intValue();
        view.setLayoutParams(nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(com.transsion.search_pugc.fragment.result.adapter.a aVar, k kVar, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        UGCVideo a11 = ((ResultCollectItemWrapper) aVar.getData().get(i11)).a();
        if (a11 != null) {
            com.transsion.search_pugc.constant.a.g(a11, true);
            kVar.c(a11, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
    
        if (r2 != 3) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean I(com.transsion.search_pugc.fragment.result.provider.FooterStretchRecyclerView r6, com.transsion.search_pugc.fragment.result.adapter.a r7, kotlin.jvm.internal.Ref.FloatRef r8, kotlin.jvm.internal.Ref.BooleanRef r9, com.transsion.search_pugc.fragment.result.provider.k r10, com.transsion.search_pugc.bean.SearchResultItem r11, com.chad.library.adapter.base.viewholder.BaseViewHolder r12, android.view.View r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.search_pugc.fragment.result.provider.k.I(com.transsion.search_pugc.fragment.result.provider.FooterStretchRecyclerView, com.transsion.search_pugc.fragment.result.adapter.a, kotlin.jvm.internal.Ref$FloatRef, kotlin.jvm.internal.Ref$BooleanRef, com.transsion.search_pugc.fragment.result.provider.k, com.transsion.search_pugc.bean.SearchResultItem, com.chad.library.adapter.base.viewholder.BaseViewHolder, android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(SearchResultItem searchResultItem, k kVar, BaseViewHolder baseViewHolder, View view) {
        List<UGCVideo> videos;
        UGCVideo uGCVideo;
        UGCCollection collection = searchResultItem.getCollection();
        if (collection != null && (videos = collection.getVideos()) != null && (uGCVideo = (UGCVideo) CollectionsKt.k0(videos)) != null) {
            com.transsion.search_pugc.constant.a.h(uGCVideo, false, 1, null);
        }
        kVar.d(searchResultItem, baseViewHolder.getBindingAdapterPosition());
    }

    private final int K() {
        return ((Number) this.f52500g.getValue()).intValue();
    }

    private final int L() {
        return ((Number) this.f52499f.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int M() {
        return com.blankj.utilcode.util.i.e(52.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int N() {
        return com.blankj.utilcode.util.i.e(26.0f);
    }

    private final void O(SearchResultItem searchResultItem) {
        List<UGCVideo> videos;
        UGCCollection collection = searchResultItem.getCollection();
        if (collection == null || (videos = collection.getVideos()) == null) {
            return;
        }
        int i11 = 0;
        for (Object obj : videos) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.u();
            }
            e((UGCVideo) obj, i11);
            i11 = i12;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0177  */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(final com.chad.library.adapter.base.viewholder.BaseViewHolder r13, final com.transsion.search_pugc.bean.SearchResultItem r14) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.search_pugc.fragment.result.provider.k.b(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.transsion.search_pugc.bean.SearchResultItem):void");
    }

    @Override // com.transsion.search_pugc.fragment.result.provider.t
    public void a(UGCVideo ugcVideo, int i11) {
        Intrinsics.h(ugcVideo, "ugcVideo");
        this.f52498e.a(ugcVideo, i11);
    }

    @Override // com.transsion.search_pugc.fragment.result.provider.t
    public void c(UGCVideo ugcVideo, int i11) {
        Intrinsics.h(ugcVideo, "ugcVideo");
        this.f52498e.c(ugcVideo, i11);
    }

    @Override // com.transsion.search_pugc.fragment.result.provider.t
    public void d(SearchResultItem item, int i11) {
        Intrinsics.h(item, "item");
        this.f52498e.d(item, i11);
    }

    @Override // com.transsion.search_pugc.fragment.result.provider.t
    public void e(UGCVideo ugcVideo, int i11) {
        Intrinsics.h(ugcVideo, "ugcVideo");
        this.f52498e.e(ugcVideo, i11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return SearchType.UGC_COLLECTION.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.provider_result_collection;
    }
}
