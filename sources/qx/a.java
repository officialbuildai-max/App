package qx;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLView;
import com.transsion.videofloat.R$id;

/* loaded from: classes7.dex */
public final class a implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final BLConstraintLayout f74006a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f74007b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f74008c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f74009d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f74010e;

    /* renamed from: f, reason: collision with root package name */
    public final BLView f74011f;

    private a(BLConstraintLayout bLConstraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, BLView bLView) {
        this.f74006a = bLConstraintLayout;
        this.f74007b = appCompatImageView;
        this.f74008c = appCompatImageView2;
        this.f74009d = appCompatTextView;
        this.f74010e = appCompatTextView2;
        this.f74011f = bLView;
    }

    public static a a(View view) {
        int i11 = R$id.iv_close;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.iv_icon;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.tv_button;
                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.tv_subtitle;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView2 != null) {
                        i11 = R$id.v_icon_bg;
                        BLView bLView = (BLView) g4.b.a(view, i11);
                        if (bLView != null) {
                            return new a((BLConstraintLayout) view, appCompatImageView, appCompatImageView2, appCompatTextView, appCompatTextView2, bLView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.f74006a;
    }
}
