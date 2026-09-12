package cn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.view.CustomTextViewGroup;

/* loaded from: classes5.dex */
public final class q implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17532a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f17533b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f17534c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f17535d;

    /* renamed from: e, reason: collision with root package name */
    public final CustomTextViewGroup f17536e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f17537f;

    /* renamed from: g, reason: collision with root package name */
    public final CustomTextViewGroup f17538g;

    /* renamed from: h, reason: collision with root package name */
    public final CustomTextViewGroup f17539h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f17540i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatTextView f17541j;

    /* renamed from: k, reason: collision with root package name */
    public final CustomTextViewGroup f17542k;

    /* renamed from: l, reason: collision with root package name */
    public final View f17543l;

    private q(ConstraintLayout constraintLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout, CustomTextViewGroup customTextViewGroup, AppCompatTextView appCompatTextView, CustomTextViewGroup customTextViewGroup2, CustomTextViewGroup customTextViewGroup3, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, CustomTextViewGroup customTextViewGroup4, View view) {
        this.f17532a = constraintLayout;
        this.f17533b = frameLayout;
        this.f17534c = appCompatImageView;
        this.f17535d = linearLayout;
        this.f17536e = customTextViewGroup;
        this.f17537f = appCompatTextView;
        this.f17538g = customTextViewGroup2;
        this.f17539h = customTextViewGroup3;
        this.f17540i = appCompatTextView2;
        this.f17541j = appCompatTextView3;
        this.f17542k = customTextViewGroup4;
        this.f17543l = view;
    }

    public static q a(View view) {
        View a11;
        int i11 = R$id.extension_container;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.ivMovieContent;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.ll_score;
                LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                if (linearLayout != null) {
                    i11 = R$id.tv_category;
                    CustomTextViewGroup customTextViewGroup = (CustomTextViewGroup) g4.b.a(view, i11);
                    if (customTextViewGroup != null) {
                        i11 = R$id.tvDes;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView != null) {
                            i11 = R$id.tv_duration;
                            CustomTextViewGroup customTextViewGroup2 = (CustomTextViewGroup) g4.b.a(view, i11);
                            if (customTextViewGroup2 != null) {
                                i11 = R$id.tv_genre;
                                CustomTextViewGroup customTextViewGroup3 = (CustomTextViewGroup) g4.b.a(view, i11);
                                if (customTextViewGroup3 != null) {
                                    i11 = R$id.tvMovieInfo;
                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView2 != null) {
                                        i11 = R$id.tvMovieTitle;
                                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                        if (appCompatTextView3 != null) {
                                            i11 = R$id.tv_students;
                                            CustomTextViewGroup customTextViewGroup4 = (CustomTextViewGroup) g4.b.a(view, i11);
                                            if (customTextViewGroup4 != null && (a11 = g4.b.a(view, (i11 = R$id.v_detail_hot_zone))) != null) {
                                                return new q((ConstraintLayout) view, frameLayout, appCompatImageView, linearLayout, customTextViewGroup, appCompatTextView, customTextViewGroup2, customTextViewGroup3, appCompatTextView2, appCompatTextView3, customTextViewGroup4, a11);
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

    public static q c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static q d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_subject_edu_header, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f17532a;
    }
}
