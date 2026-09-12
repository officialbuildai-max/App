package wy;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsnet.login.R$id;
import com.transsnet.login.country.SelectCountryViewModel;
import com.transsnet.loginapi.bean.Country;

/* loaded from: classes7.dex */
public class c extends RecyclerView.b0 {

    /* renamed from: a, reason: collision with root package name */
    private View f78111a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f78112b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f78113c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f78114d;

    public c(View view) {
        super(view);
        this.f78111a = view.findViewById(R$id.index_layout);
        this.f78112b = (TextView) view.findViewById(R$id.index_tv);
        this.f78113c = (TextView) view.findViewById(R$id.name);
        this.f78114d = (TextView) view.findViewById(R$id.code);
    }

    public void g(final Country country, final SelectCountryViewModel selectCountryViewModel) {
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: wy.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectCountryViewModel.this.r(country);
            }
        });
        if (TextUtils.isEmpty(country.getIndex())) {
            this.f78111a.setVisibility(8);
        } else {
            this.f78111a.setVisibility(0);
            this.f78112b.setText(country.getIndex());
        }
        this.f78113c.setText(country.getCountry());
        this.f78114d.setText(country.getCodeAndAdd());
    }
}
