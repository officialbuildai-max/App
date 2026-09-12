package so;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Barrier;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.tn.lib.view.expand.ExpandView;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.baseui.widget.NestedScrollableHost;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.ui.view.ClipLoading;
import com.transsion.postdetail.ui.view.VideoProgressDragGestureView;

/* loaded from: classes6.dex */
public final class y implements g4.a {
    public final GradientTextView A;
    public final AppCompatTextView B;
    public final AppCompatTextView C;
    public final AppCompatTextView D;
    public final AppCompatTextView E;
    public final BLTextView F;
    public final AppCompatTextView G;
    public final BLView H;
    public final View I;
    public final VideoProgressDragGestureView J;

    /* renamed from: a, reason: collision with root package name */
    private final View f75885a;

    /* renamed from: b, reason: collision with root package name */
    public final Barrier f75886b;

    /* renamed from: c, reason: collision with root package name */
    public final BLView f75887c;

    /* renamed from: d, reason: collision with root package name */
    public final BLConstraintLayout f75888d;

    /* renamed from: e, reason: collision with root package name */
    public final ClipLoading f75889e;

    /* renamed from: f, reason: collision with root package name */
    public final ShapeableImageView f75890f;

    /* renamed from: g, reason: collision with root package name */
    public final ExpandView f75891g;

    /* renamed from: h, reason: collision with root package name */
    public final FrameLayout f75892h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatImageView f75893i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatImageView f75894j;

    /* renamed from: k, reason: collision with root package name */
    public final ShapeableImageView f75895k;

    /* renamed from: l, reason: collision with root package name */
    public final AppCompatImageView f75896l;

    /* renamed from: m, reason: collision with root package name */
    public final AppCompatImageView f75897m;

    /* renamed from: n, reason: collision with root package name */
    public final AppCompatImageView f75898n;

    /* renamed from: o, reason: collision with root package name */
    public final AppCompatImageView f75899o;

    /* renamed from: p, reason: collision with root package name */
    public final ShapeableImageView f75900p;

    /* renamed from: q, reason: collision with root package name */
    public final ShapeableImageView f75901q;

    /* renamed from: r, reason: collision with root package name */
    public final e0 f75902r;

    /* renamed from: s, reason: collision with root package name */
    public final LinearLayout f75903s;

    /* renamed from: t, reason: collision with root package name */
    public final NestedScrollableHost f75904t;

    /* renamed from: u, reason: collision with root package name */
    public final ProgressBar f75905u;

    /* renamed from: v, reason: collision with root package name */
    public final Space f75906v;

    /* renamed from: w, reason: collision with root package name */
    public final AppCompatSeekBar f75907w;

    /* renamed from: x, reason: collision with root package name */
    public final AppCompatTextView f75908x;

    /* renamed from: y, reason: collision with root package name */
    public final AppCompatTextView f75909y;

    /* renamed from: z, reason: collision with root package name */
    public final AppCompatTextView f75910z;

    private y(View view, Barrier barrier, BLView bLView, BLConstraintLayout bLConstraintLayout, ClipLoading clipLoading, ShapeableImageView shapeableImageView, ExpandView expandView, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ShapeableImageView shapeableImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, AppCompatImageView appCompatImageView6, ShapeableImageView shapeableImageView3, ShapeableImageView shapeableImageView4, e0 e0Var, LinearLayout linearLayout, NestedScrollableHost nestedScrollableHost, ProgressBar progressBar, Space space, AppCompatSeekBar appCompatSeekBar, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, GradientTextView gradientTextView, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, BLTextView bLTextView, AppCompatTextView appCompatTextView8, BLView bLView2, View view2, VideoProgressDragGestureView videoProgressDragGestureView) {
        this.f75885a = view;
        this.f75886b = barrier;
        this.f75887c = bLView;
        this.f75888d = bLConstraintLayout;
        this.f75889e = clipLoading;
        this.f75890f = shapeableImageView;
        this.f75891g = expandView;
        this.f75892h = frameLayout;
        this.f75893i = appCompatImageView;
        this.f75894j = appCompatImageView2;
        this.f75895k = shapeableImageView2;
        this.f75896l = appCompatImageView3;
        this.f75897m = appCompatImageView4;
        this.f75898n = appCompatImageView5;
        this.f75899o = appCompatImageView6;
        this.f75900p = shapeableImageView3;
        this.f75901q = shapeableImageView4;
        this.f75902r = e0Var;
        this.f75903s = linearLayout;
        this.f75904t = nestedScrollableHost;
        this.f75905u = progressBar;
        this.f75906v = space;
        this.f75907w = appCompatSeekBar;
        this.f75908x = appCompatTextView;
        this.f75909y = appCompatTextView2;
        this.f75910z = appCompatTextView3;
        this.A = gradientTextView;
        this.B = appCompatTextView4;
        this.C = appCompatTextView5;
        this.D = appCompatTextView6;
        this.E = appCompatTextView7;
        this.F = bLTextView;
        this.G = appCompatTextView8;
        this.H = bLView2;
        this.I = view2;
        this.J = videoProgressDragGestureView;
    }

