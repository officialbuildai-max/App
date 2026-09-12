package com.bytedance.sdk.component.adexpress.EjP;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.HardwareRenderer;
import android.graphics.Paint;
import android.graphics.RecordingCanvas;
import android.graphics.RenderEffect;
import android.graphics.RenderNode;
import android.graphics.Shader;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import androidx.compose.foundation.i;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import i6.d;
import i6.e;
import i6.f;
import java.lang.reflect.Array;

/* loaded from: classes2.dex */
public class Sj {
    public static Bitmap Sj(Context context, Bitmap bitmap, int i11) {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * 0.2f), Math.round(bitmap.getHeight() * 0.2f), false);
            return com.bytedance.sdk.component.adexpress.EjP.EjP() == 0 ? sP(context, createScaledBitmap, i11) : com.bytedance.sdk.component.adexpress.EjP.EjP() == 1 ? Sj(createScaledBitmap, i11) : sP(createScaledBitmap, i11);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Bitmap Sj(Bitmap bitmap, int i11) {
        int[] iArr;
        int i12 = i11;
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i13 = width * height;
            int[] iArr2 = new int[i13];
            bitmap.getPixels(iArr2, 0, width, 0, 0, width, height);
            int i14 = width - 1;
            int i15 = height - 1;
            int i16 = i12 + i12;
            int i17 = i16 + 1;
            int i18 = (i16 + 2) >> 1;
            int i19 = i18 * i18;
            int[] iArr3 = new int[Math.max(width, height)];
            int i20 = i19 * 256;
            int[] iArr4 = new int[i20];
            int[] iArr5 = new int[i13];
            int[] iArr6 = new int[i13];
            int[] iArr7 = new int[i13];
            for (int i21 = 0; i21 < i20; i21++) {
                iArr4[i21] = i21 / i19;
            }
            int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i17, 3);
            int i22 = i12 + 1;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            while (i23 < height) {
                int i26 = -i12;
                int i27 = 0;
                int i28 = 0;
                int i29 = 0;
                int i30 = 0;
                int i31 = 0;
                int i32 = 0;
                int i33 = 0;
                int i34 = 0;
                int i35 = 0;
                while (i26 <= i12) {
                    int i36 = i15;
                    int i37 = height;
                    int i38 = iArr2[i24 + Math.min(i14, Math.max(i26, 0))];
                    int[] iArr9 = iArr8[i26 + i12];
                    iArr9[0] = (i38 & 16711680) >> 16;
                    iArr9[1] = (i38 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                    iArr9[2] = i38 & 255;
                    int abs = i22 - Math.abs(i26);
                    int i39 = iArr9[0];
                    i27 += i39 * abs;
                    int i40 = iArr9[1];
                    i28 += i40 * abs;
                    int i41 = iArr9[2];
                    i29 += abs * i41;
                    if (i26 <= 0) {
                        i31 += i39;
                        i33 += i40;
                        i35 += i41;
                    } else {
                        i30 += i39;
                        i32 += i40;
                        i34 += i41;
                    }
                    i26++;
                    height = i37;
                    i15 = i36;
                }
                int i42 = i15;
                int i43 = height;
                int i44 = i12;
                int i45 = 0;
                while (i45 < width) {
                    iArr5[i24] = iArr4[i27];
                    iArr6[i24] = iArr4[i28];
                    iArr7[i24] = iArr4[i29];
                    int[] iArr10 = iArr8[((i44 - i12) + i17) % i17];
                    int i46 = i27 - i31;
                    int i47 = i28 - i33;
                    int i48 = i29 - i35;
                    int i49 = i31 - iArr10[0];
                    int i50 = i33 - iArr10[1];
                    int i51 = i35 - iArr10[2];
                    if (i23 == 0) {
                        iArr = iArr4;
                        iArr3[i45] = Math.min(i45 + i12 + 1, i14);
                    } else {
                        iArr = iArr4;
                    }
                    int i52 = iArr2[i25 + iArr3[i45]];
                    int i53 = (i52 & 16711680) >> 16;
                    iArr10[0] = i53;
                    int i54 = (i52 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                    iArr10[1] = i54;
                    int i55 = i52 & 255;
                    iArr10[2] = i55;
                    int i56 = i30 + i53;
                    int i57 = i32 + i54;
                    int i58 = i34 + i55;
                    i44 = (i44 + 1) % i17;
                    int[] iArr11 = iArr8[i44 % i17];
                    i27 = i46 + i56;
                    i28 = i47 + i57;
                    i29 = i48 + i58;
                    int i59 = iArr11[0];
                    i30 = i56 - i59;
                    int i60 = iArr11[1];
                    i32 = i57 - i60;
                    int i61 = iArr11[2];
                    i34 = i58 - i61;
                    i31 = i49 + i59;
                    i33 = i50 + i60;
                    i35 = i51 + i61;
                    i24++;
                    i45++;
                    iArr4 = iArr;
                }
                i25 += width;
                i23++;
                height = i43;
                i15 = i42;
            }
            int i62 = i15;
            int i63 = height;
            int[] iArr12 = iArr4;
            int i64 = 0;
            while (i64 < width) {
                int i65 = -i12;
                int i66 = i65 * width;
                int i67 = 0;
                int i68 = 0;
                int i69 = 0;
                int i70 = 0;
                int i71 = 0;
                int i72 = 0;
                int i73 = 0;
                int i74 = 0;
                int i75 = 0;
                while (i65 <= i12) {
                    int[] iArr13 = iArr8[i65 + i12];
                    int[] iArr14 = iArr3;
                    int max = Math.max(0, i66) + i64;
                    int abs2 = i22 - Math.abs(i65);
                    int i76 = iArr5[max];
                    i67 += i76 * abs2;
                    i68 += iArr6[max] * abs2;
                    i69 += iArr7[max] * abs2;
                    iArr13[0] = i76;
                    int i77 = iArr6[max];
                    iArr13[1] = i77;
                    int i78 = iArr7[max];
                    iArr13[2] = i78;
                    if (i65 <= 0) {
                        i71 += i76;
                        i73 += i77;
                        i75 += i78;
                    } else {
                        i70 += i76;
                        i72 += i77;
                        i74 += i78;
                    }
                    int i79 = i62;
                    if (i65 < i79) {
                        i66 += width;
                    }
                    i65++;
                    i62 = i79;
                    iArr3 = iArr14;
                }
                int[] iArr15 = iArr3;
                int i80 = i62;
                int i81 = i12;
                int i82 = i64;
                int i83 = i63;
                int i84 = 0;
                while (i84 < i83) {
                    iArr2[i82] = (iArr2[i82] & ViewCompat.MEASURED_STATE_MASK) | (iArr12[i67] << 16) | (iArr12[i68] << 8) | iArr12[i69];
                    int[] iArr16 = iArr8[((i81 - i12) + i17) % i17];
                    int i85 = i67 - i71;
                    int i86 = i68 - i73;
                    int i87 = i69 - i75;
                    int i88 = i71 - iArr16[0];
                    int i89 = i73 - iArr16[1];
                    int i90 = i75 - iArr16[2];
                    if (i64 == 0) {
                        iArr15[i84] = Math.min(i84 + i22, i80) * width;
                    }
                    int i91 = iArr15[i84] + i64;
                    int i92 = iArr5[i91];
                    iArr16[0] = i92;
                    int i93 = iArr6[i91];
                    iArr16[1] = i93;
                    int i94 = iArr7[i91];
                    iArr16[2] = i94;
                    int i95 = i70 + i92;
                    int i96 = i72 + i93;
                    int i97 = i74 + i94;
                    i67 = i85 + i95;
                    i68 = i86 + i96;
                    i69 = i87 + i97;
                    i81 = (i81 + 1) % i17;
                    int[] iArr17 = iArr8[i81];
                    int i98 = iArr17[0];
                    i70 = i95 - i98;
                    int i99 = iArr17[1];
                    i72 = i96 - i99;
                    int i100 = iArr17[2];
                    i74 = i97 - i100;
                    i71 = i88 + i98;
                    i73 = i89 + i99;
                    i75 = i90 + i100;
                    i82 += width;
                    i84++;
                    i12 = i11;
                }
                i64++;
                i12 = i11;
                i63 = i83;
                i62 = i80;
                iArr3 = iArr15;
            }
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, i63);
            return bitmap;
        } catch (Throwable th2) {
            th2.getMessage();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.renderscript.BaseObj] */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.renderscript.BaseObj, android.renderscript.ScriptIntrinsicBlur] */
    public static Bitmap sP(Context context, Bitmap bitmap, int i11) {
        RenderScript renderScript;
        Allocation allocation;
        ?? r22;
        Allocation allocation2;
        com.bytedance.sdk.component.adexpress.Sj.Sj.TKC TKC;
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap);
            renderScript = RenderScript.create(context);
            if (renderScript == null) {
                try {
                    com.bytedance.sdk.component.adexpress.Sj.Sj.TKC TKC2 = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC();
                    if (TKC2 != null && TKC2.dNu() && renderScript != null) {
                        RenderScript.releaseAllContexts();
                    }
                } catch (Throwable th2) {
                    th2.getMessage();
                }
                return null;
            }
            try {
                r22 = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
                try {
                    allocation = Allocation.createFromBitmap(renderScript, bitmap);
                    try {
                        allocation2 = Allocation.createFromBitmap(renderScript, createBitmap);
                        try {
                            r22.setRadius(i11);
                            r22.setInput(allocation);
                            r22.forEach(allocation2);
                            allocation2.copyTo(createBitmap);
                            try {
                                com.bytedance.sdk.component.adexpress.Sj.Sj.TKC TKC3 = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC();
                                if (TKC3 != null && TKC3.dNu()) {
                                    RenderScript.releaseAllContexts();
                                    if (allocation != null) {
                                        allocation.destroy();
                                    }
                                    allocation2.destroy();
                                    r22.destroy();
                                }
                            } catch (Throwable th3) {
                                th3.getMessage();
                            }
                            return createBitmap;
                        } catch (Throwable th4) {
                            th = th4;
                            try {
                                th.getMessage();
                                try {
                                    TKC = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC();
                                    return TKC == null ? null : null;
                                } catch (Throwable th5) {
                                    th5.getMessage();
                                    return null;
                                }
                            } catch (Throwable th6) {
                                try {
                                    com.bytedance.sdk.component.adexpress.Sj.Sj.TKC TKC4 = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC();
                                    if (TKC4 != null && TKC4.dNu()) {
                                        if (renderScript != null) {
                                            RenderScript.releaseAllContexts();
                                        }
                                        if (allocation != null) {
                                            allocation.destroy();
                                        }
                                        if (allocation2 != null) {
                                            allocation2.destroy();
                                        }
                                        if (r22 != 0) {
                                            r22.destroy();
                                        }
                                    }
                                } catch (Throwable th7) {
                                    th7.getMessage();
                                }
                                throw th6;
                            }
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        allocation2 = null;
                    }
                } catch (Throwable th9) {
                    th = th9;
                    allocation = null;
                    allocation2 = null;
                }
            } catch (Throwable th10) {
                th = th10;
                allocation = null;
                r22 = allocation;
                allocation2 = r22;
                th.getMessage();
                TKC = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC();
                if (TKC == null && TKC.dNu()) {
                    if (renderScript != null) {
                        RenderScript.releaseAllContexts();
                    }
                    if (allocation != null) {
                        allocation.destroy();
                    }
                    if (allocation2 != null) {
                        allocation2.destroy();
                    }
                    if (r22 == 0) {
                        return null;
                    }
                    r22.destroy();
                    return null;
                }
            }
        } catch (Throwable th11) {
            th = th11;
            renderScript = null;
            allocation = null;
        }
    }

    public static Bitmap sP(Bitmap bitmap, int i11) {
        ImageReader newInstance;
        RenderEffect createBlurEffect;
        RecordingCanvas beginRecording;
        HardwareRenderer.FrameRenderRequest createRenderRequest;
        HardwareRenderer.FrameRenderRequest waitForPresent;
        HardwareBuffer hardwareBuffer;
        Bitmap wrapHardwareBuffer;
        try {
            if (Build.VERSION.SDK_INT < 31) {
                return Sj(bitmap, i11);
            }
            newInstance = ImageReader.newInstance(bitmap.getWidth(), bitmap.getHeight(), 1, 1, 768L);
            e.a();
            RenderNode a11 = i.a("BlurEffect");
            f.a();
            HardwareRenderer a12 = d.a();
            a12.setSurface(newInstance.getSurface());
            a12.setContentRoot(a11);
            a11.setPosition(0, 0, newInstance.getWidth(), newInstance.getHeight());
            float f11 = i11;
            createBlurEffect = RenderEffect.createBlurEffect(f11, f11, Shader.TileMode.MIRROR);
            a11.setRenderEffect(createBlurEffect);
            beginRecording = a11.beginRecording();
            beginRecording.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            a11.endRecording();
            createRenderRequest = a12.createRenderRequest();
            waitForPresent = createRenderRequest.setWaitForPresent(true);
            waitForPresent.syncAndDraw();
            Image acquireNextImage = newInstance.acquireNextImage();
            hardwareBuffer = acquireNextImage.getHardwareBuffer();
            wrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBuffer, null);
            hardwareBuffer.close();
            acquireNextImage.close();
            newInstance.close();
            a11.discardDisplayList();
            a12.destroy();
            return wrapHardwareBuffer;
        } catch (Throwable th2) {
            th2.getMessage();
            return Sj(bitmap, i11);
        }
    }
}
