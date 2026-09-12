package bq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsion.room.R$layout;

/* loaded from: classes5.dex */
public final class i implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f16849a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f16850b;

    private i(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f16849a = frameLayout;
        this.f16850b = frameLayout2;
    }

    public static i a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new i(frameLayout, frameLayout);
    }

    public static i c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_room_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f16849a;
    }
}
