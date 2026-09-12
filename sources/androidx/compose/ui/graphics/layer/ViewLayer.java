package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.compose.ui.graphics.m1;
import androidx.compose.ui.graphics.n1;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b'\b\u0000\u0018\u0000 J2\u00020\u0001:\u0001(B#\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ@\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0002\b\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u001fH\u0014¢\u0006\u0004\b!\u0010\"J7\u0010)\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020$H\u0014¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0016H\u0016¢\u0006\u0004\b+\u0010\u001cR\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b(\u00100\u001a\u0004\b1\u00102R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\"\u00107\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R*\u0010A\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u000b8\u0000@@X\u0080\u000e¢\u0006\u0012\n\u0004\b>\u00106\u001a\u0004\b?\u0010\u001e\"\u0004\b@\u00109R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER'\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0002\b\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006K"}, d2 = {"Landroidx/compose/ui/graphics/layer/ViewLayer;", "Landroid/view/View;", "ownerView", "Landroidx/compose/ui/graphics/n1;", "canvasHolder", "Lz/a;", "canvasDrawScope", "<init>", "(Landroid/view/View;Landroidx/compose/ui/graphics/n1;Lz/a;)V", "Landroid/graphics/Outline;", "outline", "", "setLayerOutline", "(Landroid/graphics/Outline;)Z", "Lo0/e;", "density", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentLayer", "Lkotlin/Function1;", "Lz/g;", "", "Lkotlin/ExtensionFunctionType;", "drawBlock", "setDrawParams", "(Lo0/e;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/jvm/functions/Function1;)V", "invalidate", "()V", "hasOverlappingRendering", "()Z", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "changed", "", "l", "t", CampaignEx.JSON_KEY_AD_R, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "onLayout", "(ZIIII)V", "forceLayout", "a", "Landroid/view/View;", "getOwnerView", "()Landroid/view/View;", "Landroidx/compose/ui/graphics/n1;", "getCanvasHolder", "()Landroidx/compose/ui/graphics/n1;", "c", "Lz/a;", "d", "Z", "isInvalidated", "setInvalidated", "(Z)V", "e", "Landroid/graphics/Outline;", "layerOutline", AppMeasurementSdk.ConditionalUserProperty.VALUE, "f", "getCanUseCompositingLayer$ui_graphics_release", "setCanUseCompositingLayer$ui_graphics_release", "canUseCompositingLayer", be.g.f16474b, "Lo0/e;", "h", "Landroidx/compose/ui/unit/LayoutDirection;", "i", "Lkotlin/jvm/functions/Function1;", com.mbridge.msdk.foundation.same.report.j.f35620b, "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ViewLayer extends View {

    /* renamed from: k, reason: collision with root package name */
    private static final ViewOutlineProvider f4571k = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final View ownerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final n1 canvasHolder;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final z.a canvasDrawScope;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isInvalidated;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Outline layerOutline;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean canUseCompositingLayer;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private o0.e density;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LayoutDirection layoutDirection;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Function1 drawBlock;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private GraphicsLayer parentLayer;

    /* loaded from: classes.dex */
    public static final class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Outline outline2;
            if (!(view instanceof ViewLayer) || (outline2 = ((ViewLayer) view).layerOutline) == null) {
                return;
            }
            outline.set(outline2);
        }
    }

    public ViewLayer(View view, n1 n1Var, z.a aVar) {
        super(view.getContext());
        this.ownerView = view;
        this.canvasHolder = n1Var;
        this.canvasDrawScope = aVar;
        setOutlineProvider(f4571k);
        this.canUseCompositingLayer = true;
        this.density = z.e.a();
        this.layoutDirection = LayoutDirection.Ltr;
        this.drawBlock = GraphicsLayerImpl.f4568a.a();
        setWillNotDraw(false);
        setClipBounds(null);
    }

    public /* synthetic */ ViewLayer(View view, n1 n1Var, z.a aVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, (i11 & 2) != 0 ? new n1() : n1Var, (i11 & 4) != 0 ? new z.a() : aVar);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        n1 n1Var = this.canvasHolder;
        Canvas v11 = n1Var.a().v();
        n1Var.a().w(canvas);
        androidx.compose.ui.graphics.g0 a11 = n1Var.a();
        z.a aVar = this.canvasDrawScope;
        o0.e eVar = this.density;
        LayoutDirection layoutDirection = this.layoutDirection;
        long a12 = y.n.a(getWidth(), getHeight());
        GraphicsLayer graphicsLayer = this.parentLayer;
        Function1 function1 = this.drawBlock;
        o0.e density = aVar.H0().getDensity();
        LayoutDirection layoutDirection2 = aVar.H0().getLayoutDirection();
        m1 e11 = aVar.H0().e();
        long i11 = aVar.H0().i();
        GraphicsLayer g11 = aVar.H0().g();
        z.d H0 = aVar.H0();
        H0.b(eVar);
        H0.a(layoutDirection);
        H0.h(a11);
        H0.f(a12);
        H0.d(graphicsLayer);
        a11.n();
        try {
            function1.invoke(aVar);
            a11.j();
            z.d H02 = aVar.H0();
            H02.b(density);
            H02.a(layoutDirection2);
            H02.h(e11);
            H02.f(i11);
            H02.d(g11);
            n1Var.a().w(v11);
            this.isInvalidated = false;
        } catch (Throwable th2) {
            a11.j();
            z.d H03 = aVar.H0();
            H03.b(density);
            H03.a(layoutDirection2);
            H03.h(e11);
            H03.f(i11);
            H03.d(g11);
            throw th2;
        }
    }

    @Override // android.view.View
    public void forceLayout() {
    }

    /* renamed from: getCanUseCompositingLayer$ui_graphics_release, reason: from getter */
    public final boolean getCanUseCompositingLayer() {
        return this.canUseCompositingLayer;
    }

    public final n1 getCanvasHolder() {
        return this.canvasHolder;
    }

    public final View getOwnerView() {
        return this.ownerView;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.canUseCompositingLayer;
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.isInvalidated) {
            return;
        }
        this.isInvalidated = true;
        super.invalidate();
    }

    /* renamed from: isInvalidated, reason: from getter */
    public final boolean getIsInvalidated() {
        return this.isInvalidated;
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int l11, int t11, int r11, int b11) {
    }

    public final void setCanUseCompositingLayer$ui_graphics_release(boolean z10) {
        if (this.canUseCompositingLayer != z10) {
            this.canUseCompositingLayer = z10;
            invalidate();
        }
    }

    public final void setDrawParams(o0.e density, LayoutDirection layoutDirection, GraphicsLayer parentLayer, Function1<? super z.g, Unit> drawBlock) {
        this.density = density;
        this.layoutDirection = layoutDirection;
        this.drawBlock = drawBlock;
        this.parentLayer = parentLayer;
    }

    public final void setInvalidated(boolean z10) {
        this.isInvalidated = z10;
    }

    public final boolean setLayerOutline(Outline outline) {
        this.layerOutline = outline;
        return j0.f4671a.a(this);
    }
}
