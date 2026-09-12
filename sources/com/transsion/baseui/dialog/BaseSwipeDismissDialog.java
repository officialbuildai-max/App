package com.transsion.baseui.dialog;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.collection.s;
import androidx.core.app.NotificationCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import be.g;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.android.material.card.MaterialCardView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseSwipeDismissDialog;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b'\u0018\u00002\u00020\u0001:\u0002|}B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\u0016J3\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010\u0003J\u0017\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020 H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020 H\u0002¢\u0006\u0004\b(\u0010&J\u000f\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010\u0003J\u000f\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010\u0003J\u000f\u0010+\u001a\u00020\u0006H\u0002¢\u0006\u0004\b+\u0010\u0003J\u000f\u0010,\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010\u0003J\u0019\u0010/\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0004\b/\u00100J\u0019\u00102\u001a\u0002012\b\u0010.\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0004\b2\u00103J!\u00105\u001a\u00020\u00062\u0006\u00104\u001a\u00020\t2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0006H\u0016¢\u0006\u0004\b7\u0010\u0003J\u0017\u00108\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b8\u0010\bJ\u000f\u00109\u001a\u00020\u0006H\u0004¢\u0006\u0004\b9\u0010\u0003J\u000f\u0010:\u001a\u00020\u0010H\u0014¢\u0006\u0004\b:\u0010\u001fJ\u000f\u0010<\u001a\u00020;H\u0014¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u00020\u00062\u0006\u0010?\u001a\u00020>H\u0014¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020;H\u0014¢\u0006\u0004\bB\u0010=J\u000f\u0010C\u001a\u00020;H\u0014¢\u0006\u0004\bC\u0010=J\u000f\u0010D\u001a\u00020 H\u0014¢\u0006\u0004\bD\u0010\"J\u000f\u0010E\u001a\u00020;H\u0014¢\u0006\u0004\bE\u0010=J\u000f\u0010F\u001a\u00020;H\u0014¢\u0006\u0004\bF\u0010=J\u000f\u0010G\u001a\u00020;H\u0014¢\u0006\u0004\bG\u0010=J\u0011\u0010H\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\bH\u0010IJ\u0011\u0010J\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\bJ\u0010IJ\u001f\u0010M\u001a\u00020\u00062\u0006\u0010K\u001a\u00020 2\u0006\u0010L\u001a\u00020 H\u0014¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020;H\u0014¢\u0006\u0004\bO\u0010=J\u000f\u0010P\u001a\u00020\u0006H\u0016¢\u0006\u0004\bP\u0010\u0003J\u000f\u0010Q\u001a\u00020\u0006H\u0016¢\u0006\u0004\bQ\u0010\u0003R\u0018\u0010T\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010_\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010b\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010aR\u0016\u0010g\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010k\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u001e\u0010o\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u001b\u0010s\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010=R\u001a\u0010y\u001a\u00020t8\u0014X\u0094\u0004¢\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010xR\u0016\u0010{\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010^¨\u0006~"}, d2 = {"Lcom/transsion/baseui/dialog/BaseSwipeDismissDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "Landroid/view/Window;", "window", "", "O0", "(Landroid/view/Window;)V", "Landroid/view/View;", "root", "l1", "(Landroid/view/View;)Landroid/view/View;", "P0", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "", "g1", "(Landroid/view/MotionEvent;Landroid/view/View;)Z", "p1", "target", "m1", "(Landroid/view/View;)V", "scrollView", "o1", "disallowParentIntercept", "captureOnDown", "requireNestedScrollAtTop", "e1", "(Landroid/view/MotionEvent;ZZZ)Z", "K0", "()Z", "", "M0", "()F", "k1", "currentRawY", "d1", "(F)V", "velocityY", "c1", "B0", "D0", "L0", "q1", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", TmcConstants.NAVIGATION_ON_START, "N0", "F0", "f1", "", "V0", "()I", "Landroidx/core/view/WindowInsetsCompat;", "insets", "h1", "(Landroidx/core/view/WindowInsetsCompat;)V", "S0", "R0", "W0", "a1", "T0", "Y0", "Z0", "()Landroid/view/View;", "i1", "translationY", NotificationCompat.CATEGORY_PROGRESS, "j1", "(FF)V", "U0", "dismissAllowingStateLoss", "onDestroyView", "c", "Landroid/view/View;", "swipeTargetView", "Landroid/view/GestureDetector;", "d", "Landroid/view/GestureDetector;", "gestureDetector", "Landroid/view/VelocityTracker;", "e", "Landroid/view/VelocityTracker;", "velocityTracker", "f", "Z", "isDragging", g.f16474b, "F", "dragStartY", "h", "currentTranslationY", "i", "I", "activeTouchPointerId", "Landroid/animation/ValueAnimator;", j.f35620b, "Landroid/animation/ValueAnimator;", "currentAnimator", "Lkotlin/Function0;", CampaignEx.JSON_KEY_AD_K, "Lkotlin/jvm/functions/Function0;", "onSwipeDismissListener", "l", "Lkotlin/Lazy;", "b1", "touchSlop", "Lcom/transsion/baseui/dialog/BaseSwipeDismissDialog$a;", "m", "Lcom/transsion/baseui/dialog/BaseSwipeDismissDialog$a;", "X0", "()Lcom/transsion/baseui/dialog/BaseSwipeDismissDialog$a;", "swipeConfig", "n", "outsideDismissTapConfigured", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "BaseUI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public abstract class BaseSwipeDismissDialog extends BaseDialog {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private View swipeTargetView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GestureDetector gestureDetector;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private VelocityTracker velocityTracker;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isDragging;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float dragStartY;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float currentTranslationY;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ValueAnimator currentAnimator;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private Function0 onSwipeDismissListener;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean outsideDismissTapConfigured;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int activeTouchPointerId = -1;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final Lazy touchSlop = LazyKt.b(new Function0() { // from class: ck.l
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            int s12;
            s12 = BaseSwipeDismissDialog.s1(BaseSwipeDismissDialog.this);
            return Integer.valueOf(s12);
        }
    });

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final a swipeConfig = new a(0.0f, 0.0f, 0, 0, 0.0f, false, 63, null);

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final float f43485a;

        /* renamed from: b, reason: collision with root package name */
        private final float f43486b;

        /* renamed from: c, reason: collision with root package name */
        private final long f43487c;

        /* renamed from: d, reason: collision with root package name */
        private final long f43488d;

        /* renamed from: e, reason: collision with root package name */
        private final float f43489e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f43490f;

        public a() {
            this(0.0f, 0.0f, 0L, 0L, 0.0f, false, 63, null);
        }

        public a(float f11, float f12, long j11, long j12, float f13, boolean z10) {
            this.f43485a = f11;
            this.f43486b = f12;
            this.f43487c = j11;
            this.f43488d = j12;
            this.f43489e = f13;
            this.f43490f = z10;
        }

        public /* synthetic */ a(float f11, float f12, long j11, long j12, float f13, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? 200.0f : f11, (i11 & 2) != 0 ? 800.0f : f12, (i11 & 4) != 0 ? 250L : j11, (i11 & 8) != 0 ? 200L : j12, (i11 & 16) != 0 ? 0.6f : f13, (i11 & 32) != 0 ? false : z10);
        }

        public final boolean a() {
            return this.f43490f;
        }

        public final long b() {
            return this.f43488d;
        }

        public final float c() {
            return this.f43485a;
        }

        public final float d() {
            return this.f43486b;
        }

        public final long e() {
            return this.f43487c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Float.compare(this.f43485a, aVar.f43485a) == 0 && Float.compare(this.f43486b, aVar.f43486b) == 0 && this.f43487c == aVar.f43487c && this.f43488d == aVar.f43488d && Float.compare(this.f43489e, aVar.f43489e) == 0 && this.f43490f == aVar.f43490f;
        }

        public int hashCode() {
            return (((((((((Float.floatToIntBits(this.f43485a) * 31) + Float.floatToIntBits(this.f43486b)) * 31) + s.a(this.f43487c)) * 31) + s.a(this.f43488d)) * 31) + Float.floatToIntBits(this.f43489e)) * 31) + androidx.compose.foundation.e.a(this.f43490f);
        }

        public String toString() {
            return "SwipeConfig(dismissThreshold=" + this.f43485a + ", dismissVelocity=" + this.f43486b + ", restoreDuration=" + this.f43487c + ", dismissDuration=" + this.f43488d + ", minAlpha=" + this.f43489e + ", dimWithContent=" + this.f43490f + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent e22, float f11, float f12) {
            Intrinsics.h(e22, "e2");
            if (!BaseSwipeDismissDialog.this.isDragging || f12 <= BaseSwipeDismissDialog.this.getSwipeConfig().d()) {
                return false;
            }
            BaseSwipeDismissDialog.this.B0();
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Window window;
            Function0 function0 = BaseSwipeDismissDialog.this.onSwipeDismissListener;
            if (function0 != null) {
                function0.invoke();
            }
            Dialog dialog = BaseSwipeDismissDialog.this.getDialog();
            if (dialog != null && (window = dialog.getWindow()) != null) {
                window.setWindowAnimations(0);
            }
            BaseSwipeDismissDialog.this.dismissAllowingStateLoss();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes5.dex */
    public static final class d implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f43493a;

        public d(View view) {
            this.f43493a = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f43493a.setTranslationY(0.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends RecyclerView.w {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.w, androidx.recyclerview.widget.RecyclerView.q
        public boolean b(RecyclerView recyclerView, MotionEvent event) {
            Intrinsics.h(recyclerView, "recyclerView");
            Intrinsics.h(event, "event");
            return BaseSwipeDismissDialog.this.e1(event, true, false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B0() {
        final View view = this.swipeTargetView;
        if (view == null) {
            dismissAllowingStateLoss();
            return;
        }
        L0();
        final float translationY = view.getTranslationY();
        final float height = view.getHeight();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(getSwipeConfig().b());
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ck.k
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseSwipeDismissDialog.C0(view, translationY, height, valueAnimator);
            }
        });
        Intrinsics.e(ofFloat);
        ofFloat.addListener(new c());
        ofFloat.start();
        this.currentAnimator = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(View view, float f11, float f12, ValueAnimator animator) {
        Intrinsics.h(animator, "animator");
        Object animatedValue = animator.getAnimatedValue();
        Intrinsics.f(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setTranslationY(f11 + ((f12 - f11) * ((Float) animatedValue).floatValue()));
    }

    private final void D0() {
        final View view = this.swipeTargetView;
        if (view == null) {
            return;
        }
        L0();
        final float translationY = view.getTranslationY();
        if (translationY == 0.0f) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(getSwipeConfig().e());
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ck.m
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseSwipeDismissDialog.E0(view, translationY, valueAnimator);
            }
        });
        Intrinsics.e(ofFloat);
        ofFloat.addListener(new d(view));
        ofFloat.start();
        this.currentAnimator = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(View view, float f11, ValueAnimator animator) {
        Intrinsics.h(animator, "animator");
        Object animatedValue = animator.getAnimatedValue();
        Intrinsics.f(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setTranslationY(f11 * (1.0f - ((Float) animatedValue).floatValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
    
        if (r2.intValue() > 0) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit G0(com.transsion.baseui.dialog.BaseSwipeDismissDialog r2, android.widget.FrameLayout r3, float r4, android.view.View r5) {
        /*
            android.app.Dialog r2 = r2.getDialog()
            r0 = 0
            if (r2 == 0) goto L22
            android.view.Window r2 = r2.getWindow()
            if (r2 == 0) goto L22
            android.view.View r2 = r2.getDecorView()
            if (r2 == 0) goto L22
            int r2 = r2.getHeight()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r1 = r2.intValue()
            if (r1 <= 0) goto L22
            goto L23
        L22:
            r2 = r0
        L23:
            int r3 = r3.getHeight()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            int r1 = r3.intValue()
            if (r1 <= 0) goto L32
            r0 = r3
        L32:
            if (r2 == 0) goto L39
            int r2 = r2.intValue()
            goto L44
        L39:
            if (r0 == 0) goto L40
            int r2 = r0.intValue()
            goto L44
        L40:
            int r2 = com.blankj.utilcode.util.y.c()
        L44:
            float r2 = (float) r2
            float r2 = r2 * r4
            int r2 = (int) r2
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams
            r4 = -1
            r0 = 80
            r3.<init>(r4, r2, r0)
            r5.setLayoutParams(r3)
            kotlin.Unit r2 = kotlin.Unit.f67184a
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.baseui.dialog.BaseSwipeDismissDialog.G0(com.transsion.baseui.dialog.BaseSwipeDismissDialog, android.widget.FrameLayout, float, android.view.View):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(Function0 function0, BaseSwipeDismissDialog baseSwipeDismissDialog) {
        function0.invoke();
        baseSwipeDismissDialog.P0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(Function0 function0, BaseSwipeDismissDialog baseSwipeDismissDialog) {
        function0.invoke();
        baseSwipeDismissDialog.P0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(BaseSwipeDismissDialog baseSwipeDismissDialog) {
        baseSwipeDismissDialog.P0();
    }

    private final boolean K0() {
        if (Z0() instanceof RecyclerView) {
            return !((RecyclerView) r0).canScrollVertically(-1);
        }
        return true;
    }

    private final void L0() {
        ValueAnimator valueAnimator = this.currentAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.currentAnimator = null;
    }

    private final float M0() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.computeCurrentVelocity(1000);
        }
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            return velocityTracker2.getYVelocity();
        }
        return 0.0f;
    }

    private final void O0(Window window) {
        ViewGroup.LayoutParams layoutParams;
        window.setLayout(-1, -1);
        View decorView = window.getDecorView();
        Intrinsics.g(decorView, "getDecorView(...)");
        decorView.setPadding(0, 0, 0, 0);
        if (decorView instanceof ViewGroup) {
            ((ViewGroup) decorView).setClipToPadding(false);
            View findViewById = decorView.findViewById(R.id.content);
            if (findViewById != null) {
                findViewById.setPadding(0, 0, 0, 0);
            }
            if (findViewById != null && (layoutParams = findViewById.getLayoutParams()) != null) {
                layoutParams.height = -1;
            }
        }
        View view = getView();
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = -1;
        } else {
            layoutParams2 = null;
        }
        view.setLayoutParams(layoutParams2);
        view.setPadding(0, 0, 0, 0);
    }

    private final void P0() {
        View view;
        if (this.outsideDismissTapConfigured || !f1()) {
            return;
        }
        int V0 = V0();
        if (V0 != 0) {
            View view2 = getView();
            view = view2 != null ? view2.findViewById(V0) : null;
        } else {
            view = getView();
        }
        if (view == null) {
            return;
        }
        view.setClickable(true);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: ck.t
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view3, MotionEvent motionEvent) {
                boolean Q0;
                Q0 = BaseSwipeDismissDialog.Q0(BaseSwipeDismissDialog.this, view3, motionEvent);
                return Q0;
            }
        });
        this.outsideDismissTapConfigured = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Q0(BaseSwipeDismissDialog baseSwipeDismissDialog, View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 1) {
            return false;
        }
        Intrinsics.e(motionEvent);
        Intrinsics.e(view);
        if (!baseSwipeDismissDialog.g1(motionEvent, view)) {
            return false;
        }
        baseSwipeDismissDialog.dismissAllowingStateLoss();
        return true;
    }

    private final int b1() {
        return ((Number) this.touchSlop.getValue()).intValue();
    }

    private final void c1(float velocityY) {
        if (this.currentTranslationY > getSwipeConfig().c() || (this.currentTranslationY > b1() && velocityY > getSwipeConfig().d())) {
            B0();
        } else {
            D0();
        }
    }

    private final void d1(float currentRawY) {
        View view;
        Dialog dialog;
        Window window;
        float f11 = currentRawY - this.dragStartY;
        if (f11 >= 0.0f && (view = this.swipeTargetView) != null) {
            this.currentTranslationY = f11;
            view.setTranslationY(f11);
            float l11 = RangesKt.l(this.currentTranslationY / (view.getHeight() * 0.5f), 0.0f, 1.0f);
            if (getSwipeConfig().a() && (dialog = getDialog()) != null && (window = dialog.getWindow()) != null) {
                window.setDimAmount((1.0f - l11) * 0.5f);
            }
            j1(this.currentTranslationY, l11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e1(MotionEvent event, boolean disallowParentIntercept, boolean captureOnDown, boolean requireNestedScrollAtTop) {
        View view;
        ViewParent parent;
        ValueAnimator valueAnimator = this.currentAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return false;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.activeTouchPointerId = event.getPointerId(0);
            this.dragStartY = event.getRawY();
            this.isDragging = false;
            VelocityTracker velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            VelocityTracker obtain = VelocityTracker.obtain();
            this.velocityTracker = obtain;
            if (obtain != null) {
                obtain.addMovement(event);
            }
            return captureOnDown;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                VelocityTracker velocityTracker2 = this.velocityTracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(event);
                }
                float rawY = event.getRawY() - this.dragStartY;
                if (!this.isDragging) {
                    if (rawY <= b1()) {
                        return false;
                    }
                    if (requireNestedScrollAtTop && !K0()) {
                        return false;
                    }
                    this.isDragging = true;
                    L0();
                    if (disallowParentIntercept && (view = this.swipeTargetView) != null && (parent = view.getParent()) != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                }
                if (!this.isDragging) {
                    return false;
                }
                d1(event.getRawY());
                return true;
            }
            if (actionMasked != 3) {
                if (actionMasked != 6) {
                    return false;
                }
                int actionIndex = event.getActionIndex();
                if (event.getPointerId(actionIndex) == this.activeTouchPointerId) {
                    int i11 = actionIndex != 0 ? 0 : 1;
                    if (i11 < event.getPointerCount()) {
                        this.activeTouchPointerId = event.getPointerId(i11);
                        this.dragStartY = event.getY(i11) + (event.getRawY() - event.getY());
                    }
                }
                VelocityTracker velocityTracker3 = this.velocityTracker;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(event);
                }
                return this.isDragging;
            }
        }
        VelocityTracker velocityTracker4 = this.velocityTracker;
        if (velocityTracker4 != null) {
            velocityTracker4.addMovement(event);
        }
        if (!this.isDragging) {
            k1();
            return false;
        }
        this.isDragging = false;
        c1(M0());
        k1();
        return true;
    }

    private final boolean g1(MotionEvent event, View root) {
        int R0 = R0();
        View findViewById = R0 != 0 ? root.findViewById(R0) : this.swipeTargetView;
        if (findViewById == null) {
            return true;
        }
        return event.getY() < ((float) findViewById.getTop()) + findViewById.getTranslationY();
    }

    private final void k1() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.velocityTracker = null;
    }

    private final View l1(View root) {
        View findViewById;
        View findViewById2;
        int a12 = a1();
        if (a12 != 0 && (findViewById2 = root.findViewById(a12)) != null) {
            return findViewById2;
        }
        int S0 = S0();
        return (S0 == 0 || (findViewById = root.findViewById(S0)) == null) ? root : findViewById;
    }

    private final void m1(View target) {
        target.setOnTouchListener(new View.OnTouchListener() { // from class: ck.s
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean n12;
                n12 = BaseSwipeDismissDialog.n1(BaseSwipeDismissDialog.this, view, motionEvent);
                return n12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n1(BaseSwipeDismissDialog baseSwipeDismissDialog, View view, MotionEvent motionEvent) {
        Intrinsics.e(motionEvent);
        return baseSwipeDismissDialog.e1(motionEvent, true, true, false);
    }

    private final void o1(View scrollView) {
        if (scrollView instanceof RecyclerView) {
            ((RecyclerView) scrollView).addOnItemTouchListener(new e());
        }
    }

    private final void p1() {
        View view;
        View findViewById;
        this.gestureDetector = new GestureDetector(requireContext(), new b());
        int Y0 = Y0();
        if (Y0 != 0 && (view = getView()) != null && (findViewById = view.findViewById(Y0)) != null) {
            m1(findViewById);
        }
        View Z0 = Z0();
        if (Z0 != null) {
            o1(Z0);
        }
        View i12 = i1();
        if (i12 == null || Y0 != 0) {
            return;
        }
        m1(i12);
    }

    private final void q1() {
        View view = getView();
        if (view == null) {
            return;
        }
        ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: ck.r
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat r12;
                r12 = BaseSwipeDismissDialog.r1(BaseSwipeDismissDialog.this, view2, windowInsetsCompat);
                return r12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat r1(BaseSwipeDismissDialog baseSwipeDismissDialog, View v11, WindowInsetsCompat insets) {
        Intrinsics.h(v11, "v");
        Intrinsics.h(insets, "insets");
        v11.setPadding(v11.getPaddingLeft(), v11.getPaddingTop(), v11.getPaddingRight(), 0);
        baseSwipeDismissDialog.h1(insets);
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int s1(BaseSwipeDismissDialog baseSwipeDismissDialog) {
        return ViewConfiguration.get(baseSwipeDismissDialog.requireContext()).getScaledTouchSlop();
    }

    protected final void F0() {
        final View findViewById;
        Window window;
        int R0 = R0();
        if (R0 == 0) {
            View view = getView();
            if (view != null) {
                view.post(new Runnable() { // from class: ck.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseSwipeDismissDialog.J0(BaseSwipeDismissDialog.this);
                    }
                });
                return;
            }
            return;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(R0)) == null) {
            return;
        }
        ViewParent parent = findViewById.getParent();
        View view3 = null;
        final FrameLayout frameLayout = parent instanceof FrameLayout ? (FrameLayout) parent : null;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setBackgroundColor(0);
        final float W0 = W0();
        final Function0 function0 = new Function0() { // from class: ck.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit G0;
                G0 = BaseSwipeDismissDialog.G0(BaseSwipeDismissDialog.this, frameLayout, W0, findViewById);
                return G0;
            }
        };
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            view3 = window.getDecorView();
        }
        if (view3 != null && view3.getHeight() > 0) {
            function0.invoke();
            P0();
        } else if (view3 != null) {
            view3.post(new Runnable() { // from class: ck.p
                @Override // java.lang.Runnable
                public final void run() {
                    BaseSwipeDismissDialog.H0(Function0.this, this);
                }
            });
        } else {
            frameLayout.post(new Runnable() { // from class: ck.q
                @Override // java.lang.Runnable
                public final void run() {
                    BaseSwipeDismissDialog.I0(Function0.this, this);
                }
            });
        }
    }

    protected void N0(Window window) {
        Intrinsics.h(window, "window");
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(201326592);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(U0());
        if (Build.VERSION.SDK_INT >= 29) {
            window.setStatusBarContrastEnforced(false);
            window.setNavigationBarContrastEnforced(false);
        }
    }

    protected int R0() {
        return 0;
    }

    protected int S0() {
        return 0;
    }

    protected int T0() {
        return S0();
    }

    protected int U0() {
        return Color.parseColor("#000000");
    }

    protected int V0() {
        return 0;
    }

    protected float W0() {
        return 0.75f;
    }

    /* renamed from: X0, reason: from getter */
    protected a getSwipeConfig() {
        return this.swipeConfig;
    }

    protected int Y0() {
        return 0;
    }

    protected View Z0() {
        return null;
    }

    protected int a1() {
        int R0 = R0();
        return R0 != 0 ? R0 : S0();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setWindowAnimations(0);
        }
        super.dismissAllowingStateLoss();
    }

    protected boolean f1() {
        return true;
    }

    protected void h1(WindowInsetsCompat insets) {
        View view;
        Intrinsics.h(insets, "insets");
        int T0 = T0();
        if (T0 != 0) {
            View view2 = getView();
            view = view2 != null ? view2.findViewById(T0) : null;
        } else {
            view = this.swipeTargetView;
        }
        if (view == null) {
            return;
        }
        int i11 = insets.getInsets(WindowInsetsCompat.Type.ime()).f79251d;
        int i12 = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).f79251d;
        if (i11 <= 0) {
            i11 = i12;
        }
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i11);
    }

    protected View i1() {
        return null;
    }

    protected void j1(float translationY, float progress) {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R$style.SwipeDismissDialogTheme);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.g(onCreateDialog, "onCreateDialog(...)");
        onCreateDialog.setCanceledOnTouchOutside(f1());
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setDimAmount(0.5f);
            window.setWindowAnimations(R$style.BaseBottomDialogAnimation);
            window.setGravity(MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START);
            window.setLayout(-1, -1);
            window.setSoftInputMode(48);
            window.setBackgroundDrawable(null);
            N0(window);
        }
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        View view;
        this.outsideDismissTapConfigured = false;
        int V0 = V0();
        if (V0 != 0) {
            View view2 = getView();
            view = view2 != null ? view2.findViewById(V0) : null;
        } else {
            view = getView();
        }
        if (view != null) {
            view.setOnTouchListener(null);
        }
        L0();
        k1();
        this.gestureDetector = null;
        this.swipeTargetView = null;
        super.onDestroyView();
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            N0(window);
            O0(window);
        }
        F0();
        View view = getView();
        if (view != null) {
            ViewCompat.requestApplyInsets(view);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.swipeTargetView = l1(view);
        p1();
        q1();
    }
}
