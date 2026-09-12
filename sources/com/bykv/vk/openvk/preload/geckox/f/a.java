package com.bykv.vk.openvk.preload.geckox.f;

import com.bykv.vk.openvk.preload.geckox.f.a.c;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import com.bykv.vk.openvk.preload.geckox.utils.g;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private String f20765a;

    /* renamed from: b, reason: collision with root package name */
    private String f20766b;

    /* renamed from: c, reason: collision with root package name */
    private volatile File f20767c;

    /* renamed from: d, reason: collision with root package name */
    private volatile Long f20768d;

    /* renamed from: e, reason: collision with root package name */
    private volatile com.bykv.vk.openvk.preload.geckox.f.a.a f20769e;

    /* renamed from: f, reason: collision with root package name */
    private AtomicBoolean f20770f = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, String str2) {
        this.f20765a = str;
        this.f20766b = str2;
    }

    private static String a(String str, String str2) {
        return str2.substring(str.length() + 1);
    }

    private synchronized com.bykv.vk.openvk.preload.geckox.f.a.a d(String str) throws Exception {
        if (this.f20769e != null) {
            return this.f20769e;
        }
        File e11 = e(str);
        if (e11 == null) {
            throw new FileNotFoundException("channel no exist，channel:".concat(String.valueOf(str)));
        }
        File file = new File(e11, "res.macv");
        File file2 = new File(e11, "res");
        if (file2.exists() && file2.isDirectory()) {
            this.f20769e = new c(e11);
        } else {
            if (!file.exists() || !file.isFile()) {
                throw new RuntimeException("can not find res, dir:" + e11.getAbsolutePath());
            }
            this.f20769e = new com.bykv.vk.openvk.preload.geckox.f.a.b(e11);
        }
        return this.f20769e;
    }

    private synchronized File e(String str) throws Exception {
        if (this.f20767c != null) {
            return this.f20767c;
        }
        if (this.f20768d != null && this.f20768d.longValue() == -1) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f20765a);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(str);
        sb2.append(str2);
        sb2.append("select.lock");
        com.bykv.vk.openvk.preload.geckox.g.b a11 = com.bykv.vk.openvk.preload.geckox.g.b.a(sb2.toString());
        try {
            if (this.f20768d == null) {
                this.f20768d = g.a(new File(this.f20765a, str));
            }
            if (this.f20768d == null) {
                this.f20768d = -1L;
                a11.a();
                return null;
            }
            File file = new File(this.f20765a, str2 + str + str2 + this.f20768d + str2 + "using.lock");
            this.f20767c = file.getParentFile();
            com.bykv.vk.openvk.preload.geckox.g.c.a(file.getAbsolutePath());
            File file2 = this.f20767c;
            a11.a();
            return file2;
        } catch (Throwable th2) {
            a11.a();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final InputStream a(String str) throws Exception {
        return d(this.f20766b).a(a(this.f20766b, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Long a() {
        return this.f20768d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String b() {
        return this.f20766b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b(String str) throws Exception {
        return d(this.f20766b).b(a(this.f20766b, str));
    }

    public final int c(String str) {
        try {
            File file = new File(e(str), "res");
            if (!file.exists() || !file.isDirectory()) {
                return 0;
            }
            int length = file.listFiles().length;
            if (length > 0) {
                return length - 1;
            }
            return 0;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() throws Exception {
        if (this.f20770f.getAndSet(true)) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f20765a);
        String str = File.separator;
        sb2.append(str);
        sb2.append(this.f20766b);
        sb2.append(str);
        sb2.append("select.lock");
        com.bykv.vk.openvk.preload.geckox.g.b a11 = com.bykv.vk.openvk.preload.geckox.g.b.a(sb2.toString());
        GeckoLogger.d("gecko-file-lock", "channel version loader clean");
        try {
            if (this.f20767c == null) {
                return;
            }
            com.bykv.vk.openvk.preload.geckox.g.c.b(this.f20767c.getAbsolutePath() + str + "using.lock");
            a11.a();
            com.bykv.vk.openvk.preload.geckox.a.c.a(this.f20765a + str + this.f20766b);
        } finally {
            a11.a();
        }
    }
}
