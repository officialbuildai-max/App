package k1;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends a {

    /* renamed from: b, reason: collision with root package name */
    private Context f66689b;

    /* renamed from: c, reason: collision with root package name */
    private Uri f66690c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, Context context, Uri uri) {
        super(aVar);
        this.f66689b = context;
        this.f66690c = uri;
    }

    private static void m(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception unused) {
            }
        }
    }

    private static Uri n(Context context, Uri uri, String str, String str2) {
        try {
            return DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // k1.a
    public boolean a() {
        return b.a(this.f66689b, this.f66690c);
    }

    @Override // k1.a
    public a b(String str) {
        Uri n11 = n(this.f66689b, this.f66690c, "vnd.android.document/directory", str);
        if (n11 != null) {
            return new d(this, this.f66689b, n11);
        }
        return null;
    }

    @Override // k1.a
    public a c(String str, String str2) {
        Uri n11 = n(this.f66689b, this.f66690c, str, str2);
        if (n11 != null) {
            return new d(this, this.f66689b, n11);
        }
        return null;
    }

    @Override // k1.a
    public boolean d() {
        try {
            return DocumentsContract.deleteDocument(this.f66689b.getContentResolver(), this.f66690c);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // k1.a
    public boolean e() {
        return b.c(this.f66689b, this.f66690c);
    }

    @Override // k1.a
    public String i() {
        return b.d(this.f66689b, this.f66690c);
    }

    @Override // k1.a
    public Uri j() {
        return this.f66690c;
    }

    @Override // k1.a
    public long k() {
        return b.f(this.f66689b, this.f66690c);
    }

    @Override // k1.a
    public a[] l() {
        ContentResolver contentResolver = this.f66689b.getContentResolver();
        Uri uri = this.f66690c;
        Uri buildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri));
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = contentResolver.query(buildChildDocumentsUriUsingTree, new String[]{"document_id"}, null, null, null);
                while (cursor.moveToNext()) {
                    arrayList.add(DocumentsContract.buildDocumentUriUsingTree(this.f66690c, cursor.getString(0)));
                }
            } catch (Exception e11) {
                Log.w("DocumentFile", "Failed query: " + e11);
            }
            Uri[] uriArr = (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
            a[] aVarArr = new a[uriArr.length];
            for (int i11 = 0; i11 < uriArr.length; i11++) {
                aVarArr[i11] = new d(this, this.f66689b, uriArr[i11]);
            }
            return aVarArr;
        } finally {
            m(cursor);
        }
    }
}
