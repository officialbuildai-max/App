package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;

/* loaded from: classes2.dex */
public interface ImageOutput {

    /* renamed from: a, reason: collision with root package name */
    public static final ImageOutput f12112a = new a();

    /* loaded from: classes2.dex */
    class a implements ImageOutput {
        a() {
        }

        @Override // androidx.media3.exoplayer.image.ImageOutput
        public void a() {
        }

        @Override // androidx.media3.exoplayer.image.ImageOutput
        public void onImageAvailable(long j11, Bitmap bitmap) {
        }
    }

    void a();

    void onImageAvailable(long j11, Bitmap bitmap);
}
