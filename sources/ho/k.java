package ho;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.SecondariesSeekBar;
import com.transsion.player.longvideo.R$id;
import com.transsion.player.longvideo.member.LongVodResolutionMemberTipView;
import com.transsion.postdetail.ui.view.ImmScaleView;
import com.transsion.postdetail.ui.view.ImmSpeedView;

/* loaded from: classes6.dex */
public final class k implements g4.a {
    public final ImmSpeedView A;
    public final View B;
    public final View C;
    public final FrameLayout D;
    public final TextView E;
    public final ViewStub F;
    public final ViewStub G;

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f64759a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f64760b;

    /* renamed from: c, reason: collision with root package name */
    public final bk.e f64761c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f64762d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f64763e;

    /* renamed from: f, reason: collision with root package name */
    public final FrameLayout f64764f;

    /* renamed from: g, reason: collision with root package name */
    public final FrameLayout f64765g;

    /* renamed from: h, reason: collision with root package name */
    public final Group f64766h;

    /* renamed from: i, reason: collision with root package name */
    public final ShapeableImageView f64767i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatImageView f64768j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatImageView f64769k;

    /* renamed from: l, reason: collision with root package name */
    public final AppCompatTextView f64770l;

    /* renamed from: m, reason: collision with root package name */
    public final AppCompatImageView f64771m;

    /* renamed from: n, reason: collision with root package name */
    public final ImmScaleView f64772n;

    /* renamed from: o, reason: collision with root package name */
    public final View f64773o;

    /* renamed from: p, reason: collision with root package name */
    public final View f64774p;

    /* renamed from: q, reason: collision with root package name */
    public final LinearLayout f64775q;

    /* renamed from: r, reason: collision with root package name */
    public final LongVodResolutionMemberTipView f64776r;

    /* renamed from: s, reason: collision with root package name */
    public final f f64777s;

    /* renamed from: t, reason: collision with root package name */
    public final SecondariesSeekBar f64778t;

    /* renamed from: u, reason: collision with root package name */
    public final TextView f64779u;

    /* renamed from: v, reason: collision with root package name */
    public final TextView f64780v;

    /* renamed from: w, reason: collision with root package name */
    public final TextView f64781w;

    /* renamed from: x, reason: collision with root package name */
    public final AppCompatTextView f64782x;

    /* renamed from: y, reason: collision with root package name */
    public final AppCompatTextView f64783y;

    /* renamed from: z, reason: collision with root package name */
    public final TextView f64784z;

    private k(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, bk.e eVar, ConstraintLayout constraintLayout2, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, Group group, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView4, ImmScaleView immScaleView, View view, View view2, LinearLayout linearLayout, LongVodResolutionMemberTipView longVodResolutionMemberTipView, f fVar, SecondariesSeekBar secondariesSeekBar, TextView textView, TextView textView2, TextView textView3, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, TextView textView4, ImmSpeedView immSpeedView, View view3, View view4, FrameLayout frameLayout4, TextView textView5, ViewStub viewStub, ViewStub viewStub2) {
        this.f64759a = constraintLayout;
        this.f64760b = appCompatImageView;
        this.f64761c = eVar;
        this.f64762d = constraintLayout2;
        this.f64763e = frameLayout;
        this.f64764f = frameLayout2;
        this.f64765g = frameLayout3;
        this.f64766h = group;
        this.f64767i = shapeableImageView;
        this.f64768j = appCompatImageView2;
        this.f64769k = appCompatImageView3;
        this.f64770l = appCompatTextView;
        this.f64771m = appCompatImageView4;
        this.f64772n = immScaleView;
        this.f64773o = view;
        this.f64774p = view2;
        this.f64775q = linearLayout;
        this.f64776r = longVodResolutionMemberTipView;
        this.f64777s = fVar;
        this.f64778t = secondariesSeekBar;
        this.f64779u = textView;
        this.f64780v = textView2;
        this.f64781w = textView3;
        this.f64782x = appCompatTextView2;
        this.f64783y = appCompatTextView3;
        this.f64784z = textView4;
        this.A = immSpeedView;
        this.B = view3;
        this.C = view4;
        this.D = frameLayout4;
        this.E = textView5;
        this.F = viewStub;
        this.G = viewStub2;
    }

