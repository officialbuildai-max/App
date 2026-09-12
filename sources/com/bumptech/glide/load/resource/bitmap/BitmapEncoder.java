package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;

/* loaded from: classes2.dex */
public class BitmapEncoder implements ResourceEncoder<Bitmap> {
    private static final String TAG = "BitmapEncoder";

    @Nullable
    private final ArrayPool arrayPool;
    public static final Option<Integer> COMPRESSION_QUALITY = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final Option<Bitmap.CompressFormat> COMPRESSION_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    @Deprecated
    public BitmapEncoder() {
        this.arrayPool = null;
    }

    public BitmapEncoder(@NonNull ArrayPool arrayPool) {
        this.arrayPool = arrayPool;
    }

    private Bitmap.CompressFormat getFormat(Bitmap bitmap, Options options) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) options.get(COMPRESSION_FORMAT);
        return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006c A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #3 {all -> 0x0055, blocks: (B:3:0x0021, B:14:0x0051, B:17:0x0066, B:19:0x006c, B:43:0x00b8, B:41:0x00bb, B:35:0x0061), top: B:2:0x0021 }] */
    @Override // com.bumptech.glide.load.Encoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean encode(@androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> r8, @androidx.annotation.NonNull java.io.File r9, @androidx.annotation.NonNull com.bumptech.glide.load.Options r10) {
        /*
            r7 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r8 = r8.get()
            android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8
            android.graphics.Bitmap$CompressFormat r1 = r7.getFormat(r8, r10)
            int r2 = r8.getWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r3 = r8.getHeight()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "encode: [%dx%d] %s"
            com.bumptech.glide.util.pool.GlideTrace.beginSectionFormat(r4, r2, r3, r1)
            long r2 = com.bumptech.glide.util.LogTime.getLogTime()     // Catch: java.lang.Throwable -> L55
            com.bumptech.glide.load.Option<java.lang.Integer> r4 = com.bumptech.glide.load.resource.bitmap.BitmapEncoder.COMPRESSION_QUALITY     // Catch: java.lang.Throwable -> L55
            java.lang.Object r4 = r10.get(r4)     // Catch: java.lang.Throwable -> L55
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> L55
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> L55
            r5 = 0
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            r6.<init>(r9)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r9 = r7.arrayPool     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            if (r9 == 0) goto L4a
            com.bumptech.glide.load.data.BufferedOutputStream r9 = new com.bumptech.glide.load.data.BufferedOutputStream     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r5 = r7.arrayPool     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            r9.<init>(r6, r5)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            r5 = r9
            goto L4b
        L44:
            r8 = move-exception
            r5 = r6
            goto Lb6
        L48:
            r5 = r6
            goto L5b
        L4a:
            r5 = r6
        L4b:
            r8.compress(r1, r4, r5)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            r5.close()     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            r5.close()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            goto L57
        L55:
            r8 = move-exception
            goto Lbc
        L57:
            r9 = 1
            goto L65
        L59:
            r8 = move-exception
            goto Lb6
        L5b:
            r9 = 3
            android.util.Log.isLoggable(r0, r9)     // Catch: java.lang.Throwable -> L59
            if (r5 == 0) goto L64
            r5.close()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L64
        L64:
            r9 = 0
        L65:
            r4 = 2
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch: java.lang.Throwable -> L55
            if (r4 == 0) goto Lb2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L55
            r4.<init>()     // Catch: java.lang.Throwable -> L55
            java.lang.String r5 = "Compressed with type: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L55
            r4.append(r1)     // Catch: java.lang.Throwable -> L55
            java.lang.String r1 = " of size "
            r4.append(r1)     // Catch: java.lang.Throwable -> L55
            int r1 = com.bumptech.glide.util.Util.getBitmapByteSize(r8)     // Catch: java.lang.Throwable -> L55
            r4.append(r1)     // Catch: java.lang.Throwable -> L55
            java.lang.String r1 = " in "
            r4.append(r1)     // Catch: java.lang.Throwable -> L55
            double r1 = com.bumptech.glide.util.LogTime.getElapsedMillis(r2)     // Catch: java.lang.Throwable -> L55
            r4.append(r1)     // Catch: java.lang.Throwable -> L55
            java.lang.String r1 = ", options format: "
            r4.append(r1)     // Catch: java.lang.Throwable -> L55
            com.bumptech.glide.load.Option<android.graphics.Bitmap$CompressFormat> r1 = com.bumptech.glide.load.resource.bitmap.BitmapEncoder.COMPRESSION_FORMAT     // Catch: java.lang.Throwable -> L55
            java.lang.Object r10 = r10.get(r1)     // Catch: java.lang.Throwable -> L55
            r4.append(r10)     // Catch: java.lang.Throwable -> L55
            java.lang.String r10 = ", hasAlpha: "
            r4.append(r10)     // Catch: java.lang.Throwable -> L55
            boolean r8 = r8.hasAlpha()     // Catch: java.lang.Throwable -> L55
            r4.append(r8)     // Catch: java.lang.Throwable -> L55
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> L55
            android.util.Log.v(r0, r8)     // Catch: java.lang.Throwable -> L55
        Lb2:
            com.bumptech.glide.util.pool.GlideTrace.endSection()
            return r9
        Lb6:
            if (r5 == 0) goto Lbb
            r5.close()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> Lbb
        Lbb:
            throw r8     // Catch: java.lang.Throwable -> L55
        Lbc:
            com.bumptech.glide.util.pool.GlideTrace.endSection()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.BitmapEncoder.encode(com.bumptech.glide.load.engine.Resource, java.io.File, com.bumptech.glide.load.Options):boolean");
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    @NonNull
    public EncodeStrategy getEncodeStrategy(@NonNull Options options) {
        return EncodeStrategy.TRANSFORMED;
    }
}
