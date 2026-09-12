package wm;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.transsion.baseui.widget.GradientBorderView;
import com.transsion.member.R$id;

/* loaded from: classes6.dex */
public final class j implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f77890a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f77891b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f77892c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f77893d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f77894e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatEditText f77895f;

    /* renamed from: g, reason: collision with root package name */
    public final GradientBorderView f77896g;

    private j(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, AppCompatEditText appCompatEditText, GradientBorderView gradientBorderView) {
        this.f77890a = linearLayout;
        this.f77891b = imageView;
        this.f77892c = imageView2;
        this.f77893d = textView;
        this.f77894e = textView2;
        this.f77895f = appCompatEditText;
        this.f77896g = gradientBorderView;
    }

    public static j a(View view) {
        int i11 = R$id.promo_code_dialog_close;
        ImageView imageView = (ImageView) g4.b.a(view, i11);
        if (imageView != null) {
            i11 = R$id.promo_code_input_clear_iv;
            ImageView imageView2 = (ImageView) g4.b.a(view, i11);
            if (imageView2 != null) {
                i11 = R$id.promo_code_input_confirm;
                TextView textView = (TextView) g4.b.a(view, i11);
                if (textView != null) {
                    i11 = R$id.promo_code_input_error_tips;
                    TextView textView2 = (TextView) g4.b.a(view, i11);
                    if (textView2 != null) {
                        i11 = R$id.promo_code_input_et;
                        AppCompatEditText appCompatEditText = (AppCompatEditText) g4.b.a(view, i11);
                        if (appCompatEditText != null) {
                            i11 = R$id.promo_code_title_layout;
                            GradientBorderView gradientBorderView = (GradientBorderView) g4.b.a(view, i11);
                            if (gradientBorderView != null) {
                                return new j((LinearLayout) view, imageView, imageView2, textView, textView2, appCompatEditText, gradientBorderView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f77890a;
    }
}
