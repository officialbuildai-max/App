package com.transsion.ninegridview.helper;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.view.v;
import com.blankj.utilcode.util.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes6.dex */
public final class FileHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final FileHelper f47736a = new FileHelper();

    /* renamed from: b, reason: collision with root package name */
    private static final String f47737b = Environment.DIRECTORY_PICTURES;

    /* renamed from: c, reason: collision with root package name */
    private static final int f47738c = 100;

    /* renamed from: d, reason: collision with root package name */
    private static t1 f47739d;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private File f47740a;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public a(File file) {
            this.f47740a = file;
        }

        public /* synthetic */ a(File file, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : file);
        }

        public final File a() {
            return this.f47740a;
        }

        public final void b(File file) {
            this.f47740a = file;
        }
    }

    private FileHelper() {
    }

    private final void d(AppCompatActivity appCompatActivity, Function0 function0) {
        if (Build.VERSION.SDK_INT >= 29) {
            function0.invoke();
        } else if (androidx.core.content.b.checkSelfPermission(appCompatActivity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && androidx.core.content.b.checkSelfPermission(appCompatActivity, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            function0.invoke();
        } else {
            q(appCompatActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.io.File r13, android.content.Context r14, java.lang.String r15, java.lang.String r16, boolean r17, kotlin.coroutines.Continuation r18) {
        /*
            r12 = this;
            r0 = r13
            r1 = r18
            boolean r2 = r1 instanceof com.transsion.ninegridview.helper.FileHelper$copyToAlbum$1
            if (r2 == 0) goto L18
            r2 = r1
            com.transsion.ninegridview.helper.FileHelper$copyToAlbum$1 r2 = (com.transsion.ninegridview.helper.FileHelper$copyToAlbum$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.label = r3
            r3 = r12
        L16:
            r10 = r2
            goto L1f
        L18:
            com.transsion.ninegridview.helper.FileHelper$copyToAlbum$1 r2 = new com.transsion.ninegridview.helper.FileHelper$copyToAlbum$1
            r3 = r12
            r2.<init>(r12, r1)
            goto L16
        L1f:
            java.lang.Object r1 = r10.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r4 = r10.label
            r5 = 1
            r11 = 0
            if (r4 == 0) goto L41
            if (r4 != r5) goto L39
            java.lang.Object r0 = r10.L$0
            r2 = r0
            java.io.Closeable r2 = (java.io.Closeable) r2
            kotlin.ResultKt.b(r1)     // Catch: java.lang.Throwable -> L36
            goto L6c
        L36:
            r0 = move-exception
        L37:
            r1 = r0
            goto L77
        L39:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L41:
            kotlin.ResultKt.b(r1)
            boolean r1 = r13.canRead()     // Catch: java.lang.Exception -> L72
            if (r1 == 0) goto L7e
            boolean r1 = r13.exists()     // Catch: java.lang.Exception -> L72
            if (r1 != 0) goto L51
            goto L7e
        L51:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Exception -> L72
            r1.<init>(r13)     // Catch: java.lang.Exception -> L72
            com.transsion.ninegridview.helper.FileHelper r4 = com.transsion.ninegridview.helper.FileHelper.f47736a     // Catch: java.lang.Throwable -> L74
            r10.L$0 = r1     // Catch: java.lang.Throwable -> L74
            r10.label = r5     // Catch: java.lang.Throwable -> L74
            r5 = r1
            r6 = r14
            r7 = r15
            r8 = r16
            r9 = r17
            java.lang.Object r0 = r4.u(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L74
            if (r0 != r2) goto L6a
            return r2
        L6a:
            r2 = r1
            r1 = r0
        L6c:
            android.net.Uri r1 = (android.net.Uri) r1     // Catch: java.lang.Throwable -> L36
            kotlin.io.CloseableKt.a(r2, r11)     // Catch: java.lang.Exception -> L72
            return r1
        L72:
            r0 = move-exception
            goto La3
        L74:
            r0 = move-exception
            r2 = r1
            goto L37
        L77:
            throw r1     // Catch: java.lang.Throwable -> L78
        L78:
            r0 = move-exception
            r4 = r0
            kotlin.io.CloseableKt.a(r2, r1)     // Catch: java.lang.Exception -> L72
            throw r4     // Catch: java.lang.Exception -> L72
        L7e:
            lg.a$a r1 = lg.a.f68962a     // Catch: java.lang.Exception -> L72
            java.lang.String r2 = "FileHelper"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L72
            r4.<init>()     // Catch: java.lang.Exception -> L72
            java.lang.String r5 = "check: read file error: "
            r4.append(r5)     // Catch: java.lang.Exception -> L72
            r4.append(r13)     // Catch: java.lang.Exception -> L72
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Exception -> L72
            r4 = 4
            r5 = 0
            r6 = 0
            r13 = r1
            r14 = r2
            r15 = r0
            r16 = r6
            r17 = r4
            r18 = r5
            lg.a.C0856a.f(r13, r14, r15, r16, r17, r18)     // Catch: java.lang.Exception -> L72
            return r11
        La3:
            r0.printStackTrace()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ninegridview.helper.FileHelper.e(java.io.File, android.content.Context, java.lang.String, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ void g(FileHelper fileHelper, File file, Context context, String str, String str2, boolean z10, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            z10 = true;
        }
        fileHelper.f(file, context, str, str2, z10);
    }

    private final void h(Uri uri, Context context, ContentResolver contentResolver, File file) {
        ContentValues contentValues = new ContentValues();
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("is_pending", (Integer) 0);
            contentResolver.update(uri, contentValues, null, null);
        } else {
            if (file != null) {
                contentValues.put("_size", Long.valueOf(file.length()));
            }
            contentResolver.update(uri, contentValues, null, null);
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", uri));
        }
    }

    private final Bitmap.CompressFormat i(String str) {
        Bitmap.CompressFormat compressFormat;
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        if (StringsKt.G(lowerCase, ".png", false, 2, null)) {
            return Bitmap.CompressFormat.PNG;
        }
        if (StringsKt.G(lowerCase, ".jpg", false, 2, null) || StringsKt.G(lowerCase, ".jpeg", false, 2, null)) {
            return Bitmap.CompressFormat.JPEG;
        }
        if (!StringsKt.G(lowerCase, ".webp", false, 2, null)) {
            return Bitmap.CompressFormat.PNG;
        }
        if (Build.VERSION.SDK_INT < 30) {
            return Bitmap.CompressFormat.WEBP;
        }
        compressFormat = Bitmap.CompressFormat.WEBP_LOSSLESS;
        return compressFormat;
    }

    private final String k(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        if (StringsKt.G(lowerCase, ".png", false, 2, null)) {
            return "image/png";
        }
        if (StringsKt.G(lowerCase, ".jpg", false, 2, null) || StringsKt.G(lowerCase, ".jpeg", false, 2, null)) {
            return "image/jpeg";
        }
        if (StringsKt.G(lowerCase, ".webp", false, 2, null)) {
            return "image/webp";
        }
        if (StringsKt.G(lowerCase, ".gif", false, 2, null)) {
            return "image/gif";
        }
        return null;
    }

    private final OutputStream o(Uri uri, ContentResolver contentResolver) {
        try {
            return contentResolver.openOutputStream(uri);
        } catch (FileNotFoundException e11) {
            a.C0856a.f(lg.a.f68962a, "FileHelper", "save: open stream error: " + e11, false, 4, null);
            return null;
        }
    }

    private final Uri p(ContentResolver contentResolver, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return null;
        }
        File file = new File(str);
        if (file.canRead() && file.exists()) {
            a.C0856a.v(lg.a.f68962a, "FileHelper", "query: path: " + str + " exists", false, 4, null);
            return Uri.fromFile(file);
        }
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor query = contentResolver.query(uri, new String[]{"_id", "_data"}, "_data == ?", new String[]{str}, null);
        if (query != null) {
            try {
                if (query.moveToNext()) {
                    Uri withAppendedId = ContentUris.withAppendedId(uri, query.getLong(query.getColumnIndexOrThrow("_id")));
                    Intrinsics.g(withAppendedId, "withAppendedId(...)");
                    a.C0856a.v(lg.a.f68962a, "FileHelper", "query: path: " + str + " exists uri: " + withAppendedId, false, 4, null);
                    CloseableKt.a(query, null);
                    return withAppendedId;
                }
                Unit unit = Unit.f67184a;
                CloseableKt.a(query, null);
            } finally {
            }
        }
        return null;
    }

    private final void q(AppCompatActivity appCompatActivity) {
        ActivityCompat.g(appCompatActivity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, f47738c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(AppCompatActivity appCompatActivity, String str, Bitmap bitmap, Function2 function2) {
        t1 d11;
        t1 t1Var = f47739d;
        if (t1Var != null) {
            t1.a.b(t1Var, null, 1, null);
        }
        d11 = k.d(v.a(appCompatActivity), y0.b(), null, new FileHelper$saveBitmapToPicture$1$1(str, bitmap, appCompatActivity, function2, null), 2, null);
        f47739d = d11;
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(java.io.InputStream r13, android.content.Context r14, java.lang.String r15, java.lang.String r16, boolean r17, kotlin.coroutines.Continuation r18) {
        /*
            Method dump skipped, instructions count: 196
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ninegridview.helper.FileHelper.u(java.io.InputStream, android.content.Context, java.lang.String, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Uri v(FileHelper fileHelper, Bitmap bitmap, Context context, String str, String str2, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            str2 = "MovieBox";
        }
        String str3 = str2;
        if ((i12 & 8) != 0) {
            i11 = 75;
        }
        return fileHelper.t(bitmap, context, str, str3, i11);
    }

    public final void f(File file, Context context, String fileName, String str, boolean z10) {
        t1 d11;
        Intrinsics.h(file, "file");
        Intrinsics.h(context, "context");
        Intrinsics.h(fileName, "fileName");
        try {
            Result.Companion companion = Result.INSTANCE;
            d11 = k.d(o0.a(y0.b()), null, null, new FileHelper$copyToAlbumAsync$1$1(this, file, context, fileName, str, z10, null), 3, null);
            Result.m1185constructorimpl(d11);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public final String j(String str) {
        List l11;
        List l12;
        if (str == null) {
            return System.currentTimeMillis() + ".jpg";
        }
        int i11 = Utils.a().getApplicationInfo().uid;
        List<String> split = new Regex("[?]").split(str, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    l11 = CollectionsKt.K0(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        l11 = CollectionsKt.l();
        String[] strArr = (String[]) l11.toArray(new String[0]);
        if (!(strArr.length == 0)) {
            List<String> split2 = new Regex("/").split(strArr[0], 0);
            if (!split2.isEmpty()) {
                ListIterator<String> listIterator2 = split2.listIterator(split2.size());
                while (listIterator2.hasPrevious()) {
                    if (listIterator2.previous().length() != 0) {
                        l12 = CollectionsKt.K0(split2, listIterator2.nextIndex() + 1);
                        break;
                    }
                }
            }
            l12 = CollectionsKt.l();
            String[] strArr2 = (String[]) l12.toArray(new String[0]);
            if (!(strArr2.length == 0)) {
                return i11 + "_" + strArr2[strArr2.length - 1];
            }
        }
        return System.currentTimeMillis() + ".jpg";
    }

    public final int l() {
        return f47738c;
    }

    public final File m(String fileName) {
        Intrinsics.h(fileName, "fileName");
        return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "MovieBox" + File.separator + fileName);
    }

    public final Uri n(ContentResolver contentResolver, String fileName, String str, a aVar) {
        Uri EXTERNAL_CONTENT_URI;
        String str2;
        Intrinsics.h(contentResolver, "<this>");
        Intrinsics.h(fileName, "fileName");
        ContentValues contentValues = new ContentValues();
        String k11 = f47736a.k(fileName);
        if (k11 != null) {
            contentValues.put("mime_type", k11);
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        contentValues.put("date_added", Long.valueOf(currentTimeMillis));
        contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
        int i11 = 1;
        if (Build.VERSION.SDK_INT >= 29) {
            if (str != null) {
                str2 = f47737b + "/" + str;
            } else {
                str2 = f47737b;
            }
            contentValues.put("_display_name", fileName);
            contentValues.put("relative_path", str2);
            contentValues.put("is_pending", (Integer) 1);
            EXTERNAL_CONTENT_URI = MediaStore.Images.Media.getContentUri("external_primary");
            Intrinsics.g(EXTERNAL_CONTENT_URI, "getContentUri(...)");
        } else {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(f47737b);
            if (str != null) {
                externalStoragePublicDirectory = new File(externalStoragePublicDirectory, str);
            }
            if (!externalStoragePublicDirectory.exists() && !externalStoragePublicDirectory.mkdirs()) {
                a.C0856a.f(lg.a.f68962a, "FileHelper", "save: error: can't create Pictures directory", false, 4, null);
                return null;
            }
            File file = new File(externalStoragePublicDirectory, fileName);
            String x10 = FilesKt.x(file);
            String w11 = FilesKt.w(file);
            String absolutePath = file.getAbsolutePath();
            Intrinsics.g(absolutePath, "getAbsolutePath(...)");
            Uri p11 = p(contentResolver, absolutePath);
            while (p11 != null) {
                int i12 = i11 + 1;
                File file2 = new File(externalStoragePublicDirectory, x10 + "(" + i11 + ")." + w11);
                String absolutePath2 = file2.getAbsolutePath();
                Intrinsics.g(absolutePath2, "getAbsolutePath(...)");
                Uri p12 = p(contentResolver, absolutePath2);
                i11 = i12;
                file = file2;
                p11 = p12;
            }
            contentValues.put("_display_name", file.getName());
            String absolutePath3 = file.getAbsolutePath();
            a.C0856a.v(lg.a.f68962a, "FileHelper", "save file: " + absolutePath3, false, 4, null);
            contentValues.put("_data", absolutePath3);
            if (aVar != null) {
                aVar.b(file);
            }
            EXTERNAL_CONTENT_URI = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            Intrinsics.g(EXTERNAL_CONTENT_URI, "EXTERNAL_CONTENT_URI");
        }
        try {
            return contentResolver.insert(EXTERNAL_CONTENT_URI, contentValues);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void r(final AppCompatActivity activity, final Bitmap bitmap, final String fileName, final Function2 function2) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(fileName, "fileName");
        if (bitmap == null) {
            return;
        }
        d(activity, new Function0() { // from class: com.transsion.ninegridview.helper.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit s11;
                s11 = FileHelper.s(AppCompatActivity.this, fileName, bitmap, function2);
                return s11;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Uri t(Bitmap bitmap, Context context, String fileName, String relativePath, int i11) {
        Intrinsics.h(bitmap, "<this>");
        Intrinsics.h(context, "context");
        Intrinsics.h(fileName, "fileName");
        Intrinsics.h(relativePath, "relativePath");
        ContentResolver contentResolver = context.getContentResolver();
        a aVar = new a(null, 1, 0 == true ? 1 : 0);
        Intrinsics.e(contentResolver);
        Uri n11 = n(contentResolver, fileName, relativePath, aVar);
        if (n11 == null) {
            a.C0856a.f(lg.a.f68962a, "FileHelper", "insert: error: uri == null", false, 4, null);
            return null;
        }
        OutputStream o11 = o(n11, contentResolver);
        if (o11 == null) {
            return null;
        }
        try {
            FileHelper fileHelper = f47736a;
            bitmap.compress(fileHelper.i(fileName), i11, o11);
            fileHelper.h(n11, context, contentResolver, aVar.a());
            Unit unit = Unit.f67184a;
            CloseableKt.a(o11, null);
            return n11;
        } finally {
        }
    }
}
