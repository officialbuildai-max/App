package py;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLTextView;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class y0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f73107a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f73108b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f73109c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f73110d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f73111e;

    /* renamed from: f, reason: collision with root package name */
    public final BLTextView f73112f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayout f73113g;

    /* renamed from: h, reason: collision with root package name */
    public final RecyclerView f73114h;

    /* renamed from: i, reason: collision with root package name */
    public final BLTextView f73115i;

    /* renamed from: j, reason: collision with root package name */
    public final Space f73116j;

    /* renamed from: k, reason: collision with root package name */
    public final View f73117k;

    private y0(View view, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, BLTextView bLTextView, LinearLayout linearLayout, RecyclerView recyclerView, BLTextView bLTextView2, Space space, View view2) {
        this.f73107a = view;
        this.f73108b = appCompatImageView;
        this.f73109c = appCompatTextView;
        this.f73110d = appCompatTextView2;
        this.f73111e = appCompatTextView3;
        this.f73112f = bLTextView;
        this.f73113g = linearLayout;
        this.f73114h = recyclerView;
        this.f73115i = bLTextView2;
        this.f73116j = space;
        this.f73117k = view2;
    }

    public static y0 a(View view) {
        View a11;
        int i11 = R$id.innerIcon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.innerTvInfo;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.innerTvName;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.innerTvTitle;
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView3 != null) {
                        i11 = R$id.iv_seasons;
                        BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
                        if (bLTextView != null) {
                            i11 = R$id.llLanguage;
                            LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                            if (linearLayout != null) {
                                i11 = R$id.quality_recycler_view;
                                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                                if (recyclerView != null) {
                                    i11 = R$id.tvLanguage;
                                    BLTextView bLTextView2 = (BLTextView) g4.b.a(view, i11);
                                    if (bLTextView2 != null) {
                                        i11 = R$id.v_bottom_space;
                                        Space space = (Space) g4.b.a(view, i11);
                                        if (space != null && (a11 = g4.b.a(view, (i11 = R$id.v_line))) != null) {
                                            return new y0(view, appCompatImageView, appCompatTextView, appCompatTextView2, appCompatTextView3, bLTextView, linearLayout, recyclerView, bLTextView2, space, a11);
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

    @Override // g4.a
    public View getRoot() {
        return this.f73107a;
    }
}
