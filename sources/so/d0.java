package so;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.tn.lib.view.SecondariesSeekBar;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.ui.view.ImmSpeedView;

/* loaded from: classes6.dex */
public final class d0 implements g4.a {
    public final AppCompatTextView A;
    public final TextView B;
    public final TextView C;
    public final FrameLayout D;
    public final ViewStub E;
    public final ViewStub F;

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f75589a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f75590b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayoutCompat f75591c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f75592d;

    /* renamed from: e, reason: collision with root package name */
    public final View f75593e;

    /* renamed from: f, reason: collision with root package name */
    public final View f75594f;

    /* renamed from: g, reason: collision with root package name */
    public final po.a f75595g;

    /* renamed from: h, reason: collision with root package name */
    public final fu.j f75596h;

    /* renamed from: i, reason: collision with root package name */
    public final ConstraintLayout f75597i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f75598j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatTextView f75599k;

    /* renamed from: l, reason: collision with root package name */
    public final ImmSpeedView f75600l;

    /* renamed from: m, reason: collision with root package name */
    public final AppCompatTextView f75601m;

    /* renamed from: n, reason: collision with root package name */
    public final AppCompatTextView f75602n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f75603o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f75604p;

    /* renamed from: q, reason: collision with root package name */
    public final View f75605q;

    /* renamed from: r, reason: collision with root package name */
    public final SimpleSubtitleView f75606r;

    /* renamed from: s, reason: collision with root package name */
    public final SimpleSubtitleView f75607s;

    /* renamed from: t, reason: collision with root package name */
    public final p0 f75608t;

    /* renamed from: u, reason: collision with root package name */
    public final AppCompatImageView f75609u;

    /* renamed from: v, reason: collision with root package name */
    public final ConstraintLayout f75610v;

    /* renamed from: w, reason: collision with root package name */
    public final AppCompatTextView f75611w;

    /* renamed from: x, reason: collision with root package name */
    public final Group f75612x;

    /* renamed from: y, reason: collision with root package name */
    public final AppCompatImageView f75613y;

    /* renamed from: z, reason: collision with root package name */
    public final SecondariesSeekBar f75614z;

    private d0(ConstraintLayout constraintLayout, FrameLayout frameLayout, LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView, View view, View view2, po.a aVar, fu.j jVar, ConstraintLayout constraintLayout2, TextView textView, AppCompatTextView appCompatTextView, ImmSpeedView immSpeedView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, TextView textView2, TextView textView3, View view3, SimpleSubtitleView simpleSubtitleView, SimpleSubtitleView simpleSubtitleView2, p0 p0Var, AppCompatImageView appCompatImageView2, ConstraintLayout constraintLayout3, AppCompatTextView appCompatTextView4, Group group, AppCompatImageView appCompatImageView3, SecondariesSeekBar secondariesSeekBar, AppCompatTextView appCompatTextView5, TextView textView4, TextView textView5, FrameLayout frameLayout2, ViewStub viewStub, ViewStub viewStub2) {
        this.f75589a = constraintLayout;
        this.f75590b = frameLayout;
        this.f75591c = linearLayoutCompat;
        this.f75592d = appCompatImageView;
        this.f75593e = view;
        this.f75594f = view2;
        this.f75595g = aVar;
        this.f75596h = jVar;
        this.f75597i = constraintLayout2;
        this.f75598j = textView;
        this.f75599k = appCompatTextView;
        this.f75600l = immSpeedView;
        this.f75601m = appCompatTextView2;
        this.f75602n = appCompatTextView3;
        this.f75603o = textView2;
        this.f75604p = textView3;
        this.f75605q = view3;
        this.f75606r = simpleSubtitleView;
        this.f75607s = simpleSubtitleView2;
        this.f75608t = p0Var;
        this.f75609u = appCompatImageView2;
        this.f75610v = constraintLayout3;
        this.f75611w = appCompatTextView4;
        this.f75612x = group;
        this.f75613y = appCompatImageView3;
        this.f75614z = secondariesSeekBar;
        this.A = appCompatTextView5;
        this.B = textView4;
        this.C = textView5;
        this.D = frameLayout2;
        this.E = viewStub;
        this.F = viewStub2;
    }

