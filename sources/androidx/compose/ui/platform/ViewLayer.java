package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.e5;
import androidx.compose.ui.graphics.i4;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.v4;
import androidx.compose.ui.graphics.w3;
import androidx.compose.ui.graphics.x4;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.push.PushConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0000\u0018\u0000 \u008b\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0015TB_\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00128\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010#\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001a\u0010(\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020$H\u0016ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u001a\u0010+\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020)H\u0016ø\u0001\u0000¢\u0006\u0004\b*\u0010'J!\u0010,\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020.H\u0014¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u000fH\u0016¢\u0006\u0004\b1\u0010\u0016J7\u00107\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u001c2\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u0002032\u0006\u00106\u001a\u0002032\u0006\u0010\u0015\u001a\u000203H\u0014¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u000fH\u0016¢\u0006\u0004\b9\u0010\u0016J\u000f\u0010:\u001a\u00020\u000fH\u0016¢\u0006\u0004\b:\u0010\u0016J\u000f\u0010;\u001a\u00020\u000fH\u0016¢\u0006\u0004\b;\u0010\u0016J\"\u0010@\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020\u001cH\u0016ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u001f\u0010C\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020A2\u0006\u0010=\u001a\u00020\u001cH\u0016¢\u0006\u0004\bC\u0010DJW\u0010E\u001a\u00020\u000f28\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011H\u0016¢\u0006\u0004\bE\u0010FJ\u001a\u0010K\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020GH\u0016ø\u0001\u0000¢\u0006\u0004\bI\u0010JJ\u001a\u0010M\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020GH\u0016ø\u0001\u0000¢\u0006\u0004\bL\u0010JR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010N\u001a\u0004\bO\u0010PR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0015\u0010Q\u001a\u0004\bR\u0010SRJ\u0010\u0010\u001a6\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010^\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010b\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR*\u0010e\u001a\u00020\u001c2\u0006\u0010c\u001a\u00020\u001c8\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010]\u001a\u0004\be\u0010\u001e\"\u0004\bf\u0010gR\u0016\u0010i\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010]R\u0014\u0010m\u001a\u00020j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u001a\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00010n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u001c\u0010t\u001a\u00020r8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b4\u0010sR\u0016\u0010v\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010]R\u001a\u0010{\u001a\u00020w8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bx\u0010s\u001a\u0004\by\u0010zR\u0016\u0010~\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u0019\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u007f8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0016\u0010\u0084\u0001\u001a\u00020w8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010zR+\u0010\u008a\u0001\u001a\u00030\u0085\u00012\u0007\u0010c\u001a\u00030\u0085\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u008c\u0001"}, d2 = {"Landroidx/compose/ui/platform/ViewLayer;", "Landroid/view/View;", "Landroidx/compose/ui/node/w0;", "", "Landroidx/compose/ui/platform/AndroidComposeView;", "ownerView", "Landroidx/compose/ui/platform/DrawChildContainer;", "container", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/m1;", "Lkotlin/ParameterName;", "name", "canvas", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentLayer", "", "drawBlock", "Lkotlin/Function0;", "invalidateParentLayer", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/ui/platform/DrawChildContainer;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()V", "a", "Landroidx/compose/ui/graphics/x4;", "scope", "updateLayerProperties", "(Landroidx/compose/ui/graphics/x4;)V", "", "hasOverlappingRendering", "()Z", "Ly/g;", RequestParameters.POSITION, "isInLayer-k-4lQ0M", "(J)Z", "isInLayer", "Lo0/t;", "size", "resize-ozmzZPI", "(J)V", "resize", "Lo0/p;", "move--gyyYBs", "move", "drawLayer", "(Landroidx/compose/ui/graphics/m1;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "Landroid/graphics/Canvas;", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "invalidate", "changed", "", "l", "t", CampaignEx.JSON_KEY_AD_R, "onLayout", "(ZIIII)V", PushConstants.PROVIDER_FIELD_DESTROY, "updateDisplayList", "forceLayout", "point", "inverse", "mapOffset-8S9VItk", "(JZ)J", "mapOffset", "Ly/e;", "rect", "mapBounds", "(Ly/e;Z)V", "reuseLayer", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "Landroidx/compose/ui/graphics/i4;", "matrix", "transform-58bKbWc", "([F)V", "transform", "inverseTransform-58bKbWc", "inverseTransform", "Landroidx/compose/ui/platform/AndroidComposeView;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "Landroidx/compose/ui/platform/DrawChildContainer;", "getContainer", "()Landroidx/compose/ui/platform/DrawChildContainer;", "c", "Lkotlin/jvm/functions/Function2;", "d", "Lkotlin/jvm/functions/Function0;", "Landroidx/compose/ui/platform/i1;", "e", "Landroidx/compose/ui/platform/i1;", "outlineResolver", "f", "Z", "clipToBounds", "Landroid/graphics/Rect;", be.g.f16474b, "Landroid/graphics/Rect;", "clipBoundsCache", AppMeasurementSdk.ConditionalUserProperty.VALUE, "h", "isInvalidated", "setInvalidated", "(Z)V", "i", "drawnWithZ", "Landroidx/compose/ui/graphics/n1;", com.mbridge.msdk.foundation.same.report.j.f35620b, "Landroidx/compose/ui/graphics/n1;", "canvasHolder", "Landroidx/compose/ui/platform/d1;", CampaignEx.JSON_KEY_AD_K, "Landroidx/compose/ui/platform/d1;", "matrixCache", "Landroidx/compose/ui/graphics/e5;", "J", "mTransformOrigin", "m", "mHasOverlappingRendering", "", "n", "getLayerId", "()J", "layerId", "o", "I", "mutatedFields", "Landroidx/compose/ui/graphics/Path;", "getManualClipPath", "()Landroidx/compose/ui/graphics/Path;", "manualClipPath", "getOwnerViewId", "ownerViewId", "", "getCameraDistancePx", "()F", "setCameraDistancePx", "(F)V", "cameraDistancePx", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ViewLayer extends View implements androidx.compose.ui.node.w0 {

    /* renamed from: r, reason: collision with root package name */
    private static Method f5762r;

    /* renamed from: s, reason: collision with root package name */
    private static Field f5763s;

    /* renamed from: t, reason: collision with root package name */
    private static boolean f5764t;

    /* renamed from: u, reason: collision with root package name */
    private static boolean f5765u;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AndroidComposeView ownerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final DrawChildContainer container;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Function2 drawBlock;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Function0 invalidateParentLayer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final i1 outlineResolver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean clipToBounds;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Rect clipBoundsCache;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isInvalidated;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean drawnWithZ;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final androidx.compose.ui.graphics.n1 canvasHolder;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final d1 matrixCache;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private long mTransformOrigin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mHasOverlappingRendering;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final long layerId;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int mutatedFields;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* renamed from: p, reason: collision with root package name */
    private static final Function2 f5760p = new Function2<View, Matrix, Unit>() { // from class: androidx.compose.ui.platform.ViewLayer$Companion$getMatrix$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((View) obj, (Matrix) obj2);
            return Unit.f67184a;
        }

        public final void invoke(View view, Matrix matrix) {
            matrix.set(view.getMatrix());
        }
    };

    /* renamed from: q, reason: collision with root package name */
    private static final ViewOutlineProvider f5761q = new a();

    /* loaded from: classes.dex */
    public static final class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Intrinsics.f(view, "null cannot be cast to non-null type androidx.compose.ui.platform.ViewLayer");
            Outline b11 = ((ViewLayer) view).outlineResolver.b();
            Intrinsics.e(b11);
            outline.set(b11);
        }
    }

    /* renamed from: androidx.compose.ui.platform.ViewLayer$b, reason: from kotlin metadata */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return ViewLayer.f5764t;
        }

        public final boolean b() {
            return ViewLayer.f5765u;
        }

        public final void c(boolean z10) {
            ViewLayer.f5765u = z10;
        }

        public final void d(View view) {
            try {
                if (!a()) {
                    ViewLayer.f5764t = true;
                    if (Build.VERSION.SDK_INT < 28) {
                        ViewLayer.f5762r = View.class.getDeclaredMethod("updateDisplayListIfDirty", null);
                        ViewLayer.f5763s = View.class.getDeclaredField("mRecreateDisplayList");
                    } else {
                        ViewLayer.f5762r = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, new Class[0].getClass()).invoke(View.class, "updateDisplayListIfDirty", new Class[0]);
                        ViewLayer.f5763s = (Field) Class.class.getDeclaredMethod("getDeclaredField", String.class).invoke(View.class, "mRecreateDisplayList");
                    }
                    Method method = ViewLayer.f5762r;
                    if (method != null) {
                        method.setAccessible(true);
                    }
                    Field field = ViewLayer.f5763s;
                    if (field != null) {
                        field.setAccessible(true);
                    }
                }
                Field field2 = ViewLayer.f5763s;
                if (field2 != null) {
                    field2.setBoolean(view, true);
                }
                Method method2 = ViewLayer.f5762r;
                if (method2 != null) {
                    method2.invoke(view, null);
                }
            } catch (Throwable unused) {
                c(true);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final c f5781a = new c();

        private c() {
        }

        @JvmStatic
        public static final long a(View view) {
            long uniqueDrawingId;
            uniqueDrawingId = view.getUniqueDrawingId();
            return uniqueDrawingId;
        }
    }

    public ViewLayer(AndroidComposeView androidComposeView, DrawChildContainer drawChildContainer, Function2<? super androidx.compose.ui.graphics.m1, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0) {
        super(androidComposeView.getContext());
        this.ownerView = androidComposeView;
        this.container = drawChildContainer;
        this.drawBlock = function2;
        this.invalidateParentLayer = function0;
        this.outlineResolver = new i1();
        this.canvasHolder = new androidx.compose.ui.graphics.n1();
        this.matrixCache = new d1(f5760p);
        this.mTransformOrigin = e5.f4511a.a();
        this.mHasOverlappingRendering = true;
        setWillNotDraw(false);
        drawChildContainer.addView(this);
        this.layerId = View.generateViewId();
    }

    private final void a() {
        Rect rect;
        if (this.clipToBounds) {
            Rect rect2 = this.clipBoundsCache;
            if (rect2 == null) {
                this.clipBoundsCache = new Rect(0, 0, getWidth(), getHeight());
            } else {
                Intrinsics.e(rect2);
                rect2.set(0, 0, getWidth(), getHeight());
            }
            rect = this.clipBoundsCache;
        } else {
            rect = null;
        }
        setClipBounds(rect);
    }

    private final void b() {
        setOutlineProvider(this.outlineResolver.b() != null ? f5761q : null);
    }

    private final Path getManualClipPath() {
        if (!getClipToOutline() || this.outlineResolver.e()) {
            return null;
        }
        return this.outlineResolver.d();
    }

    private final void setInvalidated(boolean z10) {
        if (z10 != this.isInvalidated) {
            this.isInvalidated = z10;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z10);
        }
    }

    @Override // androidx.compose.ui.node.w0
    public void destroy() {
        setInvalidated(false);
        this.ownerView.requestClearInvalidObservations();
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.ownerView.recycle$ui_release(this);
        this.container.removeViewInLayout(this);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        boolean z10;
        androidx.compose.ui.graphics.n1 n1Var = this.canvasHolder;
        Canvas v11 = n1Var.a().v();
        n1Var.a().w(canvas);
        androidx.compose.ui.graphics.g0 a11 = n1Var.a();
        if (getManualClipPath() == null && canvas.isHardwareAccelerated()) {
            z10 = false;
        } else {
            a11.n();
            this.outlineResolver.a(a11);
            z10 = true;
        }
        Function2 function2 = this.drawBlock;
        if (function2 != null) {
            function2.invoke(a11, null);
        }
        if (z10) {
            a11.j();
        }
        n1Var.a().w(v11);
        setInvalidated(false);
    }

    @Override // androidx.compose.ui.node.w0
    public void drawLayer(androidx.compose.ui.graphics.m1 canvas, GraphicsLayer parentLayer) {
        boolean z10 = getElevation() > 0.0f;
        this.drawnWithZ = z10;
        if (z10) {
            canvas.k();
        }
        this.container.drawChild$ui_release(canvas, this, getDrawingTime());
        if (this.drawnWithZ) {
            canvas.o();
        }
    }

    @Override // android.view.View
    public void forceLayout() {
    }

    public final float getCameraDistancePx() {
        return getCameraDistance() / getResources().getDisplayMetrics().densityDpi;
    }

    public final DrawChildContainer getContainer() {
        return this.container;
    }

    public long getLayerId() {
        return this.layerId;
    }

    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    public long getOwnerViewId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return c.a(this.ownerView);
        }
        return -1L;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.mHasOverlappingRendering;
    }

    @Override // android.view.View, androidx.compose.ui.node.w0
    public void invalidate() {
        if (this.isInvalidated) {
            return;
        }
        setInvalidated(true);
        super.invalidate();
        this.ownerView.invalidate();
    }

    /* renamed from: inverseTransform-58bKbWc, reason: not valid java name */
    public void m163inverseTransform58bKbWc(float[] matrix) {
        float[] a11 = this.matrixCache.a(this);
        if (a11 != null) {
            i4.n(matrix, a11);
        }
    }

    @Override // androidx.compose.ui.node.w0
    /* renamed from: isInLayer-k-4lQ0M */
    public boolean mo138isInLayerk4lQ0M(long position) {
        float m11 = y.g.m(position);
        float n11 = y.g.n(position);
        if (this.clipToBounds) {
            return 0.0f <= m11 && m11 < ((float) getWidth()) && 0.0f <= n11 && n11 < ((float) getHeight());
        }
        if (getClipToOutline()) {
            return this.outlineResolver.f(position);
        }
        return true;
    }

    /* renamed from: isInvalidated, reason: from getter */
    public final boolean getIsInvalidated() {
        return this.isInvalidated;
    }

    @Override // androidx.compose.ui.node.w0
    public void mapBounds(y.e rect, boolean inverse) {
        if (!inverse) {
            i4.g(this.matrixCache.b(this), rect);
            return;
        }
        float[] a11 = this.matrixCache.a(this);
        if (a11 != null) {
            i4.g(a11, rect);
        } else {
            rect.g(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    @Override // androidx.compose.ui.node.w0
    /* renamed from: mapOffset-8S9VItk */
    public long mo139mapOffset8S9VItk(long point, boolean inverse) {
        if (!inverse) {
            return i4.f(this.matrixCache.b(this), point);
        }
        float[] a11 = this.matrixCache.a(this);
        return a11 != null ? i4.f(a11, point) : y.g.f78593b.a();
    }

    @Override // androidx.compose.ui.node.w0
    /* renamed from: move--gyyYBs */
    public void mo140movegyyYBs(long position) {
        int h11 = o0.p.h(position);
        if (h11 != getLeft()) {
            offsetLeftAndRight(h11 - getLeft());
            this.matrixCache.c();
        }
        int i11 = o0.p.i(position);
        if (i11 != getTop()) {
            offsetTopAndBottom(i11 - getTop());
            this.matrixCache.c();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int l11, int t11, int r11, int b11) {
    }

    @Override // androidx.compose.ui.node.w0
    /* renamed from: resize-ozmzZPI */
    public void mo141resizeozmzZPI(long size) {
        int g11 = o0.t.g(size);
        int f11 = o0.t.f(size);
        if (g11 == getWidth() && f11 == getHeight()) {
            return;
        }
        setPivotX(e5.d(this.mTransformOrigin) * g11);
        setPivotY(e5.e(this.mTransformOrigin) * f11);
        b();
        layout(getLeft(), getTop(), getLeft() + g11, getTop() + f11);
        a();
        this.matrixCache.c();
    }

    @Override // androidx.compose.ui.node.w0
    public void reuseLayer(Function2<? super androidx.compose.ui.graphics.m1, ? super GraphicsLayer, Unit> drawBlock, Function0<Unit> invalidateParentLayer) {
        this.container.addView(this);
        this.clipToBounds = false;
        this.drawnWithZ = false;
        this.mTransformOrigin = e5.f4511a.a();
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
    }

    public final void setCameraDistancePx(float f11) {
        setCameraDistance(f11 * getResources().getDisplayMetrics().densityDpi);
    }

    /* renamed from: transform-58bKbWc, reason: not valid java name */
    public void m164transform58bKbWc(float[] matrix) {
        i4.n(matrix, this.matrixCache.b(this));
    }

    @Override // androidx.compose.ui.node.w0
    public void updateDisplayList() {
        if (!this.isInvalidated || f5765u) {
            return;
        }
        INSTANCE.d(this);
        setInvalidated(false);
    }

    @Override // androidx.compose.ui.node.w0
    public void updateLayerProperties(x4 scope) {
        Function0 function0;
        int F = scope.F() | this.mutatedFields;
        if ((F & 4096) != 0) {
            long b02 = scope.b0();
            this.mTransformOrigin = b02;
            setPivotX(e5.d(b02) * getWidth());
            setPivotY(e5.e(this.mTransformOrigin) * getHeight());
        }
        if ((F & 1) != 0) {
            setScaleX(scope.t());
        }
        if ((F & 2) != 0) {
            setScaleY(scope.A());
        }
        if ((F & 4) != 0) {
            setAlpha(scope.n());
        }
        if ((F & 8) != 0) {
            setTranslationX(scope.x());
        }
        if ((F & 16) != 0) {
            setTranslationY(scope.w());
        }
        if ((F & 32) != 0) {
            setElevation(scope.L());
        }
        if ((F & 1024) != 0) {
            setRotation(scope.o());
        }
        if ((F & 256) != 0) {
            setRotationX(scope.y());
        }
        if ((F & 512) != 0) {
            setRotationY(scope.m());
        }
        if ((F & 2048) != 0) {
            setCameraDistancePx(scope.q());
        }
        boolean z10 = false;
        boolean z11 = getManualClipPath() != null;
        boolean z12 = scope.z() && scope.M() != v4.a();
        if ((F & 24576) != 0) {
            this.clipToBounds = scope.z() && scope.M() == v4.a();
            a();
            setClipToOutline(z12);
        }
        boolean h11 = this.outlineResolver.h(scope.G(), scope.n(), z12, scope.L(), scope.i());
        if (this.outlineResolver.c()) {
            b();
        }
        boolean z13 = getManualClipPath() != null;
        if (z11 != z13 || (z13 && h11)) {
            invalidate();
        }
        if (!this.drawnWithZ && getElevation() > 0.0f && (function0 = this.invalidateParentLayer) != null) {
            function0.invoke();
        }
        if ((F & 7963) != 0) {
            this.matrixCache.c();
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            if ((F & 64) != 0) {
                p2.f5926a.a(this, androidx.compose.ui.graphics.w1.j(scope.v()));
            }
            if ((F & 128) != 0) {
                p2.f5926a.b(this, androidx.compose.ui.graphics.w1.j(scope.O()));
            }
        }
        if (i11 >= 31 && (131072 & F) != 0) {
            q2 q2Var = q2.f5928a;
            scope.I();
            q2Var.a(this, null);
        }
        if ((F & 32768) != 0) {
            int B = scope.B();
            w3.a aVar = w3.f4949a;
            if (w3.e(B, aVar.c())) {
                setLayerType(2, null);
            } else if (w3.e(B, aVar.b())) {
                setLayerType(0, null);
                this.mHasOverlappingRendering = z10;
            } else {
                setLayerType(0, null);
            }
            z10 = true;
            this.mHasOverlappingRendering = z10;
        }
        this.mutatedFields = scope.F();
    }
}
