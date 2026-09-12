package com.transsion.ninegridview.preview;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.ninegridview.preview.GifImagePreviewFragment;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c extends FragmentStateAdapter {

    /* renamed from: a, reason: collision with root package name */
    private List f47768a;

    /* renamed from: b, reason: collision with root package name */
    private Boolean f47769b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(FragmentActivity activity) {
        super(activity);
        Intrinsics.h(activity, "activity");
        this.f47769b = Boolean.FALSE;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int i11) {
        GifImagePreviewFragment.Companion companion = GifImagePreviewFragment.INSTANCE;
        Boolean bool = this.f47769b;
        List list = this.f47768a;
        return companion.a(bool, list != null ? (Image) list.get(i11) : null, i11);
    }

    public final void g(Boolean bool) {
        this.f47769b = bool;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List list = this.f47768a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final void h(List list) {
        this.f47768a = list;
    }
}
