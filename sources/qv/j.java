package qv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.R$layout;

/* loaded from: classes7.dex */
public final class j implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f73901a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f73902b;

    /* renamed from: c, reason: collision with root package name */
    public final ShapeableImageView f73903c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f73904d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f73905e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f73906f;

    /* renamed from: g, reason: collision with root package name */
    public final BLTextView f73907g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f73908h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f73909i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatTextView f73910j;

    /* renamed from: k, reason: collision with root package name */
    public final View f73911k;

    private j(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ShapeableImageView shapeableImageView, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, BLTextView bLTextView, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, View view) {
        this.f73901a = constraintLayout;
        this.f73902b = appCompatImageView;
        this.f73903c = shapeableImageView;
        this.f73904d = recyclerView;
        this.f73905e = appCompatTextView;
        this.f73906f = appCompatTextView2;
        this.f73907g = bLTextView;
        this.f73908h = appCompatTextView3;
        this.f73909i = appCompatTextView4;
        this.f73910j = appCompatTextView5;
        this.f73911k = view;
    }

    public static j a(View view) {
        View a11;
        int i11 = R$id.ivClose;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.ivUserCover;
            ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
            if (shapeableImageView != null) {
                i11 = R$id.recyclerTag;
                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.tvDes;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView != null) {
                        i11 = R$id.tvDesTitle;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView2 != null) {
                            i11 = R$id.tvFollow;
                            BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
                            if (bLTextView != null) {
                                i11 = R$id.tvPageTitle;
                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView3 != null) {
                                    i11 = R$id.tvTitle;
                                    AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView4 != null) {
                                        i11 = R$id.tvUsername;
                                        AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                                        if (appCompatTextView5 != null && (a11 = g4.b.a(view, (i11 = R$id.vTitleLine))) != null) {
                                            return new j((ConstraintLayout) view, appCompatImageView, shapeableImageView, recyclerView, appCompatTextView, appCompatTextView2, bLTextView, appCompatTextView3, appCompatTextView4, appCompatTextView5, a11);
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

    public static j c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static j d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_ugc_video_detail_info_dialog, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f73901a;
    }
}
