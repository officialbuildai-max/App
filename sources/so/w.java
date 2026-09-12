package so;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLView;
import com.tn.lib.view.NoScrollRecyclerView2;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.postdetail.R$id;

/* loaded from: classes6.dex */
public final class w implements g4.a {
    public final AppCompatTextView A;
    public final View B;
    public final View C;
    public final View D;
    public final View E;
    public final View F;
    public final View G;
    public final View H;
    public final BLView I;
    public final BLView J;

    /* renamed from: a, reason: collision with root package name */
    private final View f75856a;

    /* renamed from: b, reason: collision with root package name */
    public final BLConstraintLayout f75857b;

    /* renamed from: c, reason: collision with root package name */
    public final ShapeableImageView f75858c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f75859d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f75860e;

    /* renamed from: f, reason: collision with root package name */
    public final ShapeableImageView f75861f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f75862g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatImageView f75863h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatImageView f75864i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatImageView f75865j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatImageView f75866k;

    /* renamed from: l, reason: collision with root package name */
    public final ShapeableImageView f75867l;

    /* renamed from: m, reason: collision with root package name */
    public final ShapeableImageView f75868m;

    /* renamed from: n, reason: collision with root package name */
    public final ShapeableImageView f75869n;

    /* renamed from: o, reason: collision with root package name */
    public final e0 f75870o;

    /* renamed from: p, reason: collision with root package name */
    public final g0 f75871p;

    /* renamed from: q, reason: collision with root package name */
    public final NoScrollRecyclerView2 f75872q;

    /* renamed from: r, reason: collision with root package name */
    public final AppCompatTextView f75873r;

    /* renamed from: s, reason: collision with root package name */
    public final GradientTextView f75874s;

    /* renamed from: t, reason: collision with root package name */
    public final AppCompatTextView f75875t;

    /* renamed from: u, reason: collision with root package name */
    public final AppCompatTextView f75876u;

    /* renamed from: v, reason: collision with root package name */
    public final AppCompatTextView f75877v;

    /* renamed from: w, reason: collision with root package name */
    public final AppCompatTextView f75878w;

    /* renamed from: x, reason: collision with root package name */
    public final AppCompatTextView f75879x;

    /* renamed from: y, reason: collision with root package name */
    public final AppCompatTextView f75880y;

    /* renamed from: z, reason: collision with root package name */
    public final AppCompatTextView f75881z;

    private w(View view, BLConstraintLayout bLConstraintLayout, ShapeableImageView shapeableImageView, FrameLayout frameLayout, FrameLayout frameLayout2, ShapeableImageView shapeableImageView2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, ShapeableImageView shapeableImageView3, ShapeableImageView shapeableImageView4, ShapeableImageView shapeableImageView5, e0 e0Var, g0 g0Var, NoScrollRecyclerView2 noScrollRecyclerView2, AppCompatTextView appCompatTextView, GradientTextView gradientTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8, AppCompatTextView appCompatTextView9, View view2, View view3, View view4, View view5, View view6, View view7, View view8, BLView bLView, BLView bLView2) {
        this.f75856a = view;
        this.f75857b = bLConstraintLayout;
        this.f75858c = shapeableImageView;
        this.f75859d = frameLayout;
        this.f75860e = frameLayout2;
        this.f75861f = shapeableImageView2;
        this.f75862g = appCompatImageView;
        this.f75863h = appCompatImageView2;
        this.f75864i = appCompatImageView3;
        this.f75865j = appCompatImageView4;
        this.f75866k = appCompatImageView5;
        this.f75867l = shapeableImageView3;
        this.f75868m = shapeableImageView4;
        this.f75869n = shapeableImageView5;
        this.f75870o = e0Var;
        this.f75871p = g0Var;
        this.f75872q = noScrollRecyclerView2;
        this.f75873r = appCompatTextView;
        this.f75874s = gradientTextView;
        this.f75875t = appCompatTextView2;
        this.f75876u = appCompatTextView3;
        this.f75877v = appCompatTextView4;
        this.f75878w = appCompatTextView5;
        this.f75879x = appCompatTextView6;
        this.f75880y = appCompatTextView7;
        this.f75881z = appCompatTextView8;
        this.A = appCompatTextView9;
        this.B = view2;
        this.C = view3;
        this.D = view4;
        this.E = view5;
        this.F = view6;
        this.G = view7;
        this.H = view8;
        this.I = bLView;
        this.J = bLView2;
    }

