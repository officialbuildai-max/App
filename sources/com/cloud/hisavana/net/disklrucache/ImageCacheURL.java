package com.cloud.hisavana.net.disklrucache;

import android.net.Uri;
import android.text.TextUtils;
import com.cloud.sdk.commonutil.util.c;
import com.cloud.sdk.commonutil.util.n;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes3.dex */
public class ImageCacheURL {

    /* renamed from: d, reason: collision with root package name */
    private static final Charset f21470d = StandardCharsets.UTF_8;

    /* renamed from: a, reason: collision with root package name */
    private volatile byte[] f21471a;

    /* renamed from: b, reason: collision with root package name */
    private final String f21472b;

    /* renamed from: c, reason: collision with root package name */
    private final String f21473c;

    public ImageCacheURL(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f21473c = str;
            this.f21472b = Uri.encode(str, "@#&=*+-_.,:!?()/~'%");
        } else {
            this.f21473c = "";
            this.f21472b = "";
            c.netLog("url must be can not null or empty");
        }
    }

    public byte[] a() {
        if (this.f21471a == null) {
            this.f21471a = this.f21472b.getBytes(f21470d);
        }
        return this.f21471a;
    }

    public String b() {
        return d();
    }

    public String c() {
        return this.f21473c;
    }

    public String d() {
        return n.a(this.f21472b);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageCacheURL) {
            return b().equals(((ImageCacheURL) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f21472b.hashCode() * 31;
    }
}
