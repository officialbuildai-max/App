package com.transsion.player.longvideo.member;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.view.LifecycleCoroutineScope;
import androidx.view.v;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.transsion.ad.strategy.r;
import com.transsion.player.longvideo.R$id;
import com.transsion.player.longvideo.R$layout;
import com.transsion.player.longvideo.R$string;
import com.transsion.player.longvideo.ui.LongVodPlayerView;
import com.transsion.push.PushConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J;\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\f¢\u0006\u0004\b \u0010\u000eJ\r\u0010!\u001a\u00020\f¢\u0006\u0004\b!\u0010\u000eR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/transsion/player/longvideo/member/LongVodResolutionMemberTipView;", "Landroid/widget/FrameLayout;", "Lcom/transsion/ad/strategy/r$a;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "getClassTag", "()Ljava/lang/String;", "", "e", "()V", "", "isVisible", "onVisibilityChanged", "(Z)V", "Landroid/view/View;", "getVisibilityView", "()Landroid/view/View;", "hasAtLeast720P", "Lgo/a;", "curBean", "pageName", "Lcom/transsion/player/longvideo/ui/LongVodPlayerView;", "longVodPlayerView", "", "target", "showResolutionTip", "(ZLgo/a;Ljava/lang/String;Lcom/transsion/player/longvideo/ui/LongVodPlayerView;Ljava/lang/Integer;)V", PushConstants.PROVIDER_FIELD_DESTROY, "onShowComplete", "a", "Lcom/transsion/player/longvideo/ui/LongVodPlayerView;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "c", "Ljava/lang/Integer;", "d", "Lgo/a;", "Z", "isShowing", "", "f", "J", "currentTimestep", "Landroid/os/Handler;", be.g.f16474b, "Landroid/os/Handler;", "handler", "LongVideo_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class LongVodResolutionMemberTipView extends FrameLayout implements r.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private LongVodPlayerView longVodPlayerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String pageName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Integer target;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private go.a curBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isShowing;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long currentTimestep;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Handler handler;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public LongVodResolutionMemberTipView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LongVodResolutionMemberTipView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        this.handler = new Handler(Looper.getMainLooper());
        View inflate = LayoutInflater.from(context).inflate(R$layout.long_vod_resolution_member_tip_layout, (ViewGroup) this, false);
        addView(inflate);
        TextView textView = (TextView) inflate.findViewById(R$id.tvRewardTip);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.member.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LongVodResolutionMemberTipView.c(LongVodResolutionMemberTipView.this, context, view);
                }
            });
        }
        ImageView imageView = (ImageView) inflate.findViewById(R$id.ivCloseTip);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.member.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LongVodResolutionMemberTipView.d(LongVodResolutionMemberTipView.this, view);
                }
            });
        }
        TextView textView2 = (TextView) inflate.findViewById(R$id.tvTipText);
        if (textView2 != null) {
            String string = context.getString(R$string.long_vod_switch_to_720p_1080p, q.f48287a.d());
            Intrinsics.g(string, "getString(...)");
            textView2.setText(string);
        }
    }

    public /* synthetic */ LongVodResolutionMemberTipView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LongVodResolutionMemberTipView longVodResolutionMemberTipView, Context context, View view) {
        LifecycleCoroutineScope a11;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", "go_ad_free");
        go.a aVar = longVodResolutionMemberTipView.curBean;
        linkedHashMap.put("subject_id", aVar != null ? aVar.o() : null);
        hj.i iVar = hj.i.f64628a;
        String str = longVodResolutionMemberTipView.pageName;
        if (str == null) {
            str = "vip_resolution";
        }
        iVar.p(str, linkedHashMap);
        ok.c.f71157a.a(longVodResolutionMemberTipView.getClassTag() + " --> tvRewardTip.setOnClickListener{} --> target = " + longVodResolutionMemberTipView.target);
        LongVodPlayerView longVodPlayerView = longVodResolutionMemberTipView.longVodPlayerView;
        if (longVodPlayerView != null) {
            longVodPlayerView.showResolutionIntercept(new go.b(false, String.valueOf(longVodResolutionMemberTipView.target), null, 5, null), "LongVodResolutionMemberTipView");
        }
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null || (a11 = v.a(appCompatActivity)) == null) {
            return;
        }
        kotlinx.coroutines.k.d(a11, null, null, new LongVodResolutionMemberTipView$1$1(longVodResolutionMemberTipView, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LongVodResolutionMemberTipView longVodResolutionMemberTipView, View view) {
        longVodResolutionMemberTipView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        this.handler.post(new Runnable() { // from class: com.transsion.player.longvideo.member.LongVodResolutionMemberTipView$startTimer$timerRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                boolean z10;
                long j11;
                Handler handler;
                LifecycleCoroutineScope a11;
                long j12;
                z10 = LongVodResolutionMemberTipView.this.isShowing;
                if (z10) {
                    LongVodResolutionMemberTipView longVodResolutionMemberTipView = LongVodResolutionMemberTipView.this;
                    j12 = longVodResolutionMemberTipView.currentTimestep;
                    longVodResolutionMemberTipView.currentTimestep = j12 + 100;
                }
                j11 = LongVodResolutionMemberTipView.this.currentTimestep;
                if (j11 < 5000) {
                    handler = LongVodResolutionMemberTipView.this.handler;
                    handler.postDelayed(this, 100L);
                    return;
                }
                LongVodResolutionMemberTipView.this.destroy();
                LongVodResolutionMemberTipView.this.setVisibility(8);
                Context context = LongVodResolutionMemberTipView.this.getContext();
                AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
                if (appCompatActivity == null || (a11 = v.a(appCompatActivity)) == null) {
                    return;
                }
                kotlinx.coroutines.k.d(a11, null, null, new LongVodResolutionMemberTipView$startTimer$timerRunnable$1$run$1(LongVodResolutionMemberTipView.this, null), 3, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = LongVodResolutionMemberTipView.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final void destroy() {
        r.f42294a.n(this);
        this.handler.removeCallbacksAndMessages(null);
    }

    @Override // com.transsion.ad.strategy.r.a
    public double getVisibilityThreshold() {
        return r.a.C0598a.a(this);
    }

    @Override // com.transsion.ad.strategy.r.a
    public View getVisibilityView() {
        return this;
    }

    public final void onShowComplete() {
        LifecycleCoroutineScope a11;
        Context context = getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null || (a11 = v.a(appCompatActivity)) == null) {
            return;
        }
        kotlinx.coroutines.k.d(a11, null, null, new LongVodResolutionMemberTipView$onShowComplete$1(this, null), 3, null);
    }

    @Override // com.transsion.ad.strategy.r.a
    public void onVisibilityChanged(boolean isVisible) {
        this.isShowing = isVisible;
    }

    public final void showResolutionTip(boolean hasAtLeast720P, go.a curBean, String pageName, LongVodPlayerView longVodPlayerView, Integer target) {
        LifecycleCoroutineScope a11;
        Intrinsics.h(longVodPlayerView, "longVodPlayerView");
        if (curBean == null) {
            return;
        }
        this.pageName = pageName;
        this.longVodPlayerView = longVodPlayerView;
        this.target = target;
        Context context = getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null || (a11 = v.a(appCompatActivity)) == null) {
            return;
        }
        kotlinx.coroutines.k.d(a11, null, null, new LongVodResolutionMemberTipView$showResolutionTip$1(curBean, this, hasAtLeast720P, target, null), 3, null);
    }
}
