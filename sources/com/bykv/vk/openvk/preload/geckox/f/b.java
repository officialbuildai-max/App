package com.bykv.vk.openvk.preload.geckox.f;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, a> f20772a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f20773b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private String f20774c;

    public b(Context context, String str, File file) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("access key empty");
        }
        if (file != null) {
            this.f20774c = new File(file, str).getAbsolutePath();
            return;
        }
        this.f20774c = new File(context.getFilesDir(), "gecko_offline_res_x" + File.separator + str).getAbsolutePath();
    }

    private a d(String str) {
        a aVar;
        int indexOf = str.indexOf("/");
        if (indexOf == -1) {
            new RuntimeException("channel：".concat(str));
        }
        String substring = str.substring(0, indexOf);
        synchronized (this.f20772a) {
            try {
                aVar = this.f20772a.get(substring);
                if (aVar == null) {
                    aVar = new a(this.f20774c, substring);
                    this.f20772a.put(substring, aVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    public final InputStream a(String str) throws Exception {
        if (this.f20773b.get()) {
            throw new RuntimeException("released");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath empty");
        }
        return d(str.trim()).a(str);
    }

    public final String a() {
        return this.f20774c;
    }

    public final int b(String str) throws Exception {
        if (this.f20773b.get()) {
            throw new RuntimeException("released");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath empty");
        }
        return d(str.trim()).c(str);
    }

    public final Map<String, Long> b() {
        HashMap hashMap = new HashMap();
        synchronized (this.f20772a) {
            try {
                Collection<a> values = this.f20772a.values();
                if (values == null) {
                    return hashMap;
                }
                for (a aVar : values) {
                    hashMap.put(aVar.b(), aVar.a());
                }
                return hashMap;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void c() throws Exception {
        if (this.f20773b.getAndSet(true)) {
            return;
        }
        GeckoLogger.d("Loader", "release version res loader");
        synchronized (this.f20772a) {
            try {
                Iterator<a> it = this.f20772a.values().iterator();
                while (it.hasNext()) {
                    it.next().c();
                }
                this.f20772a.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean c(String str) throws Exception {
        if (this.f20773b.get()) {
            throw new RuntimeException("released");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath empty");
        }
        return d(str.trim()).b(str);
    }
}
