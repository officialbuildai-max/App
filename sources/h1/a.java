package h1;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewKt;
import androidx.customview.poolingcontainer.R$id;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int f64173a = R$id.pooling_container_listener_holder_tag;

    /* renamed from: b, reason: collision with root package name */
    private static final int f64174b = R$id.is_pooling_container_tag;

    public static final void a(View view, b listener) {
        Intrinsics.h(view, "<this>");
        Intrinsics.h(listener, "listener");
        d(view).a(listener);
    }

    public static final void b(View view) {
        Intrinsics.h(view, "<this>");
        Iterator f67553a = ViewKt.getAllViews(view).getF67553a();
        while (f67553a.hasNext()) {
            d((View) f67553a.next()).b();
        }
    }

    public static final void c(ViewGroup viewGroup) {
        Intrinsics.h(viewGroup, "<this>");
        Iterator f67553a = ViewGroupKt.getChildren(viewGroup).getF67553a();
        while (f67553a.hasNext()) {
            d((View) f67553a.next()).b();
        }
    }

    private static final c d(View view) {
        int i11 = f64173a;
        c cVar = (c) view.getTag(i11);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        view.setTag(i11, cVar2);
        return cVar2;
    }

    public static final boolean e(View view) {
        Intrinsics.h(view, "<this>");
        Object tag = view.getTag(f64174b);
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean f(View view) {
        Intrinsics.h(view, "<this>");
        for (Object obj : ViewKt.getAncestors(view)) {
            if ((obj instanceof View) && e((View) obj)) {
                return true;
            }
        }
        return false;
    }

    public static final void g(View view, b listener) {
        Intrinsics.h(view, "<this>");
        Intrinsics.h(listener, "listener");
        d(view).c(listener);
    }

    public static final void h(View view, boolean z10) {
        Intrinsics.h(view, "<this>");
        view.setTag(f64174b, Boolean.valueOf(z10));
    }
}
