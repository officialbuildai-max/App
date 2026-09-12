package py;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager2.widget.ViewPager2;
import com.tn.lib.view.indicator.CircleIndicator;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class o implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f72981a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f72982b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewPager2 f72983c;

    /* renamed from: d, reason: collision with root package name */
    public final CircleIndicator f72984d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f72985e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f72986f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f72987g;

    private o(LinearLayout linearLayout, TextView textView, ViewPager2 viewPager2, CircleIndicator circleIndicator, AppCompatImageView appCompatImageView, TextView textView2, TextView textView3) {
        this.f72981a = linearLayout;
        this.f72982b = textView;
        this.f72983c = viewPager2;
        this.f72984d = circleIndicator;
        this.f72985e = appCompatImageView;
        this.f72986f = textView2;
        this.f72987g = textView3;
    }

    public static o a(View view) {
        int i11 = R$id.guide_desc;
        TextView textView = (TextView) g4.b.a(view, i11);
        if (textView != null) {
            i11 = R$id.guide_pager;
            ViewPager2 viewPager2 = (ViewPager2) g4.b.a(view, i11);
            if (viewPager2 != null) {
                i11 = R$id.indicator;
                CircleIndicator circleIndicator = (CircleIndicator) g4.b.a(view, i11);
                if (circleIndicator != null) {
                    i11 = R$id.ivClose;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.next;
                        TextView textView2 = (TextView) g4.b.a(view, i11);
                        if (textView2 != null) {
                            i11 = R$id.title;
                            TextView textView3 = (TextView) g4.b.a(view, i11);
                            if (textView3 != null) {
                                return new o((LinearLayout) view, textView, viewPager2, circleIndicator, appCompatImageView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f72981a;
    }
}
