package rn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.payment.lib.R$id;
import com.transsion.payment.lib.R$layout;
import th.h;

/* loaded from: classes6.dex */
public final class b implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayoutCompat f74703a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f74704b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f74705c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f74706d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f74707e;

    /* renamed from: f, reason: collision with root package name */
    public final ProgressBar f74708f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayoutCompat f74709g;

    /* renamed from: h, reason: collision with root package name */
    public final ConstraintLayout f74710h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f74711i;

    /* renamed from: j, reason: collision with root package name */
    public final h f74712j;

    private b(LinearLayoutCompat linearLayoutCompat, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, ProgressBar progressBar, LinearLayoutCompat linearLayoutCompat2, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, h hVar) {
        this.f74703a = linearLayoutCompat;
        this.f74704b = frameLayout;
        this.f74705c = appCompatImageView;
        this.f74706d = appCompatImageView2;
        this.f74707e = appCompatImageView3;
        this.f74708f = progressBar;
        this.f74709g = linearLayoutCompat2;
        this.f74710h = constraintLayout;
        this.f74711i = appCompatTextView;
        this.f74712j = hVar;
    }

    public static b a(View view) {
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
                                    return new b(linearLayoutCompat, frameLayout, appCompatImageView, appCompatImageView2, appCompatImageView3, progressBar, linearLayoutCompat, constraintLayout, appCompatTextView, h.a(a11));
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_web_pay, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f74703a;
    }
}
