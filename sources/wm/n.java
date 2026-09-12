package wm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.RoundedLinearLayout;
import com.transsion.member.R$id;
import com.transsion.member.R$layout;

/* loaded from: classes6.dex */
public final class n implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f77941a;

    /* renamed from: b, reason: collision with root package name */
    public final View f77942b;

    /* renamed from: c, reason: collision with root package name */
    public final RoundedLinearLayout f77943c;

    /* renamed from: d, reason: collision with root package name */
    public final RelativeLayout f77944d;

    /* renamed from: e, reason: collision with root package name */
    public final ShapeableImageView f77945e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f77946f;

    /* renamed from: g, reason: collision with root package name */
    public final ConstraintLayout f77947g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f77948h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f77949i;

    /* renamed from: j, reason: collision with root package name */
    public final ImageView f77950j;

    /* renamed from: k, reason: collision with root package name */
    public final RecyclerView f77951k;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f77952l;

    /* renamed from: m, reason: collision with root package name */
    public final LinearLayout f77953m;

    /* renamed from: n, reason: collision with root package name */
    public final ConstraintLayout f77954n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f77955o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f77956p;

    /* renamed from: q, reason: collision with root package name */
    public final AppCompatTextView f77957q;

    /* renamed from: r, reason: collision with root package name */
    public final TextView f77958r;

    /* renamed from: s, reason: collision with root package name */
    public final AppCompatTextView f77959s;

    /* renamed from: t, reason: collision with root package name */
    public final AppCompatTextView f77960t;

    private n(LinearLayout linearLayout, View view, RoundedLinearLayout roundedLinearLayout, RelativeLayout relativeLayout, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, ImageView imageView, RecyclerView recyclerView, ImageView imageView2, LinearLayout linearLayout2, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, AppCompatTextView appCompatTextView3, TextView textView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5) {
        this.f77941a = linearLayout;
        this.f77942b = view;
        this.f77943c = roundedLinearLayout;
        this.f77944d = relativeLayout;
        this.f77945e = shapeableImageView;
        this.f77946f = appCompatImageView;
        this.f77947g = constraintLayout;
        this.f77948h = appCompatTextView;
        this.f77949i = appCompatTextView2;
        this.f77950j = imageView;
        this.f77951k = recyclerView;
        this.f77952l = imageView2;
        this.f77953m = linearLayout2;
        this.f77954n = constraintLayout2;
        this.f77955o = textView;
        this.f77956p = textView2;
        this.f77957q = appCompatTextView3;
        this.f77958r = textView3;
        this.f77959s = appCompatTextView4;
        this.f77960t = appCompatTextView5;
    }

    public static n a(View view) {
        int i11 = R$id.avatar_bg;
        View a11 = g4.b.a(view, i11);
        if (a11 != null) {
            i11 = R$id.bottom_container;
            RoundedLinearLayout roundedLinearLayout = (RoundedLinearLayout) g4.b.a(view, i11);
            if (roundedLinearLayout != null) {
                i11 = R$id.feedback_container;
                RelativeLayout relativeLayout = (RelativeLayout) g4.b.a(view, i11);
                if (relativeLayout != null) {
                    i11 = R$id.iv_avatar_premium;
                    ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                    if (shapeableImageView != null) {
                        i11 = R$id.iv_back;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                        if (appCompatImageView != null) {
                            i11 = R$id.iv_info;
                            ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
                            if (constraintLayout != null) {
                                i11 = R$id.iv_name;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView != null) {
                                    i11 = R$id.iv_premium;
                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView2 != null) {
                                        i11 = R$id.iv_premium_icon;
                                        ImageView imageView = (ImageView) g4.b.a(view, i11);
                                        if (imageView != null) {
                                            i11 = R$id.iv_sku_list;
                                            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                                            if (recyclerView != null) {
                                                i11 = R$id.iv_zero_treasure;
                                                ImageView imageView2 = (ImageView) g4.b.a(view, i11);
                                                if (imageView2 != null) {
                                                    i11 = R$id.member_top_container;
                                                    LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                                                    if (linearLayout != null) {
                                                        i11 = R$id.titleLayout;
                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) g4.b.a(view, i11);
                                                        if (constraintLayout2 != null) {
                                                            i11 = R$id.tv_agreement_content;
                                                            TextView textView = (TextView) g4.b.a(view, i11);
                                                            if (textView != null) {
                                                                i11 = R$id.tv_agreement_title;
                                                                TextView textView2 = (TextView) g4.b.a(view, i11);
                                                                if (textView2 != null) {
                                                                    i11 = R$id.tv_member_date;
                                                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                                                    if (appCompatTextView3 != null) {
                                                                        i11 = R$id.tv_pay_btn;
                                                                        TextView textView3 = (TextView) g4.b.a(view, i11);
                                                                        if (textView3 != null) {
                                                                            i11 = R$id.tv_premium_info;
                                                                            AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                                                            if (appCompatTextView4 != null) {
                                                                                i11 = R$id.tv_promo_code;
                                                                                AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                if (appCompatTextView5 != null) {
                                                                                    return new n((LinearLayout) view, a11, roundedLinearLayout, relativeLayout, shapeableImageView, appCompatImageView, constraintLayout, appCompatTextView, appCompatTextView2, imageView, recyclerView, imageView2, linearLayout, constraintLayout2, textView, textView2, appCompatTextView3, textView3, appCompatTextView4, appCompatTextView5);
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

    public static n c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static n d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_member_layout_new, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f77941a;
    }
}