    public static y a(View view) {
        View a11;
        View a12;
        int i11 = R$id.barrier;
        Barrier barrier = (Barrier) g4.b.a(view, i11);
        if (barrier != null) {
            i11 = R$id.bottom_background;
            BLView bLView = (BLView) g4.b.a(view, i11);
            if (bLView != null) {
                i11 = R$id.clHotComment;
                BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) g4.b.a(view, i11);
                if (bLConstraintLayout != null) {
                    i11 = R$id.cl_loading;
                    ClipLoading clipLoading = (ClipLoading) g4.b.a(view, i11);
                    if (clipLoading != null) {
                        i11 = R$id.commentCover;
                        ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                        if (shapeableImageView != null) {
                            i11 = R$id.ev_post_des;
                            ExpandView expandView = (ExpandView) g4.b.a(view, i11);
                            if (expandView != null) {
                                i11 = R$id.fl_container;
                                FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                                if (frameLayout != null) {
                                    i11 = R$id.iv_cover;
                                    AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                                    if (appCompatImageView != null) {
                                        i11 = R$id.iv_download;
                                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                                        if (appCompatImageView2 != null) {
                                            i11 = R$id.ivHotCommentAvatar;
                                            ShapeableImageView shapeableImageView2 = (ShapeableImageView) g4.b.a(view, i11);
                                            if (shapeableImageView2 != null) {
                                                i11 = R$id.ivHotCommentIcon;
                                                AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                                                if (appCompatImageView3 != null) {
                                                    i11 = R$id.ivHotLike;
                                                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) g4.b.a(view, i11);
                                                    if (appCompatImageView4 != null) {
                                                        i11 = R$id.iv_pause;
                                                        AppCompatImageView appCompatImageView5 = (AppCompatImageView) g4.b.a(view, i11);
                                                        if (appCompatImageView5 != null) {
                                                            i11 = R$id.iv_save;
                                                            AppCompatImageView appCompatImageView6 = (AppCompatImageView) g4.b.a(view, i11);
                                                            if (appCompatImageView6 != null) {
                                                                i11 = R$id.iv_short_cover;
                                                                ShapeableImageView shapeableImageView3 = (ShapeableImageView) g4.b.a(view, i11);
                                                                if (shapeableImageView3 != null) {
                                                                    i11 = R$id.iv_video_avatar;
                                                                    ShapeableImageView shapeableImageView4 = (ShapeableImageView) g4.b.a(view, i11);
                                                                    if (shapeableImageView4 != null && (a11 = g4.b.a(view, (i11 = R$id.layout_subject_room))) != null) {
                                                                        e0 a13 = e0.a(a11);
                                                                        i11 = R$id.llOperationLayout;
                                                                        LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                                                                        if (linearLayout != null) {
                                                                            i11 = R$id.nsPostDes;
                                                                            NestedScrollableHost nestedScrollableHost = (NestedScrollableHost) g4.b.a(view, i11);
                                                                            if (nestedScrollableHost != null) {
                                                                                i11 = R$id.progress_bar;
                                                                                ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                                                                                if (progressBar != null) {
                                                                                    i11 = R$id.progress_guideline;
                                                                                    Space space = (Space) g4.b.a(view, i11);
                                                                                    if (space != null) {
                                                                                        i11 = R$id.seek_bar;
                                                                                        AppCompatSeekBar appCompatSeekBar = (AppCompatSeekBar) g4.b.a(view, i11);
                                                                                        if (appCompatSeekBar != null) {
                                                                                            i11 = R$id.tv_comment;
                                                                                            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                                                                            if (appCompatTextView != null) {
                                                                                                i11 = R$id.tv_favorite;
                                                                                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                if (appCompatTextView2 != null) {
                                                                                                    i11 = R$id.tvHotCommentContent;
                                                                                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                    if (appCompatTextView3 != null) {
                                                                                                        i11 = R$id.tvHotCommentTitle;
                                                                                                        GradientTextView gradientTextView = (GradientTextView) g4.b.a(view, i11);
                                                                                                        if (gradientTextView != null) {
                                                                                                            i11 = R$id.tvHotLikeCount;
                                                                                                            AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                            if (appCompatTextView4 != null) {
                                                                                                                i11 = R$id.tv_like;
                                                                                                                AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                                if (appCompatTextView5 != null) {
                                                                                                                    i11 = R$id.tv_progress_des;
                                                                                                                    AppCompatTextView appCompatTextView6 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                                    if (appCompatTextView6 != null) {
                                                                                                                        i11 = R$id.tv_share;
                                                                                                                        AppCompatTextView appCompatTextView7 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                                        if (appCompatTextView7 != null) {
                                                                                                                            i11 = R$id.tvShortTvEp;
                                                                                                                            BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
                                                                                                                            if (bLTextView != null) {
                                                                                                                                i11 = R$id.tvTitle;
                                                                                                                                AppCompatTextView appCompatTextView8 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                                                if (appCompatTextView8 != null) {
                                                                                                                                    i11 = R$id.up_background;
                                                                                                                                    BLView bLView2 = (BLView) g4.b.a(view, i11);
                                                                                                                                    if (bLView2 != null && (a12 = g4.b.a(view, (i11 = R$id.vHotLike))) != null) {
                                                                                                                                        i11 = R$id.v_progress_gesture;
                                                                                                                                        VideoProgressDragGestureView videoProgressDragGestureView = (VideoProgressDragGestureView) g4.b.a(view, i11);
                                                                                                                                        if (videoProgressDragGestureView != null) {
                                                                                                                                            return new y(view, barrier, bLView, bLConstraintLayout, clipLoading, shapeableImageView, expandView, frameLayout, appCompatImageView, appCompatImageView2, shapeableImageView2, appCompatImageView3, appCompatImageView4, appCompatImageView5, appCompatImageView6, shapeableImageView3, shapeableImageView4, a13, linearLayout, nestedScrollableHost, progressBar, space, appCompatSeekBar, appCompatTextView, appCompatTextView2, appCompatTextView3, gradientTextView, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7, bLTextView, appCompatTextView8, bLView2, a12, videoProgressDragGestureView);
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
        return this.f75885a;
    }
}
