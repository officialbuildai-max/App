package ts;

import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private SubtitleDownloadTable f76482a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f76483b;

    /* renamed from: c, reason: collision with root package name */
    private String f76484c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f76485d;

    public b(SubtitleDownloadTable bean) {
        Intrinsics.h(bean, "bean");
        this.f76482a = bean;
        this.f76484c = "";
    }

    public final SubtitleDownloadTable a() {
        return this.f76482a;
    }

    public final boolean b() {
        return this.f76482a.getStatus() == 5;
    }

    public final boolean c() {
        return this.f76485d;
    }

    public final boolean d() {
        return this.f76483b;
    }

    public final void e(SubtitleDownloadTable subtitleDownloadTable) {
        Intrinsics.h(subtitleDownloadTable, "<set-?>");
        this.f76482a = subtitleDownloadTable;
    }

    public final void f(boolean z10) {
        this.f76483b = z10;
    }
}
