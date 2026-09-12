package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: classes7.dex */
public final class z implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f63139a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f63140b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f63141c;

    /* renamed from: d, reason: collision with root package name */
    public final EditTextWithClear f63142d;

    /* renamed from: e, reason: collision with root package name */
    public final EditTextWithClear f63143e;

    /* renamed from: f, reason: collision with root package name */
    public final EditTextWithClear f63144f;

    /* renamed from: g, reason: collision with root package name */
    public final EditTextWithClear f63145g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f63146h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f63147i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatTextView f63148j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatTextView f63149k;

    private z(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, EditTextWithClear editTextWithClear, EditTextWithClear editTextWithClear2, EditTextWithClear editTextWithClear3, EditTextWithClear editTextWithClear4, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6) {
        this.f63139a = constraintLayout;
        this.f63140b = appCompatTextView;
        this.f63141c = appCompatTextView2;
        this.f63142d = editTextWithClear;
        this.f63143e = editTextWithClear2;
        this.f63144f = editTextWithClear3;
        this.f63145g = editTextWithClear4;
        this.f63146h = appCompatTextView3;
        this.f63147i = appCompatTextView4;
        this.f63148j = appCompatTextView5;
        this.f63149k = appCompatTextView6;
    }

    public static z a(View view) {
        int i11 = R$id.btn_ok;
        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.btn_rest;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView2 != null) {
                i11 = R$id.et_address;
                EditTextWithClear editTextWithClear = (EditTextWithClear) g4.b.a(view, i11);
                if (editTextWithClear != null) {
                    i11 = R$id.et_lat;
                    EditTextWithClear editTextWithClear2 = (EditTextWithClear) g4.b.a(view, i11);
                    if (editTextWithClear2 != null) {
                        i11 = R$id.et_lon;
                        EditTextWithClear editTextWithClear3 = (EditTextWithClear) g4.b.a(view, i11);
                        if (editTextWithClear3 != null) {
                            i11 = R$id.et_name;
                            EditTextWithClear editTextWithClear4 = (EditTextWithClear) g4.b.a(view, i11);
                            if (editTextWithClear4 != null) {
                                i11 = R$id.tv_address;
                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView3 != null) {
                                    i11 = R$id.tv_lat;
                                    AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView4 != null) {
                                        i11 = R$id.tv_lon;
                                        AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                                        if (appCompatTextView5 != null) {
                                            i11 = R$id.tv_name;
                                            AppCompatTextView appCompatTextView6 = (AppCompatTextView) g4.b.a(view, i11);
                                            if (appCompatTextView6 != null) {
                                                return new z((ConstraintLayout) view, appCompatTextView, appCompatTextView2, editTextWithClear, editTextWithClear2, editTextWithClear3, editTextWithClear4, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6);
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

    public static z c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.dialog_lab_location, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f63139a;
    }
}
