package androidx.work;

import android.content.Context;
import androidx.view.LiveData;
import androidx.work.impl.f1;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class WorkManager {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15481a = new a(null);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/work/WorkManager$UpdateResult;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_APPLIED", "APPLIED_IMMEDIATELY", "APPLIED_FOR_NEXT_RUN", "work-runtime_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes.dex */
    public static final class UpdateResult {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ UpdateResult[] $VALUES;
        public static final UpdateResult NOT_APPLIED = new UpdateResult("NOT_APPLIED", 0);
        public static final UpdateResult APPLIED_IMMEDIATELY = new UpdateResult("APPLIED_IMMEDIATELY", 1);
        public static final UpdateResult APPLIED_FOR_NEXT_RUN = new UpdateResult("APPLIED_FOR_NEXT_RUN", 2);

        private static final /* synthetic */ UpdateResult[] $values() {
            return new UpdateResult[]{NOT_APPLIED, APPLIED_IMMEDIATELY, APPLIED_FOR_NEXT_RUN};
        }

        static {
            UpdateResult[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private UpdateResult(String str, int i11) {
        }

        public static EnumEntries<UpdateResult> getEntries() {
            return $ENTRIES;
        }

        public static UpdateResult valueOf(String str) {
            return (UpdateResult) Enum.valueOf(UpdateResult.class, str);
        }

        public static UpdateResult[] values() {
            return (UpdateResult[]) $VALUES.clone();
        }
    }

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public WorkManager a(Context context) {
            Intrinsics.h(context, "context");
            f1 o11 = f1.o(context);
            Intrinsics.g(o11, "getInstance(...)");
            return o11;
        }

        public void b(Context context, b configuration) {
            Intrinsics.h(context, "context");
            Intrinsics.h(configuration, "configuration");
            f1.h(context, configuration);
        }
    }

    public static WorkManager f(Context context) {
        return f15481a.a(context);
    }

    public static void h(Context context, b bVar) {
        f15481a.b(context, bVar);
    }

    public final h0 a(String uniqueWorkName, ExistingWorkPolicy existingWorkPolicy, v request) {
        Intrinsics.h(uniqueWorkName, "uniqueWorkName");
        Intrinsics.h(existingWorkPolicy, "existingWorkPolicy");
        Intrinsics.h(request, "request");
        return b(uniqueWorkName, existingWorkPolicy, CollectionsKt.e(request));
    }

    public abstract h0 b(String str, ExistingWorkPolicy existingWorkPolicy, List list);

    public final w c(i0 request) {
        Intrinsics.h(request, "request");
        return d(CollectionsKt.e(request));
    }

    public abstract w d(List list);

    public abstract w e(String str, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, b0 b0Var);

    public abstract LiveData g(UUID uuid);
}
