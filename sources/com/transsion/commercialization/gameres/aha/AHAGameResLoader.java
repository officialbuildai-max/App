package com.transsion.commercialization.gameres.aha;

import android.content.Context;
import com.transsion.bean.GameInfoType;
import com.transsion.commercialization.gameres.GameResView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class AHAGameResLoader implements com.transsion.commercialization.gameres.a {

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f43831b = LazyKt.b(new Function0() { // from class: com.transsion.commercialization.gameres.aha.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            a h11;
            h11 = AHAGameResLoader.h();
            return h11;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final a g() {
        return (a) this.f43831b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a h() {
        return (a) zg.c.f79537e.a().h(a.class);
    }

    @Override // com.transsion.commercialization.gameres.a
    public void a(Context context, String pageName, String itemId, Function1 callback) {
        Intrinsics.h(context, "context");
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(itemId, "itemId");
        Intrinsics.h(callback, "callback");
        k.d(o0.a(y0.b()), null, null, new AHAGameResLoader$loadGameInfo$1(itemId, this, callback, context, pageName, null), 3, null);
    }

    public mk.a d(String pageName, String itemId, c info) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(itemId, "itemId");
        Intrinsics.h(info, "info");
        mk.a aVar = new mk.a(GameInfoType.AHA, null, info);
        aVar.l(pageName);
        aVar.k(itemId);
        return aVar;
    }

    public GameResView e(Context context, mk.a info) {
        Intrinsics.h(context, "context");
        Intrinsics.h(info, "info");
        AHAGameResView aHAGameResView = new AHAGameResView(context);
        aHAGameResView.setContent(info);
        return aHAGameResView;
    }

    public String f() {
        return pg.a.f72569a.d() ? "https://tapi.ahagamecenter.com" : "https://api.ahagamecenter.com";
    }
}
