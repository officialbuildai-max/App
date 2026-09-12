package wq;

import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.c0;
import com.blankj.utilcode.util.u;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.g;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.R$string;
import com.transsion.search.bean.SuggestEntity;
import com.transsion.search.fragment.suggest.d;
import ej.f;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class c extends BaseItemProvider {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return 1;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.fragment_search_suggest_movie_layout;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, SuggestEntity item) {
        String str;
        Integer seNum;
        String mKeyWord;
        Cover cover;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        f.b m11 = f.f62005a.m(k());
        Subject subject = item.getSubject();
        String str2 = "";
        if (subject == null || (cover = subject.getCover()) == null || (str = cover.getUrl()) == null) {
            str = "";
        }
        m11.g(str).d((ImageView) helper.getView(R$id.ivCover));
        int i11 = R$id.tvTitle;
        d.Companion companion = com.transsion.search.fragment.suggest.d.INSTANCE;
        BaseProviderMultiAdapter g11 = g();
        com.transsion.search.fragment.suggest.d dVar = g11 instanceof com.transsion.search.fragment.suggest.d ? (com.transsion.search.fragment.suggest.d) g11 : null;
        if (dVar != null && (mKeyWord = dVar.getMKeyWord()) != null) {
            str2 = mKeyWord;
        }
        Subject subject2 = item.getSubject();
        helper.setText(i11, companion.a(str2, subject2 != null ? subject2.getTitle() : null));
        AppCompatTextView appCompatTextView = (AppCompatTextView) helper.getViewOrNull(R$id.tvDes);
        if (appCompatTextView != null) {
            Subject subject3 = item.getSubject();
            Date l11 = c0.l(subject3 != null ? subject3.getReleaseDate() : null, "yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(l11);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) String.valueOf(calendar.get(1)));
            Subject subject4 = item.getSubject();
            String[] a11 = u.a(subject4 != null ? subject4.getGenre() : null, ",");
            if (a11 != null) {
                for (String str3 : a11) {
                    spannableStringBuilder.append((CharSequence) " · ").append((CharSequence) str3);
                }
            }
            Subject subject5 = item.getSubject();
            if (!TextUtils.isEmpty(subject5 != null ? subject5.getCountryName() : null)) {
                SpannableStringBuilder append = spannableStringBuilder.append((CharSequence) " · ");
                Subject subject6 = item.getSubject();
                append.append((CharSequence) (subject6 != null ? subject6.getCountryName() : null));
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            spannableStringBuilder2.append((CharSequence) "  ");
            spannableStringBuilder2.append((CharSequence) spannableStringBuilder.toString());
            Subject subject7 = item.getSubject();
            int a12 = g.a(subject7 != null ? subject7.getSubjectType() : null);
            spannableStringBuilder2.setSpan(Build.VERSION.SDK_INT >= 29 ? new ImageSpan(appCompatTextView.getContext(), a12, 2) : new ImageSpan(appCompatTextView.getContext(), a12, 1), 0, 1, 34);
            appCompatTextView.setText(spannableStringBuilder2);
        }
        int i12 = R$id.tvScore;
        Subject subject8 = item.getSubject();
        helper.setText(i12, String.valueOf(subject8 != null ? subject8.getImdbRate() : null));
        Subject subject9 = item.getSubject();
        int intValue = (subject9 == null || (seNum = subject9.getSeNum()) == null) ? 0 : seNum.intValue();
        helper.setGone(R$id.tvSeasons, intValue <= 1);
        String string = k().getString(R$string.seasons, String.valueOf(intValue));
        Intrinsics.g(string, "getString(...)");
        helper.setText(R$id.tvSeasons, z(string));
    }

    public final String z(String input) {
        Intrinsics.h(input, "input");
        List S0 = StringsKt.S0(input, new String[]{" "}, false, 0, 6, null);
        if (S0.size() != 2) {
            return "";
        }
        String lowerCase = (S0.get(1) + " " + S0.get(0)).toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }
}
