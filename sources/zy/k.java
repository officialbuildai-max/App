package zy;

import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsnet.login.R$id;

/* loaded from: classes7.dex */
public final class k implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f79719a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatEditText f79720b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f79721c;

    /* renamed from: d, reason: collision with root package name */
    public final View f79722d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f79723e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f79724f;

    private k(ConstraintLayout constraintLayout, AppCompatEditText appCompatEditText, AppCompatImageView appCompatImageView, View view, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.f79719a = constraintLayout;
        this.f79720b = appCompatEditText;
        this.f79721c = appCompatImageView;
        this.f79722d = view;
        this.f79723e = appCompatTextView;
        this.f79724f = appCompatTextView2;
    }

    public static k a(View view) {
        View a11;
        int i11 = R$id.et_code;
        AppCompatEditText appCompatEditText = (AppCompatEditText) g4.b.a(view, i11);
        if (appCompatEditText != null) {
            i11 = R$id.iv_help;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null && (a11 = g4.b.a(view, (i11 = R$id.line))) != null) {
                i11 = R$id.tv_hava_invitation_code;
                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.tv_tips;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView2 != null) {
                        return new k((ConstraintLayout) view, appCompatEditText, appCompatImageView, a11, appCompatTextView, appCompatTextView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f79719a;
    }
}
