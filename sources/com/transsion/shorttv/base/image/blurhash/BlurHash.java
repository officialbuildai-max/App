package com.transsion.shorttv.base.image.blurhash;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.LruCache;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class BlurHash {

    /* renamed from: a, reason: collision with root package name */
    private Context f52835a;

    /* renamed from: b, reason: collision with root package name */
    private float f52836b;

    /* renamed from: c, reason: collision with root package name */
    private LruCache f52837c;

    /* renamed from: d, reason: collision with root package name */
    private final n0 f52838d;

    public BlurHash(Context context, int i11, float f11) {
        Intrinsics.h(context, "context");
        this.f52835a = context;
        this.f52836b = f11;
        this.f52837c = new LruCache(i11);
        this.f52838d = o0.a(y0.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(String str, BitmapDrawable bitmapDrawable) {
        this.f52837c.put(str, bitmapDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BitmapDrawable g(String str) {
        return (BitmapDrawable) this.f52837c.get(str);
    }

    public final void f(String blurString, int i11, int i12, Function1 response) {
        Intrinsics.h(blurString, "blurString");
        Intrinsics.h(response, "response");
        k.d(this.f52838d, null, null, new BlurHash$execute$1(this, blurString, response, i11, i12, null), 3, null);
    }
}
