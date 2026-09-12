package wo;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.cloud.tmc.integration.event.EventConstants;
import com.therouter.TheRouter;
import com.transsion.baseui.R$string;
import com.transsion.baseui.fragment.EmptyFragment;
import com.transsion.moviedetailapi.IMovieDetailService;
import com.transsion.postdetail.comment.ui.CommentListFragment;
import com.transsion.usercenter.profile.ProfileSubjectListViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class h extends FragmentStateAdapter {

    /* renamed from: f, reason: collision with root package name */
    public static final a f78049f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private String f78050a;

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f78051b;

    /* renamed from: c, reason: collision with root package name */
    private long f78052c;

    /* renamed from: d, reason: collision with root package name */
    private long f78053d;

    /* renamed from: e, reason: collision with root package name */
    private long f78054e;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Fragment fragment, String str) {
        super(fragment);
        Intrinsics.h(fragment, "fragment");
        this.f78050a = str;
        this.f78051b = LazyKt.b(new Function0() { // from class: wo.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                IMovieDetailService l11;
                l11 = h.l();
                return l11;
            }
        });
    }

    private final Fragment h(int i11) {
        Fragment e11;
        Bundle bundle = new Bundle();
        bundle.putInt(EventConstants.KEY_SOURCE, i11);
        bundle.putString("userId", this.f78050a);
        IMovieDetailService j11 = j();
        return (j11 == null || (e11 = j11.e(bundle, ProfileSubjectListViewModel.class)) == null) ? new EmptyFragment() : e11;
    }

    private final IMovieDetailService j() {
        return (IMovieDetailService) this.f78051b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMovieDetailService l() {
        return (IMovieDetailService) TheRouter.d(IMovieDetailService.class, new Object[0]);
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public boolean containsItem(long j11) {
        return j11 == getItemId(0) || j11 == getItemId(1) || j11 == getItemId(2);
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? new EmptyFragment() : CommentListFragment.INSTANCE.a(true) : h(0) : h(1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 3;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i11) {
        long j11;
        long j12;
        if (i11 == 0) {
            j11 = 1000;
            j12 = this.f78052c;
        } else if (i11 == 1) {
            j11 = 2000;
            j12 = this.f78053d;
        } else {
            if (i11 != 2) {
                return i11;
            }
            j11 = 3000;
            j12 = this.f78054e;
        }
        return j11 + j12;
    }

    public final void i(String str) {
        this.f78050a = str;
        this.f78052c++;
        this.f78053d++;
        this.f78054e++;
        notifyDataSetChanged();
    }

    public final int k(int i11) {
        return i11 != 0 ? i11 != 1 ? R$string.my_comments : com.tn.lib.widget.R$string.my_posts : com.tn.lib.widget.R$string.my_likes;
    }
}
