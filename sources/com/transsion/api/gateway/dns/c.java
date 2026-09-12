package com.transsion.api.gateway.dns;

import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class c {
    private static volatile c INSTANCE;

    /* renamed from: a, reason: collision with root package name */
    public static CopyOnWriteArrayList f42574a = new CopyOnWriteArrayList();

    public static c a() {
        if (INSTANCE == null) {
            synchronized (c.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new c();
                        INSTANCE.b();
                    }
                } finally {
                }
            }
        }
        return INSTANCE;
    }

    public final void b() {
        b bVar = new b("apigateway.tmctool.com");
        b bVar2 = new b("apigateway.tmctool.com");
        for (String str : com.transsion.api.gateway.config.d.f42570a) {
            bVar.a(str, 443);
        }
        for (String str2 : com.transsion.api.gateway.config.c.f42569a) {
            bVar2.a(str2, 443);
        }
        f42574a.add(bVar);
        f42574a.add(bVar2);
    }
}
