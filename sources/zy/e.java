package zy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsnet.login.R$id;
import com.transsnet.login.R$layout;

/* loaded from: classes7.dex */
public final class e implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f79663a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f79664b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f79665c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f79666d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayout f79667e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f79668f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f79669g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f79670h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f79671i;

    /* renamed from: j, reason: collision with root package name */
    public final View f79672j;

    private e(LinearLayout linearLayout, FrameLayout frameLayout, FrameLayout frameLayout2, AppCompatImageView appCompatImageView, LinearLayout linearLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, View view) {
        this.f79663a = linearLayout;
        this.f79664b = frameLayout;
        this.f79665c = frameLayout2;
        this.f79666d = appCompatImageView;
        this.f79667e = linearLayout2;
        this.f79668f = appCompatTextView;
        this.f79669g = appCompatTextView2;
        this.f79670h = appCompatTextView3;
        this.f79671i = appCompatTextView4;
        this.f79672j = view;
    }

    public static e a(View view) {
        View a11;
        int i11 = R$id.btn_email_login;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.btn_gp_login;
            FrameLayout frameLayout2 = (FrameLayout) g4.b.a(view, i11);
            if (frameLayout2 != null) {
                i11 = R$id.ll_close;
                AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.rl_login;
                    LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                    if (linearLayout != null) {
                        i11 = R$id.tv_email_login_text;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView != null) {
                            i11 = R$id.tv_log_in;
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView2 != null) {
                                i11 = R$id.tv_privacy;
                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView3 != null) {
                                    i11 = R$id.tv_title;
                                    AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView4 != null && (a11 = g4.b.a(view, (i11 = R$id.view_blank))) != null) {
                                        return new e((LinearLayout) view, frameLayout, frameLayout2, appCompatImageView, linearLayout, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, a11);
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

    public static e c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static e d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.login_activity_like, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f79663a;
    }
}
