package cn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLLinearLayout;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.view.InfoExtendView;

/* loaded from: classes5.dex */
public final class i implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17458a;

    /* renamed from: b, reason: collision with root package name */
    public final InfoExtendView f17459b;

    /* renamed from: c, reason: collision with root package name */
    public final ShapeableImageView f17460c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f17461d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f17462e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayoutCompat f17463f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f17464g;

    /* renamed from: h, reason: collision with root package name */
    public final BLLinearLayout f17465h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f17466i;

    private i(ConstraintLayout constraintLayout, InfoExtendView infoExtendView, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView2, BLLinearLayout bLLinearLayout, AppCompatTextView appCompatTextView3) {
        this.f17458a = constraintLayout;
        this.f17459b = infoExtendView;
        this.f17460c = shapeableImageView;
        this.f17461d = appCompatImageView;
        this.f17462e = appCompatTextView;
        this.f17463f = linearLayoutCompat;
        this.f17464g = appCompatTextView2;
        this.f17465h = bLLinearLayout;
        this.f17466i = appCompatTextView3;
    }

    public static i a(View view) {
        int i11 = R$id.infoExtendView;
        InfoExtendView infoExtendView = (InfoExtendView) g4.b.a(view, i11);
        if (infoExtendView != null) {
            i11 = R$id.ivAvatar;
            ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
            if (shapeableImageView != null) {
                i11 = R$id.tv_close;
                AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.tvDes;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView != null) {
                        i11 = R$id.tv_header_toolbar;
                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) g4.b.a(view, i11);
                        if (linearLayoutCompat != null) {
                            i11 = R$id.tvMovieTitle;
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView2 != null) {
                                i11 = R$id.tv_music_avatar;
                                BLLinearLayout bLLinearLayout = (BLLinearLayout) g4.b.a(view, i11);
                                if (bLLinearLayout != null) {
                                    i11 = R$id.tvTag;
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView3 != null) {
                                        return new i((ConstraintLayout) view, infoExtendView, shapeableImageView, appCompatImageView, appCompatTextView, linearLayoutCompat, appCompatTextView2, bLLinearLayout, appCompatTextView3);
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

    public static i c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_music_info_dialog, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f17458a;
    }
}
