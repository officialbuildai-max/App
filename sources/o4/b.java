package o4;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.airbnb.lottie.l0;
import java.io.IOException;
import java.util.Map;
import v4.f;
import v4.l;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private static final Object f70856d = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final Context f70857a;

    /* renamed from: b, reason: collision with root package name */
    private final String f70858b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f70859c;

    public b(Drawable.Callback callback, String str, com.airbnb.lottie.b bVar, Map map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.f70858b = str;
        } else {
            this.f70858b = str + '/';
        }
        this.f70859c = map;
        d(bVar);
        if (callback instanceof View) {
            this.f70857a = ((View) callback).getContext().getApplicationContext();
        } else {
            this.f70857a = null;
        }
    }

    private Bitmap c(String str, Bitmap bitmap) {
        synchronized (f70856d) {
            ((l0) this.f70859c.get(str)).g(bitmap);
        }
        return bitmap;
    }

    public Bitmap a(String str) {
        l0 l0Var = (l0) this.f70859c.get(str);
        if (l0Var == null) {
            return null;
        }
        Bitmap b11 = l0Var.b();
        if (b11 != null) {
            return b11;
        }
        Context context = this.f70857a;
        if (context == null) {
            return null;
        }
        String c11 = l0Var.c();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (c11.startsWith("data:") && c11.indexOf("base64,") > 0) {
            try {
                byte[] decode = Base64.decode(c11.substring(c11.indexOf(44) + 1), 0);
                return c(str, l.m(BitmapFactory.decodeByteArray(decode, 0, decode.length, options), l0Var.f(), l0Var.d()));
            } catch (IllegalArgumentException e11) {
                f.d("data URL did not have correct base64 format.", e11);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.f70858b)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.f70858b + c11), null, options);
                if (decodeStream != null) {
                    return c(str, l.m(decodeStream, l0Var.f(), l0Var.d()));
                }
                f.c("Decoded image `" + str + "` is null.");
                return null;
            } catch (IllegalArgumentException e12) {
                f.d("Unable to decode image `" + str + "`.", e12);
                return null;
            }
        } catch (IOException e13) {
            f.d("Unable to open asset.", e13);
            return null;
        }
    }

    public boolean b(Context context) {
        if (this.f70857a instanceof Application) {
            context = context.getApplicationContext();
        }
        return context == this.f70857a;
    }

    public void d(com.airbnb.lottie.b bVar) {
    }

    public Bitmap e(String str, Bitmap bitmap) {
        if (bitmap != null) {
            Bitmap b11 = ((l0) this.f70859c.get(str)).b();
            c(str, bitmap);
            return b11;
        }
        l0 l0Var = (l0) this.f70859c.get(str);
        Bitmap b12 = l0Var.b();
        l0Var.g(null);
        return b12;
    }
}
