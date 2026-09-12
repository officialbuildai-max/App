package androidx.compose.ui.contentcapture;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.LongSparseArray;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.translation.TranslationRequestValue;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import androidx.collection.e0;
import androidx.collection.f0;
import androidx.collection.o;
import androidx.collection.p;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.x0;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.c2;
import androidx.compose.ui.platform.d2;
import androidx.compose.ui.platform.e2;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.y;
import androidx.compose.ui.text.z;
import androidx.view.u;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o0.w;

/* loaded from: classes.dex */
public final class AndroidContentCaptureManager implements m, androidx.view.f, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final AndroidComposeView f4183a;

    /* renamed from: b, reason: collision with root package name */
    private Function0 f4184b;

    /* renamed from: c, reason: collision with root package name */
    private androidx.compose.ui.platform.coreshims.d f4185c;

    /* renamed from: d, reason: collision with root package name */
    private final e0 f4186d;

    /* renamed from: e, reason: collision with root package name */
    private final f0 f4187e;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.collection.b f4191i;

    /* renamed from: m, reason: collision with root package name */
    private long f4195m;

    /* renamed from: o, reason: collision with root package name */
    private c2 f4197o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f4198p;

    /* renamed from: f, reason: collision with root package name */
    private long f4188f = 100;

    /* renamed from: g, reason: collision with root package name */
    private TranslateStatus f4189g = TranslateStatus.SHOW_ORIGINAL;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4190h = true;

    /* renamed from: j, reason: collision with root package name */
    private final kotlinx.coroutines.channels.d f4192j = kotlinx.coroutines.channels.g.b(1, null, null, 6, null);

    /* renamed from: k, reason: collision with root package name */
    private final Handler f4193k = new Handler(Looper.getMainLooper());

    /* renamed from: l, reason: collision with root package name */
    private o f4194l = p.a();

    /* renamed from: n, reason: collision with root package name */
    private e0 f4196n = p.b();

    /* renamed from: q, reason: collision with root package name */
    private final Runnable f4199q = new Runnable() { // from class: androidx.compose.ui.contentcapture.a
        @Override // java.lang.Runnable
        public final void run() {
            AndroidContentCaptureManager.g(AndroidContentCaptureManager.this);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$TranslateStatus;", "", "(Ljava/lang/String;I)V", "SHOW_ORIGINAL", "SHOW_TRANSLATED", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes.dex */
    public enum TranslateStatus {
        SHOW_ORIGINAL,
        SHOW_TRANSLATED
    }

    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f4200a = new a();

        private a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
        
            r3 = r3.getText();
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
        
            r3 = r3.getValue("android:text");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void b(androidx.compose.ui.contentcapture.AndroidContentCaptureManager r11, android.util.LongSparseArray r12) {
            /*
                r10 = this;
                kotlin.collections.LongIterator r0 = androidx.core.util.c.a(r12)
            L4:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L68
                long r1 = r0.a()
                java.lang.Object r3 = r12.get(r1)
                android.view.translation.ViewTranslationResponse r3 = androidx.compose.ui.contentcapture.i.a(r3)
                if (r3 == 0) goto L4
                java.lang.String r4 = "android:text"
                android.view.translation.TranslationResponseValue r3 = androidx.compose.ui.contentcapture.j.a(r3, r4)
                if (r3 == 0) goto L4
                java.lang.CharSequence r3 = androidx.compose.ui.contentcapture.k.a(r3)
                if (r3 == 0) goto L4
                androidx.collection.o r4 = r11.h()
                int r1 = (int) r1
                java.lang.Object r1 = r4.c(r1)
                androidx.compose.ui.platform.d2 r1 = (androidx.compose.ui.platform.d2) r1
                if (r1 == 0) goto L4
                androidx.compose.ui.semantics.SemanticsNode r1 = r1.b()
                if (r1 == 0) goto L4
                androidx.compose.ui.semantics.i r1 = r1.w()
                androidx.compose.ui.semantics.h r2 = androidx.compose.ui.semantics.h.f6051a
                androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.y()
                java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.a(r1, r2)
                androidx.compose.ui.semantics.a r1 = (androidx.compose.ui.semantics.a) r1
                if (r1 == 0) goto L4
                kotlin.Function r1 = r1.a()
                kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
                if (r1 == 0) goto L4
                androidx.compose.ui.text.AnnotatedString r2 = new androidx.compose.ui.text.AnnotatedString
                java.lang.String r5 = r3.toString()
                r8 = 6
                r9 = 0
                r6 = 0
                r7 = 0
                r4 = r2
                r4.<init>(r5, r6, r7, r8, r9)
                java.lang.Object r1 = r1.invoke(r2)
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                goto L4
            L68:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.contentcapture.AndroidContentCaptureManager.a.b(androidx.compose.ui.contentcapture.AndroidContentCaptureManager, android.util.LongSparseArray):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(AndroidContentCaptureManager androidContentCaptureManager, LongSparseArray longSparseArray) {
            f4200a.b(androidContentCaptureManager, longSparseArray);
        }

        public final void c(AndroidContentCaptureManager androidContentCaptureManager, long[] jArr, int[] iArr, Consumer<ViewTranslationRequest> consumer) {
            SemanticsNode b11;
            String d11;
            TranslationRequestValue forText;
            ViewTranslationRequest build;
            for (long j11 : jArr) {
                d2 d2Var = (d2) androidContentCaptureManager.h().c((int) j11);
                if (d2Var != null && (b11 = d2Var.b()) != null) {
                    c.a();
                    ViewTranslationRequest.Builder a11 = b.a(d.a(androidContentCaptureManager.i()), b11.o());
                    List list = (List) SemanticsConfigurationKt.a(b11.w(), SemanticsProperties.f5994a.C());
                    if (list != null && (d11 = q0.a.d(list, "\n", null, null, 0, null, null, 62, null)) != null) {
                        forText = TranslationRequestValue.forText(new AnnotatedString(d11, null, null, 6, null));
                        a11.setValue("android:text", forText);
                        build = a11.build();
                        consumer.accept(build);
                    }
                }
            }
        }

        public final void d(final AndroidContentCaptureManager androidContentCaptureManager, final LongSparseArray<ViewTranslationResponse> longSparseArray) {
            if (Build.VERSION.SDK_INT < 31) {
                return;
            }
            if (Intrinsics.c(Looper.getMainLooper().getThread(), Thread.currentThread())) {
                b(androidContentCaptureManager, longSparseArray);
            } else {
                androidContentCaptureManager.i().post(new Runnable() { // from class: androidx.compose.ui.contentcapture.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        AndroidContentCaptureManager.a.e(AndroidContentCaptureManager.this, longSparseArray);
                    }
                });
            }
        }
    }

    public AndroidContentCaptureManager(AndroidComposeView androidComposeView, Function0 function0) {
        this.f4183a = androidComposeView;
        this.f4184b = function0;
        int i11 = 0;
        int i12 = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.f4186d = new e0(i11, i12, defaultConstructorMarker);
        this.f4187e = new f0(i11, i12, defaultConstructorMarker);
        this.f4191i = new androidx.collection.b(i11, i12, defaultConstructorMarker);
        this.f4197o = new c2(androidComposeView.getSemanticsOwner().a(), p.a());
    }

    private final void A(SemanticsNode semanticsNode) {
        if (k()) {
            d(semanticsNode.o());
            List t11 = semanticsNode.t();
            int size = t11.size();
            for (int i11 = 0; i11 < size; i11++) {
                A((SemanticsNode) t11.get(i11));
            }
        }
    }

    private final void B() {
        this.f4196n.i();
        o h11 = h();
        int[] iArr = h11.f2379b;
        Object[] objArr = h11.f2380c;
        long[] jArr = h11.f2378a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i11 = 0;
            while (true) {
                long j11 = jArr[i11];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                    for (int i13 = 0; i13 < i12; i13++) {
                        if ((255 & j11) < 128) {
                            int i14 = (i11 << 3) + i13;
                            this.f4196n.t(iArr[i14], new c2(((d2) objArr[i14]).b(), h()));
                        }
                        j11 >>= 8;
                    }
                    if (i12 != 8) {
                        break;
                    }
                }
                if (i11 == length) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        this.f4197o = new c2(this.f4183a.getSemanticsOwner().a(), h());
    }

    private final void C(SemanticsNode semanticsNode) {
        androidx.compose.ui.semantics.a aVar;
        Function1 function1;
        Function1 function12;
        androidx.compose.ui.semantics.i w11 = semanticsNode.w();
        Boolean bool = (Boolean) SemanticsConfigurationKt.a(w11, SemanticsProperties.f5994a.q());
        if (this.f4189g == TranslateStatus.SHOW_ORIGINAL && Intrinsics.c(bool, Boolean.TRUE)) {
            androidx.compose.ui.semantics.a aVar2 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(w11, androidx.compose.ui.semantics.h.f6051a.z());
            if (aVar2 == null || (function12 = (Function1) aVar2.a()) == null) {
                return;
            }
            return;
        }
        if (this.f4189g != TranslateStatus.SHOW_TRANSLATED || !Intrinsics.c(bool, Boolean.FALSE) || (aVar = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(w11, androidx.compose.ui.semantics.h.f6051a.z())) == null || (function1 = (Function1) aVar.a()) == null) {
            return;
        }
    }

    private final void c(int i11, androidx.compose.ui.platform.coreshims.f fVar) {
        if (fVar == null) {
            return;
        }
        if (this.f4187e.a(i11)) {
            this.f4187e.q(i11);
        } else {
            this.f4186d.t(i11, fVar);
        }
    }

    private final void d(int i11) {
        if (this.f4186d.b(i11)) {
            this.f4186d.q(i11);
        } else {
            this.f4187e.f(i11);
        }
    }

    private final void e(o oVar) {
        int i11;
        int[] iArr = oVar.f2379b;
        long[] jArr = oVar.f2378a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i12 = 0;
        while (true) {
            long j11 = jArr[i12];
            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i13 = 8;
                int i14 = 8 - ((~(i12 - length)) >>> 31);
                int i15 = 0;
                while (i15 < i14) {
                    if ((255 & j11) < 128) {
                        int i16 = iArr[(i12 << 3) + i15];
                        c2 c2Var = (c2) this.f4196n.c(i16);
                        d2 d2Var = (d2) oVar.c(i16);
                        SemanticsNode b11 = d2Var != null ? d2Var.b() : null;
                        if (b11 == null) {
                            g0.a.c("no value for specified key");
                            throw new KotlinNothingValueException();
                        }
                        if (c2Var == null) {
                            Iterator it = b11.w().iterator();
                            while (it.hasNext()) {
                                Object key = ((Map.Entry) it.next()).getKey();
                                SemanticsProperties semanticsProperties = SemanticsProperties.f5994a;
                                if (Intrinsics.c(key, semanticsProperties.C())) {
                                    List list = (List) SemanticsConfigurationKt.a(b11.w(), semanticsProperties.C());
                                    v(b11.o(), String.valueOf(list != null ? (AnnotatedString) CollectionsKt.k0(list) : null));
                                }
                            }
                        } else {
                            Iterator it2 = b11.w().iterator();
                            while (it2.hasNext()) {
                                SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) ((Map.Entry) it2.next()).getKey();
                                SemanticsProperties semanticsProperties2 = SemanticsProperties.f5994a;
                                if (Intrinsics.c(semanticsPropertyKey, semanticsProperties2.C())) {
                                    List list2 = (List) SemanticsConfigurationKt.a(c2Var.b(), semanticsProperties2.C());
                                    AnnotatedString annotatedString = list2 != null ? (AnnotatedString) CollectionsKt.k0(list2) : null;
                                    List list3 = (List) SemanticsConfigurationKt.a(b11.w(), semanticsProperties2.C());
                                    AnnotatedString annotatedString2 = list3 != null ? (AnnotatedString) CollectionsKt.k0(list3) : null;
                                    if (!Intrinsics.c(annotatedString, annotatedString2)) {
                                        v(b11.o(), String.valueOf(annotatedString2));
                                    }
                                }
                            }
                        }
                        i11 = 8;
                    } else {
                        i11 = i13;
                    }
                    j11 >>= i11;
                    i15++;
                    i13 = i11;
                }
                if (i14 != i13) {
                    return;
                }
            }
            if (i12 == length) {
                return;
            } else {
                i12++;
            }
        }
    }

    private final void f() {
        androidx.compose.ui.semantics.a aVar;
        Function0 function0;
        o h11 = h();
        Object[] objArr = h11.f2380c;
        long[] jArr = h11.f2378a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i11 = 0;
        while (true) {
            long j11 = jArr[i11];
            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i12 = 8 - ((~(i11 - length)) >>> 31);
                for (int i13 = 0; i13 < i12; i13++) {
                    if ((255 & j11) < 128) {
                        androidx.compose.ui.semantics.i w11 = ((d2) objArr[(i11 << 3) + i13]).b().w();
                        if (SemanticsConfigurationKt.a(w11, SemanticsProperties.f5994a.q()) != null && (aVar = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(w11, androidx.compose.ui.semantics.h.f6051a.a())) != null && (function0 = (Function0) aVar.a()) != null) {
                        }
                    }
                    j11 >>= 8;
                }
                if (i12 != 8) {
                    return;
                }
            }
            if (i11 == length) {
                return;
            } else {
                i11++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(AndroidContentCaptureManager androidContentCaptureManager) {
        if (androidContentCaptureManager.k()) {
            x0.c(androidContentCaptureManager.f4183a, false, 1, null);
            androidContentCaptureManager.w(androidContentCaptureManager.f4183a.getSemanticsOwner().a(), androidContentCaptureManager.f4197o);
            androidContentCaptureManager.u(androidContentCaptureManager.f4183a.getSemanticsOwner().a(), androidContentCaptureManager.f4197o);
            androidContentCaptureManager.e(androidContentCaptureManager.h());
            androidContentCaptureManager.B();
            androidContentCaptureManager.f4198p = false;
        }
    }

    private final void j() {
        androidx.compose.ui.semantics.a aVar;
        Function1 function1;
        o h11 = h();
        Object[] objArr = h11.f2380c;
        long[] jArr = h11.f2378a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i11 = 0;
        while (true) {
            long j11 = jArr[i11];
            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i12 = 8 - ((~(i11 - length)) >>> 31);
                for (int i13 = 0; i13 < i12; i13++) {
                    if ((255 & j11) < 128) {
                        androidx.compose.ui.semantics.i w11 = ((d2) objArr[(i11 << 3) + i13]).b().w();
                        if (Intrinsics.c(SemanticsConfigurationKt.a(w11, SemanticsProperties.f5994a.q()), Boolean.TRUE) && (aVar = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(w11, androidx.compose.ui.semantics.h.f6051a.z())) != null && (function1 = (Function1) aVar.a()) != null) {
                        }
                    }
                    j11 >>= 8;
                }
                if (i12 != 8) {
                    return;
                }
            }
            if (i11 == length) {
                return;
            } else {
                i11++;
            }
        }
    }

    private final void l() {
        androidx.compose.ui.platform.coreshims.d dVar = this.f4185c;
        if (dVar != null && Build.VERSION.SDK_INT >= 29) {
            long j11 = 255;
            char c11 = 7;
            if (this.f4186d.g()) {
                ArrayList arrayList = new ArrayList();
                e0 e0Var = this.f4186d;
                Object[] objArr = e0Var.f2380c;
                long[] jArr = e0Var.f2378a;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i11 = 0;
                    while (true) {
                        long j12 = jArr[i11];
                        long[] jArr2 = jArr;
                        if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i12 = 8 - ((~(i11 - length)) >>> 31);
                            int i13 = 0;
                            while (i13 < i12) {
                                if ((j12 & j11) < 128) {
                                    arrayList.add((androidx.compose.ui.platform.coreshims.f) objArr[(i11 << 3) + i13]);
                                }
                                j12 >>= 8;
                                i13++;
                                j11 = 255;
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
                        j11 = 255;
                    }
                }
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                int size = arrayList.size();
                for (int i14 = 0; i14 < size; i14++) {
                    arrayList2.add(((androidx.compose.ui.platform.coreshims.f) arrayList.get(i14)).h());
                }
                dVar.d(arrayList2);
                this.f4186d.i();
            }
            if (this.f4187e.c()) {
                ArrayList arrayList3 = new ArrayList();
                f0 f0Var = this.f4187e;
                int[] iArr = f0Var.f2395b;
                long[] jArr3 = f0Var.f2394a;
                int length2 = jArr3.length - 2;
                if (length2 >= 0) {
                    int i15 = 0;
                    while (true) {
                        long j13 = jArr3[i15];
                        if ((((~j13) << c11) & j13 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i16 = 8 - ((~(i15 - length2)) >>> 31);
                            for (int i17 = 0; i17 < i16; i17++) {
                                if ((j13 & 255) < 128) {
                                    arrayList3.add(Integer.valueOf(iArr[(i15 << 3) + i17]));
                                }
                                j13 >>= 8;
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
                    }
                }
                ArrayList arrayList4 = new ArrayList(arrayList3.size());
                int size2 = arrayList3.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    arrayList4.add(Long.valueOf(((Number) arrayList3.get(i18)).intValue()));
                }
                dVar.e(CollectionsKt.S0(arrayList4));
                this.f4187e.h();
            }
        }
    }

    private final void m(LayoutNode layoutNode) {
        if (this.f4191i.add(layoutNode)) {
            this.f4192j.c(Unit.f67184a);
        }
    }

    private final void u(SemanticsNode semanticsNode, c2 c2Var) {
        List t11 = semanticsNode.t();
        int size = t11.size();
        for (int i11 = 0; i11 < size; i11++) {
            SemanticsNode semanticsNode2 = (SemanticsNode) t11.get(i11);
            if (h().a(semanticsNode2.o()) && !c2Var.a().a(semanticsNode2.o())) {
                z(semanticsNode2);
            }
        }
        e0 e0Var = this.f4196n;
        int[] iArr = e0Var.f2379b;
        long[] jArr = e0Var.f2378a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i12 = 0;
            while (true) {
                long j11 = jArr[i12];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i13 = 8 - ((~(i12 - length)) >>> 31);
                    for (int i14 = 0; i14 < i13; i14++) {
                        if ((255 & j11) < 128) {
                            int i15 = iArr[(i12 << 3) + i14];
                            if (!h().a(i15)) {
                                d(i15);
                            }
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
        for (int i16 = 0; i16 < size2; i16++) {
            SemanticsNode semanticsNode3 = (SemanticsNode) t12.get(i16);
            if (h().a(semanticsNode3.o()) && this.f4196n.a(semanticsNode3.o())) {
                Object c11 = this.f4196n.c(semanticsNode3.o());
                if (c11 == null) {
                    g0.a.c("node not present in pruned tree before this change");
                    throw new KotlinNothingValueException();
                }
                u(semanticsNode3, (c2) c11);
            }
        }
    }

    private final void v(int i11, String str) {
        androidx.compose.ui.platform.coreshims.d dVar;
        if (Build.VERSION.SDK_INT >= 29 && (dVar = this.f4185c) != null) {
            AutofillId a11 = dVar.a(i11);
            if (a11 != null) {
                dVar.c(a11, str);
            } else {
                g0.a.c("Invalid content capture ID");
                throw new KotlinNothingValueException();
            }
        }
    }

    private final void w(SemanticsNode semanticsNode, c2 c2Var) {
        int i11 = 0;
        f0 f0Var = new f0(i11, 1, null);
        List t11 = semanticsNode.t();
        int size = t11.size();
        for (int i12 = 0; i12 < size; i12++) {
            SemanticsNode semanticsNode2 = (SemanticsNode) t11.get(i12);
            if (h().a(semanticsNode2.o())) {
                if (!c2Var.a().a(semanticsNode2.o())) {
                    m(semanticsNode.q());
                    return;
                }
                f0Var.f(semanticsNode2.o());
            }
        }
        f0 a11 = c2Var.a();
        int[] iArr = a11.f2395b;
        long[] jArr = a11.f2394a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i13 = 0;
            while (true) {
                long j11 = jArr[i13];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i14 = 8 - ((~(i13 - length)) >>> 31);
                    for (int i15 = 0; i15 < i14; i15++) {
                        if ((255 & j11) < 128 && !f0Var.a(iArr[(i13 << 3) + i15])) {
                            m(semanticsNode.q());
                            return;
                        }
                        j11 >>= 8;
                    }
                    if (i14 != 8) {
                        break;
                    }
                }
                if (i13 == length) {
                    break;
                } else {
                    i13++;
                }
            }
        }
        List t12 = semanticsNode.t();
        int size2 = t12.size();
        while (i11 < size2) {
            SemanticsNode semanticsNode3 = (SemanticsNode) t12.get(i11);
            if (h().a(semanticsNode3.o())) {
                Object c11 = this.f4196n.c(semanticsNode3.o());
                if (c11 == null) {
                    g0.a.c("node not present in pruned tree before this change");
                    throw new KotlinNothingValueException();
                }
                w(semanticsNode3, (c2) c11);
            }
            i11++;
        }
    }

    private final void x() {
        androidx.compose.ui.semantics.a aVar;
        Function1 function1;
        o h11 = h();
        Object[] objArr = h11.f2380c;
        long[] jArr = h11.f2378a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i11 = 0;
        while (true) {
            long j11 = jArr[i11];
            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i12 = 8 - ((~(i11 - length)) >>> 31);
                for (int i13 = 0; i13 < i12; i13++) {
                    if ((255 & j11) < 128) {
                        androidx.compose.ui.semantics.i w11 = ((d2) objArr[(i11 << 3) + i13]).b().w();
                        if (Intrinsics.c(SemanticsConfigurationKt.a(w11, SemanticsProperties.f5994a.q()), Boolean.FALSE) && (aVar = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(w11, androidx.compose.ui.semantics.h.f6051a.z())) != null && (function1 = (Function1) aVar.a()) != null) {
                        }
                    }
                    j11 >>= 8;
                }
                if (i12 != 8) {
                    return;
                }
            }
            if (i11 == length) {
                return;
            } else {
                i11++;
            }
        }
    }

    private final androidx.compose.ui.platform.coreshims.f y(SemanticsNode semanticsNode) {
        androidx.compose.ui.platform.coreshims.b a11;
        AutofillId a12;
        String h11;
        androidx.compose.ui.platform.coreshims.d dVar = this.f4185c;
        if (dVar == null || Build.VERSION.SDK_INT < 29 || (a11 = androidx.compose.ui.platform.coreshims.e.a(this.f4183a)) == null) {
            return null;
        }
        if (semanticsNode.r() != null) {
            a12 = dVar.a(r3.o());
            if (a12 == null) {
                return null;
            }
        } else {
            a12 = a11.a();
        }
        androidx.compose.ui.platform.coreshims.f b11 = dVar.b(a12, semanticsNode.o());
        if (b11 == null) {
            return null;
        }
        androidx.compose.ui.semantics.i w11 = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5994a;
        if (w11.e(semanticsProperties.v())) {
            return null;
        }
        Bundle a13 = b11.a();
        if (a13 != null) {
            a13.putLong("android.view.contentcapture.EventTimestamp", this.f4195m);
        }
        String str = (String) SemanticsConfigurationKt.a(w11, semanticsProperties.B());
        if (str != null) {
            b11.e(semanticsNode.o(), null, null, str);
        }
        List list = (List) SemanticsConfigurationKt.a(w11, semanticsProperties.C());
        if (list != null) {
            b11.b("android.widget.TextView");
            b11.f(q0.a.d(list, "\n", null, null, 0, null, null, 62, null));
        }
        AnnotatedString annotatedString = (AnnotatedString) SemanticsConfigurationKt.a(w11, semanticsProperties.g());
        if (annotatedString != null) {
            b11.b("android.widget.EditText");
            b11.f(annotatedString);
        }
        List list2 = (List) SemanticsConfigurationKt.a(w11, semanticsProperties.d());
        if (list2 != null) {
            b11.c(q0.a.d(list2, "\n", null, null, 0, null, null, 62, null));
        }
        androidx.compose.ui.semantics.f fVar = (androidx.compose.ui.semantics.f) SemanticsConfigurationKt.a(w11, semanticsProperties.x());
        if (fVar != null && (h11 = e2.h(fVar.n())) != null) {
            b11.b(h11);
        }
        z e11 = e2.e(w11);
        if (e11 != null) {
            y k11 = e11.k();
            b11.g(w.h(k11.i().l()) * k11.b().getDensity() * k11.b().C0(), 0, 0, 0);
        }
        y.i h12 = semanticsNode.h();
        b11.d((int) h12.f(), (int) h12.i(), 0, 0, (int) h12.k(), (int) h12.e());
        return b11;
    }

    private final void z(SemanticsNode semanticsNode) {
        if (k()) {
            C(semanticsNode);
            c(semanticsNode.o(), y(semanticsNode));
            List t11 = semanticsNode.t();
            int size = t11.size();
            for (int i11 = 0; i11 < size; i11++) {
                z((SemanticsNode) t11.get(i11));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006e A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:12:0x0030, B:14:0x0056, B:19:0x0066, B:21:0x006e, B:23:0x0077, B:24:0x007a, B:26:0x007e, B:27:0x0087, B:36:0x0048), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0098 -> B:13:0x0033). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(kotlin.coroutines.Continuation r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1 r0 = (androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1 r0 = new androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.channels.f r2 = (kotlinx.coroutines.channels.f) r2
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.contentcapture.AndroidContentCaptureManager r5 = (androidx.compose.ui.contentcapture.AndroidContentCaptureManager) r5
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L35
        L33:
            r10 = r2
            goto L56
        L35:
            r10 = move-exception
            goto La5
        L38:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L40:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.channels.f r2 = (kotlinx.coroutines.channels.f) r2
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.contentcapture.AndroidContentCaptureManager r5 = (androidx.compose.ui.contentcapture.AndroidContentCaptureManager) r5
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L35
            goto L66
        L4c:
            kotlin.ResultKt.b(r10)
            kotlinx.coroutines.channels.d r10 = r9.f4192j     // Catch: java.lang.Throwable -> La3
            kotlinx.coroutines.channels.f r10 = r10.iterator()     // Catch: java.lang.Throwable -> La3
            r5 = r9
        L56:
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L35
            r0.L$1 = r10     // Catch: java.lang.Throwable -> L35
            r0.label = r4     // Catch: java.lang.Throwable -> L35
            java.lang.Object r2 = r10.a(r0)     // Catch: java.lang.Throwable -> L35
            if (r2 != r1) goto L63
            return r1
        L63:
            r8 = r2
            r2 = r10
            r10 = r8
        L66:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L35
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r10 == 0) goto L9b
            r2.next()     // Catch: java.lang.Throwable -> L35
            boolean r10 = r5.k()     // Catch: java.lang.Throwable -> L35
            if (r10 == 0) goto L7a
            r5.l()     // Catch: java.lang.Throwable -> L35
        L7a:
            boolean r10 = r5.f4198p     // Catch: java.lang.Throwable -> L35
            if (r10 != 0) goto L87
            r5.f4198p = r4     // Catch: java.lang.Throwable -> L35
            android.os.Handler r10 = r5.f4193k     // Catch: java.lang.Throwable -> L35
            java.lang.Runnable r6 = r5.f4199q     // Catch: java.lang.Throwable -> L35
            r10.post(r6)     // Catch: java.lang.Throwable -> L35
        L87:
            androidx.collection.b r10 = r5.f4191i     // Catch: java.lang.Throwable -> L35
            r10.clear()     // Catch: java.lang.Throwable -> L35
            long r6 = r5.f4188f     // Catch: java.lang.Throwable -> L35
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L35
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L35
            r0.label = r3     // Catch: java.lang.Throwable -> L35
            java.lang.Object r10 = kotlinx.coroutines.u0.a(r6, r0)     // Catch: java.lang.Throwable -> L35
            if (r10 != r1) goto L33
            return r1
        L9b:
            androidx.collection.b r10 = r5.f4191i
            r10.clear()
            kotlin.Unit r10 = kotlin.Unit.f67184a
            return r10
        La3:
            r10 = move-exception
            r5 = r9
        La5:
            androidx.collection.b r0 = r5.f4191i
            r0.clear()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.contentcapture.AndroidContentCaptureManager.b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final o h() {
        if (this.f4190h) {
            this.f4190h = false;
            this.f4194l = e2.b(this.f4183a.getSemanticsOwner());
            this.f4195m = System.currentTimeMillis();
        }
        return this.f4194l;
    }

    public final AndroidComposeView i() {
        return this.f4183a;
    }

    public final boolean k() {
        return m.f4204b1.a() && this.f4185c != null;
    }

    public final void n() {
        this.f4189g = TranslateStatus.SHOW_ORIGINAL;
        f();
    }

    public final void o(long[] jArr, int[] iArr, Consumer consumer) {
        a.f4200a.c(this, jArr, iArr, consumer);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onCreate(u uVar) {
        androidx.view.e.a(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onDestroy(u uVar) {
        androidx.view.e.b(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onPause(u uVar) {
        androidx.view.e.c(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onResume(u uVar) {
        androidx.view.e.d(this, uVar);
    }

    @Override // androidx.view.f
    public void onStart(u uVar) {
        this.f4185c = (androidx.compose.ui.platform.coreshims.d) this.f4184b.invoke();
        z(this.f4183a.getSemanticsOwner().a());
        l();
    }

    @Override // androidx.view.f
    public void onStop(u uVar) {
        A(this.f4183a.getSemanticsOwner().a());
        l();
        this.f4185c = null;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f4193k.removeCallbacks(this.f4199q);
        this.f4185c = null;
    }

    public final void p() {
        this.f4189g = TranslateStatus.SHOW_ORIGINAL;
        j();
    }

    public final void q(LayoutNode layoutNode) {
        this.f4190h = true;
        if (k()) {
            m(layoutNode);
        }
    }

    public final void r() {
        this.f4190h = true;
        if (!k() || this.f4198p) {
            return;
        }
        this.f4198p = true;
        this.f4193k.post(this.f4199q);
    }

    public final void s() {
        this.f4189g = TranslateStatus.SHOW_TRANSLATED;
        x();
    }

    public final void t(AndroidContentCaptureManager androidContentCaptureManager, LongSparseArray longSparseArray) {
        a.f4200a.d(androidContentCaptureManager, longSparseArray);
    }
}
