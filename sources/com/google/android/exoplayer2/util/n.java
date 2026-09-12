package com.google.android.exoplayer2.util;

import android.opengl.GLES20;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private final int f27664a;

    /* renamed from: b, reason: collision with root package name */
    private final a[] f27665b;

    /* renamed from: c, reason: collision with root package name */
    private final b[] f27666c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f27667d;

    /* renamed from: e, reason: collision with root package name */
    private final Map f27668e;

    /* loaded from: classes3.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f27669a;

        /* renamed from: b, reason: collision with root package name */
        private final int f27670b;

        /* renamed from: c, reason: collision with root package name */
        private final int f27671c;

        private a(String str, int i11, int i12) {
            this.f27669a = str;
            this.f27670b = i11;
            this.f27671c = i12;
        }

        public static a a(int i11, int i12) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i11, 35722, iArr, 0);
            int i13 = iArr[0];
            byte[] bArr = new byte[i13];
            GLES20.glGetActiveAttrib(i11, i12, i13, new int[1], 0, new int[1], 0, new int[1], 0, bArr, 0);
            String str = new String(bArr, 0, n.h(bArr));
            return new a(str, i12, n.f(i11, str));
        }
    }

    /* loaded from: classes3.dex */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f27672a;

        /* renamed from: b, reason: collision with root package name */
        private final int f27673b;

        /* renamed from: c, reason: collision with root package name */
        private final int f27674c;

        /* renamed from: d, reason: collision with root package name */
        private final float[] f27675d = new float[16];

        private b(String str, int i11, int i12) {
            this.f27672a = str;
            this.f27673b = i11;
            this.f27674c = i12;
        }

        public static b a(int i11, int i12) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i11, 35719, iArr, 0);
            int[] iArr2 = new int[1];
            int i13 = iArr[0];
            byte[] bArr = new byte[i13];
            GLES20.glGetActiveUniform(i11, i12, i13, new int[1], 0, new int[1], 0, iArr2, 0, bArr, 0);
            String str = new String(bArr, 0, n.h(bArr));
            return new b(str, n.i(i11, str), iArr2[0]);
        }
    }

    public n(String str, String str2) {
        int glCreateProgram = GLES20.glCreateProgram();
        this.f27664a = glCreateProgram;
        GlUtil.c();
        d(glCreateProgram, 35633, str);
        d(glCreateProgram, 35632, str2);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            GlUtil.j("Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(glCreateProgram));
        }
        GLES20.glUseProgram(glCreateProgram);
        this.f27667d = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35721, iArr2, 0);
        this.f27665b = new a[iArr2[0]];
        for (int i11 = 0; i11 < iArr2[0]; i11++) {
            a a11 = a.a(this.f27664a, i11);
            this.f27665b[i11] = a11;
            this.f27667d.put(a11.f27669a, a11);
        }
        this.f27668e = new HashMap();
        int[] iArr3 = new int[1];
        GLES20.glGetProgramiv(this.f27664a, 35718, iArr3, 0);
        this.f27666c = new b[iArr3[0]];
        for (int i12 = 0; i12 < iArr3[0]; i12++) {
            b a12 = b.a(this.f27664a, i12);
            this.f27666c[i12] = a12;
            this.f27668e.put(a12.f27672a, a12);
        }
        GlUtil.c();
    }

    private static void d(int i11, int i12, String str) {
        int glCreateShader = GLES20.glCreateShader(i12);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            GlUtil.j(GLES20.glGetShaderInfoLog(glCreateShader) + ", source: " + str);
        }
        GLES20.glAttachShader(i11, glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        GlUtil.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(int i11, String str) {
        return GLES20.glGetAttribLocation(i11, str);
    }

    private int g(String str) {
        return f(this.f27664a, str);
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
        GlUtil.c();
        return g11;
    }

    public int j(String str) {
        return i(this.f27664a, str);
    }
}
