package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class i0 extends c0 {

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference f2113b;

    public i0(Context context, Resources resources) {
        super(resources);
        this.f2113b = new WeakReference(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i11) {
        Drawable a11 = a(i11);
        Context context = (Context) this.f2113b.get();
        if (a11 != null && context != null) {
            b0.h().x(context, i11, a11);
        }
        return a11;
    }
}
