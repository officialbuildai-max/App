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
import androidx.constraintlayout.widget.Group;
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
import com.transsion.shorttv.ui.widget.ShortTvDownloadInfoExtendView;

/* loaded from: classes7.dex */
public final class z implements g4.a {
    public final AppCompatTextView A;
    public final AppCompatTextView B;
    public final AppCompatTextView C;
    public final AppCompatTextView D;
    public final AppCompatTextView E;
    public final View F;
    public final View G;
    public final BLView H;
    public final ProgressBar I;

    /* renamed from: a, reason: collision with root package name */
    private final BLConstraintLayout f70084a;

    /* renamed from: b, reason: collision with root package name */
    public final AppBarLayout f70085b;

    /* renamed from: c, reason: collision with root package name */
    public final View f70086c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayoutCompat f70087d;

    /* renamed from: e, reason: collision with root package name */
    public final Group f70088e;

    /* renamed from: f, reason: collision with root package name */
    public final CoordinatorLayout f70089f;

    /* renamed from: g, reason: collision with root package name */
    public final BLFrameLayout f70090g;

    /* renamed from: h, reason: collision with root package name */
    public final FrameLayout f70091h;

    /* renamed from: i, reason: collision with root package name */
    public final FrameLayout f70092i;

    /* renamed from: j, reason: collision with root package name */
    public final ShortTvDownloadInfoExtendView f70093j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatImageView f70094k;

    /* renamed from: l, reason: collision with root package name */
    public final AppCompatImageView f70095l;

    /* renamed from: m, reason: collision with root package name */
    public final ImageView f70096m;

    /* renamed from: n, reason: collision with root package name */
    public final ShapeableImageView f70097n;

    /* renamed from: o, reason: collision with root package name */
    public final BLImageView f70098o;

    /* renamed from: p, reason: collision with root package name */
    public final BLImageView f70099p;

    /* renamed from: q, reason: collision with root package name */
    public final ProgressBar f70100q;

    /* renamed from: r, reason: collision with root package name */
    public final ProgressBar f70101r;

    /* renamed from: s, reason: collision with root package name */
    public final RecyclerView f70102s;

    /* renamed from: t, reason: collision with root package name */
    public final RecyclerView f70103t;

    /* renamed from: u, reason: collision with root package name */
    public final TabLayout f70104u;

    /* renamed from: v, reason: collision with root package name */
    public final View f70105v;

    /* renamed from: w, reason: collision with root package name */
    public final AppCompatTextView f70106w;

    /* renamed from: x, reason: collision with root package name */
    public final AppCompatTextView f70107x;

    /* renamed from: y, reason: collision with root package name */
    public final TextView f70108y;

    /* renamed from: z, reason: collision with root package name */
    public final AppCompatTextView f70109z;

    private z(BLConstraintLayout bLConstraintLayout, AppBarLayout appBarLayout, View view, LinearLayoutCompat linearLayoutCompat, Group group, CoordinatorLayout coordinatorLayout, BLFrameLayout bLFrameLayout, FrameLayout frameLayout, FrameLayout frameLayout2, ShortTvDownloadInfoExtendView shortTvDownloadInfoExtendView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ImageView imageView, ShapeableImageView shapeableImageView, BLImageView bLImageView, BLImageView bLImageView2, ProgressBar progressBar, ProgressBar progressBar2, RecyclerView recyclerView, RecyclerView recyclerView2, TabLayout tabLayout, View view2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, TextView textView, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8, View view3, View view4, BLView bLView, ProgressBar progressBar3) {
        this.f70084a = bLConstraintLayout;
        this.f70085b = appBarLayout;
        this.f70086c = view;
        this.f70087d = linearLayoutCompat;
        this.f70088e = group;
        this.f70089f = coordinatorLayout;
        this.f70090g = bLFrameLayout;
        this.f70091h = frameLayout;
        this.f70092i = frameLayout2;
        this.f70093j = shortTvDownloadInfoExtendView;
        this.f70094k = appCompatImageView;
        this.f70095l = appCompatImageView2;
        this.f70096m = imageView;
        this.f70097n = shapeableImageView;
        this.f70098o = bLImageView;
        this.f70099p = bLImageView2;
        this.f70100q = progressBar;
        this.f70101r = progressBar2;
        this.f70102s = recyclerView;
        this.f70103t = recyclerView2;
        this.f70104u = tabLayout;
        this.f70105v = view2;
        this.f70106w = appCompatTextView;
        this.f70107x = appCompatTextView2;
        this.f70108y = textView;
        this.f70109z = appCompatTextView3;
        this.A = appCompatTextView4;
        this.B = appCompatTextView5;
        this.C = appCompatTextView6;
        this.D = appCompatTextView7;
        this.E = appCompatTextView8;
        this.F = view3;
        this.G = view4;
        this.H = bLView;
        this.I = progressBar3;
    }

    public static z a(View view) {
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
                i11 = R$id.btn_group;
                Group group = (Group) g4.b.a(view, i11);
                if (group != null) {
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
                                                                                                                                return new z((BLConstraintLayout) view, appBarLayout, a11, linearLayoutCompat, group, coordinatorLayout, bLFrameLayout, frameLayout, frameLayout2, shortTvDownloadInfoExtendView, appCompatImageView, appCompatImageView2, imageView, shapeableImageView, bLImageView, bLImageView2, progressBar, progressBar2, recyclerView, recyclerView2, tabLayout, a12, appCompatTextView, appCompatTextView2, textView, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7, appCompatTextView8, a13, a14, bLView, progressBar3);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static z c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static z d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.short_tv_fragment_download_res, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.f70084a;
    }
}
