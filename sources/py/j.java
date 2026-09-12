package py;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class j implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f72889a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f72890b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f72891c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f72892d;

    private j(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.f72889a = constraintLayout;
        this.f72890b = appCompatImageView;
        this.f72891c = appCompatTextView;
        this.f72892d = appCompatTextView2;
    }

    public static j a(View view) {
        int i11 = R$id.iv_allow_access;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.tv_allow_access;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.tv_go_to_setting;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    return new j((ConstraintLayout) view, appCompatImageView, appCompatTextView, appCompatTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f72889a;
    }
}
