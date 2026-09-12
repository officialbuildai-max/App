package k1;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c extends a {

    /* renamed from: b, reason: collision with root package name */
    private Context f66687b;

    /* renamed from: c, reason: collision with root package name */
    private Uri f66688c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, Context context, Uri uri) {
        super(aVar);
        this.f66687b = context;
        this.f66688c = uri;
    }

    @Override // k1.a
    public boolean a() {
        return b.a(this.f66687b, this.f66688c);
    }

    @Override // k1.a
    public a b(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // k1.a
    public a c(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    @Override // k1.a
    public boolean d() {
        try {
            return DocumentsContract.deleteDocument(this.f66687b.getContentResolver(), this.f66688c);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // k1.a
    public boolean e() {
        return b.c(this.f66687b, this.f66688c);
    }

    @Override // k1.a
    public String i() {
        return b.d(this.f66687b, this.f66688c);
    }

    @Override // k1.a
    public Uri j() {
        return this.f66688c;
    }

    @Override // k1.a
    public long k() {
        return b.f(this.f66687b, this.f66688c);
    }

    @Override // k1.a
    public a[] l() {
        throw new UnsupportedOperationException();
    }
}
