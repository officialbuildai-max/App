package wl;

import android.net.Uri;
import android.text.TextUtils;
import java.security.MessageDigest;

/* loaded from: classes6.dex */
public class d implements e {

    /* renamed from: b, reason: collision with root package name */
    private volatile byte[] f77829b;

    /* renamed from: c, reason: collision with root package name */
    private final String f77830c;

    public d(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("url must be can not null or empty");
        }
        this.f77830c = Uri.encode(str, "@#&=*+-_.,:!?()/~'%");
    }

    @Override // wl.e
    public void a(MessageDigest messageDigest) {
        if (this.f77829b == null) {
            this.f77829b = this.f77830c.getBytes(e.f77831a);
        }
        messageDigest.update(this.f77829b);
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return cm.e.a(this.f77830c).equals(cm.e.a(((d) obj).f77830c));
        }
        return false;
    }

    public int hashCode() {
        return this.f77830c.hashCode() * 31;
    }
}
