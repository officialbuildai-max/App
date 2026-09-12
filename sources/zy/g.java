package zy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsnet.login.R$id;
import com.transsnet.login.R$layout;
import com.transsnet.login.phone.widget.LoginPwdEditText;

/* loaded from: classes7.dex */
public final class g implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f79681a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f79682b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageButton f79683c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f79684d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f79685e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatButton f79686f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatEditText f79687g;

    /* renamed from: h, reason: collision with root package name */
    public final LoginPwdEditText f79688h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatImageView f79689i;

    /* renamed from: j, reason: collision with root package name */
    public final ConstraintLayout f79690j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatTextView f79691k;

    /* renamed from: l, reason: collision with root package name */
    public final AppCompatTextView f79692l;

    /* renamed from: m, reason: collision with root package name */
    public final AppCompatTextView f79693m;

    /* renamed from: n, reason: collision with root package name */
    public final AppCompatTextView f79694n;

    /* renamed from: o, reason: collision with root package name */
    public final View f79695o;

    private g(LinearLayout linearLayout, AppCompatImageView appCompatImageView, AppCompatImageButton appCompatImageButton, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView2, AppCompatButton appCompatButton, AppCompatEditText appCompatEditText, LoginPwdEditText loginPwdEditText, AppCompatImageView appCompatImageView3, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, View view) {
        this.f79681a = linearLayout;
        this.f79682b = appCompatImageView;
        this.f79683c = appCompatImageButton;
        this.f79684d = appCompatTextView;
        this.f79685e = appCompatImageView2;
        this.f79686f = appCompatButton;
        this.f79687g = appCompatEditText;
        this.f79688h = loginPwdEditText;
        this.f79689i = appCompatImageView3;
        this.f79690j = constraintLayout;
        this.f79691k = appCompatTextView2;
        this.f79692l = appCompatTextView3;
        this.f79693m = appCompatTextView4;
        this.f79694n = appCompatTextView5;
        this.f79695o = view;
    }

    public static g a(View view) {
        View a11;
        int i11 = R$id.btn_back;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.btn_clear;
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) g4.b.a(view, i11);
            if (appCompatImageButton != null) {
                i11 = R$id.btn_email;
                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.btn_eye;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView2 != null) {
                        i11 = R$id.btn_login;
                        AppCompatButton appCompatButton = (AppCompatButton) g4.b.a(view, i11);
                        if (appCompatButton != null) {
                            i11 = R$id.et_phone;
                            AppCompatEditText appCompatEditText = (AppCompatEditText) g4.b.a(view, i11);
                            if (appCompatEditText != null) {
                                i11 = R$id.et_pwd;
                                LoginPwdEditText loginPwdEditText = (LoginPwdEditText) g4.b.a(view, i11);
                                if (loginPwdEditText != null) {
                                    i11 = R$id.iv_arrow;
                                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                                    if (appCompatImageView3 != null) {
                                        i11 = R$id.ll_input;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
                                        if (constraintLayout != null) {
                                            i11 = R$id.tv_forget_pwd;
                                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                            if (appCompatTextView2 != null) {
                                                i11 = R$id.tv_phone_country_code;
                                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                                if (appCompatTextView3 != null) {
                                                    i11 = R$id.tv_privacy;
                                                    AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                                    if (appCompatTextView4 != null) {
                                                        i11 = R$id.tv_tips;
                                                        AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                                                        if (appCompatTextView5 != null && (a11 = g4.b.a(view, (i11 = R$id.v_line))) != null) {
                                                            return new g((LinearLayout) view, appCompatImageView, appCompatImageButton, appCompatTextView, appCompatImageView2, appCompatButton, appCompatEditText, loginPwdEditText, appCompatImageView3, constraintLayout, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, a11);
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

    public static g c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static g d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.login_activity_phone_pwd, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f79681a;
    }
}
