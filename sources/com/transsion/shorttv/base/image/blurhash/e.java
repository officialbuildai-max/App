package com.transsion.shorttv.base.image.blurhash;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f52845a = new e();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f52846b = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.base.image.blurhash.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            BlurHash b11;
            b11 = e.b();
            return b11;
        }
    });

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlurHash b() {
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return new BlurHash(a11, 10, 0.6f);
    }

    public static /* synthetic */ void d(e eVar, String str, int i11, int i12, Function1 function1, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 20;
        }
        if ((i13 & 4) != 0) {
            i12 = 20;
        }
        eVar.c(str, i11, i12, function1);
    }

    private final BlurHash e() {
        return (BlurHash) f52846b.getValue();
    }

    public final void c(String blurString, int i11, int i12, Function1 response) {
        Intrinsics.h(blurString, "blurString");
        Intrinsics.h(response, "response");
        e().f(blurString, i11, i12, response);
    }
}
