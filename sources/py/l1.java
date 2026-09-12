package py;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLFrameLayout;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class l1 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f72958a;

    /* renamed from: b, reason: collision with root package name */
    public final BLFrameLayout f72959b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f72960c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f72961d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f72962e;

    /* renamed from: f, reason: collision with root package name */
    public final View f72963f;

    private l1(View view, BLFrameLayout bLFrameLayout, AppCompatImageView appCompatImageView, RecyclerView recyclerView, AppCompatTextView appCompatTextView, View view2) {
        this.f72958a = view;
        this.f72959b = bLFrameLayout;
        this.f72960c = appCompatImageView;
        this.f72961d = recyclerView;
        this.f72962e = appCompatTextView;
        this.f72963f = view2;
    }

    public static l1 a(View view) {
        View a11;
        int i11 = R$id.fl_content;
        BLFrameLayout bLFrameLayout = (BLFrameLayout) g4.b.a(view, i11);
        if (bLFrameLayout != null) {
            i11 = R$id.iv_close;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.recycler_view;
                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.tv_title;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView != null && (a11 = g4.b.a(view, (i11 = R$id.v_top_bg))) != null) {
                        return new l1(view, bLFrameLayout, appCompatImageView, recyclerView, appCompatTextView, a11);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    public View getRoot() {
        return this.f72958a;
    }
}
