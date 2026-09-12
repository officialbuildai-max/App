package k1;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes2.dex */
abstract class b {
    public static boolean a(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        String e11 = e(context, uri);
        int g11 = g(context, uri, "flags", 0);
        if (TextUtils.isEmpty(e11)) {
            return false;
        }
        if ((g11 & 4) != 0) {
            return true;
        }
        if (!"vnd.android.document/directory".equals(e11) || (g11 & 8) == 0) {
            return (TextUtils.isEmpty(e11) || (g11 & 2) == 0) ? false : true;
        }
        return true;
    }

    private static void b(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean c(Context context, Uri uri) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"document_id"}, null, null, null);
            return cursor.getCount() > 0;
        } catch (Exception e11) {
            Log.w("DocumentFile", "Failed query: " + e11);
            return false;
        } finally {
            b(cursor);
        }
    }

    public static String d(Context context, Uri uri) {
        return i(context, uri, "_display_name", null);
    }

    private static String e(Context context, Uri uri) {
        return i(context, uri, "mime_type", null);
    }

    public static long f(Context context, Uri uri) {
        return h(context, uri, "_size", 0L);
    }

    private static int g(Context context, Uri uri, String str, int i11) {
        return (int) h(context, uri, str, i11);
    }

    private static long h(Context context, Uri uri, String str, long j11) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(uri, new String[]{str}, null, null, null);
            return (!cursor.moveToFirst() || cursor.isNull(0)) ? j11 : cursor.getLong(0);
        } catch (Exception e11) {
            Log.w("DocumentFile", "Failed query: " + e11);
            return j11;
        } finally {
            b(cursor);
        }
    }

    private static String i(Context context, Uri uri, String str, String str2) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(uri, new String[]{str}, null, null, null);
            return (!cursor.moveToFirst() || cursor.isNull(0)) ? str2 : cursor.getString(0);
        } catch (Exception e11) {
            Log.w("DocumentFile", "Failed query: " + e11);
            return str2;
        } finally {
            b(cursor);
        }
    }
}
