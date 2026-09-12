package py;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLTextView;
import com.tn.lib.widget.TnTextView;
import com.transsion.ad.view.ScrollDetectFrameLayout;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.wrapperad.view.BiddingFloatingIrregularAnimationView;
import com.transsion.wrapperad.view.DownloadTopIrregularView;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.lottery.LotteryTipView;

/* loaded from: classes7.dex */
public final class w implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ScrollDetectFrameLayout f73072a;

    /* renamed from: b, reason: collision with root package name */
    public final BiddingFloatingIrregularAnimationView f73073b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f73074c;

    /* renamed from: d, reason: collision with root package name */
    public final ScrollDetectFrameLayout f73075d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f73076e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f73077f;

    /* renamed from: g, reason: collision with root package name */
    public final LotteryTipView f73078g;

    /* renamed from: h, reason: collision with root package name */
    public final BLTextView f73079h;

    /* renamed from: i, reason: collision with root package name */
    public final DownloadTopIrregularView f73080i;

    /* renamed from: j, reason: collision with root package name */
    public final TnTextView f73081j;

    /* renamed from: k, reason: collision with root package name */
    public final GradientTextView f73082k;

    /* renamed from: l, reason: collision with root package name */
    public final View f73083l;

    /* renamed from: m, reason: collision with root package name */
    public final ImageView f73084m;

    private w(ScrollDetectFrameLayout scrollDetectFrameLayout, BiddingFloatingIrregularAnimationView biddingFloatingIrregularAnimationView, ConstraintLayout constraintLayout, ScrollDetectFrameLayout scrollDetectFrameLayout2, FrameLayout frameLayout, AppCompatImageView appCompatImageView, LotteryTipView lotteryTipView, BLTextView bLTextView, DownloadTopIrregularView downloadTopIrregularView, TnTextView tnTextView, GradientTextView gradientTextView, View view, ImageView imageView) {
        this.f73072a = scrollDetectFrameLayout;
        this.f73073b = biddingFloatingIrregularAnimationView;
        this.f73074c = constraintLayout;
        this.f73075d = scrollDetectFrameLayout2;
        this.f73076e = frameLayout;
        this.f73077f = appCompatImageView;
        this.f73078g = lotteryTipView;
        this.f73079h = bLTextView;
        this.f73080i = downloadTopIrregularView;
        this.f73081j = tnTextView;
        this.f73082k = gradientTextView;
        this.f73083l = view;
        this.f73084m = imageView;
    }

    public static w a(View view) {
        View a11;
        int i11 = R$id.adFloatingView;
        BiddingFloatingIrregularAnimationView biddingFloatingIrregularAnimationView = (BiddingFloatingIrregularAnimationView) g4.b.a(view, i11);
        if (biddingFloatingIrregularAnimationView != null) {
            i11 = R$id.clContent;
            ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
            if (constraintLayout != null) {
                ScrollDetectFrameLayout scrollDetectFrameLayout = (ScrollDetectFrameLayout) view;
                i11 = R$id.fl_container;
                FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                if (frameLayout != null) {
                    i11 = R$id.iv_back;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.lotteryTipView;
                        LotteryTipView lotteryTipView = (LotteryTipView) g4.b.a(view, i11);
                        if (lotteryTipView != null) {
                            i11 = R$id.speedUpTip;
                            BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
                            if (bLTextView != null) {
                                i11 = R$id.topIrregularView;
                                DownloadTopIrregularView downloadTopIrregularView = (DownloadTopIrregularView) g4.b.a(view, i11);
                                if (downloadTopIrregularView != null) {
                                    i11 = R$id.tv_title;
                                    TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
                                    if (tnTextView != null) {
                                        i11 = R$id.tv_transfer;
                                        GradientTextView gradientTextView = (GradientTextView) g4.b.a(view, i11);
                                        if (gradientTextView != null && (a11 = g4.b.a(view, (i11 = R$id.v_line))) != null) {
                                            i11 = R$id.v_top_bg;
                                            ImageView imageView = (ImageView) g4.b.a(view, i11);
                                            if (imageView != null) {
                                                return new w(scrollDetectFrameLayout, biddingFloatingIrregularAnimationView, constraintLayout, scrollDetectFrameLayout, frameLayout, appCompatImageView, lotteryTipView, bLTextView, downloadTopIrregularView, tnTextView, gradientTextView, a11, imageView);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static w c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static w d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_download_main, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollDetectFrameLayout getRoot() {
        return this.f73072a;
    }
}
