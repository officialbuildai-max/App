package com.transsion.shorttv.ui.fragment.download;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.Group;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Lifecycle;
import androidx.view.b0;
import androidx.view.c0;
import as.b;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.a0;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.ad.bidding.video.BiddingVideoManager;
import com.transsion.shorttv.R$color;
import com.transsion.shorttv.R$drawable;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv.R$mipmap;
import com.transsion.shorttv.R$string;
import com.transsion.shorttv.ad.common.STCommonVideoAdHelper;
import com.transsion.shorttv.base.widget.DefaultView;
import com.transsion.shorttv.bean.Cover;
import com.transsion.shorttv.bean.DownloadItem;
import com.transsion.shorttv.bean.DownloadListBean;
import com.transsion.shorttv.bean.ShortTVFavInfo;
import com.transsion.shorttv.bean.ShortTVItem;
import com.transsion.shorttv.bean.SkuInfo;
import com.transsion.shorttv.bean.Subject;
import com.transsion.shorttv.order.b;
import com.transsion.shorttv.order.bean.CreatePaynicornOrderReqBean;
import com.transsion.shorttv.order.bean.GetPaynicornOrderStatusRespEntity;
import com.transsion.shorttv.ui.adapter.ShortTvDownloadEpListAdapter;
import com.transsion.shorttv.ui.dialog.ShortTvAlertDialog;
import com.transsion.shorttv.ui.fragment.download.ShortTVDownloadReFragment;
import com.transsion.shorttv.ui.widget.ShortTvDownloadInfoExtendView;
import com.transsion.shorttv.viewmodel.ShortTvDownloadViewModel;
import com.transsion.shorttv.viewmodel.ShortTvViewModel;
import com.transsion.web.api.WebConstants;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.y0;
import lg.a;
import ms.z;

