package com.transsion.transfer.impl.server.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.transsion.transfer.androidasync.http.server.q;
import com.transsion.transfer.impl.entity.FileData;
import com.transsion.transfer.impl.i;
import iv.c;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class NotifyFileErrorService implements q {

    /* renamed from: d, reason: collision with root package name */
    public static final a f55906d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private static final String f55907e = "Transfer-" + NotifyFileErrorService.class.getName();

    /* renamed from: a, reason: collision with root package name */
    private final com.transsion.transfer.impl.g f55908a;

    /* renamed from: b, reason: collision with root package name */
    private i f55909b;

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f55910c;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public NotifyFileErrorService(com.transsion.transfer.impl.g fileHandler, i listener) {
        Intrinsics.h(fileHandler, "fileHandler");
        Intrinsics.h(listener, "listener");
        this.f55908a = fileHandler;
        this.f55909b = listener;
        this.f55910c = LazyKt.b(new Function0() { // from class: com.transsion.transfer.impl.server.service.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Gson d11;
                d11 = NotifyFileErrorService.d();
                return d11;
            }
        });
    }

    private final Gson c() {
        return (Gson) this.f55910c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Gson d() {
        return new Gson();
    }

    @Override // com.transsion.transfer.androidasync.http.server.q
    public void b(com.transsion.transfer.androidasync.http.server.b bVar, com.transsion.transfer.androidasync.http.server.d dVar) {
        try {
            c.a aVar = iv.c.f65742d;
            Triple c11 = aVar.c(bVar != null ? bVar.getHeaders() : null);
            int intValue = ((Number) c11.getSecond()).intValue();
            String str = (String) c11.getThird();
            if (intValue < 1) {
                if (dVar != null) {
                    dVar.send(aVar.a(-1, "protocol version compatible error", ""));
                    return;
                }
                return;
            }
            cv.f fVar = bVar != null ? (cv.f) bVar.D() : null;
            if (!(fVar instanceof cv.f)) {
                fVar = null;
            }
            List<Pair> list = (List) c().fromJson(fVar != null ? fVar.a() : null, new TypeToken<List<Pair<? extends String, ? extends Integer>>>() { // from class: com.transsion.transfer.impl.server.service.NotifyFileErrorService$onRequest$data$1
            }.getType());
            Intrinsics.e(list);
            for (Pair pair : list) {
                this.f55909b.K(str, (String) pair.getFirst(), FileData.INSTANCE.b(((Number) pair.getSecond()).intValue()), 0L, 0L);
            }
            String a11 = iv.c.f65742d.a(0, "notify File Task change", "");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("createResponseJsonObj: ");
            sb2.append(a11);
            if (dVar != null) {
                dVar.send(a11);
            }
        } catch (Exception e11) {
            if (dVar != null) {
                dVar.send(iv.c.f65742d.a(500, "server error:" + e11.getMessage(), ""));
            }
        }
    }
}
