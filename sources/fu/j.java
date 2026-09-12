package fu;

import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.subtitle.R$id;

/* loaded from: classes7.dex */
public final class j implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayoutCompat f62672a;

    /* renamed from: b, reason: collision with root package name */
    public final EditText f62673b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f62674c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f62675d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f62676e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayoutCompat f62677f;

    private j(LinearLayoutCompat linearLayoutCompat, EditText editText, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, LinearLayoutCompat linearLayoutCompat2) {
        this.f62672a = linearLayoutCompat;
        this.f62673b = editText;
        this.f62674c = appCompatImageView;
        this.f62675d = appCompatImageView2;
        this.f62676e = appCompatImageView3;
        this.f62677f = linearLayoutCompat2;
    }

    public static j a(View view) {
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
                        return new j(linearLayoutCompat, editText, appCompatImageView, appCompatImageView2, appCompatImageView3, linearLayoutCompat);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f62672a;
    }
}
