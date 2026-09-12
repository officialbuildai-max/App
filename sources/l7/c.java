package l7;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.cloud.sdk.commonutil.util.e;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f68860a = new c();

    private c() {
    }

    public static final Drawable a(Drawable drawable) {
        return b.f68857a.a(drawable);
    }

    public static final Drawable b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (bArr.length <= 1 || bArr[0] != 71) ? f68860a.d(bArr) : f68860a.c(bArr);
        } catch (Exception e11) {
            com.cloud.sdk.commonutil.util.c.Log().w("HisavanaImageRender", "getDrawableFromData failed, error=" + e11.getMessage());
            return null;
        }
    }

    private final Drawable c(byte[] bArr) {
        Drawable c11 = b.f68857a.c(bArr);
        if (c11 != null) {
            return c11;
        }
        Drawable a11 = a.f68855a.a(bArr);
        return a11 == null ? d(bArr) : a11;
    }

    private final Drawable d(byte[] bArr) {
        return new BitmapDrawable(e.a().getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
    }

    public static final void e() {
        b.f68857a.f();
        a.f68855a.b();
    }
}
