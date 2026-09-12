package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: classes7.dex */
public final class f0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f62773a;

    /* renamed from: b, reason: collision with root package name */
    public final View f62774b;

    /* renamed from: c, reason: collision with root package name */
    public final View f62775c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatCheckBox f62776d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f62777e;

    private f0(ConstraintLayout constraintLayout, View view, View view2, AppCompatCheckBox appCompatCheckBox, AppCompatTextView appCompatTextView) {
        this.f62773a = constraintLayout;
        this.f62774b = view;
        this.f62775c = view2;
        this.f62776d = appCompatCheckBox;
        this.f62777e = appCompatTextView;
    }

    public static f0 a(View view) {
        View a11;
        int i11 = R$id.bgView;
        View a12 = g4.b.a(view, i11);
        if (a12 != null && (a11 = g4.b.a(view, (i11 = R$id.divider))) != null) {
            i11 = R$id.radioButton;
            AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) g4.b.a(view, i11);
            if (appCompatCheckBox != null) {
                i11 = R$id.textView;
                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView != null) {
                    return new f0((ConstraintLayout) view, a12, a11, appCompatCheckBox, appCompatTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static f0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.feedback_option_list_cell, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f62773a;
    }
}
