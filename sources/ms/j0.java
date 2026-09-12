package ms;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLView;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv_pugc.base.widget.NestedScrollableHost;
import com.transsion.shorttv_pugc.base.widget.TnTextView;
import com.transsion.shorttv_pugc.base.widget.expand.ExpandView;
import com.transsion.shorttv_pugc.ui.widget.ShortTvAdView;
import com.transsion.shorttv_pugc.ui.widget.ShortTvVideoProgressDragGestureView;

/* loaded from: classes7.dex */
public final class j0 implements g4.a {
    public final AppCompatTextView A;
    public final AppCompatTextView B;
    public final AppCompatTextView C;
    public final TextView D;
    public final AppCompatTextView E;
    public final AppCompatTextView F;
    public final TnTextView G;
    public final BLView H;
    public final ShortTvVideoProgressDragGestureView I;
    public final SimpleSubtitleView J;
    public final ViewStub K;

    /* renamed from: a, reason: collision with root package name */
    private final View f69926a;

    /* renamed from: b, reason: collision with root package name */
    public final BLView f69927b;

    /* renamed from: c, reason: collision with root package name */
    public final ExpandView f69928c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f69929d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f69930e;

    /* renamed from: f, reason: collision with root package name */
    public final Group f69931f;

    /* renamed from: g, reason: collision with root package name */
    public final View f69932g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatImageView f69933h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatImageView f69934i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatImageView f69935j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatImageView f69936k;

    /* renamed from: l, reason: collision with root package name */
    public final AppCompatImageView f69937l;

    /* renamed from: m, reason: collision with root package name */
    public final ShapeableImageView f69938m;

    /* renamed from: n, reason: collision with root package name */
    public final AppCompatImageView f69939n;

    /* renamed from: o, reason: collision with root package name */
    public final FrameLayout f69940o;

    /* renamed from: p, reason: collision with root package name */
    public final LinearLayout f69941p;

    /* renamed from: q, reason: collision with root package name */
    public final NestedScrollableHost f69942q;

    /* renamed from: r, reason: collision with root package name */
    public final ProgressBar f69943r;

    /* renamed from: s, reason: collision with root package name */
    public final Space f69944s;

    /* renamed from: t, reason: collision with root package name */
    public final RecyclerView f69945t;

    /* renamed from: u, reason: collision with root package name */
    public final AppCompatSeekBar f69946u;

    /* renamed from: v, reason: collision with root package name */
    public final ShortTvAdView f69947v;

    /* renamed from: w, reason: collision with root package name */
    public final ConstraintLayout f69948w;

    /* renamed from: x, reason: collision with root package name */
    public final AppCompatTextView f69949x;

    /* renamed from: y, reason: collision with root package name */
    public final AppCompatTextView f69950y;

    /* renamed from: z, reason: collision with root package name */
    public final AppCompatTextView f69951z;

    private j0(View view, BLView bLView, ExpandView expandView, FrameLayout frameLayout, FrameLayout frameLayout2, Group group, View view2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView6, FrameLayout frameLayout3, LinearLayout linearLayout, NestedScrollableHost nestedScrollableHost, ProgressBar progressBar, Space space, RecyclerView recyclerView, AppCompatSeekBar appCompatSeekBar, ShortTvAdView shortTvAdView, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, TextView textView, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8, TnTextView tnTextView, BLView bLView2, ShortTvVideoProgressDragGestureView shortTvVideoProgressDragGestureView, SimpleSubtitleView simpleSubtitleView, ViewStub viewStub) {
        this.f69926a = view;
        this.f69927b = bLView;
        this.f69928c = expandView;
        this.f69929d = frameLayout;
        this.f69930e = frameLayout2;
        this.f69931f = group;
        this.f69932g = view2;
        this.f69933h = appCompatImageView;
        this.f69934i = appCompatImageView2;
        this.f69935j = appCompatImageView3;
        this.f69936k = appCompatImageView4;
        this.f69937l = appCompatImageView5;
        this.f69938m = shapeableImageView;
        this.f69939n = appCompatImageView6;
        this.f69940o = frameLayout3;
        this.f69941p = linearLayout;
        this.f69942q = nestedScrollableHost;
        this.f69943r = progressBar;
        this.f69944s = space;
        this.f69945t = recyclerView;
        this.f69946u = appCompatSeekBar;
        this.f69947v = shortTvAdView;
        this.f69948w = constraintLayout;
        this.f69949x = appCompatTextView;
        this.f69950y = appCompatTextView2;
        this.f69951z = appCompatTextView3;
        this.A = appCompatTextView4;
        this.B = appCompatTextView5;
        this.C = appCompatTextView6;
        this.D = textView;
        this.E = appCompatTextView7;
        this.F = appCompatTextView8;
        this.G = tnTextView;
        this.H = bLView2;
        this.I = shortTvVideoProgressDragGestureView;
        this.J = simpleSubtitleView;
        this.K = viewStub;
    }

