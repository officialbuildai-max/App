package androidx.compose.ui.platform;

import android.R;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.text.SpannableString;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.compose.ui.R$id;
import androidx.compose.ui.R$string;
import androidx.compose.ui.f;
import androidx.compose.ui.graphics.u4;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.accessibility.CollectionInfo_androidKt;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesAndroid;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.f;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.view.Lifecycle;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat {
    public static final d L = new d(null);
    public static final int M = 8;
    private static final androidx.collection.m N = androidx.collection.n.a(R$id.accessibility_custom_action_0, R$id.accessibility_custom_action_1, R$id.accessibility_custom_action_2, R$id.accessibility_custom_action_3, R$id.accessibility_custom_action_4, R$id.accessibility_custom_action_5, R$id.accessibility_custom_action_6, R$id.accessibility_custom_action_7, R$id.accessibility_custom_action_8, R$id.accessibility_custom_action_9, R$id.accessibility_custom_action_10, R$id.accessibility_custom_action_11, R$id.accessibility_custom_action_12, R$id.accessibility_custom_action_13, R$id.accessibility_custom_action_14, R$id.accessibility_custom_action_15, R$id.accessibility_custom_action_16, R$id.accessibility_custom_action_17, R$id.accessibility_custom_action_18, R$id.accessibility_custom_action_19, R$id.accessibility_custom_action_20, R$id.accessibility_custom_action_21, R$id.accessibility_custom_action_22, R$id.accessibility_custom_action_23, R$id.accessibility_custom_action_24, R$id.accessibility_custom_action_25, R$id.accessibility_custom_action_26, R$id.accessibility_custom_action_27, R$id.accessibility_custom_action_28, R$id.accessibility_custom_action_29, R$id.accessibility_custom_action_30, R$id.accessibility_custom_action_31);
    private androidx.collection.c0 A;
    private androidx.collection.c0 B;
    private final String C;
    private final String D;
    private final androidx.compose.ui.text.platform.r E;
    private androidx.collection.e0 F;
    private c2 G;
    private boolean H;
    private final Runnable I;
    private final List J;
    private final Function1 K;

    /* renamed from: a, reason: collision with root package name */
    private final AndroidComposeView f5606a;

    /* renamed from: b, reason: collision with root package name */
    private int f5607b = Integer.MIN_VALUE;

    /* renamed from: c, reason: collision with root package name */
    private Function1 f5608c = new Function1<AccessibilityEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$onSendAccessibilityEvent$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(AccessibilityEvent accessibilityEvent) {
            return Boolean.valueOf(AndroidComposeViewAccessibilityDelegateCompat.this.Y().getParent().requestSendAccessibilityEvent(AndroidComposeViewAccessibilityDelegateCompat.this.Y(), accessibilityEvent));
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private final AccessibilityManager f5609d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f5610e;

    /* renamed from: f, reason: collision with root package name */
    private long f5611f;

    /* renamed from: g, reason: collision with root package name */
    private final AccessibilityManager.AccessibilityStateChangeListener f5612g;

    /* renamed from: h, reason: collision with root package name */
    private final AccessibilityManager.TouchExplorationStateChangeListener f5613h;

    /* renamed from: i, reason: collision with root package name */
    private List f5614i;

    /* renamed from: j, reason: collision with root package name */
    private final Handler f5615j;

    /* renamed from: k, reason: collision with root package name */
    private e f5616k;

    /* renamed from: l, reason: collision with root package name */
    private int f5617l;

    /* renamed from: m, reason: collision with root package name */
    private AccessibilityNodeInfoCompat f5618m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f5619n;

    /* renamed from: o, reason: collision with root package name */
    private final androidx.collection.e0 f5620o;

    /* renamed from: p, reason: collision with root package name */
    private final androidx.collection.e0 f5621p;

    /* renamed from: q, reason: collision with root package name */
    private androidx.collection.y0 f5622q;

    /* renamed from: r, reason: collision with root package name */
    private androidx.collection.y0 f5623r;

    /* renamed from: s, reason: collision with root package name */
    private int f5624s;

    /* renamed from: t, reason: collision with root package name */
    private Integer f5625t;

    /* renamed from: u, reason: collision with root package name */
    private final androidx.collection.b f5626u;

    /* renamed from: v, reason: collision with root package name */
    private final kotlinx.coroutines.channels.d f5627v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f5628w;

    /* renamed from: x, reason: collision with root package name */
    private f f5629x;

    /* renamed from: y, reason: collision with root package name */
    private androidx.collection.o f5630y;

    /* renamed from: z, reason: collision with root package name */
    private androidx.collection.f0 f5631z;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$LtrBoundsComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "()V", "compare", "", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "ui_release"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes.dex */
    public static final class LtrBoundsComparator implements Comparator<SemanticsNode> {
        public static final LtrBoundsComparator INSTANCE = new LtrBoundsComparator();

        private LtrBoundsComparator() {
        }

        @Override // java.util.Comparator
        public int compare(SemanticsNode a11, SemanticsNode b11) {
            y.i j11 = a11.j();
            y.i j12 = b11.j();
            int compare = Float.compare(j11.f(), j12.f());
            if (compare != 0) {
                return compare;
            }
            int compare2 = Float.compare(j11.i(), j12.i());
            if (compare2 != 0) {
                return compare2;
            }
            int compare3 = Float.compare(j11.c(), j12.c());
            return compare3 != 0 ? compare3 : Float.compare(j11.g(), j12.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$RtlBoundsComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "()V", "compare", "", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "ui_release"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes.dex */
    public static final class RtlBoundsComparator implements Comparator<SemanticsNode> {
        public static final RtlBoundsComparator INSTANCE = new RtlBoundsComparator();

        private RtlBoundsComparator() {
        }

        @Override // java.util.Comparator
        public int compare(SemanticsNode a11, SemanticsNode b11) {
            y.i j11 = a11.j();
            y.i j12 = b11.j();
            int compare = Float.compare(j12.g(), j11.g());
            if (compare != 0) {
                return compare;
            }
            int compare2 = Float.compare(j11.i(), j12.i());
            if (compare2 != 0) {
                return compare2;
            }
            int compare3 = Float.compare(j11.c(), j12.c());
            return compare3 != 0 ? compare3 : Float.compare(j12.f(), j11.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u000026\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00020\u0001j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002`\u0006B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJC\u0010\f\u001a\u00020\u000b2\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00022\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$TopBottomBoundsComparator;", "Ljava/util/Comparator;", "Lkotlin/Pair;", "Ly/i;", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "<init>", "()V", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "compare", "(Lkotlin/Pair;Lkotlin/Pair;)I", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes.dex */
    public static final class TopBottomBoundsComparator implements Comparator<Pair<? extends y.i, ? extends List<SemanticsNode>>> {
        public static final TopBottomBoundsComparator INSTANCE = new TopBottomBoundsComparator();

        private TopBottomBoundsComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Pair<? extends y.i, ? extends List<SemanticsNode>> pair, Pair<? extends y.i, ? extends List<SemanticsNode>> pair2) {
            return compare2((Pair<y.i, ? extends List<SemanticsNode>>) pair, (Pair<y.i, ? extends List<SemanticsNode>>) pair2);
        }

        /* renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Pair<y.i, ? extends List<SemanticsNode>> a11, Pair<y.i, ? extends List<SemanticsNode>> b11) {
            int compare = Float.compare(a11.getFirst().i(), b11.getFirst().i());
            return compare != 0 ? compare : Float.compare(a11.getFirst().c(), b11.getFirst().c());
        }
    }

    /* loaded from: classes.dex */
    public static final class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            AccessibilityManager accessibilityManager = AndroidComposeViewAccessibilityDelegateCompat.this.f5609d;
            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
            accessibilityManager.addAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat.f5612g);
            accessibilityManager.addTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.f5613h);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            AndroidComposeViewAccessibilityDelegateCompat.this.f5615j.removeCallbacks(AndroidComposeViewAccessibilityDelegateCompat.this.I);
            AccessibilityManager accessibilityManager = AndroidComposeViewAccessibilityDelegateCompat.this.f5609d;
            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
            accessibilityManager.removeAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat.f5612g);
            accessibilityManager.removeTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.f5613h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f5633a = new b();

        private b() {
        }

        @JvmStatic
        public static final void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, SemanticsNode semanticsNode) {
            boolean i11;
            androidx.compose.ui.semantics.a aVar;
            i11 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.i(semanticsNode);
            if (!i11 || (aVar = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), androidx.compose.ui.semantics.h.f6051a.v())) == null) {
                return;
            }
            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionSetProgress, aVar.b()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final c f5634a = new c();

        private c() {
        }

        @JvmStatic
        public static final void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, SemanticsNode semanticsNode) {
            boolean i11;
            i11 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.i(semanticsNode);
            if (i11) {
                androidx.compose.ui.semantics.i w11 = semanticsNode.w();
                androidx.compose.ui.semantics.h hVar = androidx.compose.ui.semantics.h.f6051a;
                androidx.compose.ui.semantics.a aVar = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(w11, hVar.p());
                if (aVar != null) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageUp, aVar.b()));
                }
                androidx.compose.ui.semantics.a aVar2 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), hVar.m());
                if (aVar2 != null) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageDown, aVar2.b()));
                }
                androidx.compose.ui.semantics.a aVar3 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), hVar.n());
                if (aVar3 != null) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageLeft, aVar3.b()));
                }
                androidx.compose.ui.semantics.a aVar4 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), hVar.o());
                if (aVar4 != null) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageRight, aVar4.b()));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private final class e extends AccessibilityNodeProviderCompat {
        public e() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public void addExtraDataToAccessibilityNodeInfo(int i11, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String str, Bundle bundle) {
            AndroidComposeViewAccessibilityDelegateCompat.this.x(i11, accessibilityNodeInfoCompat, str, bundle);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i11) {
            AccessibilityNodeInfoCompat F = AndroidComposeViewAccessibilityDelegateCompat.this.F(i11);
            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
            if (androidComposeViewAccessibilityDelegateCompat.f5619n && i11 == androidComposeViewAccessibilityDelegateCompat.f5617l) {
                androidComposeViewAccessibilityDelegateCompat.f5618m = F;
            }
            return F;
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int i11) {
            return createAccessibilityNodeInfo(AndroidComposeViewAccessibilityDelegateCompat.this.f5617l);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int i11, int i12, Bundle bundle) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.i0(i11, i12, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        private final SemanticsNode f5636a;

        /* renamed from: b, reason: collision with root package name */
        private final int f5637b;

        /* renamed from: c, reason: collision with root package name */
        private final int f5638c;

        /* renamed from: d, reason: collision with root package name */
        private final int f5639d;

        /* renamed from: e, reason: collision with root package name */
        private final int f5640e;

        /* renamed from: f, reason: collision with root package name */
        private final long f5641f;

        public f(SemanticsNode semanticsNode, int i11, int i12, int i13, int i14, long j11) {
            this.f5636a = semanticsNode;
            this.f5637b = i11;
            this.f5638c = i12;
            this.f5639d = i13;
            this.f5640e = i14;
            this.f5641f = j11;
        }

        public final int a() {
            return this.f5637b;
        }

        public final int b() {
            return this.f5639d;
        }

        public final int c() {
            return this.f5638c;
        }

        public final SemanticsNode d() {
            return this.f5636a;
        }

        public final int e() {
            return this.f5640e;
        }

        public final long f() {
            return this.f5641f;
        }
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class g {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5642a;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f5642a = iArr;
        }
    }

    public AndroidComposeViewAccessibilityDelegateCompat(AndroidComposeView androidComposeView) {
        this.f5606a = androidComposeView;
        Object systemService = androidComposeView.getContext().getSystemService("accessibility");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
        this.f5609d = accessibilityManager;
        this.f5611f = 100L;
        this.f5612g = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: androidx.compose.ui.platform.s
            @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
            public final void onAccessibilityStateChanged(boolean z10) {
                AndroidComposeViewAccessibilityDelegateCompat.J(AndroidComposeViewAccessibilityDelegateCompat.this, z10);
            }
        };
        this.f5613h = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: androidx.compose.ui.platform.t
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z10) {
                AndroidComposeViewAccessibilityDelegateCompat.Q0(AndroidComposeViewAccessibilityDelegateCompat.this, z10);
            }
        };
        this.f5614i = accessibilityManager.getEnabledAccessibilityServiceList(-1);
        this.f5615j = new Handler(Looper.getMainLooper());
        this.f5616k = new e();
        this.f5617l = Integer.MIN_VALUE;
        this.f5620o = new androidx.collection.e0(0, 1, null);
        this.f5621p = new androidx.collection.e0(0, 1, null);
        this.f5622q = new androidx.collection.y0(0, 1, null);
        this.f5623r = new androidx.collection.y0(0, 1, null);
        this.f5624s = -1;
        this.f5626u = new androidx.collection.b(0, 1, null);
        this.f5627v = kotlinx.coroutines.channels.g.b(1, null, null, 6, null);
        this.f5628w = true;
        this.f5630y = androidx.collection.p.a();
        this.f5631z = new androidx.collection.f0(0, 1, null);
        this.A = new androidx.collection.c0(0, 1, null);
        this.B = new androidx.collection.c0(0, 1, null);
        this.C = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.D = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL";
        this.E = new androidx.compose.ui.text.platform.r();
        this.F = androidx.collection.p.b();
        this.G = new c2(androidComposeView.getSemanticsOwner().a(), androidx.collection.p.a());
        androidComposeView.addOnAttachStateChangeListener(new a());
        this.I = new Runnable() { // from class: androidx.compose.ui.platform.u
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeViewAccessibilityDelegateCompat.r0(AndroidComposeViewAccessibilityDelegateCompat.this);
            }
        };
        this.J = new ArrayList();
        this.K = new Function1<b2, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeededLambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((b2) obj);
                return Unit.f67184a;
            }

            public final void invoke(b2 b2Var) {
                AndroidComposeViewAccessibilityDelegateCompat.this.q0(b2Var);
            }
        };
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        r0 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.k(r8, androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.INSTANCE);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void A0(androidx.compose.ui.node.LayoutNode r8, androidx.collection.f0 r9) {
        /*
            r7 = this;
            boolean r0 = r8.D0()
            if (r0 != 0) goto L7
            return
        L7:
            androidx.compose.ui.platform.AndroidComposeView r0 = r7.f5606a
            androidx.compose.ui.platform.AndroidViewsHandler r0 = r0.getAndroidViewsHandler$ui_release()
            java.util.HashMap r0 = r0.getLayoutNodeToHolder()
            boolean r0 = r0.containsKey(r8)
            if (r0 == 0) goto L18
            return
        L18:
            androidx.compose.ui.node.q0 r0 = r8.e0()
            r1 = 8
            int r1 = androidx.compose.ui.node.s0.a(r1)
            boolean r0 = r0.q(r1)
            if (r0 == 0) goto L29
            goto L2f
        L29:
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1 r0 = new kotlin.jvm.functions.Function1<androidx.compose.ui.node.LayoutNode, java.lang.Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1
                static {
                    /*
                        androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1 r0 = new androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT 
  (r0 I:androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1)
 androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1.INSTANCE androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                public final java.lang.Boolean invoke(androidx.compose.ui.node.LayoutNode r2) {
                    /*
                        r1 = this;
                        androidx.compose.ui.node.q0 r2 = r2.e0()
                        r0 = 8
                        int r0 = androidx.compose.ui.node.s0.a(r0)
                        boolean r2 = r2.q(r0)
                        java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1.invoke(androidx.compose.ui.node.LayoutNode):java.lang.Boolean");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1) {
                    /*
                        r0 = this;
                        androidx.compose.ui.node.LayoutNode r1 = (androidx.compose.ui.node.LayoutNode) r1
                        java.lang.Boolean r1 = r0.invoke(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1.invoke(java.lang.Object):java.lang.Object");
                }
            }
            androidx.compose.ui.node.LayoutNode r8 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.d(r8, r0)
        L2f:
            if (r8 == 0) goto L65
            androidx.compose.ui.semantics.i r0 = r8.F()
            if (r0 != 0) goto L38
            goto L65
        L38:
            boolean r0 = r0.o()
            if (r0 != 0) goto L47
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1 r0 = new kotlin.jvm.functions.Function1<androidx.compose.ui.node.LayoutNode, java.lang.Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1
                static {
                    /*
                        androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1 r0 = new androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT 
  (r0 I:androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1)
 androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.INSTANCE androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                public final java.lang.Boolean invoke(androidx.compose.ui.node.LayoutNode r3) {
                    /*
                        r2 = this;
                        androidx.compose.ui.semantics.i r3 = r3.F()
                        r0 = 0
                        if (r3 == 0) goto Lf
                        boolean r3 = r3.o()
                        r1 = 1
                        if (r3 != r1) goto Lf
                        r0 = r1
                    Lf:
                        java.lang.Boolean r3 = java.lang.Boolean.valueOf(r0)
                        return r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.invoke(androidx.compose.ui.node.LayoutNode):java.lang.Boolean");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1) {
                    /*
                        r0 = this;
                        androidx.compose.ui.node.LayoutNode r1 = (androidx.compose.ui.node.LayoutNode) r1
                        java.lang.Boolean r1 = r0.invoke(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.invoke(java.lang.Object):java.lang.Object");
                }
            }
            androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.d(r8, r0)
            if (r0 == 0) goto L47
            r8 = r0
        L47:
            int r8 = r8.j0()
            boolean r9 = r9.f(r8)
            if (r9 != 0) goto L52
            return
        L52:
            int r1 = r7.s0(r8)
            r8 = 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            r5 = 8
            r6 = 0
            r2 = 2048(0x800, float:2.87E-42)
            r4 = 0
            r0 = r7
            w0(r0, r1, r2, r3, r4, r5, r6)
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.A0(androidx.compose.ui.node.LayoutNode, androidx.collection.f0):void");
    }

    private final boolean B(androidx.collection.o oVar, boolean z10, int i11, long j11) {
        SemanticsPropertyKey k11;
        boolean z11;
        androidx.compose.ui.semantics.g gVar;
        if (y.g.j(j11, y.g.f78593b.b()) || !y.g.p(j11)) {
            return false;
        }
        if (z10) {
            k11 = SemanticsProperties.f5994a.H();
        } else {
            if (z10) {
                throw new NoWhenBranchMatchedException();
            }
            k11 = SemanticsProperties.f5994a.k();
        }
        Object[] objArr = oVar.f2380c;
        long[] jArr = oVar.f2378a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i12 = 0;
            boolean z12 = false;
            while (true) {
                long j12 = jArr[i12];
                if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i13 = 8 - ((~(i12 - length)) >>> 31);
                    for (int i14 = 0; i14 < i13; i14++) {
                        if ((j12 & 255) < 128) {
                            d2 d2Var = (d2) objArr[(i12 << 3) + i14];
                            if (u4.e(d2Var.a()).b(j11) && (gVar = (androidx.compose.ui.semantics.g) SemanticsConfigurationKt.a(d2Var.b().w(), k11)) != null) {
                                int i15 = gVar.b() ? -i11 : i11;
                                if (i11 == 0 && gVar.b()) {
                                    i15 = -1;
                                }
                                if (i15 < 0) {
                                    if (((Number) gVar.c().invoke()).floatValue() <= 0.0f) {
                                    }
                                    z12 = true;
                                } else {
                                    if (((Number) gVar.c().invoke()).floatValue() >= ((Number) gVar.a().invoke()).floatValue()) {
                                    }
                                    z12 = true;
                                }
                            }
                        }
                        j12 >>= 8;
                    }
                    if (i13 != 8) {
                        return z12;
                    }
                }
                if (i12 == length) {
                    z11 = z12;
                    break;
                }
                i12++;
            }
        } else {
            z11 = false;
        }
        return z11;
    }

    private final void B0(LayoutNode layoutNode) {
        if (layoutNode.D0() && !this.f5606a.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            int j02 = layoutNode.j0();
            androidx.compose.ui.semantics.g gVar = (androidx.compose.ui.semantics.g) this.f5620o.c(j02);
            androidx.compose.ui.semantics.g gVar2 = (androidx.compose.ui.semantics.g) this.f5621p.c(j02);
            if (gVar == null && gVar2 == null) {
                return;
            }
            AccessibilityEvent E = E(j02, 4096);
            if (gVar != null) {
                E.setScrollX((int) ((Number) gVar.c().invoke()).floatValue());
                E.setMaxScrollX((int) ((Number) gVar.a().invoke()).floatValue());
            }
            if (gVar2 != null) {
                E.setScrollY((int) ((Number) gVar2.c().invoke()).floatValue());
                E.setMaxScrollY((int) ((Number) gVar2.a().invoke()).floatValue());
            }
            u0(E);
        }
    }

    private final void C() {
        Trace.beginSection("sendAccessibilitySemanticsStructureChangeEvents");
        try {
            if (c0()) {
                t0(this.f5606a.getSemanticsOwner().a(), this.G);
            }
            Unit unit = Unit.f67184a;
            Trace.endSection();
            Trace.beginSection("sendSemanticsPropertyChangeEvents");
            try {
                z0(N());
                Trace.endSection();
                Trace.beginSection("updateSemanticsNodesCopyAndPanes");
                try {
                    U0();
                } finally {
                }
            } finally {
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private final boolean D(int i11) {
        if (!a0(i11)) {
            return false;
        }
        this.f5617l = Integer.MIN_VALUE;
        this.f5618m = null;
        this.f5606a.invalidate();
        w0(this, i11, 65536, null, null, 12, null);
        return true;
    }

    private final boolean D0(SemanticsNode semanticsNode, int i11, int i12, boolean z10) {
        String V;
        boolean i13;
        androidx.compose.ui.semantics.i w11 = semanticsNode.w();
        androidx.compose.ui.semantics.h hVar = androidx.compose.ui.semantics.h.f6051a;
        if (w11.e(hVar.w())) {
            i13 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.i(semanticsNode);
            if (i13) {
                Function3 function3 = (Function3) ((androidx.compose.ui.semantics.a) semanticsNode.w().j(hVar.w())).a();
                if (function3 != null) {
                    return ((Boolean) function3.invoke(Integer.valueOf(i11), Integer.valueOf(i12), Boolean.valueOf(z10))).booleanValue();
                }
                return false;
            }
        }
        if ((i11 == i12 && i12 == this.f5624s) || (V = V(semanticsNode)) == null) {
            return false;
        }
        if (i11 < 0 || i11 != i12 || i12 > V.length()) {
            i11 = -1;
        }
        this.f5624s = i11;
        boolean z11 = V.length() > 0;
        u0(H(s0(semanticsNode.o()), z11 ? Integer.valueOf(this.f5624s) : null, z11 ? Integer.valueOf(this.f5624s) : null, z11 ? Integer.valueOf(V.length()) : null, V));
        y0(semanticsNode.o());
        return true;
    }

    private final AccessibilityEvent E(int i11, int i12) {
        d2 d2Var;
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i12);
        obtain.setEnabled(true);
        obtain.setClassName("android.view.View");
        obtain.setPackageName(this.f5606a.getContext().getPackageName());
        obtain.setSource(this.f5606a, i11);
        if (c0() && (d2Var = (d2) N().c(i11)) != null) {
            obtain.setPassword(d2Var.b().w().e(SemanticsProperties.f5994a.v()));
        }
        return obtain;
    }

    private final void E0(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        androidx.compose.ui.semantics.i w11 = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5994a;
        if (w11.e(semanticsProperties.h())) {
            accessibilityNodeInfoCompat.setContentInvalid(true);
            accessibilityNodeInfoCompat.setError((CharSequence) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.h()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final AccessibilityNodeInfoCompat F(int i11) {
        androidx.view.u a11;
        Lifecycle lifecycle;
        AndroidComposeView.b viewTreeOwners = this.f5606a.getViewTreeOwners();
        if (((viewTreeOwners == null || (a11 = viewTreeOwners.a()) == null || (lifecycle = a11.getLifecycle()) == null) ? null : lifecycle.b()) == Lifecycle.State.DESTROYED) {
            return null;
        }
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        d2 d2Var = (d2) N().c(i11);
        if (d2Var == null) {
            return null;
        }
        SemanticsNode b11 = d2Var.b();
        if (i11 == -1) {
            ViewParent parentForAccessibility = this.f5606a.getParentForAccessibility();
            obtain.setParent(parentForAccessibility instanceof View ? (View) parentForAccessibility : null);
        } else {
            SemanticsNode r11 = b11.r();
            Integer valueOf = r11 != null ? Integer.valueOf(r11.o()) : null;
            if (valueOf == null) {
                g0.a.c("semanticsNode " + i11 + " has null parent");
                throw new KotlinNothingValueException();
            }
            int intValue = valueOf.intValue();
            obtain.setParent(this.f5606a, intValue != this.f5606a.getSemanticsOwner().a().o() ? intValue : -1);
        }
        obtain.setSource(this.f5606a, i11);
        obtain.setBoundsInScreen(y(d2Var));
        l0(i11, obtain, b11);
        return obtain;
    }

    private final void F0(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        accessibilityNodeInfoCompat.setCheckable(S(semanticsNode));
    }

    private final String G(SemanticsNode semanticsNode) {
        Collection collection;
        CharSequence charSequence;
        androidx.compose.ui.semantics.i n11 = semanticsNode.a().n();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5994a;
        Collection collection2 = (Collection) SemanticsConfigurationKt.a(n11, semanticsProperties.d());
        if ((collection2 == null || collection2.isEmpty()) && (((collection = (Collection) SemanticsConfigurationKt.a(n11, semanticsProperties.C())) == null || collection.isEmpty()) && ((charSequence = (CharSequence) SemanticsConfigurationKt.a(n11, semanticsProperties.g())) == null || charSequence.length() == 0))) {
            return this.f5606a.getContext().getResources().getString(R$string.state_empty);
        }
        return null;
    }

    private final AccessibilityEvent H(int i11, Integer num, Integer num2, Integer num3, CharSequence charSequence) {
        AccessibilityEvent E = E(i11, 8192);
        if (num != null) {
            E.setFromIndex(num.intValue());
        }
        if (num2 != null) {
            E.setToIndex(num2.intValue());
        }
        if (num3 != null) {
            E.setItemCount(num3.intValue());
        }
        if (charSequence != null) {
            E.getText().add(charSequence);
        }
        return E;
    }

    private final void H0(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        accessibilityNodeInfoCompat.setStateDescription(T(semanticsNode));
    }

    private final void I0(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AnnotatedString U = U(semanticsNode);
        accessibilityNodeInfoCompat.setText(U != null ? P0(U) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z10) {
        androidComposeViewAccessibilityDelegateCompat.f5614i = z10 ? androidComposeViewAccessibilityDelegateCompat.f5609d.getEnabledAccessibilityServiceList(-1) : CollectionsKt.l();
    }

    private final void J0() {
        boolean l11;
        this.A.i();
        this.B.i();
        d2 d2Var = (d2) N().c(-1);
        SemanticsNode b11 = d2Var != null ? d2Var.b() : null;
        Intrinsics.e(b11);
        l11 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.l(b11);
        List N0 = N0(l11, CollectionsKt.q(b11));
        int n11 = CollectionsKt.n(N0);
        if (1 > n11) {
            return;
        }
        int i11 = 1;
        while (true) {
            int o11 = ((SemanticsNode) N0.get(i11 - 1)).o();
            int o12 = ((SemanticsNode) N0.get(i11)).o();
            this.A.q(o11, o12);
            this.B.q(o12, o11);
            if (i11 == n11) {
                return;
            } else {
                i11++;
            }
        }
    }

    private final void K(SemanticsNode semanticsNode, ArrayList arrayList, androidx.collection.e0 e0Var) {
        boolean l11;
        l11 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.l(semanticsNode);
        boolean booleanValue = ((Boolean) semanticsNode.w().l(SemanticsProperties.f5994a.r(), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$geometryDepthFirstSearch$isTraversalGroup$1
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.FALSE;
            }
        })).booleanValue();
        if ((booleanValue || d0(semanticsNode)) && N().b(semanticsNode.o())) {
            arrayList.add(semanticsNode);
        }
        if (booleanValue) {
            e0Var.t(semanticsNode.o(), N0(l11, CollectionsKt.U0(semanticsNode.k())));
            return;
        }
        List k11 = semanticsNode.k();
        int size = k11.size();
        for (int i11 = 0; i11 < size; i11++) {
            K((SemanticsNode) k11.get(i11), arrayList, e0Var);
        }
    }

    private final List K0(boolean z10, ArrayList arrayList, androidx.collection.e0 e0Var) {
        ArrayList arrayList2 = new ArrayList();
        int n11 = CollectionsKt.n(arrayList);
        int i11 = 0;
        if (n11 >= 0) {
            int i12 = 0;
            while (true) {
                SemanticsNode semanticsNode = (SemanticsNode) arrayList.get(i12);
                if (i12 == 0 || !M0(arrayList2, semanticsNode)) {
                    arrayList2.add(new Pair(semanticsNode.j(), CollectionsKt.q(semanticsNode)));
                }
                if (i12 == n11) {
                    break;
                }
                i12++;
            }
        }
        CollectionsKt.A(arrayList2, TopBottomBoundsComparator.INSTANCE);
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList2.size();
        for (int i13 = 0; i13 < size; i13++) {
            Pair pair = (Pair) arrayList2.get(i13);
            List list = (List) pair.getSecond();
            final Comparator comparator = z10 ? RtlBoundsComparator.INSTANCE : LtrBoundsComparator.INSTANCE;
            final Comparator b11 = LayoutNode.K.b();
            final Comparator comparator2 = new Comparator() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t11, T t12) {
                    int compare = comparator.compare(t11, t12);
                    return compare != 0 ? compare : b11.compare(((SemanticsNode) t11).q(), ((SemanticsNode) t12).q());
                }
            };
            CollectionsKt.A(list, new Comparator() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t11, T t12) {
                    int compare = comparator2.compare(t11, t12);
                    return compare != 0 ? compare : ComparisonsKt.d(Integer.valueOf(((SemanticsNode) t11).o()), Integer.valueOf(((SemanticsNode) t12).o()));
                }
            });
            arrayList3.addAll((Collection) pair.getSecond());
        }
        final AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2 androidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2 = new Function2<SemanticsNode, SemanticsNode, Integer>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(SemanticsNode semanticsNode2, SemanticsNode semanticsNode3) {
                androidx.compose.ui.semantics.i w11 = semanticsNode2.w();
                SemanticsProperties semanticsProperties = SemanticsProperties.f5994a;
                return Integer.valueOf(Float.compare(((Number) w11.l(semanticsProperties.G(), new Function0<Float>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2.1
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(0.0f);
                    }
                })).floatValue(), ((Number) semanticsNode3.w().l(semanticsProperties.G(), new Function0<Float>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2.2
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(0.0f);
                    }
                })).floatValue()));
            }
        };
        CollectionsKt.A(arrayList3, new Comparator() { // from class: androidx.compose.ui.platform.r
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int L0;
                L0 = AndroidComposeViewAccessibilityDelegateCompat.L0(Function2.this, obj, obj2);
                return L0;
            }
        });
        while (i11 <= CollectionsKt.n(arrayList3)) {
            List list2 = (List) e0Var.c(((SemanticsNode) arrayList3.get(i11)).o());
            if (list2 != null) {
                if (d0((SemanticsNode) arrayList3.get(i11))) {
                    i11++;
                } else {
                    arrayList3.remove(i11);
                }
                arrayList3.addAll(i11, list2);
                i11 += list2.size();
            } else {
                i11++;
            }
        }
        return arrayList3;
    }

    private final int L(SemanticsNode semanticsNode) {
        androidx.compose.ui.semantics.i w11 = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5994a;
        return (w11.e(semanticsProperties.d()) || !semanticsNode.w().e(semanticsProperties.D())) ? this.f5624s : androidx.compose.ui.text.b0.g(((androidx.compose.ui.text.b0) semanticsNode.w().j(semanticsProperties.D())).n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int L0(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    private final int M(SemanticsNode semanticsNode) {
        androidx.compose.ui.semantics.i w11 = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5994a;
        return (w11.e(semanticsProperties.d()) || !semanticsNode.w().e(semanticsProperties.D())) ? this.f5624s : androidx.compose.ui.text.b0.k(((androidx.compose.ui.text.b0) semanticsNode.w().j(semanticsProperties.D())).n());
    }

    private static final boolean M0(ArrayList arrayList, SemanticsNode semanticsNode) {
        float i11 = semanticsNode.j().i();
        float c11 = semanticsNode.j().c();
        boolean z10 = i11 >= c11;
        int n11 = CollectionsKt.n(arrayList);
        if (n11 >= 0) {
            int i12 = 0;
            while (true) {
                y.i iVar = (y.i) ((Pair) arrayList.get(i12)).getFirst();
                boolean z11 = iVar.i() >= iVar.c();
                if (!z10 && !z11 && Math.max(i11, iVar.i()) < Math.min(c11, iVar.c())) {
                    arrayList.set(i12, new Pair(iVar.l(0.0f, i11, Float.POSITIVE_INFINITY, c11), ((Pair) arrayList.get(i12)).getSecond()));
                    ((List) ((Pair) arrayList.get(i12)).getSecond()).add(semanticsNode);
                    return true;
                }
                if (i12 == n11) {
                    break;
                }
                i12++;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final androidx.collection.o N() {
        if (this.f5628w) {
            this.f5628w = false;
            this.f5630y = e2.b(this.f5606a.getSemanticsOwner());
            if (c0()) {
                J0();
            }
        }
        return this.f5630y;
    }

    private final List N0(boolean z10, List list) {
        androidx.collection.e0 b11 = androidx.collection.p.b();
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            K((SemanticsNode) list.get(i11), arrayList, b11);
        }
        return K0(z10, arrayList, b11);
    }

    private final RectF O0(SemanticsNode semanticsNode, y.i iVar) {
        if (semanticsNode == null) {
            return null;
        }
        y.i q11 = iVar.q(semanticsNode.s());
        y.i i11 = semanticsNode.i();
        y.i m11 = q11.o(i11) ? q11.m(i11) : null;
        if (m11 == null) {
            return null;
        }
        long mo116localToScreenMKHz9U = this.f5606a.mo116localToScreenMKHz9U(y.h.a(m11.f(), m11.i()));
        long mo116localToScreenMKHz9U2 = this.f5606a.mo116localToScreenMKHz9U(y.h.a(m11.g(), m11.c()));
        return new RectF(y.g.m(mo116localToScreenMKHz9U), y.g.n(mo116localToScreenMKHz9U), y.g.m(mo116localToScreenMKHz9U2), y.g.n(mo116localToScreenMKHz9U2));
    }

    private final SpannableString P0(AnnotatedString annotatedString) {
        return (SpannableString) S0(androidx.compose.ui.text.platform.a.b(annotatedString, this.f5606a.getDensity(), this.f5606a.getFontFamilyResolver(), this.E), DefaultOggSeeker.MATCH_BYTE_RANGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z10) {
        androidComposeViewAccessibilityDelegateCompat.f5614i = androidComposeViewAccessibilityDelegateCompat.f5609d.getEnabledAccessibilityServiceList(-1);
    }

    private final boolean R0(SemanticsNode semanticsNode, int i11, boolean z10, boolean z11) {
        int i12;
        int i13;
        int o11 = semanticsNode.o();
        Integer num = this.f5625t;
        if (num == null || o11 != num.intValue()) {
            this.f5624s = -1;
            this.f5625t = Integer.valueOf(semanticsNode.o());
        }
        String V = V(semanticsNode);
        boolean z12 = false;
        if (V != null && V.length() != 0) {
            androidx.compose.ui.platform.f W = W(semanticsNode, i11);
            if (W == null) {
                return false;
            }
            int L2 = L(semanticsNode);
            if (L2 == -1) {
                L2 = z10 ? 0 : V.length();
            }
            int[] a11 = z10 ? W.a(L2) : W.b(L2);
            if (a11 == null) {
                return false;
            }
            int i14 = a11[0];
            z12 = true;
            int i15 = a11[1];
            if (z11 && b0(semanticsNode)) {
                i12 = M(semanticsNode);
                if (i12 == -1) {
                    i12 = z10 ? i14 : i15;
                }
                i13 = z10 ? i15 : i14;
            } else {
                i12 = z10 ? i15 : i14;
                i13 = i12;
            }
            this.f5629x = new f(semanticsNode, z10 ? 256 : 512, i11, i14, i15, SystemClock.uptimeMillis());
            D0(semanticsNode, i12, i13, true);
        }
        return z12;
    }

    private final boolean S(SemanticsNode semanticsNode) {
        androidx.compose.ui.semantics.i w11 = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5994a;
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.a(w11, semanticsProperties.F());
        androidx.compose.ui.semantics.f fVar = (androidx.compose.ui.semantics.f) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.x());
        boolean z10 = toggleableState != null;
        if (((Boolean) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.z())) != null) {
            return fVar != null ? androidx.compose.ui.semantics.f.k(fVar.n(), androidx.compose.ui.semantics.f.f6039b.g()) : false ? z10 : true;
        }
        return z10;
    }

    private final CharSequence S0(CharSequence charSequence, int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("size should be greater than 0");
        }
        if (charSequence == null || charSequence.length() == 0 || charSequence.length() <= i11) {
            return charSequence;
        }
        int i12 = i11 - 1;
        if (Character.isHighSurrogate(charSequence.charAt(i12)) && Character.isLowSurrogate(charSequence.charAt(i11))) {
            i11 = i12;
        }
        CharSequence subSequence = charSequence.subSequence(0, i11);
        Intrinsics.f(subSequence, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
        return subSequence;
    }

    private final String T(SemanticsNode semanticsNode) {
        int i11;
        androidx.compose.ui.semantics.i w11 = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5994a;
        Object a11 = SemanticsConfigurationKt.a(w11, semanticsProperties.A());
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.F());
        androidx.compose.ui.semantics.f fVar = (androidx.compose.ui.semantics.f) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.x());
        if (toggleableState != null) {
            int i12 = g.f5642a[toggleableState.ordinal()];
            if (i12 == 1) {
                if ((fVar == null ? false : androidx.compose.ui.semantics.f.k(fVar.n(), androidx.compose.ui.semantics.f.f6039b.f())) && a11 == null) {
                    a11 = this.f5606a.getContext().getResources().getString(R$string.state_on);
                }
            } else if (i12 == 2) {
                if ((fVar == null ? false : androidx.compose.ui.semantics.f.k(fVar.n(), androidx.compose.ui.semantics.f.f6039b.f())) && a11 == null) {
                    a11 = this.f5606a.getContext().getResources().getString(R$string.state_off);
                }
            } else if (i12 == 3 && a11 == null) {
                a11 = this.f5606a.getContext().getResources().getString(R$string.indeterminate);
            }
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.z());
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (!(fVar == null ? false : androidx.compose.ui.semantics.f.k(fVar.n(), androidx.compose.ui.semantics.f.f6039b.g())) && a11 == null) {
                a11 = booleanValue ? this.f5606a.getContext().getResources().getString(R$string.selected) : this.f5606a.getContext().getResources().getString(R$string.not_selected);
            }
        }
        androidx.compose.ui.semantics.e eVar = (androidx.compose.ui.semantics.e) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.w());
        if (eVar != null) {
            if (eVar != androidx.compose.ui.semantics.e.f6034d.a()) {
                if (a11 == null) {
                    ClosedFloatingPointRange c11 = eVar.c();
                    float b11 = ((((Number) c11.e()).floatValue() - ((Number) c11.j()).floatValue()) > 0.0f ? 1 : ((((Number) c11.e()).floatValue() - ((Number) c11.j()).floatValue()) == 0.0f ? 0 : -1)) == 0 ? 0.0f : (eVar.b() - ((Number) c11.j()).floatValue()) / (((Number) c11.e()).floatValue() - ((Number) c11.j()).floatValue());
                    if (b11 < 0.0f) {
                        b11 = 0.0f;
                    }
                    if (b11 > 1.0f) {
                        b11 = 1.0f;
                    }
                    if (b11 == 0.0f) {
                        i11 = 0;
                    } else {
                        i11 = 100;
                        if (!(b11 == 1.0f)) {
                            i11 = RangesKt.m(Math.round(b11 * 100), 1, 99);
                        }
                    }
                    a11 = this.f5606a.getContext().getResources().getString(R$string.template_percent, Integer.valueOf(i11));
                }
            } else if (a11 == null) {
                a11 = this.f5606a.getContext().getResources().getString(R$string.in_progress);
            }
        }
        if (semanticsNode.w().e(semanticsProperties.g())) {
            a11 = G(semanticsNode);
        }
        return (String) a11;
    }

    private final void T0(int i11) {
        int i12 = this.f5607b;
        if (i12 == i11) {
            return;
        }
        this.f5607b = i11;
        w0(this, i11, 128, null, null, 12, null);
        w0(this, i12, 256, null, null, 12, null);
    }

    private final AnnotatedString U(SemanticsNode semanticsNode) {
        AnnotatedString X = X(semanticsNode.w());
        List list = (List) SemanticsConfigurationKt.a(semanticsNode.w(), SemanticsProperties.f5994a.C());
        return X == null ? list != null ? (AnnotatedString) CollectionsKt.k0(list) : null : X;
    }

    private final void U0() {
        androidx.compose.ui.semantics.i b11;
        androidx.collection.f0 f0Var = new androidx.collection.f0(0, 1, null);
        androidx.collection.f0 f0Var2 = this.f5631z;
        int[] iArr = f0Var2.f2395b;
        long[] jArr = f0Var2.f2394a;
        int length = jArr.length - 2;
        long j11 = 128;
        long j12 = 255;
        char c11 = 7;
        long j13 = -9187201950435737472L;
        if (length >= 0) {
            int i11 = 0;
            while (true) {
                long j14 = jArr[i11];
                long[] jArr2 = jArr;
                if ((((~j14) << 7) & j14 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((j14 & j12) < j11) {
                            int i14 = iArr[(i11 << 3) + i13];
                            d2 d2Var = (d2) N().c(i14);
                            SemanticsNode b12 = d2Var != null ? d2Var.b() : null;
                            if (b12 == null || !b12.w().e(SemanticsProperties.f5994a.u())) {
                                f0Var.f(i14);
                                c2 c2Var = (c2) this.F.c(i14);
                                x0(i14, 32, (c2Var == null || (b11 = c2Var.b()) == null) ? null : (String) SemanticsConfigurationKt.a(b11, SemanticsProperties.f5994a.u()));
                            }
                        }
                        j14 >>= 8;
                        i13++;
                        j11 = 128;
                        j12 = 255;
                    }
                    if (i12 != 8) {
                        break;
                    }
                }
                if (i11 == length) {
                    break;
                }
                i11++;
                jArr = jArr2;
                j11 = 128;
                j12 = 255;
            }
        }
        this.f5631z.r(f0Var);
        this.F.i();
        androidx.collection.o N2 = N();
        int[] iArr2 = N2.f2379b;
        Object[] objArr = N2.f2380c;
        long[] jArr3 = N2.f2378a;
        int length2 = jArr3.length - 2;
        if (length2 >= 0) {
            int i15 = 0;
            while (true) {
                long j15 = jArr3[i15];
                if ((((~j15) << c11) & j15 & j13) != j13) {
                    int i16 = 8 - ((~(i15 - length2)) >>> 31);
                    for (int i17 = 0; i17 < i16; i17++) {
                        if ((j15 & 255) < 128) {
                            int i18 = (i15 << 3) + i17;
                            int i19 = iArr2[i18];
                            d2 d2Var2 = (d2) objArr[i18];
                            androidx.compose.ui.semantics.i w11 = d2Var2.b().w();
                            SemanticsProperties semanticsProperties = SemanticsProperties.f5994a;
                            if (w11.e(semanticsProperties.u()) && this.f5631z.f(i19)) {
                                x0(i19, 16, (String) d2Var2.b().w().j(semanticsProperties.u()));
                            }
                            this.F.t(i19, new c2(d2Var2.b(), N()));
                        }
                        j15 >>= 8;
                    }
                    if (i16 != 8) {
                        break;
                    }
                }
                if (i15 == length2) {
                    break;
                }
                i15++;
                c11 = 7;
                j13 = -9187201950435737472L;
            }
        }
        this.G = new c2(this.f5606a.getSemanticsOwner().a(), N());
    }

    private final String V(SemanticsNode semanticsNode) {
        AnnotatedString annotatedString;
        if (semanticsNode == null) {
            return null;
        }
        androidx.compose.ui.semantics.i w11 = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5994a;
        if (w11.e(semanticsProperties.d())) {
            return q0.a.d((List) semanticsNode.w().j(semanticsProperties.d()), ",", null, null, 0, null, null, 62, null);
        }
        if (semanticsNode.w().e(semanticsProperties.g())) {
            AnnotatedString X = X(semanticsNode.w());
            if (X != null) {
                return X.i();
            }
            return null;
        }
        List list = (List) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.C());
        if (list == null || (annotatedString = (AnnotatedString) CollectionsKt.k0(list)) == null) {
            return null;
        }
        return annotatedString.i();
    }

    private final androidx.compose.ui.platform.f W(SemanticsNode semanticsNode, int i11) {
        String V;
        androidx.compose.ui.text.z e11;
        if (semanticsNode == null || (V = V(semanticsNode)) == null || V.length() == 0) {
            return null;
        }
        if (i11 == 1) {
            androidx.compose.ui.platform.b a11 = androidx.compose.ui.platform.b.f5809d.a(this.f5606a.getContext().getResources().getConfiguration().locale);
            a11.e(V);
            return a11;
        }
        if (i11 == 2) {
            androidx.compose.ui.platform.g a12 = androidx.compose.ui.platform.g.f5856d.a(this.f5606a.getContext().getResources().getConfiguration().locale);
            a12.e(V);
            return a12;
        }
        if (i11 != 4) {
            if (i11 == 8) {
                androidx.compose.ui.platform.e a13 = androidx.compose.ui.platform.e.f5851c.a();
                a13.e(V);
                return a13;
            }
            if (i11 != 16) {
                return null;
            }
        }
        if (!semanticsNode.w().e(androidx.compose.ui.semantics.h.f6051a.i()) || (e11 = e2.e(semanticsNode.w())) == null) {
            return null;
        }
        if (i11 == 4) {
            androidx.compose.ui.platform.c a14 = androidx.compose.ui.platform.c.f5820d.a();
            a14.j(V, e11);
            return a14;
        }
        androidx.compose.ui.platform.d a15 = androidx.compose.ui.platform.d.f5832f.a();
        a15.j(V, e11, semanticsNode);
        return a15;
    }

    private final AnnotatedString X(androidx.compose.ui.semantics.i iVar) {
        return (AnnotatedString) SemanticsConfigurationKt.a(iVar, SemanticsProperties.f5994a.g());
    }

    private final boolean a0(int i11) {
        return this.f5617l == i11;
    }

    private final boolean b0(SemanticsNode semanticsNode) {
        androidx.compose.ui.semantics.i w11 = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5994a;
        return !w11.e(semanticsProperties.d()) && semanticsNode.w().e(semanticsProperties.g());
    }

    private final boolean d0(SemanticsNode semanticsNode) {
        List list = (List) SemanticsConfigurationKt.a(semanticsNode.w(), SemanticsProperties.f5994a.d());
        boolean z10 = ((list != null ? (String) CollectionsKt.k0(list) : null) == null && U(semanticsNode) == null && T(semanticsNode) == null && !S(semanticsNode)) ? false : true;
        if (semanticsNode.w().o()) {
            return true;
        }
        return semanticsNode.A() && z10;
    }

    private final boolean e0() {
        return this.f5610e || (this.f5609d.isEnabled() && this.f5609d.isTouchExplorationEnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(LayoutNode layoutNode) {
        if (this.f5626u.add(layoutNode)) {
            this.f5627v.c(Unit.f67184a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0190 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01af  */
    /* JADX WARN: Type inference failed for: r0v107 */
    /* JADX WARN: Type inference failed for: r0v108 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v49, types: [java.lang.Comparable] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Comparable] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Comparable] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v18, types: [java.lang.Comparable] */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:116:0x018d -> B:85:0x018e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i0(int r18, int r19, android.os.Bundle r20) {
        /*
            Method dump skipped, instructions count: 1838
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.i0(int, int, android.os.Bundle):boolean");
    }

    private static final boolean j0(androidx.compose.ui.semantics.g gVar, float f11) {
        return (f11 < 0.0f && ((Number) gVar.c().invoke()).floatValue() > 0.0f) || (f11 > 0.0f && ((Number) gVar.c().invoke()).floatValue() < ((Number) gVar.a().invoke()).floatValue());
    }

    private static final float k0(float f11, float f12) {
        if (Math.signum(f11) == Math.signum(f12)) {
            return Math.abs(f11) < Math.abs(f12) ? f11 : f12;
        }
        return 0.0f;
    }

    private final void l0(int i11, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, SemanticsNode semanticsNode) {
        boolean i12;
        boolean m11;
        boolean i13;
        boolean i14;
        View g11;
        boolean i15;
        boolean i16;
        boolean l11;
        boolean l12;
        boolean i17;
        boolean j11;
        boolean i18;
        boolean z10;
        boolean i19;
        boolean z11;
        accessibilityNodeInfoCompat.setClassName("android.view.View");
        androidx.compose.ui.semantics.i w11 = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5994a;
        if (w11.e(semanticsProperties.g())) {
            accessibilityNodeInfoCompat.setClassName("android.widget.EditText");
        }
        if (semanticsNode.w().e(semanticsProperties.C())) {
            accessibilityNodeInfoCompat.setClassName("android.widget.TextView");
        }
        androidx.compose.ui.semantics.f fVar = (androidx.compose.ui.semantics.f) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.x());
        if (fVar != null) {
            fVar.n();
            if (semanticsNode.x() || semanticsNode.t().isEmpty()) {
                f.a aVar = androidx.compose.ui.semantics.f.f6039b;
                if (androidx.compose.ui.semantics.f.k(fVar.n(), aVar.g())) {
                    accessibilityNodeInfoCompat.setRoleDescription(this.f5606a.getContext().getResources().getString(R$string.tab));
                } else if (androidx.compose.ui.semantics.f.k(fVar.n(), aVar.f())) {
                    accessibilityNodeInfoCompat.setRoleDescription(this.f5606a.getContext().getResources().getString(R$string.switch_role));
                } else {
                    String h11 = e2.h(fVar.n());
                    if (!androidx.compose.ui.semantics.f.k(fVar.n(), aVar.d()) || semanticsNode.A() || semanticsNode.w().o()) {
                        accessibilityNodeInfoCompat.setClassName(h11);
                    }
                }
            }
            Unit unit = Unit.f67184a;
        }
        accessibilityNodeInfoCompat.setPackageName(this.f5606a.getContext().getPackageName());
        accessibilityNodeInfoCompat.setImportantForAccessibility(e2.f(semanticsNode));
        List t11 = semanticsNode.t();
        int size = t11.size();
        for (int i20 = 0; i20 < size; i20++) {
            SemanticsNode semanticsNode2 = (SemanticsNode) t11.get(i20);
            if (N().a(semanticsNode2.o())) {
                AndroidViewHolder androidViewHolder = this.f5606a.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(semanticsNode2.q());
                if (semanticsNode2.o() != -1) {
                    if (androidViewHolder != null) {
                        accessibilityNodeInfoCompat.addChild(androidViewHolder);
                    } else {
                        accessibilityNodeInfoCompat.addChild(this.f5606a, semanticsNode2.o());
                    }
                }
            }
        }
        if (i11 == this.f5617l) {
            accessibilityNodeInfoCompat.setAccessibilityFocused(true);
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } else {
            accessibilityNodeInfoCompat.setAccessibilityFocused(false);
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
        }
        I0(semanticsNode, accessibilityNodeInfoCompat);
        E0(semanticsNode, accessibilityNodeInfoCompat);
        H0(semanticsNode, accessibilityNodeInfoCompat);
        F0(semanticsNode, accessibilityNodeInfoCompat);
        androidx.compose.ui.semantics.i w12 = semanticsNode.w();
        SemanticsProperties semanticsProperties2 = SemanticsProperties.f5994a;
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.a(w12, semanticsProperties2.F());
        if (toggleableState != null) {
            if (toggleableState == ToggleableState.On) {
                accessibilityNodeInfoCompat.setChecked(true);
            } else if (toggleableState == ToggleableState.Off) {
                accessibilityNodeInfoCompat.setChecked(false);
            }
            Unit unit2 = Unit.f67184a;
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties2.z());
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (fVar == null ? false : androidx.compose.ui.semantics.f.k(fVar.n(), androidx.compose.ui.semantics.f.f6039b.g())) {
                accessibilityNodeInfoCompat.setSelected(booleanValue);
            } else {
                accessibilityNodeInfoCompat.setChecked(booleanValue);
            }
            Unit unit3 = Unit.f67184a;
        }
        if (!semanticsNode.w().o() || semanticsNode.t().isEmpty()) {
            List list = (List) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties2.d());
            accessibilityNodeInfoCompat.setContentDescription(list != null ? (String) CollectionsKt.k0(list) : null);
        }
        String str = (String) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties2.B());
        if (str != null) {
            SemanticsNode semanticsNode3 = semanticsNode;
            while (true) {
                if (semanticsNode3 == null) {
                    z11 = false;
                    break;
                }
                androidx.compose.ui.semantics.i w13 = semanticsNode3.w();
                SemanticsPropertiesAndroid semanticsPropertiesAndroid = SemanticsPropertiesAndroid.f6020a;
                if (w13.e(semanticsPropertiesAndroid.a())) {
                    z11 = ((Boolean) semanticsNode3.w().j(semanticsPropertiesAndroid.a())).booleanValue();
                    break;
                }
                semanticsNode3 = semanticsNode3.r();
            }
            if (z11) {
                accessibilityNodeInfoCompat.setViewIdResourceName(str);
            }
        }
        androidx.compose.ui.semantics.i w14 = semanticsNode.w();
        SemanticsProperties semanticsProperties3 = SemanticsProperties.f5994a;
        if (((Unit) SemanticsConfigurationKt.a(w14, semanticsProperties3.j())) != null) {
            accessibilityNodeInfoCompat.setHeading(true);
            Unit unit4 = Unit.f67184a;
        }
        accessibilityNodeInfoCompat.setPassword(semanticsNode.w().e(semanticsProperties3.v()));
        accessibilityNodeInfoCompat.setEditable(semanticsNode.w().e(semanticsProperties3.p()));
        Integer num = (Integer) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties3.t());
        accessibilityNodeInfoCompat.setMaxTextLength(num != null ? num.intValue() : -1);
        i12 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.i(semanticsNode);
        accessibilityNodeInfoCompat.setEnabled(i12);
        accessibilityNodeInfoCompat.setFocusable(semanticsNode.w().e(semanticsProperties3.i()));
        if (accessibilityNodeInfoCompat.isFocusable()) {
            accessibilityNodeInfoCompat.setFocused(((Boolean) semanticsNode.w().j(semanticsProperties3.i())).booleanValue());
            if (accessibilityNodeInfoCompat.isFocused()) {
                accessibilityNodeInfoCompat.addAction(2);
            } else {
                accessibilityNodeInfoCompat.addAction(1);
            }
        }
        m11 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.m(semanticsNode);
        accessibilityNodeInfoCompat.setVisibleToUser(m11);
        android.support.v4.media.session.c.a(SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties3.s()));
        accessibilityNodeInfoCompat.setClickable(false);
        androidx.compose.ui.semantics.i w15 = semanticsNode.w();
        androidx.compose.ui.semantics.h hVar = androidx.compose.ui.semantics.h.f6051a;
        androidx.compose.ui.semantics.a aVar2 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(w15, hVar.j());
        if (aVar2 != null) {
            boolean c11 = Intrinsics.c(SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties3.z()), Boolean.TRUE);
            f.a aVar3 = androidx.compose.ui.semantics.f.f6039b;
            if (!(fVar == null ? false : androidx.compose.ui.semantics.f.k(fVar.n(), aVar3.g()))) {
                if (!(fVar == null ? false : androidx.compose.ui.semantics.f.k(fVar.n(), aVar3.e()))) {
                    z10 = false;
                    accessibilityNodeInfoCompat.setClickable(z10 || (z10 && !c11));
                    i19 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.i(semanticsNode);
                    if (i19 && accessibilityNodeInfoCompat.isClickable()) {
                        accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, aVar2.b()));
                    }
                    Unit unit5 = Unit.f67184a;
                }
            }
            z10 = true;
            accessibilityNodeInfoCompat.setClickable(z10 || (z10 && !c11));
            i19 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.i(semanticsNode);
            if (i19) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, aVar2.b()));
            }
            Unit unit52 = Unit.f67184a;
        }
        accessibilityNodeInfoCompat.setLongClickable(false);
        androidx.compose.ui.semantics.a aVar4 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), hVar.l());
        if (aVar4 != null) {
            accessibilityNodeInfoCompat.setLongClickable(true);
            i18 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.i(semanticsNode);
            if (i18) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32, aVar4.b()));
            }
            Unit unit6 = Unit.f67184a;
        }
        androidx.compose.ui.semantics.a aVar5 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), hVar.c());
        if (aVar5 != null) {
            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, aVar5.b()));
            Unit unit7 = Unit.f67184a;
        }
        i13 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.i(semanticsNode);
        if (i13) {
            androidx.compose.ui.semantics.a aVar6 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), hVar.x());
            if (aVar6 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2097152, aVar6.b()));
                Unit unit8 = Unit.f67184a;
            }
            androidx.compose.ui.semantics.a aVar7 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), hVar.k());
            if (aVar7 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionImeEnter, aVar7.b()));
                Unit unit9 = Unit.f67184a;
            }
            androidx.compose.ui.semantics.a aVar8 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), hVar.e());
            if (aVar8 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, aVar8.b()));
                Unit unit10 = Unit.f67184a;
            }
            androidx.compose.ui.semantics.a aVar9 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), hVar.q());
            if (aVar9 != null) {
                if (accessibilityNodeInfoCompat.isFocused() && this.f5606a.getClipboardManager().b()) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, aVar9.b()));
                }
                Unit unit11 = Unit.f67184a;
            }
        }
        String V = V(semanticsNode);
        if (!(V == null || V.length() == 0)) {
            accessibilityNodeInfoCompat.setTextSelection(M(semanticsNode), L(semanticsNode));
            androidx.compose.ui.semantics.a aVar10 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), hVar.w());
            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, aVar10 != null ? aVar10.b() : null));
            accessibilityNodeInfoCompat.addAction(256);
            accessibilityNodeInfoCompat.addAction(512);
            accessibilityNodeInfoCompat.setMovementGranularities(11);
            List list2 = (List) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties3.d());
            if ((list2 == null || list2.isEmpty()) && semanticsNode.w().e(hVar.i())) {
                j11 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.j(semanticsNode);
                if (!j11) {
                    accessibilityNodeInfoCompat.setMovementGranularities(accessibilityNodeInfoCompat.getMovementGranularities() | 20);
                }
            }
        }
        int i21 = Build.VERSION.SDK_INT;
        if (i21 >= 26) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("androidx.compose.ui.semantics.id");
            CharSequence text = accessibilityNodeInfoCompat.getText();
            if (!(text == null || text.length() == 0) && semanticsNode.w().e(hVar.i())) {
                arrayList.add(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY);
            }
            if (semanticsNode.w().e(semanticsProperties3.B())) {
                arrayList.add("androidx.compose.ui.semantics.testTag");
            }
            accessibilityNodeInfoCompat.setAvailableExtraData(arrayList);
        }
        androidx.compose.ui.semantics.e eVar = (androidx.compose.ui.semantics.e) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties3.w());
        if (eVar != null) {
            if (semanticsNode.w().e(hVar.v())) {
                accessibilityNodeInfoCompat.setClassName("android.widget.SeekBar");
            } else {
                accessibilityNodeInfoCompat.setClassName("android.widget.ProgressBar");
            }
            if (eVar != androidx.compose.ui.semantics.e.f6034d.a()) {
                accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, ((Number) eVar.c().j()).floatValue(), ((Number) eVar.c().e()).floatValue(), eVar.b()));
            }
            if (semanticsNode.w().e(hVar.v())) {
                i17 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.i(semanticsNode);
                if (i17) {
                    if (eVar.b() < RangesKt.e(((Number) eVar.c().e()).floatValue(), ((Number) eVar.c().j()).floatValue())) {
                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    }
                    if (eVar.b() > RangesKt.h(((Number) eVar.c().j()).floatValue(), ((Number) eVar.c().e()).floatValue())) {
                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    }
                }
            }
        }
        if (i21 >= 24) {
            b.a(accessibilityNodeInfoCompat, semanticsNode);
        }
        CollectionInfo_androidKt.d(semanticsNode, accessibilityNodeInfoCompat);
        CollectionInfo_androidKt.e(semanticsNode, accessibilityNodeInfoCompat);
        androidx.compose.ui.semantics.g gVar = (androidx.compose.ui.semantics.g) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties3.k());
        androidx.compose.ui.semantics.a aVar11 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), hVar.s());
        if (gVar != null && aVar11 != null) {
            if (!CollectionInfo_androidKt.b(semanticsNode)) {
                accessibilityNodeInfoCompat.setClassName("android.widget.HorizontalScrollView");
            }
            if (((Number) gVar.a().invoke()).floatValue() > 0.0f) {
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            i16 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.i(semanticsNode);
            if (i16) {
                if (n0(gVar)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    l12 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.l(semanticsNode);
                    accessibilityNodeInfoCompat.addAction(!l12 ? AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT : AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT);
                }
                if (m0(gVar)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    l11 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.l(semanticsNode);
                    accessibilityNodeInfoCompat.addAction(!l11 ? AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT : AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT);
                }
            }
        }
        androidx.compose.ui.semantics.g gVar2 = (androidx.compose.ui.semantics.g) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties3.H());
        if (gVar2 != null && aVar11 != null) {
            if (!CollectionInfo_androidKt.b(semanticsNode)) {
                accessibilityNodeInfoCompat.setClassName("android.widget.ScrollView");
            }
            if (((Number) gVar2.a().invoke()).floatValue() > 0.0f) {
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            i15 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.i(semanticsNode);
            if (i15) {
                if (n0(gVar2)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                }
                if (m0(gVar2)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                }
            }
        }
        if (i21 >= 29) {
            c.a(accessibilityNodeInfoCompat, semanticsNode);
        }
        accessibilityNodeInfoCompat.setPaneTitle((CharSequence) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties3.u()));
        i14 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.i(semanticsNode);
        if (i14) {
            androidx.compose.ui.semantics.a aVar12 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), hVar.g());
            if (aVar12 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, aVar12.b()));
                Unit unit12 = Unit.f67184a;
            }
            androidx.compose.ui.semantics.a aVar13 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), hVar.b());
            if (aVar13 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, aVar13.b()));
                Unit unit13 = Unit.f67184a;
            }
            androidx.compose.ui.semantics.a aVar14 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), hVar.f());
            if (aVar14 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1048576, aVar14.b()));
                Unit unit14 = Unit.f67184a;
            }
            if (semanticsNode.w().e(hVar.d())) {
                List list3 = (List) semanticsNode.w().j(hVar.d());
                int size2 = list3.size();
                androidx.collection.m mVar = N;
                if (size2 >= mVar.b()) {
                    throw new IllegalStateException("Can't have more than " + mVar.b() + " custom actions for one widget");
                }
                androidx.collection.y0 y0Var = new androidx.collection.y0(0, 1, null);
                androidx.collection.k0 b11 = androidx.collection.q0.b();
                if (this.f5623r.d(i11)) {
                    androidx.collection.k0 k0Var = (androidx.collection.k0) this.f5623r.f(i11);
                    androidx.collection.d0 d0Var = new androidx.collection.d0(0, 1, null);
                    int[] iArr = mVar.f2373a;
                    int i22 = mVar.f2374b;
                    for (int i23 = 0; i23 < i22; i23++) {
                        d0Var.e(iArr[i23]);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    if (list3.size() > 0) {
                        android.support.v4.media.session.c.a(list3.get(0));
                        Intrinsics.e(k0Var);
                        throw null;
                    }
                    if (arrayList2.size() > 0) {
                        android.support.v4.media.session.c.a(arrayList2.get(0));
                        d0Var.a(0);
                        throw null;
                    }
                } else if (list3.size() > 0) {
                    android.support.v4.media.session.c.a(list3.get(0));
                    mVar.a(0);
                    throw null;
                }
                this.f5622q.l(i11, y0Var);
                this.f5623r.l(i11, b11);
            }
        }
        accessibilityNodeInfoCompat.setScreenReaderFocusable(d0(semanticsNode));
        int e11 = this.A.e(i11, -1);
        if (e11 != -1) {
            View g12 = e2.g(this.f5606a.getAndroidViewsHandler$ui_release(), e11);
            if (g12 != null) {
                accessibilityNodeInfoCompat.setTraversalBefore(g12);
            } else {
                accessibilityNodeInfoCompat.setTraversalBefore(this.f5606a, e11);
            }
            x(i11, accessibilityNodeInfoCompat, this.C, null);
        }
        int e12 = this.B.e(i11, -1);
        if (e12 == -1 || (g11 = e2.g(this.f5606a.getAndroidViewsHandler$ui_release(), e12)) == null) {
            return;
        }
        accessibilityNodeInfoCompat.setTraversalAfter(g11);
        x(i11, accessibilityNodeInfoCompat, this.D, null);
    }

    private static final boolean m0(androidx.compose.ui.semantics.g gVar) {
        return (((Number) gVar.c().invoke()).floatValue() > 0.0f && !gVar.b()) || (((Number) gVar.c().invoke()).floatValue() < ((Number) gVar.a().invoke()).floatValue() && gVar.b());
    }

    private static final boolean n0(androidx.compose.ui.semantics.g gVar) {
        return (((Number) gVar.c().invoke()).floatValue() < ((Number) gVar.a().invoke()).floatValue() && !gVar.b()) || (((Number) gVar.c().invoke()).floatValue() > 0.0f && gVar.b());
    }

    private final boolean o0(int i11, List list) {
        boolean z10;
        b2 a11 = e2.a(list, i11);
        if (a11 != null) {
            z10 = false;
        } else {
            a11 = new b2(i11, this.J, null, null, null, null);
            z10 = true;
        }
        this.J.add(a11);
        return z10;
    }

    private final boolean p0(int i11) {
        if (!e0() || a0(i11)) {
            return false;
        }
        int i12 = this.f5617l;
        if (i12 != Integer.MIN_VALUE) {
            w0(this, i12, 65536, null, null, 12, null);
        }
        this.f5617l = i11;
        this.f5606a.invalidate();
        w0(this, i11, 32768, null, null, 12, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(final b2 b2Var) {
        if (b2Var.isValidOwnerScope()) {
            this.f5606a.getSnapshotObserver().i(b2Var, this.K, new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeeded$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m158invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m158invoke() {
                    int s02;
                    androidx.collection.o N2;
                    androidx.collection.o N3;
                    SemanticsNode b11;
                    LayoutNode q11;
                    androidx.collection.e0 e0Var;
                    androidx.collection.e0 e0Var2;
                    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
                    Rect y10;
                    androidx.compose.ui.semantics.g a11 = b2.this.a();
                    androidx.compose.ui.semantics.g e11 = b2.this.e();
                    Float b12 = b2.this.b();
                    Float c11 = b2.this.c();
                    float floatValue = (a11 == null || b12 == null) ? 0.0f : ((Number) a11.c().invoke()).floatValue() - b12.floatValue();
                    float floatValue2 = (e11 == null || c11 == null) ? 0.0f : ((Number) e11.c().invoke()).floatValue() - c11.floatValue();
                    if (floatValue != 0.0f || floatValue2 != 0.0f) {
                        s02 = this.s0(b2.this.d());
                        N2 = this.N();
                        d2 d2Var = (d2) N2.c(this.f5617l);
                        if (d2Var != null) {
                            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this;
                            try {
                                accessibilityNodeInfoCompat = androidComposeViewAccessibilityDelegateCompat.f5618m;
                                if (accessibilityNodeInfoCompat != null) {
                                    y10 = androidComposeViewAccessibilityDelegateCompat.y(d2Var);
                                    accessibilityNodeInfoCompat.setBoundsInScreen(y10);
                                    Unit unit = Unit.f67184a;
                                }
                            } catch (IllegalStateException unused) {
                                Unit unit2 = Unit.f67184a;
                            }
                        }
                        this.Y().invalidate();
                        N3 = this.N();
                        d2 d2Var2 = (d2) N3.c(s02);
                        if (d2Var2 != null && (b11 = d2Var2.b()) != null && (q11 = b11.q()) != null) {
                            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat2 = this;
                            if (a11 != null) {
                                e0Var2 = androidComposeViewAccessibilityDelegateCompat2.f5620o;
                                e0Var2.t(s02, a11);
                            }
                            if (e11 != null) {
                                e0Var = androidComposeViewAccessibilityDelegateCompat2.f5621p;
                                e0Var.t(s02, e11);
                            }
                            androidComposeViewAccessibilityDelegateCompat2.f0(q11);
                        }
                    }
                    if (a11 != null) {
                        b2.this.g((Float) a11.c().invoke());
                    }
                    if (e11 != null) {
                        b2.this.h((Float) e11.c().invoke());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        Trace.beginSection("measureAndLayout");
        try {
            androidx.compose.ui.node.x0.c(androidComposeViewAccessibilityDelegateCompat.f5606a, false, 1, null);
            Unit unit = Unit.f67184a;
            Trace.endSection();
            Trace.beginSection("checkForSemanticsChanges");
            try {
                androidComposeViewAccessibilityDelegateCompat.C();
                Trace.endSection();
                androidComposeViewAccessibilityDelegateCompat.H = false;
            } finally {
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int s0(int i11) {
        if (i11 == this.f5606a.getSemanticsOwner().a().o()) {
            return -1;
        }
        return i11;
    }

    private final void t0(SemanticsNode semanticsNode, c2 c2Var) {
        androidx.collection.f0 b11 = androidx.collection.r.b();
        List t11 = semanticsNode.t();
        int size = t11.size();
        for (int i11 = 0; i11 < size; i11++) {
            SemanticsNode semanticsNode2 = (SemanticsNode) t11.get(i11);
            if (N().a(semanticsNode2.o())) {
                if (!c2Var.a().a(semanticsNode2.o())) {
                    f0(semanticsNode.q());
                    return;
                }
                b11.f(semanticsNode2.o());
            }
        }
        androidx.collection.f0 a11 = c2Var.a();
        int[] iArr = a11.f2395b;
        long[] jArr = a11.f2394a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i12 = 0;
            while (true) {
                long j11 = jArr[i12];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i13 = 8 - ((~(i12 - length)) >>> 31);
                    for (int i14 = 0; i14 < i13; i14++) {
                        if ((255 & j11) < 128 && !b11.a(iArr[(i12 << 3) + i14])) {
                            f0(semanticsNode.q());
                            return;
                        }
                        j11 >>= 8;
                    }
                    if (i13 != 8) {
                        break;
                    }
                }
                if (i12 == length) {
                    break;
                } else {
                    i12++;
                }
            }
        }
        List t12 = semanticsNode.t();
        int size2 = t12.size();
        for (int i15 = 0; i15 < size2; i15++) {
            SemanticsNode semanticsNode3 = (SemanticsNode) t12.get(i15);
            if (N().a(semanticsNode3.o())) {
                Object c11 = this.F.c(semanticsNode3.o());
                Intrinsics.e(c11);
                t0(semanticsNode3, (c2) c11);
            }
        }
    }

    private final boolean u0(AccessibilityEvent accessibilityEvent) {
        if (!c0()) {
            return false;
        }
        if (accessibilityEvent.getEventType() == 2048 || accessibilityEvent.getEventType() == 32768) {
            this.f5619n = true;
        }
        try {
            return ((Boolean) this.f5608c.invoke(accessibilityEvent)).booleanValue();
        } finally {
            this.f5619n = false;
        }
    }

    private final boolean v0(int i11, int i12, Integer num, List list) {
        if (i11 == Integer.MIN_VALUE || !c0()) {
            return false;
        }
        AccessibilityEvent E = E(i11, i12);
        if (num != null) {
            E.setContentChangeTypes(num.intValue());
        }
        if (list != null) {
            E.setContentDescription(q0.a.d(list, ",", null, null, 0, null, null, 62, null));
        }
        Trace.beginSection("sendEvent");
        try {
            return u0(E);
        } finally {
            Trace.endSection();
        }
    }

    static /* synthetic */ boolean w0(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i11, int i12, Integer num, List list, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            num = null;
        }
        if ((i13 & 8) != 0) {
            list = null;
        }
        return androidComposeViewAccessibilityDelegateCompat.v0(i11, i12, num, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(int i11, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String str, Bundle bundle) {
        SemanticsNode b11;
        d2 d2Var = (d2) N().c(i11);
        if (d2Var == null || (b11 = d2Var.b()) == null) {
            return;
        }
        String V = V(b11);
        if (Intrinsics.c(str, this.C)) {
            int e11 = this.A.e(i11, -1);
            if (e11 != -1) {
                accessibilityNodeInfoCompat.getExtras().putInt(str, e11);
                return;
            }
            return;
        }
        if (Intrinsics.c(str, this.D)) {
            int e12 = this.B.e(i11, -1);
            if (e12 != -1) {
                accessibilityNodeInfoCompat.getExtras().putInt(str, e12);
                return;
            }
            return;
        }
        if (!b11.w().e(androidx.compose.ui.semantics.h.f6051a.i()) || bundle == null || !Intrinsics.c(str, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY)) {
            androidx.compose.ui.semantics.i w11 = b11.w();
            SemanticsProperties semanticsProperties = SemanticsProperties.f5994a;
            if (!w11.e(semanticsProperties.B()) || bundle == null || !Intrinsics.c(str, "androidx.compose.ui.semantics.testTag")) {
                if (Intrinsics.c(str, "androidx.compose.ui.semantics.id")) {
                    accessibilityNodeInfoCompat.getExtras().putInt(str, b11.o());
                    return;
                }
                return;
            } else {
                String str2 = (String) SemanticsConfigurationKt.a(b11.w(), semanticsProperties.B());
                if (str2 != null) {
                    accessibilityNodeInfoCompat.getExtras().putCharSequence(str, str2);
                    return;
                }
                return;
            }
        }
        int i12 = bundle.getInt(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX, -1);
        int i13 = bundle.getInt(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH, -1);
        if (i13 > 0 && i12 >= 0) {
            if (i12 < (V != null ? V.length() : Integer.MAX_VALUE)) {
                androidx.compose.ui.text.z e13 = e2.e(b11.w());
                if (e13 == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i14 = 0; i14 < i13; i14++) {
                    int i15 = i12 + i14;
                    if (i15 >= e13.k().j().length()) {
                        arrayList.add(null);
                    } else {
                        arrayList.add(O0(b11, e13.d(i15)));
                    }
                }
                accessibilityNodeInfoCompat.getExtras().putParcelableArray(str, (Parcelable[]) arrayList.toArray(new RectF[0]));
                return;
            }
        }
        Log.e("AccessibilityDelegate", "Invalid arguments for accessibility character locations");
    }

    private final void x0(int i11, int i12, String str) {
        AccessibilityEvent E = E(s0(i11), 32);
        E.setContentChangeTypes(i12);
        if (str != null) {
            E.getText().add(str);
        }
        u0(E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect y(d2 d2Var) {
        Rect a11 = d2Var.a();
        long mo116localToScreenMKHz9U = this.f5606a.mo116localToScreenMKHz9U(y.h.a(a11.left, a11.top));
        long mo116localToScreenMKHz9U2 = this.f5606a.mo116localToScreenMKHz9U(y.h.a(a11.right, a11.bottom));
        return new Rect((int) Math.floor(y.g.m(mo116localToScreenMKHz9U)), (int) Math.floor(y.g.n(mo116localToScreenMKHz9U)), (int) Math.ceil(y.g.m(mo116localToScreenMKHz9U2)), (int) Math.ceil(y.g.n(mo116localToScreenMKHz9U2)));
    }

    private final void y0(int i11) {
        f fVar = this.f5629x;
        if (fVar != null) {
            if (i11 != fVar.d().o()) {
                return;
            }
            if (SystemClock.uptimeMillis() - fVar.f() <= 1000) {
                AccessibilityEvent E = E(s0(fVar.d().o()), 131072);
                E.setFromIndex(fVar.b());
                E.setToIndex(fVar.e());
                E.setAction(fVar.a());
                E.setMovementGranularity(fVar.c());
                E.getText().add(V(fVar.d()));
                u0(E);
            }
        }
        this.f5629x = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:153:0x0560, code lost:
    
        if (r0.containsAll(r2) != false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0563, code lost:
    
        r21 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x05c9, code lost:
    
        if (r0 == false) goto L160;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void z0(androidx.collection.o r37) {
        /*
            Method dump skipped, instructions count: 1620
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.z0(androidx.collection.o):void");
    }

    public final boolean A(boolean z10, int i11, long j11) {
        if (Intrinsics.c(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            return B(N(), z10, i11, j11);
        }
        return false;
    }

    public final void C0(boolean z10) {
        this.f5610e = z10;
        this.f5628w = true;
    }

    public final void G0(long j11) {
        this.f5611f = j11;
    }

    public final boolean I(MotionEvent motionEvent) {
        if (!e0()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int Z = Z(motionEvent.getX(), motionEvent.getY());
            boolean dispatchGenericMotionEvent = this.f5606a.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(motionEvent);
            T0(Z);
            if (Z == Integer.MIN_VALUE) {
                return dispatchGenericMotionEvent;
            }
            return true;
        }
        if (action != 10) {
            return false;
        }
        if (this.f5607b == Integer.MIN_VALUE) {
            return this.f5606a.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(motionEvent);
        }
        T0(Integer.MIN_VALUE);
        return true;
    }

    public final String O() {
        return this.D;
    }

    public final String P() {
        return this.C;
    }

    public final androidx.collection.c0 Q() {
        return this.B;
    }

    public final androidx.collection.c0 R() {
        return this.A;
    }

    public final AndroidComposeView Y() {
        return this.f5606a;
    }

    public final int Z(float f11, float f12) {
        androidx.compose.ui.node.q0 e02;
        boolean m11;
        androidx.compose.ui.node.x0.c(this.f5606a, false, 1, null);
        androidx.compose.ui.node.q qVar = new androidx.compose.ui.node.q();
        this.f5606a.getRoot().s0(y.h.a(f11, f12), qVar, (r13 & 4) != 0, (r13 & 8) != 0);
        f.c cVar = (f.c) CollectionsKt.v0(qVar);
        LayoutNode m12 = cVar != null ? androidx.compose.ui.node.g.m(cVar) : null;
        if (m12 != null && (e02 = m12.e0()) != null && e02.q(androidx.compose.ui.node.s0.a(8))) {
            m11 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.m(androidx.compose.ui.semantics.l.a(m12, false));
            if (m11 && this.f5606a.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(m12) == null) {
                return s0(m12.j0());
            }
        }
        return Integer.MIN_VALUE;
    }

    public final boolean c0() {
        return this.f5610e || (this.f5609d.isEnabled() && !this.f5614i.isEmpty());
    }

    public final void g0(LayoutNode layoutNode) {
        this.f5628w = true;
        if (c0()) {
            f0(layoutNode);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        return this.f5616k;
    }

    public final void h0() {
        this.f5628w = true;
        if (!c0() || this.H) {
            return;
        }
        this.H = true;
        this.f5615j.post(this.I);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0073 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:12:0x0035, B:14:0x0065, B:19:0x0077, B:21:0x007f, B:23:0x0088, B:25:0x0091, B:27:0x00a2, B:29:0x00a9, B:30:0x00b2, B:39:0x0051), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0086 -> B:13:0x00d2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00cf -> B:13:0x00d2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(kotlin.coroutines.Continuation r12) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.z(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
