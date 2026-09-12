package gh;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.tn.lib.tranpay.R$id;

/* loaded from: classes4.dex */
public final class b implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayoutCompat f63702a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f63703b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f63704c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatEditText f63705d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatEditText f63706e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f63707f;

    /* renamed from: g, reason: collision with root package name */
    public final FrameLayout f63708g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatImageView f63709h;

    /* renamed from: i, reason: collision with root package name */
    public final ConstraintLayout f63710i;

    /* renamed from: j, reason: collision with root package name */
    public final View f63711j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatTextView f63712k;

    /* renamed from: l, reason: collision with root package name */
    public final AppCompatTextView f63713l;

    /* renamed from: m, reason: collision with root package name */
    public final AppCompatTextView f63714m;

    /* renamed from: n, reason: collision with root package name */
    public final AppCompatTextView f63715n;

    /* renamed from: o, reason: collision with root package name */
    public final AppCompatTextView f63716o;

    /* renamed from: p, reason: collision with root package name */
    public final AppCompatTextView f63717p;

    /* renamed from: q, reason: collision with root package name */
    public final AppCompatTextView f63718q;

    /* renamed from: r, reason: collision with root package name */
    public final AppCompatTextView f63719r;

    /* renamed from: s, reason: collision with root package name */
    public final AppCompatTextView f63720s;

    /* renamed from: t, reason: collision with root package name */
    public final ConstraintLayout f63721t;

    /* renamed from: u, reason: collision with root package name */
    public final View f63722u;

    /* renamed from: v, reason: collision with root package name */
    public final LinearLayoutCompat f63723v;

    /* renamed from: w, reason: collision with root package name */
    public final LinearLayoutCompat f63724w;

    /* renamed from: x, reason: collision with root package name */
    public final NestedScrollView f63725x;

    /* renamed from: y, reason: collision with root package name */
    public final View f63726y;

    private b(LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatEditText appCompatEditText, AppCompatEditText appCompatEditText2, AppCompatTextView appCompatTextView, FrameLayout frameLayout, AppCompatImageView appCompatImageView3, ConstraintLayout constraintLayout, View view, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8, AppCompatTextView appCompatTextView9, AppCompatTextView appCompatTextView10, ConstraintLayout constraintLayout2, View view2, LinearLayoutCompat linearLayoutCompat2, LinearLayoutCompat linearLayoutCompat3, NestedScrollView nestedScrollView, View view3) {
        this.f63702a = linearLayoutCompat;
        this.f63703b = appCompatImageView;
        this.f63704c = appCompatImageView2;
        this.f63705d = appCompatEditText;
        this.f63706e = appCompatEditText2;
        this.f63707f = appCompatTextView;
        this.f63708g = frameLayout;
        this.f63709h = appCompatImageView3;
        this.f63710i = constraintLayout;
        this.f63711j = view;
        this.f63712k = appCompatTextView2;
        this.f63713l = appCompatTextView3;
        this.f63714m = appCompatTextView4;
        this.f63715n = appCompatTextView5;
        this.f63716o = appCompatTextView6;
        this.f63717p = appCompatTextView7;
        this.f63718q = appCompatTextView8;
        this.f63719r = appCompatTextView9;
        this.f63720s = appCompatTextView10;
        this.f63721t = constraintLayout2;
        this.f63722u = view2;
        this.f63723v = linearLayoutCompat2;
        this.f63724w = linearLayoutCompat3;
        this.f63725x = nestedScrollView;
        this.f63726y = view3;
    }

    public static b a(View view) {
        View a11;
        View a12;
        View a13;
        int i11 = R$id.clear_cnic_button;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.clear_phone_button;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.input_cnic;
                AppCompatEditText appCompatEditText = (AppCompatEditText) g4.b.a(view, i11);
                if (appCompatEditText != null) {
                    i11 = R$id.input_phone;
                    AppCompatEditText appCompatEditText2 = (AppCompatEditText) g4.b.a(view, i11);
                    if (appCompatEditText2 != null) {
                        i11 = R$id.iv_amount;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView != null) {
                            i11 = R$id.iv_back;
                            FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                            if (frameLayout != null) {
                                i11 = R$id.iv_close;
                                AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                                if (appCompatImageView3 != null) {
                                    i11 = R$id.iv_cnic_container;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
                                    if (constraintLayout != null && (a11 = g4.b.a(view, (i11 = R$id.iv_cnic_container_line))) != null) {
                                        i11 = R$id.iv_company;
                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                        if (appCompatTextView2 != null) {
                                            i11 = R$id.iv_cp_name_desc;
                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                            if (appCompatTextView3 != null) {
                                                i11 = R$id.iv_desc;
                                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                                if (appCompatTextView4 != null) {
                                                    i11 = R$id.iv_input_cnic_error;
                                                    AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                                                    if (appCompatTextView5 != null) {
                                                        i11 = R$id.iv_input_phone_error;
                                                        AppCompatTextView appCompatTextView6 = (AppCompatTextView) g4.b.a(view, i11);
                                                        if (appCompatTextView6 != null) {
                                                            i11 = R$id.iv_order_id;
                                                            AppCompatTextView appCompatTextView7 = (AppCompatTextView) g4.b.a(view, i11);
                                                            if (appCompatTextView7 != null) {
                                                                i11 = R$id.iv_pay_button;
                                                                AppCompatTextView appCompatTextView8 = (AppCompatTextView) g4.b.a(view, i11);
                                                                if (appCompatTextView8 != null) {
                                                                    i11 = R$id.iv_payment_method;
                                                                    AppCompatTextView appCompatTextView9 = (AppCompatTextView) g4.b.a(view, i11);
                                                                    if (appCompatTextView9 != null) {
                                                                        i11 = R$id.iv_phone_code;
                                                                        AppCompatTextView appCompatTextView10 = (AppCompatTextView) g4.b.a(view, i11);
                                                                        if (appCompatTextView10 != null) {
                                                                            i11 = R$id.iv_phone_container;
                                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) g4.b.a(view, i11);
                                                                            if (constraintLayout2 != null && (a12 = g4.b.a(view, (i11 = R$id.iv_phone_container_line))) != null) {
                                                                                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) g4.b.a(view, R$id.left_panel);
                                                                                LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) view;
                                                                                i11 = R$id.scroll_view;
                                                                                NestedScrollView nestedScrollView = (NestedScrollView) g4.b.a(view, i11);
                                                                                if (nestedScrollView != null && (a13 = g4.b.a(view, (i11 = R$id.view))) != null) {
                                                                                    return new b(linearLayoutCompat2, appCompatImageView, appCompatImageView2, appCompatEditText, appCompatEditText2, appCompatTextView, frameLayout, appCompatImageView3, constraintLayout, a11, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7, appCompatTextView8, appCompatTextView9, appCompatTextView10, constraintLayout2, a12, linearLayoutCompat, linearLayoutCompat2, nestedScrollView, a13);
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
                                }
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
    public LinearLayoutCompat getRoot() {
        return this.f63702a;
    }
}
