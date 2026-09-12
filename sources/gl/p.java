package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: classes6.dex */
public final class p implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f63927a;

    /* renamed from: b, reason: collision with root package name */
    public final View f63928b;

    /* renamed from: c, reason: collision with root package name */
    public final MagicIndicator f63929c;

    /* renamed from: d, reason: collision with root package name */
    public final ViewPager2 f63930d;

    private p(LinearLayout linearLayout, View view, MagicIndicator magicIndicator, ViewPager2 viewPager2) {
        this.f63927a = linearLayout;
        this.f63928b = view;
        this.f63929c = magicIndicator;
        this.f63930d = viewPager2;
    }

    public static p a(View view) {
        int i11 = R$id.hashtag_divider_view;
        View a11 = g4.b.a(view, i11);
        if (a11 != null) {
            i11 = R$id.hashtag_magic_indicator;
            MagicIndicator magicIndicator = (MagicIndicator) g4.b.a(view, i11);
            if (magicIndicator != null) {
                i11 = R$id.hashtag_viewpager;
                ViewPager2 viewPager2 = (ViewPager2) g4.b.a(view, i11);
                if (viewPager2 != null) {
                    return new p((LinearLayout) view, a11, magicIndicator, viewPager2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static p c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static p d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_hashtag, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f63927a;
    }
}
