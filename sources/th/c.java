package th;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;

/* loaded from: classes4.dex */
public final class c implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f76344a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f76345b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f76346c;

    /* renamed from: d, reason: collision with root package name */
    public final CardView f76347d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f76348e;

    /* renamed from: f, reason: collision with root package name */
    public final TextSwitcher f76349f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f76350g;

    private c(LinearLayout linearLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, CardView cardView, TextView textView, TextSwitcher textSwitcher, TextView textView2) {
        this.f76344a = linearLayout;
        this.f76345b = appCompatImageView;
        this.f76346c = appCompatImageView2;
        this.f76347d = cardView;
        this.f76348e = textView;
        this.f76349f = textSwitcher;
        this.f76350g = textView2;
    }

    public static native c a(View view);

    public static native c c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10);

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public native LinearLayout getRoot();
}
