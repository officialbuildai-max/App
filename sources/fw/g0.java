package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.setting.labelsfeedback.UCEditText;

/* loaded from: classes7.dex */
public final class g0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f62785a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f62786b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatEditText f62787c;

    /* renamed from: d, reason: collision with root package name */
    public final UCEditText f62788d;

    /* renamed from: e, reason: collision with root package name */
    public final ShapeableImageView f62789e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatEditText f62790f;

    /* renamed from: g, reason: collision with root package name */
    public final View f62791g;

    private g0(LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatEditText appCompatEditText, UCEditText uCEditText, ShapeableImageView shapeableImageView, AppCompatEditText appCompatEditText2, View view) {
        this.f62785a = linearLayout;
        this.f62786b = appCompatTextView;
        this.f62787c = appCompatEditText;
        this.f62788d = uCEditText;
        this.f62789e = shapeableImageView;
        this.f62790f = appCompatEditText2;
        this.f62791g = view;
    }

    public static g0 a(View view) {
        View a11;
        int i11 = R$id.countTextView;
        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.countryEditText;
            AppCompatEditText appCompatEditText = (AppCompatEditText) g4.b.a(view, i11);
            if (appCompatEditText != null) {
                i11 = R$id.editText;
                UCEditText uCEditText = (UCEditText) g4.b.a(view, i11);
                if (uCEditText != null) {
                    i11 = R$id.imageView;
                    ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                    if (shapeableImageView != null) {
                        i11 = R$id.phoneEditText;
                        AppCompatEditText appCompatEditText2 = (AppCompatEditText) g4.b.a(view, i11);
                        if (appCompatEditText2 != null && (a11 = g4.b.a(view, (i11 = R$id.view6))) != null) {
                            return new g0((LinearLayout) view, appCompatTextView, appCompatEditText, uCEditText, shapeableImageView, appCompatEditText2, a11);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static g0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.feedback_option_list_footer, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f62785a;
    }
}
