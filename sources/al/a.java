package al;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: al.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0010a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f737a;

        C0010a(float f11) {
            this.f737a = f11;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Intrinsics.h(view, "view");
            Intrinsics.h(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f737a);
        }
    }

    public static final void a(View view, float f11) {
        Intrinsics.h(view, "<this>");
        view.setOutlineProvider(new C0010a(f11));
        view.setClipToOutline(true);
    }
}
