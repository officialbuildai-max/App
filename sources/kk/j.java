package kk;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.commercialization.R$id;
import com.transsion.commercialization.pslink.PsLinkDownLoadButton;

/* loaded from: classes6.dex */
public final class j implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f67008a;

    /* renamed from: b, reason: collision with root package name */
    public final ShapeableImageView f67009b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f67010c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f67011d;

    /* renamed from: e, reason: collision with root package name */
    public final PsLinkDownLoadButton f67012e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f67013f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f67014g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f67015h;

    /* renamed from: i, reason: collision with root package name */
    public final View f67016i;

    private j(View view, ShapeableImageView shapeableImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, PsLinkDownLoadButton psLinkDownLoadButton, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, View view2) {
        this.f67008a = view;
        this.f67009b = shapeableImageView;
        this.f67010c = appCompatTextView;
        this.f67011d = appCompatTextView2;
        this.f67012e = psLinkDownLoadButton;
        this.f67013f = appCompatTextView3;
        this.f67014g = appCompatTextView4;
        this.f67015h = appCompatTextView5;
        this.f67016i = view2;
    }

    public static j a(View view) {
        View a11;
        int i11 = R$id.iv_cover;
        ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
        if (shapeableImageView != null) {
            i11 = R$id.tv_aha_btn;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.tv_category;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.tv_ps_btn;
                    PsLinkDownLoadButton psLinkDownLoadButton = (PsLinkDownLoadButton) g4.b.a(view, i11);
                    if (psLinkDownLoadButton != null) {
                        i11 = R$id.tv_size;
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView3 != null) {
                            i11 = R$id.tv_star;
                            AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView4 != null) {
                                i11 = R$id.tv_title;
                                AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView5 != null && (a11 = g4.b.a(view, (i11 = R$id.v_line))) != null) {
                                    return new j(view, shapeableImageView, appCompatTextView, appCompatTextView2, psLinkDownLoadButton, appCompatTextView3, appCompatTextView4, appCompatTextView5, a11);
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
    public View getRoot() {
        return this.f67008a;
    }
}