    public static d0 a(View view) {
        View a11;
        View a12;
        View a13;
        View a14;
        View a15;
        int i11 = R$id.flRootSubtitle;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.flSubtitle;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) g4.b.a(view, i11);
            if (linearLayoutCompat != null) {
                i11 = R$id.iv_feedback;
                AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView != null && (a11 = g4.b.a(view, (i11 = R$id.land_view1))) != null && (a12 = g4.b.a(view, (i11 = R$id.land_view2))) != null && (a13 = g4.b.a(view, (i11 = R$id.layout_bv))) != null) {
                    po.a a16 = po.a.a(a13);
                    i11 = R$id.layout_sync_adjust;
                    View a17 = g4.b.a(view, i11);
                    if (a17 != null) {
                        fu.j a18 = fu.j.a(a17);
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i11 = R$id.tvHelpTip;
                        TextView textView = (TextView) g4.b.a(view, i11);
                        if (textView != null) {
                            i11 = R$id.tv_language;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R$id.tv_play_speed;
                                ImmSpeedView immSpeedView = (ImmSpeedView) g4.b.a(view, i11);
                                if (immSpeedView != null) {
                                    i11 = R$id.tvPressSpeed;
                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView2 != null) {
                                        i11 = R$id.tvRotate;
                                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                        if (appCompatTextView3 != null) {
                                            i11 = R$id.tv_toast_1;
                                            TextView textView2 = (TextView) g4.b.a(view, i11);
                                            if (textView2 != null) {
                                                i11 = R$id.tv_toast_2;
                                                TextView textView3 = (TextView) g4.b.a(view, i11);
                                                if (textView3 != null && (a14 = g4.b.a(view, (i11 = R$id.v_gesture))) != null) {
                                                    i11 = R$id.vSubtitleBottom;
                                                    SimpleSubtitleView simpleSubtitleView = (SimpleSubtitleView) g4.b.a(view, i11);
                                                    if (simpleSubtitleView != null) {
                                                        i11 = R$id.vSubtitleTop;
                                                        SimpleSubtitleView simpleSubtitleView2 = (SimpleSubtitleView) g4.b.a(view, i11);
                                                        if (simpleSubtitleView2 != null && (a15 = g4.b.a(view, (i11 = R$id.vd_include_load))) != null) {
                                                            p0 a19 = p0.a(a15);
                                                            i11 = R$id.vd_iv_back;
                                                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                                                            if (appCompatImageView2 != null) {
                                                                i11 = R$id.vd_land_bottom_controller;
                                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) g4.b.a(view, i11);
                                                                if (constraintLayout2 != null) {
                                                                    i11 = R$id.vd_land_center_progress;
                                                                    AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                                                    if (appCompatTextView4 != null) {
                                                                        i11 = R$id.vd_land_toolbar;
                                                                        Group group = (Group) g4.b.a(view, i11);
                                                                        if (group != null) {
                                                                            i11 = R$id.vd_pause;
                                                                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                                                                            if (appCompatImageView3 != null) {
                                                                                i11 = R$id.vd_seekbar;
                                                                                SecondariesSeekBar secondariesSeekBar = (SecondariesSeekBar) g4.b.a(view, i11);
                                                                                if (secondariesSeekBar != null) {
                                                                                    i11 = R$id.vd_title;
                                                                                    AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                    if (appCompatTextView5 != null) {
                                                                                        i11 = R$id.vd_video_duration;
                                                                                        TextView textView4 = (TextView) g4.b.a(view, i11);
                                                                                        if (textView4 != null) {
                                                                                            i11 = R$id.vd_video_time;
                                                                                            TextView textView5 = (TextView) g4.b.a(view, i11);
                                                                                            if (textView5 != null) {
                                                                                                i11 = R$id.video_portrait_surface;
                                                                                                FrameLayout frameLayout2 = (FrameLayout) g4.b.a(view, i11);
                                                                                                if (frameLayout2 != null) {
                                                                                                    i11 = R$id.vs_load_failed;
                                                                                                    ViewStub viewStub = (ViewStub) g4.b.a(view, i11);
                                                                                                    if (viewStub != null) {
                                                                                                        i11 = R$id.vs_replay;
                                                                                                        ViewStub viewStub2 = (ViewStub) g4.b.a(view, i11);
                                                                                                        if (viewStub2 != null) {
                                                                                                            return new d0(constraintLayout, frameLayout, linearLayoutCompat, appCompatImageView, a11, a12, a16, a18, constraintLayout, textView, appCompatTextView, immSpeedView, appCompatTextView2, appCompatTextView3, textView2, textView3, a14, simpleSubtitleView, simpleSubtitleView2, a19, appCompatImageView2, constraintLayout2, appCompatTextView4, group, appCompatImageView3, secondariesSeekBar, appCompatTextView5, textView4, textView5, frameLayout2, viewStub, viewStub2);
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
        return this.f75589a;
    }
}
