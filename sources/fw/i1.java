package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: classes7.dex */
public final class i1 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f62816a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatButton f62817b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatEditText f62818c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatEditText f62819d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f62820e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f62821f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayout f62822g;

    /* renamed from: h, reason: collision with root package name */
    public final TitleLayout f62823h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f62824i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatTextView f62825j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatTextView f62826k;

    /* renamed from: l, reason: collision with root package name */
    public final AppCompatTextView f62827l;

    private i1(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, AppCompatEditText appCompatEditText, AppCompatEditText appCompatEditText2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LinearLayout linearLayout, TitleLayout titleLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        this.f62816a = constraintLayout;
        this.f62817b = appCompatButton;
        this.f62818c = appCompatEditText;
        this.f62819d = appCompatEditText2;
        this.f62820e = appCompatImageView;
        this.f62821f = appCompatImageView2;
        this.f62822g = linearLayout;
        this.f62823h = titleLayout;
        this.f62824i = appCompatTextView;
        this.f62825j = appCompatTextView2;
        this.f62826k = appCompatTextView3;
        this.f62827l = appCompatTextView4;
    }

    public static i1 a(View view) {
        int i11 = R$id.btn_submit;
        AppCompatButton appCompatButton = (AppCompatButton) g4.b.a(view, i11);
        if (appCompatButton != null) {
            i11 = R$id.et_desc;
            AppCompatEditText appCompatEditText = (AppCompatEditText) g4.b.a(view, i11);
            if (appCompatEditText != null) {
                i11 = R$id.et_phone;
                AppCompatEditText appCompatEditText2 = (AppCompatEditText) g4.b.a(view, i11);
                if (appCompatEditText2 != null) {
                    i11 = R$id.img_background;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.iv_add_image;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                        if (appCompatImageView2 != null) {
                            i11 = R$id.ll_input;
                            LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                            if (linearLayout != null) {
                                i11 = R$id.toolbar;
                                TitleLayout titleLayout = (TitleLayout) g4.b.a(view, i11);
                                if (titleLayout != null) {
                                    i11 = R$id.tv_desc_num;
                                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView != null) {
                                        i11 = R$id.tv_phone_country_code;
                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                        if (appCompatTextView2 != null) {
                                            i11 = R$id.tv_title_desc;
                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                            if (appCompatTextView3 != null) {
                                                i11 = R$id.whatsapp_hint;
                                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                                if (appCompatTextView4 != null) {
                                                    return new i1((ConstraintLayout) view, appCompatButton, appCompatEditText, appCompatEditText2, appCompatImageView, appCompatImageView2, linearLayout, titleLayout, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static i1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.user_activity_setting_feedback, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f62816a;
    }
}
