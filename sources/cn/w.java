package cn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;

/* loaded from: classes5.dex */
public final class w implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final HorizontalScrollView f17602a;

    /* renamed from: b, reason: collision with root package name */
    public final ShapeableImageView f17603b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f17604c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f17605d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f17606e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f17607f;

    /* renamed from: g, reason: collision with root package name */
    public final ConstraintLayout f17608g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f17609h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f17610i;

    private w(HorizontalScrollView horizontalScrollView, ShapeableImageView shapeableImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6) {
        this.f17602a = horizontalScrollView;
        this.f17603b = shapeableImageView;
        this.f17604c = appCompatTextView;
        this.f17605d = appCompatTextView2;
        this.f17606e = appCompatTextView3;
        this.f17607f = appCompatTextView4;
        this.f17608g = constraintLayout;
        this.f17609h = appCompatTextView5;
        this.f17610i = appCompatTextView6;
    }

    public static w a(View view) {
        int i11 = R$id.ivAvatar;
        ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
        if (shapeableImageView != null) {
            i11 = R$id.tv_add;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.tvDes;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.tv_download;
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView3 != null) {
                        i11 = R$id.tv_download_page;
                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView4 != null) {
                            i11 = R$id.tv_music_avatar;
                            ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
                            if (constraintLayout != null) {
                                i11 = R$id.tv_remind;
                                AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView5 != null) {
                                    i11 = R$id.tv_share;
                                    AppCompatTextView appCompatTextView6 = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView6 != null) {
                                        return new w((HorizontalScrollView) view, shapeableImageView, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, constraintLayout, appCompatTextView5, appCompatTextView6);
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

    public static w c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static w d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.header_extension_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public HorizontalScrollView getRoot() {
        return this.f17602a;
    }
}
