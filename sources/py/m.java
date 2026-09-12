package py;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLTextView;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class m implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f72964a;

    /* renamed from: b, reason: collision with root package name */
    public final BLTextView f72965b;

    /* renamed from: c, reason: collision with root package name */
    public final View f72966c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f72967d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f72968e;

    private m(ConstraintLayout constraintLayout, BLTextView bLTextView, View view, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView) {
        this.f72964a = constraintLayout;
        this.f72965b = bLTextView;
        this.f72966c = view;
        this.f72967d = appCompatImageView;
        this.f72968e = appCompatTextView;
    }

    public static m a(View view) {
        View a11;
        int i11 = R$id.btn_bottom;
        BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
        if (bLTextView != null && (a11 = g4.b.a(view, (i11 = R$id.btn_top))) != null) {
            i11 = R$id.iv_close;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.tv_tips;
                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView != null) {
                    return new m((ConstraintLayout) view, bLTextView, a11, appCompatImageView, appCompatTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f72964a;
    }
}
