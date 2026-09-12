package py;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLFrameLayout;
import com.transsion.wrapperad.view.DownloadMovieAdView;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.widget.DownloadGridTabView;
import com.transsnet.downloader.widget.DownloadResolutionTabView;

/* loaded from: classes7.dex */
public final class a0 implements g4.a {
    public final DownloadResolutionTabView A;
    public final DownloadMovieAdView B;
    public final ProgressBar C;

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f72690a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayoutCompat f72691b;

    /* renamed from: c, reason: collision with root package name */
    public final BLConstraintLayout f72692c;

    /* renamed from: d, reason: collision with root package name */
    public final CoordinatorLayout f72693d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f72694e;

    /* renamed from: f, reason: collision with root package name */
    public final BLFrameLayout f72695f;

    /* renamed from: g, reason: collision with root package name */
    public final FrameLayout f72696g;

    /* renamed from: h, reason: collision with root package name */
    public final FrameLayout f72697h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatImageView f72698i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatImageView f72699j;

    /* renamed from: k, reason: collision with root package name */
    public final ImageView f72700k;

    /* renamed from: l, reason: collision with root package name */
    public final View f72701l;

    /* renamed from: m, reason: collision with root package name */
    public final LinearLayout f72702m;

    /* renamed from: n, reason: collision with root package name */
    public final LinearLayout f72703n;

    /* renamed from: o, reason: collision with root package name */
    public final ProgressBar f72704o;

    /* renamed from: p, reason: collision with root package name */
    public final ProgressBar f72705p;

    /* renamed from: q, reason: collision with root package name */
    public final AppCompatTextView f72706q;

    /* renamed from: r, reason: collision with root package name */
    public final TextView f72707r;

    /* renamed from: s, reason: collision with root package name */
    public final AppCompatTextView f72708s;

    /* renamed from: t, reason: collision with root package name */
    public final AppCompatTextView f72709t;

    /* renamed from: u, reason: collision with root package name */
    public final AppCompatTextView f72710u;

    /* renamed from: v, reason: collision with root package name */
    public final AppCompatTextView f72711v;

    /* renamed from: w, reason: collision with root package name */
    public final AppCompatTextView f72712w;

    /* renamed from: x, reason: collision with root package name */
    public final LinearLayout f72713x;

    /* renamed from: y, reason: collision with root package name */
    public final View f72714y;

    /* renamed from: z, reason: collision with root package name */
    public final DownloadGridTabView f72715z;

    private a0(FrameLayout frameLayout, LinearLayoutCompat linearLayoutCompat, BLConstraintLayout bLConstraintLayout, CoordinatorLayout coordinatorLayout, FrameLayout frameLayout2, BLFrameLayout bLFrameLayout, FrameLayout frameLayout3, FrameLayout frameLayout4, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ImageView imageView, View view, LinearLayout linearLayout, LinearLayout linearLayout2, ProgressBar progressBar, ProgressBar progressBar2, AppCompatTextView appCompatTextView, TextView textView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, LinearLayout linearLayout3, View view2, DownloadGridTabView downloadGridTabView, DownloadResolutionTabView downloadResolutionTabView, DownloadMovieAdView downloadMovieAdView, ProgressBar progressBar3) {
        this.f72690a = frameLayout;
        this.f72691b = linearLayoutCompat;
        this.f72692c = bLConstraintLayout;
        this.f72693d = coordinatorLayout;
        this.f72694e = frameLayout2;
        this.f72695f = bLFrameLayout;
        this.f72696g = frameLayout3;
        this.f72697h = frameLayout4;
        this.f72698i = appCompatImageView;
        this.f72699j = appCompatImageView2;
        this.f72700k = imageView;
        this.f72701l = view;
        this.f72702m = linearLayout;
        this.f72703n = linearLayout2;
        this.f72704o = progressBar;
        this.f72705p = progressBar2;
        this.f72706q = appCompatTextView;
        this.f72707r = textView;
        this.f72708s = appCompatTextView2;
        this.f72709t = appCompatTextView3;
        this.f72710u = appCompatTextView4;
        this.f72711v = appCompatTextView5;
        this.f72712w = appCompatTextView6;
        this.f72713x = linearLayout3;
        this.f72714y = view2;
        this.f72715z = downloadGridTabView;
        this.A = downloadResolutionTabView;
        this.B = downloadMovieAdView;
        this.C = progressBar3;
    }