    public static j0 a(View view) {
        View a11;
        int i11 = R$id.bottom_background;
        BLView bLView = (BLView) g4.b.a(view, i11);
        if (bLView != null) {
            i11 = R$id.ev_post_des;
            ExpandView expandView = (ExpandView) g4.b.a(view, i11);
            if (expandView != null) {
                i11 = R$id.fl_container;
                FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                if (frameLayout != null) {
                    i11 = R$id.flSubtitle;
                    FrameLayout frameLayout2 = (FrameLayout) g4.b.a(view, i11);
                    if (frameLayout2 != null) {
                        i11 = R$id.group_content;
                        Group group = (Group) g4.b.a(view, i11);
                        if (group != null && (a11 = g4.b.a(view, (i11 = R$id.group_content_bg))) != null) {
                            i11 = R$id.iv_back;
                            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                            if (appCompatImageView != null) {
                                i11 = R$id.iv_cover;
                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                                if (appCompatImageView2 != null) {
                                    i11 = R$id.iv_download;
                                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                                    if (appCompatImageView3 != null) {
                                        i11 = R$id.iv_play_status;
                                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) g4.b.a(view, i11);
                                        if (appCompatImageView4 != null) {
                                            i11 = R$id.iv_share;
                                            AppCompatImageView appCompatImageView5 = (AppCompatImageView) g4.b.a(view, i11);
                                            if (appCompatImageView5 != null) {
                                                i11 = R$id.iv_short_cover;
                                                ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                                                if (shapeableImageView != null) {
                                                    i11 = R$id.iv_subscribe;
                                                    AppCompatImageView appCompatImageView6 = (AppCompatImageView) g4.b.a(view, i11);
                                                    if (appCompatImageView6 != null) {
                                                        i11 = R$id.layout_tv_episode;
                                                        FrameLayout frameLayout3 = (FrameLayout) g4.b.a(view, i11);
                                                        if (frameLayout3 != null) {
                                                            i11 = R$id.ll_ctr;
                                                            LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                                                            if (linearLayout != null) {
                                                                i11 = R$id.ns_post_des;
                                                                NestedScrollableHost nestedScrollableHost = (NestedScrollableHost) g4.b.a(view, i11);
                                                                if (nestedScrollableHost != null) {
                                                                    i11 = R$id.progress_bar;
                                                                    ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                                                                    if (progressBar != null) {
                                                                        i11 = R$id.progress_guideline;
                                                                        Space space = (Space) g4.b.a(view, i11);
                                                                        if (space != null) {
                                                                            i11 = R$id.rv_tags;
                                                                            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                                                                            if (recyclerView != null) {
                                                                                i11 = R$id.seek_bar;
                                                                                AppCompatSeekBar appCompatSeekBar = (AppCompatSeekBar) g4.b.a(view, i11);
                                                                                if (appCompatSeekBar != null) {
                                                                                    i11 = R$id.shortTvAdView;
                                                                                    ShortTvAdView shortTvAdView = (ShortTvAdView) g4.b.a(view, i11);
                                                                                    if (shortTvAdView != null) {
                                                                                        i11 = R$id.tool_bar;
                                                                                        ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
                                                                                        if (constraintLayout != null) {
                                                                                            i11 = R$id.tv_comment;
                                                                                            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                                                                            if (appCompatTextView != null) {
                                                                                                i11 = R$id.tv_episode;
                                                                                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                if (appCompatTextView2 != null) {
                                                                                                    i11 = R$id.tv_favorite;
                                                                                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                    if (appCompatTextView3 != null) {
                                                                                                        i11 = R$id.tv_language;
                                                                                                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                        if (appCompatTextView4 != null) {
                                                                                                            i11 = R$id.tv_like;
                                                                                                            AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                            if (appCompatTextView5 != null) {
                                                                                                                i11 = R$id.tv_name;
                                                                                                                AppCompatTextView appCompatTextView6 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                                if (appCompatTextView6 != null) {
                                                                                                                    i11 = R$id.tv_progress_des;
                                                                                                                    TextView textView = (TextView) g4.b.a(view, i11);
                                                                                                                    if (textView != null) {
                                                                                                                        i11 = R$id.tv_resolution;
                                                                                                                        AppCompatTextView appCompatTextView7 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                                        if (appCompatTextView7 != null) {
                                                                                                                            i11 = R$id.tv_speed;
                                                                                                                            AppCompatTextView appCompatTextView8 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                                            if (appCompatTextView8 != null) {
                                                                                                                                i11 = R$id.tv_title;
                                                                                                                                TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
                                                                                                                                if (tnTextView != null) {
                                                                                                                                    i11 = R$id.up_background;
                                                                                                                                    BLView bLView2 = (BLView) g4.b.a(view, i11);
                                                                                                                                    if (bLView2 != null) {
                                                                                                                                        i11 = R$id.v_progress_gesture;
                                                                                                                                        ShortTvVideoProgressDragGestureView shortTvVideoProgressDragGestureView = (ShortTvVideoProgressDragGestureView) g4.b.a(view, i11);
                                                                                                                                        if (shortTvVideoProgressDragGestureView != null) {
                                                                                                                                            i11 = R$id.vSubtitle;
                                                                                                                                            SimpleSubtitleView simpleSubtitleView = (SimpleSubtitleView) g4.b.a(view, i11);
                                                                                                                                            if (simpleSubtitleView != null) {
                                                                                                                                                i11 = R$id.vs_unlock;
                                                                                                                                                ViewStub viewStub = (ViewStub) g4.b.a(view, i11);
                                                                                                                                                if (viewStub != null) {
                                                                                                                                                    return new j0(view, bLView, expandView, frameLayout, frameLayout2, group, a11, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, appCompatImageView5, shapeableImageView, appCompatImageView6, frameLayout3, linearLayout, nestedScrollableHost, progressBar, space, recyclerView, appCompatSeekBar, shortTvAdView, constraintLayout, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, textView, appCompatTextView7, appCompatTextView8, tnTextView, bLView2, shortTvVideoProgressDragGestureView, simpleSubtitleView, viewStub);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    public View getRoot() {
        return this.f69926a;
    }
}
