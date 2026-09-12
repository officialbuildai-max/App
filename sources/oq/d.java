package oq;

import android.content.Context;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.c0;
import com.blankj.utilcode.util.u;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.view.CornerTextView;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.g;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.search.bean.SearchSubject;
import ej.f;
import java.util.Calendar;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import oh.h;

/* loaded from: classes6.dex */
public final class d extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final int f71224e;

    /* renamed from: f, reason: collision with root package name */
    private final int f71225f;

    /* renamed from: g, reason: collision with root package name */
    private final int f71226g;

    /* renamed from: h, reason: collision with root package name */
    private final int f71227h;

    /* renamed from: i, reason: collision with root package name */
    private final int f71228i;

    /* renamed from: j, reason: collision with root package name */
    private final int f71229j;

    public d(Context context) {
        Intrinsics.h(context, "context");
        int a11 = a0.a(104.0f);
        this.f71224e = a11;
        int a12 = a0.a(149.0f);
        this.f71225f = a12;
        int a13 = a0.a(48.0f);
        this.f71226g = a13;
        int e11 = h.f71144a.e(context);
        this.f71227h = e11;
        int i11 = (e11 - a13) / 3;
        this.f71228i = i11;
        this.f71229j = (int) (i11 * ((a12 * 1.0f) / a11));
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return 0;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.item_works_layout_vertical;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, SearchSubject item) {
        String url;
        String str;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        Context context = helper.itemView.getContext();
        ImageView imageView = (ImageView) helper.itemView.findViewById(R$id.ivCover);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).height = this.f71229j;
        ((ViewGroup.MarginLayoutParams) bVar).width = this.f71228i;
        Cover cover = item.getCover();
        if (cover != null && (url = cover.getUrl()) != null) {
            f.a aVar = f.f62005a;
            Intrinsics.e(context);
            f.b c11 = aVar.m(context).g(url).m(this.f71228i).c(this.f71229j);
            Cover cover2 = item.getCover();
            if (cover2 == null || (str = cover2.getThumbnail()) == null) {
                str = "";
            }
            f.b l11 = c11.l(str);
            Intrinsics.e(imageView);
            l11.d(imageView);
        }
        helper.setText(R$id.tvSubject, item.getTitle());
        AppCompatTextView appCompatTextView = (AppCompatTextView) helper.getViewOrNull(R$id.tvSubjectYear);
        if (appCompatTextView != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) "  ");
            String releaseDate = item.getReleaseDate();
            if (releaseDate != null && releaseDate.length() != 0) {
                Date l12 = c0.l(item.getReleaseDate(), "yyyy-MM-dd");
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(l12);
                spannableStringBuilder.append((CharSequence) String.valueOf(calendar.get(1)));
            }
            String[] a11 = u.a(item.getGenre(), ",");
            if (a11 != null) {
                for (String str2 : a11) {
                    spannableStringBuilder.append((CharSequence) " / ").append((CharSequence) str2);
                }
            }
            String countryName = item.getCountryName();
            if (countryName != null && countryName.length() != 0) {
                spannableStringBuilder.append((CharSequence) " / ").append((CharSequence) item.getCountryName());
            }
            int a12 = g.a(item.getSubjectType());
            spannableStringBuilder.setSpan(Build.VERSION.SDK_INT >= 29 ? new ImageSpan(context, a12, 2) : new ImageSpan(context, a12, 1), 0, 1, 34);
            appCompatTextView.setText(spannableStringBuilder);
        }
        Integer seNum = item.getSeNum();
        int intValue = seNum != null ? seNum.intValue() : 0;
        helper.setGone(R$id.tvSeasons, intValue < 2);
        helper.setText(R$id.tvSeasons, context.getString(R$string.seasons, String.valueOf(intValue)));
        ((CornerTextView) helper.getView(R$id.ivSearchCorner)).setTextWithType(item.getCorner(), item.getSubjectType());
    }
}
