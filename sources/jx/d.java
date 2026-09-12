package jx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLTextView;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;

/* loaded from: classes7.dex */
public final class d implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f66472a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f66473b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f66474c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f66475d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f66476e;

    /* renamed from: f, reason: collision with root package name */
    public final BLTextView f66477f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayout f66478g;

    /* renamed from: h, reason: collision with root package name */
    public final RecyclerView f66479h;

    /* renamed from: i, reason: collision with root package name */
    public final BLTextView f66480i;

    /* renamed from: j, reason: collision with root package name */
    public final BLTextView f66481j;

    private d(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, BLTextView bLTextView, LinearLayout linearLayout, RecyclerView recyclerView, BLTextView bLTextView2, BLTextView bLTextView3) {
        this.f66472a = constraintLayout;
        this.f66473b = appCompatImageView;
        this.f66474c = appCompatTextView;
        this.f66475d = appCompatTextView2;
        this.f66476e = appCompatTextView3;
        this.f66477f = bLTextView;
        this.f66478g = linearLayout;
        this.f66479h = recyclerView;
        this.f66480i = bLTextView2;
        this.f66481j = bLTextView3;
    }

    public static d a(View view) {
        int i11 = R$id.innerIcon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.innerTvInfo;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.innerTvName;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.innerTvTitle;
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView3 != null) {
                        i11 = R$id.iv_seasons;
                        BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
                        if (bLTextView != null) {
                            i11 = R$id.llLanguage;
                            LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                            if (linearLayout != null) {
                                i11 = R$id.resourceRv;
                                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                                if (recyclerView != null) {
                                    i11 = R$id.tvLanguage;
                                    BLTextView bLTextView2 = (BLTextView) g4.b.a(view, i11);
                                    if (bLTextView2 != null) {
                                        i11 = R$id.tv_more;
                                        BLTextView bLTextView3 = (BLTextView) g4.b.a(view, i11);
                                        if (bLTextView3 != null) {
                                            return new d((ConstraintLayout) view, appCompatImageView, appCompatTextView, appCompatTextView2, appCompatTextView3, bLTextView, linearLayout, recyclerView, bLTextView2, bLTextView3);
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

    public static d c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static d d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_episode, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f66472a;
    }
}
