package cn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;

/* loaded from: classes5.dex */
public final class r implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17544a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f17545b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f17546c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f17547d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f17548e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f17549f;

    /* renamed from: g, reason: collision with root package name */
    public final View f17550g;

    /* renamed from: h, reason: collision with root package name */
    public final View f17551h;

    private r(ConstraintLayout constraintLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, View view, View view2) {
        this.f17544a = constraintLayout;
        this.f17545b = frameLayout;
        this.f17546c = appCompatImageView;
        this.f17547d = appCompatTextView;
        this.f17548e = appCompatTextView2;
        this.f17549f = appCompatTextView3;
        this.f17550g = view;
        this.f17551h = view2;
    }

    public static r a(View view) {
        View a11;
        View a12;
        int i11 = R$id.extension_container;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.ivCollection;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.tvMovieInfo;
                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.tvMovieTitle;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView2 != null) {
                        i11 = R$id.tvTag;
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView3 != null && (a11 = g4.b.a(view, (i11 = R$id.v_detail_hot_zone))) != null && (a12 = g4.b.a(view, (i11 = R$id.v_line))) != null) {
                            return new r((ConstraintLayout) view, frameLayout, appCompatImageView, appCompatTextView, appCompatTextView2, appCompatTextView3, a11, a12);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static r c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static r d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_subject_edu_music_header, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f17544a;
    }
}
