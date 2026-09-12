package bq;

import android.view.View;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.tn.lib.widget.TnTextView;
import com.transsion.room.R$id;

/* loaded from: classes5.dex */
public final class e0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f16827a;

    /* renamed from: b, reason: collision with root package name */
    public final BLTextView f16828b;

    /* renamed from: c, reason: collision with root package name */
    public final TnTextView f16829c;

    /* renamed from: d, reason: collision with root package name */
    public final BLView f16830d;

    private e0(View view, BLTextView bLTextView, TnTextView tnTextView, BLView bLView) {
        this.f16827a = view;
        this.f16828b = bLTextView;
        this.f16829c = tnTextView;
        this.f16830d = bLView;
    }

    public static e0 a(View view) {
        int i11 = R$id.tv_badge;
        BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
        if (bLTextView != null) {
            i11 = R$id.tv_title;
            TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
            if (tnTextView != null) {
                i11 = R$id.v_badge;
                BLView bLView = (BLView) g4.b.a(view, i11);
                if (bLView != null) {
                    return new e0(view, bLTextView, tnTextView, bLView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    public View getRoot() {
        return this.f16827a;
    }
}
