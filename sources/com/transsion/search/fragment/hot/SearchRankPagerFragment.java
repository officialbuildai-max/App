package com.transsion.search.fragment.hot;

import ak.h;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.v0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.search.R$drawable;
import com.transsion.search.bean.GroupInfo;
import com.transsion.search.bean.HotRankItem;
import com.transsion.search.bean.HotSubject;
import com.transsion.search.fragment.hot.adapter.c;
import com.transsion.search.viewmodel.SearchViewModel;
import com.transsion.search.widget.d;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import rq.f;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/transsion/search/fragment/hot/SearchRankPagerFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lrq/f;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "a0", "(Landroid/view/LayoutInflater;)Lrq/f;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "b0", "lazyLoadData", "", "a", "Z", "hasReported", "Lcom/transsion/search/viewmodel/SearchViewModel;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsion/search/viewmodel/SearchViewModel;", "searchViewModel", "c", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class SearchRankPagerFragment extends BaseFragment<f> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean hasReported;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private SearchViewModel searchViewModel;

    /* renamed from: com.transsion.search.fragment.hot.SearchRankPagerFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchRankPagerFragment a(HotRankItem hotRankItem) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("hotRankItem", hotRankItem);
            SearchRankPagerFragment searchRankPagerFragment = new SearchRankPagerFragment();
            searchRankPagerFragment.setArguments(bundle);
            return searchRankPagerFragment;
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public f getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        f c11 = f.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    public final void b0() {
        String str;
        List<GroupInfo> groups;
        List<HotSubject> items;
        if (this.hasReported) {
            return;
        }
        boolean a11 = h.f716a.a();
        Bundle arguments = getArguments();
        HotRankItem hotRankItem = arguments != null ? (HotRankItem) arguments.getParcelable("hotRankItem") : null;
        HotRankItem hotRankItem2 = hotRankItem instanceof HotRankItem ? hotRankItem : null;
        SearchViewModel searchViewModel = this.searchViewModel;
        if (searchViewModel == null || (str = searchViewModel.s()) == null) {
            str = "mb_sug";
        }
        String str2 = str;
        int i11 = 0;
        if (hotRankItem2 != null && (items = hotRankItem2.getItems()) != null) {
            int i12 = 0;
            for (Object obj : items) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    CollectionsKt.u();
                }
                d.f52324a.n((HotSubject) obj, i12, hotRankItem2.getCategory(), hotRankItem2.getIndex(), a11, str2);
                i12 = i13;
            }
        }
        if (hotRankItem2 != null && (groups = hotRankItem2.getGroups()) != null) {
            Iterator<T> it = groups.iterator();
            while (true) {
                int i14 = i11;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                i11 = i14 + 1;
                if (i14 < 0) {
                    CollectionsKt.u();
                }
                d.f52324a.l((GroupInfo) next, i14, hotRankItem2.getCategory(), hotRankItem2.getIndex(), a11, str2);
            }
        }
        this.hasReported = true;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView;
        BaseQuickAdapter hVar;
        String s11;
        String s12;
        ImageView imageView;
        int i11;
        List<GroupInfo> groups;
        List<HotSubject> items;
        Intrinsics.h(view, "view");
        Bundle arguments = getArguments();
        HotRankItem hotRankItem = arguments != null ? (HotRankItem) arguments.getParcelable("hotRankItem") : null;
        HotRankItem hotRankItem2 = hotRankItem instanceof HotRankItem ? hotRankItem : null;
        if (hotRankItem2 == null) {
            return;
        }
        boolean c11 = Intrinsics.c(hotRankItem2.getCategory(), HotRankItem.CATE_GROUP);
        if (c11 || !((items = hotRankItem2.getItems()) == null || items.isEmpty())) {
            if (c11 && ((groups = hotRankItem2.getGroups()) == null || groups.isEmpty())) {
                return;
            }
            f mViewBinding = getMViewBinding();
            if (mViewBinding != null && (imageView = mViewBinding.f74766c) != null) {
                String category = hotRankItem2.getCategory();
                int hashCode = category.hashCode();
                if (hashCode == 2690) {
                    if (category.equals(HotRankItem.CATE_TV)) {
                        i11 = R$drawable.rank_type_tv;
                        imageView.setImageResource(i11);
                    }
                    i11 = R$drawable.rank_type_community;
                    imageView.setImageResource(i11);
                } else if (hashCode != 74534672) {
                    if (hashCode == 74710533 && category.equals(HotRankItem.CATE_MUSIC)) {
                        i11 = R$drawable.rank_type_music;
                        imageView.setImageResource(i11);
                    }
                    i11 = R$drawable.rank_type_community;
                    imageView.setImageResource(i11);
                } else {
                    if (category.equals(HotRankItem.CATE_MOVIE)) {
                        i11 = R$drawable.rank_type_movie;
                        imageView.setImageResource(i11);
                    }
                    i11 = R$drawable.rank_type_community;
                    imageView.setImageResource(i11);
                }
            }
            f mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (recyclerView = mViewBinding2.f74765b) == null) {
                return;
            }
            Resources resources = recyclerView.getResources();
            Intrinsics.g(resources, "getResources(...)");
            boolean e11 = com.transsion.search.f.e(resources);
            recyclerView.setLayoutManager(e11 ? new NpaGridLayoutManager(recyclerView.getContext(), 2) : new LinearLayoutManager(recyclerView.getContext()));
            if (!Intrinsics.c(hotRankItem2.getCategory(), HotRankItem.CATE_TV) && !Intrinsics.c(hotRankItem2.getCategory(), HotRankItem.CATE_MOVIE) && recyclerView.getItemDecorationCount() == 0) {
                recyclerView.addItemDecoration(new ig.f(0.0f, 8.0f, 0.0f, 5, null));
            }
            String str = "mb_sug";
            if (c11) {
                String category2 = hotRankItem2.getCategory();
                int index = hotRankItem2.getIndex();
                SearchViewModel searchViewModel = this.searchViewModel;
                if (searchViewModel != null && (s12 = searchViewModel.s()) != null) {
                    str = s12;
                }
                hVar = new c(category2, index, str);
                hVar.n1(hotRankItem2.getGroups());
            } else {
                String category3 = hotRankItem2.getCategory();
                int index2 = hotRankItem2.getIndex();
                SearchViewModel searchViewModel2 = this.searchViewModel;
                if (searchViewModel2 != null && (s11 = searchViewModel2.s()) != null) {
                    str = s11;
                }
                hVar = new com.transsion.search.fragment.hot.adapter.h(category3, index2, e11, str);
                hVar.n1(hotRankItem2.getItems());
            }
            recyclerView.setAdapter(hVar);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        Object m1185constructorimpl;
        super.onCreate(savedInstanceState);
        try {
            Result.Companion companion = Result.INSTANCE;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.g(requireActivity, "requireActivity(...)");
            m1185constructorimpl = Result.m1185constructorimpl((SearchViewModel) new v0(requireActivity).a(SearchViewModel.class));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1191isFailureimpl(m1185constructorimpl)) {
            m1185constructorimpl = null;
        }
        this.searchViewModel = (SearchViewModel) m1185constructorimpl;
    }
}
