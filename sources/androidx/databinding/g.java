package androidx.databinding;

import android.view.View;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    private static e f8630a = new DataBinderMapperImpl();

    public static ViewDataBinding a(View view) {
        b(view, null);
        return null;
    }

    public static ViewDataBinding b(View view, f fVar) {
        c(view);
        Object tag = view.getTag();
        if (!(tag instanceof String)) {
            throw new IllegalArgumentException("View is not a binding layout");
        }
        int c11 = f8630a.c((String) tag);
        if (c11 != 0) {
            f8630a.b(fVar, view, c11);
            return null;
        }
        throw new IllegalArgumentException("View is not a binding layout. Tag: " + tag);
    }

    public static ViewDataBinding c(View view) {
        ViewDataBinding.g(view);
        return null;
    }
}
