package com.transsion.transfer.impl.server.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.transsion.transfer.androidasync.http.server.q;
import com.transsion.transfer.impl.TaskState;
import com.transsion.transfer.impl.i;
import iv.c;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class NotifyFileFinishService implements q {

    /* renamed from: d, reason: collision with root package name */
    public static final a f55911d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private static final String f55912e = "Transfer-" + NotifyFileFinishService.class.getName();

    /* renamed from: a, reason: collision with root package name */
    private final com.transsion.transfer.impl.g f55913a;

    /* renamed from: b, reason: collision with root package name */
    private i f55914b;

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f55915c;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public NotifyFileFinishService(com.transsion.transfer.impl.g fileHandler, i listener) {
        Intrinsics.h(fileHandler, "fileHandler");
        Intrinsics.h(listener, "listener");
        this.f55913a = fileHandler;
        this.f55914b = listener;
        this.f55915c = LazyKt.b(new Function0() { // from class: com.transsion.transfer.impl.server.service.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Gson d11;
                d11 = NotifyFileFinishService.d();
                return d11;
            }
        });
    }

    private final Gson c() {
        return (Gson) this.f55915c.getValue();
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
            List list = (List) c().fromJson(fVar != null ? fVar.a() : null, new TypeToken<List<String>>() { // from class: com.transsion.transfer.impl.server.service.NotifyFileFinishService$onRequest$array$1
            }.getType());
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    File file = new File((String) it.next());
                    if (file.exists()) {
                        i iVar = this.f55914b;
                        String absolutePath = file.getAbsolutePath();
                        Intrinsics.g(absolutePath, "getAbsolutePath(...)");
                        iVar.K(str, absolutePath, TaskState.FINISH, file.length(), file.length());
                    }
                }
            }
            String a11 = iv.c.f65742d.a(0, "noitfy server success", "");
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
