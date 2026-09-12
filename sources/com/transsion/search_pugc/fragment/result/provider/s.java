package com.transsion.search_pugc.fragment.result.provider;

import android.animation.ValueAnimator;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
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
import com.transsion.ugcvideodetail.api.bean.UGCVerticalRank;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class s extends BaseItemProvider implements t {

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ t f52515e;

    /* renamed from: f, reason: collision with root package name */
    private final Lazy f52516f;

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f52517g;

    /* renamed from: h, reason: collision with root package name */
    private final float f52518h;

    public s(t reportable) {
        Intrinsics.h(reportable, "reportable");
        this.f52515e = reportable;
        this.f52516f = LazyKt.b(new Function0() { // from class: com.transsion.search_pugc.fragment.result.provider.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int O;
                O = s.O();
                return Integer.valueOf(O);
            }
        });
        this.f52517g = LazyKt.b(new Function0() { // from class: com.transsion.search_pugc.fragment.result.provider.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int N;
                N = s.N();
                return Integer.valueOf(N);
            }
        });
        this.f52518h = 0.95f;
    }

    private final void E(final View view, int i11, int i12) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i11, i12);
        ofInt.setDuration(200L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.transsion.search_pugc.fragment.result.provider.r
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                s.F(view, valueAnimator);
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
    public static final void H(SearchResultItem searchResultItem, s sVar, BaseViewHolder baseViewHolder, View view) {
        UGCVerticalRank verticalRank = searchResultItem.getVerticalRank();
        if (verticalRank != null) {
            com.transsion.search_pugc.constant.a.f(verticalRank, searchResultItem.getOps());
        }
        sVar.d(searchResultItem, baseViewHolder.getBindingAdapterPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(com.transsion.search_pugc.fragment.result.adapter.a aVar, s sVar, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        UGCVideo a11 = ((ResultCollectItemWrapper) aVar.getData().get(i11)).a();
        if (a11 != null) {
            com.transsion.search_pugc.constant.a.h(a11, false, 1, null);
            sVar.a(a11, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
    
        if (r2 != 3) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean J(com.transsion.search_pugc.fragment.result.provider.FooterStretchRecyclerView r6, com.transsion.search_pugc.fragment.result.adapter.a r7, kotlin.jvm.internal.Ref.FloatRef r8, kotlin.jvm.internal.Ref.BooleanRef r9, com.transsion.search_pugc.fragment.result.provider.s r10, com.transsion.search_pugc.bean.SearchResultItem r11, com.chad.library.adapter.base.viewholder.BaseViewHolder r12, android.view.View r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.search_pugc.fragment.result.provider.s.J(com.transsion.search_pugc.fragment.result.provider.FooterStretchRecyclerView, com.transsion.search_pugc.fragment.result.adapter.a, kotlin.jvm.internal.Ref$FloatRef, kotlin.jvm.internal.Ref$BooleanRef, com.transsion.search_pugc.fragment.result.provider.s, com.transsion.search_pugc.bean.SearchResultItem, com.chad.library.adapter.base.viewholder.BaseViewHolder, android.view.View, android.view.MotionEvent):boolean");
    }

    private final int K() {
        return ((Number) this.f52517g.getValue()).intValue();
    }

    private final int L() {
        return ((Number) this.f52516f.getValue()).intValue();
    }

    private final SpannableStringBuilder M(String str, String str2, int i11) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int o02 = StringsKt.o0(str, str2, 0, false, 6, null);
        if (o02 >= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i11), o02, str2.length() + o02, 33);
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int N() {
        return com.blankj.utilcode.util.i.e(52.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int O() {
        return com.blankj.utilcode.util.i.e(26.0f);
    }

    private final void P(SearchResultItem searchResultItem) {
        List<UGCVideo> videos;
        UGCVerticalRank verticalRank = searchResultItem.getVerticalRank();
        if (verticalRank == null || (videos = verticalRank.getVideos()) == null) {
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

    /* JADX WARN: Removed duplicated region for block: B:26:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x013c  */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(final com.chad.library.adapter.base.viewholder.BaseViewHolder r11, final com.transsion.search_pugc.bean.SearchResultItem r12) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.search_pugc.fragment.result.provider.s.b(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.transsion.search_pugc.bean.SearchResultItem):void");
    }

    @Override // com.transsion.search_pugc.fragment.result.provider.t
    public void a(UGCVideo ugcVideo, int i11) {
        Intrinsics.h(ugcVideo, "ugcVideo");
        this.f52515e.a(ugcVideo, i11);
    }

    @Override // com.transsion.search_pugc.fragment.result.provider.t
    public void c(UGCVideo ugcVideo, int i11) {
        Intrinsics.h(ugcVideo, "ugcVideo");
        this.f52515e.c(ugcVideo, i11);
    }

    @Override // com.transsion.search_pugc.fragment.result.provider.t
    public void d(SearchResultItem item, int i11) {
        Intrinsics.h(item, "item");
        this.f52515e.d(item, i11);
    }

    @Override // com.transsion.search_pugc.fragment.result.provider.t
    public void e(UGCVideo ugcVideo, int i11) {
        Intrinsics.h(ugcVideo, "ugcVideo");
        this.f52515e.e(ugcVideo, i11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return SearchType.VERTICAL_RANK.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.provider_result_collection;
    }
}
