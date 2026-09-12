package so;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;

/* loaded from: classes6.dex */
public final class x implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f75882a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatCheckBox f75883b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f75884c;

    private x(ConstraintLayout constraintLayout, AppCompatCheckBox appCompatCheckBox, AppCompatTextView appCompatTextView) {
        this.f75882a = constraintLayout;
        this.f75883b = appCompatCheckBox;
        this.f75884c = appCompatTextView;
    }

    public static x a(View view) {
        int i11 = R$id.radioButton;
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) g4.b.a(view, i11);
        if (appCompatCheckBox != null) {
            i11 = R$id.tvReasonTitle;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                return new x((ConstraintLayout) view, appCompatCheckBox, appCompatTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static x c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.item_report_reason, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f75882a;
    }
}
