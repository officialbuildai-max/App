package com.transsion.transfer.impl.server.service;

import com.transsion.transfer.androidasync.http.server.q;
import com.transsion.transfer.impl.entity.FileData;
import com.transsion.transfer.impl.i;
import iv.c;
import java.util.Iterator;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b implements q {

    /* renamed from: c, reason: collision with root package name */
    public static final a f55926c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final String f55927d = "Transfer-" + b.class.getName();

    /* renamed from: a, reason: collision with root package name */
    private final com.transsion.transfer.impl.g f55928a;

    /* renamed from: b, reason: collision with root package name */
    private i f55929b;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return b.f55927d;
        }
    }

    public b(com.transsion.transfer.impl.g fileHandler, i listener) {
        Intrinsics.h(fileHandler, "fileHandler");
        Intrinsics.h(listener, "listener");
        this.f55928a = fileHandler;
        this.f55929b = listener;
    }

    @Override // com.transsion.transfer.androidasync.http.server.q
    public void b(com.transsion.transfer.androidasync.http.server.b bVar, com.transsion.transfer.androidasync.http.server.d dVar) {
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
        List d11 = mv.b.f70138a.d();
        String a11 = aVar.a(0, "", d11);
        Iterator it = d11.iterator();
        while (it.hasNext()) {
            String fileRemotePath = ((FileData) it.next()).getFileRemotePath();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onRequest: ");
            sb2.append(fileRemotePath);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("createResponseJsonObj: ");
        sb3.append(a11);
        if (dVar != null) {
            dVar.send(a11);
        }
        this.f55929b.n(str, d11);
    }
}
