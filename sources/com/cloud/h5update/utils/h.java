package com.cloud.h5update.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.cloud.h5update.TH5Update;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final a f21378a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f21379b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f21380c;

    /* renamed from: d, reason: collision with root package name */
    private static final String f21381d;

    /* renamed from: e, reason: collision with root package name */
    private static final String f21382e;

    /* renamed from: f, reason: collision with root package name */
    private static final String f21383f;

    /* renamed from: g, reason: collision with root package name */
    private static final String f21384g;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void f(Closeable... closeableArr) {
            for (Closeable closeable : closeableArr) {
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        private final ContentResolver g() {
            ContentResolver contentResolver = TH5Update.f21320c.c().getContentResolver();
            Intrinsics.g(contentResolver, "getContext().contentResolver");
            return contentResolver;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String i() {
            String absolutePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
            Intrinsics.g(absolutePath, "getExternalStoragePublic…            .absolutePath");
            return absolutePath;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String j() {
            String absolutePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            Intrinsics.g(absolutePath, "getExternalStoragePublic…            .absolutePath");
            return absolutePath;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String k() {
            String absolutePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
            Intrinsics.g(absolutePath, "getExternalStoragePublic…            .absolutePath");
            return absolutePath;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String l() {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            Intrinsics.g(absolutePath, "getExternalStorageDirectory().absolutePath");
            return absolutePath;
        }

        private final Uri o(Context context, File file) {
            try {
                String absolutePath = file.getAbsolutePath();
                Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                Cursor query = context.getContentResolver().query(uri, new String[]{"_id"}, "_data=? ", new String[]{absolutePath}, null);
                if (query == null || !query.moveToFirst()) {
                    if (!file.exists()) {
                        return null;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("_data", absolutePath);
                    return context.getContentResolver().insert(uri, contentValues);
                }
                int i11 = query.getInt(query.getColumnIndex("_id"));
                query.close();
                return Uri.withAppendedPath(uri, "" + i11);
            } catch (Exception e11) {
                e11.printStackTrace();
                return null;
            }
        }

        private final Uri q(File file) {
            if (file == null) {
                return null;
            }
            return Uri.fromFile(file);
        }

        private final boolean s(String str) {
            File m11 = m(str);
            if (m11 == null) {
                return false;
            }
            if (m11.exists()) {
                return true;
            }
            return t(str);
        }

        private final boolean t(String str) {
            if (Build.VERSION.SDK_INT >= 29) {
                try {
                    AssetFileDescriptor z10 = z(Uri.parse(str));
                    if (z10 == null) {
                        f(z10);
                        return false;
                    }
                    f(z10);
                    f(z10);
                    return true;
                } catch (FileNotFoundException unused) {
                    f(null);
                } catch (Throwable th2) {
                    f(null);
                    throw th2;
                }
            }
            return false;
        }

        private final boolean v(File file) {
            if (file == null) {
                return false;
            }
            try {
                String canonicalPath = file.getCanonicalPath();
                Intrinsics.g(canonicalPath, "file.canonicalPath");
                return w(canonicalPath);
            } catch (IOException e11) {
                e11.printStackTrace();
                return false;
            }
        }

        private final boolean w(String str) {
            return (y(str) || !StringsKt.W(str, h.f21379b, false, 2, null) || StringsKt.W(str, h.f21381d, false, 2, null)) ? false : true;
        }

        private final boolean x() {
            boolean isExternalStorageLegacy;
            if (Build.VERSION.SDK_INT >= 29) {
                isExternalStorageLegacy = Environment.isExternalStorageLegacy();
                if (!isExternalStorageLegacy) {
                    return true;
                }
            }
            return false;
        }

        private final boolean y(String str) {
            if (str == null) {
                return true;
            }
            int length = str.length();
            for (int i11 = 0; i11 < length; i11++) {
                if (!Character.isWhitespace(str.charAt(i11))) {
                    return false;
                }
            }
            return true;
        }

        public final void e(Closeable... closeables) {
            Intrinsics.h(closeables, "closeables");
            for (Closeable closeable : closeables) {
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
            }
        }

        public final Uri h(Context context, File file) {
            Uri EXTERNAL_CONTENT_URI;
            Intrinsics.h(context, "context");
            Intrinsics.h(file, "file");
            try {
                String absolutePath = file.getAbsolutePath();
                EXTERNAL_CONTENT_URI = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
                Intrinsics.g(EXTERNAL_CONTENT_URI, "EXTERNAL_CONTENT_URI");
                Cursor query = context.getContentResolver().query(EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{absolutePath}, null);
                if (query == null || !query.moveToFirst()) {
                    if (!file.exists()) {
                        return null;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("_data", absolutePath);
                    return context.getContentResolver().insert(EXTERNAL_CONTENT_URI, contentValues);
                }
                int i11 = query.getInt(query.getColumnIndex("_id"));
                query.close();
                return Uri.withAppendedPath(EXTERNAL_CONTENT_URI, "" + i11);
            } catch (Exception e11) {
                e11.printStackTrace();
                return null;
            }
        }

        public final File m(String str) {
            if (str == null || StringsKt.q0(str) || y(str)) {
                return null;
            }
            return new File(str);
        }

        public final InputStream n(File file) {
            InputStream inputStream = null;
            try {
                if (x()) {
                    Uri p11 = p(file);
                    if (p11 == null) {
                        return null;
                    }
                    inputStream = g().openInputStream(p11);
                } else {
                    inputStream = new FileInputStream(file);
                }
            } catch (Exception e11) {
                gg.b.f63690a.e(e11);
            }
            return inputStream;
        }

        public final Uri p(File file) {
            if (file == null) {
                return null;
            }
            if (!x() || !v(file)) {
                return q(file);
            }
            String filePath = file.getAbsolutePath();
            Intrinsics.g(filePath, "filePath");
            return StringsKt.W(filePath, h.f21382e, false, 2, null) ? h(TH5Update.f21320c.c(), file) : (StringsKt.W(filePath, h.f21383f, false, 2, null) || StringsKt.W(filePath, h.f21384g, false, 2, null)) ? o(TH5Update.f21320c.c(), file) : q(file);
        }

        public final boolean r(File file) {
            if (file == null) {
                return false;
            }
            if (file.exists()) {
                return true;
            }
            return s(file.getAbsolutePath());
        }

        public final boolean u(String str, File file) {
            return str == null || StringsKt.q0(str) || StringsKt.H(str, i.f21385a.b(file), true);
        }

        public final AssetFileDescriptor z(Uri uri) {
            ContentResolver g11 = g();
            Intrinsics.e(uri);
            return g11.openAssetFileDescriptor(uri, CampaignEx.JSON_KEY_AD_R);
        }
    }

    static {
        a aVar = new a(null);
        f21378a = aVar;
        String l11 = aVar.l();
        f21379b = l11;
        String str = l11 + File.separator;
        f21380c = str;
        f21381d = str + "Android";
        f21382e = aVar.j();
        f21383f = aVar.k();
        f21384g = aVar.i();
    }
}