@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 Ã\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002Ä\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\n\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0015H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\bH\u0002¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020&H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\b2\u0006\u00100\u001a\u00020\u0015H\u0002¢\u0006\u0004\b1\u0010\u0018J\u0019\u00104\u001a\u00020\b2\b\u00103\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\b2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b6\u0010/J/\u0010<\u001a\u00020\b2\u000e\u00109\u001a\n\u0012\u0004\u0012\u000208\u0018\u0001072\u0006\u0010:\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\u0015H\u0002¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u00020\b2\u0006\u0010;\u001a\u00020\u0015H\u0002¢\u0006\u0004\b>\u0010\u0018J\u000f\u0010?\u001a\u00020\bH\u0002¢\u0006\u0004\b?\u0010\u0004J\u000f\u0010@\u001a\u00020\bH\u0002¢\u0006\u0004\b@\u0010\u0004J\u000f\u0010A\u001a\u00020\bH\u0002¢\u0006\u0004\bA\u0010\u0004J\u000f\u0010B\u001a\u00020\bH\u0002¢\u0006\u0004\bB\u0010\u0004J\u000f\u0010C\u001a\u00020\u000fH\u0002¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u000fH\u0002¢\u0006\u0004\bE\u0010DJ)\u0010K\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020F2\u0006\u0010I\u001a\u00020H2\b\b\u0002\u0010J\u001a\u00020\u001bH\u0002¢\u0006\u0004\bK\u0010LJ\u0011\u0010M\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\bM\u0010DJ\u000f\u0010N\u001a\u00020\bH\u0002¢\u0006\u0004\bN\u0010\u0004J\u0017\u0010P\u001a\u00020\b2\u0006\u0010O\u001a\u00020\u001bH\u0002¢\u0006\u0004\bP\u0010\u001eJ\u0017\u0010Q\u001a\u00020\b2\u0006\u0010O\u001a\u00020\u001bH\u0002¢\u0006\u0004\bQ\u0010\u001eJ\u000f\u0010R\u001a\u00020\u001bH\u0002¢\u0006\u0004\bR\u0010SJ\u0017\u0010U\u001a\u00020\b2\u0006\u0010T\u001a\u00020\u001bH\u0002¢\u0006\u0004\bU\u0010\u001eJ\u0017\u0010V\u001a\u00020\b2\u0006\u0010T\u001a\u00020\u001bH\u0002¢\u0006\u0004\bV\u0010\u001eJ\u0017\u0010W\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\bW\u0010\"JQ\u0010_\u001a\u00020\b2\b\u0010X\u001a\u0004\u0018\u00010H2\u0006\u0010Y\u001a\u00020H2\b\u0010Z\u001a\u0004\u0018\u00010H2\b\u0010[\u001a\u0004\u0018\u00010H2\b\u0010\\\u001a\u0004\u0018\u00010H2\b\u0010]\u001a\u0004\u0018\u00010H2\u0006\u0010^\u001a\u00020HH\u0002¢\u0006\u0004\b_\u0010`J\u000f\u0010a\u001a\u00020\bH\u0002¢\u0006\u0004\ba\u0010\u0004J\u000f\u0010b\u001a\u00020\bH\u0002¢\u0006\u0004\bb\u0010\u0004J/\u0010g\u001a\u00020\b2\b\u0010c\u001a\u0004\u0018\u00010H2\n\b\u0002\u0010e\u001a\u0004\u0018\u00010d2\b\b\u0002\u0010f\u001a\u00020\u0015H\u0002¢\u0006\u0004\bg\u0010hJ\u000f\u0010i\u001a\u00020\bH\u0016¢\u0006\u0004\bi\u0010\u0004J\u0019\u0010l\u001a\u00020\b2\b\u0010k\u001a\u0004\u0018\u00010jH\u0016¢\u0006\u0004\bl\u0010mJ\u0017\u0010p\u001a\u00020\u00022\u0006\u0010o\u001a\u00020nH\u0016¢\u0006\u0004\bp\u0010qJ\u000f\u0010r\u001a\u00020HH\u0016¢\u0006\u0004\br\u0010sJ\u000f\u0010t\u001a\u00020\u001bH\u0016¢\u0006\u0004\bt\u0010SJ\u000f\u0010u\u001a\u00020\u001bH\u0016¢\u0006\u0004\bu\u0010SJ\u000f\u0010v\u001a\u00020\bH\u0016¢\u0006\u0004\bv\u0010\u0004J\u000f\u0010w\u001a\u00020\bH\u0016¢\u0006\u0004\bw\u0010\u0004J\u000f\u0010x\u001a\u00020\bH\u0016¢\u0006\u0004\bx\u0010\u0004J\u000f\u0010y\u001a\u00020\bH\u0016¢\u0006\u0004\by\u0010\u0004J\u000f\u0010z\u001a\u00020\bH\u0016¢\u0006\u0004\bz\u0010\u0004R\u001e\u0010}\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R&\u0010\u0083\u0001\u001a\u0011\u0012\r\u0012\u000b \u0080\u0001*\u0004\u0018\u00010\u007f0\u007f0~8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0017\u0010\u0086\u0001\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R!\u0010\u008c\u0001\u001a\u00030\u0087\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0019\u0010\u008f\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001c\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0018\u00100\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0085\u0001R$\u0010\u0098\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002080\u0095\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R$\u0010\u009a\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002080\u0095\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u0097\u0001R\u0019\u0010\u009c\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u0085\u0001R\u0019\u0010\u009e\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u0085\u0001R\u0019\u0010 \u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010\u0085\u0001R\u0018\u0010Y\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R\u0019\u0010¤\u0001\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¢\u0001R\u001b\u0010§\u0001\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u001a\u0010Z\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010¢\u0001R\u001a\u0010\\\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010¢\u0001R\u001b\u0010«\u0001\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010¢\u0001R\u0019\u0010\u00ad\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u008e\u0001R\u0019\u0010¯\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010\u008e\u0001R\u0019\u0010±\u0001\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010¢\u0001R\u0019\u0010´\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R\u001c\u0010·\u0001\u001a\u0005\u0018\u00010µ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010¶\u0001R\u0019\u0010¹\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010\u008e\u0001R \u0010»\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bº\u0001\u0010|R\u001a\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010½\u0001R\u0019\u0010¿\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010\u0085\u0001R\u001b\u0010Â\u0001\u001a\u00020\u00158\u0006¢\u0006\u000f\n\u0006\bÀ\u0001\u0010\u0085\u0001\u001a\u0005\bÁ\u0001\u0010$¨\u0006Å\u0001"}, d2 = {"Lcom/transsion/shorttv/ui/fragment/download/ShortTVDownloadReFragment;", "Lcom/transsion/shorttv/ui/fragment/download/ShortTvDownloadReBaseFragment;", "Lms/z;", "<init>", "()V", "Lqs/i;", "loginProvider", "Lkotlin/Function0;", "", "onSuccess", "x1", "(Lqs/i;Lkotlin/jvm/functions/Function0;)V", "J1", "initHistory", "initView", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "F1", "(Landroid/view/View;)V", "D1", "I1", "", RequestParameters.POSITION, "E1", "(I)V", "X0", "V0", "", "onlyEpisodeList", "y1", "(Z)V", "", "totalSize", "H1", "(J)V", "Y0", "()I", "U1", "Lcom/transsion/shorttv/ui/fragment/download/ShortTVDownloadReFragment$a$a;", "L1", "()Lcom/transsion/shorttv/ui/fragment/download/ShortTVDownloadReFragment$a$a;", "state", "V1", "(Lcom/transsion/shorttv/ui/fragment/download/ShortTVDownloadReFragment$a$a;)V", "Lcom/transsion/shorttv/bean/DownloadListBean;", "listBean", "T1", "(Lcom/transsion/shorttv/bean/DownloadListBean;)V", "totalEpisode", "Q0", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "C1", "(Lcom/google/android/material/tabs/TabLayout$Tab;)V", "R0", "", "Lcom/transsion/shorttv/bean/DownloadItem;", "list", "start", TtmlNode.END, "W1", "(Ljava/util/List;II)V", "W0", "showNotNetError", "S1", "showLoading", "K1", "f1", "()Landroid/view/View;", "e1", "Landroid/content/Context;", "context", "", "desText", "showRightBtn", "b1", "(Landroid/content/Context;Ljava/lang/String;Z)Landroid/view/View;", "a1", "G1", "selectAll", "M1", "O1", "w1", "()Z", "isSelected", "Q1", "P1", "A1", "pageName", "pageFrom", "subjectId", "miniId", "ops", "resourceId", "taskId", "Z0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "X1", "S0", "userId", "Lcom/transsion/shorttv/bean/Subject;", "dotSubject", "dotEp", "U0", "(Ljava/lang/String;Lcom/transsion/shorttv/bean/Subject;I)V", "initViewData", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "h1", "(Landroid/view/LayoutInflater;)Lms/z;", "getPageStateLayoutTitle", "()Ljava/lang/String;", "isAudioShowNoNetworkLayout", "isMonitorNetworkState", "initViewModel", "initListener", "retryLoadData", TmcConstants.NAVIGATION_ON_START, "onDestroy", "m", "Lkotlin/jvm/functions/Function0;", "loginSuccessCallback", "Landroidx/activity/result/b;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "n", "Landroidx/activity/result/b;", "loginLauncher", "o", "I", "padding", "Lcom/transsion/shorttv/utils/b;", TtmlNode.TAG_P, "Lkotlin/Lazy;", "g1", "()Lcom/transsion/shorttv/utils/b;", "shortTVReporter", CampaignEx.JSON_KEY_AD_Q, "Z", "isContentDataRequested", "Lcom/transsion/shorttv/ui/adapter/ShortTvDownloadEpListAdapter;", CampaignEx.JSON_KEY_AD_R, "Lcom/transsion/shorttv/ui/adapter/ShortTvDownloadEpListAdapter;", "shortTVEpAdapter", "s", "", "t", "Ljava/util/Map;", "episodeResourceMap", TmcStartParams.KEY_URL_SHORT, "inDownloadStatusMap", "v", "startPosition", "w", "endPosition", "x", "curDownloadTabPosition", "y", "Ljava/lang/String;", "z", "lastPageFrom", "A", "Lcom/transsion/shorttv/bean/Subject;", "subject", "B", "C", "D", "moduleName", "E", "scroll2Download", "F", "isSelectAll", "G", "formatSize", "H", "Lcom/transsion/shorttv/ui/fragment/download/ShortTVDownloadReFragment$a$a;", "downloadBtnState", "Lcom/transsion/shorttv/ad/common/STCommonVideoAdHelper;", "Lcom/transsion/shorttv/ad/common/STCommonVideoAdHelper;", "downloadVideoAdHelper", "J", "isRequestingData", "K", "selectAllCallback", "L", "Lcom/transsion/shorttv/bean/DownloadListBean;", "M", "prevSelectedLockedCount", "N", "getAdUnlockEpLimitForDownload", "adUnlockEpLimitForDownload", "O", "a", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public class ShortTVDownloadReFragment extends ShortTvDownloadReBaseFragment<z> {

    /* renamed from: O, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A, reason: from kotlin metadata */
    private Subject subject;

    /* renamed from: B, reason: from kotlin metadata */
    private String subjectId;

    /* renamed from: C, reason: from kotlin metadata */
    private String ops;

    /* renamed from: D, reason: from kotlin metadata */
    private String moduleName;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean scroll2Download;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isSelectAll;

    /* renamed from: G, reason: from kotlin metadata */
    private String formatSize;

    /* renamed from: H, reason: from kotlin metadata */
    private Companion.AbstractC0660a downloadBtnState;

    /* renamed from: I, reason: from kotlin metadata */
    private STCommonVideoAdHelper downloadVideoAdHelper;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isRequestingData;

    /* renamed from: K, reason: from kotlin metadata */
    private Function0 selectAllCallback;

    /* renamed from: L, reason: from kotlin metadata */
    private DownloadListBean listBean;

    /* renamed from: M, reason: from kotlin metadata */
    private int prevSelectedLockedCount;

    /* renamed from: N, reason: from kotlin metadata */
    private final int adUnlockEpLimitForDownload;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Function0 loginSuccessCallback;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final androidx.activity.result.b loginLauncher;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final int padding;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final Lazy shortTVReporter;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean isContentDataRequested;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private ShortTvDownloadEpListAdapter shortTVEpAdapter;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private int totalEpisode;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final Map episodeResourceMap;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final Map inDownloadStatusMap;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private int startPosition;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private int endPosition;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private int curDownloadTabPosition;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private String pageFrom;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private String lastPageFrom;

    /* renamed from: com.transsion.shorttv.ui.fragment.download.ShortTVDownloadReFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.transsion.shorttv.ui.fragment.download.ShortTVDownloadReFragment$a$a, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static abstract class AbstractC0660a {

            /* renamed from: com.transsion.shorttv.ui.fragment.download.ShortTVDownloadReFragment$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public static final class C0661a extends AbstractC0660a {

                /* renamed from: a, reason: collision with root package name */
                public static final C0661a f53396a = new C0661a();

                private C0661a() {
                    super(null);
                }
            }

            /* renamed from: com.transsion.shorttv.ui.fragment.download.ShortTVDownloadReFragment$a$a$b */
            /* loaded from: classes6.dex */
            public static final class b extends AbstractC0660a {

                /* renamed from: a, reason: collision with root package name */
                public static final b f53397a = new b();

                private b() {
                    super(null);
                }
            }

            /* renamed from: com.transsion.shorttv.ui.fragment.download.ShortTVDownloadReFragment$a$a$c */
            /* loaded from: classes6.dex */
            public static final class c extends AbstractC0660a {

                /* renamed from: a, reason: collision with root package name */
                public static final c f53398a = new c();

                private c() {
                    super(null);
                }
            }

            /* renamed from: com.transsion.shorttv.ui.fragment.download.ShortTVDownloadReFragment$a$a$d */
            /* loaded from: classes6.dex */
            public static final class d extends AbstractC0660a {

                /* renamed from: a, reason: collision with root package name */
                private final boolean f53399a;

                public d(boolean z10) {
                    super(null);
                    this.f53399a = z10;
                }

                public final boolean a() {
                    return this.f53399a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof d) && this.f53399a == ((d) obj).f53399a;
                }

                public int hashCode() {
                    return androidx.compose.foundation.e.a(this.f53399a);
                }

                public String toString() {
                    return "WatchAd(unlockAll=" + this.f53399a + ")";
                }
            }

            private AbstractC0660a() {
            }

            public /* synthetic */ AbstractC0660a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ShortTVDownloadReFragment a(String str, String str2, Subject subject, String str3, String str4, boolean z10) {
            ShortTVDownloadReFragment shortTVDownloadReFragment = new ShortTVDownloadReFragment();
            shortTVDownloadReFragment.setArguments(androidx.core.os.d.b(TuplesKt.a(WebConstants.PAGE_FROM, str), TuplesKt.a("last_page_from", str2), TuplesKt.a("subject", subject), TuplesKt.a("ops", str3), TuplesKt.a("module_name", str4), TuplesKt.a("download_scroll_to_download", Boolean.valueOf(z10))));
            return shortTVDownloadReFragment;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements TabLayout.OnTabSelectedListener {
        b() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            ShortTVDownloadReFragment.this.C1(tab);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements c0 {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ qs.i f53402b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Subject f53403c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f53404d;

        c(qs.i iVar, Subject subject, int i11) {
            this.f53402b = iVar;
            this.f53403c = subject;
            this.f53404d = i11;
        }

        @Override // androidx.view.c0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Unit unit) {
            b0 r11;
            Long l11;
            b0 p11;
            b0 j11;
            b0 j12;
            ShortTVDownloadReFragment.this.K1();
            ShortTvDownloadViewModel viewModel = ShortTVDownloadReFragment.this.getViewModel();
            if (viewModel != null && (j12 = viewModel.j()) != null) {
                j12.o(this);
            }
            ShortTvDownloadViewModel viewModel2 = ShortTVDownloadReFragment.this.getViewModel();
            Subject subject = null;
            if (viewModel2 != null && (j11 = viewModel2.j()) != null) {
                j11.q(null);
            }
            ShortTvDownloadViewModel viewModel3 = ShortTVDownloadReFragment.this.getViewModel();
            if (viewModel3 != null && (p11 = viewModel3.p()) != null) {
                subject = (Subject) p11.f();
            }
            if (subject == null || subject.isPaid() != 1) {
                ShortTVDownloadReFragment.this.U0(this.f53402b.getUserId(), this.f53403c, this.f53404d);
                return;
            }
            ShortTVDownloadReFragment.this.g0().R0(1);
            ShortTVDownloadReFragment.this.g0().S0();
            ShortTVDownloadReFragment.this.U1();
            ShortTVDownloadReFragment shortTVDownloadReFragment = ShortTVDownloadReFragment.this;
            ShortTvDownloadViewModel viewModel4 = shortTVDownloadReFragment.getViewModel();
            shortTVDownloadReFragment.A1((viewModel4 == null || (r11 = viewModel4.r()) == null || (l11 = (Long) r11.f()) == null) ? 0L : l11.longValue());
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements com.transsion.shorttv.order.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Subject f53406b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f53407c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f53408d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f53409e;

        d(Subject subject, int i11, Context context, String str) {
            this.f53406b = subject;
            this.f53407c = i11;
            this.f53408d = context;
            this.f53409e = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit d(ShortTVDownloadReFragment shortTVDownloadReFragment, String str, Subject subject, int i11) {
            shortTVDownloadReFragment.U0(str, subject, i11);
            return Unit.f67184a;
        }

        @Override // com.transsion.shorttv.order.b
        public void a(String errorCode, String errorMsg) {
            ShortTvAlertDialog a11;
            Intrinsics.h(errorCode, "errorCode");
            Intrinsics.h(errorMsg, "errorMsg");
            b.a.a(this, errorCode, errorMsg);
            a.C0856a c0856a = lg.a.f68962a;
            String tag = ShortTVDownloadReFragment.this.getTAG();
            Intrinsics.g(tag, "<get-TAG>(...)");
            a.C0856a.l(c0856a, tag, "callPayMethod onPayFail, errorCode=" + errorCode + ", errorMsg=" + errorMsg, false, 4, null);
            ss.b.f75981a.j(this.f53406b, this.f53407c, "fail", errorMsg, errorCode, "download");
            ShortTvAlertDialog.Companion companion = ShortTvAlertDialog.INSTANCE;
            String string = this.f53408d.getString(R$string.short_tv_pay_failed_title);
            Intrinsics.g(string, "getString(...)");
            String string2 = this.f53408d.getString(R$string.short_tv_pay_failed_message);
            Intrinsics.g(string2, "getString(...)");
            String string3 = this.f53408d.getString(R$string.short_tv_payment_retry);
            Intrinsics.g(string3, "getString(...)");
            final ShortTVDownloadReFragment shortTVDownloadReFragment = ShortTVDownloadReFragment.this;
            final String str = this.f53409e;
            final Subject subject = this.f53406b;
            final int i11 = this.f53407c;
            a11 = companion.a(string, string2, string3, (r16 & 8) != 0 ? null : new Function0() { // from class: com.transsion.shorttv.ui.fragment.download.y
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit d11;
                    d11 = ShortTVDownloadReFragment.d.d(ShortTVDownloadReFragment.this, str, subject, i11);
                    return d11;
                }
            }, (r16 & 16) != 0 ? null : this.f53408d.getString(R$string.short_tv_payment_cancel), (r16 & 32) != 0 ? null : null);
            a11.i0(this.f53408d, "ShortTvAlertDialog");
        }

        @Override // com.transsion.shorttv.order.b
        public void b(GetPaynicornOrderStatusRespEntity getPaynicornOrderStatusRespEntity) {
            String str;
            String str2;
            b0 r11;
            Long l11;
            String orderStatus;
            b.a.b(this, getPaynicornOrderStatusRespEntity);
            Integer v11 = (getPaynicornOrderStatusRespEntity == null || (orderStatus = getPaynicornOrderStatusRespEntity.getOrderStatus()) == null) ? null : StringsKt.v(orderStatus);
            if (v11 != null && v11.intValue() == 2) {
                ss.b.f75981a.j(this.f53406b, this.f53407c, NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, "", "0", "download");
                ShortTvDownloadViewModel viewModel = ShortTVDownloadReFragment.this.getViewModel();
                if (viewModel != null) {
                    viewModel.s(1);
                }
                ShortTVDownloadReFragment.this.g0().R0(1);
                ShortTVDownloadReFragment.this.g0().S0();
                ShortTVDownloadReFragment.this.U1();
                ShortTVDownloadReFragment shortTVDownloadReFragment = ShortTVDownloadReFragment.this;
                ShortTvDownloadViewModel viewModel2 = shortTVDownloadReFragment.getViewModel();
                shortTVDownloadReFragment.A1((viewModel2 == null || (r11 = viewModel2.r()) == null || (l11 = (Long) r11.f()) == null) ? 0L : l11.longValue());
                return;
            }
            if (v11 != null && v11.intValue() == 3) {
                ss.b.f75981a.j(this.f53406b, this.f53407c, "cancel", "", "0", "download");
                return;
            }
            ss.b bVar = ss.b.f75981a;
            Subject subject = this.f53406b;
            int i11 = this.f53407c;
            if (getPaynicornOrderStatusRespEntity == null || (str = getPaynicornOrderStatusRespEntity.getDescription()) == null) {
                str = "";
            }
            String str3 = str;
            if (v11 == null || (str2 = v11.toString()) == null) {
                str2 = TmcConstants.COLD_OPEN_TYPE;
            }
            bVar.j(subject, i11, "fail", str3, str2, "download");
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends RecyclerView.r {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            z zVar;
            TabLayout tabLayout;
            TabLayout.Tab tabAt;
            Intrinsics.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i11, i12);
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
            int findFirstVisibleItemPosition = ((gridLayoutManager != null ? gridLayoutManager.findFirstVisibleItemPosition() : 0) + 24) / 25;
            if (findFirstVisibleItemPosition == ShortTVDownloadReFragment.this.curDownloadTabPosition || (zVar = (z) ShortTVDownloadReFragment.this.getMViewBinding()) == null || (tabLayout = zVar.f70104u) == null || (tabAt = tabLayout.getTabAt(findFirstVisibleItemPosition)) == null) {
                return;
            }
            tabAt.select();
        }
    }

    /* loaded from: classes6.dex */
    static final class f implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f53411a;

        f(Function1 function) {
            Intrinsics.h(function, "function");
            this.f53411a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f53411a;
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
            this.f53411a.invoke(obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ShortTVDownloadReFragment() {
        /*
            r4 = this;
            r4.<init>()
            f.j r0 = new f.j
            r0.<init>()
            com.transsion.shorttv.ui.fragment.download.e r1 = new com.transsion.shorttv.ui.fragment.download.e
            r1.<init>()
            androidx.activity.result.b r0 = r4.registerForActivityResult(r0, r1)
            java.lang.String r1 = "registerForActivityResult(...)"
            kotlin.jvm.internal.Intrinsics.g(r0, r1)
            r4.loginLauncher = r0
            r0 = 1094713344(0x41400000, float:12.0)
            int r0 = com.blankj.utilcode.util.a0.a(r0)
            r4.padding = r0
            com.transsion.shorttv.ui.fragment.download.f r0 = new com.transsion.shorttv.ui.fragment.download.f
            r0.<init>()
            kotlin.Lazy r0 = kotlin.LazyKt.b(r0)
            r4.shortTVReporter = r0
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            r4.episodeResourceMap = r0
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            r4.inDownloadStatusMap = r0
            r0 = 1
            r4.startPosition = r0
            r0 = 20
            r4.endPosition = r0
            java.lang.String r0 = ""
            r4.pageFrom = r0
            r4.lastPageFrom = r0
            r4.formatSize = r0
            com.transsion.shorttv.ui.fragment.download.ShortTVDownloadReFragment$a$a$c r0 = com.transsion.shorttv.ui.fragment.download.ShortTVDownloadReFragment.Companion.AbstractC0660a.c.f53398a
            r4.downloadBtnState = r0
            ur.a r0 = ur.a.f77012a
            java.lang.String r0 = "adUnlockEpLimitForDownload"
            java.lang.String r1 = "ShortTvPlayerUnlockDownloadScene"
            r2 = 0
            kotlin.Result$Companion r3 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L62
            com.transsion.ad.scene.d r3 = com.transsion.ad.scene.d.f42258a     // Catch: java.lang.Throwable -> L62
            com.google.gson.JsonObject r1 = r3.b(r1)     // Catch: java.lang.Throwable -> L62
            if (r1 == 0) goto L64
            com.google.gson.JsonElement r0 = r1.get(r0)     // Catch: java.lang.Throwable -> L62
            goto L65
        L62:
            r0 = move-exception
            goto Lc4
        L64:
            r0 = r2
        L65:
            java.lang.Class<java.lang.Integer> r1 = java.lang.Integer.class
            kotlin.reflect.KClass r1 = kotlin.jvm.internal.Reflection.b(r1)     // Catch: java.lang.Throwable -> L62
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.b(r3)     // Catch: java.lang.Throwable -> L62
            boolean r3 = kotlin.jvm.internal.Intrinsics.c(r1, r3)     // Catch: java.lang.Throwable -> L62
            if (r3 == 0) goto L7e
            if (r0 == 0) goto L7c
            r0.getAsString()     // Catch: java.lang.Throwable -> L62
        L7c:
            r0 = r2
            goto Lbf
        L7e:
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> L62
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.b(r3)     // Catch: java.lang.Throwable -> L62
            boolean r3 = kotlin.jvm.internal.Intrinsics.c(r1, r3)     // Catch: java.lang.Throwable -> L62
            if (r3 == 0) goto L9b
            if (r0 == 0) goto L95
            int r0 = r0.getAsInt()     // Catch: java.lang.Throwable -> L62
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L62
            goto L96
        L95:
            r0 = r2
        L96:
            boolean r1 = r0 instanceof java.lang.Integer     // Catch: java.lang.Throwable -> L62
            if (r1 != 0) goto Lbf
            goto L7c
        L9b:
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch: java.lang.Throwable -> L62
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.b(r3)     // Catch: java.lang.Throwable -> L62
            boolean r3 = kotlin.jvm.internal.Intrinsics.c(r1, r3)     // Catch: java.lang.Throwable -> L62
            if (r3 == 0) goto Lad
            if (r0 == 0) goto L7c
            r0.getAsLong()     // Catch: java.lang.Throwable -> L62
            goto L7c
        Lad:
            java.lang.Class r3 = java.lang.Boolean.TYPE     // Catch: java.lang.Throwable -> L62
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.b(r3)     // Catch: java.lang.Throwable -> L62
            boolean r1 = kotlin.jvm.internal.Intrinsics.c(r1, r3)     // Catch: java.lang.Throwable -> L62
            if (r1 == 0) goto L7c
            if (r0 == 0) goto L7c
            r0.getAsBoolean()     // Catch: java.lang.Throwable -> L62
            goto L7c
        Lbf:
            java.lang.Object r0 = kotlin.Result.m1185constructorimpl(r0)     // Catch: java.lang.Throwable -> L62
            goto Lce
        Lc4:
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.ResultKt.a(r0)
            java.lang.Object r0 = kotlin.Result.m1185constructorimpl(r0)
        Lce:
            java.lang.Throwable r1 = kotlin.Result.m1188exceptionOrNullimpl(r0)
            if (r1 != 0) goto Ld5
            r2 = r0
        Ld5:
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 == 0) goto Lde
            int r0 = r2.intValue()
            goto Le0
        Lde:
            r0 = 10
        Le0:
            r4.adUnlockEpLimitForDownload = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.ui.fragment.download.ShortTVDownloadReFragment.<init>():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A1(long totalSize) {
        final ArrayList arrayList;
        ProgressBar progressBar;
        BLFrameLayout bLFrameLayout;
        ProgressBar progressBar2;
        AppCompatTextView appCompatTextView;
        AppCompatImageView appCompatImageView;
        View view;
        b0 q11;
        Map map;
        DownloadItem downloadItem;
        b0 p11;
        b0 p12;
        Companion.AbstractC0660a abstractC0660a = this.downloadBtnState;
        Subject subject = null;
        if (abstractC0660a instanceof Companion.AbstractC0660a.d) {
            ShortTvDownloadViewModel viewModel = getViewModel();
            if (viewModel != null && (p12 = viewModel.p()) != null) {
                subject = (Subject) p12.f();
            }
            Integer num = (Integer) g0().j0().f();
            ss.b.f75981a.d(subject, num != null ? num.intValue() : 0, "minitv_ad");
            X1();
            return;
        }
        if (abstractC0660a instanceof Companion.AbstractC0660a.C0661a) {
            ShortTvDownloadViewModel viewModel2 = getViewModel();
            if (viewModel2 != null && (p11 = viewModel2.p()) != null) {
                subject = (Subject) p11.f();
            }
            Integer num2 = (Integer) g0().j0().f();
            ss.b.f75981a.d(subject, num2 != null ? num2.intValue() : 0, "minitv_pay");
            S0();
            return;
        }
        if (abstractC0660a instanceof Companion.AbstractC0660a.b) {
            fs.b.f62582a.e(getString(R$string.short_tv_no_unlock_method_available));
            return;
        }
        if (!(abstractC0660a instanceof Companion.AbstractC0660a.c)) {
            throw new NoWhenBranchMatchedException();
        }
        qs.d s02 = g0().s0();
        if (s02 == null || !s02.e(totalSize)) {
            ArrayList arrayList2 = new ArrayList();
            ShortTvDownloadViewModel viewModel3 = getViewModel();
            if (viewModel3 != null && (q11 = viewModel3.q()) != null && (map = (Map) q11.f()) != null) {
                for (Map.Entry entry : map.entrySet()) {
                    if (this.episodeResourceMap.containsKey(entry.getKey()) && (downloadItem = (DownloadItem) this.episodeResourceMap.get(entry.getKey())) != null) {
                        arrayList2.add(downloadItem);
                    }
                }
            }
            a.C0856a c0856a = lg.a.f68962a;
            String tag = getTAG();
            Intrinsics.g(tag, "<get-TAG>(...)");
            a.C0856a.f(c0856a, tag, "onDownload ", false, 4, null);
            z zVar = (z) getMViewBinding();
            if (zVar != null && (view = zVar.G) != null) {
                yr.b.e(view);
            }
            z zVar2 = (z) getMViewBinding();
            if (zVar2 != null && (appCompatImageView = zVar2.f70094k) != null) {
                yr.b.b(appCompatImageView);
            }
            z zVar3 = (z) getMViewBinding();
            if (zVar3 != null && (appCompatTextView = zVar3.f70106w) != null) {
                yr.b.b(appCompatTextView);
            }
            z zVar4 = (z) getMViewBinding();
            if (zVar4 != null && (progressBar2 = zVar4.f70100q) != null) {
                yr.b.e(progressBar2);
            }
            z zVar5 = (z) getMViewBinding();
            if (zVar5 != null && (bLFrameLayout = zVar5.f70090g) != null) {
                yr.b.e(bLFrameLayout);
            }
            DownloadItem downloadItem2 = null;
            for (Object obj : arrayList2) {
                int i11 = r2 + 1;
                if (r2 < 0) {
                    CollectionsKt.u();
                }
                DownloadItem downloadItem3 = (DownloadItem) obj;
                String uuid = UUID.randomUUID().toString();
                Intrinsics.g(uuid, "toString(...)");
                downloadItem3.setTaskId(uuid);
                DownloadItem downloadItem4 = (downloadItem2 == null || downloadItem3.getEp() < downloadItem2.getEp()) ? downloadItem3 : downloadItem2;
                Z0(this.pageFrom, this.lastPageFrom, this.subjectId, downloadItem3.getResourceId(), this.ops, downloadItem3.getResourceId(), uuid);
                lg.a.f68962a.p("Download", new String[]{"剧集多资源，下载点击，开始下载: subjectId = " + this.subjectId + ",resourceId = " + downloadItem3.getResourceId()}, true);
                r2 = i11;
                downloadItem2 = downloadItem4;
            }
            qs.d s03 = g0().s0();
            if (s03 != null) {
                arrayList = arrayList2;
                s03.h(this.listBean, this.subject, this.ops, this.pageFrom, this.lastPageFrom, arrayList);
            } else {
                arrayList = arrayList2;
            }
            ShortTvDownloadViewModel viewModel4 = getViewModel();
            if (viewModel4 != null) {
                viewModel4.w(this.subjectId, arrayList);
            }
            kotlinx.coroutines.k.d(androidx.view.v.a(this), null, null, new ShortTVDownloadReFragment$onDownload$3(this, null), 3, null);
            long size = ((arrayList.size() / 20) * 100) + 300;
            z zVar6 = (z) getMViewBinding();
            if (zVar6 == null || (progressBar = zVar6.f70100q) == null) {
                return;
            }
            progressBar.postDelayed(new Runnable() { // from class: com.transsion.shorttv.ui.fragment.download.h
                @Override // java.lang.Runnable
                public final void run() {
                    ShortTVDownloadReFragment.B1(ShortTVDownloadReFragment.this, arrayList);
                }
            }, size);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(ShortTVDownloadReFragment shortTVDownloadReFragment, List list) {
        FragmentActivity activity = shortTVDownloadReFragment.getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || list.isEmpty()) {
            return;
        }
        qs.d s02 = shortTVDownloadReFragment.g0().s0();
        if (s02 != null) {
            s02.i(activity, (DownloadItem) CollectionsKt.i0(list), list.size(), shortTVDownloadReFragment.formatSize);
        }
        shortTVDownloadReFragment.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C1(TabLayout.Tab tab) {
        RecyclerView recyclerView;
        if (tab == null || !tab.isSelected()) {
            return;
        }
        this.curDownloadTabPosition = tab.getPosition();
        int position = tab.getPosition() * 25;
        z zVar = (z) getMViewBinding();
        Object layoutManager = (zVar == null || (recyclerView = zVar.f70102s) == null) ? null : recyclerView.getLayoutManager();
        GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
        if (gridLayoutManager != null) {
            gridLayoutManager.scrollToPositionWithOffset(position, 0);
        }
    }

    private final void D1(View view) {
        ShortTVFavInfo shortTVFavInfo;
        if (ds.d.f61551a.a(view.getId(), 500L)) {
            return;
        }
        if (!nh.m.f70597a.e()) {
            fs.b.f62582a.d(R$string.short_tv_no_network_toast);
            return;
        }
        com.transsion.shorttv.utils.b g12 = g1();
        String str = this.subjectId;
        Subject subject = this.subject;
        g12.c(str, "", (subject == null || (shortTVFavInfo = subject.getShortTVFavInfo()) == null) ? false : shortTVFavInfo.getHasFavorite(), "minitv_download");
        ShortTvDownloadViewModel viewModel = getViewModel();
        if (viewModel != null) {
            viewModel.g(this.subject);
        }
    }

    private final void E1(int position) {
        b0 r11;
        b0 r12;
        b0 r13;
        Long l11;
        Long size;
        ShortTvDownloadEpListAdapter shortTvDownloadEpListAdapter = this.shortTVEpAdapter;
        Intrinsics.e(shortTvDownloadEpListAdapter);
        List data = shortTvDownloadEpListAdapter.getData();
        if (position >= data.size()) {
            return;
        }
        js.d dVar = (js.d) data.get(position);
        if (dVar.c()) {
            return;
        }
        ShortTvDownloadViewModel viewModel = getViewModel();
        if (viewModel != null) {
            viewModel.v(dVar);
        }
        DownloadItem downloadItem = (DownloadItem) this.episodeResourceMap.get(Integer.valueOf(position));
        long j11 = 0;
        long longValue = (downloadItem == null || (size = downloadItem.getSize()) == null) ? 0L : size.longValue();
        ShortTvDownloadViewModel viewModel2 = getViewModel();
        if (viewModel2 != null && (r13 = viewModel2.r()) != null && (l11 = (Long) r13.f()) != null) {
            j11 = l11.longValue();
        }
        if (dVar.d()) {
            dVar.g(false);
            ShortTvDownloadViewModel viewModel3 = getViewModel();
            if (viewModel3 != null && (r12 = viewModel3.r()) != null) {
                r12.q(Long.valueOf(j11 - longValue));
            }
        } else {
            dVar.g(true);
            ShortTvDownloadViewModel viewModel4 = getViewModel();
            if (viewModel4 != null && (r11 = viewModel4.r()) != null) {
                r11.q(Long.valueOf(j11 + longValue));
            }
        }
        ShortTvDownloadEpListAdapter shortTvDownloadEpListAdapter2 = this.shortTVEpAdapter;
        if (shortTvDownloadEpListAdapter2 != null) {
            shortTvDownloadEpListAdapter2.notifyItemChanged(position, dVar);
        }
    }

    private final void F1(View view) {
        if (ds.d.f61551a.a(view.getId(), 500L)) {
            return;
        }
        Navigator c11 = TheRouter.c(ls.a.f69157a.b());
        Subject subject = this.subject;
        Navigator.x(c11.K("id", subject != null ? subject.getSubjectId() : null), getContext(), null, 2, null);
        f0();
    }

    private final void G1() {
        AppCompatImageView appCompatImageView;
        if (ds.d.f61551a.a(-912345, 1000L)) {
            return;
        }
        if (!w1()) {
            fs.b.f62582a.d(R$string.short_tv_download_no_options_toast);
            return;
        }
        z zVar = (z) getMViewBinding();
        if (zVar == null || (appCompatImageView = zVar.f70095l) == null) {
            return;
        }
        boolean z10 = !appCompatImageView.isSelected();
        this.isSelectAll = z10;
        M1(z10);
    }

    private final void H1(long totalSize) {
        String str;
        if (totalSize > 0) {
            a.C0856a c0856a = lg.a.f68962a;
            String tag = getTAG();
            Intrinsics.g(tag, "<get-TAG>(...)");
            a.C0856a.v(c0856a, tag, "observe totalSize:" + totalSize, false, 4, null);
            str = com.blankj.utilcode.util.i.b(totalSize, 1);
            Intrinsics.e(str);
        } else {
            str = "";
        }
        this.formatSize = str;
        U1();
    }

    private final void I1(View view) {
        if (ds.d.f61551a.a(view.getId(), 500L)) {
            return;
        }
        com.transsion.shorttv.utils.b.e(g1(), this.subjectId, null, 2, null);
        qs.k C0 = g0().C0();
        if (C0 != null) {
            String str = this.subjectId;
            Subject subject = this.subject;
            C0.a(this, str, subject != null ? subject.getTitle() : null, this.pageFrom);
        }
    }

    private final void J1() {
        BiddingVideoManager.Companion.b(BiddingVideoManager.f42103w, "ShortTvPlayerUnlockDownloadScene", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K1() {
        FrameLayout frameLayout;
        z zVar = (z) getMViewBinding();
        if (zVar == null || (frameLayout = zVar.f70092i) == null) {
            return;
        }
        frameLayout.removeAllViews();
        frameLayout.setVisibility(8);
    }

    private final Companion.AbstractC0660a L1() {
        b0 p11;
        ShortTvDownloadViewModel viewModel = getViewModel();
        Subject subject = (viewModel == null || (p11 = viewModel.p()) == null) ? null : (Subject) p11.f();
        int Y0 = Y0();
        if (Y0 == 0) {
            return Companion.AbstractC0660a.c.f53398a;
        }
        List unlockType = subject != null ? subject.getUnlockType() : null;
        boolean z10 = unlockType != null && unlockType.contains(1);
        boolean z11 = unlockType != null && unlockType.contains(2);
        return (subject == null || subject.getMiniTvType() != 2) ? (z10 || z11) ? Y0 <= this.adUnlockEpLimitForDownload ? z11 ? new Companion.AbstractC0660a.d(false) : z10 ? Companion.AbstractC0660a.C0661a.f53396a : Companion.AbstractC0660a.b.f53397a : z10 ? Companion.AbstractC0660a.C0661a.f53396a : z11 ? new Companion.AbstractC0660a.d(false) : Companion.AbstractC0660a.b.f53397a : Companion.AbstractC0660a.b.f53397a : (z10 || z11) ? z10 ? Companion.AbstractC0660a.C0661a.f53396a : new Companion.AbstractC0660a.d(true) : Companion.AbstractC0660a.b.f53397a;
    }

    private final void M1(final boolean selectAll) {
        FrameLayout frameLayout;
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag, "selectAll click, selectAll = " + selectAll + " ", false, 4, null);
        this.isSelectAll = selectAll;
        if (!this.isRequestingData) {
            O1(selectAll);
            return;
        }
        z zVar = (z) getMViewBinding();
        if (zVar != null && (frameLayout = zVar.f70091h) != null) {
            yr.b.e(frameLayout);
        }
        this.selectAllCallback = new Function0() { // from class: com.transsion.shorttv.ui.fragment.download.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit N1;
                N1 = ShortTVDownloadReFragment.N1(ShortTVDownloadReFragment.this, selectAll);
                return N1;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N1(ShortTVDownloadReFragment shortTVDownloadReFragment, boolean z10) {
        shortTVDownloadReFragment.O1(z10);
        shortTVDownloadReFragment.selectAllCallback = null;
        return Unit.f67184a;
    }

    private final void O1(boolean selectAll) {
        List data;
        ShortTvDownloadEpListAdapter shortTvDownloadEpListAdapter = this.shortTVEpAdapter;
        if (((shortTvDownloadEpListAdapter == null || (data = shortTvDownloadEpListAdapter.getData()) == null) ? 0 : data.size()) > 30) {
            Q1(selectAll);
        } else {
            P1(selectAll);
        }
    }

    private final void P1(boolean isSelected) {
        b0 r11;
        b0 q11;
        List data;
        js.d dVar;
        Long size;
        List data2;
        b0 q12;
        ShortTvDownloadViewModel viewModel = getViewModel();
        Map map = (viewModel == null || (q12 = viewModel.q()) == null) ? null : (Map) q12.f();
        if (map == null) {
            map = new LinkedHashMap();
        }
        map.clear();
        ShortTvDownloadEpListAdapter shortTvDownloadEpListAdapter = this.shortTVEpAdapter;
        int size2 = (shortTvDownloadEpListAdapter == null || (data2 = shortTvDownloadEpListAdapter.getData()) == null) ? 0 : data2.size();
        long j11 = 0;
        for (int i11 = 0; i11 < size2; i11++) {
            ShortTvDownloadEpListAdapter shortTvDownloadEpListAdapter2 = this.shortTVEpAdapter;
            if (shortTvDownloadEpListAdapter2 != null && (data = shortTvDownloadEpListAdapter2.getData()) != null && (dVar = (js.d) CollectionsKt.l0(data, i11)) != null && !dVar.c()) {
                dVar.g(isSelected);
                if (isSelected) {
                    DownloadItem downloadItem = (DownloadItem) this.episodeResourceMap.get(Integer.valueOf(i11));
                    j11 += (downloadItem == null || (size = downloadItem.getSize()) == null) ? 0L : size.longValue();
                    map.put(Integer.valueOf(i11), dVar);
                } else {
                    map.remove(Integer.valueOf(i11));
                }
            }
        }
        ShortTvDownloadViewModel viewModel2 = getViewModel();
        if (viewModel2 != null && (q11 = viewModel2.q()) != null) {
            q11.q(map);
        }
        ShortTvDownloadViewModel viewModel3 = getViewModel();
        if (viewModel3 != null && (r11 = viewModel3.r()) != null) {
            r11.q(Long.valueOf(j11));
        }
        ShortTvDownloadEpListAdapter shortTvDownloadEpListAdapter3 = this.shortTVEpAdapter;
        if (shortTvDownloadEpListAdapter3 != null) {
            shortTvDownloadEpListAdapter3.notifyItemRangeChanged(0, size2);
        }
    }

    private final void Q0(int totalEpisode) {
        TabLayout tabLayout;
        TabLayout tabLayout2;
        TabLayout tabLayout3;
        int i11 = (totalEpisode + 24) / 25;
        if (i11 <= 1) {
            z zVar = (z) getMViewBinding();
            if (zVar == null || (tabLayout3 = zVar.f70104u) == null) {
                return;
            }
            yr.b.b(tabLayout3);
            return;
        }
        z zVar2 = (z) getMViewBinding();
        if (zVar2 != null && (tabLayout2 = zVar2.f70104u) != null) {
            tabLayout2.removeAllTabs();
            tabLayout2.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new b());
        }
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = i12 * 25;
            int i14 = i13 + 1;
            int i15 = RangesKt.i(i13 + 25, totalEpisode);
            z zVar3 = (z) getMViewBinding();
            if (zVar3 != null && (tabLayout = zVar3.f70104u) != null) {
                tabLayout.addTab(tabLayout.newTab().setText(i14 + "-" + i15));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.LinkedHashMap, T] */
    private final void Q1(boolean isSelected) {
        b0 q11;
        FrameLayout frameLayout;
        z zVar = (z) getMViewBinding();
        if (zVar != null && (frameLayout = zVar.f70091h) != null) {
            yr.b.e(frameLayout);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ShortTvDownloadViewModel viewModel = getViewModel();
        T t11 = (viewModel == null || (q11 = viewModel.q()) == null) ? 0 : (Map) q11.f();
        objectRef.element = t11;
        if (t11 == 0) {
            objectRef.element = new LinkedHashMap();
        }
        ((Map) objectRef.element).clear();
        kotlinx.coroutines.k.d(androidx.view.v.a(this), null, null, new ShortTVDownloadReFragment$selectAllWithSizeMoreThan30$1(this, isSelected, objectRef, null), 3, null);
    }

    private final void R0(DownloadListBean listBean) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        List<String> tags = listBean.getTags();
        if (tags == null || tags.isEmpty()) {
            z zVar = (z) getMViewBinding();
            if (zVar == null || (recyclerView = zVar.f70103t) == null) {
                return;
            }
            yr.b.b(recyclerView);
            return;
        }
        List<String> tags2 = listBean.getTags();
        Intrinsics.e(tags2);
        com.transsion.shorttv.ui.adapter.s sVar = new com.transsion.shorttv.ui.adapter.s(tags2);
        z zVar2 = (z) getMViewBinding();
        if (zVar2 == null || (recyclerView2 = zVar2.f70103t) == null) {
            return;
        }
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(recyclerView2.getContext());
        flexboxLayoutManager.c0(0);
        flexboxLayoutManager.d0(1);
        flexboxLayoutManager.e0(0);
        recyclerView2.setLayoutManager(flexboxLayoutManager);
        com.google.android.flexbox.d dVar = new com.google.android.flexbox.d(recyclerView2.getContext());
        dVar.l(3);
        dVar.i(androidx.core.content.b.getDrawable(Utils.a(), R$drawable.short_tv_space_tag_decoration));
        recyclerView2.addItemDecoration(dVar);
        recyclerView2.setAdapter(sVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.shorttv.utils.b R1() {
        return new com.transsion.shorttv.utils.b();
    }

    private final void S0() {
        b0 p11;
        final qs.i B0 = g0().B0();
        if (B0 == null) {
            return;
        }
        ShortTvDownloadViewModel viewModel = getViewModel();
        final Subject subject = (viewModel == null || (p11 = viewModel.p()) == null) ? null : (Subject) p11.f();
        Integer num = (Integer) g0().j0().f();
        final int intValue = num != null ? num.intValue() : 0;
        if (B0.a()) {
            U0(B0.getUserId(), subject, intValue);
        } else {
            x1(B0, new Function0() { // from class: com.transsion.shorttv.ui.fragment.download.m
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit T0;
                    T0 = ShortTVDownloadReFragment.T0(ShortTVDownloadReFragment.this, B0, subject, intValue);
                    return T0;
                }
            });
        }
    }

    private final void S1() {
        FrameLayout frameLayout;
        z zVar = (z) getMViewBinding();
        if (zVar == null || (frameLayout = zVar.f70092i) == null) {
            return;
        }
        frameLayout.removeAllViews();
        frameLayout.setVisibility(0);
        frameLayout.addView(e1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(ShortTVDownloadReFragment shortTVDownloadReFragment, qs.i iVar, Subject subject, int i11) {
        b0 j11;
        shortTVDownloadReFragment.isContentDataRequested = false;
        ShortTvViewModel g02 = shortTVDownloadReFragment.g0();
        String str = shortTVDownloadReFragment.subjectId;
        if (str == null) {
            str = "";
        }
        g02.M(str);
        shortTVDownloadReFragment.startPosition = 1;
        shortTVDownloadReFragment.endPosition = 20;
        c cVar = new c(iVar, subject, i11);
        ShortTvDownloadViewModel viewModel = shortTVDownloadReFragment.getViewModel();
        if (viewModel != null && (j11 = viewModel.j()) != null) {
            j11.j(shortTVDownloadReFragment.getViewLifecycleOwner(), cVar);
        }
        shortTVDownloadReFragment.showLoading();
        ShortTvDownloadViewModel viewModel2 = shortTVDownloadReFragment.getViewModel();
        if (viewModel2 != null) {
            String str2 = shortTVDownloadReFragment.subjectId;
            if (str2 == null) {
                str2 = "";
            }
            viewModel2.n(str2, true);
        }
        ShortTvDownloadViewModel viewModel3 = shortTVDownloadReFragment.getViewModel();
        if (viewModel3 != null) {
            String str3 = shortTVDownloadReFragment.subjectId;
            viewModel3.i(str3 != null ? str3 : "", shortTVDownloadReFragment.startPosition, shortTVDownloadReFragment.endPosition);
        }
        return Unit.f67184a;
    }

    private final void T1(DownloadListBean listBean) {
        List data;
        String subjectId;
        ShortTvDownloadInfoExtendView shortTvDownloadInfoExtendView;
        BLImageView bLImageView;
        AppCompatTextView appCompatTextView;
        ShapeableImageView shapeableImageView;
        String thumbnail;
        String url;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        this.listBean = listBean;
        if (this.isContentDataRequested) {
            return;
        }
        Integer totalEpisode = listBean.getTotalEpisode();
        if (totalEpisode != null && totalEpisode.intValue() == 0) {
            return;
        }
        this.isContentDataRequested = true;
        z zVar = (z) getMViewBinding();
        if (zVar != null && (appCompatTextView3 = zVar.E) != null) {
            appCompatTextView3.setText(listBean.getSubjectTitle());
        }
        z zVar2 = (z) getMViewBinding();
        if (zVar2 != null && (appCompatTextView2 = zVar2.D) != null) {
            appCompatTextView2.setText(listBean.getSubjectTitle());
        }
        z zVar3 = (z) getMViewBinding();
        if (zVar3 != null && (shapeableImageView = zVar3.f70097n) != null) {
            b.a aVar = as.b.f16186a;
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            Cover cover = listBean.getCover();
            String str = (cover == null || (url = cover.getUrl()) == null) ? "" : url;
            int i11 = R$color.short_tv_module_04;
            int width = shapeableImageView.getWidth();
            int height = shapeableImageView.getHeight();
            Cover cover2 = listBean.getCover();
            aVar.i(requireContext, shapeableImageView, str, (r34 & 8) != 0 ? R$color.image_skeleton : i11, (r34 & 16) != 0 ? aVar.c() : width, (r34 & 32) != 0 ? aVar.b() : height, (r34 & 64) != 0 ? 0 : 0, (r34 & 128) != 0, (r34 & 256) != 0 ? "" : (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) ? "" : thumbnail, (r34 & 512) != 0, (r34 & 1024) != 0, (r34 & 2048) != 0 ? false : false, (r34 & 4096) != 0 ? false : false, (r34 & 8192) != 0 ? false : false, (r34 & 16384) != 0 ? 25 : 0);
        }
        R0(listBean);
        String genre = listBean.getGenre();
        if (genre != null && genre.length() != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            String releaseDate = listBean.getReleaseDate();
            if (releaseDate != null && releaseDate.length() > 0) {
                Date l11 = com.blankj.utilcode.util.c0.l(listBean.getReleaseDate(), "yyyy-MM-dd");
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(l11);
                stringBuffer.append(String.valueOf(calendar.get(1)));
            }
            String genre2 = listBean.getGenre();
            if (genre2 != null && genre2.length() > 0) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(" • ");
                }
                String genre3 = listBean.getGenre();
                stringBuffer.append(genre3 != null ? StringsKt.Q(genre3, "，", " • ", false, 4, null) : null);
            }
            String countryName = listBean.getCountryName();
            if (countryName != null && countryName.length() > 0) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(" • ");
                }
                stringBuffer.append(listBean.getCountryName());
            }
            z zVar4 = (z) getMViewBinding();
            if (zVar4 != null && (appCompatTextView = zVar4.f70109z) != null) {
                appCompatTextView.setText(stringBuffer);
            }
        }
        z zVar5 = (z) getMViewBinding();
        if (zVar5 != null && (bLImageView = zVar5.f70098o) != null) {
            ShortTVFavInfo shortTVFavInfo = listBean.getShortTVFavInfo();
            bLImageView.setSelected(shortTVFavInfo != null ? shortTVFavInfo.getHasFavorite() : false);
        }
        z zVar6 = (z) getMViewBinding();
        if (zVar6 != null && (shortTvDownloadInfoExtendView = zVar6.f70093j) != null) {
            String description = listBean.getDescription();
            if (description == null) {
                description = "";
            }
            shortTvDownloadInfoExtendView.showData(description);
        }
        Subject subject = this.subject;
        int totalEpisode2 = subject != null ? subject.getTotalEpisode() : 0;
        Integer totalEpisode3 = listBean.getTotalEpisode();
        int max = Math.max(totalEpisode2, totalEpisode3 != null ? totalEpisode3.intValue() : 0);
        this.totalEpisode = max;
        if (max > 0) {
            Q0(max);
            int i12 = this.totalEpisode;
            for (int i13 = 0; i13 < i12; i13++) {
                ShortTvDownloadEpListAdapter shortTvDownloadEpListAdapter = this.shortTVEpAdapter;
                if (shortTvDownloadEpListAdapter != null && (data = shortTvDownloadEpListAdapter.getData()) != null) {
                    Subject subject2 = this.subject;
                    data.add(new js.d((subject2 == null || (subjectId = subject2.getSubjectId()) == null) ? "" : subjectId, i13, false, this.inDownloadStatusMap.containsKey(Integer.valueOf(i13)), null, 20, null));
                }
            }
            ShortTvDownloadEpListAdapter shortTvDownloadEpListAdapter2 = this.shortTVEpAdapter;
            if (shortTvDownloadEpListAdapter2 != null) {
                shortTvDownloadEpListAdapter2.notifyItemRangeChanged(0, this.totalEpisode);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U0(String userId, Subject dotSubject, int dotEp) {
        b0 p11;
        Subject subject;
        Context context;
        if (!nh.m.f70597a.e()) {
            fs.b.f62582a.e(Utils.a().getString(R$string.short_tv_no_network_toast));
            return;
        }
        if (userId != null) {
            String str = userId.length() > 0 ? userId : null;
            if (str != null) {
                ShortTvDownloadViewModel viewModel = getViewModel();
                if (viewModel == null || (p11 = viewModel.p()) == null || (subject = (Subject) p11.f()) == null) {
                    return;
                }
                SkuInfo skuInfo = subject.getSkuInfo();
                if (skuInfo == null) {
                    a.C0856a c0856a = lg.a.f68962a;
                    String tag = getTAG();
                    Intrinsics.g(tag, "<get-TAG>(...)");
                    a.C0856a.l(c0856a, tag, "callPayMethod failed, no sku info.", false, 4, null);
                    return;
                }
                String skuId = skuInfo.getSkuId();
                if (skuId != null) {
                    String str2 = skuId.length() > 0 ? skuId : null;
                    if (str2 != null) {
                        String subjectId = subject.getSubjectId();
                        if (subjectId != null) {
                            String str3 = subjectId.length() > 0 ? subjectId : null;
                            if (str3 == null || (context = getContext()) == null) {
                                return;
                            }
                            com.transsion.shorttv.order.d.f53100a.d(context, new CreatePaynicornOrderReqBean("MovieBox", str2, str, null, null, null, MapsKt.f(TuplesKt.a("subject_id", str3)), false, null, Sdk$SDKError.Reason.DEEPLINK_OPEN_FAILED_VALUE, null), new d(dotSubject, dotEp, context, str));
                            return;
                        }
                        return;
                    }
                }
                a.C0856a c0856a2 = lg.a.f68962a;
                String tag2 = getTAG();
                Intrinsics.g(tag2, "<get-TAG>(...)");
                a.C0856a.l(c0856a2, tag2, "callPayMethod failed, skuId is empty.", false, 4, null);
                return;
            }
        }
        a.C0856a c0856a3 = lg.a.f68962a;
        String tag3 = getTAG();
        Intrinsics.g(tag3, "<get-TAG>(...)");
        a.C0856a.l(c0856a3, tag3, "callPayMethod failed, userId is empty.", false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1() {
        Companion.AbstractC0660a L1 = L1();
        this.downloadBtnState = L1;
        V1(L1);
    }

    private final void V0() {
        b0 p11;
        Subject subject;
        ShortTvDownloadViewModel viewModel = getViewModel();
        if (viewModel == null || (p11 = viewModel.p()) == null || (subject = (Subject) p11.f()) == null) {
            return;
        }
        if (!subject.getUnlockType().contains(1)) {
            this.prevSelectedLockedCount = Y0();
            return;
        }
        int Y0 = Y0();
        if (Y0 > this.adUnlockEpLimitForDownload && Y0 > this.prevSelectedLockedCount) {
            fs.b.f62582a.e(getString(R$string.short_tv_download_ad_unlock_limit_reached));
        }
        this.prevSelectedLockedCount = Y0;
    }

    private final void V1(Companion.AbstractC0660a state) {
        LinearLayoutCompat linearLayoutCompat;
        AppCompatTextView appCompatTextView;
        AppCompatImageView appCompatImageView;
        AppCompatTextView appCompatTextView2;
        AppCompatImageView appCompatImageView2;
        AppCompatTextView appCompatTextView3;
        AppCompatImageView appCompatImageView3;
        String string;
        AppCompatTextView appCompatTextView4;
        AppCompatImageView appCompatImageView4;
        z zVar = (z) getMViewBinding();
        if (zVar == null || (linearLayoutCompat = zVar.f70087d) == null) {
            return;
        }
        if (state instanceof Companion.AbstractC0660a.c) {
            linearLayoutCompat.setBackgroundResource(R$drawable.short_tv_btn_normal);
            z zVar2 = (z) getMViewBinding();
            if (zVar2 != null && (appCompatImageView4 = zVar2.f70094k) != null) {
                appCompatImageView4.setVisibility(8);
            }
            if (this.formatSize.length() > 0) {
                string = getString(R$string.short_tv_download) + " · " + this.formatSize;
            } else {
                string = getString(R$string.short_tv_download);
                Intrinsics.e(string);
            }
            z zVar3 = (z) getMViewBinding();
            if (zVar3 == null || (appCompatTextView4 = zVar3.f70106w) == null) {
                return;
            }
            appCompatTextView4.setText(string);
            return;
        }
        if (state instanceof Companion.AbstractC0660a.b) {
            linearLayoutCompat.setBackgroundResource(R$drawable.short_tv_locked_btn_buy_bg);
            z zVar4 = (z) getMViewBinding();
            if (zVar4 != null && (appCompatImageView3 = zVar4.f70094k) != null) {
                appCompatImageView3.setVisibility(8);
            }
            z zVar5 = (z) getMViewBinding();
            if (zVar5 == null || (appCompatTextView3 = zVar5.f70106w) == null) {
                return;
            }
            appCompatTextView3.setText(getString(R$string.short_tv_download));
            return;
        }
        if (state instanceof Companion.AbstractC0660a.d) {
            linearLayoutCompat.setBackgroundResource(R$drawable.short_tv_locked_btn_buy_bg);
            z zVar6 = (z) getMViewBinding();
            if (zVar6 != null && (appCompatImageView2 = zVar6.f70094k) != null) {
                appCompatImageView2.setImageResource(R$mipmap.short_tv_ic_lock_watch_ad);
                appCompatImageView2.setVisibility(0);
            }
            z zVar7 = (z) getMViewBinding();
            if (zVar7 == null || (appCompatTextView2 = zVar7.f70106w) == null) {
                return;
            }
            appCompatTextView2.setText(getString(R$string.short_tv_download_watch_ad_to_download));
            return;
        }
        if (!(state instanceof Companion.AbstractC0660a.C0661a)) {
            throw new NoWhenBranchMatchedException();
        }
        linearLayoutCompat.setBackgroundResource(R$drawable.short_tv_locked_btn_buy_bg);
        z zVar8 = (z) getMViewBinding();
        if (zVar8 != null && (appCompatImageView = zVar8.f70094k) != null) {
            appCompatImageView.setVisibility(8);
        }
        z zVar9 = (z) getMViewBinding();
        if (zVar9 == null || (appCompatTextView = zVar9.f70106w) == null) {
            return;
        }
        appCompatTextView.setText(getString(R$string.short_tv_download_buy_full_series_to_download));
    }

    private final void W0(int end) {
        int i11 = this.totalEpisode;
        if (end >= i11) {
            this.isRequestingData = false;
            Function0 function0 = this.selectAllCallback;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        int i12 = i11 - end;
        if (i12 > 20) {
            this.startPosition = end + 1;
            this.endPosition = end + 20;
        } else {
            int i13 = end + 1;
            this.startPosition = i13;
            this.endPosition = (i13 + i12) - 1;
        }
        y1(true);
    }

    private final void W1(List list, int start, int end) {
        HashMap g11;
        b0 r11;
        DownloadItem downloadItem;
        List data;
        List data2;
        List data3;
        js.d dVar;
        b0 r12;
        Long l11;
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag, "updateList ,  size = " + (list != null ? Integer.valueOf(list.size()) : null), false, 4, null);
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            this.isRequestingData = false;
            Function0 function0 = this.selectAllCallback;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        ShortTvDownloadViewModel viewModel = getViewModel();
        long longValue = (viewModel == null || (r12 = viewModel.r()) == null || (l11 = (Long) r12.f()) == null) ? 0L : l11.longValue();
        String tag2 = getTAG();
        Intrinsics.g(tag2, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag2, "before curTotalSize:" + longValue, false, 4, null);
        int size = list2.size();
        long j11 = longValue;
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            int i13 = (start + i12) - 1;
            DownloadItem downloadItem2 = (DownloadItem) list.get(i12);
            qs.d s02 = g0().s0();
            if (s02 != null) {
                String resourceId = downloadItem2.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadItem2.getUrl();
                }
                downloadItem = s02.g(resourceId);
            } else {
                downloadItem = null;
            }
            if (this.isSelectAll) {
                if (downloadItem != null) {
                    downloadItem.setCheck(true);
                }
                downloadItem2.setCheck(true);
                Long size2 = downloadItem2.getSize();
                j11 += size2 != null ? size2.longValue() : 0L;
            }
            if (downloadItem != null) {
                downloadItem.setUploadBy(downloadItem2.getUploadBy());
                i11++;
                downloadItem.setPosition(i13);
                this.episodeResourceMap.put(Integer.valueOf(i13), downloadItem);
                a.C0856a c0856a2 = lg.a.f68962a;
                String tag3 = getTAG();
                Intrinsics.g(tag3, "<get-TAG>(...)");
                a.C0856a.f(c0856a2, tag3, "in download ep:" + downloadItem.getEp() + ", status:" + downloadItem.getStatus(), false, 4, null);
            } else {
                downloadItem2.setPosition(i13);
                i11++;
                this.episodeResourceMap.put(Integer.valueOf(i13), downloadItem2);
            }
            ShortTvDownloadEpListAdapter shortTvDownloadEpListAdapter = this.shortTVEpAdapter;
            if (shortTvDownloadEpListAdapter != null && (data3 = shortTvDownloadEpListAdapter.getData()) != null && (dVar = (js.d) CollectionsKt.l0(data3, i13)) != null) {
                dVar.f(downloadItem2.getEpisodeItem());
            }
            if (downloadItem != null && downloadItem.isAvailable()) {
                this.inDownloadStatusMap.put(Integer.valueOf(i13), downloadItem);
                a.C0856a c0856a3 = lg.a.f68962a;
                String tag4 = getTAG();
                Intrinsics.g(tag4, "<get-TAG>(...)");
                a.C0856a.v(c0856a3, tag4, "unable index:" + i13, false, 4, null);
                ShortTvDownloadEpListAdapter shortTvDownloadEpListAdapter2 = this.shortTVEpAdapter;
                if (i13 < ((shortTvDownloadEpListAdapter2 == null || (data2 = shortTvDownloadEpListAdapter2.getData()) == null) ? 0 : data2.size())) {
                    ShortTvDownloadEpListAdapter shortTvDownloadEpListAdapter3 = this.shortTVEpAdapter;
                    js.d dVar2 = (shortTvDownloadEpListAdapter3 == null || (data = shortTvDownloadEpListAdapter3.getData()) == null) ? null : (js.d) CollectionsKt.l0(data, i13);
                    if (dVar2 != null) {
                        dVar2.e(true);
                    }
                }
            }
        }
        ShortTvDownloadEpListAdapter shortTvDownloadEpListAdapter4 = this.shortTVEpAdapter;
        if (shortTvDownloadEpListAdapter4 != null) {
            shortTvDownloadEpListAdapter4.notifyItemRangeChanged(start - 1, list.size());
        }
        a.C0856a c0856a4 = lg.a.f68962a;
        String tag5 = getTAG();
        Intrinsics.g(tag5, "<get-TAG>(...)");
        a.C0856a.v(c0856a4, tag5, "update data curTotalSize:" + j11, false, 4, null);
        ShortTvDownloadViewModel viewModel2 = getViewModel();
        if (viewModel2 != null && (r11 = viewModel2.r()) != null) {
            r11.q(Long.valueOf(j11));
        }
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        hj.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (g11 = logViewConfig2.g()) != null) {
            g11.put("size", String.valueOf(i11));
        }
        W0(end);
    }

    private final void X0() {
        AppCompatTextView appCompatTextView;
        AppCompatImageView appCompatImageView;
        List data;
        b0 q11;
        Map map;
        ShortTvDownloadViewModel viewModel = getViewModel();
        int size = (viewModel == null || (q11 = viewModel.q()) == null || (map = (Map) q11.f()) == null) ? 0 : map.size();
        ShortTvDownloadEpListAdapter shortTvDownloadEpListAdapter = this.shortTVEpAdapter;
        int size2 = ((shortTvDownloadEpListAdapter == null || (data = shortTvDownloadEpListAdapter.getData()) == null) ? 0 : data.size()) - this.inDownloadStatusMap.size();
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag, "checkSelectAll, selectedCount: " + size + ", totalSelectable:" + size2, false, 4, null);
        this.isSelectAll = size == size2;
        z zVar = (z) getMViewBinding();
        if (zVar != null && (appCompatImageView = zVar.f70095l) != null) {
            appCompatImageView.setSelected(this.isSelectAll);
        }
        z zVar2 = (z) getMViewBinding();
        if (zVar2 == null || (appCompatTextView = zVar2.f70107x) == null) {
            return;
        }
        appCompatTextView.setVisibility(size > 0 ? 0 : 8);
        appCompatTextView.setText(Utils.a().getString(R$string.short_tv_download_ep_selected_count, String.valueOf(size)));
    }

    private final void X1() {
        b0 p11;
        if (!nh.m.f70597a.e()) {
            fs.b.f62582a.e(Utils.a().getString(R$string.short_tv_no_network_toast));
            return;
        }
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        z zVar = (z) getMViewBinding();
        Subject subject = null;
        final LinearLayoutCompat linearLayoutCompat = zVar != null ? zVar.f70087d : null;
        if (linearLayoutCompat != null) {
            linearLayoutCompat.setEnabled(false);
        }
        STCommonVideoAdHelper sTCommonVideoAdHelper = this.downloadVideoAdHelper;
        if (sTCommonVideoAdHelper != null) {
            STCommonVideoAdHelper.q(sTCommonVideoAdHelper, 0, 1, null);
        }
        this.downloadVideoAdHelper = new STCommonVideoAdHelper("ShortTvPlayerUnlockDownloadScene", androidx.view.v.a(this));
        ShortTvDownloadViewModel viewModel = getViewModel();
        if (viewModel != null && (p11 = viewModel.p()) != null) {
            subject = (Subject) p11.f();
        }
        final Subject subject2 = subject;
        Integer num = (Integer) g0().j0().f();
        final int intValue = num != null ? num.intValue() : 0;
        STCommonVideoAdHelper sTCommonVideoAdHelper2 = this.downloadVideoAdHelper;
        if (sTCommonVideoAdHelper2 != null) {
            sTCommonVideoAdHelper2.t(new Function3() { // from class: com.transsion.shorttv.ui.fragment.download.n
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit Y1;
                    Y1 = ShortTVDownloadReFragment.Y1(ShortTVDownloadReFragment.this, activity, subject2, intValue, linearLayoutCompat, ((Boolean) obj).booleanValue(), (String) obj2, (String) obj3);
                    return Y1;
                }
            });
        }
    }

    private final int Y0() {
        b0 q11;
        Map map;
        b0 p11;
        ShortTvDownloadViewModel viewModel = getViewModel();
        Subject subject = (viewModel == null || (p11 = viewModel.p()) == null) ? null : (Subject) p11.f();
        ShortTvDownloadViewModel viewModel2 = getViewModel();
        int i11 = 0;
        if (viewModel2 != null && (q11 = viewModel2.q()) != null && (map = (Map) q11.f()) != null) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                if (zr.b.f79574a.c(subject, ((js.d) ((Map.Entry) it.next()).getValue()).a())) {
                    i11++;
                }
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y1(final ShortTVDownloadReFragment shortTVDownloadReFragment, FragmentActivity fragmentActivity, final Subject subject, final int i11, final LinearLayoutCompat linearLayoutCompat, boolean z10, String errorCode, String errorMessage) {
        Intrinsics.h(errorCode, "errorCode");
        Intrinsics.h(errorMessage, "errorMessage");
        if (z10) {
            STCommonVideoAdHelper sTCommonVideoAdHelper = shortTVDownloadReFragment.downloadVideoAdHelper;
            if (sTCommonVideoAdHelper != null) {
                sTCommonVideoAdHelper.u(fragmentActivity, new Function0() { // from class: com.transsion.shorttv.ui.fragment.download.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit Z1;
                        Z1 = ShortTVDownloadReFragment.Z1(ShortTVDownloadReFragment.this);
                        return Z1;
                    }
                }, new Function1() { // from class: com.transsion.shorttv.ui.fragment.download.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit a22;
                        a22 = ShortTVDownloadReFragment.a2(ShortTVDownloadReFragment.this, linearLayoutCompat, subject, i11, ((Boolean) obj).booleanValue());
                        return a22;
                    }
                });
            }
        } else {
            ss.b.f75981a.l(subject, i11, "fail", errorMessage, errorCode, "download");
            fs.b.f62582a.d(R$string.short_tv_ad_unlocked_get_ad_failed);
            shortTVDownloadReFragment.downloadVideoAdHelper = null;
            if (linearLayoutCompat != null) {
                linearLayoutCompat.setEnabled(true);
            }
        }
        return Unit.f67184a;
    }

    private final void Z0(String pageName, String pageFrom, String subjectId, String miniId, String ops, String resourceId, String taskId) {
        HashMap hashMap = new HashMap();
        hashMap.put(WebConstants.PAGE_FROM, pageFrom);
        hashMap.put("subject_id", subjectId);
        hashMap.put("mini_id", miniId);
        hashMap.put("ops", ops);
        hashMap.put("resource_id", resourceId);
        hashMap.put("task_id", taskId);
        hashMap.put("module_name", this.moduleName);
        hashMap.put("is_select_all", this.isSelectAll ? "1" : "0");
        hj.i iVar = hj.i.f64628a;
        if (pageName == null) {
            pageName = "download_click";
        }
        iVar.s(pageName, "download_click", hashMap);
        Bundle bundle = new Bundle();
        bundle.putString("resource_id", resourceId);
        bundle.putString("subject_id", subjectId);
        qs.f y02 = g0().y0();
        if (y02 != null) {
            y02.b("download_click", bundle, getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z1(ShortTVDownloadReFragment shortTVDownloadReFragment) {
        b0 p11;
        Subject subject;
        b0 q11;
        Map map;
        Collection values;
        ShortTvDownloadViewModel viewModel;
        ShortTvDownloadViewModel viewModel2 = shortTVDownloadReFragment.getViewModel();
        if (viewModel2 == null || (p11 = viewModel2.p()) == null || (subject = (Subject) p11.f()) == null) {
            return Unit.f67184a;
        }
        Companion.AbstractC0660a abstractC0660a = shortTVDownloadReFragment.downloadBtnState;
        Companion.AbstractC0660a.d dVar = abstractC0660a instanceof Companion.AbstractC0660a.d ? (Companion.AbstractC0660a.d) abstractC0660a : null;
        if (dVar != null ? dVar.a() : false) {
            zr.b.f79574a.f(subject);
        } else {
            ShortTvDownloadViewModel viewModel3 = shortTVDownloadReFragment.getViewModel();
            if (viewModel3 != null && (q11 = viewModel3.q()) != null && (map = (Map) q11.f()) != null && (values = map.values()) != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : values) {
                    if (zr.b.f79574a.c(subject, ((js.d) obj).a())) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ShortTVItem a11 = ((js.d) it.next()).a();
                    if (a11 != null) {
                        arrayList2.add(a11);
                    }
                }
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    zr.b.f79574a.g(subject, (ShortTVItem) it2.next(), 1);
                }
            }
        }
        shortTVDownloadReFragment.g0().Q0(subject.getAdUnlockedEps());
        String subjectId = subject.getSubjectId();
        if (subjectId != null && (viewModel = shortTVDownloadReFragment.getViewModel()) != null) {
            viewModel.t(subjectId);
        }
        return Unit.f67184a;
    }

    private final View a1() {
        LayoutInflater from = LayoutInflater.from(requireContext());
        int i11 = R$layout.short_tv_layout_download_loading;
        z zVar = (z) getMViewBinding();
        return from.inflate(i11, (ViewGroup) (zVar != null ? zVar.f70092i : null), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a2(ShortTVDownloadReFragment shortTVDownloadReFragment, LinearLayoutCompat linearLayoutCompat, Subject subject, int i11, boolean z10) {
        b0 r11;
        Long l11;
        shortTVDownloadReFragment.downloadVideoAdHelper = null;
        if (linearLayoutCompat != null) {
            linearLayoutCompat.setEnabled(true);
        }
        if (z10) {
            ss.b.f75981a.l(subject, i11, NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, "", "0", "download");
            shortTVDownloadReFragment.g0().S0();
            shortTVDownloadReFragment.U1();
            ShortTvDownloadViewModel viewModel = shortTVDownloadReFragment.getViewModel();
            shortTVDownloadReFragment.A1((viewModel == null || (r11 = viewModel.r()) == null || (l11 = (Long) r11.f()) == null) ? 0L : l11.longValue());
            fs.b.f62582a.d(R$string.short_tv_locked_episode_unlocked);
        } else {
            ss.b.f75981a.l(subject, i11, "cancel", "", "0", "download");
        }
        return Unit.f67184a;
    }

    private final View b1(Context context, String desText, boolean showRightBtn) {
        final DefaultView defaultView = new DefaultView(context, DefaultView.ModelStyle.MODEL_STYLE_NIGHT);
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_DES_BTN);
        defaultView.setDescText(desText);
        defaultView.setDescTextColor(-1);
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_NO_IMAGE);
        defaultView.setBtnVisibility(showRightBtn ? 0 : 8);
        String string = context.getString(R$string.short_tv_go_to_setting);
        Intrinsics.g(string, "getString(...)");
        defaultView.setBtnText(string);
        defaultView.setTipOperationVisibility(8);
        defaultView.setBtnBg(androidx.core.content.b.getDrawable(Utils.a(), R$drawable.short_tv_download_empty_btn_bg));
        defaultView.setBtnTextColor(-1);
        defaultView.setBackgroundColor(0);
        defaultView.setBtnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.ui.fragment.download.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTVDownloadReFragment.c1(view);
            }
        });
        defaultView.setLeftBtnVisibility(0);
        String string2 = context.getString(R$string.short_tv_Retry);
        Intrinsics.g(string2, "getString(...)");
        defaultView.setLeftBtnText(string2);
        defaultView.setLeftBtnBg(androidx.core.content.b.getDrawable(Utils.a(), R$drawable.short_tv_download_empty_btn_bg));
        defaultView.setLeftBtnTextColor(-1);
        defaultView.setLeftBtnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.ui.fragment.download.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTVDownloadReFragment.d1(ShortTVDownloadReFragment.this, defaultView, view);
            }
        });
        defaultView.setTitleViewVisibility(8);
        int a11 = a0.a(16.0f);
        defaultView.setPadding(a11, a0.a(110.0f), a11, 0);
        defaultView.setVisibility(0);
        return defaultView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(View view) {
        NetworkUtils.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(ShortTVDownloadReFragment shortTVDownloadReFragment, DefaultView defaultView, View view) {
        shortTVDownloadReFragment.showLoading();
        if (shortTVDownloadReFragment.startPosition == 1) {
            shortTVDownloadReFragment.y1(false);
        } else {
            shortTVDownloadReFragment.y1(true);
        }
        defaultView.setVisibility(8);
    }

    private final View e1() {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        String string = Utils.a().getString(R$string.short_tv_error_load_failed);
        Intrinsics.g(string, "getString(...)");
        return b1(requireContext, string, false);
    }

    private final View f1() {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        String string = Utils.a().getString(R$string.short_tv_no_network_title);
        Intrinsics.g(string, "getString(...)");
        return b1(requireContext, string, true);
    }

    private final com.transsion.shorttv.utils.b g1() {
        return (com.transsion.shorttv.utils.b) this.shortTVReporter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(ShortTVDownloadReFragment shortTVDownloadReFragment, View view) {
        shortTVDownloadReFragment.f0();
    }

    private final void initHistory() {
        kotlinx.coroutines.k.d(androidx.view.v.a(this), null, null, new ShortTVDownloadReFragment$initHistory$1(this, null), 3, null);
    }

    private final void initView() {
        z zVar;
        Group group;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        AppBarLayout appBarLayout;
        AppBarLayout appBarLayout2;
        AppCompatTextView appCompatTextView;
        z zVar2 = (z) getMViewBinding();
        if (zVar2 != null && (appCompatTextView = zVar2.D) != null) {
            Subject subject = this.subject;
            appCompatTextView.setText(subject != null ? subject.getTitle() : null);
        }
        z zVar3 = (z) getMViewBinding();
        if (zVar3 != null && (appBarLayout2 = zVar3.f70085b) != null) {
            appBarLayout2.setExpanded(!this.scroll2Download);
        }
        z zVar4 = (z) getMViewBinding();
        Object layoutParams = (zVar4 == null || (appBarLayout = zVar4.f70085b) == null) ? null : appBarLayout.getLayoutParams();
        CoordinatorLayout.f fVar = layoutParams instanceof CoordinatorLayout.f ? (CoordinatorLayout.f) layoutParams : null;
        AppBarLayout.Behavior behavior = new AppBarLayout.Behavior() { // from class: com.transsion.shorttv.ui.fragment.download.ShortTVDownloadReFragment$initView$behavior$1

            /* loaded from: classes6.dex */
            public static final class a extends AppBarLayout.Behavior.a {
                a() {
                }

                @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior.c
                public boolean a(AppBarLayout appBarLayout) {
                    Intrinsics.h(appBarLayout, "appBarLayout");
                    return true;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                u0(new a());
            }

            @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
            /* renamed from: m0 */
            public void q(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dx2, int dy2, int[] consumed, int type) {
                Intrinsics.h(coordinatorLayout, "coordinatorLayout");
                Intrinsics.h(child, "child");
                Intrinsics.h(target, "target");
                Intrinsics.h(consumed, "consumed");
                if (target instanceof RecyclerView) {
                    if (dy2 > 0 && target.canScrollVertically(1)) {
                        return;
                    }
                    if (dy2 < 0 && target.canScrollVertically(-1)) {
                        return;
                    }
                }
                super.q(coordinatorLayout, child, target, dx2, dy2, consumed, type);
            }
        };
        if (fVar != null) {
            fVar.o(behavior);
        }
        z zVar5 = (z) getMViewBinding();
        if (zVar5 != null && (recyclerView2 = zVar5.f70102s) != null) {
            int i11 = this.padding;
            recyclerView2.setPadding(i11, 0, i11, 0);
            recyclerView2.setLayoutManager(new GridLayoutManager(recyclerView2.getContext(), 5, 1, false));
            recyclerView2.addOnScrollListener(new e());
        }
        ShortTvDownloadEpListAdapter shortTvDownloadEpListAdapter = new ShortTvDownloadEpListAdapter();
        shortTvDownloadEpListAdapter.l(new Function1() { // from class: com.transsion.shorttv.ui.fragment.download.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit p12;
                p12 = ShortTVDownloadReFragment.p1(ShortTVDownloadReFragment.this, ((Integer) obj).intValue());
                return p12;
            }
        });
        this.shortTVEpAdapter = shortTvDownloadEpListAdapter;
        z zVar6 = (z) getMViewBinding();
        if (zVar6 != null && (recyclerView = zVar6.f70102s) != null) {
            recyclerView.setAdapter(this.shortTVEpAdapter);
        }
        if (!lr.c.f69154a.b().d().b() || (zVar = (z) getMViewBinding()) == null || (group = zVar.f70088e) == null) {
            return;
        }
        yr.b.b(group);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(ShortTVDownloadReFragment shortTVDownloadReFragment, View view) {
        Intrinsics.e(view);
        shortTVDownloadReFragment.F1(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(ShortTVDownloadReFragment shortTVDownloadReFragment, View view) {
        Intrinsics.e(view);
        shortTVDownloadReFragment.D1(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(ShortTVDownloadReFragment shortTVDownloadReFragment, View view) {
        Intrinsics.e(view);
        shortTVDownloadReFragment.I1(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(ShortTVDownloadReFragment shortTVDownloadReFragment, View view) {
        shortTVDownloadReFragment.G1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(ShortTVDownloadReFragment shortTVDownloadReFragment, View view) {
        shortTVDownloadReFragment.G1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(ShortTVDownloadReFragment shortTVDownloadReFragment, View view) {
        b0 r11;
        Long l11;
        b0 q11;
        FrameLayout frameLayout;
        if (ds.d.f61551a.a(view.getId(), 500L)) {
            return;
        }
        if (!nh.m.f70597a.e()) {
            fs.b.f62582a.d(R$string.short_tv_no_network_toast);
            return;
        }
        z zVar = (z) shortTVDownloadReFragment.getMViewBinding();
        if (zVar != null && (frameLayout = zVar.f70091h) != null && frameLayout.getVisibility() == 0) {
            lg.a.f68962a.p("Download", new String[]{"DownloadReDetectorGroupMainFragment --> onDownload() --> 当前正在全选中"}, true);
            return;
        }
        ShortTvDownloadViewModel viewModel = shortTVDownloadReFragment.getViewModel();
        Map map = (viewModel == null || (q11 = viewModel.q()) == null) ? null : (Map) q11.f();
        if (map == null || map.isEmpty()) {
            fs.b.f62582a.e(Utils.a().getString(R$string.download_short_tv_unselected_toast));
        } else {
            ShortTvDownloadViewModel viewModel2 = shortTVDownloadReFragment.getViewModel();
            shortTVDownloadReFragment.A1((viewModel2 == null || (r11 = viewModel2.r()) == null || (l11 = (Long) r11.f()) == null) ? 0L : l11.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p1(ShortTVDownloadReFragment shortTVDownloadReFragment, int i11) {
        shortTVDownloadReFragment.E1(i11);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1(ShortTVDownloadReFragment shortTVDownloadReFragment, DownloadListBean downloadListBean) {
        List data;
        shortTVDownloadReFragment.K1();
        if (downloadListBean == null) {
            ShortTvDownloadEpListAdapter shortTvDownloadEpListAdapter = shortTVDownloadReFragment.shortTVEpAdapter;
            if (shortTvDownloadEpListAdapter != null && (data = shortTvDownloadEpListAdapter.getData()) != null && data.size() == 0) {
                shortTVDownloadReFragment.S1();
            }
            return Unit.f67184a;
        }
        a.C0856a c0856a = lg.a.f68962a;
        String tag = shortTVDownloadReFragment.getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        List<DownloadItem> items = downloadListBean.getItems();
        a.C0856a.f(c0856a, tag, "get data from  net, size = " + (items != null ? Integer.valueOf(items.size()) : null), false, 4, null);
        Integer totalEpisode = downloadListBean.getTotalEpisode();
        if (totalEpisode != null && totalEpisode.intValue() == 0) {
            Subject subject = shortTVDownloadReFragment.subject;
            downloadListBean.setTotalEpisode(Integer.valueOf(subject != null ? subject.getTotalEpisode() : 0));
        }
        shortTVDownloadReFragment.T1(downloadListBean);
        shortTVDownloadReFragment.W1(downloadListBean.getItems(), downloadListBean.getStartPosition(), downloadListBean.getEndPosition());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r1(ShortTVDownloadReFragment shortTVDownloadReFragment, Subject subject) {
        if (subject != null) {
            shortTVDownloadReFragment.subject = subject;
            ShortTvDownloadEpListAdapter shortTvDownloadEpListAdapter = shortTVDownloadReFragment.shortTVEpAdapter;
            if (shortTvDownloadEpListAdapter != null) {
                shortTvDownloadEpListAdapter.m(subject);
            }
            shortTVDownloadReFragment.U1();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s1(ShortTVDownloadReFragment shortTVDownloadReFragment, Map map) {
        shortTVDownloadReFragment.X0();
        shortTVDownloadReFragment.V0();
        return Unit.f67184a;
    }

    private final void showLoading() {
        FrameLayout frameLayout;
        z zVar = (z) getMViewBinding();
        if (zVar == null || (frameLayout = zVar.f70092i) == null) {
            return;
        }
        frameLayout.removeAllViews();
        frameLayout.setVisibility(0);
        frameLayout.addView(a1());
    }

    private final void showNotNetError() {
        FrameLayout frameLayout;
        z zVar = (z) getMViewBinding();
        if (zVar == null || (frameLayout = zVar.f70092i) == null) {
            return;
        }
        frameLayout.removeAllViews();
        frameLayout.setVisibility(0);
        frameLayout.addView(f1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t1(ShortTVDownloadReFragment shortTVDownloadReFragment, Long l11) {
        Intrinsics.e(l11);
        shortTVDownloadReFragment.H1(l11.longValue());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u1(Integer num) {
        fs.b.f62582a.d((num != null && num.intValue() == 0) ? R$string.short_tv_error_load_failed : (num != null && num.intValue() == 2) ? R$string.short_tv_favorite_remove_toast : R$string.short_tv_favorite_toast);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v1(ShortTVDownloadReFragment shortTVDownloadReFragment, uy.c value) {
        BLImageView bLImageView;
        ShortTVFavInfo shortTVFavInfo;
        Intrinsics.h(value, "value");
        try {
        } catch (Exception unused) {
            a.C0856a.g(lg.a.f68962a, " callback change data fail", false, 2, null);
        }
        if (!TextUtils.equals(value.c(), shortTVDownloadReFragment.subjectId)) {
            return Unit.f67184a;
        }
        Subject subject = shortTVDownloadReFragment.subject;
        if (subject != null && (shortTVFavInfo = subject.getShortTVFavInfo()) != null) {
            shortTVFavInfo.setFavoriteNum(value.b());
            shortTVFavInfo.setHasFavorite(value.a());
        }
        z zVar = (z) shortTVDownloadReFragment.getMViewBinding();
        if (zVar != null && (bLImageView = zVar.f70098o) != null) {
            bLImageView.setSelected(value.a());
        }
        return Unit.f67184a;
    }

    private final boolean w1() {
        List data;
        int size = this.inDownloadStatusMap.size();
        ShortTvDownloadEpListAdapter shortTvDownloadEpListAdapter = this.shortTVEpAdapter;
        return size < ((shortTvDownloadEpListAdapter == null || (data = shortTvDownloadEpListAdapter.getData()) == null) ? 0 : data.size());
    }

    private final void x1(qs.i loginProvider, Function0 onSuccess) {
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        Intent b11 = loginProvider.b(requireContext);
        if (b11 == null) {
            return;
        }
        this.loginSuccessCallback = onSuccess;
        this.loginLauncher.a(b11);
    }

    private final void y1(boolean onlyEpisodeList) {
        if (!nh.m.f70597a.e()) {
            showNotNetError();
            return;
        }
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag, "loadData ,  startPosition:" + this.startPosition + ", endPosition:" + this.endPosition, false, 4, null);
        this.isRequestingData = true;
        if (onlyEpisodeList) {
            ShortTvDownloadViewModel viewModel = getViewModel();
            if (viewModel != null) {
                String str = this.subjectId;
                viewModel.i(str != null ? str : "", this.startPosition, this.endPosition);
                return;
            }
            return;
        }
        ShortTvDownloadViewModel viewModel2 = getViewModel();
        if (viewModel2 != null) {
            String str2 = this.subjectId;
            if (str2 == null) {
                str2 = "";
            }
            ShortTvDownloadViewModel.o(viewModel2, str2, false, 2, null);
        }
        ShortTvDownloadViewModel viewModel3 = getViewModel();
        if (viewModel3 != null) {
            String str3 = this.subjectId;
            viewModel3.i(str3 != null ? str3 : "", this.startPosition, this.endPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z1(ShortTVDownloadReFragment shortTVDownloadReFragment, ActivityResult activityResult) {
        Function0 function0;
        if (activityResult.getResultCode() == -1 && (function0 = shortTVDownloadReFragment.loginSuccessCallback) != null) {
            function0.invoke();
        }
        shortTVDownloadReFragment.loginSuccessCallback = null;
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public z getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        z c11 = z.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public void initListener() {
        LinearLayoutCompat linearLayoutCompat;
        AppCompatImageView appCompatImageView;
        AppCompatTextView appCompatTextView;
        BLImageView bLImageView;
        BLImageView bLImageView2;
        BLView bLView;
        ImageView imageView;
        z zVar = (z) getMViewBinding();
        if (zVar != null && (imageView = zVar.f70096m) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.ui.fragment.download.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShortTVDownloadReFragment.i1(ShortTVDownloadReFragment.this, view);
                }
            });
        }
        z zVar2 = (z) getMViewBinding();
        if (zVar2 != null && (bLView = zVar2.H) != null) {
            bLView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.ui.fragment.download.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShortTVDownloadReFragment.j1(ShortTVDownloadReFragment.this, view);
                }
            });
        }
        z zVar3 = (z) getMViewBinding();
        if (zVar3 != null && (bLImageView2 = zVar3.f70098o) != null) {
            bLImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.ui.fragment.download.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShortTVDownloadReFragment.k1(ShortTVDownloadReFragment.this, view);
                }
            });
        }
        z zVar4 = (z) getMViewBinding();
        if (zVar4 != null && (bLImageView = zVar4.f70099p) != null) {
            bLImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.ui.fragment.download.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShortTVDownloadReFragment.l1(ShortTVDownloadReFragment.this, view);
                }
            });
        }
        z zVar5 = (z) getMViewBinding();
        if (zVar5 != null && (appCompatTextView = zVar5.B) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.ui.fragment.download.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShortTVDownloadReFragment.m1(ShortTVDownloadReFragment.this, view);
                }
            });
        }
        z zVar6 = (z) getMViewBinding();
        if (zVar6 != null && (appCompatImageView = zVar6.f70095l) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.ui.fragment.download.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShortTVDownloadReFragment.n1(ShortTVDownloadReFragment.this, view);
                }
            });
        }
        z zVar7 = (z) getMViewBinding();
        if (zVar7 == null || (linearLayoutCompat = zVar7.f70087d) == null) {
            return;
        }
        linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.ui.fragment.download.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTVDownloadReFragment.o1(ShortTVDownloadReFragment.this, view);
            }
        });
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public void initViewData() {
        initView();
        J1();
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public void initViewModel() {
        b0 p11;
        b0 l11;
        b0 m11;
        b0 r11;
        b0 q11;
        String str = this.subjectId;
        if (str == null || str.length() == 0) {
            a.C0856a c0856a = lg.a.f68962a;
            String tag = getTAG();
            Intrinsics.g(tag, "<get-TAG>(...)");
            a.C0856a.l(c0856a, tag, "subjectId is null", false, 4, null);
            return;
        }
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            ShortTvDownloadViewModel viewModel = getViewModel();
            if (viewModel != null && (q11 = viewModel.q()) != null) {
                q11.j(parentFragment, new f(new Function1() { // from class: com.transsion.shorttv.ui.fragment.download.v
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit s12;
                        s12 = ShortTVDownloadReFragment.s1(ShortTVDownloadReFragment.this, (Map) obj);
                        return s12;
                    }
                }));
            }
            ShortTvDownloadViewModel viewModel2 = getViewModel();
            if (viewModel2 != null && (r11 = viewModel2.r()) != null) {
                r11.j(parentFragment, new f(new Function1() { // from class: com.transsion.shorttv.ui.fragment.download.w
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit t12;
                        t12 = ShortTVDownloadReFragment.t1(ShortTVDownloadReFragment.this, (Long) obj);
                        return t12;
                    }
                }));
            }
            ShortTvDownloadViewModel viewModel3 = getViewModel();
            if (viewModel3 != null && (m11 = viewModel3.m()) != null) {
                m11.j(parentFragment, new f(new Function1() { // from class: com.transsion.shorttv.ui.fragment.download.x
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit u12;
                        u12 = ShortTVDownloadReFragment.u1((Integer) obj);
                        return u12;
                    }
                }));
            }
        }
        androidx.view.u viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.g(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Function1 function1 = new Function1() { // from class: com.transsion.shorttv.ui.fragment.download.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit v12;
                v12 = ShortTVDownloadReFragment.v1(ShortTVDownloadReFragment.this, (uy.c) obj);
                return v12;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = uy.c.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent(viewLifecycleOwner, name, Lifecycle.State.CREATED, y0.c().q(), false, function1);
        Fragment parentFragment2 = getParentFragment();
        if (parentFragment2 != null && getViewModel() != null) {
            ShortTvDownloadViewModel viewModel4 = getViewModel();
            if (viewModel4 != null && (l11 = viewModel4.l()) != null) {
                l11.j(parentFragment2, new f(new Function1() { // from class: com.transsion.shorttv.ui.fragment.download.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit q12;
                        q12 = ShortTVDownloadReFragment.q1(ShortTVDownloadReFragment.this, (DownloadListBean) obj);
                        return q12;
                    }
                }));
            }
            ShortTvDownloadViewModel viewModel5 = getViewModel();
            if (viewModel5 != null && (p11 = viewModel5.p()) != null) {
                p11.j(parentFragment2, new f(new Function1() { // from class: com.transsion.shorttv.ui.fragment.download.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit r12;
                        r12 = ShortTVDownloadReFragment.r1(ShortTVDownloadReFragment.this, (Subject) obj);
                        return r12;
                    }
                }));
            }
        }
        a.C0856a c0856a2 = lg.a.f68962a;
        String tag2 = getTAG();
        Intrinsics.g(tag2, "<get-TAG>(...)");
        a.C0856a.f(c0856a2, tag2, "initViewModel ,loadData", false, 4, null);
        showLoading();
        y1(false);
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public boolean isMonitorNetworkState() {
        return true;
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        String str2;
        String str3;
        HashMap g11;
        HashMap g12;
        HashMap g13;
        HashMap g14;
        HashMap g15;
        String string;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        String str4 = "";
        if (arguments == null || (str = arguments.getString(WebConstants.PAGE_FROM)) == null) {
            str = "";
        }
        this.pageFrom = str;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str2 = arguments2.getString("last_page_from")) == null) {
            str2 = "";
        }
        this.lastPageFrom = str2;
        Bundle arguments3 = getArguments();
        this.subject = (Subject) (arguments3 != null ? arguments3.getSerializable("subject") : null);
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (str3 = arguments4.getString("ops")) == null) {
            str3 = "";
        }
        this.ops = str3;
        Bundle arguments5 = getArguments();
        if (arguments5 != null && (string = arguments5.getString("module_name")) != null) {
            str4 = string;
        }
        this.moduleName = str4;
        Bundle arguments6 = getArguments();
        this.scroll2Download = arguments6 != null ? arguments6.getBoolean("download_scroll_to_download") : false;
        Subject subject = this.subject;
        this.subjectId = subject != null ? subject.getSubjectId() : null;
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag, "ShortTv download init subjectId:" + this.subjectId, false, 4, null);
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (g15 = logViewConfig.g()) != null) {
            g15.put(WebConstants.PAGE_FROM, this.pageFrom);
        }
        hj.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (g14 = logViewConfig2.g()) != null) {
            g14.put("last_page_from", this.lastPageFrom);
        }
        hj.b logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (g13 = logViewConfig3.g()) != null) {
            Subject subject2 = this.subject;
            g13.put("subject_id", subject2 != null ? subject2.getSubjectId() : null);
        }
        hj.b logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null && (g12 = logViewConfig4.g()) != null) {
            g12.put("ops", this.ops);
        }
        hj.b logViewConfig5 = getLogViewConfig();
        if (logViewConfig5 != null && (g11 = logViewConfig5.g()) != null) {
            g11.put(NativeComponentConstants.KEY_COMPONENT_TYPE, "2");
        }
        com.transsion.shorttv.utils.b.b(g1(), this.subjectId, "dialog_minitv_download", null, 4, null);
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        STCommonVideoAdHelper sTCommonVideoAdHelper = this.downloadVideoAdHelper;
        if (sTCommonVideoAdHelper != null) {
            STCommonVideoAdHelper.q(sTCommonVideoAdHelper, 0, 1, null);
        }
        this.downloadVideoAdHelper = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        initHistory();
    }

    @Override // com.transsion.shorttv.base.fragment.PageStatusFragment
    public void retryLoadData() {
        List data;
        ShortTvDownloadEpListAdapter shortTvDownloadEpListAdapter = this.shortTVEpAdapter;
        if (shortTvDownloadEpListAdapter == null || (data = shortTvDownloadEpListAdapter.getData()) == null || data.size() != 0) {
            return;
        }
        showLoading();
        y1(false);
    }
}
