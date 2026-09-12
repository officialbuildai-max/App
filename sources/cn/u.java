package cn;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.SecondariesSeekBar;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;

/* loaded from: classes5.dex */
public final class u implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17581a;

    /* renamed from: b, reason: collision with root package name */
    public final Group f17582b;

    /* renamed from: c, reason: collision with root package name */
    public final Group f17583c;

    /* renamed from: d, reason: collision with root package name */
    public final ShapeableImageView f17584d;

    /* renamed from: e, reason: collision with root package name */
    public final ShapeableImageView f17585e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f17586f;

    /* renamed from: g, reason: collision with root package name */
    public final ProgressBar f17587g;

    /* renamed from: h, reason: collision with root package name */
    public final TextureView f17588h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f17589i;

    /* renamed from: j, reason: collision with root package name */
    public final View f17590j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatImageView f17591k;

    /* renamed from: l, reason: collision with root package name */
    public final SecondariesSeekBar f17592l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f17593m;

    /* renamed from: n, reason: collision with root package name */
    public final ViewStub f17594n;

    private u(ConstraintLayout constraintLayout, Group group, Group group2, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, AppCompatImageView appCompatImageView, ProgressBar progressBar, TextureView textureView, TextView textView, View view, AppCompatImageView appCompatImageView2, SecondariesSeekBar secondariesSeekBar, TextView textView2, ViewStub viewStub) {
        this.f17581a = constraintLayout;
        this.f17582b = group;
        this.f17583c = group2;
        this.f17584d = shapeableImageView;
        this.f17585e = shapeableImageView2;
        this.f17586f = appCompatImageView;
        this.f17587g = progressBar;
        this.f17588h = textureView;
        this.f17589i = textView;
        this.f17590j = view;
        this.f17591k = appCompatImageView2;
        this.f17592l = secondariesSeekBar;
        this.f17593m = textView2;
        this.f17594n = viewStub;
    }

    public static u a(View view) {
        View a11;
        int i11 = R$id.group_loading;
        Group group = (Group) g4.b.a(view, i11);
        if (group != null) {
            i11 = R$id.group_progress;
            Group group2 = (Group) g4.b.a(view, i11);
            if (group2 != null) {
                i11 = R$id.ivMovieBlurCover;
                ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                if (shapeableImageView != null) {
                    i11 = R$id.ivMovieCover;
                    ShapeableImageView shapeableImageView2 = (ShapeableImageView) g4.b.a(view, i11);
                    if (shapeableImageView2 != null) {
                        i11 = R$id.iv_play;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                        if (appCompatImageView != null) {
                            i11 = R$id.progress;
                            ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                            if (progressBar != null) {
                                i11 = R$id.textureView;
                                TextureView textureView = (TextureView) g4.b.a(view, i11);
                                if (textureView != null) {
                                    i11 = R$id.tv_loading;
                                    TextView textView = (TextView) g4.b.a(view, i11);
                                    if (textView != null && (a11 = g4.b.a(view, (i11 = R$id.v_tap))) != null) {
                                        i11 = R$id.vd_pause;
                                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                                        if (appCompatImageView2 != null) {
                                            i11 = R$id.vd_seekbar;
                                            SecondariesSeekBar secondariesSeekBar = (SecondariesSeekBar) g4.b.a(view, i11);
                                            if (secondariesSeekBar != null) {
                                                i11 = R$id.vd_video_time;
                                                TextView textView2 = (TextView) g4.b.a(view, i11);
                                                if (textView2 != null) {
                                                    i11 = R$id.vs_load_failed;
                                                    ViewStub viewStub = (ViewStub) g4.b.a(view, i11);
                                                    if (viewStub != null) {
                                                        return new u((ConstraintLayout) view, group, group2, shapeableImageView, shapeableImageView2, appCompatImageView, progressBar, textureView, textView, a11, appCompatImageView2, secondariesSeekBar, textView2, viewStub);
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

    public static u c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static u d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_trailer, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f17581a;
    }
}
