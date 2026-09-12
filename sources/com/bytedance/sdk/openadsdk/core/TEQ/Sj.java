package com.bytedance.sdk.openadsdk.core.TEQ;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.drawable.c;
import com.bytedance.adsdk.ugeno.Sj;
import com.bytedance.sdk.component.Dq.Dq;
import com.bytedance.sdk.component.HiB.TEQ;
import com.bytedance.sdk.component.HiB.Ym;
import com.bytedance.sdk.component.HiB.uvD;
import com.bytedance.sdk.component.utils.Jcg;
import com.bytedance.sdk.component.utils.sU;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.utils.JcM;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: classes3.dex */
public class Sj implements com.bytedance.adsdk.ugeno.Sj {

    /* renamed from: com.bytedance.sdk.openadsdk.core.TEQ.Sj$Sj, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0267Sj {
        void Sj(Drawable drawable);
    }

    /* loaded from: classes3.dex */
    private static class sP implements uvD {
        private final int EjP;
        private final WeakReference<ImageView> Sj;
        private final int TKC;
        private final Sj sP;

        public sP(ImageView imageView, Sj sj2, int i11, int i12) {
            this.Sj = new WeakReference<>(imageView);
            this.sP = sj2;
            this.TKC = i11;
            this.EjP = i12;
        }

        @Override // com.bytedance.sdk.component.HiB.uvD
        public void Sj(int i11, String str, Throwable th2) {
        }

        @Override // com.bytedance.sdk.component.HiB.uvD
        public void Sj(Ym ym2) {
            try {
                final ImageView imageView = this.Sj.get();
                if (imageView == null) {
                    return;
                }
                final Object sP = ym2.sP();
                if (!(sP instanceof byte[])) {
                    if (sP instanceof Bitmap) {
                        JcM.Sj((Runnable) new Dq("ug_load_bitmap") { // from class: com.bytedance.sdk.openadsdk.core.TEQ.Sj.sP.2
                            @Override // java.lang.Runnable
                            public void run() {
                                imageView.setImageBitmap((Bitmap) sP);
                            }
                        });
                    }
                } else {
                    if (ym2.HiB()) {
                        if (Build.VERSION.SDK_INT <= 30) {
                            this.sP.Sj((byte[]) sP, imageView);
                            return;
                        } else {
                            this.sP.Sj(imageView, (byte[]) sP, this.TKC, this.EjP);
                            return;
                        }
                    }
                    if (this.sP.Sj((byte[]) sP)) {
                        this.sP.Sj(imageView, (byte[]) sP, this.TKC, this.EjP);
                        return;
                    }
                    final Bitmap Sj = new com.bytedance.sdk.component.HiB.EjP.TKC.sP.Sj(this.TKC, this.EjP, imageView.getScaleType(), Bitmap.Config.RGB_565, this.TKC, this.EjP).Sj((byte[]) sP);
                    if (Sj != null) {
                        JcM.Sj((Runnable) new Dq("load_static_img") { // from class: com.bytedance.sdk.openadsdk.core.TEQ.Sj.sP.1
                            @Override // java.lang.Runnable
                            public void run() {
                                imageView.setImageBitmap(Sj);
                            }
                        });
                    }
                }
            } catch (Throwable th2) {
                sU.sP("ImageLoaderProvider", th2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(final ImageView imageView, byte[] bArr, int i11, int i12) {
        ImageDecoder.Source createSource;
        final Drawable decodeDrawable;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (Build.VERSION.SDK_INT < 28) {
            sP(imageView, bArr, i11, i12);
            return;
        }
        createSource = ImageDecoder.createSource(wrap);
        try {
            decodeDrawable = ImageDecoder.decodeDrawable(createSource);
            if (decodeDrawable != null) {
                JcM.Sj((Runnable) new Dq("loadAnimatedDrawable") { // from class: com.bytedance.sdk.openadsdk.core.TEQ.Sj.1
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setImageDrawable(decodeDrawable);
                    }
                });
            }
        } catch (IOException e11) {
            sU.sP("ImageLoaderProvider", e11.getMessage());
        }
    }

    private void Sj(com.bytedance.adsdk.ugeno.core.Dq dq2, @NonNull TEQ teq, String str) {
        Map<String, Object> sP2;
        if (dq2 == null || (sP2 = dq2.sP()) == null) {
            return;
        }
        Object obj = sP2.get("image_info");
        if (obj instanceof Map) {
            teq.Sj((String) ((Map) obj).get(str));
        }
        String str2 = (String) sP2.get("cache_dir");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        teq.sP(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(byte[] bArr, final ImageView imageView) {
        try {
            Sj(bArr, new InterfaceC0267Sj() { // from class: com.bytedance.sdk.openadsdk.core.TEQ.Sj.3
                @Override // com.bytedance.sdk.openadsdk.core.TEQ.Sj.InterfaceC0267Sj
                public void Sj(final Drawable drawable) {
                    JcM.Sj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.TEQ.Sj.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Build.VERSION.SDK_INT >= 28 && com.bumptech.glide.load.resource.drawable.b.a(drawable)) {
                                c.a(drawable).start();
                            }
                            imageView.setImageDrawable(drawable);
                        }
                    });
                }
            });
        } catch (Exception e11) {
            sU.sP("ImageLoaderProvider", e11.getMessage());
        }
    }

