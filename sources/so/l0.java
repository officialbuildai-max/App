package so;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.ui.view.ClipLoading;
import com.transsion.postdetail.ui.view.VideoProgressDragGestureView;

/* loaded from: classes6.dex */
public final class l0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f75714a;

    /* renamed from: b, reason: collision with root package name */
    public final BLView f75715b;

    /* renamed from: c, reason: collision with root package name */
    public final ClipLoading f75716c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f75717d;

    /* renamed from: e, reason: collision with root package name */
    public final Group f75718e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f75719f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f75720g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatImageView f75721h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatImageView f75722i;

    /* renamed from: j, reason: collision with root package name */
    public final ShapeableImageView f75723j;

    /* renamed from: k, reason: collision with root package name */
    public final ShapeableImageView f75724k;

    /* renamed from: l, reason: collision with root package name */
    public final LinearLayout f75725l;

    /* renamed from: m, reason: collision with root package name */
    public final ProgressBar f75726m;

    /* renamed from: n, reason: collision with root package name */
    public final Space f75727n;

    /* renamed from: o, reason: collision with root package name */
    public final AppCompatSeekBar f75728o;

    /* renamed from: p, reason: collision with root package name */
    public final AppCompatTextView f75729p;

    /* renamed from: q, reason: collision with root package name */
    public final AppCompatTextView f75730q;

    /* renamed from: r, reason: collision with root package name */
    public final AppCompatTextView f75731r;

    /* renamed from: s, reason: collision with root package name */
    public final AppCompatTextView f75732s;

    /* renamed from: t, reason: collision with root package name */
    public final AppCompatTextView f75733t;

    /* renamed from: u, reason: collision with root package name */
    public final BLTextView f75734u;

    /* renamed from: v, reason: collision with root package name */
    public final AppCompatTextView f75735v;

    /* renamed from: w, reason: collision with root package name */
    public final BLView f75736w;

    /* renamed from: x, reason: collision with root package name */
    public final VideoProgressDragGestureView f75737x;

    private l0(View view, BLView bLView, ClipLoading clipLoading, FrameLayout frameLayout, Group group, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, LinearLayout linearLayout, ProgressBar progressBar, Space space, AppCompatSeekBar appCompatSeekBar, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, BLTextView bLTextView, AppCompatTextView appCompatTextView6, BLView bLView2, VideoProgressDragGestureView videoProgressDragGestureView) {
        this.f75714a = view;
        this.f75715b = bLView;
        this.f75716c = clipLoading;
        this.f75717d = frameLayout;
        this.f75718e = group;
        this.f75719f = appCompatImageView;
        this.f75720g = appCompatImageView2;
        this.f75721h = appCompatImageView3;
        this.f75722i = appCompatImageView4;
        this.f75723j = shapeableImageView;
        this.f75724k = shapeableImageView2;
        this.f75725l = linearLayout;
        this.f75726m = progressBar;
        this.f75727n = space;
        this.f75728o = appCompatSeekBar;
        this.f75729p = appCompatTextView;
        this.f75730q = appCompatTextView2;
        this.f75731r = appCompatTextView3;
        this.f75732s = appCompatTextView4;
        this.f75733t = appCompatTextView5;
        this.f75734u = bLTextView;
        this.f75735v = appCompatTextView6;
        this.f75736w = bLView2;
        this.f75737x = videoProgressDragGestureView;
    }

    public static l0 a(View view) {
        int i11 = R$id.bottom_background;
        BLView bLView = (BLView) g4.b.a(view, i11);
        if (bLView != null) {
            i11 = R$id.cl_loading;
            ClipLoading clipLoading = (ClipLoading) g4.b.a(view, i11);
            if (clipLoading != null) {
                i11 = R$id.fl_container;
                FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                if (frameLayout != null) {
                    i11 = R$id.group_content;
                    Group group = (Group) g4.b.a(view, i11);
                    if (group != null) {
                        i11 = R$id.iv_cover;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                        if (appCompatImageView != null) {
                            i11 = R$id.iv_download;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                            if (appCompatImageView2 != null) {
                                i11 = R$id.iv_pause;
                                AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                                if (appCompatImageView3 != null) {
                                    i11 = R$id.iv_share;
                                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) g4.b.a(view, i11);
                                    if (appCompatImageView4 != null) {
                                        i11 = R$id.iv_short_cover;
                                        ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                                        if (shapeableImageView != null) {
                                            i11 = R$id.iv_video_avatar;
                                            ShapeableImageView shapeableImageView2 = (ShapeableImageView) g4.b.a(view, i11);
                                            if (shapeableImageView2 != null) {
                                                i11 = R$id.llOperationLayout;
                                                LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                                                if (linearLayout != null) {
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
                                                                    i11 = R$id.tv_desc;
                                                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                                                    if (appCompatTextView2 != null) {
                                                                        i11 = R$id.tv_favorite;
                                                                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                                                        if (appCompatTextView3 != null) {
                                                                            i11 = R$id.tv_like;
                                                                            AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                                                            if (appCompatTextView4 != null) {
                                                                                i11 = R$id.tv_progress_des;
                                                                                AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                if (appCompatTextView5 != null) {
                                                                                    i11 = R$id.tv_short_tv_ep;
                                                                                    BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
                                                                                    if (bLTextView != null) {
                                                                                        i11 = R$id.tv_title;
                                                                                        AppCompatTextView appCompatTextView6 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                        if (appCompatTextView6 != null) {
                                                                                            i11 = R$id.up_background;
                                                                                            BLView bLView2 = (BLView) g4.b.a(view, i11);
                                                                                            if (bLView2 != null) {
                                                                                                i11 = R$id.v_progress_gesture;
                                                                                                VideoProgressDragGestureView videoProgressDragGestureView = (VideoProgressDragGestureView) g4.b.a(view, i11);
                                                                                                if (videoProgressDragGestureView != null) {
                                                                                                    return new l0(view, bLView, clipLoading, frameLayout, group, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, shapeableImageView, shapeableImageView2, linearLayout, progressBar, space, appCompatSeekBar, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, bLTextView, appCompatTextView6, bLView2, videoProgressDragGestureView);
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
        return this.f75714a;
    }
}
