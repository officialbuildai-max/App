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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLLinearLayout;
import com.transsion.wrapperad.view.DownloadMovieAdView;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;

/* loaded from: classes7.dex */
public final class c1 implements g4.a {
    public final ProgressBar A;

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f72757a;

    /* renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f72758b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayoutCompat f72759c;

    /* renamed from: d, reason: collision with root package name */
    public final BLLinearLayout f72760d;

    /* renamed from: e, reason: collision with root package name */
    public final BLConstraintLayout f72761e;

    /* renamed from: f, reason: collision with root package name */
    public final View f72762f;

    /* renamed from: g, reason: collision with root package name */
    public final View f72763g;

    /* renamed from: h, reason: collision with root package name */
    public final BLFrameLayout f72764h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatImageView f72765i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatImageView f72766j;

    /* renamed from: k, reason: collision with root package name */
    public final ImageView f72767k;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f72768l;

    /* renamed from: m, reason: collision with root package name */
    public final ImageView f72769m;

    /* renamed from: n, reason: collision with root package name */
    public final LinearLayout f72770n;

    /* renamed from: o, reason: collision with root package name */
    public final ProgressBar f72771o;

    /* renamed from: p, reason: collision with root package name */
    public final RecyclerView f72772p;

    /* renamed from: q, reason: collision with root package name */
    public final RecyclerView f72773q;

    /* renamed from: r, reason: collision with root package name */
    public final AppCompatTextView f72774r;

    /* renamed from: s, reason: collision with root package name */
    public final AppCompatTextView f72775s;

    /* renamed from: t, reason: collision with root package name */
    public final TextView f72776t;

    /* renamed from: u, reason: collision with root package name */
    public final AppCompatTextView f72777u;

    /* renamed from: v, reason: collision with root package name */
    public final AppCompatTextView f72778v;

    /* renamed from: w, reason: collision with root package name */
    public final AppCompatTextView f72779w;

    /* renamed from: x, reason: collision with root package name */
    public final AppCompatTextView f72780x;

    /* renamed from: y, reason: collision with root package name */
    public final View f72781y;

    /* renamed from: z, reason: collision with root package name */
    public final DownloadMovieAdView f72782z;

    private c1(FrameLayout frameLayout, ConstraintLayout constraintLayout, LinearLayoutCompat linearLayoutCompat, BLLinearLayout bLLinearLayout, BLConstraintLayout bLConstraintLayout, View view, View view2, BLFrameLayout bLFrameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, ProgressBar progressBar, RecyclerView recyclerView, RecyclerView recyclerView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, TextView textView, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, View view3, DownloadMovieAdView downloadMovieAdView, ProgressBar progressBar2) {
        this.f72757a = frameLayout;
        this.f72758b = constraintLayout;
        this.f72759c = linearLayoutCompat;
        this.f72760d = bLLinearLayout;
        this.f72761e = bLConstraintLayout;
        this.f72762f = view;
        this.f72763g = view2;
        this.f72764h = bLFrameLayout;
        this.f72765i = appCompatImageView;
        this.f72766j = appCompatImageView2;
        this.f72767k = imageView;
        this.f72768l = imageView2;
        this.f72769m = imageView3;
        this.f72770n = linearLayout;
        this.f72771o = progressBar;
        this.f72772p = recyclerView;
        this.f72773q = recyclerView2;
        this.f72774r = appCompatTextView;
        this.f72775s = appCompatTextView2;
        this.f72776t = textView;
        this.f72777u = appCompatTextView3;
        this.f72778v = appCompatTextView4;
        this.f72779w = appCompatTextView5;
        this.f72780x = appCompatTextView6;
        this.f72781y = view3;
        this.f72782z = downloadMovieAdView;
        this.A = progressBar2;
    }

