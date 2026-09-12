package gv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.tn.lib.view.TitleLayout;
import com.transsion.transfer.R$id;
import com.transsion.transfer.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: classes7.dex */
public final class b implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f64082a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f64083b;

    /* renamed from: c, reason: collision with root package name */
    public final CoordinatorLayout f64084c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f64085d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f64086e;

    /* renamed from: f, reason: collision with root package name */
    public final MagicIndicator f64087f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f64088g;

    /* renamed from: h, reason: collision with root package name */
    public final TitleLayout f64089h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f64090i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f64091j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatImageView f64092k;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f64093l;

    /* renamed from: m, reason: collision with root package name */
    public final ViewPager2 f64094m;

    private b(ConstraintLayout constraintLayout, LinearLayout linearLayout, CoordinatorLayout coordinatorLayout, LinearLayout linearLayout2, FrameLayout frameLayout, MagicIndicator magicIndicator, TextView textView, TitleLayout titleLayout, TextView textView2, TextView textView3, AppCompatImageView appCompatImageView, ImageView imageView, ViewPager2 viewPager2) {
        this.f64082a = constraintLayout;
        this.f64083b = linearLayout;
        this.f64084c = coordinatorLayout;
        this.f64085d = linearLayout2;
        this.f64086e = frameLayout;
        this.f64087f = magicIndicator;
        this.f64088g = textView;
        this.f64089h = titleLayout;
        this.f64090i = textView2;
        this.f64091j = textView3;
        this.f64092k = appCompatImageView;
        this.f64093l = imageView;
        this.f64094m = viewPager2;
    }

    public static b a(View view) {
        int i11 = R$id.bottom_layout;
        LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
        if (linearLayout != null) {
            i11 = R$id.cl_root;
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) g4.b.a(view, i11);
            if (coordinatorLayout != null) {
                i11 = R$id.connect_info_layout;
                LinearLayout linearLayout2 = (LinearLayout) g4.b.a(view, i11);
                if (linearLayout2 != null) {
                    i11 = R$id.fl_select_page_container;
                    FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                    if (frameLayout != null) {
                        i11 = R$id.magic_indicator;
                        MagicIndicator magicIndicator = (MagicIndicator) g4.b.a(view, i11);
                        if (magicIndicator != null) {
                            i11 = R$id.sendMore;
                            TextView textView = (TextView) g4.b.a(view, i11);
                            if (textView != null) {
                                i11 = R$id.tool_bar;
                                TitleLayout titleLayout = (TitleLayout) g4.b.a(view, i11);
                                if (titleLayout != null) {
                                    i11 = R$id.transfer_connect_state;
                                    TextView textView2 = (TextView) g4.b.a(view, i11);
                                    if (textView2 != null) {
                                        i11 = R$id.transfer_connected_devicename;
                                        TextView textView3 = (TextView) g4.b.a(view, i11);
                                        if (textView3 != null) {
                                            i11 = R$id.transfer_connected_state_image;
                                            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                                            if (appCompatImageView != null) {
                                                i11 = R$id.v_top_bg;
                                                ImageView imageView = (ImageView) g4.b.a(view, i11);
                                                if (imageView != null) {
                                                    i11 = R$id.view_pager;
                                                    ViewPager2 viewPager2 = (ViewPager2) g4.b.a(view, i11);
                                                    if (viewPager2 != null) {
                                                        return new b((ConstraintLayout) view, linearLayout, coordinatorLayout, linearLayout2, frameLayout, magicIndicator, textView, titleLayout, textView2, textView3, appCompatImageView, imageView, viewPager2);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_transfer_status, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f64082a;
    }
}
