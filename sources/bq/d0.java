package bq;

import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.tabs.TabLayout;
import com.transsion.room.R$id;

/* loaded from: classes5.dex */
public final class d0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayoutCompat f16821a;

    /* renamed from: b, reason: collision with root package name */
    public final View f16822b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayoutCompat f16823c;

    /* renamed from: d, reason: collision with root package name */
    public final TabLayout f16824d;

    private d0(LinearLayoutCompat linearLayoutCompat, View view, LinearLayoutCompat linearLayoutCompat2, TabLayout tabLayout) {
        this.f16821a = linearLayoutCompat;
        this.f16822b = view;
        this.f16823c = linearLayoutCompat2;
        this.f16824d = tabLayout;
    }

    public static d0 a(View view) {
        int i11 = R$id.divider;
        View a11 = g4.b.a(view, i11);
        if (a11 != null) {
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
            int i12 = R$id.tab_room;
            TabLayout tabLayout = (TabLayout) g4.b.a(view, i12);
            if (tabLayout != null) {
                return new d0(linearLayoutCompat, a11, linearLayoutCompat, tabLayout);
            }
            i11 = i12;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f16821a;
    }
}
