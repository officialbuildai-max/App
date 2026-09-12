package bq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLTextView;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: classes5.dex */
public final class z implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final BLFrameLayout f16992a;

    /* renamed from: b, reason: collision with root package name */
    public final BLFrameLayout f16993b;

    /* renamed from: c, reason: collision with root package name */
    public final BLTextView f16994c;

    /* renamed from: d, reason: collision with root package name */
    public final View f16995d;

    private z(BLFrameLayout bLFrameLayout, BLFrameLayout bLFrameLayout2, BLTextView bLTextView, View view) {
        this.f16992a = bLFrameLayout;
        this.f16993b = bLFrameLayout2;
        this.f16994c = bLTextView;
        this.f16995d = view;
    }

    public static z a(View view) {
        View a11;
        BLFrameLayout bLFrameLayout = (BLFrameLayout) view;
        int i11 = R$id.tv_title;
        BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
        if (bLTextView == null || (a11 = g4.b.a(view, (i11 = R$id.v_selected))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
        }
        return new z(bLFrameLayout, bLFrameLayout, bLTextView, a11);
    }

    public static z c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.item_room_list_tab, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLFrameLayout getRoot() {
        return this.f16992a;
    }
}
