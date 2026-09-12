package kk;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.commercialization.R$id;

/* loaded from: classes6.dex */
public final class g implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f66985a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f66986b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f66987c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f66988d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f66989e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f66990f;

    /* renamed from: g, reason: collision with root package name */
    public final ConstraintLayout f66991g;

    /* renamed from: h, reason: collision with root package name */
    public final LinearLayout f66992h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f66993i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f66994j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f66995k;

    /* renamed from: l, reason: collision with root package name */
    public final View f66996l;

    /* renamed from: m, reason: collision with root package name */
    public final ShapeableImageView f66997m;

    /* renamed from: n, reason: collision with root package name */
    public final FrameLayout f66998n;

    private g(LinearLayout linearLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, ConstraintLayout constraintLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, View view, ShapeableImageView shapeableImageView, FrameLayout frameLayout) {
        this.f66985a = linearLayout;
        this.f66986b = appCompatImageView;
        this.f66987c = appCompatImageView2;
        this.f66988d = appCompatImageView3;
        this.f66989e = appCompatImageView4;
        this.f66990f = appCompatImageView5;
        this.f66991g = constraintLayout;
        this.f66992h = linearLayout2;
        this.f66993i = textView;
        this.f66994j = textView2;
        this.f66995k = textView3;
        this.f66996l = view;
        this.f66997m = shapeableImageView;
        this.f66998n = frameLayout;
    }

    public static g a(View view) {
        View a11;
        int i11 = R$id.ivBg1;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.ivClose;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.ivLeftWing;
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView3 != null) {
                    i11 = R$id.ivRightWing;
                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView4 != null) {
                        i11 = R$id.ivTreasureAvatar;
                        AppCompatImageView appCompatImageView5 = (AppCompatImageView) g4.b.a(view, i11);
                        if (appCompatImageView5 != null) {
                            i11 = R$id.llContent;
                            ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
                            if (constraintLayout != null) {
                                LinearLayout linearLayout = (LinearLayout) view;
                                i11 = R$id.tvClaimNow;
                                TextView textView = (TextView) g4.b.a(view, i11);
                                if (textView != null) {
                                    i11 = R$id.tvStateTitle;
                                    TextView textView2 = (TextView) g4.b.a(view, i11);
                                    if (textView2 != null) {
                                        i11 = R$id.tvStateTitlePrize;
                                        TextView textView3 = (TextView) g4.b.a(view, i11);
                                        if (textView3 != null && (a11 = g4.b.a(view, (i11 = R$id.viewBg1))) != null) {
                                            i11 = R$id.viewBg2;
                                            ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                                            if (shapeableImageView != null) {
                                                i11 = R$id.viewClaim;
                                                FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                                                if (frameLayout != null) {
                                                    return new g(linearLayout, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, appCompatImageView5, constraintLayout, linearLayout, textView, textView2, textView3, a11, shapeableImageView, frameLayout);
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
    public LinearLayout getRoot() {
        return this.f66985a;
    }
}
