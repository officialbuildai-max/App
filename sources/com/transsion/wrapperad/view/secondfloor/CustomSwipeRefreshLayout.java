package com.transsion.wrapperad.view.secondfloor;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.transsion.mb.config.manager.ConfigBean;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u001e\u0018\u0000 K2\u00020\u0001:\u0002LMB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u000eJ\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\u001e\u0010\u001dJ\u0015\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001aR\u0016\u0010&\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u001aR\u0016\u0010(\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010\u001aR\u0016\u0010*\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\u001aR\u0016\u0010-\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010,R\u0018\u00108\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u001b\u0010=\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001b\u0010A\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010:\u001a\u0004\b?\u0010@R\u001b\u0010D\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010:\u001a\u0004\bC\u0010@R\"\u0010J\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u00102\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I¨\u0006N"}, d2 = {"Lcom/transsion/wrapperad/view/secondfloor/CustomSwipeRefreshLayout;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/MotionEvent;", "ev", "", "B", "(Landroid/view/MotionEvent;)V", "C", "()V", "Lkotlin/Pair;", "", "x", "()Lkotlin/Pair;", "y", "(Landroid/view/MotionEvent;)F", "A", "", "index", "z", "(ILandroid/view/MotionEvent;)F", "F", "", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "onTouchEvent", "Lcom/transsion/wrapperad/view/secondfloor/CustomSwipeRefreshLayout$b;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnSwipeActionListener", "(Lcom/transsion/wrapperad/view/secondfloor/CustomSwipeRefreshLayout$b;)V", "R", "initialTouchX", "S", "initialTouchY", "T", "lastTouchY", "U", "totalAccumulatedOffset", "V", "Z", "horizontalScrollDetected", "W", "downEventProcessed", "", "a0", "Ljava/lang/String;", "lastTrigger", "b0", "isPulling", "c0", "Lcom/transsion/wrapperad/view/secondfloor/CustomSwipeRefreshLayout$b;", "onSwipeActionListener", "d0", "Lkotlin/Lazy;", "getScreenHeight", "()I", "screenHeight", "e0", "getMaxSwipeDistance", "()F", "maxSwipeDistance", "f0", "getAlphaChangeDistance", "alphaChangeDistance", "g0", "getCurrentState", "()Ljava/lang/String;", "setCurrentState", "(Ljava/lang/String;)V", "currentState", "Companion", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "wrapperad_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class CustomSwipeRefreshLayout extends SwipeRefreshLayout {
    public static final float DAMPING = 0.6f;
    public static final float DAMPING_OVER = 0.2f;
    public static final String DOWN = "DOWN";
    public static final String HOVER_FULL = "HOVER_FULL";
    public static final String HOVER_HALF = "HOVER_HALF";
    public static final String IDLE = "IDLE";
    public static final String IDLE_TRIGGER = "IDLE_TRIGGER";
    public static final String KEY_AB_CONFIG = "second_floor_exp_config";
    public static final String MOVE = "MOVE";
    public static final String REFRESH = "REFRESH";
    public static final String REFRESH_TRIGGER = "REFRESH_TRIGGER";
    public static final String SECOND_FLOOR = "SECOND_FLOOR";
    public static final String SECOND_FLOOR_TRIGGER = "SECOND_FLOOR_TRIGGER";
    public static final String TAG = "SecondFloor";
    public static final float THRESHOLD_PULL = 3.0f;
    public static final float THRESHOLD_REFRESH = 0.09f;
    public static final float THRESHOLD_SECOND_FLOOR = 0.21000001f;
    public static final String UP = "UP";

    /* renamed from: R, reason: from kotlin metadata */
    private float initialTouchX;

    /* renamed from: S, reason: from kotlin metadata */
    private float initialTouchY;

    /* renamed from: T, reason: from kotlin metadata */
    private float lastTouchY;

    /* renamed from: U, reason: from kotlin metadata */
    private float totalAccumulatedOffset;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean horizontalScrollDetected;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean downEventProcessed;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private String lastTrigger;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean isPulling;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private b onSwipeActionListener;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final Lazy screenHeight;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private final Lazy maxSwipeDistance;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private final Lazy alphaChangeDistance;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private String currentState;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h0, reason: collision with root package name */
    private static final Lazy f58489h0 = LazyKt.b(new Function0() { // from class: com.transsion.wrapperad.view.secondfloor.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean D;
            D = CustomSwipeRefreshLayout.D();
            return Boolean.valueOf(D);
        }
    });

    /* renamed from: com.transsion.wrapperad.view.secondfloor.CustomSwipeRefreshLayout$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            Boolean m12;
            ConfigBean c11 = sm.f.f75530c.a().c(CustomSwipeRefreshLayout.KEY_AB_CONFIG, true);
            String value = c11 != null ? c11.getValue() : null;
            if (value == null || value.length() == 0 || (m12 = StringsKt.m1(value)) == null) {
                return false;
            }
            return m12.booleanValue();
        }

        public final boolean b() {
            return ((Boolean) CustomSwipeRefreshLayout.f58489h0.getValue()).booleanValue();
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(String str, float f11, float f12);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public CustomSwipeRefreshLayout(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CustomSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        this.lastTrigger = IDLE_TRIGGER;
        this.screenHeight = LazyKt.b(new Function0() { // from class: com.transsion.wrapperad.view.secondfloor.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int G;
                G = CustomSwipeRefreshLayout.G(CustomSwipeRefreshLayout.this);
                return Integer.valueOf(G);
            }
        });
        this.maxSwipeDistance = LazyKt.b(new Function0() { // from class: com.transsion.wrapperad.view.secondfloor.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                float E;
                E = CustomSwipeRefreshLayout.E(CustomSwipeRefreshLayout.this);
                return Float.valueOf(E);
            }
        });
        this.alphaChangeDistance = LazyKt.b(new Function0() { // from class: com.transsion.wrapperad.view.secondfloor.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                float w11;
                w11 = CustomSwipeRefreshLayout.w(CustomSwipeRefreshLayout.this);
                return Float.valueOf(w11);
            }
        });
        this.currentState = IDLE;
    }

    public /* synthetic */ CustomSwipeRefreshLayout(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    private final float A(MotionEvent ev2) {
        int actionIndex = ev2.getActionIndex();
        int pointerCount = ev2.getPointerCount();
        for (int i11 = 0; i11 < pointerCount; i11++) {
            if (i11 != actionIndex) {
                return z(i11, ev2);
            }
        }
        return z(0, ev2);
    }

    private final void B(MotionEvent ev2) {
        float y10 = y(ev2);
        float f11 = y10 - this.lastTouchY;
        float f12 = this.totalAccumulatedOffset;
        if (f12 + f11 >= 0.0f) {
            this.totalAccumulatedOffset = f12 + f11;
        } else {
            this.totalAccumulatedOffset = 0.0f;
        }
        this.lastTouchY = y10;
        Pair x10 = x();
        float floatValue = ((Number) x10.component1()).floatValue();
        float floatValue2 = ((Number) x10.component2()).floatValue();
        b bVar = this.onSwipeActionListener;
        if (bVar != null) {
            bVar.a(MOVE, floatValue, floatValue2);
        }
        float screenHeight = floatValue / getScreenHeight();
        if (INSTANCE.b()) {
            if (screenHeight < 0.09f) {
                if (Intrinsics.c(this.lastTrigger, IDLE_TRIGGER)) {
                    return;
                }
                this.lastTrigger = IDLE_TRIGGER;
                b bVar2 = this.onSwipeActionListener;
                if (bVar2 != null) {
                    bVar2.a(IDLE_TRIGGER, floatValue, floatValue2);
                    return;
                }
                return;
            }
            if (screenHeight < 0.09f || Intrinsics.c(this.lastTrigger, REFRESH_TRIGGER)) {
                return;
            }
            this.lastTrigger = REFRESH_TRIGGER;
            b bVar3 = this.onSwipeActionListener;
            if (bVar3 != null) {
                bVar3.a(REFRESH_TRIGGER, floatValue, floatValue2);
                return;
            }
            return;
        }
        if (screenHeight < 0.09f) {
            if (Intrinsics.c(this.lastTrigger, IDLE_TRIGGER)) {
                return;
            }
            this.lastTrigger = IDLE_TRIGGER;
            b bVar4 = this.onSwipeActionListener;
            if (bVar4 != null) {
                bVar4.a(IDLE_TRIGGER, floatValue, floatValue2);
                return;
            }
            return;
        }
        if (RangesKt.c(0.09f, 0.21000001f).a(Float.valueOf(screenHeight))) {
            if (Intrinsics.c(this.lastTrigger, REFRESH_TRIGGER)) {
                return;
            }
            this.lastTrigger = REFRESH_TRIGGER;
            b bVar5 = this.onSwipeActionListener;
            if (bVar5 != null) {
                bVar5.a(REFRESH_TRIGGER, floatValue, floatValue2);
                return;
            }
            return;
        }
        if (screenHeight < 0.21000001f || Intrinsics.c(this.lastTrigger, SECOND_FLOOR_TRIGGER)) {
            return;
        }
        this.lastTrigger = SECOND_FLOOR_TRIGGER;
        b bVar6 = this.onSwipeActionListener;
        if (bVar6 != null) {
            bVar6.a(SECOND_FLOOR_TRIGGER, floatValue, floatValue2);
        }
    }

    private final void C() {
        Pair x10 = x();
        float floatValue = ((Number) x10.component1()).floatValue();
        float floatValue2 = ((Number) x10.component2()).floatValue();
        b bVar = this.onSwipeActionListener;
        if (bVar != null) {
            bVar.a(UP, floatValue, floatValue2);
        }
        float screenHeight = floatValue / getScreenHeight();
        if (screenHeight < 0.09f) {
            this.currentState = IDLE;
            b bVar2 = this.onSwipeActionListener;
            if (bVar2 != null) {
                bVar2.a(IDLE, floatValue, floatValue2);
            }
        } else {
            boolean a11 = RangesKt.c(0.09f, 0.21000001f).a(Float.valueOf(screenHeight));
            String str = REFRESH;
            if (a11) {
                this.currentState = REFRESH;
                b bVar3 = this.onSwipeActionListener;
                if (bVar3 != null) {
                    bVar3.a(REFRESH, floatValue, floatValue2);
                }
            } else if (screenHeight >= 0.21000001f) {
                if (!INSTANCE.b()) {
                    str = SECOND_FLOOR;
                }
                this.currentState = str;
                b bVar4 = this.onSwipeActionListener;
                if (bVar4 != null) {
                    bVar4.a(str, floatValue, floatValue2);
                }
            }
        }
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D() {
        return INSTANCE.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float E(CustomSwipeRefreshLayout customSwipeRefreshLayout) {
        return ((customSwipeRefreshLayout.getResources().getDisplayMetrics().widthPixels * 9) / 16.0f) / 0.6f;
    }

    private final void F() {
        this.isPulling = false;
        this.initialTouchY = 0.0f;
        this.totalAccumulatedOffset = 0.0f;
        this.lastTouchY = 0.0f;
        this.downEventProcessed = false;
        this.horizontalScrollDetected = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int G(CustomSwipeRefreshLayout customSwipeRefreshLayout) {
        return customSwipeRefreshLayout.getResources().getDisplayMetrics().heightPixels;
    }

    private final float getAlphaChangeDistance() {
        return ((Number) this.alphaChangeDistance.getValue()).floatValue();
    }

    private final float getMaxSwipeDistance() {
        return ((Number) this.maxSwipeDistance.getValue()).floatValue();
    }

    private final int getScreenHeight() {
        return ((Number) this.screenHeight.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float w(CustomSwipeRefreshLayout customSwipeRefreshLayout) {
        return customSwipeRefreshLayout.getScreenHeight() * 0.1f;
    }

    private final Pair x() {
        float maxSwipeDistance;
        float e11 = RangesKt.e(this.totalAccumulatedOffset, 0.0f);
        if (e11 <= getMaxSwipeDistance()) {
            maxSwipeDistance = e11 * 0.6f;
        } else {
            maxSwipeDistance = ((e11 - getMaxSwipeDistance()) * 0.2f) + (getMaxSwipeDistance() * 0.6f);
        }
        return new Pair(Float.valueOf(maxSwipeDistance), Float.valueOf(maxSwipeDistance / getAlphaChangeDistance()));
    }

    private final float y(MotionEvent ev2) {
        return ev2.getActionMasked() == 6 ? A(ev2) : z(ev2.getPointerCount() - 1, ev2);
    }

    private final float z(int index, MotionEvent ev2) {
        float rawY;
        if (Build.VERSION.SDK_INT < 29) {
            return ev2.getY(index) + getScrollY();
        }
        rawY = ev2.getRawY(index);
        return rawY;
    }

    public final String getCurrentState() {
        return this.currentState;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev2) {
        Intrinsics.h(ev2, "ev");
        if (Intrinsics.c(this.currentState, HOVER_HALF) || Intrinsics.c(this.currentState, HOVER_FULL)) {
            b bVar = this.onSwipeActionListener;
            if (bVar != null) {
                bVar.a(IDLE, 0.0f, 0.0f);
            }
            return false;
        }
        if (!Intrinsics.c(this.currentState, IDLE)) {
            return false;
        }
        int action = ev2.getAction();
        if (action == 0) {
            this.initialTouchX = ev2.getRawX();
            this.initialTouchY = ev2.getRawY();
            this.lastTouchY = ev2.getRawY();
            this.totalAccumulatedOffset = 0.0f;
            this.isPulling = false;
            this.downEventProcessed = true;
            this.horizontalScrollDetected = false;
            b bVar2 = this.onSwipeActionListener;
            if (bVar2 != null) {
                bVar2.a(DOWN, 0.0f, 0.0f);
            }
        } else if (action == 2 && this.downEventProcessed) {
            float y10 = y(ev2);
            float rawX = ev2.getRawX();
            float abs = Math.abs(y10 - this.lastTouchY);
            float abs2 = Math.abs(rawX - this.initialTouchX);
            if (abs2 > abs && abs2 > 3.0f) {
                this.horizontalScrollDetected = true;
            }
            if (abs > 3.0f && !this.horizontalScrollDetected && !canChildScrollUp()) {
                this.isPulling = true;
            }
        }
        if (!this.downEventProcessed || this.horizontalScrollDetected) {
            return false;
        }
        return super.onInterceptTouchEvent(ev2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        if (r0 != 3) goto L28;
     */
    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r3) {
        /*
            r2 = this;
            java.lang.String r0 = "ev"
            kotlin.jvm.internal.Intrinsics.h(r3, r0)
            java.lang.String r0 = r2.currentState
            java.lang.String r1 = "IDLE"
            boolean r0 = kotlin.jvm.internal.Intrinsics.c(r0, r1)
            if (r0 != 0) goto L18
            boolean r0 = r2.downEventProcessed
            if (r0 != 0) goto L18
            boolean r3 = super.onTouchEvent(r3)
            return r3
        L18:
            int r0 = r3.getAction()
            r1 = 1
            if (r0 == r1) goto L38
            r1 = 2
            if (r0 == r1) goto L26
            r1 = 3
            if (r0 == r1) goto L38
            goto L49
        L26:
            boolean r0 = r2.downEventProcessed
            if (r0 == 0) goto L49
            boolean r0 = r2.canChildScrollUp()
            if (r0 != 0) goto L49
            boolean r0 = r2.isPulling
            if (r0 == 0) goto L49
            r2.B(r3)
            goto L49
        L38:
            boolean r0 = r2.downEventProcessed
            if (r0 == 0) goto L43
            boolean r0 = r2.isPulling
            if (r0 == 0) goto L43
            r2.C()
        L43:
            r0 = 0
            r2.downEventProcessed = r0
            r2.F()
        L49:
            boolean r3 = super.onTouchEvent(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.wrapperad.view.secondfloor.CustomSwipeRefreshLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void setCurrentState(String str) {
        Intrinsics.h(str, "<set-?>");
        this.currentState = str;
    }

    public final void setOnSwipeActionListener(b listener) {
        Intrinsics.h(listener, "listener");
        this.onSwipeActionListener = listener;
    }
}
