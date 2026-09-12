package androidx.compose.ui.graphics;

import android.content.ComponentCallbacks2;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerImpl;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.graphics.layer.view.ViewLayerContainer;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k0 implements a4 {

    /* renamed from: e, reason: collision with root package name */
    public static final a f4531e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static boolean f4532f = true;

    /* renamed from: a, reason: collision with root package name */
    private final ViewGroup f4533a;

    /* renamed from: c, reason: collision with root package name */
    private DrawChildContainer f4535c;

    /* renamed from: b, reason: collision with root package name */
    private final Object f4534b = new Object();

    /* renamed from: d, reason: collision with root package name */
    private final ComponentCallbacks2 f4536d = null;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f4537a = new b();

        private b() {
        }

        @JvmStatic
        public static final long a(View view) {
            long uniqueDrawingId;
            uniqueDrawingId = view.getUniqueDrawingId();
            return uniqueDrawingId;
        }
    }

    public k0(ViewGroup viewGroup) {
        this.f4533a = viewGroup;
    }

    private final long c(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return b.a(view);
        }
        return -1L;
    }

    private final DrawChildContainer d(ViewGroup viewGroup) {
        DrawChildContainer drawChildContainer = this.f4535c;
        if (drawChildContainer != null) {
            return drawChildContainer;
        }
        ViewLayerContainer viewLayerContainer = new ViewLayerContainer(viewGroup.getContext());
        viewGroup.addView(viewLayerContainer);
        this.f4535c = viewLayerContainer;
        return viewLayerContainer;
    }

    @Override // androidx.compose.ui.graphics.a4
    public GraphicsLayer a() {
        GraphicsLayerImpl d0Var;
        GraphicsLayer graphicsLayer;
        synchronized (this.f4534b) {
            try {
                long c11 = c(this.f4533a);
                if (Build.VERSION.SDK_INT >= 29) {
                    d0Var = new androidx.compose.ui.graphics.layer.c0(c11, null, null, 6, null);
                } else if (f4532f) {
                    try {
                        d0Var = new androidx.compose.ui.graphics.layer.e(this.f4533a, c11, null, null, 12, null);
                    } catch (Throwable unused) {
                        f4532f = false;
                        d0Var = new androidx.compose.ui.graphics.layer.d0(d(this.f4533a), c11, null, null, 12, null);
                    }
                } else {
                    d0Var = new androidx.compose.ui.graphics.layer.d0(d(this.f4533a), c11, null, null, 12, null);
                }
                graphicsLayer = new GraphicsLayer(d0Var, null);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return graphicsLayer;
    }

    @Override // androidx.compose.ui.graphics.a4
    public void b(GraphicsLayer graphicsLayer) {
        synchronized (this.f4534b) {
            graphicsLayer.H();
            Unit unit = Unit.f67184a;
        }
    }
}
