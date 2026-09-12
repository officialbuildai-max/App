package com.transsion.home.activity;

import ak.x;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.therouter.TheRouter;
import com.tn.lib.view.GradientLinePagerIndicator;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.report.g;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.baseui.util.f;
import com.transsion.baseui.widget.CustomPagerTitleView;
import com.transsion.home.R$mipmap;
import com.transsion.home.R$string;
import com.transsion.home.activity.MovieFilterActivity;
import com.transsion.home.bean.AppTab;
import com.transsion.home.bean.HomeTabItem;
import com.transsion.home.fragment.tab.MovieFragment;
import com.transsion.home.p004enum.HomeTabId;
import com.transsion.home.p004enum.HomeTabType;
import com.transsion.home.viewmodel.preload.PreloadTrendingData;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import j00.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import oh.h;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010\u0005J\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b.\u0010,R\u001a\u00104\u001a\b\u0012\u0004\u0012\u000201008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/transsion/home/activity/MovieFilterActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lgl/c;", "Lcom/transsion/baselib/report/g;", "<init>", "()V", "", "j0", "", "tabId", "", "o0", "(Ljava/lang/Integer;)Z", "m0", "n0", "r0", "(I)V", "h0", "(I)I", "q0", "p0", "isTranslucent", "()Z", "isStatusDark", "i0", "()Lgl/c;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "initView", "retryLoadData", "", "getPageName", "()Ljava/lang/String;", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "a", "I", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Z", "showViewPager", "c", "Ljava/lang/String;", "tabCode", "d", "mFilterJson", "", "Lcom/transsion/home/bean/HomeTabItem;", "e", "Ljava/util/List;", "tabItems", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class MovieFilterActivity extends BaseActivity<gl.c> implements g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int tabId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public String mFilterJson;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public boolean showViewPager = true;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public String tabCode = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final List tabItems = new ArrayList();

    /* loaded from: classes5.dex */
    public static final class a extends FragmentStateAdapter {
        a() {
            super(MovieFilterActivity.this);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i11) {
            MovieFilterActivity movieFilterActivity = MovieFilterActivity.this;
            int i12 = movieFilterActivity.tabId;
            Integer tabId = ((HomeTabItem) movieFilterActivity.tabItems.get(i11)).getTabId();
            String str = (tabId != null && i12 == tabId.intValue()) ? MovieFilterActivity.this.mFilterJson : null;
            MovieFragment.Companion companion = MovieFragment.INSTANCE;
            Integer tabId2 = ((HomeTabItem) MovieFilterActivity.this.tabItems.get(i11)).getTabId();
            return companion.a(tabId2 != null ? tabId2.intValue() : 2, true, str, ((HomeTabItem) MovieFilterActivity.this.tabItems.get(i11)).getTabCode());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return MovieFilterActivity.this.tabItems.size();
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends ViewPager2.OnPageChangeCallback {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            super.onPageScrollStateChanged(i11);
            ((gl.c) MovieFilterActivity.this.getMViewBinding()).f63770b.onPageScrollStateChanged(i11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            super.onPageScrolled(i11, f11, i12);
            ((gl.c) MovieFilterActivity.this.getMViewBinding()).f63770b.onPageScrolled(i11, f11, i12);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            ((gl.c) MovieFilterActivity.this.getMViewBinding()).f63770b.onPageSelected(i11);
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends j00.a {

        /* loaded from: classes5.dex */
        public static final class a extends f {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ MovieFilterActivity f44284e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f44285f;

            a(MovieFilterActivity movieFilterActivity, int i11) {
                this.f44284e = movieFilterActivity;
                this.f44285f = i11;
            }

            @Override // com.transsion.baseui.util.f
            public void c(View view) {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.transsion.baseui.util.f
            public void d(View view) {
                ((gl.c) this.f44284e.getMViewBinding()).f63772d.setCurrentItem(this.f44285f, false);
                ((gl.c) this.f44284e.getMViewBinding()).f63770b.onPageScrolled(this.f44285f, 0.0f, 0);
            }
        }

        c() {
        }

        @Override // j00.a
        public int a() {
            return MovieFilterActivity.this.tabItems.size();
        }

        @Override // j00.a
        public j00.c b(Context context) {
            GradientLinePagerIndicator gradientLinePagerIndicator = new GradientLinePagerIndicator(MovieFilterActivity.this);
            MovieFilterActivity movieFilterActivity = MovieFilterActivity.this;
            gradientLinePagerIndicator.setMode(2);
            gradientLinePagerIndicator.setLineHeight(com.transsion.usercenter.setting.labelsfeedback.a.b(3));
            gradientLinePagerIndicator.setLineWidth(com.transsion.usercenter.setting.labelsfeedback.a.b(24));
            gradientLinePagerIndicator.setRoundRadius(com.transsion.usercenter.setting.labelsfeedback.a.a(1.5f));
            gradientLinePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
            gradientLinePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
            int color = androidx.core.content.b.getColor(movieFilterActivity, R$color.white);
            gradientLinePagerIndicator.setColors(color, color, color);
            return gradientLinePagerIndicator;
        }

        @Override // j00.a
        public d c(Context context, int i11) {
            CustomPagerTitleView customPagerTitleView = new CustomPagerTitleView(MovieFilterActivity.this, 17, com.transsion.usercenter.setting.labelsfeedback.a.b(12));
            MovieFilterActivity movieFilterActivity = MovieFilterActivity.this;
            customPagerTitleView.setText(((HomeTabItem) movieFilterActivity.tabItems.get(i11)).getName());
            customPagerTitleView.setOnClickListener(new a(movieFilterActivity, i11));
            return customPagerTitleView;
        }
    }

    private final int h0(int tabId) {
        int size = this.tabItems.size();
        for (int i11 = 0; i11 < size; i11++) {
            Integer tabId2 = ((HomeTabItem) this.tabItems.get(i11)).getTabId();
            if (tabId2 != null && tabId2.intValue() == tabId) {
                return i11;
            }
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void j0() {
        List<HomeTabItem> homeTabs;
        PreloadTrendingData.a aVar = PreloadTrendingData.f45940n;
        AppTab appTab = (AppTab) aVar.a().D().f();
        if (appTab == null) {
            appTab = (AppTab) aVar.a().C().f();
        }
        this.tabItems.clear();
        if (!this.showViewPager || !o0(Integer.valueOf(this.tabId))) {
            this.tabItems.add(new HomeTabItem("", Integer.valueOf(this.tabId), "", "", this.tabCode, null, null, null, null, 480, null));
            MagicIndicator magicIndicator = ((gl.c) getMViewBinding()).f63770b;
            Intrinsics.g(magicIndicator, "magicIndicator");
            jg.c.g(magicIndicator);
            return;
        }
        if (appTab == null || (homeTabs = appTab.getHomeTabs()) == null) {
            return;
        }
        for (HomeTabItem homeTabItem : homeTabs) {
            if (Intrinsics.c(homeTabItem != null ? homeTabItem.getType() : null, HomeTabType.SUB_OPERATION.getValue()) && o0(homeTabItem.getTabId())) {
                this.tabItems.add(homeTabItem);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(MovieFilterActivity movieFilterActivity, View view) {
        yj.b bVar = (yj.b) yj.a.f79145a.a(yj.b.class);
        if (bVar != null) {
            bVar.c("", movieFilterActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(MovieFilterActivity movieFilterActivity, View view) {
        movieFilterActivity.q0();
        movieFilterActivity.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m0() {
        ((gl.c) getMViewBinding()).f63772d.setAdapter(new a());
        ((gl.c) getMViewBinding()).f63772d.registerOnPageChangeCallback(new b());
        r0(this.tabId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n0() {
        MagicIndicator magicIndicator = ((gl.c) getMViewBinding()).f63770b;
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(new c());
        magicIndicator.setNavigator(commonNavigator);
    }

    private final boolean o0(Integer tabId) {
        HomeTabId.Companion companion = HomeTabId.INSTANCE;
        int d11 = companion.d();
        if (tabId == null || tabId.intValue() != d11) {
            int f11 = companion.f();
            if (tabId == null || tabId.intValue() != f11) {
                int b11 = companion.b();
                if (tabId == null || tabId.intValue() != b11) {
                    return false;
                }
            }
        }
        return true;
    }

    private final void p0() {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "back_browse");
        hashMap.put("tabId", String.valueOf(this.tabId));
        com.transsion.baselib.helper.a.f43316a.e(getPageName(), hashMap);
    }

    private final void q0() {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "back_click");
        hashMap.put("tabId", String.valueOf(this.tabId));
        com.transsion.baselib.helper.a.f43316a.f(getPageName(), hashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r0(int tabId) {
        ((gl.c) getMViewBinding()).f63772d.setCurrentItem(h0(tabId), false);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "movie_filter_page";
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public gl.c getViewBinding() {
        gl.c c11 = gl.c.c(getLayoutInflater());
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity
    public void initView(Bundle savedInstanceState) {
        TitleLayout titleLayout = ((gl.c) getMViewBinding()).f63771c;
        titleLayout.setRightView(R$mipmap.ic_search_movie, new View.OnClickListener() { // from class: bl.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieFilterActivity.k0(MovieFilterActivity.this, view);
            }
        });
        titleLayout.setLeftOnclick(new View.OnClickListener() { // from class: bl.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MovieFilterActivity.l0(MovieFilterActivity.this, view);
            }
        });
        p0();
        String string = getString(R$string.filter);
        Intrinsics.g(string, "getString(...)");
        titleLayout.setTitleText(string);
        h hVar = h.f71144a;
        Context context = titleLayout.getContext();
        Intrinsics.g(context, "getContext(...)");
        titleLayout.setPadding(0, hVar.d(context), 0, 0);
        j0();
        n0();
        m0();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return !x.f733a.a();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public hj.b newLogViewConfig() {
        hj.b bVar = new hj.b(getPageName(), false, 2, null);
        bVar.l(true);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        TheRouter.l(this);
        super.onCreate(savedInstanceState);
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public void retryLoadData() {
    }
}
