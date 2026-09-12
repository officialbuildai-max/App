package ms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLView;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv_pugc.ui.widget.ShortTvDownloadInfoExtendView;

/* loaded from: classes7.dex */
public final class d implements g4.a {
    public final AppCompatTextView A;
    public final AppCompatTextView B;
    public final AppCompatTextView C;
    public final AppCompatTextView D;
    public final View E;
    public final View F;
    public final BLView G;
    public final ProgressBar H;

    /* renamed from: a, reason: collision with root package name */
    private final BLConstraintLayout f69852a;

    /* renamed from: b, reason: collision with root package name */
    public final AppBarLayout f69853b;

    /* renamed from: c, reason: collision with root package name */
    public final View f69854c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayoutCompat f69855d;

    /* renamed from: e, reason: collision with root package name */
    public final CoordinatorLayout f69856e;

    /* renamed from: f, reason: collision with root package name */
    public final BLFrameLayout f69857f;

    /* renamed from: g, reason: collision with root package name */
    public final FrameLayout f69858g;

    /* renamed from: h, reason: collision with root package name */
    public final FrameLayout f69859h;

    /* renamed from: i, reason: collision with root package name */
    public final ShortTvDownloadInfoExtendView f69860i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatImageView f69861j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatImageView f69862k;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f69863l;

    /* renamed from: m, reason: collision with root package name */
    public final ShapeableImageView f69864m;

    /* renamed from: n, reason: collision with root package name */
    public final BLImageView f69865n;

    /* renamed from: o, reason: collision with root package name */
    public final BLImageView f69866o;

    /* renamed from: p, reason: collision with root package name */
    public final ProgressBar f69867p;

    /* renamed from: q, reason: collision with root package name */
    public final ProgressBar f69868q;

    /* renamed from: r, reason: collision with root package name */
    public final RecyclerView f69869r;

    /* renamed from: s, reason: collision with root package name */
    public final RecyclerView f69870s;

    /* renamed from: t, reason: collision with root package name */
    public final TabLayout f69871t;

    /* renamed from: u, reason: collision with root package name */
    public final View f69872u;

    /* renamed from: v, reason: collision with root package name */
    public final AppCompatTextView f69873v;

    /* renamed from: w, reason: collision with root package name */
    public final AppCompatTextView f69874w;

    /* renamed from: x, reason: collision with root package name */
    public final TextView f69875x;

    /* renamed from: y, reason: collision with root package name */
    public final AppCompatTextView f69876y;

    /* renamed from: z, reason: collision with root package name */
    public final AppCompatTextView f69877z;

    private d(BLConstraintLayout bLConstraintLayout, AppBarLayout appBarLayout, View view, LinearLayoutCompat linearLayoutCompat, CoordinatorLayout coordinatorLayout, BLFrameLayout bLFrameLayout, FrameLayout frameLayout, FrameLayout frameLayout2, ShortTvDownloadInfoExtendView shortTvDownloadInfoExtendView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ImageView imageView, ShapeableImageView shapeableImageView, BLImageView bLImageView, BLImageView bLImageView2, ProgressBar progressBar, ProgressBar progressBar2, RecyclerView recyclerView, RecyclerView recyclerView2, TabLayout tabLayout, View view2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, TextView textView, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8, View view3, View view4, BLView bLView, ProgressBar progressBar3) {
        this.f69852a = bLConstraintLayout;
        this.f69853b = appBarLayout;
        this.f69854c = view;
        this.f69855d = linearLayoutCompat;
        this.f69856e = coordinatorLayout;
        this.f69857f = bLFrameLayout;
        this.f69858g = frameLayout;
        this.f69859h = frameLayout2;
        this.f69860i = shortTvDownloadInfoExtendView;
        this.f69861j = appCompatImageView;
        this.f69862k = appCompatImageView2;
        this.f69863l = imageView;
        this.f69864m = shapeableImageView;
        this.f69865n = bLImageView;
        this.f69866o = bLImageView2;
        this.f69867p = progressBar;
        this.f69868q = progressBar2;
        this.f69869r = recyclerView;
        this.f69870s = recyclerView2;
        this.f69871t = tabLayout;
        this.f69872u = view2;
        this.f69873v = appCompatTextView;
        this.f69874w = appCompatTextView2;
        this.f69875x = textView;
        this.f69876y = appCompatTextView3;
        this.f69877z = appCompatTextView4;
        this.A = appCompatTextView5;
        this.B = appCompatTextView6;
        this.C = appCompatTextView7;
        this.D = appCompatTextView8;
        this.E = view3;
        this.F = view4;
        this.G = bLView;
        this.H = progressBar3;
    }

