package gv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.transsion.transfer.R$id;
import com.transsion.transfer.R$layout;

/* loaded from: classes7.dex */
public final class c implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f64095a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f64096b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f64097c;

    /* renamed from: d, reason: collision with root package name */
    public final DecoratedBarcodeView f64098d;

    private c(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, DecoratedBarcodeView decoratedBarcodeView) {
        this.f64095a = constraintLayout;
        this.f64096b = appCompatImageView;
        this.f64097c = constraintLayout2;
        this.f64098d = decoratedBarcodeView;
    }

    public static c a(View view) {
        int i11 = R$id.ivClose;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            int i12 = R$id.zxing_barcode_scanner;
            DecoratedBarcodeView decoratedBarcodeView = (DecoratedBarcodeView) g4.b.a(view, i12);
            if (decoratedBarcodeView != null) {
                return new c(constraintLayout, appCompatImageView, constraintLayout, decoratedBarcodeView);
            }
            i11 = i12;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static c c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static c d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_wifi_connect, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f64095a;
    }
}
