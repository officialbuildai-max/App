package com.transsion.home.fragment.film;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.d;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.view.b0;
import androidx.view.c0;
import androidx.view.v0;
import be.g;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.gslb.Utils;
import com.transsion.home.adapter.e;
import com.transsion.home.bean.UGCRankAllData;
import com.transsion.home.bean.UgcGenreTopRespGenreItem;
import com.transsion.home.fragment.film.UGCFilmListFragment;
import com.transsion.home.p004enum.HomeTabId;
import com.transsion.home.viewmodel.UGCFilmListViewModel;
import com.transsion.home.viewmodel.UGCRankingViewModel;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.ugcvideodetail.api.UGCVideoType;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import gl.n;
import hj.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import lg.a;
import nh.m;
import nl.a;
import oh.h;
import r6.f;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u0000 a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0003¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u001d\u0010\u0012\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\r\u0010\u001d\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u0004J\r\u0010\u001e\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020!H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0007H\u0016¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\u0007H\u0016¢\u0006\u0004\b(\u0010\u0004J\u000f\u0010)\u001a\u00020\u0007H\u0016¢\u0006\u0004\b)\u0010\u0004J\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0007H\u0016¢\u0006\u0004\b-\u0010\u0004J\u001f\u00101\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00100\u001a\u00020\u0018¢\u0006\u0004\b1\u00102J\u0015\u00105\u001a\u00020\u00072\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\u0018¢\u0006\u0004\b7\u0010\u001aR\u0018\u00104\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010<R\u0016\u0010A\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010<R\u0016\u0010C\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010<R\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010<R\u0016\u0010O\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010<R\u0016\u0010S\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010<R\u0018\u0010V\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010`\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010N¨\u0006b"}, d2 = {"Lcom/transsion/home/fragment/film/UGCFilmListFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lgl/n;", "<init>", "()V", "Lcom/transsion/moviedetailapi/bean/Cover;", "cover", "", "G0", "(Lcom/transsion/moviedetailapi/bean/Cover;)V", "B0", "Lcom/transsion/home/adapter/e;", "x0", "()Lcom/transsion/home/adapter/e;", "reload", "", "Lcom/transsion/home/bean/UgcGenreTopRespGenreItem;", "filmList", "K0", "(Ljava/util/List;)V", "Landroid/view/LayoutInflater;", "inflater", "w0", "(Landroid/view/LayoutInflater;)Lgl/n;", "", "getPageStateLayoutTitle", "()Ljava/lang/String;", "receiveArguments", "initViewData", "hideLoading", "startLoading", "initViewModel", "initListener", "", "isMonitorNetworkState", "()Z", "hidden", "onHiddenChanged", "(Z)V", "onPause", "retryLoadData", "loadDefaultData", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "onDestroy", "Lcom/transsion/home/bean/UGCRankAllData;", "data", "rankCategory", "L0", "(Lcom/transsion/home/bean/UGCRankAllData;Ljava/lang/String;)V", "Lcom/transsion/home/viewmodel/UGCRankingViewModel;", "viewModel", "H0", "(Lcom/transsion/home/viewmodel/UGCRankingViewModel;)V", "getPageName", "Lcom/transsion/home/viewmodel/UGCFilmListViewModel;", "a", "Lcom/transsion/home/viewmodel/UGCFilmListViewModel;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "tabId", "c", "fromOptId", "d", "filmType", "e", "mFilmListTitle", "Lhl/b;", "f", "Lhl/b;", "mExposureHelper", g.f16474b, "Lcom/transsion/home/adapter/e;", "mFilmListAdapter", "h", "mFilmListCover", "i", "Z", "isRankingMode", j.f35620b, "rankingCategory", CampaignEx.JSON_KEY_AD_K, "videoType", "l", "Lcom/transsion/home/viewmodel/UGCRankingViewModel;", "rankingViewModel", "Lnl/a;", "m", "Lnl/a;", "headerMaskManager", "", "n", "J", "firstLoadStartTimeMillis", "o", "hasRecordedFirstLoadDuration", TtmlNode.TAG_P, "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class UGCFilmListFragment extends PageStatusFragment<n> {

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: q, reason: collision with root package name */
    public static final int f44999q = 8;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private UGCFilmListViewModel viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private hl.b mExposureHelper;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private e mFilmListAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isRankingMode;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private UGCRankingViewModel rankingViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private a headerMaskManager;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private long firstLoadStartTimeMillis;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean hasRecordedFirstLoadDuration;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String tabId = "0";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String fromOptId = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String filmType = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String mFilmListTitle = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String mFilmListCover = "";

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private String rankingCategory = "";

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String videoType = "";

    /* renamed from: com.transsion.home.fragment.film.UGCFilmListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ UGCFilmListFragment b(Companion companion, String str, String str2, String str3, boolean z10, String str4, String str5, int i11, Object obj) {
            if ((i11 & 8) != 0) {
                z10 = false;
            }
            return companion.a(str, str2, str3, z10, str4, str5);
        }

        public final UGCFilmListFragment a(String tabId, String filmType, String mFilmListTitle, boolean z10, String videoType, String fromOptId) {
            Intrinsics.h(tabId, "tabId");
            Intrinsics.h(filmType, "filmType");
            Intrinsics.h(mFilmListTitle, "mFilmListTitle");
            Intrinsics.h(videoType, "videoType");
            Intrinsics.h(fromOptId, "fromOptId");
            UGCFilmListFragment uGCFilmListFragment = new UGCFilmListFragment();
            uGCFilmListFragment.setArguments(d.b(TuplesKt.a("tabId", tabId), TuplesKt.a("filmType", filmType), TuplesKt.a("filmListTitle", mFilmListTitle), TuplesKt.a("onlyShowList", Boolean.valueOf(z10)), TuplesKt.a("videoType", videoType), TuplesKt.a("fromOptId", fromOptId)));
            return uGCFilmListFragment;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements hl.a {
        b() {
        }

        @Override // hl.a
        public void a(int i11, long j11, View view) {
            String str;
            String str2;
            String str3;
            UGCVideo video;
            String ops;
            UGCVideo video2;
            UGCVideo video3;
            UGCVideo video4;
            UGCVideoBelongToCollection belongToCollection;
            List<Object> data;
            e eVar = UGCFilmListFragment.this.mFilmListAdapter;
            if (i11 >= ((eVar == null || (data = eVar.getData()) == null) ? 0 : data.size())) {
                return;
            }
            e eVar2 = UGCFilmListFragment.this.mFilmListAdapter;
            UGCContent uGCContent = eVar2 != null ? (UGCContent) eVar2.getItem(i11) : null;
            HashMap hashMap = new HashMap();
            hashMap.put("browse_duration", String.valueOf(j11));
            hashMap.put("module_name", WebConstants.FIELD_ITEM);
            if (UGCFilmListFragment.this.isRankingMode) {
                hashMap.put("rank_category", UGCFilmListFragment.this.rankingCategory);
            }
            String str4 = "";
            if (uGCContent == null || (video4 = uGCContent.getVideo()) == null || (belongToCollection = video4.getBelongToCollection()) == null || (str = belongToCollection.getCollectionId()) == null) {
                str = "";
            }
            hashMap.put("belong_to_collection_id", str);
            if (uGCContent == null || (video3 = uGCContent.getVideo()) == null || (str2 = video3.getUgcVideoId()) == null) {
                str2 = "";
            }
            hashMap.put("content_id", str2);
            if (uGCContent == null || (video2 = uGCContent.getVideo()) == null || (str3 = video2.getSubjectId()) == null) {
                str3 = "";
            }
            hashMap.put("refer_subject_id", str3);
            hashMap.put("content_type", "ugc_video");
            if (uGCContent != null && (video = uGCContent.getVideo()) != null && (ops = video.getOps()) != null) {
                str4 = ops;
            }
            hashMap.put("ops", str4);
            hashMap.put(CampaignEx.JSON_KEY_TITLE, UGCFilmListFragment.this.isRankingMode ? UGCFilmListFragment.this.rankingCategory : UGCFilmListFragment.this.mFilmListTitle);
            com.transsion.baselib.helper.a.f43316a.e(UGCFilmListFragment.this.getPageName(), hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f45016a;

        c(Function1 function) {
            Intrinsics.h(function, "function");
            this.f45016a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f45016a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f45016a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(UGCFilmListFragment uGCFilmListFragment, BaseQuickAdapter adapter, View view, int i11) {
        String str;
        String ops;
        UGCVideoBelongToCollection belongToCollection;
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        Object item = adapter.getItem(i11);
        if (item instanceof UGCContent) {
            UGCContent uGCContent = (UGCContent) item;
            String str2 = null;
            ov.c.f(uGCContent, null, null, 3, null);
            UGCVideo video = uGCContent.getVideo();
            String ugcVideoId = video != null ? video.getUgcVideoId() : null;
            UGCVideo video2 = uGCContent.getVideo();
            if (video2 != null && (belongToCollection = video2.getBelongToCollection()) != null) {
                str2 = belongToCollection.getCollectionId();
            }
            a.C0856a.f(lg.a.f68962a, "FilmListFragment", "initFilmListAdapter: item clicked, position=" + i11 + ", topicType=" + uGCContent.getTopicType() + ", videoId=" + ugcVideoId + ", collectionId=" + str2, false, 4, null);
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", WebConstants.FIELD_ITEM);
            if (uGCFilmListFragment.isRankingMode) {
                hashMap.put("rank_category", uGCFilmListFragment.rankingCategory);
            }
            String str3 = "";
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("belong_to_collection_id", str2);
            if (ugcVideoId == null) {
                ugcVideoId = "";
            }
            hashMap.put("content_id", ugcVideoId);
            UGCVideo video3 = uGCContent.getVideo();
            if (video3 == null || (str = video3.getSubjectId()) == null) {
                str = "";
            }
            hashMap.put("refer_subject_id", str);
            hashMap.put("content_type", "ugc_video");
            UGCVideo video4 = uGCContent.getVideo();
            if (video4 != null && (ops = video4.getOps()) != null) {
                str3 = ops;
            }
            hashMap.put("ops", str3);
            com.transsion.baselib.helper.a.f43316a.f(uGCFilmListFragment.getPageName(), hashMap);
        }
    }

    private final void B0() {
        RecyclerView recyclerView;
        SwipeRefreshLayout swipeRefreshLayout;
        n mViewBinding = getMViewBinding();
        if (mViewBinding != null && (swipeRefreshLayout = mViewBinding.f63914f) != null) {
            swipeRefreshLayout.setEnabled(true);
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: kl.e
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
                public final void a() {
                    UGCFilmListFragment.C0(UGCFilmListFragment.this);
                }
            });
        }
        n mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (recyclerView = mViewBinding2.f63913e) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setItemAnimator(null);
        hl.b bVar = new hl.b(0.6f, new b(), false, 4, null);
        bVar.l(2);
        recyclerView.addOnScrollListener(bVar);
        this.mExposureHelper = bVar;
        recyclerView.setAdapter(x0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(UGCFilmListFragment uGCFilmListFragment) {
        a.C0856a.f(lg.a.f68962a, "FilmListFragment", "initRecyclerView: user pull to refresh", false, 4, null);
        hl.b bVar = uGCFilmListFragment.mExposureHelper;
        if (bVar != null) {
            bVar.e();
        }
        if (uGCFilmListFragment.isRankingMode) {
            UGCRankingViewModel uGCRankingViewModel = uGCFilmListFragment.rankingViewModel;
            if (uGCRankingViewModel != null) {
                uGCRankingViewModel.n();
                return;
            }
            return;
        }
        UGCFilmListViewModel uGCFilmListViewModel = uGCFilmListFragment.viewModel;
        if (uGCFilmListViewModel != null) {
            uGCFilmListViewModel.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(UGCFilmListFragment uGCFilmListFragment, View view) {
        FragmentActivity activity = uGCFilmListFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(UGCFilmListFragment uGCFilmListFragment, String str) {
        TitleLayout titleLayout;
        TitleLayout titleLayout2;
        TnTextView tvTitleText;
        CharSequence text;
        if (!uGCFilmListFragment.isRankingMode) {
            n mViewBinding = uGCFilmListFragment.getMViewBinding();
            String obj = (mViewBinding == null || (titleLayout2 = mViewBinding.f63915g) == null || (tvTitleText = titleLayout2.getTvTitleText()) == null || (text = tvTitleText.getText()) == null) ? null : text.toString();
            if ((obj == null || obj.length() == 0) && str != null && str.length() > 0) {
                a.C0856a.f(lg.a.f68962a, "FilmListFragment", "filmListDescLiveData: set title from desc='" + str + "'", false, 4, null);
                uGCFilmListFragment.mFilmListTitle = str;
                n mViewBinding2 = uGCFilmListFragment.getMViewBinding();
                if (mViewBinding2 != null && (titleLayout = mViewBinding2.f63915g) != null) {
                    titleLayout.setTitleText(str);
                }
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(UGCFilmListFragment uGCFilmListFragment, List list) {
        List l11;
        e eVar;
        List<Object> data;
        SwipeRefreshLayout swipeRefreshLayout;
        f h02;
        List<Object> data2;
        List<Object> data3;
        HashMap g11;
        List<Object> data4;
        f h03;
        e eVar2;
        f h04;
        SwipeRefreshLayout swipeRefreshLayout2;
        if (list != null) {
            List list2 = list;
            l11 = new ArrayList(CollectionsKt.v(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                l11.add(((UgcGenreTopRespGenreItem) it.next()).getUgcContent());
            }
        } else {
            l11 = CollectionsKt.l();
        }
        a.C0856a c0856a = lg.a.f68962a;
        Integer valueOf = list != null ? Integer.valueOf(list.size()) : null;
        int size = l11.size();
        boolean z10 = list == null;
        a.C0856a.f(c0856a, "FilmListFragment", "filmListLiveData: data received, rawItems=" + valueOf + ", flattened=" + size + ", isNull=" + z10 + ", isRankingMode=" + uGCFilmListFragment.isRankingMode, false, 4, null);
        if (!uGCFilmListFragment.isRankingMode) {
            uGCFilmListFragment.showContentView();
        }
        n mViewBinding = uGCFilmListFragment.getMViewBinding();
        if (mViewBinding != null && (swipeRefreshLayout2 = mViewBinding.f63914f) != null) {
            swipeRefreshLayout2.setRefreshing(false);
        }
        e eVar3 = uGCFilmListFragment.mFilmListAdapter;
        if (eVar3 != null && (h03 = eVar3.h0()) != null && h03.r() && (eVar2 = uGCFilmListFragment.mFilmListAdapter) != null && (h04 = eVar2.h0()) != null) {
            h04.s();
        }
        if (list != null) {
            e eVar4 = uGCFilmListFragment.mFilmListAdapter;
            boolean z11 = (eVar4 == null || (data4 = eVar4.getData()) == null || !data4.isEmpty()) ? false : true;
            if (!uGCFilmListFragment.isRankingMode && z11 && !uGCFilmListFragment.hasRecordedFirstLoadDuration && uGCFilmListFragment.firstLoadStartTimeMillis > 0) {
                long currentTimeMillis = System.currentTimeMillis() - uGCFilmListFragment.firstLoadStartTimeMillis;
                hj.b logViewConfig = uGCFilmListFragment.getLogViewConfig();
                if (logViewConfig != null && (g11 = logViewConfig.g()) != null) {
                    g11.put("load_duration", String.valueOf(currentTimeMillis));
                }
                uGCFilmListFragment.hasRecordedFirstLoadDuration = true;
            }
            int size2 = l11.size();
            e eVar5 = uGCFilmListFragment.mFilmListAdapter;
            Integer valueOf2 = (eVar5 == null || (data3 = eVar5.getData()) == null) ? null : Integer.valueOf(data3.size());
            UGCFilmListViewModel uGCFilmListViewModel = uGCFilmListFragment.viewModel;
            a.C0856a.f(c0856a, "FilmListFragment", "filmListLiveData: received " + size2 + " contents, currentListSize=" + valueOf2 + ", hasMore=" + (uGCFilmListViewModel != null ? Boolean.valueOf(uGCFilmListViewModel.l()) : null), false, 4, null);
            UGCFilmListViewModel uGCFilmListViewModel2 = uGCFilmListFragment.viewModel;
            if (uGCFilmListViewModel2 == null || !uGCFilmListViewModel2.l()) {
                a.C0856a.f(c0856a, "FilmListFragment", "filmListLiveData: no more data, load more end", false, 4, null);
                e eVar6 = uGCFilmListFragment.mFilmListAdapter;
                if (eVar6 != null && (h02 = eVar6.h0()) != null) {
                    f.u(h02, false, 1, null);
                }
            }
            e eVar7 = uGCFilmListFragment.mFilmListAdapter;
            if (eVar7 == null || (data2 = eVar7.getData()) == null || !data2.isEmpty() || size2 != 0) {
                uGCFilmListFragment.K0(list);
            } else {
                a.C0856a.f(c0856a, "FilmListFragment", "filmListLiveData: empty data, isRankingMode=" + uGCFilmListFragment.isRankingMode, false, 4, null);
                if (!uGCFilmListFragment.isRankingMode) {
                    uGCFilmListFragment.showEmptyView(true);
                }
            }
            hj.b logViewConfig2 = uGCFilmListFragment.getLogViewConfig();
            if (logViewConfig2 != null) {
                logViewConfig2.k(true);
            }
        } else {
            c0856a.i("FilmListFragment", "filmListLiveData: data is null, isRankingMode=" + uGCFilmListFragment.isRankingMode, true);
            n mViewBinding2 = uGCFilmListFragment.getMViewBinding();
            if (mViewBinding2 != null && (swipeRefreshLayout = mViewBinding2.f63914f) != null) {
                swipeRefreshLayout.setRefreshing(false);
            }
            if (!uGCFilmListFragment.isRankingMode && (eVar = uGCFilmListFragment.mFilmListAdapter) != null && (data = eVar.getData()) != null && data.isEmpty()) {
                uGCFilmListFragment.showEmptyView(true);
            }
        }
        return Unit.f67184a;
    }

    private final void G0(Cover cover) {
        String averageHueDark;
        Object m1185constructorimpl;
        ImageView imageView;
        String str;
        String str2;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        n mViewBinding = getMViewBinding();
        String str3 = "";
        if (mViewBinding != null && (imageView = mViewBinding.f63911c) != null) {
            f.b m11 = ej.f.f62005a.m(activity);
            if (cover == null || (str = cover.getUrl()) == null) {
                str = "";
            }
            f.b g11 = m11.g(str);
            if (cover == null || (str2 = cover.getThumbnail()) == null) {
                str2 = "";
            }
            g11.l(str2).d(imageView);
        }
        if (cover == null || (averageHueDark = cover.getAverageHueDark()) == null) {
            return;
        }
        Unit unit = null;
        if (StringsKt.c0(averageHueDark, Utils.SEPARATOR, false, 2, null)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                String averageHueDark2 = cover.getAverageHueDark();
                if (averageHueDark2 != null) {
                    str3 = averageHueDark2;
                }
                int parseColor = Color.parseColor(str3);
                nl.a aVar = this.headerMaskManager;
                if (aVar != null) {
                    aVar.a(Integer.valueOf(parseColor));
                    unit = Unit.f67184a;
                }
                m1185constructorimpl = Result.m1185constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
                a.C0856a.l(lg.a.f68962a, "FilmListFragment", "initRecyclerView: parseColor failed, use default color", false, 4, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(final UGCFilmListFragment uGCFilmListFragment, final UGCRankAllData uGCRankAllData) {
        RecyclerView recyclerView;
        r6.f h02;
        Pager pager;
        List<UGCContent> items;
        a.C0856a c0856a = lg.a.f68962a;
        Boolean bool = null;
        Integer valueOf = (uGCRankAllData == null || (items = uGCRankAllData.getItems()) == null) ? null : Integer.valueOf(items.size());
        if (uGCRankAllData != null && (pager = uGCRankAllData.getPager()) != null) {
            bool = pager.getHasMore();
        }
        a.C0856a.f(c0856a, "FilmListFragment", "loadMoreLiveData: received data, items size=" + valueOf + ", hasMore=" + bool, false, 4, null);
        if (uGCRankAllData == null) {
            a.C0856a.z(c0856a, "FilmListFragment", "loadMoreLiveData: data is null, load more failed", false, 4, null);
            e eVar = uGCFilmListFragment.mFilmListAdapter;
            if (eVar != null && (h02 = eVar.h0()) != null) {
                h02.v();
            }
        } else {
            List<UGCContent> items2 = uGCRankAllData.getItems();
            if (items2 == null) {
                items2 = CollectionsKt.l();
            }
            List<UGCContent> list = items2;
            a.C0856a.f(c0856a, "FilmListFragment", "loadMoreLiveData: add " + list.size() + " items to list", false, 4, null);
            e eVar2 = uGCFilmListFragment.mFilmListAdapter;
            if (eVar2 != null) {
                eVar2.q(list);
            }
            n mViewBinding = uGCFilmListFragment.getMViewBinding();
            if (mViewBinding != null && (recyclerView = mViewBinding.f63913e) != null) {
                recyclerView.postDelayed(new Runnable() { // from class: kl.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        UGCFilmListFragment.J0(UGCFilmListFragment.this, uGCRankAllData);
                    }
                }, 300L);
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(UGCFilmListFragment uGCFilmListFragment, UGCRankAllData uGCRankAllData) {
        r6.f h02;
        r6.f h03;
        e eVar;
        r6.f h04;
        e eVar2 = uGCFilmListFragment.mFilmListAdapter;
        if (eVar2 != null && (h03 = eVar2.h0()) != null && h03.r() && (eVar = uGCFilmListFragment.mFilmListAdapter) != null && (h04 = eVar.h0()) != null) {
            h04.s();
        }
        Pager pager = uGCRankAllData.getPager();
        if (pager != null ? Intrinsics.c(pager.getHasMore(), Boolean.TRUE) : false) {
            return;
        }
        a.C0856a.f(lg.a.f68962a, "FilmListFragment", "loadMoreLiveData: no more data, load more end", false, 4, null);
        e eVar3 = uGCFilmListFragment.mFilmListAdapter;
        if (eVar3 == null || (h02 = eVar3.h0()) == null) {
            return;
        }
        r6.f.u(h02, false, 1, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b9, code lost:
    
        if ((r5 != null ? r5.Q1() : false) != false) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void K0(java.util.List r14) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.fragment.film.UGCFilmListFragment.K0(java.util.List):void");
    }

    private final void reload() {
        if (m.f70597a.e()) {
            loadDefaultData();
        } else {
            showLoadingView();
            showNoNetworkViewDelayed();
        }
    }

    private final e x0() {
        e eVar = new e(new ArrayList(), this.mExposureHelper, this.isRankingMode, HomeTabId.INSTANCE.h(StringsKt.v(this.tabId), false) || StringsKt.H(UGCVideoType.EDUCATION.getValue(), this.videoType, true));
        eVar.h0().z(true);
        eVar.h0().y(true);
        eVar.h0().D(new p6.f() { // from class: kl.g
            @Override // p6.f
            public final void a() {
                UGCFilmListFragment.y0(UGCFilmListFragment.this);
            }
        });
        eVar.w1(new p6.d() { // from class: kl.h
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                UGCFilmListFragment.A0(UGCFilmListFragment.this, baseQuickAdapter, view, i11);
            }
        });
        this.mFilmListAdapter = eVar;
        Intrinsics.e(eVar);
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(final UGCFilmListFragment uGCFilmListFragment) {
        RecyclerView recyclerView;
        if (!m.f70597a.e()) {
            a.C0856a.z(lg.a.f68962a, "FilmListFragment", "initFilmListAdapter: no network, load more failed", false, 4, null);
            n mViewBinding = uGCFilmListFragment.getMViewBinding();
            if (mViewBinding == null || (recyclerView = mViewBinding.f63913e) == null) {
                return;
            }
            recyclerView.postDelayed(new Runnable() { // from class: kl.i
                @Override // java.lang.Runnable
                public final void run() {
                    UGCFilmListFragment.z0(UGCFilmListFragment.this);
                }
            }, 300L);
            return;
        }
        a.C0856a.f(lg.a.f68962a, "FilmListFragment", "initFilmListAdapter: trigger load more, isRankingMode=" + uGCFilmListFragment.isRankingMode, false, 4, null);
        if (uGCFilmListFragment.isRankingMode) {
            UGCRankingViewModel uGCRankingViewModel = uGCFilmListFragment.rankingViewModel;
            if (uGCRankingViewModel != null) {
                uGCRankingViewModel.m();
                return;
            }
            return;
        }
        UGCFilmListViewModel uGCFilmListViewModel = uGCFilmListFragment.viewModel;
        if (uGCFilmListViewModel != null) {
            uGCFilmListViewModel.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(UGCFilmListFragment uGCFilmListFragment) {
        r6.f h02;
        e eVar = uGCFilmListFragment.mFilmListAdapter;
        if (eVar == null || (h02 = eVar.h0()) == null) {
            return;
        }
        h02.v();
    }

    public final void H0(UGCRankingViewModel viewModel) {
        Intrinsics.h(viewModel, "viewModel");
        a.C0856a.f(lg.a.f68962a, "FilmListFragment", "setupRankingViewModel: setup ranking mode, disable self error handling", false, 4, null);
        this.rankingViewModel = viewModel;
        this.isRankingMode = true;
        viewModel.j().p(this);
        viewModel.j().j(this, new c(new Function1() { // from class: kl.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit I0;
                I0 = UGCFilmListFragment.I0(UGCFilmListFragment.this, (UGCRankAllData) obj);
                return I0;
            }
        }));
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void L0(com.transsion.home.bean.UGCRankAllData r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.fragment.film.UGCFilmListFragment.L0(com.transsion.home.bean.UGCRankAllData, java.lang.String):void");
    }

    public final String getPageName() {
        return this.isRankingMode ? "/home/ugc_ranking" : "/home/ugc_film_list";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    public final void hideLoading() {
        SwipeRefreshLayout swipeRefreshLayout;
        n mViewBinding = getMViewBinding();
        if (mViewBinding == null || (swipeRefreshLayout = mViewBinding.f63914f) == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        TitleLayout titleLayout;
        SwipeRefreshLayout swipeRefreshLayout;
        View view;
        View view2;
        ImageView imageView;
        TitleLayout titleLayout2;
        if (this.isRankingMode) {
            a.C0856a.f(lg.a.f68962a, "FilmListFragment", "initViewData: onlyShowList mode, hide header views", false, 4, null);
            n mViewBinding = getMViewBinding();
            if (mViewBinding != null && (titleLayout2 = mViewBinding.f63915g) != null) {
                jg.c.g(titleLayout2);
            }
            n mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (imageView = mViewBinding2.f63911c) != null) {
                jg.c.g(imageView);
            }
            n mViewBinding3 = getMViewBinding();
            if (mViewBinding3 != null && (view2 = mViewBinding3.f63912d) != null) {
                jg.c.g(view2);
            }
            n mViewBinding4 = getMViewBinding();
            if (mViewBinding4 != null && (view = mViewBinding4.f63910b) != null) {
                jg.c.g(view);
            }
            n mViewBinding5 = getMViewBinding();
            if (mViewBinding5 != null && (swipeRefreshLayout = mViewBinding5.f63914f) != null) {
                ViewGroup.LayoutParams layoutParams = swipeRefreshLayout.getLayoutParams();
                ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
                if (bVar != null) {
                    bVar.f7753i = 0;
                    swipeRefreshLayout.setLayoutParams(bVar);
                }
            }
        } else {
            n mViewBinding6 = getMViewBinding();
            if (mViewBinding6 != null && (titleLayout = mViewBinding6.f63915g) != null) {
                titleLayout.setLeftOnclick(new View.OnClickListener() { // from class: kl.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        UGCFilmListFragment.D0(UGCFilmListFragment.this, view3);
                    }
                });
                h hVar = h.f71144a;
                Context context = titleLayout.getContext();
                Intrinsics.g(context, "getContext(...)");
                titleLayout.setPadding(0, hVar.d(context), 0, 0);
                titleLayout.setTitleTextColor(titleLayout.getResources().getColor(R$color.white_100));
                titleLayout.setTitleText(this.mFilmListTitle);
                titleLayout.setTitleMaxWidth(Integer.MAX_VALUE);
            }
            n mViewBinding7 = getMViewBinding();
            ImageView imageView2 = mViewBinding7 != null ? mViewBinding7.f63911c : null;
            n mViewBinding8 = getMViewBinding();
            this.headerMaskManager = new nl.a(imageView2, mViewBinding8 != null ? mViewBinding8.f63910b : null);
            pageStateFitStatusBar();
        }
        B0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        b0 k11;
        b0 j11;
        if (this.isRankingMode) {
            a.C0856a.f(lg.a.f68962a, "FilmListFragment", "initViewModel: ranking mode, skip init self viewmodel", false, 4, null);
            return;
        }
        UGCFilmListViewModel uGCFilmListViewModel = (UGCFilmListViewModel) new v0(this).a(UGCFilmListViewModel.class);
        this.viewModel = uGCFilmListViewModel;
        if (uGCFilmListViewModel != null) {
            uGCFilmListViewModel.m(this.filmType);
        }
        a.C0856a.f(lg.a.f68962a, "FilmListFragment", "initViewModel: ViewModel initialized with filmListId=" + this.filmType, false, 4, null);
        if (!this.hasRecordedFirstLoadDuration && this.firstLoadStartTimeMillis == 0) {
            this.firstLoadStartTimeMillis = System.currentTimeMillis();
        }
        UGCFilmListViewModel uGCFilmListViewModel2 = this.viewModel;
        if (uGCFilmListViewModel2 != null && (j11 = uGCFilmListViewModel2.j()) != null) {
            j11.j(this, new c(new Function1() { // from class: kl.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit E0;
                    E0 = UGCFilmListFragment.E0(UGCFilmListFragment.this, (String) obj);
                    return E0;
                }
            }));
        }
        UGCFilmListViewModel uGCFilmListViewModel3 = this.viewModel;
        if (uGCFilmListViewModel3 == null || (k11 = uGCFilmListViewModel3.k()) == null) {
            return;
        }
        k11.j(this, new c(new Function1() { // from class: kl.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit F0;
                F0 = UGCFilmListFragment.F0(UGCFilmListFragment.this, (List) obj);
                return F0;
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isMonitorNetworkState() {
        return true;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void loadDefaultData() {
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "FilmListFragment", "loadDefaultData: start loading default data, isRankingMode=" + this.isRankingMode, false, 4, null);
        if (this.isRankingMode) {
            a.C0856a.f(c0856a, "FilmListFragment", "loadDefaultData: ranking mode, skip self loading", false, 4, null);
            return;
        }
        if (!m.f70597a.e()) {
            a.C0856a.z(c0856a, "FilmListFragment", "loadDefaultData: no network available", false, 4, null);
            return;
        }
        showLoadingView();
        if (!this.hasRecordedFirstLoadDuration && this.firstLoadStartTimeMillis == 0) {
            this.firstLoadStartTimeMillis = System.currentTimeMillis();
        }
        UGCFilmListViewModel uGCFilmListViewModel = this.viewModel;
        if (uGCFilmListViewModel != null) {
            uGCFilmListViewModel.p();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public hj.b newLogViewConfig() {
        return new hj.b(getPageName(), false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        hl.b bVar = this.mExposureHelper;
        if (bVar != null) {
            bVar.e();
        }
        this.mExposureHelper = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (isResumed()) {
            if (hidden) {
                logPause();
            } else {
                logResume();
            }
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        hl.b bVar = this.mExposureHelper;
        if (bVar != null) {
            bVar.e();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void receiveArguments() {
        HashMap g11;
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("tabId", "0");
            Intrinsics.g(string, "getString(...)");
            this.tabId = string;
            String string2 = arguments.getString("filmType", "");
            Intrinsics.g(string2, "getString(...)");
            this.filmType = string2;
            String string3 = arguments.getString("filmListTitle", "");
            Intrinsics.g(string3, "getString(...)");
            this.mFilmListTitle = string3;
            this.isRankingMode = arguments.getBoolean("onlyShowList", false);
            String string4 = arguments.getString("videoType", "");
            Intrinsics.g(string4, "getString(...)");
            this.videoType = string4;
            String string5 = arguments.getString("fromOptId", "");
            Intrinsics.g(string5, "getString(...)");
            this.fromOptId = string5;
        }
        a.C0856a.f(lg.a.f68962a, "FilmListFragment", "receiveArguments: filmListId=" + this.filmType + ", title=" + this.mFilmListTitle + ", cover=" + this.mFilmListCover + ", onlyShowList=" + this.isRankingMode, false, 4, null);
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (g11 = logViewConfig.g()) == null) {
            return;
        }
        g11.put(WebConstants.PAGE_FROM, i.f64628a.i());
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
        List<Object> data;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "FilmListFragment", "retryLoadData: retry loading data, isRankingMode=" + this.isRankingMode, false, 4, null);
        if (this.isRankingMode) {
            a.C0856a.f(c0856a, "FilmListFragment", "retryLoadData: ranking mode, skip self retry", false, 4, null);
            return;
        }
        e eVar = this.mFilmListAdapter;
        if (eVar != null && (data = eVar.getData()) != null && data.isEmpty()) {
            reload();
            return;
        }
        e eVar2 = this.mFilmListAdapter;
        if (eVar2 == null || eVar2.h0().i() != LoadMoreStatus.Fail) {
            return;
        }
        eVar2.h0().w();
    }

    public final void startLoading() {
        SwipeRefreshLayout swipeRefreshLayout;
        n mViewBinding = getMViewBinding();
        if (mViewBinding == null || (swipeRefreshLayout = mViewBinding.f63914f) == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public n getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        n c11 = n.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }
}
