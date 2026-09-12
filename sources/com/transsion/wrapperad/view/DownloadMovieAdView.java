package com.transsion.wrapperad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.view.LifecycleCoroutineScope;
import androidx.view.v;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.transsion.ad.bidding.icon.BiddingIconAdManager;
import com.transsion.ad.bidding.icon.BiddingWrapperIconBean;
import com.transsion.ad.bidding.icon.BiddingWrapperIconView;
import com.transsion.wrapperad.R$id;
import com.transsion.wrapperad.R$layout;
import com.transsion.wrapperad.R$mipmap;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b\u0016\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/transsion/wrapperad/view/DownloadMovieAdView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "Lcom/transsion/ad/bidding/icon/BiddingWrapperIconBean;", "data", "", "c", "(Ljava/util/List;)V", "", "genre", "loadAd", "(Ljava/lang/String;)V", "download", "()V", "onDestroy", "a", "Lcom/transsion/ad/bidding/icon/BiddingWrapperIconBean;", "wrapperIconBean", "Lfy/b;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lfy/b;", "viewBinderProvider", "Lcom/transsion/ad/bidding/icon/BiddingWrapperIconView;", "Lcom/transsion/ad/bidding/icon/BiddingWrapperIconView;", "iconView", "Lcom/transsion/ad/bidding/icon/BiddingIconAdManager;", "d", "Lcom/transsion/ad/bidding/icon/BiddingIconAdManager;", "adManager", "", "e", "Z", "isChecked", "Ldi/a;", "f", "Ldi/a;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "wrapperad_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class DownloadMovieAdView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private BiddingWrapperIconBean wrapperIconBean;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final fy.b viewBinderProvider;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private BiddingWrapperIconView iconView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private BiddingIconAdManager adManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isChecked;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final di.a listener;

    /* loaded from: classes7.dex */
    public static final class a extends di.a {
        a() {
        }

        @Override // di.a
        public void w(List list) {
            super.w(list);
            DownloadMovieAdView.this.c(list);
            if (list == null || !(!list.isEmpty())) {
                return;
            }
            DownloadMovieAdView.this.setVisibility(0);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DownloadMovieAdView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DownloadMovieAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DownloadMovieAdView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.h(context, "context");
        this.viewBinderProvider = new fy.b(context);
        this.adManager = new BiddingIconAdManager();
        this.isChecked = true;
        this.listener = new a();
        View inflate = LayoutInflater.from(context).inflate(R$layout.view_download_movie_ad_layout, (ViewGroup) this, false);
        addView(inflate);
        setVisibility(8);
        this.iconView = (BiddingWrapperIconView) inflate.findViewById(R$id.iconView);
        final ImageView imageView = (ImageView) inflate.findViewById(R$id.ivCheck);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.wrapperad.view.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadMovieAdView.b(DownloadMovieAdView.this, imageView, view);
                }
            });
        }
    }

    public /* synthetic */ DownloadMovieAdView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DownloadMovieAdView downloadMovieAdView, ImageView imageView, View view) {
        boolean z10 = downloadMovieAdView.isChecked;
        downloadMovieAdView.isChecked = !z10;
        imageView.setImageResource(!z10 ? R$mipmap.ad_check_oval_2 : R$mipmap.ad_check_oval_1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(List data) {
        BiddingWrapperIconView biddingWrapperIconView;
        List list = data;
        if (list == null || list.isEmpty()) {
            return;
        }
        BiddingWrapperIconBean biddingWrapperIconBean = (BiddingWrapperIconBean) data.get(0);
        this.wrapperIconBean = biddingWrapperIconBean;
        if (biddingWrapperIconBean == null || (biddingWrapperIconView = this.iconView) == null) {
            return;
        }
        biddingWrapperIconView.showData(this.adManager, biddingWrapperIconBean, this.viewBinderProvider);
    }

    public static /* synthetic */ void loadAd$default(DownloadMovieAdView downloadMovieAdView, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        downloadMovieAdView.loadAd(str);
    }

    public final void download() {
        BiddingWrapperIconView biddingWrapperIconView;
        if (!this.isChecked || (biddingWrapperIconView = this.iconView) == null) {
            return;
        }
        biddingWrapperIconView.onClick(this.wrapperIconBean, this.viewBinderProvider);
    }

    public final void loadAd(String genre) {
        LifecycleCoroutineScope a11;
        Context context = getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null || (a11 = v.a(appCompatActivity)) == null) {
            return;
        }
        kotlinx.coroutines.k.d(a11, null, null, new DownloadMovieAdView$loadAd$1(this, genre, null), 3, null);
    }

    public final void onDestroy() {
        this.adManager.I();
    }
}
