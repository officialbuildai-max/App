package androidx.core.provider;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.z;
import androidx.core.provider.k;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static final z f8264a = new z(2);

    /* renamed from: b, reason: collision with root package name */
    private static final Comparator f8265b = new Comparator() { // from class: androidx.core.provider.b
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int g11;
            g11 = d.g((byte[]) obj, (byte[]) obj2);
            return g11;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface a {
        Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);

        void close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements a {

        /* renamed from: a, reason: collision with root package name */
        private final ContentProviderClient f8266a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(Context context, Uri uri) {
            this.f8266a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // androidx.core.provider.d.a
        public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f8266a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e11) {
                Log.w("FontsProvider", "Unable to query the content provider", e11);
                return null;
            }
        }

        @Override // androidx.core.provider.d.a
        public void close() {
            ContentProviderClient contentProviderClient = this.f8266a;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c implements a {

        /* renamed from: a, reason: collision with root package name */
        private final ContentProviderClient f8267a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(Context context, Uri uri) {
            this.f8267a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // androidx.core.provider.d.a
        public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f8267a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e11) {
                Log.w("FontsProvider", "Unable to query the content provider", e11);
                return null;
            }
        }

        @Override // androidx.core.provider.d.a
        public void close() {
            ContentProviderClient contentProviderClient = this.f8267a;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.core.provider.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0073d {

        /* renamed from: a, reason: collision with root package name */
        String f8268a;

        /* renamed from: b, reason: collision with root package name */
        String f8269b;

        /* renamed from: c, reason: collision with root package name */
        List f8270c;

        C0073d(String str, String str2, List list) {
            this.f8268a = str;
            this.f8269b = str2;
            this.f8270c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0073d)) {
                return false;
            }
            C0073d c0073d = (C0073d) obj;
            return Objects.equals(this.f8268a, c0073d.f8268a) && Objects.equals(this.f8269b, c0073d.f8269b) && Objects.equals(this.f8270c, c0073d.f8270c);
        }

        public int hashCode() {
            return Objects.hash(this.f8268a, this.f8269b, this.f8270c);
        }
    }

    private static List b(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean c(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (!Arrays.equals((byte[]) list.get(i11), (byte[]) list2.get(i11))) {
                return false;
            }
        }
        return true;
    }

    private static List d(e eVar, Resources resources) {
        return eVar.b() != null ? eVar.b() : y0.e.c(resources, eVar.c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k.a e(Context context, List list, CancellationSignal cancellationSignal) {
        f4.a.c("FontProvider.getFontFamilyResult");
        try {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < list.size(); i11++) {
                e eVar = (e) list.get(i11);
                ProviderInfo f11 = f(context.getPackageManager(), eVar, context.getResources());
                if (f11 == null) {
                    return k.a.b(1, null);
                }
                arrayList.add(h(context, eVar, f11.authority, cancellationSignal));
            }
            return k.a.a(0, arrayList);
        } finally {
            f4.a.f();
        }
    }

    static ProviderInfo f(PackageManager packageManager, e eVar, Resources resources) {
        f4.a.c("FontProvider.getProvider");
        try {
            List d11 = d(eVar, resources);
            C0073d c0073d = new C0073d(eVar.e(), eVar.f(), d11);
            ProviderInfo providerInfo = (ProviderInfo) f8264a.get(c0073d);
            if (providerInfo != null) {
                return providerInfo;
            }
            String e11 = eVar.e();
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(e11, 0);
            if (resolveContentProvider == null) {
                throw new PackageManager.NameNotFoundException("No package found for authority: " + e11);
            }
            if (!resolveContentProvider.packageName.equals(eVar.f())) {
                throw new PackageManager.NameNotFoundException("Found content provider " + e11 + ", but package was not " + eVar.f());
            }
            List b11 = b(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(b11, f8265b);
            for (int i11 = 0; i11 < d11.size(); i11++) {
                ArrayList arrayList = new ArrayList((Collection) d11.get(i11));
                Collections.sort(arrayList, f8265b);
                if (c(b11, arrayList)) {
                    f8264a.put(c0073d, resolveContentProvider);
                    return resolveContentProvider;
                }
            }
            f4.a.f();
            return null;
        } finally {
            f4.a.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int g(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i11 = 0; i11 < bArr.length; i11++) {
            byte b11 = bArr[i11];
            byte b12 = bArr2[i11];
            if (b11 != b12) {
                return b11 - b12;
            }
        }
        return 0;
    }

    static k.b[] h(Context context, e eVar, String str, CancellationSignal cancellationSignal) {
        ArrayList arrayList;
        Uri withAppendedId;
        boolean z10;
        f4.a.c("FontProvider.query");
        try {
            ArrayList arrayList2 = new ArrayList();
            Uri build = new Uri.Builder().scheme("content").authority(str).build();
            Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath(OfflineConstantsKt.OFFLINE_DOWNLOAD_SEARCH_MODE_FILE).build();
            a a11 = androidx.core.provider.c.a(context, build);
            Cursor cursor = null;
            try {
                String[] strArr = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
                f4.a.c("ContentQueryWrapper.query");
                try {
                    cursor = a11.a(build, strArr, "query = ?", new String[]{eVar.g()}, null, cancellationSignal);
                    f4.a.f();
                    if (cursor != null && cursor.getCount() > 0) {
                        int columnIndex = cursor.getColumnIndex("result_code");
                        ArrayList arrayList3 = new ArrayList();
                        int columnIndex2 = cursor.getColumnIndex("_id");
                        int columnIndex3 = cursor.getColumnIndex("file_id");
                        int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                        int columnIndex5 = cursor.getColumnIndex("font_weight");
                        int columnIndex6 = cursor.getColumnIndex("font_italic");
                        while (cursor.moveToNext()) {
                            int i11 = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                            int i12 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0;
                            if (columnIndex3 == -1) {
                                arrayList = arrayList3;
                                withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                            } else {
                                arrayList = arrayList3;
                                withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                            }
                            int i13 = columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400;
                            if (columnIndex6 != -1) {
                                z10 = true;
                                if (cursor.getInt(columnIndex6) == 1) {
                                    k.b a12 = k.b.a(withAppendedId, i12, i13, z10, i11);
                                    arrayList3 = arrayList;
                                    arrayList3.add(a12);
                                }
                            }
                            z10 = false;
                            k.b a122 = k.b.a(withAppendedId, i12, i13, z10, i11);
                            arrayList3 = arrayList;
                            arrayList3.add(a122);
                        }
                        arrayList2 = arrayList3;
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    a11.close();
                    return (k.b[]) arrayList2.toArray(new k.b[0]);
                } finally {
                    f4.a.f();
                }
            } catch (Throwable th2) {
                if (cursor != null) {
                    cursor.close();
                }
                a11.close();
                throw th2;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }
}
