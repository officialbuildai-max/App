package com.transsnet.downloader.adapter;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.therouter.TheRouter;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.memberapi.IPremiumApi;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.R$layout;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004BS\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010!\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0002H\u0014¢\u0006\u0004\b!\u0010\"J\u001d\u0010$\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\r¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0016¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u0016¢\u0006\u0004\b(\u0010'JE\u00100\u001a\u00020\u001626\u0010/\u001a2\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\r¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00160)¢\u0006\u0004\b0\u00101R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00108R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00105R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010\u001bR\u001d\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00020F8\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JRH\u0010N\u001a4\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\r¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u0016\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010M¨\u0006O"}, d2 = {"Lcom/transsnet/downloader/adapter/g;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/baselib/db/download/DownloadBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lr6/i;", "", "season", "", "dataList", "", WebConstants.PAGE_FROM, "subjectId", "subjectType", "", "showPremiumIfNeed", "Lkotlin/Function0;", "hasMore", "<init>", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function0;)V", "Landroidx/appcompat/widget/AppCompatImageView;", "checkView", WebConstants.FIELD_ITEM, "", "M1", "(Landroidx/appcompat/widget/AppCompatImageView;Lcom/transsion/baselib/db/download/DownloadBean;)V", "O1", "I1", "(Lcom/transsion/baselib/db/download/DownloadBean;)V", "J1", "newSubjectId", "P1", "(Ljava/lang/String;)V", "holder", "D1", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/transsion/baselib/db/download/DownloadBean;)V", "add", "C1", "(Lcom/transsion/baselib/db/download/DownloadBean;Z)V", "K1", "()V", "H1", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "totalSize", "isSelectAll", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "N1", "(Lkotlin/jvm/functions/Function2;)V", "F", "I", "G", "Ljava/lang/String;", "H", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "J", "Lkotlin/jvm/functions/Function0;", "K", "pageFrom", "Lcom/transsnet/downloader/manager/g;", "L", "Lcom/transsnet/downloader/manager/g;", "downloadManager", "M", "Lcom/transsion/baselib/db/download/DownloadBean;", "G1", "()Lcom/transsion/baselib/db/download/DownloadBean;", "L1", "Ljava/util/concurrent/CopyOnWriteArrayList;", "N", "Ljava/util/concurrent/CopyOnWriteArrayList;", "F1", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "checkedList", "O", "Lkotlin/jvm/functions/Function2;", "itemSelectListener", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class g extends BaseQuickAdapter implements r6.i {

    /* renamed from: F, reason: from kotlin metadata */
    private final int season;

    /* renamed from: G, reason: from kotlin metadata */
    private String subjectId;

    /* renamed from: H, reason: from kotlin metadata */
    private Integer subjectType;

    /* renamed from: I, reason: from kotlin metadata */
    private Boolean showPremiumIfNeed;

    /* renamed from: J, reason: from kotlin metadata */
    private final Function0<Boolean> hasMore;

    /* renamed from: K, reason: from kotlin metadata */
    private String pageFrom;

    /* renamed from: L, reason: from kotlin metadata */
    private com.transsnet.downloader.manager.g downloadManager;

    /* renamed from: M, reason: from kotlin metadata */
    private DownloadBean item;

    /* renamed from: N, reason: from kotlin metadata */
    private final CopyOnWriteArrayList<DownloadBean> checkedList;

    /* renamed from: O, reason: from kotlin metadata */
    private Function2<? super Long, ? super Boolean, Unit> itemSelectListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(int i11, List<DownloadBean> dataList, String page_from, String str, Integer num, Boolean bool, Function0<Boolean> hasMore) {
        super(R$layout.item_bottom_dialog_download_ana_group, dataList);
        Intrinsics.h(dataList, "dataList");
        Intrinsics.h(page_from, "page_from");
        Intrinsics.h(hasMore, "hasMore");
        this.season = i11;
        this.subjectId = str;
        this.subjectType = num;
        this.showPremiumIfNeed = bool;
        this.hasMore = hasMore;
        this.pageFrom = "";
        this.checkedList = new CopyOnWriteArrayList<>();
        this.downloadManager = com.transsnet.downloader.manager.p.f59623a.a(Utils.a());
        this.pageFrom = page_from;
    }

    public /* synthetic */ g(int i11, List list, String str, String str2, Integer num, Boolean bool, Function0 function0, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, list, str, str2, num, (i12 & 32) != 0 ? Boolean.FALSE : bool, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E1(g gVar, AppCompatImageView appCompatImageView, DownloadBean downloadBean, View view) {
        Integer num;
        if (gVar.h0().r()) {
            return;
        }
        if (appCompatImageView.isSelected()) {
            gVar.M1(appCompatImageView, downloadBean);
            return;
        }
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        boolean c11 = iPremiumApi != null ? iPremiumApi.c() : false;
        Integer num2 = gVar.subjectType;
        if ((num2 != null && num2.intValue() == 5) || ((num = gVar.subjectType) != null && num.intValue() == 6)) {
            c11 = true;
        }
        IPremiumApi iPremiumApi2 = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        int i11 = iPremiumApi2 != null ? iPremiumApi2.i() : 3;
        Iterator<T> it = gVar.getData().iterator();
        int i12 = 0;
        while (it.hasNext()) {
            DownloadBean downloadBean2 = (DownloadBean) it.next();
            if (downloadBean2.getIsCheck() && !downloadBean2.isUnable()) {
                i12++;
            }
        }
        if (c11 || i12 < i11) {
            gVar.M1(appCompatImageView, downloadBean);
            return;
        }
        ToastUtils.s("Select up to " + i11 + " episodes at a time", new Object[0]);
    }

    private final void I1(DownloadBean item) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", item.getUrl());
        String postId = item.getPostId();
        if (postId == null) {
            postId = "";
        }
        hashMap.put("post_id", postId);
        hashMap.put(WebConstants.PAGE_FROM, this.pageFrom);
        hashMap.put("sequence", String.valueOf(g0(item)));
        hashMap.put("item_type", String.valueOf(item.getType()));
        String name = item.getName();
        if (name == null) {
            name = "";
        }
        hashMap.put("item_title", name);
        String str = this.subjectId;
        hashMap.put("subject_id", str != null ? str : "");
        hashMap.put("subject_type", String.valueOf(this.subjectType));
    }

    private final void J1(DownloadBean item) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", item.getUrl());
        String postId = item.getPostId();
        if (postId == null) {
            postId = "";
        }
        hashMap.put("post_id", postId);
        hashMap.put(WebConstants.PAGE_FROM, this.pageFrom);
        hashMap.put("sequence", String.valueOf(g0(item)));
        hashMap.put("item_type", String.valueOf(item.getType()));
        String name = item.getName();
        if (name == null) {
            name = "";
        }
        hashMap.put("item_title", name);
        String str = this.subjectId;
        hashMap.put("subject_id", str != null ? str : "");
        hashMap.put("subject_type", String.valueOf(this.subjectType));
    }

    private final void M1(AppCompatImageView checkView, DownloadBean item) {
        if (checkView.isSelected()) {
            C1(item, false);
            checkView.setSelected(false);
        } else {
            C1(item, true);
            checkView.setSelected(true);
        }
        item.setCheck(checkView.isSelected());
        O1(checkView, item);
        H1();
        J1(item);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
    
        if (((r1 == null || (r1 = r1.getFreeEpisodeCount()) == null) ? 0 : r1.intValue()) >= r7.getEp()) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void O1(androidx.appcompat.widget.AppCompatImageView r6, com.transsion.baselib.db.download.DownloadBean r7) {
        /*
            r5 = this;
            com.transsion.baselib.db.download.VipInfo r0 = r7.getVipInfo()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L17
            java.lang.Integer r0 = r0.getRequireMemberType()
            if (r0 != 0) goto Lf
            goto L17
        Lf:
            int r0 = r0.intValue()
            if (r0 != r1) goto L17
            r0 = r1
            goto L18
        L17:
            r0 = r2
        L18:
            int r3 = r7.getSubjectType()
            r4 = 5
            if (r3 == r4) goto L26
            int r3 = r7.getSubjectType()
            r4 = 6
            if (r3 != r4) goto L27
        L26:
            r0 = r2
        L27:
            if (r0 == 0) goto L4a
            int r1 = r7.getEp()
            if (r1 <= 0) goto L48
            com.transsion.baselib.db.download.VipInfo r1 = r7.getVipInfo()
            if (r1 == 0) goto L40
            java.lang.Integer r1 = r1.getFreeEpisodeCount()
            if (r1 == 0) goto L40
            int r1 = r1.intValue()
            goto L41
        L40:
            r1 = r2
        L41:
            int r3 = r7.getEp()
            if (r1 < r3) goto L48
            goto L70
        L48:
            r2 = r0
            goto L70
        L4a:
            java.lang.Class<com.transsion.memberapi.IPremiumApi> r0 = com.transsion.memberapi.IPremiumApi.class
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.Object r0 = com.therouter.TheRouter.d(r0, r3)
            com.transsion.memberapi.IPremiumApi r0 = (com.transsion.memberapi.IPremiumApi) r0
            if (r0 == 0) goto L5b
            int r0 = r0.t()
            goto L5d
        L5b:
            r0 = 720(0x2d0, float:1.009E-42)
        L5d:
            com.transsnet.downloader.util.b0 r3 = com.transsnet.downloader.util.b0.f60044a
            int r4 = r7.getResolution()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r3 = r3.a(r4)
            if (r3 < r0) goto L6e
            goto L6f
        L6e:
            r1 = r2
        L6f:
            r2 = r1
        L70:
            boolean r7 = r7.getIsCheck()
            if (r7 == 0) goto L7e
            if (r2 == 0) goto L7e
            int r7 = com.transsnet.downloader.R$mipmap.p_v2_ic_download_group_selected
            r6.setImageResource(r7)
            goto L83
        L7e:
            int r7 = com.transsnet.downloader.R$drawable.selector_download_group_check
            r6.setImageResource(r7)
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.adapter.g.O1(androidx.appcompat.widget.AppCompatImageView, com.transsion.baselib.db.download.DownloadBean):void");
    }

    public final void C1(DownloadBean item, boolean add) {
        Intrinsics.h(item, "item");
        if (!add) {
            a.C0856a.f(lg.a.f68962a, "DownloadReDete ", "==remove, epName:" + item.getEpName(), false, 4, null);
            this.checkedList.remove(item);
            return;
        }
        if (this.checkedList.contains(item)) {
            a.C0856a.f(lg.a.f68962a, "DownloadReDete ", "==add contains, epName:" + item.getEpName(), false, 4, null);
            return;
        }
        a.C0856a.f(lg.a.f68962a, "DownloadReDete ", "==add, epName:" + item.getEpName(), false, 4, null);
        this.checkedList.add(item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0070  */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void F(com.chad.library.adapter.base.viewholder.BaseViewHolder r7, final com.transsion.baselib.db.download.DownloadBean r8) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.adapter.g.F(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.transsion.baselib.db.download.DownloadBean):void");
    }

    public final CopyOnWriteArrayList<DownloadBean> F1() {
        return this.checkedList;
    }

    /* renamed from: G1, reason: from getter */
    public final DownloadBean getItem() {
        return this.item;
    }

    public final void H1() {
        long j11 = 0;
        for (DownloadBean downloadBean : this.checkedList) {
            if (!downloadBean.isUnable()) {
                Long size = downloadBean.getSize();
                j11 += size != null ? size.longValue() : 0L;
            }
        }
        Function2<? super Long, ? super Boolean, Unit> function2 = this.itemSelectListener;
        if (function2 != null) {
            function2.invoke(Long.valueOf(j11), Boolean.FALSE);
        }
        a.C0856a.f(lg.a.f68962a, "downloadAna", "onItemSelect, totalSize = " + j11 + ", checkList.size = " + this.checkedList.size() + ", itemCount = " + getData().size(), false, 4, null);
    }

    public final void K1() {
        this.checkedList.clear();
    }

    public final void L1(DownloadBean downloadBean) {
        this.item = downloadBean;
    }

    public final void N1(Function2<? super Long, ? super Boolean, Unit> listener) {
        Intrinsics.h(listener, "listener");
        this.itemSelectListener = listener;
    }

    public final void P1(String newSubjectId) {
        Intrinsics.h(newSubjectId, "newSubjectId");
        this.subjectId = newSubjectId;
    }

    @Override // r6.i
    public /* bridge */ /* synthetic */ r6.f b(BaseQuickAdapter baseQuickAdapter) {
        return r6.h.a(this, baseQuickAdapter);
    }
}
