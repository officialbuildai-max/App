package fu;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.subtitle.R$id;

/* loaded from: classes7.dex */
public final class a implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f62590a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f62591b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f62592c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f62593d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f62594e;

    /* renamed from: f, reason: collision with root package name */
    public final Space f62595f;

    /* renamed from: g, reason: collision with root package name */
    public final Space f62596g;

    /* renamed from: h, reason: collision with root package name */
    public final View f62597h;

    private a(ConstraintLayout constraintLayout, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, Space space, Space space2, View view) {
        this.f62590a = constraintLayout;
        this.f62591b = frameLayout;
        this.f62592c = frameLayout2;
        this.f62593d = frameLayout3;
        this.f62594e = frameLayout4;
        this.f62595f = space;
        this.f62596g = space2;
        this.f62597h = view;
    }

    public static a a(View view) {
        View a11;
        int i11 = R$id.flSearchContainer;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.flStyleContainer;
            FrameLayout frameLayout2 = (FrameLayout) g4.b.a(view, i11);
            if (frameLayout2 != null) {
                i11 = R$id.fl_subtitle_container;
                FrameLayout frameLayout3 = (FrameLayout) g4.b.a(view, i11);
                if (frameLayout3 != null) {
                    i11 = R$id.flSyncAdjustContainer;
                    FrameLayout frameLayout4 = (FrameLayout) g4.b.a(view, i11);
                    if (frameLayout4 != null) {
                        i11 = R$id.guideline_bottom_controller;
                        Space space = (Space) g4.b.a(view, i11);
                        if (space != null) {
                            i11 = R$id.guideline_player;
                            Space space2 = (Space) g4.b.a(view, i11);
                            if (space2 != null && (a11 = g4.b.a(view, (i11 = R$id.v_bg_start))) != null) {
                                return new a((ConstraintLayout) view, frameLayout, frameLayout2, frameLayout3, frameLayout4, space, space2, a11);
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
        return this.f62590a;
    }
}
