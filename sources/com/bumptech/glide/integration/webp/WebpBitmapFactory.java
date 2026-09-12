package com.bumptech.glide.integration.webp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.TypedValue;
import androidx.annotation.Keep;
import com.bumptech.glide.integration.webp.WebpHeaderParser;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Keep
/* loaded from: classes.dex */
public class WebpBitmapFactory {
    private static final int IN_TEMP_BUFFER_SIZE = 8192;
    private static final int MAX_WEBP_HEADER_SIZE = 21;

    static {
        System.loadLibrary("glide-webp");
    }

    @Keep
    private static Bitmap createBitmap(int i11, int i12, BitmapFactory.Options options) {
        Bitmap bitmap;
        if (options != null && (bitmap = options.inBitmap) != null && bitmap.isMutable()) {
            return options.inBitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
        createBitmap.setHasAlpha(true);
        createBitmap.eraseColor(0);
        return createBitmap;
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i11, int i12) {
        return decodeByteArray(bArr, i11, i12, null);
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i11, int i12, BitmapFactory.Options options) {
        if ((i11 | i12) < 0 || bArr.length < i11 + i12) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (!webpSupportRequired(bArr, i11, i12)) {
            return BitmapFactory.decodeByteArray(bArr, i11, i12, options);
        }
        Bitmap nativeDecodeByteArray = nativeDecodeByteArray(bArr, i11, i12, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
        setWebpBitmapOptions(nativeDecodeByteArray, options);
        return nativeDecodeByteArray;
    }

    public static Bitmap decodeFile(String str) {
        return decodeFile(str, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap decodeFile(java.lang.String r4, android.graphics.BitmapFactory.Options r5) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L15
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L15
            android.graphics.Bitmap r0 = decodeStream(r1, r0, r5)     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L11
        La:
            r1.close()     // Catch: java.io.IOException -> L30
            goto L30
        Le:
            r4 = move-exception
            r0 = r1
            goto L31
        L11:
            r4 = move-exception
            goto L17
        L13:
            r4 = move-exception
            goto L31
        L15:
            r4 = move-exception
            r1 = r0
        L17:
            java.lang.String r5 = "WebpBitmapFactory"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Le
            r2.<init>()     // Catch: java.lang.Throwable -> Le
            java.lang.String r3 = "Unable to decode stream: "
            r2.append(r3)     // Catch: java.lang.Throwable -> Le
            r2.append(r4)     // Catch: java.lang.Throwable -> Le
            java.lang.String r4 = r2.toString()     // Catch: java.lang.Throwable -> Le
            android.util.Log.e(r5, r4)     // Catch: java.lang.Throwable -> Le
            if (r1 == 0) goto L30
            goto La
        L30:
            return r0
        L31:
            if (r0 == 0) goto L36
            r0.close()     // Catch: java.io.IOException -> L36
        L36:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.integration.webp.WebpBitmapFactory.decodeFile(java.lang.String, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor) {
        return decodeFileDescriptor(fileDescriptor, null, null);
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        Bitmap decodeFileDescriptor;
        InputStream wrapToMarkSupportedStream = wrapToMarkSupportedStream(new FileInputStream(fileDescriptor));
        try {
            if (webpSupportRequired(getImageHeader(wrapToMarkSupportedStream), 0, 21)) {
                decodeFileDescriptor = nativeDecodeStream(wrapToMarkSupportedStream, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
                setWebpBitmapOptions(decodeFileDescriptor, options);
                setDefaultPadding(rect);
            } else {
                decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
            }
            try {
                wrapToMarkSupportedStream.close();
            } catch (Throwable unused) {
            }
            return decodeFileDescriptor;
        } catch (Throwable th2) {
            try {
                wrapToMarkSupportedStream.close();
            } catch (Throwable unused2) {
            }
            throw th2;
        }
    }

    public static Bitmap decodeResource(Resources resources, int i11) {
        return decodeResource(resources, i11, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
    
        throw new java.lang.IllegalArgumentException("Problem decoding into existing bitmap");
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0010, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0021, code lost:
    
        if (r3 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000e, code lost:
    
        if (r3 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0024, code lost:
    
        if (r0 != null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap decodeResource(android.content.res.Resources r2, int r3, android.graphics.BitmapFactory.Options r4) {
        /*
            r0 = 0
            android.util.TypedValue r1 = new android.util.TypedValue     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            r1.<init>()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            java.io.InputStream r3 = r2.openRawResource(r3, r1)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            android.graphics.Bitmap r0 = decodeResourceStream(r2, r1, r3, r0, r4)     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L21
            if (r3 == 0) goto L24
        L10:
            r3.close()     // Catch: java.io.IOException -> L24
            goto L24
        L14:
            r2 = move-exception
            r0 = r3
            goto L1b
        L17:
            r2 = move-exception
            goto L1b
        L19:
            r3 = r0
            goto L21
        L1b:
            if (r0 == 0) goto L20
            r0.close()     // Catch: java.io.IOException -> L20
        L20:
            throw r2
        L21:
            if (r3 == 0) goto L24
            goto L10
        L24:
            if (r0 != 0) goto L35
            if (r4 == 0) goto L35
            android.graphics.Bitmap r2 = r4.inBitmap
            if (r2 != 0) goto L2d
            goto L35
        L2d:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Problem decoding into existing bitmap"
            r2.<init>(r3)
            throw r2
        L35:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.integration.webp.WebpBitmapFactory.decodeResource(android.content.res.Resources, int, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    public static Bitmap decodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        if (options.inDensity == 0 && typedValue != null) {
            int i11 = typedValue.density;
            if (i11 == 0) {
                options.inDensity = 160;
            } else if (i11 != 65535) {
                options.inDensity = i11;
            }
        }
        if (options.inTargetDensity == 0 && resources != null) {
            options.inTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        return decodeStream(inputStream, rect, options);
    }

    public static Bitmap decodeStream(InputStream inputStream) {
        return decodeStream(inputStream, null, null);
    }

    public static Bitmap decodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        if (inputStream == null) {
            return null;
        }
        InputStream wrapToMarkSupportedStream = wrapToMarkSupportedStream(inputStream);
        if (!webpSupportRequired(getImageHeader(wrapToMarkSupportedStream), 0, 21)) {
            return BitmapFactory.decodeStream(wrapToMarkSupportedStream, rect, options);
        }
        Bitmap nativeDecodeStream = nativeDecodeStream(wrapToMarkSupportedStream, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
        setWebpBitmapOptions(nativeDecodeStream, options);
        setDefaultPadding(rect);
        return nativeDecodeStream;
    }

    private static byte[] getImageHeader(InputStream inputStream) {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream, 21);
        }
        inputStream.mark(21);
        byte[] bArr = new byte[21];
        try {
            inputStream.read(bArr, 0, 21);
            inputStream.reset();
            return bArr;
        } catch (IOException unused) {
            return null;
        }
    }

    private static byte[] getInTempStorageFromOptions(BitmapFactory.Options options) {
        byte[] bArr;
        return (options == null || (bArr = options.inTempStorage) == null) ? new byte[8192] : bArr;
    }

    private static float getScaleFromOptions(BitmapFactory.Options options) {
        if (options == null) {
            return 1.0f;
        }
        int i11 = options.inSampleSize;
        float f11 = i11 > 1 ? 1.0f / i11 : 1.0f;
        if (!options.inScaled) {
            return f11;
        }
        int i12 = options.inDensity;
        int i13 = options.inTargetDensity;
        return (i12 == 0 || i13 == 0 || i12 == options.inScreenDensity) ? f11 : i13 / i12;
    }

    private static native Bitmap nativeDecodeByteArray(byte[] bArr, int i11, int i12, BitmapFactory.Options options, float f11, byte[] bArr2);

    private static native Bitmap nativeDecodeStream(InputStream inputStream, BitmapFactory.Options options, float f11, byte[] bArr);

    private static void setDefaultPadding(Rect rect) {
        if (rect != null) {
            rect.top = -1;
            rect.left = -1;
            rect.bottom = -1;
            rect.right = -1;
        }
    }

    private static void setDensityFromOptions(Bitmap bitmap, BitmapFactory.Options options) {
        if (bitmap == null || options == null) {
            return;
        }
        int i11 = options.inDensity;
        if (i11 == 0) {
            if (options.inBitmap != null) {
                bitmap.setDensity(160);
                return;
            }
            return;
        }
        bitmap.setDensity(i11);
        int i12 = options.inTargetDensity;
        if (i12 == 0 || i11 == i12 || i11 == options.inScreenDensity || !options.inScaled) {
            return;
        }
        bitmap.setDensity(i12);
    }

    @Keep
    private static boolean setOutDimensions(BitmapFactory.Options options, int i11, int i12) {
        if (options == null) {
            return false;
        }
        options.outWidth = i11;
        options.outHeight = i12;
        return options.inJustDecodeBounds;
    }

    private static void setWebpBitmapOptions(Bitmap bitmap, BitmapFactory.Options options) {
        setDensityFromOptions(bitmap, options);
        if (options != null) {
            options.outMimeType = "image/webp";
        }
    }

    public static boolean webpSupportRequired(byte[] bArr, int i11, int i12) {
        try {
            WebpHeaderParser.getType(bArr, i11, i12);
            return false;
        } catch (IOException unused) {
            WebpHeaderParser.WebpImageType webpImageType = WebpHeaderParser.WebpImageType.WEBP_SIMPLE;
            return false;
        }
    }

    private static InputStream wrapToMarkSupportedStream(InputStream inputStream) {
        return !inputStream.markSupported() ? new BufferedInputStream(inputStream, 8192) : inputStream;
    }
}
