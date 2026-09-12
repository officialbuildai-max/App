package so;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.transsion.postdetail.R$id;

/* loaded from: classes6.dex */
public final class c0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f75577a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f75578b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f75579c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f75580d;

    /* renamed from: e, reason: collision with root package name */
    public final ShapeableImageView f75581e;

    /* renamed from: f, reason: collision with root package name */
    public final BLLinearLayout f75582f;

    /* renamed from: g, reason: collision with root package name */
    public final BLLinearLayout f75583g;

    /* renamed from: h, reason: collision with root package name */
    public final RecyclerView f75584h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f75585i;

    /* renamed from: j, reason: collision with root package name */
    public final BLTextView f75586j;

    private c0(View view, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, ShapeableImageView shapeableImageView, BLLinearLayout bLLinearLayout, BLLinearLayout bLLinearLayout2, RecyclerView recyclerView, AppCompatTextView appCompatTextView3, BLTextView bLTextView) {
        this.f75577a = view;
        this.f75578b = appCompatImageView;
        this.f75579c = appCompatTextView;
        this.f75580d = appCompatTextView2;
        this.f75581e = shapeableImageView;
        this.f75582f = bLLinearLayout;
        this.f75583g = bLLinearLayout2;
        this.f75584h = recyclerView;
        this.f75585i = appCompatTextView3;
        this.f75586j = bLTextView;
    }

    public static c0 a(View view) {
        int i11 = R$id.innerIcon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.innerTvInfo;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.innerTvName;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.iv_cover;
                    ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                    if (shapeableImageView != null) {
                        i11 = R$id.ll_detail;
                        BLLinearLayout bLLinearLayout = (BLLinearLayout) g4.b.a(view, i11);
                        if (bLLinearLayout != null) {
                            i11 = R$id.ll_download;
                            BLLinearLayout bLLinearLayout2 = (BLLinearLayout) g4.b.a(view, i11);
                            if (bLLinearLayout2 != null) {
                                i11 = R$id.recycler_view_ep;
                                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                                if (recyclerView != null) {
                                    i11 = R$id.tv_ep_title;
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView3 != null) {
                                        i11 = R$id.tv_more;
                                        BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
                                        if (bLTextView != null) {
                                            return new c0(view, appCompatImageView, appCompatTextView, appCompatTextView2, shapeableImageView, bLLinearLayout, bLLinearLayout2, recyclerView, appCompatTextView3, bLTextView);
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
        return this.f75577a;
    }
}
