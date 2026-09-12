package cn;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.moviedetail.R$id;

/* loaded from: classes5.dex */
public final class z implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17618a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f17619b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f17620c;

    private z(ConstraintLayout constraintLayout, ImageView imageView, AppCompatTextView appCompatTextView) {
        this.f17618a = constraintLayout;
        this.f17619b = imageView;
        this.f17620c = appCompatTextView;
    }

    public static z a(View view) {
        int i11 = R$id.closeWatchTv;
        ImageView imageView = (ImageView) g4.b.a(view, i11);
        if (imageView != null) {
            i11 = R$id.goWatchTv;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                return new z((ConstraintLayout) view, imageView, appCompatTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f17618a;
    }
}
