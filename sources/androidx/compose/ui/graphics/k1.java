package androidx.compose.ui.graphics;

import android.graphics.Shader;

/* loaded from: classes.dex */
public abstract class k1 {

    /* loaded from: classes.dex */
    public static final class a extends y4 {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Shader f4538e;

        a(Shader shader) {
            this.f4538e = shader;
        }

        @Override // androidx.compose.ui.graphics.y4
        public Shader b(long j11) {
            return this.f4538e;
        }
    }

    public static final y4 a(Shader shader) {
        return new a(shader);
    }
}
