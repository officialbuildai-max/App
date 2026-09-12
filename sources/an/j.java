package an;

import com.transsion.moviedetailapi.bean.Subject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private final Subject f796a;

    /* JADX WARN: Multi-variable type inference failed */
    public j() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public j(Subject subject) {
        this.f796a = subject;
    }

    public /* synthetic */ j(Subject subject, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : subject);
    }

    public final Subject a() {
        return this.f796a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j) && Intrinsics.c(this.f796a, ((j) obj).f796a);
    }

    public int hashCode() {
        Subject subject = this.f796a;
        if (subject == null) {
            return 0;
        }
        return subject.hashCode();
    }

    public String toString() {
        return "PosterDetailEvent(mMovieDetailBean=" + this.f796a + ")";
    }
}
