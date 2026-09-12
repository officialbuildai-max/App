package vp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;

/* loaded from: classes6.dex */
public final class e implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayoutCompat f77507a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatButton f77508b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatEditText f77509c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f77510d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f77511e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f77512f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayoutCompat f77513g;

    /* renamed from: h, reason: collision with root package name */
    public final LinearLayoutCompat f77514h;

    /* renamed from: i, reason: collision with root package name */
    public final LinearLayoutCompat f77515i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatTextView f77516j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatTextView f77517k;

    /* renamed from: l, reason: collision with root package name */
    public final AppCompatTextView f77518l;

    /* renamed from: m, reason: collision with root package name */
    public final AppCompatTextView f77519m;

    /* renamed from: n, reason: collision with root package name */
    public final AppCompatTextView f77520n;

    private e(LinearLayoutCompat linearLayoutCompat, AppCompatButton appCompatButton, AppCompatEditText appCompatEditText, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, LinearLayoutCompat linearLayoutCompat2, LinearLayoutCompat linearLayoutCompat3, LinearLayoutCompat linearLayoutCompat4, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5) {
        this.f77507a = linearLayoutCompat;
        this.f77508b = appCompatButton;
        this.f77509c = appCompatEditText;
        this.f77510d = appCompatImageView;
        this.f77511e = appCompatImageView2;
        this.f77512f = appCompatImageView3;
        this.f77513g = linearLayoutCompat2;
        this.f77514h = linearLayoutCompat3;
        this.f77515i = linearLayoutCompat4;
        this.f77516j = appCompatTextView;
        this.f77517k = appCompatTextView2;
        this.f77518l = appCompatTextView3;
        this.f77519m = appCompatTextView4;
        this.f77520n = appCompatTextView5;
    }

    public static e a(View view) {
        int i11 = R$id.btn_action;
        AppCompatButton appCompatButton = (AppCompatButton) g4.b.a(view, i11);
        if (appCompatButton != null) {
            i11 = R$id.et_phone;
            AppCompatEditText appCompatEditText = (AppCompatEditText) g4.b.a(view, i11);
            if (appCompatEditText != null) {
                i11 = R$id.iv_back;
                AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.iv_clear;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView2 != null) {
                        i11 = R$id.iv_close;
                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                        if (appCompatImageView3 != null) {
                            i11 = R$id.ll_phone_cc;
                            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) g4.b.a(view, i11);
                            if (linearLayoutCompat != null) {
                                i11 = R$id.ll_phone_input_container;
                                LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) g4.b.a(view, i11);
                                if (linearLayoutCompat2 != null) {
                                    LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) view;
                                    i11 = R$id.tv_phone_cc;
                                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView != null) {
                                        i11 = R$id.tv_price;
                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                        if (appCompatTextView2 != null) {
                                            i11 = R$id.tv_product_name;
                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                            if (appCompatTextView3 != null) {
                                                i11 = R$id.tv_subtitle;
                                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                                if (appCompatTextView4 != null) {
                                                    i11 = R$id.tv_title;
                                                    AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                                                    if (appCompatTextView5 != null) {
                                                        return new e(linearLayoutCompat3, appCompatButton, appCompatEditText, appCompatImageView, appCompatImageView2, appCompatImageView3, linearLayoutCompat, linearLayoutCompat2, linearLayoutCompat3, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static e c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.phone_bottom_sheet, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f77507a;
    }
}
