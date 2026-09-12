package cn;

import android.view.LayoutInflater;
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
public final class j implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17467a;

    /* renamed from: b, reason: collision with root package name */
    public final Group f17468b;

    /* renamed from: c, reason: collision with root package name */
    public final Group f17469c;

    /* renamed from: d, reason: collision with root package name */
    public final ShapeableImageView f17470d;

    /* renamed from: e, reason: collision with root package name */
    public final ShapeableImageView f17471e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f17472f;

    /* renamed from: g, reason: collision with root package name */
    public final ProgressBar f17473g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f17474h;

    /* renamed from: i, reason: collision with root package name */
    public final View f17475i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatImageView f17476j;

    /* renamed from: k, reason: collision with root package name */
    public final SecondariesSeekBar f17477k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f17478l;

    /* renamed from: m, reason: collision with root package name */
    public final ViewStub f17479m;

    private j(ConstraintLayout constraintLayout, Group group, Group group2, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, AppCompatImageView appCompatImageView, ProgressBar progressBar, TextView textView, View view, AppCompatImageView appCompatImageView2, SecondariesSeekBar secondariesSeekBar, TextView textView2, ViewStub viewStub) {
        this.f17467a = constraintLayout;
        this.f17468b = group;
        this.f17469c = group2;
        this.f17470d = shapeableImageView;
        this.f17471e = shapeableImageView2;
        this.f17472f = appCompatImageView;
        this.f17473g = progressBar;
        this.f17474h = textView;
        this.f17475i = view;
        this.f17476j = appCompatImageView2;
        this.f17477k = secondariesSeekBar;
        this.f17478l = textView2;
        this.f17479m = viewStub;
    }

    public static j a(View view) {
        View a11;
        int i11 = R$id.groupLoading;
        Group group = (Group) g4.b.a(view, i11);
        if (group != null) {
            i11 = R$id.groupProgress;
            Group group2 = (Group) g4.b.a(view, i11);
            if (group2 != null) {
                i11 = R$id.ivMovieBlurCover;
                ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                if (shapeableImageView != null) {
                    i11 = R$id.ivMovieCover;
                    ShapeableImageView shapeableImageView2 = (ShapeableImageView) g4.b.a(view, i11);
                    if (shapeableImageView2 != null) {
                        i11 = R$id.ivPlay;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                        if (appCompatImageView != null) {
                            i11 = R$id.progress;
                            ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                            if (progressBar != null) {
                                i11 = R$id.tvLoading;
                                TextView textView = (TextView) g4.b.a(view, i11);
                                if (textView != null && (a11 = g4.b.a(view, (i11 = R$id.vTap))) != null) {
                                    i11 = R$id.vdPause;
                                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                                    if (appCompatImageView2 != null) {
                                        i11 = R$id.vdSeekbar;
                                        SecondariesSeekBar secondariesSeekBar = (SecondariesSeekBar) g4.b.a(view, i11);
                                        if (secondariesSeekBar != null) {
                                            i11 = R$id.vdVideoTime;
                                            TextView textView2 = (TextView) g4.b.a(view, i11);
                                            if (textView2 != null) {
                                                i11 = R$id.vsLoadFailed;
                                                ViewStub viewStub = (ViewStub) g4.b.a(view, i11);
                                                if (viewStub != null) {
                                                    return new j((ConstraintLayout) view, group, group2, shapeableImageView, shapeableImageView2, appCompatImageView, progressBar, textView, a11, appCompatImageView2, secondariesSeekBar, textView2, viewStub);
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

    public static j c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static j d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_music_trailer_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f17467a;
    }
}
