package ms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv_pugc.base.widget.ShortTvGradientTextView;

/* loaded from: classes7.dex */
public final class e implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f69882a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f69883b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f69884c;

    /* renamed from: d, reason: collision with root package name */
    public final ShortTvGradientTextView f69885d;

    private e(FrameLayout frameLayout, FrameLayout frameLayout2, AppCompatTextView appCompatTextView, ShortTvGradientTextView shortTvGradientTextView) {
        this.f69882a = frameLayout;
        this.f69883b = frameLayout2;
        this.f69884c = appCompatTextView;
        this.f69885d = shortTvGradientTextView;
    }

    public static e a(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i11 = R$id.tvName;
        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.tvNameSelected;
            ShortTvGradientTextView shortTvGradientTextView = (ShortTvGradientTextView) g4.b.a(view, i11);
            if (shortTvGradientTextView != null) {
                return new e(frameLayout, frameLayout, appCompatTextView, shortTvGradientTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static e c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.pugc_short_tv_item_language_select, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f69882a;
    }
}
