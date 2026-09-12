package com.transsion.base.image.blurhash;

import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.RequestBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class c {
    public static final void b(final RequestBuilder requestBuilder, String blurString, int i11, int i12, BlurHash blurHash, final Function1 response) {
        Intrinsics.h(requestBuilder, "<this>");
        Intrinsics.h(blurString, "blurString");
        Intrinsics.h(blurHash, "blurHash");
        Intrinsics.h(response, "response");
        if (i11 == 0 || i12 == 0) {
            return;
        }
        blurHash.f(blurString, i11, i12, new Function1() { // from class: com.transsion.base.image.blurhash.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit c11;
                c11 = c.c(RequestBuilder.this, response, (BitmapDrawable) obj);
                return c11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(RequestBuilder requestBuilder, Function1 function1, BitmapDrawable drawable) {
        Intrinsics.h(drawable, "drawable");
        requestBuilder.placeholder(drawable);
        function1.invoke(requestBuilder);
        return Unit.f67184a;
    }
}
