package fw;

import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textfield.TextInputLayout;
import com.transsion.usercenter.R$id;

/* loaded from: classes7.dex */
public final class a0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f62697a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f62698b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f62699c;

    /* renamed from: d, reason: collision with root package name */
    public final EditText f62700d;

    /* renamed from: e, reason: collision with root package name */
    public final TextInputLayout f62701e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f62702f;

    private a0(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, EditText editText, TextInputLayout textInputLayout, AppCompatTextView appCompatTextView3) {
        this.f62697a = constraintLayout;
        this.f62698b = appCompatTextView;
        this.f62699c = appCompatTextView2;
        this.f62700d = editText;
        this.f62701e = textInputLayout;
        this.f62702f = appCompatTextView3;
    }

    public static a0 a(View view) {
        int i11 = R$id.btn_cancel;
        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.btn_ok;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView2 != null) {
                i11 = R$id.et_pwd;
                EditText editText = (EditText) g4.b.a(view, i11);
                if (editText != null) {
                    i11 = R$id.til_pwd;
                    TextInputLayout textInputLayout = (TextInputLayout) g4.b.a(view, i11);
                    if (textInputLayout != null) {
                        i11 = R$id.tv_title;
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView3 != null) {
                            return new a0((ConstraintLayout) view, appCompatTextView, appCompatTextView2, editText, textInputLayout, appCompatTextView3);
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
        return this.f62697a;
    }
}
