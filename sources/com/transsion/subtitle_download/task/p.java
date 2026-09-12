package com.transsion.subtitle_download.task;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import com.transsion.subtitle_download.SubtitleDownloadManager;
import com.transsion.subtitle_download.db.SubtitleDownloadDatabase;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class p {

    /* renamed from: a */
    public static final p f55161a = new p();

    /* renamed from: b */
    private static final LinkedBlockingDeque f55162b = new LinkedBlockingDeque();

    /* renamed from: c */
    private static volatile boolean f55163c;

    private p() {
    }

    public static /* synthetic */ void e(p pVar, SubtitleDownloadTable subtitleDownloadTable, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        pVar.d(subtitleDownloadTable, z10);
    }

    private final void f() {
        f55163c = false;
        g();
    }

    private final void g() {
        Object m1185constructorimpl;
        Unit unit;
        if (!f55163c) {
            LinkedBlockingDeque linkedBlockingDeque = f55162b;
            if (!linkedBlockingDeque.isEmpty()) {
                f55163c = true;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    SubtitleDownloadTable subtitleDownloadTable = (SubtitleDownloadTable) linkedBlockingDeque.removeFirst();
                    if (subtitleDownloadTable != null) {
                        int type = subtitleDownloadTable.getType();
                        if (type == 4) {
                            new l().k(subtitleDownloadTable, new Function0() { // from class: com.transsion.subtitle_download.task.m
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit h11;
                                    h11 = p.h(p.this);
                                    return h11;
                                }
                            });
                        } else if (type != 5) {
                            new f().k(subtitleDownloadTable, new Function0() { // from class: com.transsion.subtitle_download.task.o
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit j11;
                                    j11 = p.j(p.this);
                                    return j11;
                                }
                            });
                        } else {
                            new i().k(subtitleDownloadTable, new Function0() { // from class: com.transsion.subtitle_download.task.n
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit i11;
                                    i11 = p.i(p.this);
                                    return i11;
                                }
                            });
                        }
                        unit = Unit.f67184a;
                    } else {
                        unit = null;
                    }
                    m1185constructorimpl = Result.m1185constructorimpl(unit);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
                }
                Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
                if (m1188exceptionOrNullimpl == null) {
                    return;
                }
                com.transsion.subtitle_download.utils.b bVar = com.transsion.subtitle_download.utils.b.f55167a;
                p pVar = f55161a;
                bVar.b(pVar.k() + " --> downloadNext() --> 执行下载任务发生异常 -- it = " + Log.getStackTraceString(m1188exceptionOrNullimpl));
                pVar.f();
                return;
            }
        }
        LinkedBlockingDeque linkedBlockingDeque2 = f55162b;
        if (linkedBlockingDeque2.isEmpty()) {
            com.transsion.subtitle_download.utils.b.f55167a.c(k() + " --> downloadNext() --> taskList = " + linkedBlockingDeque2.size() + " -- 当前没有可执行任务了");
        }
    }

    public static final Unit h(p pVar) {
        pVar.f();
        return Unit.f67184a;
    }

    public static final Unit i(p pVar) {
        pVar.f();
        return Unit.f67184a;
    }

    public static final Unit j(p pVar) {
        pVar.f();
        return Unit.f67184a;
    }

    private final String k() {
        String simpleName = p.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final void d(SubtitleDownloadTable dbBean, boolean z10) {
        Intrinsics.h(dbBean, "dbBean");
        if (com.transsion.subtitle_download.utils.e.f55170a.i(dbBean.getPath())) {
            com.transsion.subtitle_download.utils.b.f55167a.c(k() + " --> addTaskAndExecute() --> 开始下载字幕 --> 如果字幕资源已经下载完成了，那就直接跳过 --> next() -- getSubtitleInfo = " + dbBean.getSubtitleInfo());
            dbBean.setStatus(5);
            SubtitleDownloadDatabase.Companion companion = SubtitleDownloadDatabase.INSTANCE;
            Application a11 = Utils.a();
            Intrinsics.g(a11, "getApp(...)");
            companion.b(a11).l0().f(dbBean);
            SubtitleDownloadManager.f55121a.n(dbBean);
            return;
        }
        Iterator it = f55162b.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            if (TextUtils.equals(((SubtitleDownloadTable) it.next()).getId(), dbBean.getId())) {
                z11 = true;
            }
        }
        if (z11) {
            return;
        }
        q.f55164a.d(dbBean);
        if (z10) {
            f55162b.addFirst(dbBean);
        } else {
            f55162b.add(dbBean);
        }
        com.transsion.subtitle_download.utils.b.f55167a.a(k() + " --> addTaskAndExecute() --> 剩余任务数量 -- taskList.size = " + f55162b.size() + " --> isDownloading = " + f55163c + " --> dbBean.failCount = " + dbBean.getFailCount());
        g();
    }
}
