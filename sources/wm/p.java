package wm;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.member.R$id;

/* loaded from: classes6.dex */
public final class p implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f77974a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f77975b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f77976c;

    private p(FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView) {
        this.f77974a = frameLayout;
        this.f77975b = appCompatImageView;
        this.f77976c = appCompatTextView;
    }

    public static p a(View view) {
        int i11 = R$id.iv_back;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.tv_title;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                return new p((FrameLayout) view, appCompatImageView, appCompatTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f77974a;
    }
}
