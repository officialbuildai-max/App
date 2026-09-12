package androidx.compose.foundation.layout;

/* loaded from: classes.dex */
public abstract class v {
    public static final m a(z zVar) {
        if (zVar != null) {
            return zVar.a();
        }
        return null;
    }

    public static final boolean b(z zVar) {
        if (zVar != null) {
            return zVar.b();
        }
        return true;
    }

    public static final z c(androidx.compose.ui.layout.i iVar) {
        Object G = iVar.G();
        if (G instanceof z) {
            return (z) G;
        }
        return null;
    }

    public static final z d(androidx.compose.ui.layout.g0 g0Var) {
        Object G = g0Var.G();
        if (G instanceof z) {
            return (z) G;
        }
        return null;
    }

    public static final float e(z zVar) {
        if (zVar != null) {
            return zVar.d();
        }
        return 0.0f;
    }

    public static final boolean f(z zVar) {
        m a11 = a(zVar);
        if (a11 != null) {
            return a11.c();
        }
        return false;
    }
}
