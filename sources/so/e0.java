package so;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLLinearLayout;
import com.transsion.postdetail.R$id;

/* loaded from: classes6.dex */
public final class e0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final BLLinearLayout f75619a;

    /* renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f75620b;

    /* renamed from: c, reason: collision with root package name */
    public final ShapeableImageView f75621c;

    /* renamed from: d, reason: collision with root package name */
    public final ShapeableImageView f75622d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f75623e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayout f75624f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f75625g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f75626h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f75627i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatTextView f75628j;

    /* renamed from: k, reason: collision with root package name */
    public final View f75629k;

    /* renamed from: l, reason: collision with root package name */
    public final View f75630l;

    /* renamed from: m, reason: collision with root package name */
    public final View f75631m;

    private e0(BLLinearLayout bLLinearLayout, ConstraintLayout constraintLayout, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, AppCompatImageView appCompatImageView, LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, View view, View view2, View view3) {
        this.f75619a = bLLinearLayout;
        this.f75620b = constraintLayout;
        this.f75621c = shapeableImageView;
        this.f75622d = shapeableImageView2;
        this.f75623e = appCompatImageView;
        this.f75624f = linearLayout;
        this.f75625g = appCompatTextView;
        this.f75626h = appCompatTextView2;
        this.f75627i = appCompatTextView3;
        this.f75628j = appCompatTextView4;
        this.f75629k = view;
        this.f75630l = view2;
        this.f75631m = view3;
    }

    public static e0 a(View view) {
        View a11;
        View a12;
        View a13;
        int i11 = R$id.cl_subject_content;
        ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
        if (constraintLayout != null) {
            i11 = R$id.iv_room_cover;
            ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
            if (shapeableImageView != null) {
                i11 = R$id.iv_subject_cover;
                ShapeableImageView shapeableImageView2 = (ShapeableImageView) g4.b.a(view, i11);
                if (shapeableImageView2 != null) {
                    i11 = R$id.iv_subject_tag;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.ll_room_tag;
                        LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                        if (linearLayout != null) {
                            i11 = R$id.tv_room_tag;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R$id.tv_subject_date;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView2 != null) {
                                    i11 = R$id.tv_subject_genre;
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView3 != null) {
                                        i11 = R$id.tv_subject_name;
                                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                        if (appCompatTextView4 != null && (a11 = g4.b.a(view, (i11 = R$id.v_subject_line_1))) != null && (a12 = g4.b.a(view, (i11 = R$id.v_subject_line_2))) != null && (a13 = g4.b.a(view, (i11 = R$id.v_subject_room_line))) != null) {
                                            return new e0((BLLinearLayout) view, constraintLayout, shapeableImageView, shapeableImageView2, appCompatImageView, linearLayout, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, a11, a12, a13);
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
    public BLLinearLayout getRoot() {
        return this.f75619a;
    }
}
