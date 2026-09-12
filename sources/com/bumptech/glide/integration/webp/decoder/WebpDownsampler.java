package com.bumptech.glide.integration.webp.decoder;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bumptech.glide.integration.webp.WebpHeaderParser;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* loaded from: classes2.dex */
public final class WebpDownsampler {
    private static final int DENSITY_PRECISION_MULTIPLIER = 1000000000;
    private static final int MARK_POSITION = 10485760;
    private static final String TAG = "WebpDownsampler";
    private final BitmapPool bitmapPool;
    private final ArrayPool byteArrayPool;
    private final DisplayMetrics displayMetrics;
    private final List<ImageHeaderParser> parsers;
    public static final Option<Boolean> DISABLE_DECODER = Option.memory("com.bumptech.glide.integration.webp.decoder.WebpDownsampler.DisableDecoder", Boolean.FALSE);
    private static final Downsampler.DecodeCallbacks EMPTY_CALLBACKS = new Downsampler.DecodeCallbacks() { // from class: com.bumptech.glide.integration.webp.decoder.WebpDownsampler.1
        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) throws IOException {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onObtainBounds() {
        }
    };
    private static final Queue<BitmapFactory.Options> OPTIONS_QUEUE = Util.createQueue(0);

    public WebpDownsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.parsers = list;
        this.displayMetrics = (DisplayMetrics) Preconditions.checkNotNull(displayMetrics);
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(bitmapPool);
        this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(arrayPool);
    }

    private static int adjustTargetDensityForError(double d11) {
        return round((d11 / (r0 / 1.0E9f)) * round(1.0E9d * d11));
    }

    private void calculateConfig(InputStream inputStream, DecodeFormat decodeFormat, boolean z10, boolean z11, BitmapFactory.Options options, int i11, int i12) throws IOException {
        boolean z12;
        if (decodeFormat == DecodeFormat.PREFER_ARGB_8888) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        try {
            z12 = ImageHeaderParserUtils.getType(this.parsers, inputStream, this.byteArrayPool).hasAlpha();
        } catch (IOException unused) {
            if (Log.isLoggable(TAG, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cannot determine whether the image has alpha or not from header, format ");
                sb2.append(decodeFormat);
            }
            z12 = false;
        }
        Bitmap.Config config = z12 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444 || config == Bitmap.Config.ALPHA_8) {
            options.inDither = true;
        }
    }

    static void calculateScaling(ImageHeaderParser.ImageType imageType, InputStream inputStream, Downsampler.DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool, DownsampleStrategy downsampleStrategy, int i11, int i12, int i13, int i14, int i15, BitmapFactory.Options options) throws IOException {
        int floor;
        double floor2;
        int i16;
        if (i12 <= 0 || i13 <= 0) {
            return;
        }
        float scaleFactor = (i11 == 90 || i11 == 270) ? downsampleStrategy.getScaleFactor(i13, i12, i14, i15) : downsampleStrategy.getScaleFactor(i12, i13, i14, i15);
        if (scaleFactor <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + scaleFactor + " from: " + downsampleStrategy + ", source: [" + i12 + "x" + i13 + "], target: [" + i14 + "x" + i15 + "]");
        }
        DownsampleStrategy.SampleSizeRounding sampleSizeRounding = downsampleStrategy.getSampleSizeRounding(i12, i13, i14, i15);
        if (sampleSizeRounding == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f11 = i12;
        float f12 = i13;
        int round = i12 / round(scaleFactor * f11);
        int round2 = i13 / round(scaleFactor * f12);
        DownsampleStrategy.SampleSizeRounding sampleSizeRounding2 = DownsampleStrategy.SampleSizeRounding.MEMORY;
        int max = Math.max(1, Integer.highestOneBit(sampleSizeRounding == sampleSizeRounding2 ? Math.max(round, round2) : Math.min(round, round2)));
        if (sampleSizeRounding == sampleSizeRounding2 && max < 1.0f / scaleFactor) {
            max <<= 1;
        }
        options.inSampleSize = max;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float min = Math.min(max, 8);
            floor = (int) Math.ceil(f11 / min);
            i16 = (int) Math.ceil(f12 / min);
            int i17 = max / 8;
            if (i17 > 0) {
                floor /= i17;
                i16 /= i17;
            }
        } else {
            if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
                float f13 = max;
                floor = (int) Math.floor(f11 / f13);
                floor2 = Math.floor(f12 / f13);
            } else if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                if (Build.VERSION.SDK_INT >= 24) {
                    float f14 = max;
                    floor = Math.round(f11 / f14);
                    i16 = Math.round(f12 / f14);
                } else {
                    float f15 = max;
                    floor = (int) Math.floor(f11 / f15);
                    floor2 = Math.floor(f12 / f15);
                }
            } else if (i12 % max == 0 && i13 % max == 0) {
                floor = i12 / max;
                i16 = i13 / max;
            } else {
                int[] dimensions = getDimensions(inputStream, options, decodeCallbacks, bitmapPool);
                floor = dimensions[0];
                i16 = dimensions[1];
            }
            i16 = (int) floor2;
        }
        double scaleFactor2 = downsampleStrategy.getScaleFactor(floor, i16, i14, i15);
        options.inTargetDensity = adjustTargetDensityForError(scaleFactor2);
        options.inDensity = 1000000000;
        if (isScaling(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "Calculate scaling, source: [" + i12 + "x" + i13 + "], target: [" + i14 + "x" + i15 + "], power of two scaled: [" + floor + "x" + i16 + "], exact scale factor: " + scaleFactor + ", power of 2 sample size: " + max + ", adjusted scale factor: " + scaleFactor2 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    private Bitmap decodeFromWrappedStreams(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, boolean z10, int i11, int i12, boolean z11, Downsampler.DecodeCallbacks decodeCallbacks) throws IOException {
        int i13;
        int round;
        int round2;
        long logTime = LogTime.getLogTime();
        int[] dimensions = getDimensions(inputStream, options, decodeCallbacks, this.bitmapPool);
        int i14 = dimensions[0];
        int i15 = dimensions[1];
        String str = options.outMimeType;
        boolean z12 = (i14 == -1 || i15 == -1) ? false : z10;
        int orientation = ImageHeaderParserUtils.getOrientation(this.parsers, inputStream, this.byteArrayPool);
        int exifOrientationDegrees = TransformationUtils.getExifOrientationDegrees(orientation);
        boolean isExifOrientationRequired = TransformationUtils.isExifOrientationRequired(orientation);
        int i16 = i11 == Integer.MIN_VALUE ? i14 : i11;
        int i17 = i12 == Integer.MIN_VALUE ? i15 : i12;
        ImageHeaderParser.ImageType type = ImageHeaderParserUtils.getType(this.parsers, inputStream, this.byteArrayPool);
        calculateScaling(type, inputStream, decodeCallbacks, this.bitmapPool, downsampleStrategy, exifOrientationDegrees, i14, i15, i16, i17, options);
        calculateConfig(inputStream, decodeFormat, z12, isExifOrientationRequired, options, i16, i17);
        if (shouldUsePool(type)) {
            if (z11) {
                round = i16;
                round2 = i17;
            } else {
                float f11 = isScaling(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i18 = options.inSampleSize;
                float f12 = i18;
                int ceil = (int) Math.ceil(i14 / f12);
                int ceil2 = (int) Math.ceil(i15 / f12);
                round = Math.round(ceil * f11);
                round2 = Math.round(ceil2 * f11);
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Calculated target [" + round + "x" + round2 + "] for source [" + i14 + "x" + i15 + "], sampleSize: " + i18 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f11);
                }
            }
            if (round > 0 && round2 > 0) {
                setInBitmap(options, this.bitmapPool, round, round2);
            }
        }
        Bitmap decodeStream = decodeStream(inputStream, options, decodeCallbacks, this.bitmapPool);
        decodeCallbacks.onDecodeComplete(this.bitmapPool, decodeStream);
        if (Log.isLoggable(TAG, 2)) {
            i13 = orientation;
            logDecode(i14, i15, str, options, decodeStream, i11, i12, logTime);
        } else {
            i13 = orientation;
        }
        if (decodeStream == null) {
            return null;
        }
        decodeStream.setDensity(this.displayMetrics.densityDpi);
        Bitmap rotateImageExif = TransformationUtils.rotateImageExif(this.bitmapPool, decodeStream, i13);
        if (decodeStream.equals(rotateImageExif)) {
            return rotateImageExif;
        }
        this.bitmapPool.put(decodeStream);
        return rotateImageExif;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Bitmap decodeStream(java.io.InputStream r5, android.graphics.BitmapFactory.Options r6, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r7, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r8) throws java.io.IOException {
        /*
            boolean r0 = r6.inJustDecodeBounds
            if (r0 == 0) goto La
            r0 = 10485760(0xa00000, float:1.469368E-38)
            r5.mark(r0)
            goto Ld
        La:
            r7.onObtainBounds()
        Ld:
            int r0 = r6.outWidth
            int r1 = r6.outHeight
            java.lang.String r2 = r6.outMimeType
            java.util.concurrent.locks.Lock r3 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r3.lock()
            r3 = 0
            android.graphics.Bitmap r7 = com.bumptech.glide.integration.webp.WebpBitmapFactory.decodeStream(r5, r3, r6)     // Catch: java.lang.Throwable -> L2e java.lang.IllegalArgumentException -> L30
            java.util.concurrent.locks.Lock r8 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r8.unlock()
            boolean r6 = r6.inJustDecodeBounds
            if (r6 == 0) goto L2d
            r5.reset()
        L2d:
            return r7
        L2e:
            r5 = move-exception
            goto L57
        L30:
            r4 = move-exception
            java.io.IOException r0 = newIoExceptionForInBitmapAssertion(r4, r0, r1, r2, r6)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r1 = "WebpDownsampler"
            r2 = 3
            android.util.Log.isLoggable(r1, r2)     // Catch: java.lang.Throwable -> L2e
            android.graphics.Bitmap r1 = r6.inBitmap     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto L56
            r5.reset()     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L55
            android.graphics.Bitmap r1 = r6.inBitmap     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L55
            r8.put(r1)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L55
            r6.inBitmap = r3     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L55
            android.graphics.Bitmap r5 = decodeStream(r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L55
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r6.unlock()
            return r5
        L55:
            throw r0     // Catch: java.lang.Throwable -> L2e
        L56:
            throw r0     // Catch: java.lang.Throwable -> L2e
        L57:
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.integration.webp.decoder.WebpDownsampler.decodeStream(java.io.InputStream, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool):android.graphics.Bitmap");
    }

    @Nullable
    @TargetApi(19)
    private static String getBitmapString(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static synchronized BitmapFactory.Options getDefaultOptions() {
        BitmapFactory.Options poll;
        synchronized (WebpDownsampler.class) {
            Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                resetOptions(poll);
            }
        }
        return poll;
    }

    private static int[] getDimensions(InputStream inputStream, BitmapFactory.Options options, Downsampler.DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) throws IOException {
        options.inJustDecodeBounds = true;
        decodeStream(inputStream, options, decodeCallbacks, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String getInBitmapString(BitmapFactory.Options options) {
        return getBitmapString(options.inBitmap);
    }

    private static boolean isScaling(BitmapFactory.Options options) {
        int i11;
        int i12 = options.inTargetDensity;
        return i12 > 0 && (i11 = options.inDensity) > 0 && i12 != i11;
    }

    private static void logDecode(int i11, int i12, String str, BitmapFactory.Options options, Bitmap bitmap, int i13, int i14, long j11) {
        Log.v(TAG, "Decoded " + getBitmapString(bitmap) + " from [" + i11 + "x" + i12 + "] " + str + " with inBitmap " + getInBitmapString(options) + " for [" + i13 + "x" + i14 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + LogTime.getElapsedMillis(j11));
    }

    private static IOException newIoExceptionForInBitmapAssertion(IllegalArgumentException illegalArgumentException, int i11, int i12, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i11 + ", outHeight: " + i12 + ", outMimeType: " + str + ", inBitmap: " + getInBitmapString(options), illegalArgumentException);
    }

    private static void releaseOptions(BitmapFactory.Options options) {
        resetOptions(options);
        Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void resetOptions(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int round(double d11) {
        return (int) (d11 + 0.5d);
    }

    @TargetApi(26)
    private static void setInBitmap(BitmapFactory.Options options, BitmapPool bitmapPool, int i11, int i12) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT >= 26) {
            Bitmap.Config config2 = options.inPreferredConfig;
            config = Bitmap.Config.HARDWARE;
            if (config2 == config) {
                return;
            }
        }
        options.inBitmap = bitmapPool.getDirty(i11, i12, options.inPreferredConfig);
    }

    private boolean shouldUsePool(ImageHeaderParser.ImageType imageType) throws IOException {
        return true;
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i11, int i12, Options options) throws IOException {
        return decode(inputStream, i11, i12, options, EMPTY_CALLBACKS);
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i11, int i12, Options options, Downsampler.DecodeCallbacks decodeCallbacks) throws IOException {
        Preconditions.checkArgument(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        BitmapFactory.Options defaultOptions = getDefaultOptions();
        defaultOptions.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options.get(Downsampler.DECODE_FORMAT);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(Downsampler.DOWNSAMPLE_STRATEGY);
        boolean booleanValue = ((Boolean) options.get(Downsampler.FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue();
        Option<Boolean> option = Downsampler.ALLOW_HARDWARE_CONFIG;
        try {
            return BitmapResource.obtain(decodeFromWrappedStreams(inputStream, defaultOptions, downsampleStrategy, decodeFormat, options.get(option) != null && ((Boolean) options.get(option)).booleanValue(), i11, i12, booleanValue, decodeCallbacks), this.bitmapPool);
        } finally {
            releaseOptions(defaultOptions);
            this.byteArrayPool.put(bArr, byte[].class);
        }
    }

    public boolean handles(InputStream inputStream, Options options) throws IOException {
        if (((Boolean) options.get(DISABLE_DECODER)).booleanValue() || WebpHeaderParser.sIsExtendedWebpSupported) {
            return false;
        }
        WebpHeaderParser.WebpImageType type = WebpHeaderParser.getType(inputStream, this.byteArrayPool);
        return WebpHeaderParser.isStaticWebpType(type) && type != WebpHeaderParser.WebpImageType.WEBP_SIMPLE;
    }

    public boolean handles(ByteBuffer byteBuffer, Options options) throws IOException {
        if (((Boolean) options.get(DISABLE_DECODER)).booleanValue() || WebpHeaderParser.sIsExtendedWebpSupported) {
            return false;
        }
        WebpHeaderParser.WebpImageType type = WebpHeaderParser.getType(byteBuffer);
        return WebpHeaderParser.isStaticWebpType(type) && type != WebpHeaderParser.WebpImageType.WEBP_SIMPLE;
    }
}
