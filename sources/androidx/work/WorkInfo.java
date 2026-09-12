package androidx.work;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class WorkInfo {

    /* renamed from: m, reason: collision with root package name */
    public static final a f15466m = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final UUID f15467a;

    /* renamed from: b, reason: collision with root package name */
    private final State f15468b;

    /* renamed from: c, reason: collision with root package name */
    private final Set f15469c;

    /* renamed from: d, reason: collision with root package name */
    private final f f15470d;

    /* renamed from: e, reason: collision with root package name */
    private final f f15471e;

    /* renamed from: f, reason: collision with root package name */
    private final int f15472f;

    /* renamed from: g, reason: collision with root package name */
    private final int f15473g;

    /* renamed from: h, reason: collision with root package name */
    private final d f15474h;

    /* renamed from: i, reason: collision with root package name */
    private final long f15475i;

    /* renamed from: j, reason: collision with root package name */
    private final b f15476j;

    /* renamed from: k, reason: collision with root package name */
    private final long f15477k;

    /* renamed from: l, reason: collision with root package name */
    private final int f15478l;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\fj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\r"}, d2 = {"Landroidx/work/WorkInfo$State;", "", "<init>", "(Ljava/lang/String;I)V", "ENQUEUED", "RUNNING", "SUCCEEDED", "FAILED", "BLOCKED", "CANCELLED", "isFinished", "", "()Z", "work-runtime_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes.dex */
    public static final class State {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State ENQUEUED = new State("ENQUEUED", 0);
        public static final State RUNNING = new State("RUNNING", 1);
        public static final State SUCCEEDED = new State("SUCCEEDED", 2);
        public static final State FAILED = new State("FAILED", 3);
        public static final State BLOCKED = new State("BLOCKED", 4);
        public static final State CANCELLED = new State("CANCELLED", 5);

        private static final /* synthetic */ State[] $values() {
            return new State[]{ENQUEUED, RUNNING, SUCCEEDED, FAILED, BLOCKED, CANCELLED};
        }

        static {
            State[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private State(String str, int i11) {
        }

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public final boolean isFinished() {
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final long f15479a;

        /* renamed from: b, reason: collision with root package name */
        private final long f15480b;

        public b(long j11, long j12) {
            this.f15479a = j11;
            this.f15480b = j12;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.c(b.class, obj.getClass())) {
                return false;
            }
            b bVar = (b) obj;
            return bVar.f15479a == this.f15479a && bVar.f15480b == this.f15480b;
        }

        public int hashCode() {
            return (androidx.collection.s.a(this.f15479a) * 31) + androidx.collection.s.a(this.f15480b);
        }

        public String toString() {
            return "PeriodicityInfo{repeatIntervalMillis=" + this.f15479a + ", flexIntervalMillis=" + this.f15480b + '}';
        }
    }

    public WorkInfo(UUID id2, State state, Set tags, f outputData, f progress, int i11, int i12, d constraints, long j11, b bVar, long j12, int i13) {
        Intrinsics.h(id2, "id");
        Intrinsics.h(state, "state");
        Intrinsics.h(tags, "tags");
        Intrinsics.h(outputData, "outputData");
        Intrinsics.h(progress, "progress");
        Intrinsics.h(constraints, "constraints");
        this.f15467a = id2;
        this.f15468b = state;
        this.f15469c = tags;
        this.f15470d = outputData;
        this.f15471e = progress;
        this.f15472f = i11;
        this.f15473g = i12;
        this.f15474h = constraints;
        this.f15475i = j11;
        this.f15476j = bVar;
        this.f15477k = j12;
        this.f15478l = i13;
    }

    public final State a() {
        return this.f15468b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.c(WorkInfo.class, obj.getClass())) {
            return false;
        }
        WorkInfo workInfo = (WorkInfo) obj;
        if (this.f15472f == workInfo.f15472f && this.f15473g == workInfo.f15473g && Intrinsics.c(this.f15467a, workInfo.f15467a) && this.f15468b == workInfo.f15468b && Intrinsics.c(this.f15470d, workInfo.f15470d) && Intrinsics.c(this.f15474h, workInfo.f15474h) && this.f15475i == workInfo.f15475i && Intrinsics.c(this.f15476j, workInfo.f15476j) && this.f15477k == workInfo.f15477k && this.f15478l == workInfo.f15478l && Intrinsics.c(this.f15469c, workInfo.f15469c)) {
            return Intrinsics.c(this.f15471e, workInfo.f15471e);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((this.f15467a.hashCode() * 31) + this.f15468b.hashCode()) * 31) + this.f15470d.hashCode()) * 31) + this.f15469c.hashCode()) * 31) + this.f15471e.hashCode()) * 31) + this.f15472f) * 31) + this.f15473g) * 31) + this.f15474h.hashCode()) * 31) + androidx.collection.s.a(this.f15475i)) * 31;
        b bVar = this.f15476j;
        return ((((hashCode + (bVar != null ? bVar.hashCode() : 0)) * 31) + androidx.collection.s.a(this.f15477k)) * 31) + this.f15478l;
    }

    public String toString() {
        return "WorkInfo{id='" + this.f15467a + "', state=" + this.f15468b + ", outputData=" + this.f15470d + ", tags=" + this.f15469c + ", progress=" + this.f15471e + ", runAttemptCount=" + this.f15472f + ", generation=" + this.f15473g + ", constraints=" + this.f15474h + ", initialDelayMillis=" + this.f15475i + ", periodicityInfo=" + this.f15476j + ", nextScheduleTimeMillis=" + this.f15477k + "}, stopReason=" + this.f15478l;
    }
}