    private void Sj(final byte[] bArr, final InterfaceC0267Sj interfaceC0267Sj) {
        JcM.sP(new Dq("pag_animation_drawable") { // from class: com.bytedance.sdk.openadsdk.core.TEQ.Sj.4
            @Override // java.lang.Runnable
            public void run() {
                Drawable sP2 = Sj.this.sP(bArr);
                InterfaceC0267Sj interfaceC0267Sj2 = interfaceC0267Sj;
                if (interfaceC0267Sj2 != null) {
                    interfaceC0267Sj2.Sj(sP2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable sP(byte[] bArr) {
        FileOutputStream fileOutputStream;
        ImageDecoder.Source createSource;
        Drawable decodeDrawable;
        try {
            boolean TKC = com.bytedance.sdk.openadsdk.multipro.sP.TKC();
            File Sj = Jcg.Sj(dNu.Sj(), TKC, TKC ? "UGEN_GIF_AD_CACHE/" : "/UGEN_GIF_CACHE/", "TT_UGEN_GIF_FILE");
            fileOutputStream = new FileOutputStream(Sj);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                if (Build.VERSION.SDK_INT < 28) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(dNu.Sj().getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    return bitmapDrawable;
                }
                createSource = ImageDecoder.createSource(Sj);
                decodeDrawable = ImageDecoder.decodeDrawable(createSource);
                try {
                    fileOutputStream.close();
                } catch (Throwable unused2) {
                }
                return decodeDrawable;
            } catch (Throwable th2) {
                th = th2;
                try {
                    sU.Sj("ImageLoaderProvider", "GifView  getSourceByFile fail : ", th);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return null;
                } catch (Throwable th3) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    private void sP(final ImageView imageView, byte[] bArr, int i11, int i12) {
        final Bitmap Sj = new com.bytedance.sdk.component.HiB.EjP.TKC.sP.Sj(i11, i12, imageView.getScaleType(), Bitmap.Config.ARGB_4444, i11, i12).Sj(bArr);
        if (Sj != null) {
            JcM.Sj((Runnable) new Dq("loadStaticImage") { // from class: com.bytedance.sdk.openadsdk.core.TEQ.Sj.2
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageBitmap(Sj);
                }
            });
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Sj
    public void Sj(com.bytedance.adsdk.ugeno.core.Dq dq2, String str, ImageView imageView, int i11, int i12) {
        String Sj = TKC.Sj(str);
        TEQ TKC = com.bytedance.sdk.openadsdk.uA.EjP.Sj(Sj).TKC(1);
        Sj(dq2, TKC, Sj);
        TKC.Sj(new sP(imageView, this, i11, i12), 4);
    }

    @Override // com.bytedance.adsdk.ugeno.Sj
    public void Sj(com.bytedance.adsdk.ugeno.core.Dq dq2, String str, Sj.InterfaceC0208Sj interfaceC0208Sj) {
        sP(dq2, TKC.Sj(str), interfaceC0208Sj);
    }

    public boolean Sj(byte[] bArr) {
        return com.bytedance.sdk.component.utils.Ym.Sj(bArr, 0);
    }

    public void sP(com.bytedance.adsdk.ugeno.core.Dq dq2, String str, final Sj.InterfaceC0208Sj interfaceC0208Sj) {
        TEQ TKC = com.bytedance.sdk.openadsdk.uA.EjP.Sj(str).TKC(2);
        Sj(dq2, TKC, str);
        TKC.Sj(new uvD() { // from class: com.bytedance.sdk.openadsdk.core.TEQ.Sj.5
            @Override // com.bytedance.sdk.component.HiB.uvD
            public void Sj(int i11, String str2, Throwable th2) {
                Sj.InterfaceC0208Sj interfaceC0208Sj2 = interfaceC0208Sj;
                if (interfaceC0208Sj2 != null) {
                    interfaceC0208Sj2.Sj(null);
                }
            }

            @Override // com.bytedance.sdk.component.HiB.uvD
            public void Sj(Ym ym2) {
                if (ym2 == null) {
                    interfaceC0208Sj.Sj(null);
                    return;
                }
                if (interfaceC0208Sj != null) {
                    Object sP2 = ym2.sP();
                    if (sP2 instanceof Bitmap) {
                        interfaceC0208Sj.Sj((Bitmap) sP2);
                        return;
                    }
                    if (ym2.sP() instanceof byte[]) {
                        try {
                            interfaceC0208Sj.Sj(BitmapFactory.decodeByteArray((byte[]) ym2.sP(), 0, ((byte[]) ym2.sP()).length));
                            return;
                        } catch (Throwable unused) {
                        }
                    }
                    interfaceC0208Sj.Sj(null);
                }
            }
        }, 4);
    }
}
