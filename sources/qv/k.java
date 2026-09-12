package qv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.R$layout;

/* loaded from: classes7.dex */
public final class k implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f73912a;

    /* renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f73913b;

    /* renamed from: c, reason: collision with root package name */
    public final FragmentContainerView f73914c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f73915d;

    /* renamed from: e, reason: collision with root package name */
    public final RecyclerView f73916e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f73917f;

    /* renamed from: g, reason: collision with root package name */
    public final View f73918g;

    private k(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, FragmentContainerView fragmentContainerView, AppCompatImageView appCompatImageView, RecyclerView recyclerView, AppCompatTextView appCompatTextView, View view) {
        this.f73912a = constraintLayout;
        this.f73913b = constraintLayout2;
        this.f73914c = fragmentContainerView;
        this.f73915d = appCompatImageView;
        this.f73916e = recyclerView;
        this.f73917f = appCompatTextView;
        this.f73918g = view;
    }

    public static k a(View view) {
        View a11;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i11 = R$id.fragmentContainer;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) g4.b.a(view, i11);
        if (fragmentContainerView != null) {
            i11 = R$id.ivClose;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.rvTabs;
                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.tvPageTitle;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView != null && (a11 = g4.b.a(view, (i11 = R$id.vTitleLine))) != null) {
                        return new k(constraintLayout, constraintLayout, fragmentContainerView, appCompatImageView, recyclerView, appCompatTextView, a11);
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
        View inflate = layoutInflater.inflate(R$layout.fragment_ugc_video_detail_play_list_tab, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f73912a;
    }
}
