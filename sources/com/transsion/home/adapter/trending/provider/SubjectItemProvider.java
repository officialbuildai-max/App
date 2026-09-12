package com.transsion.home.adapter.trending.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$color;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsnet.downloader.widget.DownloadView;
import ej.f;
import java.util.Calendar;
import java.util.Date;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class SubjectItemProvider extends b {

    /* renamed from: e, reason: collision with root package name */
    private final boolean f44758e;

    /* renamed from: f, reason: collision with root package name */
    private final int f44759f = Math.min(com.blankj.utilcode.util.y.e(), com.blankj.utilcode.util.y.c());

    /* renamed from: g, reason: collision with root package name */
    private final int f44760g;

    /* renamed from: h, reason: collision with root package name */
    private BaseViewHolder f44761h;

    public SubjectItemProvider(boolean z10) {
        this.f44758e = z10;
        this.f44760g = com.blankj.utilcode.util.a0.a(z10 ? 146.40001f : 122.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(Subject subject, boolean z10, boolean z11, long j11) {
        subject.setLoadCoverSuccess(z10);
        subject.setCoverCache(z11);
        subject.setLoadCoverDuration(j11);
        return Unit.f67184a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, OperateItem item) {
        String subjectId;
        Cover cover;
        Cover cover2;
        Cover cover3;
        Cover cover4;
        String str;
        String str2;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        final Subject feedsSubject = item.getFeedsSubject();
        if (feedsSubject == null || (subjectId = feedsSubject.getSubjectId()) == null || subjectId.length() == 0) {
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) helper.getViewOrNull(R$id.cl_cover);
        if (constraintLayout != null) {
            ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
            int i11 = this.f44760g;
            layoutParams.height = i11;
            layoutParams.width = (i11 / 4) * 3;
            constraintLayout.setLayoutParams(layoutParams);
        }
        ShapeableImageView shapeableImageView = (ShapeableImageView) helper.getViewOrNull(R$id.iv_cover);
        if (shapeableImageView != null) {
            if (feedsSubject.getBuiltIn()) {
                kotlinx.coroutines.k.d(kotlinx.coroutines.o0.a(y0.c()), null, null, new SubjectItemProvider$convert$2$1(feedsSubject, shapeableImageView, null), 3, null);
            } else {
                f.a aVar = ej.f.f62005a;
                Context context = shapeableImageView.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m11 = aVar.m(context);
                Cover cover5 = feedsSubject.getCover();
                if (cover5 == null || (str = cover5.getUrl()) == null) {
                    str = "";
                }
                f.b i12 = m11.g(str).m(this.f44759f).i(R$color.skeleton);
                Cover cover6 = feedsSubject.getCover();
                if (cover6 == null || (str2 = cover6.getThumbnail()) == null) {
                    str2 = "";
                }
                i12.l(str2).b(new Function3() { // from class: com.transsion.home.adapter.trending.provider.m0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit F;
                        F = SubjectItemProvider.F(Subject.this, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), ((Long) obj3).longValue());
                        return F;
                    }
                }).d(shapeableImageView);
            }
        }
        ShapeableImageView shapeableImageView2 = (ShapeableImageView) helper.getViewOrNull(R$id.iv_stills);
        if (shapeableImageView2 != null) {
            ViewGroup.LayoutParams layoutParams2 = shapeableImageView2.getLayoutParams();
            layoutParams2.height = this.f44760g;
            shapeableImageView2.setLayoutParams(layoutParams2);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Trailer trailer = feedsSubject.getTrailer();
            T url = (trailer == null || (cover4 = trailer.getCover()) == null) ? 0 : cover4.getUrl();
            objectRef.element = url;
            CharSequence charSequence = (CharSequence) url;
            if (charSequence == null || charSequence.length() == 0) {
                Cover stills = feedsSubject.getStills();
                String url2 = stills != null ? stills.getUrl() : null;
                objectRef.element = (url2 == null || url2.length() == 0 ? (cover = feedsSubject.getCover()) == null : (cover = feedsSubject.getStills()) == null) ? 0 : cover.getUrl();
            }
            Trailer trailer2 = feedsSubject.getTrailer();
            String thumbnail = (trailer2 == null || (cover3 = trailer2.getCover()) == null) ? null : cover3.getThumbnail();
            if (thumbnail == null || thumbnail.length() == 0) {
                Cover stills2 = feedsSubject.getStills();
                String thumbnail2 = stills2 != null ? stills2.getThumbnail() : null;
                thumbnail = (thumbnail2 == null || thumbnail2.length() == 0 ? (cover2 = feedsSubject.getCover()) == null : (cover2 = feedsSubject.getStills()) == null) ? null : cover2.getThumbnail();
            }
            if (feedsSubject.getBuiltIn()) {
                kotlinx.coroutines.k.d(kotlinx.coroutines.o0.a(y0.c()), null, null, new SubjectItemProvider$convert$3$1(objectRef, shapeableImageView2, null), 3, null);
            } else {
                f.a aVar2 = ej.f.f62005a;
                Context context2 = shapeableImageView2.getContext();
                Intrinsics.g(context2, "getContext(...)");
                f.b m12 = aVar2.m(context2);
                String str3 = (String) objectRef.element;
                if (str3 == null) {
                    str3 = "";
                }
                m12.g(str3).i(R$color.skeleton).l(thumbnail != null ? thumbnail : "").d(shapeableImageView2);
            }
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) helper.getViewOrNull(R$id.ic_player);
        if (appCompatImageView != null) {
            if (feedsSubject.getTrailer() == null) {
                jg.c.g(appCompatImageView);
            } else {
                jg.c.k(appCompatImageView);
            }
        }
        helper.setText(R$id.tv_subject, feedsSubject.getTitle());
        Date l11 = com.blankj.utilcode.util.c0.l(feedsSubject.getReleaseDate(), "yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(l11);
        AppCompatTextView appCompatTextView = (AppCompatTextView) helper.getViewOrNull(R$id.tv_subject_year);
        if (appCompatTextView != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) String.valueOf(calendar.get(1)));
            String countryName = feedsSubject.getCountryName();
            if (countryName != null && countryName.length() != 0) {
                spannableStringBuilder.append((CharSequence) " • ").append((CharSequence) feedsSubject.getCountryName());
            }
            String genre = feedsSubject.getGenre();
            if (genre != null && genre.length() != 0) {
                SpannableStringBuilder append = spannableStringBuilder.append((CharSequence) " • ");
                String genre2 = feedsSubject.getGenre();
                append.append((CharSequence) (genre2 != null ? StringsKt.Q(genre2, "，", " • ", false, 4, null) : null));
            }
            appCompatTextView.setText(spannableStringBuilder.toString());
            Drawable drawable = androidx.core.content.b.getDrawable(appCompatTextView.getContext(), com.transsion.moviedetailapi.g.a(feedsSubject.getSubjectType()));
            if (drawable != null) {
                drawable.setTint(androidx.core.content.b.getColor(appCompatTextView.getContext(), R$color.gray_40));
            }
            appCompatTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        helper.setText(com.transsion.baseui.R$id.tv_subject, feedsSubject.getTitle());
        if (Intrinsics.c(feedsSubject.getHasResource(), Boolean.TRUE)) {
            DownloadView downloadView = (DownloadView) helper.getViewOrNull(R$id.ll_download);
            if (downloadView != null) {
                jg.c.k(downloadView);
                if (ak.t.f727a.b()) {
                    Integer subjectType = feedsSubject.getSubjectType();
                    int value = SubjectType.SHORT_TV.getValue();
                    if (subjectType == null || subjectType.intValue() != value) {
                        downloadView.setShowPlayType();
                    }
                }
                ResourceDetectors resourceDetector = feedsSubject.getResourceDetector();
                if (resourceDetector != null) {
                    String subjectId2 = feedsSubject.getSubjectId();
                    String resourceId = resourceDetector.getResourceId();
                    Integer type = resourceDetector.getType();
                    DownloadView.setShowType$default(downloadView, subjectId2, resourceId, Boolean.valueOf(type != null && type.intValue() == 1), false, 0, 24, null);
                }
            }
        } else {
            helper.setGone(R$id.ll_download, true);
        }
        this.f44761h = helper;
        A(helper, feedsSubject);
    }

    public final View G() {
        BaseViewHolder baseViewHolder = this.f44761h;
        if (baseViewHolder != null) {
            return (DownloadView) baseViewHolder.getViewOrNull(R$id.ll_download);
        }
        return null;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PostItemType.SUBJECT.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.post_list_item_subject;
    }
}
