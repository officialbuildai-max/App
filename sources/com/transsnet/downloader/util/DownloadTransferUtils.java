package com.transsnet.downloader.util;

import android.content.Context;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.transfer.impl.entity.FileData;
import com.transsnet.downloader.widget.TransferBottomToolsView;
import ej.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes7.dex */
public final class DownloadTransferUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final DownloadTransferUtils f60022a = new DownloadTransferUtils();

    private DownloadTransferUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d(Map map, int i11, DownloadBean downloadBean) {
        String cover;
        String cover2 = downloadBean.getCover();
        if (cover2 == null || !StringsKt.W(cover2, "http", false, 2, null)) {
            cover = downloadBean.getCover();
            if (cover == null) {
                return "";
            }
        } else {
            f.a aVar = ej.f.f62005a;
            String cover3 = downloadBean.getCover();
            Intrinsics.e(cover3);
            cover = (String) map.get(f.a.e(aVar, cover3, i11, false, true, 4, null));
            if (cover == null && (cover = downloadBean.getCover()) == null) {
                return "";
            }
        }
        return cover;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(List list, int i11, Function1 function1, Map pathMap) {
        Intrinsics.h(pathMap, "pathMap");
        a.C0856a.f(lg.a.f68962a, TransferBottomToolsView.TAG, "getTransferDataList-----2", false, 4, null);
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new DownloadTransferUtils$getTransferDataList$2$1(list, pathMap, i11, function1, null), 3, null);
        return Unit.f67184a;
    }

    private final void g(n0 n0Var, Context context, List list, Function1 function1) {
        kotlinx.coroutines.k.d(n0Var, y0.c(), null, new DownloadTransferUtils$loadPath$1(list, function1, context, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FileData h(String str, DownloadBean downloadBean) {
        String str2;
        if (!downloadBean.isInnerRes()) {
            str2 = downloadBean.getName();
            if (str2 == null) {
                str2 = "";
            }
        } else {
            String path = downloadBean.getPath();
            if (path == null || (str2 = new File(path).getName()) == null) {
                str2 = downloadBean.getFileName() + ".mp4";
            }
        }
        String cover = downloadBean.getCover();
        if (cover == null) {
            cover = "";
        }
        String path2 = downloadBean.getPath();
        if (str2.length() == 0 && path2 != null && path2.length() > 0) {
            str2 = new File(path2).getName();
            Intrinsics.g(str2, "getName(...)");
        }
        String str3 = str2;
        a.C0856a.f(lg.a.f68962a, TransferBottomToolsView.TAG, "transLocalData2FileData: coverImagePath:" + cover + ", coverPath:" + str, false, 4, null);
        String str4 = path2 == null ? "" : path2;
        Long size = downloadBean.getSize();
        FileData fileData = new FileData(str4, str3, size != null ? size.longValue() : 0L, str, null, null, 0, 0L, 240, null);
        fileData.setDownloadBean(downloadBean);
        return fileData;
    }

    public final void e(Context context, final List list, final Function1 callback) {
        Iterator it;
        String cover;
        Iterator it2;
        String str;
        String cover2;
        Intrinsics.h(context, "context");
        Intrinsics.h(callback, "callback");
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            callback.invoke(new ArrayList());
            return;
        }
        final int a11 = com.blankj.utilcode.util.a0.a(120.0f);
        ArrayList arrayList = new ArrayList();
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            DownloadBean downloadBean = (DownloadBean) it3.next();
            String str2 = "http";
            boolean z10 = true;
            if (downloadBean.isSeriesCollection()) {
                for (DownloadBean downloadBean2 : downloadBean.getSeriesList()) {
                    String cover3 = downloadBean2.getCover();
                    if (cover3 == null || StringsKt.W(cover3, str2, false, 2, null) != z10 || (cover2 = downloadBean2.getCover()) == null) {
                        it2 = it3;
                        str = str2;
                    } else {
                        it2 = it3;
                        str = str2;
                        arrayList.add(f.a.e(ej.f.f62005a, cover2, a11, false, true, 4, null));
                    }
                    str2 = str;
                    it3 = it2;
                    z10 = true;
                }
                it = it3;
            } else {
                it = it3;
                String cover4 = downloadBean.getCover();
                if (cover4 != null && StringsKt.W(cover4, "http", false, 2, null) && (cover = downloadBean.getCover()) != null) {
                    arrayList.add(f.a.e(ej.f.f62005a, cover, a11, false, true, 4, null));
                }
            }
            it3 = it;
        }
        a.C0856a.f(lg.a.f68962a, TransferBottomToolsView.TAG, "getTransferDataList-----1", false, 4, null);
        g(o0.a(y0.c()), context, arrayList, new Function1() { // from class: com.transsnet.downloader.util.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit f11;
                f11 = DownloadTransferUtils.f(list, a11, callback, (Map) obj);
                return f11;
            }
        });
    }
}
