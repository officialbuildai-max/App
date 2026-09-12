package androidx.compose.ui.input.pointer.util;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import e0.c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public final class VelocityTracker1D {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f5116a;

    /* renamed from: b, reason: collision with root package name */
    private final Strategy f5117b;

    /* renamed from: c, reason: collision with root package name */
    private final int f5118c;

    /* renamed from: d, reason: collision with root package name */
    private final e0.a[] f5119d;

    /* renamed from: e, reason: collision with root package name */
    private int f5120e;

    /* renamed from: f, reason: collision with root package name */
    private final float[] f5121f;

    /* renamed from: g, reason: collision with root package name */
    private final float[] f5122g;

    /* renamed from: h, reason: collision with root package name */
    private final float[] f5123h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;", "", "(Ljava/lang/String;I)V", "Lsq2", "Impulse", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes.dex */
    public enum Strategy {
        Lsq2,
        Impulse
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5124a;

        static {
            int[] iArr = new int[Strategy.values().length];
            try {
                iArr[Strategy.Impulse.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Strategy.Lsq2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f5124a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VelocityTracker1D() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public VelocityTracker1D(boolean z10, Strategy strategy) {
        this.f5116a = z10;
        this.f5117b = strategy;
        if (z10 && strategy.equals(Strategy.Lsq2)) {
            throw new IllegalStateException("Lsq2 not (yet) supported for differential axes");
        }
        int i11 = a.f5124a[strategy.ordinal()];
        int i12 = 2;
        if (i11 != 1) {
            if (i11 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i12 = 3;
        }
        this.f5118c = i12;
        this.f5119d = new e0.a[20];
        this.f5121f = new float[20];
        this.f5122g = new float[20];
        this.f5123h = new float[3];
    }

    public /* synthetic */ VelocityTracker1D(boolean z10, Strategy strategy, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z10, (i11 & 2) != 0 ? Strategy.Lsq2 : strategy);
    }

    private final float b(float[] fArr, float[] fArr2, int i11) {
        try {
            return c.i(fArr2, fArr, i11, 2, this.f5123h)[1];
        } catch (IllegalArgumentException unused) {
            return 0.0f;
        }
    }

    public final void a(long j11, float f11) {
        int i11 = (this.f5120e + 1) % 20;
        this.f5120e = i11;
        c.j(this.f5119d, i11, j11, f11);
    }

    public final float c() {
        float f11;
        float[] fArr = this.f5121f;
        float[] fArr2 = this.f5122g;
        int i11 = this.f5120e;
        e0.a aVar = this.f5119d[i11];
        if (aVar == null) {
            return 0.0f;
        }
        int i12 = 0;
        e0.a aVar2 = aVar;
        while (true) {
            e0.a aVar3 = this.f5119d[i11];
            if (aVar3 != null) {
                float b11 = (float) (aVar.b() - aVar3.b());
                float abs = (float) Math.abs(aVar3.b() - aVar2.b());
                e0.a aVar4 = (this.f5117b == Strategy.Lsq2 || this.f5116a) ? aVar3 : aVar;
                if (b11 > 100.0f || abs > 40.0f) {
                    break;
                }
                fArr[i12] = aVar3.a();
                fArr2[i12] = -b11;
                if (i11 == 0) {
                    i11 = 20;
                }
                i11--;
                i12++;
                if (i12 >= 20) {
                    break;
                }
                aVar2 = aVar4;
            } else {
                break;
            }
        }
        if (i12 < this.f5118c) {
            return 0.0f;
        }
        int i13 = a.f5124a[this.f5117b.ordinal()];
        if (i13 == 1) {
            f11 = c.f(fArr, fArr2, i12, this.f5116a);
        } else {
            if (i13 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            f11 = b(fArr, fArr2, i12);
        }
        return f11 * 1000;
    }

    public final float d(float f11) {
        if (!(f11 > 0.0f)) {
            g0.a.b("maximumVelocity should be a positive value. You specified=" + f11);
        }
        float c11 = c();
        if (c11 == 0.0f || Float.isNaN(c11)) {
            return 0.0f;
        }
        return c11 > 0.0f ? RangesKt.h(c11, f11) : RangesKt.e(c11, -f11);
    }

    public final void e() {
        ArraysKt.A(this.f5119d, null, 0, 0, 6, null);
        this.f5120e = 0;
    }
}
