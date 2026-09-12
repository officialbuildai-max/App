package kotlin.time;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
final class UnboundLocalDateTime {

    /* renamed from: h, reason: collision with root package name */
    public static final Companion f67728h = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f67729a;

    /* renamed from: b, reason: collision with root package name */
    private final int f67730b;

    /* renamed from: c, reason: collision with root package name */
    private final int f67731c;

    /* renamed from: d, reason: collision with root package name */
    private final int f67732d;

    /* renamed from: e, reason: collision with root package name */
    private final int f67733e;

    /* renamed from: f, reason: collision with root package name */
    private final int f67734f;

    /* renamed from: g, reason: collision with root package name */
    private final int f67735g;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/time/UnboundLocalDateTime$Companion;", "", "<init>", "()V", "Lkotlin/time/Instant;", "instant", "Lkotlin/time/UnboundLocalDateTime;", "a", "(Lkotlin/time/Instant;)Lkotlin/time/UnboundLocalDateTime;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UnboundLocalDateTime a(Instant instant) {
            long j11;
            Intrinsics.h(instant, "instant");
            long epochSeconds = instant.getEpochSeconds();
            long j12 = epochSeconds / 86400;
            if ((epochSeconds ^ 86400) < 0 && j12 * 86400 != epochSeconds) {
                j12--;
            }
            long j13 = epochSeconds % 86400;
            int i11 = (int) (j13 + (86400 & (((j13 ^ 86400) & ((-j13) | j13)) >> 63)));
            long j14 = (j12 + 719528) - 60;
            if (j14 < 0) {
                long j15 = 146097;
                long j16 = ((j14 + 1) / j15) - 1;
                j11 = 400 * j16;
                j14 += (-j16) * j15;
            } else {
                j11 = 0;
            }
            long j17 = 400;
            long j18 = ((j17 * j14) + 591) / 146097;
            long j19 = 365;
            long j20 = 4;
            long j21 = 100;
            long j22 = j14 - ((((j19 * j18) + (j18 / j20)) - (j18 / j21)) + (j18 / j17));
            if (j22 < 0) {
                j18--;
                j22 = j14 - ((((j19 * j18) + (j18 / j20)) - (j18 / j21)) + (j18 / j17));
            }
            int i12 = (int) j22;
            int i13 = ((i12 * 5) + 2) / 153;
            int i14 = (i12 - (((i13 * 306) + 5) / 10)) + 1;
            int i15 = i11 / 3600;
            int i16 = i11 - (i15 * 3600);
            int i17 = i16 / 60;
            return new UnboundLocalDateTime((int) (j18 + j11 + (i13 / 10)), ((i13 + 2) % 12) + 1, i14, i15, i17, i16 - (i17 * 60), instant.getNanosecondsOfSecond());
        }
    }

    public UnboundLocalDateTime(int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        this.f67729a = i11;
        this.f67730b = i12;
        this.f67731c = i13;
        this.f67732d = i14;
        this.f67733e = i15;
        this.f67734f = i16;
        this.f67735g = i17;
    }

    public final int a() {
        return this.f67731c;
    }

    public final int b() {
        return this.f67732d;
    }

    public final int c() {
        return this.f67733e;
    }

    public final int d() {
        return this.f67730b;
    }

    public final int e() {
        return this.f67735g;
    }

    public final int f() {
        return this.f67734f;
    }

    public final int g() {
        return this.f67729a;
    }

    public String toString() {
        return "UnboundLocalDateTime(" + this.f67729a + '-' + this.f67730b + '-' + this.f67731c + ' ' + this.f67732d + ':' + this.f67733e + ':' + this.f67734f + '.' + this.f67735g + ')';
    }
}
