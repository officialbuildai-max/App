package com.transsion.home.fragment.rank;

import ak.t;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.b0;
import androidx.view.c0;
import androidx.view.v0;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baseui.R$string;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.R$mipmap;
import com.transsion.home.bean.RankAllData;
import com.transsion.home.fragment.rank.RankListFragment;
import com.transsion.home.p004enum.HomeTabId;
import com.transsion.home.viewmodel.RankAllViewModel;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.usercenter.R$color;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.widget.DownloadView;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import gl.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002!\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u0017\u0010\u0013\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0019\u0010\u0004R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/transsion/home/fragment/rank/RankListFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lgl/v;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "e0", "(Landroid/view/LayoutInflater;)Lgl/v;", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/os/Bundle;", "savedInstanceState", "", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "Lcom/transsion/home/bean/RankAllData;", "data", "k0", "(Lcom/transsion/home/bean/RankAllData;)V", "errorView", "j0", "(Landroid/view/View;)V", "startLoading", "hideLoading", "Lcom/transsion/home/viewmodel/RankAllViewModel;", "a", "Lcom/transsion/home/viewmodel/RankAllViewModel;", "viewModel", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/Subject;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "mMainAdapter", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "headerView", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class RankListFragment extends BaseFragment<v> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private RankAllViewModel viewModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private BaseQuickAdapter mMainAdapter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private TextView headerView;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/transsion/home/fragment/rank/RankListFragment$a;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/Subject;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lr6/i;", "<init>", "()V", "", "seconds", "", "E1", "(I)Ljava/lang/String;", WebConstants.FIELD_ITEM, "pos", "", "I1", "(Lcom/transsion/moviedetailapi/bean/Subject;I)V", RequestParameters.POSITION, "H1", "G1", "F1", "(I)I", "holder", "C1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/Subject;)V", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes5.dex */
    public static final class a extends BaseQuickAdapter implements r6.i {
        public static final int F = 8;

        public a() {
            super(R$layout.item_movie_rank_education_subject, null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void D1(a aVar, Subject subject, int i11, View view) {
            aVar.I1(subject, i11);
        }

        private final String E1(int seconds) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
            String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(seconds / 3600), Integer.valueOf((seconds % 3600) / 60), Integer.valueOf(seconds % 60)}, 3));
            Intrinsics.g(format, "format(...)");
            return format;
        }

        private final int F1(int pos) {
            return pos != 0 ? pos != 1 ? pos != 2 ? R$mipmap.ic_rank_defalut : R$mipmap.ic_rank_03 : R$mipmap.ic_rank_02 : R$mipmap.ic_rank_01;
        }

        private final void G1(Subject item, int position) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            il.b.e(item, linkedHashMap);
            linkedHashMap.put("event_type", "rank_item_browse");
            linkedHashMap.put(RequestParameters.POSITION, String.valueOf(position));
            hj.i.f64628a.D("rank_all_page", linkedHashMap);
        }

        private final void H1(Subject item, int position) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            il.b.e(item, linkedHashMap);
            linkedHashMap.put(RequestParameters.POSITION, String.valueOf(position));
            linkedHashMap.put("event_type", "rank_item_click");
            linkedHashMap.put("click_type", "poster_click");
            hj.i.f64628a.p("rank_all_page", linkedHashMap);
        }

        private final void I1(Subject item, int pos) {
            rl.h.f(item, "rank_all");
            H1(item, pos);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: C1, reason: merged with bridge method [inline-methods] */
        public void F(BaseViewHolder holder, final Subject item) {
            String str;
            String str2;
            String valueOf;
            Intrinsics.h(holder, "holder");
            Intrinsics.h(item, "item");
            ImageView imageView = (ImageView) holder.getView(R$id.rank_item_image);
            f.a aVar = ej.f.f62005a;
            Context context = imageView.getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m11 = aVar.m(context);
            Cover cover = item.getCover();
            if (cover == null || (str = cover.getUrl()) == null) {
                str = "";
            }
            f.b g11 = m11.g(str);
            Cover cover2 = item.getCover();
            if (cover2 == null || (str2 = cover2.getThumbnail()) == null) {
                str2 = "";
            }
            g11.l(str2).d(imageView);
            final int e11 = ak.k.e(getData(), item);
            AppCompatImageView appCompatImageView = (AppCompatImageView) holder.getViewOrNull(R$id.rank_item_rank_tag);
            if (appCompatImageView != null) {
                appCompatImageView.setImageResource(F1(e11));
            }
            if (e11 > 2) {
                if (e11 < 9) {
                    valueOf = "0" + (e11 + 1);
                } else {
                    valueOf = String.valueOf(e11 + 1);
                }
                holder.setText(R$id.rank_item_tag_rank, valueOf);
            } else {
                holder.setText(R$id.rank_item_tag_rank, "");
            }
            TextView textView = (TextView) holder.getView(R$id.rank_item_rank_duration);
            Integer durationSeconds = item.getDurationSeconds();
            textView.setText(E1(durationSeconds != null ? durationSeconds.intValue() : 0));
            TextView textView2 = (TextView) holder.getView(R$id.rank_item_title);
            textView2.setText(item.getTitle());
            textView2.setGravity(il.a.d());
            ((TextView) holder.getView(R$id.rank_item_des)).setText(item.getViewers() + " students");
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.rank.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RankListFragment.a.D1(RankListFragment.a.this, item, e11, view);
                }
            });
            G1(item, e11);
        }

        @Override // r6.i
        public /* bridge */ /* synthetic */ r6.f b(BaseQuickAdapter baseQuickAdapter) {
            return r6.h.a(this, baseQuickAdapter);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\fJ'\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\fJ\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0019\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/transsion/home/fragment/rank/RankListFragment$b;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/Subject;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lr6/i;", "<init>", "()V", WebConstants.FIELD_ITEM, "", "pos", "", "M1", "(Lcom/transsion/moviedetailapi/bean/Subject;I)V", "N1", RequestParameters.POSITION, "", NativeComponentConstants.KEY_COMPONENT_TYPE, "K1", "(Lcom/transsion/moviedetailapi/bean/Subject;ILjava/lang/String;)V", "J1", "I1", "(I)I", "subject", "Lcom/transsnet/downloader/widget/DownloadView;", "downloadView", "L1", "(Lcom/transsion/moviedetailapi/bean/Subject;Lcom/transsnet/downloader/widget/DownloadView;)V", "holder", "E1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/moviedetailapi/bean/Subject;)V", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes5.dex */
    public static final class b extends BaseQuickAdapter implements r6.i {
        public static final int F = 8;

        public b() {
            super(R$layout.item_movie_rank_subject, null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void F1(TextView textView, TextView textView2, Subject subject) {
            textView.setMaxLines(textView2.getLineCount() > 1 ? 2 : 3);
            textView.setText(subject.getDescription());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void G1(b bVar, Subject subject, int i11, View view) {
            bVar.N1(subject, i11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void H1(b bVar, Subject subject, int i11, View view) {
            bVar.M1(subject, i11);
        }

        private final int I1(int pos) {
            return pos != 0 ? pos != 1 ? pos != 2 ? R$mipmap.ic_rank_defalut : R$mipmap.ic_rank_03 : R$mipmap.ic_rank_02 : R$mipmap.ic_rank_01;
        }

        private final void J1(Subject item, int position) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            il.b.e(item, linkedHashMap);
            linkedHashMap.put("event_type", "rank_item_browse");
            linkedHashMap.put(RequestParameters.POSITION, String.valueOf(position));
            hj.i.f64628a.D("rank_all_page", linkedHashMap);
        }

        private final void K1(Subject item, int position, String type) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            il.b.e(item, linkedHashMap);
            linkedHashMap.put(RequestParameters.POSITION, String.valueOf(position));
            linkedHashMap.put("event_type", "rank_item_click");
            linkedHashMap.put("click_type", type);
            hj.i.f64628a.p("rank_all_page", linkedHashMap);
        }

        private final void L1(Subject subject, DownloadView downloadView) {
            if (!(subject != null ? Intrinsics.c(subject.getHasResource(), Boolean.TRUE) : false)) {
                jg.c.h(downloadView);
                return;
            }
            jg.c.k(downloadView);
            if (t.f727a.b()) {
                Integer subjectType = subject.getSubjectType();
                int value = SubjectType.SHORT_TV.getValue();
                if (subjectType == null || subjectType.intValue() != value) {
                    downloadView.setShowPlayType();
                    return;
                }
            }
            DownloadView.setShowType$default(downloadView, subject.getSubjectId(), null, null, false, R$string.download_movie, 14, null);
        }

        private final void M1(Subject item, int pos) {
            K1(item, pos, rl.h.g(item, "rank_all_page", getContext(), "rank_all"));
        }

        private final void N1(Subject item, int pos) {
            rl.h.f(item, "rank_all");
            K1(item, pos, "poster_click");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: E1, reason: merged with bridge method [inline-methods] */
        public void F(BaseViewHolder holder, final Subject item) {
            String str;
            String str2;
            String valueOf;
            Intrinsics.h(holder, "holder");
            Intrinsics.h(item, "item");
            ImageView imageView = (ImageView) holder.getView(R$id.rank_item_image);
            f.a aVar = ej.f.f62005a;
            Context context = imageView.getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b m11 = aVar.m(context);
            Cover cover = item.getCover();
            if (cover == null || (str = cover.getUrl()) == null) {
                str = "";
            }
            f.b g11 = m11.g(str);
            Cover cover2 = item.getCover();
            if (cover2 == null || (str2 = cover2.getThumbnail()) == null) {
                str2 = "";
            }
            g11.l(str2).d(imageView);
            final int e11 = ak.k.e(getData(), item);
            AppCompatImageView appCompatImageView = (AppCompatImageView) holder.getViewOrNull(R$id.rank_item_rank_tag);
            if (appCompatImageView != null) {
                appCompatImageView.setImageResource(I1(e11));
            }
            holder.setText(R$id.rank_item_corner, item.getCorner());
            if (e11 > 2) {
                if (e11 < 9) {
                    valueOf = "0" + (e11 + 1);
                } else {
                    valueOf = String.valueOf(e11 + 1);
                }
                holder.setText(R$id.rank_item_tag_rank, valueOf);
            } else {
                holder.setText(R$id.rank_item_tag_rank, "");
            }
            final TextView textView = (TextView) holder.getView(R$id.rank_item_title);
            final TextView textView2 = (TextView) holder.getView(R$id.rank_item_des);
            textView.setText(item.getTitle());
            textView.setGravity(il.a.d());
            textView.post(new Runnable() { // from class: com.transsion.home.fragment.rank.o
                @Override // java.lang.Runnable
                public final void run() {
                    RankListFragment.b.F1(textView2, textView, item);
                }
            });
            L1(item, (DownloadView) holder.getView(R$id.rank_item_download));
            holder.setText(R$id.rank_item_imdb, item.getImdbRate());
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.rank.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RankListFragment.b.G1(RankListFragment.b.this, item, e11, view);
                }
            });
            holder.getView(R$id.rank_item_download).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.rank.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RankListFragment.b.H1(RankListFragment.b.this, item, e11, view);
                }
            });
            J1(item, e11);
        }

        @Override // r6.i
        public /* bridge */ /* synthetic */ r6.f b(BaseQuickAdapter baseQuickAdapter) {
            return r6.h.a(this, baseQuickAdapter);
        }
    }

    /* loaded from: classes5.dex */
    static final class c implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f45266a;

        c(Function1 function) {
            Intrinsics.h(function, "function");
            this.f45266a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f45266a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f45266a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(final RankListFragment rankListFragment) {
        RecyclerView recyclerView;
        if (nh.m.f70597a.e()) {
            RankAllViewModel rankAllViewModel = rankListFragment.viewModel;
            if (rankAllViewModel != null) {
                rankAllViewModel.l();
                return;
            }
            return;
        }
        uh.b.f76876a.d(com.tn.lib.widget.R$string.no_network_toast);
        v mViewBinding = rankListFragment.getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f63978b) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.rank.m
            @Override // java.lang.Runnable
            public final void run() {
                RankListFragment.g0(RankListFragment.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(RankListFragment rankListFragment) {
        r6.f h02;
        BaseQuickAdapter baseQuickAdapter = rankListFragment.mMainAdapter;
        if (baseQuickAdapter == null || (h02 = baseQuickAdapter.h0()) == null) {
            return;
        }
        h02.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(final RankListFragment rankListFragment, final RankAllData rankAllData) {
        ConstraintLayout root;
        r6.f h02;
        if (rankAllData == null) {
            BaseQuickAdapter baseQuickAdapter = rankListFragment.mMainAdapter;
            if (baseQuickAdapter != null && (h02 = baseQuickAdapter.h0()) != null) {
                h02.v();
            }
        } else {
            BaseQuickAdapter baseQuickAdapter2 = rankListFragment.mMainAdapter;
            if (baseQuickAdapter2 != null) {
                List<Subject> subjects = rankAllData.getSubjects();
                baseQuickAdapter2.q(subjects != null ? subjects : new ArrayList<>());
            }
            v mViewBinding = rankListFragment.getMViewBinding();
            if (mViewBinding != null && (root = mViewBinding.getRoot()) != null) {
                root.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.rank.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        RankListFragment.i0(RankListFragment.this, rankAllData);
                    }
                }, 300L);
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(RankListFragment rankListFragment, RankAllData rankAllData) {
        BaseQuickAdapter baseQuickAdapter;
        r6.f h02;
        r6.f h03;
        BaseQuickAdapter baseQuickAdapter2;
        r6.f h04;
        BaseQuickAdapter baseQuickAdapter3 = rankListFragment.mMainAdapter;
        if (baseQuickAdapter3 != null && (h03 = baseQuickAdapter3.h0()) != null && h03.r() && (baseQuickAdapter2 = rankListFragment.mMainAdapter) != null && (h04 = baseQuickAdapter2.h0()) != null) {
            h04.s();
        }
        Pager pager = rankAllData.getPager();
        if ((pager != null ? Intrinsics.c(pager.getHasMore(), Boolean.TRUE) : false) || (baseQuickAdapter = rankListFragment.mMainAdapter) == null || (h02 = baseQuickAdapter.h0()) == null) {
            return;
        }
        r6.f.u(h02, false, 1, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public v getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.viewModel = (RankAllViewModel) new v0(activity).a(RankAllViewModel.class);
        }
        v c11 = v.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void hideLoading() {
        ConstraintLayout constraintLayout;
        v mViewBinding = getMViewBinding();
        if (mViewBinding == null || (constraintLayout = mViewBinding.f63979c) == null) {
            return;
        }
        jg.c.h(constraintLayout);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView;
        Bundle arguments;
        Intrinsics.h(view, "view");
        Fragment parentFragment = getParentFragment();
        this.mMainAdapter = HomeTabId.INSTANCE.h((parentFragment == null || (arguments = parentFragment.getArguments()) == null) ? null : Integer.valueOf(arguments.getInt("tabId")), true) ? new a() : new b();
        v mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f63978b) == null) {
            return;
        }
        recyclerView.setAdapter(this.mMainAdapter);
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setItemAnimator(null);
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ig.f(0.0f, 16.0f, 0.0f, 5, null));
        }
    }

    public final void j0(View errorView) {
        Intrinsics.h(errorView, "errorView");
        BaseQuickAdapter baseQuickAdapter = this.mMainAdapter;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.n1(null);
        }
        BaseQuickAdapter baseQuickAdapter2 = this.mMainAdapter;
        if (baseQuickAdapter2 != null) {
            baseQuickAdapter2.Y0(errorView);
        }
    }

    public final void k0(RankAllData data) {
        r6.f h02;
        RecyclerView recyclerView;
        r6.f h03;
        r6.f h04;
        Pager pager;
        BaseQuickAdapter baseQuickAdapter = this.mMainAdapter;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.n1(data != null ? data.getSubjects() : null);
        }
        TextView textView = this.headerView;
        if (textView == null) {
            TextView textView2 = new TextView(getContext());
            textView2.setText(data != null ? data.getTitle() : null);
            textView2.setPadding(a0.a(12.0f), a0.a(16.0f), a0.a(12.0f), 0);
            textView2.setTextSize(2, 16.0f);
            textView2.setTextColor(androidx.core.content.b.getColor(textView2.getContext(), R$color.pair_text_191F2B));
            textView2.setMaxLines(2);
            textView2.setGravity(il.a.d());
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setTypeface(Typeface.create("ans-serif", 1));
            BaseQuickAdapter baseQuickAdapter2 = this.mMainAdapter;
            if (baseQuickAdapter2 != null) {
                BaseQuickAdapter.y(baseQuickAdapter2, textView2, 0, 0, 6, null);
            }
            this.headerView = textView2;
        } else if (textView != null) {
            textView.setText(data != null ? data.getTitle() : null);
        }
        if ((data == null || (pager = data.getPager()) == null) ? false : Intrinsics.c(pager.getHasMore(), Boolean.TRUE)) {
            BaseQuickAdapter baseQuickAdapter3 = this.mMainAdapter;
            if (baseQuickAdapter3 != null && (h04 = baseQuickAdapter3.h0()) != null) {
                h04.z(true);
            }
            BaseQuickAdapter baseQuickAdapter4 = this.mMainAdapter;
            if (baseQuickAdapter4 != null && (h03 = baseQuickAdapter4.h0()) != null) {
                h03.y(true);
            }
        } else {
            BaseQuickAdapter baseQuickAdapter5 = this.mMainAdapter;
            if (baseQuickAdapter5 != null && (h02 = baseQuickAdapter5.h0()) != null) {
                r6.f.u(h02, false, 1, null);
            }
        }
        v mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f63978b) == null) {
            return;
        }
        recyclerView.scrollToPosition(0);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        b0 i11;
        r6.f h02;
        BaseQuickAdapter baseQuickAdapter = this.mMainAdapter;
        if (baseQuickAdapter != null && (h02 = baseQuickAdapter.h0()) != null) {
            h02.D(new p6.f() { // from class: com.transsion.home.fragment.rank.j
                @Override // p6.f
                public final void a() {
                    RankListFragment.f0(RankListFragment.this);
                }
            });
        }
        RankAllViewModel rankAllViewModel = this.viewModel;
        if (rankAllViewModel == null || (i11 = rankAllViewModel.i()) == null) {
            return;
        }
        i11.j(this, new c(new Function1() { // from class: com.transsion.home.fragment.rank.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit h03;
                h03 = RankListFragment.h0(RankListFragment.this, (RankAllData) obj);
                return h03;
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void startLoading() {
        ConstraintLayout constraintLayout;
        v mViewBinding = getMViewBinding();
        if (mViewBinding == null || (constraintLayout = mViewBinding.f63979c) == null) {
            return;
        }
        jg.c.k(constraintLayout);
    }
}
