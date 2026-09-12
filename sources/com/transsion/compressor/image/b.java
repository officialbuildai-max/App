package com.transsion.compressor.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final File f44040a;

    /* renamed from: b, reason: collision with root package name */
    private final d f44041b;

    /* renamed from: c, reason: collision with root package name */
    private int f44042c;

    /* renamed from: d, reason: collision with root package name */
    private int f44043d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f44044e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(d dVar, File file, boolean z10) {
        this.f44040a = file;
        this.f44041b = dVar;
        this.f44044e = z10;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        BitmapFactory.decodeStream(dVar.open(), null, options);
        this.f44042c = options.outWidth;
        this.f44043d = options.outHeight;
    }

    private int b() {
        int i11 = this.f44042c;
        if (i11 % 2 == 1) {
            i11++;
        }
        this.f44042c = i11;
        int i12 = this.f44043d;
        if (i12 % 2 == 1) {
            i12++;
        }
        this.f44043d = i12;
        int max = Math.max(i11, i12);
        float min = Math.min(this.f44042c, this.f44043d) / max;
        if (min > 1.0f || min <= 0.5625d) {
            double d11 = min;
            if (d11 > 0.5625d || d11 <= 0.5d) {
                return (int) Math.ceil(max / (1280.0d / d11));
            }
            int i13 = max / 1280;
            if (i13 == 0) {
                return 1;
            }
            return i13;
        }
        if (max < 1664) {
            return 1;
        }
        if (max < 4990) {
            return 2;
        }
        if (max <= 4990 || max >= 10240) {
            return max / 1280;
        }
        return 4;
    }

    private Bitmap c(Bitmap bitmap, int i11) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i11);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File a() {
        Throwable th2;
        FileOutputStream fileOutputStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = b();
        Bitmap decodeStream = BitmapFactory.decodeStream(this.f44041b.open(), null, options);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Checker checker = Checker.SINGLE;
        if (checker.isJpg(this.f44041b.open())) {
            decodeStream = c(decodeStream, checker.getOrientation(this.f44041b.open()));
        }
        decodeStream.compress(Bitmap.CompressFormat.WEBP, 70, byteArrayOutputStream);
        decodeStream.recycle();
        try {
            fileOutputStream = new FileOutputStream(this.f44040a);
            try {
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.flush();
                fileOutputStream.close();
                byteArrayOutputStream.close();
                return this.f44040a;
            } catch (Throwable th3) {
                th2 = th3;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                byteArrayOutputStream.close();
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            fileOutputStream = null;
        }
    }
}