    public static d a(View view) {
        View a11;
        View a12;
        View a13;
        View a14;
        int i11 = R$id.app_bar_layout;
        AppBarLayout appBarLayout = (AppBarLayout) g4.b.a(view, i11);
        if (appBarLayout != null && (a11 = g4.b.a(view, (i11 = R$id.bottom_line))) != null) {
            i11 = R$id.btn_download;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) g4.b.a(view, i11);
            if (linearLayoutCompat != null) {
                i11 = R$id.cl_root;
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) g4.b.a(view, i11);
                if (coordinatorLayout != null) {
                    i11 = R$id.fl_download_loading;
                    BLFrameLayout bLFrameLayout = (BLFrameLayout) g4.b.a(view, i11);
                    if (bLFrameLayout != null) {
                        i11 = R$id.fl_select_all_bg;
                        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                        if (frameLayout != null) {
                            i11 = R$id.fl_state;
                            FrameLayout frameLayout2 = (FrameLayout) g4.b.a(view, i11);
                            if (frameLayout2 != null) {
                                i11 = R$id.iev_info;
                                ShortTvDownloadInfoExtendView shortTvDownloadInfoExtendView = (ShortTvDownloadInfoExtendView) g4.b.a(view, i11);
                                if (shortTvDownloadInfoExtendView != null) {
                                    i11 = R$id.iv_btn_download_icon;
                                    AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                                    if (appCompatImageView != null) {
                                        i11 = R$id.iv_check;
                                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                                        if (appCompatImageView2 != null) {
                                            i11 = R$id.iv_close;
                                            ImageView imageView = (ImageView) g4.b.a(view, i11);
                                            if (imageView != null) {
                                                i11 = R$id.iv_cover;
                                                ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                                                if (shapeableImageView != null) {
                                                    i11 = R$id.iv_favorite;
                                                    BLImageView bLImageView = (BLImageView) g4.b.a(view, i11);
                                                    if (bLImageView != null) {
                                                        i11 = R$id.iv_share;
                                                        BLImageView bLImageView2 = (BLImageView) g4.b.a(view, i11);
                                                        if (bLImageView2 != null) {
                                                            i11 = R$id.progress_bar_btn_download;
                                                            ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                                                            if (progressBar != null) {
                                                                i11 = R$id.progress_bar_select_all;
                                                                ProgressBar progressBar2 = (ProgressBar) g4.b.a(view, i11);
                                                                if (progressBar2 != null) {
                                                                    i11 = R$id.recycler_view;
                                                                    RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                                                                    if (recyclerView != null) {
                                                                        i11 = R$id.recycler_view_tags;
                                                                        RecyclerView recyclerView2 = (RecyclerView) g4.b.a(view, i11);
                                                                        if (recyclerView2 != null) {
                                                                            i11 = R$id.tab_ep_title;
                                                                            TabLayout tabLayout = (TabLayout) g4.b.a(view, i11);
                                                                            if (tabLayout != null && (a12 = g4.b.a(view, (i11 = R$id.title_line))) != null) {
                                                                                i11 = R$id.tv_btn_download;
                                                                                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                                                                if (appCompatTextView != null) {
                                                                                    i11 = R$id.tv_download_ep_count;
                                                                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                    if (appCompatTextView2 != null) {
                                                                                        i11 = R$id.tv_download_title;
                                                                                        TextView textView = (TextView) g4.b.a(view, i11);
                                                                                        if (textView != null) {
                                                                                            i11 = R$id.tv_genre;
                                                                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                            if (appCompatTextView3 != null) {
                                                                                                i11 = R$id.tv_play_title;
                                                                                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                if (appCompatTextView4 != null) {
                                                                                                    i11 = R$id.tv_select_all;
                                                                                                    AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                    if (appCompatTextView5 != null) {
                                                                                                        i11 = R$id.tv_tips;
                                                                                                        AppCompatTextView appCompatTextView6 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                        if (appCompatTextView6 != null) {
                                                                                                            i11 = R$id.tv_title;
                                                                                                            AppCompatTextView appCompatTextView7 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                            if (appCompatTextView7 != null) {
                                                                                                                i11 = R$id.tv_title_2;
                                                                                                                AppCompatTextView appCompatTextView8 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                                if (appCompatTextView8 != null && (a13 = g4.b.a(view, (i11 = R$id.v_bottom))) != null && (a14 = g4.b.a(view, (i11 = R$id.v_content_gap))) != null) {
                                                                                                                    i11 = R$id.v_play;
                                                                                                                    BLView bLView = (BLView) g4.b.a(view, i11);
                                                                                                                    if (bLView != null) {
                                                                                                                        i11 = R$id.view_load;
                                                                                                                        ProgressBar progressBar3 = (ProgressBar) g4.b.a(view, i11);
                                                                                                                        if (progressBar3 != null) {
                                                                                                                            return new d((BLConstraintLayout) view, appBarLayout, a11, linearLayoutCompat, coordinatorLayout, bLFrameLayout, frameLayout, frameLayout2, shortTvDownloadInfoExtendView, appCompatImageView, appCompatImageView2, imageView, shapeableImageView, bLImageView, bLImageView2, progressBar, progressBar2, recyclerView, recyclerView2, tabLayout, a12, appCompatTextView, appCompatTextView2, textView, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7, appCompatTextView8, a13, a14, bLView, progressBar3);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static d c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static d d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.pugc_short_tv_fragment_download_res, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.f69852a;
    }
}
