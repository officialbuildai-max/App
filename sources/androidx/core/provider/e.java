package androidx.core.provider;

import android.util.Base64;
import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final String f8271a;

    /* renamed from: b, reason: collision with root package name */
    private final String f8272b;

    /* renamed from: c, reason: collision with root package name */
    private final String f8273c;

    /* renamed from: d, reason: collision with root package name */
    private final List f8274d;

    /* renamed from: e, reason: collision with root package name */
    private final int f8275e = 0;

    /* renamed from: f, reason: collision with root package name */
    private final String f8276f;

    public e(String str, String str2, String str3, List list) {
        this.f8271a = (String) androidx.core.util.i.g(str);
        this.f8272b = (String) androidx.core.util.i.g(str2);
        this.f8273c = (String) androidx.core.util.i.g(str3);
        this.f8274d = (List) androidx.core.util.i.g(list);
        this.f8276f = a(str, str2, str3);
    }

    private String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List b() {
        return this.f8274d;
    }

    public int c() {
        return this.f8275e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return this.f8276f;
    }

    public String e() {
        return this.f8271a;
    }

    public String f() {
        return this.f8272b;
    }

    public String g() {
        return this.f8273c;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FontRequest {mProviderAuthority: " + this.f8271a + ", mProviderPackage: " + this.f8272b + ", mQuery: " + this.f8273c + ", mCertificates:");
        for (int i11 = 0; i11 < this.f8274d.size(); i11++) {
            sb2.append(" [");
            List list = (List) this.f8274d.get(i11);
            for (int i12 = 0; i12 < list.size(); i12++) {
                sb2.append(" \"");
                sb2.append(Base64.encodeToString((byte[]) list.get(i12), 0));
                sb2.append("\"");
            }
            sb2.append(" ]");
        }
        sb2.append("}");
        sb2.append("mCertificatesArray: " + this.f8275e);
        return sb2.toString();
    }
}
