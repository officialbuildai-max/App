package ek;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a extends LruBitmapPool {
    public a(long j11) {
        super(j11);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public Bitmap get(int i11, int i12, Bitmap.Config config) {
        Intrinsics.h(config, "config");
        Bitmap bitmap = super.get(i11, i12, config);
        Intrinsics.g(bitmap, "get(...)");
        if (!bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i11, i12, config);
        Intrinsics.e(createBitmap);
        return createBitmap;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public Bitmap getDirty(int i11, int i12, Bitmap.Config config) {
        Intrinsics.h(config, "config");
        Bitmap dirty = super.getDirty(i11, i12, config);
        Intrinsics.g(dirty, "getDirty(...)");
        if (!dirty.isRecycled()) {
            return dirty;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i11, i12, config);
        Intrinsics.e(createBitmap);
        return createBitmap;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void put(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            super.put(bitmap);
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }
}
