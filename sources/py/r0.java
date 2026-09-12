package py;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: classes7.dex */
public final class r0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f73025a;

    /* renamed from: b, reason: collision with root package name */
    public final MagicIndicator f73026b;

    /* renamed from: c, reason: collision with root package name */
    public final View f73027c;

    /* renamed from: d, reason: collision with root package name */
    public final ViewPager2 f73028d;

    private r0(ConstraintLayout constraintLayout, MagicIndicator magicIndicator, View view, ViewPager2 viewPager2) {
        this.f73025a = constraintLayout;
        this.f73026b = magicIndicator;
        this.f73027c = view;
        this.f73028d = viewPager2;
    }

    public static r0 a(View view) {
        View a11;
        int i11 = R$id.magic_indicator;
        MagicIndicator magicIndicator = (MagicIndicator) g4.b.a(view, i11);
        if (magicIndicator != null && (a11 = g4.b.a(view, (i11 = R$id.view_divider))) != null) {
            i11 = R$id.view_pager;
            ViewPager2 viewPager2 = (ViewPager2) g4.b.a(view, i11);
            if (viewPager2 != null) {
                return new r0((ConstraintLayout) view, magicIndicator, a11, viewPager2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static r0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static r0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_ugc_my_downloads, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f73025a;
    }
}
