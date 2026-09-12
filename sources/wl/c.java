package wl;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;

/* loaded from: classes6.dex */
public class c implements e {

    /* renamed from: b, reason: collision with root package name */
    private final String f77826b;

    /* renamed from: c, reason: collision with root package name */
    private URL f77827c;

    /* renamed from: d, reason: collision with root package name */
    private volatile byte[] f77828d;

    public c(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("url must be can not null or empty");
        }
        this.f77826b = Uri.encode(str, "@#&=*+-_.,:!?()/~'%");
    }

    @Override // wl.e
    public void a(MessageDigest messageDigest) {
        if (this.f77828d == null) {
            this.f77828d = this.f77826b.getBytes(e.f77831a);
        }
        messageDigest.update(this.f77828d);
    }

    public URL b() {
        if (this.f77827c == null) {
            this.f77827c = new URL(this.f77826b);
        }
        return this.f77827c;
    }

    public String toString() {
        return this.f77826b;
    }
}
