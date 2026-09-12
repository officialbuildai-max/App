package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzgo implements zzgq {
    @Override // com.google.android.gms.internal.measurement.zzgq
    @Nullable
    public final String zza(ContentResolver contentResolver, String str) throws zzgt {
        Uri uri = zzgi.zza;
        ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
        try {
            if (acquireUnstableContentProviderClient == null) {
                throw new zzgt("Unable to acquire ContentProviderClient");
            }
            try {
                Cursor query = acquireUnstableContentProviderClient.query(uri, null, null, new String[]{str}, null);
                try {
                    if (query == null) {
                        throw new zzgt("ContentProvider query returned null cursor");
                    }
                    if (query.moveToFirst()) {
                        String string = query.getString(1);
                        query.close();
                        return string;
                    }
                    query.close();
                    acquireUnstableContentProviderClient.release();
                    return null;
                } catch (Throwable th2) {
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            } catch (RemoteException e11) {
                throw new zzgt("ContentProvider query failed", e11);
            }
        } finally {
            acquireUnstableContentProviderClient.release();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzgq
    public final <T extends Map<String, String>> T zza(ContentResolver contentResolver, String[] strArr, zzgr<T> zzgrVar) throws zzgt {
        Uri uri = zzgi.zzb;
        ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
        if (acquireUnstableContentProviderClient == null) {
            throw new zzgt("Unable to acquire ContentProviderClient");
        }
        try {
            try {
                Cursor query = acquireUnstableContentProviderClient.query(uri, null, null, strArr, null);
                try {
                    if (query == null) {
                        throw new zzgt("ContentProvider query returned null cursor");
                    }
                    T zza = zzgrVar.zza(query.getCount());
                    while (query.moveToNext()) {
                        zza.put(query.getString(0), query.getString(1));
                    }
                    if (!query.isAfterLast()) {
                        throw new zzgt("Cursor read incomplete (ContentProvider dead?)");
                    }
                    query.close();
                    return zza;
                } catch (Throwable th2) {
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            } catch (RemoteException e11) {
                throw new zzgt("ContentProvider query failed", e11);
            }
        } finally {
            acquireUnstableContentProviderClient.release();
        }
    }
}
