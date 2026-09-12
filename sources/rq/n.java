package rq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search_pugc.ad.SearchHotAdContainerView;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: classes6.dex */
public final class n implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final NestedScrollView f74807a;

    /* renamed from: b, reason: collision with root package name */
    public final SearchHotAdContainerView f74808b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f74809c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f74810d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f74811e;

    /* renamed from: f, reason: collision with root package name */
    public final ConstraintLayout f74812f;

    /* renamed from: g, reason: collision with root package name */
    public final CardView f74813g;

    /* renamed from: h, reason: collision with root package name */
    public final ProgressBar f74814h;

    /* renamed from: i, reason: collision with root package name */
    public final ConstraintLayout f74815i;

    /* renamed from: j, reason: collision with root package name */
    public final RecyclerView f74816j;

    /* renamed from: k, reason: collision with root package name */
    public final ConstraintLayout f74817k;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f74818l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f74819m;

    /* renamed from: n, reason: collision with root package name */
    public final View f74820n;

    /* renamed from: o, reason: collision with root package name */
    public final MagicIndicator f74821o;

    /* renamed from: p, reason: collision with root package name */
    public final ImageView f74822p;

    /* renamed from: q, reason: collision with root package name */
    public final RelativeLayout f74823q;

    /* renamed from: r, reason: collision with root package name */
    public final ViewPager2 f74824r;

    /* renamed from: s, reason: collision with root package name */
    public final NestedScrollView f74825s;

    /* renamed from: t, reason: collision with root package name */
    public final TextView f74826t;

    /* renamed from: u, reason: collision with root package name */
    public final TextView f74827u;

    private n(NestedScrollView nestedScrollView, SearchHotAdContainerView searchHotAdContainerView, ConstraintLayout constraintLayout, RecyclerView recyclerView, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, CardView cardView, ProgressBar progressBar, ConstraintLayout constraintLayout3, RecyclerView recyclerView2, ConstraintLayout constraintLayout4, ImageView imageView, TextView textView, View view, MagicIndicator magicIndicator, ImageView imageView2, RelativeLayout relativeLayout, ViewPager2 viewPager2, NestedScrollView nestedScrollView2, TextView textView2, TextView textView3) {
        this.f74807a = nestedScrollView;
        this.f74808b = searchHotAdContainerView;
        this.f74809c = constraintLayout;
        this.f74810d = recyclerView;
        this.f74811e = appCompatImageView;
        this.f74812f = constraintLayout2;
        this.f74813g = cardView;
        this.f74814h = progressBar;
        this.f74815i = constraintLayout3;
        this.f74816j = recyclerView2;
        this.f74817k = constraintLayout4;
        this.f74818l = imageView;
        this.f74819m = textView;
        this.f74820n = view;
        this.f74821o = magicIndicator;
        this.f74822p = imageView2;
        this.f74823q = relativeLayout;
        this.f74824r = viewPager2;
        this.f74825s = nestedScrollView2;
        this.f74826t = textView2;
        this.f74827u = textView3;
    }

    public static n a(View view) {
        View a11;
        int i11 = R$id.ad_container_view;
        SearchHotAdContainerView searchHotAdContainerView = (SearchHotAdContainerView) g4.b.a(view, i11);
        if (searchHotAdContainerView != null) {
            i11 = R$id.empty_view;
            ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
            if (constraintLayout != null) {
                i11 = R$id.everyone_search_rv;
                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.iv_empty;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.layout_history;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) g4.b.a(view, i11);
                        if (constraintLayout2 != null) {
                            i11 = R$id.native_ad_container;
                            CardView cardView = (CardView) g4.b.a(view, i11);
                            if (cardView != null) {
                                i11 = R$id.progress_bar;
                                ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                                if (progressBar != null) {
                                    i11 = R$id.rl_tips;
                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) g4.b.a(view, i11);
                                    if (constraintLayout3 != null) {
                                        i11 = R$id.rv_history;
                                        RecyclerView recyclerView2 = (RecyclerView) g4.b.a(view, i11);
                                        if (recyclerView2 != null) {
                                            i11 = R$id.search_hot_everyone_linear;
                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) g4.b.a(view, i11);
                                            if (constraintLayout4 != null) {
                                                i11 = R$id.search_hot_everyone_title_image;
                                                ImageView imageView = (ImageView) g4.b.a(view, i11);
                                                if (imageView != null) {
                                                    i11 = R$id.search_hot_everyone_title_text;
                                                    TextView textView = (TextView) g4.b.a(view, i11);
                                                    if (textView != null && (a11 = g4.b.a(view, (i11 = R$id.search_hot_rank_indicator_linear))) != null) {
                                                        i11 = R$id.search_hot_rank_magic_indicator;
                                                        MagicIndicator magicIndicator = (MagicIndicator) g4.b.a(view, i11);
                                                        if (magicIndicator != null) {
                                                            i11 = R$id.search_hot_rank_magic_indicator_image;
                                                            ImageView imageView2 = (ImageView) g4.b.a(view, i11);
                                                            if (imageView2 != null) {
                                                                i11 = R$id.search_hot_rank_magic_indicator_ll;
                                                                RelativeLayout relativeLayout = (RelativeLayout) g4.b.a(view, i11);
                                                                if (relativeLayout != null) {
                                                                    i11 = R$id.search_hot_rank_view_pager;
                                                                    ViewPager2 viewPager2 = (ViewPager2) g4.b.a(view, i11);
                                                                    if (viewPager2 != null) {
                                                                        NestedScrollView nestedScrollView = (NestedScrollView) view;
                                                                        i11 = R$id.tv_clear;
                                                                        TextView textView2 = (TextView) g4.b.a(view, i11);
                                                                        if (textView2 != null) {
                                                                            i11 = R$id.tv_refresh;
                                                                            TextView textView3 = (TextView) g4.b.a(view, i11);
                                                                            if (textView3 != null) {
                                                                                return new n(nestedScrollView, searchHotAdContainerView, constraintLayout, recyclerView, appCompatImageView, constraintLayout2, cardView, progressBar, constraintLayout3, recyclerView2, constraintLayout4, imageView, textView, a11, magicIndicator, imageView2, relativeLayout, viewPager2, nestedScrollView, textView2, textView3);
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

    public static n c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static n d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.pugc_fragment_hot_search, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f74807a;
    }
}
