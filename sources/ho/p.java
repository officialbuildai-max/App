package ho;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.player.longvideo.R$id;
import com.transsion.player.longvideo.R$layout;

/* loaded from: classes6.dex */
public final class p implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f64815a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f64816b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f64817c;

    private p(FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView) {
        this.f64815a = frameLayout;
        this.f64816b = appCompatImageView;
        this.f64817c = appCompatTextView;
    }

    public static p a(View view) {
        int i11 = R$id.ivBack;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.tvGoPremium;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                return new p((FrameLayout) view, appCompatImageView, appCompatTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static p c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.video_premium_intercept_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f64815a;
    }
}
