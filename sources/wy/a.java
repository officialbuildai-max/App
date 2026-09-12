package wy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsnet.login.R$layout;
import com.transsnet.login.country.SelectCountryViewModel;
import com.transsnet.loginapi.bean.Country;
import java.util.List;

/* loaded from: classes7.dex */
public class a extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    private SelectCountryViewModel f78106a;

    /* renamed from: b, reason: collision with root package name */
    private List f78107b;

    /* renamed from: c, reason: collision with root package name */
    private Context f78108c;

    public a(Context context, SelectCountryViewModel selectCountryViewModel, List list) {
        this.f78107b = list;
        this.f78108c = context;
        this.f78106a = selectCountryViewModel;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c cVar, int i11) {
        List list = this.f78107b;
        if (list == null || i11 < 0 || i11 >= list.size()) {
            return;
        }
        cVar.g((Country) this.f78107b.get(i11), this.f78106a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List list = this.f78107b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup viewGroup, int i11) {
        View inflate = LayoutInflater.from(this.f78108c).inflate(R$layout.login_item_country, viewGroup, false);
        if (inflate.getLayoutParams() == null) {
            inflate.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        }
        return new c(inflate);
    }

    public void i(List list) {
        this.f78107b = list;
        notifyDataSetChanged();
    }
}
