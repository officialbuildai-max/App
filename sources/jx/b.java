package jx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLTextView;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;

/* loaded from: classes7.dex */
public final class b implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f66458a;

    /* renamed from: b, reason: collision with root package name */
    public final View f66459b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f66460c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f66461d;

    /* renamed from: e, reason: collision with root package name */
    public final ProgressBar f66462e;

    /* renamed from: f, reason: collision with root package name */
    public final RecyclerView f66463f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f66464g;

    /* renamed from: h, reason: collision with root package name */
    public final BLTextView f66465h;

    private b(ConstraintLayout constraintLayout, View view, FrameLayout frameLayout, AppCompatImageView appCompatImageView, ProgressBar progressBar, RecyclerView recyclerView, AppCompatTextView appCompatTextView, BLTextView bLTextView) {
        this.f66458a = constraintLayout;
        this.f66459b = view;
        this.f66460c = frameLayout;
        this.f66461d = appCompatImageView;
        this.f66462e = progressBar;
        this.f66463f = recyclerView;
        this.f66464g = appCompatTextView;
        this.f66465h = bLTextView;
    }

    public static b a(View view) {
        int i11 = R$id.divider;
        View a11 = g4.b.a(view, i11);
        if (a11 != null) {
            i11 = R$id.fl_season_container;
            FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.iv_close;
                AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.pb_loading;
                    ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                    if (progressBar != null) {
                        i11 = R$id.f57686rv;
                        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                        if (recyclerView != null) {
                            i11 = R$id.tv_all_episodes;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R$id.tv_title;
                                BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
                                if (bLTextView != null) {
                                    return new b((ConstraintLayout) view, a11, frameLayout, appCompatImageView, progressBar, recyclerView, appCompatTextView, bLTextView);
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
        View inflate = layoutInflater.inflate(R$layout.fragment_all_episodes, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f66458a;
    }
}
