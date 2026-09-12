package cn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.widget.ResourcesRequestView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;

/* loaded from: classes5.dex */
public final class k implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17480a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f17481b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f17482c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f17483d;

    /* renamed from: e, reason: collision with root package name */
    public final ResourcesRequestView f17484e;

    private k(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, ResourcesRequestView resourcesRequestView) {
        this.f17480a = constraintLayout;
        this.f17481b = appCompatImageView;
        this.f17482c = appCompatTextView;
        this.f17483d = appCompatTextView2;
        this.f17484e = resourcesRequestView;
    }

    public static k a(View view) {
        int i11 = R$id.innerIcon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.innerTvInfo;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.innerTvTitle;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.iv_resources;
                    ResourcesRequestView resourcesRequestView = (ResourcesRequestView) g4.b.a(view, i11);
                    if (resourcesRequestView != null) {
                        return new k((ConstraintLayout) view, appCompatImageView, appCompatTextView, appCompatTextView2, resourcesRequestView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static k c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static k d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_resource_detector_empty_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f17480a;
    }
}
