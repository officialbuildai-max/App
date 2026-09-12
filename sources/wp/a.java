package wp;

import androidx.view.u;
import com.transsion.rewardscenter.model.RewardsCenterModel;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final u f78055a;

    /* renamed from: b, reason: collision with root package name */
    private final RewardsCenterModel f78056b;

    /* renamed from: c, reason: collision with root package name */
    private final WeakReference f78057c;

    /* renamed from: d, reason: collision with root package name */
    private final n0 f78058d;

    public a(u owner, RewardsCenterModel viewModel, WeakReference fragment, n0 scope) {
        Intrinsics.h(owner, "owner");
        Intrinsics.h(viewModel, "viewModel");
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(scope, "scope");
        this.f78055a = owner;
        this.f78056b = viewModel;
        this.f78057c = fragment;
        this.f78058d = scope;
    }

    public final WeakReference a() {
        return this.f78057c;
    }

    public final n0 b() {
        return this.f78058d;
    }

    public final RewardsCenterModel c() {
        return this.f78056b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.f78055a, aVar.f78055a) && Intrinsics.c(this.f78056b, aVar.f78056b) && Intrinsics.c(this.f78057c, aVar.f78057c) && Intrinsics.c(this.f78058d, aVar.f78058d);
    }

    public int hashCode() {
        return (((((this.f78055a.hashCode() * 31) + this.f78056b.hashCode()) * 31) + this.f78057c.hashCode()) * 31) + this.f78058d.hashCode();
    }

    public String toString() {
        return "TaskConfig(owner=" + this.f78055a + ", viewModel=" + this.f78056b + ", fragment=" + this.f78057c + ", scope=" + this.f78058d + ")";
    }
}
