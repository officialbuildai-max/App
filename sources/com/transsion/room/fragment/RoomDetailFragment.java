package com.transsion.room.fragment;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.v0;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.therouter.TheRouter;
import com.tn.lib.view.CheckInAnimationView;
import com.tn.lib.view.ToolBarCheckInAnimationView;
import com.tn.lib.view.expand.ExpandView;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$mipmap;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.baseui.widget.PileLayout;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.moviedetailapi.bean.RoomNet;
import com.transsion.publish.view.PublishStateView;
import com.transsion.room.R$drawable;
import com.transsion.room.R$string;
import com.transsion.room.activity.CreateRoomActivity;
import com.transsion.room.viewmodel.RoomDetailViewModel;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.share.share.a;
import com.transsion.usercenterapi.ReportType;
import com.transsion.web.api.WebConstants;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import lg.a;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 o2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002>pB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u0013\u0010\n\u001a\u00020\u0005*\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0014\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b#\u0010$J\u0019\u0010'\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J)\u0010-\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u001d2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\"H\u0016¢\u0006\u0004\b/\u0010$J\u0017\u00102\u001a\u00020\u00022\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0019H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0005H\u0016¢\u0006\u0004\b6\u0010\u0004J\u000f\u00107\u001a\u00020\u0005H\u0016¢\u0006\u0004\b7\u0010\u0004J\u000f\u00108\u001a\u00020\u0005H\u0016¢\u0006\u0004\b8\u0010\u0004J\u000f\u00109\u001a\u00020\u0005H\u0016¢\u0006\u0004\b9\u0010\u0004J\u000f\u0010;\u001a\u00020:H\u0016¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0005H\u0016¢\u0006\u0004\b=\u0010\u0004R\u0016\u0010@\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u001e\u0010G\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u001e\u0010I\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010FR\u0018\u0010L\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010O\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010BR\u001b\u0010[\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u001d\u0010d\u001a\u0004\u0018\u00010`8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\ba\u0010X\u001a\u0004\bb\u0010cR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010j\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010?R\u0016\u0010l\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010BR\u0016\u0010n\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010B¨\u0006q"}, d2 = {"Lcom/transsion/room/fragment/RoomDetailFragment;", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "Lbq/n;", "<init>", "()V", "", "D0", "N0", "H0", "Lcom/tn/lib/view/CheckInAnimationView;", "B0", "(Lcom/tn/lib/view/CheckInAnimationView;)V", "Lcom/transsion/moviedetailapi/bean/RoomItem;", "roomItem", "c1", "(Lcom/transsion/moviedetailapi/bean/RoomItem;)V", "Landroid/view/View;", "tvCheckIn", "Landroid/widget/TextView;", "tvEdit", "X0", "(Landroid/view/View;Landroid/widget/TextView;)V", "C0", "V0", "b1", "", "coverUrl", "Z0", "(Ljava/lang/String;)V", "", RequestParameters.POSITION, "F0", "(I)Ljava/lang/String;", "U0", "", "checkLogin", "()Z", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "isAudioShowNoNetworkLayout", "Landroid/view/LayoutInflater;", "inflater", "G0", "(Landroid/view/LayoutInflater;)Lbq/n;", "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewData", "initViewModel", "initListener", "retryLoadData", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "loadDefaultData", "a", "I", "mTabSelectIndex", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Z", "isNeedShowLoginActivity", "Landroidx/activity/result/b;", "c", "Landroidx/activity/result/b;", "loginLaunch", "d", "updateInfoLaunch", "e", "Ljava/lang/String;", "mGroupId", "f", "Lcom/transsion/moviedetailapi/bean/RoomItem;", "mRoomDetailItem", "Lcom/transsion/share/share/ShareDialogFragment;", be.g.f16474b, "Lcom/transsion/share/share/ShareDialogFragment;", "mShareDialog", "h", "netResultSuccess", "Lcom/transsion/room/viewmodel/RoomDetailViewModel;", "i", "Lkotlin/Lazy;", "E0", "()Lcom/transsion/room/viewmodel/RoomDetailViewModel;", "roomDetailViewModel", "Lab/n;", com.mbridge.msdk.foundation.same.report.j.f35620b, "Lab/n;", "shapeModel", "Lcom/transsnet/loginapi/ILoginApi;", CampaignEx.JSON_KEY_AD_K, "getLoginApi", "()Lcom/transsnet/loginapi/ILoginApi;", "loginApi", "Lcom/transsion/room/fragment/RoomDetailFragment$CollapsingToolbarLayoutState;", "l", "Lcom/transsion/room/fragment/RoomDetailFragment$CollapsingToolbarLayoutState;", "state", "m", "sz", "n", "dealWith80", "o", "dealWithElse", TtmlNode.TAG_P, "CollapsingToolbarLayoutState", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@Deprecated
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class RoomDetailFragment extends PageStatusFragment<bq.n> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int mTabSelectIndex;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isNeedShowLoginActivity;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private androidx.activity.result.b loginLaunch;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private androidx.activity.result.b updateInfoLaunch;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String mGroupId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RoomItem mRoomDetailItem;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private ShareDialogFragment mShareDialog;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean netResultSuccess;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy roomDetailViewModel;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ab.n shapeModel;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final Lazy loginApi;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private CollapsingToolbarLayoutState state;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int sz;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean dealWith80;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean dealWithElse;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/transsion/room/fragment/RoomDetailFragment$CollapsingToolbarLayoutState;", "", "<init>", "(Ljava/lang/String;I)V", "EXPANDED", "COLLAPSED", "INTERNEDIATE", "TOOLBAR", "APPBAR", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes6.dex */
    public static final class CollapsingToolbarLayoutState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CollapsingToolbarLayoutState[] $VALUES;
        public static final CollapsingToolbarLayoutState EXPANDED = new CollapsingToolbarLayoutState("EXPANDED", 0);
        public static final CollapsingToolbarLayoutState COLLAPSED = new CollapsingToolbarLayoutState("COLLAPSED", 1);
        public static final CollapsingToolbarLayoutState INTERNEDIATE = new CollapsingToolbarLayoutState("INTERNEDIATE", 2);
        public static final CollapsingToolbarLayoutState TOOLBAR = new CollapsingToolbarLayoutState("TOOLBAR", 3);
        public static final CollapsingToolbarLayoutState APPBAR = new CollapsingToolbarLayoutState("APPBAR", 4);

        private static final /* synthetic */ CollapsingToolbarLayoutState[] $values() {
            return new CollapsingToolbarLayoutState[]{EXPANDED, COLLAPSED, INTERNEDIATE, TOOLBAR, APPBAR};
        }

        static {
            CollapsingToolbarLayoutState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private CollapsingToolbarLayoutState(String str, int i11) {
        }

        public static EnumEntries<CollapsingToolbarLayoutState> getEntries() {
            return $ENTRIES;
        }

        public static CollapsingToolbarLayoutState valueOf(String str) {
            return (CollapsingToolbarLayoutState) Enum.valueOf(CollapsingToolbarLayoutState.class, str);
        }

        public static CollapsingToolbarLayoutState[] values() {
            return (CollapsingToolbarLayoutState[]) $VALUES.clone();
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
            TextView textView = (TextView) (tab != null ? tab.getCustomView() : null);
            if (textView != null) {
                textView.setTypeface(Typeface.defaultFromStyle(1));
            }
            if (RoomDetailFragment.this.isVisible()) {
                HashMap hashMap = new HashMap();
                String str = RoomDetailFragment.this.mGroupId;
                if (str == null) {
                    str = "";
                }
                hashMap.put("group_id", str);
                hashMap.put("page_tab_name", RoomDetailFragment.this.F0(tab != null ? tab.getPosition() : 0));
                com.transsion.baselib.helper.a.f43316a.l("groupdetail", hashMap);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            TextView textView = (TextView) (tab != null ? tab.getCustomView() : null);
            if (textView != null) {
                textView.setTypeface(Typeface.defaultFromStyle(0));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends ViewPager2.OnPageChangeCallback {
        c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            RoomDetailFragment.this.mTabSelectIndex = i11;
        }
    }

    /* loaded from: classes6.dex */
    static final class d implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f51476a;

        d(Function1 function) {
            Intrinsics.h(function, "function");
            this.f51476a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f51476a;
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
            this.f51476a.invoke(obj);
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements com.transsion.share.share.a {
        e() {
        }

        @Override // com.transsion.share.share.a
        public void a(String id2, PostType postType) {
            Intrinsics.h(id2, "id");
        }

        @Override // com.transsion.share.share.a
        public void b(String str) {
            a.C0650a.b(this, str);
        }

        @Override // com.transsion.share.share.a
        public void c(String url, String fileName, String fileSize, String fileImage) {
            Intrinsics.h(url, "url");
            Intrinsics.h(fileName, "fileName");
            Intrinsics.h(fileSize, "fileSize");
            Intrinsics.h(fileImage, "fileImage");
        }

        @Override // com.transsion.share.share.a
        public void d(String id2) {
            String str;
            Intrinsics.h(id2, "id");
            if (com.transsion.baseui.util.c.f43558a.a(2, 2000L) || (str = RoomDetailFragment.this.mGroupId) == null) {
                return;
            }
            RoomDetailFragment.this.E0().x(str);
        }

        @Override // com.transsion.share.share.a
        public void e(String str) {
            a.C0650a.c(this, str);
        }
    }

    public RoomDetailFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.room.fragment.RoomDetailFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.roomDetailViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(RoomDetailViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.room.fragment.RoomDetailFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final androidx.view.x0 invoke() {
                androidx.view.x0 viewModelStore = ((androidx.view.y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.room.fragment.RoomDetailFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object invoke = Function0.this.invoke();
                androidx.view.m mVar = invoke instanceof androidx.view.m ? (androidx.view.m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        ab.n m11 = ab.n.a().q(0, 20.0f).p(ab.n.f601m).m();
        Intrinsics.g(m11, "build(...)");
        this.shapeModel = m11;
        this.loginApi = LazyKt.b(new Function0() { // from class: com.transsion.room.fragment.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ILoginApi T0;
                T0 = RoomDetailFragment.T0();
                return T0;
            }
        });
        this.sz = com.blankj.utilcode.util.a0.a(20.0f);
    }

    private final void B0(CheckInAnimationView checkInAnimationView) {
        String str;
        int currentState = checkInAnimationView.getCurrentState();
        if (currentState == 2 || currentState == 4) {
            return;
        }
        if (currentState == 1) {
            checkInAnimationView.upDateState(2);
            C0();
        } else {
            if (currentState != 3) {
                return;
            }
            checkInAnimationView.upDateState(4);
            if (com.transsion.baseui.util.c.f43558a.a(2, 2000L) || (str = this.mGroupId) == null) {
                return;
            }
            E0().x(str);
        }
    }

    private final void C0() {
        RoomItem roomItem;
        String groupId;
        ToolBarCheckInAnimationView toolBarCheckInAnimationView;
        CheckInAnimationView checkInAnimationView;
        if (!checkLogin() || com.transsion.baseui.util.c.f43558a.a(1, 2000L) || (roomItem = this.mRoomDetailItem) == null || (groupId = roomItem.getGroupId()) == null) {
            return;
        }
        E0().w(groupId);
        bq.n mViewBinding = getMViewBinding();
        if (mViewBinding != null && (checkInAnimationView = mViewBinding.f16896t) != null) {
            checkInAnimationView.upDateState(2);
        }
        bq.n mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (toolBarCheckInAnimationView = mViewBinding2.f16894r) != null) {
            toolBarCheckInAnimationView.upDateState(2);
        }
        D0();
        com.transsion.baselib.helper.a.f43316a.h("groupdetail", "checkin", (r16 & 4) != 0 ? "" : this.mGroupId, (r16 & 8) != 0 ? "" : null, (r16 & 16) != 0 ? "" : null, (r16 & 32) != 0 ? null : null);
    }

    private final void D0() {
        String str = this.mGroupId;
        if (str != null) {
            E0().p(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RoomDetailViewModel E0() {
        return (RoomDetailViewModel) this.roomDetailViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String F0(int position) {
        String string = getString(position == 0 ? R$string.hot : R$string.s_new);
        Intrinsics.g(string, "getString(...)");
        return string;
    }

    private final void H0() {
        AppBarLayout appBarLayout;
        PublishStateView publishStateView;
        AppCompatImageView appCompatImageView;
        bq.n mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatImageView = mViewBinding.f16882f) != null) {
            appCompatImageView.setImageResource(R$mipmap.icon_white_back);
        }
        bq.n mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (publishStateView = mViewBinding2.f16884h) != null) {
            publishStateView.setImageResource(R$mipmap.libui_ic_base_whit_publish);
        }
        bq.n mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (appBarLayout = mViewBinding3.f16878b) == null) {
            return;
        }
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.g() { // from class: com.transsion.room.fragment.i
            @Override // com.google.android.material.appbar.AppBarLayout.b
            public final void onOffsetChanged(AppBarLayout appBarLayout2, int i11) {
                RoomDetailFragment.I0(RoomDetailFragment.this, appBarLayout2, i11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(RoomDetailFragment roomDetailFragment, AppBarLayout appBarLayout, int i11) {
        AppCompatTextView appCompatTextView;
        TextView textView;
        ToolBarCheckInAnimationView toolBarCheckInAnimationView;
        ShapeableImageView shapeableImageView;
        PublishStateView publishStateView;
        PublishStateView publishStateView2;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        Toolbar toolbar;
        Toolbar toolbar2;
        Toolbar toolbar3;
        Toolbar toolbar4;
        ViewGroup.LayoutParams layoutParams;
        PublishStateView publishStateView3;
        AppCompatImageView appCompatImageView3;
        AppCompatImageView appCompatImageView4;
        PublishStateView publishStateView4;
        AppCompatTextView appCompatTextView2;
        ShapeableImageView shapeableImageView2;
        PublishStateView publishStateView5;
        AppCompatImageView appCompatImageView5;
        AppCompatImageView appCompatImageView6;
        Toolbar toolbar5;
        Toolbar toolbar6;
        Toolbar toolbar7;
        Toolbar toolbar8;
        ViewGroup.LayoutParams layoutParams2;
        if (i11 == 0) {
            roomDetailFragment.state = CollapsingToolbarLayoutState.EXPANDED;
            return;
        }
        if (Math.abs(i11) >= appBarLayout.getTotalScrollRange()) {
            roomDetailFragment.state = CollapsingToolbarLayoutState.COLLAPSED;
            return;
        }
        roomDetailFragment.state = CollapsingToolbarLayoutState.INTERNEDIATE;
        if (Math.abs(i11) <= com.blankj.utilcode.util.a0.a(80.0f)) {
            if (roomDetailFragment.dealWithElse) {
                return;
            }
            roomDetailFragment.dealWithElse = true;
            roomDetailFragment.dealWith80 = false;
            roomDetailFragment.state = CollapsingToolbarLayoutState.APPBAR;
            bq.n mViewBinding = roomDetailFragment.getMViewBinding();
            if (mViewBinding != null && (toolbar4 = mViewBinding.f16891o) != null && (layoutParams = toolbar4.getLayoutParams()) != null) {
                layoutParams.height = com.blankj.utilcode.util.a0.a(44.0f);
            }
            bq.n mViewBinding2 = roomDetailFragment.getMViewBinding();
            if (mViewBinding2 != null && (toolbar3 = mViewBinding2.f16891o) != null) {
                toolbar3.setPadding(0, 0, 0, 0);
            }
            bq.n mViewBinding3 = roomDetailFragment.getMViewBinding();
            ViewGroup.LayoutParams layoutParams3 = (mViewBinding3 == null || (toolbar2 = mViewBinding3.f16891o) == null) ? null : toolbar2.getLayoutParams();
            if (layoutParams3 instanceof CollapsingToolbarLayout.c) {
                ((FrameLayout.LayoutParams) ((CollapsingToolbarLayout.c) layoutParams3)).topMargin = com.blankj.utilcode.util.d.c();
            }
            bq.n mViewBinding4 = roomDetailFragment.getMViewBinding();
            if (mViewBinding4 != null && (toolbar = mViewBinding4.f16891o) != null) {
                toolbar.setBackgroundResource(R$color.transparent);
            }
            bq.n mViewBinding5 = roomDetailFragment.getMViewBinding();
            if (mViewBinding5 != null && (appCompatImageView2 = mViewBinding5.f16882f) != null) {
                appCompatImageView2.setImageResource(R$mipmap.icon_white_back);
            }
            bq.n mViewBinding6 = roomDetailFragment.getMViewBinding();
            if (mViewBinding6 != null && (appCompatImageView = mViewBinding6.f16887k) != null) {
                appCompatImageView.setImageResource(R$mipmap.libui_ic_base_whit_share);
            }
            bq.n mViewBinding7 = roomDetailFragment.getMViewBinding();
            if (mViewBinding7 != null && (publishStateView2 = mViewBinding7.f16884h) != null) {
                publishStateView2.setImageResource(R$mipmap.libui_ic_base_whit_publish);
            }
            bq.n mViewBinding8 = roomDetailFragment.getMViewBinding();
            if (mViewBinding8 != null && (publishStateView = mViewBinding8.f16884h) != null) {
                publishStateView.setProgressColor(Color.parseColor("#FF5ABF"));
            }
            bq.n mViewBinding9 = roomDetailFragment.getMViewBinding();
            CheckInAnimationView checkInAnimationView = mViewBinding9 != null ? mViewBinding9.f16896t : null;
            bq.n mViewBinding10 = roomDetailFragment.getMViewBinding();
            roomDetailFragment.X0(checkInAnimationView, mViewBinding10 != null ? mViewBinding10.f16897u : null);
            bq.n mViewBinding11 = roomDetailFragment.getMViewBinding();
            if (mViewBinding11 != null && (shapeableImageView = mViewBinding11.f16883g) != null) {
                jg.c.g(shapeableImageView);
            }
            bq.n mViewBinding12 = roomDetailFragment.getMViewBinding();
            if (mViewBinding12 != null && (toolBarCheckInAnimationView = mViewBinding12.f16894r) != null) {
                jg.c.g(toolBarCheckInAnimationView);
            }
            bq.n mViewBinding13 = roomDetailFragment.getMViewBinding();
            if (mViewBinding13 != null && (textView = mViewBinding13.f16895s) != null) {
                jg.c.g(textView);
            }
            bq.n mViewBinding14 = roomDetailFragment.getMViewBinding();
            if (mViewBinding14 == null || (appCompatTextView = mViewBinding14.f16901y) == null) {
                return;
            }
            jg.c.g(appCompatTextView);
            return;
        }
        if (roomDetailFragment.dealWith80) {
            return;
        }
        roomDetailFragment.dealWith80 = true;
        roomDetailFragment.dealWithElse = false;
        roomDetailFragment.state = CollapsingToolbarLayoutState.TOOLBAR;
        bq.n mViewBinding15 = roomDetailFragment.getMViewBinding();
        if (mViewBinding15 != null && (toolbar8 = mViewBinding15.f16891o) != null && (layoutParams2 = toolbar8.getLayoutParams()) != null) {
            layoutParams2.height = com.blankj.utilcode.util.a0.a(44.0f) + com.blankj.utilcode.util.d.c();
        }
        bq.n mViewBinding16 = roomDetailFragment.getMViewBinding();
        if (mViewBinding16 != null && (toolbar7 = mViewBinding16.f16891o) != null) {
            toolbar7.setPadding(0, com.blankj.utilcode.util.d.c(), 0, 0);
        }
        bq.n mViewBinding17 = roomDetailFragment.getMViewBinding();
        ViewGroup.LayoutParams layoutParams4 = (mViewBinding17 == null || (toolbar6 = mViewBinding17.f16891o) == null) ? null : toolbar6.getLayoutParams();
        if (layoutParams4 instanceof CollapsingToolbarLayout.c) {
            ((FrameLayout.LayoutParams) ((CollapsingToolbarLayout.c) layoutParams4)).topMargin = 0;
        }
        bq.n mViewBinding18 = roomDetailFragment.getMViewBinding();
        if (mViewBinding18 != null && (toolbar5 = mViewBinding18.f16891o) != null) {
            toolbar5.setBackgroundResource(R$color.bg_01);
        }
        if (ak.x.f733a.a()) {
            bq.n mViewBinding19 = roomDetailFragment.getMViewBinding();
            if (mViewBinding19 != null && (appCompatImageView6 = mViewBinding19.f16882f) != null) {
                appCompatImageView6.setImageResource(R$mipmap.icon_white_back);
            }
            bq.n mViewBinding20 = roomDetailFragment.getMViewBinding();
            if (mViewBinding20 != null && (appCompatImageView5 = mViewBinding20.f16887k) != null) {
                appCompatImageView5.setImageResource(R$mipmap.libui_ic_base_whit_share);
            }
            bq.n mViewBinding21 = roomDetailFragment.getMViewBinding();
            if (mViewBinding21 != null && (publishStateView5 = mViewBinding21.f16884h) != null) {
                publishStateView5.setImageResource(R$mipmap.libui_ic_base_whit_publish);
            }
        } else {
            bq.n mViewBinding22 = roomDetailFragment.getMViewBinding();
            if (mViewBinding22 != null && (appCompatImageView4 = mViewBinding22.f16882f) != null) {
                appCompatImageView4.setImageResource(R$mipmap.libui_ic_base_black_left);
            }
            bq.n mViewBinding23 = roomDetailFragment.getMViewBinding();
            if (mViewBinding23 != null && (appCompatImageView3 = mViewBinding23.f16887k) != null) {
                appCompatImageView3.setImageResource(R$mipmap.libui_ic_base_black_share);
            }
            bq.n mViewBinding24 = roomDetailFragment.getMViewBinding();
            if (mViewBinding24 != null && (publishStateView3 = mViewBinding24.f16884h) != null) {
                publishStateView3.setImageResource(R$mipmap.libui_ic_base_black_publish);
            }
        }
        bq.n mViewBinding25 = roomDetailFragment.getMViewBinding();
        if (mViewBinding25 != null && (shapeableImageView2 = mViewBinding25.f16883g) != null) {
            jg.c.k(shapeableImageView2);
        }
        bq.n mViewBinding26 = roomDetailFragment.getMViewBinding();
        ToolBarCheckInAnimationView toolBarCheckInAnimationView2 = mViewBinding26 != null ? mViewBinding26.f16894r : null;
        bq.n mViewBinding27 = roomDetailFragment.getMViewBinding();
        roomDetailFragment.X0(toolBarCheckInAnimationView2, mViewBinding27 != null ? mViewBinding27.f16895s : null);
        bq.n mViewBinding28 = roomDetailFragment.getMViewBinding();
        if (mViewBinding28 != null && (appCompatTextView2 = mViewBinding28.f16901y) != null) {
            RoomItem roomItem = roomDetailFragment.mRoomDetailItem;
            appCompatTextView2.setText(roomItem != null ? roomItem.getName() : null);
            jg.c.k(appCompatTextView2);
        }
        bq.n mViewBinding29 = roomDetailFragment.getMViewBinding();
        if (mViewBinding29 == null || (publishStateView4 = mViewBinding29.f16884h) == null) {
            return;
        }
        publishStateView4.setProgressColor(Color.parseColor(IntegrationConstants.NAVIGATION_BAR_BACKGROUND_COLOR_DEFAULT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(RoomDetailFragment roomDetailFragment, CheckInAnimationView checkInAnimationView, View view) {
        roomDetailFragment.B0(checkInAnimationView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(RoomDetailFragment roomDetailFragment, ToolBarCheckInAnimationView toolBarCheckInAnimationView, View view) {
        roomDetailFragment.B0(toolBarCheckInAnimationView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(RoomDetailFragment roomDetailFragment, ActivityResult it) {
        ToolBarCheckInAnimationView toolBarCheckInAnimationView;
        CheckInAnimationView checkInAnimationView;
        Intrinsics.h(it, "it");
        if (it.getResultCode() == -1) {
            roomDetailFragment.C0();
            return;
        }
        bq.n mViewBinding = roomDetailFragment.getMViewBinding();
        if (mViewBinding != null && (checkInAnimationView = mViewBinding.f16896t) != null) {
            checkInAnimationView.upDateState(1);
        }
        bq.n mViewBinding2 = roomDetailFragment.getMViewBinding();
        if (mViewBinding2 == null || (toolBarCheckInAnimationView = mViewBinding2.f16894r) == null) {
            return;
        }
        toolBarCheckInAnimationView.upDateState(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(RoomDetailFragment roomDetailFragment, ActivityResult it) {
        Intrinsics.h(it, "it");
        if (it.getResultCode() == -1) {
            roomDetailFragment.D0();
        }
    }

    private final void N0() {
        bq.n mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(mViewBinding.f16888l.f16824d, mViewBinding.f16902z, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.transsion.room.fragment.s
                @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
                public final void onConfigureTab(TabLayout.Tab tab, int i11) {
                    RoomDetailFragment.O0(RoomDetailFragment.this, tab, i11);
                }
            });
            mViewBinding.f16888l.f16824d.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new b());
            if (mViewBinding.f16902z.getAdapter() != null) {
                tabLayoutMediator.attach();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(RoomDetailFragment roomDetailFragment, TabLayout.Tab tab, int i11) {
        Intrinsics.h(tab, "tab");
        TextView textView = new TextView(roomDetailFragment.requireContext());
        String[] strArr = {roomDetailFragment.getString(R$string.hot), roomDetailFragment.getString(R$string.s_new)};
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[0]}, new int[]{androidx.core.content.b.getColor(roomDetailFragment.requireContext(), R$color.text_01), androidx.core.content.b.getColor(roomDetailFragment.requireContext(), R$color.text_02)});
        textView.setText(strArr[i11]);
        textView.setGravity(17);
        textView.setTextSize(14.0f);
        textView.setTextColor(colorStateList);
        tab.setCustomView(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(RoomDetailFragment roomDetailFragment, View view) {
        FragmentActivity activity = roomDetailFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(RoomDetailFragment roomDetailFragment, RoomItem roomItem) {
        roomDetailFragment.showContentView();
        if (roomItem == null) {
            PageStatusFragment.showEmptyView$default(roomDetailFragment, false, 1, null);
        } else {
            roomDetailFragment.c1(roomItem);
            roomDetailFragment.netResultSuccess = true;
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(RoomDetailFragment roomDetailFragment, RoomNet roomNet) {
        ToolBarCheckInAnimationView toolBarCheckInAnimationView;
        CheckInAnimationView checkInAnimationView;
        CheckInAnimationView checkInAnimationView2;
        ToolBarCheckInAnimationView toolBarCheckInAnimationView2;
        CheckInAnimationView checkInAnimationView3;
        ToolBarCheckInAnimationView toolBarCheckInAnimationView3;
        if (roomNet == null) {
            if (roomDetailFragment.state == CollapsingToolbarLayoutState.INTERNEDIATE) {
                bq.n mViewBinding = roomDetailFragment.getMViewBinding();
                if (mViewBinding != null && (toolBarCheckInAnimationView3 = mViewBinding.f16894r) != null) {
                    toolBarCheckInAnimationView3.setVisibility(0);
                }
            } else {
                bq.n mViewBinding2 = roomDetailFragment.getMViewBinding();
                if (mViewBinding2 != null && (checkInAnimationView2 = mViewBinding2.f16896t) != null) {
                    checkInAnimationView2.setVisibility(0);
                }
            }
            bq.n mViewBinding3 = roomDetailFragment.getMViewBinding();
            if (mViewBinding3 != null && (checkInAnimationView3 = mViewBinding3.f16896t) != null) {
                checkInAnimationView3.upDateState(1);
            }
            bq.n mViewBinding4 = roomDetailFragment.getMViewBinding();
            if (mViewBinding4 != null && (toolBarCheckInAnimationView2 = mViewBinding4.f16894r) != null) {
                toolBarCheckInAnimationView2.upDateState(1);
            }
        } else {
            RoomItem roomItem = roomDetailFragment.mRoomDetailItem;
            if (roomItem != null) {
                roomItem.setHasJoin(Boolean.TRUE);
            }
            bq.n mViewBinding5 = roomDetailFragment.getMViewBinding();
            if (mViewBinding5 != null && (checkInAnimationView = mViewBinding5.f16896t) != null) {
                checkInAnimationView.upDateState(3);
            }
            bq.n mViewBinding6 = roomDetailFragment.getMViewBinding();
            if (mViewBinding6 != null && (toolBarCheckInAnimationView = mViewBinding6.f16894r) != null) {
                toolBarCheckInAnimationView.upDateState(3);
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(RoomDetailFragment roomDetailFragment, RoomNet roomNet) {
        if (roomNet != null) {
            roomDetailFragment.D0();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi T0() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    private final void U0() {
        bq.n mViewBinding;
        PublishStateView publishStateView;
        RoomItem roomItem = this.mRoomDetailItem;
        if (roomItem == null || (mViewBinding = getMViewBinding()) == null || (publishStateView = mViewBinding.f16884h) == null) {
            return;
        }
        String str = this.mGroupId;
        String str2 = str == null ? "" : str;
        String avatar = roomItem.getAvatar();
        String str3 = avatar == null ? "" : avatar;
        String name = roomItem.getName();
        publishStateView.publishSource(4, (r19 & 2) != 0 ? "" : null, (r19 & 4) != 0 ? "" : null, (r19 & 8) != 0 ? "" : null, (r19 & 16) != 0 ? "" : null, (r19 & 32) != 0 ? "" : str2, (r19 & 64) != 0 ? "" : name == null ? "" : name, (r19 & 128) == 0 ? str3 : "", (r19 & 256) != 0 ? false : false);
    }

    private final void V0() {
        AppCompatImageView appCompatImageView;
        bq.n mViewBinding = getMViewBinding();
        if (mViewBinding == null || (appCompatImageView = mViewBinding.f16887k) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoomDetailFragment.W0(RoomDetailFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(RoomDetailFragment roomDetailFragment, View view) {
        ShareDialogFragment a11;
        ShareDialogFragment shareDialogFragment;
        ShareDialogFragment.Companion companion = ShareDialogFragment.INSTANCE;
        PostType postType = PostType.GROUP_TYPE;
        String str = roomDetailFragment.mGroupId;
        RoomItem roomItem = roomDetailFragment.mRoomDetailItem;
        String creatorId = roomItem != null ? roomItem.getCreatorId() : null;
        String value = ReportType.GROUP.getValue();
        RoomItem roomItem2 = roomDetailFragment.mRoomDetailItem;
        a11 = companion.a(postType, str, creatorId, value, (r29 & 16) != 0 ? "" : roomItem2 != null ? roomItem2.getName() : null, (r29 & 32) != 0 ? "" : "", (r29 & 64) != 0 ? false : false, (r29 & 128) != 0 ? false : false, (r29 & 256) != 0 ? false : false, "groupdetail", (r29 & 1024) != 0 ? "" : null, (r29 & 2048) != 0 ? "" : null);
        roomDetailFragment.mShareDialog = a11;
        if (a11 != null) {
            a11.G0(new e());
        }
        FragmentManager childFragmentManager = roomDetailFragment.getChildFragmentManager();
        childFragmentManager.g0();
        ShareDialogFragment shareDialogFragment2 = roomDetailFragment.mShareDialog;
        if ((shareDialogFragment2 == null || !shareDialogFragment2.isAdded()) && childFragmentManager.k0("share") == null && (shareDialogFragment = roomDetailFragment.mShareDialog) != null) {
            shareDialogFragment.show(childFragmentManager, "share");
        }
        com.transsion.baselib.helper.a.f43316a.h("groupdetail", "share", (r16 & 4) != 0 ? "" : roomDetailFragment.mGroupId, (r16 & 8) != 0 ? "" : null, (r16 & 16) != 0 ? "" : null, (r16 & 32) != 0 ? null : null);
    }

    private final void X0(View tvCheckIn, TextView tvEdit) {
        ToolBarCheckInAnimationView toolBarCheckInAnimationView;
        CheckInAnimationView checkInAnimationView;
        ToolBarCheckInAnimationView toolBarCheckInAnimationView2;
        CheckInAnimationView checkInAnimationView2;
        UserInfo i11;
        RoomItem roomItem = this.mRoomDetailItem;
        if (!TextUtils.isEmpty(roomItem != null ? roomItem.getCreatorId() : null)) {
            ILoginApi loginApi = getLoginApi();
            String userId = (loginApi == null || (i11 = loginApi.i()) == null) ? null : i11.getUserId();
            RoomItem roomItem2 = this.mRoomDetailItem;
            if (TextUtils.equals(userId, roomItem2 != null ? roomItem2.getCreatorId() : null)) {
                if (tvCheckIn != null) {
                    jg.c.g(tvCheckIn);
                }
                if (tvEdit != null) {
                    jg.c.k(tvEdit);
                }
                if (tvEdit != null) {
                    tvEdit.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.h
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            RoomDetailFragment.Y0(RoomDetailFragment.this, view);
                        }
                    });
                    return;
                }
                return;
            }
        }
        if (tvCheckIn != null) {
            jg.c.k(tvCheckIn);
        }
        if (tvEdit != null) {
            jg.c.g(tvEdit);
        }
        RoomItem roomItem3 = this.mRoomDetailItem;
        if (roomItem3 != null ? Intrinsics.c(roomItem3.getHasJoin(), Boolean.TRUE) : false) {
            bq.n mViewBinding = getMViewBinding();
            if (mViewBinding != null && (checkInAnimationView2 = mViewBinding.f16896t) != null) {
                checkInAnimationView2.upDateState(3);
            }
            bq.n mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (toolBarCheckInAnimationView2 = mViewBinding2.f16894r) == null) {
                return;
            }
            toolBarCheckInAnimationView2.upDateState(3);
            return;
        }
        bq.n mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (checkInAnimationView = mViewBinding3.f16896t) != null) {
            checkInAnimationView.upDateState(1);
        }
        bq.n mViewBinding4 = getMViewBinding();
        if (mViewBinding4 == null || (toolBarCheckInAnimationView = mViewBinding4.f16894r) == null) {
            return;
        }
        toolBarCheckInAnimationView.upDateState(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(RoomDetailFragment roomDetailFragment, View view) {
        Intent intent = new Intent(roomDetailFragment.requireActivity(), (Class<?>) CreateRoomActivity.class);
        intent.putExtra("field_key", roomDetailFragment.mRoomDetailItem);
        intent.putExtra("field_type", "type_edit");
        androidx.activity.result.b bVar = roomDetailFragment.updateInfoLaunch;
        if (bVar != null) {
            bVar.a(intent);
        }
        com.transsion.baselib.helper.a.f43316a.h("groupdetail", "edit_room", (r16 & 4) != 0 ? "" : roomDetailFragment.mGroupId, (r16 & 8) != 0 ? "" : null, (r16 & 16) != 0 ? "" : null, (r16 & 32) != 0 ? null : null);
    }

    private final void Z0(String coverUrl) {
        ExpandView expandView;
        ShapeableImageView shapeableImageView;
        ViewGroup.LayoutParams layoutParams;
        bq.n mViewBinding = getMViewBinding();
        Integer valueOf = (mViewBinding == null || (shapeableImageView = mViewBinding.f16886j) == null || (layoutParams = shapeableImageView.getLayoutParams()) == null) ? null : Integer.valueOf(layoutParams.width);
        f.a aVar = ej.f.f62005a;
        String e11 = f.a.e(aVar, coverUrl, valueOf != null ? valueOf.intValue() : 0, false, false, 12, null);
        bq.n mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null) {
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            f.b g11 = aVar.m(requireContext).g(coverUrl);
            ShapeableImageView ivRoomCover = mViewBinding2.f16886j;
            Intrinsics.g(ivRoomCover, "ivRoomCover");
            g11.d(ivRoomCover);
            Context requireContext2 = requireContext();
            Intrinsics.g(requireContext2, "requireContext(...)");
            f.b g12 = aVar.m(requireContext2).g(coverUrl);
            ShapeableImageView ivCoverSmall = mViewBinding2.f16883g;
            Intrinsics.g(ivCoverSmall, "ivCoverSmall");
            g12.d(ivCoverSmall);
        }
        Glide.with(requireContext()).asBitmap().load2(e11).into((RequestBuilder<Bitmap>) new CustomTarget() { // from class: com.transsion.room.fragment.RoomDetailFragment$showCover$2
            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable drawable) {
            }

            @Override // com.bumptech.glide.request.target.Target
            public void onResourceReady(Bitmap resource, Transition transition) {
                Intrinsics.h(resource, "resource");
                a.C0856a.f(lg.a.f68962a, "RoomDetailFragment", NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, false, 4, null);
                kotlinx.coroutines.k.d(androidx.view.v.a(RoomDetailFragment.this), kotlinx.coroutines.y0.c(), null, new RoomDetailFragment$showCover$2$onResourceReady$1(resource, RoomDetailFragment.this, null), 2, null);
            }
        });
        bq.n mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (expandView = mViewBinding3.f16899w) == null) {
            return;
        }
        expandView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.transsion.room.fragment.j
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                RoomDetailFragment.a1(RoomDetailFragment.this, view, i11, i12, i13, i14, i15, i16, i17, i18);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(RoomDetailFragment roomDetailFragment, View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        bq.n mViewBinding = roomDetailFragment.getMViewBinding();
        if (mViewBinding != null) {
            ViewGroup.LayoutParams layoutParams = mViewBinding.f16879c.getLayoutParams();
            int i19 = i14 - i12;
            int i20 = i18 - i16;
            if (layoutParams != null) {
                layoutParams.height += i19 - i20;
            }
            mViewBinding.f16879c.setLayoutParams(layoutParams);
        }
    }

    private final void b1() {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        Long postCount;
        PileLayout pileLayout;
        List<String> memberAvatars;
        List<String> memberAvatars2;
        PileLayout pileLayout2;
        bq.n mViewBinding = getMViewBinding();
        if (mViewBinding != null && (pileLayout2 = mViewBinding.f16889m) != null) {
            pileLayout2.removeAllViews();
        }
        RoomItem roomItem = this.mRoomDetailItem;
        int size = (roomItem == null || (memberAvatars2 = roomItem.getMemberAvatars()) == null) ? 0 : memberAvatars2.size();
        for (int i11 = 0; i11 < size; i11++) {
            RoomItem roomItem2 = this.mRoomDetailItem;
            String str = (roomItem2 == null || (memberAvatars = roomItem2.getMemberAvatars()) == null) ? null : memberAvatars.get(i11);
            ShapeableImageView shapeableImageView = new ShapeableImageView(getContext());
            shapeableImageView.setShapeAppearanceModel(this.shapeModel);
            if (str != null) {
                f.a aVar = ej.f.f62005a;
                Context requireContext = requireContext();
                Intrinsics.g(requireContext, "requireContext(...)");
                aVar.m(requireContext).g(str).i(R$drawable.ic_avatar_default).m(this.sz).c(this.sz).d(shapeableImageView);
            }
            bq.n mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (pileLayout = mViewBinding2.f16889m) != null) {
                int i12 = this.sz;
                pileLayout.addView(shapeableImageView, i12, i12);
            }
        }
        RoomItem roomItem3 = this.mRoomDetailItem;
        long longValue = (roomItem3 == null || (postCount = roomItem3.getPostCount()) == null) ? 0L : postCount.longValue();
        if (longValue > 0) {
            bq.n mViewBinding3 = getMViewBinding();
            if (mViewBinding3 != null && (appCompatTextView2 = mViewBinding3.f16898v) != null) {
                jg.c.k(appCompatTextView2);
            }
            bq.n mViewBinding4 = getMViewBinding();
            if (mViewBinding4 == null || (appCompatTextView = mViewBinding4.f16898v) == null) {
                return;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
            String string = getString(R$string.member_count_check_in);
            Intrinsics.g(string, "getString(...)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(longValue)}, 1));
            Intrinsics.g(format, "format(...)");
            appCompatTextView.setText(format);
        }
    }

    private final void c1(RoomItem roomItem) {
        HashMap g11;
        String avatar;
        ExpandView expandView;
        AppCompatTextView appCompatTextView;
        this.mRoomDetailItem = roomItem;
        if (TextUtils.equals(roomItem.getLevel(), "LIMIT") && com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("adult_restricted", true)) {
            new AdultRestrictedDialogFragment().show(requireActivity().getSupportFragmentManager(), "AdultRestrictedDialogFragment");
        }
        bq.n mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatTextView = mViewBinding.f16900x) != null) {
            appCompatTextView.setText(roomItem.getName());
        }
        bq.n mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (expandView = mViewBinding2.f16899w) != null) {
            RoomItem roomItem2 = this.mRoomDetailItem;
            expandView.m(roomItem2 != null ? roomItem2.getDescription() : null);
        }
        CollapsingToolbarLayoutState collapsingToolbarLayoutState = this.state;
        if (collapsingToolbarLayoutState == CollapsingToolbarLayoutState.INTERNEDIATE || collapsingToolbarLayoutState == CollapsingToolbarLayoutState.COLLAPSED) {
            bq.n mViewBinding3 = getMViewBinding();
            ToolBarCheckInAnimationView toolBarCheckInAnimationView = mViewBinding3 != null ? mViewBinding3.f16894r : null;
            bq.n mViewBinding4 = getMViewBinding();
            X0(toolBarCheckInAnimationView, mViewBinding4 != null ? mViewBinding4.f16895s : null);
        } else {
            bq.n mViewBinding5 = getMViewBinding();
            CheckInAnimationView checkInAnimationView = mViewBinding5 != null ? mViewBinding5.f16896t : null;
            bq.n mViewBinding6 = getMViewBinding();
            X0(checkInAnimationView, mViewBinding6 != null ? mViewBinding6.f16897u : null);
        }
        b1();
        RoomItem roomItem3 = this.mRoomDetailItem;
        if (roomItem3 != null && (avatar = roomItem3.getAvatar()) != null) {
            Z0(avatar);
        }
        N0();
        E0().v(roomItem);
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        hj.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (g11 = logViewConfig2.g()) != null) {
            RoomItem roomItem4 = this.mRoomDetailItem;
            g11.put("group_id", roomItem4 != null ? roomItem4.getGroupId() : null);
        }
        V0();
        U0();
    }

    private final boolean checkLogin() {
        Intent o11;
        androidx.activity.result.b bVar;
        ILoginApi loginApi = getLoginApi();
        if (loginApi == null || loginApi.a()) {
            return true;
        }
        if (this.loginLaunch == null) {
            this.isNeedShowLoginActivity = true;
        }
        Context context = getContext();
        if (context == null || (o11 = loginApi.o(context)) == null || (bVar = this.loginLaunch) == null) {
            return false;
        }
        bVar.a(o11);
        return false;
    }

    private final ILoginApi getLoginApi() {
        return (ILoginApi) this.loginApi.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public bq.n getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        bq.n c11 = bq.n.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        final ToolBarCheckInAnimationView toolBarCheckInAnimationView;
        final CheckInAnimationView checkInAnimationView;
        this.loginLaunch = registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: com.transsion.room.fragment.k
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                RoomDetailFragment.L0(RoomDetailFragment.this, (ActivityResult) obj);
            }
        });
        this.updateInfoLaunch = registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: com.transsion.room.fragment.l
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                RoomDetailFragment.M0(RoomDetailFragment.this, (ActivityResult) obj);
            }
        });
        bq.n mViewBinding = getMViewBinding();
        if (mViewBinding != null && (checkInAnimationView = mViewBinding.f16896t) != null) {
            checkInAnimationView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomDetailFragment.J0(RoomDetailFragment.this, checkInAnimationView, view);
                }
            });
        }
        bq.n mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (toolBarCheckInAnimationView = mViewBinding2.f16894r) != null) {
            toolBarCheckInAnimationView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomDetailFragment.K0(RoomDetailFragment.this, toolBarCheckInAnimationView, view);
                }
            });
        }
        U0();
        V0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        AppCompatImageView appCompatImageView;
        Toolbar toolbar;
        pageStateFitStatusBar();
        bq.n mViewBinding = getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (mViewBinding == null || (toolbar = mViewBinding.f16891o) == null) ? null : toolbar.getLayoutParams();
        if (layoutParams instanceof CollapsingToolbarLayout.c) {
            ((FrameLayout.LayoutParams) ((CollapsingToolbarLayout.c) layoutParams)).topMargin = com.blankj.utilcode.util.d.c();
        }
        bq.n mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (appCompatImageView = mViewBinding2.f16882f) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomDetailFragment.P0(RoomDetailFragment.this, view);
                }
            });
        }
        bq.n mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null) {
            mViewBinding3.f16902z.setAdapter(new com.transsion.room.adapter.c(this.mGroupId, this));
            mViewBinding3.f16902z.registerOnPageChangeCallback(new c());
            N0();
        }
        H0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        RoomDetailViewModel E0 = E0();
        E0.q().j(this, new d(new Function1() { // from class: com.transsion.room.fragment.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Q0;
                Q0 = RoomDetailFragment.Q0(RoomDetailFragment.this, (RoomItem) obj);
                return Q0;
            }
        }));
        E0.s().j(this, new d(new Function1() { // from class: com.transsion.room.fragment.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit R0;
                R0 = RoomDetailFragment.R0(RoomDetailFragment.this, (RoomNet) obj);
                return R0;
            }
        }));
        E0.t().j(this, new d(new Function1() { // from class: com.transsion.room.fragment.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit S0;
                S0 = RoomDetailFragment.S0(RoomDetailFragment.this, (RoomNet) obj);
                return S0;
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void loadDefaultData() {
        showLoadingView();
        D0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public hj.b newLogViewConfig() {
        return new hj.b("groupdetail", false, 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            D0();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String groupId;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        String str = null;
        RoomItem roomItem = arguments != null ? (RoomItem) arguments.getParcelable(WebConstants.FIELD_ITEM) : null;
        if (roomItem == null || (groupId = roomItem.getGroupId()) == null) {
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                str = arguments2.getString("id");
            }
        } else {
            str = groupId;
        }
        this.mGroupId = str;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
    }
}
