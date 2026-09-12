package androidx.compose.ui.graphics.layer;

import androidx.collection.MutableScatterSet;
import androidx.compose.ui.graphics.h4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private GraphicsLayer f4582a;

    /* renamed from: b, reason: collision with root package name */
    private GraphicsLayer f4583b;

    /* renamed from: c, reason: collision with root package name */
    private MutableScatterSet f4584c;

    /* renamed from: d, reason: collision with root package name */
    private MutableScatterSet f4585d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f4586e;

    public static final /* synthetic */ MutableScatterSet a(a aVar) {
        return aVar.f4584c;
    }

    public static final /* synthetic */ GraphicsLayer b(a aVar) {
        return aVar.f4582a;
    }

    public static final /* synthetic */ MutableScatterSet c(a aVar) {
        return aVar.f4585d;
    }

    public static final /* synthetic */ GraphicsLayer d(a aVar) {
        return aVar.f4583b;
    }

    public static final /* synthetic */ void e(a aVar, GraphicsLayer graphicsLayer) {
        aVar.f4582a = graphicsLayer;
    }

    public static final /* synthetic */ void f(a aVar, MutableScatterSet mutableScatterSet) {
        aVar.f4585d = mutableScatterSet;
    }

    public static final /* synthetic */ void g(a aVar, GraphicsLayer graphicsLayer) {
        aVar.f4583b = graphicsLayer;
    }

    public static final /* synthetic */ void h(a aVar, boolean z10) {
        aVar.f4586e = z10;
    }

    public final boolean i(GraphicsLayer graphicsLayer) {
        if (!this.f4586e) {
            h4.a("Only add dependencies during a tracking");
        }
        MutableScatterSet mutableScatterSet = this.f4584c;
        if (mutableScatterSet != null) {
            Intrinsics.e(mutableScatterSet);
            mutableScatterSet.h(graphicsLayer);
        } else if (this.f4582a != null) {
            MutableScatterSet a11 = androidx.collection.w0.a();
            GraphicsLayer graphicsLayer2 = this.f4582a;
            Intrinsics.e(graphicsLayer2);
            a11.h(graphicsLayer2);
            a11.h(graphicsLayer);
            this.f4584c = a11;
            this.f4582a = null;
        } else {
            this.f4582a = graphicsLayer;
        }
        MutableScatterSet mutableScatterSet2 = this.f4585d;
        if (mutableScatterSet2 != null) {
            Intrinsics.e(mutableScatterSet2);
            return !mutableScatterSet2.x(graphicsLayer);
        }
        if (this.f4583b != graphicsLayer) {
            return true;
        }
        this.f4583b = null;
        return false;
    }
}
