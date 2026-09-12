package gv;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLTextView;
import com.transsion.transfer.R$id;

/* loaded from: classes7.dex */
public final class f implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f64119a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f64120b;

    /* renamed from: c, reason: collision with root package name */
    public final BLTextView f64121c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f64122d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f64123e;

    /* renamed from: f, reason: collision with root package name */
    public final View f64124f;

    private f(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, BLTextView bLTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, View view) {
        this.f64119a = constraintLayout;
        this.f64120b = appCompatTextView;
        this.f64121c = bLTextView;
        this.f64122d = appCompatTextView2;
        this.f64123e = appCompatTextView3;
        this.f64124f = view;
    }

    public static f a(View view) {
        View a11;
        int i11 = R$id.btn_no;
        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.btn_yes;
            BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
            if (bLTextView != null) {
                i11 = R$id.tv_tips;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.tv_title;
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView3 != null && (a11 = g4.b.a(view, (i11 = R$id.v_ling_1))) != null) {
                        return new f((ConstraintLayout) view, appCompatTextView, bLTextView, appCompatTextView2, appCompatTextView3, a11);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f64119a;
    }
}
