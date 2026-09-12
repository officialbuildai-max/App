package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLConstraintLayout;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* loaded from: classes6.dex */
public final class a0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final BLConstraintLayout f63752a;

    /* renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f63753b;

    /* renamed from: c, reason: collision with root package name */
    public final BLConstraintLayout f63754c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f63755d;

    /* renamed from: e, reason: collision with root package name */
    public final ShapeableImageView f63756e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f63757f;

    /* renamed from: g, reason: collision with root package name */
    public final RecyclerView f63758g;

    /* renamed from: h, reason: collision with root package name */
    public final SwipeRefreshLayout f63759h;

    /* renamed from: i, reason: collision with root package name */
    public final View f63760i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f63761j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f63762k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f63763l;

    private a0(BLConstraintLayout bLConstraintLayout, ConstraintLayout constraintLayout, BLConstraintLayout bLConstraintLayout2, LinearLayout linearLayout, ShapeableImageView shapeableImageView, ImageView imageView, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, View view, TextView textView, TextView textView2, TextView textView3) {
        this.f63752a = bLConstraintLayout;
        this.f63753b = constraintLayout;
        this.f63754c = bLConstraintLayout2;
        this.f63755d = linearLayout;
        this.f63756e = shapeableImageView;
        this.f63757f = imageView;
        this.f63758g = recyclerView;
        this.f63759h = swipeRefreshLayout;
        this.f63760i = view;
        this.f63761j = textView;
        this.f63762k = textView2;
        this.f63763l = textView3;
    }

    public static a0 a(View view) {
        View a11;
        int i11 = R$id.emptyContentLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
        if (constraintLayout != null) {
            i11 = R$id.filterBar;
            BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) g4.b.a(view, i11);
            if (bLConstraintLayout != null) {
                i11 = R$id.filterCountryLayout;
                LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                if (linearLayout != null) {
                    i11 = R$id.ivCountryFlag;
                    ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                    if (shapeableImageView != null) {
                        i11 = R$id.ivEmptyContent;
                        ImageView imageView = (ImageView) g4.b.a(view, i11);
                        if (imageView != null) {
                            i11 = R$id.rvChannels;
                            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                            if (recyclerView != null) {
                                i11 = R$id.swipeRefresh;
                                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) g4.b.a(view, i11);
                                if (swipeRefreshLayout != null && (a11 = g4.b.a(view, (i11 = R$id.topBorderLine))) != null) {
                                    i11 = R$id.tvCountryName;
                                    TextView textView = (TextView) g4.b.a(view, i11);
                                    if (textView != null) {
                                        i11 = R$id.tvEmptyContent;
                                        TextView textView2 = (TextView) g4.b.a(view, i11);
                                        if (textView2 != null) {
                                            i11 = R$id.tvLocalTime;
                                            TextView textView3 = (TextView) g4.b.a(view, i11);
                                            if (textView3 != null) {
                                                return new a0((BLConstraintLayout) view, constraintLayout, bLConstraintLayout, linearLayout, shapeableImageView, imageView, recyclerView, swipeRefreshLayout, a11, textView, textView2, textView3);
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

    public static a0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_tv_channel_home_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.f63752a;
    }
}
