package ho;

import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.player.longvideo.R$id;

/* loaded from: classes6.dex */
public final class h implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayoutCompat f64717a;

    /* renamed from: b, reason: collision with root package name */
    public final EditText f64718b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f64719c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f64720d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f64721e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayoutCompat f64722f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayoutCompat f64723g;

    private h(LinearLayoutCompat linearLayoutCompat, EditText editText, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, LinearLayoutCompat linearLayoutCompat2, LinearLayoutCompat linearLayoutCompat3) {
        this.f64717a = linearLayoutCompat;
        this.f64718b = editText;
        this.f64719c = appCompatImageView;
        this.f64720d = appCompatImageView2;
        this.f64721e = appCompatImageView3;
        this.f64722f = linearLayoutCompat2;
        this.f64723g = linearLayoutCompat3;
    }

    public static h a(View view) {
        int i11 = R$id.et_sync_adjust;
        EditText editText = (EditText) g4.b.a(view, i11);
        if (editText != null) {
            i11 = R$id.iv_close;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.iv_sync_adjust_minus;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R$id.iv_sync_adjust_plus;
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView3 != null) {
                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
                        i11 = R$id.llSyncAdjust;
                        LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) g4.b.a(view, i11);
                        if (linearLayoutCompat2 != null) {
                            return new h(linearLayoutCompat, editText, appCompatImageView, appCompatImageView2, appCompatImageView3, linearLayoutCompat, linearLayoutCompat2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f64717a;
    }
}
