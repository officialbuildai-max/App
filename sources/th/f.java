package th;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.tn.lib.widget.R$id;

/* loaded from: classes4.dex */
public final class f implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f76364a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f76365b;

    private f(View view, AppCompatImageView appCompatImageView) {
        this.f76364a = view;
        this.f76365b = appCompatImageView;
    }

    public static f a(View view) {
        int i11 = R$id.iv_join;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            return new f(view, appCompatImageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    public View getRoot() {
        return this.f76364a;
    }
}
