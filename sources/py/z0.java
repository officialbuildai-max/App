package py;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLFrameLayout;
import com.tn.lib.view.CircleProgressBar;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class z0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f73126a;

    /* renamed from: b, reason: collision with root package name */
    public final BLFrameLayout f73127b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f73128c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f73129d;

    /* renamed from: e, reason: collision with root package name */
    public final View f73130e;

    /* renamed from: f, reason: collision with root package name */
    public final CircleProgressBar f73131f;

    /* renamed from: g, reason: collision with root package name */
    public final RecyclerView f73132g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f73133h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f73134i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatTextView f73135j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatTextView f73136k;

    /* renamed from: l, reason: collision with root package name */
    public final View f73137l;

    /* renamed from: m, reason: collision with root package name */
    public final View f73138m;

    private z0(ConstraintLayout constraintLayout, BLFrameLayout bLFrameLayout, ImageView imageView, AppCompatImageView appCompatImageView, View view, CircleProgressBar circleProgressBar, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, View view2, View view3) {
        this.f73126a = constraintLayout;
        this.f73127b = bLFrameLayout;
        this.f73128c = imageView;
        this.f73129d = appCompatImageView;
        this.f73130e = view;
        this.f73131f = circleProgressBar;
        this.f73132g = recyclerView;
        this.f73133h = appCompatTextView;
        this.f73134i = appCompatTextView2;
        this.f73135j = appCompatTextView3;
        this.f73136k = appCompatTextView4;
        this.f73137l = view2;
        this.f73138m = view3;
    }

    public static z0 a(View view) {
        View a11;
        View a12;
        View a13;
        int i11 = R$id.fl_loading;
        BLFrameLayout bLFrameLayout = (BLFrameLayout) g4.b.a(view, i11);
        if (bLFrameLayout != null) {
            i11 = R$id.iv_close;
            ImageView imageView = (ImageView) g4.b.a(view, i11);
            if (imageView != null) {
                i11 = R$id.iv_save_close;
                AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView != null && (a11 = g4.b.a(view, (i11 = R$id.line))) != null) {
                    i11 = R$id.progress_bar;
                    CircleProgressBar circleProgressBar = (CircleProgressBar) g4.b.a(view, i11);
                    if (circleProgressBar != null) {
                        i11 = R$id.recycler_view;
                        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                        if (recyclerView != null) {
                            i11 = R$id.tv_btn_confirm;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R$id.tv_progress;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView2 != null) {
                                    i11 = R$id.tv_tips;
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView3 != null) {
                                        i11 = R$id.tv_title;
                                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                        if (appCompatTextView4 != null && (a12 = g4.b.a(view, (i11 = R$id.v_bottom))) != null && (a13 = g4.b.a(view, (i11 = R$id.v_loading_intercept))) != null) {
                                            return new z0((ConstraintLayout) view, bLFrameLayout, imageView, appCompatImageView, a11, circleProgressBar, recyclerView, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, a12, a13);
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
        return this.f73126a;
    }
}
