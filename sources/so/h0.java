package so;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.postdetail.R$id;

/* loaded from: classes6.dex */
public final class h0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayoutCompat f75664a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f75665b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f75666c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f75667d;

    private h0(LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.f75664a = linearLayoutCompat;
        this.f75665b = appCompatTextView;
        this.f75666c = appCompatTextView2;
        this.f75667d = appCompatTextView3;
    }

    public static h0 a(View view) {
        int i11 = R$id.iv_all;
        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.iv_hottest;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView2 != null) {
                i11 = R$id.iv_latest;
                AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView3 != null) {
                    return new h0((LinearLayoutCompat) view, appCompatTextView, appCompatTextView2, appCompatTextView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f75664a;
    }
}
