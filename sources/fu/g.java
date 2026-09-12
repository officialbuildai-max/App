package fu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.view.SwitchButton;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;

/* loaded from: classes7.dex */
public final class g implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f62626a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f62627b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f62628c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayoutCompat f62629d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayoutCompat f62630e;

    /* renamed from: f, reason: collision with root package name */
    public final RecyclerView f62631f;

    /* renamed from: g, reason: collision with root package name */
    public final SwitchButton f62632g;

    /* renamed from: h, reason: collision with root package name */
    public final SwitchButton f62633h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f62634i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatTextView f62635j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatTextView f62636k;

    /* renamed from: l, reason: collision with root package name */
    public final AppCompatTextView f62637l;

    /* renamed from: m, reason: collision with root package name */
    public final View f62638m;

    /* renamed from: n, reason: collision with root package name */
    public final LinearLayoutCompat f62639n;

    private g(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LinearLayoutCompat linearLayoutCompat, LinearLayoutCompat linearLayoutCompat2, RecyclerView recyclerView, SwitchButton switchButton, SwitchButton switchButton2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, View view, LinearLayoutCompat linearLayoutCompat3) {
        this.f62626a = constraintLayout;
        this.f62627b = appCompatImageView;
        this.f62628c = appCompatImageView2;
        this.f62629d = linearLayoutCompat;
        this.f62630e = linearLayoutCompat2;
        this.f62631f = recyclerView;
        this.f62632g = switchButton;
        this.f62633h = switchButton2;
        this.f62634i = appCompatTextView;
        this.f62635j = appCompatTextView2;
        this.f62636k = appCompatTextView3;
        this.f62637l = appCompatTextView4;
        this.f62638m = view;
        this.f62639n = linearLayoutCompat3;
    }

    public static g a(View view) {
        View a11;
        int i11 = R$id.ivOptions;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.ivSync;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.llOptions;
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) g4.b.a(view, i11);
                if (linearLayoutCompat != null) {
                    i11 = R$id.llSync;
                    LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) g4.b.a(view, i11);
                    if (linearLayoutCompat2 != null) {
                        i11 = R$id.recycler_view;
                        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                        if (recyclerView != null) {
                            i11 = R$id.switchBilingual;
                            SwitchButton switchButton = (SwitchButton) g4.b.a(view, i11);
                            if (switchButton != null) {
                                i11 = R$id.switchBtn;
                                SwitchButton switchButton2 = (SwitchButton) g4.b.a(view, i11);
                                if (switchButton2 != null) {
                                    i11 = R$id.tvBilingual;
                                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView != null) {
                                        i11 = R$id.tvOptions;
                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                        if (appCompatTextView2 != null) {
                                            i11 = R$id.tvSync;
                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                            if (appCompatTextView3 != null) {
                                                i11 = R$id.tvTitle;
                                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                                if (appCompatTextView4 != null && (a11 = g4.b.a(view, (i11 = R$id.viewLine))) != null) {
                                                    i11 = R$id.viewOptionsBg;
                                                    LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) g4.b.a(view, i11);
                                                    if (linearLayoutCompat3 != null) {
                                                        return new g((ConstraintLayout) view, appCompatImageView, appCompatImageView2, linearLayoutCompat, linearLayoutCompat2, recyclerView, switchButton, switchButton2, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, a11, linearLayoutCompat3);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static g c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static g d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_subtitle_select_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f62626a;
    }
}
