package zy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsnet.login.R$id;
import com.transsnet.login.R$layout;
import com.transsnet.login.phone.widget.LoginPwdEditText;

/* loaded from: classes7.dex */
public final class h implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f79696a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f79697b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatButton f79698c;

    /* renamed from: d, reason: collision with root package name */
    public final LoginPwdEditText f79699d;

    /* renamed from: e, reason: collision with root package name */
    public final l f79700e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f79701f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f79702g;

    /* renamed from: h, reason: collision with root package name */
    public final ViewStub f79703h;

    private h(LinearLayout linearLayout, AppCompatImageView appCompatImageView, AppCompatButton appCompatButton, LoginPwdEditText loginPwdEditText, l lVar, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, ViewStub viewStub) {
        this.f79696a = linearLayout;
        this.f79697b = appCompatImageView;
        this.f79698c = appCompatButton;
        this.f79699d = loginPwdEditText;
        this.f79700e = lVar;
        this.f79701f = appCompatTextView;
        this.f79702g = appCompatTextView2;
        this.f79703h = viewStub;
    }

    public static h a(View view) {
        View a11;
        int i11 = R$id.btn_eye;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.btn_login;
            AppCompatButton appCompatButton = (AppCompatButton) g4.b.a(view, i11);
            if (appCompatButton != null) {
                i11 = R$id.et_pwd;
                LoginPwdEditText loginPwdEditText = (LoginPwdEditText) g4.b.a(view, i11);
                if (loginPwdEditText != null && (a11 = g4.b.a(view, (i11 = R$id.title))) != null) {
                    l a12 = l.a(a11);
                    i11 = R$id.tv_tips;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView != null) {
                        i11 = R$id.tv_welcome;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView2 != null) {
                            i11 = R$id.vs_invitation_code;
                            ViewStub viewStub = (ViewStub) g4.b.a(view, i11);
                            if (viewStub != null) {
                                return new h((LinearLayout) view, appCompatImageView, appCompatButton, loginPwdEditText, a12, appCompatTextView, appCompatTextView2, viewStub);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static h c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static h d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.login_activity_phone_set_pwd, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f79696a;
    }
}
