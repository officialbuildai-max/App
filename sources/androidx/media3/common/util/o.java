package androidx.media3.common.util;

import android.opengl.GLES20;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private final int f10501a;

    /* renamed from: b, reason: collision with root package name */
    private final a[] f10502b;

    /* renamed from: c, reason: collision with root package name */
    private final b[] f10503c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f10504d;

    /* renamed from: e, reason: collision with root package name */
    private final Map f10505e;

    /* loaded from: classes2.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f10506a;

        /* renamed from: b, reason: collision with root package name */
        private final int f10507b;

        private a(String str, int i11) {
            this.f10506a = str;
            this.f10507b = i11;
        }

        public static a a(int i11, int i12) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i11, 35722, iArr, 0);
            int i13 = iArr[0];
            byte[] bArr = new byte[i13];
            GLES20.glGetActiveAttrib(i11, i12, i13, new int[1], 0, new int[1], 0, new int[1], 0, bArr, 0);
            String str = new String(bArr, 0, o.h(bArr));
            return new a(str, o.f(i11, str));
        }
    }

    /* loaded from: classes2.dex */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f10508a;

        /* renamed from: b, reason: collision with root package name */
        private final int f10509b;

        /* renamed from: c, reason: collision with root package name */
        private final int f10510c;

        /* renamed from: d, reason: collision with root package name */
        private final float[] f10511d = new float[16];

        /* renamed from: e, reason: collision with root package name */
        private final int[] f10512e = new int[4];

        /* renamed from: f, reason: collision with root package name */
        private int f10513f = 9729;

        private b(String str, int i11, int i12) {
            this.f10508a = str;
            this.f10509b = i11;
            this.f10510c = i12;
        }

        public static b a(int i11, int i12) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i11, 35719, iArr, 0);
            int[] iArr2 = new int[1];
            int i13 = iArr[0];
            byte[] bArr = new byte[i13];
            GLES20.glGetActiveUniform(i11, i12, i13, new int[1], 0, new int[1], 0, iArr2, 0, bArr, 0);
            String str = new String(bArr, 0, o.h(bArr));
            return new b(str, o.i(i11, str), iArr2[0]);
        }
    }

    public o(String str, String str2) {
        int glCreateProgram = GLES20.glCreateProgram();
        this.f10501a = glCreateProgram;
        GlUtil.b();
        d(glCreateProgram, 35633, str);
        d(glCreateProgram, 35632, str2);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        GlUtil.c(iArr[0] == 1, "Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(glCreateProgram));
        GLES20.glUseProgram(glCreateProgram);
        this.f10504d = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35721, iArr2, 0);
        this.f10502b = new a[iArr2[0]];
        for (int i11 = 0; i11 < iArr2[0]; i11++) {
            a a11 = a.a(this.f10501a, i11);
            this.f10502b[i11] = a11;
            this.f10504d.put(a11.f10506a, a11);
        }
        this.f10505e = new HashMap();
        int[] iArr3 = new int[1];
        GLES20.glGetProgramiv(this.f10501a, 35718, iArr3, 0);
        this.f10503c = new b[iArr3[0]];
        for (int i12 = 0; i12 < iArr3[0]; i12++) {
            b a12 = b.a(this.f10501a, i12);
            this.f10503c[i12] = a12;
            this.f10505e.put(a12.f10508a, a12);
        }
        GlUtil.b();
    }

    private static void d(int i11, int i12, String str) {
        int glCreateShader = GLES20.glCreateShader(i12);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        GlUtil.c(iArr[0] == 1, GLES20.glGetShaderInfoLog(glCreateShader) + ", source: \n" + str);
        GLES20.glAttachShader(i11, glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        GlUtil.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(int i11, String str) {
        return GLES20.glGetAttribLocation(i11, str);
    }

    private int g(String str) {
        return f(this.f10501a, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int h(byte[] bArr) {
        for (int i11 = 0; i11 < bArr.length; i11++) {
            if (bArr[i11] == 0) {
                return i11;
            }
        }
        return bArr.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int i(int i11, String str) {
        return GLES20.glGetUniformLocation(i11, str);
    }

    public int e(String str) {
        int g11 = g(str);
        GLES20.glEnableVertexAttribArray(g11);
        GlUtil.b();
        return g11;
    }

    public int j(String str) {
        return i(this.f10501a, str);
    }
}
