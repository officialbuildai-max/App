package com.transsion.home.fragment.filter;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.view.v0;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.google.android.material.tabs.TabLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.view.NoNetworkBigView;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$string;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.home.R$drawable;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.bean.RefreshBaseDto;
import com.transsion.home.bean.UGCFilterVideoItem;
import com.transsion.home.bean.ugc.UGCFilterGrade;
import com.transsion.home.bean.ugc.UGCFilterItem;
import com.transsion.home.bean.ugc.UGCFilterResponse;
import com.transsion.home.fragment.tab.BaseHomeSubFragment;
import com.transsion.home.p004enum.HomeTabId;
import com.transsion.home.view.filter.expand.UGCFilterExpandView;
import com.transsion.home.view.layoutmanager.OffsetGridLayoutManager;
import com.transsion.home.viewmodel.UGCFilterViewModel;
import com.transsion.ugcvideodetail.api.UGCVideoType;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import com.transsion.ugcvideodetail.api.bean.UGCContentList;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import gl.f0;
import gl.n0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import lg.a;
import nh.n;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0010\b\u0007\u0018\u0000 ±\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004²\u0001³\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u001b\u0010\u000f\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0007H\u0002¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\"\u0010\u0004J!\u0010&\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010%\u001a\u00020\rH\u0002¢\u0006\u0004\b&\u0010'J\u001b\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120(H\u0002¢\u0006\u0004\b)\u0010*J+\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120+j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012`,H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0007H\u0002¢\u0006\u0004\b/\u0010\u0004J\u0017\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0018H\u0002¢\u0006\u0004\b1\u0010\u001bJ\u0017\u00102\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\rH\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0007H\u0002¢\u0006\u0004\b4\u0010\u0004J\u0019\u00106\u001a\u0004\u0018\u00010\u00122\u0006\u00105\u001a\u00020\u0012H\u0002¢\u0006\u0004\b6\u00107J\u0019\u00109\u001a\u0004\u0018\u00010\u00122\u0006\u00108\u001a\u00020\u0012H\u0002¢\u0006\u0004\b9\u00107J\u000f\u0010:\u001a\u00020\u0007H\u0002¢\u0006\u0004\b:\u0010\u0004J\u000f\u0010;\u001a\u00020\u0007H\u0002¢\u0006\u0004\b;\u0010\u0004J\u0019\u0010=\u001a\u00020\u00072\b\u0010<\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u0007H\u0002¢\u0006\u0004\b?\u0010\u0004J\u000f\u0010A\u001a\u00020@H\u0002¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020@H\u0002¢\u0006\u0004\bC\u0010BJ\u000f\u0010D\u001a\u00020\u0007H\u0002¢\u0006\u0004\bD\u0010\u0004J+\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120(2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010E\u001a\u00020\u0012H\u0002¢\u0006\u0004\bF\u0010GJ\u0017\u0010J\u001a\u00020\u00022\u0006\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bJ\u0010KJ\u0019\u0010N\u001a\u00020\u00072\b\u0010M\u001a\u0004\u0018\u00010LH\u0016¢\u0006\u0004\bN\u0010OJ!\u0010Q\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00052\b\u0010M\u001a\u0004\u0018\u00010LH\u0017¢\u0006\u0004\bQ\u0010RJ\u000f\u0010S\u001a\u00020\u0007H\u0016¢\u0006\u0004\bS\u0010\u0004J\u000f\u0010T\u001a\u00020\u0007H\u0016¢\u0006\u0004\bT\u0010\u0004J\u000f\u0010U\u001a\u00020\u0007H\u0016¢\u0006\u0004\bU\u0010\u0004J\u000f\u0010V\u001a\u00020\u0007H\u0016¢\u0006\u0004\bV\u0010\u0004J\u0017\u0010X\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\rH\u0016¢\u0006\u0004\bX\u00103J\u000f\u0010Y\u001a\u00020\u0007H\u0016¢\u0006\u0004\bY\u0010\u0004J\u000f\u0010[\u001a\u00020ZH\u0016¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\u0007H\u0016¢\u0006\u0004\b]\u0010\u0004J\u000f\u0010^\u001a\u00020\u0012H\u0016¢\u0006\u0004\b^\u0010_J\u000f\u0010`\u001a\u00020\u0007H\u0016¢\u0006\u0004\b`\u0010\u0004J\u0011\u0010b\u001a\u0004\u0018\u00010aH\u0016¢\u0006\u0004\bb\u0010cJ\u001f\u0010g\u001a\u00020\u00072\u0006\u0010d\u001a\u00020@2\u0006\u0010f\u001a\u00020eH\u0016¢\u0006\u0004\bg\u0010hR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010p\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010}\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010\u0081\u0001\u001a\u00020~8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0019\u0010\u0084\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001b\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0083\u0001R\u001b\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0083\u0001R\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R+\u0010\u0091\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00180\u008e\u00010\u008d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001b\u0010\u0094\u0001\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001b\u0010\u0096\u0001\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0093\u0001R\u001b\u0010\u0098\u0001\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0093\u0001R\u001b\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u0083\u0001R\u0018\u0010\u009c\u0001\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010|R\u001c\u0010 \u0001\u001a\u0005\u0018\u00010\u009d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R9\u0010£\u0001\u001a\"\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010+j\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u0001`,8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R\u001a\u0010§\u0001\u001a\u00030¤\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u0019\u0010ª\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u001a\u0010¬\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b«\u0001\u0010rR\u001a\u0010®\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u00ad\u0001\u0010rR\u001a\u0010°\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¯\u0001\u0010r¨\u0006´\u0001"}, d2 = {"Lcom/transsion/home/fragment/filter/UGCFilterFragment;", "Lcom/transsion/home/fragment/tab/BaseHomeSubFragment;", "Lgl/o;", "<init>", "()V", "Landroid/view/View;", "header", "", "t1", "(Landroid/view/View;)V", "headerView", "s1", "Lcom/google/android/material/tabs/TabLayout$Tab;", "", "selected", "X0", "(Lcom/google/android/material/tabs/TabLayout$Tab;Z)V", "tab", "", CampaignEx.JSON_KEY_TITLE, "D1", "(Lcom/google/android/material/tabs/TabLayout$Tab;Ljava/lang/String;Z)V", "n1", "l1", "Lcom/transsion/home/bean/ugc/UGCFilterItem;", WebConstants.FIELD_ITEM, "C1", "(Lcom/transsion/home/bean/ugc/UGCFilterItem;)V", "o1", "i1", "Z0", "initViewModel", "loadData", "E1", "loadMore", "Lcom/transsion/ugcvideodetail/api/bean/UGCContentList;", "contentList", "isRefresh", "K1", "(Lcom/transsion/ugcvideodetail/api/bean/UGCContentList;Z)V", "", "Y0", "()Ljava/util/Map;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "j1", "()Ljava/util/HashMap;", "J1", "ugcFilterItem", "B1", "A1", "(Z)V", "M1", "categoryId", "a1", "(Ljava/lang/String;)Ljava/lang/String;", "gradeCode", "b1", "showLoadingView", "g1", "string", "H1", "(Ljava/lang/String;)V", "h1", "", "e1", "()I", "d1", "k1", "key", "c1", "(Lcom/transsion/home/bean/ugc/UGCFilterItem;Ljava/lang/String;)Ljava/util/Map;", "Landroid/view/LayoutInflater;", "inflater", "f1", "(Landroid/view/LayoutInflater;)Lgl/o;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "startLoading", "hideLoading", "onResume", "hidden", "onHiddenChanged", "onPause", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "onDestroyView", "g0", "()Ljava/lang/String;", "c0", "Landroidx/recyclerview/widget/RecyclerView;", "f0", "()Landroidx/recyclerview/widget/RecyclerView;", "lastAdPosition", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "wrapperNativeManager", "l0", "(ILcom/transsion/ad/bidding/nativead/BiddingNativeManager;)V", "Lcom/transsion/home/adapter/filter/a;", be.g.f16474b, "Lcom/transsion/home/adapter/filter/a;", "mAdapter", "Lcom/transsion/home/viewmodel/UGCFilterViewModel;", "h", "Lcom/transsion/home/viewmodel/UGCFilterViewModel;", "mMovieModel", "i", "Landroid/view/View;", "Lgl/n0;", com.mbridge.msdk.foundation.same.report.j.f35620b, "Lgl/n0;", "headerBinding", "Lcom/transsion/home/view/filter/expand/UGCFilterExpandView;", CampaignEx.JSON_KEY_AD_K, "Lcom/transsion/home/view/filter/expand/UGCFilterExpandView;", "filterView", "l", "I", "mPage", "Lcom/transsion/home/fragment/filter/UGCFilterFragment$TabType;", "m", "Lcom/transsion/home/fragment/filter/UGCFilterFragment$TabType;", "mCurrentTab", "n", "Ljava/lang/String;", "mCategory", "o", "mFilterJson", TtmlNode.TAG_P, "fromOptId", "Lcom/transsion/home/bean/ugc/UGCFilterResponse;", CampaignEx.JSON_KEY_AD_Q, "Lcom/transsion/home/bean/ugc/UGCFilterResponse;", "mFilterResponse", "", "", CampaignEx.JSON_KEY_AD_R, "Ljava/util/Map;", "categoryChildrenByParentIdMap", "s", "Ljava/lang/Integer;", "mSelectedLevel2", "t", "mSelectedLevel3", TmcStartParams.KEY_URL_SHORT, "mSelectedLevel4", "v", "mSelectedGrade", "w", "mPerPage", "Lhl/b;", "x", "Lhl/b;", "mExposureHelper", "y", "Ljava/util/HashMap;", "mLatestSelectItems", "", "z", "J", "firstLoadStartTimeMillis", "A", "Z", "hasRecordedFirstLoadDuration", "B", "mNoNetworkView", "C", "mLoadingView", "D", "mNoResultView", "E", "a", "TabType", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class UGCFilterFragment extends BaseHomeSubFragment<gl.o> {

    /* renamed from: E, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int F = 8;

    /* renamed from: A, reason: from kotlin metadata */
    private boolean hasRecordedFirstLoadDuration;

    /* renamed from: B, reason: from kotlin metadata */
    private View mNoNetworkView;

    /* renamed from: C, reason: from kotlin metadata */
    private View mLoadingView;

    /* renamed from: D, reason: from kotlin metadata */
    private View mNoResultView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private com.transsion.home.adapter.filter.a mAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private UGCFilterViewModel mMovieModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View header;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private n0 headerBinding;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private UGCFilterExpandView filterView;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private volatile String mFilterJson;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private String fromOptId;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private UGCFilterResponse mFilterResponse;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private Integer mSelectedLevel2;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private Integer mSelectedLevel3;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private Integer mSelectedLevel4;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private String mSelectedGrade;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private hl.b mExposureHelper;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private HashMap mLatestSelectItems;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private long firstLoadStartTimeMillis;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int mPage = 1;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TabType mCurrentTab = TabType.FOR_U;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private String mCategory = "Education";

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final Map categoryChildrenByParentIdMap = new LinkedHashMap();

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private int mPerPage = 12;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/home/fragment/filter/UGCFilterFragment$TabType;", "", "apiValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getApiValue", "()Ljava/lang/String;", "FOR_U", "LATEST", "HOTTEST", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes5.dex */
    public static final class TabType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TabType[] $VALUES;
        private final String apiValue;
        public static final TabType FOR_U = new TabType("FOR_U", 0, "ForYou");
        public static final TabType LATEST = new TabType("LATEST", 1, "Latest");
        public static final TabType HOTTEST = new TabType("HOTTEST", 2, "New");

        private static final /* synthetic */ TabType[] $values() {
            return new TabType[]{FOR_U, LATEST, HOTTEST};
        }

        static {
            TabType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private TabType(String str, int i11, String str2) {
            this.apiValue = str2;
        }

        public static EnumEntries<TabType> getEntries() {
            return $ENTRIES;
        }

        public static TabType valueOf(String str) {
            return (TabType) Enum.valueOf(TabType.class, str);
        }

        public static TabType[] values() {
            return (TabType[]) $VALUES.clone();
        }

        public final String getApiValue() {
            return this.apiValue;
        }
    }

    /* renamed from: com.transsion.home.fragment.filter.UGCFilterFragment$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UGCFilterFragment a(int i11, String str, String category, String str2, String fromOptId) {
            Intrinsics.h(category, "category");
            Intrinsics.h(fromOptId, "fromOptId");
            Bundle bundle = new Bundle();
            bundle.putInt("tab_id", i11);
            bundle.putString(WebConstants.TAB_CODE, str);
            bundle.putString("category", category);
            bundle.putString("filter_json", str2);
            bundle.putString("fromOptId", fromOptId);
            UGCFilterFragment uGCFilterFragment = new UGCFilterFragment();
            uGCFilterFragment.setArguments(bundle);
            return uGCFilterFragment;
        }
    }

    /* loaded from: classes5.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45063a;

        static {
            int[] iArr = new int[TabType.values().length];
            try {
                iArr[TabType.FOR_U.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TabType.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TabType.HOTTEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f45063a = iArr;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements hl.a {
        c() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
        
            if (r13.s0() == true) goto L8;
         */
        @Override // hl.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(int r10, long r11, android.view.View r13) {
            /*
                Method dump skipped, instructions count: 467
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.fragment.filter.UGCFilterFragment.c.a(int, long, android.view.View):void");
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends DiffUtil.e {
        d() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(UGCFilterVideoItem oldItem, UGCFilterVideoItem newItem) {
            Intrinsics.h(oldItem, "oldItem");
            Intrinsics.h(newItem, "newItem");
            return Intrinsics.c(oldItem.getVideoId(), newItem.getVideoId()) && Intrinsics.c(oldItem.getTitle(), newItem.getTitle());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(UGCFilterVideoItem oldItem, UGCFilterVideoItem newItem) {
            Intrinsics.h(oldItem, "oldItem");
            Intrinsics.h(newItem, "newItem");
            return Intrinsics.c(oldItem.getVideoId(), newItem.getVideoId());
        }
    }

    /* loaded from: classes5.dex */
    public static final class e implements TabLayout.OnTabSelectedListener {
        e() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            UGCFilterFragment uGCFilterFragment = UGCFilterFragment.this;
            int position = tab != null ? tab.getPosition() : 0;
            uGCFilterFragment.mCurrentTab = position != 0 ? position != 1 ? TabType.HOTTEST : TabType.LATEST : TabType.FOR_U;
            if (tab != null) {
                UGCFilterFragment.this.X0(tab, true);
            }
            hl.b bVar = UGCFilterFragment.this.mExposureHelper;
            if (bVar != null) {
                bVar.e();
            }
            UGCFilterFragment.this.mPage = 1;
            UGCFilterFragment.this.A1(true);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            if (tab != null) {
                UGCFilterFragment.this.X0(tab, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class f extends RecyclerView.r {

        /* renamed from: a, reason: collision with root package name */
        private int f45066a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f45068c;

        f(View view) {
            this.f45068c = view;
        }

        private final void d(RecyclerView recyclerView) {
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            Intrinsics.f(layoutManager, "null cannot be cast to non-null type com.transsion.home.view.layoutmanager.OffsetGridLayoutManager");
            this.f45066a = ((OffsetGridLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            com.transsion.home.adapter.filter.a aVar;
            r6.f h02;
            r6.f h03;
            Intrinsics.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i11);
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            int childCount = layoutManager != null ? layoutManager.getChildCount() : 0;
            int itemCount = layoutManager != null ? layoutManager.getItemCount() : 0;
            if (i11 != 0 || childCount <= 0 || this.f45066a < itemCount - 1) {
                return;
            }
            com.transsion.home.adapter.filter.a aVar2 = UGCFilterFragment.this.mAdapter;
            if (((aVar2 == null || (h03 = aVar2.h0()) == null) ? null : h03.i()) != LoadMoreStatus.Fail || (aVar = UGCFilterFragment.this.mAdapter) == null || (h02 = aVar.h0()) == null) {
                return;
            }
            h02.w();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            f0 f0Var;
            ConstraintLayout constraintLayout;
            f0 f0Var2;
            f0 f0Var3;
            ConstraintLayout constraintLayout2;
            Intrinsics.h(recyclerView, "recyclerView");
            if (recyclerView.computeVerticalScrollOffset() > this.f45068c.getMeasuredHeight()) {
                gl.o oVar = (gl.o) UGCFilterFragment.this.getMViewBinding();
                if (oVar != null && (f0Var3 = oVar.f63924b) != null && (constraintLayout2 = f0Var3.f63819c) != null) {
                    jg.c.k(constraintLayout2);
                }
                gl.o oVar2 = (gl.o) UGCFilterFragment.this.getMViewBinding();
                if (oVar2 != null && (f0Var2 = oVar2.f63924b) != null) {
                    UGCFilterFragment uGCFilterFragment = UGCFilterFragment.this;
                    ConstraintLayout llTabFilter = f0Var2.f63819c;
                    Intrinsics.g(llTabFilter, "llTabFilter");
                    jg.c.k(llTabFilter);
                    uGCFilterFragment.M1();
                }
            } else {
                gl.o oVar3 = (gl.o) UGCFilterFragment.this.getMViewBinding();
                if (oVar3 != null && (f0Var = oVar3.f63924b) != null && (constraintLayout = f0Var.f63819c) != null) {
                    jg.c.g(constraintLayout);
                }
            }
            d(recyclerView);
        }
    }

    /* loaded from: classes5.dex */
    public static final class g implements nh.n {
        g() {
        }

        @Override // nh.n
        public void onConnected() {
            n.a.a(this);
        }

        @Override // nh.n
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            boolean z10;
            r6.f h02;
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            if (UGCFilterFragment.this.isResumed()) {
                View view = UGCFilterFragment.this.mNoNetworkView;
                if (view != null) {
                    jg.c.g(view);
                }
                com.transsion.home.adapter.filter.a aVar = UGCFilterFragment.this.mAdapter;
                List<Object> data = aVar != null ? aVar.getData() : null;
                List<Object> list = data;
                if (list == null || list.isEmpty()) {
                    UGCFilterFragment.this.loadData();
                    return;
                }
                UGCFilterVideoItem uGCFilterVideoItem = (UGCFilterVideoItem) CollectionsKt.v0(data);
                boolean c11 = Intrinsics.c(uGCFilterVideoItem != null ? uGCFilterVideoItem.getChannelId() : null, UGCFilterFragment.this.mCategory);
                HashMap hashMap = UGCFilterFragment.this.mLatestSelectItems;
                if (hashMap != null) {
                    z10 = Intrinsics.c(uGCFilterVideoItem != null ? uGCFilterVideoItem.getSelectItems() : null, hashMap);
                } else {
                    z10 = false;
                }
                if (!c11 || !z10) {
                    UGCFilterFragment.this.A1(true);
                    return;
                }
                com.transsion.home.adapter.filter.a aVar2 = UGCFilterFragment.this.mAdapter;
                if (aVar2 == null || (h02 = aVar2.h0()) == null) {
                    return;
                }
                h02.w();
            }
        }

        @Override // nh.n
        public void onDisconnected() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A1(boolean isRefresh) {
        lg.a.f68962a.c("UGCFilterFragment", "loadDataWithCurrentFilter: page=" + this.mPage + ", level2=" + this.mSelectedLevel2 + ", level3=" + this.mSelectedLevel3 + ", level4=" + this.mSelectedLevel4 + ", sort=" + this.mCurrentTab.getApiValue() + ", isRefresh=" + isRefresh, false);
        this.mLatestSelectItems = new HashMap(Y0());
        if (isRefresh && !this.hasRecordedFirstLoadDuration && this.firstLoadStartTimeMillis == 0) {
            this.firstLoadStartTimeMillis = System.currentTimeMillis();
        }
        UGCFilterViewModel uGCFilterViewModel = this.mMovieModel;
        if (uGCFilterViewModel != null) {
            uGCFilterViewModel.m(this.mCategory, this.mPage, this.mPerPage, this.mCurrentTab.getApiValue(), this.mSelectedLevel2, this.mSelectedLevel3, this.mSelectedLevel4, this.mSelectedGrade, isRefresh);
        }
        if (isRefresh) {
            this.mPage = 2;
        } else {
            this.mPage++;
        }
    }

    private final void B1(UGCFilterItem ugcFilterItem) {
        lg.a.f68962a.c("UGCFilterFragment", "onUGCFilterItemSelected: id=" + ugcFilterItem.getCategoryId() + ", name=" + ugcFilterItem.getName() + ", parentId=" + ugcFilterItem.getParentId(), false);
        C1(ugcFilterItem);
    }

    private final void C1(UGCFilterItem item) {
        com.transsion.baselib.helper.a.f43316a.i("/home/ugc_filter", c1(item, "click_filter"));
    }

    private final void D1(TabLayout.Tab tab, String title, boolean selected) {
        LayoutInflater from = LayoutInflater.from(requireContext());
        int i11 = R$layout.item_home_filter_tab;
        n0 n0Var = this.headerBinding;
        if (n0Var == null) {
            Intrinsics.z("headerBinding");
            n0Var = null;
        }
        View inflate = from.inflate(i11, (ViewGroup) n0Var.f63918c, false);
        TextView textView = (TextView) inflate.findViewById(R$id.tv_tab_title);
        textView.setText(title);
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        Typeface c11 = selected ? jg.a.c(requireContext) : jg.a.d(requireContext);
        if (c11 != null) {
            textView.setTypeface(c11);
        }
        textView.setTextColor(androidx.core.content.b.getColor(requireContext(), selected ? R$color.text_01 : R$color.text_02));
        if (selected) {
            inflate.setBackgroundResource(R$drawable.bg_item_filter_tab);
        } else {
            inflate.setBackgroundColor(0);
        }
        inflate.setSelected(selected);
        tab.setCustomView(inflate);
    }

    private final void E1() {
        if (this.mNoNetworkView == null) {
            n0 n0Var = this.headerBinding;
            if (n0Var == null) {
                Intrinsics.z("headerBinding");
                n0Var = null;
            }
            this.mNoNetworkView = n0Var.f63920e.inflate();
        }
        View view = this.mNoNetworkView;
        if (view != null) {
            jg.c.k(view);
            final NoNetworkBigView noNetworkBigView = (NoNetworkBigView) view.findViewById(R$id.state_view);
            if (noNetworkBigView != null) {
                NoNetworkBigView.showTitle$default(noNetworkBigView, false, null, 2, null);
                noNetworkBigView.retry(new Function0() { // from class: com.transsion.home.fragment.filter.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit F1;
                        F1 = UGCFilterFragment.F1(NoNetworkBigView.this, this);
                        return F1;
                    }
                });
                noNetworkBigView.goToSetting(new Function0() { // from class: com.transsion.home.fragment.filter.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit G1;
                        G1 = UGCFilterFragment.G1();
                        return G1;
                    }
                });
            }
            com.tn.lib.view.r.a("/home/ugc_filter");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F1(NoNetworkBigView noNetworkBigView, UGCFilterFragment uGCFilterFragment) {
        jg.c.g(noNetworkBigView);
        uGCFilterFragment.loadData();
        com.tn.lib.view.r.b("/home/ugc_filter");
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G1() {
        com.tn.lib.view.r.c("/home/ugc_filter");
        return Unit.f67184a;
    }

    private final void H1(String string) {
        if (this.mNoResultView == null) {
            n0 n0Var = this.headerBinding;
            if (n0Var == null) {
                Intrinsics.z("headerBinding");
                n0Var = null;
            }
            this.mNoResultView = n0Var.f63921f.inflate();
        }
        final View view = this.mNoResultView;
        if (view != null) {
            jg.c.k(view);
            TextView textView = (TextView) view.findViewById(R$id.tv_no_result);
            if (textView != null) {
                textView.setText(string);
            }
            View findViewById = view.findViewById(R$id.tv_reset);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.filter.s
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        UGCFilterFragment.I1(UGCFilterFragment.this, view, view2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I1(UGCFilterFragment uGCFilterFragment, View view, View view2) {
        uGCFilterFragment.mSelectedLevel2 = null;
        uGCFilterFragment.mSelectedLevel3 = null;
        uGCFilterFragment.mSelectedLevel4 = null;
        uGCFilterFragment.mFilterJson = "";
        jg.c.g(view);
        uGCFilterFragment.loadData();
    }

    private final void J1() {
        List<UGCFilterItem> l11;
        List<UGCFilterGrade> l12;
        UGCFilterResponse uGCFilterResponse = this.mFilterResponse;
        if (uGCFilterResponse == null || (l11 = uGCFilterResponse.getItems()) == null) {
            l11 = CollectionsKt.l();
        }
        UGCFilterExpandView uGCFilterExpandView = null;
        if (l11.isEmpty()) {
            UGCFilterExpandView uGCFilterExpandView2 = this.filterView;
            if (uGCFilterExpandView2 == null) {
                Intrinsics.z("filterView");
            } else {
                uGCFilterExpandView = uGCFilterExpandView2;
            }
            jg.c.g(uGCFilterExpandView);
            lg.a.f68962a.x("UGCFilterFragment", "updateFilterViewData: no filter items", false);
            return;
        }
        Map c11 = MapsKt.c();
        Integer num = this.mSelectedLevel2;
        if (num != null) {
        }
        Integer num2 = this.mSelectedLevel3;
        if (num2 != null) {
        }
        Integer num3 = this.mSelectedLevel4;
        if (num3 != null) {
        }
        String str = this.mSelectedGrade;
        if (str != null) {
            c11.put("grade", str);
        }
        Map<String, String> b11 = MapsKt.b(c11);
        lg.a.f68962a.c("UGCFilterFragment", "updateFilterViewData: items size=" + l11.size() + ", selected=" + b11, false);
        UGCFilterExpandView uGCFilterExpandView3 = this.filterView;
        if (uGCFilterExpandView3 == null) {
            Intrinsics.z("filterView");
            uGCFilterExpandView3 = null;
        }
        jg.c.k(uGCFilterExpandView3);
        UGCFilterExpandView uGCFilterExpandView4 = this.filterView;
        if (uGCFilterExpandView4 == null) {
            Intrinsics.z("filterView");
        } else {
            uGCFilterExpandView = uGCFilterExpandView4;
        }
        UGCFilterResponse uGCFilterResponse2 = this.mFilterResponse;
        if (uGCFilterResponse2 == null || (l12 = uGCFilterResponse2.getGrades()) == null) {
            l12 = CollectionsKt.l();
        }
        uGCFilterExpandView.updateList(l11, "4", b11, l12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void K1(com.transsion.ugcvideodetail.api.bean.UGCContentList r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.fragment.filter.UGCFilterFragment.K1(com.transsion.ugcvideodetail.api.bean.UGCContentList, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L1(UGCFilterFragment uGCFilterFragment) {
        r6.f h02;
        com.transsion.home.adapter.filter.a aVar = uGCFilterFragment.mAdapter;
        if (aVar == null || (h02 = aVar.h0()) == null) {
            return;
        }
        h02.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void M1() {
        f0 f0Var;
        AppCompatTextView appCompatTextView;
        String b12;
        String a12;
        String a13;
        String a14;
        StringBuilder sb2 = new StringBuilder();
        Integer num = this.mSelectedLevel2;
        if (num != null && (a14 = a1(String.valueOf(num.intValue()))) != null && !Intrinsics.c(a14, getString(R$string.all))) {
            sb2.append(a14);
            sb2.append(" • ");
        }
        Integer num2 = this.mSelectedLevel3;
        if (num2 != null && (a13 = a1(String.valueOf(num2.intValue()))) != null && !Intrinsics.c(a13, getString(R$string.all))) {
            sb2.append(a13);
            sb2.append(" • ");
        }
        Integer num3 = this.mSelectedLevel4;
        if (num3 != null && (a12 = a1(String.valueOf(num3.intValue()))) != null && !Intrinsics.c(a12, getString(R$string.all))) {
            sb2.append(a12);
            sb2.append(" • ");
        }
        String str = this.mSelectedGrade;
        if (str != null && (b12 = b1(str)) != null && !Intrinsics.c(b12, getString(R$string.all))) {
            sb2.append(b12);
            sb2.append(" • ");
        }
        boolean c02 = StringsKt.c0(sb2, " • ", false, 2, null);
        String str2 = sb2;
        if (c02) {
            str2 = sb2.substring(0, sb2.length() - 2);
        }
        int length = str2.length();
        String str3 = str2;
        if (length == 0) {
            str3 = getString(R$string.all);
        }
        gl.o oVar = (gl.o) getMViewBinding();
        if (oVar == null || (f0Var = oVar.f63924b) == null || (appCompatTextView = f0Var.f63818b) == null) {
            return;
        }
        appCompatTextView.setText(str3);
        jg.c.k(appCompatTextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0(TabLayout.Tab tab, boolean z10) {
        View customView = tab.getCustomView();
        if (customView == null) {
            return;
        }
        customView.setSelected(z10);
        TextView textView = (TextView) customView.findViewById(R$id.tv_tab_title);
        if (textView != null) {
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            Typeface c11 = z10 ? jg.a.c(requireContext) : jg.a.d(requireContext);
            if (c11 != null) {
                textView.setTypeface(c11);
            }
            textView.setTextColor(androidx.core.content.b.getColor(requireContext(), z10 ? R$color.text_01 : R$color.text_02));
            if (z10) {
                customView.setBackgroundResource(R$drawable.bg_item_filter_tab);
            } else {
                customView.setBackgroundColor(0);
            }
        }
    }

    private final Map Y0() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Integer num = this.mSelectedLevel2;
        if (num != null) {
        }
        Integer num2 = this.mSelectedLevel3;
        if (num2 != null) {
        }
        Integer num3 = this.mSelectedLevel4;
        if (num3 != null) {
        }
        String str = this.mSelectedGrade;
        if (str != null) {
            linkedHashMap.put("grade", str);
        }
        return linkedHashMap;
    }

    private final void Z0() {
        Object obj = this.categoryChildrenByParentIdMap.get("4");
        if (obj == null) {
            obj = CollectionsKt.l();
        }
        if (((List) obj).isEmpty()) {
            return;
        }
        HashMap j12 = j1();
        if (this.mCurrentTab != TabType.FOR_U) {
            n0 n0Var = this.headerBinding;
            if (n0Var == null) {
                Intrinsics.z("headerBinding");
                n0Var = null;
            }
            TabLayout tabLayout = n0Var.f63922g;
            if (tabLayout != null) {
                n0 n0Var2 = this.headerBinding;
                if (n0Var2 == null) {
                    Intrinsics.z("headerBinding");
                    n0Var2 = null;
                }
                TabLayout tabLayout2 = n0Var2.f63922g;
                tabLayout.selectTab(tabLayout2 != null ? tabLayout2.getTabAt(this.mCurrentTab.ordinal()) : null);
            }
        }
        if (!j12.isEmpty()) {
            this.mFilterJson = "";
        }
        lg.a.f68962a.c("UGCFilterFragment", "buildFilterView: level2=" + this.mSelectedLevel2 + ", level3=" + this.mSelectedLevel3 + ", level4=" + this.mSelectedLevel4, false);
        J1();
    }

    private final String a1(String categoryId) {
        List<UGCFilterItem> items;
        Object obj;
        UGCFilterResponse uGCFilterResponse = this.mFilterResponse;
        if (uGCFilterResponse != null && (items = uGCFilterResponse.getItems()) != null) {
            Iterator<T> it = items.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.c(((UGCFilterItem) obj).getCategoryId(), categoryId)) {
                    break;
                }
            }
            UGCFilterItem uGCFilterItem = (UGCFilterItem) obj;
            if (uGCFilterItem != null) {
                return uGCFilterItem.getName();
            }
        }
        return null;
    }

    private final String b1(String gradeCode) {
        List<UGCFilterGrade> grades;
        Object obj;
        UGCFilterResponse uGCFilterResponse = this.mFilterResponse;
        if (uGCFilterResponse != null && (grades = uGCFilterResponse.getGrades()) != null) {
            Iterator<T> it = grades.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.c(((UGCFilterGrade) obj).getGrade(), gradeCode)) {
                    break;
                }
            }
            UGCFilterGrade uGCFilterGrade = (UGCFilterGrade) obj;
            if (uGCFilterGrade != null) {
                return uGCFilterGrade.getDescName();
            }
        }
        return null;
    }

    private final Map c1(UGCFilterItem item, String key) {
        List<Object> data;
        UGCFilterVideoItem uGCFilterVideoItem;
        String ops;
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", key);
        String name = item.getName();
        String str = "";
        if (name == null) {
            name = "";
        }
        hashMap.put(CampaignEx.JSON_KEY_TITLE, name);
        String categoryId = item.getCategoryId();
        if (categoryId == null) {
            categoryId = "";
        }
        hashMap.put("category_id", categoryId);
        hashMap.put("tab_id", String.valueOf(getMTabId()));
        hashMap.put("rank_category", "btn");
        String str2 = this.fromOptId;
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("from_opt_id", str2);
        com.transsion.home.adapter.filter.a aVar = this.mAdapter;
        if (aVar != null && (data = aVar.getData()) != null && (uGCFilterVideoItem = (UGCFilterVideoItem) CollectionsKt.k0(data)) != null && (ops = uGCFilterVideoItem.getOps()) != null) {
            str = ops;
        }
        hashMap.put("ops", str);
        return hashMap;
    }

    private final int d1() {
        return R$layout.home_empty_view_loading;
    }

    private final int e1() {
        FragmentActivity activity = getActivity();
        return (activity == null || !com.transsion.baseui.util.b.a(activity)) ? 2 : 3;
    }

    private final void g1() {
        View view = this.mLoadingView;
        if (view != null) {
            jg.c.g(view);
        }
    }

    private final void h1() {
        View view = this.mNoResultView;
        if (view != null) {
            jg.c.g(view);
        }
    }

    private final void i1() {
        Object obj = this.categoryChildrenByParentIdMap.get("4");
        if (obj == null) {
            obj = CollectionsKt.l();
        }
        List list = (List) obj;
        lg.a.f68962a.c("UGCFilterFragment", "initChannelView: root categories size=" + list.size(), false);
        if (!list.isEmpty()) {
            Z0();
            A1(true);
            return;
        }
        UGCFilterExpandView uGCFilterExpandView = this.filterView;
        if (uGCFilterExpandView == null) {
            Intrinsics.z("filterView");
            uGCFilterExpandView = null;
        }
        jg.c.g(uGCFilterExpandView);
    }

    private final void initViewModel() {
        UGCFilterViewModel uGCFilterViewModel = this.mMovieModel;
        if (uGCFilterViewModel != null) {
            uGCFilterViewModel.j().j(this, new c0(new Function1() { // from class: com.transsion.home.fragment.filter.o
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit w12;
                    w12 = UGCFilterFragment.w1(UGCFilterFragment.this, (BaseDto) obj);
                    return w12;
                }
            }));
            uGCFilterViewModel.n().j(this, new c0(new Function1() { // from class: com.transsion.home.fragment.filter.t
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit y12;
                    y12 = UGCFilterFragment.y1(UGCFilterFragment.this, (RefreshBaseDto) obj);
                    return y12;
                }
            }));
            uGCFilterViewModel.l().j(this, new c0(new Function1() { // from class: com.transsion.home.fragment.filter.u
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit z12;
                    z12 = UGCFilterFragment.z1(UGCFilterFragment.this, (UGCFilterItem) obj);
                    return z12;
                }
            }));
        }
    }

    private final HashMap j1() {
        HashMap hashMap = new HashMap();
        String str = this.mFilterJson;
        if (str != null && str.length() != 0) {
            try {
                String str2 = this.mFilterJson;
                if (str2 == null) {
                    str2 = "";
                }
                JSONObject jSONObject = new JSONObject(str2);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = jSONObject.getString(next);
                    if (next != null) {
                        int hashCode = next.hashCode();
                        if (hashCode != 3536286) {
                            if (hashCode != 98615255) {
                                switch (hashCode) {
                                    case 426008981:
                                        if (!next.equals("categoryLve2")) {
                                            break;
                                        } else {
                                            Intrinsics.e(string);
                                            this.mSelectedLevel2 = StringsKt.v(string);
                                            break;
                                        }
                                    case 426008982:
                                        if (!next.equals("categoryLve3")) {
                                            break;
                                        } else {
                                            Intrinsics.e(string);
                                            this.mSelectedLevel3 = StringsKt.v(string);
                                            break;
                                        }
                                    case 426008983:
                                        if (!next.equals("categoryLve4")) {
                                            break;
                                        } else {
                                            Intrinsics.e(string);
                                            this.mSelectedLevel4 = StringsKt.v(string);
                                            break;
                                        }
                                }
                            } else if (next.equals("grade")) {
                                this.mSelectedGrade = string;
                            }
                        } else if (next.equals("sort")) {
                            this.mCurrentTab = Intrinsics.c(string, "Latest") ? TabType.LATEST : Intrinsics.c(string, "New") ? TabType.HOTTEST : TabType.FOR_U;
                        }
                    }
                    hashMap.put(next, string);
                }
                lg.a.f68962a.c("UGCFilterFragment", "initDefaultSelect: filterMap=" + hashMap, false);
            } catch (Exception e11) {
                lg.a.f68962a.i("UGCFilterFragment", "initDefaultSelect: parse filterJson failed: " + e11.getMessage(), true);
            }
        }
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void k1() {
        RecyclerView recyclerView;
        if (this.mExposureHelper == null) {
            hl.b bVar = new hl.b(0.6f, new c(), false, 4, null);
            bVar.l(2);
            gl.o oVar = (gl.o) getMViewBinding();
            if (oVar != null && (recyclerView = oVar.f63925c) != null) {
                recyclerView.addOnScrollListener(bVar);
            }
            this.mExposureHelper = bVar;
        }
    }

    private final void l1() {
        UGCFilterExpandView uGCFilterExpandView = this.filterView;
        UGCFilterExpandView uGCFilterExpandView2 = null;
        if (uGCFilterExpandView == null) {
            Intrinsics.z("filterView");
            uGCFilterExpandView = null;
        }
        uGCFilterExpandView.setFilterViewModel(this.mMovieModel);
        UGCFilterExpandView uGCFilterExpandView3 = this.filterView;
        if (uGCFilterExpandView3 == null) {
            Intrinsics.z("filterView");
        } else {
            uGCFilterExpandView2 = uGCFilterExpandView3;
        }
        uGCFilterExpandView2.setOnSelectionChanged(new Function4() { // from class: com.transsion.home.fragment.filter.v
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit m12;
                m12 = UGCFilterFragment.m1(UGCFilterFragment.this, (String) obj, (String) obj2, (String) obj3, (String) obj4);
                return m12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadData() {
        startLoading();
        lg.a.f68962a.c("UGCFilterFragment", "loadData: category=" + this.mCategory, false);
        UGCFilterViewModel uGCFilterViewModel = this.mMovieModel;
        if (uGCFilterViewModel != null) {
            uGCFilterViewModel.i(this.mCategory);
        }
    }

    private final void loadMore() {
        A1(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit m1(UGCFilterFragment uGCFilterFragment, String str, String str2, String str3, String str4) {
        RecyclerView recyclerView;
        a.C0856a c0856a = lg.a.f68962a;
        UGCFilterViewModel uGCFilterViewModel = uGCFilterFragment.mMovieModel;
        UGCFilterExpandView uGCFilterExpandView = null;
        UGCFilterItem h11 = uGCFilterViewModel != null ? uGCFilterViewModel.h(str) : null;
        UGCFilterViewModel uGCFilterViewModel2 = uGCFilterFragment.mMovieModel;
        UGCFilterItem h12 = uGCFilterViewModel2 != null ? uGCFilterViewModel2.h(str2) : null;
        UGCFilterViewModel uGCFilterViewModel3 = uGCFilterFragment.mMovieModel;
        c0856a.c("UGCFilterFragment", "filter selection changed: lv2=" + str + " data=" + h11 + ", lv3=" + str2 + "  data=" + h12 + ", lv4=" + str3 + " selectedGradeId=" + str4 + " data=" + (uGCFilterViewModel3 != null ? uGCFilterViewModel3.h(str3) : null), false);
        uGCFilterFragment.mSelectedLevel2 = str != null ? StringsKt.v(str) : null;
        uGCFilterFragment.mSelectedLevel3 = str2 != null ? StringsKt.v(str2) : null;
        uGCFilterFragment.mSelectedLevel4 = str3 != null ? StringsKt.v(str3) : null;
        uGCFilterFragment.mSelectedGrade = str4;
        UGCFilterExpandView uGCFilterExpandView2 = uGCFilterFragment.filterView;
        if (uGCFilterExpandView2 == null) {
            Intrinsics.z("filterView");
            uGCFilterExpandView2 = null;
        }
        uGCFilterFragment.mSelectedGrade = uGCFilterExpandView2.getSelectedIds().get("grade");
        UGCFilterExpandView uGCFilterExpandView3 = uGCFilterFragment.filterView;
        if (uGCFilterExpandView3 == null) {
            Intrinsics.z("filterView");
        } else {
            uGCFilterExpandView = uGCFilterExpandView3;
        }
        uGCFilterExpandView.collapseAll();
        hl.b bVar = uGCFilterFragment.mExposureHelper;
        if (bVar != null) {
            bVar.e();
        }
        uGCFilterFragment.mPage = 1;
        uGCFilterFragment.A1(true);
        gl.o oVar = (gl.o) uGCFilterFragment.getMViewBinding();
        if (oVar != null && (recyclerView = oVar.f63925c) != null) {
            recyclerView.scrollToPosition(0);
        }
        return Unit.f67184a;
    }

    private final void n1() {
        List<UGCFilterItem> items;
        this.categoryChildrenByParentIdMap.clear();
        UGCFilterResponse uGCFilterResponse = this.mFilterResponse;
        if (uGCFilterResponse == null || (items = uGCFilterResponse.getItems()) == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : items) {
            String parentId = ((UGCFilterItem) obj).getParentId();
            if (parentId == null) {
                parentId = "4";
            }
            Object obj2 = linkedHashMap.get(parentId);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(parentId, obj2);
            }
            ((List) obj2).add(obj);
        }
        this.categoryChildrenByParentIdMap.putAll(linkedHashMap);
        lg.a.f68962a.c("UGCFilterFragment", "initFilterMap: tree size=" + this.categoryChildrenByParentIdMap.size(), false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o1() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        gl.o oVar;
        RecyclerView recyclerView3;
        RecyclerView recyclerView4;
        int e12 = e1();
        OffsetGridLayoutManager offsetGridLayoutManager = new OffsetGridLayoutManager(getContext(), e12, 1, false);
        gl.o oVar2 = (gl.o) getMViewBinding();
        if (oVar2 != null && (recyclerView4 = oVar2.f63925c) != null) {
            recyclerView4.setLayoutManager(offsetGridLayoutManager);
        }
        com.transsion.home.adapter.filter.a aVar = new com.transsion.home.adapter.filter.a(new ArrayList(), this.mExposureHelper, null, e12, HomeTabId.INSTANCE.h(Integer.valueOf(getMTabId()), false) || StringsKt.H(UGCVideoType.EDUCATION.getValue(), this.mCategory, true));
        aVar.h0().z(true);
        aVar.h0().y(true);
        aVar.h0().D(new p6.f() { // from class: com.transsion.home.fragment.filter.w
            @Override // p6.f
            public final void a() {
                UGCFilterFragment.p1(UGCFilterFragment.this);
            }
        });
        aVar.R0(new d());
        aVar.w1(new p6.d() { // from class: com.transsion.home.fragment.filter.x
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                UGCFilterFragment.r1(UGCFilterFragment.this, baseQuickAdapter, view, i11);
            }
        });
        this.mAdapter = aVar;
        gl.o oVar3 = (gl.o) getMViewBinding();
        if (oVar3 != null && (recyclerView2 = oVar3.f63925c) != null && recyclerView2.getItemDecorationCount() < 1 && (oVar = (gl.o) getMViewBinding()) != null && (recyclerView3 = oVar.f63925c) != null) {
            recyclerView3.addItemDecoration(new ig.b(com.blankj.utilcode.util.a0.a(4.0f), com.blankj.utilcode.util.a0.a(4.0f), com.blankj.utilcode.util.a0.a(16.0f), com.blankj.utilcode.util.a0.a(16.0f)));
        }
        gl.o oVar4 = (gl.o) getMViewBinding();
        if (oVar4 == null || (recyclerView = oVar4.f63925c) == null) {
            return;
        }
        recyclerView.setAdapter(this.mAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void p1(final UGCFilterFragment uGCFilterFragment) {
        RecyclerView recyclerView;
        if (nh.m.f70597a.e()) {
            uGCFilterFragment.loadMore();
            return;
        }
        uh.b.f76876a.d(R$string.no_network_toast);
        gl.o oVar = (gl.o) uGCFilterFragment.getMViewBinding();
        if (oVar == null || (recyclerView = oVar.f63925c) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.filter.b0
            @Override // java.lang.Runnable
            public final void run() {
                UGCFilterFragment.q1(UGCFilterFragment.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(UGCFilterFragment uGCFilterFragment) {
        r6.f h02;
        com.transsion.home.adapter.filter.a aVar = uGCFilterFragment.mAdapter;
        if (aVar == null || (h02 = aVar.h0()) == null) {
            return;
        }
        h02.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(UGCFilterFragment uGCFilterFragment, BaseQuickAdapter adapter, View view, int i11) {
        String str;
        String str2;
        UGCVideoBelongToCollection belongToCollection;
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "<unused var>");
        Object item = adapter.getItem(i11);
        if (item instanceof UGCFilterVideoItem) {
            UGCFilterVideoItem uGCFilterVideoItem = (UGCFilterVideoItem) item;
            lg.a.f68962a.c("UGCFilterFragment", "click ugc video: id=" + uGCFilterVideoItem.getVideoId() + ", title=" + uGCFilterVideoItem.getTitle(), false);
            ov.c.f(uGCFilterVideoItem.getContent(), null, null, 3, null);
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", WebConstants.FIELD_ITEM);
            hashMap.put("rank_category", WebConstants.FIELD_ITEM);
            String str3 = uGCFilterFragment.fromOptId;
            if (str3 == null) {
                str3 = "";
            }
            hashMap.put("from_opt_id", str3);
            UGCVideo video = uGCFilterVideoItem.getContent().getVideo();
            if (video == null || (belongToCollection = video.getBelongToCollection()) == null || (str = belongToCollection.getCollectionId()) == null) {
                str = "";
            }
            hashMap.put("belong_to_collection_id", str);
            String videoId = uGCFilterVideoItem.getVideoId();
            if (videoId == null) {
                videoId = "";
            }
            hashMap.put("content_id", videoId);
            UGCVideo video2 = uGCFilterVideoItem.getContent().getVideo();
            if (video2 == null || (str2 = video2.getSubjectId()) == null) {
                str2 = "";
            }
            hashMap.put("refer_subject_id", str2);
            hashMap.put("content_type", "ugc_video");
            hashMap.put(RequestParameters.POSITION, String.valueOf(i11));
            String ops = uGCFilterVideoItem.getOps();
            hashMap.put("ops", ops != null ? ops : "");
            com.transsion.baselib.helper.a.f43316a.f("/home/ugc_filter", hashMap);
        }
    }

    private final void s1(View headerView) {
        n0 n0Var = this.headerBinding;
        n0 n0Var2 = null;
        if (n0Var == null) {
            Intrinsics.z("headerBinding");
            n0Var = null;
        }
        ConstraintLayout llTabMovie = n0Var.f63918c;
        Intrinsics.g(llTabMovie, "llTabMovie");
        n0 n0Var3 = this.headerBinding;
        if (n0Var3 == null) {
            Intrinsics.z("headerBinding");
        } else {
            n0Var2 = n0Var3;
        }
        TabLayout tabMovie = n0Var2.f63922g;
        Intrinsics.g(tabMovie, "tabMovie");
        jg.c.k(llTabMovie);
        tabMovie.removeAllTabs();
        int i11 = 0;
        for (Object obj : CollectionsKt.o(getString(com.transsion.home.R$string.item_filter_for_u), getString(com.transsion.home.R$string.item_filter_latest), getString(com.transsion.home.R$string.item_filter_hottest))) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.u();
            }
            String str = (String) obj;
            int i13 = b.f45063a[this.mCurrentTab.ordinal()];
            boolean z10 = true;
            if (i13 == 1) {
                if (i11 == 0) {
                    TabLayout.Tab newTab = tabMovie.newTab();
                    Intrinsics.g(newTab, "newTab(...)");
                    Intrinsics.e(str);
                    D1(newTab, str, z10);
                    tabMovie.addTab(newTab, z10);
                    i11 = i12;
                }
                z10 = false;
                TabLayout.Tab newTab2 = tabMovie.newTab();
                Intrinsics.g(newTab2, "newTab(...)");
                Intrinsics.e(str);
                D1(newTab2, str, z10);
                tabMovie.addTab(newTab2, z10);
                i11 = i12;
            } else if (i13 == 2) {
                if (i11 == 1) {
                    TabLayout.Tab newTab22 = tabMovie.newTab();
                    Intrinsics.g(newTab22, "newTab(...)");
                    Intrinsics.e(str);
                    D1(newTab22, str, z10);
                    tabMovie.addTab(newTab22, z10);
                    i11 = i12;
                }
                z10 = false;
                TabLayout.Tab newTab222 = tabMovie.newTab();
                Intrinsics.g(newTab222, "newTab(...)");
                Intrinsics.e(str);
                D1(newTab222, str, z10);
                tabMovie.addTab(newTab222, z10);
                i11 = i12;
            } else {
                if (i13 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (i11 == 2) {
                    TabLayout.Tab newTab2222 = tabMovie.newTab();
                    Intrinsics.g(newTab2222, "newTab(...)");
                    Intrinsics.e(str);
                    D1(newTab2222, str, z10);
                    tabMovie.addTab(newTab2222, z10);
                    i11 = i12;
                }
                z10 = false;
                TabLayout.Tab newTab22222 = tabMovie.newTab();
                Intrinsics.g(newTab22222, "newTab(...)");
                Intrinsics.e(str);
                D1(newTab22222, str, z10);
                tabMovie.addTab(newTab22222, z10);
                i11 = i12;
            }
        }
        tabMovie.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new e());
    }

    private final void showLoadingView() {
        n0 n0Var = this.headerBinding;
        if (n0Var == null) {
            Intrinsics.z("headerBinding");
            n0Var = null;
        }
        ViewStub loadingStub = n0Var.f63919d;
        Intrinsics.g(loadingStub, "loadingStub");
        loadingStub.setLayoutResource(d1());
        if (this.mLoadingView == null) {
            this.mLoadingView = loadingStub.inflate();
        }
        View view = this.mLoadingView;
        if (view != null) {
            jg.c.k(view);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t1(View header) {
        f0 f0Var;
        ConstraintLayout constraintLayout;
        RecyclerView recyclerView;
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        gl.o oVar = (gl.o) getMViewBinding();
        if (oVar != null && (swipeRefreshLayout2 = oVar.f63926d) != null) {
            swipeRefreshLayout2.setEnabled(false);
        }
        gl.o oVar2 = (gl.o) getMViewBinding();
        if (oVar2 != null && (swipeRefreshLayout = oVar2.f63926d) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.home.fragment.filter.y
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
                public final void a() {
                    UGCFilterFragment.u1(UGCFilterFragment.this);
                }
            });
        }
        gl.o oVar3 = (gl.o) getMViewBinding();
        if (oVar3 != null && (recyclerView = oVar3.f63925c) != null) {
            recyclerView.addOnScrollListener(new f(header));
        }
        gl.o oVar4 = (gl.o) getMViewBinding();
        if (oVar4 == null || (f0Var = oVar4.f63924b) == null || (constraintLayout = f0Var.f63819c) == null) {
            return;
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.filter.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UGCFilterFragment.v1(UGCFilterFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(UGCFilterFragment uGCFilterFragment) {
        uGCFilterFragment.c0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void v1(UGCFilterFragment uGCFilterFragment, View view) {
        RecyclerView recyclerView;
        gl.o oVar = (gl.o) uGCFilterFragment.getMViewBinding();
        if (oVar == null || (recyclerView = oVar.f63925c) == null) {
            return;
        }
        recyclerView.scrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit w1(final UGCFilterFragment uGCFilterFragment, BaseDto baseDto) {
        SwipeRefreshLayout swipeRefreshLayout;
        List<UGCFilterItem> items;
        if (baseDto == null || !Intrinsics.c(baseDto.getCode(), "0")) {
            gl.o oVar = (gl.o) uGCFilterFragment.getMViewBinding();
            if (oVar != null && (swipeRefreshLayout = oVar.f63926d) != null) {
                swipeRefreshLayout.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.filter.a0
                    @Override // java.lang.Runnable
                    public final void run() {
                        UGCFilterFragment.x1(UGCFilterFragment.this);
                    }
                }, 200L);
            }
            lg.a.f68962a.i("UGCFilterFragment", "getFilterItems failed: code=" + (baseDto != null ? baseDto.getCode() : null) + ", msg=" + (baseDto != null ? baseDto.getMsg() : null), true);
            return Unit.f67184a;
        }
        a.C0856a c0856a = lg.a.f68962a;
        UGCFilterResponse uGCFilterResponse = (UGCFilterResponse) baseDto.getData();
        c0856a.c("UGCFilterFragment", "getFilterItems success: items size=" + ((uGCFilterResponse == null || (items = uGCFilterResponse.getItems()) == null) ? 0 : items.size()), false);
        UGCFilterResponse uGCFilterResponse2 = (UGCFilterResponse) baseDto.getData();
        if (uGCFilterResponse2 != null) {
            uGCFilterFragment.hideLoading();
            uGCFilterFragment.mFilterResponse = uGCFilterResponse2;
            uGCFilterFragment.n1();
            uGCFilterFragment.i1();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(UGCFilterFragment uGCFilterFragment) {
        if (!uGCFilterFragment.isAdded() || uGCFilterFragment.isDetached() || uGCFilterFragment.isRemoving()) {
            return;
        }
        uGCFilterFragment.hideLoading();
        uGCFilterFragment.H1(uGCFilterFragment.getString(com.transsnet.downloader.R$string.str_ad_video_error_tips));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit y1(UGCFilterFragment uGCFilterFragment, RefreshBaseDto refreshBaseDto) {
        r6.f h02;
        com.transsion.home.adapter.filter.a aVar;
        r6.f h03;
        List<Object> data;
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        HashMap g11;
        List<UGCContent> items;
        UGCContent uGCContent;
        UGCVideo video;
        List<Object> data2;
        HashMap g12;
        List<UGCContent> items2;
        UGCContent uGCContent2;
        UGCVideo video2;
        SwipeRefreshLayout swipeRefreshLayout3;
        gl.o oVar = (gl.o) uGCFilterFragment.getMViewBinding();
        if (oVar != null && (swipeRefreshLayout3 = oVar.f63926d) != null) {
            swipeRefreshLayout3.setEnabled(true);
        }
        if (refreshBaseDto == null || !Intrinsics.c(refreshBaseDto.getCode(), "0")) {
            if (refreshBaseDto == null || !refreshBaseDto.getIsRefresh()) {
                com.transsion.home.adapter.filter.a aVar2 = uGCFilterFragment.mAdapter;
                if (aVar2 != null && (h02 = aVar2.h0()) != null && h02.r() && (aVar = uGCFilterFragment.mAdapter) != null && (h03 = aVar.h0()) != null) {
                    h03.v();
                }
            } else {
                gl.o oVar2 = (gl.o) uGCFilterFragment.getMViewBinding();
                if (oVar2 != null && (swipeRefreshLayout = oVar2.f63926d) != null && swipeRefreshLayout.isRefreshing()) {
                    gl.o oVar3 = (gl.o) uGCFilterFragment.getMViewBinding();
                    if (oVar3 != null && (swipeRefreshLayout2 = oVar3.f63926d) != null) {
                        swipeRefreshLayout2.setRefreshing(false);
                    }
                    uGCFilterFragment.n0();
                }
            }
            com.transsion.home.adapter.filter.a aVar3 = uGCFilterFragment.mAdapter;
            if (aVar3 != null && (data = aVar3.getData()) != null && data.size() == 0) {
                if (nh.m.f70597a.e()) {
                    uGCFilterFragment.H1(uGCFilterFragment.getString(com.transsnet.downloader.R$string.str_ad_video_error_tips));
                } else {
                    uGCFilterFragment.E1();
                }
                return Unit.f67184a;
            }
            if (nh.m.f70597a.e()) {
                uh.b.f76876a.d(com.transsnet.downloader.R$string.str_ad_video_error_tips);
            } else {
                uh.b.f76876a.d(R$string.no_network_toast);
            }
            lg.a.f68962a.i("UGCFilterFragment", "getUGCContentList failed: code=" + (refreshBaseDto != null ? refreshBaseDto.getCode() : null) + ", msg=" + (refreshBaseDto != null ? refreshBaseDto.getMsg() : null), true);
            return Unit.f67184a;
        }
        hj.b logViewConfig = uGCFilterFragment.getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        com.transsion.home.adapter.filter.a aVar4 = uGCFilterFragment.mAdapter;
        if (aVar4 == null || (data2 = aVar4.getData()) == null || !data2.isEmpty() || uGCFilterFragment.hasRecordedFirstLoadDuration || uGCFilterFragment.firstLoadStartTimeMillis <= 0) {
            hj.b logViewConfig2 = uGCFilterFragment.getLogViewConfig();
            if (logViewConfig2 != null && (g11 = logViewConfig2.g()) != null) {
                UGCContentList uGCContentList = (UGCContentList) refreshBaseDto.getData();
                if (uGCContentList != null && (items = uGCContentList.getItems()) != null && (uGCContent = (UGCContent) CollectionsKt.k0(items)) != null && (video = uGCContent.getVideo()) != null) {
                    r0 = video.getOps();
                }
                g11.put("ops", r0);
            }
        } else {
            long currentTimeMillis = System.currentTimeMillis() - uGCFilterFragment.firstLoadStartTimeMillis;
            hj.b logViewConfig3 = uGCFilterFragment.getLogViewConfig();
            if (logViewConfig3 != null && (g12 = logViewConfig3.g()) != null) {
                g12.put("load_duration", String.valueOf(currentTimeMillis));
                UGCContentList uGCContentList2 = (UGCContentList) refreshBaseDto.getData();
                if (uGCContentList2 != null && (items2 = uGCContentList2.getItems()) != null && (uGCContent2 = (UGCContent) CollectionsKt.k0(items2)) != null && (video2 = uGCContent2.getVideo()) != null) {
                    r0 = video2.getOps();
                }
                g12.put("ops", r0);
            }
            uGCFilterFragment.hasRecordedFirstLoadDuration = true;
        }
        UGCContentList uGCContentList3 = (UGCContentList) refreshBaseDto.getData();
        if (uGCContentList3 != null) {
            uGCFilterFragment.K1(uGCContentList3, refreshBaseDto.getIsRefresh());
            View view = uGCFilterFragment.mNoNetworkView;
            if (view != null) {
                jg.c.g(view);
            }
        }
        uGCFilterFragment.hideLoading();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z1(UGCFilterFragment uGCFilterFragment, UGCFilterItem uGCFilterItem) {
        if (uGCFilterItem != null) {
            lg.a.f68962a.c("UGCFilterFragment", "selectFilterItemLiveData changed: id=" + uGCFilterItem.getCategoryId() + ", name=" + uGCFilterItem.getName(), false);
            uGCFilterFragment.B1(uGCFilterItem);
            hl.b bVar = uGCFilterFragment.mExposureHelper;
            if (bVar != null) {
                bVar.e();
            }
        }
        return Unit.f67184a;
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void c0() {
        super.c0();
        this.mPage = 1;
        A1(true);
        hl.b bVar = this.mExposureHelper;
        if (bVar != null) {
            bVar.e();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public RecyclerView f0() {
        gl.o oVar = (gl.o) getMViewBinding();
        if (oVar != null) {
            return oVar.f63925c;
        }
        return null;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public gl.o getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        gl.o c11 = gl.o.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public String g0() {
        int e12 = e1();
        return e12 != 2 ? e12 != 3 ? "HomeFragmentListLinearTemplateAd" : "HomeFragmentListGrid3TemplateAd" : "HomeFragmentListGrid2TemplateAd";
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void hideLoading() {
        g1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment, com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        f0 f0Var;
        ConstraintLayout constraintLayout;
        Intrinsics.h(view, "view");
        super.initView(view, savedInstanceState);
        this.mMovieModel = (UGCFilterViewModel) new v0(this).a(UGCFilterViewModel.class);
        n0 n0Var = null;
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.ugc_header_filter, (ViewGroup) null);
        n0 a11 = n0.a(inflate);
        this.headerBinding = a11;
        if (a11 == null) {
            Intrinsics.z("headerBinding");
        } else {
            n0Var = a11;
        }
        this.filterView = n0Var.f63917b;
        l1();
        Intrinsics.e(inflate);
        s1(inflate);
        k1();
        o1();
        t1(inflate);
        com.transsion.home.adapter.filter.a aVar = this.mAdapter;
        if (aVar != null) {
            BaseQuickAdapter.y(aVar, inflate, 0, 0, 6, null);
        }
        initViewModel();
        setNetListener(new g());
        this.header = inflate;
        int color = androidx.core.content.b.getColor(requireContext(), R$color.module_01);
        gl.o oVar = (gl.o) getMViewBinding();
        if (oVar == null || (f0Var = oVar.f63924b) == null || (constraintLayout = f0Var.f63819c) == null) {
            return;
        }
        constraintLayout.setBackgroundColor(color);
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void l0(int lastAdPosition, BiddingNativeManager wrapperNativeManager) {
        List<Object> data;
        List<Object> data2;
        Intrinsics.h(wrapperNativeManager, "wrapperNativeManager");
        if (wrapperNativeManager != null) {
            UGCFilterVideoItem a11 = UGCFilterVideoItem.INSTANCE.a(wrapperNativeManager, this.mCategory, Y0());
            com.transsion.home.adapter.filter.a aVar = this.mAdapter;
            int size = (aVar == null || (data2 = aVar.getData()) == null) ? 0 : data2.size();
            if (lastAdPosition < 0 || lastAdPosition > size) {
                com.transsion.home.adapter.filter.a aVar2 = this.mAdapter;
                if (aVar2 != null) {
                    aVar2.p(a11);
                }
            } else {
                com.transsion.home.adapter.filter.a aVar3 = this.mAdapter;
                if (aVar3 != null) {
                    aVar3.n(lastAdPosition, a11);
                }
            }
            a.C0856a c0856a = lg.a.f68962a;
            com.transsion.home.adapter.filter.a aVar4 = this.mAdapter;
            c0856a.c("UGCFilterFragment", "onAdCallback: insert ad at position=" + lastAdPosition + ", total size=" + ((aVar4 == null || (data = aVar4.getData()) == null) ? null : Integer.valueOf(data.size())), false);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        loadData();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public hj.b newLogViewConfig() {
        return new hj.b("/home/ugc_filter", false, 2, null);
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment, com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        String str2;
        HashMap g11;
        String string;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("category")) == null) {
            str = "Education";
        }
        this.mCategory = str;
        if (str.length() == 0) {
            this.mCategory = "Education";
        }
        Bundle arguments2 = getArguments();
        String str3 = "";
        if (arguments2 == null || (str2 = arguments2.getString("filter_json")) == null) {
            str2 = "";
        }
        this.mFilterJson = str2;
        Bundle arguments3 = getArguments();
        if (arguments3 != null && (string = arguments3.getString("fromOptId")) != null) {
            str3 = string;
        }
        this.fromOptId = str3;
        lg.a.f68962a.c("UGCFilterFragment", "onCreate: category=" + this.mCategory + ", filterJson=" + this.mFilterJson, false);
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (g11 = logViewConfig.g()) == null) {
            return;
        }
        g11.put(WebConstants.PAGE_FROM, hj.i.f64628a.i());
        g11.put("from_opt_id", this.fromOptId);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        androidx.view.b0 o11;
        androidx.view.b0 k11;
        this.mPage = 1;
        UGCFilterViewModel uGCFilterViewModel = this.mMovieModel;
        if (uGCFilterViewModel != null && (k11 = uGCFilterViewModel.k()) != null) {
            k11.q(null);
        }
        UGCFilterViewModel uGCFilterViewModel2 = this.mMovieModel;
        if (uGCFilterViewModel2 != null && (o11 = uGCFilterViewModel2.o()) != null) {
            o11.q(null);
        }
        lg.a.f68962a.c("UGCFilterFragment", "onDestroyView: clear data", false);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        com.transsion.baseui.activity.k.h(null, this, hidden, "tabId=" + getMTabId(), 1, null);
        if (isResumed()) {
            if (hidden) {
                logPause();
            } else {
                logResume();
            }
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        hl.b bVar = this.mExposureHelper;
        if (bVar != null) {
            bVar.e();
        }
        com.transsion.baseui.activity.k.l(null, this, "tabId=" + getMTabId(), 1, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com.transsion.home.adapter.filter.a aVar;
        List<Object> data;
        super.onResume();
        View view = this.mNoNetworkView;
        if (view != null && jg.c.i(view) && nh.m.f70597a.e() && (aVar = this.mAdapter) != null && (data = aVar.getData()) != null && data.isEmpty()) {
            View view2 = this.mNoNetworkView;
            if (view2 != null) {
                jg.c.g(view2);
            }
            loadData();
        }
        com.transsion.baseui.activity.k.p(null, this, "tabId=" + getMTabId() + " visible=" + isVisible(), 1, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void startLoading() {
        showLoadingView();
    }
}
