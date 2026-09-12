package y1;

import android.media.metrics.LogSessionId;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class f4 {

    /* renamed from: d, reason: collision with root package name */
    public static final f4 f78769d = new f4("");

    /* renamed from: a, reason: collision with root package name */
    public final String f78770a;

    /* renamed from: b, reason: collision with root package name */
    private final a f78771b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f78772c;

    /* loaded from: classes2.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public LogSessionId f78773a;

        public a() {
            LogSessionId logSessionId;
            logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
            this.f78773a = logSessionId;
        }

        public void a(LogSessionId logSessionId) {
            LogSessionId logSessionId2;
            boolean equals;
            LogSessionId logSessionId3 = this.f78773a;
            logSessionId2 = LogSessionId.LOG_SESSION_ID_NONE;
            equals = logSessionId3.equals(logSessionId2);
            androidx.media3.common.util.a.g(equals);
            this.f78773a = logSessionId;
        }
    }

    public f4(String str) {
        this.f78770a = str;
        this.f78771b = androidx.media3.common.util.a1.f10432a >= 31 ? new a() : null;
        this.f78772c = new Object();
    }

    public synchronized LogSessionId a() {
        return ((a) androidx.media3.common.util.a.e(this.f78771b)).f78773a;
    }

    public synchronized void b(LogSessionId logSessionId) {
        ((a) androidx.media3.common.util.a.e(this.f78771b)).a(logSessionId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f4)) {
            return false;
        }
        f4 f4Var = (f4) obj;
        return Objects.equals(this.f78770a, f4Var.f78770a) && Objects.equals(this.f78771b, f4Var.f78771b) && Objects.equals(this.f78772c, f4Var.f78772c);
    }

    public int hashCode() {
        return Objects.hash(this.f78770a, this.f78771b, this.f78772c);
    }
}
