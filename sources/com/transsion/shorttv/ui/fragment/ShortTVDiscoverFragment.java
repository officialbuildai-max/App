package com.transsion.shorttv.ui.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.view.v0;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.gyf.immersionbar.ImmersionBar;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.shorttv.R$color;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv.R$string;
import com.transsion.shorttv.base.fragment.PageStatusFragment;
import com.transsion.shorttv.base.widget.NpaGridLayoutManager;
import com.transsion.shorttv.base.widget.SafeRecyclerView;
import com.transsion.shorttv.base.widget.StateView;
import com.transsion.shorttv.bean.BannerBean;
import com.transsion.shorttv.bean.BannerData;
import com.transsion.shorttv.bean.Image;
import com.transsion.shorttv.bean.OperateItem;
import com.transsion.shorttv.bean.OperatingResp;
import com.transsion.shorttv.bean.Pager;
import com.transsion.shorttv.bean.ShortTVRespData;
import com.transsion.shorttv.bean.ShortTvItemType;
import com.transsion.shorttv.bean.Subject;
import com.transsion.shorttv.ui.adapter.ShortTVBannerAdapter;
import com.transsion.shorttv.ui.widget.ShortTVBannerView;
import com.transsion.shorttv.ui.widget.ShortTVDiscoverHeaderView;
import com.transsion.shorttv.ui.widget.ShortTVFavoriteView;
import com.transsion.shorttv.ui.widget.ShortTvLoadMoreView;
import com.transsion.shorttv.viewmodel.ShortTvViewModel;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;
import lh.a;
import ms.q0;

@Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u0098\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002Û\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\u0019\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\u0019\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001e\u0010\u0013J\u000f\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0005H\u0002¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0004\b!\u0010\u0004J\u001f\u0010$\u001a\u00020\u00052\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"H\u0002¢\u0006\u0004\b$\u0010%J\u001f\u0010(\u001a\u00020\u00052\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\"H\u0002¢\u0006\u0004\b(\u0010%J'\u0010.\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0005H\u0002¢\u0006\u0004\b0\u0010\u0004J\u0017\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u00020)H\u0002¢\u0006\u0004\b2\u00103J\u001f\u00105\u001a\u00020\u00052\u0006\u00104\u001a\u00020)2\u0006\u0010\u000b\u001a\u00020#H\u0002¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0005H\u0002¢\u0006\u0004\b7\u0010\u0004J\u000f\u00108\u001a\u00020\u0005H\u0002¢\u0006\u0004\b8\u0010\u0004J\u001f\u0010<\u001a\u00020\u00052\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\u0010H\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0005H\u0002¢\u0006\u0004\b>\u0010\u0004J\u0017\u0010A\u001a\u00020\u00022\u0006\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\bA\u0010BJ\u000f\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\u0005H\u0016¢\u0006\u0004\bF\u0010\u0004J\u000f\u0010G\u001a\u00020\u0005H\u0016¢\u0006\u0004\bG\u0010\u0004J\r\u0010H\u001a\u00020\u0005¢\u0006\u0004\bH\u0010\u0004J\u000f\u0010I\u001a\u00020\u0005H\u0016¢\u0006\u0004\bI\u0010\u0004J\u000f\u0010J\u001a\u00020\u0005H\u0016¢\u0006\u0004\bJ\u0010\u0004J)\u0010O\u001a\u00020\u00052\u0006\u0010L\u001a\u00020K2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050M¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\u0005H\u0016¢\u0006\u0004\bQ\u0010\u0004J\u000f\u0010R\u001a\u00020\u0005H\u0016¢\u0006\u0004\bR\u0010\u0004J/\u0010U\u001a\u00020\u00052\u000e\u0010S\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010\"2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010T\u001a\u00020\u0010H\u0016¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\u0005H\u0016¢\u0006\u0004\bW\u0010\u0004J\u0017\u0010Z\u001a\u00020Y2\u0006\u0010X\u001a\u00020\u0010H\u0016¢\u0006\u0004\bZ\u0010[J\u000f\u0010\\\u001a\u00020)H\u0016¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020YH\u0016¢\u0006\u0004\b^\u0010_J\u0011\u0010`\u001a\u0004\u0018\u00010YH\u0016¢\u0006\u0004\b`\u0010_J\u000f\u0010a\u001a\u00020)H\u0016¢\u0006\u0004\ba\u0010]J\u0017\u0010c\u001a\u00020\u00052\u0006\u0010b\u001a\u00020\u0010H\u0016¢\u0006\u0004\bc\u0010\u0013J\u000f\u0010d\u001a\u00020\u0005H\u0016¢\u0006\u0004\bd\u0010\u0004J\u000f\u0010e\u001a\u00020\u0005H\u0016¢\u0006\u0004\be\u0010\u0004J\u000f\u0010f\u001a\u00020CH\u0016¢\u0006\u0004\bf\u0010EJ\u000f\u0010g\u001a\u00020CH\u0016¢\u0006\u0004\bg\u0010EJ\u000f\u0010i\u001a\u00020hH\u0016¢\u0006\u0004\bi\u0010jJ\u000f\u0010k\u001a\u00020\u0005H\u0016¢\u0006\u0004\bk\u0010\u0004R\"\u0010p\u001a\n l*\u0004\u0018\u00010C0C8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010ER$\u0010x\u001a\u0004\u0018\u00010q8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\"\u0010}\u001a\u00020C8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\by\u0010n\u001a\u0004\bz\u0010E\"\u0004\b{\u0010|R*\u0010\u0085\u0001\u001a\u0004\u0018\u00010~8\u0004@\u0004X\u0084\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R!\u0010\u008b\u0001\u001a\u00030\u0086\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R'\u0010\u0092\u0001\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0005\b\u0092\u0001\u0010\u0015\"\u0005\b\u0093\u0001\u0010\u0013R'\u0010\u0095\u0001\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0006\b\u0094\u0001\u0010\u0091\u0001\u001a\u0005\b\u0095\u0001\u0010\u0015\"\u0005\b\u0096\u0001\u0010\u0013R\u0019\u0010\u0099\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R'\u0010\u009e\u0001\u001a\u0010\u0012\u0004\u0012\u00020C\u0012\u0005\u0012\u00030\u009b\u00010\u009a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001c\u0010¢\u0001\u001a\u0005\u0018\u00010\u009f\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u001c\u0010¦\u0001\u001a\u0005\u0018\u00010£\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R\u001b\u0010©\u0001\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R!\u0010®\u0001\u001a\u00030ª\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b«\u0001\u0010\u0088\u0001\u001a\u0006\b¬\u0001\u0010\u00ad\u0001R\u0019\u0010°\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010\u0098\u0001R\u001a\u0010´\u0001\u001a\u00030±\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R\u0019\u0010¶\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010\u0091\u0001R\u0017\u0010¸\u0001\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b·\u0001\u0010\u0098\u0001RH\u0010Á\u0001\u001a!\u0012\u0015\u0012\u00130\u0010¢\u0006\u000e\b¹\u0001\u0012\t\bº\u0001\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0005\u0018\u00010M8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b»\u0001\u0010¼\u0001\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001R\u001b\u0010Ä\u0001\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R'\u0010Æ\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010¼\u0001R\u0017\u0010È\u0001\u001a\u00020\u00108\u0002X\u0082D¢\u0006\b\n\u0006\bÇ\u0001\u0010\u0091\u0001R'\u0010Ì\u0001\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bÉ\u0001\u0010\u0091\u0001\u001a\u0005\bÊ\u0001\u0010\u0015\"\u0005\bË\u0001\u0010\u0013R\u0019\u0010Î\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010\u0098\u0001R\u0018\u0010Ò\u0001\u001a\u00030Ï\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÐ\u0001\u0010Ñ\u0001R\u001c\u0010Ö\u0001\u001a\u0005\u0018\u00010Ó\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010Õ\u0001R\u0016\u0010Ø\u0001\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b×\u0001\u0010\u0015R\u0016\u0010Ú\u0001\u001a\u00020)8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÙ\u0001\u0010]¨\u0006Ü\u0001"}, d2 = {"Lcom/transsion/shorttv/ui/fragment/ShortTVDiscoverFragment;", "Lcom/transsion/shorttv/base/fragment/PageStatusFragment;", "Lms/x;", "<init>", "()V", "", "Y0", "Lcom/transsion/shorttv/bean/OperatingResp;", "M0", "(Lcom/transsion/shorttv/bean/OperatingResp;)Lcom/transsion/shorttv/bean/OperatingResp;", "Lcom/transsion/shorttv/bean/ShortTVRespData;", "data", "C1", "(Lcom/transsion/shorttv/bean/ShortTVRespData;)V", "z1", "(Lcom/transsion/shorttv/bean/OperatingResp;)V", "", "isBanner", "L0", "(Z)V", "W0", "()Z", "s1", "I0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "K0", "(Landroidx/recyclerview/widget/RecyclerView;)V", "loadMore", "isRefresh", "k1", "j1", "H0", "t1", "", "Lcom/transsion/shorttv/bean/BannerData;", "v1", "(Ljava/util/List;)V", "Lcom/transsion/shorttv/bean/OperateItem;", "ops", "A1", "", "fromPosition", "toPosition", "", "positionOffset", "n1", "(IIF)V", "l1", "dy", "o1", "(I)V", RequestParameters.POSITION, "m1", "(ILcom/transsion/shorttv/bean/BannerData;)V", "showLoading", "hideLoading", "Lcom/transsion/shorttv/bean/Subject;", "subject", "isDownloadView", "p1", "(Lcom/transsion/shorttv/bean/Subject;Z)V", "initAd", "Landroid/view/LayoutInflater;", "inflater", "V0", "(Landroid/view/LayoutInflater;)Lms/x;", "", "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewData", "initViewModel", "u1", TmcConstants.NAVIGATION_ON_START, "initListener", "Landroidx/recyclerview/widget/RecyclerView$r;", "pageScrollListener", "Lkotlin/Function1;", "onLoaderSuccess", "B1", "(Landroidx/recyclerview/widget/RecyclerView$r;Lkotlin/jvm/functions/Function1;)V", "retryLoadData", "r1", "list", "hasMore", "E1", "(Ljava/util/List;ZZ)V", "D1", "isShowTitleLayout", "Landroid/view/View;", "getEmptyView", "(Z)Landroid/view/View;", "getScreenType", "()I", "getNoNetworkView", "()Landroid/view/View;", "getLoadingView", "T0", "hidden", "onHiddenChanged", "onResume", "onPause", "getPageName", "R0", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "onDestroy", "kotlin.jvm.PlatformType", "i", "Ljava/lang/String;", "getTAG", "TAG", "Lcom/transsion/shorttv/ui/adapter/h;", com.mbridge.msdk.foundation.same.report.j.f35620b, "Lcom/transsion/shorttv/ui/adapter/h;", "S0", "()Lcom/transsion/shorttv/ui/adapter/h;", "setListAdapter", "(Lcom/transsion/shorttv/ui/adapter/h;)V", "listAdapter", CampaignEx.JSON_KEY_AD_K, "getNextPage", "setNextPage", "(Ljava/lang/String;)V", "nextPage", "Lcom/transsion/shorttv/viewmodel/ShortTvViewModel;", "l", "Lcom/transsion/shorttv/viewmodel/ShortTvViewModel;", "getViewModel", "()Lcom/transsion/shorttv/viewmodel/ShortTvViewModel;", "setViewModel", "(Lcom/transsion/shorttv/viewmodel/ShortTvViewModel;)V", "viewModel", "Lss/a;", "m", "Lkotlin/Lazy;", "U0", "()Lss/a;", "recReport", "Lcom/transsion/shorttv/ui/widget/ShortTVFavoriteView;", "n", "Lcom/transsion/shorttv/ui/widget/ShortTVFavoriteView;", "favoriteHeaderView", "o", "Z", "isFirstStart", "setFirstStart", TtmlNode.TAG_P, "isFirstPageChange", "setFirstPageChange", CampaignEx.JSON_KEY_AD_Q, "I", "tabId", "", "Landroid/view/ViewGroup;", CampaignEx.JSON_KEY_AD_R, "Ljava/util/Map;", "headerViewList", "Lms/q0;", "s", "Lms/q0;", "bannerBinding", "Lcom/transsion/shorttv/ui/adapter/ShortTVBannerAdapter;", "t", "Lcom/transsion/shorttv/ui/adapter/ShortTVBannerAdapter;", "bannerAdapter", TmcStartParams.KEY_URL_SHORT, "Lcom/transsion/shorttv/bean/OperatingResp;", "curOperatingResp", "Lcom/transsion/shorttv/utils/a;", "v", "O0", "()Lcom/transsion/shorttv/utils/a;", "bannerDotHelper", "w", "bannerCurPosition", "", "x", "J", "bannerBrowseTime", "y", "hasAddedBanner", "z", "statusBarHeight", "Lkotlin/ParameterName;", "name", "A", "Lkotlin/jvm/functions/Function1;", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "B", "Landroidx/recyclerview/widget/RecyclerView$r;", "subTabScrollListener", "C", "subTabLoadSuccessListener", "D", "mockServerNoBanner", "E", "getHasSlideOutBanner", "y1", "hasSlideOutBanner", "F", "mDy", "Lxr/b;", "G", "Lxr/b;", "exposureHelper", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "H", "Lcom/transsion/ad/bidding/nativead/BiddingListManager;", "v3ListManager", "Q0", "hasTopTabs", "N0", "adjustNoBannerTopMarginPx", "a", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public class ShortTVDiscoverFragment extends PageStatusFragment<ms.x> {

    /* renamed from: I, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A, reason: from kotlin metadata */
    private Function1 listener;

    /* renamed from: B, reason: from kotlin metadata */
    private RecyclerView.r subTabScrollListener;

    /* renamed from: C, reason: from kotlin metadata */
    private Function1 subTabLoadSuccessListener;

    /* renamed from: D, reason: from kotlin metadata */
    private final boolean mockServerNoBanner;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean hasSlideOutBanner;

    /* renamed from: F, reason: from kotlin metadata */
    private int mDy;

    /* renamed from: H, reason: from kotlin metadata */
    private BiddingListManager v3ListManager;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private com.transsion.shorttv.ui.adapter.h listAdapter;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private ShortTvViewModel viewModel;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private ShortTVFavoriteView favoriteHeaderView;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private q0 bannerBinding;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private ShortTVBannerAdapter bannerAdapter;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private OperatingResp curOperatingResp;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private long bannerBrowseTime;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private boolean hasAddedBanner;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final String TAG = getClass().getSimpleName();

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String nextPage = "1";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy recReport = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.ui.fragment.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ss.a q12;
            q12 = ShortTVDiscoverFragment.q1();
            return q12;
        }
    });

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstStart = true;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstPageChange = true;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int tabId = 13;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private Map headerViewList = new LinkedHashMap();

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private final Lazy bannerDotHelper = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.ui.fragment.j
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.transsion.shorttv.utils.a J0;
            J0 = ShortTVDiscoverFragment.J0(ShortTVDiscoverFragment.this);
            return J0;
        }
    });

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private int bannerCurPosition = -1;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private final int statusBarHeight = com.blankj.utilcode.util.d.c();

    /* renamed from: G, reason: from kotlin metadata */
    private final xr.b exposureHelper = new xr.b(0.6f, new d(), false, 4, null);

    /* renamed from: com.transsion.shorttv.ui.fragment.ShortTVDiscoverFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ShortTVDiscoverFragment b(Companion companion, boolean z10, Bundle bundle, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                bundle = null;
            }
            return companion.a(z10, bundle);
        }

        public final ShortTVDiscoverFragment a(boolean z10, Bundle bundle) {
            ShortTVDiscoverFragment shortTVDiscoverFragment = new ShortTVDiscoverFragment();
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            bundle2.putBoolean("arg_has_top_tabs", z10);
            shortTVDiscoverFragment.setArguments(bundle2);
            return shortTVDiscoverFragment;
        }
    }

    /* loaded from: classes6.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f53330a;

        static {
            int[] iArr = new int[ShortTvItemType.values().length];
            try {
                iArr[ShortTvItemType.FILTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ShortTvItemType.APPOINTMENT_LIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ShortTvItemType.CUSTOM_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ShortTvItemType.OP_SUBJECTS_MOVIE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ShortTvItemType.PLAY_LIST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f53330a = iArr;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends RecyclerView.r {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            Intrinsics.h(recyclerView, "recyclerView");
            if (i12 > 0) {
                ShortTVDiscoverFragment.this.K0(recyclerView);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements xr.a {
        d() {
        }

        @Override // xr.a
        public void a(int i11, long j11, View view) {
            Subject b11;
            List<Object> data;
            List<Object> data2;
            com.transsion.shorttv.ui.adapter.h listAdapter = ShortTVDiscoverFragment.this.getListAdapter();
            if (((listAdapter == null || (data2 = listAdapter.getData()) == null) ? 0 : data2.size()) <= i11) {
                return;
            }
            com.transsion.shorttv.ui.adapter.h listAdapter2 = ShortTVDiscoverFragment.this.getListAdapter();
            xs.a aVar = (listAdapter2 == null || (data = listAdapter2.getData()) == null) ? null : (xs.a) data.get(i11);
            if (aVar == null || aVar.d() != 1 || (b11 = aVar.b()) == null) {
                return;
            }
            ShortTVDiscoverFragment shortTVDiscoverFragment = ShortTVDiscoverFragment.this;
            shortTVDiscoverFragment.U0().a(shortTVDiscoverFragment.getPageName(), b11, i11, Long.valueOf(j11), shortTVDiscoverFragment.R0());
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends DiffUtil.e {
        e() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(xs.a oldItem, xs.a newItem) {
            Intrinsics.h(oldItem, "oldItem");
            Intrinsics.h(newItem, "newItem");
            if (oldItem.d() != 1 || newItem.d() != 1) {
                return false;
            }
            Subject b11 = oldItem.b();
            String subjectId = b11 != null ? b11.getSubjectId() : null;
            Subject b12 = newItem.b();
            return Intrinsics.c(subjectId, b12 != null ? b12.getSubjectId() : null);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(xs.a oldItem, xs.a newItem) {
            Intrinsics.h(oldItem, "oldItem");
            Intrinsics.h(newItem, "newItem");
            if (oldItem.d() != newItem.d()) {
                return false;
            }
            if (oldItem.d() != 1) {
                return Intrinsics.c(oldItem, newItem);
            }
            Subject b11 = oldItem.b();
            String subjectId = b11 != null ? b11.getSubjectId() : null;
            Subject b12 = newItem.b();
            return Intrinsics.c(subjectId, b12 != null ? b12.getSubjectId() : null);
        }
    }

    /* loaded from: classes6.dex */
    public static final class f extends GridLayoutManager.c {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ SafeRecyclerView f53334f;

        f(SafeRecyclerView safeRecyclerView) {
            this.f53334f = safeRecyclerView;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i11) {
            xs.a aVar;
            Subject b11;
            com.transsion.shorttv.ui.adapter.h listAdapter = ShortTVDiscoverFragment.this.getListAdapter();
            boolean z10 = ((listAdapter == null || (aVar = (xs.a) listAdapter.f0(i11)) == null || (b11 = aVar.b()) == null) ? null : b11.getNonAdDelegate()) != null;
            Context context = this.f53334f.getContext();
            Intrinsics.g(context, "getContext(...)");
            return (!ds.a.a(context) || z10) ? 2 : 1;
        }
    }

    /* loaded from: classes6.dex */
    public static final class g extends RecyclerView.l {
        g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
            Intrinsics.h(outRect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(parent, "parent");
            Intrinsics.h(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (parent.getAdapter() != null) {
                if (childAdapterPosition == 0) {
                    outRect.top = com.blankj.utilcode.util.a0.a(0.0f);
                } else {
                    outRect.top = com.blankj.utilcode.util.a0.a(16.0f);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class h extends RecyclerView.r {

        /* renamed from: a, reason: collision with root package name */
        private int f53335a;

        h() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            ms.x xVar;
            SafeRecyclerView safeRecyclerView;
            Intrinsics.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i11);
            if (i11 != 0 || (xVar = (ms.x) ShortTVDiscoverFragment.this.getMViewBinding()) == null || (safeRecyclerView = xVar.f70071b) == null || safeRecyclerView.canScrollVertically(-1)) {
                return;
            }
            ShortTVDiscoverFragment shortTVDiscoverFragment = ShortTVDiscoverFragment.this;
            shortTVDiscoverFragment.L0(shortTVDiscoverFragment.W0());
            ShortTVDiscoverFragment.this.y1(false);
            this.f53335a = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            Intrinsics.h(recyclerView, "recyclerView");
            ShortTVDiscoverFragment.this.o1(i12);
        }
    }

    /* loaded from: classes6.dex */
    static final class i implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f53337a;

        i(Function1 function) {
            Intrinsics.h(function, "function");
            this.f53337a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f53337a;
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
            this.f53337a.invoke(obj);
        }
    }

    /* loaded from: classes6.dex */
    public static final class j extends ViewPager2.OnPageChangeCallback {
        j() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            ShortTVDiscoverFragment shortTVDiscoverFragment = ShortTVDiscoverFragment.this;
            shortTVDiscoverFragment.n1(i11, shortTVDiscoverFragment.bannerCurPosition, f11);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            if (ShortTVDiscoverFragment.this.isResumed()) {
                ShortTVDiscoverFragment.this.l1();
                ShortTVDiscoverFragment.this.bannerBrowseTime = System.currentTimeMillis();
            }
            ShortTVDiscoverFragment.this.bannerCurPosition = i11;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0132 A[EDGE_INSN: B:106:0x0132->B:58:0x0132 BREAK  A[LOOP:4: B:99:0x011f->B:105:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void A1(java.util.List r23) {
        /*
            Method dump skipped, instructions count: 516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.ui.fragment.ShortTVDiscoverFragment.A1(java.util.List):void");
    }

    private final void C1(ShortTVRespData data) {
        String str;
        Boolean hasMore;
        r6.f h02;
        com.transsion.shorttv.ui.adapter.h hVar;
        r6.f h03;
        com.transsion.shorttv.ui.adapter.h hVar2;
        List<Object> data2;
        if (data == null) {
            if (this.bannerBinding == null && this.headerViewList.isEmpty() && (hVar2 = this.listAdapter) != null && (data2 = hVar2.getData()) != null && data2.isEmpty()) {
                D1();
                return;
            }
            com.transsion.shorttv.ui.adapter.h hVar3 = this.listAdapter;
            if (hVar3 == null || (h02 = hVar3.h0()) == null || !h02.r() || (hVar = this.listAdapter) == null || (h03 = hVar.h0()) == null) {
                return;
            }
            h03.v();
            return;
        }
        Pager pager = data.getPager();
        if (pager == null || (str = pager.getNextPage()) == null) {
            str = "1";
        }
        this.nextPage = str;
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.TAG;
        Intrinsics.g(TAG, "TAG");
        String str2 = this.nextPage;
        List<Subject> items = data.getItems();
        Integer valueOf = items != null ? Integer.valueOf(items.size()) : null;
        Pager pager2 = data.getPager();
        a.C0856a.f(c0856a, TAG, "updateTreadingList,nextPage :" + str2 + ", size:" + valueOf + ", hasMore:" + (pager2 != null ? pager2.getHasMore() : null), false, 4, null);
        List<Subject> items2 = data.getItems();
        boolean isRefresh = data.isRefresh();
        Pager pager3 = data.getPager();
        E1(items2, isRefresh, (pager3 == null || (hasMore = pager3.getHasMore()) == null) ? false : hasMore.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F1(ShortTVDiscoverFragment shortTVDiscoverFragment) {
        com.transsion.shorttv.ui.adapter.h hVar = shortTVDiscoverFragment.listAdapter;
        if (hVar != null) {
            hVar.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G1(ShortTVDiscoverFragment shortTVDiscoverFragment) {
        com.transsion.shorttv.ui.adapter.h hVar = shortTVDiscoverFragment.listAdapter;
        if (hVar != null) {
            hVar.notifyDataSetChanged();
        }
    }

    private final void H0() {
        Context context;
        if (this.favoriteHeaderView == null && (context = getContext()) != null) {
            ShortTVFavoriteView shortTVFavoriteView = new ShortTVFavoriteView(this, "collection", U0(), context);
            this.favoriteHeaderView = shortTVFavoriteView;
            if (this.hasAddedBanner) {
                com.transsion.shorttv.ui.adapter.h hVar = this.listAdapter;
                if (hVar != null) {
                    Intrinsics.e(shortTVFavoriteView);
                    BaseQuickAdapter.y(hVar, shortTVFavoriteView, 2, 0, 4, null);
                    return;
                }
                return;
            }
            com.transsion.shorttv.ui.adapter.h hVar2 = this.listAdapter;
            if (hVar2 != null) {
                Intrinsics.e(shortTVFavoriteView);
                BaseQuickAdapter.y(hVar2, shortTVFavoriteView, 1, 0, 4, null);
            }
        }
    }

    private final void I0() {
        SafeRecyclerView safeRecyclerView;
        ms.x xVar = (ms.x) getMViewBinding();
        if (xVar == null || (safeRecyclerView = xVar.f70071b) == null) {
            return;
        }
        safeRecyclerView.addOnScrollListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.shorttv.utils.a J0(ShortTVDiscoverFragment shortTVDiscoverFragment) {
        return new com.transsion.shorttv.utils.a(shortTVDiscoverFragment.getPageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K0(RecyclerView recyclerView) {
        com.transsion.shorttv.ui.adapter.h hVar;
        LinearLayout Z;
        RecyclerView.m layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        if (!(layoutManager instanceof LinearLayoutManager) || ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() != 0 || (hVar = this.listAdapter) == null || (Z = hVar.Z()) == null) {
            return;
        }
        int childCount = Z.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = Z.getChildAt(i11);
            if ((childAt instanceof ShortTVDiscoverHeaderView) && childAt.getVisibility() == 0) {
                ((ShortTVDiscoverHeaderView) childAt).clearExposureCache();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L0(boolean isBanner) {
        int color;
        ms.x xVar;
        View view;
        if (isBanner && W0()) {
            ImmersionBar with = ImmersionBar.with(this);
            color = 0;
            with.statusBarDarkFont(false);
            with.init();
        } else {
            color = androidx.core.content.b.getColor(requireContext(), R$color.short_tv_bg_02);
            ImmersionBar with2 = ImmersionBar.with(this);
            with2.statusBarDarkFont(!ds.g.f61554a.a());
            with2.init();
        }
        if (lr.c.f69154a.b().d().a() || (xVar = (ms.x) getMViewBinding()) == null || (view = xVar.f70076g) == null) {
            return;
        }
        view.setBackgroundColor(color);
    }

    private final OperatingResp M0(OperatingResp operatingResp) {
        OperateItem operateItem;
        BannerBean banner;
        List<BannerData> banners;
        OperateItem copy;
        List<OperateItem> items = operatingResp.getItems();
        if (items == null || (operateItem = (OperateItem) CollectionsKt.l0(items, 0)) == null || (banner = operateItem.getBanner()) == null || (banners = banner.getBanners()) == null || banners.isEmpty()) {
            return operatingResp;
        }
        copy = operateItem.copy((r39 & 1) != 0 ? operateItem.title : null, (r39 & 2) != 0 ? operateItem.type : null, (r39 & 4) != 0 ? operateItem.position : null, (r39 & 8) != 0 ? operateItem.deepLink : null, (r39 & 16) != 0 ? operateItem.banner : BannerBean.copy$default(banner, null, null, null, false, null, 29, null), (r39 & 32) != 0 ? operateItem.filters : null, (r39 & 64) != 0 ? operateItem.subjects : null, (r39 & 128) != 0 ? operateItem.customData : null, (r39 & 256) != 0 ? operateItem.playListData : null, (r39 & 512) != 0 ? operateItem.feedsSubject : null, (r39 & 1024) != 0 ? operateItem.opId : null, (r39 & 2048) != 0 ? operateItem.page : null, (r39 & 4096) != 0 ? operateItem.rankings : null, (r39 & 8192) != 0 ? operateItem.rankingData : null, (r39 & 16384) != 0 ? operateItem.rankingListData : null, (r39 & 32768) != 0 ? operateItem.liveList : null, (r39 & 65536) != 0 ? operateItem.groups : null, (r39 & 131072) != 0 ? operateItem.nonAdDelegate : null, (r39 & 262144) != 0 ? operateItem.pageName : null, (r39 & 524288) != 0 ? operateItem.md5 : null, (r39 & 1048576) != 0 ? operateItem.ops : null);
        List U0 = CollectionsKt.U0(items);
        U0.set(0, copy);
        OperatingResp copy$default = OperatingResp.copy$default(operatingResp, U0, null, null, null, 14, null);
        copy$default.setCache(operatingResp.getIsCache());
        return copy$default;
    }

    private final int N0() {
        return yr.a.a(lr.c.f69154a.b().d().d());
    }

    private final com.transsion.shorttv.utils.a O0() {
        return (com.transsion.shorttv.utils.a) this.bannerDotHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(ShortTVDiscoverFragment shortTVDiscoverFragment) {
        String f11;
        shortTVDiscoverFragment.retryLoadData();
        hj.b logViewConfig = shortTVDiscoverFragment.getLogViewConfig();
        if (logViewConfig != null && (f11 = logViewConfig.f()) != null) {
            com.transsion.shorttv.base.widget.k.b(f11);
        }
        return Unit.f67184a;
    }

    private final boolean Q0() {
        Bundle arguments = getArguments();
        return arguments != null && arguments.getBoolean("arg_has_top_tabs", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ss.a U0() {
        return (ss.a) this.recReport.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean W0() {
        ShortTVBannerAdapter shortTVBannerAdapter = this.bannerAdapter;
        if (shortTVBannerAdapter == null) {
            return false;
        }
        Intrinsics.e(shortTVBannerAdapter);
        return shortTVBannerAdapter.getData().size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(ShortTVDiscoverFragment shortTVDiscoverFragment, int i11, BiddingNativeManager wrapperNativeManager) {
        List<Object> data;
        Intrinsics.h(wrapperNativeManager, "wrapperNativeManager");
        if (wrapperNativeManager != null) {
            Subject subject = new Subject(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, false, null, null, 0, 0, null, 0, null, 0, null, -1, 1073741823, null);
            subject.setNonAdDelegate(wrapperNativeManager);
            com.transsion.shorttv.ui.adapter.h hVar = shortTVDiscoverFragment.listAdapter;
            int size = (hVar == null || (data = hVar.getData()) == null) ? 0 : data.size();
            Context context = shortTVDiscoverFragment.getContext();
            int i12 = (context == null || !ds.a.a(context) || i11 % 2 == 0) ? i11 : i11 - 1;
            if (i12 <= size) {
                com.transsion.shorttv.ui.adapter.h hVar2 = shortTVDiscoverFragment.listAdapter;
                if (hVar2 != null) {
                    hVar2.n(i12, new xs.a(1, null, subject, null, 0, false, 58, null));
                }
            } else {
                com.transsion.shorttv.ui.adapter.h hVar3 = shortTVDiscoverFragment.listAdapter;
                if (hVar3 != null) {
                    hVar3.n(size, new xs.a(1, null, subject, null, 0, false, 58, null));
                }
            }
        }
        return Unit.f67184a;
    }

    private final void Y0() {
        final SwipeRefreshLayout swipeRefreshLayout;
        SafeRecyclerView safeRecyclerView;
        final boolean z10 = true;
        com.transsion.shorttv.ui.adapter.h hVar = new com.transsion.shorttv.ui.adapter.h(getPageName(), true);
        hVar.h0().C(new ShortTvLoadMoreView());
        hVar.h0().z(true);
        hVar.h0().y(true);
        hVar.h0().E(3);
        hVar.h0().D(new p6.f() { // from class: com.transsion.shorttv.ui.fragment.m
            @Override // p6.f
            public final void a() {
                ShortTVDiscoverFragment.a1(ShortTVDiscoverFragment.this);
            }
        });
        hVar.R0(new e());
        hVar.w1(new p6.d() { // from class: com.transsion.shorttv.ui.fragment.n
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                ShortTVDiscoverFragment.b1(ShortTVDiscoverFragment.this, baseQuickAdapter, view, i11);
            }
        });
        hVar.l(R$id.btn_download);
        hVar.s1(new p6.b() { // from class: com.transsion.shorttv.ui.fragment.o
            @Override // p6.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                ShortTVDiscoverFragment.c1(ShortTVDiscoverFragment.this, z10, baseQuickAdapter, view, i11);
            }
        });
        this.listAdapter = hVar;
        ms.x xVar = (ms.x) getMViewBinding();
        if (xVar != null && (safeRecyclerView = xVar.f70071b) != null) {
            NpaGridLayoutManager npaGridLayoutManager = new NpaGridLayoutManager(safeRecyclerView.getContext(), 2);
            npaGridLayoutManager.d0(new f(safeRecyclerView));
            safeRecyclerView.setLayoutManager(npaGridLayoutManager);
            safeRecyclerView.setAdapter(this.listAdapter);
            safeRecyclerView.setItemAnimator(null);
            safeRecyclerView.addOnScrollListener(this.exposureHelper);
            I0();
            safeRecyclerView.addItemDecoration(new g());
        }
        ms.x xVar2 = (ms.x) getMViewBinding();
        if (xVar2 == null || (swipeRefreshLayout = xVar2.f70072c) == null) {
            return;
        }
        int a11 = com.blankj.utilcode.util.a0.a(30.0f);
        int i11 = this.statusBarHeight + a11;
        swipeRefreshLayout.setProgressViewOffset(false, i11, (a11 * 2) + i11);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.shorttv.ui.fragment.p
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void a() {
                ShortTVDiscoverFragment.Z0(SwipeRefreshLayout.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(SwipeRefreshLayout swipeRefreshLayout, ShortTVDiscoverFragment shortTVDiscoverFragment) {
        if (nh.m.f70597a.e()) {
            shortTVDiscoverFragment.r1();
        } else {
            fs.b.f62582a.d(R$string.short_tv_no_network_toast);
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(ShortTVDiscoverFragment shortTVDiscoverFragment) {
        shortTVDiscoverFragment.loadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(ShortTVDiscoverFragment shortTVDiscoverFragment, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Subject b11;
        List<Object> data;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        com.transsion.shorttv.ui.adapter.h hVar = shortTVDiscoverFragment.listAdapter;
        xs.a aVar = (hVar == null || (data = hVar.getData()) == null) ? null : (xs.a) CollectionsKt.l0(data, i11);
        if (aVar == null || (b11 = aVar.b()) == null) {
            return;
        }
        shortTVDiscoverFragment.U0().c(shortTVDiscoverFragment.getPageName(), b11, i11, shortTVDiscoverFragment.R0());
        shortTVDiscoverFragment.p1(b11, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(ShortTVDiscoverFragment shortTVDiscoverFragment, boolean z10, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Subject b11;
        List<Object> data;
        Intrinsics.h(baseQuickAdapter, "<unused var>");
        Intrinsics.h(view, "<unused var>");
        com.transsion.shorttv.ui.adapter.h hVar = shortTVDiscoverFragment.listAdapter;
        xs.a aVar = (hVar == null || (data = hVar.getData()) == null) ? null : (xs.a) CollectionsKt.l0(data, i11);
        if (aVar == null || (b11 = aVar.b()) == null) {
            return;
        }
        shortTVDiscoverFragment.U0().c(shortTVDiscoverFragment.getPageName(), b11, i11, shortTVDiscoverFragment.R0());
        shortTVDiscoverFragment.p1(b11, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(ShortTVDiscoverFragment shortTVDiscoverFragment) {
        SafeRecyclerView safeRecyclerView;
        if (shortTVDiscoverFragment.isAdded()) {
            ms.x xVar = (ms.x) shortTVDiscoverFragment.getMViewBinding();
            int computeVerticalScrollOffset = (xVar == null || (safeRecyclerView = xVar.f70071b) == null) ? 0 : safeRecyclerView.computeVerticalScrollOffset();
            shortTVDiscoverFragment.mDy = 0;
            shortTVDiscoverFragment.o1(computeVerticalScrollOffset);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(ShortTVDiscoverFragment shortTVDiscoverFragment, OperatingResp operatingResp) {
        shortTVDiscoverFragment.hideLoading();
        if (shortTVDiscoverFragment.mockServerNoBanner) {
            operatingResp = operatingResp != null ? shortTVDiscoverFragment.M0(operatingResp) : null;
        }
        shortTVDiscoverFragment.z1(operatingResp);
        if (operatingResp == null || !operatingResp.getIsCache()) {
            shortTVDiscoverFragment.k1(true);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(ShortTVDiscoverFragment shortTVDiscoverFragment, ShortTVRespData shortTVRespData) {
        shortTVDiscoverFragment.hideLoading();
        shortTVDiscoverFragment.C1(shortTVRespData);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(ShortTVDiscoverFragment shortTVDiscoverFragment, ShortTVRespData shortTVRespData) {
        if ((shortTVRespData != null ? shortTVRespData.getItems() : null) != null) {
            List<Subject> items = shortTVRespData.getItems();
            Intrinsics.e(items);
            if (!items.isEmpty()) {
                a.C0856a c0856a = lg.a.f68962a;
                String TAG = shortTVDiscoverFragment.TAG;
                Intrinsics.g(TAG, "TAG");
                a.C0856a.f(c0856a, TAG, "addHeaderView, has Favorite", false, 4, null);
                shortTVDiscoverFragment.H0();
                return Unit.f67184a;
            }
        }
        a.C0856a c0856a2 = lg.a.f68962a;
        String TAG2 = shortTVDiscoverFragment.TAG;
        Intrinsics.g(TAG2, "TAG");
        a.C0856a.z(c0856a2, TAG2, "addHeaderView, has no Favorite", false, 4, null);
        shortTVDiscoverFragment.t1();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(ShortTVDiscoverFragment shortTVDiscoverFragment) {
        r6.f h02;
        com.transsion.shorttv.ui.adapter.h hVar = shortTVDiscoverFragment.listAdapter;
        if (((hVar == null || (h02 = hVar.h0()) == null) ? null : h02.i()) == LoadMoreStatus.End) {
            return;
        }
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = shortTVDiscoverFragment.TAG;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "load more， loadData", false, 4, null);
        shortTVDiscoverFragment.k1(false);
    }

    private final void hideLoading() {
        showContentView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(ShortTVDiscoverFragment shortTVDiscoverFragment) {
        r6.f h02;
        com.transsion.shorttv.ui.adapter.h hVar = shortTVDiscoverFragment.listAdapter;
        if (hVar == null || (h02 = hVar.h0()) == null) {
            return;
        }
        h02.v();
    }

    private final void initAd() {
        BiddingListManager biddingListManager = new BiddingListManager();
        ms.x xVar = (ms.x) getMViewBinding();
        biddingListManager.F(xVar != null ? xVar.f70071b : null);
        biddingListManager.A(androidx.view.v.a(this));
        biddingListManager.G("ShortTvDiscoverMostTrendingScene");
        biddingListManager.z(new Function2() { // from class: com.transsion.shorttv.ui.fragment.l
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit X0;
                X0 = ShortTVDiscoverFragment.X0(ShortTVDiscoverFragment.this, ((Integer) obj).intValue(), (BiddingNativeManager) obj2);
                return X0;
            }
        });
        this.v3ListManager = biddingListManager;
    }

    private final void j1() {
        ShortTvViewModel shortTvViewModel = this.viewModel;
        if (shortTvViewModel != null) {
            shortTvViewModel.h0(this.tabId);
        }
    }

    private final void k1(boolean isRefresh) {
        ShortTvViewModel shortTvViewModel = this.viewModel;
        if (shortTvViewModel != null) {
            shortTvViewModel.r0(this.nextPage, 8, isRefresh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l1() {
        /*
            r22 = this;
            r0 = r22
            int r1 = r0.bannerCurPosition
            if (r1 < 0) goto L9f
            com.transsion.shorttv.ui.adapter.ShortTVBannerAdapter r2 = r0.bannerAdapter
            if (r2 == 0) goto L15
            java.util.List r2 = r2.getData()
            if (r2 == 0) goto L15
            int r2 = r2.size()
            goto L16
        L15:
            r2 = 0
        L16:
            if (r1 < r2) goto L1a
            goto L9f
        L1a:
            long r1 = r0.bannerBrowseTime
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L25
        L22:
            r16 = r3
            goto L2e
        L25:
            long r1 = java.lang.System.currentTimeMillis()
            long r3 = r0.bannerBrowseTime
            long r3 = r1 - r3
            goto L22
        L2e:
            com.transsion.shorttv.ui.adapter.ShortTVBannerAdapter r1 = r0.bannerAdapter
            if (r1 == 0) goto L9f
            java.util.List r1 = r1.getData()
            if (r1 == 0) goto L9f
            int r2 = r0.bannerCurPosition
            java.lang.Object r1 = r1.get(r2)
            com.transsion.shorttv.bean.BannerData r1 = (com.transsion.shorttv.bean.BannerData) r1
            if (r1 == 0) goto L9f
            com.transsion.shorttv.utils.a r5 = r22.O0()
            java.lang.String r6 = r22.getPageName()
            com.transsion.shorttv.bean.ShortTvItemType r2 = com.transsion.shorttv.bean.ShortTvItemType.BANNER
            java.lang.String r8 = r2.getValue()
            java.lang.String r9 = r1.getSubjectId()
            java.lang.String r3 = r1.getOps()
            r4 = 0
            if (r3 != 0) goto L6f
            com.transsion.shorttv.bean.Subject r3 = r1.getSubject()
            if (r3 == 0) goto L66
            java.lang.String r3 = r3.getOps()
            goto L67
        L66:
            r3 = r4
        L67:
            if (r3 != 0) goto L6f
            java.lang.String r2 = r2.getValue()
            r11 = r2
            goto L70
        L6f:
            r11 = r3
        L70:
            java.lang.Boolean r12 = r1.getHasResource()
            java.lang.String r13 = r1.getDeepLink()
            int r2 = r0.bannerCurPosition
            java.lang.Integer r14 = java.lang.Integer.valueOf(r2)
            com.transsion.shorttv.bean.Image r2 = r1.getImage()
            if (r2 == 0) goto L8a
            java.lang.String r2 = r2.getUrl()
            r15 = r2
            goto L8b
        L8a:
            r15 = r4
        L8b:
            boolean r1 = r1.getBuiltIn()
            java.lang.Boolean r18 = java.lang.Boolean.valueOf(r1)
            r20 = 4112(0x1010, float:5.762E-42)
            r21 = 0
            java.lang.String r7 = "opt"
            r10 = 0
            r19 = 0
            com.transsion.shorttv.utils.a.b(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r19, r20, r21)
        L9f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.ui.fragment.ShortTVDiscoverFragment.l1():void");
    }

    private final void loadMore() {
        SafeRecyclerView safeRecyclerView;
        SafeRecyclerView safeRecyclerView2;
        r6.f h02;
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.TAG;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "loadMore", false, 4, null);
        if (!nh.m.f70597a.e()) {
            fs.b.f62582a.d(R$string.short_tv_no_network_toast);
            ms.x xVar = (ms.x) getMViewBinding();
            if (xVar == null || (safeRecyclerView = xVar.f70071b) == null) {
                return;
            }
            safeRecyclerView.postDelayed(new Runnable() { // from class: com.transsion.shorttv.ui.fragment.e
                @Override // java.lang.Runnable
                public final void run() {
                    ShortTVDiscoverFragment.i1(ShortTVDiscoverFragment.this);
                }
            }, 500L);
            return;
        }
        com.transsion.shorttv.ui.adapter.h hVar = this.listAdapter;
        if (hVar != null && (h02 = hVar.h0()) != null) {
            h02.w();
        }
        ms.x xVar2 = (ms.x) getMViewBinding();
        if (xVar2 == null || (safeRecyclerView2 = xVar2.f70071b) == null) {
            return;
        }
        safeRecyclerView2.postDelayed(new Runnable() { // from class: com.transsion.shorttv.ui.fragment.d
            @Override // java.lang.Runnable
            public final void run() {
                ShortTVDiscoverFragment.h1(ShortTVDiscoverFragment.this);
            }
        }, 300L);
    }

    private final void m1(int position, BannerData data) {
        String ops = data.getOps();
        if (ops == null) {
            Subject subject = data.getSubject();
            ops = subject != null ? subject.getOps() : null;
            if (ops == null) {
                ops = ShortTvItemType.BANNER.getValue();
            }
        }
        com.transsion.shorttv.utils.a O0 = O0();
        String pageName = getPageName();
        String value = ShortTvItemType.BANNER.getValue();
        String subjectId = data.getSubjectId();
        Boolean hasResource = data.getHasResource();
        String deepLink = data.getDeepLink();
        Integer valueOf = Integer.valueOf(position);
        Image image = data.getImage();
        O0.c(pageName, "opt", value, (r31 & 8) != 0 ? null : subjectId, (r31 & 16) != 0 ? null : null, (r31 & 32) != 0 ? null : ops, (r31 & 64) != 0 ? null : hasResource, (r31 & 128) != 0 ? null : null, (r31 & 256) != 0 ? null : deepLink, (r31 & 512) != 0 ? null : valueOf, (r31 & 1024) != 0 ? null : image != null ? image.getUrl() : null, (r31 & 2048) != 0 ? Boolean.FALSE : Boolean.valueOf(data.getBuiltIn()), (r31 & 4096) != 0 ? null : null);
        String deepLink2 = data.getDeepLink();
        if (deepLink2 != null) {
            Uri a11 = zr.a.f79573a.a(Uri.parse(deepLink2 + "&ops=" + ops));
            if (a11 != null) {
                ds.c.j(a11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n1(int fromPosition, int toPosition, float positionOffset) {
        Image image;
        String averageHueDark;
        Image image2;
        String averageHueDark2;
        View view;
        View view2;
        SwipeRefreshLayout swipeRefreshLayout;
        View view3;
        View view4;
        View view5;
        List data;
        List data2;
        ShortTVBannerAdapter shortTVBannerAdapter = this.bannerAdapter;
        BannerData bannerData = null;
        BannerData bannerData2 = (shortTVBannerAdapter == null || (data2 = shortTVBannerAdapter.getData()) == null) ? null : (BannerData) data2.get(fromPosition);
        ShortTVBannerAdapter shortTVBannerAdapter2 = this.bannerAdapter;
        if (shortTVBannerAdapter2 != null && (data = shortTVBannerAdapter2.getData()) != null) {
            bannerData = (BannerData) data.get(toPosition);
        }
        if (bannerData2 == null || (image = bannerData2.getImage()) == null || (averageHueDark = image.getAverageHueDark()) == null || bannerData == null || (image2 = bannerData.getImage()) == null || (averageHueDark2 = image2.getAverageHueDark()) == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{fromPosition == toPosition ? Color.parseColor(averageHueDark) : i00.a.a(positionOffset, Color.parseColor(averageHueDark), Color.parseColor(averageHueDark2)), 0});
        if (!lr.c.f69154a.b().d().a()) {
            q0 q0Var = this.bannerBinding;
            if (q0Var == null || (view5 = q0Var.f70024d) == null) {
                return;
            }
            view5.setBackground(gradientDrawable);
            return;
        }
        ms.x xVar = (ms.x) getMViewBinding();
        if (xVar != null && (view3 = xVar.f70073d) != null) {
            ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            q0 q0Var2 = this.bannerBinding;
            layoutParams.height = (q0Var2 == null || (view4 = q0Var2.f70024d) == null) ? 1 : view4.getHeight();
            view3.setLayoutParams(layoutParams);
            view3.setBackground(gradientDrawable);
        }
        ms.x xVar2 = (ms.x) getMViewBinding();
        if (xVar2 != null && (swipeRefreshLayout = xVar2.f70072c) != null) {
            ViewGroup.LayoutParams layoutParams2 = swipeRefreshLayout.getLayoutParams();
            if (layoutParams2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams2;
            bVar.setMargins(0, yr.a.a(74), 0, 0);
            swipeRefreshLayout.setLayoutParams(bVar);
        }
        q0 q0Var3 = this.bannerBinding;
        if (q0Var3 != null && (view2 = q0Var3.f70026f) != null) {
            ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
            if (layoutParams3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            layoutParams3.height = 0;
            view2.setLayoutParams(layoutParams3);
        }
        q0 q0Var4 = this.bannerBinding;
        if (q0Var4 == null || (view = q0Var4.f70025e) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams4 = view.getLayoutParams();
        if (layoutParams4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams4.height = yr.a.a(4);
        view.setLayoutParams(layoutParams4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o1(int dy2) {
        if (dy2 == 0) {
            this.mDy = 0;
        } else {
            this.mDy += dy2;
        }
        if (Math.abs(this.mDy) > ((com.blankj.utilcode.util.y.e() * 9) / 16) / 2) {
            if (this.hasSlideOutBanner) {
                return;
            }
            L0(false);
            this.hasSlideOutBanner = true;
            return;
        }
        if (this.hasSlideOutBanner) {
            L0(true);
            this.hasSlideOutBanner = false;
        }
    }

    private final void p1(Subject subject, boolean isDownloadView) {
        Context context = getContext();
        if (context != null) {
            ns.a.f70665a.a((FragmentActivity) context, getPageName(), subject.getOps(), (r21 & 8) != 0 ? null : "download_subject", (r21 & 16) != 0 ? false : isDownloadView, (r21 & 32) != 0 ? null : subject, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? Boolean.FALSE : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ss.a q1() {
        return new ss.a();
    }

    private final void s1(boolean isBanner) {
        Space space;
        View view;
        Space space2;
        View view2;
        Space space3;
        View view3;
        if (isBanner) {
            ms.x xVar = (ms.x) getMViewBinding();
            if (xVar != null && (view3 = xVar.f70075f) != null) {
                ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
                ((ViewGroup.MarginLayoutParams) bVar).height = this.subTabScrollListener != null ? 0 : this.statusBarHeight;
                view3.setLayoutParams(bVar);
            }
            ms.x xVar2 = (ms.x) getMViewBinding();
            if (xVar2 == null || (space3 = xVar2.f70074e) == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = space3.getLayoutParams();
            if (layoutParams2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
            ((ViewGroup.MarginLayoutParams) bVar2).height = this.subTabScrollListener != null ? yr.a.a(90) : 0;
            space3.setLayoutParams(bVar2);
            return;
        }
        if (Q0() && lr.c.f69154a.b().d().a()) {
            ms.x xVar3 = (ms.x) getMViewBinding();
            if (xVar3 != null && (view2 = xVar3.f70075f) != null) {
                ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
                if (layoutParams3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                ConstraintLayout.b bVar3 = (ConstraintLayout.b) layoutParams3;
                ((ViewGroup.MarginLayoutParams) bVar3).height = this.statusBarHeight + N0();
                view2.setLayoutParams(bVar3);
            }
            ms.x xVar4 = (ms.x) getMViewBinding();
            if (xVar4 == null || (space2 = xVar4.f70074e) == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams4 = space2.getLayoutParams();
            if (layoutParams4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.b bVar4 = (ConstraintLayout.b) layoutParams4;
            ((ViewGroup.MarginLayoutParams) bVar4).height = 0;
            space2.setLayoutParams(bVar4);
            return;
        }
        int i11 = Q0() ? 0 : this.statusBarHeight;
        ms.x xVar5 = (ms.x) getMViewBinding();
        if (xVar5 != null && (view = xVar5.f70075f) != null) {
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            if (layoutParams5 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.b bVar5 = (ConstraintLayout.b) layoutParams5;
            ((ViewGroup.MarginLayoutParams) bVar5).height = i11;
            view.setLayoutParams(bVar5);
        }
        ms.x xVar6 = (ms.x) getMViewBinding();
        if (xVar6 == null || (space = xVar6.f70074e) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams6 = space.getLayoutParams();
        if (layoutParams6 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.b bVar6 = (ConstraintLayout.b) layoutParams6;
        ((ViewGroup.MarginLayoutParams) bVar6).height = 0;
        space.setLayoutParams(bVar6);
    }

    private final void showLoading() {
        showLoadingView();
    }

    private final void t1() {
        ShortTVFavoriteView shortTVFavoriteView = this.favoriteHeaderView;
        if (shortTVFavoriteView == null) {
            return;
        }
        com.transsion.shorttv.ui.adapter.h hVar = this.listAdapter;
        if (hVar != null) {
            Intrinsics.e(shortTVFavoriteView);
            hVar.J0(shortTVFavoriteView);
        }
        this.favoriteHeaderView = null;
    }

    private final void v1(List data) {
        View view;
        View view2;
        if (this.bannerBinding != null) {
            a.C0856a c0856a = lg.a.f68962a;
            String TAG = this.TAG;
            Intrinsics.g(TAG, "TAG");
            a.C0856a.f(c0856a, TAG, "set banner data", false, 4, null);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(data);
            ShortTVBannerAdapter shortTVBannerAdapter = this.bannerAdapter;
            if (shortTVBannerAdapter != null) {
                shortTVBannerAdapter.setData(arrayList);
                return;
            }
            return;
        }
        a.C0856a c0856a2 = lg.a.f68962a;
        String TAG2 = this.TAG;
        Intrinsics.g(TAG2, "TAG");
        a.C0856a.f(c0856a2, TAG2, "add banner HeaderView", false, 4, null);
        if (getContext() != null) {
            q0 c11 = q0.c(LayoutInflater.from(getContext()));
            this.bannerBinding = c11;
            ViewGroup.LayoutParams layoutParams = (c11 == null || (view2 = c11.f70025e) == null) ? null : view2.getLayoutParams();
            if (this.subTabScrollListener != null) {
                if (layoutParams != null) {
                    layoutParams.height = this.statusBarHeight + com.blankj.utilcode.util.a0.a(50.0f);
                }
            } else if (layoutParams != null) {
                layoutParams.height = this.statusBarHeight + com.blankj.utilcode.util.a0.a(10.0f);
            }
            q0 q0Var = this.bannerBinding;
            if (q0Var != null && (view = q0Var.f70025e) != null) {
                view.setLayoutParams(layoutParams);
            }
            q0 q0Var2 = this.bannerBinding;
            Intrinsics.e(q0Var2);
            ShortTVBannerView shortTVBannerView = q0Var2.f70022b;
            shortTVBannerView.getWindowVisibility();
            ShortTVBannerAdapter shortTVBannerAdapter2 = new ShortTVBannerAdapter();
            shortTVBannerAdapter2.k(new Function3() { // from class: com.transsion.shorttv.ui.fragment.h
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit w12;
                    w12 = ShortTVDiscoverFragment.w1(ShortTVDiscoverFragment.this, (View) obj, ((Integer) obj2).intValue(), (BannerData) obj3);
                    return w12;
                }
            });
            this.bannerAdapter = shortTVBannerAdapter2;
            shortTVBannerView.setAutoTurningTime(4000L);
            shortTVBannerView.setPagerScrollDuration(1000L);
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            shortTVBannerView.setPageMargin(com.blankj.utilcode.util.a0.a((ds.a.a(requireContext) ? 3 : 1) * 44.0f), com.blankj.utilcode.util.a0.a(16.0f));
            shortTVBannerView.addPageTransformer(new com.to.aboomy.pager2banner.b());
            shortTVBannerView.setOuterPageChangeListener(new j());
            shortTVBannerView.setAdapter(this.bannerAdapter);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(data);
            ShortTVBannerAdapter shortTVBannerAdapter3 = this.bannerAdapter;
            Intrinsics.e(shortTVBannerAdapter3);
            shortTVBannerAdapter3.setData(arrayList2);
            shortTVBannerView.post(new Runnable() { // from class: com.transsion.shorttv.ui.fragment.i
                @Override // java.lang.Runnable
                public final void run() {
                    ShortTVDiscoverFragment.x1(ShortTVDiscoverFragment.this);
                }
            });
            com.transsion.shorttv.ui.adapter.h hVar = this.listAdapter;
            if (hVar != null) {
                q0 q0Var3 = this.bannerBinding;
                Intrinsics.e(q0Var3);
                ConstraintLayout root = q0Var3.f70023c;
                Intrinsics.g(root, "root");
                BaseQuickAdapter.y(hVar, root, 0, 0, 4, null);
            }
            this.hasAddedBanner = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w1(ShortTVDiscoverFragment shortTVDiscoverFragment, View view, int i11, BannerData item) {
        Intrinsics.h(view, "<unused var>");
        Intrinsics.h(item, "item");
        shortTVDiscoverFragment.m1(i11, item);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(ShortTVDiscoverFragment shortTVDiscoverFragment) {
        shortTVDiscoverFragment.n1(0, 0, 0.0f);
    }

    private final void z1(OperatingResp data) {
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        SwipeRefreshLayout swipeRefreshLayout3;
        OperateItem operateItem;
        SwipeRefreshLayout swipeRefreshLayout4;
        SwipeRefreshLayout swipeRefreshLayout5;
        SwipeRefreshLayout swipeRefreshLayout6;
        List<OperateItem> items;
        OperateItem operateItem2;
        com.transsion.shorttv.ui.adapter.h hVar;
        List<Object> data2;
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        if (data == null) {
            if (this.bannerBinding == null && this.headerViewList.isEmpty() && (hVar = this.listAdapter) != null && (data2 = hVar.getData()) != null && data2.isEmpty()) {
                D1();
                return;
            }
            return;
        }
        OperatingResp operatingResp = this.curOperatingResp;
        if (Intrinsics.c(operatingResp != null ? operatingResp.getVersion() : null, data.getVersion())) {
            a.C0856a c0856a = lg.a.f68962a;
            String TAG = this.TAG;
            Intrinsics.g(TAG, "TAG");
            a.C0856a.r(c0856a, TAG, new String[]{"setOperationListData, version same:" + data.getVersion()}, false, 4, null);
        } else {
            a.C0856a c0856a2 = lg.a.f68962a;
            String TAG2 = this.TAG;
            Intrinsics.g(TAG2, "TAG");
            OperatingResp operatingResp2 = this.curOperatingResp;
            String version = operatingResp2 != null ? operatingResp2.getVersion() : null;
            a.C0856a.r(c0856a2, TAG2, new String[]{"setOperationListData oldVs:" + version + ", newVs:" + data.getVersion()}, false, 4, null);
            List<OperateItem> items2 = data.getItems();
            if (items2 != null && (operateItem = (OperateItem) CollectionsKt.l0(items2, 0)) != null) {
                OperatingResp operatingResp3 = this.curOperatingResp;
                String md5 = (operatingResp3 == null || (items = operatingResp3.getItems()) == null || (operateItem2 = (OperateItem) CollectionsKt.l0(items, 0)) == null) ? null : operateItem2.getMd5();
                a.C0858a c0858a = lh.a.f68965a;
                String j11 = com.blankj.utilcode.util.o.j(operateItem);
                Intrinsics.g(j11, "toJson(...)");
                String d11 = c0858a.d(j11);
                operateItem.setMd5(d11);
                String TAG3 = this.TAG;
                Intrinsics.g(TAG3, "TAG");
                List<BannerData> banners = data.getBanners();
                a.C0856a.f(c0856a2, TAG3, "banner size: " + (banners != null ? Integer.valueOf(banners.size()) : null), false, 4, null);
                if (data.getBanners() == null || !(!r1.isEmpty())) {
                    L0(false);
                    Function1 function1 = this.listener;
                    if (function1 != null) {
                        function1.invoke(Boolean.FALSE);
                    }
                    s1(false);
                    if (Q0() && lr.c.f69154a.b().d().a()) {
                        int N0 = this.statusBarHeight + N0();
                        ms.x xVar = (ms.x) getMViewBinding();
                        if (xVar != null && (swipeRefreshLayout5 = xVar.f70072c) != null) {
                            ViewGroup.LayoutParams layoutParams = swipeRefreshLayout5.getLayoutParams();
                            if (layoutParams == null) {
                                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                            }
                            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
                            bVar.setMargins(0, N0, 0, 0);
                            swipeRefreshLayout5.setLayoutParams(bVar);
                        }
                    } else {
                        int i11 = Q0() ? 0 : this.statusBarHeight;
                        ms.x xVar2 = (ms.x) getMViewBinding();
                        if (xVar2 != null && (swipeRefreshLayout4 = xVar2.f70072c) != null) {
                            ViewGroup.LayoutParams layoutParams2 = swipeRefreshLayout4.getLayoutParams();
                            if (layoutParams2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                            }
                            ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
                            bVar2.setMargins(0, i11, 0, 0);
                            swipeRefreshLayout4.setLayoutParams(bVar2);
                        }
                    }
                } else if (!Intrinsics.c(md5, d11)) {
                    List<BannerData> banners2 = data.getBanners();
                    Intrinsics.e(banners2);
                    v1(banners2);
                    L0(true);
                    s1(true);
                    Function1 function12 = this.listener;
                    if (function12 != null) {
                        function12.invoke(Boolean.TRUE);
                    }
                    ms.x xVar3 = (ms.x) getMViewBinding();
                    if (xVar3 != null && (swipeRefreshLayout6 = xVar3.f70072c) != null) {
                        ViewGroup.LayoutParams layoutParams3 = swipeRefreshLayout6.getLayoutParams();
                        if (layoutParams3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                        }
                        ConstraintLayout.b bVar3 = (ConstraintLayout.b) layoutParams3;
                        bVar3.setMargins(0, com.blankj.utilcode.util.a0.a(0.0f), 0, 0);
                        swipeRefreshLayout6.setLayoutParams(bVar3);
                    }
                }
            }
            A1(data.getItems());
            this.curOperatingResp = data;
        }
        ms.x xVar4 = (ms.x) getMViewBinding();
        if (xVar4 == null || (swipeRefreshLayout2 = xVar4.f70072c) == null || !swipeRefreshLayout2.isRefreshing()) {
            Function1 function13 = this.subTabLoadSuccessListener;
            if (function13 != null) {
                function13.invoke(Boolean.valueOf(W0()));
            }
        } else {
            ms.x xVar5 = (ms.x) getMViewBinding();
            if (xVar5 != null && (swipeRefreshLayout3 = xVar5.f70072c) != null) {
                swipeRefreshLayout3.setRefreshing(false);
            }
        }
        ShortTVBannerAdapter shortTVBannerAdapter = this.bannerAdapter;
        List data3 = shortTVBannerAdapter != null ? shortTVBannerAdapter.getData() : null;
        if ((data3 == null || data3.isEmpty()) && Q0() && lr.c.f69154a.b().d().a()) {
            int N02 = this.statusBarHeight + N0();
            ms.x xVar6 = (ms.x) getMViewBinding();
            if (xVar6 == null || (swipeRefreshLayout = xVar6.f70072c) == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams4 = swipeRefreshLayout.getLayoutParams();
            if (layoutParams4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.b bVar4 = (ConstraintLayout.b) layoutParams4;
            bVar4.setMargins(0, N02, 0, 0);
            swipeRefreshLayout.setLayoutParams(bVar4);
        }
    }

    public final void B1(RecyclerView.r pageScrollListener, Function1 onLoaderSuccess) {
        Intrinsics.h(pageScrollListener, "pageScrollListener");
        Intrinsics.h(onLoaderSuccess, "onLoaderSuccess");
        this.subTabScrollListener = pageScrollListener;
        this.subTabLoadSuccessListener = onLoaderSuccess;
    }

    public void D1() {
        if (nh.m.f70597a.e()) {
            PageStatusFragment.c0(this, false, 1, null);
        } else {
            showNoNetworkView(false);
        }
    }

    public void E1(List list, boolean isRefresh, boolean hasMore) {
        r6.f h02;
        r6.f h03;
        com.transsion.shorttv.ui.adapter.h hVar;
        r6.f h04;
        SwipeRefreshLayout swipeRefreshLayout;
        ms.x xVar;
        SwipeRefreshLayout swipeRefreshLayout2;
        List<Object> data;
        SafeRecyclerView safeRecyclerView;
        List<Object> data2;
        List l11;
        List<Object> data3;
        List<Object> l12;
        r6.f h05;
        SwipeRefreshLayout swipeRefreshLayout3;
        r6.f h06;
        com.transsion.shorttv.ui.adapter.h hVar2;
        r6.f h07;
        SafeRecyclerView safeRecyclerView2;
        List<Object> data4;
        List l13;
        List<Object> data5;
        SwipeRefreshLayout swipeRefreshLayout4;
        ms.x xVar2;
        SwipeRefreshLayout swipeRefreshLayout5;
        List<Object> data6;
        Subject subject;
        SwipeRefreshLayout swipeRefreshLayout6;
        ms.x xVar3 = (ms.x) getMViewBinding();
        if (xVar3 != null && (swipeRefreshLayout6 = xVar3.f70072c) != null) {
            swipeRefreshLayout6.setEnabled(true);
        }
        if (isRefresh) {
            BiddingListManager biddingListManager = this.v3ListManager;
            if (biddingListManager != null) {
                biddingListManager.y();
            }
            if (list != null && (subject = (Subject) CollectionsKt.k0(list)) != null) {
                subject.setShowTitle(true);
            }
        }
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            if (isRefresh) {
                hj.b logViewConfig = getLogViewConfig();
                if (logViewConfig != null) {
                    logViewConfig.k(true);
                }
                com.transsion.shorttv.ui.adapter.h hVar3 = this.listAdapter;
                Iterator<Object> it = (hVar3 == null || (data3 = hVar3.getData()) == null) ? null : data3.iterator();
                while (it != null && it.hasNext()) {
                    if (((xs.a) it.next()).d() == 1) {
                        it.remove();
                    }
                }
                com.transsion.shorttv.ui.adapter.h hVar4 = this.listAdapter;
                if (hVar4 != null && (data2 = hVar4.getData()) != null) {
                    if (list != null) {
                        List list3 = list;
                        l11 = new ArrayList<>(CollectionsKt.v(list3, 10));
                        Iterator it2 = list3.iterator();
                        while (it2.hasNext()) {
                            l11.add(new xs.a(1, null, (Subject) it2.next(), null, 0, false, 58, null));
                        }
                    } else {
                        l11 = CollectionsKt.l();
                    }
                    data2.addAll(l11);
                }
                ms.x xVar4 = (ms.x) getMViewBinding();
                if (xVar4 != null && (safeRecyclerView = xVar4.f70071b) != null) {
                    safeRecyclerView.post(new Runnable() { // from class: com.transsion.shorttv.ui.fragment.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            ShortTVDiscoverFragment.F1(ShortTVDiscoverFragment.this);
                        }
                    });
                }
            }
            com.transsion.shorttv.ui.adapter.h hVar5 = this.listAdapter;
            if (hVar5 == null || (data = hVar5.getData()) == null || !data.isEmpty()) {
                if (hasMore) {
                    com.transsion.shorttv.ui.adapter.h hVar6 = this.listAdapter;
                    if (hVar6 != null && (h03 = hVar6.h0()) != null && h03.r() && (hVar = this.listAdapter) != null && (h04 = hVar.h0()) != null) {
                        h04.s();
                    }
                } else {
                    com.transsion.shorttv.ui.adapter.h hVar7 = this.listAdapter;
                    if (hVar7 != null && (h02 = hVar7.h0()) != null) {
                        r6.f.u(h02, false, 1, null);
                    }
                }
            } else if (isRefresh) {
                Intrinsics.c(getPageName(), "minitv_explore");
            }
            ms.x xVar5 = (ms.x) getMViewBinding();
            if (xVar5 == null || (swipeRefreshLayout = xVar5.f70072c) == null || !swipeRefreshLayout.isRefreshing() || (xVar = (ms.x) getMViewBinding()) == null || (swipeRefreshLayout2 = xVar.f70072c) == null) {
                return;
            }
            swipeRefreshLayout2.setRefreshing(false);
            return;
        }
        com.transsion.shorttv.ui.adapter.h hVar8 = this.listAdapter;
        if ((hVar8 == null || (data6 = hVar8.getData()) == null || !data6.isEmpty()) && !isRefresh) {
            com.transsion.shorttv.ui.adapter.h hVar9 = this.listAdapter;
            if (hVar9 == null || (l12 = hVar9.getData()) == null) {
                l12 = CollectionsKt.l();
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                Subject subject2 = (Subject) obj;
                List<Object> list4 = l12;
                if (!(list4 instanceof Collection) || !list4.isEmpty()) {
                    Iterator<T> it3 = list4.iterator();
                    while (it3.hasNext()) {
                        if (Intrinsics.c(((xs.a) it3.next()).b(), subject2)) {
                            break;
                        }
                    }
                }
                arrayList.add(obj);
            }
            if (arrayList.isEmpty()) {
                a.C0856a c0856a = lg.a.f68962a;
                String TAG = this.TAG;
                Intrinsics.g(TAG, "TAG");
                a.C0856a.f(c0856a, TAG, "updateList 全部去重了", false, 4, null);
                return;
            }
            com.transsion.shorttv.ui.adapter.h hVar10 = this.listAdapter;
            if (hVar10 != null) {
                ArrayList arrayList2 = new ArrayList(CollectionsKt.v(arrayList, 10));
                Iterator it4 = arrayList.iterator();
                while (it4.hasNext()) {
                    arrayList2.add(new xs.a(1, null, (Subject) it4.next(), null, 0, false, 58, null));
                }
                hVar10.q(arrayList2);
            }
        } else {
            ms.x xVar6 = (ms.x) getMViewBinding();
            if (xVar6 != null && (swipeRefreshLayout4 = xVar6.f70072c) != null && swipeRefreshLayout4.isRefreshing() && (xVar2 = (ms.x) getMViewBinding()) != null && (swipeRefreshLayout5 = xVar2.f70072c) != null) {
                swipeRefreshLayout5.setRefreshing(false);
            }
            hj.b logViewConfig2 = getLogViewConfig();
            if (logViewConfig2 != null) {
                logViewConfig2.k(true);
            }
            com.transsion.shorttv.ui.adapter.h hVar11 = this.listAdapter;
            Iterator<Object> it5 = (hVar11 == null || (data5 = hVar11.getData()) == null) ? null : data5.iterator();
            while (it5 != null && it5.hasNext()) {
                if (((xs.a) it5.next()).d() == 1) {
                    it5.remove();
                }
            }
            com.transsion.shorttv.ui.adapter.h hVar12 = this.listAdapter;
            if (hVar12 != null && (data4 = hVar12.getData()) != null) {
                if (list != null) {
                    List list5 = list;
                    l13 = new ArrayList<>(CollectionsKt.v(list5, 10));
                    Iterator it6 = list5.iterator();
                    while (it6.hasNext()) {
                        l13.add(new xs.a(1, null, (Subject) it6.next(), null, 0, false, 58, null));
                    }
                } else {
                    l13 = CollectionsKt.l();
                }
                data4.addAll(l13);
            }
            ms.x xVar7 = (ms.x) getMViewBinding();
            if (xVar7 != null && (safeRecyclerView2 = xVar7.f70071b) != null) {
                safeRecyclerView2.post(new Runnable() { // from class: com.transsion.shorttv.ui.fragment.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        ShortTVDiscoverFragment.G1(ShortTVDiscoverFragment.this);
                    }
                });
            }
        }
        if (hasMore) {
            com.transsion.shorttv.ui.adapter.h hVar13 = this.listAdapter;
            if (hVar13 != null && (h06 = hVar13.h0()) != null && h06.r() && (hVar2 = this.listAdapter) != null && (h07 = hVar2.h0()) != null) {
                h07.s();
            }
        } else {
            com.transsion.shorttv.ui.adapter.h hVar14 = this.listAdapter;
            if (hVar14 != null && (h05 = hVar14.h0()) != null) {
                r6.f.u(h05, false, 1, null);
            }
        }
        if (W0() || Q0()) {
            return;
        }
        L0(false);
        Function1 function1 = this.listener;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        s1(false);
        ms.x xVar8 = (ms.x) getMViewBinding();
        if (xVar8 == null || (swipeRefreshLayout3 = xVar8.f70072c) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = swipeRefreshLayout3.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        bVar.setMargins(0, this.statusBarHeight, 0, 0);
        swipeRefreshLayout3.setLayoutParams(bVar);
    }

    public String R0() {
        return "most_trending";
    }

    /* renamed from: S0, reason: from getter */
    protected final com.transsion.shorttv.ui.adapter.h getListAdapter() {
        return this.listAdapter;
    }

    public int T0() {
        return R$layout.short_tv_layout_skeleton_drawing_discover;
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public ms.x getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        ms.x c11 = ms.x.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public View getEmptyView(boolean isShowTitleLayout) {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        StateView stateView = new StateView(requireContext);
        stateView.retry(new Function0() { // from class: com.transsion.shorttv.ui.fragment.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit P0;
                P0 = ShortTVDiscoverFragment.P0(ShortTVDiscoverFragment.this);
                return P0;
            }
        });
        stateView.showData(4, getScreenType(), false, getPageStateLayoutTitle(), getEmptyDescText());
        return stateView;
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public View getLoadingView() {
        View inflate = LayoutInflater.from(requireContext()).inflate(T0(), (ViewGroup) getFlStateView(), false);
        View findViewById = inflate.findViewById(R$id.v_bar_space);
        if (this.subTabScrollListener != null) {
            View findViewById2 = inflate.findViewById(R$id.v_title);
            Intrinsics.g(findViewById2, "findViewById(...)");
            ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = com.blankj.utilcode.util.a0.a(10.0f);
            findViewById2.setLayoutParams(bVar);
            int a11 = this.statusBarHeight + com.blankj.utilcode.util.a0.a(32.0f);
            Intrinsics.e(findViewById);
            ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
            if (layoutParams2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
            ((ViewGroup.MarginLayoutParams) bVar2).height = a11;
            findViewById.setLayoutParams(bVar2);
        } else {
            Intrinsics.e(findViewById);
            ViewGroup.LayoutParams layoutParams3 = findViewById.getLayoutParams();
            if (layoutParams3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.b bVar3 = (ConstraintLayout.b) layoutParams3;
            ((ViewGroup.MarginLayoutParams) bVar3).height = this.statusBarHeight;
            findViewById.setLayoutParams(bVar3);
        }
        return inflate;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
    
        if (r0 == null) goto L8;
     */
    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View getNoNetworkView() {
        /*
            r5 = this;
            com.transsion.shorttv.viewmodel.ShortTvViewModel r0 = r5.viewModel
            if (r0 == 0) goto L19
            qs.l r0 = r0.E0()
            if (r0 == 0) goto L19
            android.content.Context r1 = r5.requireContext()
            java.lang.String r2 = "requireContext(...)"
            kotlin.jvm.internal.Intrinsics.g(r1, r2)
            android.view.View r0 = r0.a(r1)
            if (r0 != 0) goto L1d
        L19:
            android.view.View r0 = super.getNoNetworkView()
        L1d:
            int r1 = r0.getPaddingStart()
            int r2 = r0.getPaddingTop()
            int r3 = r5.statusBarHeight
            int r2 = r2 + r3
            r3 = 1108082688(0x420c0000, float:35.0)
            int r3 = com.blankj.utilcode.util.a0.a(r3)
            int r2 = r2 + r3
            int r3 = r0.getPaddingEnd()
            int r4 = r0.getPaddingBottom()
            r0.setPadding(r1, r2, r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.ui.fragment.ShortTVDiscoverFragment.getNoNetworkView():android.view.View");
    }

    public String getPageName() {
        return "minitv_explore";
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public int getScreenType() {
        return 4;
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public void initListener() {
        SafeRecyclerView safeRecyclerView;
        SafeRecyclerView safeRecyclerView2;
        SafeRecyclerView safeRecyclerView3;
        if (this.subTabScrollListener != null) {
            ms.x xVar = (ms.x) getMViewBinding();
            if (xVar != null && (safeRecyclerView3 = xVar.f70071b) != null) {
                RecyclerView.r rVar = this.subTabScrollListener;
                Intrinsics.e(rVar);
                safeRecyclerView3.addOnScrollListener(rVar);
            }
        } else {
            ms.x xVar2 = (ms.x) getMViewBinding();
            if (xVar2 != null && (safeRecyclerView = xVar2.f70071b) != null) {
                safeRecyclerView.addOnScrollListener(new h());
            }
        }
        ms.x xVar3 = (ms.x) getMViewBinding();
        if (xVar3 == null || (safeRecyclerView2 = xVar3.f70071b) == null) {
            return;
        }
        safeRecyclerView2.post(new Runnable() { // from class: com.transsion.shorttv.ui.fragment.k
            @Override // java.lang.Runnable
            public final void run() {
                ShortTVDiscoverFragment.d1(ShortTVDiscoverFragment.this);
            }
        });
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public void initViewData() {
        Space space;
        View view;
        Bundle arguments = getArguments();
        this.tabId = arguments != null ? arguments.getInt("tab_id", this.tabId) : this.tabId;
        ms.x xVar = (ms.x) getMViewBinding();
        if (xVar != null && (view = xVar.f70075f) != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            ((ViewGroup.MarginLayoutParams) bVar).height = this.statusBarHeight;
            view.setLayoutParams(bVar);
        }
        ms.x xVar2 = (ms.x) getMViewBinding();
        if (xVar2 != null && (space = xVar2.f70074e) != null) {
            ViewGroup.LayoutParams layoutParams2 = space.getLayoutParams();
            if (layoutParams2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
            ((ViewGroup.MarginLayoutParams) bVar2).height = 0;
            space.setLayoutParams(bVar2);
        }
        Y0();
        initAd();
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public void initViewModel() {
        ShortTvViewModel shortTvViewModel;
        ShortTvViewModel shortTvViewModel2;
        androidx.view.b0 c02;
        androidx.view.b0 K0;
        androidx.view.b0 i02;
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.TAG;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "initViewModel " + this, false, 4, null);
        ShortTvViewModel shortTvViewModel3 = (ShortTvViewModel) new v0(this).a(ShortTvViewModel.class);
        this.viewModel = shortTvViewModel3;
        if (shortTvViewModel3 != null && (i02 = shortTvViewModel3.i0()) != null) {
            i02.j(this, new i(new Function1() { // from class: com.transsion.shorttv.ui.fragment.q
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit e12;
                    e12 = ShortTVDiscoverFragment.e1(ShortTVDiscoverFragment.this, (OperatingResp) obj);
                    return e12;
                }
            }));
        }
        ShortTvViewModel shortTvViewModel4 = this.viewModel;
        if (shortTvViewModel4 != null && (K0 = shortTvViewModel4.K0()) != null) {
            K0.j(this, new i(new Function1() { // from class: com.transsion.shorttv.ui.fragment.r
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit f12;
                    f12 = ShortTVDiscoverFragment.f1(ShortTVDiscoverFragment.this, (ShortTVRespData) obj);
                    return f12;
                }
            }));
        }
        if (lr.c.f69154a.b().c() && (shortTvViewModel2 = this.viewModel) != null && (c02 = shortTvViewModel2.c0()) != null) {
            c02.j(this, new i(new Function1() { // from class: com.transsion.shorttv.ui.fragment.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit g12;
                    g12 = ShortTVDiscoverFragment.g1(ShortTVDiscoverFragment.this, (ShortTVRespData) obj);
                    return g12;
                }
            }));
        }
        t1();
        showLoading();
        Context context = getContext();
        if (context != null && (shortTvViewModel = this.viewModel) != null) {
            shortTvViewModel.P0(context);
        }
        r1();
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public hj.b newLogViewConfig() {
        return new hj.b(getPageName(), false, 2, null);
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BiddingListManager biddingListManager = this.v3ListManager;
        if (biddingListManager != null) {
            biddingListManager.o();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (isResumed() && hidden) {
            this.exposureHelper.e();
            ms.x xVar = (ms.x) getMViewBinding();
            K0(xVar != null ? xVar.f70071b : null);
        }
        if (isResumed()) {
            if (hidden) {
                logPause();
            } else {
                logResume();
            }
        }
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        ShortTVBannerView shortTVBannerView;
        ShortTVBannerView shortTVBannerView2;
        super.onPause();
        l1();
        this.exposureHelper.e();
        ms.x xVar = (ms.x) getMViewBinding();
        K0(xVar != null ? xVar.f70071b : null);
        q0 q0Var = this.bannerBinding;
        if (q0Var == null || (shortTVBannerView = q0Var.f70022b) == null || !shortTVBannerView.isAttachedToWindow()) {
            return;
        }
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.TAG;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "onPause banner stopTurning", false, 4, null);
        q0 q0Var2 = this.bannerBinding;
        if (q0Var2 == null || (shortTVBannerView2 = q0Var2.f70022b) == null) {
            return;
        }
        shortTVBannerView2.stopTurning();
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        ShortTVBannerView shortTVBannerView;
        ShortTVBannerView shortTVBannerView2;
        super.onResume();
        this.bannerBrowseTime = System.currentTimeMillis();
        q0 q0Var = this.bannerBinding;
        if (q0Var == null || (shortTVBannerView = q0Var.f70022b) == null || !shortTVBannerView.isAttachedToWindow()) {
            return;
        }
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.TAG;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "onResume banner startTurning", false, 4, null);
        q0 q0Var2 = this.bannerBinding;
        if (q0Var2 == null || (shortTVBannerView2 = q0Var2.f70022b) == null) {
            return;
        }
        shortTVBannerView2.startTurning();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        ShortTvViewModel shortTvViewModel;
        super.onStart();
        if (isVisible()) {
            if (this.isFirstStart) {
                this.isFirstStart = false;
            } else {
                if (!lr.c.f69154a.b().c() || (shortTvViewModel = this.viewModel) == null) {
                    return;
                }
                shortTvViewModel.o0();
            }
        }
    }

    public void r1() {
        ShortTvViewModel shortTvViewModel;
        j1();
        if (lr.c.f69154a.b().c() && (shortTvViewModel = this.viewModel) != null) {
            shortTvViewModel.o0();
        }
        this.nextPage = "1";
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public void retryLoadData() {
        List<Object> data;
        com.transsion.shorttv.ui.adapter.h hVar = this.listAdapter;
        if (hVar != null && (data = hVar.getData()) != null && data.size() == 0) {
            showLoading();
            r1();
            return;
        }
        com.transsion.shorttv.ui.adapter.h hVar2 = this.listAdapter;
        if (hVar2 == null || hVar2.h0().i() != LoadMoreStatus.Fail) {
            return;
        }
        hVar2.h0().w();
    }

    public final void u1() {
        SafeRecyclerView safeRecyclerView;
        ms.x xVar = (ms.x) getMViewBinding();
        if (xVar == null || (safeRecyclerView = xVar.f70071b) == null) {
            return;
        }
        safeRecyclerView.smoothScrollToPosition(0);
    }

    public final void y1(boolean z10) {
        this.hasSlideOutBanner = z10;
    }
}
