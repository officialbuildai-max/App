package com.google.android.exoplayer2.video.spherical;

import android.opengl.GLES20;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.video.spherical.c;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* loaded from: classes3.dex */
final class e {

    /* renamed from: j, reason: collision with root package name */
    private static final float[] f28013j = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: k, reason: collision with root package name */
    private static final float[] f28014k = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: l, reason: collision with root package name */
    private static final float[] f28015l = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: m, reason: collision with root package name */
    private static final float[] f28016m = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: n, reason: collision with root package name */
    private static final float[] f28017n = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    private int f28018a;

    /* renamed from: b, reason: collision with root package name */
    private a f28019b;

    /* renamed from: c, reason: collision with root package name */
    private a f28020c;

    /* renamed from: d, reason: collision with root package name */
    private n f28021d;

    /* renamed from: e, reason: collision with root package name */
    private int f28022e;

    /* renamed from: f, reason: collision with root package name */
    private int f28023f;

    /* renamed from: g, reason: collision with root package name */
    private int f28024g;

    /* renamed from: h, reason: collision with root package name */
    private int f28025h;

    /* renamed from: i, reason: collision with root package name */
    private int f28026i;

    /* loaded from: classes3.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f28027a;

        /* renamed from: b, reason: collision with root package name */
        private final FloatBuffer f28028b;

        /* renamed from: c, reason: collision with root package name */
        private final FloatBuffer f28029c;

        /* renamed from: d, reason: collision with root package name */
        private final int f28030d;

        public a(c.b bVar) {
            this.f28027a = bVar.a();
            this.f28028b = GlUtil.e(bVar.f28011c);
            this.f28029c = GlUtil.e(bVar.f28012d);
            int i11 = bVar.f28010b;
            if (i11 == 1) {
                this.f28030d = 5;
            } else if (i11 != 2) {
                this.f28030d = 4;
            } else {
                this.f28030d = 6;
            }
        }
    }

    public static boolean c(c cVar) {
        c.a aVar = cVar.f28004a;
        c.a aVar2 = cVar.f28005b;
        return aVar.b() == 1 && aVar.a(0).f28009a == 0 && aVar2.b() == 1 && aVar2.a(0).f28009a == 0;
    }

    public void a(int i11, float[] fArr, boolean z10) {
        a aVar = z10 ? this.f28020c : this.f28019b;
        if (aVar == null) {
            return;
        }
        int i12 = this.f28018a;
        GLES20.glUniformMatrix3fv(this.f28023f, 1, false, i12 == 1 ? z10 ? f28015l : f28014k : i12 == 2 ? z10 ? f28017n : f28016m : f28013j, 0);
        GLES20.glUniformMatrix4fv(this.f28022e, 1, false, fArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i11);
        GLES20.glUniform1i(this.f28026i, 0);
        GlUtil.c();
        GLES20.glVertexAttribPointer(this.f28024g, 3, 5126, false, 12, (Buffer) aVar.f28028b);
        GlUtil.c();
        GLES20.glVertexAttribPointer(this.f28025h, 2, 5126, false, 8, (Buffer) aVar.f28029c);
        GlUtil.c();
        GLES20.glDrawArrays(aVar.f28030d, 0, aVar.f28027a);
        GlUtil.c();
    }

    public void b() {
        n nVar = new n("uniform mat4 uMvpMatrix;\nuniform mat3 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTexCoords;\nvarying vec2 vTexCoords;\n// Standard transformation.\nvoid main() {\n  gl_Position = uMvpMatrix * aPosition;\n  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;\n}\n", "// This is required since the texture data is GL_TEXTURE_EXTERNAL_OES.\n#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n// Standard texture rendering shader.\nuniform samplerExternalOES uTexture;\nvarying vec2 vTexCoords;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTexCoords);\n}\n");
        this.f28021d = nVar;
        this.f28022e = nVar.j("uMvpMatrix");
        this.f28023f = this.f28021d.j("uTexMatrix");
        this.f28024g = this.f28021d.e("aPosition");
        this.f28025h = this.f28021d.e("aTexCoords");
        this.f28026i = this.f28021d.j("uTexture");
    }

    public void d(c cVar) {
        if (c(cVar)) {
            this.f28018a = cVar.f28006c;
            a aVar = new a(cVar.f28004a.a(0));
            this.f28019b = aVar;
            if (!cVar.f28007d) {
                aVar = new a(cVar.f28005b.a(0));
            }
            this.f28020c = aVar;
        }
    }
}
