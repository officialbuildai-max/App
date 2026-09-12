package bq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsion.room.R$layout;

/* loaded from: classes5.dex */
public final class e implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f16825a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f16826b;

    private e(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f16825a = frameLayout;
        this.f16826b = frameLayout2;
    }

    public static e a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new e(frameLayout, frameLayout);
    }

    public static e c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static e d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_list_subscription, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f16825a;
    }
}
