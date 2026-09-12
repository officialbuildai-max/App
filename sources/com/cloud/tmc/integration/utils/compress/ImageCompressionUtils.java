package com.cloud.tmc.integration.utils.compress;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.cloud.tmc.integration.BuildConfig;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J:\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J8\u0010\b\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¨\u0006\u0014"}, d2 = {"Lcom/cloud/tmc/integration/utils/compress/ImageCompressionUtils;", "", "()V", "calculateInSampleSize", "", "options", "Landroid/graphics/BitmapFactory$Options;", "ratio", "compressImage", "Ljava/io/File;", "imageFile", "quality", "compressedWidth", "compressedHeight", "compressDir", "", "", "imageData", "format", "Landroid/graphics/Bitmap$CompressFormat;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final class ImageCompressionUtils {
    public static final ImageCompressionUtils INSTANCE = new ImageCompressionUtils();

    private ImageCompressionUtils() {
    }

    private final int calculateInSampleSize(BitmapFactory.Options options, int ratio) {
        int i11 = options.outWidth;
        int i12 = options.outHeight;
        int i13 = 1;
        int i14 = i12;
        int i15 = i11;
        while (true) {
            if (i14 <= i12 / ratio && i15 <= i11 / ratio) {
                return i13;
            }
            i14 >>= 1;
            i15 >>= 1;
            i13 <<= 1;
        }
    }

    @JvmStatic
    public static final File compressImage(File imageFile, int quality, int compressedWidth, int compressedHeight, String compressDir) {
        Intrinsics.h(imageFile, "imageFile");
        String w11 = FilesKt.w(imageFile);
        byte[] compressImage = compressImage(FilesKt.g(imageFile), quality, compressedWidth, compressedHeight, Intrinsics.c(w11, "png") ? Bitmap.CompressFormat.PNG : Intrinsics.c(w11, "webp") ? Build.VERSION.SDK_INT >= 30 ? quality == 100 ? Bitmap.CompressFormat.WEBP_LOSSLESS : Bitmap.CompressFormat.WEBP_LOSSY : Bitmap.CompressFormat.WEBP : Bitmap.CompressFormat.JPEG);
        if (compressDir == null || compressDir.length() == 0) {
            compressDir = imageFile.getParent();
        }
        File file = new File(compressDir, "compressed_" + imageFile.getName());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(compressImage);
            fileOutputStream.flush();
            Unit unit = Unit.f67184a;
            CloseableKt.a(fileOutputStream, null);
            return file;
        } finally {
        }
    }

    @JvmStatic
    public static final byte[] compressImage(byte[] imageData, int quality, int compressedWidth, int compressedHeight, Bitmap.CompressFormat format) {
        Intrinsics.h(imageData, "imageData");
        Intrinsics.h(format, "format");
        if (format == Bitmap.CompressFormat.PNG) {
            return imageData;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(imageData, 0, imageData.length, options);
        int i11 = options.outWidth;
        int i12 = options.outHeight;
        options.inSampleSize = INSTANCE.calculateInSampleSize(options, (compressedWidth <= 0 || compressedHeight <= 0) ? compressedWidth > 0 ? MathKt.c(i11 / compressedWidth) : compressedHeight > 0 ? MathKt.c(i12 / compressedHeight) : 1 : RangesKt.i(MathKt.c(i12 / compressedHeight), MathKt.c(i11 / compressedWidth)));
        options.inJustDecodeBounds = false;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(imageData, 0, imageData.length, options);
        int width = decodeByteArray.getWidth();
        int height = decodeByteArray.getHeight();
        Bitmap createScaledBitmap = (compressedWidth <= 0 || compressedHeight <= 0) ? compressedWidth > 0 ? Bitmap.createScaledBitmap(decodeByteArray, compressedWidth, (int) (height * (compressedWidth / width)), true) : compressedHeight > 0 ? Bitmap.createScaledBitmap(decodeByteArray, (int) (width * (compressedHeight / height)), compressedHeight, true) : decodeByteArray : Bitmap.createScaledBitmap(decodeByteArray, compressedWidth, compressedHeight, true);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createScaledBitmap.compress(format, quality, byteArrayOutputStream);
        createScaledBitmap.recycle();
        decodeByteArray.recycle();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.g(byteArray, "outputStream.toByteArray()");
        return byteArray;
    }

    public static /* synthetic */ File compressImage$default(File file, int i11, int i12, int i13, String str, int i14, Object obj) {
        if ((i14 & 2) != 0) {
            i11 = 80;
        }
        if ((i14 & 4) != 0) {
            i12 = 0;
        }
        if ((i14 & 8) != 0) {
            i13 = 0;
        }
        if ((i14 & 16) != 0) {
            str = null;
        }
        return compressImage(file, i11, i12, i13, str);
    }

    public static /* synthetic */ byte[] compressImage$default(byte[] bArr, int i11, int i12, int i13, Bitmap.CompressFormat compressFormat, int i14, Object obj) {
        if ((i14 & 2) != 0) {
            i11 = 80;
        }
        if ((i14 & 4) != 0) {
            i12 = 0;
        }
        if ((i14 & 8) != 0) {
            i13 = 0;
        }
        if ((i14 & 16) != 0) {
            compressFormat = Bitmap.CompressFormat.JPEG;
        }
        return compressImage(bArr, i11, i12, i13, compressFormat);
    }
}