    public static w a(View view) {
        View a11;
        View a12;
        View a13;
        View a14;
        View a15;
        View a16;
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) g4.b.a(view, R$id.clHotComment);
        ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, R$id.commentCover);
        int i11 = R$id.fl_content;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.fl_cover;
            FrameLayout frameLayout2 = (FrameLayout) g4.b.a(view, i11);
            if (frameLayout2 != null) {
                ShapeableImageView shapeableImageView2 = (ShapeableImageView) g4.b.a(view, R$id.ivHotCommentAvatar);
                AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, R$id.ivHotCommentIcon);
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, R$id.ivHotLike);
                i11 = R$id.iv_location_icon;
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView3 != null) {
                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) g4.b.a(view, R$id.ivNegativeFeedback);
                    i11 = R$id.iv_post_download;
                    AppCompatImageView appCompatImageView5 = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView5 != null) {
                        i11 = R$id.iv_room_cover;
                        ShapeableImageView shapeableImageView3 = (ShapeableImageView) g4.b.a(view, i11);
                        if (shapeableImageView3 != null) {
                            i11 = R$id.iv_user_avatar;
                            ShapeableImageView shapeableImageView4 = (ShapeableImageView) g4.b.a(view, i11);
                            if (shapeableImageView4 != null) {
                                i11 = R$id.iv_user_avatar_2;
                                ShapeableImageView shapeableImageView5 = (ShapeableImageView) g4.b.a(view, i11);
                                if (shapeableImageView5 != null && (a11 = g4.b.a(view, (i11 = R$id.layout_bottom_module))) != null) {
                                    e0 a17 = e0.a(a11);
                                    i11 = R$id.layout_content_video;
                                    View a18 = g4.b.a(view, i11);
                                    if (a18 != null) {
                                        g0 a19 = g0.a(a18);
                                        i11 = R$id.recycler_view_post;
                                        NoScrollRecyclerView2 noScrollRecyclerView2 = (NoScrollRecyclerView2) g4.b.a(view, i11);
                                        if (noScrollRecyclerView2 != null) {
                                            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, R$id.tvHotCommentContent);
                                            GradientTextView gradientTextView = (GradientTextView) g4.b.a(view, R$id.tvHotCommentTitle);
                                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, R$id.tvHotLikeCount);
                                            i11 = R$id.tv_post_comment;
                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                            if (appCompatTextView3 != null) {
                                                i11 = R$id.tv_post_content;
                                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                                if (appCompatTextView4 != null) {
                                                    i11 = R$id.tv_post_date;
                                                    AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                                                    if (appCompatTextView5 != null) {
                                                        i11 = R$id.tv_post_like;
                                                        AppCompatTextView appCompatTextView6 = (AppCompatTextView) g4.b.a(view, i11);
                                                        if (appCompatTextView6 != null) {
                                                            i11 = R$id.tv_post_share;
                                                            AppCompatTextView appCompatTextView7 = (AppCompatTextView) g4.b.a(view, i11);
                                                            if (appCompatTextView7 != null) {
                                                                i11 = R$id.tv_room_name;
                                                                AppCompatTextView appCompatTextView8 = (AppCompatTextView) g4.b.a(view, i11);
                                                                if (appCompatTextView8 != null) {
                                                                    i11 = R$id.tv_user_name_or_location;
                                                                    AppCompatTextView appCompatTextView9 = (AppCompatTextView) g4.b.a(view, i11);
                                                                    if (appCompatTextView9 != null && (a12 = g4.b.a(view, (i11 = R$id.v_bottom_line))) != null) {
                                                                        View a20 = g4.b.a(view, R$id.vHotLike);
                                                                        i11 = R$id.v_location_line;
                                                                        View a21 = g4.b.a(view, i11);
                                                                        if (a21 != null && (a13 = g4.b.a(view, (i11 = R$id.v_post_comment))) != null && (a14 = g4.b.a(view, (i11 = R$id.v_post_download))) != null && (a15 = g4.b.a(view, (i11 = R$id.v_post_like))) != null && (a16 = g4.b.a(view, (i11 = R$id.v_post_share))) != null) {
                                                                            return new w(view, bLConstraintLayout, shapeableImageView, frameLayout, frameLayout2, shapeableImageView2, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, appCompatImageView5, shapeableImageView3, shapeableImageView4, shapeableImageView5, a17, a19, noScrollRecyclerView2, appCompatTextView, gradientTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7, appCompatTextView8, appCompatTextView9, a12, a20, a21, a13, a14, a15, a16, (BLView) g4.b.a(view, R$id.v_room_cover_stroke), (BLView) g4.b.a(view, R$id.v_user_avatar_2_stroke));
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
        return this.f75856a;
    }
}
