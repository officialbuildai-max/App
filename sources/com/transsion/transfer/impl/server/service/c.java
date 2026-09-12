package com.transsion.transfer.impl.server.service;

import com.transsion.transfer.androidasync.http.server.q;
import com.transsion.transfer.impl.i;
import iv.c;
import kotlin.Triple;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c implements q {

    /* renamed from: c, reason: collision with root package name */
    public static final a f55930c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final String f55931d = "Transfer-" + c.class.getName();

    /* renamed from: a, reason: collision with root package name */
    private final com.transsion.transfer.impl.g f55932a;

    /* renamed from: b, reason: collision with root package name */
    private i f55933b;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public c(com.transsion.transfer.impl.g fileHandler, i listener) {
        Intrinsics.h(fileHandler, "fileHandler");
        Intrinsics.h(listener, "listener");
        this.f55932a = fileHandler;
        this.f55933b = listener;
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
            String a11 = aVar.a(0, "noitfy client close success", "");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("createResponseJsonObj: ");
            sb2.append(a11);
            if (dVar != null) {
                dVar.send(a11);
            }
            this.f55933b.p(str);
        } catch (Exception e11) {
            if (dVar != null) {
                dVar.send(iv.c.f65742d.a(500, "server error:" + e11.getMessage(), ""));
            }
        }
    }
}
