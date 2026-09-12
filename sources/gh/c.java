package gh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.tranpay.R$id;
import com.tn.lib.tranpay.R$layout;

/* loaded from: classes4.dex */
public final class c implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayoutCompat f63727a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f63728b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f63729c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f63730d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f63731e;

    /* renamed from: f, reason: collision with root package name */
    public final ProgressBar f63732f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayoutCompat f63733g;

    /* renamed from: h, reason: collision with root package name */
    public final ConstraintLayout f63734h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f63735i;

    /* renamed from: j, reason: collision with root package name */
    public final d f63736j;

    private c(LinearLayoutCompat linearLayoutCompat, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, ProgressBar progressBar, LinearLayoutCompat linearLayoutCompat2, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, d dVar) {
        this.f63727a = linearLayoutCompat;
        this.f63728b = frameLayout;
        this.f63729c = appCompatImageView;
        this.f63730d = appCompatImageView2;
        this.f63731e = appCompatImageView3;
        this.f63732f = progressBar;
        this.f63733g = linearLayoutCompat2;
        this.f63734h = constraintLayout;
        this.f63735i = appCompatTextView;
        this.f63736j = dVar;
    }

    public static c a(View view) {
        View a11;
        int i11 = R$id.fl_web;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.iv_back;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.iv_close;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R$id.iv_right;
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView3 != null) {
                        i11 = R$id.progress;
                        ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                        if (progressBar != null) {
                            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
                            i11 = R$id.tool_bar;
                            ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
                            if (constraintLayout != null) {
                                i11 = R$id.tv_titleText;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView != null && (a11 = g4.b.a(view, (i11 = R$id.web_pay_include_loading))) != null) {
                                    return new c(linearLayoutCompat, frameLayout, appCompatImageView, appCompatImageView2, appCompatImageView3, progressBar, linearLayoutCompat, constraintLayout, appCompatTextView, d.a(a11));
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static c c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static c d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.tran_fragment_web_pay, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f63727a;
    }
}