    public static a0 a(View view) {
        View a11;
        View a12;
        int i11 = R$id.btn_download;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) g4.b.a(view, i11);
        if (linearLayoutCompat != null) {
            i11 = R$id.cl_content;
            BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) g4.b.a(view, i11);
            if (bLConstraintLayout != null) {
                i11 = R$id.cl_root;
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) g4.b.a(view, i11);
                if (coordinatorLayout != null) {
                    i11 = R$id.fl_content;
                    FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                    if (frameLayout != null) {
                        i11 = R$id.fl_loading;
                        BLFrameLayout bLFrameLayout = (BLFrameLayout) g4.b.a(view, i11);
                        if (bLFrameLayout != null) {
                            i11 = R$id.flSelectAll;
                            FrameLayout frameLayout2 = (FrameLayout) g4.b.a(view, i11);
                            if (frameLayout2 != null) {
                                i11 = R$id.fl_select_all_bg;
                                FrameLayout frameLayout3 = (FrameLayout) g4.b.a(view, i11);
                                if (frameLayout3 != null) {
                                    i11 = R$id.iv_btn_download_icon;
                                    AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                                    if (appCompatImageView != null) {
                                        i11 = R$id.iv_check;
                                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                                        if (appCompatImageView2 != null) {
                                            i11 = R$id.iv_close;
                                            ImageView imageView = (ImageView) g4.b.a(view, i11);
                                            if (imageView != null && (a11 = g4.b.a(view, (i11 = R$id.line))) != null) {
                                                i11 = R$id.llFreeDownloadTimes;
                                                LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                                                if (linearLayout != null) {
                                                    i11 = R$id.ll_not_net;
                                                    LinearLayout linearLayout2 = (LinearLayout) g4.b.a(view, i11);
                                                    if (linearLayout2 != null) {
                                                        i11 = R$id.progress_bar_btn_download;
                                                        ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                                                        if (progressBar != null) {
                                                            i11 = R$id.progress_bar_select_all;
                                                            ProgressBar progressBar2 = (ProgressBar) g4.b.a(view, i11);
                                                            if (progressBar2 != null) {
                                                                i11 = R$id.tv_btn_download;
                                                                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                                                if (appCompatTextView != null) {
                                                                    i11 = R$id.tvFreeTimes;
                                                                    TextView textView = (TextView) g4.b.a(view, i11);
                                                                    if (textView != null) {
                                                                        i11 = R$id.tv_no_network_content;
                                                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                                                        if (appCompatTextView2 != null) {
                                                                            i11 = R$id.tv_retry;
                                                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                                                            if (appCompatTextView3 != null) {
                                                                                i11 = R$id.tv_select_all;
                                                                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                if (appCompatTextView4 != null) {
                                                                                    i11 = R$id.tv_tips;
                                                                                    AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                    if (appCompatTextView5 != null) {
                                                                                        i11 = R$id.tv_title;
                                                                                        AppCompatTextView appCompatTextView6 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                        if (appCompatTextView6 != null) {
                                                                                            i11 = R$id.v_bottom;
                                                                                            LinearLayout linearLayout3 = (LinearLayout) g4.b.a(view, i11);
                                                                                            if (linearLayout3 != null && (a12 = g4.b.a(view, (i11 = R$id.v_content_gap))) != null) {
                                                                                                i11 = R$id.vGridTab;
                                                                                                DownloadGridTabView downloadGridTabView = (DownloadGridTabView) g4.b.a(view, i11);
                                                                                                if (downloadGridTabView != null) {
                                                                                                    i11 = R$id.v_language_resolution;
                                                                                                    DownloadResolutionTabView downloadResolutionTabView = (DownloadResolutionTabView) g4.b.a(view, i11);
                                                                                                    if (downloadResolutionTabView != null) {
                                                                                                        i11 = R$id.viewAd;
                                                                                                        DownloadMovieAdView downloadMovieAdView = (DownloadMovieAdView) g4.b.a(view, i11);
                                                                                                        if (downloadMovieAdView != null) {
                                                                                                            i11 = R$id.view_load;
                                                                                                            ProgressBar progressBar3 = (ProgressBar) g4.b.a(view, i11);
                                                                                                            if (progressBar3 != null) {
                                                                                                                return new a0((FrameLayout) view, linearLayoutCompat, bLConstraintLayout, coordinatorLayout, frameLayout, bLFrameLayout, frameLayout2, frameLayout3, appCompatImageView, appCompatImageView2, imageView, a11, linearLayout, linearLayout2, progressBar, progressBar2, appCompatTextView, textView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, linearLayout3, a12, downloadGridTabView, downloadResolutionTabView, downloadMovieAdView, progressBar3);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static a0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_download_res_group_main, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f72690a;
    }
}
