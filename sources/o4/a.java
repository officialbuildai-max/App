package o4;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.HashMap;
import java.util.Map;
import p4.h;
import v4.f;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private final AssetManager f70853d;

    /* renamed from: e, reason: collision with root package name */
    private com.airbnb.lottie.a f70854e;

    /* renamed from: a, reason: collision with root package name */
    private final h f70850a = new h();

    /* renamed from: b, reason: collision with root package name */
    private final Map f70851b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map f70852c = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private String f70855f = ".ttf";

    public a(Drawable.Callback callback, com.airbnb.lottie.a aVar) {
        this.f70854e = aVar;
        if (callback instanceof View) {
            this.f70853d = ((View) callback).getContext().getAssets();
        } else {
            f.c("LottieDrawable must be inside of a view for images to work.");
            this.f70853d = null;
        }
    }

    private Typeface a(p4.b bVar) {
        Typeface typeface;
        String a11 = bVar.a();
        Typeface typeface2 = (Typeface) this.f70852c.get(a11);
        if (typeface2 != null) {
            return typeface2;
        }
        String c11 = bVar.c();
        String b11 = bVar.b();
        com.airbnb.lottie.a aVar = this.f70854e;
        if (aVar != null) {
            typeface = aVar.b(a11, c11, b11);
            if (typeface == null) {
                typeface = this.f70854e.a(a11);
            }
        } else {
            typeface = null;
        }
        com.airbnb.lottie.a aVar2 = this.f70854e;
        if (aVar2 != null && typeface == null) {
            String d11 = aVar2.d(a11, c11, b11);
            if (d11 == null) {
                d11 = this.f70854e.c(a11);
            }
            if (d11 != null) {
                typeface = Typeface.createFromAsset(this.f70853d, d11);
            }
        }
        if (bVar.d() != null) {
            return bVar.d();
        }
        if (typeface == null) {
            typeface = Typeface.createFromAsset(this.f70853d, "fonts/" + a11 + this.f70855f);
        }
        this.f70852c.put(a11, typeface);
        return typeface;
    }

    private Typeface e(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i11 = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        return typeface.getStyle() == i11 ? typeface : Typeface.create(typeface, i11);
    }

    public Typeface b(p4.b bVar) {
        this.f70850a.b(bVar.a(), bVar.c());
        Typeface typeface = (Typeface) this.f70851b.get(this.f70850a);
        if (typeface != null) {
            return typeface;
        }
        Typeface e11 = e(a(bVar), bVar.c());
        this.f70851b.put(this.f70850a, e11);
        return e11;
    }

    public void c(String str) {
        this.f70855f = str;
    }

    public void d(com.airbnb.lottie.a aVar) {
        this.f70854e = aVar;
    }
}
