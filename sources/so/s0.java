package so;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;

/* loaded from: classes6.dex */
public final class s0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f75829a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f75830b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f75831c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f75832d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f75833e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f75834f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f75835g;

    /* renamed from: h, reason: collision with root package name */
    public final View f75836h;

    /* renamed from: i, reason: collision with root package name */
    public final View f75837i;

    /* renamed from: j, reason: collision with root package name */
    public final View f75838j;

    /* renamed from: k, reason: collision with root package name */
    public final View f75839k;

    private s0(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, View view, View view2, View view3, View view4) {
        this.f75829a = constraintLayout;
        this.f75830b = appCompatImageView;
        this.f75831c = appCompatImageView2;
        this.f75832d = appCompatImageView3;
        this.f75833e = appCompatImageView4;
        this.f75834f = appCompatTextView;
        this.f75835g = appCompatTextView2;
        this.f75836h = view;
        this.f75837i = view2;
        this.f75838j = view3;
        this.f75839k = view4;
    }

    public static s0 a(View view) {
        View a11;
        View a12;
        View a13;
        View a14;
        int i11 = R$id.ivComment;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.ivDownload;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.ivLike;
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView3 != null) {
                    i11 = R$id.ivShare;
                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView4 != null) {
                        i11 = R$id.tvComment;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView != null) {
                            i11 = R$id.tvLike;
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView2 != null && (a11 = g4.b.a(view, (i11 = R$id.viewComment))) != null && (a12 = g4.b.a(view, (i11 = R$id.viewDownload))) != null && (a13 = g4.b.a(view, (i11 = R$id.viewLike))) != null && (a14 = g4.b.a(view, (i11 = R$id.viewShare))) != null) {
                                return new s0((ConstraintLayout) view, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, appCompatTextView, appCompatTextView2, a11, a12, a13, a14);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static s0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static s0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.view_post_detail_operation_new_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f75829a;
    }
}
