package com.transsion.subtitle_download.task;

import android.text.TextUtils;
import com.transsion.subtitle_download.bean.SubtitleItem;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class GetInStationSubtitleListTask {

    /* renamed from: a, reason: collision with root package name */
    public static final GetInStationSubtitleListTask f55136a = new GetInStationSubtitleListTask();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f55137b = LazyKt.b(new Function0() { // from class: com.transsion.subtitle_download.task.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ku.a f11;
            f11 = GetInStationSubtitleListTask.f();
            return f11;
        }
    });

    private GetInStationSubtitleListTask() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ku.a f() {
        return (ku.a) zg.c.f79537e.a().h(ku.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x002e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0214 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x047c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00f6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0471 -> B:16:0x0474). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x030c -> B:43:0x0312). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(com.tn.lib.net.bean.BaseDto r34, kotlin.jvm.functions.Function1 r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, int r39, int r40, int r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, kotlin.coroutines.Continuation r45) {
        /*
            Method dump skipped, instructions count: 1316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subtitle_download.task.GetInStationSubtitleListTask.g(com.tn.lib.net.bean.BaseDto, kotlin.jvm.functions.Function1, java.lang.String, java.lang.String, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ku.a k() {
        return (ku.a) f55137b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String l() {
        String simpleName = GetInStationSubtitleListTask.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final boolean m(String str, int i11, List list) {
        boolean z10 = false;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                SubtitleDownloadTable subtitleDownloadTable = (SubtitleDownloadTable) it.next();
                if (TextUtils.equals(str, subtitleDownloadTable.getId()) && i11 == subtitleDownloadTable.getResourceStreamType()) {
                    z10 = true;
                }
            }
        }
        return z10;
    }

    private final boolean n(String str, List list) {
        Iterator it = list.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            if (TextUtils.equals(str, ((SubtitleItem) it.next()).getId())) {
                z10 = true;
            }
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.String r20, java.lang.String r21, java.lang.String r22, int r23, int r24, int r25, com.transsion.subtitle_download.bean.SubtitleItem r26, boolean r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, kotlin.coroutines.Continuation r31) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subtitle_download.task.GetInStationSubtitleListTask.o(java.lang.String, java.lang.String, java.lang.String, int, int, int, com.transsion.subtitle_download.bean.SubtitleItem, boolean, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object p(GetInStationSubtitleListTask getInStationSubtitleListTask, String str, String str2, String str3, int i11, int i12, int i13, SubtitleItem subtitleItem, boolean z10, String str4, String str5, String str6, Continuation continuation, int i14, Object obj) {
        return getInStationSubtitleListTask.o(str, str2, str3, i11, (i14 & 16) != 0 ? 0 : i12, (i14 & 32) != 0 ? 0 : i13, subtitleItem, (i14 & 128) != 0 ? true : z10, (i14 & 256) != 0 ? null : str4, (i14 & 512) != 0 ? null : str5, (i14 & 1024) != 0 ? null : str6, continuation);
    }

    private final void q(List list) {
        SubtitleItem subtitleItem;
        String str;
        try {
            Result.Companion companion = Result.INSTANCE;
            int i11 = -1;
            if (list != null) {
                int i12 = 0;
                for (Object obj : list) {
                    int i13 = i12 + 1;
                    if (i12 < 0) {
                        CollectionsKt.u();
                    }
                    String lanAbbr = ((SubtitleItem) obj).getLanAbbr();
                    if (lanAbbr != null) {
                        str = lanAbbr.toUpperCase(Locale.ROOT);
                        Intrinsics.g(str, "toUpperCase(...)");
                    } else {
                        str = null;
                    }
                    String upperCase = com.transsion.subtitle_download.utils.e.f55170a.f().toUpperCase(Locale.ROOT);
                    Intrinsics.g(upperCase, "toUpperCase(...)");
                    if (TextUtils.equals(str, upperCase)) {
                        i11 = i12;
                    }
                    i12 = i13;
                }
            }
            if (i11 > 0 && list != null && (subtitleItem = (SubtitleItem) list.remove(i11)) != null) {
                list.add(0, subtitleItem);
            }
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public final void h(SubtitleDownloadTable dbBean) {
        Intrinsics.h(dbBean, "dbBean");
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new GetInStationSubtitleListTask$download$2(dbBean, null), 3, null);
    }

    public final void i(String str, String str2, String str3, int i11, int i12, int i13, String str4, String str5, String str6, int i14, Function1 function1) {
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new GetInStationSubtitleListTask$download$1(i14, str, str4, str3, i11, str2, i12, function1, str5, i13, str6, null), 3, null);
    }

    public final void j(String str, String str2, String videoResourceId, String str3, String str4, String str5, String idType, Function1 function1) {
        Intrinsics.h(videoResourceId, "videoResourceId");
        Intrinsics.h(idType, "idType");
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new GetInStationSubtitleListTask$downloadUGCVideo$1(str3, videoResourceId, idType, str, str2, str4, function1, str5, null), 3, null);
    }
}
