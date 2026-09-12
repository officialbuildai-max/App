package androidx.media3.exoplayer.video.spherical;

import android.opengl.GLES20;
import android.util.Log;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.o;
import androidx.media3.exoplayer.video.spherical.c;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* loaded from: classes2.dex */
final class e {

    /* renamed from: j, reason: collision with root package name */
    private static final float[] f13347j = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: k, reason: collision with root package name */
    private static final float[] f13348k = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: l, reason: collision with root package name */
    private static final float[] f13349l = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: m, reason: collision with root package name */
    private static final float[] f13350m = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: n, reason: collision with root package name */
    private static final float[] f13351n = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    private int f13352a;

    /* renamed from: b, reason: collision with root package name */
    private a f13353b;

    /* renamed from: c, reason: collision with root package name */
    private a f13354c;

    /* renamed from: d, reason: collision with root package name */
    private o f13355d;

    /* renamed from: e, reason: collision with root package name */
    private int f13356e;

    /* renamed from: f, reason: collision with root package name */
    private int f13357f;

    /* renamed from: g, reason: collision with root package name */
    private int f13358g;

    /* renamed from: h, reason: collision with root package name */
    private int f13359h;

    /* renamed from: i, reason: collision with root package name */
    private int f13360i;

    /* loaded from: classes2.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f13361a;

        /* renamed from: b, reason: collision with root package name */
        private final FloatBuffer f13362b;

        /* renamed from: c, reason: collision with root package name */
        private final FloatBuffer f13363c;

        /* renamed from: d, reason: collision with root package name */
        private final int f13364d;

        public a(c.b bVar) {
            this.f13361a = bVar.a();
            this.f13362b = GlUtil.e(bVar.f13345c);
            this.f13363c = GlUtil.e(bVar.f13346d);
            int i11 = bVar.f13344b;
            if (i11 == 1) {
                this.f13364d = 5;
            } else if (i11 != 2) {
                this.f13364d = 4;
            } else {
                this.f13364d = 6;
            }
        }
    }

    public static boolean c(c cVar) {
        c.a aVar = cVar.f13338a;
        c.a aVar2 = cVar.f13339b;
        return aVar.b() == 1 && aVar.a(0).f13343a == 0 && aVar2.b() == 1 && aVar2.a(0).f13343a == 0;
    }

    public void a(int i11, float[] fArr, boolean z10) {
        a aVar = z10 ? this.f13354c : this.f13353b;
        if (aVar == null) {
            return;
        }
        int i12 = this.f13352a;
        GLES20.glUniformMatrix3fv(this.f13357f, 1, false, i12 == 1 ? z10 ? f13349l : f13348k : i12 == 2 ? z10 ? f13351n : f13350m : f13347j, 0);
        GLES20.glUniformMatrix4fv(this.f13356e, 1, false, fArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i11);
        GLES20.glUniform1i(this.f13360i, 0);
        try {
            GlUtil.b();
        } catch (GlUtil.GlException e11) {
            Log.e("ProjectionRenderer", "Failed to bind uniforms", e11);
        }
        GLES20.glVertexAttribPointer(this.f13358g, 3, 5126, false, 12, (Buffer) aVar.f13362b);
        try {
            GlUtil.b();
        } catch (GlUtil.GlException e12) {
            Log.e("ProjectionRenderer", "Failed to load position data", e12);
        }
        GLES20.glVertexAttribPointer(this.f13359h, 2, 5126, false, 8, (Buffer) aVar.f13363c);
        try {
            GlUtil.b();
        } catch (GlUtil.GlException e13) {
            Log.e("ProjectionRenderer", "Failed to load texture data", e13);
        }
        GLES20.glDrawArrays(aVar.f13364d, 0, aVar.f13361a);
        try {
            GlUtil.b();
        } catch (GlUtil.GlException e14) {
            Log.e("ProjectionRenderer", "Failed to render", e14);
        }
    }

    public void b() {
        try {
            o oVar = new o("uniform mat4 uMvpMatrix;\nuniform mat3 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTexCoords;\nvarying vec2 vTexCoords;\n// Standard transformation.\nvoid main() {\n  gl_Position = uMvpMatrix * aPosition;\n  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;\n}\n", "// This is required since the texture data is GL_TEXTURE_EXTERNAL_OES.\n#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n// Standard texture rendering shader.\nuniform samplerExternalOES uTexture;\nvarying vec2 vTexCoords;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTexCoords);\n}\n");
            this.f13355d = oVar;
            this.f13356e = oVar.j("uMvpMatrix");
            this.f13357f = this.f13355d.j("uTexMatrix");
            this.f13358g = this.f13355d.e("aPosition");
            this.f13359h = this.f13355d.e("aTexCoords");
            this.f13360i = this.f13355d.j("uTexture");
        } catch (GlUtil.GlException e11) {
            Log.e("ProjectionRenderer", "Failed to initialize the program", e11);
        }
    }

    public void d(c cVar) {
        if (c(cVar)) {
            this.f13352a = cVar.f13340c;
            a aVar = new a(cVar.f13338a.a(0));
            this.f13353b = aVar;
            if (!cVar.f13341d) {
                aVar = new a(cVar.f13339b.a(0));
            }
            this.f13354c = aVar;
        }
    }
}
