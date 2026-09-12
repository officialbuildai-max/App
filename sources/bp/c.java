package bp;

import android.content.Context;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsnet.downloader.widget.DownloadView;
import ej.f;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class c extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final String f16748e;

    /* renamed from: f, reason: collision with root package name */
    private final dx.e f16749f;

    public c(String pageName, dx.e dotHelper) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(dotHelper, "dotHelper");
        this.f16748e = pageName;
        this.f16749f = dotHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void A(com.transsion.moviedetailapi.bean.Subject r19, com.transsnet.downloader.widget.DownloadView r20, bp.c r21, com.transsion.moviedetailapi.bean.Subject r22, java.lang.Integer r23, android.view.View r24) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bp.c.A(com.transsion.moviedetailapi.bean.Subject, com.transsnet.downloader.widget.DownloadView, bp.c, com.transsion.moviedetailapi.bean.Subject, java.lang.Integer, android.view.View):void");
    }

    private final void B(View view, Subject subject) {
        if (subject == null) {
            return;
        }
        Navigator c11 = TheRouter.c("/playvideo/detail");
        Integer subjectType = subject.getSubjectType();
        Navigator.x(c11.F("subject_type", subjectType != null ? subjectType.intValue() : SubjectType.MOVIE.getValue()).K("id", subject.getSubjectId()).F("season", subject.getSeason()).K("ops", subject.getOps()), view.getContext(), null, 2, null);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return 1;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.item_foryou;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder holder, final Subject item) {
        String str;
        String str2;
        String str3;
        boolean z10 = false;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        BaseProviderMultiAdapter g11 = g();
        final Integer valueOf = g11 != null ? Integer.valueOf(g11.g0(item)) : null;
        AppCompatTextView appCompatTextView = (AppCompatTextView) holder.getViewOrNull(R$id.tv_title);
        if (appCompatTextView != null) {
            appCompatTextView.setText(item.getTitle());
        }
        ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getViewOrNull(R$id.iv_cover);
        str = "";
        if (shapeableImageView != null) {
            f.a aVar = ej.f.f62005a;
            Context context = shapeableImageView.getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m11 = aVar.m(context);
            Cover cover = item.getCover();
            if (cover == null || (str2 = cover.getUrl()) == null) {
                str2 = "";
            }
            f.b g12 = m11.g(str2);
            Cover cover2 = item.getCover();
            if (cover2 == null || (str3 = cover2.getThumbnail()) == null) {
                str3 = "";
            }
            g12.l(str3).d(shapeableImageView);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) holder.getViewOrNull(R$id.tv_desc);
        if (appCompatTextView2 != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            String countryName = item.getCountryName();
            if (countryName != null && countryName.length() != 0) {
                spannableStringBuilder.append((CharSequence) item.getCountryName());
            }
            String genre = item.getGenre();
            if (genre != null && genre.length() != 0) {
                spannableStringBuilder.append((CharSequence) " / ").append((CharSequence) item.getGenre());
            }
            String releaseDate = item.getReleaseDate();
            if (releaseDate != null && releaseDate.length() != 0) {
                spannableStringBuilder.append((CharSequence) " / ").append((CharSequence) item.getReleaseDate());
            }
            Integer durationSeconds = item.getDurationSeconds();
            if (durationSeconds != null) {
                spannableStringBuilder.append((CharSequence) " / ").append((CharSequence) TimeUtilKt.f(durationSeconds.intValue()));
            }
            CharSequence o12 = StringsKt.o1(StringsKt.n1(spannableStringBuilder), '/');
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            spannableStringBuilder2.append((CharSequence) "  ").append(o12);
            int a11 = com.transsion.moviedetailapi.g.a(item.getSubjectType());
            spannableStringBuilder2.setSpan(Build.VERSION.SDK_INT >= 29 ? new ImageSpan(appCompatTextView2.getContext(), a11, 2) : new ImageSpan(appCompatTextView2.getContext(), a11, 1), 0, 1, 34);
            appCompatTextView2.setText(spannableStringBuilder2);
        }
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) holder.getViewOrNull(R$id.tv_score);
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(item.getImdbRate());
        }
        final DownloadView downloadView = (DownloadView) holder.getViewOrNull(R$id.ll_download);
        if (downloadView != null) {
            downloadView.setPageFrom(this.f16748e);
            if (!Intrinsics.c(item.getHasResource(), Boolean.TRUE)) {
                jg.c.g(downloadView);
                return;
            }
            downloadView.setOnClickListener(new View.OnClickListener() { // from class: bp.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.A(Subject.this, downloadView, this, item, valueOf, view);
                }
            });
            jg.c.k(downloadView);
            if (item.isShortTV()) {
                return;
            }
            if (ak.t.f727a.b()) {
                downloadView.setShowPlayType();
                return;
            }
            List<ResourceDetectors> resourceDetectors = item.getResourceDetectors();
            if (resourceDetectors != null) {
                if (!resourceDetectors.isEmpty()) {
                    String resourceId = resourceDetectors.get(0).getResourceId();
                    str = resourceId != null ? resourceId : "";
                    Integer type = resourceDetectors.get(0).getType();
                    if (type != null && type.intValue() == 1) {
                        z10 = true;
                    }
                }
                DownloadView.setShowType$default(downloadView, item.getSubjectId(), str, Boolean.valueOf(z10), false, 0, 24, null);
            }
        }
    }
}
