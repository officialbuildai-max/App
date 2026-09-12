package com.transsion.postdetail.util;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class VideoSaver {

    /* renamed from: a, reason: collision with root package name */
    public static final VideoSaver f50212a = new VideoSaver();

    private VideoSaver() {
    }

    private final Object a(Context context, InputStream inputStream, String str, Continuation continuation) {
        try {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
            if (!externalStoragePublicDirectory.exists()) {
                externalStoragePublicDirectory.mkdirs();
            }
            File file = new File(externalStoragePublicDirectory, str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                ByteStreamsKt.b(inputStream, fileOutputStream, 0, 2, null);
                CloseableKt.a(fileOutputStream, null);
                c cVar = c.f50215a;
                String absolutePath = file.getAbsolutePath();
                Intrinsics.g(absolutePath, "getAbsolutePath(...)");
                cVar.a(context, absolutePath);
                return Uri.fromFile(file);
            } finally {
            }
        } catch (Exception unused) {
            return null;
        }
    }

    private final Object b(Context context, InputStream inputStream, String str, Continuation continuation) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", str);
            contentValues.put("mime_type", MimeTypes.VIDEO_MP4);
            contentValues.put("is_pending", Boxing.d(1));
            Uri insert = context.getContentResolver().insert(Build.VERSION.SDK_INT >= 29 ? MediaStore.Video.Media.getContentUri("external_primary") : MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
            if (insert != null) {
                OutputStream openOutputStream = context.getContentResolver().openOutputStream(insert);
                if (openOutputStream != null) {
                    try {
                        Boxing.e(ByteStreamsKt.b(inputStream, openOutputStream, 0, 2, null));
                        CloseableKt.a(openOutputStream, null);
                    } finally {
                    }
                }
                contentValues.clear();
                contentValues.put("is_pending", Boxing.d(0));
                Boxing.d(context.getContentResolver().update(insert, contentValues, null, null));
            }
            return insert;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(android.content.Context r6, java.lang.String r7, java.lang.String r8, kotlin.coroutines.Continuation r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.transsion.postdetail.util.VideoSaver$saveVideoToGallery$1
            if (r0 == 0) goto L13
            r0 = r9
            com.transsion.postdetail.util.VideoSaver$saveVideoToGallery$1 r0 = (com.transsion.postdetail.util.VideoSaver$saveVideoToGallery$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.postdetail.util.VideoSaver$saveVideoToGallery$1 r0 = new com.transsion.postdetail.util.VideoSaver$saveVideoToGallery$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Exception -> L2c
            goto L66
        L2c:
            r6 = move-exception
            goto L69
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Exception -> L2c
            goto L5a
        L3a:
            kotlin.ResultKt.b(r9)
            java.net.URL r9 = new java.net.URL     // Catch: java.lang.Exception -> L2c
            r9.<init>(r7)     // Catch: java.lang.Exception -> L2c
            java.io.InputStream r7 = com.google.firebase.perf.network.FirebasePerfUrlConnection.openStream(r9)     // Catch: java.lang.Exception -> L2c
            java.lang.String r9 = "openStream(...)"
            kotlin.jvm.internal.Intrinsics.g(r7, r9)     // Catch: java.lang.Exception -> L2c
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L2c
            r2 = 29
            if (r9 < r2) goto L5d
            r0.label = r4     // Catch: java.lang.Exception -> L2c
            java.lang.Object r9 = r5.b(r6, r7, r8, r0)     // Catch: java.lang.Exception -> L2c
            if (r9 != r1) goto L5a
            return r1
        L5a:
            android.net.Uri r9 = (android.net.Uri) r9     // Catch: java.lang.Exception -> L2c
            goto L6d
        L5d:
            r0.label = r3     // Catch: java.lang.Exception -> L2c
            java.lang.Object r9 = r5.a(r6, r7, r8, r0)     // Catch: java.lang.Exception -> L2c
            if (r9 != r1) goto L66
            return r1
        L66:
            android.net.Uri r9 = (android.net.Uri) r9     // Catch: java.lang.Exception -> L2c
            goto L6d
        L69:
            r6.printStackTrace()
            r9 = 0
        L6d:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.util.VideoSaver.c(android.content.Context, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
