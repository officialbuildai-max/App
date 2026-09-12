package am;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected static HostnameVerifier f738a;

    /* renamed from: am.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0011a implements HostnameVerifier {
        C0011a(a aVar) {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    public HostnameVerifier a() {
        if (f738a == null) {
            synchronized (this) {
                try {
                    if (f738a == null) {
                        f738a = new C0011a(this);
                    }
                } finally {
                }
            }
        }
        return f738a;
    }
}
