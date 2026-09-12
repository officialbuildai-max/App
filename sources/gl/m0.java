package gl;

import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.home.R$id;

/* loaded from: classes6.dex */
public final class m0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f63900a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayoutCompat f63901b;

    /* renamed from: c, reason: collision with root package name */
    public final View f63902c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayoutCompat f63903d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayoutCompat f63904e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayoutCompat f63905f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayoutCompat f63906g;

    /* renamed from: h, reason: collision with root package name */
    public final ConstraintLayout f63907h;

    /* renamed from: i, reason: collision with root package name */
    public final ProgressBar f63908i;

    private m0(ConstraintLayout constraintLayout, LinearLayoutCompat linearLayoutCompat, View view, LinearLayoutCompat linearLayoutCompat2, LinearLayoutCompat linearLayoutCompat3, LinearLayoutCompat linearLayoutCompat4, LinearLayoutCompat linearLayoutCompat5, ConstraintLayout constraintLayout2, ProgressBar progressBar) {
        this.f63900a = constraintLayout;
        this.f63901b = linearLayoutCompat;
        this.f63902c = view;
        this.f63903d = linearLayoutCompat2;
        this.f63904e = linearLayoutCompat3;
        this.f63905f = linearLayoutCompat4;
        this.f63906g = linearLayoutCompat5;
        this.f63907h = constraintLayout2;
        this.f63908i = progressBar;
    }

    public static m0 a(View view) {
        View a11;
        int i11 = R$id.f44265l1;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) g4.b.a(view, i11);
        if (linearLayoutCompat != null && (a11 = g4.b.a(view, (i11 = R$id.f44266l2))) != null) {
            i11 = R$id.f44267l3;
            LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) g4.b.a(view, i11);
            if (linearLayoutCompat2 != null) {
                i11 = R$id.f44268l4;
                LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) g4.b.a(view, i11);
                if (linearLayoutCompat3 != null) {
                    i11 = R$id.f44269l5;
                    LinearLayoutCompat linearLayoutCompat4 = (LinearLayoutCompat) g4.b.a(view, i11);
                    if (linearLayoutCompat4 != null) {
                        i11 = R$id.f44270l6;
                        LinearLayoutCompat linearLayoutCompat5 = (LinearLayoutCompat) g4.b.a(view, i11);
                        if (linearLayoutCompat5 != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                            i11 = R$id.loading_pb;
                            ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                            if (progressBar != null) {
                                return new m0(constraintLayout, linearLayoutCompat, a11, linearLayoutCompat2, linearLayoutCompat3, linearLayoutCompat4, linearLayoutCompat5, constraintLayout, progressBar);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f63900a;
    }
}
