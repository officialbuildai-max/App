package androidx.media3.common.util;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.opengl.Matrix;
import android.os.Build;
import com.google.android.gms.gcm.Task;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: classes2.dex */
public abstract class GlUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f10427a = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f10428b = {12352, 4, 12324, 10, 12323, 10, 12322, 10, 12321, 2, 12325, 0, 12326, 0, 12344};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f10429c = {12445, 13120, 12344, 12344};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f10430d = {12445, 13632, 12344, 12344};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f10431e = {12344};

    /* loaded from: classes2.dex */
    public static final class GlException extends Exception {
        public GlException(String str) {
            super(str);
        }
    }

    public static void a(int i11, int i12, int i13) {
        GLES20.glBindTexture(i11, i12);
        b();
        GLES20.glTexParameteri(i11, Task.EXTRAS_LIMIT_BYTES, i13);
        b();
        GLES20.glTexParameteri(i11, 10241, i13);
        b();
        GLES20.glTexParameteri(i11, 10242, 33071);
        b();
        GLES20.glTexParameteri(i11, 10243, 33071);
        b();
    }

    public static void b() {
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = false;
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                break;
            }
            if (z10) {
                sb2.append('\n');
            }
            String gluErrorString = GLU.gluErrorString(glGetError);
            if (gluErrorString == null) {
                gluErrorString = "error code: 0x" + Integer.toHexString(glGetError);
            }
            sb2.append("glError: ");
            sb2.append(gluErrorString);
            z10 = true;
        }
        if (z10) {
            throw new GlException(sb2.toString());
        }
    }

    public static void c(boolean z10, String str) {
        if (!z10) {
            throw new GlException(str);
        }
    }

    private static FloatBuffer d(int i11) {
        return ByteBuffer.allocateDirect(i11 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static FloatBuffer e(float[] fArr) {
        return (FloatBuffer) d(fArr.length).put(fArr).flip();
    }

    public static int f() {
        int g11 = g();
        a(36197, g11, 9729);
        return g11;
    }

    public static int g() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        b();
        return iArr[0];
    }

    private static boolean h(String str) {
        String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
        return eglQueryString != null && eglQueryString.contains(str);
    }

    public static boolean i(Context context) {
        int i11 = a1.f10432a;
        if (i11 < 24) {
            return false;
        }
        if (i11 < 26 && ("samsung".equals(Build.MANUFACTURER) || "XT1650".equals(Build.MODEL))) {
            return false;
        }
        if (i11 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
            return h("EGL_EXT_protected_content");
        }
        return false;
    }

    public static boolean j() {
        return h("EGL_KHR_surfaceless_context");
    }

    public static void k(float[] fArr) {
        Matrix.setIdentityM(fArr, 0);
    }
}
