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
import com.transsnet.login.R$id;
import com.transsnet.login.R$layout;

/* loaded from: classes7.dex */
public final class j implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f79709a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f79710b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageButton f79711c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatButton f79712d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatButton f79713e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatEditText f79714f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayout f79715g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f79716h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f79717i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatTextView f79718j;

    private j(LinearLayout linearLayout, AppCompatImageView appCompatImageView, AppCompatImageButton appCompatImageButton, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, AppCompatEditText appCompatEditText, LinearLayout linearLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.f79709a = linearLayout;
        this.f79710b = appCompatImageView;
        this.f79711c = appCompatImageButton;
        this.f79712d = appCompatButton;
        this.f79713e = appCompatButton2;
        this.f79714f = appCompatEditText;
        this.f79715g = linearLayout2;
        this.f79716h = appCompatTextView;
        this.f79717i = appCompatTextView2;
        this.f79718j = appCompatTextView3;
    }

    public static j a(View view) {
        int i11 = R$id.btn_back;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.btn_clear;
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) g4.b.a(view, i11);
            if (appCompatImageButton != null) {
                i11 = R$id.btn_email;
                AppCompatButton appCompatButton = (AppCompatButton) g4.b.a(view, i11);
                if (appCompatButton != null) {
                    i11 = R$id.btn_login;
                    AppCompatButton appCompatButton2 = (AppCompatButton) g4.b.a(view, i11);
                    if (appCompatButton2 != null) {
                        i11 = R$id.et_phone;
                        AppCompatEditText appCompatEditText = (AppCompatEditText) g4.b.a(view, i11);
                        if (appCompatEditText != null) {
                            i11 = R$id.ll_input;
                            LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                            if (linearLayout != null) {
                                i11 = R$id.tv_phone_country_code;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView != null) {
                                    i11 = R$id.tv_privacy;
                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView2 != null) {
                                        i11 = R$id.tv_tips;
                                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                        if (appCompatTextView3 != null) {
                                            return new j((LinearLayout) view, appCompatImageView, appCompatImageButton, appCompatButton, appCompatButton2, appCompatEditText, linearLayout, appCompatTextView, appCompatTextView2, appCompatTextView3);
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
        View inflate = layoutInflater.inflate(R$layout.login_fragment_phone, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f79709a;
    }
}
