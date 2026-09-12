package ji;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;

/* loaded from: classes6.dex */
public final class y implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayoutCompat f66315a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f66316b;

    /* renamed from: c, reason: collision with root package name */
    public final Button f66317c;

    /* renamed from: d, reason: collision with root package name */
    public final Button f66318d;

    /* renamed from: e, reason: collision with root package name */
    public final RecyclerView f66319e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f66320f;

    private y(LinearLayoutCompat linearLayoutCompat, Button button, Button button2, Button button3, RecyclerView recyclerView, AppCompatTextView appCompatTextView) {
        this.f66315a = linearLayoutCompat;
        this.f66316b = button;
        this.f66317c = button2;
        this.f66318d = button3;
        this.f66319e = recyclerView;
        this.f66320f = appCompatTextView;
    }

    public static y a(View view) {
        int i11 = R$id.btn;
        Button button = (Button) g4.b.a(view, i11);
        if (button != null) {
            i11 = R$id.btnLogger;
            Button button2 = (Button) g4.b.a(view, i11);
            if (button2 != null) {
                i11 = R$id.btnRequestDetailLog;
                Button button3 = (Button) g4.b.a(view, i11);
                if (button3 != null) {
                    i11 = R$id.f41832rv;
                    RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                    if (recyclerView != null) {
                        i11 = R$id.tvConfig;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView != null) {
                            return new y((LinearLayoutCompat) view, button, button2, button3, recyclerView, appCompatTextView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static y c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static y d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_test_ad_ps_offer_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f66315a;
    }
}
