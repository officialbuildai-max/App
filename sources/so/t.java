package so;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: classes6.dex */
public final class t implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f75840a;

    /* renamed from: b, reason: collision with root package name */
    public final MagicIndicator f75841b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewPager2 f75842c;

    private t(FrameLayout frameLayout, MagicIndicator magicIndicator, ViewPager2 viewPager2) {
        this.f75840a = frameLayout;
        this.f75841b = magicIndicator;
        this.f75842c = viewPager2;
    }

    public static t a(View view) {
        int i11 = R$id.magic_indicator;
        MagicIndicator magicIndicator = (MagicIndicator) g4.b.a(view, i11);
        if (magicIndicator != null) {
            i11 = R$id.view_pager;
            ViewPager2 viewPager2 = (ViewPager2) g4.b.a(view, i11);
            if (viewPager2 != null) {
                return new t((FrameLayout) view, magicIndicator, viewPager2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static t c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static t d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_short_tv_home, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f75840a;
    }
}
