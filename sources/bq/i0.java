package bq;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.room.R$id;

/* loaded from: classes5.dex */
public final class i0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f16851a;

    /* renamed from: b, reason: collision with root package name */
    public final View f16852b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f16853c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f16854d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f16855e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f16856f;

    private i0(View view, View view2, RecyclerView recyclerView, TextView textView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.f16851a = view;
        this.f16852b = view2;
        this.f16853c = recyclerView;
        this.f16854d = textView;
        this.f16855e = appCompatTextView;
        this.f16856f = appCompatTextView2;
    }

    public static i0 a(View view) {
        int i11 = R$id.all_bg;
        View a11 = g4.b.a(view, i11);
        if (a11 != null) {
            i11 = R$id.recyclerView;
            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
            if (recyclerView != null) {
                i11 = R$id.tv_banner;
                TextView textView = (TextView) g4.b.a(view, i11);
                if (textView != null) {
                    i11 = R$id.tvMore;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView != null) {
                        i11 = R$id.tv_title;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView2 != null) {
                            return new i0(view, a11, recyclerView, textView, appCompatTextView, appCompatTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    public View getRoot() {
        return this.f16851a;
    }
}
