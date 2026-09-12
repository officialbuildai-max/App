package com.transsion.home.adapter;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.videodetail.music.ui.MusicTabLikedFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class c extends FragmentStateAdapter {

    /* renamed from: a, reason: collision with root package name */
    private final ViewPager2 f44316a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44317b;

    /* renamed from: c, reason: collision with root package name */
    private final String f44318c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(ViewPager2 viewPager2, int i11, String str, Fragment fragment) {
        super(fragment);
        Intrinsics.h(fragment, "fragment");
        this.f44316a = viewPager2;
        this.f44317b = i11;
        this.f44318c = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(c cVar) {
        ViewPager2 viewPager2 = cVar.f44316a;
        if (viewPager2 != null) {
            viewPager2.setCurrentItem(0);
        }
        return Unit.f67184a;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int i11) {
        if (i11 == 0) {
            return SubTabFragment.INSTANCE.b(this.f44317b, this.f44318c);
        }
        if (i11 != 1) {
            return new MusicTabLikedFragment();
        }
        MusicTabLikedFragment musicTabLikedFragment = new MusicTabLikedFragment();
        musicTabLikedFragment.m1(new Function0() { // from class: com.transsion.home.adapter.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit h11;
                h11 = c.h(c.this);
                return h11;
            }
        });
        return musicTabLikedFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 2;
    }
}
