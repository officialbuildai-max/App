package zy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsnet.login.R$id;
import com.transsnet.login.R$layout;

/* loaded from: classes7.dex */
public final class f implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f79673a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatButton f79674b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f79675c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatEditText f79676d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f79677e;

    /* renamed from: f, reason: collision with root package name */
    public final l f79678f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f79679g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f79680h;

    private f(LinearLayout linearLayout, AppCompatButton appCompatButton, AppCompatTextView appCompatTextView, AppCompatEditText appCompatEditText, FrameLayout frameLayout, l lVar, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.f79673a = linearLayout;
        this.f79674b = appCompatButton;
        this.f79675c = appCompatTextView;
        this.f79676d = appCompatEditText;
        this.f79677e = frameLayout;
        this.f79678f = lVar;
        this.f79679g = appCompatTextView2;
        this.f79680h = appCompatTextView3;
    }

    public static f a(View view) {
        View a11;
        int i11 = R$id.btn_login;
        AppCompatButton appCompatButton = (AppCompatButton) g4.b.a(view, i11);
        if (appCompatButton != null) {
            i11 = R$id.btn_resend;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.et_code;
                AppCompatEditText appCompatEditText = (AppCompatEditText) g4.b.a(view, i11);
                if (appCompatEditText != null) {
                    i11 = R$id.ll_input;
                    FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                    if (frameLayout != null && (a11 = g4.b.a(view, (i11 = R$id.title))) != null) {
                        l a12 = l.a(a11);
                        i11 = R$id.tv_code_tips;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView2 != null) {
                            i11 = R$id.tv_tips;
                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView3 != null) {
                                return new f((LinearLayout) view, appCompatButton, appCompatTextView, appCompatEditText, frameLayout, a12, appCompatTextView2, appCompatTextView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static f c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static f d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.login_activity_phone_code, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f79673a;
    }
}
