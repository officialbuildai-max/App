package rh;

import android.content.res.Resources;
import android.util.TypedValue;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f74653a = new a();

    private a() {
    }

    public final int a(float f11) {
        return (int) TypedValue.applyDimension(1, f11, Resources.getSystem().getDisplayMetrics());
    }
}
