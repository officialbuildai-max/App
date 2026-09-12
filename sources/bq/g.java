package bq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: classes5.dex */
public final class g implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f16835a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f16836b;

    /* renamed from: c, reason: collision with root package name */
    public final TitleLayout f16837c;

    private g(LinearLayout linearLayout, FrameLayout frameLayout, TitleLayout titleLayout) {
        this.f16835a = linearLayout;
        this.f16836b = frameLayout;
        this.f16837c = titleLayout;
    }

    public static g a(View view) {
        int i11 = R$id.fl_container;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.tool_bar;
            TitleLayout titleLayout = (TitleLayout) g4.b.a(view, i11);
            if (titleLayout != null) {
                return new g((LinearLayout) view, frameLayout, titleLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static g c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static g d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_others_room_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f16835a;
    }
}
