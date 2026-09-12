package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLConstraintLayout;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* loaded from: classes6.dex */
public final class i implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final BLConstraintLayout f63841a;

    /* renamed from: b, reason: collision with root package name */
    public final EditText f63842b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f63843c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f63844d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f63845e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f63846f;

    /* renamed from: g, reason: collision with root package name */
    public final RecyclerView f63847g;

    /* renamed from: h, reason: collision with root package name */
    public final BLConstraintLayout f63848h;

    /* renamed from: i, reason: collision with root package name */
    public final View f63849i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f63850j;

    private i(BLConstraintLayout bLConstraintLayout, EditText editText, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, RecyclerView recyclerView, BLConstraintLayout bLConstraintLayout2, View view, TextView textView) {
        this.f63841a = bLConstraintLayout;
        this.f63842b = editText;
        this.f63843c = constraintLayout;
        this.f63844d = imageView;
        this.f63845e = imageView2;
        this.f63846f = imageView3;
        this.f63847g = recyclerView;
        this.f63848h = bLConstraintLayout2;
        this.f63849i = view;
        this.f63850j = textView;
    }

    public static i a(View view) {
        View a11;
        int i11 = R$id.etSearch;
        EditText editText = (EditText) g4.b.a(view, i11);
        if (editText != null) {
            i11 = R$id.header;
            ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
            if (constraintLayout != null) {
                i11 = R$id.ivClear;
                ImageView imageView = (ImageView) g4.b.a(view, i11);
                if (imageView != null) {
                    i11 = R$id.ivClose;
                    ImageView imageView2 = (ImageView) g4.b.a(view, i11);
                    if (imageView2 != null) {
                        i11 = R$id.ivSearch;
                        ImageView imageView3 = (ImageView) g4.b.a(view, i11);
                        if (imageView3 != null) {
                            i11 = R$id.rvCountries;
                            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                            if (recyclerView != null) {
                                i11 = R$id.searchBar;
                                BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) g4.b.a(view, i11);
                                if (bLConstraintLayout != null && (a11 = g4.b.a(view, (i11 = R$id.topBorder))) != null) {
                                    i11 = R$id.tvTitle;
                                    TextView textView = (TextView) g4.b.a(view, i11);
                                    if (textView != null) {
                                        return new i((BLConstraintLayout) view, editText, constraintLayout, imageView, imageView2, imageView3, recyclerView, bLConstraintLayout, a11, textView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static i c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.dialog_tv_country_select, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.f63841a;
    }
}
