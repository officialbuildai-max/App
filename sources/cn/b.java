package cn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;

/* loaded from: classes5.dex */
public final class b implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17382a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f17383b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f17384c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f17385d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f17386e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayout f17387f;

    /* renamed from: g, reason: collision with root package name */
    public final RecyclerView f17388g;

    /* renamed from: h, reason: collision with root package name */
    public final NestedScrollView f17389h;

    /* renamed from: i, reason: collision with root package name */
    public final ConstraintLayout f17390i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatTextView f17391j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatTextView f17392k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f17393l;

    private b(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, LinearLayout linearLayout, RecyclerView recyclerView, NestedScrollView nestedScrollView, ConstraintLayout constraintLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, TextView textView) {
        this.f17382a = constraintLayout;
        this.f17383b = appCompatImageView;
        this.f17384c = appCompatImageView2;
        this.f17385d = appCompatImageView3;
        this.f17386e = appCompatImageView4;
        this.f17387f = linearLayout;
        this.f17388g = recyclerView;
        this.f17389h = nestedScrollView;
        this.f17390i = constraintLayout2;
        this.f17391j = appCompatTextView;
        this.f17392k = appCompatTextView2;
        this.f17393l = textView;
    }

    public static b a(View view) {
        int i11 = R$id.ivBack;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.ivCover;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.ivDownload;
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView3 != null) {
                    i11 = R$id.ivShare;
                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView4 != null) {
                        i11 = R$id.llContent;
                        LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                        if (linearLayout != null) {
                            i11 = R$id.rvStaff;
                            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                            if (recyclerView != null) {
                                i11 = R$id.scrollView;
                                NestedScrollView nestedScrollView = (NestedScrollView) g4.b.a(view, i11);
                                if (nestedScrollView != null) {
                                    i11 = R$id.topLayout;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
                                    if (constraintLayout != null) {
                                        i11 = R$id.tvMovieDesc;
                                        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                        if (appCompatTextView != null) {
                                            i11 = R$id.tvMovieName;
                                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                            if (appCompatTextView2 != null) {
                                                i11 = R$id.tvStaffTitle;
                                                TextView textView = (TextView) g4.b.a(view, i11);
                                                if (textView != null) {
                                                    return new b((ConstraintLayout) view, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, linearLayout, recyclerView, nestedScrollView, constraintLayout, appCompatTextView, appCompatTextView2, textView);
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

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_movie_poster_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f17382a;
    }
}
