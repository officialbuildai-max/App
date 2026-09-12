package androidx.compose.ui.window;

import android.R;
import android.graphics.Outline;
import android.os.Build;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import androidx.activity.q;
import androidx.activity.u;
import androidx.activity.w;
import androidx.compose.runtime.m;
import androidx.compose.ui.R$id;
import androidx.compose.ui.R$style;
import androidx.compose.ui.platform.s2;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.WindowCompat;
import androidx.view.ViewTreeLifecycleOwner;
import androidx.view.ViewTreeSavedStateRegistryOwner;
import androidx.view.ViewTreeViewModelStoreOwner;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class DialogWrapper extends q implements s2 {

    /* renamed from: a, reason: collision with root package name */
    private Function0 f6605a;

    /* renamed from: b, reason: collision with root package name */
    private c f6606b;

    /* renamed from: c, reason: collision with root package name */
    private final View f6607c;

    /* renamed from: d, reason: collision with root package name */
    private final DialogLayout f6608d;

    /* renamed from: e, reason: collision with root package name */
    private final float f6609e;

    /* renamed from: f, reason: collision with root package name */
    private final int f6610f;

    /* loaded from: classes.dex */
    public static final class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRect(0, 0, view.getWidth(), view.getHeight());
            outline.setAlpha(0.0f);
        }
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6611a;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f6611a = iArr;
        }
    }

    public DialogWrapper(Function0 function0, c cVar, View view, LayoutDirection layoutDirection, o0.e eVar, UUID uuid) {
        super(new ContextThemeWrapper(view.getContext(), (Build.VERSION.SDK_INT >= 31 || cVar.a()) ? R$style.DialogWindowTheme : R$style.FloatingDialogWindowTheme), 0, 2, null);
        this.f6605a = function0;
        this.f6606b = cVar;
        this.f6607c = view;
        float g11 = o0.i.g(8);
        this.f6609e = g11;
        Window window = getWindow();
        if (window == null) {
            throw new IllegalStateException("Dialog has no window");
        }
        this.f6610f = window.getAttributes().softInputMode & 240;
        window.requestFeature(1);
        window.setBackgroundDrawableResource(R.color.transparent);
        WindowCompat.setDecorFitsSystemWindows(window, this.f6606b.a());
        DialogLayout dialogLayout = new DialogLayout(getContext(), window);
        dialogLayout.setTag(R$id.compose_view_saveable_id_tag, "Dialog:" + uuid);
        dialogLayout.setClipChildren(false);
        dialogLayout.setElevation(eVar.E0(g11));
        dialogLayout.setOutlineProvider(new a());
        this.f6608d = dialogLayout;
        View decorView = window.getDecorView();
        ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        if (viewGroup != null) {
            d(viewGroup);
        }
        setContentView(dialogLayout);
        ViewTreeLifecycleOwner.b(dialogLayout, ViewTreeLifecycleOwner.a(view));
        ViewTreeViewModelStoreOwner.b(dialogLayout, ViewTreeViewModelStoreOwner.a(view));
        ViewTreeSavedStateRegistryOwner.b(dialogLayout, ViewTreeSavedStateRegistryOwner.a(view));
        k(this.f6605a, this.f6606b, layoutDirection);
        w.b(getOnBackPressedDispatcher(), this, false, new Function1<u, Unit>() { // from class: androidx.compose.ui.window.DialogWrapper.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((u) obj);
                return Unit.f67184a;
            }

            public final void invoke(u uVar) {
                if (DialogWrapper.this.f6606b.b()) {
                    DialogWrapper.this.f6605a.invoke();
                }
            }
        }, 2, null);
    }

    private static final void d(ViewGroup viewGroup) {
        viewGroup.setClipChildren(false);
        if (viewGroup instanceof DialogLayout) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            ViewGroup viewGroup2 = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
            if (viewGroup2 != null) {
                d(viewGroup2);
            }
        }
    }

    private final void i(LayoutDirection layoutDirection) {
        DialogLayout dialogLayout = this.f6608d;
        int i11 = b.f6611a[layoutDirection.ordinal()];
        int i12 = 1;
        if (i11 == 1) {
            i12 = 0;
        } else if (i11 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        dialogLayout.setLayoutDirection(i12);
    }

    private final void j(SecureFlagPolicy secureFlagPolicy) {
        boolean a11 = k.a(secureFlagPolicy, AndroidPopup_androidKt.d(this.f6607c));
        Window window = getWindow();
        Intrinsics.e(window);
        window.setFlags(a11 ? 8192 : -8193, 8192);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
    }

    public final void g() {
        this.f6608d.disposeComposition();
    }

    public final void h(m mVar, Function2 function2) {
        this.f6608d.setContent(mVar, function2);
    }

    public final void k(Function0 function0, c cVar, LayoutDirection layoutDirection) {
        Window window;
        this.f6605a = function0;
        this.f6606b = cVar;
        j(cVar.d());
        i(layoutDirection);
        if (cVar.e() && !this.f6608d.f() && (window = getWindow()) != null) {
            window.setLayout(-2, -2);
        }
        this.f6608d.g(cVar.e());
        if (Build.VERSION.SDK_INT < 31) {
            if (cVar.a()) {
                Window window2 = getWindow();
                if (window2 != null) {
                    window2.setSoftInputMode(this.f6610f);
                    return;
                }
                return;
            }
            Window window3 = getWindow();
            if (window3 != null) {
                window3.setSoftInputMode(16);
            }
        }
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (onTouchEvent && this.f6606b.c()) {
            this.f6605a.invoke();
        }
        return onTouchEvent;
    }
}
