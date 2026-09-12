package com.mbridge.msdk.foundation.same.directory;

import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.r0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class e {

    /* renamed from: c, reason: collision with root package name */
    private static volatile e f35448c;

    /* renamed from: a, reason: collision with root package name */
    private final b f35449a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<a> f35450b = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public File f35451a;

        /* renamed from: b, reason: collision with root package name */
        public c f35452b;

        public a(c cVar, File file) {
            this.f35452b = cVar;
            this.f35451a = file;
        }
    }

    private e(b bVar) {
        this.f35449a = bVar;
    }

    public static File a(c cVar) {
        try {
            if (b() == null || b().f35450b == null || b().f35450b.isEmpty()) {
                return null;
            }
            Iterator<a> it = b().f35450b.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.f35452b.equals(cVar)) {
                    return next.f35451a;
                }
            }
            return null;
        } catch (Throwable th2) {
            o0.b("MBridgeDirManager", th2.getMessage(), th2);
            return null;
        }
    }

    public static synchronized void a(b bVar) {
        synchronized (e.class) {
            if (f35448c == null) {
                f35448c = new e(bVar);
            }
        }
    }

    private boolean a(com.mbridge.msdk.foundation.same.directory.a aVar) {
        String str;
        com.mbridge.msdk.foundation.same.directory.a c11 = aVar.c();
        if (c11 == null) {
            str = aVar.b();
        } else {
            File a11 = a(c11.d());
            if (a11 == null) {
                return false;
            }
            str = a11.getAbsolutePath() + File.separator + aVar.b();
        }
        File file = new File(str);
        if (!(!file.exists() ? file.mkdirs() : true)) {
            return false;
        }
        this.f35450b.add(new a(aVar.d(), file));
        List<com.mbridge.msdk.foundation.same.directory.a> a12 = aVar.a();
        if (a12 != null) {
            Iterator<com.mbridge.msdk.foundation.same.directory.a> it = a12.iterator();
            while (it.hasNext()) {
                if (!a(it.next())) {
                    return false;
                }
            }
        }
        return true;
    }

    public static synchronized e b() {
        e eVar;
        synchronized (e.class) {
            try {
                if (f35448c == null && com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    r0.a(com.mbridge.msdk.foundation.controller.c.m().d());
                }
                eVar = f35448c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return eVar;
    }

    public static String b(c cVar) {
        File a11 = a(cVar);
        if (a11 != null) {
            return a11.getAbsolutePath();
        }
        return null;
    }

    public boolean a() {
        return a(this.f35449a.a());
    }
}
