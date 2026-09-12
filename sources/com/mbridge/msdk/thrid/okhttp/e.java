package com.mbridge.msdk.thrid.okhttp;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: classes5.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public static final e f37852c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    private final Set<b> f37853a;

    /* renamed from: b, reason: collision with root package name */
    private final com.mbridge.msdk.thrid.okhttp.internal.tls.c f37854b;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<b> f37855a = new ArrayList();

        public e a() {
            return new e(new LinkedHashSet(this.f37855a), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final String f37856a;

        /* renamed from: b, reason: collision with root package name */
        final String f37857b;

        /* renamed from: c, reason: collision with root package name */
        final String f37858c;

        /* renamed from: d, reason: collision with root package name */
        final com.mbridge.msdk.thrid.okio.f f37859d;

        boolean a(String str) {
            if (!this.f37856a.startsWith("*.")) {
                return str.equals(this.f37857b);
            }
            int indexOf = str.indexOf(46);
            if ((str.length() - indexOf) - 1 == this.f37857b.length()) {
                String str2 = this.f37857b;
                if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f37856a.equals(bVar.f37856a) && this.f37858c.equals(bVar.f37858c) && this.f37859d.equals(bVar.f37859d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((this.f37856a.hashCode() + 527) * 31) + this.f37858c.hashCode()) * 31) + this.f37859d.hashCode();
        }

        public String toString() {
            return this.f37858c + this.f37859d.a();
        }
    }

    e(Set<b> set, com.mbridge.msdk.thrid.okhttp.internal.tls.c cVar) {
        this.f37853a = set;
        this.f37854b = cVar;
    }

    static com.mbridge.msdk.thrid.okio.f a(X509Certificate x509Certificate) {
        return com.mbridge.msdk.thrid.okio.f.a(x509Certificate.getPublicKey().getEncoded()).c();
    }

    public static String a(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + b((X509Certificate) certificate).a();
    }

    static com.mbridge.msdk.thrid.okio.f b(X509Certificate x509Certificate) {
        return com.mbridge.msdk.thrid.okio.f.a(x509Certificate.getPublicKey().getEncoded()).d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a(com.mbridge.msdk.thrid.okhttp.internal.tls.c cVar) {
        return com.mbridge.msdk.thrid.okhttp.internal.c.a(this.f37854b, cVar) ? this : new e(this.f37853a, cVar);
    }

    List<b> a(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b bVar : this.f37853a) {
            if (bVar.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(bVar);
            }
        }
        return emptyList;
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> a11 = a(str);
        if (a11.isEmpty()) {
            return;
        }
        com.mbridge.msdk.thrid.okhttp.internal.tls.c cVar = this.f37854b;
        if (cVar != null) {
            list = cVar.a(list, str);
        }
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i11);
            int size2 = a11.size();
            com.mbridge.msdk.thrid.okio.f fVar = null;
            com.mbridge.msdk.thrid.okio.f fVar2 = null;
            for (int i12 = 0; i12 < size2; i12++) {
                b bVar = a11.get(i12);
                if (bVar.f37858c.equals("sha256/")) {
                    if (fVar == null) {
                        fVar = b(x509Certificate);
                    }
                    if (bVar.f37859d.equals(fVar)) {
                        return;
                    }
                } else {
                    if (!bVar.f37858c.equals("sha1/")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.f37858c);
                    }
                    if (fVar2 == null) {
                        fVar2 = a(x509Certificate);
                    }
                    if (bVar.f37859d.equals(fVar2)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Certificate pinning failure!");
        sb2.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i13 = 0; i13 < size3; i13++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i13);
            sb2.append("\n    ");
            sb2.append(a((Certificate) x509Certificate2));
            sb2.append(": ");
            sb2.append(x509Certificate2.getSubjectDN().getName());
        }
        sb2.append("\n  Pinned certificates for ");
        sb2.append(str);
        sb2.append(":");
        int size4 = a11.size();
        for (int i14 = 0; i14 < size4; i14++) {
            b bVar2 = a11.get(i14);
            sb2.append("\n    ");
            sb2.append(bVar2);
        }
        throw new SSLPeerUnverifiedException(sb2.toString());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (com.mbridge.msdk.thrid.okhttp.internal.c.a(this.f37854b, eVar.f37854b) && this.f37853a.equals(eVar.f37853a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        com.mbridge.msdk.thrid.okhttp.internal.tls.c cVar = this.f37854b;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f37853a.hashCode();
    }
}