    public static k a(View view) {
        View a11;
        View a12;
        View a13;
        View a14;
        View a15;
        View a16;
        int i11 = R$id.ad_close_view;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null && (a11 = g4.b.a(view, (i11 = R$id.centerControlLayout))) != null) {
            bk.e a17 = bk.e.a(a11);
            i11 = R$id.cl_bottom_control;
            ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
            if (constraintLayout != null) {
                i11 = R$id.fl_native_ad;
                FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                if (frameLayout != null) {
                    i11 = R$id.fl_playing_10_ad_group;
                    FrameLayout frameLayout2 = (FrameLayout) g4.b.a(view, i11);
                    if (frameLayout2 != null) {
                        i11 = R$id.game_container;
                        FrameLayout frameLayout3 = (FrameLayout) g4.b.a(view, i11);
                        if (frameLayout3 != null) {
                            i11 = R$id.group_control_pk;
                            Group group = (Group) g4.b.a(view, i11);
                            if (group != null) {
                                i11 = R$id.iv_brand_ad_logo;
                                ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                                if (shapeableImageView != null) {
                                    i11 = R$id.iv_game_close;
                                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                                    if (appCompatImageView2 != null) {
                                        i11 = R$id.iv_land_pause;
                                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                                        if (appCompatImageView3 != null) {
                                            i11 = R$id.iv_lock;
                                            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                            if (appCompatTextView != null) {
                                                i11 = R$id.iv_play;
                                                AppCompatImageView appCompatImageView4 = (AppCompatImageView) g4.b.a(view, i11);
                                                if (appCompatImageView4 != null) {
                                                    i11 = R$id.iv_play_scale;
                                                    ImmScaleView immScaleView = (ImmScaleView) g4.b.a(view, i11);
                                                    if (immScaleView != null && (a12 = g4.b.a(view, (i11 = R$id.land_gradient_bottom))) != null && (a13 = g4.b.a(view, (i11 = R$id.land_gradient_top))) != null) {
                                                        i11 = R$id.ll_play_scale;
                                                        LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                                                        if (linearLayout != null) {
                                                            i11 = R$id.memberTip;
                                                            LongVodResolutionMemberTipView longVodResolutionMemberTipView = (LongVodResolutionMemberTipView) g4.b.a(view, i11);
                                                            if (longVodResolutionMemberTipView != null && (a14 = g4.b.a(view, (i11 = R$id.operatorLayout))) != null) {
                                                                f a18 = f.a(a14);
                                                                i11 = R$id.seek_bar_land;
                                                                SecondariesSeekBar secondariesSeekBar = (SecondariesSeekBar) g4.b.a(view, i11);
                                                                if (secondariesSeekBar != null) {
                                                                    i11 = R$id.tv_land_bitrate;
                                                                    TextView textView = (TextView) g4.b.a(view, i11);
                                                                    if (textView != null) {
                                                                        i11 = R$id.tv_land_cur_time;
                                                                        TextView textView2 = (TextView) g4.b.a(view, i11);
                                                                        if (textView2 != null) {
                                                                            i11 = R$id.tv_land_total_time;
                                                                            TextView textView3 = (TextView) g4.b.a(view, i11);
                                                                            if (textView3 != null) {
                                                                                i11 = R$id.tv_language;
                                                                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                if (appCompatTextView2 != null) {
                                                                                    i11 = R$id.tvPlayNext;
                                                                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                    if (appCompatTextView3 != null) {
                                                                                        i11 = R$id.tv_play_scale;
                                                                                        TextView textView4 = (TextView) g4.b.a(view, i11);
                                                                                        if (textView4 != null) {
                                                                                            i11 = R$id.tv_play_speed;
                                                                                            ImmSpeedView immSpeedView = (ImmSpeedView) g4.b.a(view, i11);
                                                                                            if (immSpeedView != null && (a15 = g4.b.a(view, (i11 = R$id.v_land_space_end))) != null && (a16 = g4.b.a(view, (i11 = R$id.v_land_space_start))) != null) {
                                                                                                i11 = R$id.v_native_ad;
                                                                                                FrameLayout frameLayout4 = (FrameLayout) g4.b.a(view, i11);
                                                                                                if (frameLayout4 != null) {
                                                                                                    i11 = R$id.v_native_ad_countdown;
                                                                                                    TextView textView5 = (TextView) g4.b.a(view, i11);
                                                                                                    if (textView5 != null) {
                                                                                                        i11 = R$id.vs_forward;
                                                                                                        ViewStub viewStub = (ViewStub) g4.b.a(view, i11);
                                                                                                        if (viewStub != null) {
                                                                                                            i11 = R$id.vs_forward_guide;
                                                                                                            ViewStub viewStub2 = (ViewStub) g4.b.a(view, i11);
                                                                                                            if (viewStub2 != null) {
                                                                                                                return new k((ConstraintLayout) view, appCompatImageView, a17, constraintLayout, frameLayout, frameLayout2, frameLayout3, group, shapeableImageView, appCompatImageView2, appCompatImageView3, appCompatTextView, appCompatImageView4, immScaleView, a12, a13, linearLayout, longVodResolutionMemberTipView, a18, secondariesSeekBar, textView, textView2, textView3, appCompatTextView2, appCompatTextView3, textView4, immSpeedView, a15, a16, frameLayout4, textView5, viewStub, viewStub2);
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
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f64759a;
    }
}
