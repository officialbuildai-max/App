package com.transsion.subtitle.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.v0;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.tn.lib.view.DefaultView;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.SubtitleLanguageMapBean;
import com.transsion.baseui.fragment.LazyFragment;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.push.PushConstants;
import com.transsion.subtitle.R$drawable;
import com.transsion.subtitle.R$string;
import com.transsion.subtitle.bean.SubtitleSearchListBean;
import com.transsion.subtitle.h;
import com.transsion.subtitle.helper.SubtitleSearchHelper;
import com.transsion.subtitle.view.SubtitleDialogLoadMoreView;
import com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel;
import com.transsion.subtitle_download.a;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import hu.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u0013\u0018\u0000 \u0094\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001fB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b \u0010\u0006J!\u0010!\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b!\u0010\u0015J\u000f\u0010!\u001a\u00020\tH\u0016¢\u0006\u0004\b!\u0010\u0006J\u000f\u0010\"\u001a\u00020\tH\u0016¢\u0006\u0004\b\"\u0010\u0006J\u000f\u0010#\u001a\u00020\tH\u0016¢\u0006\u0004\b#\u0010\u0006J\u000f\u0010$\u001a\u00020\tH\u0016¢\u0006\u0004\b$\u0010\u0006J\u0017\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010'J\u001f\u0010,\u001a\u00020\t2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\t2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b.\u0010/J#\u00103\u001a\u00020\t2\n\u00102\u001a\u000600j\u0002`12\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\tH\u0016¢\u0006\u0004\b5\u0010\u0006J\u000f\u00106\u001a\u00020\tH\u0016¢\u0006\u0004\b6\u0010\u0006J\u0017\u00108\u001a\u00020\t2\b\u00107\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b8\u00109J/\u0010>\u001a\u00020\t2\b\u0010;\u001a\u0004\u0018\u00010:2\b\u0010=\u001a\u0004\u0018\u00010<2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\tH\u0002¢\u0006\u0004\b@\u0010\u0006J\u000f\u0010A\u001a\u00020\tH\u0002¢\u0006\u0004\bA\u0010\u0006J\u0017\u0010B\u001a\u00020\t2\u0006\u0010%\u001a\u00020\bH\u0002¢\u0006\u0004\bB\u0010'J%\u0010F\u001a\b\u0012\u0004\u0012\u00020\b0C2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010CH\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\tH\u0002¢\u0006\u0004\bH\u0010\u0006J\u000f\u0010I\u001a\u00020\tH\u0002¢\u0006\u0004\bI\u0010\u0006J\u000f\u0010J\u001a\u00020\tH\u0002¢\u0006\u0004\bJ\u0010\u0006J%\u0010M\u001a\u00020\t2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\b0C2\u0006\u0010L\u001a\u00020\u001dH\u0002¢\u0006\u0004\bM\u0010NJ\u0017\u0010P\u001a\u00020\t2\u0006\u0010O\u001a\u00020\u001dH\u0002¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020\tH\u0002¢\u0006\u0004\bR\u0010\u0006J\u000f\u0010S\u001a\u00020\tH\u0002¢\u0006\u0004\bS\u0010\u0006J\u000f\u0010T\u001a\u00020\tH\u0002¢\u0006\u0004\bT\u0010\u0006J\u0017\u0010W\u001a\u00020\u00102\u0006\u0010V\u001a\u00020UH\u0002¢\u0006\u0004\bW\u0010XJ\u0017\u0010Y\u001a\u00020\u00102\u0006\u0010V\u001a\u00020UH\u0002¢\u0006\u0004\bY\u0010XJ\u0017\u0010Z\u001a\u00020\u00102\u0006\u0010V\u001a\u00020UH\u0002¢\u0006\u0004\bZ\u0010XJ)\u0010]\u001a\u00020\u00102\u0006\u0010V\u001a\u00020U2\u0006\u0010[\u001a\u00020\u001a2\b\b\u0002\u0010\\\u001a\u00020\u001dH\u0002¢\u0006\u0004\b]\u0010^J\u0017\u0010`\u001a\u00020\t2\u0006\u0010_\u001a\u00020\bH\u0002¢\u0006\u0004\b`\u0010'J\u001f\u0010c\u001a\u00020\t2\u0006\u0010a\u001a\u00020\u001d2\u0006\u0010b\u001a\u00020(H\u0002¢\u0006\u0004\bc\u0010dR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010o\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010q\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010nR\u0018\u0010t\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010sR\u0016\u0010v\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010nR\u001c\u0010y\u001a\b\u0012\u0004\u0012\u00020<0w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010xR\u0018\u0010;\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0018\u00107\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010nR\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R&\u0010\u0085\u0001\u001a\u000f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020(0\u0082\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0019\u0010\u0088\u0001\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R'\u0010\u008b\u0001\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R!\u0010\u008e\u0001\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0019\u0010\u0091\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0019\u0010\u0093\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0090\u0001¨\u0006\u0095\u0001"}, d2 = {"Lcom/transsion/subtitle/fragment/SubtitleSearchResultListFragment;", "Lcom/transsion/baseui/fragment/LazyFragment;", "Lfu/b;", "Lcom/transsion/subtitle_download/a;", "Lhu/c;", "<init>", "()V", "Lkotlin/Function1;", "Leu/a;", "", "callback", "U0", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "T0", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "E0", "(Landroid/view/LayoutInflater;)Lfu/b;", "", "getPageStateLayoutTitle", "()Ljava/lang/String;", "", "isAudioShowNoNetworkLayout", "()Z", "initListener", "initViewData", "initViewModel", "lazyLoadData", "loadDefaultData", "bean", be.g.f16474b, "(Leu/a;)V", "", NotificationCompat.CATEGORY_PROGRESS, "Lcom/transsion/subtitle_download/db/SubtitleDownloadTable;", "dbBean", "onDownloading", "(ILcom/transsion/subtitle_download/db/SubtitleDownloadTable;)V", "onComplete", "(Lcom/transsion/subtitle_download/db/SubtitleDownloadTable;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "onFail", "(Ljava/lang/Exception;Lcom/transsion/subtitle_download/db/SubtitleDownloadTable;)V", "onDestroy", "retryLoadData", "searchName", "Q0", "(Ljava/lang/String;)V", "Lcom/transsion/baselib/db/download/DownloadBean;", "downloadBean", "Lcom/transsion/baselib/db/download/SubtitleLanguageMapBean;", "languageBean", "S0", "(Lcom/transsion/baselib/db/download/DownloadBean;Lcom/transsion/baselib/db/download/SubtitleLanguageMapBean;Ljava/lang/String;)V", "K0", "w0", "Y0", "", "Lcom/transsion/moviedetailapi/bean/SubtitleItem;", "items", "F0", "(Ljava/util/List;)Ljava/util/List;", "loadData", "P0", "loadMore", "list", "hasMore", "Z0", "(Ljava/util/List;Z)V", PushConstants.PUSH_SERVICE_TYPE_SHOW, "W0", "(Z)V", "X0", "showEmpty", "V0", "Landroid/content/Context;", "context", "getEmptyView", "(Landroid/content/Context;)Landroid/view/View;", "D0", "C0", "desText", "showLeftBtn", "y0", "(Landroid/content/Context;Ljava/lang/String;Z)Landroid/view/View;", WebConstants.FIELD_ITEM, "x0", "isSuccess", NativeComponentConstants.KEY_COMPONENT_TYPE, "R0", "(ZI)V", "Lcom/transsion/subtitle/viewmodel/SubtitleDownloadViewModel;", "a", "Lcom/transsion/subtitle/viewmodel/SubtitleDownloadViewModel;", "viewModel", "Lcom/transsion/subtitle/adapter/c;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsion/subtitle/adapter/c;", "resultAdapter", "c", "Ljava/lang/String;", "nextPage", "d", "pageName", "Lcom/transsion/subtitle/fragment/i;", "Lcom/transsion/subtitle/fragment/i;", "keyword", "f", "languages", "", "Ljava/util/List;", "languageList", "h", "Lcom/transsion/baselib/db/download/DownloadBean;", "i", com.mbridge.msdk.foundation.same.report.j.f35620b, "Lcom/transsion/baselib/db/download/SubtitleLanguageMapBean;", CampaignEx.JSON_KEY_AD_K, "Leu/a;", "currentSelectItem", "", "l", "Ljava/util/Map;", "curDownloadedMap", "m", "I", "currentSelectPosition", "n", "Lkotlin/jvm/functions/Function1;", "selectSubtitleCallback", "o", "Lkotlin/jvm/functions/Function0;", "onGetDataResultCallback", TtmlNode.TAG_P, "Z", "hasSubDownloading", CampaignEx.JSON_KEY_AD_Q, "isOpenSubtitle", CampaignEx.JSON_KEY_AD_R, "VideoSubtitle_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class SubtitleSearchResultListFragment extends LazyFragment<fu.b> implements com.transsion.subtitle_download.a, hu.c {

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private SubtitleDownloadViewModel viewModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private com.transsion.subtitle.adapter.c resultAdapter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String pageName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private i keyword;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private DownloadBean downloadBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String searchName;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private SubtitleLanguageMapBean languageBean;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private eu.a currentSelectItem;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private Function1 selectSubtitleCallback;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private Function0 onGetDataResultCallback;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean hasSubDownloading;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String nextPage = "1";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String languages = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private List languageList = new ArrayList();

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private Map curDownloadedMap = new LinkedHashMap();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int currentSelectPosition = -1;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean isOpenSubtitle = true;

    /* renamed from: com.transsion.subtitle.fragment.SubtitleSearchResultListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubtitleSearchResultListFragment a(DownloadBean downloadBean, SubtitleLanguageMapBean subtitleLanguageMapBean, String str, String str2) {
            SubtitleSearchResultListFragment subtitleSearchResultListFragment = new SubtitleSearchResultListFragment();
            subtitleSearchResultListFragment.S0(downloadBean, subtitleLanguageMapBean, str);
            subtitleSearchResultListFragment.setArguments(androidx.core.os.d.b(TuplesKt.a("KEY_PAGE_NAME", str2)));
            return subtitleSearchResultListFragment;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends RecyclerView.r {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            Intrinsics.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i11);
            if (i11 != 0 || recyclerView.canScrollVertically(1)) {
                return;
            }
            SubtitleSearchResultListFragment.this.K0();
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends DiffUtil.e {
        c() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(eu.a oldItem, eu.a newItem) {
            Intrinsics.h(oldItem, "oldItem");
            Intrinsics.h(newItem, "newItem");
            return Intrinsics.c(oldItem.b().getId(), newItem.b().getId()) && Intrinsics.c(oldItem.b().getUrl(), newItem.b().getUrl()) && oldItem.b().getStatus() == newItem.b().getStatus();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(eu.a oldItem, eu.a newItem) {
            Intrinsics.h(oldItem, "oldItem");
            Intrinsics.h(newItem, "newItem");
            return Intrinsics.c(oldItem.b().getUrl(), newItem.b().getUrl());
        }
    }

    /* loaded from: classes6.dex */
    static final class d implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f54960a;

        d(Function1 function) {
            Intrinsics.h(function, "function");
            this.f54960a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f54960a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.view.c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f54960a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(SubtitleSearchResultListFragment subtitleSearchResultListFragment, DefaultView defaultView, View view) {
        subtitleSearchResultListFragment.W0(true);
        subtitleSearchResultListFragment.loadData();
        defaultView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(DefaultView defaultView, View view) {
        try {
            Result.Companion companion = Result.INSTANCE;
            NetworkUtils.v();
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    private final View C0(Context context) {
        String string = context.getString(R$string.subtitle_load_failed);
        Intrinsics.g(string, "getString(...)");
        return z0(this, context, string, false, 4, null);
    }

    private final View D0(Context context) {
        String string = context.getString(com.tn.lib.widget.R$string.no_network_title);
        Intrinsics.g(string, "getString(...)");
        return y0(context, string, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0217 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x020d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List F0(java.util.List r40) {
        /*
            Method dump skipped, instructions count: 544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subtitle.fragment.SubtitleSearchResultListFragment.F0(java.util.List):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(SubtitleSearchResultListFragment subtitleSearchResultListFragment) {
        subtitleSearchResultListFragment.K0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(SubtitleSearchResultListFragment subtitleSearchResultListFragment, BaseQuickAdapter adapter, View view, int i11) {
        com.transsion.subtitle.adapter.c cVar;
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "<unused var>");
        Object item = adapter.getItem(i11);
        Intrinsics.f(item, "null cannot be cast to non-null type com.transsion.subtitle.bean.VideoSubtitleBean");
        eu.a aVar = (eu.a) item;
        if (aVar.b().getStatus() == 2) {
            return;
        }
        if (!aVar.d() && subtitleSearchResultListFragment.hasSubDownloading) {
            uh.b.f76876a.d(R$string.subtitle_is_downloading);
            return;
        }
        if (aVar.f()) {
            return;
        }
        aVar.l(true);
        if (subtitleSearchResultListFragment.currentSelectPosition == i11) {
            subtitleSearchResultListFragment.currentSelectPosition = -1;
            subtitleSearchResultListFragment.currentSelectItem = null;
            return;
        }
        eu.a aVar2 = subtitleSearchResultListFragment.currentSelectItem;
        if (aVar2 != null) {
            aVar2.l(false);
        }
        int i12 = subtitleSearchResultListFragment.currentSelectPosition;
        if (i12 >= 0 && (cVar = subtitleSearchResultListFragment.resultAdapter) != null) {
            cVar.notifyItemChanged(i12, subtitleSearchResultListFragment.currentSelectItem);
        }
        String str = subtitleSearchResultListFragment.pageName;
        if (str == null) {
            str = "";
        }
        aVar.k(str);
        subtitleSearchResultListFragment.currentSelectItem = aVar;
        subtitleSearchResultListFragment.currentSelectPosition = i11;
        com.transsion.subtitle.adapter.c cVar2 = subtitleSearchResultListFragment.resultAdapter;
        if (cVar2 != null) {
            cVar2.notifyItemChanged(i11, aVar);
        }
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "ORSubtitle_search", "select item = " + aVar.b().getName() + ", position = " + i11 + "， status:" + aVar.b().getStatus(), false, 4, null);
        if (aVar.d()) {
            Function1 function1 = subtitleSearchResultListFragment.selectSubtitleCallback;
            if (function1 != null) {
                function1.invoke(aVar);
                return;
            }
            return;
        }
        aVar.b().setStatus(2);
        a.C0856a.r(c0856a, "ORSubtitle_search", new String[]{"itemClick, resourceId:" + aVar.b().getId() + ", name:" + aVar.b().getName() + " index:" + i11 + ", isOpenSubNewApi:" + aVar.e()}, false, 4, null);
        subtitleSearchResultListFragment.curDownloadedMap.put(aVar, Integer.valueOf(i11));
        subtitleSearchResultListFragment.x0(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(SubtitleSearchResultListFragment subtitleSearchResultListFragment, SubtitleSearchListBean subtitleSearchListBean) {
        String str;
        Boolean hasMore;
        r6.f h02;
        r6.f h03;
        com.transsion.subtitle.adapter.c cVar;
        r6.f h04;
        List<Object> data;
        boolean z10 = false;
        subtitleSearchResultListFragment.W0(false);
        Function0 function0 = subtitleSearchResultListFragment.onGetDataResultCallback;
        if (function0 != null) {
            function0.invoke();
        }
        subtitleSearchResultListFragment.isOpenSubtitle = subtitleSearchListBean != null && subtitleSearchListBean.getSearchType() == 2;
        if (subtitleSearchListBean == null || !subtitleSearchListBean.isRefresh()) {
            subtitleSearchResultListFragment.R0(false, 2);
        } else {
            subtitleSearchResultListFragment.R0(true, subtitleSearchListBean.getSearchType());
        }
        if (subtitleSearchListBean != null) {
            Pager pager = subtitleSearchListBean.getPager();
            if (pager == null || (str = pager.getNextPage()) == null) {
                str = "1";
            }
            subtitleSearchResultListFragment.nextPage = str;
            List F0 = subtitleSearchResultListFragment.F0(subtitleSearchListBean.getItems());
            Pager pager2 = subtitleSearchListBean.getPager();
            if (pager2 != null && (hasMore = pager2.getHasMore()) != null) {
                z10 = hasMore.booleanValue();
            }
            subtitleSearchResultListFragment.Z0(F0, z10);
            return Unit.f67184a;
        }
        com.transsion.subtitle.adapter.c cVar2 = subtitleSearchResultListFragment.resultAdapter;
        if (cVar2 == null || (data = cVar2.getData()) == null || data.size() != 0) {
            com.transsion.subtitle.adapter.c cVar3 = subtitleSearchResultListFragment.resultAdapter;
            if (cVar3 != null && (h03 = cVar3.h0()) != null && h03.r() && (cVar = subtitleSearchResultListFragment.resultAdapter) != null && (h04 = cVar.h0()) != null) {
                h04.v();
            }
            com.transsion.subtitle.adapter.c cVar4 = subtitleSearchResultListFragment.resultAdapter;
            if (cVar4 != null && (h02 = cVar4.h0()) != null) {
                r6.f.u(h02, false, 1, null);
            }
        } else if (nh.m.f70597a.e()) {
            subtitleSearchResultListFragment.V0();
        } else {
            subtitleSearchResultListFragment.X0();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(SubtitleSearchResultListFragment subtitleSearchResultListFragment, eu.a aVar) {
        if (aVar != null) {
            String url = aVar.b().getUrl();
            if (url == null || url.length() == 0) {
                aVar.b().setStatus(6);
                subtitleSearchResultListFragment.Y0(aVar);
            } else {
                subtitleSearchResultListFragment.x0(aVar);
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void K0() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        r6.f h02;
        r6.f h03;
        if (this.isOpenSubtitle) {
            return;
        }
        com.transsion.subtitle.adapter.c cVar = this.resultAdapter;
        if (cVar == null || (h03 = cVar.h0()) == null || !h03.r()) {
            if (!nh.m.f70597a.e()) {
                uh.b.f76876a.d(com.tn.lib.widget.R$string.no_network_toast);
                fu.b bVar = (fu.b) getMViewBinding();
                if (bVar == null || (recyclerView = bVar.f62601d) == null) {
                    return;
                }
                recyclerView.postDelayed(new Runnable() { // from class: com.transsion.subtitle.fragment.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        SubtitleSearchResultListFragment.M0(SubtitleSearchResultListFragment.this);
                    }
                }, 500L);
                return;
            }
            com.transsion.subtitle.adapter.c cVar2 = this.resultAdapter;
            if (cVar2 != null && (h02 = cVar2.h0()) != null) {
                h02.w();
            }
            fu.b bVar2 = (fu.b) getMViewBinding();
            if (bVar2 == null || (recyclerView2 = bVar2.f62601d) == null) {
                return;
            }
            recyclerView2.postDelayed(new Runnable() { // from class: com.transsion.subtitle.fragment.n
                @Override // java.lang.Runnable
                public final void run() {
                    SubtitleSearchResultListFragment.L0(SubtitleSearchResultListFragment.this);
                }
            }, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(SubtitleSearchResultListFragment subtitleSearchResultListFragment) {
        subtitleSearchResultListFragment.loadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(SubtitleSearchResultListFragment subtitleSearchResultListFragment) {
        r6.f h02;
        com.transsion.subtitle.adapter.c cVar = subtitleSearchResultListFragment.resultAdapter;
        if (cVar == null || (h02 = cVar.h0()) == null) {
            return;
        }
        h02.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(SubtitleSearchResultListFragment subtitleSearchResultListFragment, SubtitleDownloadTable subtitleDownloadTable) {
        List<Object> data;
        Object obj;
        com.transsion.subtitle.adapter.c cVar = subtitleSearchResultListFragment.resultAdapter;
        if (cVar == null || (data = cVar.getData()) == null) {
            return;
        }
        Iterator<T> it = data.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.c(((eu.a) obj).b().getId(), subtitleDownloadTable.getId())) {
                    break;
                }
            }
        }
        eu.a aVar = (eu.a) obj;
        if (aVar != null) {
            aVar.h(subtitleDownloadTable);
            a.C0856a c0856a = lg.a.f68962a;
            String a11 = com.transsion.baselib.report.a.f43394a.a();
            DownloadBean downloadBean = subtitleSearchResultListFragment.downloadBean;
            String totalTitleName = downloadBean != null ? downloadBean.getTotalTitleName() : null;
            c0856a.c(a11, "搜索字幕下载成功，name = " + totalTitleName + ", subtype = " + aVar.b().getType() + ", download subtitleName = " + aVar.b().getSubtitleName() + ", lan = " + aVar.b().getLan() + "~", true);
            com.transsion.subtitle.adapter.c cVar2 = subtitleSearchResultListFragment.resultAdapter;
            Intrinsics.e(cVar2);
            aVar.l(cVar2.getData().indexOf(aVar) == subtitleSearchResultListFragment.currentSelectPosition);
            subtitleSearchResultListFragment.Y0(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(SubtitleSearchResultListFragment subtitleSearchResultListFragment, SubtitleDownloadTable subtitleDownloadTable) {
        List<Object> data;
        Object obj;
        subtitleSearchResultListFragment.currentSelectPosition = -1;
        subtitleSearchResultListFragment.currentSelectItem = null;
        com.transsion.subtitle.adapter.c cVar = subtitleSearchResultListFragment.resultAdapter;
        if (cVar == null || (data = cVar.getData()) == null) {
            return;
        }
        Iterator<T> it = data.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.c(((eu.a) obj).b().getId(), subtitleDownloadTable.getId())) {
                    break;
                }
            }
        }
        eu.a aVar = (eu.a) obj;
        if (aVar != null) {
            aVar.h(subtitleDownloadTable);
            a.C0856a c0856a = lg.a.f68962a;
            String a11 = com.transsion.baselib.report.a.f43394a.a();
            DownloadBean downloadBean = subtitleSearchResultListFragment.downloadBean;
            String totalTitleName = downloadBean != null ? downloadBean.getTotalTitleName() : null;
            c0856a.x(a11, "搜索字幕下载失败TnT，name = " + totalTitleName + ", subtype = " + aVar.b().getType() + ", download subtitleName = " + aVar.b().getSubtitleName() + ", lan = " + aVar.b().getLan() + "~ , url：" + aVar.b().getUrl(), true);
            subtitleSearchResultListFragment.Y0(aVar);
        }
    }

    private final void P0() {
        this.nextPage = "1";
        com.transsion.subtitle.adapter.c cVar = this.resultAdapter;
        if (cVar != null) {
            cVar.n1(CollectionsKt.l());
        }
        if (!nh.m.f70597a.e()) {
            X0();
            return;
        }
        W0(true);
        SubtitleDownloadViewModel subtitleDownloadViewModel = this.viewModel;
        if (subtitleDownloadViewModel != null) {
            SubtitleDownloadViewModel.u(subtitleDownloadViewModel, this.keyword, this.languages, this.languageList, this.downloadBean, this.nextPage, 0, 32, null);
        }
    }

    private final void R0(boolean isSuccess, int type) {
        DownloadBean downloadBean;
        SubtitleLanguageMapBean subtitleLanguageMapBean;
        String lan;
        String str = this.pageName;
        if (str == null || (downloadBean = this.downloadBean) == null || (subtitleLanguageMapBean = this.languageBean) == null || (lan = subtitleLanguageMapBean.getLan()) == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("result", isSuccess ? "1" : "0");
        linkedHashMap.put(NativeComponentConstants.KEY_COMPONENT_TYPE, String.valueOf(type));
        linkedHashMap.put("lan", lan);
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = "";
        }
        linkedHashMap.put("resource_id", resourceId);
        String subjectId = downloadBean.getSubjectId();
        linkedHashMap.put("subject_id", subjectId != null ? subjectId : "");
        if (downloadBean.getEp() > 0) {
            linkedHashMap.put("ep", String.valueOf(downloadBean.getEp()));
        }
        if (downloadBean.getSe() > 0) {
            linkedHashMap.put("se", String.valueOf(downloadBean.getSe()));
        }
        hj.i.f64628a.s(str, "subtitle_search", linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S0(DownloadBean downloadBean, SubtitleLanguageMapBean languageBean, String searchName) {
        this.downloadBean = downloadBean;
        this.searchName = searchName;
        if (languageBean != null) {
            this.languageBean = languageBean;
            this.languages = languageBean.getLan();
            this.languageList.add(languageBean);
        }
    }

    private final void V0() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a.C0856a.f(lg.a.f68962a, "ORSubtitle_search", "showFail~", false, 4, null);
        W0(false);
        com.transsion.subtitle.adapter.c cVar = this.resultAdapter;
        if (cVar != null) {
            cVar.Y0(C0(context));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void W0(boolean show) {
        LinearLayoutCompat linearLayoutCompat;
        fu.b bVar = (fu.b) getMViewBinding();
        if (bVar == null || (linearLayoutCompat = bVar.f62600c) == null) {
            return;
        }
        linearLayoutCompat.setVisibility(show ? 0 : 8);
    }

    private final void X0() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a.C0856a.f(lg.a.f68962a, "ORSubtitle_search", "showNotNet~", false, 4, null);
        W0(false);
        com.transsion.subtitle.adapter.c cVar = this.resultAdapter;
        if (cVar != null) {
            cVar.Y0(D0(context));
        }
    }

    private final void Y0(eu.a bean) {
        int indexOf;
        com.transsion.subtitle.adapter.c cVar;
        com.transsion.subtitle.adapter.c cVar2 = this.resultAdapter;
        if (cVar2 == null || (indexOf = cVar2.getData().indexOf(bean)) < 0 || !isAdded() || (cVar = this.resultAdapter) == null) {
            return;
        }
        cVar.notifyItemChanged(indexOf, bean);
    }

    private final void Z0(List list, boolean hasMore) {
        List<Object> l11;
        r6.f h02;
        r6.f h03;
        com.transsion.subtitle.adapter.c cVar;
        r6.f h04;
        List<Object> data;
        r6.f h05;
        r6.f h06;
        com.transsion.subtitle.adapter.c cVar2;
        r6.f h07;
        r6.f h08;
        List<Object> data2;
        if (list.isEmpty()) {
            com.transsion.subtitle.adapter.c cVar3 = this.resultAdapter;
            if (cVar3 != null && (data2 = cVar3.getData()) != null && data2.size() == 0) {
                if (nh.m.f70597a.e()) {
                    showEmpty();
                } else {
                    X0();
                }
            }
            com.transsion.subtitle.adapter.c cVar4 = this.resultAdapter;
            if (cVar4 == null || (h08 = cVar4.h0()) == null) {
                return;
            }
            r6.f.u(h08, false, 1, null);
            return;
        }
        com.transsion.subtitle.adapter.c cVar5 = this.resultAdapter;
        if (cVar5 != null && (data = cVar5.getData()) != null && data.isEmpty()) {
            com.transsion.subtitle.adapter.c cVar6 = this.resultAdapter;
            if (cVar6 != null) {
                cVar6.n1(list);
            }
            if (!hasMore) {
                com.transsion.subtitle.adapter.c cVar7 = this.resultAdapter;
                if (cVar7 == null || (h05 = cVar7.h0()) == null) {
                    return;
                }
                r6.f.u(h05, false, 1, null);
                return;
            }
            com.transsion.subtitle.adapter.c cVar8 = this.resultAdapter;
            if (cVar8 == null || (h06 = cVar8.h0()) == null || !h06.r() || (cVar2 = this.resultAdapter) == null || (h07 = cVar2.h0()) == null) {
                return;
            }
            h07.s();
            return;
        }
        com.transsion.subtitle.adapter.c cVar9 = this.resultAdapter;
        if (cVar9 == null || (l11 = cVar9.getData()) == null) {
            l11 = CollectionsKt.l();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            eu.a aVar = (eu.a) obj;
            List<Object> list2 = l11;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.c(aVar.b().getUrl(), ((eu.a) it.next()).b().getUrl())) {
                        break;
                    }
                }
            }
            arrayList.add(obj);
        }
        if (arrayList.isEmpty()) {
            a.C0856a.f(lg.a.f68962a, "ORSubtitle_search", "全部去重了~", false, 4, null);
            return;
        }
        com.transsion.subtitle.adapter.c cVar10 = this.resultAdapter;
        if (cVar10 != null) {
            cVar10.q(arrayList);
        }
        if (!hasMore) {
            com.transsion.subtitle.adapter.c cVar11 = this.resultAdapter;
            if (cVar11 == null || (h02 = cVar11.h0()) == null) {
                return;
            }
            r6.f.u(h02, false, 1, null);
            return;
        }
        com.transsion.subtitle.adapter.c cVar12 = this.resultAdapter;
        if (cVar12 == null || (h03 = cVar12.h0()) == null || !h03.r() || (cVar = this.resultAdapter) == null || (h04 = cVar.h0()) == null) {
            return;
        }
        h04.s();
    }

    private final View getEmptyView(Context context) {
        String string = context.getString(R$string.subtitle_no_subtitles_found);
        Intrinsics.g(string, "getString(...)");
        return z0(this, context, string, false, 4, null);
    }

    private final void loadData() {
        if (!nh.m.f70597a.e()) {
            X0();
            return;
        }
        SubtitleDownloadViewModel subtitleDownloadViewModel = this.viewModel;
        if (subtitleDownloadViewModel != null) {
            SubtitleDownloadViewModel.u(subtitleDownloadViewModel, this.keyword, this.languages, this.languageList, this.downloadBean, this.nextPage, 0, 32, null);
        }
    }

    private final void loadMore() {
        SubtitleDownloadViewModel subtitleDownloadViewModel = this.viewModel;
        if (subtitleDownloadViewModel != null) {
            SubtitleDownloadViewModel.u(subtitleDownloadViewModel, this.keyword, this.languages, this.languageList, this.downloadBean, this.nextPage, 0, 32, null);
        }
    }

    private final void showEmpty() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a.C0856a.f(lg.a.f68962a, "ORSubtitle_search", "showEmpty~", false, 4, null);
        W0(false);
        com.transsion.subtitle.adapter.c cVar = this.resultAdapter;
        if (cVar != null) {
            cVar.Y0(getEmptyView(context));
        }
    }

    private final void w0() {
        h.a aVar = com.transsion.subtitle.h.f55010a;
        aVar.b().b(this);
        aVar.b().d(this);
    }

    private final void x0(eu.a item) {
        String url;
        if (item.e() && ((url = item.b().getUrl()) == null || url.length() == 0)) {
            lg.a.f68962a.c(com.transsion.baselib.report.a.f43394a.a(), "搜索下载字幕，是opensubtitle 新api，需要先请求才能下载", true);
            SubtitleDownloadViewModel subtitleDownloadViewModel = this.viewModel;
            if (subtitleDownloadViewModel != null) {
                subtitleDownloadViewModel.k(item);
                return;
            }
            return;
        }
        this.hasSubDownloading = true;
        a.C0856a c0856a = lg.a.f68962a;
        String a11 = com.transsion.baselib.report.a.f43394a.a();
        DownloadBean downloadBean = this.downloadBean;
        String totalTitleName = downloadBean != null ? downloadBean.getTotalTitleName() : null;
        c0856a.c(a11, "搜索下载字幕，name = " + totalTitleName + ", subtype = " + item.b().getType() + ", download subtitleName = " + item.b().getSubtitleName() + ", subResourceId = " + item.b().getId() + "~", true);
        item.b().setSetImmediately(true);
        com.transsion.subtitle.h.f55010a.b().j(item);
    }

    private final View y0(Context context, String desText, boolean showLeftBtn) {
        final DefaultView defaultView = new DefaultView(context, DefaultView.ModelStyle.MODEL_STYLE_NIGHT);
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_DES_BTN);
        defaultView.setDescText(desText);
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_NO_IMAGE);
        defaultView.setBtnVisibility(0);
        String string = context.getString(com.transsion.baseui.R$string.retry_text);
        Intrinsics.g(string, "getString(...)");
        defaultView.setBtnText(string);
        defaultView.setTipOperationVisibility(8);
        defaultView.setBtnBg(androidx.core.content.b.getDrawable(Utils.a(), R$drawable.post_detail_shape_subtitle_empty_btn_bg));
        defaultView.setBtnTextColor(-1);
        defaultView.setBackgroundColor(0);
        defaultView.setBtnClickListener(new View.OnClickListener() { // from class: com.transsion.subtitle.fragment.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubtitleSearchResultListFragment.A0(SubtitleSearchResultListFragment.this, defaultView, view);
            }
        });
        defaultView.setLeftBtnVisibility(showLeftBtn ? 0 : 8);
        String string2 = context.getString(com.tn.lib.widget.R$string.go_to_setting);
        Intrinsics.g(string2, "getString(...)");
        defaultView.setLeftBtnText(string2);
        defaultView.setLeftBtnBg(androidx.core.content.b.getDrawable(Utils.a(), R$drawable.post_detail_shape_subtitle_empty_btn_bg));
        defaultView.setLeftBtnTextColor(-1);
        defaultView.setLeftBtnClickListener(new View.OnClickListener() { // from class: com.transsion.subtitle.fragment.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubtitleSearchResultListFragment.B0(DefaultView.this, view);
            }
        });
        defaultView.setTitleViewVisibility(8);
        int a11 = com.blankj.utilcode.util.a0.a(16.0f);
        defaultView.setPadding(a11, com.blankj.utilcode.util.a0.a(30.0f), a11, 0);
        defaultView.setVisibility(0);
        return defaultView;
    }

    static /* synthetic */ View z0(SubtitleSearchResultListFragment subtitleSearchResultListFragment, Context context, String str, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return subtitleSearchResultListFragment.y0(context, str, z10);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public fu.b getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        fu.b c11 = fu.b.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // hu.c
    public void J(boolean z10, DownloadBean downloadBean) {
        c.a.a(this, z10, downloadBean);
    }

    public final void Q0(String searchName) {
        if (searchName == null || searchName.length() == 0) {
            return;
        }
        this.searchName = searchName;
        DownloadBean downloadBean = this.downloadBean;
        int se2 = downloadBean != null ? downloadBean.getSe() : 0;
        DownloadBean downloadBean2 = this.downloadBean;
        this.keyword = new i(searchName, se2, downloadBean2 != null ? downloadBean2.getEp() : 0);
        P0();
    }

    public final void T0(Function0 callback) {
        this.onGetDataResultCallback = callback;
    }

    public final void U0(Function1 callback) {
        this.selectSubtitleCallback = callback;
    }

    @Override // hu.c
    public void g(eu.a bean) {
        com.transsion.subtitle.adapter.c cVar;
        List<Object> data;
        Intrinsics.h(bean, "bean");
        for (Map.Entry entry : this.curDownloadedMap.entrySet()) {
            eu.a aVar = (eu.a) entry.getKey();
            int intValue = ((Number) entry.getValue()).intValue();
            if (!Intrinsics.c(bean.b().getId(), aVar.b().getId())) {
                a.C0856a c0856a = lg.a.f68962a;
                a.C0856a.v(c0856a, "ORSubtitle_search", "subtitleSelected, resourceId = " + aVar.b().getId() + ", name = " + aVar.b().getName(), false, 4, null);
                try {
                    Result.Companion companion = Result.INSTANCE;
                    aVar.l(false);
                    if (intValue < 0) {
                        com.transsion.subtitle.adapter.c cVar2 = this.resultAdapter;
                        intValue = (cVar2 == null || (data = cVar2.getData()) == null) ? -1 : data.indexOf(aVar);
                    }
                    a.C0856a.v(c0856a, "ORSubtitle_search", "subtitleSelected2, index = " + intValue, false, 4, null);
                    if (intValue >= 0 && (cVar = this.resultAdapter) != null) {
                        cVar.notifyItemChanged(intValue, aVar);
                    }
                    Result.m1185constructorimpl(Unit.f67184a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m1185constructorimpl(ResultKt.a(th2));
                }
            }
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        RecyclerView recyclerView;
        com.transsion.subtitle.adapter.c cVar = new com.transsion.subtitle.adapter.c(true, new ArrayList());
        cVar.h0().C(new SubtitleDialogLoadMoreView());
        cVar.h0().z(true);
        cVar.h0().y(true);
        cVar.h0().E(2);
        cVar.h0().D(new p6.f() { // from class: com.transsion.subtitle.fragment.l
            @Override // p6.f
            public final void a() {
                SubtitleSearchResultListFragment.G0(SubtitleSearchResultListFragment.this);
            }
        });
        cVar.R0(new c());
        cVar.w1(new p6.d() { // from class: com.transsion.subtitle.fragment.m
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                SubtitleSearchResultListFragment.H0(SubtitleSearchResultListFragment.this, baseQuickAdapter, view, i11);
            }
        });
        this.resultAdapter = cVar;
        fu.b bVar = (fu.b) getMViewBinding();
        if (bVar == null || (recyclerView = bVar.f62601d) == null) {
            return;
        }
        recyclerView.setAdapter(this.resultAdapter);
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView;
        Intrinsics.h(view, "view");
        super.initViewData(view, savedInstanceState);
        fu.b bVar = (fu.b) getMViewBinding();
        if (bVar == null || (recyclerView = bVar.f62601d) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new b());
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        String e11;
        androidx.view.b0 l11;
        androidx.view.b0 o11;
        String subtitleResId;
        SubtitleDownloadViewModel subtitleDownloadViewModel = (SubtitleDownloadViewModel) new v0(this).a(SubtitleDownloadViewModel.class);
        DownloadBean downloadBean = this.downloadBean;
        if (downloadBean != null && (subtitleResId = downloadBean.getSubtitleResId()) != null) {
            subtitleDownloadViewModel.g(subtitleResId);
        }
        this.viewModel = subtitleDownloadViewModel;
        String str = this.searchName;
        if (str == null || str.length() == 0) {
            e11 = SubtitleSearchHelper.f55013c.a().e(this.downloadBean);
        } else {
            e11 = this.searchName;
            Intrinsics.e(e11);
        }
        DownloadBean downloadBean2 = this.downloadBean;
        int se2 = downloadBean2 != null ? downloadBean2.getSe() : 0;
        DownloadBean downloadBean3 = this.downloadBean;
        this.keyword = new i(e11, se2, downloadBean3 != null ? downloadBean3.getEp() : 0);
        SubtitleDownloadViewModel subtitleDownloadViewModel2 = this.viewModel;
        if (subtitleDownloadViewModel2 != null && (o11 = subtitleDownloadViewModel2.o()) != null) {
            o11.j(this, new d(new Function1() { // from class: com.transsion.subtitle.fragment.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit I0;
                    I0 = SubtitleSearchResultListFragment.I0(SubtitleSearchResultListFragment.this, (SubtitleSearchListBean) obj);
                    return I0;
                }
            }));
        }
        SubtitleDownloadViewModel subtitleDownloadViewModel3 = this.viewModel;
        if (subtitleDownloadViewModel3 == null || (l11 = subtitleDownloadViewModel3.l()) == null) {
            return;
        }
        l11.j(this, new d(new Function1() { // from class: com.transsion.subtitle.fragment.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit J0;
                J0 = SubtitleSearchResultListFragment.J0(SubtitleSearchResultListFragment.this, (eu.a) obj);
                return J0;
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        w0();
        W0(true);
        loadData();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void loadDefaultData() {
    }

    @Override // com.transsion.subtitle_download.a
    public void onComplete(final SubtitleDownloadTable dbBean) {
        Intrinsics.h(dbBean, "dbBean");
        this.hasSubDownloading = false;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.transsion.subtitle.fragment.r
                @Override // java.lang.Runnable
                public final void run() {
                    SubtitleSearchResultListFragment.N0(SubtitleSearchResultListFragment.this, dbBean);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        h.a aVar = com.transsion.subtitle.h.f55010a;
        aVar.b().c(this);
        aVar.b().f(this);
    }

    @Override // com.transsion.subtitle_download.a
    public void onDownloading(int progress, SubtitleDownloadTable dbBean) {
        Intrinsics.h(dbBean, "dbBean");
    }

    @Override // com.transsion.subtitle_download.a
    public void onFail(Exception e11, final SubtitleDownloadTable dbBean) {
        Intrinsics.h(e11, "e");
        Intrinsics.h(dbBean, "dbBean");
        this.hasSubDownloading = false;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.transsion.subtitle.fragment.s
                @Override // java.lang.Runnable
                public final void run() {
                    SubtitleSearchResultListFragment.O0(SubtitleSearchResultListFragment.this, dbBean);
                }
            });
        }
    }

    @Override // com.transsion.subtitle_download.a
    public void onSaveDownload(SubtitleDownloadTable subtitleDownloadTable) {
        a.C0697a.a(this, subtitleDownloadTable);
    }

    @Override // com.transsion.subtitle_download.a
    public void onUnGzZip(SubtitleDownloadTable subtitleDownloadTable) {
        a.C0697a.b(this, subtitleDownloadTable);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.pageName = arguments.getString("KEY_PAGE_NAME", "");
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
        W0(true);
        loadData();
    }
}
