package hm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.lib_web.R$id;
import com.transsion.lib_web.R$layout;
import g4.b;

/* loaded from: classes6.dex */
public final class a implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f64652a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f64653b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f64654c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f64655d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayoutCompat f64656e;

    /* renamed from: f, reason: collision with root package name */
    public final ProgressBar f64657f;

    /* renamed from: g, reason: collision with root package name */
    public final View f64658g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f64659h;

    /* renamed from: i, reason: collision with root package name */
    public final FrameLayout f64660i;

    private a(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, LinearLayoutCompat linearLayoutCompat, ProgressBar progressBar, View view, AppCompatTextView appCompatTextView, FrameLayout frameLayout) {
        this.f64652a = constraintLayout;
        this.f64653b = appCompatImageView;
        this.f64654c = appCompatImageView2;
        this.f64655d = appCompatImageView3;
        this.f64656e = linearLayoutCompat;
        this.f64657f = progressBar;
        this.f64658g = view;
        this.f64659h = appCompatTextView;
        this.f64660i = frameLayout;
    }

    public static a a(View view) {
        View a11;
        int i11 = R$id.ivBack;
        AppCompatImageView appCompatImageView = (AppCompatImageView) b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.ivClose;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.ivRight;
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) b.a(view, i11);
                if (appCompatImageView3 != null) {
                    i11 = R$id.llToolBar;
                    LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) b.a(view, i11);
                    if (linearLayoutCompat != null) {
                        i11 = R$id.progressBar;
                        ProgressBar progressBar = (ProgressBar) b.a(view, i11);
                        if (progressBar != null && (a11 = b.a(view, (i11 = R$id.subWebHeaderBg))) != null) {
                            i11 = R$id.tvTitle;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) b.a(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R$id.webContainer;
                                FrameLayout frameLayout = (FrameLayout) b.a(view, i11);
                                if (frameLayout != null) {
                                    return new a((ConstraintLayout) view, appCompatImageView, appCompatImageView2, appCompatImageView3, linearLayoutCompat, progressBar, a11, appCompatTextView, frameLayout);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.lib_web_web_fragment_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f64652a;
    }
}
