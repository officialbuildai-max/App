package com.transsnet.downloader.manager;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes7.dex */
public final class StartDownloadHelper {

    /* renamed from: a, reason: collision with root package name */
    private final String f59597a = "StartDownloadHelper";

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f59598b = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.manager.x
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            qy.a e11;
            e11 = StartDownloadHelper.e();
            return e11;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final qy.a d() {
        return (qy.a) this.f59598b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qy.a e() {
        return (qy.a) zg.c.f79537e.a().h(qy.a.class);
    }

    public final void f(List list) {
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new StartDownloadHelper$startDownloadResource$1(list, this, null), 3, null);
    }
}
