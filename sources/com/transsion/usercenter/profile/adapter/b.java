package com.transsion.usercenter.profile.adapter;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.cloud.tmc.integration.event.EventConstants;
import com.therouter.TheRouter;
import com.transsion.baseui.fragment.EmptyFragment;
import com.transsion.moviedetailapi.IMovieDetailService;
import com.transsion.usercenter.profile.ProfileSubjectListViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b extends FragmentStateAdapter {

    /* renamed from: a, reason: collision with root package name */
    private final String f57235a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.collection.a f57236b;

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f57237c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, Fragment fragment) {
        super(fragment);
        Intrinsics.h(fragment, "fragment");
        this.f57235a = str;
        this.f57236b = new androidx.collection.a();
        this.f57237c = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.profile.adapter.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                IMovieDetailService j11;
                j11 = b.j();
                return j11;
            }
        });
    }

    private final IMovieDetailService i() {
        return (IMovieDetailService) this.f57237c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMovieDetailService j() {
        return (IMovieDetailService) TheRouter.d(IMovieDetailService.class, new Object[0]);
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int i11) {
        Bundle bundle = new Bundle();
        bundle.putInt(EventConstants.KEY_SOURCE, i11);
        bundle.putString("userId", this.f57235a);
        IMovieDetailService i12 = i();
        Fragment e11 = i12 != null ? i12.e(bundle, ProfileSubjectListViewModel.class) : null;
        this.f57236b.put(Integer.valueOf(i11), e11);
        return e11 == null ? new EmptyFragment() : e11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 2;
    }

    public final void h(int i11) {
        Bundle bundle = new Bundle();
        bundle.putInt(EventConstants.KEY_SOURCE, i11);
        bundle.putString("userId", this.f57235a);
        Fragment fragment = (Fragment) this.f57236b.get(Integer.valueOf(i11));
        if (fragment == null || fragment.isStateSaved()) {
            return;
        }
        fragment.setArguments(bundle);
        IMovieDetailService i12 = i();
        if (i12 != null) {
            i12.c(fragment);
        }
    }
}
