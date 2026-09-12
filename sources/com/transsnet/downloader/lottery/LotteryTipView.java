package com.transsnet.downloader.lottery;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.view.LifecycleCoroutineScope;
import androidx.view.v;
import com.cloud.tmc.integration.event.EventConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.bean.lottery.LotteryUserActivityInfoPriceItemsBean;
import com.transsion.bean.lottery.LotteryUserInfoEntity;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k;
import ok.c;
import py.i1;
import ti.p;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u000fR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/transsnet/downloader/lottery/LotteryTipView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "getClassTag", "()Ljava/lang/String;", "", "getLotteryUserInfoEntity", "()V", "", "e", "()Z", "onFragmentResume", "Lcom/transsion/bean/lottery/LotteryUserInfoEntity;", "a", "Lcom/transsion/bean/lottery/LotteryUserInfoEntity;", "lotteryUserInfoEntity", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Z", "isRequesting", "c", "isCountryEnable", "Lpy/i1;", "d", "Lpy/i1;", "binding", "Companion", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class LotteryTipView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private LotteryUserInfoEntity lotteryUserInfoEntity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isRequesting;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isCountryEnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final i1 binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LotteryTipView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LotteryTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LotteryTipView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.h(context, "context");
        this.isCountryEnable = true;
        i1 c11 = i1.c(LayoutInflater.from(context), this, true);
        Intrinsics.g(c11, "inflate(...)");
        this.binding = c11;
        c11.f72886b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.lottery.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LotteryTipView.c(LotteryTipView.this, view);
            }
        });
        c11.f72887c.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.lottery.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LotteryTipView.d(LotteryTipView.this, view);
            }
        });
    }

    public /* synthetic */ LotteryTipView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LotteryTipView lotteryTipView, View view) {
        List<LotteryUserActivityInfoPriceItemsBean> priceItems;
        lotteryTipView.setVisibility(8);
        LotteryUserInfoEntity lotteryUserInfoEntity = lotteryTipView.lotteryUserInfoEntity;
        if (((lotteryUserInfoEntity == null || (priceItems = lotteryUserInfoEntity.getPriceItems()) == null) ? 0 : priceItems.size()) > 0) {
            com.transsion.baselib.report.launch.b.f43424a.b().putString("lottery_tip_close_date", p.f76389a.c());
            c.f71157a.a(lotteryTipView.getClassTag() + " --> ivClose 点击，有未领取奖品，当天不再展示");
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(6, 7);
        com.transsion.baselib.report.launch.b.f43424a.b().putString("lottery_tip_close_7day_expire_date", new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(calendar.getTime()));
        c.f71157a.a(lotteryTipView.getClassTag() + " --> ivClose 点击，无未领取奖品，7天内不再展示");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LotteryTipView lotteryTipView, View view) {
        Navigator.x(TheRouter.c("/rewards/center").K(EventConstants.KEY_SOURCE, "LotteryTipView"), null, null, 3, null);
        c.f71157a.a(lotteryTipView.getClassTag() + " --> 点击之后置空数据，因为不确定用户是否会领取奖品，重新进入需要重新加载数据");
        lotteryTipView.lotteryUserInfoEntity = null;
    }

    private final boolean e() {
        List<LotteryUserActivityInfoPriceItemsBean> priceItems;
        if (!this.isCountryEnable) {
            c.f71157a.a(getClassTag() + " --> isRequest() --> 当前国家不支持");
            return false;
        }
        LotteryUserInfoEntity lotteryUserInfoEntity = this.lotteryUserInfoEntity;
        if (((lotteryUserInfoEntity == null || (priceItems = lotteryUserInfoEntity.getPriceItems()) == null) ? 0 : priceItems.size()) > 0) {
            c.f71157a.a(getClassTag() + " --> isRequest() --> 已经有数据了");
            return false;
        }
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        String string = bVar.b().getString("lottery_tip_close_7day_expire_date", "");
        if (!(string == null || string.length() == 0) && new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Calendar.getInstance().getTime()).compareTo(string) < 0) {
            c.f71157a.a(getClassTag() + " --> isRequest() --> 7天自然日内不再展示");
            return false;
        }
        if (TextUtils.equals(p.f76389a.c(), bVar.b().getString("lottery_tip_close_date", ""))) {
            c.f71157a.a(getClassTag() + " --> onFragmentResume() --> 1天最多展示一次");
            return false;
        }
        if (!this.isRequesting) {
            this.isRequesting = true;
            return true;
        }
        c.f71157a.a(getClassTag() + " --> isRequest() --> 正在请求中");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = LotteryTipView.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final void getLotteryUserInfoEntity() {
        LifecycleCoroutineScope a11;
        Context context = getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null || (a11 = v.a(appCompatActivity)) == null) {
            return;
        }
        k.d(a11, null, null, new LotteryTipView$getLotteryUserInfoEntity$1(this, null), 3, null);
    }

    public final void onFragmentResume() {
        c.f71157a.a(getClassTag() + " --> onFragmentResume() --> 请求未领取奖品数据");
        if (e()) {
            getLotteryUserInfoEntity();
        }
    }
}
