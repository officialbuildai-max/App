package bq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: classes5.dex */
public final class s implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f16940a;

    /* renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f16941b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f16942c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f16943d;

    /* renamed from: e, reason: collision with root package name */
    public final MagicIndicator f16944e;

    /* renamed from: f, reason: collision with root package name */
    public final ViewPager2 f16945f;

    private s(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, ImageView imageView, MagicIndicator magicIndicator, ViewPager2 viewPager2) {
        this.f16940a = constraintLayout;
        this.f16941b = constraintLayout2;
        this.f16942c = appCompatImageView;
        this.f16943d = imageView;
        this.f16944e = magicIndicator;
        this.f16945f = viewPager2;
    }

    public static s a(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i11 = R$id.iv_back;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.iv_top_bg;
            ImageView imageView = (ImageView) g4.b.a(view, i11);
            if (imageView != null) {
                i11 = R$id.magic_indicator;
                MagicIndicator magicIndicator = (MagicIndicator) g4.b.a(view, i11);
                if (magicIndicator != null) {
                    i11 = R$id.view_pager;
                    ViewPager2 viewPager2 = (ViewPager2) g4.b.a(view, i11);
                    if (viewPager2 != null) {
                        return new s(constraintLayout, constraintLayout, appCompatImageView, imageView, magicIndicator, viewPager2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static s c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static s d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_room_list_main, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f16940a;
    }
}
