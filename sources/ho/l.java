package ho;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.SecondariesSeekBar;
import com.transsion.player.longvideo.R$id;

/* loaded from: classes6.dex */
public final class l implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f64785a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f64786b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f64787c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f64788d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f64789e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f64790f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f64791g;

    /* renamed from: h, reason: collision with root package name */
    public final d f64792h;

    /* renamed from: i, reason: collision with root package name */
    public final LinearLayout f64793i;

    /* renamed from: j, reason: collision with root package name */
    public final View f64794j;

    /* renamed from: k, reason: collision with root package name */
    public final View f64795k;

    /* renamed from: l, reason: collision with root package name */
    public final View f64796l;

    /* renamed from: m, reason: collision with root package name */
    public final f f64797m;

    /* renamed from: n, reason: collision with root package name */
    public final SecondariesSeekBar f64798n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f64799o;

    /* renamed from: p, reason: collision with root package name */
    public final ViewStub f64800p;

    /* renamed from: q, reason: collision with root package name */
    public final ViewStub f64801q;

    private l(ConstraintLayout constraintLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, ImageView imageView, d dVar, LinearLayout linearLayout, View view, View view2, View view3, f fVar, SecondariesSeekBar secondariesSeekBar, TextView textView, ViewStub viewStub, ViewStub viewStub2) {
        this.f64785a = constraintLayout;
        this.f64786b = frameLayout;
        this.f64787c = appCompatImageView;
        this.f64788d = appCompatImageView2;
        this.f64789e = appCompatImageView3;
        this.f64790f = appCompatImageView4;
        this.f64791g = imageView;
        this.f64792h = dVar;
        this.f64793i = linearLayout;
        this.f64794j = view;
        this.f64795k = view2;
        this.f64796l = view3;
        this.f64797m = fVar;
        this.f64798n = secondariesSeekBar;
        this.f64799o = textView;
        this.f64800p = viewStub;
        this.f64801q = viewStub2;
    }

    public static l a(View view) {
        View a11;
        View a12;
        View a13;
        View a14;
        View a15;
        int i11 = R$id.flUGCAutoPlayGroup;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.iv_back;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.iv_float;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R$id.iv_middle_pause;
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView3 != null) {
                        i11 = R$id.iv_middle_screen_change;
                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) g4.b.a(view, i11);
                        if (appCompatImageView4 != null) {
                            i11 = R$id.ivUGCAutoPlayBtn;
                            ImageView imageView = (ImageView) g4.b.a(view, i11);
                            if (imageView != null && (a11 = g4.b.a(view, (i11 = R$id.layout_loading))) != null) {
                                d a16 = d.a(a11);
                                i11 = R$id.ll_middle_bottom_controller;
                                LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                                if (linearLayout != null && (a12 = g4.b.a(view, (i11 = R$id.middle_gradient_bottom))) != null && (a13 = g4.b.a(view, (i11 = R$id.middle_gradient_top))) != null && (a14 = g4.b.a(view, (i11 = R$id.middle_guideline))) != null && (a15 = g4.b.a(view, (i11 = R$id.operatorLayout))) != null) {
                                    f a17 = f.a(a15);
                                    i11 = R$id.seek_bar_middle;
                                    SecondariesSeekBar secondariesSeekBar = (SecondariesSeekBar) g4.b.a(view, i11);
                                    if (secondariesSeekBar != null) {
                                        i11 = R$id.tv_middle_time;
                                        TextView textView = (TextView) g4.b.a(view, i11);
                                        if (textView != null) {
                                            i11 = R$id.vs_forward_guide_middle;
                                            ViewStub viewStub = (ViewStub) g4.b.a(view, i11);
                                            if (viewStub != null) {
                                                i11 = R$id.vs_forward_middle;
                                                ViewStub viewStub2 = (ViewStub) g4.b.a(view, i11);
                                                if (viewStub2 != null) {
                                                    return new l((ConstraintLayout) view, frameLayout, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, imageView, a16, linearLayout, a12, a13, a14, a17, secondariesSeekBar, textView, viewStub, viewStub2);
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
        return this.f64785a;
    }
}