    public static c1 a(View view) {
        View a11;
        View a12;
        View a13;
        int i11 = R$id.bottomBar;
        ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
        if (constraintLayout != null) {
            i11 = R$id.btnDownload;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) g4.b.a(view, i11);
            if (linearLayoutCompat != null) {
                i11 = R$id.btnResolution;
                BLLinearLayout bLLinearLayout = (BLLinearLayout) g4.b.a(view, i11);
                if (bLLinearLayout != null) {
                    i11 = R$id.clContent;
                    BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) g4.b.a(view, i11);
                    if (bLConstraintLayout != null && (a11 = g4.b.a(view, (i11 = R$id.dividerLine))) != null && (a12 = g4.b.a(view, (i11 = R$id.dividerLine1))) != null) {
                        i11 = R$id.flLoading;
                        BLFrameLayout bLFrameLayout = (BLFrameLayout) g4.b.a(view, i11);
                        if (bLFrameLayout != null) {
                            i11 = R$id.ivBtnDownloadIcon;
                            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                            if (appCompatImageView != null) {
                                i11 = R$id.ivCheck;
                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                                if (appCompatImageView2 != null) {
                                    i11 = R$id.ivClose;
                                    ImageView imageView = (ImageView) g4.b.a(view, i11);
                                    if (imageView != null) {
                                        i11 = R$id.ivResolutionArrow;
                                        ImageView imageView2 = (ImageView) g4.b.a(view, i11);
                                        if (imageView2 != null) {
                                            i11 = R$id.ivResolutionIcon;
                                            ImageView imageView3 = (ImageView) g4.b.a(view, i11);
                                            if (imageView3 != null) {
                                                i11 = R$id.llNotNet;
                                                LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                                                if (linearLayout != null) {
                                                    i11 = R$id.progressBarBtnDownload;
                                                    ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                                                    if (progressBar != null) {
                                                        i11 = R$id.recyclerView;
                                                        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                                                        if (recyclerView != null) {
                                                            i11 = R$id.rvTabs;
                                                            RecyclerView recyclerView2 = (RecyclerView) g4.b.a(view, i11);
                                                            if (recyclerView2 != null) {
                                                                i11 = R$id.tvBtnDownload;
                                                                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                                                if (appCompatTextView != null) {
                                                                    i11 = R$id.tv_no_network_content;
                                                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                                                    if (appCompatTextView2 != null) {
                                                                        i11 = R$id.tvResolution;
                                                                        TextView textView = (TextView) g4.b.a(view, i11);
                                                                        if (textView != null) {
                                                                            i11 = R$id.tv_retry;
                                                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                                                            if (appCompatTextView3 != null) {
                                                                                i11 = R$id.tvSelectAll;
                                                                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                if (appCompatTextView4 != null) {
                                                                                    i11 = R$id.tv_tips;
                                                                                    AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                    if (appCompatTextView5 != null) {
                                                                                        i11 = R$id.tvTitle;
                                                                                        AppCompatTextView appCompatTextView6 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                        if (appCompatTextView6 != null && (a13 = g4.b.a(view, (i11 = R$id.vContentGap))) != null) {
                                                                                            i11 = R$id.viewAd;
                                                                                            DownloadMovieAdView downloadMovieAdView = (DownloadMovieAdView) g4.b.a(view, i11);
                                                                                            if (downloadMovieAdView != null) {
                                                                                                i11 = R$id.view_load;
                                                                                                ProgressBar progressBar2 = (ProgressBar) g4.b.a(view, i11);
                                                                                                if (progressBar2 != null) {
                                                                                                    return new c1((FrameLayout) view, constraintLayout, linearLayoutCompat, bLLinearLayout, bLConstraintLayout, a11, a12, bLFrameLayout, appCompatImageView, appCompatImageView2, imageView, imageView2, imageView3, linearLayout, progressBar, recyclerView, recyclerView2, appCompatTextView, appCompatTextView2, textView, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, a13, downloadMovieAdView, progressBar2);
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

    public static c1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.ugc_dialog_download_page, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f72757a;
    }
}
