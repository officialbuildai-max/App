package qv;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.noober.background.view.BLTextView;
import com.transsion.ugcvideodetail.R$id;

/* loaded from: classes7.dex */
public final class m implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f73922a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f73923b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f73924c;

    /* renamed from: d, reason: collision with root package name */
    public final BLTextView f73925d;

    private m(FrameLayout frameLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, BLTextView bLTextView) {
        this.f73922a = frameLayout;
        this.f73923b = appCompatTextView;
        this.f73924c = appCompatTextView2;
        this.f73925d = bLTextView;
    }

    public static m a(View view) {
        int i11 = R$id.tvUGCImmDownloading;
        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.tvUGCImmDownloadingPercent;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView2 != null) {
                i11 = R$id.tvUGCImmDownloadingView;
                BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
                if (bLTextView != null) {
                    return new m((FrameLayout) view, appCompatTextView, appCompatTextView2, bLTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f73922a;
    }
}
